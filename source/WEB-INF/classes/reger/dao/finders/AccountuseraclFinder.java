package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuseraclDAO;

/**
 * Finder for the 'accountuseracl' DAO
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

public class AccountuseraclFinder {


    public static ArrayList<AccountuseraclDAO> findByAccountuseraclid(int accountuseraclid) {
        return findByAccountuseraclid(accountuseraclid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclid(int accountuseraclid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAclobjectid(int aclobjectid) {
        return findByAclobjectid(aclobjectid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAclobjectid(int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAccountuserid(int accountuseraclid, int accountuserid) {
        return findByAccountuseraclidAccountuserid(accountuseraclid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAccountuserid(int accountuseraclid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAclobjectid(int accountuseraclid, int aclobjectid) {
        return findByAccountuseraclidAclobjectid(accountuseraclid, aclobjectid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAclobjectid(int accountuseraclid, int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"', aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAccountid(int accountuseraclid, int accountid) {
        return findByAccountuseraclidAccountid(accountuseraclid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseraclidAccountid(int accountuseraclid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseridAclobjectid(int accountuserid, int aclobjectid) {
        return findByAccountuseridAclobjectid(accountuserid, aclobjectid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseridAclobjectid(int accountuserid, int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuserid='"+accountuserid+"', aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseridAccountid(int accountuserid, int accountid) {
        return findByAccountuseridAccountid(accountuserid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAccountuseridAccountid(int accountuserid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuserid='"+accountuserid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclDAO> findByAclobjectidAccountid(int aclobjectid, int accountid) {
        return findByAclobjectidAccountid(aclobjectid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclDAO> findByAclobjectidAccountid(int aclobjectid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclDAO> resultarraylist = new ArrayList<AccountuseraclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE aclobjectid='"+aclobjectid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}