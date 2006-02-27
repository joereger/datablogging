package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TrafficbypageDAO;

/**
 * Finder for the 'trafficbypage' DAO
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

public class TrafficbypageFinder {


    public static ArrayList<TrafficbypageDAO> findByTrafficbypageid(int trafficbypageid) {
        return findByTrafficbypageid(trafficbypageid, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByTrafficbypageid(int trafficbypageid, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficbypageDAO> findByPagename(String pagename) {
        return findByPagename(pagename, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByPagename(String pagename, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE pagename='"+reger.core.Util.cleanForSQL(pagename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficbypageDAO> findByCount(int count) {
        return findByCount(count, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByCount(int count, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficbypageDAO> findByTrafficbypageidPagename(int trafficbypageid, String pagename) {
        return findByTrafficbypageidPagename(trafficbypageid, pagename, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByTrafficbypageidPagename(int trafficbypageid, String pagename, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"', pagename='"+reger.core.Util.cleanForSQL(pagename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficbypageDAO> findByTrafficbypageidCount(int trafficbypageid, int count) {
        return findByTrafficbypageidCount(trafficbypageid, count, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByTrafficbypageidCount(int trafficbypageid, int count, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficbypageDAO> findByPagenameCount(String pagename, int count) {
        return findByPagenameCount(pagename, count, 0, 50000);
    }

    public static ArrayList<TrafficbypageDAO> findByPagenameCount(String pagename, int count, int limitmin, int limitmax) {
        ArrayList<TrafficbypageDAO> resultarraylist = new ArrayList<TrafficbypageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE pagename='"+reger.core.Util.cleanForSQL(pagename)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficbypageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}