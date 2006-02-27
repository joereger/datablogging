package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.RobotstxtDAO;

/**
 * Finder for the 'robotstxt' DAO
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

public class RobotstxtFinder {


    public static ArrayList<RobotstxtDAO> findByRobotstxtid(int robotstxtid) {
        return findByRobotstxtid(robotstxtid, 0, 50000);
    }

    public static ArrayList<RobotstxtDAO> findByRobotstxtid(int robotstxtid, int limitmin, int limitmax) {
        ArrayList<RobotstxtDAO> resultarraylist = new ArrayList<RobotstxtDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT robotstxtid FROM robotstxt WHERE robotstxtid='"+robotstxtid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new RobotstxtDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<RobotstxtDAO> findByRobotstxt(String robotstxt) {
        return findByRobotstxt(robotstxt, 0, 50000);
    }

    public static ArrayList<RobotstxtDAO> findByRobotstxt(String robotstxt, int limitmin, int limitmax) {
        ArrayList<RobotstxtDAO> resultarraylist = new ArrayList<RobotstxtDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT robotstxtid FROM robotstxt WHERE robotstxt='"+reger.core.Util.cleanForSQL(robotstxt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new RobotstxtDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<RobotstxtDAO> findByRobotstxtidRobotstxt(int robotstxtid, String robotstxt) {
        return findByRobotstxtidRobotstxt(robotstxtid, robotstxt, 0, 50000);
    }

    public static ArrayList<RobotstxtDAO> findByRobotstxtidRobotstxt(int robotstxtid, String robotstxt, int limitmin, int limitmax) {
        ArrayList<RobotstxtDAO> resultarraylist = new ArrayList<RobotstxtDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT robotstxtid FROM robotstxt WHERE robotstxtid='"+robotstxtid+"', robotstxt='"+reger.core.Util.cleanForSQL(robotstxt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new RobotstxtDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}