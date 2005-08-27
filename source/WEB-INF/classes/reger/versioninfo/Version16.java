package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version16 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.02";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-02-21 00:00:00");
    }

    public String getQuickSummary(){
        return "Mostly bug fixes.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>ConcurrentModificationException in Field.java</li>");
        desc.append("<li>Can't view logs of same name on /myhome/index.log</li>");
        desc.append("<li>Log delete NullPointerException</li>");
        desc.append("<li>NPE on advanced search</li>");
        desc.append("<li>Error on save field</li>");
        desc.append("<li>Error saving siteProps</li>");
        desc.append("<li>NPE on EntryListTemplateProcessor</li>");
        desc.append("<li>ConcurrentModificationException on saveField</li>");
        desc.append("<li>rss.xml looking for reger/Upload?</li>");
        desc.append("</ul>");

        desc.append("<h2>Task</h2>");
        desc.append("<ul>");
        desc.append("<li>Research stdout.log file size limit</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>NavBars don't need to call database</li>");
        desc.append("<li>Scheduler refactored to use static var for thread</li>");
        desc.append("</ul>");


        return desc.toString();
    }

}
