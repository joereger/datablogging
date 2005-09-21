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
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-71'>REGER-71</a>] - Unhide dropdown option doesn't appear immediately</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-254'>REGER-254</a>] - Re-Ordering Options of Custom Fields Error</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-259'>REGER-259</a>] - Advanced search: skip to logs not working</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-265'>REGER-265</a>] - Polarhrm Import Data Truncation</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-399'>REGER-399</a>] - Customized Log Dupe Fields, Funkiness</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-430'>REGER-430</a>] - NestedNavDisplayVertical.java:75 NPE</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-431'>REGER-431</a>] - Default image icon not found in production</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-437'>REGER-437</a>] - Security: Password recovery</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-438'>REGER-438</a>] - Create Custom Log Type, Auto Log Created Isn't Correct</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-441'>REGER-441</a>] - Invite to log type broken</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-444'>REGER-444</a>] - Script Error on file upload page</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-445'>REGER-445</a>] - Group XML Bug</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-446'>REGER-446</a>] - Extra Column on Group Discussions Page & Other Funkiness</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-448'>REGER-448</a>] - Illegal Characters in jdom cause structured data output to fail</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-449'>REGER-449</a>] - Nestednav failure on log delete</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-452'>REGER-452</a>] - Linkrot spider nullpointerexception</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-453'>REGER-453</a>] - More graceful catching of email sends to invalid addresses</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-454'>REGER-454</a>] - Entry list intermittent array out of bounds error</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-455'>REGER-455</a>] - Ambiguous accountuserid SQL</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-456'>REGER-456</a>] - EmailAPI Blank Subject bug</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-458'>REGER-458</a>] - Author profile page  bug</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-459'>REGER-459</a>] - Login page error</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-460'>REGER-460</a>] - Unknown column fieldorder</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-461'>REGER-461</a>] - NPE in EntryXmlRenderer.java</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-462'>REGER-462</a>] - Invite to log type broken in certain situations</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-463'>REGER-463</a>] - Able to get to logs-log-properties.log with logid=-1</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-465'>REGER-465</a>] - Graph Pulling Data from Old Entries</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-467'>REGER-467</a>] - LOE Add field link broken</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-468'>REGER-468</a>] - Page redirect is not valid for Invitation e-mail</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-474'>REGER-474</a>] - \"Remove this user's special permissions\" doesn't work</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-476'>REGER-476</a>] - Invitation logs to share</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-478'>REGER-478</a>] - Invitation acceptance forces Login</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-485'>REGER-485</a>] - Grey out system log types on invitation page</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-486'>REGER-486</a>] - NPE on invitation code preventing invitations</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-487'>REGER-487</a>] - NPE in EntryXmlRenderer.java line 101</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-489'>REGER-489</a>] - Make log private it stays in nav until next reboot</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-491'>REGER-491</a>] - Invitation typo</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-498'>REGER-498</a>] - Advanced search-duplicate entries & entries not showing up</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-511'>REGER-511</a>] - Tags showing in group entries listing</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-27'>REGER-27</a>] - Save 404s</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-29'>REGER-29</a>] - globalheader.jsp and globalfooter.jsp put into compiled object</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-43'>REGER-43</a>] - Nested Logs</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-8'>REGER-8</a>] - EmailApi addresses shortened</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-88'>REGER-88</a>] - Alphanumeric, numeric, integer (datatype) on megafield html display</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-90'>REGER-90</a>] - Movetotop to not leave hole in layout</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-251'>REGER-251</a>] - Linkrot spider made multithreaded</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-405'>REGER-405</a>] - Location.java shouldn't be populated on every request</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-429'>REGER-429</a>] - Add formatting capabilities to outgoing invite friends email.</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-457'>REGER-457</a>] - Field ordering simplified</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-466'>REGER-466</a>] - Numeric range field to accept numeric type, not integer</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-471'>REGER-471</a>] - Settings at log level</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-472'>REGER-472</a>] - Author permission at log level</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-473'>REGER-473</a>] - Need a \"view authors\" tab</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-481'>REGER-481</a>] - External links popups</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-482'>REGER-482</a>] - Combine Friends & People Special Access tabs</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-483'>REGER-483</a>] - Remove Make User a Friend option on Find People tab</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-499'>REGER-499</a>] - Can grant authoring permission via invitations</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-500'>REGER-500</a>] - My Privileges screen includes read/write status for each log</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-501'>REGER-501</a>] - SnapTo added to datablogging fields layout</li>");
        desc.append("<li>[<a href='http://www.reger.com/jira/browse/REGER-504'>REGER-504</a>] - User Settings tab word change</li>");
        desc.append("</ul>");




        return desc.toString();
    }

}
