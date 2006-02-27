package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SchedulerDAO;

/**
 * Finder for the 'scheduler' DAO
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

public class SchedulerFinder {


    public static ArrayList<SchedulerDAO> findBySchedulerid(int schedulerid) {
        return findBySchedulerid(schedulerid, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findBySchedulerid(int schedulerid, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadid(int masterthreadid) {
        return findByMasterthreadid(masterthreadid, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadid(int masterthreadid, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE masterthreadid='"+masterthreadid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTask(String task) {
        return findByTask(task, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTask(String task, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE task='"+reger.core.Util.cleanForSQL(task)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByLastrun(java.util.Calendar lastrun) {
        return findByLastrun(lastrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByLastrun(java.util.Calendar lastrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTimesrun(int timesrun) {
        return findByTimesrun(timesrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTimesrun(int timesrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE timesrun='"+timesrun+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByComment(String comment) {
        return findByComment(comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByComment(String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByScheduleridMasterthreadid(int schedulerid, int masterthreadid) {
        return findByScheduleridMasterthreadid(schedulerid, masterthreadid, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByScheduleridMasterthreadid(int schedulerid, int masterthreadid, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"', masterthreadid='"+masterthreadid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByScheduleridTask(int schedulerid, String task) {
        return findByScheduleridTask(schedulerid, task, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByScheduleridTask(int schedulerid, String task, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"', task='"+reger.core.Util.cleanForSQL(task)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByScheduleridLastrun(int schedulerid, java.util.Calendar lastrun) {
        return findByScheduleridLastrun(schedulerid, lastrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByScheduleridLastrun(int schedulerid, java.util.Calendar lastrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"', lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByScheduleridTimesrun(int schedulerid, int timesrun) {
        return findByScheduleridTimesrun(schedulerid, timesrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByScheduleridTimesrun(int schedulerid, int timesrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"', timesrun='"+timesrun+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByScheduleridComment(int schedulerid, String comment) {
        return findByScheduleridComment(schedulerid, comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByScheduleridComment(int schedulerid, String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidTask(int masterthreadid, String task) {
        return findByMasterthreadidTask(masterthreadid, task, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidTask(int masterthreadid, String task, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE masterthreadid='"+masterthreadid+"', task='"+reger.core.Util.cleanForSQL(task)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidLastrun(int masterthreadid, java.util.Calendar lastrun) {
        return findByMasterthreadidLastrun(masterthreadid, lastrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidLastrun(int masterthreadid, java.util.Calendar lastrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE masterthreadid='"+masterthreadid+"', lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidTimesrun(int masterthreadid, int timesrun) {
        return findByMasterthreadidTimesrun(masterthreadid, timesrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidTimesrun(int masterthreadid, int timesrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE masterthreadid='"+masterthreadid+"', timesrun='"+timesrun+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidComment(int masterthreadid, String comment) {
        return findByMasterthreadidComment(masterthreadid, comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByMasterthreadidComment(int masterthreadid, String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE masterthreadid='"+masterthreadid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTaskLastrun(String task, java.util.Calendar lastrun) {
        return findByTaskLastrun(task, lastrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTaskLastrun(String task, java.util.Calendar lastrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE task='"+reger.core.Util.cleanForSQL(task)+"', lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTaskTimesrun(String task, int timesrun) {
        return findByTaskTimesrun(task, timesrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTaskTimesrun(String task, int timesrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE task='"+reger.core.Util.cleanForSQL(task)+"', timesrun='"+timesrun+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTaskComment(String task, String comment) {
        return findByTaskComment(task, comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTaskComment(String task, String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE task='"+reger.core.Util.cleanForSQL(task)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByLastrunTimesrun(java.util.Calendar lastrun, int timesrun) {
        return findByLastrunTimesrun(lastrun, timesrun, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByLastrunTimesrun(java.util.Calendar lastrun, int timesrun, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"', timesrun='"+timesrun+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByLastrunComment(java.util.Calendar lastrun, String comment) {
        return findByLastrunComment(lastrun, comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByLastrunComment(java.util.Calendar lastrun, String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SchedulerDAO> findByTimesrunComment(int timesrun, String comment) {
        return findByTimesrunComment(timesrun, comment, 0, 50000);
    }

    public static ArrayList<SchedulerDAO> findByTimesrunComment(int timesrun, String comment, int limitmin, int limitmax) {
        ArrayList<SchedulerDAO> resultarraylist = new ArrayList<SchedulerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE timesrun='"+timesrun+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SchedulerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}