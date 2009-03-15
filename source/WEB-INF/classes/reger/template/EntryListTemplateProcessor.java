package reger.template;

import reger.core.Debug;
import reger.cache.TemplateTagCache;
import reger.Entry;

import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes Entry List templates
 */
public class EntryListTemplateProcessor implements TemplateProcessor {

    private static EntryListTemplateTag[] tags;
    private static String defaultTemplate;


    public int getType(){
        return Template.TEMPLATETYPEENTRYLIST;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Entry List Template";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This template governs entries as they appear in a list on the homepage. This template can be overridden for each log on your site.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-entlist.gif";
    }

    /**
     * Override so it can be called without an author tag
     */
    public static StringBuffer entryout(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, Entry entry) {
        return entryout(templateentry, entrydate, logentrytitle, logentryurl, logentrybody, logname, imagescount, messagescount, -1, entry);
    }

  /**
    * tRex is the template engine.  It's robust but fast... like tRex.
    * This version of tRex builds events from templates.
    */
    public static StringBuffer entryout(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid, Entry entry) {
        //Make sure we have a template
        if (templateentry.equals("")) {
            EntryListTemplateProcessor enttp = new EntryListTemplateProcessor();
            templateentry=enttp.getDefaultTemplate();
        }
        //This is the main page output stringbuffer
        StringBuffer en = new StringBuffer();

		//Create a utility class to work with
		reger.core.Util util = new reger.core.Util();

         // Create a pattern to match cat
        Pattern p = Pattern.compile("\\<\\$(.|\\n)*?\\$\\>");
        // Create a matcher with an input string
        Matcher m = p.matcher(templateentry);
        // Loop through
        while(m.find()) {
            //Go get the tag that can handle this syntax
            EntryListTemplateTag tag = getTagBySyntax(m.group());
            if (tag!=null){
                m.appendReplacement(en, reger.core.Util.cleanForAppendreplacement(tag.getValue(templateentry, entrydate, logentrytitle, logentryurl, logentrybody, logname, imagescount, messagescount, accountuserid, entry)));
            }

        }
        // Add the last segment
        try{
            m.appendTail(en);
        } catch (Exception e){
            //Do nothing... just null pointer
        }

	    return en;
    }

    public static EntryListTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            EntryListTemplateTag tag = (EntryListTemplateTag)TemplateTagCache.get(tagSyntax, "EntryListTemplateTag", tags);
            if (tag!=null){
                return tag;
            }
        } catch (Exception e){
            Debug.errorsave(e, "");
        }

        //Find a tag that fulfills the incoming syntax
        if (tags!=null){
            for (int i = 0; i < tags.length; i++) {
                if (tags[i]!=null){
                    if (tags[i].acceptsParticularSyntax(tagSyntax)){
                        return tags[i];
                    }
                }
            }
        }



        return null;
    }

    private static void loadTags(){
        tags = new EntryListTemplateTag[13];
        tags[0] = new EntryListTemplateTagLogentryTitle();
        tags[1] = new EntryListTemplateTagLogentryUrl();
        tags[2] = new EntryListTemplateTagLogentryBody();
        tags[3] = new EntryListTemplateTagAgoGraphic1();
        tags[4] = new EntryListTemplateTagAgoText();
        tags[5] = new EntryListTemplateTagAuthor();
        tags[6] = new EntryListTemplateTagImagesCount();
        tags[7] = new EntryListTemplateTagLogentryDatetimeCompact();
        tags[8] = new EntryListTemplateTagLogentryDatetimeExpanded();
        tags[9] = new EntryListTemplateTagLogName();
        tags[10]= new EntryListTemplateTagMessagesCount();
        tags[11]= new EntryListTemplateTagFileThumbs();
        tags[12]= new EntryListTemplateTagFileThumbsLightbox();
    }

    public TemplateTag[] getTagsThisProcessorCanHandle(){
        if (tags==null){
            loadTags();
        }
        return tags;
    }




    public boolean validateTemplate(String template) throws TemplateValidationException{

        String errortext = "";

        for (int i = 0; i < tags.length; i++) {
            if (tags[i].isRequired()){
                if (template.indexOf(tags[i].getSyntax())<1){
                    errortext = errortext + "<$" + tags[i].getSyntax() + "$> is required in this template.<br>";
                }
            }
        }

        if (!errortext.equals("")){
            TemplateValidationException exc = new TemplateValidationException();
            exc.setError(errortext);
            throw(exc);
        }

        return true;
    }

    public String preview(Template template){
        //This is the main page output stringbuffer
        StringBuffer pg = new StringBuffer();

        // Create a pattern to match cat
        Pattern p = Pattern.compile("\\<\\$(.|\\n)*?\\$\\>");
        // Create a matcher with an input string
        Matcher m = p.matcher(template.getTemplate());
        // Loop through
        while(m!=null && m.find()) {


            //Go get the tag that can handle this syntax
            EntryListTemplateTag tag = getTagBySyntax(m.group());
            if (tag!=null){
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getPreview()));
            }


        }
        // Add the last segment
        try{
            m.appendTail(pg);
        } catch (Exception e){
            //Do nothing... just null pointer... there was no tail because a tag was last char
        }

        return pg.toString();
    }

    public String getDefaultTemplate(){
        if (defaultTemplate==null){
            defaultTemplate = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "templates\\entrylist\\default\\template.html").toString();
        }
        return defaultTemplate;
    }




}
