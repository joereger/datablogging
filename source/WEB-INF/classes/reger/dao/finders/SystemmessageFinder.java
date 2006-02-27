package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SystemmessageDAO;

/**
 * Finder for the 'systemmessage' DAO
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

public class SystemmessageFinder {


    public static ArrayList<SystemmessageDAO> findBySystemmessageid(int systemmessageid) {
        return findBySystemmessageid(systemmessageid, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageid(int systemmessageid, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessage(String systemmessage) {
        return findBySystemmessage(systemmessage, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessage(String systemmessage, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByIslive(boolean islive) {
        return findByIslive(islive, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByIslive(boolean islive, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='"+reger.core.Util.booleanAsSQLText(islive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestart(boolean autooldonrestart) {
        return findByAutooldonrestart(autooldonrestart, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestart(boolean autooldonrestart, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusers(boolean showtologgedinusers) {
        return findByShowtologgedinusers(showtologgedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusers(boolean showtologgedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByShowtonotloggedinusers(boolean showtonotloggedinusers) {
        return findByShowtonotloggedinusers(showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByShowtonotloggedinusers(boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidSystemmessage(int systemmessageid, String systemmessage) {
        return findBySystemmessageidSystemmessage(systemmessageid, systemmessage, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidSystemmessage(int systemmessageid, String systemmessage, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidIslive(int systemmessageid, boolean islive) {
        return findBySystemmessageidIslive(systemmessageid, islive, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidIslive(int systemmessageid, boolean islive, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', islive='"+reger.core.Util.booleanAsSQLText(islive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidAutooldonrestart(int systemmessageid, boolean autooldonrestart) {
        return findBySystemmessageidAutooldonrestart(systemmessageid, autooldonrestart, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidAutooldonrestart(int systemmessageid, boolean autooldonrestart, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidShowtologgedinusers(int systemmessageid, boolean showtologgedinusers) {
        return findBySystemmessageidShowtologgedinusers(systemmessageid, showtologgedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidShowtologgedinusers(int systemmessageid, boolean showtologgedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidShowtonotloggedinusers(int systemmessageid, boolean showtonotloggedinusers) {
        return findBySystemmessageidShowtonotloggedinusers(systemmessageid, showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidShowtonotloggedinusers(int systemmessageid, boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidDate(int systemmessageid, java.util.Calendar date) {
        return findBySystemmessageidDate(systemmessageid, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageidDate(int systemmessageid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageIslive(String systemmessage, boolean islive) {
        return findBySystemmessageIslive(systemmessage, islive, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageIslive(String systemmessage, boolean islive, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', islive='"+reger.core.Util.booleanAsSQLText(islive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageAutooldonrestart(String systemmessage, boolean autooldonrestart) {
        return findBySystemmessageAutooldonrestart(systemmessage, autooldonrestart, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageAutooldonrestart(String systemmessage, boolean autooldonrestart, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageShowtologgedinusers(String systemmessage, boolean showtologgedinusers) {
        return findBySystemmessageShowtologgedinusers(systemmessage, showtologgedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageShowtologgedinusers(String systemmessage, boolean showtologgedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageShowtonotloggedinusers(String systemmessage, boolean showtonotloggedinusers) {
        return findBySystemmessageShowtonotloggedinusers(systemmessage, showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageShowtonotloggedinusers(String systemmessage, boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageDate(String systemmessage, java.util.Calendar date) {
        return findBySystemmessageDate(systemmessage, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findBySystemmessageDate(String systemmessage, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByIsliveAutooldonrestart(boolean islive, boolean autooldonrestart) {
        return findByIsliveAutooldonrestart(islive, autooldonrestart, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByIsliveAutooldonrestart(boolean islive, boolean autooldonrestart, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='"+reger.core.Util.booleanAsSQLText(islive)+"', autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByIsliveShowtologgedinusers(boolean islive, boolean showtologgedinusers) {
        return findByIsliveShowtologgedinusers(islive, showtologgedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByIsliveShowtologgedinusers(boolean islive, boolean showtologgedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='"+reger.core.Util.booleanAsSQLText(islive)+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByIsliveShowtonotloggedinusers(boolean islive, boolean showtonotloggedinusers) {
        return findByIsliveShowtonotloggedinusers(islive, showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByIsliveShowtonotloggedinusers(boolean islive, boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='"+reger.core.Util.booleanAsSQLText(islive)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByIsliveDate(boolean islive, java.util.Calendar date) {
        return findByIsliveDate(islive, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByIsliveDate(boolean islive, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='"+reger.core.Util.booleanAsSQLText(islive)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartShowtologgedinusers(boolean autooldonrestart, boolean showtologgedinusers) {
        return findByAutooldonrestartShowtologgedinusers(autooldonrestart, showtologgedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartShowtologgedinusers(boolean autooldonrestart, boolean showtologgedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartShowtonotloggedinusers(boolean autooldonrestart, boolean showtonotloggedinusers) {
        return findByAutooldonrestartShowtonotloggedinusers(autooldonrestart, showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartShowtonotloggedinusers(boolean autooldonrestart, boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartDate(boolean autooldonrestart, java.util.Calendar date) {
        return findByAutooldonrestartDate(autooldonrestart, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByAutooldonrestartDate(boolean autooldonrestart, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusersShowtonotloggedinusers(boolean showtologgedinusers, boolean showtonotloggedinusers) {
        return findByShowtologgedinusersShowtonotloggedinusers(showtologgedinusers, showtonotloggedinusers, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusersShowtonotloggedinusers(boolean showtologgedinusers, boolean showtonotloggedinusers, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusersDate(boolean showtologgedinusers, java.util.Calendar date) {
        return findByShowtologgedinusersDate(showtologgedinusers, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByShowtologgedinusersDate(boolean showtologgedinusers, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemmessageDAO> findByShowtonotloggedinusersDate(boolean showtonotloggedinusers, java.util.Calendar date) {
        return findByShowtonotloggedinusersDate(showtonotloggedinusers, date, 0, 50000);
    }

    public static ArrayList<SystemmessageDAO> findByShowtonotloggedinusersDate(boolean showtonotloggedinusers, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<SystemmessageDAO> resultarraylist = new ArrayList<SystemmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}