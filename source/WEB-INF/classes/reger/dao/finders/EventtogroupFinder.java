package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EventtogroupDAO;

/**
 * Finder for the 'eventtogroup' DAO
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

public class EventtogroupFinder {


    public static ArrayList<EventtogroupDAO> findByEventtogroupid(int eventtogroupid) {
        return findByEventtogroupid(eventtogroupid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByEventtogroupid(int eventtogroupid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtogroupDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtogroupDAO> findByGroupid(int groupid) {
        return findByGroupid(groupid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByGroupid(int groupid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtogroupDAO> findByEventtogroupidEventid(int eventtogroupid, int eventid) {
        return findByEventtogroupidEventid(eventtogroupid, eventid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByEventtogroupidEventid(int eventtogroupid, int eventid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtogroupDAO> findByEventtogroupidGroupid(int eventtogroupid, int groupid) {
        return findByEventtogroupidGroupid(eventtogroupid, groupid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByEventtogroupidGroupid(int eventtogroupid, int groupid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtogroupDAO> findByEventidGroupid(int eventid, int groupid) {
        return findByEventidGroupid(eventid, groupid, 0, 50000);
    }

    public static ArrayList<EventtogroupDAO> findByEventidGroupid(int eventid, int groupid, int limitmin, int limitmax) {
        ArrayList<EventtogroupDAO> resultarraylist = new ArrayList<EventtogroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventid='"+eventid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtogroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}