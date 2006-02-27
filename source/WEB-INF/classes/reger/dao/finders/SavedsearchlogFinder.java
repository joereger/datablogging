package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearchlogDAO;

/**
 * Finder for the 'savedsearchlog' DAO
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

public class SavedsearchlogFinder {


    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogid(int savedsearchlogid) {
        return findBySavedsearchlogid(savedsearchlogid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogid(int savedsearchlogid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlogDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogidSavedsearchid(int savedsearchlogid, int savedsearchid) {
        return findBySavedsearchlogidSavedsearchid(savedsearchlogid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogidSavedsearchid(int savedsearchlogid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogidLogid(int savedsearchlogid, int logid) {
        return findBySavedsearchlogidLogid(savedsearchlogid, logid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchlogidLogid(int savedsearchlogid, int logid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchidLogid(int savedsearchid, int logid) {
        return findBySavedsearchidLogid(savedsearchid, logid, 0, 50000);
    }

    public static ArrayList<SavedsearchlogDAO> findBySavedsearchidLogid(int savedsearchid, int logid, int limitmin, int limitmax) {
        ArrayList<SavedsearchlogDAO> resultarraylist = new ArrayList<SavedsearchlogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchid='"+savedsearchid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchlogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}