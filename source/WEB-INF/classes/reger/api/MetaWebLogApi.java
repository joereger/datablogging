package reger.api;

import reger.core.db.Db;
import reger.Accountuser;
import reger.Account;
import reger.core.ValidationException;
import reger.core.db.Db;
import reger.core.ValidationException;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;

import java.util.Hashtable;
import java.util.Calendar;
import java.util.Vector;
import java.util.Enumeration;
import java.io.*;
import org.apache.commons.codec.binary.Base64;


/**
 * The MetaWebLogApi
 */
public class MetaWebLogApi {


    public MetaWebLogApi(){
        
    }


    /**
     * New Entry method
     */
 	public String newPost(String blogid, String username, String password, Hashtable content, boolean publish){

        //@todo Be able to accept megalog field data via metaweblogapi.newpost;

        //Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

        try {

            //Get this user's data
            int accountid = au.getAccountid();
            String timezoneid = account.getTimezoneid();

            if (au.isLoggedIn) {
                //Set the accountid
                entry.accountid = accountid;

                //Set the title
                entry.title=reger.core.Util.truncateString(content.get("title").toString(), 255);

                //If the title is blank, use the description
                if (entry.title.equals("")) {
                    entry.title=reger.core.Util.truncateString(content.get("description").toString() ,255);
                }

                //Set the comments
                entry.comments=content.get("description").toString();

                //Set the draft/live status
                if (!publish) {
                    entry.isDraft = 1;
                } else {
                    entry.isDraft = 0;
                }

                //Set the blogid
                if (reger.core.Util.isinteger(blogid)){
                    entry.logid=Integer.parseInt(blogid);
                } else {
                    return "blogid must be an integer.";
                }

                //Get the current time in the user's timezone
                Calendar nowInUsertimezone = reger.core.TimeUtils.nowInUserTimezone(timezoneid);

                //Populate the date/time vars in the event object
                entry.populateThisEventTimeVarsFromCal(nowInUsertimezone);

                //Set the author in the posts.
                entry.accountuserid = au.getAccountuserid();

                try{
                    //Save the entry to the database
                    entry.newEntryTemporary();
                    entry.editEntryAll(entry.eventid);
                } catch (ValidationException error){
                    return error.getErrorsAsSingleString();
                }

                //Get the return value
                String returnEventid=String.valueOf(entry.eventid);

                //Return the eventid to the client
                return returnEventid;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return "Invalid servername or password.";
            }

        } catch (Exception e) {
            reger.core.Util.errorsave(e);
            return "Error.";
        }

    }

    /**
     * Edit entry
     */
    public boolean editPost(String postid, String username, String password, Hashtable content, boolean publish){

        //Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

        try {

            //Parse the incoming postid
            if (reger.core.Util.isinteger(postid)) {
                //Set the eventid
                entry.eventid=Integer.parseInt(postid);
                //Before any action, get the existing entry
                entry.getEntryAll(entry.eventid);
            } else {
                return false;
            }



            //Get this user's data
            int accountid = au.getAccountid();
            String timezoneid = account.getTimezoneid();

            if (au.isLoggedIn) {
                //Get logid from eventid
                entry.logid=reger.core.Util.getLogidFromEventid(entry.eventid, accountid);

                //Set the accountid
                entry.accountid = accountid;

                //Set the title
                entry.title=reger.core.Util.truncateString(content.get("title").toString(), 255);

                //If the title is blank, use the description
                if (entry.title.equals("")) {
                    entry.title=reger.core.Util.truncateString(content.get("description").toString() ,255);
                }

                //Set the comments
                entry.comments=content.get("description").toString();

                //Set the draft/live status
                if (!publish) {
                    entry.isDraft = 1;
                } else {
                    entry.isDraft = 0;
                }



                //Set the author in the posts.
                entry.accountuserid = au.getAccountuserid();

                //Edit the actual entry
                try{
                    entry.editEntryAll(entry.eventid);
                } catch (ValidationException error){
                    return false;
                }

                //Reply to the client
                return true;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return false;

            }

        } catch (Exception e) {
            reger.core.Util.errorsave(e);
            return false;
        }

    }

    /**
     * Get Recent Posts Override
     */
    public Vector getRecentPosts(String appkey, String blogid, String username, String password, int numberOfPosts){
        return getRecentPosts(blogid, username, password, numberOfPosts);
    }

    /**
     * Get Recent Posts
     */
    public Vector getRecentPosts(String blogid, String username, String password, int numberOfPosts){

        //@todo Check the signature of this method against the documented metaWebLogApi.


        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

		try {

            //Get this user's data
            int accountid = au.getAccountid();
            String timezoneid = account.getTimezoneid();

            if (au.isLoggedIn) {
                //A vector to hold the list of recent entries
                Vector postArray = new Vector();

                //-----------------------------------
                //-----------------------------------
                String[][] rstGetPostList= Db.RunSQL("SELECT title, comments, eventid, date FROM event, megalog WHERE event.logid=megalog.logid AND "+au.LogsUserCanViewQueryend(account.getAccountid())+" AND "+reger.Entry.sqlOfLiveEntry+" AND event.accountid='" + accountid + "' ORDER BY event.date DESC LIMIT 0, "+numberOfPosts+"");
                //-----------------------------------
                //-----------------------------------
                if (rstGetPostList!=null && rstGetPostList.length>0){
                    for(int i=0; i<rstGetPostList.length; i++){
                        //The Hashtable that holds one entry
                        Hashtable uPosts = new Hashtable();
                        uPosts.put(String.valueOf("title"), rstGetPostList[i][0]);
                        uPosts.put(String.valueOf("content"), rstGetPostList[i][1]);
                        uPosts.put(String.valueOf("userid"), account.getSiteRootUrl());
                        uPosts.put(String.valueOf("postid"), rstGetPostList[i][2]);
                        uPosts.put(String.valueOf("datecreated"), reger.core.TimeUtils.dateformatUtc(reger.core.TimeUtils.dbstringtocalendar(rstGetPostList[i][3])));

                        //Megalog Start

                        //@toto Add Megadata
//                        //Grab the data
//                        reger.MegaGetSingleEventData eventData = new reger.MegaGetSingleEventData(Integer.parseInt(rstGetPostList[i][2]));
//
//                        //The data is now in eventData.cleanData with fieldtypes in eventData.fieldTypes
//                        for ( Enumeration e = eventData.cleanData.keys() ; e.hasMoreElements() ; ) {
//                            // retrieve the object_key
//                            String fieldname = reger.core.Util.xmlFieldNameClean((String)e.nextElement());
//                            // retrieve the object associated with the key
//                            String data = String.valueOf(eventData.cleanData.get(fieldname));
//                            //Output the correct tags
//                            uPosts.put(fieldname, data);
//                        }

                        //Megalog end

                        //The array that holds multiple entries
                        postArray.add(i, uPosts);

                    }
                }

                //Return the array
                return postArray;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return new Vector();
            }
        } catch (Exception e) {
            reger.core.Util.errorsave(e);
            return new Vector();
        }
    }

    /**
     * Get Post Override
     */
    public Hashtable getPost(String appkey, String postid, String username, String password){
        return getPost(postid, username, password);
    }

    /**
     * Get Post
     */
    public Hashtable getPost(String postid, String username, String password){

		//Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

        try {

            //Parse the incoming postid
            int eventid=-1;
            if (reger.core.Util.isinteger(postid)) {
                entry.eventid=Integer.parseInt(postid);
            } else {
                Hashtable errOut = new Hashtable();
                errOut.put("error", "Postid must be an integer.");
                return errOut;
            }

            //Get this user's data
            int accountid = au.getAccountid();
            String timezoneid = account.getTimezoneid();

            if (au.isLoggedIn) {
                //Get logid from eventid
                entry.logid=reger.core.Util.getLogidFromEventid(eventid, accountid);

                //Set the accountid
                entry.accountid = accountid;

                //Get the entry
                entry.getEntryAll(entry.eventid);

                //Format post as Hashtable
                Hashtable outPost = new Hashtable();
                outPost.put("title", entry.title);
                outPost.put("content", entry.comments);
                outPost.put("userid", account.getSiteRootUrl());
                outPost.put("postid", postid);
                outPost.put("datecreated", reger.core.TimeUtils.dateformatUtc(reger.core.TimeUtils.dbstringtocalendar(entry.convertUsingEntrytimezoneid())));

                //Megalog Start

                //@todo Add megadata

                //Grab the data
//                reger.MegaGetSingleEventData eventData = new reger.MegaGetSingleEventData(entry.eventid);
//
//                //The data is now in eventData.cleanData with fieldtypes in eventData.fieldTypes
//                for ( Enumeration e = eventData.cleanData.keys() ; e.hasMoreElements() ; ) {
//                    // retrieve the object_key
//                    String fieldname = reger.core.Util.xmlFieldNameClean((String)e.nextElement());
//                    // retrieve the object associated with the key
//                    String data = String.valueOf(eventData.cleanData.get(fieldname));
//                    //Output the correct tags
//                    outPost.put(fieldname, data);
//                }

                //Megalog end

                //Send back to client
                return outPost;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return new Hashtable();
            }

        } catch (Exception e) {
            reger.core.Util.errorsave(e);
            return new Hashtable();
        }
    }


    public String newMediaObject(String blogid, String username, String password, Hashtable content) {

        //Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

        try {

            //Get this user's data
            int accountid = au.getAccountid();
            String timezoneid = account.getTimezoneid();

            if (au.isLoggedIn) {
                //Set the accountid
                entry.accountid = accountid;

                //Turn the "bits" content piece into an imputstream
                byte[] bits = content.get("bits").toString().getBytes();

                //Decode the inputstream
                bits = Base64.decodeBase64(bits);

                //Get the size of the incoming file
                int contentlength=bits.length - 1;

                //Make sure there's enough space left for this user
                reger.Account acct = new reger.Account(accountid);
                long freespace = acct.getFreespace();
                if ((long)contentlength>freespace) {
                    return "Not enough free storage space available for this account.";
                }

                //Define the content of the entry
                entry.title = "New media object of type " + content.get("type") + ".";
                //@todo This time in MetaWebLogApi should be converted to usertime before being passed.
                entry.populateThisEventTimeVarsFromCal(Calendar.getInstance());

                //Make the entry
                try{
                    entry.newEntryTemporary();
                    entry.editEntryAll(entry.eventid);
                } catch (ValidationException error){
                    return error.getErrorsAsSingleString();
                }

                //Figure out a filename
                String incomingname = content.get("name").toString();
                String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);

                //Here's the file naming convention I'm using:
                //(2003-10-23)18-43-32-accountid(76382)-eventid(6732234)-ver(incrementer)filename.ext
                String stamp = reger.core.TimeUtils.dateformatfilestamp(Calendar.getInstance());
                stamp=stamp+"-accountid("+accountid+")";
                stamp=stamp+"-eventid("+entry.eventid+")";
                stamp=stamp+"-";

                //Test for file existence... if it exists does, add an incrementer
                File savedFile  = new File((String)reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA"), stamp+incomingname);
                int incrementer = 0;
                String incrementerstring="";
                while (savedFile.exists()){
                    incrementer=incrementer+1;
                    incrementerstring="("+incrementer+")";
                    savedFile  = new File((String)reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA"), stamp+incomingnamebase+incrementerstring+"."+incomingnameext);
                }
                String finalfilename = stamp+incomingnamebase+incrementerstring+"."+incomingnameext;

                //Save the file with the updated filename
                FileOutputStream fileOut = new FileOutputStream(savedFile);
                fileOut.write(bits);


                //@todo Exif data extraction from image with http://www.drewnoakes.com/code/exif/ ???

                //-----------------------------------
                //-----------------------------------
                int imageid = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, originalfilename) VALUES('"+entry.eventid+"', '"+finalfilename+"', '"+bits.length+"', '"+reger.core.Util.cleanForSQL(incomingname)+"')");
                //-----------------------------------
                //-----------------------------------

                //Get a MediaType handler
                MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                //Generate a thumbnail
                mt.createThumbnail(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+finalfilename, reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+"thumbnails/"+finalfilename, 100);
                //Handle any parsing required
                mt.saveToDatabase(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+finalfilename, imageid);


                //Return the public URL where this can be accessed
                return "" + reger.Vars.getHttpUrlPrefix() + account.getSiteRootUrl() + "/mediaout.log?imageid=" + imageid;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return "Invalid servername or password.";
            }

        } catch (Exception e) {
            reger.core.Util.errorsave(e);
            return "Error.";
        }

    }


}
