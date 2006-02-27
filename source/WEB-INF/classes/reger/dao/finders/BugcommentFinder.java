package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BugcommentDAO;

/**
 * Finder for the 'bugcomment' DAO
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

public class BugcommentFinder {


    public static ArrayList<BugcommentDAO> findByBugcommentid(int bugcommentid) {
        return findByBugcommentid(bugcommentid, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugcommentid(int bugcommentid, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugcommentid='"+bugcommentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugid(int bugid) {
        return findByBugid(bugid, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugid(int bugid, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugid='"+bugid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByComment(String comment) {
        return findByComment(comment, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByComment(String comment, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidBugid(int bugcommentid, int bugid) {
        return findByBugcommentidBugid(bugcommentid, bugid, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidBugid(int bugcommentid, int bugid, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugcommentid='"+bugcommentid+"', bugid='"+bugid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidDate(int bugcommentid, java.util.Calendar date) {
        return findByBugcommentidDate(bugcommentid, date, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidDate(int bugcommentid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugcommentid='"+bugcommentid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidComment(int bugcommentid, String comment) {
        return findByBugcommentidComment(bugcommentid, comment, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugcommentidComment(int bugcommentid, String comment, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugcommentid='"+bugcommentid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugidDate(int bugid, java.util.Calendar date) {
        return findByBugidDate(bugid, date, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugidDate(int bugid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugid='"+bugid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByBugidComment(int bugid, String comment) {
        return findByBugidComment(bugid, comment, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByBugidComment(int bugid, String comment, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugid='"+bugid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugcommentDAO> findByDateComment(java.util.Calendar date, String comment) {
        return findByDateComment(date, comment, 0, 50000);
    }

    public static ArrayList<BugcommentDAO> findByDateComment(java.util.Calendar date, String comment, int limitmin, int limitmax) {
        ArrayList<BugcommentDAO> resultarraylist = new ArrayList<BugcommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugcommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}