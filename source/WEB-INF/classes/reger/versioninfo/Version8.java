package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version8 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "3.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2003-01-27 00:00:00");
    }

    public String getQuickSummary(){
        return "APIs - Launch of metaWeblogAPI, BloggerAPI, XML-RPC and WAP APIs.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
