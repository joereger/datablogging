package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearchlocationDAO;

/**
 * Finder for the 'savedsearchlocation' DAO
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

public class SavedsearchlocationFinder {


    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationid(int savedsearchlocationid) {
        return findBySavedsearchlocationid(savedsearchlocationid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationid(int savedsearchlocationid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlocationDAO> findByLocationid(int locationid) {
        return findByLocationid(locationid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findByLocationid(int locationid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationidSavedsearchid(int savedsearchlocationid, int savedsearchid) {
        return findBySavedsearchlocationidSavedsearchid(savedsearchlocationid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationidSavedsearchid(int savedsearchlocationid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationidLocationid(int savedsearchlocationid, int locationid) {
        return findBySavedsearchlocationidLocationid(savedsearchlocationid, locationid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchlocationidLocationid(int savedsearchlocationid, int locationid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"', locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchidLocationid(int savedsearchid, int locationid) {
        return findBySavedsearchidLocationid(savedsearchid, locationid, 0, 50000);
    }

    public static ArrayList<SavedsearchlocationDAO> findBySavedsearchidLocationid(int savedsearchid, int locationid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlocationDAO> resultarraylist = new ArrayList<SavedsearchlocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchid='"+savedsearchid+"', locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}