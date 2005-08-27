package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version11 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "4.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2004-03-21 00:00:00");
    }

    public String getQuickSummary(){
        return "Reger.com Rename and Pro Launch - Site renamed to reger.com. Pro features launched incorporating user feedback.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
