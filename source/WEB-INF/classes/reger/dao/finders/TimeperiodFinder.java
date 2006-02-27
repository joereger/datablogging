package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.TimeperiodDAO;

/**
 * Finder for the 'timeperiod' DAO
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

public class TimeperiodFinder {


    public static ArrayList<TimeperiodDAO> findByTimeperiodid(int timeperiodid) {
        return findByTimeperiodid(timeperiodid, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodid(int timeperiodid, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdate(java.util.Calendar startdate) {
        return findByStartdate(startdate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdate(java.util.Calendar startdate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByEnddate(java.util.Calendar enddate) {
        return findByEnddate(enddate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByEnddate(java.util.Calendar enddate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByIsprivate(boolean isprivate) {
        return findByIsprivate(isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByIsprivate(boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTitle(String title) {
        return findByTitle(title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTitle(String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByIsopenended(boolean isopenended) {
        return findByIsopenended(isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByIsopenended(boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidAccountid(int timeperiodid, int accountid) {
        return findByTimeperiodidAccountid(timeperiodid, accountid, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidAccountid(int timeperiodid, int accountid, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidStartdate(int timeperiodid, java.util.Calendar startdate) {
        return findByTimeperiodidStartdate(timeperiodid, startdate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidStartdate(int timeperiodid, java.util.Calendar startdate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidEnddate(int timeperiodid, java.util.Calendar enddate) {
        return findByTimeperiodidEnddate(timeperiodid, enddate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidEnddate(int timeperiodid, java.util.Calendar enddate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidDescription(int timeperiodid, String description) {
        return findByTimeperiodidDescription(timeperiodid, description, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidDescription(int timeperiodid, String description, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidIsprivate(int timeperiodid, boolean isprivate) {
        return findByTimeperiodidIsprivate(timeperiodid, isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidIsprivate(int timeperiodid, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidTitle(int timeperiodid, String title) {
        return findByTimeperiodidTitle(timeperiodid, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidTitle(int timeperiodid, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidIsopenended(int timeperiodid, boolean isopenended) {
        return findByTimeperiodidIsopenended(timeperiodid, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTimeperiodidIsopenended(int timeperiodid, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidStartdate(int accountid, java.util.Calendar startdate) {
        return findByAccountidStartdate(accountid, startdate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidStartdate(int accountid, java.util.Calendar startdate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidEnddate(int accountid, java.util.Calendar enddate) {
        return findByAccountidEnddate(accountid, enddate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidEnddate(int accountid, java.util.Calendar enddate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidDescription(int accountid, String description) {
        return findByAccountidDescription(accountid, description, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidDescription(int accountid, String description, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidIsprivate(int accountid, boolean isprivate) {
        return findByAccountidIsprivate(accountid, isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidIsprivate(int accountid, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidTitle(int accountid, String title) {
        return findByAccountidTitle(accountid, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidTitle(int accountid, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByAccountidIsopenended(int accountid, boolean isopenended) {
        return findByAccountidIsopenended(accountid, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByAccountidIsopenended(int accountid, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE accountid='"+accountid+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdateEnddate(java.util.Calendar startdate, java.util.Calendar enddate) {
        return findByStartdateEnddate(startdate, enddate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdateEnddate(java.util.Calendar startdate, java.util.Calendar enddate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdateDescription(java.util.Calendar startdate, String description) {
        return findByStartdateDescription(startdate, description, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdateDescription(java.util.Calendar startdate, String description, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdateIsprivate(java.util.Calendar startdate, boolean isprivate) {
        return findByStartdateIsprivate(startdate, isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdateIsprivate(java.util.Calendar startdate, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdateTitle(java.util.Calendar startdate, String title) {
        return findByStartdateTitle(startdate, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdateTitle(java.util.Calendar startdate, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByStartdateIsopenended(java.util.Calendar startdate, boolean isopenended) {
        return findByStartdateIsopenended(startdate, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByStartdateIsopenended(java.util.Calendar startdate, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByEnddateDescription(java.util.Calendar enddate, String description) {
        return findByEnddateDescription(enddate, description, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByEnddateDescription(java.util.Calendar enddate, String description, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByEnddateIsprivate(java.util.Calendar enddate, boolean isprivate) {
        return findByEnddateIsprivate(enddate, isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByEnddateIsprivate(java.util.Calendar enddate, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByEnddateTitle(java.util.Calendar enddate, String title) {
        return findByEnddateTitle(enddate, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByEnddateTitle(java.util.Calendar enddate, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByEnddateIsopenended(java.util.Calendar enddate, boolean isopenended) {
        return findByEnddateIsopenended(enddate, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByEnddateIsopenended(java.util.Calendar enddate, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionIsprivate(String description, boolean isprivate) {
        return findByDescriptionIsprivate(description, isprivate, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionIsprivate(String description, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionTitle(String description, String title) {
        return findByDescriptionTitle(description, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionTitle(String description, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE description='"+reger.core.Util.cleanForSQL(description)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionIsopenended(String description, boolean isopenended) {
        return findByDescriptionIsopenended(description, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByDescriptionIsopenended(String description, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE description='"+reger.core.Util.cleanForSQL(description)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByIsprivateTitle(boolean isprivate, String title) {
        return findByIsprivateTitle(isprivate, title, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByIsprivateTitle(boolean isprivate, String title, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByIsprivateIsopenended(boolean isprivate, boolean isopenended) {
        return findByIsprivateIsopenended(isprivate, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByIsprivateIsopenended(boolean isprivate, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<TimeperiodDAO> findByTitleIsopenended(String title, boolean isopenended) {
        return findByTitleIsopenended(title, isopenended, 0, 50000);
    }

    public static ArrayList<TimeperiodDAO> findByTitleIsopenended(String title, boolean isopenended, int limitmin, int limitmax) {
        ArrayList<TimeperiodDAO> resultarraylist = new ArrayList<TimeperiodDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE title='"+reger.core.Util.cleanForSQL(title)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new TimeperiodDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}