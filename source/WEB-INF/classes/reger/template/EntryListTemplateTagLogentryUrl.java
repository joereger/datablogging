package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagLogentryUrl implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Logentry.Url";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "People need a way to get to the details of your log entry. This tag outputs the URL to your log entry detail page. Note: This tag presents just the URL in single quotes. You need to put it inside of an anchor tag. For example: &lt;a href=<$Logentry.Url$>>Click Here&lt;/a>";
    }

    public boolean isRequired(){
        return true;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid) {
        return logentryurl;
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "#logentryurl";    
    }

}
