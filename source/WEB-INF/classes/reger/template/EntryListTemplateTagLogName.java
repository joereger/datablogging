package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagLogName implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Log.Name";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The name of the log that a particular entry appears in.";
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
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, reger.Entry entry, int numberOnPage) {
        return logname;
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "My Log";    
    }

}
