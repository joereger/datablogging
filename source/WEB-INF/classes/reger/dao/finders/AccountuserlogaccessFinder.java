package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuserlogaccessDAO;

/**
 * Finder for the 'accountuserlogaccess' DAO
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

public class AccountuserlogaccessFinder {


    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessid(int accountuserlogaccessid) {
        return findByAccountuserlogaccessid(accountuserlogaccessid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessid(int accountuserlogaccessid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanread(boolean canread) {
        return findByCanread(canread, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanread(boolean canread, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanwrite(boolean canwrite) {
        return findByCanwrite(canwrite, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanwrite(boolean canwrite, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidAccountuserid(int accountuserlogaccessid, int accountuserid) {
        return findByAccountuserlogaccessidAccountuserid(accountuserlogaccessid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidAccountuserid(int accountuserlogaccessid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidLogid(int accountuserlogaccessid, int logid) {
        return findByAccountuserlogaccessidLogid(accountuserlogaccessid, logid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidLogid(int accountuserlogaccessid, int logid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidCanread(int accountuserlogaccessid, boolean canread) {
        return findByAccountuserlogaccessidCanread(accountuserlogaccessid, canread, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidCanread(int accountuserlogaccessid, boolean canread, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidCanwrite(int accountuserlogaccessid, boolean canwrite) {
        return findByAccountuserlogaccessidCanwrite(accountuserlogaccessid, canwrite, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuserlogaccessidCanwrite(int accountuserlogaccessid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridLogid(int accountuserid, int logid) {
        return findByAccountuseridLogid(accountuserid, logid, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridLogid(int accountuserid, int logid, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridCanread(int accountuserid, boolean canread) {
        return findByAccountuseridCanread(accountuserid, canread, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridCanread(int accountuserid, boolean canread, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridCanwrite(int accountuserid, boolean canwrite) {
        return findByAccountuseridCanwrite(accountuserid, canwrite, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByAccountuseridCanwrite(int accountuserid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogidCanread(int logid, boolean canread) {
        return findByLogidCanread(logid, canread, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogidCanread(int logid, boolean canread, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE logid='"+logid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogidCanwrite(int logid, boolean canwrite) {
        return findByLogidCanwrite(logid, canwrite, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByLogidCanwrite(int logid, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE logid='"+logid+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanreadCanwrite(boolean canread, boolean canwrite) {
        return findByCanreadCanwrite(canread, canwrite, 0, 50000);
    }

    public static ArrayList<AccountuserlogaccessDAO> findByCanreadCanwrite(boolean canread, boolean canwrite, int limitmin, int limitmax) {
        ArrayList<AccountuserlogaccessDAO> resultarraylist = new ArrayList<AccountuserlogaccessDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE canread='"+reger.core.Util.booleanAsSQLText(canread)+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserlogaccessDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}