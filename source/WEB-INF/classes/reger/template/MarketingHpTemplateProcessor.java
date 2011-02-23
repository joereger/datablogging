package reger.template;

import reger.core.Debug;
import reger.pageFramework.PageProps;
import reger.cache.TemplateTagCache;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes Homepage templates
 */
public class MarketingHpTemplateProcessor implements TemplateProcessor {

    private static MarketingHpTemplateTag[] tags;
    private static String defaultTemplate;


    public int getType(){
        return Template.TEMPLATETYPEMARKETINGHOMEPAGE;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Marketing Site Homepage Template";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This template dictates the layout of the marketing site home page.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-homepage.gif";
    }


  /**
    * tRex is the template engine.  It's robust but fast... like tRex.
    * This version of tRex builds events from templates.
    */
    public static StringBuffer getHtml(reger.UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps, String template){

        //Get the template
        //Template tmpl = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getPl().getMarketingsitehptemplateid(), Template.TEMPLATETYPEMARKETINGHOMEPAGE);
        //if (tmpl!=null){
            //template = tmpl.getTemplate();
        //}


        //Make sure we have a template
        if (template.equals("")) {
            template=defHpTemplate();
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
            MarketingHpTemplateTag tag = getTagBySyntax(m.group());
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

    public static MarketingHpTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            MarketingHpTemplateTag tag = (MarketingHpTemplateTag)TemplateTagCache.get(tagSyntax, "MarketingHpTemplateTag", tags);
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
        tags = new MarketingHpTemplateTag[10];
        tags[0] = new MarketingHpTemplateTagLogInBox();
        tags[1] = new MarketingHpTemplateTagLogTypeList();
        tags[2] = new MarketingHpTemplateTagVersionNumber();
        tags[3] = new MarketingHpTemplateTagEntriesMostRead();
        tags[4] = new MarketingHpTemplateTagEntriesMostReadAllTime();
        tags[5] = new MarketingHpTemplateTagNewestSites();
        tags[6] = new MarketingHpTemplateTagRecentEntries();
        tags[7] = new MarketingHpTemplateTagSitesMostRead();
        tags[8] = new MarketingHpTemplateTagSitesMostReadAllTime();
        tags[9] = new MarketingHpTemplateTagRecentEntriesPlusSummary();
    }

    public TemplateTag[] getTagsThisProcessorCanHandle(){
        if (tags==null){
            loadTags();
        }
        return tags;
    }


    /**
    * A default entry template in case none exists.
    */
    private static String defHpTemplate(){
        return "Welcome.";
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
            MarketingHpTemplateTag tag = getTagBySyntax(m.group());
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
            defaultTemplate = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "templates/marketinghp/default/template.html").toString();
        }
        return defaultTemplate;
    }

   


}
