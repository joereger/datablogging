package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version22 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "6.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2006-02-18 00:00:00");
    }

    public String getQuickSummary(){
        return "Polls on entries.  New file management system.  Groups enhancements.  Login now by email.  Better password recovery.  Tagging improvements brought to entry level.  Import blog entries from RSS and/or MTIMPORT format.  Numerous bug fixes.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");


        desc.append("Version 6.1");

        desc.append("<h2>Bug</h2>\n" +
                "<ul>\n" +
                "<li>WAR Deployment under Tomcat 5.5.7 doesn't find web.xml</li>\n" +
                "<li>Field Layout engine not working properly</li>\n" +
                "<li>Upgrade Rome Library Version</li>\n" +
                "<li>Duplicating entry</li>\n" +
                "<li>Entrykey from Groups not working on password-protected logs</li>\n" +
                "<li>setup04 redirs back to setup03 on downloadable install</li>\n" +
                "<li>Images uploaded through fckeditor appear as profile images</li>\n" +
                "<li>Extra URL Prefix on /myhome/index.log in the sites (right hand nav) section of the page.</li>\n" +
                "<li>Vanessa Display and Typing Issues</li>\n" +
                "<li>/pl/pltemplates.log can't create new pl marketing site template</li>\n" +
                "<li>Broken logo image on /setup/ screens</li>\n" +
                "<li>Main Html List Not Displaying New Entries</li>\n" +
                "<li>PlWrapper on Pro vs. Free vs. Trial</li>\n" +
                "<li>Comment tag not updating after comment submission</li>\n" +
                "<li>html tags from main datablog message are being incorporated into keyword tags</li>\n" +
                "<li>SQL Error unsibscribing from group</li>\n" +
                "<li>EmailApi NPE</li>\n" +
                "<li>Required Fields a Problem with entry-additionalinfo.log</li>\n" +
                "<li>unable to join a group</li>\n" +
                "<li>Email subject link in inbox does not invoke email reader</li>\n" +
                "</ul>\n" +
                "    \n" +
                "<h2>New Feature</h2>\n" +
                "<ul>\n" +
                "<li>ACL extended to give log-level control</li>\n" +
                "<li>Smart robots.txt file</li>\n" +
                "<li>Static content page marketing materials</li>\n" +
                "<li>/about/community.log - Bump directory to top level tab called Community</li>\n" +
                "<li>GPS to support multiple coordinate systems</li>\n" +
                "<li>Change relationship between entries and log types</li>\n" +
                "<li>Links to Graphs on Each Field</li>\n" +
                "<li>Import RSS Feeds as Blog Entries</li>\n" +
                "<li>Import Blog Entries from Movable Type/Type Pad mtimport format</li>\n" +
                "<li>Private Label Banner Serving Capability</li>\n" +
                "<li>Private Label as Content Management Tool</li>\n" +
                "<li>Activation of accounts by email</li>\n" +
                "<li>Password recovery screen</li>\n" +
                "<li>Welcome Email Text</li>\n" +
                "<li>Activation Email Text</li>\n" +
                "<li>Tags at the Private Label /about/ Community Level</li>\n" +
                "</ul>\n" +
                "    \n" +
                "<h2>Task</h2>\n" +
                "<ul>\n" +
                "<li>Why slow login to MySQL?</li>\n" +
                "<li>TriFuel Template</li>\n" +
                "<li>Remove OpenMap code and libraries</li>\n" +
                "</ul>\n" +
                "    \n" +
                "<h2>Improvement</h2>\n" +
                "<ul>\n" +
                "<li>DBCP without JNDI</li>\n" +
                "<li>Back out of user override log types</li>\n" +
                "<li>Find People Search Improved</li>\n" +
                "<li>Customize fields of entry that's already been started.</li>\n" +
                "<li>Auto-grant Admin Home Page and Create Entries ACLs when any authorship capability is granted to a log</li>\n" +
                "<li>Permission, invitation flow for new authors</li>\n" +
                "<li>fckeditor rich text editor library updated</li>\n" +
                "<li>/loe/systemdb.log allow sysadmin to specify dbdrivername</li>\n" +
                "<li>Output Tweek <$Titles.Most.Recent.Entries$></li>\n" +
                "<li>Output Tweek <$Titles.Most.Read.Entries.7.Days$></li>\n" +
                "<li>Output Tweek <$Comments$></li>\n" +
                "<li>Better Support for Install on Ports other than 80</li>\n" +
                "<li>fckeditor rich text editor library updated to Version 2.2</li>\n" +
                "<li>Make URLs linkable in the body of log entries</li>\n" +
                "<li>Email validation improvement</li>\n" +
                "<li>make body text wrap in blogs with data fields (e.g. movie reviews) so users don't have to scroll horizontally to read a blog post</li>\n" +
                "<li>/tag-detail.log - Sizing of tags</li>\n" +
                "<li>On tag listings, order alphabetically</li>\n" +
                "<li>Community-entries.log to not display future entries</li>\n" +
                "</ul>");





        return desc.toString();
    }

}
