package reger.versioninfo;

import java.util.Calendar;

/**
 * A version
 */
public class Version13 implements Version{

    public String getVersionName(){
        //The text "Version " is automatically pre-pended
        return "4.3";
    }

    public Calendar getDeploymentDateGMT(){
        return reger.core.TimeUtils.dbstringtocalendar("2004-08-15 00:00:00");
    }

    public String getQuickSummary(){
        return "Enhancements - Numerous features based on user feedback. Spell check of entries. Moderator approval capability. Rebuild of private labeling infrastructure. Database self-updater, plugin architecture and the ability to run without wildcard DNS entries all point to the near future... a downloadable/distributable version of Reger.com!";
    }

    public String getDescription(){
        StringBuffer desc = new StringBuffer();
        desc.append("");
        return desc.toString();
    }

}
