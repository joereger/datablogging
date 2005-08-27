package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagAgoGraphic1 implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Ago.Graphic.1";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A graphical version of the days, weeks, months or years since this entry was made. The images have a white background.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid) {
        //Agotext is based on a GMT date so I must convert from this calendar to a gmt one
        Calendar tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(entrydate, entrydate.getTimeZone().getID(), "GMT");
        return reger.core.TimeUtils.agoGraphicText(tmpCal);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return reger.core.TimeUtils.agoGraphicText(reger.core.TimeUtils.xDaysAgoStart(Calendar.getInstance(), 3));
    }

}
