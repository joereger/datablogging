package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuseraclgroupDAO;

/**
 * Finder for the 'accountuseraclgroup' DAO
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

public class AccountuseraclgroupFinder {


    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupid(int accountuseraclgroupid) {
        return findByAccountuseraclgroupid(accountuseraclgroupid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupid(int accountuseraclgroupid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAclgroupid(int aclgroupid) {
        return findByAclgroupid(aclgroupid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAclgroupid(int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAccountuserid(int accountuseraclgroupid, int accountuserid) {
        return findByAccountuseraclgroupidAccountuserid(accountuseraclgroupid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAccountuserid(int accountuseraclgroupid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAclgroupid(int accountuseraclgroupid, int aclgroupid) {
        return findByAccountuseraclgroupidAclgroupid(accountuseraclgroupid, aclgroupid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAclgroupid(int accountuseraclgroupid, int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"', aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAccountid(int accountuseraclgroupid, int accountid) {
        return findByAccountuseraclgroupidAccountid(accountuseraclgroupid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseraclgroupidAccountid(int accountuseraclgroupid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseridAclgroupid(int accountuserid, int aclgroupid) {
        return findByAccountuseridAclgroupid(accountuserid, aclgroupid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseridAclgroupid(int accountuserid, int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuserid='"+accountuserid+"', aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseridAccountid(int accountuserid, int accountid) {
        return findByAccountuseridAccountid(accountuserid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAccountuseridAccountid(int accountuserid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuserid='"+accountuserid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAclgroupidAccountid(int aclgroupid, int accountid) {
        return findByAclgroupidAccountid(aclgroupid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuseraclgroupDAO> findByAclgroupidAccountid(int aclgroupid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuseraclgroupDAO> resultarraylist = new ArrayList<AccountuseraclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE aclgroupid='"+aclgroupid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuseraclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}