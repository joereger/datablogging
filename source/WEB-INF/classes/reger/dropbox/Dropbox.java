package reger.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.RESTUtility;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;
import com.dropbox.client2.session.WebAuthSession;
import org.apache.jcs.engine.control.event.ElementEvent;
import org.apache.tools.ant.util.FileUtils;
import reger.*;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.core.DateDiff;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.core.ValidationException;
import reger.core.db.Db;
import reger.dao.Pl;
import reger.util.Num;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: joereger
 * Date: 1/19/13
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Dropbox {

    public static String APP_KEY  = "nv41sybz3kc3wpp";
    public static String APP_SECRET = "wqecg2bwdx8yhvf";
    public static Session.AccessType ACCESS_TYPE = Session.AccessType.DROPBOX;



    public static DropboxAPI<WebAuthSession> getApi(int accountid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEv= Db.RunSQL("SELECT dropboxid, access_key, access_secret, oauth_token FROM dropbox WHERE accountid='" + accountid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstEv!=null && rstEv.length>0){
            String access_key = rstEv[0][1];
            String access_secret = rstEv[0][2];
            try{
                AppKeyPair appKeys = new AppKeyPair(Dropbox.APP_KEY, Dropbox.APP_SECRET);
                AccessTokenPair accessTokenPair = new AccessTokenPair(access_key, access_secret);
                WebAuthSession sess = new WebAuthSession(appKeys, Dropbox.ACCESS_TYPE, accessTokenPair);
                DropboxAPI<WebAuthSession> mDBApi = new DropboxAPI<WebAuthSession>(sess);
                return mDBApi;
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }



    public static void downloadFile(String dropboxPath, String localPath, int accountid){
        DropboxAPI<WebAuthSession> api = getApi(accountid);
        if (api==null){return;}

        FileOutputStream outputStream = null;
        try {
            File file = new File(localPath);
            outputStream = new FileOutputStream(file);
            DropboxAPI.DropboxFileInfo info = api.getFile(dropboxPath, null, outputStream, null);
        } catch (DropboxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String getAutoBlogPath(int accountid){
        String autoblogpath = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstCheck = Db.RunSQL("SELECT autoblogpath FROM dropbox WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheck!=null && rstCheck.length>0){
        	autoblogpath = rstCheck[0][0];
        }
        return autoblogpath;
    }

    public static Log getLog(int accountid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCheck = Db.RunSQL("SELECT logid FROM dropbox WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheck!=null && rstCheck.length>0){
            String logStr = rstCheck[0][0];
            if (Num.isinteger(logStr)){
                if (Integer.parseInt(rstCheck[0][0])>0){
                    Log log = new Log(Integer.parseInt(logStr));
                    return log;
                }
            }
        }
        return null;
    }



    public static void processAutoBlogPath(int accountid, boolean forcenow){
        try{

            Log log = getLog(accountid);
            if (log==null || log.getLogid()<=0){return;}
            int logid = log.getLogid();


            DropboxAPI<WebAuthSession> api = Dropbox.getApi(accountid);
            String path = getAutoBlogPath(accountid);

            if (path==null || path.equals("")){
                Debug.logtodb("path empty", "Dropbox");
                return;
            }

            if (api!=null){

                DropboxAPI.Entry rootdir = api.metadata(path, 0, null, true, null);

                for (Iterator<DropboxAPI.Entry> iterator = rootdir.contents.iterator(); iterator.hasNext();) {

                    DropboxAPI.Entry entry = iterator.next();

                    if (entry.isDir){
                        //mb.append("<br/><a href='tools-dropbox.log?path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>"+entry.fileName()+"</a> (<a href='tools-dropbox.log?action=choosepath&path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>Use This</a>)");
                        if (!isPathAlreadyInUse(accountid, entry.fileName())){
                            Debug.logtodb("found directory entry.filename="+entry.fileName(), "Dropbox processAutoBlogPath()");

                            //If was last updated 5 mins ago
                            int REFRAIN_TIME = 3;
                            if (!isUpdatedInLastXMinutes(accountid, entry.path, REFRAIN_TIME) || forcenow){

                                //Create it
                                Debug.logtodb("WILL CREATE POST", "Dropbox processAutoBlogPath()");
                                createPostFromPath(accountid, logid, entry.path);

                            }

                        }
                    } else {
                        Debug.logtodb("Dropbox processAutoBlogPath()", "found file "+entry.fileName());
                    }

                }

            } else {
                Debug.logtodb("api==null", "Dropbox");
            }


        } catch (Exception ex){
            Debug.errorsave(ex, "Dropbox");
        }
    }

    public static boolean isUpdatedInLastXMinutes(int accountid, String path, int xMinutes){
        try{

            DropboxAPI<WebAuthSession> api = Dropbox.getApi(accountid);

            if (path==null || path.equals("")){
                Debug.logtodb("path empty", "Dropbox");
                return false;
            }

            if (api!=null){

                DropboxAPI.Entry rootdir = api.metadata(path, 0, null, true, null);

                //Check the root dir
                if (true){
                    Date modified = RESTUtility.parseDate(rootdir.modified);
                    String modifiedStr = TimeUtils.dateformatcompactwithtime(TimeUtils.getCalFromDate(modified));
                    Calendar d1 = Calendar.getInstance();
                    Calendar d2 = TimeUtils.getCalFromDate(modified);
                    int minutesAgo = DateDiff.dateDiff("minute", d1, d2);
                    if (minutesAgo<=xMinutes){
                        Debug.logtodb(path+" updated "+minutesAgo+" min ago","Dropbox isUpdatedInLastXMinutes()");
                        return true;
                    }
                }


                for (Iterator<DropboxAPI.Entry> iterator = rootdir.contents.iterator(); iterator.hasNext();) {

                    DropboxAPI.Entry entry = iterator.next();

                    Date modified = RESTUtility.parseDate(entry.modified);
                    String modifiedStr = TimeUtils.dateformatcompactwithtime(TimeUtils.getCalFromDate(modified));
                    Calendar d1 = Calendar.getInstance();
                    Calendar d2 = TimeUtils.getCalFromDate(modified);
                    int minutesAgo = DateDiff.dateDiff("minute", d1, d2);
                    if (minutesAgo<=xMinutes){
                        Debug.logtodb(entry.fileName() + " updated "+minutesAgo+" min ago","Dropbox isUpdatedInLastXMinutes()");
                        return true;
                    }

                }

            } else {
                Debug.logtodb("api==null", "Dropbox");
            }


        } catch (Exception ex){
            Debug.errorsave(ex, "Dropbox");
        }
        Debug.logtodb("not updated in last "+xMinutes+" min","Dropbox isUpdatedInLastXMinutes()");
        return false;
    }




    public static boolean isPathAlreadyInUse(int accountid, String path){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCheck = Db.RunSQL("SELECT dropboxpostid FROM dropboxpost WHERE accountid='"+accountid+"' and path='"+reger.core.Util.cleanForSQL(path)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheck!=null && rstCheck.length>0){
            return true;
        }
        return false;
    }

    public static void createPostFromPath(int accountid, int logid, String path){
        try{

            //Connect to Dropbox
            DropboxAPI<WebAuthSession> api = Dropbox.getApi(accountid);

            if (api!=null){

                DropboxAPI.Entry rootdir = api.metadata(path, 0, null, true, null);

                String dirname = rootdir.fileName();
                Debug.logtodb("dirname="+dirname, "Dropbox createPostFromPath()");

                //Set post date by breaking up directory name in format of
                //   2013-04-21-My Post Title Here
                Calendar dateGmt = reger.core.TimeUtils.nowInGmtCalendar();
                try{
                    String[] dirparts = dirname.split("-");
                    String yyyyStr = dirparts[0];
                    String mmStr = dirparts[1];
                    String ddStr = dirparts[2];
                    Calendar date = TimeUtils.formtocalendar(yyyyStr, mmStr, ddStr, "12", "0", "0", "PM");
                    dateGmt = TimeUtils.usertogmttime(date, date.getTimeZone().getID());
                } catch (Exception ex){
                    Debug.errorsave(ex, "Dropbox creating date from subject, will use NOW");
                    dateGmt = reger.core.TimeUtils.nowInGmtCalendar();
                }

                //Set post title from directory name
                //   2013-04-21-My Post Title Here
                String postTitle = "Blog Post";
                try {
                    StringBuffer tmpPostTitle = new StringBuffer();
                    String[] dirparts = dirname.split("-");
                    for (int i = 3; i < dirparts.length; i++) {
                        String part = dirparts[i];
                        if (tmpPostTitle.length()>0){tmpPostTitle.append("-");}
                        tmpPostTitle.append(part);
                    }
                    postTitle = tmpPostTitle.toString();
                }  catch (Exception ex){
                    Debug.errorsave(ex, "Dropbox creating date from subject, will use BLOG POST");
                    postTitle = "Blog Post";
                }

                //Create an instance of the backend object
                reger.Entry entry = new reger.Entry();

                //Get this user's timezone
                String timezoneid = reger.Account.getTimezoneidFromAccountid(accountid);
                reger.Account accountOfEntry = new reger.Account(accountid);
                reger.PrivateLabel plOfEntry = new reger.PrivateLabel(accountOfEntry.getPlid());
                reger.Accountuser accountuserOfPersonAccessing = new reger.Accountuser(Accountuser.getDefaultAccountuseridForAccount(accountid), false);
                String friendlyname = accountuserOfPersonAccessing.getFriendlyname();
                int accountuserid = accountuserOfPersonAccessing.getAccountuserid();


                Debug.debug(3, "Dropb0x", "Dropbox createPostFromPath() - accountuserOfPersonAccessing.getAccountuserid()=" + accountuserOfPersonAccessing.getAccountuserid());

                //Create the entry
                entry = new reger.Entry();
                entry.logid = logid;
                entry.accountid = accountid;

                //Set the title
                entry.title=reger.core.Util.truncateString(postTitle, 255);

                //If the title is blank, use the description
                if (entry.title==null || entry.title.equals("")){
                    entry.title="Blog Post";
                }

                //Set the comments
                entry.comments="";

                //Set the draft/live status
                entry.isDraft = 0;
                entry.isApproved=1;

                //Set the logid
                entry.logid=logid;

                //Populate the date/time vars in the event object
                //@todo pull date from path
                entry.dateGmt = dateGmt;

                //Set the author in the EmailApi posts.
                entry.accountuserid = accountuserid;

                //Create or find the entry
                try{
                    //Save the entry to the database
                    entry.newEntryTemporary(accountOfEntry, accountuserOfPersonAccessing);
                    entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
                } catch (ValidationException error){
                    //@todo Handle the exception and send it back to user via email?
                    Debug.debug(2, "Dropbox", "Dropbox save post Error:" + error.getErrorsAsSingleString());
                }

                Debug.debug(2, "Dropbox", "Dropbox.java - createPostFromPath() Ready to start processing files.");

                //Back to Dropbox... let's iterate and get some files
                for (Iterator<DropboxAPI.Entry> iterator = rootdir.contents.iterator(); iterator.hasNext();) {

                    DropboxAPI.Entry dbentry = iterator.next();

                    if (dbentry.isDir){
                        //mb.append("<br/><a href='tools-dropbox.log?path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>"+entry.fileName()+"</a> (<a href='tools-dropbox.log?action=choosepath&path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>Use This</a>)");
                        if (!isPathAlreadyInUse(accountid, dbentry.path)){
                            Debug.logtodb("Dropbox createPostFromPath()", "found directory entry.filename="+dbentry.fileName());
                            //createPostFromPath(accountid, logid, dbentry.fileName());
                        }
                    } else {
                        Debug.logtodb("Dropbox createPostFromPath()", "found file " + dbentry.fileName());

                        int imageid = 0;
                        boolean keepTrying = true;
                        int attempts = 0;
                        while (keepTrying && attempts<=10){
                            try{
                                imageid = saveImage(accountid, dbentry.path, dbentry.fileName(), entry.eventid, entry, accountuserOfPersonAccessing, plOfEntry);
                                keepTrying = false;
                            } catch (Exception ex){attempts++;Debug.errorsave(ex, "Dropbox in while loop saving image attempts="+attempts);}
                        }

                        //Add the image to the body of the post
                        if (imageid>0 && dbentry.fileName().indexOf("[big]")>-1){
                            entry.comments = entry.comments + "<$image id=\""+imageid+"\"$>";
                        }
                        try{
                            entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
                        } catch (ValidationException error){
                            Debug.debug(3, "Dropbox", "Dropbox save post Error:" + error.getErrorsAsSingleString());
                        }


                    }

                }

                Debug.debug(3, "Dropbox", "Dropbox.java - createPostFromPath() Done processing files.");


                //@todo Must write to dropboxpath to make sure this post isn't re-created next time
                //-----------------------------------
                //-----------------------------------
                int dropboxpostid = Db.RunSQLInsert("INSERT INTO dropboxpost(accountid, path) VALUES('"+accountid+"', '"+ reger.core.Util.cleanForSQL(rootdir.fileName()) +"')");
                //-----------------------------------
                //-----------------------------------


            } else {
                Debug.logtodb("api==null", "Dropbox when trying to create a post");
            }


        } catch (Exception ex){
            Debug.errorsave(ex, "Dropbox");
        }
    }

    public static int saveImage(int accountid, String dbFilePath, String dbFileName, int eventid, Entry entry, Accountuser accountuserOfPersonAccessing, PrivateLabel plOfEntry) throws Exception {
        Debug.logtodb("dbFilePath="+dbFilePath, "Dropbox.saveImage()");

        //Connect to Dropbox
        DropboxAPI<WebAuthSession> api = Dropbox.getApi(accountid);
        if (api!=null){
            DropboxAPI.Entry rootdir = api.metadata(dbFilePath, 0, null, true, null);

            //Make sure there's enough space left for this user
            //Just make sure there's some free space left
            reger.Account acct = new reger.Account(accountid);
            long freespace = acct.getFreespace();
            if (freespace<100000) {
                Debug.debug(3, "Dropbox", "Failed because there's no more free space on this account. freespace="+freespace);
                return 0;
            }

            //Figure out a filename
            String incomingname = dbFileName;
            String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
            String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);

            //Calculate the new dated directory name
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH)+1;
            String monthStr = String.valueOf(month);
            if (monthStr.length()==1){
                monthStr = "0"+monthStr;
            }
            String datedDirectoryName = year+"/"+monthStr;

            //Create directory
            Account account = new Account(accountid);
            String filesdirectory = account.getPathToAccountFiles() + datedDirectoryName + "/";
            File dir = new File(filesdirectory);
            dir.mkdirs();
            File dirThumbs = new File(filesdirectory+".thumbnails/");
            dirThumbs.mkdirs();

            //Test for file existence... if it exists then increment
            String finalfilename = incomingname;
            File savedFile  = new File(filesdirectory, finalfilename);
            int incrementer = 0;
            while (savedFile.exists()){
                incrementer=incrementer+1;
                finalfilename = incomingnamebase+"-"+incrementer;
                if (!incomingnameext.equals("")){
                    finalfilename = finalfilename + "." + incomingnameext;
                }
                savedFile  = new File(filesdirectory, finalfilename);
            }

            //Now write dropbox file to this file
            FileOutputStream outputStream = null;

            outputStream = new FileOutputStream(savedFile);
            DropboxAPI.DropboxFileInfo info = api.getFile(dbFilePath, null, outputStream, null);
            Debug.logtodb("The file's rev is: " + info.getMetadata().rev, "Dropbox save file");

            String mimetype = info.getMimeType();
            Debug.logtodb("The file's mimetype is: " + info.getMimeType(), "Dropbox save file");
            Debug.logtodb("info.getMimeType().substring(0,5): " + info.getMimeType().substring(0, 5), "Dropbox save file");
            if (info.getMimeType().equals("text/plain")){
                processTextFile(accountid, entry, savedFile, accountuserOfPersonAccessing, plOfEntry);
                return 0;
            }
            if (!info.getMimeType().substring(0,5).equals("image")){
                try{
                    FileUtils.delete(savedFile);
                } catch (Exception ex){Debug.errorsave(ex, "Dropbox delete file");}
                return 0;
            }

            //Create thumbnail
            ThumbnailCreator.createThumbnail(savedFile);

            //Resize
            long startTime = new Date().getTime();
            Debug.logtodb("Start resize", "Dropbox Resize File");
            ResizeImage.resizeInPlace(savedFile.getAbsolutePath(), 1600);
            Debug.logtodb("End resize, took "+(new Date().getTime()-startTime)+" millis", "Dropbox Resize File");

            //-----------------------------------
            //-----------------------------------
            int imageid = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, description, originalfilename, accountid, filename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(datedDirectoryName+"/"+finalfilename)+"', '"+info.getFileSize()+"', '"+reger.core.Util.cleanForSQL("")+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(datedDirectoryName+"/"+finalfilename)+"')");
            //-----------------------------------
            //-----------------------------------

            //Get a MediaType handler
            MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
            //Handle any parsing required
            mt.saveToDatabase(filesdirectory+finalfilename, imageid);

            //Refresh entry cache
            reger.cache.EntryCache.flush(eventid);

            //Closeth thy streams, young man
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }

            //return imageid
            return imageid;

        }
        throw new Exception();
    }

    private static void processTextFile(int accountid, Entry entry, File txtFile, Accountuser accountuserOfPersonAccessing, PrivateLabel plOfEntry){
       try{
           entry.comments = entry.comments + deserializeString(txtFile);
           entry.editEntryAll(new Account(accountid), accountuserOfPersonAccessing, plOfEntry);
       } catch (ValidationException error){
           Debug.debug(3, "Dropbox", "Dropbox save post Error:" + error.getErrorsAsSingleString());
       }
       try{
            FileUtils.delete(txtFile);
       } catch (Exception ex){Debug.errorsave(ex, "Dropbox process txt file");}
    }


    public static String deserializeString(File file) {
        try{
          int len;
          char[] chr = new char[4096];
          final StringBuffer buffer = new StringBuffer();
          final FileReader reader = new FileReader(file);
          try {
              while ((len = reader.read(chr)) > 0) {
                  buffer.append(chr, 0, len);
              }
          } finally {
              reader.close();
          }
          return buffer.toString();
        } catch (Exception ex){Debug.errorsave(ex, "Dropbox deserialize txt file");}
        return "";
      }

}
