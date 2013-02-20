package reger.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;
import com.dropbox.client2.session.WebAuthSession;
import reger.core.Debug;
import reger.core.db.Db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
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
        String[][] rstCheck= Db.RunSQL("SELECT autoblogpath FROM dropbox WHERE accountid='"+userSession.getAccount().getAccountid()+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheck!=null && rstCheck.length>0){
        	autoblogpath = rstCheck[0][0];
        }
        return autoblogpath;
    }



    public static void processAutoBlogPath(int accountid){
        try{
            DropboxAPI.Entry rootdir = api.metadata(path, 0, null, true, null);

            for (Iterator<DropboxAPI.Entry> iterator = rootdir.contents.iterator(); iterator.hasNext();) {

                DropboxAPI.Entry entry = iterator.next();

                if (entry.isDir){
                    mb.append("<br/><a href='tools-dropbox.log?path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>"+entry.fileName()+"</a> (<a href='tools-dropbox.log?action=choosepath&path="+ URLEncoder.encode(entry.path, "UTF-8")+"'>Use This</a>)");
                } else {
                    mb.append("<br/>"+entry.fileName());
                }

            }


        } catch (Exception ex){
            Debug.errorsave(ex, "Dropbox");
        }
    }

}
