package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BannerDAO;

/**
 * Finder for the 'banner' DAO
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

public class BannerFinder {


    public static ArrayList<BannerDAO> findByBannerid(int bannerid) {
        return findByBannerid(bannerid, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBannerid(int bannerid, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByFilename(String filename) {
        return findByFilename(filename, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByFilename(String filename, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByWidth(int width) {
        return findByWidth(width, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByWidth(int width, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE width='"+width+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByHeight(int height) {
        return findByHeight(height, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByHeight(int height, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE height='"+height+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByActive(boolean active) {
        return findByActive(active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByActive(boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByImpressions(int impressions) {
        return findByImpressions(impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByImpressions(int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridUrl(int bannerid, String url) {
        return findByBanneridUrl(bannerid, url, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridUrl(int bannerid, String url, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridFilename(int bannerid, String filename) {
        return findByBanneridFilename(bannerid, filename, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridFilename(int bannerid, String filename, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridWidth(int bannerid, int width) {
        return findByBanneridWidth(bannerid, width, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridWidth(int bannerid, int width, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', width='"+width+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridHeight(int bannerid, int height) {
        return findByBanneridHeight(bannerid, height, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridHeight(int bannerid, int height, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', height='"+height+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridActive(int bannerid, boolean active) {
        return findByBanneridActive(bannerid, active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridActive(int bannerid, boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByBanneridImpressions(int bannerid, int impressions) {
        return findByBanneridImpressions(bannerid, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByBanneridImpressions(int bannerid, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrlFilename(String url, String filename) {
        return findByUrlFilename(url, filename, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrlFilename(String url, String filename, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"', filename='"+reger.core.Util.cleanForSQL(filename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrlWidth(String url, int width) {
        return findByUrlWidth(url, width, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrlWidth(String url, int width, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"', width='"+width+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrlHeight(String url, int height) {
        return findByUrlHeight(url, height, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrlHeight(String url, int height, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"', height='"+height+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrlActive(String url, boolean active) {
        return findByUrlActive(url, active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrlActive(String url, boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"', active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByUrlImpressions(String url, int impressions) {
        return findByUrlImpressions(url, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByUrlImpressions(String url, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE url='"+reger.core.Util.cleanForSQL(url)+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByFilenameWidth(String filename, int width) {
        return findByFilenameWidth(filename, width, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByFilenameWidth(String filename, int width, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"', width='"+width+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByFilenameHeight(String filename, int height) {
        return findByFilenameHeight(filename, height, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByFilenameHeight(String filename, int height, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"', height='"+height+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByFilenameActive(String filename, boolean active) {
        return findByFilenameActive(filename, active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByFilenameActive(String filename, boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"', active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByFilenameImpressions(String filename, int impressions) {
        return findByFilenameImpressions(filename, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByFilenameImpressions(String filename, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE filename='"+reger.core.Util.cleanForSQL(filename)+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByWidthHeight(int width, int height) {
        return findByWidthHeight(width, height, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByWidthHeight(int width, int height, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE width='"+width+"', height='"+height+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByWidthActive(int width, boolean active) {
        return findByWidthActive(width, active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByWidthActive(int width, boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE width='"+width+"', active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByWidthImpressions(int width, int impressions) {
        return findByWidthImpressions(width, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByWidthImpressions(int width, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE width='"+width+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByHeightActive(int height, boolean active) {
        return findByHeightActive(height, active, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByHeightActive(int height, boolean active, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE height='"+height+"', active='"+reger.core.Util.booleanAsSQLText(active)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByHeightImpressions(int height, int impressions) {
        return findByHeightImpressions(height, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByHeightImpressions(int height, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE height='"+height+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannerDAO> findByActiveImpressions(boolean active, int impressions) {
        return findByActiveImpressions(active, impressions, 0, 50000);
    }

    public static ArrayList<BannerDAO> findByActiveImpressions(boolean active, int impressions, int limitmin, int limitmax) {
        ArrayList<BannerDAO> resultarraylist = new ArrayList<BannerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE active='"+reger.core.Util.booleanAsSQLText(active)+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}