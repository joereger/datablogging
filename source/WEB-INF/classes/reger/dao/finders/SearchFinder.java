package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SearchDAO;

/**
 * Finder for the 'search' DAO
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

public class SearchFinder {


    public static ArrayList<SearchDAO> findBySearchid(int searchid) {
        return findBySearchid(searchid, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchid(int searchid, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchid='"+searchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<SearchDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findBySearchstring(String searchstring) {
        return findBySearchstring(searchstring, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchstring(String searchstring, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchstring='"+reger.core.Util.cleanForSQL(searchstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findByDatetime(java.util.Calendar datetime) {
        return findByDatetime(datetime, 0, 50000);
    }

    public static ArrayList<SearchDAO> findByDatetime(java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findBySearchidAccountid(int searchid, int accountid) {
        return findBySearchidAccountid(searchid, accountid, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchidAccountid(int searchid, int accountid, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchid='"+searchid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findBySearchidSearchstring(int searchid, String searchstring) {
        return findBySearchidSearchstring(searchid, searchstring, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchidSearchstring(int searchid, String searchstring, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchid='"+searchid+"', searchstring='"+reger.core.Util.cleanForSQL(searchstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findBySearchidDatetime(int searchid, java.util.Calendar datetime) {
        return findBySearchidDatetime(searchid, datetime, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchidDatetime(int searchid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchid='"+searchid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findByAccountidSearchstring(int accountid, String searchstring) {
        return findByAccountidSearchstring(accountid, searchstring, 0, 50000);
    }

    public static ArrayList<SearchDAO> findByAccountidSearchstring(int accountid, String searchstring, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE accountid='"+accountid+"', searchstring='"+reger.core.Util.cleanForSQL(searchstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findByAccountidDatetime(int accountid, java.util.Calendar datetime) {
        return findByAccountidDatetime(accountid, datetime, 0, 50000);
    }

    public static ArrayList<SearchDAO> findByAccountidDatetime(int accountid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE accountid='"+accountid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SearchDAO> findBySearchstringDatetime(String searchstring, java.util.Calendar datetime) {
        return findBySearchstringDatetime(searchstring, datetime, 0, 50000);
    }

    public static ArrayList<SearchDAO> findBySearchstringDatetime(String searchstring, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<SearchDAO> resultarraylist = new ArrayList<SearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchstring='"+reger.core.Util.cleanForSQL(searchstring)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}