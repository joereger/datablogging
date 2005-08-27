package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version15 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "5.01";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2005-02-16 00:00:00");
    }

    public String getQuickSummary(){
        return "Quick fixes per user feedback.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");

        desc.append("<h2>Bug</h2>");
        desc.append("<ul>");
        desc.append("<li>htmlListEvents not working with Hide from Homepage</li>");
        desc.append("<li>Save chart with name not working</li>");
        desc.append("<li>No Handler found for templateFactory</li>");
        desc.append("<li>http://reger.com/biz broken</li>");
        desc.append("<li>Marketing navBar links not working in /biz</li>");
        desc.append("<li>Can't create new private label with same plbaseurl as another</li>");
        desc.append("<li>Private label on subdomain not found</li>");
        desc.append("<li>qlogger.pltemplate' doesn't exist error</li>");
        desc.append("<li>plmanage.log Content moderation boxes not working</li>");
        desc.append("<li>Content flagging/moderation not working</li>");
        desc.append("<li>/pl/entryapproval-viewentry.log goes boomps</li>");
        desc.append("</ul>");

        desc.append("<h2>New Feature</h2>");
        desc.append("<ul>");
        desc.append("<li>Need a secondary customdomain</li>");
        desc.append("</ul>");

        desc.append("<h2>Improvement</h2>");
        desc.append("<ul>");
        desc.append("<li>Domains to accept (and ignore) www prefix</li>");
        desc.append("<li>Icons demonstrating each template type</li>");
        desc.append("</ul>");



        return desc.toString();
    }

}
