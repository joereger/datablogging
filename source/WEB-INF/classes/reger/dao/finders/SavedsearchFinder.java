package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearchDAO;

/**
 * Finder for the 'savedsearch' DAO
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

public class SavedsearchFinder {


    public static ArrayList<SavedsearchDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastx(int lastx) {
        return findByLastx(lastx, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastx(int lastx, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxunits(int lastxunits) {
        return findByLastxunits(lastxunits, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxunits(int lastxunits, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastxunits='"+lastxunits+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDaterange(int daterange) {
        return findByDaterange(daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDaterange(int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmt(java.util.Calendar datefromgmt) {
        return findByDatefromgmt(datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmt(java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDatetogmt(java.util.Calendar datetogmt) {
        return findByDatetogmt(datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDatetogmt(java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySearchterms(String searchterms) {
        return findBySearchterms(searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySearchterms(String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidName(int savedsearchid, String name) {
        return findBySavedsearchidName(savedsearchid, name, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidName(int savedsearchid, String name, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidAccountid(int savedsearchid, int accountid) {
        return findBySavedsearchidAccountid(savedsearchid, accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidAccountid(int savedsearchid, int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidLastx(int savedsearchid, int lastx) {
        return findBySavedsearchidLastx(savedsearchid, lastx, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidLastx(int savedsearchid, int lastx, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', lastx='"+lastx+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidLastxunits(int savedsearchid, int lastxunits) {
        return findBySavedsearchidLastxunits(savedsearchid, lastxunits, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidLastxunits(int savedsearchid, int lastxunits, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', lastxunits='"+lastxunits+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDaterange(int savedsearchid, int daterange) {
        return findBySavedsearchidDaterange(savedsearchid, daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDaterange(int savedsearchid, int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDatefromgmt(int savedsearchid, java.util.Calendar datefromgmt) {
        return findBySavedsearchidDatefromgmt(savedsearchid, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDatefromgmt(int savedsearchid, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDatetogmt(int savedsearchid, java.util.Calendar datetogmt) {
        return findBySavedsearchidDatetogmt(savedsearchid, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidDatetogmt(int savedsearchid, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidSearchterms(int savedsearchid, String searchterms) {
        return findBySavedsearchidSearchterms(savedsearchid, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findBySavedsearchidSearchterms(int savedsearchid, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameAccountid(String name, int accountid) {
        return findByNameAccountid(name, accountid, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameAccountid(String name, int accountid, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameLastx(String name, int lastx) {
        return findByNameLastx(name, lastx, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameLastx(String name, int lastx, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', lastx='"+lastx+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameLastxunits(String name, int lastxunits) {
        return findByNameLastxunits(name, lastxunits, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameLastxunits(String name, int lastxunits, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', lastxunits='"+lastxunits+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameDaterange(String name, int daterange) {
        return findByNameDaterange(name, daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameDaterange(String name, int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameDatefromgmt(String name, java.util.Calendar datefromgmt) {
        return findByNameDatefromgmt(name, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameDatefromgmt(String name, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameDatetogmt(String name, java.util.Calendar datetogmt) {
        return findByNameDatetogmt(name, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameDatetogmt(String name, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByNameSearchterms(String name, String searchterms) {
        return findByNameSearchterms(name, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByNameSearchterms(String name, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE name='"+reger.core.Util.cleanForSQL(name)+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidLastx(int accountid, int lastx) {
        return findByAccountidLastx(accountid, lastx, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidLastx(int accountid, int lastx, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', lastx='"+lastx+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidLastxunits(int accountid, int lastxunits) {
        return findByAccountidLastxunits(accountid, lastxunits, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidLastxunits(int accountid, int lastxunits, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', lastxunits='"+lastxunits+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDaterange(int accountid, int daterange) {
        return findByAccountidDaterange(accountid, daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDaterange(int accountid, int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDatefromgmt(int accountid, java.util.Calendar datefromgmt) {
        return findByAccountidDatefromgmt(accountid, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDatefromgmt(int accountid, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDatetogmt(int accountid, java.util.Calendar datetogmt) {
        return findByAccountidDatetogmt(accountid, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidDatetogmt(int accountid, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByAccountidSearchterms(int accountid, String searchterms) {
        return findByAccountidSearchterms(accountid, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByAccountidSearchterms(int accountid, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE accountid='"+accountid+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxLastxunits(int lastx, int lastxunits) {
        return findByLastxLastxunits(lastx, lastxunits, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxLastxunits(int lastx, int lastxunits, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"', lastxunits='"+lastxunits+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxDaterange(int lastx, int daterange) {
        return findByLastxDaterange(lastx, daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxDaterange(int lastx, int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxDatefromgmt(int lastx, java.util.Calendar datefromgmt) {
        return findByLastxDatefromgmt(lastx, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxDatefromgmt(int lastx, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxDatetogmt(int lastx, java.util.Calendar datetogmt) {
        return findByLastxDatetogmt(lastx, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxDatetogmt(int lastx, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxSearchterms(int lastx, String searchterms) {
        return findByLastxSearchterms(lastx, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxSearchterms(int lastx, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastx='"+lastx+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDaterange(int lastxunits, int daterange) {
        return findByLastxunitsDaterange(lastxunits, daterange, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDaterange(int lastxunits, int daterange, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastxunits='"+lastxunits+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDatefromgmt(int lastxunits, java.util.Calendar datefromgmt) {
        return findByLastxunitsDatefromgmt(lastxunits, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDatefromgmt(int lastxunits, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastxunits='"+lastxunits+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDatetogmt(int lastxunits, java.util.Calendar datetogmt) {
        return findByLastxunitsDatetogmt(lastxunits, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsDatetogmt(int lastxunits, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastxunits='"+lastxunits+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsSearchterms(int lastxunits, String searchterms) {
        return findByLastxunitsSearchterms(lastxunits, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByLastxunitsSearchterms(int lastxunits, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE lastxunits='"+lastxunits+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeDatefromgmt(int daterange, java.util.Calendar datefromgmt) {
        return findByDaterangeDatefromgmt(daterange, datefromgmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeDatefromgmt(int daterange, java.util.Calendar datefromgmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE daterange='"+daterange+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeDatetogmt(int daterange, java.util.Calendar datetogmt) {
        return findByDaterangeDatetogmt(daterange, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeDatetogmt(int daterange, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE daterange='"+daterange+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeSearchterms(int daterange, String searchterms) {
        return findByDaterangeSearchterms(daterange, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDaterangeSearchterms(int daterange, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE daterange='"+daterange+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmtDatetogmt(java.util.Calendar datefromgmt, java.util.Calendar datetogmt) {
        return findByDatefromgmtDatetogmt(datefromgmt, datetogmt, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmtDatetogmt(java.util.Calendar datefromgmt, java.util.Calendar datetogmt, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmtSearchterms(java.util.Calendar datefromgmt, String searchterms) {
        return findByDatefromgmtSearchterms(datefromgmt, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDatefromgmtSearchterms(java.util.Calendar datefromgmt, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchDAO> findByDatetogmtSearchterms(java.util.Calendar datetogmt, String searchterms) {
        return findByDatetogmtSearchterms(datetogmt, searchterms, 0, 50000);
    }

    public static ArrayList<SavedsearchDAO> findByDatetogmtSearchterms(java.util.Calendar datetogmt, String searchterms, int limitmin, int limitmax) {
        ArrayList<SavedsearchDAO> resultarraylist = new ArrayList<SavedsearchDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}