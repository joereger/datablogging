package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BugcategoryDAO;

/**
 * Finder for the 'bugcategory' DAO
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 */

public class BugcategoryFinder {


    public static ArrayList<BugcategoryDAO> findByBugcategoryid(int bugcategoryid) {
        return findByBugcategoryid(bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugcategoryDAO> findByBugcategoryid(int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugcategoryDAO> resultarraylist = new ArrayList<BugcategoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcategoryid FROM bugcategory WHERE bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcategoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcategoryDAO> findByBugcategory(String bugcategory) {
        return findByBugcategory(bugcategory, 0, 50000);
    }

    public static ArrayList<BugcategoryDAO> findByBugcategory(String bugcategory, int limitmin, int limitmax) {
        ArrayList<BugcategoryDAO> resultarraylist = new ArrayList<BugcategoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcategoryid FROM bugcategory WHERE bugcategory='"+reger.core.Util.cleanForSQL(bugcategory)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcategoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcategoryDAO> findByBugcategoryidBugcategory(int bugcategoryid, String bugcategory) {
        return findByBugcategoryidBugcategory(bugcategoryid, bugcategory, 0, 50000);
    }

    public static ArrayList<BugcategoryDAO> findByBugcategoryidBugcategory(int bugcategoryid, String bugcategory, int limitmin, int limitmax) {
        ArrayList<BugcategoryDAO> resultarraylist = new ArrayList<BugcategoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcategoryid FROM bugcategory WHERE bugcategoryid='"+bugcategoryid+"', bugcategory='"+reger.core.Util.cleanForSQL(bugcategory)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcategoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}