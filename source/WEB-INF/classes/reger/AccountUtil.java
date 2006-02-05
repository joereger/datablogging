package reger;

import reger.core.TimeUtils;
import reger.filesync.server.Util;

import java.util.Vector;
import java.util.Calendar;
import java.util.Hashtable;
import java.io.File;

/**
 * Utilities for the account class
 */
public class AccountUtil {


    public static long getSpaceOfAllFilesInADirectory(String startingPath){
        File start = new File(startingPath);
        return getSpaceUsedByAllFiles(start);
    }

    private static long getSpaceUsedByAllFiles(File in) {
        long spaceused = 0;
        if (in.isDirectory()) {
            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                spaceused = spaceused +getSpaceUsedByAllFiles(new File(in, children[i]));
            }
        } else {
            spaceused = spaceused + in.length();
        }
        return spaceused;
    }

}
