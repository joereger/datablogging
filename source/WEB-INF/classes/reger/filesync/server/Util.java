package reger.filesync.server;

import org.apache.commons.io.FilenameUtils;
import reger.Account;
import reger.systemprops.AllSystemProperties;

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
        String filesdirectory = FilenameUtils.normalize(AllSystemProperties.getProp("PATHUPLOADMEDIA") + "files" + java.io.File.separator + account.getAccountid() + java.io.File.separator);
        String absPath = FilenameUtils.normalize(file.getAbsolutePath());
        if (absPath.length() > filesdirectory.length()){
            out = absPath.substring(filesdirectory.length(), absPath.length());
        }
        return out;
    }

    public static String getNormalizedFilename(String filename){
        String normalized = FilenameUtils.normalize(filename);
        return normalized;
    }

    



}
