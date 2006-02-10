package reger.files;

import reger.Accountuser;
import reger.Account;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

/**
 * Utilities for working with FileAcl objects
 */
public class FileAclUtil {


    /**
     * Start with a path like /dir1/dir2/dir3/
     * If there's an entry in one of the fileacls for this accountuserid, return true
     * Otherwise truncate the last dir to /dir1/dir2/ and recursively look again
     *
     * A user who has access to / will have access to everything
     * A user with access to /folder/ will have access to all files and sub-folders in /folder/
     */
    public static boolean userCanAccessPath(String path, int accountuserid, ArrayList<FileAcl> fileacls){
        boolean canAccessPath = false;
        path = FilenameUtils.normalize(FilenameUtils.getPath(path));
        //Check the current path in the fileacls for an accountuserid<0(public) or equal to this accountuserid
        for (Iterator it = fileacls.iterator(); it.hasNext(); ) {
            FileAcl acl = (FileAcl)it.next();
            if (path.equals(FilenameUtils.normalize(acl.getPathandorfilename()))){
                if (accountuserid==acl.getAccountuserid() || acl.getAccountuserid()<=0){
                    canAccessPath = true;
                }
            }
        }
        //If it's not found, remove the lowest directory and try again
        if (!canAccessPath){
            if (FilenameUtils.indexOfLastSeparator(path)>0){
                path = path.substring(0, FilenameUtils.indexOfLastSeparator(path));
                canAccessPath = userCanAccessPath(path, accountuserid, fileacls);
            } else if (path.length()>0){
                path = "";
                canAccessPath = userCanAccessPath(path, accountuserid, fileacls);
            }
        }
        return canAccessPath;
    }


}
