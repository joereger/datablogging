package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.Debug;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes the Site Templates
 */
public class SiteTemplateProcessor implements TemplateProcessor {

    private static SiteTemplateTag[] tags;

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

        if (userSession.getAccount().getHomepagetitle()!=null && !userSession.getAccount().getHomepagetitle().equals("")) {
            homepagetitle=userSession.getAccount().getHomepagetitle();
        }

        if (userSession.getAccount().getHomepagehtml()!=null && !userSession.getAccount().getHomepagehtml().equals("")) {
            homepagehtml=userSession.getAccount().getHomepagehtml();
        }


        //Get the template string to use
        String templateMainBody="";

        //Use the template from the object
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccount().getSitetemplateid()>0){
            templateMainBody=reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getAccount().getSitetemplateid(), Template.TEMPLATETYPESITE).getTemplate();
        }
        if (templateMainBody==null || templateMainBody.equals("")){
            SiteTemplateProcessor stp = new SiteTemplateProcessor();
            templateMainBody = stp.getDefaultTemplate();
        }


        //Figure out what AdminTools and LoggedInBar look like
        StringBuffer appendToTop = new StringBuffer();
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/nav.css\" type=\"text/css\" />");
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/cssobjectlayouts.css\" type=\"text/css\" />");
        appendToTop.append("<link rel=\"stylesheet\" href=\""+pageProps.pathToAppRoot+"css/style.css\" type=\"text/css\" />");
        if (userSession.getAccountuser().getIsLoggedIn()){
            appendToTop.append(reger.LoggedInBar.getHtml(userSession, pageProps));
            if (userSession.getAccount().getAdmintools()==1 && userSession.getAccountuser().getAccountid()==userSession.getAccount().getAccountid()){
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
            } else if (m.group().substring(0,5).equalsIgnoreCase("<head") || m.group().substring(0,6).equalsIgnoreCase("< head")) {
                //Head tag
                m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(m.group() + appendRssAutodiscovery(userSession)));
            } else {
                //Go get the tag that can handle this syntax
                SiteTemplateTag tag = getTagBySyntax(m.group());
                if (tag!=null){
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(tag.getValue(mb, sc, pageProps, userSession, request)));
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
        if (!userSession.getAccount().isPro()){
            pg.append(reger.core.Util.poweredby(pageProps.pathToAppRoot));
        }

        //If no body tag was found we should put admintools on top of the stringbuffer
        if (!foundbodytag){
            //Append AdminTools
            StringBuffer tmp = new StringBuffer();
            tmp.append(appendToTop);
            tmp.append(pg);
            pg = tmp;
        }


        //Wrap in a plusertemplate
        pg = wrapInPlUserTemplate(pg, pageProps, userSession);

        //Return the page
	    return pg;



    }


    public static SiteTemplateTag getTagBySyntax(String tagSyntax){
        if (tags==null){
            loadTags();
        }

        //Try the cache
        try{
            SiteTemplateTag tag = (SiteTemplateTag)SiteTemplateCacheTags.get(tagSyntax);
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
        tags = new SiteTemplateTag[13];
        tags[0] = new SiteTemplateTagEntryTitle();
        tags[1] = new SiteTemplateTagLogName();
        tags[2] = new SiteTemplateTagMainBody();
        tags[3] = new SiteTemplateTagNavbarHorizontal();
        tags[4] = new SiteTemplateTagNavbarVertical();
        tags[5] = new SiteTemplateTagSideColumn();
        tags[6] = new SiteTemplateTagSiteDescription();
        tags[7] = new SiteTemplateTagSiteName();
        tags[8] = new SiteTemplateTagFavoriteEntries();
        tags[9] = new SiteTemplateTagMostRead7Days();
        tags[10] = new SiteTemplateTagMostRecentFiles();
        tags[11] = new SiteTemplateTagMostRecentList();
        tags[12] = new SiteTemplateTagRandomFiles();
    }




    private static String appendRssAutodiscovery(reger.UserSession userSession){
        String autodiscovery = "";
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            String title = "RSS";
            if (userSession.getAccount().getHomepagetitle()!=null && !userSession.getAccount().getHomepagetitle().equals("")){
                title = userSession.getAccount().getHomepagetitle();
            }

            autodiscovery = "<link rel=\"alternate\" type=\"application/rss+xml\" title=\""+reger.core.Util.cleanForHtml(title)+"\" href=\""+reger.Vars.getHttpUrlPrefix()+userSession.getAccount().getSiteRootUrl()+"/rss.xml\">";
        }
        return autodiscovery;
    }

    /**
     * Wrap in a plusertemplate
     */
    public static StringBuffer wrapInPlUserTemplate(StringBuffer pageHtml, reger.pageFramework.PageProps pageProps, reger.UserSession userSession){
        if ((!userSession.getAccount().isPro() || userSession.getPl().getDoapplyplusertemplatetopro()) && userSession.getPl().getPlusertemplate()!=null && !userSession.getPl().getPlusertemplate().equals("")){
            //Create the output buffer
            StringBuffer out = new StringBuffer();
            // Create a pattern to match cat
            Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>|\\<body(.|\\n)*?\\>|\\<head(.|\\n)*?\\>|\\<\\/body>|\\<\\/head>)");
            // Create a matcher with an input string
            Matcher m = p.matcher(userSession.getPl().getPlusertemplate());
            // Loop through
            while(m!=null && m.find()) {
                if (m.group().equalsIgnoreCase("<$Body$>")){
                    m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement(pageHtml.toString()));
                } else if (m.group().equalsIgnoreCase("<$Banner$>")){
                    //Only show banners if it's a free account
                    if (!userSession.getAccount().isPro()){
                        m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement(reger.Banner.getBannerHtml(pageProps.pathToAppRoot)));
                    } else {
                        m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement(""));
                    }
                }
            }
            // Add the last segment
            m.appendTail(out);
            //Return the page, now wrapped in a plusertemplate
            return out;
        } else {
            //There's no plusertemplate so just return the page.
            //This happens when the user has upgraded their account.
            return pageHtml;
        }
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
        StringBuffer mb = new StringBuffer();


        mb.append("<html>" + "");
        mb.append("<head>" + "");
        mb.append("<title><$Site.Name$> <$Entry.Title$></title>" + "");

        mb.append("");

        mb.append("<style>" + "");
        mb.append("/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You're in control. */" + "");

        mb.append("");

        mb.append("/* The color of links on your site. */" + "");
        mb.append("a       {color: #000000;  font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* A big font used throughout the site in various places. */" + "");
        mb.append(".bigfont{font-family: verdana, arial, helvetica, sans-serif;" + "");
        mb.append("color:#000000;" + "");
        mb.append("font-size:25px;}" + "");

        mb.append("");

        mb.append("/* A medium font used throughout the site in various places. */" + "");
        mb.append(".mediumfont{font-family: verdana, arial, helvetica, sans-serif;        " + "");
        mb.append("color:#000000;" + "");
        mb.append("font-size:10px;}" + "");

        mb.append("");

        mb.append("/* A small font used throughout the site in various places. */" + "");
        mb.append(".smallfont{font-family: verdana, arial, helvetica, sans-serif;" + "");
        mb.append("color:#666666;" + "");
        mb.append("font-size:10px;}" + "");

        mb.append("");

        mb.append("/* The table that houses your main log navigation. */" + "");
        mb.append(".navigation{width: 100%;" + "");
        mb.append("background-color: #e6e6e6;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */" + "");
        mb.append(".navcelloff{padding: 3px;" + "");
        mb.append("background-color: #cccccc;" + "");
        mb.append("width: 100%;" + "");
        mb.append("border-left: 6px solid #cccccc;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* The style of a navigation button that is currently clicked on. */" + "");
        mb.append(".navcellon{padding: 3px;" + "");
        mb.append("background-color: #dddddd;" + "");
        mb.append("width: 100%;" + "");
        mb.append("border-left: 6px solid #666699;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* The font used when a navigation bar button is turned off. */" + "");
        mb.append(".navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px; color: #333333;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* The font used when a navigation bar button is turned on. */" + "");
        mb.append(".navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px; color: #333333;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* Content in your side column is arranged into units. */" + "");
        mb.append(".sidecolunit {" + "");
        mb.append("width: 100%;" + "");
        mb.append("margin-bottom: 10px;" + "");
        mb.append("border-top: 3px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* The background and font for unit headers in your side column. */" + "");
        mb.append(".sidecolheader {" + "");
        mb.append("background-color: #666699;" + "");
        mb.append("padding: 3px;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("width: 100%;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".sidecolheader a {" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("} " + "");

        mb.append("");

        mb.append("/* The background and font for content in your side column. */" + "");
        mb.append(".sidecolcontent {" + "");
        mb.append("padding: 3px;" + "");
        mb.append("background-color: #cccccc;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #333333;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("width: 100%;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".sidecolcontent a {" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #333333;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */" + "");
        mb.append(".calendardayname{background-color: #999999;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 8px; color: #000000;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */" + "");
        mb.append(".calendardaybox{background-color: #e6e6e6;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px; color: #000000;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */" + "");
        mb.append(".calendardayboxtoday{background-color: #cccccc;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px; color: #000000;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* Important for setting the style of your log entry detail page. This controls the display of field names.*/" + "");
        mb.append(".logentryheader{background-color: #cccccc;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 12px; color: #000000;" + "");
        mb.append("font-weight: bold;}" + "");

        mb.append("");

        mb.append("/* Important for setting the style of your log entry detail page. This controls the display of your data. */" + "");
        mb.append(".logentrycontent{background-color: #ffffff;" + "");
        mb.append("FONT-FAMILY: verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px; color: #000000;}" + "");

        mb.append("");

        mb.append("/* Control the little numbers that appear when you list more log entries than will appear on the page. */" + "");
        mb.append(".pagingnumbers{padding: 0px;" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #333333;" + "");
        mb.append("font-weight: bold;  " + "");
        mb.append("background-color: #e6e6e6;" + "");
        mb.append("border-top: 1px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("width: 100%}" + "");

        mb.append("");

        mb.append(".pagingnumbers a {" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #333333;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */" + "");

        mb.append("");

        mb.append("TD.topbox {" + "");
        mb.append("border-top: 7px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("TD.leftcol {" + "");
        mb.append("border-top: 7px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("TD.centercol {" + "");
        mb.append("border-top: 7px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append("TD.rightcol {" + "");
        mb.append("border-top: 7px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #333333;" + "");
        mb.append("border-left: 1px solid #333333;" + "");
        mb.append("border-right: 1px solid #333333;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrywrapper {" + "");
        mb.append("border-top: 3px solid #333333;" + "");
        mb.append("border-bottom: 1px solid #cccccc;" + "");
        mb.append("border-left: 1px solid #cccccc;" + "");
        mb.append("border-right: 1px solid #cccccc;" + "");
        mb.append("margin-top: 8px;" + "");
        mb.append("margin-bottom: 15px;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrytitle {" + "");
        mb.append("background: #666699;" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 12px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("border-left: 0px solid #666699;" + "");
        mb.append("padding: 3px;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrytitle a, .entrytitle font {" + "");
        mb.append("FONT-FAMILY:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 12px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entryago {" + "");
        mb.append("float: right;" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("padding-left: 5px;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entryago a, .entryago font {" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #e6e6e6;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrybody {" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 10px;" + "");
        mb.append("color: #666666;" + "");
        mb.append("font-weight: normal;" + "");
        mb.append("padding-left: 5px;" + "");
        mb.append("padding-top: 8px;" + "");
        mb.append("padding-bottom: 8px;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrydate {" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 8px;" + "");
        mb.append("color: #333333;" + "");
        mb.append("font-weight: bold;" + "");
        mb.append("padding-left: 5px;" + "");
        mb.append("}" + "");

        mb.append("");

        mb.append(".entrydate a, .entrydate font {" + "");
        mb.append("font-family:  verdana, arial, helvetica, sans-serif;" + "");
        mb.append("font-size: 8px;" + "");
        mb.append("color: #333333; " + "");
        mb.append("font-weight: bold;" + "");
        mb.append("}" + "");

        mb.append("</style>" + "");

        mb.append("");

        mb.append("</head>" + "");
        mb.append("<body bgcolor='#ffffff' text='#000000' link='#0000ff' vlink='#0000ff' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0'>" + "");
        mb.append("<center>" + "");
        mb.append("<br>" + "");
        mb.append("<table cellpadding=3 cellspacing=2 border=0 width=95% >" + "");

        mb.append("");

        mb.append("<tr>" + "");
        mb.append("<td colspan=3 valign=bottom align=left bgcolor='#666699'' class=topbox>" + "");
        mb.append("<br><br><br><font face=arial color=#e6e6e6 size=+3><b><$Site.Name$></b></font>" + "");
        mb.append("<br><font face=arial color=#cccccc size=+1><$Site.Description$></font>" + "");
        mb.append("</td>" + "");
        mb.append("</tr>" + "");

        mb.append("");

        mb.append("<tr>" + "");
        mb.append("<td valign=top bgcolor='#cccccc' width=200 class=leftcol>" + "");
        mb.append("<$Navbar.Vertical$>" + "");
        mb.append("</td>" + "");
        mb.append("<td valign=top bgcolor=#ffffff class=centercol>" + "");
        mb.append("<$Main.Body$>" + "");
        mb.append("</td>" + "");
        mb.append("<td valign=top bgcolor=#cccccc width=200 align=right class=rightcol>" + "");
        mb.append("<$Side.Column$>" + "");
        mb.append("</td>" + "");
        mb.append("</tr>" + "");

        mb.append("");

        mb.append("</table>" + "");
        mb.append("</center>" + "");
        mb.append("</body>" + "");
        mb.append("</html>" + "");

        mb.append("");

        return mb.toString();
    }


}
