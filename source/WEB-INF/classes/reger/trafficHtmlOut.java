package reger;

import reger.core.db.Db;

import javax.servlet.http.HttpServletRequest;

/**
 * A class to output traffic stats
 */
public class trafficHtmlOut {

    //This is a SQL string that filters out (removes) traffic that comes from the admin section.
    public static String filterAdminEntries=" AND (traffictypeid<>'"+reger.Vars.TRAFFICTYPEADMINHOMEPAGE+"' AND traffictypeid<>'"+reger.Vars.TRAFFICTYPEADMINLOGSECTION+"' AND traffictypeid<>'"+reger.Vars.TRAFFICTYPEADMINHOMEPAGE+"'AND traffictypeid<>'"+reger.Vars.TRAFFICTYPEADMINMISC+"')";

    /**
     * Do something.
     */
    public static String getTimeAgo(int daysago, reger.UserSession userSession){

        //Get current time
        java.util.Calendar tdate=java.util.Calendar.getInstance();


        //Convert to user time
        //tdate=reger.core.TimeUtils.gmttousertime(tdate, "EST");
        tdate=reger.core.TimeUtils.convertFromOneTimeZoneToAnother(tdate, tdate.getTimeZone().getID(), userSession.getAccount().getTimezoneid());


        //Get the start date
        tdate=reger.core.TimeUtils.xDaysAgoStart(tdate, daysago);


        //Convert to a server time for query
        tdate=reger.core.TimeUtils.usertogmttime(tdate, userSession.getAccount().getTimezoneid());


        return reger.core.TimeUtils.dateformatfordb(tdate);
    }

    /**
     * Do something.
     */
    public static StringBuffer homeTrafficList(int daysago, int maxinlist, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT SUM(count) FROM traffic WHERE datetime>'"+ getTimeAgo(daysago, userSession) +"' AND traffic.traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICHOMEPAGE+"' AND accountid='"+ userSession.getAccount().getAccountid() +"'";


        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	int i=0;
            int counter=0;
        	while(i<rstToday.length && counter<maxinlist){
        		counter=counter+1;
                sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstToday[i][0]);
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                sb.append("My Homepage" );
                sb.append("</font></td>" );
                sb.append("</tr>" );
                i=i+1;
        	}
        }

        sb.append("</table>" );

        return sb;
    }


    /**
     * Do something.
     */
    public static StringBuffer entryTrafficList(int daysago, int maxinlist, reger.UserSession userSession, boolean displayasadmin, int logid){

        StringBuffer sb = new StringBuffer();

        //Limit to logid, if required
        String logidSql = "";
        if (logid>0){
            logidSql = " AND megalog.logid='"+logid+"'";
        }

        String sql="SELECT SUM(traffic.count) as sumcnt, event.title, traffic.eventid, event.eventtypeid, event.logid FROM traffic, event, megalog WHERE traffic.traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICENTRYDETAIL+"' AND traffic.datetime>'"+ getTimeAgo(daysago, userSession) +"' AND traffic.eventid=event.eventid AND traffic.eventid>0 AND traffic.accountid='"+ userSession.getAccount().getAccountid() +"'" + filterAdminEntries + " AND traffic.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" "+logidSql+" GROUP BY traffic.eventid, event.title, event.eventtypeid, event.logid ORDER BY sumcnt DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
            int i=0;
            int counter=0;
        	while(i<rstToday.length && counter<maxinlist){
        		counter=counter+1;
        		sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2 class=smallfont>" );
                sb.append("<strong>");
                if (displayasadmin){
                    sb.append(rstToday[i][0]);
                    sb.append("&nbsp;&nbsp;");
                } else {
                    sb.append(counter);
                }
                sb.append("</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                if (displayasadmin){
                    sb.append("<a href='traffic-entry-zoom.log?eventid=" + rstToday[i][2] + "'>" );
                } else {
                    sb.append("<a href='entry-eventid"+rstToday[i][2]+".log'>" );
                }
                sb.append(rstToday[i][1]);
                sb.append("</a>");
                sb.append("&nbsp;&nbsp;");
                sb.append("</font></td>" );
                sb.append("</tr>" );
                i=i+1;
        	}
        }

        sb.append("</table>" );

        return sb;
    }



    /**
     * Do something.
     */
    public static StringBuffer entryTrafficZoom(int eventid, reger.UserSession userSession) {

        //@todo No longer storing traffic data over 7 days

        StringBuffer sb = new StringBuffer();

        //-----------------------------------
        //-----------------------------------
        String[][] rstTodayCount= Db.RunSQL("SELECT sum(count) FROM traffic WHERE traffic.traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICENTRYDETAIL+"' AND eventid='"+ eventid +"' AND accountid='"+ userSession.getAccount().getAccountid() +"'" + filterAdminEntries + "");
        //-----------------------------------
        //-----------------------------------
        int counttotal=0;
        if (rstTodayCount!=null && rstTodayCount.length>0){
            if (reger.core.Util.isinteger(rstTodayCount[0][0])){
        	    counttotal=Integer.parseInt(rstTodayCount[0][0]);
            }
        }

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL("SELECT YEAR(datetime) as yr, MONTH(datetime) as mn, DAYOFMONTH(datetime) as dy, sum(count), datetime FROM traffic WHERE eventid='"+ eventid +"' AND accountid='"+ userSession.getAccount().getAccountid() +"' "+filterAdminEntries+" AND datetime>'2001-01-01 00:00:00' GROUP BY yr, mn, dy ORDER BY yr DESC, mn DESC, dy DESC");
        //-----------------------------------
        //-----------------------------------

        int width=0;
        java.util.Calendar rollingDate = java.util.Calendar.getInstance();
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){

        		if (reger.core.Util.isnumeric(rstToday[i][3]) && counttotal>0) {
                    width=(int)((Double.parseDouble(rstToday[i][3])/counttotal)*500);

                } else {
                    width=0;
                }



                //java.Util.Calendar currentDate = reger.core.TimeUtils.dbstringtocalendar()


                java.util.Calendar currentDate=reger.core.TimeUtils.gmttousertime(reger.core.TimeUtils.minTime(reger.core.TimeUtils.dbstringtocalendar(rstToday[i][4])), "GMT");


                if (reger.core.DateDiff.dateDiff("day", rollingDate, currentDate)>1) {
                    int maxtimes=reger.core.DateDiff.dateDiff("day" ,rollingDate, currentDate)-1;
                    for(int j=0; j<=(maxtimes-1); j++){


                        //Increment rollingdate
                        rollingDate.add(java.util.Calendar.DATE, -1);
                        sb.append(outputEntryZoomRow(rollingDate, 0, 0));
                    }
                }

                sb.append(outputEntryZoomRow(currentDate, Integer.parseInt(rstToday[i][3]), width));

                rollingDate=currentDate;
        	}
        }

        sb.append("</table>" );

        return sb;
    }


    /**
     * Do something.
     */
    public static StringBuffer outputEntryZoomRow(java.util.Calendar indate, int hits, int width) {

            StringBuffer sb = new StringBuffer();

            sb.append("<tr>" );
            sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
            sb.append("<strong>" );
            sb.append(reger.core.TimeUtils.monthname(indate) +" "+ indate.get(java.util.Calendar.DATE) +", "+ indate.get(java.util.Calendar.YEAR));
            sb.append("&nbsp;&nbsp;</strong>" );
            sb.append("</font></td>" );
            sb.append("<td valign=top bgcolor=#ffffff align=left>" );
            if (hits>0) {
                sb.append("<img src='../images/clear.gif' width=5 height=1><img src='../images/bar_dkgrey.gif' width="+ width +" height=10>");
            }
            sb.append("<font face=arial size=-2>" );
            sb.append(hits );
            sb.append("</font>" );
            sb.append("</td>" );
            sb.append("</tr>" );

            return sb;
    }



    /**
     * Do something.
     */
    public static StringBuffer logsTrafficList(int daysago, int maxinlist, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT SUM(traffic.count) as sumcnt, megalog.name, traffic.logid FROM traffic, megalog WHERE traffic.traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICLOGSECTION+"' AND traffic.datetime>'"+ getTimeAgo(daysago, userSession) +"' AND traffic.logid=megalog.logid AND traffic.logid>0 AND traffic.accountid='"+ userSession.getAccount().getAccountid() +"'  AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" GROUP BY traffic.logid, megalog.name ORDER BY sumcnt DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	int i=0;
            int counter=0;
        	while(i<rstToday.length && counter<maxinlist){
        		counter=counter+1;

        		sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstToday[i][0] );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                sb.append(rstToday[i][1] );
                sb.append("</font></td>" );
                sb.append("</tr>" );

                i=i+1;

        	}
        }

        sb.append("</table>" );

        return sb;
    }

    public static StringBuffer imageTrafficList(int daysago, int maxinlist, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT SUM(traffic.count) as sumcnt, traffic.imageid, image.image, megalog.logid FROM traffic, image, megalog, event WHERE traffic.traffictypeid='"+reger.Vars.TRAFFICTYPEIMAGE+"' AND image.eventid=event.eventid AND event.logid=megalog.logid AND traffic.datetime>'"+ getTimeAgo(daysago, userSession) +"' AND traffic.imageid=image.imageid AND traffic.imageid>0 AND traffic.accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" GROUP BY traffic.imageid, image.image  ORDER BY sumcnt DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	int i=0;
            int counter=0;
        	while(i<rstToday.length && counter<maxinlist){
        		counter=counter+1;

        		sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstToday[i][0] );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                sb.append("<a href='../mediaouthtml.log?imageid=" + rstToday[i][1] + "&logid="+rstToday[i][3]+"' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">" );
                sb.append("<img src='../mediaout.log?imageid="+ rstToday[i][1] +"&isthumbnail=yes' border=0>" );
                sb.append("</a>" );
                sb.append("</font></td>" );
                sb.append("</tr>" );

                i=i+1;

        	}
        }

        sb.append("</table>" );

        return sb;

    }


    public static StringBuffer browserTrafficList(int daysago, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT SUM(count) as sumcnt, browser FROM traffic WHERE datetime>'"+ getTimeAgo(daysago, userSession) +"'" + filterAdminEntries + " AND accountid='"+ userSession.getAccount().getAccountid() +"' GROUP BY browser ORDER BY sumcnt DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){
        		sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstToday[i][0] );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                sb.append(rstToday[i][1] );
                sb.append("</font></td>" );
                sb.append("</tr>" );
        	}
        }

        sb.append("</table>" );

        return sb;
    }





    public static StringBuffer referrerTrafficList(int daysago, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT SUM(count) as sumcnt, referrer FROM traffic WHERE datetime>'"+ getTimeAgo(daysago, userSession) +"'" + filterAdminEntries + " AND accountid='"+ userSession.getAccount().getAccountid() +"' GROUP BY referrer ORDER BY sumcnt DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){
        		sb.append("<tr>" );
                sb.append("<td valign=top bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstToday[i][0] );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=-2>" );
                if (!rstToday[i][1].equals("")) {
                    sb.append("<a href='" + rstToday[i][1] + "'>" );
                    sb.append(rstToday[i][1] );
                    sb.append("</a>" );
                } else {
                    sb.append("No Referrer" );
                }
                sb.append("</font></td>" );
                sb.append("</tr>" );
        	}
        }

        sb.append("</table>" );

        return sb;
    }





    public static StringBuffer searchesTrafficList(int daysago, reger.UserSession userSession){

        StringBuffer sb = new StringBuffer();

        String sql="SELECT datetime, searchstring FROM search WHERE accountid='"+ userSession.getAccount().getAccountid() +"' ORDER BY datetime DESC";

        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        //-----------------------------------
        //-----------------------------------
        String[][] rstSearches= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstSearches!=null && rstSearches.length>0){
        	for(int i=0; i<rstSearches.length; i++){
        		sb.append("<tr>" );
                sb.append("<td valign=middle bgcolor=#ffffff align=right nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(rstSearches[i][0] );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );
                sb.append("<td valign=top bgcolor=#ffffff><font face=arial size=+1>" );
                sb.append(rstSearches[i][1] );
                sb.append("</font></td>" );
                sb.append("</tr>" );
        	}
        }

        sb.append("</table>" );

        return sb;
    }




    public static StringBuffer rawclicksTrafficList(int currentpage, String pagename, reger.UserSession userSession, HttpServletRequest request){

        StringBuffer sb = new StringBuffer();

        int perpage=100;
        if (currentpage<1) {
            currentpage=1;
        }

        //Only upgraded customers get to see today's traffic
        String appendsql="";
        if (userSession.getAccount().isPro()) {
            appendsql = " AND datetime<'" + getTimeAgo(1, userSession) + "'";
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstTodayCount= Db.RunSQL("SELECT count(*) FROM traffic, megalog WHERE iscollapsed='0'" + filterAdminEntries + " AND traffic.accountid='"+ userSession.getAccount().getAccountid() +"'"+ appendsql + "  AND traffic.logid=megalog.logid AND (traffic.logid='-1' OR "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+")");
        //-----------------------------------
        //-----------------------------------
        int counttotal=0;
        if (rstTodayCount!=null && rstTodayCount.length>0){
        	counttotal=Integer.parseInt(rstTodayCount[0][0]);
        }


        sb.append("<table cellpadding=0 cellspacing=1 border=0>" );

        sb.append("<tr>" );
        sb.append("<td colspan=2 align=left>" );
        sb.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, perpage, request));
        sb.append("</td>" );
        sb.append("</tr>" );

        sb.append("<tr>" );

        sb.append("<td valign=top bgcolor=#cccccc align=left nowrap><font face=arial size=-2>" );
        sb.append("<strong>Date/Time</strong>" );
        sb.append("</font></td>" );


        sb.append("<td valign=top bgcolor=#cccccc nowrap><font face=arial size=-2>" );
        sb.append("<strong>What was clicked</strong>" );
        sb.append("&nbsp;&nbsp;</font></td>" );


        sb.append("<td valign=top bgcolor=#cccccc nowrap><font face=arial size=-2>" );
        sb.append("<strong>Who clicked it</strong>" );
        sb.append("&nbsp;&nbsp;</font></td>" );

        sb.append("<td valign=top bgcolor=#cccccc nowrap><font face=arial size=-2>" );
        sb.append("<strong>What browser they were using</strong>" );
        sb.append("&nbsp;&nbsp;</font></td>" );

        sb.append("<td valign=top bgcolor=#cccccc nowrap><font face=arial size=-2>" );
        sb.append("<strong>Where they came from</strong>" );
        sb.append("&nbsp;&nbsp;</font></td>" );


        sb.append("</tr>" );


        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL("SELECT datetime, url, remotehost, browser, referrer FROM traffic, megalog WHERE iscollapsed='0'" + filterAdminEntries + " AND traffic.accountid='"+ userSession.getAccount().getAccountid() +"'  AND traffic.logid=megalog.logid AND (traffic.logid='-1' OR "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+") " + appendsql + " ORDER BY datetime DESC LIMIT "+((perpage*currentpage)-perpage)+", "+(perpage*currentpage));
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){
        		sb.append("<tr>" );

                sb.append("<td valign=top bgcolor=#ffffff align=left nowrap><font face=arial size=-2>" );
                sb.append("<strong>" );
                sb.append(reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.gmttousertime(rstToday[i][0], "GMT")) );
                sb.append("&nbsp;&nbsp;</strong>" );
                sb.append("</font></td>" );


                sb.append("<td valign=top bgcolor=#ffffff nowrap><font face=arial size=-2>" );
                sb.append("<a href='"+ userSession.getUrlSplitter().getScheme() + "://" + rstToday[i][1] + "' target=new>" );
                sb.append("" + userSession.getUrlSplitter().getScheme() + "://" + rstToday[i][1] );
                sb.append("</a>" );
                sb.append("&nbsp;&nbsp;</font></td>" );


                sb.append("<td valign=top bgcolor=#ffffff nowrap><font face=arial size=-2>" );
                sb.append(rstToday[i][2] );
                sb.append("&nbsp;&nbsp;</font></td>" );

                sb.append("<td valign=top bgcolor=#ffffff nowrap><font face=arial size=-2>" );
                sb.append(rstToday[i][3] );
                sb.append("&nbsp;&nbsp;</font></td>" );

                sb.append("<td valign=top bgcolor=#ffffff nowrap><font face=arial size=-2>" );
                sb.append("<a href='" + rstToday[i][4] + "'>" );
                sb.append(rstToday[i][4] );
                sb.append("</a>" );
                sb.append("&nbsp;&nbsp;</font></td>" );

                sb.append("</tr>" );
        	}
        }

        sb.append("</table>" );

        return sb;
    }

    public static StringBuffer mobileEntryTrafficList(int accountid, int daysago, int maxinlist, String timezoneid) {
        StringBuffer el = new StringBuffer();


        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL("SELECT SUM(traffic.count) as cnt, event.title, traffic.eventid, event.eventtypeid, event.logid FROM traffic, event WHERE traffic.datetime>'"+ reger.TrafficNumericSummary.getTimeAgo(daysago, timezoneid) +"' AND traffic.eventid=event.eventid AND traffic.eventid>0 AND traffic.accountid='"+ accountid +"'  AND traffic.logid=megalog.logid GROUP BY traffic.eventid, event.title, event.eventtypeid, event.logid ORDER BY cnt DESC LIMIT 0,"+maxinlist);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){
        	    el.append("<p>");
                el.append("(" + rstToday[i][0] + ")" + reger.core.Util.truncateString(rstToday[i][1], 15) + "<br>");
        	    el.append("</p>");
        	}
        } else {
            el.append("<p>");
            el.append("No Individual Entries Read So Far Today");
            el.append("</p>");
        }

        return el;

    }

    public static StringBuffer mobileLogsTrafficList(int accountid, int daysago, int maxinlist, String timezoneid){
        StringBuffer el = new StringBuffer();

        //-----------------------------------
        //-----------------------------------
        String[][] rstToday= Db.RunSQL("SELECT SUM(traffic.count) as cnt, megalog.name, traffic.logid FROM traffic, megalog WHERE traffic.datetime>'"+ reger.TrafficNumericSummary.getTimeAgo(daysago, timezoneid) +"' AND traffic.logid=megalog.logid AND traffic.logid>0 AND traffic.accountid='"+accountid+"' GROUP BY traffic.logid, megalog.name ORDER BY cnt DESC LIMIT 0," + maxinlist);
        //-----------------------------------
        //-----------------------------------
        if (rstToday!=null && rstToday.length>0){
        	for(int i=0; i<rstToday.length; i++){
        		el.append("<p>");
                el.append("(" + rstToday[i][0] + ")" + reger.core.Util.truncateString(rstToday[i][1], 15) + "<br>");
        	    el.append("</p>");
        	}
        } else {
            el.append("<p>");
            el.append("No Individual Entries Read So Far Today");
            el.append("</p>");
        }

        return el;

    }



}
