package reger.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;
import com.dropbox.client2.session.WebAuthSession;
import reger.Account;
import reger.Accountuser;
import reger.api.EmailApiAddress;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.core.ValidationException;
import reger.core.db.Db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;

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



    public static void processAutoBlogPath(int accountid, int logid){
        try{
            if (logid==0){
                logid = Account.getDefaultLogid(accountid);
            }


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
                        if (!isPathAlreadyInUse(accountid, entry.path)){
                            Debug.logtodb("Dropbox processAutoBlogPath()", "found directory entry.filename="+entry.fileName());
                            createPostFromPath(accountid, logid, entry.fileName());
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

            //Create an instance of the backend object
            reger.Entry entry = new reger.Entry();

            try {

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
                entry.title=reger.core.Util.truncateString(path, 255);

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
                entry.dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

                //Set the author in the EmailApi posts.
                entry.accountuserid = accountuserid;

                //Create or find the entry
                try{
                    //Save the entry to the database
                    entry.newEntryTemporary(accountOfEntry, accountuserOfPersonAccessing);
                    entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
                } catch (ValidationException error){
                    //@todo Handle the exception and send it back to user via email?
                    Debug.debug(3, "Dropbox", "Dropbox save post Error:" + error.getErrorsAsSingleString());
                }

                Debug.debug(3, "Dropbox", "Dropbox.java - createPostFromPath() Ready to start processing files.");

                //@todo process files

                Debug.debug(3, "Dropbox", "Dropbox.java - createPostFromPath() Done processing files.");


            } catch (Exception e) {
                Debug.errorsave(e, "Dropbox");
            }


        } catch (Exception ex){
            Debug.errorsave(ex, "Dropbox");
        }
    }

}
