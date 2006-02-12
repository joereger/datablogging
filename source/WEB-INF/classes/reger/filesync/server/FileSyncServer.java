package reger.filesync.server;

import reger.Accountuser;
import reger.Account;
import reger.PrivateLabel;
import reger.ThumbnailCreator;
import reger.systemproperties.AllSystemProperties;
import reger.core.TimeUtils;
import reger.core.ValidationException;
import reger.core.db.Db;
import reger.cache.AccountCache;

import java.util.Hashtable;
import java.util.Calendar;
import java.util.Vector;
import java.io.*;

import org.apache.xmlrpc.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;


/**
 * The server side of the filesync operations.
 * This class just handles communications and then sends out work to other classes.
 */
public class FileSyncServer {

//    public Hashtable getFileStatus(String email, String password, String file)  {
//        reger.core.Debug.debug(5, "FileSyncServer.java", "getFileStatus("+email+", "+password+", "+file+") called");
//        Accountuser au = new reger.Accountuser(email, password);
//        if (au.isLoggedIn){
//            Account account = AccountCache.get(au.getAccountid());
//            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
//            File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
//            if (fileObj.exists() && fileObj.canRead() && fileObj.canWrite()){
//                Calendar lastmodifieddategmtCal = Calendar.getInstance();
//                lastmodifieddategmtCal.setTimeInMillis(fileObj.lastModified());
//                lastmodifieddategmtCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(lastmodifieddategmtCal, lastmodifieddategmtCal.getTimeZone().getID(), "GMT");
//                String lastmodifieddategmt = reger.core.TimeUtils.dateformatfordb(lastmodifieddategmtCal);
//                Hashtable out = new Hashtable();
//                out.put("exists", "1");
//                out.put("lastmodifieddategmt", lastmodifieddategmt);
//                return out;
//            } else {
//                Hashtable out = new Hashtable();
//                out.put("exists", "0");
//                return out;
//            }
//        } else {
//            return error("Login failed.");
//        }
//    }

    public Hashtable saveFileOnServer(String email, String password, String file, byte[] filebytes, String lastmodifieddateinmillis) {
        reger.core.Debug.debug(5, "FileSyncServer.java", "saveFileOnServer("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            if (isProtectedDirectoryName(file)){
                return error("Sorry, that file includes a protected directory name.");
            }
            reger.core.Debug.debug(5, "FileSyncServer.java", "au.isLoggedIn=true");
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            byte[] bits = filebytes;
            int contentlength=bits.length - 1;
            long freespace = account.getFreespace();
            if ((long)contentlength>freespace) {
                reger.core.Debug.debug(5, "FileSyncServer.java", "returning error: not enough free space");
                return error("Not enough free storage space available for this account.");
            } else {
                reger.core.Debug.debug(5, "FileSyncServer.java", "there's enough free space, will try to create file");
                File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
                try{
                    fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
                    fileObj.createNewFile();
                } catch (Exception e){
                    reger.core.Debug.debug(5, "FileSyncServer.java", "fileObj.createNewFile() error: " + e.getMessage());
                }

                reger.core.Debug.debug(5, "FileSyncServer.java", "fileObj.canWrite()=true");
                try{
                    FileOutputStream fileOut = new FileOutputStream(fileObj);
                    fileOut.write(bits);
                    fileOut.close();
                    try{
                        if (lastmodifieddateinmillis!=null && !lastmodifieddateinmillis.equals("")){
                            Calendar cal = Calendar.getInstance();
                            cal.setTimeInMillis(Long.parseLong(lastmodifieddateinmillis));
                            cal = TimeUtils.convertFromOneTimeZoneToAnother(cal, "GMT", cal.getTimeZone().getID());
                            //cal.set(2000, 2, 2, 2, 2, 2);
                            if(fileObj.setLastModified(cal.getTime().getTime())){
                                reger.core.Debug.debug(5, "FileSyncServer.java", "Success setting last modified date");
                            } else {
                                reger.core.Debug.debug(5, "FileSyncServer.java", "Success setting last modified date");
                            }
                        }
                    } catch(Exception e){
                        reger.core.Debug.debug(5, "FileSyncServer.java", e);
                    }
                    ThumbnailCreator.createThumbnail(fileObj);
                    account.updateSpaceused();
                    Hashtable out = new Hashtable();
                    out.put("success", "1");
                    reger.core.Debug.debug(5, "FileSyncServer.java", "returning success");
                    return out;
                } catch (Exception e){
                    reger.core.Debug.debug(5, "FileSyncServer.java", "returning error: " + e.getMessage());
                    return error("Error: " + e.getMessage());
                }

            }
            //return new Hashtable();
        } else {
            return error("Login failed.");
        }
    }

    public Hashtable saveDirectoryOnServer(String email, String password, String file) {
        reger.core.Debug.debug(5, "FileSyncServer.java", "saveDirectoryOnServer("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            if (isProtectedDirectoryName(file)){
                return error("Sorry, that directory name includes a protected directory name.");
            }
            reger.core.Debug.debug(5, "FileSyncServer.java", "au.isLoggedIn=true");
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
            reger.core.Debug.debug(5, "FileSyncServer.java", "there's enough free space, will try to create file");
            File fileObj = new File(Util.getFilenamePlusDirectoryName(file, account));
            try{
                fileObj.mkdirs();
            } catch (Exception e){
                reger.core.Debug.debug(5, "FileSyncServer.java", "fileObj.mkdirs() error: " + e.getMessage());
            }
            try{
                Hashtable out = new Hashtable();
                out.put("success", "1");
                reger.core.Debug.debug(5, "FileSyncServer.java", "returning success");
                return out;
            } catch (Exception e){
                reger.core.Debug.debug(5, "FileSyncServer.java", "returning error: " + e.getMessage());
                return error("Error: " + e.getMessage());
            }
            //return new Hashtable();
        } else {
            return error("Login failed.");
        }
    }

    private static boolean isProtectedDirectoryName(String file){
        if (file.indexOf(".thumbnails")>-1 || file.indexOf(".versions")>-1){
            return true;
        }
        return false;
    }

//    public Hashtable renameFile(String email, String password, String file) {
//        reger.core.Debug.debug(5, "FileSyncServer.java", "renameFile("+email+", "+password+", "+file+") called");
//        Accountuser au = new reger.Accountuser(email, password);
//        if (au.isLoggedIn){
//            Account account = AccountCache.get(au.getAccountid());
//            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
//
//            int i = 0;
//            String finalFilename = file;
//            File oldFile = new File(Util.getFilenamePlusDirectoryName(file, account));
//            File newFile = new File(Util.getFilenamePlusDirectoryName(finalFilename, account));
//            while(newFile.exists()){
//                i=i+1;
//                finalFilename = addIndexToFilename(file, String.valueOf(i));
//                newFile = new File(Util.getFilenamePlusDirectoryName(finalFilename, account));
//            }
//            try{
//                FileUtils.copyFile(oldFile, newFile, true);
//
//                //-----------------------------------
//                //-----------------------------------
//                int count = Db.RunSQLUpdate("UPDATE image SET filename='"+reger.core.Util.cleanForSQL(finalFilename)+"' WHERE filename='"+reger.core.Util.cleanForSQL(file)+"' AND accountid='"+account.getAccountid()+"'");
//                //-----------------------------------
//                //-----------------------------------
//            } catch (Exception e){
//                return error("Error: "+e.getMessage());
//            }
//            Hashtable out = new Hashtable();
//            out.put("success", String.valueOf("1"));
//            out.put("newfilename", String.valueOf(finalFilename));
//            return out;
//        } else {
//            return error("Login failed.");
//        }
//    }

//    private static String addIndexToFilename(String file, String index){
//        String pathAndFilenameNoExtension = FilenameUtils.removeExtension(file);
//        String finalFilename = pathAndFilenameNoExtension + "-" + index;
//        if (!FilenameUtils.getExtension(file).equals("")){
//            finalFilename = finalFilename+"."+FilenameUtils.getExtension(file);
//        }
//        return finalFilename;
//    }

//    public Hashtable getStorageRemainingOnAccount(String email, String password) {
//        reger.core.Debug.debug(5, "FileSyncServer.java", "getStorageRemainingOnAccount("+email+", "+password+") called");
//        Accountuser au = new reger.Accountuser(email, password);
//        if (au.isLoggedIn){
//            Account account = AccountCache.get(au.getAccountid());
//            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
//            long freespace = account.getFreespace();
//            Hashtable out = new Hashtable();
//            out.put("freespace", String.valueOf(freespace));
//            return out;
//        } else {
//            return error("Login failed.");
//        }
//    }

    public Vector getListOfFilesOnServer(String email, String password) {
        reger.core.Debug.debug(5, "FileSyncServer.java", "getListOfFilesOnServer("+email+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

            String filesdirectory = AllSystemProperties.getProp("PATHUPLOADMEDIA");
            filesdirectory = filesdirectory + "files/" + account.getAccountid() + "/";
            filesdirectory = Util.getNormalizedFilename(filesdirectory);

            reger.core.Debug.debug(5, "FileSyncServer.java", "getListOfFilesOnServer() about to call getAllFiles on:"+filesdirectory);

            return getAllFiles(new File(filesdirectory), account);
        } else {
            Vector err = new Vector();
            err.add(error("Login failed."));
            return err;
        }
    }

    private static Vector getAllFiles(File in, Account account) {
        reger.core.Debug.debug(5, "FileSyncServer.java", "getAllFiles() called: "+ in.getAbsolutePath());
        Vector out = new Vector();
        Calendar lastmodifieddategmt = Calendar.getInstance();
        lastmodifieddategmt.setTimeInMillis(in.lastModified());
        lastmodifieddategmt = TimeUtils.convertFromOneTimeZoneToAnother(lastmodifieddategmt, lastmodifieddategmt.getTimeZone().getID(), "GMT");

        if (in.isDirectory()) {
            if (!isProtectedDirectoryName(in.getAbsolutePath())){
                Hashtable hash = new Hashtable();
                hash.put(String.valueOf("filename"), Util.getFilenameMinusDirectoryName(in, account));
                hash.put(String.valueOf("lastmodifieddategmt"), reger.core.TimeUtils.dateformatfordb(lastmodifieddategmt));
                hash.put(String.valueOf("isdirectory"), "1");
                out.add(hash);

                String[] children = in.list();
                for (int i=0; i<children.length; i++) {
                    out.addAll(getAllFiles(new File(in, children[i]), account));
                }
            }
        } else {
            Hashtable hash = new Hashtable();
            hash.put(String.valueOf("filename"), Util.getFilenameMinusDirectoryName(in, account));
            hash.put(String.valueOf("lastmodifieddategmt"), reger.core.TimeUtils.dateformatfordb(lastmodifieddategmt));
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

    public Hashtable downloadFileFromServer(String email, String password, String file) {
        reger.core.Debug.debug(5, "FileSyncServer.java", "downloadFileFromServer("+email+", "+password+", "+file+") called");
        Accountuser au = new reger.Accountuser(email, password);
        if (au.isLoggedIn){
            Account account = AccountCache.get(au.getAccountid());
            PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());

            File fileToSend = new File(Util.getFilenamePlusDirectoryName(file, account));
            if (fileToSend.exists()){
                try{
                    Calendar lastmodifieddategmt = Calendar.getInstance();
                    lastmodifieddategmt.setTimeInMillis(fileToSend.lastModified());
                    lastmodifieddategmt = TimeUtils.convertFromOneTimeZoneToAnother(lastmodifieddategmt, lastmodifieddategmt.getTimeZone().getID(), "GMT");


                    Hashtable out = new Hashtable();
                    out.put("success", "1");
                    out.put("file", file);
                    out.put("filebytes", getBytesFromFile(fileToSend));
                    out.put("lastmodifieddateinmillis", String.valueOf(lastmodifieddategmt.getTimeInMillis()));
                    return out;
                } catch (Exception e){
                    return error("Error encoding file: "+e.getMessage());
                }
            } else {
                return error("File not found.");
            }
        } else {
            return error("Login failed.");
        }
    }

//    public static String base64EncodeFile(File in) throws ValidationException {
//        if (in.canRead() && !in.isDirectory()){
//            try{
//                String out = new String(Base64.encode(getBytesFromFile(in)));
//                return out;
//            } catch (IOException ioex){
//                ValidationException vex = new ValidationException();
//                vex.addValidationError(ioex.getMessage());
//                throw vex;
//            }
//        }
//        return "";
//    }

    private static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }


}
