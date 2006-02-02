package reger.filesync.server;

import org.apache.commons.io.FilenameUtils;
import reger.Accountuser;

/**
 * Utils for the server
 */
public class Util {

    public static String getFilenameMinusDirectoryName(String file, Accountuser au){
        String filesdirectory = reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA");
        filesdirectory = filesdirectory + "files/" + au.getAccountuserid() + "/";
        String out = filesdirectory + file;
        out = getNormalizedFilename(out);
        return out;
    }

    public static String getNormalizedFilename(String filename){
        String normalized = FilenameUtils.normalize(filename);
        return normalized;
    }

    

}
