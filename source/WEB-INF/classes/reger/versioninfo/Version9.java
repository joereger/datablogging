package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version9 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "3.2";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2003-02-21 00:00:00");
    }

    public String getQuickSummary(){
        return "Qlogger Pro Beta - Beta launch of a premium offering called Pro. User feedback collected.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
