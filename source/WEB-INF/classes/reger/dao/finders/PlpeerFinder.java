package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PlpeerDAO;

/**
 * Finder for the 'plpeer' DAO
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

public class PlpeerFinder {


    public static ArrayList<PlpeerDAO> findByPlpeerid(int plpeerid) {
        return findByPlpeerid(plpeerid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPlpeerid(int plpeerid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plpeerid='"+plpeerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlpeerDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlpeerDAO> findByPeerplid(int peerplid) {
        return findByPeerplid(peerplid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPeerplid(int peerplid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE peerplid='"+peerplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlpeerDAO> findByPlpeeridPlid(int plpeerid, int plid) {
        return findByPlpeeridPlid(plpeerid, plid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPlpeeridPlid(int plpeerid, int plid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plpeerid='"+plpeerid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlpeerDAO> findByPlpeeridPeerplid(int plpeerid, int peerplid) {
        return findByPlpeeridPeerplid(plpeerid, peerplid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPlpeeridPeerplid(int plpeerid, int peerplid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plpeerid='"+plpeerid+"', peerplid='"+peerplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlpeerDAO> findByPlidPeerplid(int plid, int peerplid) {
        return findByPlidPeerplid(plid, peerplid, 0, 50000);
    }

    public static ArrayList<PlpeerDAO> findByPlidPeerplid(int plid, int peerplid, int limitmin, int limitmax) {
        ArrayList<PlpeerDAO> resultarraylist = new ArrayList<PlpeerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plid='"+plid+"', peerplid='"+peerplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlpeerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}