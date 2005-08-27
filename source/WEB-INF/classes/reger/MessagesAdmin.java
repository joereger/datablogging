package reger;

import reger.core.db.Db;

/**
 * Created by IntelliJ IDEA.
 * User: jreger
 * Date: Feb 29, 2004
 * Time: 10:36:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessagesAdmin {

    public static StringBuffer htmlOut(reger.UserSession userSession, int perpage, javax.servlet.http.HttpServletRequest request, boolean showpaginglinks, String tabletitle, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        //Count total records
        int totalmessages=0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessageCount= Db.RunSQL("SELECT count(*) FROM message, event, megalog WHERE message.eventid=event.eventid AND event.accountid='"+userSession.getAccount().getAccountid()+"' AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" ORDER BY message.messagedate DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstMessageCount!=null && rstMessageCount.length>0){
            totalmessages=Integer.parseInt(rstMessageCount[0][0]);
        }

        //Get current page number
        int currentpage=1;
        if (request.getParameter("currentpage")!=null && reger.core.Util.isinteger(request.getParameter("currentpage"))){
            currentpage=Integer.parseInt(request.getParameter("currentpage"));
        }

        //Set the num per page
        //perpage=25;

        //Calculate the record bounds
        int bottomlimit=(perpage*currentpage)-perpage;
        int upperlimit=perpage;

        if (showpaginglinks){
            mb.append("<center>");
            mb.append(reger.pagingLinkPrint.getHtml(totalmessages, currentpage, perpage, request));
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
        mb.append("<font face=arial size=-2 color=#666666>Status</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Date/From</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left>");
        mb.append("<font face=arial size=-2 color=#666666>Message</font>");
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
        String[][] rstMessage= Db.RunSQL("SELECT message.messageid, message.eventid, message.messagedate, message.messagefrom, message.message, message.isapproved, event.title FROM message, event, megalog WHERE message.eventid=event.eventid AND event.accountid='"+userSession.getAccount().getAccountid()+"' AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" ORDER BY message.messagedate DESC LIMIT "+bottomlimit+", "+upperlimit+"");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            for(int i=0; i<rstMessage.length; i++){

                if (rowcolor.equals("#e6e6e6")){
                    rowcolor="#ffffff";
                } else {
                    rowcolor="#e6e6e6";
                }

                mb.append("<tr>");
                if (rstMessage[i][5].equals("1")) {
                    hlcolor="#00ff00";
                } else {
                    hlcolor="#ff0000";
                }
                mb.append("<td valign=top bgcolor="+hlcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append("<b>");
                if (rstMessage[i][5].equals("1")) {
                    tostatus="0";
                } else {
                    tostatus="1";
                }
                mb.append("<a href='traffic-messages.log?action=togglestatus&tostatus="+tostatus+"&messageid="+rstMessage[i][0]+"&currentpage="+currentpage+"'>");
                if (rstMessage[i][5].equals("1")) {
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
                mb.append(reger.core.TimeUtils.dateformatcompact(reger.core.TimeUtils.dbstringtocalendar(rstMessage[i][2])));
                mb.append("<br>");
                mb.append(rstMessage[i][3]);
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor="+rowcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append(rstMessage[i][4].replaceAll("<", "&lt;"));
                mb.append("<br>");
                mb.append("<b>From Entry:</b> ");
                mb.append("<a href='../entry-eventid"+rstMessage[i][1]+".log'>");
                mb.append(rstMessage[i][6]);
                mb.append("</a>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor="+rowcolor+" align=left>");
                mb.append("<font face=arial size=-2 color=#000000>");
                mb.append("<a href='traffic-messages.log?action=delete&messageid="+rstMessage[i][0]+"&currentpage="+currentpage+"'>");
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
            mb.append("No Messages Have Been Posted.  Turn Reader Messages On/Off and configure message approval on the <a href='settings-siteprops.log'>Site Properties</a> page in the Customize Section.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }

        mb.append("</table>");
        mb.append(reger.ui.BubbleBox.end(pathToAppRoot));

        return mb;
    }

}
