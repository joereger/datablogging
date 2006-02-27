package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuserfieldDAO;

/**
 * Finder for the 'accountuserfield' DAO
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

public class AccountuserfieldFinder {


    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldid(int accountuserfieldid) {
        return findByAccountuserfieldid(accountuserfieldid, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldid(int accountuserfieldid, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitle(String fieldtitle) {
        return findByFieldtitle(fieldtitle, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitle(String fieldtitle, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByFielddata(String fielddata) {
        return findByFielddata(fielddata, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByFielddata(String fielddata, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByOrder(int order) {
        return findByOrder(order, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByOrder(int order, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidAccountuserid(int accountuserfieldid, int accountuserid) {
        return findByAccountuserfieldidAccountuserid(accountuserfieldid, accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidAccountuserid(int accountuserfieldid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidFieldtitle(int accountuserfieldid, String fieldtitle) {
        return findByAccountuserfieldidFieldtitle(accountuserfieldid, fieldtitle, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidFieldtitle(int accountuserfieldid, String fieldtitle, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"', fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidFielddata(int accountuserfieldid, String fielddata) {
        return findByAccountuserfieldidFielddata(accountuserfieldid, fielddata, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidFielddata(int accountuserfieldid, String fielddata, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"', fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidOrder(int accountuserfieldid, int order) {
        return findByAccountuserfieldidOrder(accountuserfieldid, order, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuserfieldidOrder(int accountuserfieldid, int order, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridFieldtitle(int accountuserid, String fieldtitle) {
        return findByAccountuseridFieldtitle(accountuserid, fieldtitle, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridFieldtitle(int accountuserid, String fieldtitle, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserid='"+accountuserid+"', fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridFielddata(int accountuserid, String fielddata) {
        return findByAccountuseridFielddata(accountuserid, fielddata, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridFielddata(int accountuserid, String fielddata, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserid='"+accountuserid+"', fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridOrder(int accountuserid, int order) {
        return findByAccountuseridOrder(accountuserid, order, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByAccountuseridOrder(int accountuserid, int order, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserid='"+accountuserid+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitleFielddata(String fieldtitle, String fielddata) {
        return findByFieldtitleFielddata(fieldtitle, fielddata, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitleFielddata(String fieldtitle, String fielddata, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"', fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitleOrder(String fieldtitle, int order) {
        return findByFieldtitleOrder(fieldtitle, order, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByFieldtitleOrder(String fieldtitle, int order, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserfieldDAO> findByFielddataOrder(String fielddata, int order) {
        return findByFielddataOrder(fielddata, order, 0, 50000);
    }

    public static ArrayList<AccountuserfieldDAO> findByFielddataOrder(String fielddata, int order, int limitmin, int limitmax) {
        ArrayList<AccountuserfieldDAO> resultarraylist = new ArrayList<AccountuserfieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"', order='"+order+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserfieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}