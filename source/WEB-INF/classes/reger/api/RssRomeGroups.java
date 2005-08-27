package reger.api;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.rss.*;
import com.sun.syndication.feed.synd.*;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Generator;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.io.*;

/**
 *
 */
public class RssRomeGroups {


    public static StringBuffer getFeed(reger.UserSession userSession, int limititems , String feedType, int groupid){
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
            return getFeedRss(userSession, groupid, limititems, feedType);
        } else {
            return getFeedRss(userSession, groupid, limititems, feedType);
        }

    }

    public static StringBuffer getFeedRss(reger.UserSession userSession, int groupid, int limititems, String feedType){
        StringBuffer fd = new StringBuffer();

        String groupName = "";
        String groupDesc = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstGpDetails= Db.RunSQL("SELECT groupid, groupname, groupdescription FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGpDetails!=null && rstGpDetails.length>0){
            for(int i=0; i<rstGpDetails.length; i++){
                groupName = rstGpDetails[i][1];
                groupDesc = rstGpDetails[i][2];

            }
        }

        //Create Rome Feed Object
        Channel rssChannel = new Channel(feedType);

        //Channel Title
        String channelTitle = groupName;
        rssChannel.setTitle(channelTitle);

        //Channel Description
        String channelDesc = groupDesc;
        rssChannel.setDescription(channelDesc);

        //Channel Link
        String channelLink = "" + reger.Vars.getHttpUrlPrefix() + userSession.getSiteRootUrl() + "/groups/group"+groupid+".log";
        rssChannel.setLink(channelLink);

        //Channel Generator
        String channelGenerator = "Reger.com datablogging Server Technology";
        rssChannel.setGenerator(channelGenerator);

        //Create Items
        java.util.Vector itemList = new java.util.Vector();

        //Go to database
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT entrytitle, entryurl, entryextract, datetime, author, authorurl FROM groupentry WHERE groupid='"+groupid+"' ORDER BY datetime DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	for(int i=0; i<rstEvent.length; i++){

        	    //Create a Rome RSS Item
                Item item = new Item();

                //Item Pubdate
                //Correct format is:
                //Sat, 07 Sep 2002 0:00:01 GMT
                //Calendar gmttime = reger.core.TimeUtils.gmttousertime(rstEvent[i][3], userSession.getAccount().getTimezoneid());
                //gmttime = reger.core.TimeUtils.usertogmttime(gmttime, userSession.getAccount().getTimezoneid());
                item.setPubDate(reger.core.TimeUtils.dbstringtocalendar(rstEvent[i][3]).getTime());

                //Item Link
                item.setLink(rstEvent[i][1]);

                //Guid
                Guid guid = new Guid();
                guid.setPermaLink(true);
                guid.setValue(rstEvent[i][1]);
                item.setGuid(guid);

                //Item title
                String itemTitle = rstEvent[i][0];
                item.setTitle(itemTitle);


                //Item Description
                String itemDescription = rstEvent[i][2];
                Description desc = new Description();
                desc.setValue(itemDescription);
                item.setDescription(desc);

                //Item Author
                if (!rstEvent[i][4].equals("")){
                    item.setAuthor(rstEvent[i][4]);
                }


                //Add the item to the list of items
                itemList.add(item);

        	}
        }

        //Add the list of items to the rss/channel
        rssChannel.setItems(itemList);

        //Start the output of the feed
        try{
            WireFeedOutput feedOut = new WireFeedOutput();
            fd.append(feedOut.outputString(rssChannel));
            reger.core.Util.debug(5, "Successfully output Rome RSS Feed");
        } catch (FeedException fe) {
            reger.core.Util.debug(5, "Rome RSS Feed died:" + fe.toString());
        } catch (Exception e){
            reger.core.Util.debug(5, e);
        }



        //Debug
        reger.core.Util.debug(5, "Rss Groups Feed=" + fd.toString());

        return fd;
    }



    public static boolean verifyType(String type){
        List supportedTypes = WireFeedOutput.getSupportedFeedTypes();
          for (int i = 0; i < supportedTypes.size(); i++) {
              Object o = (Object) supportedTypes.get(i);
              if (o.toString().equals(type)){
                  return true;
              }
          }
          reger.core.Util.debug(5, "Feed type not found=" + type);
          return false;
    }


}
