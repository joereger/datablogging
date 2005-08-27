package reger;

import reger.core.db.Db;
import reger.core.TimeUtils;
import reger.core.Util;

/**
 * Trackback admin.
 */
public class TrackbackAdmin {

    public static StringBuffer htmlOut(reger.UserSession userSession, int perpage, javax.servlet.http.HttpServletRequest request, boolean showpaginglinks, String tabletitle, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        //Count total records
        int totaltrackback=0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessageCount= Db.RunSQL("SELECT count(*) FROM trackback, event, megalog WHERE trackback.eventid=event.eventid AND event.accountid='"+userSession.getAccount().getAccountid()+"' AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" AND trackback.isoutbound='0' ORDER BY trackback.datetime DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstMessageCount!=null && rstMessageCount.length>0){
            totaltrackback=Integer.parseInt(rstMessageCount[0][0]);
        }

        //Get current page number
        int currentpage=1;
        if (request.getParameter("currentpage")!=null && Util.isinteger(request.getParameter("currentpage"))){
            currentpage=Integer.parseInt(request.getParameter("currentpage"));
        }

        //Set the num per page
        //perpage=25;

        //Calculate the record bounds
        int bottomlimit=(perpage*currentpage)-perpage;
        int upperlimit=perpage;

        if (showpaginglinks){
            mb.append("<center>");
            mb.append(pagingLinkPrint.getHtml(totaltrackback, currentpage, perpage, request));
            mb.append("</center>");
        }

        mb.append(reger.ui.BubbleBox.start(tabletitle, pathToAppRoot));

        mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");

        //mb.append("<tr>");
        //mb.append("<td valign=top bgcolor=#666666 align=left colspan=4>");
        //mb.append("<font face=arial size=+1 color=#ffffff><strong>"+tabletitle+"</strong></font>");
        //mb.append("</td>");
        //mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Approved?</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Date/From</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Trackback Body</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Delete?</font>");
        mb.append("</td>");
        mb.append("</tr>");

        String rowcolor="";
        String hlcolor="";
        String tostatus="";

        //-----------------------------------
        //-----------------------------------
        String[][] rstTrackback= Db.RunSQL("SELECT trackback.trackbackid, trackback.eventid, trackback.datetime, trackback.blogname, trackback.posttitle, trackback.isapproved, event.title, trackback.excerpt, trackback.url FROM trackback, event, megalog WHERE trackback.eventid=event.eventid AND event.accountid='"+userSession.getAccount().getAccountid()+"' AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" AND trackback.isoutbound='0' ORDER BY trackback.datetime DESC LIMIT "+bottomlimit+", "+upperlimit+"");
        //-----------------------------------
        //-----------------------------------
        if (rstTrackback!=null && rstTrackback.length>0){
            for(int i=0; i<rstTrackback.length; i++){

                if (rowcolor.equals("#e6e6e6")){
                    rowcolor="#ffffff";
                } else {
                    rowcolor="#e6e6e6";
                }

                mb.append("<tr>");
                if (rstTrackback[i][5].equals("1")) {
                    hlcolor="#00ff00";
                } else {
                    hlcolor="#ff0000";
                }
                mb.append("<td valign=top bgcolor="+hlcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append("<b>");
                if (rstTrackback[i][5].equals("1")) {
                    tostatus="0";
                } else {
                    tostatus="1";
                }
                mb.append("<a href='traffic-trackback.log?action=togglestatus&tostatus="+tostatus+"&trackbackid="+rstTrackback[i][0]+"&currentpage="+currentpage+"'>");
                if (rstTrackback[i][5].equals("1")) {
                    mb.append("Approved");
                } else {
                    mb.append("Not Approved");
                }
                mb.append("</a>");
                mb.append("</b>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor="+rowcolor+" align=left nowrap>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append(TimeUtils.dateformatcompact(TimeUtils.dbstringtocalendar(rstTrackback[i][2])));
                mb.append("<br>");
                mb.append(rstTrackback[i][3]);
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor="+rowcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append("<a href=\""+reger.core.Util.cleanForHtml(rstTrackback[i][8])+"\">");
                mb.append(rstTrackback[i][4] + "&nbsp;");
                mb.append("</a>");
                mb.append("<br>");
                mb.append("<b>"+rstTrackback[i][3]+"</b>");
                mb.append("<br>");
                mb.append(rstTrackback[i][7]);
                mb.append("<br>");
                mb.append("<b>Trackbacked to Your Entry:</b>");
                mb.append("<br>");
                mb.append("<a href='../entry-eventid"+rstTrackback[i][1]+".log'>");
                mb.append(rstTrackback[i][6]);
                mb.append("</a>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor="+rowcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append("<a href='traffic-trackback.log?action=delete&trackbackid="+rstTrackback[i][0]+"&currentpage="+currentpage+"'>");
                mb.append("Delete");
                mb.append("</a>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
        } else {
            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#ffffff align=left colspan=4>");
            mb.append("<font face=arial size=-2 color=#000000>");
            mb.append("No Trackbacks Have Been Received.  Turn Trackback On/Off and configure trackback approval on the <a href='settings-siteprops.log'>Site Properties</a> page in the Customize Section.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }

        mb.append("</table>");
        mb.append(reger.ui.BubbleBox.end(pathToAppRoot));

        return mb;
    }

}
