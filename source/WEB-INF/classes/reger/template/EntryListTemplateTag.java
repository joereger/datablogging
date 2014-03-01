package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Entry;

import java.util.Calendar;

/**
 * A single tag element that users can put onto the page somewhere
 */
public interface EntryListTemplateTag extends TemplateTag{


    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, Entry entry, int numberOnPage);


}
