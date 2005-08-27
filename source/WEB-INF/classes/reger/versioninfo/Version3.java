package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version3 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "1.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("1998-06-01 00:00:00");
    }

    public String getQuickSummary(){
        return "Initial public build - Implemented core features of web logging and activity-specific log types, launching to the public for the first time.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
