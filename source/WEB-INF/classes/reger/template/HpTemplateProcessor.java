package reger.template;

import reger.core.Debug;
import reger.pageFramework.PageProps;
import reger.cache.TemplateTagCache;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes Homepage templates
 */
public class HpTemplateProcessor implements TemplateProcessor {

    private static HpTemplateTag[] tags;
    private static String defaultTemplate;

    public int getType(){
        return Template.TEMPLATETYPEHOMEPAGE;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Main Page Template";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This template dictates the layout of the main page of a site or of a log.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-homepage.gif";
    }


  /**
    * tRex is the template engine.  It's robust but fast... like tRex.
    * This version of tRex builds events from templates.
    */
    public static StringBuffer getHtml(String template, reger.UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){
        //Make sure we have a template
        if (template.equals("")) {
            HpTemplateProcessor stp = new HpTemplateProcessor();
            template = stp.getDefaultTemplate();
        }
        //This is the main page output stringbuffer
        StringBuffer en = new StringBuffer();

         // Create a pattern to match cat
        Pattern p = Pattern.compile("\\<\\$(.|\\n)*?\\$\\>");
        // Create a matcher with an input string
        Matcher m = p.matcher(template);
        // Loop through
        while(m.find()) {
            //Go get the tag that can handle this syntax
            HpTemplateTag tag = getTagBySyntax(m.group());
            if (tag!=null){
                m.appendReplacement(en, reger.core.Util.cleanForAppendreplacement(tag.getHtml(userSession, request, pageProps)));
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

    public static HpTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            HpTemplateTag tag = (HpTemplateTag)TemplateTagCache.get(tagSyntax, "HpTemplateTag", tags);
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
        tags = new HpTemplateTag[8];
        tags[0] = new HpTemplateTagFavoriteEntries();
        tags[1] = new HpTemplateTagListOfEntries();
        tags[2] = new HpTemplateTagMostRead7Days();
        tags[3] = new HpTemplateTagMostRecentFiles();
        tags[4] = new HpTemplateTagMostRecentList();
        tags[5] = new HpTemplateTagOnThisDay();
        tags[6] = new HpTemplateTagRandomFiles();
        tags[7] = new HpTemplateTagRandomFilesPolaroid();
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
            HpTemplateTag tag = getTagBySyntax(m.group());
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
            defaultTemplate = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "templates/hp/default/template.html").toString();
        }
        return defaultTemplate;
    }


}
