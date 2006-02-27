package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.BannertrafficDAO;

/**
 * Finder for the 'bannertraffic' DAO
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

public class BannertrafficFinder {


    public static ArrayList<BannertrafficDAO> findByBannertrafficid(int bannertrafficid) {
        return findByBannertrafficid(bannertrafficid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficid(int bannertrafficid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannerid(int bannerid) {
        return findByBannerid(bannerid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannerid(int bannerid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByImpressions(int impressions) {
        return findByImpressions(impressions, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByImpressions(int impressions, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByClicks(int clicks) {
        return findByClicks(clicks, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByClicks(int clicks, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE clicks='"+clicks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidBannerid(int bannertrafficid, int bannerid) {
        return findByBannertrafficidBannerid(bannertrafficid, bannerid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidBannerid(int bannertrafficid, int bannerid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', bannerid='"+bannerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidDate(int bannertrafficid, java.util.Calendar date) {
        return findByBannertrafficidDate(bannertrafficid, date, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidDate(int bannertrafficid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidImpressions(int bannertrafficid, int impressions) {
        return findByBannertrafficidImpressions(bannertrafficid, impressions, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidImpressions(int bannertrafficid, int impressions, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidClicks(int bannertrafficid, int clicks) {
        return findByBannertrafficidClicks(bannertrafficid, clicks, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidClicks(int bannertrafficid, int clicks, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', clicks='"+clicks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidPlid(int bannertrafficid, int plid) {
        return findByBannertrafficidPlid(bannertrafficid, plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidPlid(int bannertrafficid, int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidEventtypeid(int bannertrafficid, int eventtypeid) {
        return findByBannertrafficidEventtypeid(bannertrafficid, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBannertrafficidEventtypeid(int bannertrafficid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBanneridDate(int bannerid, java.util.Calendar date) {
        return findByBanneridDate(bannerid, date, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBanneridDate(int bannerid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBanneridImpressions(int bannerid, int impressions) {
        return findByBanneridImpressions(bannerid, impressions, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBanneridImpressions(int bannerid, int impressions, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBanneridClicks(int bannerid, int clicks) {
        return findByBanneridClicks(bannerid, clicks, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBanneridClicks(int bannerid, int clicks, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"', clicks='"+clicks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBanneridPlid(int bannerid, int plid) {
        return findByBanneridPlid(bannerid, plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBanneridPlid(int bannerid, int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByBanneridEventtypeid(int bannerid, int eventtypeid) {
        return findByBanneridEventtypeid(bannerid, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByBanneridEventtypeid(int bannerid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannerid='"+bannerid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByDateImpressions(java.util.Calendar date, int impressions) {
        return findByDateImpressions(date, impressions, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByDateImpressions(java.util.Calendar date, int impressions, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', impressions='"+impressions+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByDateClicks(java.util.Calendar date, int clicks) {
        return findByDateClicks(date, clicks, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByDateClicks(java.util.Calendar date, int clicks, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', clicks='"+clicks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByDatePlid(java.util.Calendar date, int plid) {
        return findByDatePlid(date, plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByDatePlid(java.util.Calendar date, int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByDateEventtypeid(java.util.Calendar date, int eventtypeid) {
        return findByDateEventtypeid(date, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByDateEventtypeid(java.util.Calendar date, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsClicks(int impressions, int clicks) {
        return findByImpressionsClicks(impressions, clicks, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsClicks(int impressions, int clicks, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE impressions='"+impressions+"', clicks='"+clicks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsPlid(int impressions, int plid) {
        return findByImpressionsPlid(impressions, plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsPlid(int impressions, int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE impressions='"+impressions+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsEventtypeid(int impressions, int eventtypeid) {
        return findByImpressionsEventtypeid(impressions, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByImpressionsEventtypeid(int impressions, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE impressions='"+impressions+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByClicksPlid(int clicks, int plid) {
        return findByClicksPlid(clicks, plid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByClicksPlid(int clicks, int plid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE clicks='"+clicks+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByClicksEventtypeid(int clicks, int eventtypeid) {
        return findByClicksEventtypeid(clicks, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByClicksEventtypeid(int clicks, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE clicks='"+clicks+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<BannertrafficDAO> findByPlidEventtypeid(int plid, int eventtypeid) {
        return findByPlidEventtypeid(plid, eventtypeid, 0, 50000);
    }

    public static ArrayList<BannertrafficDAO> findByPlidEventtypeid(int plid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<BannertrafficDAO> resultarraylist = new ArrayList<BannertrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE plid='"+plid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new BannertrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}