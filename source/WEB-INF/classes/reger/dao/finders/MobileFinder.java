package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MobileDAO;

/**
 * Finder for the 'mobile' DAO
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

public class MobileFinder {


    public static ArrayList<MobileDAO> findByMobileid(int mobileid) {
        return findByMobileid(mobileid, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByMobileid(int mobileid, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE mobileid='"+mobileid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MobileDAO> findByXupsubno(String xupsubno) {
        return findByXupsubno(xupsubno, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByXupsubno(String xupsubno, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE xupsubno='"+reger.core.Util.cleanForSQL(xupsubno)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MobileDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MobileDAO> findByMobileidXupsubno(int mobileid, String xupsubno) {
        return findByMobileidXupsubno(mobileid, xupsubno, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByMobileidXupsubno(int mobileid, String xupsubno, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE mobileid='"+mobileid+"', xupsubno='"+reger.core.Util.cleanForSQL(xupsubno)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MobileDAO> findByMobileidAccountuserid(int mobileid, int accountuserid) {
        return findByMobileidAccountuserid(mobileid, accountuserid, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByMobileidAccountuserid(int mobileid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE mobileid='"+mobileid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MobileDAO> findByXupsubnoAccountuserid(String xupsubno, int accountuserid) {
        return findByXupsubnoAccountuserid(xupsubno, accountuserid, 0, 50000);
    }

    public static ArrayList<MobileDAO> findByXupsubnoAccountuserid(String xupsubno, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MobileDAO> resultarraylist = new ArrayList<MobileDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE xupsubno='"+reger.core.Util.cleanForSQL(xupsubno)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MobileDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}