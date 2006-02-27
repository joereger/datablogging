package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.ErrorDAO;

/**
 * Finder for the 'error' DAO
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

public class ErrorFinder {


    public static ArrayList<ErrorDAO> findByErrorid(int errorid) {
        return findByErrorid(errorid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErrorid(int errorid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByStatus(String status) {
        return findByStatus(status, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByStatus(String status, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE status='"+reger.core.Util.cleanForSQL(status)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByCount(int count) {
        return findByCount(count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByCount(int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByLabel(String label) {
        return findByLabel(label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByLabel(String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridDate(int errorid, java.util.Calendar date) {
        return findByErroridDate(errorid, date, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridDate(int errorid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridUrl(int errorid, String url) {
        return findByErroridUrl(errorid, url, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridUrl(int errorid, String url, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridDescription(int errorid, String description) {
        return findByErroridDescription(errorid, description, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridDescription(int errorid, String description, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridStatus(int errorid, String status) {
        return findByErroridStatus(errorid, status, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridStatus(int errorid, String status, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', status='"+reger.core.Util.cleanForSQL(status)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridAccountid(int errorid, int accountid) {
        return findByErroridAccountid(errorid, accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridAccountid(int errorid, int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridCount(int errorid, int count) {
        return findByErroridCount(errorid, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridCount(int errorid, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByErroridLabel(int errorid, String label) {
        return findByErroridLabel(errorid, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByErroridLabel(int errorid, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateUrl(java.util.Calendar date, String url) {
        return findByDateUrl(date, url, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateUrl(java.util.Calendar date, String url, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateDescription(java.util.Calendar date, String description) {
        return findByDateDescription(date, description, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateDescription(java.util.Calendar date, String description, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateStatus(java.util.Calendar date, String status) {
        return findByDateStatus(date, status, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateStatus(java.util.Calendar date, String status, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', status='"+reger.core.Util.cleanForSQL(status)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateAccountid(java.util.Calendar date, int accountid) {
        return findByDateAccountid(date, accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateAccountid(java.util.Calendar date, int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateCount(java.util.Calendar date, int count) {
        return findByDateCount(date, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateCount(java.util.Calendar date, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDateLabel(java.util.Calendar date, String label) {
        return findByDateLabel(date, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDateLabel(java.util.Calendar date, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrlDescription(String url, String description) {
        return findByUrlDescription(url, description, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrlDescription(String url, String description, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrlStatus(String url, String status) {
        return findByUrlStatus(url, status, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrlStatus(String url, String status, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"', status='"+reger.core.Util.cleanForSQL(status)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrlAccountid(String url, int accountid) {
        return findByUrlAccountid(url, accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrlAccountid(String url, int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrlCount(String url, int count) {
        return findByUrlCount(url, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrlCount(String url, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByUrlLabel(String url, String label) {
        return findByUrlLabel(url, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByUrlLabel(String url, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE url='"+reger.core.Util.cleanForSQL(url)+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDescriptionStatus(String description, String status) {
        return findByDescriptionStatus(description, status, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDescriptionStatus(String description, String status, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE description='"+reger.core.Util.cleanForSQL(description)+"', status='"+reger.core.Util.cleanForSQL(status)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDescriptionAccountid(String description, int accountid) {
        return findByDescriptionAccountid(description, accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDescriptionAccountid(String description, int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE description='"+reger.core.Util.cleanForSQL(description)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDescriptionCount(String description, int count) {
        return findByDescriptionCount(description, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDescriptionCount(String description, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE description='"+reger.core.Util.cleanForSQL(description)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByDescriptionLabel(String description, String label) {
        return findByDescriptionLabel(description, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByDescriptionLabel(String description, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE description='"+reger.core.Util.cleanForSQL(description)+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByStatusAccountid(String status, int accountid) {
        return findByStatusAccountid(status, accountid, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByStatusAccountid(String status, int accountid, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE status='"+reger.core.Util.cleanForSQL(status)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByStatusCount(String status, int count) {
        return findByStatusCount(status, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByStatusCount(String status, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE status='"+reger.core.Util.cleanForSQL(status)+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByStatusLabel(String status, String label) {
        return findByStatusLabel(status, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByStatusLabel(String status, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE status='"+reger.core.Util.cleanForSQL(status)+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByAccountidCount(int accountid, int count) {
        return findByAccountidCount(accountid, count, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByAccountidCount(int accountid, int count, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE accountid='"+accountid+"', count='"+count+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByAccountidLabel(int accountid, String label) {
        return findByAccountidLabel(accountid, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByAccountidLabel(int accountid, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE accountid='"+accountid+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ErrorDAO> findByCountLabel(int count, String label) {
        return findByCountLabel(count, label, 0, 50000);
    }

    public static ArrayList<ErrorDAO> findByCountLabel(int count, String label, int limitmin, int limitmax) {
        ArrayList<ErrorDAO> resultarraylist = new ArrayList<ErrorDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE count='"+count+"', label='"+reger.core.Util.cleanForSQL(label)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ErrorDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}