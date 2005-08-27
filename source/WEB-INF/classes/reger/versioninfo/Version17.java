package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version17 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-03-14 00:00:00");
    }

    public String getQuickSummary(){
        return "Episodes allow a relationship to be built between two entries.  Advanced search is united with graphing.  Enhancements to the EmailAPI.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>Typos/better text on /biz/portals.log</li>");
        desc.append("<li>Typos/better test on /biz/telco.log</li>");
        desc.append("<li>Typos on /biz/productscorporateintranet.log</li>");
        desc.append("<li>Advanced Search Date Range</li>");
        desc.append("<li>locations.log NullPointerException</li>");
        desc.append("<li>ClassCastException in EmailAPI</li>");
        desc.append("<li>Data truncation of account.monthlycharge on upgrade</li>");
        desc.append("<li>NPE with entry</li>");
        desc.append("<li>Login on marketing hp doesn't take you to your site</li>");
        desc.append("<li>NPE on saveEpisodes()</li>");
        desc.append("<li>Polarhrm Import Data Truncation</li>");
        desc.append("<li>Invite user to log, password error</li>");
        desc.append("<li>Possible to signup for account with blank password</li>");
        desc.append("<li>Search on number = 8 not working in advanced search</li>");
        desc.append("<li>/about/directory NPE</li>");
        desc.append("<li>graph.log - SpreadsheetDate: Year must be in range 1900 to 9999.</li>");
        desc.append("<li>Login not working across shared custom domains</li>");
        desc.append("<li>Delete Quick login per log</li>");
        desc.append("<li>settings-siteprops.log error saving emailnewsletter on/off</li>");
        desc.append("<li>Signup not accepting password</li>");
        desc.append("<li>Is Signup Enabled Toggle Not Working</li>");
        desc.append("<li>EmailAPI bombing because of cast exception</li>");
        desc.append("<li>Timeperiod html broken</li>");
        desc.append("<li>Public/private radio button broken on /myhome/logs-log-properties.log</li>");
        desc.append("<li>Typo</li>");
        desc.append("<li>EmailApi Error - Missing Start Boundary</li>");
        desc.append("<li>Graph not using saved search as base</li>");
        desc.append("<li>Emailnewsletter to/from reversed</li>");
        desc.append("<li>Advanced Search Bug</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Episodes</li>");
        desc.append("<li>Advanced search united with charting</li>");
        desc.append("<li>Sites list on main admin page</li>");
        desc.append("<li>Site owners can set outbound email address</li>");
        desc.append("<li>Site owners can define newsletter email subject</li>");
        desc.append("<li>EmailAPI Accepts Forwarded Messages/Nested Messages/Attachments</li>");
        desc.append("<li>Business Tab on/off setting for Private Label</li>");
        desc.append("</ul>");

        desc.append("<h2>Task</h2>");
        desc.append("<ul>");
        desc.append("<li>Verify fields chosen for RSS include custom fields</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>Friendly name change shows up after login</li>");
        desc.append("<li>List Groups on Access list</li>");
        desc.append("<li>Added /biz/ content</li>");
        desc.append("<li>SearchEntries.java Optimized</li>");
        desc.append("</ul>");



        return desc.toString();
    }

}
