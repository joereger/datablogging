package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BugDAO;

/**
 * Finder for the 'bug' DAO
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

public class BugFinder {


    public static ArrayList<BugDAO> findByBugid(int bugid) {
        return findByBugid(bugid, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugid(int bugid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByCreatedate(java.util.Calendar createdate) {
        return findByCreatedate(createdate, 0, 50000);
    }

    public static ArrayList<BugDAO> findByCreatedate(java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByIsopen(boolean isopen) {
        return findByIsopen(isopen, 0, 50000);
    }

    public static ArrayList<BugDAO> findByIsopen(boolean isopen, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findBySeverity(int severity) {
        return findBySeverity(severity, 0, 50000);
    }

    public static ArrayList<BugDAO> findBySeverity(int severity, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE severity='"+severity+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugcategoryid(int bugcategoryid) {
        return findByBugcategoryid(bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugcategoryid(int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByTitle(String title) {
        return findByTitle(title, 0, 50000);
    }

    public static ArrayList<BugDAO> findByTitle(String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugidCreatedate(int bugid, java.util.Calendar createdate) {
        return findByBugidCreatedate(bugid, createdate, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugidCreatedate(int bugid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugidIsopen(int bugid, boolean isopen) {
        return findByBugidIsopen(bugid, isopen, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugidIsopen(int bugid, boolean isopen, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugidSeverity(int bugid, int severity) {
        return findByBugidSeverity(bugid, severity, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugidSeverity(int bugid, int severity, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"', severity='"+severity+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugidBugcategoryid(int bugid, int bugcategoryid) {
        return findByBugidBugcategoryid(bugid, bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugidBugcategoryid(int bugid, int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"', bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugidTitle(int bugid, String title) {
        return findByBugidTitle(bugid, title, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugidTitle(int bugid, String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByCreatedateIsopen(java.util.Calendar createdate, boolean isopen) {
        return findByCreatedateIsopen(createdate, isopen, 0, 50000);
    }

    public static ArrayList<BugDAO> findByCreatedateIsopen(java.util.Calendar createdate, boolean isopen, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByCreatedateSeverity(java.util.Calendar createdate, int severity) {
        return findByCreatedateSeverity(createdate, severity, 0, 50000);
    }

    public static ArrayList<BugDAO> findByCreatedateSeverity(java.util.Calendar createdate, int severity, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', severity='"+severity+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByCreatedateBugcategoryid(java.util.Calendar createdate, int bugcategoryid) {
        return findByCreatedateBugcategoryid(createdate, bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugDAO> findByCreatedateBugcategoryid(java.util.Calendar createdate, int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByCreatedateTitle(java.util.Calendar createdate, String title) {
        return findByCreatedateTitle(createdate, title, 0, 50000);
    }

    public static ArrayList<BugDAO> findByCreatedateTitle(java.util.Calendar createdate, String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByIsopenSeverity(boolean isopen, int severity) {
        return findByIsopenSeverity(isopen, severity, 0, 50000);
    }

    public static ArrayList<BugDAO> findByIsopenSeverity(boolean isopen, int severity, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"', severity='"+severity+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByIsopenBugcategoryid(boolean isopen, int bugcategoryid) {
        return findByIsopenBugcategoryid(isopen, bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugDAO> findByIsopenBugcategoryid(boolean isopen, int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"', bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByIsopenTitle(boolean isopen, String title) {
        return findByIsopenTitle(isopen, title, 0, 50000);
    }

    public static ArrayList<BugDAO> findByIsopenTitle(boolean isopen, String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findBySeverityBugcategoryid(int severity, int bugcategoryid) {
        return findBySeverityBugcategoryid(severity, bugcategoryid, 0, 50000);
    }

    public static ArrayList<BugDAO> findBySeverityBugcategoryid(int severity, int bugcategoryid, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE severity='"+severity+"', bugcategoryid='"+bugcategoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findBySeverityTitle(int severity, String title) {
        return findBySeverityTitle(severity, title, 0, 50000);
    }

    public static ArrayList<BugDAO> findBySeverityTitle(int severity, String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE severity='"+severity+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BugDAO> findByBugcategoryidTitle(int bugcategoryid, String title) {
        return findByBugcategoryidTitle(bugcategoryid, title, 0, 50000);
    }

    public static ArrayList<BugDAO> findByBugcategoryidTitle(int bugcategoryid, String title, int limitmin, int limitmax) {
        ArrayList<BugDAO> resultarraylist = new ArrayList<BugDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugcategoryid='"+bugcategoryid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BugDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}