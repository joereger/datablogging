package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearcheventtypeDAO;

/**
 * Finder for the 'savedsearcheventtype' DAO
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

public class SavedsearcheventtypeFinder {


    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeid(int savedsearcheventtypeid) {
        return findBySavedsearcheventtypeid(savedsearcheventtypeid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeid(int savedsearcheventtypeid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearcheventtypeDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeidSavedsearchid(int savedsearcheventtypeid, int savedsearchid) {
        return findBySavedsearcheventtypeidSavedsearchid(savedsearcheventtypeid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeidSavedsearchid(int savedsearcheventtypeid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeidEventtypeid(int savedsearcheventtypeid, int eventtypeid) {
        return findBySavedsearcheventtypeidEventtypeid(savedsearcheventtypeid, eventtypeid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearcheventtypeidEventtypeid(int savedsearcheventtypeid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearchidEventtypeid(int savedsearchid, int eventtypeid) {
        return findBySavedsearchidEventtypeid(savedsearchid, eventtypeid, 0, 50000);
    }

    public static ArrayList<SavedsearcheventtypeDAO> findBySavedsearchidEventtypeid(int savedsearchid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<SavedsearcheventtypeDAO> resultarraylist = new ArrayList<SavedsearcheventtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearchid='"+savedsearchid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearcheventtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}