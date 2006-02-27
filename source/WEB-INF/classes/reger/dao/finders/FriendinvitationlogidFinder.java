package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendinvitationlogidDAO;

/**
 * Finder for the 'friendinvitationlogid' DAO
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

public class FriendinvitationlogidFinder {


    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogidid(int friendinvitationlogidid) {
        return findByFriendinvitationlogidid(friendinvitationlogidid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogidid(int friendinvitationlogidid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationid(int friendinvitationid) {
        return findByFriendinvitationid(friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationid(int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanread(boolean canread) {
        return findByCanread(canread, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanread(boolean canread, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanwrite(boolean canwrite) {
        return findByCanwrite(canwrite, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanwrite(boolean canwrite, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididFriendinvitationid(int friendinvitationlogidid, int friendinvitationid) {
        return findByFriendinvitationlogididFriendinvitationid(friendinvitationlogidid, friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididFriendinvitationid(int friendinvitationlogidid, int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"', friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididLogid(int friendinvitationlogidid, int logid) {
        return findByFriendinvitationlogididLogid(friendinvitationlogidid, logid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididLogid(int friendinvitationlogidid, int logid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididCanread(int friendinvitationlogidid, boolean canread) {
        return findByFriendinvitationlogididCanread(friendinvitationlogidid, canread, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididCanread(int friendinvitationlogidid, boolean canread, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididCanwrite(int friendinvitationlogidid, boolean canwrite) {
        return findByFriendinvitationlogididCanwrite(friendinvitationlogidid, canwrite, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationlogididCanwrite(int friendinvitationlogidid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidLogid(int friendinvitationid, int logid) {
        return findByFriendinvitationidLogid(friendinvitationid, logid, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidLogid(int friendinvitationid, int logid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationid='"+friendinvitationid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidCanread(int friendinvitationid, boolean canread) {
        return findByFriendinvitationidCanread(friendinvitationid, canread, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidCanread(int friendinvitationid, boolean canread, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationid='"+friendinvitationid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidCanwrite(int friendinvitationid, boolean canwrite) {
        return findByFriendinvitationidCanwrite(friendinvitationid, canwrite, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByFriendinvitationidCanwrite(int friendinvitationid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationid='"+friendinvitationid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogidCanread(int logid, boolean canread) {
        return findByLogidCanread(logid, canread, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogidCanread(int logid, boolean canread, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE logid='"+logid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogidCanwrite(int logid, boolean canwrite) {
        return findByLogidCanwrite(logid, canwrite, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByLogidCanwrite(int logid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE logid='"+logid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanreadCanwrite(boolean canread, boolean canwrite) {
        return findByCanreadCanwrite(canread, canwrite, 0, 50000);
    }

    public static ArrayList<FriendinvitationlogidDAO> findByCanreadCanwrite(boolean canread, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<FriendinvitationlogidDAO> resultarraylist = new ArrayList<FriendinvitationlogidDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE canread='"+reger.core.Util.booleanAsSQLText(canread)+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationlogidDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}