package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version20 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "6.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-09-21 00:00:00");
    }

    public String getQuickSummary(){
        return "Downloadable version.  Integrated licensing framework.  Improved caching performance.  Simplified homepages.  New database pooling code.  Import XML schema as Log Type beta.  Numerous bug fixes.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>Unhide dropdown option doesn't appear immediately</li>");
        desc.append("<li>Re-Ordering Options of Custom Fields Error</li>");
        desc.append("<li>Advanced search: skip to logs not working</li>");
        desc.append("<li>Polarhrm Import Data Truncation</li>");
        desc.append("<li>Customized Log Dupe Fields, Funkiness</li>");
        desc.append("<li>NestedNavDisplayVertical.java:75 NPE</li>");
        desc.append("<li>Default image icon not found in production</li>");
        desc.append("<li>Security: Password recovery</li>");
        desc.append("<li>Create Custom Log Type, Auto Log Created Isn't Correct</li>");
        desc.append("<li>Invite to log type broken</li>");
        desc.append("<li>Script Error on file upload page</li>");
        desc.append("<li>Group XML Bug</li>");
        desc.append("<li>Extra Column on Group Discussions Page & Other Funkiness</li>");
        desc.append("<li>Illegal Characters in jdom cause structured data output to fail</li>");
        desc.append("<li>Nestednav failure on log delete</li>");
        desc.append("<li>Linkrot spider nullpointerexception</li>");
        desc.append("<li>More graceful catching of email sends to invalid addresses</li>");
        desc.append("<li>Entry list intermittent array out of bounds error</li>");
        desc.append("<li>Ambiguous accountuserid SQL</li>");
        desc.append("<li>EmailAPI Blank Subject bug</li>");
        desc.append("<li>Author profile page  bug</li>");
        desc.append("<li>Login page error</li>");
        desc.append("<li>Unknown column fieldorder</li>");
        desc.append("<li>NPE in EntryXmlRenderer.java</li>");
        desc.append("<li>Invite to log type broken in certain situations</li>");
        desc.append("<li>Able to get to logs-log-properties.log with logid=-1</li>");
        desc.append("<li>Graph Pulling Data from Old Entries</li>");
        desc.append("<li>LOE Add field link broken</li>");
        desc.append("<li>Page redirect is not valid for Invitation e-mail</li>");
        desc.append("<li>\"Remove this user's special permissions\" doesn't work</li>");
        desc.append("<li>Invitation logs to share</li>");
        desc.append("<li>Invitation acceptance forces Login</li>");
        desc.append("<li>Grey out system log types on invitation page</li>");
        desc.append("<li>NPE on invitation code preventing invitations</li>");
        desc.append("<li>NPE in EntryXmlRenderer.java line 101</li>");
        desc.append("<li>Make log private it stays in nav until next reboot</li>");
        desc.append("<li>Invitation typo</li>");
        desc.append("<li>Advanced search-duplicate entries & entries not showing up</li>");
        desc.append("<li>Tags showing in group entries listing</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Save 404s</li>");
        desc.append("<li>globalheader.jsp and globalfooter.jsp put into compiled object</li>");
        desc.append("<li>Nested Logs</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>EmailApi addresses shortened</li>");
        desc.append("<li>Alphanumeric, numeric, integer (datatype) on megafield html display</li>");
        desc.append("<li>Movetotop to not leave hole in layout</li>");
        desc.append("<li>Linkrot spider made multithreaded</li>");
        desc.append("<li>Location.java shouldn't be populated on every request</li>");
        desc.append("<li>Add formatting capabilities to outgoing invite friends email.</li>");
        desc.append("<li>Field ordering simplified</li>");
        desc.append("<li>Numeric range field to accept numeric type, not integer</li>");
        desc.append("<li>Settings at log level</li>");
        desc.append("<li>Author permission at log level</li>");
        desc.append("<li>Need a \"view authors\" tab</li>");
        desc.append("<li>External links popups</li>");
        desc.append("<li>Combine Friends & People Special Access tabs</li>");
        desc.append("<li>Remove Make User a Friend option on Find People tab</li>");
        desc.append("<li>Can grant authoring permission via invitations</li>");
        desc.append("<li>My Privileges screen includes read/write status for each log</li>");
        desc.append("<li>SnapTo added to datablogging fields layout</li>");
        desc.append("<li>User Settings tab word change</li>");
        desc.append("</ul>");




        return desc.toString();
    }

}
