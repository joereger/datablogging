package reger;

import reger.core.db.Db;

/**
 * Util for the built-in bug tracker
 */
public class BugUtil {


    /**
     * Goes to the database to find a bug category called "User Comments" and if one isn't there creates it.
     */
     public static int bugcategoryidForUserComments(){
        int bugcategoryid = -1;

        //-----------------------------------
        //-----------------------------------
        String[][] rstCat= Db.RunSQL("SELECT bugcategoryid FROM bugcategory WHERE bugcategory='User Comments'");
        //-----------------------------------
        //-----------------------------------
        if (rstCat!=null && rstCat.length>0){
            bugcategoryid=Integer.parseInt(rstCat[0][0]);
        } else {
            //Create one
            //-----------------------------------
            //-----------------------------------
            bugcategoryid = Db.RunSQLInsert("INSERT INTO bugcategory(bugcategory) VALUES('User Comments')");
            //-----------------------------------
            //-----------------------------------
        }

        return bugcategoryid;
    }
}
