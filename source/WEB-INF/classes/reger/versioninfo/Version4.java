package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version4 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "1.1";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("1999-01-15 00:00:00");
    }

    public String getQuickSummary(){
        return "Architecture redo - Rebuilt architecture to better deal with maintenance and daily support of an active user base. In short, rebuilt it to make sense... system design is always easier the second time around.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
