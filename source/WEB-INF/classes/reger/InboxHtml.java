package reger;

import reger.core.db.Db;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class InboxHtml {


    public static StringBuffer getInboxListing(boolean showNavLinks, int numbertoshow, reger.pageFramework.PageProps pageProps, reger.UserSession userSession, HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        if (showNavLinks){
            mb.append(reger.ui.BubbleBox.start("Inbox", pageProps.pathToAppRoot));
        } else {
            mb.append(reger.ui.BubbleBox.start("<a href='people-inbox.log'><font color=#e6e6e6>Inbox</font></a>", pageProps.pathToAppRoot));
        }

        if (showNavLinks){
            mb.append("<table cellpadding=3 cellspacing=0 width=100% border=0>");

            mb.append("<tr>");
            mb.append("<td valign=top>");
            mb.append(reger.ui.BubbleBox.start("", pageProps.pathToAppRoot));
            mb.append("<font face=arial size=-2><b>");
            mb.append("<a href='people-inbox.log'>Inbox</a>");
            mb.append("<br>");
            mb.append("<a href='people-newmessage.log'>Send New Message</a>");
            mb.append("<br>");
            mb.append("</b></font>");
            mb.append(reger.ui.BubbleBox.end(pageProps.pathToAppRoot));
            mb.append("</td>");
            mb.append("<td valign=top>");
        }
        //Do paging
        int counttotal = 0;
        int currentpage = 1;
        if (request.getParameter("currentpage")!=null && reger.core.Util.isinteger(request.getParameter("currentpage"))){
            currentpage = Integer.parseInt(request.getParameter("currentpage"));
        }
        int perpage=50;
        //-----------------------------------
        //-----------------------------------
        String[][] rstInboxCount= Db.RunSQL("SELECT count(*) FROM friendmessage, friendmessagerecipient WHERE friendmessagerecipient.accountuserid='"+userSession.getAccountuser().getAccountuserid()+"' AND friendmessagerecipient.friendmessageid=friendmessage.friendmessageid");
        //-----------------------------------
        //-----------------------------------
        if (rstInboxCount!=null && rstInboxCount.length>0){
            for(int i=0; i<rstInboxCount.length; i++){
                counttotal = Integer.parseInt(rstInboxCount[0][0]);
            }
        }
        if (numbertoshow<=0){
            mb.append("<center>");
            mb.append(reger.pagingLinkPrint.getHtml(counttotal, currentpage, perpage, request));
            mb.append("</center>");
        }
        //Figure out limit statement
        int limitMin = (currentpage * perpage) - perpage;
        int limitMax = perpage;
        //Deal with numbertoshow
        if (numbertoshow>0){
            limitMin = 0;
            limitMax = numbertoshow;
        }
        //Begin inbox listing
        mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#e6e6e6><font face=arial size=-2 color=#666666>Status</font></td>");
        mb.append("<td bgcolor=#e6e6e6><font face=arial size=-2 color=#666666>Date</font></td>");
        mb.append("<td bgcolor=#e6e6e6><font face=arial size=-2 color=#666666>Subject</font></td>");
        mb.append("<td bgcolor=#e6e6e6><font face=arial size=-2 color=#666666>From</font></td>");
        mb.append("<td bgcolor=#e6e6e6><font face=arial size=-2 color=#666666>Actions</font></td>");
        mb.append("</tr>");
        //Go get inbox items
        //-----------------------------------
        //-----------------------------------
        String[][] rstInbox= Db.RunSQL("SELECT friendmessage.friendmessageid, subject, message, datetime, parentfriendmessageid, isread, friendmessage.accountuserid, friendmessagerecipientid FROM friendmessage, friendmessagerecipient WHERE friendmessagerecipient.accountuserid='"+userSession.getAccountuser().getAccountuserid()+"' AND friendmessagerecipient.friendmessageid=friendmessage.friendmessageid ORDER BY datetime DESC" + " LIMIT "+ limitMin +","+ limitMax);
        //-----------------------------------
        //-----------------------------------
        if (rstInbox!=null && rstInbox.length>0){
            for(int i=0; i<rstInbox.length; i++){
                //Determine isread status
                String isreadtext = "New";
                String isreadcolor = "#e6e6e6";
                if (rstInbox[i][5].equals("1")){
                    isreadtext="Old";
                    isreadcolor = "#ffffff";
                }

                //Format date
                java.util.Calendar cal = reger.core.TimeUtils.gmttousertime(rstInbox[i][3], userSession.getAccountuser().getUsertimezoneid());

                //Create the accountuser
                reger.Accountuser friend = new reger.Accountuser(Integer.parseInt(rstInbox[i][6]), true);


                mb.append("<tr>");
                mb.append("<td bgcolor="+isreadcolor+" valign=top><font face=arial size=-2 color=#666666>"+isreadtext+"</font></td>");
                mb.append("<td bgcolor="+isreadcolor+" valign=top><font face=arial size=-2 color=#666666>"+reger.core.TimeUtils.dateformatcompactwithtime(cal)+"</font></td>");
                mb.append("<td bgcolor="+isreadcolor+" valign=top><font face=arial size=-2 color=#666666><a href='people-message.log?friendmessageid="+rstInbox[i][0]+"'>"+rstInbox[i][1]+"</a></font></td>");
                mb.append("<td bgcolor="+isreadcolor+" valign=top><font face=arial size=-2 color=#666666>");
                mb.append("<img src='"+friend.primaryImage(userSession, true)+"' width=35 border=0 align=top>");
                mb.append(friend.getFriendlyname());
                mb.append("</font></td>");
                mb.append("<td bgcolor="+isreadcolor+" valign=top><font face=arial size=-2 color=#666666><a href='people-inbox.log?action=delete&friendmessagerecipientid="+rstInbox[i][7]+"&currentpage="+request.getParameter("currentpage")+"'>Delete</a>");
                mb.append(" | ");
                if (!rstInbox[i][5].equals("1")){
                    mb.append("<a href='people-inbox.log?action=markread&friendmessagerecipientid="+rstInbox[i][7]+"&currentpage="+request.getParameter("currentpage")+"'>Mark Old</a>");
                } else {
                    mb.append("<a href='people-inbox.log?action=markunread&friendmessagerecipientid="+rstInbox[i][7]+"&currentpage="+request.getParameter("currentpage")+"'>Mark New</a>");
                }
                mb.append("</font></td>");
                mb.append("</tr>");

            }
        }
        mb.append("</table>");
        //End inbox listing
        if (showNavLinks){
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("</table>");
        }

        mb.append(reger.ui.BubbleBox.end(pageProps.pathToAppRoot));


        return mb;
    }

}
