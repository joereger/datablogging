package reger.api;

import reger.core.db.Db;
import reger.core.Debug;
import reger.core.DateDiff;
import reger.api.rome.MegaDataRSSModule;
import reger.api.rome.MegaDataRSSModuleImpl;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.Log;
import reger.Account;
import reger.Accountuser;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.rss.*;
import com.sun.syndication.feed.synd.*;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Generator;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.io.*;
import org.apache.log4j.Logger;

/**
 *
 */
public class RssRome {


    public static StringBuffer getFeed(reger.UserSession userSession, int logid, int limititems, String feedType, String password, int eventid){
        //Verify that we have a valid feed type
        if (!verifyType(feedType)){
            //Default value if fail
            feedType = "rss_2.0";
        }

        //If we have a password, do a quick login on it.
        //if (password!=null && !password.equals("")){
            //userSession.getAccountuser().quickLogLogin(password);
        //}

        //Call the appropriate Atom or RSS feed generator
        if (feedType.substring(0,4).equals("atom")){
            return getFeedAtom(userSession, logid, limititems, feedType, eventid);
        } else {
            return getFeedRss(userSession, logid, limititems, feedType, eventid);
        }

    }



    private static StringBuffer getFeedRss(reger.UserSession userSession, int logid, int limititems , String feedType, int eventid){
        StringBuffer fd = new StringBuffer();

        //Create Rome Feed Object
        Channel rssChannel = new Channel(feedType);

        //Channel Title
        String channelTitle = userSession.getAccount().getHomepagetitle();
        if (channelTitle.equals("")) {
            channelTitle="" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        rssChannel.setTitle(channelTitle);

        //Channel Description
        String channelDesc = userSession.getAccount().getHomepagehtml();
        if (channelDesc.equals("")) {
            channelDesc="A blog called " + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        rssChannel.setDescription(channelDesc);

        //Channel Link
        String channelLink = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        rssChannel.setLink(channelLink);

        //Channel Generator
        String channelGenerator = "Reger.com datablogging Server";
        rssChannel.setGenerator(channelGenerator);

        //Build logid-dependent sql
        String logidSql="";
        if (logid>0) {
            logidSql=" AND event.logid='"+logid+"'";
        }

        //EventidSql
        String eventSql = "";
        if (eventid>0){
            eventSql = " AND event.eventid='" + eventid + "' ";
        }

        //Language
        //rssChannel.setLanguage("English");

        //Create Items
        java.util.Vector itemList = new java.util.Vector();


        //date, eventid, event.logid, title, comments, megalog.name, accountuser.friendlyname, megalog.logaccess, megalog.password

        //Go to database
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT eventid FROM event WHERE "+reger.Entry.sqlOfLiveEntry+" AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), false)+""+logidSql+" "+eventSql+" ORDER BY event.date DESC LIMIT 0, "+limititems+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	for(int i=0; i<rstEvent.length; i++){

                //Go get the entry from the cache
                reger.Entry entry = reger.cache.EntryCache.get(Integer.parseInt(rstEvent[i][0]));

                //See if this is an auto title... if so, don't post for a couple days
                if (!isAutoNamedJobbie(entry, userSession.getAccountuser(), userSession.getAccount())){

                    //Get log name
                    String logname="";
                    Log log = reger.cache.LogCache.get(entry.logid);
                    if (log!=null){
                        logname = log.getName();
                    }

                    //Create a Rome RSS Item
                    Item item = new Item();

                    //Item Pubdate
                    //Correct format is:
                    //Sat, 07 Sep 2002 0:00:01 GMT

                    //reger.core.TimeUtils.gmttousertime(entry.dateGmt, userSession.getAccount().getTimezoneid())

                    //Calendar gmttime = reger.core.TimeUtils.gmttousertime(rstEvent[i][0], userSession.getAccount().getTimezoneid());
                    Calendar gmttime = reger.core.TimeUtils.usertogmttime(entry.dateGmt, userSession.getAccount().getTimezoneid());
                    item.setPubDate(gmttime.getTime());

                    //Item Link
                    String entryurl=reger.Entry.entryFileNameStatic(entry.logid, entry.eventid, entry.title);
                    String itemLink="" +userSession.getAccount().getSiteRootUrl(userSession) +"/" + entryurl;
                    if (log.getLogaccess()==reger.Vars.LOGACCESSPRIVATE){
                        if (log.getPassword()!=null && !log.getPassword().equals("")){
                            itemLink = itemLink + "?qpass=" + log.getPassword();
                        }
                    }
                    item.setLink(itemLink);

                    //Guid
                    String entryurlGuid=reger.Entry.entryFileNameStaticNoWords(entry.logid, entry.eventid);
                    String itemLinkGuid="" +userSession.getAccount().getSiteRootUrl(userSession) +"/" + entryurlGuid;
                    Guid guid = new Guid();
                    guid.setPermaLink(true);
                    guid.setValue(itemLinkGuid);
                    item.setGuid(guid);

                    //Item title
                    String itemTitle = entry.title;
                    item.setTitle(itemTitle);

                    //Item Comments Link
                    String itemCommentsLink = "";
                    if (userSession.getAccount().getMessagesstatus()==1) {
                        itemCommentsLink = itemLink;
                        item.setComments(itemCommentsLink);
                    }

                    //Item Description
                    //char apost = '\u2019';
                    //reger.core.Util.logtodb("Before \u2019 : " + rstEvent[i][4]);
                    //String itemDescription = rstEvent[i][4].replace(apost, "'");
                    //String itemDescription = rstEvent[i][4].replaceAll("\\\u2019", "'");
                    //String itemDescription = reger.core.Util.cleanForHtmlAdvanced(rstEvent[i][4]);
                    String itemDescription = entry.comments.replaceAll( reger.Vars.CARRIAGERETURN + reger.Vars.LINEBREAK, "<br>");
                    itemDescription = itemDescription + "<br><br>";
                    itemDescription = itemDescription + entry.filethumbsrss;
                    //reger.core.Util.logtodb("After: " + itemDescription);
                    Description desc = new Description();
                    desc.setValue(itemDescription);
                    item.setDescription(desc);

                    //Item Category
                    String itemCategory = logname;
                    Category cat = new Category();
                    cat.setValue(itemCategory);
                    java.util.Vector categoryList = new java.util.Vector();
                    categoryList.add(cat);
                    item.setCategories((java.util.List)categoryList);

                    //Item Author
                    String itemAuthor = entry.author;
                    item.setAuthor(itemAuthor);

                    //Item Enclosures
                    java.util.Vector encList = new java.util.Vector();
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstEnc= Db.RunSQL("SELECT imageid, image, description, sizeinbytes FROM image WHERE eventid='"+entry.eventid+"' ORDER BY imageorder ASC, image.imageid ASC");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstEnc!=null && rstEnc.length>0){
                        for(int j=0; j<rstEnc.length; j++){
                            String encLink="" +userSession.getAccount().getSiteRootUrl(userSession) +"/mediaout.log?imageid=" + rstEnc[j][0];
                            String extension = reger.core.Util.getFilenameExtension(rstEnc[j][1]);
                            MediaType mt = MediaTypeFactory.getHandlerByFileExtension(extension);
                            Enclosure enc = new Enclosure();
                            enc.setUrl(encLink);
                            enc.setLength(Long.parseLong(rstEnc[j][3]));
                            enc.setType(mt.getMimeType());
                            encList.add(enc);
                        }
                    }
                    if (encList.size()>0){
                        item.setEnclosures(encList);
                    }


                    //Instantiate the module
                    Debug.debug(5, "", "RssRome.java - Outputting entry... about to get entrydata for eventid="+entry.eventid);
                    MegaDataRSSModule tm = new MegaDataRSSModuleImpl();
                    tm.setFields(entry.fields);
                    item.getModules().add(tm);
                    Debug.debug(5, "", "RssRome.java - item.getModules() has been called<br>item.getModules().size()=" + item.getModules().size());



                    //Add the item to the list of items
                    itemList.add(item);
                }
        	}
        }

        //Add the list of items to the rss/channel
        rssChannel.setItems(itemList);

        //Start the output of the feed
        try{
            WireFeedOutput feedOut = new WireFeedOutput();
            fd.append(feedOut.outputString(rssChannel));
            Debug.debug(5, "", "Successfully output Rome RSS Feed");
        } catch (com.sun.syndication.io.FeedException fe) {
            Debug.debug(5, "", "Rome RSS Feed died:" + fe.toString());
        } catch (Exception e){
            Debug.debug(5, "", e);
        }

//          //List supported feed types
//          java.Util.List supportedTypes = FeedOutput.getSupportedFeedTypes();
//          StringBuffer eeee = new StringBuffer();
//          for (int i = 0; i < supportedTypes.size(); i++) {
//              Object o = (Object) supportedTypes.get(i);
//              eeee.append(i + ")" + o.toString() + "<br>");
//          }
//          reger.core.Util.debug(5, "SupportedTypes:<br>" + eeee.toString());
//SupportedTypes:
//rss_0.93
//rss_0.9
//rss_0.92
//atom_0.3
//rss_1.0
//rss_0.91
//rss_2.0
//rss_0.94

        //Debug
        Debug.debug(5, "", "Rss Feed=" + fd.toString());

        return fd;
    }

    public static boolean isAutoNamedJobbie(reger.Entry entry, Accountuser accountuser, Account account){
        Logger logger = Logger.getLogger(RssRome.class);
        logger.debug("start isAutoNamedJobbie()-------");
        try{
            int overridecamphonesubject = 0;
            String overridecamphonesubjecttext = "";
            //If it's older than 48 hours, return false
            if (DateDiff.dateDiff("hour", reger.core.TimeUtils.nowInGmtCalendar(), entry.dateGmt) > 48 ){
                logger.debug("returning false because DateDiff > 48");
                return false;
            }
            //Get the emailapi settings
            //-----------------------------------
            //-----------------------------------
            String[][] rstApisettings= Db.RunSQL("SELECT overridecamphonesubject, overridecamphonesubjecttext, ignorecamphonebody, consolidatecamphonetoonedailyentry, saveemailpostsasdraft, savecamphonepostsasdraft, camphoneimagetags, emailsecret FROM emailapi WHERE emailapi.accountuserid='"+accountuser.getAccountuserid()+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstApisettings!=null && rstApisettings.length>0){
                if (!rstApisettings[0][0].equals("") && reger.core.Util.isinteger(rstApisettings[0][0])){
                    overridecamphonesubject = Integer.parseInt(rstApisettings[0][0]);
                }
                if (!rstApisettings[0][1].equals("")){
                    overridecamphonesubjecttext = rstApisettings[0][1];
                }
            }
            //Now see what's up
            logger.debug("overridecamphonesubject="+overridecamphonesubject);
            if (overridecamphonesubject==1){
                String dateString = reger.core.TimeUtils.dateformatFullNoTime(reger.core.TimeUtils.gmttousertime(entry.dateGmt, account.getTimezoneid()));
                overridecamphonesubjecttext = overridecamphonesubjecttext.replaceAll("\\<\\$Date\\$\\>", dateString);
                String tmpTitle = reger.core.Util.truncateString(overridecamphonesubjecttext, 255);
                logger.debug("entry.title="+entry.title);
                logger.debug("dateString="+dateString);
                logger.debug("tmpTitle="+tmpTitle);
                if (tmpTitle.equals(entry.title) || dateString.equals(entry.title)){
                    logger.debug("returning true!!!");
                    return true;
                }
            }
        } catch (Exception ex){
            logger.error(ex);
        }
        //Default to false
        logger.debug("returning false by default.");
        return false;
    }




    public static StringBuffer getFeedAtom(reger.UserSession userSession, int logid, int limititems , String feedType, int eventid){
        StringBuffer fd = new StringBuffer();

        //Create Rome Feed Object
        Feed rssChannel = new Feed(feedType);

        //Channel Title
        String channelTitle = userSession.getAccount().getHomepagetitle();
        if (channelTitle.equals("")) {
            channelTitle="" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        rssChannel.setTitle(channelTitle);

        //Channel Description
        String channelDesc = userSession.getAccount().getHomepagehtml();
        if (channelDesc.equals("")) {
            channelDesc="A web log called " + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        Content atomDesc = new Content();
        atomDesc.setValue(channelDesc);
        rssChannel.setTagline(atomDesc);

        //Channel Link
        //String channelLink = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        //rssChannel.setLink(channelLink);

        //Channel Generator
        String channelGenerator = "Reger.com datablogging Server Technology";
        Generator gen = new Generator();
        gen.setValue(channelGenerator);
        gen.setUrl("http://www.reger.com");
        rssChannel.setGenerator(gen);

        //Build logid-dependent sql
        String logidSql="";
        if (logid>0) {
            logidSql=" AND event.logid='"+logid+"' ";
        }

        //EventidSql
        String eventSql = "";
        if (eventid>0){
            eventSql = " AND event.eventid='" + eventid + "' ";
        }

        //Create Items
        java.util.Vector itemList = new java.util.Vector();

        //Go to database
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT eventid FROM event WHERE "+reger.Entry.sqlOfLiveEntry+" AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), false)+""+logidSql+" "+eventSql+" ORDER BY event.date DESC LIMIT 0, "+limititems+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	for(int i=0; i<rstEvent.length; i++){

        	    //Go get the entry from the cache
                reger.Entry entry = reger.cache.EntryCache.get(Integer.parseInt(rstEvent[i][0]));

                //See if this is an auto title... if so, don't post for a couple days
                if (!isAutoNamedJobbie(entry, userSession.getAccountuser(), userSession.getAccount())){

                    //Get log name
                    String logname="";
                    Log log = reger.cache.LogCache.get(entry.logid);
                    if (log!=null){
                        logname = log.getName();
                    }


                    //Create a Rome RSS Item
                    Entry item = new Entry();

                    //Item Pubdate
                    //Correct format is:
                    //Sat, 07 Sep 2002 0:00:01 GMT
                    //Calendar gmttime = reger.core.TimeUtils.gmttousertime(rstEvent[i][0], userSession.getAccount().getTimezoneid());
                    Calendar gmttime = reger.core.TimeUtils.usertogmttime(entry.dateGmt, userSession.getAccount().getTimezoneid());
                    item.setCreated(gmttime.getTime());

                    //Item Link
                    //String itemLink="" + userSession.getAccount().getSiteRootUrl(userSession) +"/entry-logid"+rstEvent[i][2]+"-eventid"+rstEvent[i][1]+".log";
                    //item.setLink(itemLink);

                    //Item title
                    String itemTitle = entry.title;
                    item.setTitle(itemTitle);

                    //Item Comments Link
                    //String itemCommentsLink = "";
                    //if (userSession.getAccount().getMessagesstatus()==1) {
                        //itemCommentsLink = itemLink;
                        //item.setMessages(itemCommentsLink);
                    //}

                    //Item Description
                    String itemDescription = entry.comments;
                    Description desc = new Description();
                    desc.setValue(itemDescription);
                    Content descr = new Content();
                    descr.setValue(itemDescription);
                    java.util.Vector descList = new java.util.Vector();
                    descList.add(descr);
                    item.setContents(descList);

                    //Item Category
                    //String itemCategory = rstEvent[i][5];
                    //Category cat = new Category();
                    //cat.setValue(itemCategory);
                    //java.Util.Vector categoryList = new java.Util.Vector();
                    //categoryList.add(cat);
                    //item.setCategories((java.Util.List)categoryList);

                    //Item Author
                    //@todo Implement <author> tag.
                    //String itemAuthor = "";
                    //item.setAuthor(itemAuthor);

                    //Item Enclosure
                    //@todo Implement enclosure tag for all media.
                    //<enclosure url="http://www.scripting.com/mp3s/weatherReportSuite.mp3" length="12216320" type="audio/mpeg" />


                    //Instantiate the module
                    MegaDataRSSModule tm = new MegaDataRSSModuleImpl();
                    tm.setFields(entry.fields);
                    item.getModules().add(tm);

                    //Add the item to the list of items
                    itemList.add(item);
                }
        	}
        }

        //Add the list of items to the rss/channel
        rssChannel.setEntries(itemList);

        //Start the output of the feed
        try{
            WireFeedOutput feedOut = new WireFeedOutput();
            fd.append(feedOut.outputString(rssChannel));
            Debug.debug(5, "", "Successfully output Rome Atom Feed");
        } catch (com.sun.syndication.io.FeedException fe) {
            Debug.debug(5, "", "Rome Atom Feed died:" + fe.toString());
        } catch (Exception e){
            Debug.debug(5, "", e);
        }

//          //List supported feed types
//          java.Util.List supportedTypes = FeedOutput.getSupportedFeedTypes();
//          StringBuffer eeee = new StringBuffer();
//          for (int i = 0; i < supportedTypes.size(); i++) {
//              Object o = (Object) supportedTypes.get(i);
//              eeee.append(i + ")" + o.toString() + "<br>");
//          }
//          reger.core.Util.debug(5, "SupportedTypes:<br>" + eeee.toString());
//SupportedTypes:
//rss_0.93
//rss_0.9
//rss_0.92
//atom_0.3
//rss_1.0
//rss_0.91
//rss_2.0
//rss_0.94

        //Debug
        Debug.debug(5, "", "Rss Feed=" + fd.toString());

        return fd;
    }



    public static StringBuffer getSyndFeed(reger.UserSession userSession, int logid, int limititems , String feedType){
        StringBuffer fd = new StringBuffer();

        //Create Rome Feed Object
        //Channel rssChannel = new Channel(feedType);

        SyndFeed feed = new SyndFeedImpl();

        //Channel Title
        String channelTitle = userSession.getAccount().getHomepagetitle();
        if (channelTitle.equals("")) {
            channelTitle="" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        feed.setTitle(channelTitle);

        //Channel Description
        String channelDesc = userSession.getAccount().getHomepagehtml();
        if (channelDesc.equals("")) {
            channelDesc="A web log called " + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        }
        feed.setDescription(channelDesc);

        //Channel Link
        String channelLink = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/";
        feed.setLink(channelLink);

        //Channel Generator
        //String channelGenerator = "Reger.com";
        //feed.setGenerator(channelGenerator);


        //Build logid-dependent sql
        String logidSql="";
        if (logid>0) {
            logidSql=" AND event.logid='"+logid+"'";
        }

        //Language
        //feed.setLanguage("English");

        //Create Items
        List entries = new ArrayList();

        //Go to database
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT eventid FROM event WHERE "+reger.Entry.sqlOfLiveEntry+" AND "+userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid(), false)+""+logidSql+" ORDER BY event.date DESC LIMIT 0, "+limititems+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	for(int i=0; i<rstEvent.length; i++){

        	    //Go get the entry from the cache
                reger.Entry entry = reger.cache.EntryCache.get(Integer.parseInt(rstEvent[i][0]));

                //See if this is an auto title... if so, don't post for a couple days
                if (!isAutoNamedJobbie(entry, userSession.getAccountuser(), userSession.getAccount())){

                    //Get log name
                    String logname="";
                    Log log = reger.cache.LogCache.get(entry.logid);
                    if (log!=null){
                        logname = log.getName();
                    }

                    //Create a Rome RSS Item
                    //Item item = new Item();
                    SyndEntryImpl item = new SyndEntryImpl();

                    //Item Pubdate
                    //Correct format is:
                    //Sat, 07 Sep 2002 0:00:01 GMT
                    //Calendar gmttime = reger.core.TimeUtils.gmttousertime(rstEvent[i][0], userSession.getAccount().getTimezoneid());
                    Calendar gmttime = reger.core.TimeUtils.usertogmttime(entry.dateGmt, userSession.getAccount().getTimezoneid());
                    item.setPublishedDate(gmttime.getTime());

                    //Item Link
                    String entryurl=reger.Entry.entryFileNameStatic(entry.logid, entry.eventid, entry.title);
                    String itemLink="" + userSession.getAccount().getSiteRootUrl(userSession) +"/" + entryurl;
                    if (log.getLogaccess()==reger.Vars.LOGACCESSPRIVATE){
                        if (log.getPassword()!=null && !log.getPassword().equals("")){
                            itemLink = itemLink + "?qpass=" + log.getPassword();
                        }
                    }
                    item.setLink(itemLink);

                    //Guid
                    //Guid guid = new Guid();
                    //guid.setPermaLink(true);
                    //guid.setValue(itemLink);
                    //item.setGuid(guid);

                    //Item title
                    String itemTitle = entry.title;
                    item.setTitle(itemTitle);

                    //Item Comments Link
                    //String itemCommentsLink = "";
                    //if (userSession.getAccount().getMessagesstatus()==1) {
                    //    itemCommentsLink = itemLink;
                    //    item.setMessages(itemCommentsLink);
                    //}

                    //Item Description
                    //char apost = '\u2019';
                    //reger.core.Util.logtodb("Before \u2019 : " + rstEvent[i][4]);
                    //String itemDescription = rstEvent[i][4].replace(apost, "'");
                    //String itemDescription = rstEvent[i][4].replaceAll("\\\u2019", "'");
                    //String itemDescription = reger.core.Util.cleanForHtmlAdvanced(rstEvent[i][4]);
                    String itemDescription = entry.comments;
                    //reger.core.Util.logtodb("After: " + itemDescription);
                    SyndContentImpl description = new SyndContentImpl();
                    description.setType("text/plain");
                    description.setValue(itemDescription);
                    item.setDescription(description);

                    //Item Category
                    String itemCategory = log.getName();
                    SyndCategoryImpl cat = new SyndCategoryImpl();
                    cat.setName(itemCategory);
                    List categoryList = new ArrayList();
                    categoryList.add(cat);
                    item.setCategories(categoryList);

                    //Item Author
                    String itemAuthor = entry.author;
                    item.setAuthor(itemAuthor);

                    //Item Enclosures
                    java.util.Vector encList = new java.util.Vector();
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstEnc= Db.RunSQL("SELECT imageid, image, description, sizeinbytes FROM image WHERE eventid='"+entry.eventid+"' ORDER BY imageorder ASC, image.imageid ASC");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstEnc!=null && rstEnc.length>0){
                        for(int j=0; j<rstEnc.length; j++){
                            Enclosure enc = new Enclosure();
                            String encLink="" + userSession.getAccount().getSiteRootUrl(userSession) +"/mediaout.log?imageid=" + rstEnc[j][0];
                            enc.setUrl(encLink);
                            enc.setLength(Long.parseLong(rstEnc[j][3]));
                            encList.add(enc);
                        }
                    }
                    if (encList.size()>0){
                        item.setContents(encList);
                    }

                    //Item Abitrary Fields Start
                    //Grab the data from the database
    //                reger.MegaGetSingleEventData eventData = new reger.MegaGetSingleEventData(Integer.parseInt(rstEvent[i][1]));
    //                //The data is now in eventData.cleanData with fieldtypes in eventData.fieldTypes
    //                for ( Enumeration e = eventData.cleanData.keys() ; e.hasMoreElements() ; ) {
    //                	//Field Name
    //                	String fieldname = (String)e.nextElement();
    //                	//Field data
    //                	String data = String.valueOf(eventData.cleanData.get(fieldname));
    //                	//Add to rome object
    //                    //But how?
    //                }
                    //Item Abitrary Fields End

                    //Add the item to the list of items
                    entries.add(item);
                }
        	}
        }

        //Add the list of items to the rss/channel
        feed.setEntries(entries);

        //Start the output of the feed
        try{
            feed.setFeedType(feedType);
            SyndFeedOutput output = new SyndFeedOutput();
            fd.append(output.outputString(feed));
            Debug.debug(5, "", "Successfully output Rome RSS Feed");
        } catch (com.sun.syndication.io.FeedException fe) {
            Debug.debug(5, "", "Rome RSS Feed died:" + fe.toString());
        } catch (Exception e){
            Debug.debug(5, "", e);
        }

//          //List supported feed types
//          java.Util.List supportedTypes = FeedOutput.getSupportedFeedTypes();
//          StringBuffer eeee = new StringBuffer();
//          for (int i = 0; i < supportedTypes.size(); i++) {
//              Object o = (Object) supportedTypes.get(i);
//              eeee.append(i + ")" + o.toString() + "<br>");
//          }
//          reger.core.Util.debug(5, "SupportedTypes:<br>" + eeee.toString());
//SupportedTypes:
//rss_0.93
//rss_0.9
//rss_0.92
//atom_0.3
//rss_1.0
//rss_0.91
//rss_2.0
//rss_0.94

        //Debug
        Debug.debug(5, "", "Rss Feed=" + fd.toString());

        return fd;
    }






    public static boolean verifyType(String type){
        java.util.List supportedTypes = WireFeedOutput.getSupportedFeedTypes();
          for (int i = 0; i < supportedTypes.size(); i++) {
              Object o = (Object) supportedTypes.get(i);
              if (o.toString().equals(type)){
                  return true;
              }
          }
          Debug.debug(5, "", "Feed type not found=" + type);
          return false;
    }


}
