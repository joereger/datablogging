package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.cache.TemplateTagCache;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Processes the Site Templates
 */
public class SiteTemplateProcessor implements TemplateProcessor {

    private static SiteTemplateTag[] tags;
    private static String defaultTemplate;

    public int getType(){
        return Template.TEMPLATETYPESITE;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Site Template";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This is the template that determines the general look of your site.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-site.gif";
    }

    public static StringBuffer getValue(StringBuffer mb, StringBuffer sc, UserSession userSession, PageProps pageProps, javax.servlet.http.HttpServletRequest request) {

        //Setup some vars and defaults
        String homepagetitle="My Site";
        String homepagehtml="";

        reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "Made it to SiteTemplateProcessor.");

        if (userSession.getAccount().getHomepagetitle()!=null && !userSession.getAccount().getHomepagetitle().equals("")) {
            homepagetitle=userSession.getAccount().getHomepagetitle();
        }

        if (userSession.getAccount().getHomepagehtml()!=null && !userSession.getAccount().getHomepagehtml().equals("")) {
            homepagehtml=userSession.getAccount().getHomepagehtml();
        }


        //Get the template string to use
        String templateMainBody="";

        //Use the template from the object
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            templateMainBody=reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getAccount().getSitetemplateid(), Template.TEMPLATETYPESITE).getTemplate();
        }
        if (templateMainBody==null || templateMainBody.equals("")){
            SiteTemplateProcessor stp = new SiteTemplateProcessor();
            templateMainBody = stp.getDefaultTemplate();
        }


        //Figure out what AdminTools and LoggedInBar look like
        StringBuffer appendToHead = new StringBuffer();

        //Base URL
        appendToHead.append("<base href=\"/\"><!--[if lte IE 6]></base><![endif]-->"+"\n");



        //jQuery
        appendToHead.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/jQuery/js/jquery-1.9.1.min.js\"></script>"+"\n");
        appendToHead.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/jQuery/js/jquery-ui-1.8.18.custom.min.js\"></script>"+"\n");
        appendToHead.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"js/jQuery/css/smoothness/jquery-ui-1.8.18.custom.css\" type=\"text/css\" />"+"\n");


        //Twitter Bootstrap
        appendToHead.append("<link href=\""+pageProps.pathToAppRoot+"js/bootstrap-3.1.1-dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
        appendToHead.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>"+"\n");


        //prettyPhoto
        appendToHead.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"js/prettyPhoto3.1.5/css/prettyPhoto.css\" type=\"text/css\" />"+"\n");
        appendToHead.append("<script type=\"text/javascript\" src=\""+pageProps.pathToAppRoot+"js/prettyPhoto3.1.5/js/jquery.prettyPhoto.js\"></script>"+"\n");


        //Slides
        //appendToHead.append("<script src=\""+pageProps.pathToAppRoot+"js/slides/js/slides.min.jquery.js\"></script>");



        //Canonical
        appendToHead.append(appendCanonicalToHead(userSession, request));


        StringBuffer appendToTopOfPage = new StringBuffer();


        //Append just before close body
        StringBuffer appendToBottomOfPage = new StringBuffer();



        appendToBottomOfPage.append("<script type=\"text/javascript\" charset=\"utf-8\">\n" +
                "  $(document).ready(function(){\n" +
                "    $(\"a[rel^='prettyPhoto']\").prettyPhoto();\n" +
                "  });\n" +
                "</script>");




        //Whether or not we've found a body tag yet
        boolean foundbodytag = false;
        boolean foundclosebodytag = false;
        boolean foundheadtag = false;

        //This is the main page output stringbuffer
        StringBuffer pg = new StringBuffer();

        // Create a pattern to match
        String flag1 = String.valueOf(Pattern.CASE_INSENSITIVE);
        String flag2 = String.valueOf(Pattern.DOTALL);
        String allFlags = flag1+flag2;
        int allFlagsAsInt = Integer.parseInt(allFlags);
        //Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)", allFlagsAsInt);
        //Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.*?)\\>|\\<head(.*?)\\>|\\<\\/body>|\\<\\/head>)", allFlagsAsInt);
        Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.*?)\\>|\\<head(.*?)\\>|\\</body(.*?)\\>)", allFlagsAsInt);
        // Create a matcher with an input string
        Matcher m = p.matcher(templateMainBody);
        // Loop through
        while(m!=null && m.find()) {

            if (m.group().substring(0,5).equalsIgnoreCase("<body") || m.group().substring(0,6).equalsIgnoreCase("< body")) {
                //Body tag
                foundbodytag = true;
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group() + appendToTopOfPage.toString()));
            } else if (m.group().substring(0,6).equalsIgnoreCase("</body")) {
                //Just before close body tag
                foundclosebodytag = true;
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(appendToBottomOfPage.toString() + m.group()));
            } else if (m.group().substring(0,5).equalsIgnoreCase("<head") || m.group().substring(0,6).equalsIgnoreCase("< head")) {
                //Head tag
                foundheadtag = true;
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group() + appendToHead));
            } else {
                //Go get the tag that can handle this syntax
                SiteTemplateTag tag = getTagBySyntax(m.group());
                if (tag!=null){
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getValue(mb, sc, pageProps, userSession, request)));
                } else {
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group()));
                }
            }

        }
        // Add the last segment
        try{
            m.appendTail(pg);
        } catch (Exception e){
            //Do nothing... just null pointer... there was no tail because a tag was last char
        }

        //If no body tag was found we should put admintools on top of the stringbuffer
        if (!foundbodytag){
            //Append AdminTools
            StringBuffer tmp = new StringBuffer();
            tmp.append(appendToTopOfPage);
            tmp.append(pg);
            pg = tmp;
        }

        //If no body tag was found we should put admintools on top of the stringbuffer
        if (!foundheadtag){
            //Append AdminTools
            StringBuffer tmp = new StringBuffer();
            tmp.append("<head>"+appendToHead+"</head>");
            tmp.append(pg);
            pg = tmp;
        }

        //If no close body tag was found we should put stuff onto bottom of the stringbuffer
        if (!foundclosebodytag){
            //Append AdminTools
            StringBuffer tmp = new StringBuffer();
            tmp.append(pg);
            tmp.append(appendToBottomOfPage);
            pg = tmp;
        }

        //Wrap in a plusertemplate
        pg = wrapInPlUserTemplate(pg, pageProps, userSession, request);

        //Return the page
        reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "Leaving SiteTemplateProcessor.");
	    return pg;

    }

    public static String appendCanonicalToHead(UserSession userSession, javax.servlet.http.HttpServletRequest request){
        String out = "";
        //userSession.getUrlSplitter().getRequest_uri();
        return out;
    }


    public static SiteTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "In getTagBySyntax("+tagSyntax.replaceAll("<", "&lt;")+")");

        //Try the cache
        try{
            SiteTemplateTag tag = (SiteTemplateTag)TemplateTagCache.get(tagSyntax, "SiteTemplateTag", tags);
            if (tag!=null){
                reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "Returning tag from cache.");
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
                        reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "Returning tag by finding it in tag array.");
                        return tags[i];
                    }
                }
            }
        }
        reger.core.Debug.debug(5, "SiteTemplateProcessor.java", "Returning null.");
        return null;
    }

    public TemplateTag[] getTagsThisProcessorCanHandle(){
        if (tags==null){
            loadTags();
        }
        return tags;
    }

    private static void loadTags(){
        tags = new SiteTemplateTag[26];
        tags[0] = new SiteTemplateTagEntryTitle();
        tags[1] = new SiteTemplateTagLogName();
        tags[2] = new SiteTemplateTagMainBody();
        tags[3] = new SiteTemplateTagNavbarHorizontal();
        tags[4] = new SiteTemplateTagNavbarVertical();
        tags[5] = new SiteTemplateTagSiteDescription();
        tags[6] = new SiteTemplateTagSiteName();
        tags[7] = new SiteTemplateTagFavoriteEntries();
        tags[8] = new SiteTemplateTagMostRead7Days();
        tags[9] = new SiteTemplateTagMostRecentFiles();
        tags[10] = new SiteTemplateTagMostRecentList();
        tags[11] = new SiteTemplateTagRandomFiles();
        tags[12] = new SiteTemplateTagQuickStats();
        tags[13] = new SiteTemplateTagSmallCalendar();
        tags[14] = new SiteTemplateTagOnThisDay();
        tags[15] = new SiteTemplateTagBlogroll();
        tags[16] = new SiteTemplateTagComments();
        tags[17] = new SiteTemplateTagSearchBox();
        tags[18] = new SiteTemplateTagEmailSubscribe();
        tags[19] = new SiteTemplateTagGraphs();
        tags[20] = new SiteTemplateTagRssXmlLink();
        tags[21] = new SiteTemplateTagWapLink();
        tags[22] = new SiteTemplateTagNavLogsAndPages();
        tags[23] = new SiteTemplateTagAboutThisBlog();
        tags[24] = new SiteTemplateTagInfoNavbar();
        tags[25] = new SiteTemplateTagBackgroundSlideshow();
    }




    private static String appendRssAutodiscovery(reger.UserSession userSession){
        String autodiscovery = "";
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            String title = "RSS";
            if (userSession.getAccount().getHomepagetitle()!=null && !userSession.getAccount().getHomepagetitle().equals("")){
                title = userSession.getAccount().getHomepagetitle();
            }

            autodiscovery = "<link rel=\"alternate\" type=\"application/rss+xml\" title=\""+reger.core.Util.cleanForHtml(title)+"\" href=\""+userSession.getAccount().getSiteRootUrl(userSession)+"/rss.xml\">";
        }
        return autodiscovery;
    }

    /**
     * Wrap in a plusertemplate
     */
    public static StringBuffer wrapInPlUserTemplate(StringBuffer pageHtml, reger.pageFramework.PageProps pageProps, reger.UserSession userSession, HttpServletRequest request){

        PlUserTemplateProcessor proc = new PlUserTemplateProcessor();
        return proc.getValue(pageHtml, userSession, pageProps, request);

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
            SiteTemplateTag tag = getTagBySyntax(m.group());
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
            defaultTemplate = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "templates/site/default/template.html").toString();
        }
        return defaultTemplate;
    }




}
