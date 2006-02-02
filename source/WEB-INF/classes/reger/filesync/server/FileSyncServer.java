package reger.filesync.server;

import reger.Accountuser;
import reger.Account;
import reger.PrivateLabel;
import reger.cache.AccountCache;

import java.util.Hashtable;
import java.util.Calendar;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.xmlrpc.Base64;



/**
 * The server side of the filesync operations.
 * This class just handles communications and then sends out work to other classes.
 */
public class FileSyncServer {

    public Hashtable getFileStatus(String email, String password, String file)  {
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            File fileObj = new File(Util.getFilenameMinusDirectoryName(file, au));
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

    public Hashtable saveFileOnServer(String email, String password, String file, String filebase64encoded) {
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
                byte[] bits = filebase64encoded.getBytes();
                bits = Base64.decode(bits);
                int contentlength=bits.length - 1;
                long freespace = account.getFreespace();
                if ((long)contentlength>freespace) {
                    return error("Not enough free storage space available for this account.");
                } else {
                    File fileObj = new File(Util.getFilenameMinusDirectoryName(file, au));
                    if (fileObj.exists() && fileObj.canRead() && fileObj.canWrite()){
                        try{
                            FileOutputStream fileOut = new FileOutputStream(fileObj);
                            fileOut.write(bits);
                            //@todo Update accountspace calculation
                            Hashtable out = new Hashtable();
                            out.put("success", "1");
                            return out;
                        } catch (Exception e){
                            return error("Error: " + e.getMessage());
                        }
                    }
                }
            return new Hashtable();
        } else {
            return error("Login failed.");
        }
    }

    public Hashtable getStorageRemainingOnAccount(String email, String password) {
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

    private static Hashtable error(String error){
        Hashtable out = new Hashtable();
        out.put("error", error);
        return out;
    }


}
