package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TrackbackDAO;

/**
 * Finder for the 'trackback' DAO
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

public class TrackbackFinder {


    public static ArrayList<TrackbackDAO> findByTrackbackid(int trackbackid) {
        return findByTrackbackid(trackbackid, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackid(int trackbackid, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutbound(boolean isoutbound) {
        return findByIsoutbound(isoutbound, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutbound(boolean isoutbound, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalready(boolean ispingedalready) {
        return findByIspingedalready(ispingedalready, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalready(boolean ispingedalready, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByBlogname(String blogname) {
        return findByBlogname(blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByBlogname(String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByPosttitle(String posttitle) {
        return findByPosttitle(posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByPosttitle(String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByExcerpt(String excerpt) {
        return findByExcerpt(excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByExcerpt(String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByDatetime(java.util.Calendar datetime) {
        return findByDatetime(datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByDatetime(java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidEventid(int trackbackid, int eventid) {
        return findByTrackbackidEventid(trackbackid, eventid, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidEventid(int trackbackid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIsoutbound(int trackbackid, boolean isoutbound) {
        return findByTrackbackidIsoutbound(trackbackid, isoutbound, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIsoutbound(int trackbackid, boolean isoutbound, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIspingedalready(int trackbackid, boolean ispingedalready) {
        return findByTrackbackidIspingedalready(trackbackid, ispingedalready, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIspingedalready(int trackbackid, boolean ispingedalready, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidUrl(int trackbackid, String url) {
        return findByTrackbackidUrl(trackbackid, url, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidUrl(int trackbackid, String url, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidBlogname(int trackbackid, String blogname) {
        return findByTrackbackidBlogname(trackbackid, blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidBlogname(int trackbackid, String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidPosttitle(int trackbackid, String posttitle) {
        return findByTrackbackidPosttitle(trackbackid, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidPosttitle(int trackbackid, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidExcerpt(int trackbackid, String excerpt) {
        return findByTrackbackidExcerpt(trackbackid, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidExcerpt(int trackbackid, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidDatetime(int trackbackid, java.util.Calendar datetime) {
        return findByTrackbackidDatetime(trackbackid, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidDatetime(int trackbackid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIsapproved(int trackbackid, boolean isapproved) {
        return findByTrackbackidIsapproved(trackbackid, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByTrackbackidIsapproved(int trackbackid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidIsoutbound(int eventid, boolean isoutbound) {
        return findByEventidIsoutbound(eventid, isoutbound, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidIsoutbound(int eventid, boolean isoutbound, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidIspingedalready(int eventid, boolean ispingedalready) {
        return findByEventidIspingedalready(eventid, ispingedalready, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidIspingedalready(int eventid, boolean ispingedalready, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidUrl(int eventid, String url) {
        return findByEventidUrl(eventid, url, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidUrl(int eventid, String url, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidBlogname(int eventid, String blogname) {
        return findByEventidBlogname(eventid, blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidBlogname(int eventid, String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidPosttitle(int eventid, String posttitle) {
        return findByEventidPosttitle(eventid, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidPosttitle(int eventid, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidExcerpt(int eventid, String excerpt) {
        return findByEventidExcerpt(eventid, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidExcerpt(int eventid, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidDatetime(int eventid, java.util.Calendar datetime) {
        return findByEventidDatetime(eventid, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidDatetime(int eventid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByEventidIsapproved(int eventid, boolean isapproved) {
        return findByEventidIsapproved(eventid, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByEventidIsapproved(int eventid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundIspingedalready(boolean isoutbound, boolean ispingedalready) {
        return findByIsoutboundIspingedalready(isoutbound, ispingedalready, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundIspingedalready(boolean isoutbound, boolean ispingedalready, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundUrl(boolean isoutbound, String url) {
        return findByIsoutboundUrl(isoutbound, url, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundUrl(boolean isoutbound, String url, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundBlogname(boolean isoutbound, String blogname) {
        return findByIsoutboundBlogname(isoutbound, blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundBlogname(boolean isoutbound, String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundPosttitle(boolean isoutbound, String posttitle) {
        return findByIsoutboundPosttitle(isoutbound, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundPosttitle(boolean isoutbound, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundExcerpt(boolean isoutbound, String excerpt) {
        return findByIsoutboundExcerpt(isoutbound, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundExcerpt(boolean isoutbound, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundDatetime(boolean isoutbound, java.util.Calendar datetime) {
        return findByIsoutboundDatetime(isoutbound, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundDatetime(boolean isoutbound, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundIsapproved(boolean isoutbound, boolean isapproved) {
        return findByIsoutboundIsapproved(isoutbound, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIsoutboundIsapproved(boolean isoutbound, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyUrl(boolean ispingedalready, String url) {
        return findByIspingedalreadyUrl(ispingedalready, url, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyUrl(boolean ispingedalready, String url, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyBlogname(boolean ispingedalready, String blogname) {
        return findByIspingedalreadyBlogname(ispingedalready, blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyBlogname(boolean ispingedalready, String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyPosttitle(boolean ispingedalready, String posttitle) {
        return findByIspingedalreadyPosttitle(ispingedalready, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyPosttitle(boolean ispingedalready, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyExcerpt(boolean ispingedalready, String excerpt) {
        return findByIspingedalreadyExcerpt(ispingedalready, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyExcerpt(boolean ispingedalready, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyDatetime(boolean ispingedalready, java.util.Calendar datetime) {
        return findByIspingedalreadyDatetime(ispingedalready, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyDatetime(boolean ispingedalready, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyIsapproved(boolean ispingedalready, boolean isapproved) {
        return findByIspingedalreadyIsapproved(ispingedalready, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByIspingedalreadyIsapproved(boolean ispingedalready, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrlBlogname(String url, String blogname) {
        return findByUrlBlogname(url, blogname, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrlBlogname(String url, String blogname, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrlPosttitle(String url, String posttitle) {
        return findByUrlPosttitle(url, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrlPosttitle(String url, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrlExcerpt(String url, String excerpt) {
        return findByUrlExcerpt(url, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrlExcerpt(String url, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrlDatetime(String url, java.util.Calendar datetime) {
        return findByUrlDatetime(url, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrlDatetime(String url, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByUrlIsapproved(String url, boolean isapproved) {
        return findByUrlIsapproved(url, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByUrlIsapproved(String url, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE url='"+reger.core.Util.cleanForSQL(url)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByBlognamePosttitle(String blogname, String posttitle) {
        return findByBlognamePosttitle(blogname, posttitle, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByBlognamePosttitle(String blogname, String posttitle, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE blogname='"+reger.core.Util.cleanForSQL(blogname)+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByBlognameExcerpt(String blogname, String excerpt) {
        return findByBlognameExcerpt(blogname, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByBlognameExcerpt(String blogname, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE blogname='"+reger.core.Util.cleanForSQL(blogname)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByBlognameDatetime(String blogname, java.util.Calendar datetime) {
        return findByBlognameDatetime(blogname, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByBlognameDatetime(String blogname, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE blogname='"+reger.core.Util.cleanForSQL(blogname)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByBlognameIsapproved(String blogname, boolean isapproved) {
        return findByBlognameIsapproved(blogname, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByBlognameIsapproved(String blogname, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE blogname='"+reger.core.Util.cleanForSQL(blogname)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByPosttitleExcerpt(String posttitle, String excerpt) {
        return findByPosttitleExcerpt(posttitle, excerpt, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByPosttitleExcerpt(String posttitle, String excerpt, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByPosttitleDatetime(String posttitle, java.util.Calendar datetime) {
        return findByPosttitleDatetime(posttitle, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByPosttitleDatetime(String posttitle, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByPosttitleIsapproved(String posttitle, boolean isapproved) {
        return findByPosttitleIsapproved(posttitle, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByPosttitleIsapproved(String posttitle, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByExcerptDatetime(String excerpt, java.util.Calendar datetime) {
        return findByExcerptDatetime(excerpt, datetime, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByExcerptDatetime(String excerpt, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByExcerptIsapproved(String excerpt, boolean isapproved) {
        return findByExcerptIsapproved(excerpt, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByExcerptIsapproved(String excerpt, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrackbackDAO> findByDatetimeIsapproved(java.util.Calendar datetime, boolean isapproved) {
        return findByDatetimeIsapproved(datetime, isapproved, 0, 50000);
    }

    public static ArrayList<TrackbackDAO> findByDatetimeIsapproved(java.util.Calendar datetime, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<TrackbackDAO> resultarraylist = new ArrayList<TrackbackDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrackbackDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}