package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.DebuglevelDAO;

/**
 * Finder for the 'debuglevel' DAO
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

public class DebuglevelFinder {


    public static ArrayList<DebuglevelDAO> findByDebuglevelid(int debuglevelid) {
        return findByDebuglevelid(debuglevelid, 0, 50000);
    }

    public static ArrayList<DebuglevelDAO> findByDebuglevelid(int debuglevelid, int limitmin, int limitmax) {
        ArrayList<DebuglevelDAO> resultarraylist = new ArrayList<DebuglevelDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT debuglevelid FROM debuglevel WHERE debuglevelid='"+debuglevelid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DebuglevelDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DebuglevelDAO> findByDebuglevel(int debuglevel) {
        return findByDebuglevel(debuglevel, 0, 50000);
    }

    public static ArrayList<DebuglevelDAO> findByDebuglevel(int debuglevel, int limitmin, int limitmax) {
        ArrayList<DebuglevelDAO> resultarraylist = new ArrayList<DebuglevelDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT debuglevelid FROM debuglevel WHERE debuglevel='"+debuglevel+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DebuglevelDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<DebuglevelDAO> findByDebuglevelidDebuglevel(int debuglevelid, int debuglevel) {
        return findByDebuglevelidDebuglevel(debuglevelid, debuglevel, 0, 50000);
    }

    public static ArrayList<DebuglevelDAO> findByDebuglevelidDebuglevel(int debuglevelid, int debuglevel, int limitmin, int limitmax) {
        ArrayList<DebuglevelDAO> resultarraylist = new ArrayList<DebuglevelDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT debuglevelid FROM debuglevel WHERE debuglevelid='"+debuglevelid+"', debuglevel='"+debuglevel+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new DebuglevelDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}