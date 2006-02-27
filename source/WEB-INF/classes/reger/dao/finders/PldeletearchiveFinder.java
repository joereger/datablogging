package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PldeletearchiveDAO;

/**
 * Finder for the 'pldeletearchive' DAO
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

public class PldeletearchiveFinder {


    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveid(int pldeletearchiveid) {
        return findByPldeletearchiveid(pldeletearchiveid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveid(int pldeletearchiveid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByOldplid(int oldplid) {
        return findByOldplid(oldplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByOldplid(int oldplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE oldplid='"+oldplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByNewplid(int newplid) {
        return findByNewplid(newplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByNewplid(int newplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE newplid='"+newplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidAccountid(int pldeletearchiveid, int accountid) {
        return findByPldeletearchiveidAccountid(pldeletearchiveid, accountid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidAccountid(int pldeletearchiveid, int accountid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidDate(int pldeletearchiveid, java.util.Calendar date) {
        return findByPldeletearchiveidDate(pldeletearchiveid, date, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidDate(int pldeletearchiveid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidOldplid(int pldeletearchiveid, int oldplid) {
        return findByPldeletearchiveidOldplid(pldeletearchiveid, oldplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidOldplid(int pldeletearchiveid, int oldplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"', oldplid='"+oldplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidNewplid(int pldeletearchiveid, int newplid) {
        return findByPldeletearchiveidNewplid(pldeletearchiveid, newplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByPldeletearchiveidNewplid(int pldeletearchiveid, int newplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"', newplid='"+newplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidDate(int accountid, java.util.Calendar date) {
        return findByAccountidDate(accountid, date, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidDate(int accountid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE accountid='"+accountid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidOldplid(int accountid, int oldplid) {
        return findByAccountidOldplid(accountid, oldplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidOldplid(int accountid, int oldplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE accountid='"+accountid+"', oldplid='"+oldplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidNewplid(int accountid, int newplid) {
        return findByAccountidNewplid(accountid, newplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByAccountidNewplid(int accountid, int newplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE accountid='"+accountid+"', newplid='"+newplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByDateOldplid(java.util.Calendar date, int oldplid) {
        return findByDateOldplid(date, oldplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByDateOldplid(java.util.Calendar date, int oldplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', oldplid='"+oldplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByDateNewplid(java.util.Calendar date, int newplid) {
        return findByDateNewplid(date, newplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByDateNewplid(java.util.Calendar date, int newplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', newplid='"+newplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PldeletearchiveDAO> findByOldplidNewplid(int oldplid, int newplid) {
        return findByOldplidNewplid(oldplid, newplid, 0, 50000);
    }

    public static ArrayList<PldeletearchiveDAO> findByOldplidNewplid(int oldplid, int newplid, int limitmin, int limitmax) {
        ArrayList<PldeletearchiveDAO> resultarraylist = new ArrayList<PldeletearchiveDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE oldplid='"+oldplid+"', newplid='"+newplid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PldeletearchiveDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}