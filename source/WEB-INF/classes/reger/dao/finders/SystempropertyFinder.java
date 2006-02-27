package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SystempropertyDAO;

/**
 * Finder for the 'systemproperty' DAO
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

public class SystempropertyFinder {


    public static ArrayList<SystempropertyDAO> findBySystempropertyid(int systempropertyid) {
        return findBySystempropertyid(systempropertyid, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findBySystempropertyid(int systempropertyid, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE systempropertyid='"+systempropertyid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystempropertyDAO> findByPropertyname(String propertyname) {
        return findByPropertyname(propertyname, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findByPropertyname(String propertyname, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE propertyname='"+reger.core.Util.cleanForSQL(propertyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystempropertyDAO> findByPropertyvalue(String propertyvalue) {
        return findByPropertyvalue(propertyvalue, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findByPropertyvalue(String propertyvalue, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE propertyvalue='"+reger.core.Util.cleanForSQL(propertyvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystempropertyDAO> findBySystempropertyidPropertyname(int systempropertyid, String propertyname) {
        return findBySystempropertyidPropertyname(systempropertyid, propertyname, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findBySystempropertyidPropertyname(int systempropertyid, String propertyname, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE systempropertyid='"+systempropertyid+"', propertyname='"+reger.core.Util.cleanForSQL(propertyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystempropertyDAO> findBySystempropertyidPropertyvalue(int systempropertyid, String propertyvalue) {
        return findBySystempropertyidPropertyvalue(systempropertyid, propertyvalue, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findBySystempropertyidPropertyvalue(int systempropertyid, String propertyvalue, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE systempropertyid='"+systempropertyid+"', propertyvalue='"+reger.core.Util.cleanForSQL(propertyvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystempropertyDAO> findByPropertynamePropertyvalue(String propertyname, String propertyvalue) {
        return findByPropertynamePropertyvalue(propertyname, propertyvalue, 0, 50000);
    }

    public static ArrayList<SystempropertyDAO> findByPropertynamePropertyvalue(String propertyname, String propertyvalue, int limitmin, int limitmax) {
        ArrayList<SystempropertyDAO> resultarraylist = new ArrayList<SystempropertyDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE propertyname='"+reger.core.Util.cleanForSQL(propertyname)+"', propertyvalue='"+reger.core.Util.cleanForSQL(propertyvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystempropertyDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}