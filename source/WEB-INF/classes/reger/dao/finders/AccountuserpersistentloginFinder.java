package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuserpersistentloginDAO;

/**
 * Finder for the 'accountuserpersistentlogin' DAO
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

public class AccountuserpersistentloginFinder {


    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginid(int accountuserpersistentloginid) {
        return findByAccountuserpersistentloginid(accountuserpersistentloginid, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginid(int accountuserpersistentloginid, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByRandomstring(String randomstring) {
        return findByRandomstring(randomstring, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByRandomstring(String randomstring, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE randomstring='"+reger.core.Util.cleanForSQL(randomstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByLastusedtologin(java.util.Calendar lastusedtologin) {
        return findByLastusedtologin(lastusedtologin, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByLastusedtologin(java.util.Calendar lastusedtologin, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE lastusedtologin='"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidAccountuserid(int accountuserpersistentloginid, int accountuserid) {
        return findByAccountuserpersistentloginidAccountuserid(accountuserpersistentloginid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidAccountuserid(int accountuserpersistentloginid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidRandomstring(int accountuserpersistentloginid, String randomstring) {
        return findByAccountuserpersistentloginidRandomstring(accountuserpersistentloginid, randomstring, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidRandomstring(int accountuserpersistentloginid, String randomstring, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"', randomstring='"+reger.core.Util.cleanForSQL(randomstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidLastusedtologin(int accountuserpersistentloginid, java.util.Calendar lastusedtologin) {
        return findByAccountuserpersistentloginidLastusedtologin(accountuserpersistentloginid, lastusedtologin, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuserpersistentloginidLastusedtologin(int accountuserpersistentloginid, java.util.Calendar lastusedtologin, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"', lastusedtologin='"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuseridRandomstring(int accountuserid, String randomstring) {
        return findByAccountuseridRandomstring(accountuserid, randomstring, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuseridRandomstring(int accountuserid, String randomstring, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserid='"+accountuserid+"', randomstring='"+reger.core.Util.cleanForSQL(randomstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuseridLastusedtologin(int accountuserid, java.util.Calendar lastusedtologin) {
        return findByAccountuseridLastusedtologin(accountuserid, lastusedtologin, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByAccountuseridLastusedtologin(int accountuserid, java.util.Calendar lastusedtologin, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserid='"+accountuserid+"', lastusedtologin='"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByRandomstringLastusedtologin(String randomstring, java.util.Calendar lastusedtologin) {
        return findByRandomstringLastusedtologin(randomstring, lastusedtologin, 0, 50000);
    }

    public static ArrayList<AccountuserpersistentloginDAO> findByRandomstringLastusedtologin(String randomstring, java.util.Calendar lastusedtologin, int limitmin, int limitmax) {
        ArrayList<AccountuserpersistentloginDAO> resultarraylist = new ArrayList<AccountuserpersistentloginDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE randomstring='"+reger.core.Util.cleanForSQL(randomstring)+"', lastusedtologin='"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpersistentloginDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}