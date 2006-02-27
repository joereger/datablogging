package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EventtaglinkDAO;

/**
 * Finder for the 'eventtaglink' DAO
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

public class EventtaglinkFinder {


    public static ArrayList<EventtaglinkDAO> findByEventtaglinkid(int eventtaglinkid) {
        return findByEventtaglinkid(eventtaglinkid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByEventtaglinkid(int eventtaglinkid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtaglinkDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtaglinkDAO> findByTagid(int tagid) {
        return findByTagid(tagid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByTagid(int tagid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtaglinkDAO> findByEventtaglinkidEventid(int eventtaglinkid, int eventid) {
        return findByEventtaglinkidEventid(eventtaglinkid, eventid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByEventtaglinkidEventid(int eventtaglinkid, int eventid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtaglinkDAO> findByEventtaglinkidTagid(int eventtaglinkid, int tagid) {
        return findByEventtaglinkidTagid(eventtaglinkid, tagid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByEventtaglinkidTagid(int eventtaglinkid, int tagid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"', tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtaglinkDAO> findByEventidTagid(int eventid, int tagid) {
        return findByEventidTagid(eventid, tagid, 0, 50000);
    }

    public static ArrayList<EventtaglinkDAO> findByEventidTagid(int eventid, int tagid, int limitmin, int limitmax) {
        ArrayList<EventtaglinkDAO> resultarraylist = new ArrayList<EventtaglinkDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventid='"+eventid+"', tagid='"+tagid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtaglinkDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}