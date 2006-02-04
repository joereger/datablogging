package reger.filesync.server;

import reger.Accountuser;
import reger.Account;
import reger.PrivateLabel;
import reger.systemproperties.AllSystemProperties;
import reger.core.TimeUtils;
import reger.cache.AccountCache;

import java.util.Hashtable;
import java.util.Calendar;
import java.util.Vector;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.xmlrpc.Base64;


/**
 * The server side of the filesync operations.
 * This class just handles communications and then sends out work to other classes.
 */
public class FileSyncServer {

    public Hashtable getFileStatus(String email, String password, String file)  {
        reger.core.Debug.debug(3, "FileSyncServer.java", "getFileStatus("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
            if (fileObj.exists() && fileObj.canRead() && fileObj.canWrite()){
                Calendar lastmodifieddategmtCal = Calendar.getInstance();
                lastmodifieddategmtCal.setTimeInMillis(fileObj.lastModified());
                lastmodifieddategmtCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(lastmodifieddategmtCal, lastmodifieddategmtCal.getTimeZone().getID(), "GMT");
                String lastmodifieddategmt = reger.core.TimeUtils.dateformatfordb(lastmodifieddategmtCal);
                Hashtable out = new Hashtable();
                out.put("exists", "1");
                out.put("lastmodifieddategmt", lastmodifieddategmt);
                return out;
            } else {
                Hashtable out = new Hashtable();
                out.put("exists", "0");
                return out;
            }
        } else {
            return error("Login failed.");
        }
    }

    public Hashtable saveFileOnServer(String email, String password, String file, String filebase64encoded, String lastmodifieddateinmillis) {
        reger.core.Debug.debug(3, "FileSyncServer.java", "saveFileOnServer("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            reger.core.Debug.debug(3, "FileSyncServer.java", "au.isLoggedIn=true");
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            byte[] bits = filebase64encoded.getBytes();
            bits = Base64.decode(bits);
            int contentlength=bits.length - 1;
            long freespace = account.getFreespace();
            if ((long)contentlength>freespace) {
                reger.core.Debug.debug(3, "FileSyncServer.java", "returning error: not enough free space");
                return error("Not enough free storage space available for this account.");
            } else {
                reger.core.Debug.debug(3, "FileSyncServer.java", "there's enough free space, will try to create file");
                File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
                try{
                    fileObj.createNewFile();
                } catch (Exception e){
                    reger.core.Debug.debug(3, "FileSyncServer.java", "fileObj.createNewFile() error: " + e.getMessage());
                }
                if (fileObj.canWrite()){
                    reger.core.Debug.debug(3, "FileSyncServer.java", "fileObj.canWrite()=true");
                    try{

                        FileOutputStream fileOut = new FileOutputStream(fileObj);
                        fileOut.write(bits);
                        fileObj.setLastModified(new Long(lastmodifieddateinmillis));
                        //@todo Update accountspace calculation
                        Hashtable out = new Hashtable();
                        out.put("success", "1");
                        reger.core.Debug.debug(3, "FileSyncServer.java", "returning success");
                        return out;
                    } catch (Exception e){
                        reger.core.Debug.debug(3, "FileSyncServer.java", "returning error: " + e.getMessage());
                        return error("Error: " + e.getMessage());
                    }
                }
            }
            //return new Hashtable();
        } else {
            return error("Login failed.");
        }
        return error("Unspecified error.");
    }

    public Hashtable saveDirectoryOnServer(String email, String password, String file) {
        reger.core.Debug.debug(3, "FileSyncServer.java", "saveDirectoryOnServer("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            reger.core.Debug.debug(3, "FileSyncServer.java", "au.isLoggedIn=true");
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            reger.core.Debug.debug(3, "FileSyncServer.java", "there's enough free space, will try to create file");
            File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
            try{
                fileObj.mkdirs();
            } catch (Exception e){
                reger.core.Debug.debug(3, "FileSyncServer.java", "fileObj.mkdirs() error: " + e.getMessage());
            }
            try{
                Hashtable out = new Hashtable();
                out.put("success", "1");
                reger.core.Debug.debug(3, "FileSyncServer.java", "returning success");
                return out;
            } catch (Exception e){
                reger.core.Debug.debug(3, "FileSyncServer.java", "returning error: " + e.getMessage());
                return error("Error: " + e.getMessage());
            }
            //return new Hashtable();
        } else {
            return error("Login failed.");
        }
    }

    public Hashtable getStorageRemainingOnAccount(String email, String password) {
        reger.core.Debug.debug(3, "FileSyncServer.java", "getStorageRemainingOnAccount("+email+", "+password+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            long freespace = account.getFreespace();
            Hashtable out = new Hashtable();
            out.put("freespace", String.valueOf(freespace));
            return out;
        } else {
            return error("Login failed.");
        }
    }

    public Vector getListOfFilesOnServer(String email, String password) {
        reger.core.Debug.debug(3, "FileSyncServer.java", "getListOfFilesOnServer("+email+", "+password+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

            String filesdirectory = AllSystemProperties.getProp("PATHUPLOADMEDIA");
            filesdirectory = filesdirectory + "files/" + account.getAccountid() + "/";
            filesdirectory = Util.getNormalizedFilename(filesdirectory);

            return getAllFiles(new File(filesdirectory), account);
        } else {
            Vector err = new Vector();
            err.add(error("Login failed."));
            return err;
        }
    }

    private static Vector getAllFiles(File in, Account account) {
        Vector out = new Vector();
        Calendar lastmodifieddategmt = Calendar.getInstance();
        lastmodifieddategmt.setTimeInMillis(in.lastModified());
        lastmodifieddategmt = TimeUtils.convertFromOneTimeZoneToAnother(lastmodifieddategmt, lastmodifieddategmt.getTimeZone().getID(), "GMT");

        if (in.isDirectory()) {
            Hashtable hash = new Hashtable();
            hash.put(String.valueOf("filename"), Util.getFilenameMinusDirectoryName(in, account));
            hash.put(String.valueOf("lastmodifieddategmt"), lastmodifieddategmt);
            hash.put(String.valueOf("isdirectory"), "1");
            out.add(hash);

            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                out.addAll(getAllFiles(new File(in, children[i]), account));
            }
        } else {
            Hashtable hash = new Hashtable();
            hash.put(String.valueOf("filename"), Util.getFilenameMinusDirectoryName(in, account));
            hash.put(String.valueOf("lastmodifieddategmt"), lastmodifieddategmt);
            hash.put(String.valueOf("isdirectory"), "0");
            out.add(hash);
        }
        return out;
    }

    private static Hashtable error(String error){
        Hashtable out = new Hashtable();
        out.put("error", error);
        return out;
    }


}
