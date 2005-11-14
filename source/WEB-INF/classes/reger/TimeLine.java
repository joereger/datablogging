package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * A timeline organizes a number of time periods into a single view or chart.
 */
public class TimeLine {

    //Dates are held in TimeLine as GMT and then converted to user on output
    java.util.Calendar lowestDateGMT;
    java.util.Calendar highestDateGMT;
    java.util.Calendar boundaryDateGMT;
    int accountid;
    reger.UserSession userSession = null; //The person trying to view this timeline
    public int[] timeperiodids = new int[0];

    /**
     * If you submit dates as null you'll get all time periods in the account.
     * If you submit a boundary date, it'll search for those time periods that cross over the boundary date. If lowestDateGMT and highestDateGMT are null, it'll calculare those to be the highest/lowest in that set of time periods that cross the boundary.
     */
    public TimeLine(java.util.Calendar lowestDateGMT, java.util.Calendar highestDateGMT, java.util.Calendar boundaryDateGMT, int accountid, reger.UserSession userSession){
        this.lowestDateGMT = lowestDateGMT;
        this.highestDateGMT = highestDateGMT;
        this.boundaryDateGMT = boundaryDateGMT;
        this.accountid = accountid;
        this.userSession = userSession;

        //Deal with private/public
        String privateSql = " isprivate='0' ";
        if (userSession.getAccountuser().userCanDoAcl("TIMEPERIODSVIEWPRIVATE", userSession.getAccount().getAccountid())){
            privateSql = " (isprivate='0' || isprivate='1') ";
        }

        Calendar nowInGMT = reger.core.TimeUtils.nowInUserTimezone("GMT");

        //Yes, boundary
        //If they're the same, we need to get all time periods that cross the boundary of the time listed
        if (boundaryDateGMT!=null && lowestDateGMT==null && highestDateGMT==null){

            //reger.core.Util.logtodb("BoundaryDateGMT=" + boundaryDateGMT.toString());
            //reger.core.Util.logtodb("dateformatfordb(boundaryDateGMT)=" +reger.core.TimeUtils.dateformatfordb(boundaryDateGMT));

            String dateSql = "(   startdate<='" + reger.core.TimeUtils.dateformatfordb(boundaryDateGMT) + "' AND (enddate>='"+reger.core.TimeUtils.dateformatfordb(boundaryDateGMT)+"'";
            if (nowInGMT.after(boundaryDateGMT)){
                dateSql = dateSql + " OR isopenended='1'";
            }
            dateSql = dateSql + ")   )";

            //reger.core.Util.logtodb(dateSql);


            //Get the lowest date
            //-----------------------------------
            //-----------------------------------
            String[][] rstLowDate= Db.RunSQL("SELECT startDate FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" AND "+dateSql+" ORDER BY startDate ASC LIMIT 0,1");
            //-----------------------------------
            //-----------------------------------
            if (rstLowDate!=null && rstLowDate.length>0){
                this.lowestDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstLowDate[0][0]);
            } else {
                this.lowestDateGMT = nowInGMT;
            }

            //Get the highest date
            //-----------------------------------
            //-----------------------------------
            String[][] rstHighDate= Db.RunSQL("SELECT endDate, isopenended FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" AND "+dateSql+" ORDER BY endDate DESC LIMIT 0,1");
            //-----------------------------------
            //-----------------------------------
            if (rstHighDate!=null && rstHighDate.length>0){
                if (rstHighDate[0][1].equals("0")){
                    this.highestDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstHighDate[0][0]);
                } else {
                    this.highestDateGMT = nowInGMT;
                }
            } else {
                this.highestDateGMT = nowInGMT;
            }

            //reger.core.Util.logtodb("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" AND "+dateSql+" ORDER BY startDate DESC");

            //Go find time periods in this timeline, based on the date
            //-----------------------------------
            //-----------------------------------
            String[][] rstTp= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" AND "+dateSql+" ORDER BY startDate DESC");
            //-----------------------------------
            //-----------------------------------
            if (rstTp!=null && rstTp.length>0){
                for(int i=0; i<rstTp.length; i++){
                    timeperiodids = reger.core.Util.addToIntArray(timeperiodids, Integer.parseInt(rstTp[i][0]));
                }
            }


        //No boundary ---------------
        } else {

            //Happens when all dates are set to null.
            if (lowestDateGMT==null){
                //Get the lowest date
                //-----------------------------------
                //-----------------------------------
                String[][] rstLowDate= Db.RunSQL("SELECT startDate FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" ORDER BY startDate ASC LIMIT 0,1");
                //-----------------------------------
                //-----------------------------------
                if (rstLowDate!=null && rstLowDate.length>0){
                    this.lowestDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstLowDate[0][0]);
                } else {
                    this.lowestDateGMT = nowInGMT;
                }
            }

            //Happens when all dates are set to null.
            if (highestDateGMT==null){
                //Get the highest date
                //-----------------------------------
                //-----------------------------------
                String[][] rstHighDate= Db.RunSQL("SELECT endDate FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" ORDER BY endDate DESC LIMIT 0,1");
                //-----------------------------------
                //-----------------------------------
                if (rstHighDate!=null && rstHighDate.length>0){
                    this.highestDateGMT = reger.core.TimeUtils.dbstringtocalendar(rstHighDate[0][0]);
                } else {
                    this.highestDateGMT = nowInGMT;
                }
            }

            String dateSql = "(    (isopenended='1' AND startdate>='" + reger.core.TimeUtils.dateformatfordb(this.lowestDateGMT) + "' AND startdate<='"+reger.core.TimeUtils.dateformatfordb(this.highestDateGMT)+"') OR ((startdate>='" + reger.core.TimeUtils.dateformatfordb(this.lowestDateGMT) + "' AND startdate<='"+reger.core.TimeUtils.dateformatfordb(this.highestDateGMT)+"') OR (enddate>='" + reger.core.TimeUtils.dateformatfordb(this.lowestDateGMT) + "' AND enddate<='"+reger.core.TimeUtils.dateformatfordb(this.highestDateGMT)+"'))    )";

            //Go find time periods in this timeline, based on the date
            //-----------------------------------
            //-----------------------------------
            String[][] rstTp= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"' AND "+privateSql+" AND "+dateSql+" ORDER BY startDate DESC");
            //-----------------------------------
            //-----------------------------------
            if (rstTp!=null && rstTp.length>0){
                for(int i=0; i<rstTp.length; i++){
                    timeperiodids = reger.core.Util.addToIntArray(timeperiodids, Integer.parseInt(rstTp[i][0]));
                }
            }



        }






    }


    public String getTimelineHtml(String pathToAppRoot, int width){
        StringBuffer mb = new StringBuffer();


        if (timeperiodids.length>0){

            mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");

            mb.append("<tr>");
            mb.append("<td valign=bottom align=left bgcolor=#ffffff style=\"border-bottom: 2px solid #cccccc; border-left: 0px solid #666666; padding: 3px;\">");
            mb.append("<font face=arial size=-2 style=\"font-size: 9px; color: #666666;\">");
            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(lowestDateGMT, userSession.getAccount().getTimezoneid())));
            mb.append("<br>");
            mb.append(userSession.getAccount().getTimezoneid());
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=bottom align=right bgcolor=#ffffff style=\"border-bottom: 2px solid #cccccc; border-right: 0px solid #666666; padding: 3px;\">");
            mb.append("<font face=arial size=-2 style=\"font-size: 9px; color: #666666;\">");
            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(highestDateGMT, userSession.getAccount().getTimezoneid())));
            mb.append("<br>");
            mb.append(userSession.getAccount().getTimezoneid());
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");

//            mb.append("<tr>");
//            mb.append("<td valign=middle bgcolor=#ffffff>");
//            mb.append("<font face=arial size=-2 style=\"font-size: 9px\">");
//            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(lowestDateGMT, userSession.getAccount().getTimezoneid())));
//            mb.append("<br>");
//            mb.append(userSession.getAccount().getTimezoneid());
//            mb.append("</font>");
//            mb.append("</td>");

//            mb.append("<td valign=middle align=left background='"+pathToAppRoot+"images/timeperiod/vertline-bg-left.gif'>");
//            mb.append("<img src='"+pathToAppRoot+"images/timeperiod/mainarrow-left.gif' width=38 height=37 border=0>");
//            mb.append("</td>");

            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#ffffff colspan=2>");
            mb.append("<br>");
            //Iterate the timeperiodids
            for (int i = 0; i < timeperiodids.length; i++) {
                reger.TimePeriod tmpTp = new reger.TimePeriod(timeperiodids[i], userSession);
                mb.append(tmpTp.getTimePeriodRowHtml(lowestDateGMT, highestDateGMT, boundaryDateGMT, pathToAppRoot, width, userSession));
            }

            mb.append("</td>");
            mb.append("</tr>");

//            mb.append("<td valign=middle align=left background='"+pathToAppRoot+"images/timeperiod/vertline-bg-right.gif'>");
//            mb.append("<img src='"+pathToAppRoot+"images/timeperiod/mainarrow-right.gif' width=38 height=37 border=0>");
//            mb.append("</td>");

//            mb.append("<td valign=middle bgcolor=#ffffff>");
//            mb.append("<font face=arial size=-2 style=\"font-size: 9px\">");
//            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(highestDateGMT, userSession.getAccount().getTimezoneid())));
//            mb.append("<br>");
//            mb.append(userSession.getAccount().getTimezoneid());
//            mb.append("</font>");
//            mb.append("</td>");

            mb.append("</table>");

        } else {
            mb.append("<font face=arial size=-1>None.</font>");
        }

        return mb.toString();
    }




}
