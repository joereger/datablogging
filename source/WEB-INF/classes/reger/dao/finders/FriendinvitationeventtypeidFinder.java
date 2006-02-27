package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendinvitationeventtypeidDAO;

/**
 * Finder for the 'friendinvitationeventtypeid' DAO
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

public class FriendinvitationeventtypeidFinder {


    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeidid(int friendinvitationeventtypeidid) {
        return findByFriendinvitationeventtypeidid(friendinvitationeventtypeidid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeidid(int friendinvitationeventtypeidid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationid(int friendinvitationid) {
        return findByFriendinvitationid(friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationid(int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeididFriendinvitationid(int friendinvitationeventtypeidid, int friendinvitationid) {
        return findByFriendinvitationeventtypeididFriendinvitationid(friendinvitationeventtypeidid, friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeididFriendinvitationid(int friendinvitationeventtypeidid, int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"', friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeididEventtypeid(int friendinvitationeventtypeidid, int eventtypeid) {
        return findByFriendinvitationeventtypeididEventtypeid(friendinvitationeventtypeidid, eventtypeid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationeventtypeididEventtypeid(int friendinvitationeventtypeidid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationidEventtypeid(int friendinvitationid, int eventtypeid) {
        return findByFriendinvitationidEventtypeid(friendinvitationid, eventtypeid, 0, 50000);
    }

    public static ArrayList<FriendinvitationeventtypeidDAO> findByFriendinvitationidEventtypeid(int friendinvitationid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationeventtypeidDAO> resultarraylist = new ArrayList<FriendinvitationeventtypeidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationid='"+friendinvitationid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationeventtypeidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}