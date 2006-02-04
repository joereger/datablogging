package reger.filesync.server;

import org.apache.commons.io.FilenameUtils;
import reger.Accountuser;
import reger.Account;
import reger.systemproperties.AllSystemProperties;

import java.io.File;

/**
 * Utils for the server
 */
public class Util {

    public static String getFilenamePlusDirectoryName(String file, Account account){
        String filesdirectory = AllSystemProperties.getProp("PATHUPLOADMEDIA");
        filesdirectory = filesdirectory + "files/" + account.getAccountid() + "/";
        String out = filesdirectory + file;
        out = getNormalizedFilename(out);
        return out;
    }

    public static String getFilenameMinusDirectoryName(File file, Account account){
        String out = "";
        String filesdirectory = AllSystemProperties.getProp("PATHUPLOADMEDIA");
        filesdirectory = filesdirectory + "files/" + account.getAccountid() + "/";
        String absPath = file.getAbsolutePath();
        absPath = getNormalizedFilename(absPath);
        filesdirectory = getNormalizedFilename(filesdirectory);
        if (absPath.length() > filesdirectory.length()){
            out = absPath.substring(filesdirectory.length());
        }
        return out;
    }

    public static String getNormalizedFilename(String filename){
        String normalized = FilenameUtils.normalize(filename);
        return normalized;
    }



}
