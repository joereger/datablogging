package reger.api;

import reger.core.db.Db;
import reger.Accountuser;
import reger.Account;
import reger.PrivateLabel;
import reger.ThumbnailCreator;
import reger.core.ValidationException;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;

import java.util.Hashtable;
import java.util.Calendar;
import java.util.Vector;
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

        //Get the pl
        PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

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



                //Populate the date/time vars in the event object
                entry.dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

                //Set the author in the posts.
                entry.accountuserid = au.getAccountuserid();

                try{
                    //Save the entry to the database
                    entry.newEntryTemporary(account, au);
                    entry.editEntryAll(account, au, pl);
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
            Debug.errorsave(e, "");
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

        //Get the pl
        PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

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
                    entry.editEntryAll(account, au, pl);
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
            Debug.errorsave(e, "");
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
            Debug.errorsave(e, "");
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
                outPost.put("datecreated", TimeUtils.dateformatUtc(TimeUtils.dbstringtocalendar(TimeUtils.dateformatfordb(entry.dateGmt))));

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
            Debug.errorsave(e, "");
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

        //Get the pl
        PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

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
                entry.dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

                //Make the entry
                try{
                    entry.newEntryTemporary(account, au);
                    entry.editEntryAll(account, au, pl);
                } catch (ValidationException error){
                    return error.getErrorsAsSingleString();
                }

                //Figure out a filename
                String incomingname = content.get("name").toString();
                String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);


                //Test for file existence... if it exists does, add an incrementer
                String finalfilename = incomingname;
                File savedFile  = new File(account.getPathToAccountFiles(), finalfilename);
                int incrementer = 0;
                while (savedFile.exists()){
                    incrementer=incrementer+1;
                    finalfilename = incomingnamebase+"-"+incrementer;
                    if (!incomingnameext.equals("")){
                        finalfilename = finalfilename + "." + incomingnameext;
                    }
                    savedFile  = new File(account.getPathToAccountFiles(), finalfilename);
                }

                //Save the file with the updated filename
                FileOutputStream fileOut = new FileOutputStream(savedFile);
                fileOut.write(bits);

                ThumbnailCreator.createThumbnail(savedFile);


                //@todo Exif data extraction from image with http://www.drewnoakes.com/code/exif/ ???

                //-----------------------------------
                //-----------------------------------
                int imageid = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, originalfilename, accountid, filename) VALUES('"+entry.eventid+"', '"+finalfilename+"', '"+bits.length+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(finalfilename)+"')");
                //-----------------------------------
                //-----------------------------------

                //Get a MediaType handler
                MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                //Handle any parsing required
                mt.saveToDatabase(account.getPathToAccountFiles()+finalfilename, imageid);


                //Return the public URL where this can be accessed
                return "" + account.getSiteRootUrl() + "/mediaout.log?imageid=" + imageid;
            } else {
                //@todo Learn to throw an xml-rpc exception
                return "Invalid servername or password.";
            }

        } catch (Exception e) {
            Debug.errorsave(e, "");
            return "Error.";
        }

    }


}
