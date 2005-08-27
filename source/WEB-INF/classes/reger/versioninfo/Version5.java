package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version5 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "1.2";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2001-03-15 00:00:00");
    }

    public String getQuickSummary(){
        return "Private Label Engine - Added header/footer private labeling features so that others could rebrand the offering as their own.";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
