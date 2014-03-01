package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagLogentryBody implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Logentry.Body";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The main body of your log entry.";
    }

    public boolean isRequired(){
        return true;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, reger.Entry entry, int numberOnPage) {
        return logentrybody;
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "This is the body of a fictional log entry. This is the body of a fictional log entry. This is the body of a fictional log entry. This is the body of a fictional log entry. This is the body of a fictional log entry. This is the body of a fictional log entry.";

    }


}
