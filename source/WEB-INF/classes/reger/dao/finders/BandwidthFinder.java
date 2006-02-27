package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BandwidthDAO;

/**
 * Finder for the 'bandwidth' DAO
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

public class BandwidthFinder {


    public static ArrayList<BandwidthDAO> findByBandwidthid(int bandwidthid) {
        return findByBandwidthid(bandwidthid, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBandwidthid(int bandwidthid, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByMonth(int month) {
        return findByMonth(month, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByMonth(int month, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE month='"+month+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByYear(int year) {
        return findByYear(year, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByYear(int year, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE year='"+year+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByBytes(int bytes) {
        return findByBytes(bytes, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBytes(int bytes, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bytes='"+bytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidAccountid(int bandwidthid, int accountid) {
        return findByBandwidthidAccountid(bandwidthid, accountid, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidAccountid(int bandwidthid, int accountid, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidMonth(int bandwidthid, int month) {
        return findByBandwidthidMonth(bandwidthid, month, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidMonth(int bandwidthid, int month, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"', month='"+month+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidYear(int bandwidthid, int year) {
        return findByBandwidthidYear(bandwidthid, year, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidYear(int bandwidthid, int year, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"', year='"+year+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidBytes(int bandwidthid, int bytes) {
        return findByBandwidthidBytes(bandwidthid, bytes, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByBandwidthidBytes(int bandwidthid, int bytes, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"', bytes='"+bytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByAccountidMonth(int accountid, int month) {
        return findByAccountidMonth(accountid, month, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByAccountidMonth(int accountid, int month, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE accountid='"+accountid+"', month='"+month+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByAccountidYear(int accountid, int year) {
        return findByAccountidYear(accountid, year, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByAccountidYear(int accountid, int year, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE accountid='"+accountid+"', year='"+year+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByAccountidBytes(int accountid, int bytes) {
        return findByAccountidBytes(accountid, bytes, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByAccountidBytes(int accountid, int bytes, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE accountid='"+accountid+"', bytes='"+bytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByMonthYear(int month, int year) {
        return findByMonthYear(month, year, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByMonthYear(int month, int year, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE month='"+month+"', year='"+year+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByMonthBytes(int month, int bytes) {
        return findByMonthBytes(month, bytes, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByMonthBytes(int month, int bytes, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE month='"+month+"', bytes='"+bytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BandwidthDAO> findByYearBytes(int year, int bytes) {
        return findByYearBytes(year, bytes, 0, 50000);
    }

    public static ArrayList<BandwidthDAO> findByYearBytes(int year, int bytes, int limitmin, int limitmax) {
        ArrayList<BandwidthDAO> resultarraylist = new ArrayList<BandwidthDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE year='"+year+"', bytes='"+bytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BandwidthDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}