package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version12 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "4.2";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2004-04-12 00:00:00");
    }

    public String getQuickSummary(){
        return "Social Networking - Personal profile and social networking features added.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
