package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TrafficDAO;

/**
 * Finder for the 'traffic' DAO
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

public class TrafficFinder {


    public static ArrayList<TrafficDAO> findByTrafficid(int trafficid) {
        return findByTrafficid(trafficid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficid(int trafficid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCount(int count) {
        return findByCount(count, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCount(int count, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeid(int traffictypeid) {
        return findByTraffictypeid(traffictypeid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeid(int traffictypeid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetime(java.util.Calendar datetime) {
        return findByDatetime(datetime, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetime(java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByImageid(int imageid) {
        return findByImageid(imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByImageid(int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByReferrer(String referrer) {
        return findByReferrer(referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByReferrer(String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByBrowser(String browser) {
        return findByBrowser(browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByBrowser(String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByRemotehost(String remotehost) {
        return findByRemotehost(remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByRemotehost(String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByIscollapsed(boolean iscollapsed) {
        return findByIscollapsed(iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByIscollapsed(boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidCount(int trafficid, int count) {
        return findByTrafficidCount(trafficid, count, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidCount(int trafficid, int count, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidTraffictypeid(int trafficid, int traffictypeid) {
        return findByTrafficidTraffictypeid(trafficid, traffictypeid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidTraffictypeid(int trafficid, int traffictypeid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', traffictypeid='"+traffictypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidDatetime(int trafficid, java.util.Calendar datetime) {
        return findByTrafficidDatetime(trafficid, datetime, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidDatetime(int trafficid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidUrl(int trafficid, String url) {
        return findByTrafficidUrl(trafficid, url, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidUrl(int trafficid, String url, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidPlid(int trafficid, int plid) {
        return findByTrafficidPlid(trafficid, plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidPlid(int trafficid, int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidAccountid(int trafficid, int accountid) {
        return findByTrafficidAccountid(trafficid, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidAccountid(int trafficid, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidLogid(int trafficid, int logid) {
        return findByTrafficidLogid(trafficid, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidLogid(int trafficid, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidEventid(int trafficid, int eventid) {
        return findByTrafficidEventid(trafficid, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidEventid(int trafficid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidImageid(int trafficid, int imageid) {
        return findByTrafficidImageid(trafficid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidImageid(int trafficid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidReferrer(int trafficid, String referrer) {
        return findByTrafficidReferrer(trafficid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidReferrer(int trafficid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidBrowser(int trafficid, String browser) {
        return findByTrafficidBrowser(trafficid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidBrowser(int trafficid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidRemotehost(int trafficid, String remotehost) {
        return findByTrafficidRemotehost(trafficid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidRemotehost(int trafficid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTrafficidIscollapsed(int trafficid, boolean iscollapsed) {
        return findByTrafficidIscollapsed(trafficid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTrafficidIscollapsed(int trafficid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountTraffictypeid(int count, int traffictypeid) {
        return findByCountTraffictypeid(count, traffictypeid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountTraffictypeid(int count, int traffictypeid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', traffictypeid='"+traffictypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountDatetime(int count, java.util.Calendar datetime) {
        return findByCountDatetime(count, datetime, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountDatetime(int count, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountUrl(int count, String url) {
        return findByCountUrl(count, url, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountUrl(int count, String url, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountPlid(int count, int plid) {
        return findByCountPlid(count, plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountPlid(int count, int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountAccountid(int count, int accountid) {
        return findByCountAccountid(count, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountAccountid(int count, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountLogid(int count, int logid) {
        return findByCountLogid(count, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountLogid(int count, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountEventid(int count, int eventid) {
        return findByCountEventid(count, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountEventid(int count, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountImageid(int count, int imageid) {
        return findByCountImageid(count, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountImageid(int count, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountReferrer(int count, String referrer) {
        return findByCountReferrer(count, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountReferrer(int count, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountBrowser(int count, String browser) {
        return findByCountBrowser(count, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountBrowser(int count, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountRemotehost(int count, String remotehost) {
        return findByCountRemotehost(count, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountRemotehost(int count, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByCountIscollapsed(int count, boolean iscollapsed) {
        return findByCountIscollapsed(count, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByCountIscollapsed(int count, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE count='"+count+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidDatetime(int traffictypeid, java.util.Calendar datetime) {
        return findByTraffictypeidDatetime(traffictypeid, datetime, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidDatetime(int traffictypeid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidUrl(int traffictypeid, String url) {
        return findByTraffictypeidUrl(traffictypeid, url, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidUrl(int traffictypeid, String url, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidPlid(int traffictypeid, int plid) {
        return findByTraffictypeidPlid(traffictypeid, plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidPlid(int traffictypeid, int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidAccountid(int traffictypeid, int accountid) {
        return findByTraffictypeidAccountid(traffictypeid, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidAccountid(int traffictypeid, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidLogid(int traffictypeid, int logid) {
        return findByTraffictypeidLogid(traffictypeid, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidLogid(int traffictypeid, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidEventid(int traffictypeid, int eventid) {
        return findByTraffictypeidEventid(traffictypeid, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidEventid(int traffictypeid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidImageid(int traffictypeid, int imageid) {
        return findByTraffictypeidImageid(traffictypeid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidImageid(int traffictypeid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidReferrer(int traffictypeid, String referrer) {
        return findByTraffictypeidReferrer(traffictypeid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidReferrer(int traffictypeid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidBrowser(int traffictypeid, String browser) {
        return findByTraffictypeidBrowser(traffictypeid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidBrowser(int traffictypeid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidRemotehost(int traffictypeid, String remotehost) {
        return findByTraffictypeidRemotehost(traffictypeid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidRemotehost(int traffictypeid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidIscollapsed(int traffictypeid, boolean iscollapsed) {
        return findByTraffictypeidIscollapsed(traffictypeid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByTraffictypeidIscollapsed(int traffictypeid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE traffictypeid='"+traffictypeid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeUrl(java.util.Calendar datetime, String url) {
        return findByDatetimeUrl(datetime, url, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeUrl(java.util.Calendar datetime, String url, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimePlid(java.util.Calendar datetime, int plid) {
        return findByDatetimePlid(datetime, plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimePlid(java.util.Calendar datetime, int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeAccountid(java.util.Calendar datetime, int accountid) {
        return findByDatetimeAccountid(datetime, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeAccountid(java.util.Calendar datetime, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeLogid(java.util.Calendar datetime, int logid) {
        return findByDatetimeLogid(datetime, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeLogid(java.util.Calendar datetime, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeEventid(java.util.Calendar datetime, int eventid) {
        return findByDatetimeEventid(datetime, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeEventid(java.util.Calendar datetime, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeImageid(java.util.Calendar datetime, int imageid) {
        return findByDatetimeImageid(datetime, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeImageid(java.util.Calendar datetime, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeReferrer(java.util.Calendar datetime, String referrer) {
        return findByDatetimeReferrer(datetime, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeReferrer(java.util.Calendar datetime, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeBrowser(java.util.Calendar datetime, String browser) {
        return findByDatetimeBrowser(datetime, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeBrowser(java.util.Calendar datetime, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeRemotehost(java.util.Calendar datetime, String remotehost) {
        return findByDatetimeRemotehost(datetime, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeRemotehost(java.util.Calendar datetime, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByDatetimeIscollapsed(java.util.Calendar datetime, boolean iscollapsed) {
        return findByDatetimeIscollapsed(datetime, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByDatetimeIscollapsed(java.util.Calendar datetime, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlPlid(String url, int plid) {
        return findByUrlPlid(url, plid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlPlid(String url, int plid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlAccountid(String url, int accountid) {
        return findByUrlAccountid(url, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlAccountid(String url, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlLogid(String url, int logid) {
        return findByUrlLogid(url, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlLogid(String url, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlEventid(String url, int eventid) {
        return findByUrlEventid(url, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlEventid(String url, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlImageid(String url, int imageid) {
        return findByUrlImageid(url, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlImageid(String url, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlReferrer(String url, String referrer) {
        return findByUrlReferrer(url, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlReferrer(String url, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlBrowser(String url, String browser) {
        return findByUrlBrowser(url, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlBrowser(String url, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlRemotehost(String url, String remotehost) {
        return findByUrlRemotehost(url, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlRemotehost(String url, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByUrlIscollapsed(String url, boolean iscollapsed) {
        return findByUrlIscollapsed(url, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByUrlIscollapsed(String url, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE url='"+reger.core.Util.cleanForSQL(url)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidAccountid(int plid, int accountid) {
        return findByPlidAccountid(plid, accountid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidAccountid(int plid, int accountid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidLogid(int plid, int logid) {
        return findByPlidLogid(plid, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidLogid(int plid, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidEventid(int plid, int eventid) {
        return findByPlidEventid(plid, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidEventid(int plid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidImageid(int plid, int imageid) {
        return findByPlidImageid(plid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidImageid(int plid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidReferrer(int plid, String referrer) {
        return findByPlidReferrer(plid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidReferrer(int plid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidBrowser(int plid, String browser) {
        return findByPlidBrowser(plid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidBrowser(int plid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidRemotehost(int plid, String remotehost) {
        return findByPlidRemotehost(plid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidRemotehost(int plid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByPlidIscollapsed(int plid, boolean iscollapsed) {
        return findByPlidIscollapsed(plid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByPlidIscollapsed(int plid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE plid='"+plid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidLogid(int accountid, int logid) {
        return findByAccountidLogid(accountid, logid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidLogid(int accountid, int logid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidEventid(int accountid, int eventid) {
        return findByAccountidEventid(accountid, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidEventid(int accountid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidImageid(int accountid, int imageid) {
        return findByAccountidImageid(accountid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidImageid(int accountid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidReferrer(int accountid, String referrer) {
        return findByAccountidReferrer(accountid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidReferrer(int accountid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidBrowser(int accountid, String browser) {
        return findByAccountidBrowser(accountid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidBrowser(int accountid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidRemotehost(int accountid, String remotehost) {
        return findByAccountidRemotehost(accountid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidRemotehost(int accountid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByAccountidIscollapsed(int accountid, boolean iscollapsed) {
        return findByAccountidIscollapsed(accountid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByAccountidIscollapsed(int accountid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE accountid='"+accountid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidEventid(int logid, int eventid) {
        return findByLogidEventid(logid, eventid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidEventid(int logid, int eventid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidImageid(int logid, int imageid) {
        return findByLogidImageid(logid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidImageid(int logid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidReferrer(int logid, String referrer) {
        return findByLogidReferrer(logid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidReferrer(int logid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidBrowser(int logid, String browser) {
        return findByLogidBrowser(logid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidBrowser(int logid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidRemotehost(int logid, String remotehost) {
        return findByLogidRemotehost(logid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidRemotehost(int logid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByLogidIscollapsed(int logid, boolean iscollapsed) {
        return findByLogidIscollapsed(logid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByLogidIscollapsed(int logid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE logid='"+logid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventidImageid(int eventid, int imageid) {
        return findByEventidImageid(eventid, imageid, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventidImageid(int eventid, int imageid, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"', imageid='"+imageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventidReferrer(int eventid, String referrer) {
        return findByEventidReferrer(eventid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventidReferrer(int eventid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventidBrowser(int eventid, String browser) {
        return findByEventidBrowser(eventid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventidBrowser(int eventid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventidRemotehost(int eventid, String remotehost) {
        return findByEventidRemotehost(eventid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventidRemotehost(int eventid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByEventidIscollapsed(int eventid, boolean iscollapsed) {
        return findByEventidIscollapsed(eventid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByEventidIscollapsed(int eventid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE eventid='"+eventid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByImageidReferrer(int imageid, String referrer) {
        return findByImageidReferrer(imageid, referrer, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByImageidReferrer(int imageid, String referrer, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE imageid='"+imageid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByImageidBrowser(int imageid, String browser) {
        return findByImageidBrowser(imageid, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByImageidBrowser(int imageid, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE imageid='"+imageid+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByImageidRemotehost(int imageid, String remotehost) {
        return findByImageidRemotehost(imageid, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByImageidRemotehost(int imageid, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE imageid='"+imageid+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByImageidIscollapsed(int imageid, boolean iscollapsed) {
        return findByImageidIscollapsed(imageid, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByImageidIscollapsed(int imageid, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE imageid='"+imageid+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByReferrerBrowser(String referrer, String browser) {
        return findByReferrerBrowser(referrer, browser, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByReferrerBrowser(String referrer, String browser, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE referrer='"+reger.core.Util.cleanForSQL(referrer)+"', browser='"+reger.core.Util.cleanForSQL(browser)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByReferrerRemotehost(String referrer, String remotehost) {
        return findByReferrerRemotehost(referrer, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByReferrerRemotehost(String referrer, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE referrer='"+reger.core.Util.cleanForSQL(referrer)+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByReferrerIscollapsed(String referrer, boolean iscollapsed) {
        return findByReferrerIscollapsed(referrer, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByReferrerIscollapsed(String referrer, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE referrer='"+reger.core.Util.cleanForSQL(referrer)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByBrowserRemotehost(String browser, String remotehost) {
        return findByBrowserRemotehost(browser, remotehost, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByBrowserRemotehost(String browser, String remotehost, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE browser='"+reger.core.Util.cleanForSQL(browser)+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByBrowserIscollapsed(String browser, boolean iscollapsed) {
        return findByBrowserIscollapsed(browser, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByBrowserIscollapsed(String browser, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE browser='"+reger.core.Util.cleanForSQL(browser)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TrafficDAO> findByRemotehostIscollapsed(String remotehost, boolean iscollapsed) {
        return findByRemotehostIscollapsed(remotehost, iscollapsed, 0, 50000);
    }

    public static ArrayList<TrafficDAO> findByRemotehostIscollapsed(String remotehost, boolean iscollapsed, int limitmin, int limitmax) {
        ArrayList<TrafficDAO> resultarraylist = new ArrayList<TrafficDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TrafficDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}