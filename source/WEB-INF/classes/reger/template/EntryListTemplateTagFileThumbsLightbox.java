package reger.template;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagFileThumbsLightbox implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "File.Thumbs.Lightbox";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Thumbnails of files added to this entry.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, reger.Entry entry) {
        return entry.filethumbslightbox.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview.";
    }

}