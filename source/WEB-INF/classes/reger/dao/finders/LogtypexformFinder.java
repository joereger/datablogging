package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LogtypexformDAO;

/**
 * Finder for the 'logtypexform' DAO
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

public class LogtypexformFinder {


    public static ArrayList<LogtypexformDAO> findByLogtypexformid(int logtypexformid) {
        return findByLogtypexformid(logtypexformid, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformid(int logtypexformid, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByXform(String xform) {
        return findByXform(xform, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByXform(String xform, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE xform='"+reger.core.Util.cleanForSQL(xform)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByXformdefinition(String xformdefinition) {
        return findByXformdefinition(xformdefinition, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByXformdefinition(String xformdefinition, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE xformdefinition='"+reger.core.Util.cleanForSQL(xformdefinition)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidEventtypeid(int logtypexformid, int eventtypeid) {
        return findByLogtypexformidEventtypeid(logtypexformid, eventtypeid, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidEventtypeid(int logtypexformid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidXform(int logtypexformid, String xform) {
        return findByLogtypexformidXform(logtypexformid, xform, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidXform(int logtypexformid, String xform, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"', xform='"+reger.core.Util.cleanForSQL(xform)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidXformdefinition(int logtypexformid, String xformdefinition) {
        return findByLogtypexformidXformdefinition(logtypexformid, xformdefinition, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByLogtypexformidXformdefinition(int logtypexformid, String xformdefinition, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"', xformdefinition='"+reger.core.Util.cleanForSQL(xformdefinition)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeidXform(int eventtypeid, String xform) {
        return findByEventtypeidXform(eventtypeid, xform, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeidXform(int eventtypeid, String xform, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE eventtypeid='"+eventtypeid+"', xform='"+reger.core.Util.cleanForSQL(xform)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeidXformdefinition(int eventtypeid, String xformdefinition) {
        return findByEventtypeidXformdefinition(eventtypeid, xformdefinition, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByEventtypeidXformdefinition(int eventtypeid, String xformdefinition, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE eventtypeid='"+eventtypeid+"', xformdefinition='"+reger.core.Util.cleanForSQL(xformdefinition)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LogtypexformDAO> findByXformXformdefinition(String xform, String xformdefinition) {
        return findByXformXformdefinition(xform, xformdefinition, 0, 50000);
    }

    public static ArrayList<LogtypexformDAO> findByXformXformdefinition(String xform, String xformdefinition, int limitmin, int limitmax) {
        ArrayList<LogtypexformDAO> resultarraylist = new ArrayList<LogtypexformDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE xform='"+reger.core.Util.cleanForSQL(xform)+"', xformdefinition='"+reger.core.Util.cleanForSQL(xformdefinition)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LogtypexformDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}