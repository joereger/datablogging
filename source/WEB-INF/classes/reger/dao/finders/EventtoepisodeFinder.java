package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EventtoepisodeDAO;

/**
 * Finder for the 'eventtoepisode' DAO
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

public class EventtoepisodeFinder {


    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeid(int eventtoepisodeid) {
        return findByEventtoepisodeid(eventtoepisodeid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeid(int eventtoepisodeid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtoepisodeDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtoepisodeDAO> findByEpisodeid(int episodeid) {
        return findByEpisodeid(episodeid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEpisodeid(int episodeid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE episodeid='"+episodeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeidEventid(int eventtoepisodeid, int eventid) {
        return findByEventtoepisodeidEventid(eventtoepisodeid, eventid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeidEventid(int eventtoepisodeid, int eventid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeidEpisodeid(int eventtoepisodeid, int episodeid) {
        return findByEventtoepisodeidEpisodeid(eventtoepisodeid, episodeid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEventtoepisodeidEpisodeid(int eventtoepisodeid, int episodeid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"', episodeid='"+episodeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventtoepisodeDAO> findByEventidEpisodeid(int eventid, int episodeid) {
        return findByEventidEpisodeid(eventid, episodeid, 0, 50000);
    }

    public static ArrayList<EventtoepisodeDAO> findByEventidEpisodeid(int eventid, int episodeid, int limitmin, int limitmax) {
        ArrayList<EventtoepisodeDAO> resultarraylist = new ArrayList<EventtoepisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventid='"+eventid+"', episodeid='"+episodeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventtoepisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}