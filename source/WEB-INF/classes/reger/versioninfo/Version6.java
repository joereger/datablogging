package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version6 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "2.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2002-06-12 00:00:00");
    }

    public String getQuickSummary(){
        return "Template Engine - Rich templating engine was implemented allowing users to completely customize their site to their own taste. This effort involved upgrading every line of code in the system.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
