package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PleventtypeidDAO;

/**
 * Finder for the 'pleventtypeid' DAO
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

public class PleventtypeidFinder {


    public static ArrayList<PleventtypeidDAO> findByPleventtypeid(int pleventtypeid) {
        return findByPleventtypeid(pleventtypeid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeid(int pleventtypeid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPriority(int priority) {
        return findByPriority(priority, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPriority(int priority, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE priority='"+priority+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidPlid(int pleventtypeid, int plid) {
        return findByPleventtypeidPlid(pleventtypeid, plid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidPlid(int pleventtypeid, int plid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidEventtypeid(int pleventtypeid, int eventtypeid) {
        return findByPleventtypeidEventtypeid(pleventtypeid, eventtypeid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidEventtypeid(int pleventtypeid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidPriority(int pleventtypeid, int priority) {
        return findByPleventtypeidPriority(pleventtypeid, priority, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPleventtypeidPriority(int pleventtypeid, int priority, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"', priority='"+priority+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPlidEventtypeid(int plid, int eventtypeid) {
        return findByPlidEventtypeid(plid, eventtypeid, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPlidEventtypeid(int plid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE plid='"+plid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByPlidPriority(int plid, int priority) {
        return findByPlidPriority(plid, priority, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByPlidPriority(int plid, int priority, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE plid='"+plid+"', priority='"+priority+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PleventtypeidDAO> findByEventtypeidPriority(int eventtypeid, int priority) {
        return findByEventtypeidPriority(eventtypeid, priority, 0, 50000);
    }

    public static ArrayList<PleventtypeidDAO> findByEventtypeidPriority(int eventtypeid, int priority, int limitmin, int limitmax) {
        ArrayList<PleventtypeidDAO> resultarraylist = new ArrayList<PleventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE eventtypeid='"+eventtypeid+"', priority='"+priority+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PleventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}