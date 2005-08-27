package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version14 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-02-14 00:00:00");
    }

    public String getQuickSummary(){
        return "datablogging extended to user level.  Anybody can now create their own custom log type.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>Delete log doesn't delete files and free up space</li>");
        desc.append("<li>Move Up allowed when shouldn't be in form layout engine</li>");
        desc.append("<li>When login on another person's site, redirect to your primary site</li>");
        desc.append("<li>Deleting log, count of existing entries wrong</li>");
        desc.append("<li>myhome/logs-log-permissions.log not working</li>");
        desc.append("<li>myhome/settings-accountuser.log not working when all permissions selected</li>");
        desc.append("<li>navBar Home tab not highlighting</li>");
        desc.append("<li>DB Upgrade from Version 0 to current has some errors</li>");
        desc.append("<li>Persistent login not working under Tomcat 5.5.7, Java 5.0</li>");
        desc.append("<li>Trackback on HTTPS</li>");
        desc.append("<li>Custom skins navButton url broken</li>");
        desc.append("<li>Directory to not show entries from inactive sites</li>");
        desc.append("<li>Preview charts and graphs</li>");
        desc.append("<li>Preview log type</li>");
        desc.append("<li>Remove reger.Vars.templateiddefault</li>");
        desc.append("<li>Activity-specific field borders not displaying in IE</li>");
        desc.append("<li>LOE: edit user template, should create system template</li>");
        desc.append("<li>RSS Not outputting custom field value</li>");
        desc.append("<li>Configure off - create entry not working</li>");
        desc.append("<li>Configure fields appears on public site</li>");
        desc.append("<li>Configure fields button not working on basic log</li>");
        desc.append("<li>Preview template not working from myhome/logs-log-templates.log</li>");
        desc.append("<li>/pl/accountuserdetail.log?accountuserid=XX not displaying username correctly</li>");
        desc.append("<li>Fields with no coordinates can't be brought back onto grid as loe</li>");
        desc.append("<li>LOE Unhide box not showing</li>");
        desc.append("<li>Legacy templates with no names need to be given names</li>");
        desc.append("<li>PL Use This One Template Bombs</li>");
        desc.append("<li>Template switch delayed</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Inbox notification via email</li>");
        desc.append("<li>FieldLayout activity-specific infrastructure</li>");
        desc.append("<li>RSS feeds to output activity-specific data</li>");
        desc.append("<li>Nofollow comment spam reduction tag</li>");
        desc.append("<li>Promote orphaned log type to system log type</li>");
        desc.append("<li>Export template as database SQL statement</li>");
        desc.append("<li>Design one high quality template</li>");
        desc.append("<li>Pl setting to remove reger.com logo</li>");
        desc.append("<li>Choose log templates on log settings page</li>");
        desc.append("<li>Objectize Pl Save on plmanage.log</li>");
        desc.append("<li>Template type: marketingHomepage</li>");
        desc.append("<li>New pl properties</li>");
        desc.append("</ul>");

        desc.append("<h2>Task</h2>");
        desc.append("<ul>");
        desc.append("<li>Check Advanced Search for new megafield/megafielduser issues</li>");
        desc.append("<li>Document megadata rss XML schema</li>");
        desc.append("<li>Remove database table megafieldtype</li>");
        desc.append("<li>Get backup software running on production site</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>New Template System</li>");
        desc.append("<li>Main Admin page speed</li>");
        desc.append("<li>Navtabs css when on small screen</li>");
        desc.append("<li>Account status tab in settings</li>");
        desc.append("<li>Delete log to offer movement to logs of different type, while losing activity-specific data</li>");
        desc.append("<li>Refactor FieldType to represent field data</li>");
        desc.append("<li>When LOE Weblogs.com off, hide site option in Settings tab</li>");
        desc.append("<li>LOE Graphic</li>");
        desc.append("<li>DB: Default pltemplates set for all PLs</li>");
        desc.append("<li>Remove reger.com hardcoded text in Tour, use pl name</li>");
        desc.append("</ul>");


        return desc.toString();
    }

}
