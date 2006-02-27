package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendmessagerecipientDAO;

/**
 * Finder for the 'friendmessagerecipient' DAO
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

public class FriendmessagerecipientFinder {


    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientid(int friendmessagerecipientid) {
        return findByFriendmessagerecipientid(friendmessagerecipientid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientid(int friendmessagerecipientid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageid(int friendmessageid) {
        return findByFriendmessageid(friendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageid(int friendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessageid='"+friendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByIsread(boolean isread) {
        return findByIsread(isread, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByIsread(boolean isread, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE isread='"+reger.core.Util.booleanAsSQLText(isread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidFriendmessageid(int friendmessagerecipientid, int friendmessageid) {
        return findByFriendmessagerecipientidFriendmessageid(friendmessagerecipientid, friendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidFriendmessageid(int friendmessagerecipientid, int friendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"', friendmessageid='"+friendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidAccountuserid(int friendmessagerecipientid, int accountuserid) {
        return findByFriendmessagerecipientidAccountuserid(friendmessagerecipientid, accountuserid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidAccountuserid(int friendmessagerecipientid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidIsread(int friendmessagerecipientid, boolean isread) {
        return findByFriendmessagerecipientidIsread(friendmessagerecipientid, isread, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessagerecipientidIsread(int friendmessagerecipientid, boolean isread, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"', isread='"+reger.core.Util.booleanAsSQLText(isread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageidAccountuserid(int friendmessageid, int accountuserid) {
        return findByFriendmessageidAccountuserid(friendmessageid, accountuserid, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageidAccountuserid(int friendmessageid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessageid='"+friendmessageid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageidIsread(int friendmessageid, boolean isread) {
        return findByFriendmessageidIsread(friendmessageid, isread, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByFriendmessageidIsread(int friendmessageid, boolean isread, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessageid='"+friendmessageid+"', isread='"+reger.core.Util.booleanAsSQLText(isread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessagerecipientDAO> findByAccountuseridIsread(int accountuserid, boolean isread) {
        return findByAccountuseridIsread(accountuserid, isread, 0, 50000);
    }

    public static ArrayList<FriendmessagerecipientDAO> findByAccountuseridIsread(int accountuserid, boolean isread, int limitmin, int limitmax) {
        ArrayList<FriendmessagerecipientDAO> resultarraylist = new ArrayList<FriendmessagerecipientDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE accountuserid='"+accountuserid+"', isread='"+reger.core.Util.booleanAsSQLText(isread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessagerecipientDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}