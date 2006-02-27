package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendinvitationgroupDAO;

/**
 * Finder for the 'friendinvitationgroup' DAO
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

public class FriendinvitationgroupFinder {


    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupid(int friendinvitationgroupid) {
        return findByFriendinvitationgroupid(friendinvitationgroupid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupid(int friendinvitationgroupid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationid(int friendinvitationid) {
        return findByFriendinvitationid(friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationid(int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationgroupDAO> findByGroupid(int groupid) {
        return findByGroupid(groupid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByGroupid(int groupid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupidFriendinvitationid(int friendinvitationgroupid, int friendinvitationid) {
        return findByFriendinvitationgroupidFriendinvitationid(friendinvitationgroupid, friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupidFriendinvitationid(int friendinvitationgroupid, int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"', friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupidGroupid(int friendinvitationgroupid, int groupid) {
        return findByFriendinvitationgroupidGroupid(friendinvitationgroupid, groupid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationgroupidGroupid(int friendinvitationgroupid, int groupid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationidGroupid(int friendinvitationid, int groupid) {
        return findByFriendinvitationidGroupid(friendinvitationid, groupid, 0, 50000);
    }

    public static ArrayList<FriendinvitationgroupDAO> findByFriendinvitationidGroupid(int friendinvitationid, int groupid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationgroupDAO> resultarraylist = new ArrayList<FriendinvitationgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationid='"+friendinvitationid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}