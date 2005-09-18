package reger.template;

import reger.core.Debug;
import reger.pageFramework.PageProps;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Processes Homepage templates
 */
public class MarketingHpTemplateProcessor implements TemplateProcessor {

    private static MarketingHpTemplateTag[] tags;


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
    public static StringBuffer getHtml(reger.UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){
        String template = "";

        //Get the template
        Template tmpl = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getPl().getMarketingsitehptemplateid(), Template.TEMPLATETYPEMARKETINGHOMEPAGE);
        if (tmpl!=null){
            template = tmpl.getTemplate();
        }


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
            MarketingHpTemplateTag tag = (MarketingHpTemplateTag)MarketingHpTemplateCacheTags.get(tagSyntax);
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
        tags = new MarketingHpTemplateTag[3];
        tags[0] = new MarketingHpTemplateTagLogInBox();
        tags[1] = new MarketingHpTemplateTagLogTypeList();
        tags[2] = new MarketingHpTemplateTagVersionNumber();
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
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#ffcc33>");
        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#ffcc33 align=right valign=middle>");
        mb.append("<br><br>");

        mb.append("<center>");

        mb.append("<a href='signup.log'><img src=../images/hp-freeblog.gif border=0></a>");

        mb.append("<a href='download.log'><img src=../images/hp-download.gif border=0></a>");

        mb.append("<a href='moreinfo.log'><img src=../images/hp-moreinfo.gif border=0></a>");

        mb.append("</center>");

        mb.append("<br><br>");

        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#000000>");
        mb.append("<img src=../images/clear.gif width=1 height=1>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");




        mb.append("<table cellspacing='0' width=275 cellpadding='10' border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top'>");



        mb.append("<$LogInBox$>");


        mb.append("<font face=arial size=-1><b>Recent News/Updates/Status</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>For the latest datablogging and Reger.com news, visit Joe Reger, Jr's blog:");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle> <a href='http://www.joereger.com/logmain7.log'>Get News Here.</a></font>");
        mb.append("<br><br>");

        mb.append("<font face=arial size=-1><b>Questions/Feedback?</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>Visit the Reger.com discussion forum:");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle>  <font face=arial size=-2><a href='http://www.reger.com/jforum/'>Visit the Forum.</a></font>");
        mb.append("<br><br>");

        mb.append("<font face=arial size=-1><b>Current Version:</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=+2 color=#cccccc><b><$VersionNumber$></b></font>");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle>  <font face=arial size=-2><a href='versions.log'>List All Versions.</a></font>");
        mb.append("<br><br>");





        mb.append("<br><br><br>");

        mb.append("</td>");

        mb.append("<td valign='top'>");
        mb.append("<font face=arial size=+3 color=#cccccc>You invest a lot living your life... invest a little capturing it.</font>");
        mb.append("</td>");

        mb.append("</tr></table>");









        return mb.toString();
    }

    public String getDefaultTemplateOld(){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#ffcc00><table cellspacing='0' cellpadding='0' width=100% border='0'>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#ffcc00 align=right valign=middle>");
        mb.append("<a href='signup.log'><img src='images/createownweblog.gif' border=0></a>");
        mb.append("</td>");
        mb.append("<td bgcolor=#ffcc00 align=left>");
        mb.append("<img src='images/clear.gif' width='1' height='1' alt='' border='0'>");
        mb.append("</td>");
        mb.append("<td bgcolor=#ffcc00 align=right>");
        mb.append("<img src='images/hp-image-1.gif' width='195' height='168' alt='' border='0'>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign='top' bgcolor=#000000>");
        mb.append("<img src=../images/clear.gif width=1 height=1>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");




        mb.append("<table cellspacing='0' width=100% cellpadding='0' border='0'>");
        mb.append("<tr>");
        mb.append("<td valign='top'>");
        mb.append("<table width=100% cellpadding=4 cellspacing=0 border=0>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#000000>");
        mb.append("<img src='images/clear.gif' width='1' height='50' alt='' border='0' align=left><font face=arial size=-1 color=#ffffff><b>A Log Type for Everybody:</b></font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<td bgcolor=#ffffff>");
        mb.append("<$LogTypeList$>");
        mb.append("</td>");
        mb.append("</table>");
        mb.append("</td>");

        mb.append("<td valign='top' bgcolor=#000000 width=1><img src=../images/clear.gif width=1 height=1></td>");
        mb.append("<td valign='top'><table cellpadding=10 cellspacing=0 width=100% border=0><tr><td valign=top>");
        mb.append("<!-- Begin Center of the page -->");



        mb.append("<center>");
        mb.append("<img src='images/hp-datablogging.jpg' width=366 height=467 border=0>");

        mb.append("<br><br>");

        mb.append("<table width=366 cellpadding=4 cellspacing=0 border=0>");


        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff align=center>");
        mb.append(reger.ui.ShadowBox.start("../"));
        mb.append("<font face=arial size=+1 color=#666666><b>A Full-featured Blogging Tool</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2><b>This is a full-featured blogging tool.  Using it you can create a blog and publish your first entry in minutes.  You can customize your site's look and feel, use open APIs, publish RSS feeds, password-protect entries and do everything else you'd expect to be able to do with a blogging tool... even some things you wouldn't expect.</b></font>");
        mb.append("<br>");
        mb.append("<a href='features.log'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>View the feature list.</b></font></a>");
        mb.append(reger.ui.ShadowBox.end("../"));
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff align=center>");
        mb.append(reger.ui.ShadowBox.start("../"));
        mb.append("<font face=arial size=+1 color=#666666><b>datablogging is Powerful</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2><b>datablogging is what makes this tool unique.  You can do basic blog entries with a title, date and body.  But what this tool excels at is allowing you to capture extended data fields with each entry.  As you blog and collect data, you can then mine that data with custom graphs, advanced saved data searches and data-enabled RSS feeds.  All right out of the box with no complex user manuals or custom code.  You can create a custom log type to log any sort of activity you can imagine. The sky's the limit. A few sample log types are provided, but they only scratch the surface of what's possible. Be creative. Have fun.</b></font>");
        mb.append("<br>");
        mb.append("<a href='../biz/what-is-datablogging.log'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>More on datablogging.</b></font></a>");
        mb.append(reger.ui.ShadowBox.end("../"));
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff align=center>");
        mb.append(reger.ui.ShadowBox.start("../"));
        mb.append("<font face=arial size=+1 color=#666666><b>Opening the Archive</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2><b>This tool is also unique because it doesn't focus on your blog's homepage.  Sure, it does an excellent job with the homepage... you can customize the heck out of it.  But your blog is more than just your homepage.  Entries don't slide off of it never to be seen again.  On the contrary, a number of features unique to this tool help weave your past entries and the context they create into your current entries.  This tool attempts to create a story out of your entries.  Some people call it a digital scrapbook.  Academics call it a personal data repository.  Businesses call it a knowledge management tool.  You say potato.  We say potato.  At the core, this tool helps you leverage your old log entries, whether that means to wax nostalgic or run a Fortune 100 business.</b></font>");
        mb.append("<br>");
        mb.append("<a href='features.log?feature=comparison'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>Open sesame</b></font></a>");
        mb.append(reger.ui.ShadowBox.end("../"));
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff align=center>");
        mb.append(reger.ui.ShadowBox.start("../"));
        mb.append("<font face=arial size=+1 color=#666666><b>Business or Pleasure?</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2><b>It's up to you.  You can use datablogging to track personal things like triathlon training, movie watching or eating out.  Or you can use it in business to track meetings, keep up with projects, share files and announce progress.  We offer custom installations of the server software for business and in the coming months will have a downloadable personal version too.</b></font>");
        mb.append("<br>");
        mb.append("<a href='../biz/index.log'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>Business folks can learn more</b></font></a>");
        mb.append("<br>");
        mb.append("<a href='tour.log'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>Personal bloggers can take a tour</b></font></a>");
        mb.append(reger.ui.ShadowBox.end("../"));
        mb.append("</td>");
        mb.append("</tr>");



//        mb.append("<tr>");
//        mb.append("<td bgcolor=#ffffff align=center>");
//        mb.append(reger.ui.ShadowBox.start("../"));
//        mb.append("<font face=arial size=+1 color=#666666><b>Build a Community</b></font>");
//        mb.append("<br>");
//        mb.append("<font face=arial size=-2><b>You are able to build complex personal networks by inviting users to create their own blog sites.  As you become linked with your friends, coworkers, partners or vendors you increase the value of the entire process.</b></font>");
//        mb.append("<br>");
//        //mb.append("<a href='features.log?feature=password'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>More on Blog Visibility</b></font></a>");
//        mb.append(reger.ui.ShadowBox.end("../"));
//        mb.append("</td>");
//        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff align=center>");
        mb.append(reger.ui.ShadowBox.start("../"));
        mb.append("<font face=arial size=+1 color=#666666><b>It's Easy and Free to Get Started</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2><b>Creating an account takes seconds and does not require a credit card.  You'll get a free upgrade to Pro features for "+reger.Vars.TRIALACCOUNTDAYS+" days.  After that you can keep using the site for free or you can pay a small fee for storage and traffic, generally around $4 per month.</b></font>");
        mb.append("<br>");
        mb.append("<a href='signup.log'><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9><font face=arial size=-2 color=#0000ff><b>Start datablogging now</b></font></a>");
        mb.append(reger.ui.ShadowBox.end("../"));
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("</tr>");
        mb.append("</table>");

        mb.append("</center>");

        mb.append("<!-- End Center of the page --></td><td width=33% valign=top>");
        mb.append("<$LogInBox$>");

        mb.append("<br>");
        mb.append("<font face=arial size=-1><b>How do I get started?</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>It's free and easy.  It only takes a few seconds to set up your site.");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle> <a href='signup.log'>Get Started Here.</a></font>");
        mb.append("<br><br>");


        mb.append("<font face=arial size=-1><b>Recent News/Updates/Status</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>For the latest datablogging and Reger.com news, visit the blog of Founder, CEO, Joe Reger, Jr.");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle> <a href='http://www.joereger.com/logmain7.log'>Get News Here</a></font>");
        mb.append("<br><br>");



        mb.append("<font face=arial size=-1><b>Current Version:</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=+2 color=#cccccc><b><$VersionNumber$></b></font>");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle>  <font face=arial size=-2><a href='versions.log'>List All Versions.</a></font>");
        mb.append("<br><br>");


        mb.append("<font face=arial size=-1><b>Site Directory</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>See some of the sites created here.<br><img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle> <a href='community.log'>Site Directory.</a></font>");
        mb.append("<br><br>");
        mb.append("<font face=arial size=-1><b>Recent Entries</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>See some of the most recent entries.");
        mb.append("<br>");
        mb.append("<img src='images/arrow-sm-yellow.gif' border=0 width=9 height=9 align=middle> <a href='community-entries.log'>Go.</a></font>");
        mb.append("<br><br>");
        mb.append("<form action=search.log method=post><font face=arial size=-1><b>Search Entries</b></font><br><font face=arial size=-2>Search entries on this server.");
        mb.append("<br>");
        mb.append("<input type=hidden name=nextchunktodisplay value=chunk-chooseaccounts><input type=hidden name=thischunkuniqueidentifier value=chunk-keywords><input type=text name=searchterms value='' size=10 maxlength=49><br><input type='submit' value='Search'></font></form>");
        mb.append("<br>");
        mb.append("<form action='community.log' method=post><input type=hidden name=action value=search><font face=arial size=-1><b>Find Sites</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>Find sites that are created here.  Enter a site name or the first letter/number of the site's url:<br><input type='text' name='searchsites' value='' size=15 maxlength=100 style='font-size: 10px'>");
        mb.append("<br>");
        mb.append("<input type='submit' value='Search Sites' style='font-size: 10px'></form>");
        mb.append("<br>");
        mb.append("<br>");
        mb.append("<form action='emailafriend.log' method=post><font face=arial size=-1><b>Tell a Friend.</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>Ok, so maybe this gig isn't for you.  But we're willing to bet that you know somebody who'll give you a big hug and a kiss for passing it on to them.  Help out a dot com and round out your cosmic karma for the week.</font>");
        mb.append("<br>");
        mb.append("<input type='text' name='friendemail' value='Friend's Email**' size=15 maxlength=100 style='font-size: 10px'>");
        mb.append("<br>");
        mb.append("<input type='submit' value='Tell A Friend.' style='font-size: 10px'></form><font face=arial size=-2>**We will not spam your friend. We respect their privacy and will only use this email address one time to tell them about the site.</font>");

        mb.append("<br><br><br>");

        mb.append("</td></tr></table></td>");

        mb.append("</tr>");
        mb.append("</table>");







        return mb.toString();
    }


}
