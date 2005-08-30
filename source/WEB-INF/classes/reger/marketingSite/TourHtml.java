package reger.marketingSite;

import reger.core.db.Db;
import reger.UserSession;
import reger.Log;
import reger.mega.FieldLayout;
import reger.mega.Field;
import reger.mega.MegaChart;
import reger.mega.MegaChartHtmlRenderer;
import reger.template.Template;

import javax.servlet.http.HttpServletRequest;

/**
 * Html for the marketing site tour section.
 */
public class TourHtml {


    /**
     * The most important method... this displays an eventtypeid's detail page
     */
    public static StringBuffer logDetail(int eventtypeid, String pathToRoot, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletResponse response){
        StringBuffer mb = new StringBuffer();

        //Add the popup javascript
        mb.append(reger.core.Util.popup());

        //-----------------------------------
        //-----------------------------------
        String[][] rstLogtype= Db.RunSQL("SELECT megalogname, description, icon, longdescription FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstLogtype!=null && rstLogtype.length>0){

            mb.append("<br><br>");
            mb.append("<center>");
            mb.append("<font face=arial size=+2 color=#666666>");
            mb.append("<b>");
            mb.append("Main log entry page:");
            mb.append("</font>");
            mb.append("</b>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 color=#666666>");
            mb.append("This page is important because it is the page you'll use to create entries.  It shows you all of the fields that make up this log.  Note that the links on this page won't work.");
            mb.append("</font>");
            mb.append("</center>");
            mb.append("<br>");

            //Set things up for the preview

            //Populate the logProps
            pageProps.logProps.populateWithEventtypeidForPreview(eventtypeid);

//            //Set as a preview
//            pageProps.isPreview = true;

            //Get a blank entry
            pageProps.entry.getBlankEntryAll();

            //Show admin mode
            boolean displayasadmin = true;

            //Disable links on the page
            //mb.append(reger.core.Util.disableLinksJavascript(pageProps.pathToAppRoot));

            //Usersession
            reger.UserSession tmpUserSession = new reger.UserSession(request);
            //reger.Account tmpAcct = new reger.Account(-1);
            tmpUserSession.setAccountid(0);


            //Display a mock-entry page
            mb.append("<table align=center cellpadding=0 cellspacing=10 bgcolor=#e6e6e6 border=0>");
            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#ffffff>");
            //Append the top of the form
            mb.append(reger.MegaHtmlFormTop.getHtml(tmpUserSession, pageProps, displayasadmin, request));
            //Append the center of the page
            //mb.append(reger.MegaHtmlFormCenter.getHtml(userSession, pageProps, displayasadmin, request));
            //Display the fields
            mb.append("<tr>");
            mb.append("<td bgcolor=#ffffff colspan=6 align=left valign=top class=logentryheader>");
            mb.append(FieldLayout.getHtml(eventtypeid, 0, FieldLayout.LAYOUTMODEADMIN, tmpUserSession, "#", "#", "#", pageProps));
            mb.append("</td>");
            mb.append("</tr>");
            //Append the bottom of the form
            mb.append(reger.MegaHtmlFormBottom.getHtml(tmpUserSession, pageProps, displayasadmin, request, response));
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");


        }






        mb.append("</font>");

        return mb;
    }







    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer defaultHtml(int plid){
        StringBuffer ff = new StringBuffer();



        //ff.append("<p align=right><font face=arial size=+3>Features</font></p>");




        ff.append("<table cellspacing='15' cellpadding='5' border='0'>");

        ff.append("<tr>");
        ff.append("<td bgcolor=#e6e6e6 valign=top><font face=arial size=+1 color=#666666><strong>Powerful Features&nbsp;&nbsp;&nbsp;</strong></font></td>");
        //ff.append("<td bgcolor=#e6e6e6 valign=top><font face=arial size=+1 color=#666666><strong>Activity-Specific Log Types</font>");
        //ff.append("<br><font face=arial size=-2 color=#666666>Your site can have as many or as few as you like when you <a href='signup.log'>signup</a>.</strong></font></td>");
        ff.append("</tr>");

        ff.append("<tr>");
        ff.append("<td bgcolor=#ffffff valign=top>");


        ff.append(reger.marketingSite.ProFeaturesGrid.getHtml(false, "../"));



        ff.append("</td>");
        //ff.append("<td valign=top align=center>");

        //List the log types
        //ff.append(listLogTypes(plid));

        //ff.append("</td>");

        ff.append("</tr></table>");


        ff.append("</center>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
//    public static StringBuffer adminFeatures(){
//        StringBuffer ff = new StringBuffer();
//
//        return ff;
//    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer admin(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Administration Features</font></p>");
        ff.append("<p align=left><font face=arial size=+1>These are the tools that you use daily to create your log website.  They're built with quick and easy logging in mind.</font></p>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-adminhome.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Main Admin Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>The first page you see after logging in, this page gives you the quick ability to add an entry to any of your logs.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-addentrywysiwyg.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Add Entry with WYSIWYG Editor</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>This is the page you use to add log entries.  It's designed to be simple.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-addentrysimple.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Add Entry with Simple Text</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>This is the page you use to add log entries.  It's designed to be simple.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");




        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-customize.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Customize My Site</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>There are many ways to customize the way that your site looks and acts.  The possibilities are endless with control of html headers, colors and skins.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-customizelogprops.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Log Names</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>What's in a name?  A lot.  You can change the name of each log and give it a quick description.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-customizelogprops.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Log Viewing Permissions</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>You can control who sees your logs.  They can be public, private or password-protected.  Each log can have a separate password so that your golf buddies don't hear about your skydiving exploits.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-deletelog.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Delete a Log</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Sometimes you just have to move on.  We understand.  Quick delete allows you to move log entries for the log you're deleting into another log of the same type.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");




        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-edit.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Edit Old Entries</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Are you a revisionist historian?  Or a spelling fixer?  This is your tool.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-customizesiteprops.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Site Preferences</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>There are numerous settings you can use to customize your site.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-newlog.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Create a New Log</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Creating a new log is only a matter of a few clicks.  Go ahead, add one for the day and then delete it.  You know you want to.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer api(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Open API</font></p>");
        ff.append("<p align=left><font face=arial size=+1>The platform is open via common web logging API's like the MetaWebLogAPI.  This means that you can use an emerging class of third party software to make it easier to make log entries.</font></p>");

        ff.append("<font face=arial size=-1>");

        ff.append("<br>For you advanced users out there we present a rough display of the API methods that are exposed and where to get to them.  Use this power for good.");

        ff.append("<br><br>Just like the web, these API's improve every now and then.  Chances are, if you're into the APIs you'll hear about the changes.  If you don't, we'll make sure that we keep you up to speed.");

        ff.append("<br><br>");

        ff.append("</font>");

        //The API description
        ff.append(reger.api.ApiDescription.getHtml());

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer chartsAndGraphs(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Cool Charts and Graphs</font></p>");
        ff.append("<p align=left><font face=arial size=+1>The power of specialized log types: cool charts and graphs.</font></p>");
        ff.append("<br><br>  ");
        ff.append("We have activity-specific log types. This means that you can track numerous things for each log type.  For example, on the Running Log you can keep track of how far you ran, how long it took, what shoes you wore, etc.  Once you've entered that data over time you'll want to analyze it.  The charts and graphs feature allows you to mine your own data.  You can create and save your own custom charts and graphs too.");
        ff.append("<br><br>");
        ff.append("</font>");
        ff.append("<br><br>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer comparison(){
        StringBuffer ff = new StringBuffer();

        ff.append("<br><br>");


        ff.append("<table cellpadding=15 cellspacing=3 border=0>");


        ff.append("<tr>");
        ff.append("<td valign=top bgcolor=#e6e6e6>");
        ff.append("<font face=arial size=+1 color=#666666>Similarities to other publishing tools</font>");
        ff.append("</td>");
        ff.append("<td valign=top bgcolor=#e6e6e6>");
        ff.append("<font face=arial size=+1 color=#666666>Differences</font>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("<tr>");
        ff.append("<td valign=top><font face=arial size=-1>");
        ff.append("<strong>A personal publishing system</strong> that allows you to quickly add/edit and delete log entries while publishing them to a public site.");
        ff.append("<br><br>");
        ff.append("<strong>No need to learn code.</strong> You can create and update your site online without knowing anything about HTML.");
        ff.append("<br><br>");
        ff.append("<strong>A user-friendly admin interface</strong> available 24x7 from anywhere in the world where you make log entries that appear on a public site.");
        ff.append("<br><br>");
        ff.append("<strong>A url of your choosing</strong> like http://whateveriwant.server.com");
        ff.append("<br><br>");
        ff.append("<strong>Easily syndication of your web log</strong> through rss.xml to content aggregators.  Share your thoughts with the world!");
        ff.append("<br><br>");
        ff.append("<strong>A template system</strong> that allows you to completely customize the way  your site looks.  The possibilities are endless.");
        ff.append("<br><br>");
        ff.append("<strong>Hosting</strong> on our servers.");
        ff.append("<br><br>");
        ff.append("<strong>Traffic Analysis</strong> Powerful traffic stats so that you can how many people visit your site and what they're reading while they're there.");
        ff.append("<br><br>");
        ff.append("<strong>Save as Draft</strong> Sometimes we all need a night or two to think about a web log post.  Save as Draft allows you to capture your thoughts and refine them before publishing.");
        ff.append("<br><br>");
        ff.append("<strong>Custom Domain Name</strong> You are easily able to point your own domain name or subdomain name at the server so that it looks like you are powering the site.");



        ff.append("</font></td>");
        ff.append("<td valign=top><font face=arial size=-1>");
        ff.append("<strong>Activity-specific log types</strong> like the Running Log, Movie Log, Morning Commute Log and General Log.  You can setup a Basic Log just like any other web logging system or you can log interest-specific activities. ");
        ff.append("<br><br>");
        ff.append("<strong>Charts and graphs</strong>... the quantifiable element.  The whole point of having special log types is so that you can collect data about your interest.  Runners collect distance, time and terrain so that reger can chart their progress.");
        ff.append("<br><br>");
        ff.append("<strong>The focus is also on nostalgia creation</strong>... in addition to the publishing focus, we care about making your memories last longer and be more impactful.  You collect not only the events in your life but the context in which they happened. Because of this, when you log you want to choose the date that something actually happened, not the time that you publish it.  This is a slightly different mind set when compared to traditional web logs where the date stamp represents the date of publishing.  Of course, the system can still be used in the traditional way, but it will, in our opinion, increase the quality of your nostalgia more when you log actual event dates.");
        ff.append("<br><br>");
        ff.append("<strong>Your site can consist of many logs.</strong>  The home page is a collection of entries across the logs.  You have a navigation bar that lists the logs that you have.  Only want one log?  You can do that too.  We're flexible.");
        ff.append("<br><br>");
        ff.append("<strong>Open the archive</strong>... with most web logging tools you spend a lot of time writing your web log entries only to see them relegated to the archive bin... where nobody sees them.  Not with this tool.  Features are designed to allow your visitors to delve deep into your old posts.  The On This Day feature shows users entries that occurred on the same date.  This generates a sense of history and continuity.  Even more powerful, the Related Links feature shows your readers other log entries that are similar.  This makes your web log a united web of entries with users bouncing from one to another naturally.  Threads, storylines and themes are much more visible to your readers.  They gain a sense of context and see your ideas grow, develop and change.  The Search feature consistently pulls up relevant results from your old posts.  The goal is to open the archive... there's a lot of good stuff in there!");
        ff.append("<br><br>");
        ff.append("<strong>The template system is more robust.</strong>  On most web log systems all pages display one type of content... namely log entries.  But with this system you get many types of content: charts, calendars, log listings and a number of other specialized screens.  A single template won't work.  Instead, you define two templates. The first is for the overall screen layout.  It defines three areas of the screen... navigation, side column and main body.  The second template defines the way that individual log entries appear.");
        ff.append("<br><br>");
        ff.append("<strong>There is a detail screen for every log entry.</strong>  While some log entries are nothing but text, others have log-specific data in them... Running data, for example.  To view it along with all of the charts and graphs there is a detail section for each log entry.  The log listing screens show you the text of an entry while the detail screens show you the text and the quantifiable data... if there is any.  It's also a nice way to guarantee a permalink!");
        ff.append("<br><br>");
        ff.append("<strong>Password protection at the log level.</strong>  Like to hang with the bikers and the sewing circle?  Want to have a Biking Log and a Sewing Log but don't want them to know about each other? Not a problem.  Password protect the two logs and give them each separate passwords.  We're flexible here.");
        ff.append("<br><br>");
        ff.append("<strong>Show users how long it was since you made a post.</strong>  Put a cool little '3 Days Ago' blurb next to each entry.  This gives a much better sense of history than a date... with a date you have to do the math yourself.  What fun is that?");
        ff.append("<br><br>");
        ff.append("<strong>Comments are made directly to the log entry.</strong>  It's built right into the system.  No need for outside scripts or services.  ");
        ff.append("<br><br>");
        ff.append("<strong>Upload images to any log entry.</strong>  It's always nice to keep your digital photos in the context of your life.  Let's face it, they make little sense three months later when they're sitting on your hard drive.  Attach them to log entries and you not only see what you were doing... you see what you were thinking... and what happened the days before... and what happened a few days later.  You get to see the big picture.  Which is what nostalgia is about. ");
        ff.append("<br><br>");
        ff.append("<strong>Cell Phone/WAP Access to Traffic.</strong>  View your daily traffic stats and new site messages from your cell phone or other WAP device.");

        ff.append("</font></td>");
        ff.append("</tr>");
        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer freehosting(String userdomain){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Hosting</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Hosting at "+reger.Vars.getHttpUrlPrefix()+"<strong>whateveryouwant</strong>." + userdomain + "/</font></p>");

        ff.append("<p align=left><font face=arial size=-1>Share your logs with friends and family around the globe.  We provide the platform... the home for your site.</font></p>");

        ff.append("<p align=left><font face=arial size=-1>When you make an entry using your admin tools it will automatically appear on your public site. No complex programming, ftp'ing or other work to do.  Quick and easy.</font></p>");

        ff.append("<p align=left><font face=arial size=-1>Of course, you can always password protect your log entries so that only you can see them.</font></p>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer getstarted(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>How to Get Started</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Free.  Easy.  Takes less than ninety seconds.</font></p>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>");
        ff.append("<a href='signup.log'><img src='images/tourperson-4.jpg' alt='' border='0' align=right></a>");
        ff.append("<b>We don't require a single piece of personal information and it's free.</b>  You can provide an email address so that we can take care of you better, but we won't force you to.");
        ff.append("<br><br>");
        ff.append("Go ahead, setup a fake account and if you like it you can always start over.  It only takes 90 seconds to create a new account.  And it's scientifically proven to be fun.  <b>The hurdle is pretty low here.</b>");
        ff.append("<br><br>");
        ff.append("Don't worry about choosing the right logs or giving them the right names.  You'll be able to add, delete or change logs later.  Go nuts.  Be young.  Have fun.");
        ff.append("<br><br>");
        ff.append("<b>If you want to watch your life grow, change and evolve this is the way.</b>");
        ff.append("<br><br>");
        ff.append("<a href='signup.log'><b>Let's Get Started<img src='../images/clear.gif' width='5' height='15' alt='' border='0' align=top><img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0' align=top></b></a>");
        ff.append("</font>");
        ff.append("</font>");
        ff.append("<br><br><br>");
        ff.append("<font face=arial size=-2>");
        ff.append("Naw, it's just not for me, but I know somebody who would love this.'  That's cool.  Thanks for being honest.  Why don't you <a href='emailafriend.log'>Tell A Friend</a>?");
        ff.append("</font>");
        ff.append("</font>");
        ff.append("<br><br>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer messages(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Messages/Comments</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Build a community around your site by allowing your visitors to interact. You get to approve all messages before they get onto your site, if you want to. ");
        ff.append("</font></p>");
        ff.append("<img src='images/tourperson-3.jpg' alt='' border='0' align=right>");
        ff.append("<br><br>");
        ff.append("The people that visit your site can post reader messages if you let them.  You get to approve each message before the world sees it... or you can let messages auto-approve.");
        ff.append("</font>");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");






        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-emailsignup.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Reader Messages Preferences</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Two levels of control.  Turn the entire feature on or off... maybe you don't really want to hear what your readers have to say.  If the feature is on you can approve each message before it gets posted to your site.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("</table>");


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer onthisday(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>On This Day</font></p>");
        ff.append("<p align=left><font face=arial size=+1>See what you were doing on the current date throughout your web logging history.");
        ff.append("</font></p>");
        ff.append("<br>");
        ff.append("This powerful feature finds old log entries that occurred on the current date and displays them for you and your readers.  This generates an incredible sense of nostalgia.");
        ff.append("</font>");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-onthisday.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>On This Day</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>It appears on your home page, if you want it to. Easy to turn on and off.  Easy to customize the look with templates.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer pro(){
        StringBuffer ff = new StringBuffer();

        //ff.append("<p align=right><font face=arial size=+3>Pro Version</font></p>");
        ff.append("<p align=left><font face=arial size=+1>The Pro Version costs as little as $3.50 per month.</font></p>");


        ff.append(reger.marketingSite.ProFeaturesGrid.getHtml(true, "../"));


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer relatedlinks(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Related Links</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Related Entries is a feature that automatically shows your readers other log entries that may be related or similar to the one they're reading. It uses a keyword analysis algorithm to do its powerful work.");
        ff.append("</font></p>");
        ff.append("<br>");
        ff.append("Let's face it... your life is an ongoing story. You can't catch it in one log entry. It's not linear. With Related Entries, when you read an entry you're presented with links to other related log entries based on keywords... so your readers see the big picture... so they keep reading. ");
        ff.append("</font>");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-relatedlinks.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Related Links on Log Entry Detail</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>The Related Links appear on the log entry detail page, where they're most relavant and most functional.  Readers finish the current entry and then move on to similar entries.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer rss(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Syndicate with RSS/XML</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Ever want to be a newspaper publisher?  Ever yearn to be heard by a worldwide audience?  Now you can.  RSS allows you to syndicate your logs and share them with aggregators.</font></p>");

        ff.append("<br>");
        ff.append("<font face=arial size=-1>");

        ff.append("RSS is a format for syndicating news and the content of news-like sites, including major news sites like Wired, news-oriented community sites like Slashdot, and personal weblogs. But it's not just for news. Your site will have it too!");
        ff.append("<br>");
        ff.append("<br>");
        ff.append("RSS-aware programs called news aggregators are popular in the weblogging community. Many weblogs make content available in RSS. A news aggregator can help you keep up with all your favorite weblogs by checking their RSS feeds and displaying new items from each of them.");
        ff.append("<br>");
        ff.append("<br>");
        ff.append("Now you can be a publisher.  It takes no code fancy technical work to become an RSS publisher.  Leave the technical details to us... we'll leave the writing to you.  A world readership is at your fingertips with this exciting XML-based technology.");

        ff.append("</font>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer search(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Built-in Search</font></p>");
        ff.append("<p align=left><font face=arial size=+1>You get a search engine on your web log.");
        ff.append("</font></p>");
        ff.append("<br>");
        ff.append("Search is the most common interface on the web.  People know how to use it.  With the built-in search engine the people who visit your site will be able to find that log entry from three years ago about 'the thing on that day at the place with the red sand storm'");
        ff.append("</font>");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-search.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>The Search Box</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Common... expected.  Allows those who visit your site to search your posts.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer share(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Password Protection</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Keep your site private, share it with a few friends, open it to the world. With separate password control for each log you have the flexibility. </font></p>");

        ff.append("<font face=arial size=-1>");

        ff.append("<img src='images/tourperson-1.jpg' alt='' border='0' align=right>");
        ff.append("<br><br>");
        ff.append("When you decide to record your life you may want to <b>share it with the world</b>.  Or you may want to share it with only your friends and family.  <b>Or you may want to keep it to yourself</b>.");
        ff.append("<br><br>");
        ff.append("We're flexible.  Everybody's different.  No peer pressure here.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-public.gif' width='16' height='16' alt='' border='0'> Public logs are visible to anybody</b> who goes to your site at the URL that you define.  They're available the moment that you create entries.  Instant.  Wham, bam, thank you mam.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-private.gif' width='16' height='16' alt='' border='0'> Private logs are only visible to you</b>.  Nobody else will even know that they exist.  This is cool because many of the insights that you can gain through a site like this can be personal.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-password.gif' width='16' height='16' alt='' border='0'> Password Protected logs only visible to a select group of your friends or family</b>. When you create a Password Protected log you give it a password. Users go to your site, click 'Log In' and enter a password.  They then get to see logs that have that password.  If they don't have a password they won't even know that a log exists.  <b>This is important because you don't want your motorcycle buddies to know that you're the president of the local knitting club... or vice versa.</b>");
        ff.append("</font>");
        ff.append("<br><br>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer templates(UserSession userSession){
        StringBuffer mb = new StringBuffer();

        mb.append(reger.core.Util.popup());

        mb.append("<p align=right><font face=arial size=+3>Easy Templates</font></p>");
        mb.append("<p align=left><font face=arial size=+1>Change the look, feel, colors and layouts of your site with pre-built templates or customize your own. Complete template engine with custom tags.</font></p>");

        mb.append("<br>");
        mb.append("<br>");

        //Site Template
        //reger.UserSession userSession;
        Template activeTemplate = null;
        Template[] siteUserTemplates = null;
        Template[] siteSystemTemplates = reger.template.AllTemplatesInSystem.getSystemTemplatesByType(Template.TEMPLATETYPESITE);
        mb.append(reger.template.TemplateHtml.getBox(activeTemplate, siteUserTemplates, siteSystemTemplates, "Site Template", "This is the overall template that determines the general look of your site.", -1, Template.TEMPLATETYPESITE, "", "", false, false, false, false, "templateid", false));

        //Spacer
        mb.append("<br>");
        mb.append("<img src=images/clear.gif width=1 height=1>");
        mb.append("<br>");

        //Entry Template
        //reger.UserSession userSession;
        Template activeEntryListTemplate = null;
        Template[] entUserTemplates = null;
        Template[] entSystemTemplates = reger.template.AllTemplatesInSystem.getSystemTemplatesByType(Template.TEMPLATETYPEENTRYLIST);
        mb.append(reger.template.TemplateHtml.getBox(activeEntryListTemplate, entUserTemplates, entSystemTemplates, "Default Entry List Template", "This template governs entries as they appear in a list on the homepage. This template can be overridden for each log on your site.", -1, Template.TEMPLATETYPEENTRYLIST, "", "", false, false, false, false, "templateid", false));

        //Spacer
        mb.append("<br>");
        mb.append("<img src=images/clear.gif width=1 height=1>");
        mb.append("<br>");

        //Hp Template
        //reger.UserSession userSession;
        Template activeHpTemplate = null;
        Template[] hpUserTemplates = null;
        Template[] hpSystemTemplates = reger.template.AllTemplatesInSystem.getSystemTemplatesByType(Template.TEMPLATETYPEHOMEPAGE);
        mb.append(reger.template.TemplateHtml.getBox(activeHpTemplate, hpUserTemplates, hpSystemTemplates, "Site Homepage Template", "This template controls how the homepage of your site operates.", -1, Template.TEMPLATETYPEHOMEPAGE, "", "", false, false, false, false, "templateid", false));

        //Spacer
        mb.append("<br>");
        mb.append("<img src=images/clear.gif width=1 height=1>");
        mb.append("<br>");

        return mb;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer traffic(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Traffic Analysis</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Publishing is important.  But to be able to tailor your message to your readership... or at least understand the effects of your words on your readership... you need a detailed view of what's happening.</font></p>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficmain.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Traffic Summary Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Quick view of your traffic stats organized in a Today, Last 7 Days and All Time format.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficentries.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Entry Traffic Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>View the top 50 most-read entries.  This page lets you put your finger on the pulse of your site.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");




        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-supercookie.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>SuperCookie</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>The Supercookie tells your site that it's you visiting it... not a visitor.  So... what good does that do me? Glad you asked. This comes in handy when you are looking at your traffic stats. You probably don't want to see traffic stats that reflect your own activity. You want to see visitors... other people... not you. This allows you to surf your own site as much as you like without affecting your traffic statistics. Pretty cool eh? </font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-entryzoom.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Entry Detail Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>A charted view of how a single log entry has been viewed over time.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficlogs.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Log Traffic Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>See which logs are recieving the most traffic.  The numbers presented include all clicks inside the log... detail pages, log main pages, images, messages, etc.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficimages.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Images Traffic Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Thumbnails of the top 50 most-viewed images in each time period are presented.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-browsers.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Browser Traffic Page</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>What browsers are your readers using?  Use this page to find out.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-referers.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Referrers</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Where is your traffic coming from?  Search engines?  Other web logs?  This page will tell you.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");



        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficclicks.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Raw Clicks</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>Not big on summarized data?  You want the raw data.  We understand.  This page will show you each click that is made on your site.  Watch it all day.  Watch it all night.  Be careful... it's addictive.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");


        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-trafficsearches.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Searches</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>You get to see when and what people search your site for.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");





        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer wap(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Cell Phone or Other WAP Device</font></p>");
        ff.append("<p align=left><font face=arial size=+1>If you've got a WAP-capable cell phone or other device you can check on your site 24/7 from anywhere!</font></p>");


        ff.append("<img src='../myhome/images/cell-wap-sm.jpg' align=right>");

        ff.append("<font face=arial size=-1>");
        ff.append("<br>");
        ff.append("Here's what you can access from your device:");
        ff.append("<ol>");
        ff.append("<li>");
        ff.append("Traffic Summary");
        ff.append("	<ul>");
        ff.append("	<li>Hits Today - The total number of hits that your site has recieved today.</li>");
        ff.append("	<li>Hits Week - Total number of hits in the last 7 days.</li>");
        ff.append("	<li>Home Today - Total Homepage hits today.</li>");
        ff.append("	<li>Home Week - Total Homepage hits in the last 7 days.</li>");
        ff.append("	<li>Entry Today - Total number of log entry detail pages read today.</li>");
        ff.append("	<li>Entry Week - Total number of log entry detail pages read in the last 7 days.</li>");
        ff.append("	<li>Unapproved Messages - Messages that your readers have submitted and are waiting for approval from you.</li>");
        ff.append("	</ul>");
        ff.append("</li>");
        ff.append("<li>");
        ff.append("Top 10 Today - See the most-read entries today.");
        ff.append("</li>");
        ff.append("<li>");
        ff.append("Traffic By Log - See which log is getting the most traffic today.");
        ff.append("</li>");
        ff.append("</ol>");
        ff.append("</font>");
        ff.append("<br><br>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer password(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Password Protection</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Keep your site private, share it with a few friends, open it to the world. With separate password control for each log you have the flexibility.</font></p>");


        ff.append("<font face=arial size=-1>");
        ff.append("<br>");

        ff.append("<img src='images/tourperson-1.jpg' alt='' border='0' align=right>");
        ff.append("<br><br>");
        ff.append("When you decide to record your life you may want to <b>share it with the world</b>.  Or you may want to share it with only your friends and family.  <b>Or you may want to keep it to yourself</b>.");
        ff.append("<br><br>");
        ff.append("We're flexible.  Everybody's different.  No peer pressure here.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-public.gif' width='16' height='16' alt='' border='0'> Public logs are visible to anybody</b> who goes to your site at the URL that you define.  They're available the moment that you create entries.  Instant.  Wham, bam, thank you mam.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-private.gif' width='16' height='16' alt='' border='0'> Private logs are only visible to you</b>.  Nobody else will even know that they exist.  This is cool because many of the insights that you can gain through a site like this can be personal.");
        ff.append("<br><br>");
        ff.append("<b><img src='../images/icon-password.gif' width='16' height='16' alt='' border='0'> Password Protected logs only visible to a select group of your friends or family</b>. When you create a Password Protected log you give it a password. Users go to your site, click 'Log In' and enter a password.  They then get to see logs that have that password.  If they don't have a password they won't even know that a log exists.  <b>This is important because you don't want your motorcycle buddies to know that you're the president of the local knitting club... or vice versa.</b>");
        ff.append("</font>");
        ff.append("<br><br>");
        ff.append("<br>");

        ff.append("</font>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer emailnewsletter(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Email Newsletter</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Allow your readers to subscribe to your site as an email newsletter.</font></p>");
        ff.append("<br><br>");
        ff.append("It's easy. Just one click turns the email newsletter feature on.  Your readers will be able to enter their email address to subscribe.  It's easy for them.");
        ff.append("<br><br>");
        ff.append("Once subscribed, your readers get to choose how often they want to get your site via email.  They can choose anything from every day to once a week to once a month.  Or they can choose a random time period like 13 days.  It's flexible.");
        ff.append("<br><br>");
        ff.append("You choose the hour of the day that you want the emails to be sent.  This way you know when to update your site by... what your deadline is.");
        ff.append("<br><br>");
        ff.append("Your readers can unsubscribe at any time without your intervention.");

        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");

        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-emailsignup.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Email Signup and Preferences</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>These are the preferences that your visitors have to choose from when they sign up for your email newsletter.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("</table>");


        ff.append("<br><br>");


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer multiplecontributors(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Multiple Contributors</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Got a publishing team scattered across the globe? No problem.</font></p>");
        ff.append("<br><br>");
        ff.append("Within each account you're able to have an unlimited number of contributors.  Each contributor has a separate login and password.  When they publish their web log entries are stamped with their name and timezones are automatically handled.");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");

        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-newuser.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>New User Account</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>It's easy to add other authors to your account and assign them very specific permissions.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("</table>");


        ff.append("<br><br>");


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer acl(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Access Control</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Give contributors a little or a lot of freedom.  Your choice.</font></p>");
        ff.append("<br><br>");
        ff.append("Giving a contributor access to your account is a big step.  You don't want them deleting or editing your entries.  Or maybe you don't want them to even know that you have a personal log named 'Me and My Cat Pepper.'  With the Access Control feature you, as the site owner, get to decide who can see which logs and who can do which features.");
        ff.append("<br><br>");

        //Permissions
        ff.append("<table cellpadding=6 cellspacing=0 border=0>");
        ff.append("<tr>");
        ff.append("<td valign=top align=left bgcolor=#e6e6e6>");
        ff.append("<b>");
        ff.append("<font face=arial size=-1>");
        ff.append("Access Control Permissions </font><br><font face=arial size=-2>(Things that can be turned on and off for each user):");
        ff.append("</font>");
        ff.append("</b>");
        ff.append("</td>");
        ff.append("</tr>");

        //Then get the array of aclobjects that this group can access
        reger.acl.AclObject[] aclObjects = reger.acl.AllAclObjects.getAllAclObjects();
        //Iterate through them, adding those that the user doesn't already have access to
        for (int i = 0; i < aclObjects.length; i++) {

            ff.append("<tr>");
            ff.append("<td valign=top align=left bgcolor=#ffffff>");
            ff.append("<font face=arial size=-1>");
            ff.append("<b>");
            ff.append(aclObjects[i].aclfriendlyname);
            ff.append("</b>");
            ff.append("</font>");
            ff.append("<br>");
            ff.append("<font face=arial size=-2>");
            ff.append(aclObjects[i].acldesc);
            ff.append("</font>");
            ff.append("</td>");
            ff.append("</tr>");

        }
        ff.append("</table>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer approval(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Publishing Approval</font></p>");
        ff.append("<p align=left><font face=arial size=+1>You can force web log entries to be approved by a site owner before they're published to the site.</font></p>");
        ff.append("<br><br>");
        ff.append("Sometimes it's best to get a second set of eyes on an entry before unleashing it on the world.  With the Publishing Approval feature you can set site contributors up so that a site owner must review entries first.  This level of safety keeps the quality of your site high.");
        ff.append("<br><br>");

        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer homepagecustomization(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Home Page Customization</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Your homepage doesn't have to be a plain old list of web log entries... not that there's anything wrong with that.</font></p>");
        ff.append("<br><br>");
        ff.append("You can customize your homepage to suit your own personality and needs.  Choose from a number of home page modules and arrange them on the screen as you see fit.  You can also customize the homepage of each of your logs.");
        ff.append("<br><br>");




        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer customservername(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Custom URL</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Make your site truly your own.</font></p>");
        ff.append("<br><br>");
        ff.append("If you have your own domain name you can point the DNS to our servers and we'll server your site under your domain name.  This is not required to run a site... just a nice feature for advanced users.");
        ff.append("<br><br>");


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer activityspecificlogtypes(int plid){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Activity-Specific Log Types</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Whatever you're interested in, we've probably got a log for it.</font></p>");
        ff.append("<br><br>");
        ff.append("Here's a list of the current log types:");
        ff.append("<br><br>");

        //List the log types
        ff.append(listLogTypes(plid));


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer favesites(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>Favorite Sites</font></p>");
        ff.append("<p align=left><font face=arial size=+1>Link to your friends online.  They'll probably return the favor.</font></p>");
        ff.append("<br><br>");
        ff.append("The Favorite Sites feature allows you to create and manage a list of your favorite sites without using Javascript or coding of any sort.  It's quick and easy.");
        ff.append("<br><br>");

        ff.append("<table cellpadding=10 cellspacing=0 border=0>");

        ff.append("<tr>");
        ff.append("<td valign=top>");
        ff.append(reger.core.Util.screenshotWithThumbnail("screenshot-favesites.gif"));
        ff.append("</td>");
        ff.append("<td valign=top>");
        ff.append("<font face=arial size=-1><b>Favorite Sites Maintenance Screen</b></font>");
        ff.append("<br><br>");
        ff.append("<font face=arial size=-1>This is the screen you use to manage your favorite sites.</font>");
        ff.append("<br><br>");
        ff.append("</td>");
        ff.append("</tr>");

        ff.append("</table>");


        ff.append("<br><br>");


        return ff;
    }

    /**
     * -----------------------------------------------
     * -----------------------------------------------
     */
    public static StringBuffer gps(){
        StringBuffer ff = new StringBuffer();

        ff.append("<p align=right><font face=arial size=+3>GPS: Global Positioning System</font></p>");
        ff.append("<p align=left><font face=arial size=+1>You can optionally log your exact coordinates.</font></p>");
        ff.append("<br><br>");
        ff.append("With the proliferation of GPS-enabled devices it's easy to lock in your exact location.  You may want to record your exact coordinates on a camping trip so that you can revisit the same spot twenty years from now.  The optional GPS feature allows you to define locations with GPS coordinates.");
        ff.append("<br><br>");


        return ff;
    }

    /**
     *
     */
    public static StringBuffer listLogTypes(int plid){
        StringBuffer ff = new StringBuffer();

        ff.append("<table cellspacing='0' cellpadding='5' border='0'>");


       int tr=0;

        //-----------------------------------
        //-----------------------------------
        String[][] rstEventtype= Db.RunSQL("SELECT pleventtypeid.eventtypeid, megalogname, megalogtype.icon, megalogtype.description FROM pleventtypeid, megalogtype WHERE plid='"+ plid +"' AND pleventtypeid.eventtypeid=megalogtype.eventtypeid ORDER BY pleventtypeid.priority ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstEventtype!=null && rstEventtype.length>0){
        	for(int i=0; i<rstEventtype.length; i++){


                ff.append("<!-- Begin Row -->");




                String imagename = rstEventtype[i][2];
                if (imagename.equals("")){
                    imagename = "logmega.gif";
                }

                String link =  "signup-log-type-detail.log?eventtypeid=" + rstEventtype[i][0] ;


                ff.append("<tr>");

                ff.append("<td bgcolor=#ffffff align=right valign=top>");
                ff.append("<a href='"+link+"'>");
                ff.append("<img src=../images/logimages/"+imagename+" width=100 height=50 border=0>");
                ff.append("</a>");
                ff.append("</td>");

                ff.append("<td bgcolor=#ffffff align=left valign=top>");
                ff.append("<a href='"+link+"'>");
                ff.append("<font face=arial size=+1><b>" + rstEventtype[i][1] + "</b></font><br>");
                ff.append("</a>");
                ff.append("<font face=arial size=-2>" + rstEventtype[i][3] + "</font>");
                ff.append("<br>");
                ff.append("<a href='"+link+"'>");
                ff.append("<font face=arial size=-2 style=\"font-size: 10px; font-weight:900;\">More Info About "+rstEventtype[i][1]+"</font>");
                ff.append("</a>");
                ff.append("<br>");
                ff.append("<br>");
                ff.append("</td>");

                ff.append("</tr>");



                ff.append("<!-- End Row -->");
        	}
        }



        ff.append("</table>");

        return ff;
    }


    public static String tourNavHtml(String pathToAppRoot, String prevLink, String prevText, String nextLink, String nextText){
        StringBuffer mb = new StringBuffer();

        mb.append(reger.ui.ShadowBox.start(pathToAppRoot));

        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td width=33% align=left valign=top nowrap>");
        if (!prevText.equals("")){
            mb.append("<font face=arial size=+2>");
            mb.append("<a href='"+prevLink+"'>");
            mb.append(prevText);
            mb.append("</a>");
            mb.append("</font>");
        }
        mb.append("</td>");
        mb.append("<td width=34% align=center valign=top>");
        mb.append("<font face=arial size=-1>");
        mb.append("<a href='signup.log'>");
        //mb.append("Start Logging Now!");
        mb.append("</a>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td width=33% align=right valign=top nowrap>");
        if (!nextText.equals("")){
            mb.append("<font face=arial size=+2>");
            mb.append("<a href='"+nextLink+"'>");
            mb.append(nextText);
            mb.append("</a>");
            mb.append("</font>");
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append(reger.ui.ShadowBox.end(pathToAppRoot));

        return mb.toString();
    }

    public static String screenShotWithDescription(String fileNameOfScreenshot, String align, String title, String desc){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=3 align="+align+" cellspacing=2 width=100% border=0>");

        mb.append("<tr>");
        mb.append("<td valign=top>");
        mb.append(reger.core.Util.screenshotWithThumbnail(fileNameOfScreenshot));
        mb.append("</td>");
        mb.append("<td valign=top>");
        mb.append("<font face=arial size=-1 color=#666666>");
        mb.append("<strong>");
        mb.append(title);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 color=#999999>");
        mb.append("<strong>");
        mb.append(desc);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("</table>");

        return mb.toString();
    }

    public static String screenShotBizWithDescription(String fileNameOfScreenshot, String align, String title, String desc){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=5 align="+align+" cellspacing=5 width=350 border=0 bgcolor=#cccccc>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#ffffff>");

        mb.append("<center>");

        mb.append("<font face=arial size=-1 color=#666666>");
        mb.append("<strong>");
        mb.append(title);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 color=#999999>");
        mb.append("<strong>");
        mb.append(desc);
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("<br>");

        mb.append("<a href='imagedisplay.log?imagename="+fileNameOfScreenshot+"' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        mb.append("<img src='images/databloggingscreens/thumbs/"+fileNameOfScreenshot+"' alt='' border='0'>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 style=\"font-size: 11px; font-weight:900;\">");
        mb.append("+ ZOOM SCREENSHOT");
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</center>");


        mb.append("</td>");

        mb.append("</tr>");


        mb.append("</table>");

        return mb.toString();
    }


}
