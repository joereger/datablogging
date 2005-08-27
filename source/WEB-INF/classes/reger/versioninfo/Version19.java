package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version19 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.3";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-05-04 00:00:00");
    }

    public String getQuickSummary(){
        return "The ability to share log types with friends.  Invite people to log types.  Bug fixes.  Caching for performance improvement.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");


        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>/loe/pleventtype.log shows user logs mixed with system logs</li>");
        desc.append("<li>Traffic reporting for images not working</li>");
        desc.append("<li>Save user settings not working</li>");
        desc.append("<li>java.Util.ConcurrentModificationException in HtmlCache</li>");
        desc.append("<li>TrafficHitCache null pointer exception</li>");
        desc.append("<li>/about/signup-log-type-detail.log graph view occassional breakage</li>");
        desc.append("<li>LOE  /loe/pleventtype.log?plid=1 doesn't show default log type properly</li>");
        desc.append("<li>pwHash null pointer</li>");
        desc.append("<li>Null page after login caused by Semicolons in username and/or password</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Build number included in WAR file</li>");
        desc.append("<li>Log type setting: share or not</li>");
        desc.append("<li>/about/signup.log - ability to search for user-created log types</li>");
        desc.append("<li>/about/signup.log - list most popular log types</li>");
        desc.append("<li>/about/signup.log - show that user can create custom log type</li>");
        desc.append("<li>/myhome/logs-newlog.log - ability to search for user-created log types</li>");
        desc.append("<li>/myhome/logs-newlog.log - list most popular log types</li>");
        desc.append("<li>Invite friends to log type</li>");
        desc.append("<li>/myhome/logs-newlog.log - show types of logs that other users have invited you to</li>");
        desc.append("<li>/myhome/logs-newlog.log - show list of log types your friends are using</li>");
        desc.append("<li>Peering relationship between private labels to share data</li>");
        desc.append("<li>On log types that you own, see a list of people using them</li>");
        desc.append("<li>On log types that you own, see entries other people created using it</li>");
        desc.append("<li>Send message to all users who have a log type that you own</li>");
        desc.append("<li>Sysadmin 404 Report</li>");
        desc.append("<li>Sysadmin page traffic report</li>");
        desc.append("<li>Selective Page Caching for improved performance</li>");
        desc.append("<li>Log type summary - display owner of the log type</li>");
        desc.append("<li>Private Label setting - default log type</li>");
        desc.append("<li>Ability to have multiple authors on one account</li>");
        desc.append("<li>Ability to have multiple sites easily managed by one user</li>");
        desc.append("<li>LOE delete errors by string search</li>");
        desc.append("<li>System notification capability for reboots, etc.</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>File type icons for more upload file types</li>");
        desc.append("<li>Account.findAccountid() security increased</li>");
        desc.append("<li>404 Page improvement</li>");
        desc.append("<li>Log Type tied to user, not account</li>");
        desc.append("<li>Protect user data on signup screen for pl's locked down</li>");
        desc.append("<li>Show distinct log types that friends are using, not all</li>");
        desc.append("<li>Graphs limited to 100 points on x-axis for performance</li>");
        desc.append("</ul>");



        return desc.toString();
    }

}
