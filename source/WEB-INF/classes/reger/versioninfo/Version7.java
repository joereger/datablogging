package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version7 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "3.0";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2002-12-21 00:00:00");
    }

    public String getQuickSummary(){
        return "OO Upgrade - The upgrade to OO provided an doubling of performance along with scaling capability to support the growing user base.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
