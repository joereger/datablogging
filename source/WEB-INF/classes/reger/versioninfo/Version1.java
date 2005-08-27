package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version1 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "0.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("1997-07-01 00:00:00");
    }

    public String getQuickSummary(){
        return "Conceptualization - Paper sketches of how personal sites should work to collect personal information into a contextual repository of data.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
