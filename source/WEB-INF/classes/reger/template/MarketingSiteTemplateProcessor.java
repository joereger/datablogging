package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.Debug;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes the Site Templates
 */
public class MarketingSiteTemplateProcessor implements TemplateProcessor {

    private static MarketingSiteTemplateTag[] tags;

    public int getType(){
        return Template.TEMPLATETYPEMARKETINGSITE;
    }

    public String getNameOfTypeOfTemplatesThisHandles(){
        return "Marketing Site Template";
    }

    public String getDescriptionOfTypeOfTemplatesThisHandles(){
        return "This is the template that determines the general look of this private label's marketing site.";
    }

    public String getNameOfIconShowingHowTemplateWorks(){
        return "templatetype-icon-site.gif";
    }

    public static StringBuffer getValue(StringBuffer mb, UserSession userSession, PageProps pageProps, javax.servlet.http.HttpServletRequest request) {



        //Go get the template
        String templateMainBody = "";
        Template tmpl =AllTemplatesInSystem.getTemplateByTemplateid(userSession.getPl().getMarketingsitetemplateid(), Template.TEMPLATETYPEMARKETINGSITE);
        if (tmpl!=null){
            templateMainBody = tmpl.getTemplate();
        }

        //If the template is blank, go get the default.
        if (templateMainBody.equals("")){
            MarketingSiteTemplateProcessor stp = new MarketingSiteTemplateProcessor();
            templateMainBody = stp.getDefaultTemplate();
        }


        //Figure out what AdminTools and LoggedInBar look like
        StringBuffer appendToTop = new StringBuffer();
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/nav.css\" type=\"text/css\" />");
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/cssobjectlayouts.css\" type=\"text/css\" />");
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/style.css\" type=\"text/css\" />");
        if (userSession.getAccountuser().getIsLoggedIn()){
            appendToTop.append(reger.LoggedInBar.getHtml(userSession, pageProps));
            if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccount().getAdmintools()==1 && userSession.getAccountuser().getAccountid()==userSession.getAccount().getAccountid()){
                appendToTop.append(reger.AdminTools.getHtml(userSession, pageProps.logProps.logid, pageProps.entry.eventid));
            }
        }


        //Whether or not we've found a body tag yet
        boolean foundbodytag = false;

        //We'll need a navbar object
        //reger.navBars navBars = new reger.navBars();

        //This is the main page output stringbuffer
        StringBuffer pg = new StringBuffer();

        // Create a pattern to match cat
        Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)");
        // Create a matcher with an input string
        Matcher m = p.matcher(templateMainBody);
        // Loop through
        while(m!=null && m.find()) {

            if (m.group().substring(0,5).equalsIgnoreCase("<body") || m.group().substring(0,6).equalsIgnoreCase("< body")) {
                //Body tag
                foundbodytag = true;
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group() + appendToTop.toString()));
            } else {
                //Go get the tag that can handle this syntax
                MarketingSiteTemplateTag tag = getTagBySyntax(m.group());
                if (tag!=null){
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getHtml(mb, pageProps, userSession, request)));
                }
            }

        }
        // Add the last segment
        try{
            m.appendTail(pg);
        } catch (Exception e){
            //Do nothing... just null pointer... there was no tail because a tag was last char
        }

        //Append the Powered By Logo
//        if (userSession.getAccount().getAccounttypeid()<reger.Vars.ACCTYPETRIAL){
//            pg.append(reger.core.Util.poweredby(pageProps.pathToAppRoot));
//        }

        //If no body tag was found we should put admintools on top of the stringbuffer
        if (!foundbodytag){
            //Append AdminTools
            StringBuffer tmp = new StringBuffer();
            tmp.append(appendToTop);
            tmp.append(pg);
            pg = tmp;
        }

        //Footer
        pg.append(reger.core.Util.pageFooter(pageProps.pathToAppRoot, userSession.getPl()));


        //Return the page
	    return pg;



    }


    public static MarketingSiteTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            MarketingSiteTemplateTag tag = (MarketingSiteTemplateTag)MarketingSiteTemplateCacheTags.get(tagSyntax);
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
        tags = new MarketingSiteTemplateTag[2];
        tags[0] = new MarketingSiteTemplateTagMainBody();
        tags[1] = new MarketingSiteTemplateTagNavBarHorizontal();
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
        Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)");
        // Create a matcher with an input string
        Matcher m = p.matcher(template.getTemplate());
        // Loop through
        while(m!=null && m.find()) {


            //Go get the tag that can handle this syntax
            MarketingSiteTemplateTag tag = getTagBySyntax(m.group());
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
        StringBuffer mb = new StringBuffer();


        mb.append("<html>");
        mb.append("<head>");
        mb.append("</head>");
        mb.append("<body  bgcolor=#ffffff link='#0000ff' vlink='#000000' text='#000000' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0'>");


        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td rowspan='2' width=275 align=center><img src='../privatelabel/reger/images/reger-logo.gif'></td>");
        mb.append("<td><img src=../images/clear.gif width=1 height=25></td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign=bottom><$NavBar.Horizontal$></td>");

        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#000000><img src=../images/clear.gif width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<$Main.Body$>");

        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#000000><img src=../images/clear.gif width=1 height=8></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("</body>");
        mb.append("</html>");




        return mb.toString();
    }


}
