package reger.Media;

import reger.core.db.Db;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class processes PolarHRM data files, stores them into the database.
 */
public class PolarHRM implements MediaType{

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "application/x-download";
    }

    public void saveToDatabase(String pathToSourceFile, int imageid){
        try{
            //Create an entry in polarhrm
            int polarhrmid = newPolarhrmEntry(imageid);
            //Data reading buffer
            BufferedReader br = new BufferedReader(new FileReader(pathToSourceFile));
            //Line variable
            String line = "";
            //Interval in seconds
            int intervalinseconds = 5;
            //Whether or not we've found the interval yet.
            boolean haveFoundInterval = false;
            //The current time in seconds
            int timeinseconds = 0;
            //Whether or not we've found the SMode yet
            boolean haveFoundSMode = false;
            //The SMode
            String smode = "";
            //Whether or not we've found the Version yet
            boolean haveFoundVersion = false;
            //The SMode
            int version = 0;

            //Whether or not we've found the main HRData line. This is the main trigger for saving to the database.
            boolean inHrDataLines = false;
            while ((line = br.readLine()) != null) {
                //If we haven't found the interval yet.
                if (!haveFoundInterval){
                    if (findIntervalInSeconds(line)>0){
                        haveFoundInterval = true;
                        intervalinseconds = findIntervalInSeconds(line);
                    }
                }

                //If we haven't found the version yet.
                if (!haveFoundVersion){
                    if (findVersion(line)>0){
                        haveFoundVersion = true;
                        version = findVersion(line);
                    }
                }

                //If we haven't found the SMode yet.
                if (!haveFoundSMode){
                    if (findSMode(line).length()>0){
                        haveFoundSMode = true;
                        smode = findSMode(line);
                    }
                }

                //If we haven't yet found the start of the HRData line
                if (!inHrDataLines){
                    //Look for it.  If it's there, we'll start processing on the next line when the loop returns.
                    inHrDataLines=isHrdataStartLine(line);
                } else {
                    //Now we need to make sure we're not at the end of the HRData
                    if (isBlankLine(line)){
                        //It is a blank line so we need to turn off the main trigger.
                        inHrDataLines = false;
                    } else {
                        //Increment the timeinseconds by the correct interval
                        timeinseconds = timeinseconds + intervalinseconds;
                        //Go ahead and process a single HRData line.
                        processSingleHrDataLine(line, polarhrmid, timeinseconds, version, smode);
                    }
                }

            }
        } catch (Throwable e){
            Debug.errorsave(e, "");
        }

    }

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail, int imageid) {

        try{
            //reger.core.Util.logtodb("Copying file in polarhrm.");
            reger.core.Util.copyFile(reger.core.WebAppRootDir.getWebAppRootPath() + "images\\mediatypeicons\\icon-polarhrm.gif", pathToThumbnail);
        } catch (Throwable e) {
            Debug.errorsave(e, "");
        }

    }



    /**
     * Returns a string array of file extensions that this media type will accept.
     */
    public String[] getAcceptableFileExtensions() {
        String[] extensions = new String[1];
        extensions[0]="hrm";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        StringBuffer mb = new StringBuffer();

        String xaxis="0";
        if (request.getParameter("xaxis")!=null && !request.getParameter("xaxis").equals("")){
            xaxis = request.getParameter("xaxis");
        }

        int imageidcompare=-1;
        if (request.getParameter("imageidcompare")!=null && reger.core.Util.isinteger(request.getParameter("imageidcompare"))){
            imageidcompare = Integer.parseInt(request.getParameter("imageidcompare"));
        }

        //Build the yaxis querystring and populate the vars
        int[] yaxis = new int[7];
        //Defaults
        yaxis[0]=0; //Time (not on y)
        yaxis[1]=1; //Heart
        yaxis[2]=1; //Speed
        yaxis[3]=1; //Cadence
        yaxis[4]=1; //Altitude
        yaxis[5]=1; //Power
        yaxis[6]=1; //LR Balance
        //Load from request
        String qs = "";
        for(int i=0; i<=6; i++){
            //If it's an integer
            if (request.getParameter("yaxis-"+i)!=null && reger.core.Util.isinteger(request.getParameter("yaxis-"+i))){
                //Override default
                yaxis[i]=Integer.parseInt(request.getParameter("yaxis-"+i));
            } else {
                if (request.getParameter("formclicked")!=null && request.getParameter("formclicked").equals("1")){
                    yaxis[i]=0;
                }
            }

            //Querystring
            qs = qs + "&yaxis-" + i + "=" + yaxis[i];
        }

        mb.append("<table cellpadding=10 cellspacing=2 width=100% border=0 bgcolor=#ffffff>");


        mb.append("<tr>");
        mb.append("<td colspan=3>");
        //-----------------------------------
        //-----------------------------------
        String[][] rstEv= Db.RunSQL("SELECT image.imageid, description, title, event.date, event.eventid FROM image, megalog, event, polarhrm WHERE event.eventid=image.eventid AND event.logid=megalog.logid AND polarhrm.imageid=image.imageid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" AND image.imageid='"+request.getParameter("imageid")+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEv!=null && rstEv.length>0){
            for(int i=0; i<rstEv.length; i++){
                mb.append("<table cellpadding=10 cellspacing=2 width=100% border=0 bgcolor=#ffffff>");
                mb.append("<tr>");
                //Date
                mb.append("<td valign=top bgcolor=#cccccc>");
                mb.append("<font face=arial size=-2>");
                java.util.Calendar calFromDB = reger.core.TimeUtils.dbstringtocalendar(rstEv[i][3]);
                java.util.Calendar cal = reger.core.TimeUtils.gmttousertime(calFromDB, userSession.getAccount().getTimezoneid());
                mb.append(reger.core.TimeUtils.dateformatcompactwithtime(cal));
                mb.append("</font>");
                mb.append("</td>");
                //Event Title
                mb.append("<td valign=top bgcolor=#cccccc>");
                mb.append("<font face=arial size=-1>");
                mb.append(rstEv[i][2]);
                mb.append("</font>");
                mb.append("</td>");
                //Image Description
                mb.append("<td valign=top bgcolor=#cccccc>");
                mb.append("<font face=arial size=-2>");
                mb.append(reger.core.Util.truncateString(rstEv[i][1], 200));
                mb.append("</font>");
                mb.append("</td>");

                mb.append("</tr>");
                mb.append("</table>");
            }
        }
        mb.append("</td>");
        mb.append("</tr>");


        //Comparison
        if (imageidcompare>0){

            mb.append("<tr>");
            mb.append("<td valign=top align=center colspan=3>");
            mb.append("<font face=arial size=-1>");
            mb.append("The Above File Compared To:");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Data for the file below appears on the chart in gray.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("<tr>");
            mb.append("<td colspan=3>");
            //-----------------------------------
            //-----------------------------------
            String[][] rstEv2= Db.RunSQL("SELECT image.imageid, description, title, event.date, event.eventid FROM image, megalog, event, polarhrm WHERE event.eventid=image.eventid AND event.logid=megalog.logid AND polarhrm.imageid=image.imageid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" AND image.imageid='"+imageidcompare+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstEv2!=null && rstEv2.length>0){
                for(int i=0; i<rstEv2.length; i++){
                    mb.append("<table cellpadding=10 cellspacing=2 width=100% border=0 bgcolor=#ffffff>");
                    mb.append("<tr>");
                    //Date
                    mb.append("<td valign=top bgcolor=#cccccc>");
                    mb.append("<font face=arial size=-2>");
                    java.util.Calendar calFromDB = reger.core.TimeUtils.dbstringtocalendar(rstEv2[i][3]);
                    java.util.Calendar cal = reger.core.TimeUtils.gmttousertime(calFromDB, userSession.getAccount().getTimezoneid());
                    mb.append(reger.core.TimeUtils.dateformatcompactwithtime(cal));
                    mb.append("</font>");
                    mb.append("</td>");
                    //Event Title
                    mb.append("<td valign=top bgcolor=#cccccc>");
                    mb.append("<font face=arial size=-1>");
                    mb.append(rstEv2[i][2]);
                    mb.append("</font>");
                    mb.append("</td>");
                    //Image Description
                    mb.append("<td valign=top bgcolor=#cccccc>");
                    mb.append("<font face=arial size=-2>");
                    mb.append(reger.core.Util.truncateString(rstEv2[i][1], 200));
                    mb.append("</font>");
                    mb.append("</td>");

                    mb.append("</tr>");
                    mb.append("</table>");
                }
            }
            mb.append("</td>");
            mb.append("</tr>");
        }




        mb.append("<tr>");
        mb.append("<td valign=top align=center colspan=3>");
        //Final call to chart
        mb.append("<img src=\"graphpolarhrm.log?imageid="+request.getParameter("imageid")+ "&imageidcompare=" + imageidcompare +"&xaxis="+xaxis+ qs + "\" border=0>");
        mb.append("</td>");
        mb.append("</tr>");



        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("X-Axis");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("Y-Axis");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("Action");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");



        mb.append("<form action=mediaouthtml.log method=get>");
        mb.append("<input type=hidden name=imageid value="+request.getParameter("imageid")+">");
        mb.append("<input type=hidden name=formclicked value=1>");

        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        //Time
        mb.append("<input type=radio name=xaxis value='0'");
        if (xaxis.equals("0")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Time");
        mb.append("<br>");
        //Heartrate
        mb.append("<input type=radio name=xaxis value='1'");
        if (xaxis.equals("1")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Heart Rate");
        mb.append("<br>");
        //Speed
        mb.append("<input type=radio name=xaxis value='2'");
        if (xaxis.equals("2")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Speed");
        mb.append("<br>");
        //Cadence
        mb.append("<input type=radio name=xaxis value='3'");
        if (xaxis.equals("3")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Cadence");
        mb.append("<br>");
        //Altitude
        mb.append("<input type=radio name=xaxis value='4'");
        if (xaxis.equals("4")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Altitude");
        mb.append("<br>");
        //Power
        mb.append("<input type=radio name=xaxis value='5'");
        if (xaxis.equals("5")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Power");
        mb.append("<br>");
        //Heartrate
        mb.append("<input type=radio name=xaxis value='6'");
        if (xaxis.equals("6")){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Left/Right Balance");
        mb.append("<br>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        //Heartrate
        mb.append("<input type=checkbox name=yaxis-1 value='1'");
        if (yaxis[1]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Heart Rate");
        mb.append("<br>");
        //Speed
        mb.append("<input type=checkbox name=yaxis-2 value='1'");
        if (yaxis[2]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Speed");
        mb.append("<br>");
        //Cadence
        mb.append("<input type=checkbox name=yaxis-3 value='1'");
        if (yaxis[3]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Cadence");
        mb.append("<br>");
        //Altitude
        mb.append("<input type=checkbox name=yaxis-4 value='1'");
        if (yaxis[4]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Altitude");
        mb.append("<br>");
        //Power
        mb.append("<input type=checkbox name=yaxis-5 value='1'");
        if (yaxis[5]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Power");
        mb.append("<br>");
        //LRB
        mb.append("<input type=checkbox name=yaxis-6 value='1'");
        if (yaxis[6]==1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("Left/Right Balance");
        mb.append("<br>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("<input type=submit value='Update Chart'>");
        mb.append("</font>");
        mb.append("<br><br>");
        mb.append("<font face=arial size=-2>");
        mb.append("<a href=\"mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"\">Download original file.</a>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");



        //Comparison to another workout
        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#cccccc colspan=3>");
        mb.append("<font face=arial size=-1>");
        mb.append("Compare this workout to another workout:");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //Start list
        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6 colspan=3>");
        //Nested table start
        mb.append("<table width=100% bgcolor=#cccccc cellpadding=5 cellspacing=2 border=0>");


        mb.append("<tr>");
        //Radio Button
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append(" ");
        mb.append("</font>");
        mb.append("</td>");
        //Date
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("Date");
        mb.append("</font>");
        mb.append("</td>");
        //Event Title
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("Entry Title");
        mb.append("</font>");
        mb.append("</td>");
        //Image Description
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("File Description");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        //None choice
        mb.append("<td valign=top bgcolor=#ffffff align=center>");
        mb.append("<input type=radio name=imageidcompare value='-1'");
        if (imageidcompare==-1){
            mb.append(" checked");
        }
        mb.append(">");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#ffffff colspan=3>");
        mb.append("<font face=arial size=-1>");
        mb.append("None");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //-----------------------------------
        //-----------------------------------
        String[][] rstImg= Db.RunSQL("SELECT image.imageid, description, title, event.date, event.eventid FROM image, megalog, event, polarhrm WHERE event.eventid=image.eventid AND event.logid=megalog.logid AND polarhrm.imageid=image.imageid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" AND image.imageid<>'"+request.getParameter("imageid")+"' ORDER BY event.date DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstImg!=null && rstImg.length>0){
            for(int i=0; i<rstImg.length; i++){
                mb.append("<tr>");
                //Radio Button
                mb.append("<td valign=top bgcolor=#ffffff align=center>");
                mb.append("<input type=radio name=imageidcompare value='"+rstImg[i][0]+"'");
                if (imageidcompare==Integer.parseInt(rstImg[i][0])){
                    mb.append(" checked");
                }
                mb.append(">");
                mb.append("</td>");
                //Date
                mb.append("<td valign=top bgcolor=#ffffff>");
                mb.append("<font face=arial size=-2>");
                java.util.Calendar calFromDB = reger.core.TimeUtils.dbstringtocalendar(rstImg[i][3]);
                java.util.Calendar cal = reger.core.TimeUtils.gmttousertime(calFromDB, userSession.getAccount().getTimezoneid());
                mb.append(reger.core.TimeUtils.dateformatcompactwithtime(cal));
                mb.append("</font>");
                mb.append("</td>");
                //Event Title
                mb.append("<td valign=top bgcolor=#ffffff>");
                mb.append("<font face=arial size=-1>");
                mb.append(rstImg[i][2]);
                mb.append("</font>");
                mb.append("</td>");
                //Image Description
                mb.append("<td valign=top bgcolor=#ffffff>");
                mb.append("<font face=arial size=-2>");
                mb.append(reger.core.Util.truncateString(rstImg[i][1], 200));
                mb.append("</font>");
                mb.append("</td>");


                mb.append("</tr>");
            }
        }




        mb.append("</table>");
        //Nested table end

        mb.append("</td>");
        mb.append("</tr>");




        mb.append("</form>");

        mb.append("</table>");

        return mb.toString();
    }

    /**
     * Looks for Interval in seconds
     */
    private int findIntervalInSeconds(String line){
        if (line.length()>9){
            if (line.substring(0,9).equals("Interval=")){
                String[] col = line.split("=");
                String interval = col[1];
                if (reger.core.Util.isinteger(interval)){
                    return Integer.parseInt(interval);
                }
            }
        }
        //Not found
        return 0;
    }

    /**
     * Looks for the SMode variable
     */
    private String findSMode(String line){
        if (line.length()>6){
            if (line.substring(0,6).equals("SMode=")){
                String[] col = line.split("=");
                String smode = col[1];
                return smode;
            }
        }
        //Not found
        return "";
    }

    /**
     * Looks for the Version variable
     */
    private int findVersion(String line){
        if (line.length()>8){
            if (line.substring(0,8).equals("Version=")){
                String[] col = line.split("=");
                String ver = col[1];
                if (reger.core.Util.isinteger(ver)){
                    return Integer.parseInt(ver);
                }
            }
        }
        //Not found
        return 0;
    }

    /**
     * Looks for trigger line of [HRDATA]
     */
    private boolean isHrdataStartLine(String line){
        if (line.length()==8){
            if (line.substring(0,8).equals("[HRData]")){
                return true;
            }
        }
        //Not found
        return false;
    }

    /**
     * Looks for blank line.
     */
    private boolean isBlankLine(String line){
        if (line.length()<1){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Breaks up the tab-delimited
     */
    private void processSingleHrDataLine(String line, int polarhrmid, int timeinseconds, int version, String smode){

        //Vars to hold the columns to use for each type of data
        int speedCol = 0;
        int cadenceCol = 0;
        int altitudeCol = 0;
        int powerCol = 0;
        int powerbalCol = 0;

        //Need to work with individual versioninfo
        if (version<=105){
            //Working with version 1.05 or before
            //See if speed is on
            if (smode.substring(1, 2).equals("1")){
                speedCol = 1;
            }
            //See if cadence is on
            if (smode.substring(0, 1).equals("0")){
                cadenceCol = 2;
            }
            //See if altitude is on
            if (smode.substring(0, 1).equals("1")){
                altitudeCol = 2;
            }
        } else {
            //Working with version 1.06 or later
            //CurrentCol holds the current column in the data that's filled.
            //smode is in the form 11010111 with each number telling us whether a feature is on/off
            int currentCol = 1;
            for (int i = 1; i <= smode.length(); i++) {
                //Get the on/off number from smode
                String onoff = smode.substring(i-1, i);
                //See if speed is on
                if (i==1 && onoff.equals("1")){
                    speedCol = currentCol;
                    currentCol = currentCol + 1;
                }
                //See if cadence is on
                if (i==2 && onoff.equals("1")){
                    cadenceCol = currentCol;
                    currentCol = currentCol + 1;
                }
                //See if altitude is on
                if (i==3 && onoff.equals("1")){
                    altitudeCol = currentCol;
                    currentCol = currentCol + 1;
                }
                //See if power is on
                if (i==4 && onoff.equals("1")){
                    powerCol = currentCol;
                    currentCol = currentCol + 1;
                }
                //See if lrb is on
                if (i==5 && onoff.equals("1")){
                    powerbalCol = currentCol;
                    currentCol = currentCol + 1;
                }
            }
        }

        //Split line on tab character
        String[] columns = line.split("\t");

        //Heart rate
        String heartrate = "";
        if (columns.length>=1 && columns[0].length()>0){
            heartrate = columns[0];
        }

        //Speed
        String speed = "";
        if (speedCol>0 && columns.length>=(speedCol+1) && columns[speedCol].length()>0){
            speed = columns[speedCol];
            speed = String.valueOf(Double.parseDouble(speed)/10);
        }

        //Cadence
        String cadence = "";
        if (cadenceCol>0 && columns.length>=(cadenceCol+1) && columns[cadenceCol].length()>0){
            cadence = columns[cadenceCol];
        }

        //Altitude
        String altitude = "";
        if (altitudeCol>0 && columns.length>=(altitudeCol+1) && columns[altitudeCol].length()>0){
            altitude = columns[altitudeCol];
        }

        //Power
        String power = "0";
        if (powerCol>0 && columns.length>=(powerCol+1) && columns[powerCol].length()>0){
            power = columns[powerCol];
        }

        //Powerbalance
        String powerbalance = "";
        int leftpowerbalance = 0;
        int pedalingindex = 0;
        if (powerbalCol>0 && columns.length>=(powerbalCol+1) && columns[powerbalCol].length()>0){
            powerbalance = columns[powerbalCol];
            //Calculate left power balance
            leftpowerbalance = (Integer.parseInt(powerbalance) % 256);
            //Calculate pedaling index
            pedalingindex = (Integer.parseInt(powerbalance))/(leftpowerbalance + 256);
        }



        //Save to DB
        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO polarhrmdata(polarhrmid, timeinseconds, heartrate, speed, cadence, altitude, power, leftpowerbalance, pedalingindex) VALUES('"+polarhrmid+"', '"+timeinseconds+"', '"+heartrate+"', '"+speed+"', '"+cadence+"', '"+altitude+"', '"+power+"', '"+leftpowerbalance+"', '"+pedalingindex+"')");
        //-----------------------------------
        //-----------------------------------


    }

    /**
     * Creates a new polarhrm umbrella row.  The id from this row is tied to every row of data in polarhrmdata.
     */
    private int newPolarhrmEntry(int imageid){
        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO polarhrm(imageid) VALUES('"+imageid+"')");
        //-----------------------------------
        //-----------------------------------
        //Return the polarhrmid
        return identity;
    }

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {
        //-----------------------------------
        //-----------------------------------
        String[][] rstImg= Db.RunSQL("SELECT polarhrmid FROM polarhrm WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstImg!=null && rstImg.length>0){
            for(int i=0; i<rstImg.length; i++){
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("DELETE FROM polarhrmdata WHERE polarhrmid='"+rstImg[i][0]+"'");
                //-----------------------------------
                //-----------------------------------

                //-----------------------------------
                //-----------------------------------
                int count2 = Db.RunSQLUpdate("DELETE FROM polarhrm WHERE polarhrmid='"+rstImg[i][0]+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }


    }


}
