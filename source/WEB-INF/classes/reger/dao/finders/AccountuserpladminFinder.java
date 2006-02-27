package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuserpladminDAO;

/**
 * Finder for the 'accountuserpladmin' DAO
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

public class AccountuserpladminFinder {


    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminid(int accountuserpladminid) {
        return findByAccountuserpladminid(accountuserpladminid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminid(int accountuserpladminid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpladminDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminidAccountuserid(int accountuserpladminid, int accountuserid) {
        return findByAccountuserpladminidAccountuserid(accountuserpladminid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminidAccountuserid(int accountuserpladminid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminidPlid(int accountuserpladminid, int plid) {
        return findByAccountuserpladminidPlid(accountuserpladminid, plid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuserpladminidPlid(int accountuserpladminid, int plid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuseridPlid(int accountuserid, int plid) {
        return findByAccountuseridPlid(accountuserid, plid, 0, 50000);
    }

    public static ArrayList<AccountuserpladminDAO> findByAccountuseridPlid(int accountuserid, int plid, int limitmin, int limitmax) {
        ArrayList<AccountuserpladminDAO> resultarraylist = new ArrayList<AccountuserpladminDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserid='"+accountuserid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserpladminDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}