package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.OffensivecontentplDAO;

/**
 * Finder for the 'offensivecontentpl' DAO
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

public class OffensivecontentplFinder {


    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplid(int offensivecontentplid) {
        return findByOffensivecontentplid(offensivecontentplid, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplid(int offensivecontentplid, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentplDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentplDAO> findByContent(String content) {
        return findByContent(content, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByContent(String content, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplidPlid(int offensivecontentplid, int plid) {
        return findByOffensivecontentplidPlid(offensivecontentplid, plid, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplidPlid(int offensivecontentplid, int plid, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplidContent(int offensivecontentplid, String content) {
        return findByOffensivecontentplidContent(offensivecontentplid, content, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByOffensivecontentplidContent(int offensivecontentplid, String content, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentplDAO> findByPlidContent(int plid, String content) {
        return findByPlidContent(plid, content, 0, 50000);
    }

    public static ArrayList<OffensivecontentplDAO> findByPlidContent(int plid, String content, int limitmin, int limitmax) {
        ArrayList<OffensivecontentplDAO> resultarraylist = new ArrayList<OffensivecontentplDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE plid='"+plid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentplDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}