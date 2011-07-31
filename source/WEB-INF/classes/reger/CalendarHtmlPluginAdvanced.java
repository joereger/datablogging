package reger;

import org.apache.jcs.auxiliary.lateral.LateralCache;
import reger.core.Util;
import reger.core.db.Db;

import java.util.*;

/**
 * This class populates the calendar cell.  Each different behavior has its own method which
 * fills cellHtml with keys of "2003-12-15" and values of whatever should be in the cell.
 * Each behavior also populates the countdates variable.
 */
public class CalendarHtmlPluginAdvanced implements CalendarDayPlugin{

    public HashMap cellHtml = new HashMap();  //Key - 2011-07-30
    public HashMap<String, Integer> cellMegavalues = new HashMap<String, Integer>();  //Key - 2011-07-30-megafieldid
    //public int countdates=0;

    //Constructor
    //typetofill=eventFinderEmptyCell - Simply adds a treemap key where the calendar should be on but leaves the cell blank
    public CalendarHtmlPluginAdvanced(int calendartype, Calendar startdate, Calendar enddate, int logid, UserSession userSession, String thisPageName){
        if (calendartype== Vars.CALENDARTYPEEMPTYEVENTFINDER){
            getHtml(startdate, enddate, logid, userSession, false, thisPageName);
        } else if (calendartype== Vars.CALENDARTYPEEMPTYEVENTLINKS){
            getHtml(startdate, enddate, logid, userSession, true, thisPageName);
        }
    }

    public void getHtml(Calendar startdate, Calendar enddate, int logid, UserSession userSession, boolean showtitles, String thisPageName){

        //Currently this is a hack for Joe Reger's training log
        ArrayList<Integer> megafieldids = CalendarHtmlAdvanced.getJoeWorkoutMegafieldids();

        if (userSession.getAccountuser()!=null){

            String sql="";

            if (logid<0) {
                //It's the index page
                sql="SELECT date, eventid, title, event.logid FROM event, megalog WHERE "+ Entry.sqlOfLiveEntry+" AND megalog.accountid='" + userSession.getAccount().getAccountid() + "' AND date>'"+reger.core.TimeUtils.dateformatfordb(startdate)+"' AND date<'"+reger.core.TimeUtils.dateformatfordb(enddate)+"' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + " AND megalog.logid=event.logid ORDER BY date DESC";
            } else {
                //It's a log-specific page
                sql="SELECT date, eventid, title, event.logid FROM event, megalog WHERE megalog.logid='" + logid + "' AND "+ Entry.sqlOfLiveEntry+" AND megalog.accountid='" + userSession.getAccount().getAccountid() + "'  AND date>'"+reger.core.TimeUtils.dateformatfordb(startdate)+"' AND date<'"+reger.core.TimeUtils.dateformatfordb(enddate)+"' AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid()) + " AND megalog.logid=event.logid ORDER BY date DESC";
            }


            //reger.core.Util.logtodb("sql: " + sql);

            //create array with all dates for this logid

            Calendar userdate;

            //-----------------------------------
            //-----------------------------------
            String[][] rstEvent= Db.RunSQL(sql);
            //-----------------------------------
            //-----------------------------------
            if (rstEvent!=null && rstEvent.length>0){
                for(int i=0; i<rstEvent.length; i++){

                    int eventid = Integer.parseInt(rstEvent[i][1]);
                    //This is the key... 2011-07-30
                    userdate=reger.core.TimeUtils.gmttousertime(rstEvent[i][0], userSession.getAccount().getTimezoneid());
                    //countdates=countdates+1;

                    //Add title to the day's cellHtml
                    String fillCell="<a href='entry-logid"+rstEvent[i][3]+"-eventid"+rstEvent[i][1]+".log'><!--<img src='images/bullet-arrow.gif' width='9' height='9' alt='' border='0'>-->"+rstEvent[i][2]+"</a><br>";
                    this.cellHtml = reger.core.Util.hashMapAppendValue(this.cellHtml, reger.core.TimeUtils.dateformatdate(userdate), fillCell);

                    for (Iterator it = megafieldids.iterator(); it.hasNext(); ) {
                        int megafieldid = (Integer)it.next();
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstVal= Db.RunSQL("SELECT megafield.fieldname, megavalue FROM megafield, megavalue WHERE megafield.megafieldid="+megafieldid+" AND megafield.megafieldid=megavalue.megafieldid AND megavalue.eventid="+eventid+"");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstVal!=null && rstVal.length>0){
                            for(int j=0; j<rstVal.length; j++){
                                String fieldname = rstVal[j][0];
                                if (fieldname.equals("Swim Time")){
                                    fieldname = "Swim";
                                } else if (fieldname.equals("Bike Time")){
                                    fieldname = "Bike";
                                } else if (fieldname.equals("Run Time")){
                                    fieldname = "Run";
                                }
                                //Get megavalue for this eventid
                                int megavalue = 0;
                                if (Util.isinteger(rstVal[j][1])){
                                    megavalue = Integer.parseInt(rstVal[j][1]);
                                }
                                //Add megafield data to the day's cellHtml
                                this.cellHtml = reger.core.Util.hashMapAppendValue(this.cellHtml, reger.core.TimeUtils.dateformatdate(userdate), CalendarHtmlAdvanced.getHms(megavalue)+" "+fieldname+"<br/>");
                                //Add it to any previous
                                String valKey = reger.core.TimeUtils.dateformatdate(userdate)+"-"+megafieldid; // Ex 2011-07-30-108
                                this.cellMegavalues = reger.core.Util.hashMapAppendValue(this.cellMegavalues, valKey, megavalue);
                            }
                        }
                    }

                    //this.cellHtml = reger.core.Util.hashMapAppendValue(this.cellHtml, reger.core.TimeUtils.dateformatdate(userdate), fillCell);

                }
            }

            //Now that we have values for each cell, we need to determine the color and linkage.
            //We do this by wrapping the inside of the cell with html
            //Iterate the HashMap
            boolean cellIsOn = false;
            String cellContent = "";
            for (Iterator i=this.cellHtml.entrySet().iterator(); i.hasNext(); ) {

                Map.Entry e = (Map.Entry) i.next();

                if (e.getValue()!=null) {
                    //Extract the day number. Date is in format yyyy-MM-dd.
                    String tmp =  (String)e.getKey();
                    String iCurrent = tmp.split("-")[2];
                    String month = tmp.split("-")[1];
                    String year = tmp.split("-")[0];
                    //Get contents of cell
                    cellContent=(String)e.getValue();
                    //Add to stringbuffer
                    StringBuffer sc = new StringBuffer();
                    sc.append("<TD class=calendardayboxtoday BGCOLOR=#ffffcc width=12% valign=top><a href='" + thisPageName + "?logid=" + logid + "&viewdate="+ year +"-"+reger.core.Util.prefillZeroes(String.valueOf(month), 2)+"-"+reger.core.Util.prefillZeroes(String.valueOf(iCurrent), 2)+"'>" + iCurrent + "</a><br>"+cellContent+"</TD>");
                    //And store back in hashmap
                    this.cellHtml.put(e.getKey(), sc.toString());
                } else {
                    //Do nothing.  Default cell is held in main CalendarHtml.java
                }

            }






        }
    }

}
