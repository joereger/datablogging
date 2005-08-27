package reger.marketingSite;
import java.util.Vector;

/**
 * A nice pretty grid that displays what's in Pro and what's in the regular site.
 *
 * Example Feature
 * cat.addFeature(new ProFeature("Feature Name", true, "link to page dedicated to feature, if available", "screenshot-filename.gif", "Description of feature here.", "Text appearing in free box", "Text appearing in pro box"));
 *
 */
public class ProFeaturesGrid {

    public static Vector getFeaturesVector(){
        //Vector to hold all features
        Vector features = new Vector(100);
        ProCategory cat;




        //Start Category: Web Logging Featues
        cat = new ProCategory("Web Logging Features");
        cat.addFeature(new ProFeature("Publishing Tool", true, "about/features.log?feature=admin", "screenshot-adminhome.gif", "Allows you to quickly and easily create web log entries.  Think of these like journal entries.  They can be short and sweet or long and involved.  You can create entries many times a day or once every now and then.  The publishing tool makes it easy for you to update your site.  You don't need to know any sort of coding or html... you simply need to type your entry and click \"Add Log Entry\".", "", ""));
        cat.addFeature(new ProFeature("A Home For Your Site", true, "", "Once you create your entries they're published automatically (you can also keep them private if you like) to your public site where friends, family, associates and the web at large can view them.  You can register your site in search engines and build your readership.  You get your own URL that you can publicize.", "", ""));
        cat.addFeature(new ProFeature("Comparison to Other Publishing Tools", true, "about/features.log?feature=comparison", "It's very similar but also very different.  The best of other publishing tools with a whole bunch of exciting new features.", "", ""));
        features.add(cat);
        //End Category: Web Logging Featues

        //Start Category: Post
        cat = new ProCategory("Post Features");
        cat.addFeature(new ProFeature("WYSIWYG Editor", true, "", "screenshot-addentrywysiwyg.gif", "Edit complex web log entries with links, fonts, smilies and other formatting just like in a word processor.", "", ""));
        cat.addFeature(new ProFeature("Spell Checking", false, "", "screenshot-spellcheck.gif", "Powerful spell checking capability keeps you looking and sounding good.  Our spell checked utilizes a fast dynamic interface to give you recommendations and the ability to manually change a word at the same time.", "", ""));
        cat.addFeature(new ProFeature("Text Editor", true, "", "screenshot-addentrysimple.gif", "Some people prefer the simplicity of text-only logging so you're able to turn off the WYSIWYG editor.", "", ""));
        cat.addFeature(new ProFeature("Entry Titles", true, "", "Each entry has a title.", "", ""));
        cat.addFeature(new ProFeature("Arbitrary Dates", true, "", "You can arbitrarily choose the date of your entry to be any time in the present, future or past.", "", ""));
        cat.addFeature(new ProFeature("Location", true, "", "Each entry can have a location.  You can choose from previously-used locations or you can add a new one.", "", ""));
        cat.addFeature(new ProFeature("GPS", true, "about/features.log?feature=gps", "Optional GPS feature allows you to enter Global Positioning Sattelite coordinates for a location.", "", ""));
        cat.addFeature(new ProFeature("Favorite Entries", true, "", "You can choose to make each entry a favorite entry.", "", ""));
        cat.addFeature(new ProFeature("Ago Text Stamp", true, "", "Your entries will be stamped with text like '2 Days Ago' or '34 Minutes Ago' or '12 Seconds Ago.'", "", ""));
        cat.addFeature(new ProFeature("Trackback Inbound", true, "", "Allow other sites to tell you when they're writing about you.", "", ""));
        cat.addFeature(new ProFeature("Trackback Outbound", true, "", "Tell other sites when you're writing about them.", "", ""));
        cat.addFeature(new ProFeature("Ping Weblogs.com", false, "", "Tell weblogs.com each time you make an entry.  This feature can be turned on or off with a single click.", "", ""));
        features.add(cat);
        //End Category: Post

        //Start Category: Activity-Specific Log Types
        cat = new ProCategory("Activity-Specific Log Types");
        cat.addFeature(new ProFeature("Basic Log Type", true, "", "This is the traditional web log and can be used for any sort of logging.", "", ""));
        cat.addFeature(new ProFeature("Activity-Specific Log Types", true, "about/features.log?feature=activityspecificlogtypes", "Sure, we have a very powerful basic web log. But we also have activity-specific web logs for anything you're interested in... running, biking, swimming, dreaming... many to choose from. By adding additional data fields and providing graphical reports, web logging takes on increased relevance in specific activities.  You're able to keep track of quantifiable information and mine that information for wisdom.", "", ""));
        cat.addFeature(new ProFeature("Prebuilt Charts and Graphs", true, "about/features.log?feature=chartsandgraphs", "The power of specialized log types: cool charts and graphs. The prebuilt charts and graphs focus on activity-specific elements.  For example, the Running Log has a summary of runs by shoe worn.", "", ""));
        cat.addFeature(new ProFeature("Custom Charts and Graphs", true, "", "You're able to create and save your own custom charts and graphs.  You choose from pie charts, bar charts, line charts, etc.  Then you choose the fields to display.  And you can filter by smart date periods like 'Last Week' or 'Year To Date.'", "", ""));
        cat.addFeature(new ProFeature("Multiple Web Logs Per Site", true, "", "screenshot-newlog.gif", "Add as many web logs as you like to your site.", "", ""));
        cat.addFeature(new ProFeature("Mix Private and Public Web Logs", true, "", "You can have private and public web logs on one site.  Nobody will know that your private web logs even exist.", "", ""));
        cat.addFeature(new ProFeature("Custom Default Field Values", true, "", "Store a set of default values for your activity-specific logs.  This will save you time with your logging.  For example, make your Nike Red Shoes the default on your Running log so that you don't have to select them from a dropdown each time you make a log entry.  Efficient.", "", ""));
        cat.addFeature(new ProFeature("Add/Edit/Delete Logs Any Time", true, "", "At any time after you sign up you can add, edit or delete logs.", "", ""));
        features.add(cat);
        //End Category: Activity-Specific Log Types

        //Start Category: Personal Profile
        cat = new ProCategory("Personal Profile Features");
        cat.addFeature(new ProFeature("A Full Personal Profile", true, "", "", "Each author in the account creates their own personal profile.", "", ""));
        cat.addFeature(new ProFeature("Profile Pictures", true, "", "", "Add images to your profile.", "", ""));
        cat.addFeature(new ProFeature("Personal Fields", true, "", "", "You can add unlimited personal fields to your profile.  You're not limited to the basic \"Age, Hobbies, etc.\" fields.  You can add interesting things like \"Last Time I Ate Green Eggs and Ham.\"", "", ""));
        cat.addFeature(new ProFeature("Post Counts", true, "", "", "Your profile includes a count of the number of posts you've made to each of your logs.", "", ""));
        features.add(cat);
        //End Category: SPersonal Profile

        //Start Category: Social Network Features
        cat = new ProCategory("Social Networking Features");
        cat.addFeature(new ProFeature("Invite Friends by Email Tool", true, "", "", "It's easy to add friends to your personal network.  Simply enter their email address and they'll be invited.", "", ""));
        cat.addFeature(new ProFeature("Invitation Status", true, "", "", "See the status of your friend invitations:  Open, Viewed, Accepted, Rejected.", "", ""));
        cat.addFeature(new ProFeature("Friends List", true, "", "", "Your profile includes a list of friends so that you can network with each other.", "", ""));
        cat.addFeature(new ProFeature("Friends Most Recent Post List", true, "", "", "See a list of the most recent posts by your friends.  Keeps you in the loop.", "", ""));
        cat.addFeature(new ProFeature("Friends Messaging", true, "", "", "Send your network of friends a message.", "", ""));
        cat.addFeature(new ProFeature("Inbox", true, "", "", "A central place to view all inbound messages from your friends.", "", ""));
        features.add(cat);
        //End Category: Social Network Features



        //Start Category: Public Site Features
        cat = new ProCategory("Site Customization Features");
        cat.addFeature(new ProFeature("Messages/Comments", true, "about/features.log?feature=messages", "Your readers can post messages to your site if you choose to let them.  Turning messages on and off is a single click operation.", "", ""));
        cat.addFeature(new ProFeature("Message/Comment Approval", true, "", "screenshot-trafficmessages.gif", "Message/Comment approval.  You can configure your site so that you must approval a message before it appears on your public site.", "", ""));
        cat.addFeature(new ProFeature("Your Own Subdomain URL", true, "about/features.log?feature=freehosting", "Choose your own subdomain name.  It's nice and clean. You're not stuck off in a subdirectory.  You have a full subdomain URL of your own.", "", ""));
        cat.addFeature(new ProFeature("Point Your Domain", true, "about/features.log?feature=customservername", "Already got a domain name?  Not a problem.  You can point your domain name to our server and it will serve your web log. This means that you have your own full domain name.", "", ""));
        cat.addFeature(new ProFeature("Favorite Entries", true, "", "A list of your favorite entries helps focus your readers on what you want them to read.", "", ""));
        cat.addFeature(new ProFeature("Homepage Layout Customization", true, "about/features.log?feature=homepagecustomization", "screenshot-hplayout.gif", "Tired of the standard web log reverse chronological entry list? You're able to add calendars, random image lists, most recent image lists, headlines, most read headlines and more in a custom layout on your homepage.", "", ""));
        cat.addFeature(new ProFeature("Entries By Location", true, "", "Your visitors can view all entries for a particular location. This is fun because it allows you to see all the times you ate ate a particular restaurant, for example.", "", ""));
        cat.addFeature(new ProFeature("Calendar", true, "", "View web log entries in a calendar format.", "", ""));
        cat.addFeature(new ProFeature("Images by Log and Image Category", true, "", "You get a list of all images that your viewers can zoom into by specifying a particular log or image category.", "", ""));
        cat.addFeature(new ProFeature("Entries on Homepage", true, "", "Decide how many of the most recent web log entries you want to put onto your homepage.", "", ""));
        cat.addFeature(new ProFeature("Entry Summary Characters", true, "", "On lists of web log entries like the homepage you can display the entire web log entry or just a specified number of characters.", "", ""));
        cat.addFeature(new ProFeature("Hide Home Button", true, "", "Choose to hide the Home button.  This works well when you're trying to integrate your web log into another site.", "", ""));
        cat.addFeature(new ProFeature("Custom Home Button Text", true, "", "Customize the home button text.  Be fun... be creative.", "", ""));
        cat.addFeature(new ProFeature("Hide Login Button", true, "", "You may not want to have a Login button hanging out there on your site.  It's easy to hide it... just make sure you remember how to get to your Admin section.", "", ""));
        cat.addFeature(new ProFeature("Don't Show Entries From Specified Logs On Homepage", true, "", "You can decide to hide entries from the homepage for specific logs.  Sometimes you log something mundane rather frequently... as with the Caffeine Log. You don't want your homepage to be cluttered with this data so you configure the Caffeine Log to not show its entries on the homepage.  Problem solved.", "", ""));
        cat.addFeature(new ProFeature("Homepage HTML Description", true, "", "Give your site a description.  Use HTML if you like.", "", ""));
        cat.addFeature(new ProFeature("Log HTML Description", true, "", "Give each log a description.  Use HTML if you like.", "", ""));
        cat.addFeature(new ProFeature("Log Names", true, "", "You get to name each log on your site.  Just because it's a Running Log doesn't mean it has to be called Running Log.  Call it 'Joe's Crazy Running Adventures.'", "", ""));
        cat.addFeature(new ProFeature("On This Day", false, "about/features.log?feature=onthisday", "screenshot-onthisday.gif", "Your web log will display other entries from the same date in your web logging history.", "", ""));
        cat.addFeature(new ProFeature("Site Search", false, "about/features.log?feature=search", "Your visitors can search your web log entries.", "", ""));
        cat.addFeature(new ProFeature("Favorite Sites", false, "about/features.log?feature=favesites", "screenshot-favesites.gif", "Got friends online? Create and manage a list of your favorite sites without javascript tricks or coding.", "", ""));
        cat.addFeature(new ProFeature("Related Links", false, "about/features.log?feature=relatedlinks", "screenshot-relatedlinks.gif", "Related Entries is a feature that automatically shows your readers other log entries that may be related or similar to the one they're reading.", "", ""));
        cat.addFeature(new ProFeature("Remove Advertising", false, "", "When you upgrade you remove advertising from your site.", "", ""));
        cat.addFeature(new ProFeature("Remove Powered By Logo", false, "", "When you upgrade you remove the little Powered By logo that appears on your site.  Nobody will know that you didn't build the whole thing on your own.", "", ""));
        features.add(cat);
        //End Category: Public Site Features

        //Start Category: Templates
        cat = new ProCategory("Site Templates/Skins Support");
        cat.addFeature(new ProFeature("Easy Templates", true, "about/features.log?feature=templates", "Change the look, feel, colors and layouts of your site with pre-built templates or customize your own. Complete template engine with custom tags.", "", ""));
        cat.addFeature(new ProFeature("Custom Templates", true, "about/features.log?feature=templates", "screenshot-customskin.gif", "If you know HTML and CSS you can completely control your template.  You have an overall layout template to control.  And a log entry listing template.  Combined you can completely control the look of your web log.", "", ""));
        cat.addFeature(new ProFeature("Template Markup Language", true, "", "A template markup language that allows you to completely control which data elements go where on your site.", "", ""));
        features.add(cat);
        //End Category: Templates

        //Start Category: Image/Media Support
        cat = new ProCategory("Image/Media Support");
        cat.addFeature(new ProFeature("Add Image/Media to Entry", true, "", "Upload an image, sound, video or other file with your entry.", "", "Pay only for what you use."));
        cat.addFeature(new ProFeature("Multiple Images/Media Per Entry", true, "", "You can associate any number of media files to a single web log entry.  This makes it easy to put all of your pictures for, say, a birthday party under a single entry.", "", ""));
        cat.addFeature(new ProFeature("Ordering", true, "", "Control the order from top to bottom of your image/media files.", "", ""));
        cat.addFeature(new ProFeature("Keyword Tags", true, "", "Assign tags to photos to help organize them.", "", ""));
        cat.addFeature(new ProFeature("Multiple Upload", true, "", "You don't have to upload a single file at a time.  You can upload up to ten at once.  And then go back for more.", "", ""));
        cat.addFeature(new ProFeature("Polar Heart Rate Monitor Support", true, "", "Upload heart monitor .hrm files and get custom dynamic charts and graphs.  Compare workouts to one another.", "", ""));
        cat.addFeature(new ProFeature("Advanced Upload Applet", false, "", "Powerful Java applet to upload any number of files.  Add a complete directory with a single click.  View upload progress.", "", ""));
        features.add(cat);
        //End Category: Image/Media Support

        //Start Category: Post Methods
        cat = new ProCategory("Ways to Post to Your Web Log");
        cat.addFeature(new ProFeature("Web", true, "", "Use the powerful Admin section of your site.", "", ""));
        cat.addFeature(new ProFeature("Open APIs", true, "about/features.log?feature=api", "MetaWebLogAPI and Blogger API support allow you to use third party logging tools.", "", ""));
        cat.addFeature(new ProFeature("Cell Phone / WAP Device", true, "", "Use a cell phone or other WAP-enabled device to make web log entries.", "", ""));
        cat.addFeature(new ProFeature("Email", false, "", "Post by email to a specific log.", "", ""));
        cat.addFeature(new ProFeature("Camera Phone / Moblogging", false, "", "Post images from cell phones with cameras built into them.", "", ""));
        features.add(cat);
        //End Category: Post Methods

        //Start Category: Relationships Between Entries
        cat = new ProCategory("Relationship Between Entries");
        cat.addFeature(new ProFeature("Time Periods", true, "", "Time Periods are simple.  They have a start date and an end date.  A web log entry that falls between the Time Period dates is considered part of the Time Period.  Use it to define parts of your life ('In College', 'Living in Atlanta', etc.), parts of a project or anything else that comes to mind.  This is a good way to create relationships between entries in different web logs.", "", ""));
        features.add(cat);
        //End Category: Relationships Between Entries

        //Start Category: Site Reporting
        cat = new ProCategory("Site Reporting Features");
        cat.addFeature(new ProFeature("Traffic Summary Page", true, "about/features.log?feature=traffic", "screenshot-trafficmain.gif", "Publishing is important. But to be able to tailor your message to your readership... or at least understand the effects of your words on your readership... you need a detailed view of what's happening.", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Entry Traffic", true, "", "screenshot-trafficentries.gif", "See what entries are being read the most.", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Browser Type", true, "", "screenshot-trafficlogs.gif", "Which logs are the most popular?", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Image Traffic", true, "", "screenshot-trafficimages.gif", "Which images are being viewed the most?", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Browser Type", true, "", "screenshot-trafficbrowsers.gif", "What browsers are your readers using? Use this page to find out.", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Referers", true, "", "screenshot-trafficreferers.gif", "Where is your traffic coming from? Search engines? Other web logs? This page will tell you.", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Raw Clicks", true, "", "screenshot-trafficclicks.gif", "Not big on summarized data? You want the raw data. We understand. This page will show you each click that is made on your site. Watch it all day. Watch it all night. Be careful... it's addictive.", "Current Day NOT Included", "Current Day Included"));
        cat.addFeature(new ProFeature("Search Report", true, "", "screenshot-trafficsearches.gif", "You get to see when and what people search your site for.", "", ""));
        cat.addFeature(new ProFeature("Last Entry by Log", true, "", "screenshot-entryzoom.gif", "See how long it's been since you updated each log.", "", ""));
        cat.addFeature(new ProFeature("Total Entries by Log", true, "", "Get a running total of the number of entries you've made in each log.", "", ""));
        cat.addFeature(new ProFeature("SuperCookie", false, "", "screenshot-supercookie.gif", "The Supercookie tells your site that it's you visiting it... not a visitor. So... what good does that do me? Glad you asked. This comes in handy when you are looking at your traffic stats. You probably don't want to see traffic stats that reflect your own activity. You want to see visitors... other people... not you. This allows you to surf your own site as much as you like without affecting your traffic statistics. Pretty cool eh?", "", ""));
        features.add(cat);
        //End Category: Site Reporting

        //Start Category: Administration
        cat = new ProCategory("Site Administration Features");
        cat.addFeature(new ProFeature("Powerful Administration Site", true, "about/features.log?feature=admin", "The Administration site is where you create log entries.  Designed to make your logging quick and easy.  Everything is at your fingertips in a low-bandwidth interface that's zippy and responsive..", "", ""));
        cat.addFeature(new ProFeature("Multiple Contributing Authors", true, "about/features.log?feature=multiplecontributors", "You can assemble a team of publishers from around the world, each with a different timezone preference.", "", ""));
        cat.addFeature(new ProFeature("Access Control Per Author", true, "about/features.log?feature=acl", "screenshot-newuser.gif", "Control what logs a contributor can see and what things a contributor can do.  If you don't give an author permission to a certain log, they won't even know it exists.", "", ""));
        cat.addFeature(new ProFeature("Publishing Approval", true, "about/features.log?feature=approval", "Get a second opinion. This feature allows you to review contributor entries before they get published, if you so choose", "", ""));
        cat.addFeature(new ProFeature("Move Entry to Another Log", true, "", "", "Move an entry to another log.  Move any entry to any log.  All messages, images, files, trackbacks, traffic data and other information will be moved.  If it's the same type of activity-specific log all extended data will be retained as well.", "", ""));
        cat.addFeature(new ProFeature("Smart Log Delete", true, "", "screenshot-deletelog.gif", "Just because you delete a log doesn't mean you want to delete the entries in it.  Smart log delete allows you to move your existing entries to another log of the same log type when you delete.", "", ""));
        cat.addFeature(new ProFeature("AdminTools", false, "about/features.log?feature=admin", "screenshot-admintools.gif", "AdminTools allow you to edit your site in place.  You see your public site as your visitors would see it but unlike them you also have a powerful toolbar at your disposal with numerous functions relevant to the entry or log that you're looking at.", "", ""));
        cat.addFeature(new ProFeature("Linkrot Fixer", false, "", "", "The Linkrot Fixer helps you diagnose and fix broken outbound links on your site.  Every night the system looks for links in your web log entries and spiders them to see if they're still valid links.  When broken links are found the system flags them as such and gives you an opportunity to fix them quickly and easily.  A cached version of keywords from the page you linked to is sent to Google which responds with a set of recommendations.  If other users have fixed the same link you'll be able to see (in a depersonalized manner) what they fixed it with.  This saves you time and increases the quality of your site.", "", ""));
        features.add(cat);
        //End Category: Administration


        //Start Category: Security
        cat = new ProCategory("Security Features");
        cat.addFeature(new ProFeature("Password Protection at the Log Level", true, "about/features.log?feature=password", "Keep your site private, share it with a few friends, open it to the world. With separate password control for each log you have the flexibility.", "", ""));
        cat.addFeature(new ProFeature("Image Protection", true, "", "Images are never exposed on a web server.  All access to images that you post is done through a security-controlled program that makes sure only allowed users can see them.", "", ""));
        cat.addFeature(new ProFeature("QuickPass Log Password", true, "", "If you have a private log that you want to share with a large but closed audience you don't want to give permission to view that log to each person individually.  So you add a QuickPass password to the log and tell your community what the password is.  They log in with a single password and view the log that you've given them permission to view.", "", ""));
        features.add(cat);
        //End Category: Security

        //Start Category: Email Subscriptions
        cat = new ProCategory("Email Subscriptions");
        cat.addFeature(new ProFeature("Easy Email Subscription Signup", false, "", "screenshot-emailsignup.gif", "Your site visitors have a very quick and easy way to signup to get your site sent to them via email.", "", ""));
        cat.addFeature(new ProFeature("Visitor Chooses Frequency of Send", false, "", "Your site visitors choose how often they want to get your site sent to them via email.  Daily, weekly, every 13 days, etc.", "", ""));
        cat.addFeature(new ProFeature("HTML/Plain Text", false, "", "Your site visitors choose whether to recieve your site in html or plain text email.", "", ""));
        cat.addFeature(new ProFeature("You Choose Send Hour", false, "", "You determine what hour of the day your email subscriptions are sent out.", "", ""));
        features.add(cat);
        //End Category: Email Subscriptions


        //Start Category: Syndication
        cat = new ProCategory("Syndication Features");
        cat.addFeature(new ProFeature("RSS Site Feed", true, "about/features.log?feature=rss", "Syndicate your writing with RSS/XML. Quick. Easy. No brainer.", "", ""));
        cat.addFeature(new ProFeature("RSS Feeds for Individual Logs", false, "", "Each log has an individual RSS feed.  This is important because it allows your business friends to focus on your business writings and your fitness friends to only read your fitness entries.", "", ""));
        cat.addFeature(new ProFeature("Activity-Specific Data Available", false, "", "Your RSS Feeds shares activity-specific data.  For example, the running log RSS feed puts distance run, running time and other fields into the RSS feed.", "", ""));
        cat.addFeature(new ProFeature("Javascript Embedding", false, "", "screenshot-javascriptembedding.gif", "You can embed your web log entries into another site simply by copying and pasting a single line of code.", "", ""));
        features.add(cat);
        //End Category: Syndication

        //Start Category: Cell Phone
        cat = new ProCategory("Cell Phone / WAP Features");
        cat.addFeature(new ProFeature("Post by Cell Phone / WAP Device", true, "", "You can post to your web log from anywere using a cell phone or other WAP-enabled device.", "", ""));
        cat.addFeature(new ProFeature("Access Traffic Data by Cell Phone", true, "about/features.log?feature=wap", "View your site traffic and see how many new messages your site has via cell phone or other WAP device. Never feel like you're out of touch with your readership.", "Current Day NOT Included", "Current Day Included"));
        features.add(cat);
        //End Category: Cell Phone

        //Start Category: Cell Phone
        cat = new ProCategory("Camera Phone / Moblogging Features");
        cat.addFeature(new ProFeature("Special Camera Phone Features", false, "", "screenshot-camphonesettings.gif", "There are a number of settings that allow you to control how your camera phone posts to your web log.", "", ""));
        cat.addFeature(new ProFeature("Daily Camera Phone Photo Aggregation", false, "", "If you post a lot of camera phone images to your site it can make your site look somewhat messy.  You can choose to aggregate all camera phone entries from one day into a single entry.  That keeps things nice and clean.", "", ""));
        cat.addFeature(new ProFeature("Override Camera Phone Subject", false, "", "When posting with your camera phone it's often difficult to type a meaningful message with those tiny phone keys. This setting allows you to override any subject that is sent from the phone with what's in the box to the right. This is convenient because it allows you to quickly click and send without worrying about how the subject appears on your site. Use <$Date$> to have the server put a date in the title for you. For example \"Phone Cam Pics From <$Date$>\"", "", ""));
        cat.addFeature(new ProFeature("Default Image Category", false, "", "Configure your site so that camera phone images are automatically stored in the correct image category.", "", ""));
        cat.addFeature(new ProFeature("Log Specific", false, "", "You can target camera phone messages to specific web logs.", "", ""));
        cat.addFeature(new ProFeature("Ignore Camera Phone Message Body", false, "", "Similar to the Override Subject for camera phones. Some cell phone companies automatically put an advertisement or other text in the body of camera phone messages. You can use this setting to override such text.", "", ""));
        cat.addFeature(new ProFeature("Save Incoming Camera Phone Images as Draft", false, "", "Allows you to send camera phone entries to your web log without publishing them. They will remain in Draft until you log in to your Admin section and publish them. This is a convenient way to start entries by camera phone and then finish and publish them with the more powerful Admin section.", "", ""));
        cat.addFeature(new ProFeature("Email Secret", false, "", "Choose an email secret so that you don't transfer your site's main password over email networks.  Higher security.", "", ""));
        features.add(cat);
        //End Category: Cell Phone




        return features;
    }

    public static StringBuffer getHtml(boolean showComparison, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        mb.append(reger.core.Util.popup());

        //Put the stylesheet on there
        mb.append(getCss(showComparison));

        //Get the main vector
        Vector features = getFeaturesVector();

        //Start the features table
        mb.append("<table border='0' cellspacing='0' cellpadding='2'>");

        for (int i = 0; i < features.size(); i++) {
            //Get the category
            ProCategory cat = (ProCategory) features.elementAt(i);


                mb.append("<tr>");
                mb.append("<td>");
                if (i>0){
                    mb.append("<br />");
                }
                mb.append("</td>");
                if (showComparison){
                    mb.append("<td colspan='4' style='border-bottom:1px solid #a6a6a6'><br /></td>");
                }
                mb.append("</tr>");


                mb.append("<tr>");
                mb.append("<th class='category'>"+cat.name+"</th>");
                if (showComparison){
                    mb.append("<th width='125' class=headerfree>Free</th>");
                    mb.append("<th width='125' class=header>Pro</th>");
                }
                mb.append("</tr>");


            //Get the individual features
            Vector individualfeatures = cat.features;

            //Iterate each individualfeature
            for (int j = 0; j < individualfeatures.size(); j++) {
                ProFeature feature = (ProFeature) individualfeatures.elementAt(j);

                mb.append("<tr>");
                mb.append("<td class='feature'>");
                mb.append("<font face=arial size=-1 class=featurename>");
                if (!feature.url.equals("")){
                    mb.append("<a href='"+pathToAppRoot+feature.url+"'>");
                }
                mb.append(feature.name);
                if (!feature.url.equals("")){
                    mb.append("</a>");
                }
                if (!feature.screenshot.equals("")){
                    mb.append(" (");
                    mb.append(reger.core.Util.screenshotTextLink(feature.screenshot, pathToAppRoot));
                    mb.append(")");
                }
                mb.append("</font>");
                if (!feature.description.equals("")){
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2 class=featuredescription>");
                    mb.append(feature.description);
                    mb.append("</font>");
                }
                mb.append("</td>");

                if (showComparison){
                    mb.append("<td class=free>");
                    if (feature.isfree){
                        mb.append("<font face=arial size=-2 class=featurename>");
                        mb.append("Yes");
                        mb.append("</font>");
                        if (!feature.freetext.equals("")){
                            mb.append("<br>");
                            mb.append("<font face=arial size=-2>");
                            mb.append(feature.freetext);
                            mb.append("</font>");
                        }
                    } else {
                        mb.append("-");
                        if (!feature.freetext.equals("")){
                            mb.append("<br>");
                            mb.append("<font face=arial size=-2>");
                            mb.append(feature.freetext);
                            mb.append("</font>");
                        }
                    }
                    mb.append("</td>");
                    mb.append("<td class=pro>");
                    mb.append("<font face=arial size=-2 class=featurename>");
                    mb.append("Yes");
                    mb.append("</font>");
                    if (!feature.protext.equals("")){
                        mb.append("<br>");
                        mb.append("<font face=arial size=-2>");
                        mb.append(feature.protext);
                        mb.append("</font>");
                    }
                    mb.append("</td>");
                }

                mb.append("</tr>");

            }


        }

        mb.append("</table>");


        return mb;
    }

    public static StringBuffer getCss(boolean showComparison){
        StringBuffer mb = new StringBuffer();

        mb.append("<style type=\"text/css\">");

        mb.append(".category");
        mb.append("{");
            mb.append("font-size:22px;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-weight:bold;");
            mb.append("color:#cccccc;");
            mb.append("border-bottom:1px solid #a6a6a6;");
            mb.append("text-align: left;");
        mb.append("}");

        mb.append(".feature");
        mb.append("{");
            if (showComparison){
                mb.append("border-bottom:1px solid #a6a6a6;");
            }
        mb.append("}");

        mb.append(".featurename");
        mb.append("{");
            mb.append("color:black;");
            mb.append("font-weight:bold;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:14px;");
        mb.append("}");

        mb.append(".featuredescription");
        mb.append("{");
            mb.append("color:black;");
            mb.append("font-family: Geneva, Arial, Helvetica, Swiss, SunSans-Regular;");
            mb.append("font-size:12px;");
        mb.append("}");

        mb.append(".free");
        mb.append("{");
            mb.append("text-align:center;");
            mb.append("background-color:#e6e6e6;");
            mb.append("border-bottom:1px solid #a6a6a6;");
            mb.append("border-right:1px solid #a6a6a6;");
            mb.append("border-left:1px solid #a6a6a6;");
        mb.append("}");

        mb.append(".pro");
        mb.append("{");
            mb.append("background-color:#dedede;");
            mb.append("text-align:center;");
            mb.append("border-bottom:1px solid #a6a6a6;");
            mb.append("border-right:1px solid #a6a6a6;");
        mb.append("}");

        mb.append(".header");
        mb.append("{");
            mb.append("font-size:12px;");
            mb.append("font-weight:bold;");
            mb.append("text-align:center;");
            mb.append("border-bottom:1px solid #a6a6a6;");
            mb.append("border-right:1px solid #a6a6a6;");
        mb.append("}");

        mb.append(".headerfree");
        mb.append("{");
            mb.append("font-size:12px;");
            mb.append("font-weight:bold;");
            mb.append("text-align:center;");
            mb.append("border-bottom:1px solid #a6a6a6;");
            mb.append("border-right:1px solid #a6a6a6;");
            mb.append("border-left:1px solid #a6a6a6;");
        mb.append("}");



        mb.append("</style>");

        return mb;
    }











}
