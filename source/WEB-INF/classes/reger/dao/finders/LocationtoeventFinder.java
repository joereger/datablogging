package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LocationtoeventDAO;

/**
 * Finder for the 'locationtoevent' DAO
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

public class LocationtoeventFinder {


    public static ArrayList<LocationtoeventDAO> findByLocationtoeventid(int locationtoeventid) {
        return findByLocationtoeventid(locationtoeventid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByLocationtoeventid(int locationtoeventid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationtoeventDAO> findByLocationid(int locationid) {
        return findByLocationid(locationid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByLocationid(int locationid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationtoeventDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationtoeventDAO> findByLocationtoeventidLocationid(int locationtoeventid, int locationid) {
        return findByLocationtoeventidLocationid(locationtoeventid, locationid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByLocationtoeventidLocationid(int locationtoeventid, int locationid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"', locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationtoeventDAO> findByLocationtoeventidEventid(int locationtoeventid, int eventid) {
        return findByLocationtoeventidEventid(locationtoeventid, eventid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByLocationtoeventidEventid(int locationtoeventid, int eventid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationtoeventDAO> findByLocationidEventid(int locationid, int eventid) {
        return findByLocationidEventid(locationid, eventid, 0, 50000);
    }

    public static ArrayList<LocationtoeventDAO> findByLocationidEventid(int locationid, int eventid, int limitmin, int limitmax) {
        ArrayList<LocationtoeventDAO> resultarraylist = new ArrayList<LocationtoeventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationid='"+locationid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationtoeventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}