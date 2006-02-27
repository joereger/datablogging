package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PolarhrmDAO;

/**
 * Finder for the 'polarhrm' DAO
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

public class PolarhrmFinder {


    public static ArrayList<PolarhrmDAO> findByPolarhrmid(int polarhrmid) {
        return findByPolarhrmid(polarhrmid, 0, 50000);
    }

    public static ArrayList<PolarhrmDAO> findByPolarhrmid(int polarhrmid, int limitmin, int limitmax) {
        ArrayList<PolarhrmDAO> resultarraylist = new ArrayList<PolarhrmDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmid FROM polarhrm WHERE polarhrmid='"+polarhrmid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmDAO> findByImageid(int imageid) {
        return findByImageid(imageid, 0, 50000);
    }

    public static ArrayList<PolarhrmDAO> findByImageid(int imageid, int limitmin, int limitmax) {
        ArrayList<PolarhrmDAO> resultarraylist = new ArrayList<PolarhrmDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmid FROM polarhrm WHERE imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PolarhrmDAO> findByPolarhrmidImageid(int polarhrmid, int imageid) {
        return findByPolarhrmidImageid(polarhrmid, imageid, 0, 50000);
    }

    public static ArrayList<PolarhrmDAO> findByPolarhrmidImageid(int polarhrmid, int imageid, int limitmin, int limitmax) {
        ArrayList<PolarhrmDAO> resultarraylist = new ArrayList<PolarhrmDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT polarhrmid FROM polarhrm WHERE polarhrmid='"+polarhrmid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PolarhrmDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}