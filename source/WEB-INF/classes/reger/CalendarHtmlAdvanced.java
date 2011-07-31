package reger;

import reger.core.Util;
import reger.core.db.Db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Displays calendars as html
 */
public class CalendarHtmlAdvanced {



    public static StringBuffer smallcalendar(int calendartype, String viewmonth, int logid, String thispagename, UserSession userSession) {

        StringBuffer sc = new StringBuffer();

        //Currently this is a hack for Joe Reger's training log
        ArrayList<Integer> megafieldids = getJoeWorkoutMegafieldids();

        //These store temporary weekly and monthly totals
        HashMap<Integer, Integer> megavalueWeekSum = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> megavalueMonthSum = new HashMap<Integer, Integer>();

        //Get default date in case no viewmonth was provided
        Calendar nowTmp = Calendar.getInstance();
        nowTmp=reger.core.TimeUtils.convertFromOneTimeZoneToAnother(nowTmp, nowTmp.getTimeZone().getID(), userSession.getAccount().getTimezoneid());
        int year=nowTmp.get(Calendar.YEAR);
        int month=nowTmp.get(Calendar.MONTH);

        //Override if we have a nice viewmonth. Convert "2003-12-23" to ints.
        if (viewmonth!=null && !viewmonth.equals("") && reger.core.Util.isinteger(viewmonth.substring(0,4))){
            year=Integer.parseInt(viewmonth.substring(0,4));
        }
        if (viewmonth!=null && !viewmonth.equals("") && reger.core.Util.isinteger(viewmonth.substring(5,7))){
            month=Integer.parseInt(viewmonth.substring(5,7))-1;
        }

        //Convert incoming date into a calendar
        Calendar startdate = Calendar.getInstance();
        startdate.set(year, month, 15, 0, 0, 0);

        //Find the start of the month
        startdate=reger.core.TimeUtils.xMonthsAgoStart(startdate, 0);


        //Convert incoming date into a calendar
        Calendar enddate = Calendar.getInstance();
        enddate.set(year, month, 15, 0, 0, 0);

        //Find the start of the month
        enddate=reger.core.TimeUtils.xMonthsAgoEnd(enddate, 0);


        //Call the plugin
        CalendarHtmlPluginAdvanced plugin = new CalendarHtmlPluginAdvanced(calendartype, startdate, enddate, logid, userSession, thispagename);
        if (calendartype== Vars.CALENDARTYPEEMPTYEVENTFINDER){
            plugin = new CalendarHtmlPluginAdvanced(calendartype, startdate, enddate, logid, userSession, thispagename);
        } else if (calendartype== Vars.CALENDARTYPEEMPTYEVENTLINKS){
            plugin = new CalendarHtmlPluginAdvanced(calendartype, startdate, enddate, logid, userSession, thispagename);
        }


        //Setup some vars
        Calendar dDate;
        int iDOW;
        int iCurrent;
        int iDIM;
        int iPosition;
        String thisdate="";
        int cellOnFlag=0;
        String inCell="";

        //The main date variable that is iterated to create the calendar
        dDate = (Calendar)startdate.clone();

        //Now we've got the date.  Now get Days in the choosen month and the day of the week it starts on.
        iDIM = reger.core.TimeUtils.GetDaysInMonth(dDate.get(Calendar.MONTH), dDate.get(Calendar.YEAR));
        iDOW = reger.core.TimeUtils.GetWeekdayMonthStartsOn(dDate.get(Calendar.MONTH), dDate.get(Calendar.YEAR));

        //Start the html
        sc.append("<TABLE BORDER=0 CELLSPACING=1 CELLPADDING=1 class=sidecolunit>");
        sc.append("<TR>");
        sc.append("<td class=sidecolheader  ALIGN='center' COLSPAN=8>");

        //Need to calculate the month/year integers for last month and next month
        String thismonthname = reger.core.TimeUtils.monthname(dDate);

        int thisyear = dDate.get(Calendar.YEAR);

        //Tmpcal for finding links to next and prev months
        Calendar tmpcal;

        //Drop back to last month
        tmpcal = (Calendar)startdate.clone();
        tmpcal.add(Calendar.MONTH, -1);
        String viewdatelastmonth = reger.core.TimeUtils.dateformatdate(tmpcal);

        //Zoom ahead to next month
        tmpcal = (Calendar)startdate.clone();
        tmpcal.add(Calendar.MONTH, 1);
        String viewdatenextmonth = reger.core.TimeUtils.dateformatdate(tmpcal);

        //The month name and next/previous links
        sc.append("<a href='" + thispagename + "?logid=" + logid + "&viewmonth="  + viewdatelastmonth + "'><</a> ");
        sc.append(thismonthname + "  " + thisyear);
        sc.append("<a href='" + thispagename + "?logid=" + logid + "&viewmonth="  + viewdatenextmonth + "'>></a> ");
        sc.append("</TD>");
        sc.append("</TR>");

        //The day names
        sc.append("<TR>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Sun</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Mon</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Tue</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Wed</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Thu</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Fri</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Sat</TD>");
        sc.append("<TD class=calendardayname ALIGN='center' BGCOLOR=#999999 width=12%>Total</TD>");
        sc.append("</TR>");

        //Write spacer cells at beginning of first row if month doesn't start on a Sunday.
        if (iDOW != 1) {
            sc.append("<TR>");
            iPosition = 1;
            while (iPosition < iDOW) {
                sc.append("<TD width=14% ></TD>");
                iPosition = iPosition + 1;
            }
        }

        //Write days of month in proper day slots
        iCurrent = 1;
        iPosition = iDOW;
        while (iCurrent <= iDIM) {
            //If we're at the begginning of a row then write TR
            if (iPosition == 1) {
                sc.append("<TR>");
            }

            //Get a simple string from the current date
            thisdate=reger.core.TimeUtils.dateformatdate(dDate);

            //See if we have anything to put inside this cell
//            if (plugin.cellHtml.get(thisdate)!=null) {
//                cellOnFlag=cellOnFlag+1;
//                inCell=(String)plugin.cellHtml.get(thisdate);
//            } else {
//                cellOnFlag=0;
//                inCell="";
//            }

            //If the day we're writing is the selected day then highlight it somehow.
//            if (cellOnFlag >= 1) {
//                sc.append("<TD class=calendardayboxtoday BGCOLOR=#ffffcc valign=top width=25><a href='" + thispagename + "?logid=" + logid + "&viewdate="+ year +"-"+reger.core.Util.prefillZeroes(String.valueOf(month+1), 2)+"-"+reger.core.Util.prefillZeroes(String.valueOf(iCurrent), 2)+"'>" + iCurrent + "</a><br>"+inCell+"</TD>");
//            } else {
//                sc.append("<TD class=calendardaybox valign=top>" + iCurrent + "<BR>"+inCell+"</TD>");
//            }

            //Append the correct cell
            if (plugin.cellHtml.get(thisdate)!=null){
                sc.append((String)plugin.cellHtml.get(thisdate) + Vars.LINEBREAKCHARFOREMAIL);
            } else {
                sc.append("<TD class=calendardaybox width=12% valign=top>" + iCurrent + "<BR></TD>" + Vars.LINEBREAKCHARFOREMAIL);
            }

            //Add the megavalues to the temporary weekly and monthly totals
            for (Iterator it = megafieldids.iterator(); it.hasNext(); ) {
                int megafieldid = (Integer)it.next();
                if (plugin.cellMegavalues.get(thisdate+"-"+megafieldid)!=null){
                    int megavalue = (Integer)plugin.cellMegavalues.get(thisdate+"-"+megafieldid);
                    megavalueWeekSum = reger.core.Util.hashMapAppendValue(megavalueWeekSum, megafieldid, megavalue);
                    megavalueMonthSum = reger.core.Util.hashMapAppendValue(megavalueMonthSum, megafieldid, megavalue);
                }
            }

            //If we're at the endof a row then write /TR
            if (iPosition == 7) {
                sc.append(getSum(megavalueWeekSum));
                //Wipe megavalweeksum because just output it
                megavalueWeekSum = new HashMap<Integer, Integer>();
                sc.append("</TR>");
                iPosition = 0;
            }

            //Increment variables
            iCurrent = iCurrent + 1;
            iPosition = iPosition + 1;
            dDate.add(Calendar.DATE, 1);
        }

        //Write spacer cells at end of last row if month doesn't end on a Saturday.
        if (iPosition != 1) {
            while (iPosition <= 7) {
                sc.append("<TD width=12% ></TD>");
                iPosition = iPosition + 1;
            }
            sc.append(getSum(megavalueWeekSum));
            //Wipe megavalweeksum because just output it
            megavalueWeekSum = new HashMap<Integer, Integer>();
            sc.append("</TR>");
        }

        //@todo Implement this Expand Calendar link outside of this class
        if (calendartype== Vars.CALENDARTYPEEMPTYEVENTFINDER){
            sc.append("<tr><td ALIGN=center COLSPAN=8>");
            sc.append("<a href='calendar.log'><font face=arial size=-2>Expand Calendar</font>");
            sc.append("</td></tr>");
        }

        //The day names
        sc.append("<TR>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#ffffff width=12%></TD>");
        sc.append("<TD BGCOLOR=#cccccc width=12% valign=top align=right style='font-weight: bold;  padding: 5px;'><font face=arial>"+thismonthname.toUpperCase() + "  " + thisyear+" TOTALS</font></TD>");
        sc.append("<TD BGCOLOR=#cccccc width=100 valign=top style='font-weight: bold;  padding: 5px;'><font face=arial>"+getMonthSum(megavalueMonthSum)+"</font></TD>");
        sc.append("</TR>");

        sc.append("</TABLE>");

        return sc;
    }


    private static String getSum(HashMap<Integer, Integer> megavalueWeekSum){
        //Currently this is a hack for Joe Reger's training log
        ArrayList<Integer> megafieldids = getJoeWorkoutMegafieldids();

        StringBuffer sum = new StringBuffer();
        sum.append("<td width=12% valign=top style='font-weight: bold; padding: 5px;'><font face=arial>");

        for (Iterator it = megafieldids.iterator(); it.hasNext(); ) {
            int megafieldid = (Integer)it.next();
            int megavalue = 0;
            if (megavalueWeekSum!=null && Util.isinteger(String.valueOf(megavalueWeekSum.get(megafieldid)))){
                megavalue = megavalueWeekSum.get(megafieldid);
            }
            sum.append(getHms(megavalue)+" "+getFieldname(megafieldid));
            sum.append("<br/>");
        }
        sum.append("</font></td>");
        return sum.toString();
    }

    private static String getFieldname(int megafieldid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT fieldname FROM megafield WHERE megafieldid="+megafieldid+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
            for(int i=0; i<rstEvent.length; i++){
                if (rstEvent[i][0].equals("Swim Time")){
                    return "Swim";
                } else if (rstEvent[i][0].equals("Bike Time")){
                    return "Bike";
                } else if (rstEvent[i][0].equals("Run Time")){
                    return "Run";
                }
                return rstEvent[i][0];
            }
        }
        return "";
    }


    private static String getMonthSum(HashMap<Integer, Integer> megavalueMonthSum){
        //Currently this is a hack for Joe Reger's training log
        ArrayList<Integer> megafieldids = getJoeWorkoutMegafieldids();

        StringBuffer sum = new StringBuffer();
        for (Iterator it = megafieldids.iterator(); it.hasNext(); ) {
            int megafieldid = (Integer)it.next();
            int megavalue = 0;
            if (megavalueMonthSum!=null && Util.isinteger(String.valueOf(megavalueMonthSum.get(megafieldid)))){
                megavalue = megavalueMonthSum.get(megafieldid);
            }
            sum.append(getHms(megavalue)+" "+getFieldname(megafieldid));
            sum.append("<br/>");
        }
        return sum.toString();
    }


    public static String getHms(int seconds){
        reger.core.HoursMinutesSeconds hms = new reger.core.HoursMinutesSeconds(seconds);
        return getPrettyNum(hms.getHours())+":"+getPrettyNum(hms.getMinutes())+"";
    }

    public static String getPrettyNum(int num){
        String out = String.valueOf(num);
        if (out.length()==1){
            out = "0"+out;
        }
        return out;
    }


    public static ArrayList<Integer> getJoeWorkoutMegafieldids(){
        //@todo make these fields configurable via UI
        ArrayList<Integer> megafieldids = new ArrayList<Integer>();
        megafieldids.add(108);  //Swim time
        megafieldids.add(113);  //Bike time
        megafieldids.add(101);  //Run time
        return megafieldids;
    }





}
