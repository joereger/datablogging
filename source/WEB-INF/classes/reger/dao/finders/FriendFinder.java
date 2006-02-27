package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendDAO;

/**
 * Finder for the 'friend' DAO
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

public class FriendFinder {


    public static ArrayList<FriendDAO> findByFriendid(int friendid) {
        return findByFriendid(friendid, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByFriendid(int friendid, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE friendid='"+friendid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendDAO> findByAccountuseridsource(int accountuseridsource) {
        return findByAccountuseridsource(accountuseridsource, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByAccountuseridsource(int accountuseridsource, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE accountuseridsource='"+accountuseridsource+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendDAO> findByAccountuseridtarget(int accountuseridtarget) {
        return findByAccountuseridtarget(accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByAccountuseridtarget(int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendDAO> findByFriendidAccountuseridsource(int friendid, int accountuseridsource) {
        return findByFriendidAccountuseridsource(friendid, accountuseridsource, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByFriendidAccountuseridsource(int friendid, int accountuseridsource, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE friendid='"+friendid+"', accountuseridsource='"+accountuseridsource+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendDAO> findByFriendidAccountuseridtarget(int friendid, int accountuseridtarget) {
        return findByFriendidAccountuseridtarget(friendid, accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByFriendidAccountuseridtarget(int friendid, int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE friendid='"+friendid+"', accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendDAO> findByAccountuseridsourceAccountuseridtarget(int accountuseridsource, int accountuseridtarget) {
        return findByAccountuseridsourceAccountuseridtarget(accountuseridsource, accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendDAO> findByAccountuseridsourceAccountuseridtarget(int accountuseridsource, int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendDAO> resultarraylist = new ArrayList<FriendDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE accountuseridsource='"+accountuseridsource+"', accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}