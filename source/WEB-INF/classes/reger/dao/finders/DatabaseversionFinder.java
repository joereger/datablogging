package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.DatabaseversionDAO;

/**
 * Finder for the 'databaseversion' DAO
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

public class DatabaseversionFinder {


    public static ArrayList<DatabaseversionDAO> findByDatabaseversionid(int databaseversionid) {
        return findByDatabaseversionid(databaseversionid, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByDatabaseversionid(int databaseversionid, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE databaseversionid='"+databaseversionid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DatabaseversionDAO> findByVersion(int version) {
        return findByVersion(version, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByVersion(int version, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE version='"+version+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DatabaseversionDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DatabaseversionDAO> findByDatabaseversionidVersion(int databaseversionid, int version) {
        return findByDatabaseversionidVersion(databaseversionid, version, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByDatabaseversionidVersion(int databaseversionid, int version, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE databaseversionid='"+databaseversionid+"', version='"+version+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DatabaseversionDAO> findByDatabaseversionidDate(int databaseversionid, java.util.Calendar date) {
        return findByDatabaseversionidDate(databaseversionid, date, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByDatabaseversionidDate(int databaseversionid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE databaseversionid='"+databaseversionid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DatabaseversionDAO> findByVersionDate(int version, java.util.Calendar date) {
        return findByVersionDate(version, date, 0, 50000);
    }

    public static ArrayList<DatabaseversionDAO> findByVersionDate(int version, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<DatabaseversionDAO> resultarraylist = new ArrayList<DatabaseversionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE version='"+version+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DatabaseversionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}