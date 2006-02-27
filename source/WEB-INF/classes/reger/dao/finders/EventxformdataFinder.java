package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EventxformdataDAO;

/**
 * Finder for the 'eventxformdata' DAO
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

public class EventxformdataFinder {


    public static ArrayList<EventxformdataDAO> findByEventxformdataid(int eventxformdataid) {
        return findByEventxformdataid(eventxformdataid, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByEventxformdataid(int eventxformdataid, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventxformdataDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventxformdataDAO> findByXformdata(String xformdata) {
        return findByXformdata(xformdata, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByXformdata(String xformdata, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE xformdata='"+reger.core.Util.cleanForSQL(xformdata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventxformdataDAO> findByEventxformdataidEventid(int eventxformdataid, int eventid) {
        return findByEventxformdataidEventid(eventxformdataid, eventid, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByEventxformdataidEventid(int eventxformdataid, int eventid, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventxformdataDAO> findByEventxformdataidXformdata(int eventxformdataid, String xformdata) {
        return findByEventxformdataidXformdata(eventxformdataid, xformdata, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByEventxformdataidXformdata(int eventxformdataid, String xformdata, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"', xformdata='"+reger.core.Util.cleanForSQL(xformdata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventxformdataDAO> findByEventidXformdata(int eventid, String xformdata) {
        return findByEventidXformdata(eventid, xformdata, 0, 50000);
    }

    public static ArrayList<EventxformdataDAO> findByEventidXformdata(int eventid, String xformdata, int limitmin, int limitmax) {
        ArrayList<EventxformdataDAO> resultarraylist = new ArrayList<EventxformdataDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventid='"+eventid+"', xformdata='"+reger.core.Util.cleanForSQL(xformdata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventxformdataDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}