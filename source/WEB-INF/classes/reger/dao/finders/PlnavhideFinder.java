package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PlnavhideDAO;

/**
 * Finder for the 'plnavhide' DAO
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

public class PlnavhideFinder {


    public static ArrayList<PlnavhideDAO> findByPlnavhideid(int plnavhideid) {
        return findByPlnavhideid(plnavhideid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByPlnavhideid(int plnavhideid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plnavhideid='"+plnavhideid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlnavhideDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlnavhideDAO> findByNestednavid(int nestednavid) {
        return findByNestednavid(nestednavid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByNestednavid(int nestednavid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE nestednavid='"+nestednavid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlnavhideDAO> findByPlnavhideidPlid(int plnavhideid, int plid) {
        return findByPlnavhideidPlid(plnavhideid, plid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByPlnavhideidPlid(int plnavhideid, int plid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plnavhideid='"+plnavhideid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlnavhideDAO> findByPlnavhideidNestednavid(int plnavhideid, int nestednavid) {
        return findByPlnavhideidNestednavid(plnavhideid, nestednavid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByPlnavhideidNestednavid(int plnavhideid, int nestednavid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plnavhideid='"+plnavhideid+"', nestednavid='"+nestednavid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlnavhideDAO> findByPlidNestednavid(int plid, int nestednavid) {
        return findByPlidNestednavid(plid, nestednavid, 0, 50000);
    }

    public static ArrayList<PlnavhideDAO> findByPlidNestednavid(int plid, int nestednavid, int limitmin, int limitmax) {
        ArrayList<PlnavhideDAO> resultarraylist = new ArrayList<PlnavhideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plid='"+plid+"', nestednavid='"+nestednavid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlnavhideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}