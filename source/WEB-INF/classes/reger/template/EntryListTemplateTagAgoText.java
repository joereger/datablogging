package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagAgoText implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Ago.Text";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Hours, Days, Weeks or Years since this log entry was made. Sample output: 3 Days Ago.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid) {
        //Agotext is based on a GMT date so I must convert from this calendar to a gmt one
        Calendar tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(entrydate, entrydate.getTimeZone().getID(), "GMT");
        return reger.core.TimeUtils.agoText(tmpCal);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return reger.core.TimeUtils.agoText(reger.core.TimeUtils.xDaysAgoStart(Calendar.getInstance(), 3));
    }

}
