package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PagenotfoundDAO;

/**
 * Finder for the 'pagenotfound' DAO
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

public class PagenotfoundFinder {


    public static ArrayList<PagenotfoundDAO> findByPagenotfoundid(int pagenotfoundid) {
        return findByPagenotfoundid(pagenotfoundid, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundid(int pagenotfoundid, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagename(String pagename) {
        return findByPagename(pagename, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagename(String pagename, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagename='"+reger.core.Util.cleanForSQL(pagename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByCount(int count) {
        return findByCount(count, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByCount(int count, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByMostrecentreferer(String mostrecentreferer) {
        return findByMostrecentreferer(mostrecentreferer, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByMostrecentreferer(String mostrecentreferer, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE mostrecentreferer='"+reger.core.Util.cleanForSQL(mostrecentreferer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidPagename(int pagenotfoundid, String pagename) {
        return findByPagenotfoundidPagename(pagenotfoundid, pagename, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidPagename(int pagenotfoundid, String pagename, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"', pagename='"+reger.core.Util.cleanForSQL(pagename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidCount(int pagenotfoundid, int count) {
        return findByPagenotfoundidCount(pagenotfoundid, count, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidCount(int pagenotfoundid, int count, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidMostrecentreferer(int pagenotfoundid, String mostrecentreferer) {
        return findByPagenotfoundidMostrecentreferer(pagenotfoundid, mostrecentreferer, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenotfoundidMostrecentreferer(int pagenotfoundid, String mostrecentreferer, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"', mostrecentreferer='"+reger.core.Util.cleanForSQL(mostrecentreferer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagenameCount(String pagename, int count) {
        return findByPagenameCount(pagename, count, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenameCount(String pagename, int count, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagename='"+reger.core.Util.cleanForSQL(pagename)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByPagenameMostrecentreferer(String pagename, String mostrecentreferer) {
        return findByPagenameMostrecentreferer(pagename, mostrecentreferer, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByPagenameMostrecentreferer(String pagename, String mostrecentreferer, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagename='"+reger.core.Util.cleanForSQL(pagename)+"', mostrecentreferer='"+reger.core.Util.cleanForSQL(mostrecentreferer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PagenotfoundDAO> findByCountMostrecentreferer(int count, String mostrecentreferer) {
        return findByCountMostrecentreferer(count, mostrecentreferer, 0, 50000);
    }

    public static ArrayList<PagenotfoundDAO> findByCountMostrecentreferer(int count, String mostrecentreferer, int limitmin, int limitmax) {
        ArrayList<PagenotfoundDAO> resultarraylist = new ArrayList<PagenotfoundDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE count='"+count+"', mostrecentreferer='"+reger.core.Util.cleanForSQL(mostrecentreferer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PagenotfoundDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}