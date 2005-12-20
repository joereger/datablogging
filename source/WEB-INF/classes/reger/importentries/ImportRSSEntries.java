package reger.importentries;

import com.sun.syndication.feed.WireFeed;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.io.WireFeedInput;
import com.sun.syndication.io.XmlReader;
import reger.Account;
import reger.Accountuser;
import reger.PrivateLabel;
import reger.UserSession;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.core.ValidationException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ImportRSSEntries {

    public void importRSSFromFeed(UserSession userSession, String url, String logid, String timezoneid) throws Exception {
        WireFeed feed = null;
        try {
            URL feedUrl = new URL(url);
            WireFeedInput input = new WireFeedInput();
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e) {
            Debug.errorsave(e, "ImportRSSEntries", "Exception occurred while importing the xml file from " + url);
            throw e;
        }
        try {
            storeInDB(feed, userSession, logid, timezoneid);
        } catch (Exception e) {
            Debug.errorsave(e, "importBlogFromFeed method in ImportRSSEntries", "Exception occurred while storing the data to the database");
            throw e;
        }
    }

    public void importRSSFromFile(UserSession userSession, InputStream fileStream, String logid, String timezoneid) throws Exception {
        WireFeed feed = null;
        try {
            WireFeedInput input = new WireFeedInput();
            feed = input.build(new XmlReader(fileStream));
        } catch (Exception e) {
            Debug.errorsave(e, "importBlogFromFile method in ImportRSSEntries", "Exception occurred while importing the xml file");
            throw e;
        }
        try {
            storeInDB(feed, userSession, logid, timezoneid);
        } catch (Exception e) {
            Debug.errorsave(e, "importBlogFromFile method in ImportRSSEntries", "Exception occurred while storing the data to the database");
            throw e;
        }
    }

    private void storeInDB(WireFeed feed, UserSession userSession, String logid, String timezoneid) throws Exception {

        try {
            //Create an instance of the backend object
            reger.Entry entry = new reger.Entry();
            //Try to log the user in
            Accountuser au = userSession.getAccountuser();
            //Get the account
            Account account = userSession.getAccount();
            //Get the pl
            PrivateLabel pl = userSession.getPl();
            //Get this user's data
            int accountid = au.getAccountid();
            if (au.isLoggedIn) {
                //Set the accountid
                entry.accountid = accountid;
                Channel channel = (Channel) feed;
                List itemList = channel.getItems();
                Iterator iter = itemList.iterator();
                Item item = null;
                Calendar calendar = Calendar.getInstance();
                while (iter.hasNext()) {
                    item = (Item) iter.next();
                    //Set the title
                    entry.title = item.getTitle();
                    //Set the comments
                    entry.comments = item.getDescription().getValue();
                    // not live
                    entry.isDraft = 0;
                    entry.logid = Integer.parseInt(logid);
                    //Populate the date/time vars in the event object
                    calendar.setTime(item.getPubDate());
                    //Convert from GMT timezone to user specific timezone.
                    calendar = TimeUtils.convertFromOneTimeZoneToAnother(calendar, "GMT", timezoneid);
                    entry.dateGmt = calendar;
                    //Set the author in the posts.
                    entry.accountuserid = au.getAccountuserid();
                    //To approve the imported entries.
                    entry.isApproved = 1;
                    try {
                        //Save the entry to the database
                        entry.newEntryTemporary(account, au);
                        entry.editEntryAll(account, au, pl);
                    } catch (ValidationException error) {
                        Debug.errorsave(error, "ValidationException while storing in database");
                        throw new Exception(error);
                    }
                }
            } else {
                Debug.debug(3, "storeInDB method in ImportRSSEntries", "User importing blog entries was not logged in.");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}