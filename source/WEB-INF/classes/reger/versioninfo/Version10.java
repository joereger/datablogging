package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version10 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "4.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2004-02-10 00:00:00");
    }

    public String getQuickSummary(){
        return "Platform Rebuild - System completely rewritten to run on Java/Tomcat/MySQL. Performance gains via smarter object abstractions. Many new features.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
