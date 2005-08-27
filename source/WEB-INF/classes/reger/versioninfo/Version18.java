package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version18 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.2";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-03-28 00:00:00");
    }

    public String getQuickSummary(){
        return "The launch of geo mapping features that allow you to see where your GPS-tagged entries occur on a global map.  These features are currently primitive, but will continue to grow and expand in the coming months.  This version also includes minor bug fixes.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");


        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>Broken links on http://www.reger.com/biz/technology.log</li>");
        desc.append("<li>search.log shows private logs on right hand search summary</li>");
        desc.append("<li>Page titles not working</li>");
        desc.append("<li>EmailApi Problems with Validation</li>");
        desc.append("<li>PolarHRM Graph Occassional Compilation Errors</li>");
        desc.append("<li>/about/features.log NPE</li>");
        desc.append("<li>MegaChartSeries.java possible issue</li>");
        desc.append("<li>Can choose location that shows no entries</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Show Blog Locations on World Map</li>");
        desc.append("<li>Release Notes infrastructure - showing what's changed on the site</li>");
        desc.append("<li>Static Content Pages</li>");
        desc.append("<li>Ability to Nest Logs and Create Navigation Heirarchies</li>");
        desc.append("<li>List locations screen in Admin section</li>");
        desc.append("<li>Edit location screen in Admin section</li>");
        desc.append("<li>Ability to delete a location</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>GPS always on</li>");
        desc.append("<li>Activity-specific should be Data Blogging</li>");
        desc.append("<li>Upgrade charting library to 1.0 pre2</li>");
        desc.append("<li>Admin Home page display cleaned up, more compact</li>");
        desc.append("<li>GPS coords & city, state, zip hidden on public entry when no coords exist</li>");
        desc.append("<li>Link on new entry screen to locations list</li>");
        desc.append("</ul>");


        return desc.toString();
    }

}
