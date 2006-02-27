package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearchaccountDAO;

/**
 * Finder for the 'savedsearchaccount' DAO
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

public class SavedsearchaccountFinder {


    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountid(int savedsearchaccountid) {
        return findBySavedsearchaccountid(savedsearchaccountid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountid(int savedsearchaccountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchaccountDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountidSavedsearchid(int savedsearchaccountid, int savedsearchid) {
        return findBySavedsearchaccountidSavedsearchid(savedsearchaccountid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountidSavedsearchid(int savedsearchaccountid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountidAccountid(int savedsearchaccountid, int accountid) {
        return findBySavedsearchaccountidAccountid(savedsearchaccountid, accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchaccountidAccountid(int savedsearchaccountid, int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchidAccountid(int savedsearchid, int accountid) {
        return findBySavedsearchidAccountid(savedsearchid, accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchaccountDAO> findBySavedsearchidAccountid(int savedsearchid, int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchaccountDAO> resultarraylist = new ArrayList<SavedsearchaccountDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchid='"+savedsearchid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchaccountDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}