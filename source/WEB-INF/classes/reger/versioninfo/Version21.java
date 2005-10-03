package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version21 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "6.0.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-10-03 00:00:00");
    }

    public String getQuickSummary(){
        return "Choose latitude/longitude easily with graphical map.  New site template tags. Minor bug fixes.  Improvements in downloadable installer.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");


        desc.append("Version Version 6.0.1");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>New dropdown field already has options</li>");
        desc.append("<li>Location Appears Multiple Times in list</li>");
        desc.append("<li>Search to pagenotfound</li>");
        desc.append("<li>www vs nothing</li>");
        desc.append("<li>Joel's Posting Problem</li>");
        desc.append("<li>Spellcheck not working</li>");
        desc.append("<li>LOE plmanage.log NPE</li>");
        desc.append("<li>NPE in TimeUtils.agoText()</li>");
        desc.append("<li>TrafficHitCache NPE</li>");
        desc.append("<li>LOE pltemplates.log</li>");
        desc.append("<li>Public sites sometimes show unapproved trackback spam</li>");
        desc.append("<li>Locations occassionally being saved with accountid=0</li>");
        desc.append("<li>Old trackbacks still showing on admin homepage after disabling</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Java Caching Mechanism</li>");
        desc.append("<li>Ten New Site Template Tags</li>");
        desc.append("<li>Choose lat/lon for a location graphically with map</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>Create uploadmedia directory if it doesn't exist</li>");
        desc.append("<li>Trackback configurable at pl level</li>");
        desc.append("<li>Linkrot fixer controlled at server level with system property</li>");
        desc.append("</ul>");





        return desc.toString();
    }

}
