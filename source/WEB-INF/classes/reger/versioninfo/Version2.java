package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version2 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "0.4";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("1997-11-01 00:00:00");
    }

    public String getQuickSummary(){
        return "Foundation - First attempts to organize the multitude of thoughts on how to create a personal repository of nostalgia-creating information. It was crude. One log entry page for many log types. Few options or features. But it worked and powered joereger.com.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
