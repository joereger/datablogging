package reger;

import reger.core.db.Db;

/**
 * AdminTools class
 */
public class AdminTools {

    public static StringBuffer getHtml(reger.UserSession userSession, int logid, int eventid){
        StringBuffer mb = new StringBuffer();

        if (userSession.getAccount().isPro()){
            mb.append("<style type=text/css>");
            mb.append("<--");
            mb.append(".admintoolslink:link {color:#0000ff; text-decoration:none;}");
            mb.append(".admintoolslink:active {color:#0000ff; text-decoration:underline;}");
            mb.append(".admintoolslink:visited {color:#0000ff; text-decoration:none;}");
            mb.append(".admintoolslink:hover {color: #ff0000; text-decoration:underline; background-color: #ffffff;}");
            mb.append(".admintoolstext {color:#000000; text-decoration:none;}");
            mb.append("-->");
            mb.append("<style></style>");

            mb.append("<table width=100% cellpadding=0 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=4><img src=clear.gif width=1 height=5></td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#ffcc00 colspan=3><font face=arial size=-2 style=\"font-size: 14px;\" class=admintoolstext>");
            mb.append("<strong><a href='myhome/index.log'>My Home Admin</a>Tools</strong></font>");
            mb.append(" <font face=arial size=-2 style=\"font-size: 9px;\" class=admintoolstext>This only appears when you're logged-in.  People who visit your site won't see it.</font>");
            mb.append("</td>");
            mb.append("<td bgcolor=#ffcc00 colspan=1 align=right>");
            mb.append("<font face=arial size=-2 style=\"font-size: 9px;\" class=admintoolstext>");
            //mb.append("Hide AdminTools ");
            //@!todo Implement toggle AdminTools
            //mb.append("<a href='' class=admintoolslink>");
            //mb.append("[X]");
            //mb.append("</a>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("<tr>");
            mb.append("<td bgcolor=#999999 colspan=4><img src=clear.gif width=1 height=1></td>");
            mb.append("</tr>");

            mb.append("<tr>");

            mb.append("<td bgcolor=#e6e6e6 valign=top rowspan=2><font face=arial size=-2 style=\"font-size: 12px;\" class=admintoolstext>");
            mb.append("<strong>Site Actions:</strong><br>");
            mb.append("<a href='myhome/settings-siteprops.log?returntoadmintools=1' class=admintoolslink>Super-Important Properties</a><br>");
            mb.append("<a href='myhome/settings-template-main.log?returntoadmintools=1' class=admintoolslink>Change Site Template/Skin</a><br>");
            mb.append("<a href='myhome/logs-newlog.log' class=admintoolslink>Add a New Log</a><br>");
            //@todo Build a count like 4 Unapproved Messages
            mb.append("<a href='myhome/traffic-messages.log?view=messages' class=admintoolslink>Reader Messages</a><br>");
            //@!todo Verify this invite a friend link once invite a friend functionality is built
            mb.append("<a href='myhome/inviteafriend.log' class=admintoolslink>Invite a Friend</a><br>");
            if (userSession.getAccount().isPro()){
                mb.append("<a href='myhome/accountstatus.log' class=admintoolslink>Remove Ads by Upgrading</a><br>");
            }
            mb.append("</font></td>");


            mb.append("<td bgcolor=#e6e6e6 valign=top rowspan=2><font face=arial size=-2 style=\"font-size: 12px;\" class=admintoolstext>");
            mb.append("<strong>Log Actions:</strong><br>");
            if (logid>0){
                mb.append("<a href='myhome/entry.log?logid="+logid+"&action=add&returntoadmintools=1' class=admintoolslink>Add Entry to This Log</a><br>");
                mb.append("<a href='myhome/logs-log-properties.log?logid="+logid+"&returntoadmintools=1' class=admintoolslink>Edit This Log's Security</a><br>");
                mb.append("<a href='myhome/logs-log-properties.log?logid="+logid+"&returntoadmintools=1' class=admintoolslink>Edit This Log's Title</a><br>");
                mb.append("<a href='myhome/traffic.log' class=admintoolslink>View Log Traffic</a><br>");
                //@!todo Verify this log delete link once log delete functionality is built
                mb.append("<a href='myhome/logs-log-delete.log?logid="+logid+"' class=admintoolslink>Delete This Log</a><br>");
            } else {
                mb.append("No Log Chosen.");
            }
            mb.append("</font></td>");

            mb.append("<td bgcolor=#e6e6e6 valign=top rowspan=2><font face=arial size=-2 style=\"font-size: 12px;\" class=admintoolstext>");
            mb.append("<strong>Entry Actions:</strong><br>");
            if (eventid>0){
                mb.append("<a href='myhome/entry.log?eventid="+eventid+"&action=edit&returntoadmintools=1' class=admintoolslink>Edit This Entry</a><br>");
                mb.append("<a href='myhome/entry-addmedia.log?eventid="+eventid+"' class=admintoolslink>Add Images to This Entry</a><br>");
                mb.append("<a href='myhome/traffic-entry-zoom.log?eventid="+eventid+"' class=admintoolslink>View Entry Traffic History</a><br>");
                //@!todo Verify this entry delete link once entry delete functionality is built
                mb.append("<a href='myhome/entry-delete.log?eventid="+eventid+"' class=admintoolslink>Delete This Entry</a><br>");
            } else {
                mb.append("No Entry Chosen.");
            }
            mb.append("</font></td>");

            mb.append("<form action='myhome/entry.log' method=get style=\"padding: 0px;\">");
            mb.append("<td bgcolor=#e6e6e6 valign=top><font face=arial size=-2 style=\"font-size: 12px;\" class=admintoolstext>");
            mb.append("<strong>Add Entry To:</strong><br>");
            mb.append("<input type=hidden name=action value=add>");
            mb.append("<input type=hidden name=returntoadmintools value=1>");
            mb.append("<select name=logid style=\"font-size: 12px;\">");
            //Only display logs that an accountuser explicitly has access to... in other words, an account owner may want to create a contributor who can't contribute to a particular public log.
            String sql = "SELECT logid, name, eventtypeid, logaccess, (SELECT max(date) FROM event WHERE megalog.logid=event.logid) as lastentry, (SELECT count(*) FROM event WHERE megalog.logid=event.logid) as totalentries FROM megalog WHERE accountid='"+ userSession.getAccount().getAccountid() +"' AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" ORDER BY name ASC";

            //-----------------------------------
            //-----------------------------------
            String[][] rstLogs= Db.RunSQL(sql);
            //-----------------------------------
            //-----------------------------------
            if (rstLogs!=null && rstLogs.length>0){
                for(int i=0; i<rstLogs.length; i++){
                    mb.append("<option value='"+rstLogs[i][0]+"'>"+reger.core.Util.truncateString(rstLogs[i][1], 15)+"</option>");
                }
            }
            mb.append("</select>");
            mb.append("<input type=submit value='Add' style=\"font-size: 12px;\">");
            mb.append("</td>");
            mb.append("</form>");
            mb.append("</tr>");


            mb.append("<tr>");
            mb.append("<form action='myhome/entry.log' method=get>");
            mb.append("<td bgcolor=#e6e6e6 valign=top><font face=arial size=-2 style=\"font-size: 12px;\" class=admintoolstext>");
            mb.append("<strong>Last 15 Entries:</strong><br>");
            mb.append("<input type=hidden name=action value=edit>");
            mb.append("<input type=hidden name=returntoadmintools value=1>");
            mb.append("<select name=eventid style=\"font-size: 12px;\">");
            //-----------------------------------
            //-----------------------------------
            String[][] rstLastentries= reger.core.db.Db.RunSQL("SELECT eventid, title FROM event, megalog WHERE event.accountid='"+ userSession.getAccount().getAccountid() +"' AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid())+" ORDER BY date DESC LIMIT 0,15");
            //-----------------------------------
            //-----------------------------------
            if (rstLastentries!=null && rstLastentries.length>0){
                for(int i=0; i<rstLastentries.length; i++){
                    mb.append("<option value='"+rstLastentries[i][0]+"'>"+reger.core.Util.truncateString(rstLastentries[i][1], 15)+"</option>");
                }
            }
            mb.append("</select>");
            mb.append("<input type=submit value='Edit' style=\"font-size: 12px;\">");
            mb.append("</font></td>");
            mb.append("</form>");


            mb.append("</tr>");


            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=4><img src=clear.gif width=1 height=1></td>");
            mb.append("</tr>");



            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=4 align=center>");
            mb.append("<font face=arial size=-2 style=\"font-size: 10px; color: #ffffff\">");
            mb.append("<b>");
            mb.append("--- Site Visitors Only See What's Below This Line ---");
            mb.append("</b>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");


            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=4><img src=clear.gif width=1 height=1></td>");
            mb.append("</tr>");

            mb.append("</table>");
        }

        return mb;
    }

}
