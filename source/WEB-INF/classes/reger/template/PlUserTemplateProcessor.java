package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.HtmlParser;
import reger.cache.TemplateTagCache;
import reger.core.Debug;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes the Site Templates
 */
public class PlUserTemplateProcessor implements TemplateProcessor {

    private static PlUserTemplateTag[] tags;
    private static String defaultTemplate;

    public int getType(){
        return Template.TEMPLATETYPEPLUSER;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Private Label User Template Wrapper";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This template is used by the private label to wrap all user sites in a common look and feel.  It is wrapped outside of whatever users create as their site template.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-site.gif";
    }

    public static StringBuffer getValue(StringBuffer mb, UserSession userSession, PageProps pageProps, javax.servlet.http.HttpServletRequest request) {
        reger.core.Debug.debug(5, "PlUserTemplateProcessor.java", "PlUserTemplateProcessor.getValue() called.");
        if ((!userSession.getAccount().isPro()) || (userSession.getAccount().isPro() && userSession.getPl().getDoapplyplusertemplatetopro())){
            reger.core.Debug.debug(5, "PlUserTemplateProcessor.java", "Attempting to apply template.");
            //Get the template string to use
            String templateMainBody="";

            //Use the template from the object
            if (userSession.getPl()!=null && userSession.getPl().getPlid()>0 && userSession.getPl().getPlusertemplateid()>0){
                templateMainBody= AllTemplatesInSystem.getTemplateByTemplateid(userSession.getPl().getPlusertemplateid(), Template.TEMPLATETYPEPLUSER).getTemplate();
            }
            if (templateMainBody==null || templateMainBody.equals("")){
                PlUserTemplateProcessor stp = new PlUserTemplateProcessor();
                templateMainBody = stp.getDefaultTemplate();
            }

            reger.core.Debug.debug(5, "PlUserTemplateProcessor.java", "templateMainBody:<br>"+templateMainBody.replaceAll("<", "&lt;") + "<br>mb.toString():"+mb.toString().replaceAll("<", "&lt;"));


            //Here's where I need to combing head contents and body contents
            //mb holds the site template contents
            //templateMainBody holds the plusertemplate
            templateMainBody = HtmlParser.combineTagContentFromTwoHtmlDocs(templateMainBody, mb.toString(), "head");
            templateMainBody = HtmlParser.combineTagContentFromTwoHtmlDocs(templateMainBody, mb.toString(), "title");
            templateMainBody = HtmlParser.combineTagAttributesForOneTagFromTwoHtmlDocs(templateMainBody, mb.toString(), "body");

            //This is the main page output stringbuffer
            StringBuffer pg = new StringBuffer();

            // Create a pattern to match cat
            //Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)");
            Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>)");
            // Create a matcher with an input string
            Matcher m = p.matcher(templateMainBody);
            // Loop through
            while(m!=null && m.find()) {
                PlUserTemplateTag tag = getTagBySyntax(m.group());
                if (tag!=null){
                    StringBuffer bodyOfPage = new StringBuffer(HtmlParser.getContentsOfHtmlTag(mb.toString(), "body"));
                    if (bodyOfPage.toString().equals("")){
                        bodyOfPage = mb;
                    }
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getValue(bodyOfPage, pageProps, userSession, request)));
                }
            }
            // Add the last segment
            try{
                m.appendTail(pg);
            } catch (Exception e){
                //Do nothing... just null pointer... there was no tail because a tag was last char
            }

            //Return the page
            return pg;

        } else {
            return mb;
        }


    }


    public static PlUserTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            PlUserTemplateTag tag = (PlUserTemplateTag)TemplateTagCache.get(tagSyntax, "PlUserTemplateTag", tags);
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

    public TemplateTag[] getTagsThisProcessorCanHandle(){
        if (tags==null){
            loadTags();
        }
        return tags;
    }

    private static void loadTags(){
        tags = new PlUserTemplateTag[4];
        tags[0] = new PlUserTemplateTagUserSite();
        tags[1] = new PlUserTemplateTagBannerOne();
        tags[2] = new PlUserTemplateTagBannerTwo();
        tags[3] = new PlUserTemplateTagBannerThree();

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
        //Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)");
        Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>)");
        // Create a matcher with an input string
        Matcher m = p.matcher(template.getTemplate());
        // Loop through
        while(m!=null && m.find()) {


            //Go get the tag that can handle this syntax
            PlUserTemplateTag tag = getTagBySyntax(m.group());
            if (tag!=null){
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getPreview()));
            } else {
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group()));
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
            defaultTemplate = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "templates\\pluser\\default\\template.html").toString();
        }
        return defaultTemplate;
    }






}
