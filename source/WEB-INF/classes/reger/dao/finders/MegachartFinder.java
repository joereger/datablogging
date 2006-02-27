package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegachartDAO;

/**
 * Finder for the 'megachart' DAO
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

public class MegachartFinder {


    public static ArrayList<MegachartDAO> findByMegachartid(int megachartid) {
        return findByMegachartid(megachartid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartid(int megachartid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartname(String chartname) {
        return findByChartname(chartname, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartname(String chartname, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeid(int xeventtypeid) {
        return findByXeventtypeid(xeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeid(int xeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogid(int xlogid) {
        return findByXlogid(xlogid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogid(int xlogid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldid(int xmegafieldid) {
        return findByXmegafieldid(xmegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldid(int xmegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodo(int yaxiswhattodo) {
        return findByYaxiswhattodo(yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodo(int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsize(int chartsize) {
        return findByChartsize(chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsize(int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttype(int charttype) {
        return findByCharttype(charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttype(int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterange(int daterange) {
        return findByDaterange(daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterange(int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdays(int lastxdays) {
        return findByLastxdays(lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdays(int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeks(int lastxweeks) {
        return findByLastxweeks(lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeks(int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonths(int lastxmonths) {
        return findByLastxmonths(lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonths(int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyears(int lastxyears) {
        return findByLastxyears(lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyears(int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyy(int daterangefromyyyy) {
        return findByDaterangefromyyyy(daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyy(int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommm(int daterangefrommm) {
        return findByDaterangefrommm(daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommm(int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromdd(int daterangefromdd) {
        return findByDaterangefromdd(daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromdd(int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyy(int daterangetoyyyy) {
        return findByDaterangetoyyyy(daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyy(int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetomm(int daterangetomm) {
        return findByDaterangetomm(daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetomm(int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetodd(int daterangetodd) {
        return findByDaterangetodd(daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetodd(int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangesavedsearchid(int daterangesavedsearchid) {
        return findByDaterangesavedsearchid(daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangesavedsearchid(int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidChartname(int megachartid, String chartname) {
        return findByMegachartidChartname(megachartid, chartname, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidChartname(int megachartid, String chartname, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', chartname='"+reger.core.Util.cleanForSQL(chartname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidXeventtypeid(int megachartid, int xeventtypeid) {
        return findByMegachartidXeventtypeid(megachartid, xeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidXeventtypeid(int megachartid, int xeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', xeventtypeid='"+xeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidXlogid(int megachartid, int xlogid) {
        return findByMegachartidXlogid(megachartid, xlogid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidXlogid(int megachartid, int xlogid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', xlogid='"+xlogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidXmegafieldid(int megachartid, int xmegafieldid) {
        return findByMegachartidXmegafieldid(megachartid, xmegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidXmegafieldid(int megachartid, int xmegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', xmegafieldid='"+xmegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidYaxiswhattodo(int megachartid, int yaxiswhattodo) {
        return findByMegachartidYaxiswhattodo(megachartid, yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidYaxiswhattodo(int megachartid, int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidChartsize(int megachartid, int chartsize) {
        return findByMegachartidChartsize(megachartid, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidChartsize(int megachartid, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidCharttype(int megachartid, int charttype) {
        return findByMegachartidCharttype(megachartid, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidCharttype(int megachartid, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterange(int megachartid, int daterange) {
        return findByMegachartidDaterange(megachartid, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterange(int megachartid, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxdays(int megachartid, int lastxdays) {
        return findByMegachartidLastxdays(megachartid, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxdays(int megachartid, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxweeks(int megachartid, int lastxweeks) {
        return findByMegachartidLastxweeks(megachartid, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxweeks(int megachartid, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxmonths(int megachartid, int lastxmonths) {
        return findByMegachartidLastxmonths(megachartid, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxmonths(int megachartid, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxyears(int megachartid, int lastxyears) {
        return findByMegachartidLastxyears(megachartid, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidLastxyears(int megachartid, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefromyyyy(int megachartid, int daterangefromyyyy) {
        return findByMegachartidDaterangefromyyyy(megachartid, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefromyyyy(int megachartid, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefrommm(int megachartid, int daterangefrommm) {
        return findByMegachartidDaterangefrommm(megachartid, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefrommm(int megachartid, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefromdd(int megachartid, int daterangefromdd) {
        return findByMegachartidDaterangefromdd(megachartid, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangefromdd(int megachartid, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetoyyyy(int megachartid, int daterangetoyyyy) {
        return findByMegachartidDaterangetoyyyy(megachartid, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetoyyyy(int megachartid, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetomm(int megachartid, int daterangetomm) {
        return findByMegachartidDaterangetomm(megachartid, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetomm(int megachartid, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetodd(int megachartid, int daterangetodd) {
        return findByMegachartidDaterangetodd(megachartid, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangetodd(int megachartid, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangesavedsearchid(int megachartid, int daterangesavedsearchid) {
        return findByMegachartidDaterangesavedsearchid(megachartid, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidDaterangesavedsearchid(int megachartid, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByMegachartidAccountid(int megachartid, int accountid) {
        return findByMegachartidAccountid(megachartid, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByMegachartidAccountid(int megachartid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameXeventtypeid(String chartname, int xeventtypeid) {
        return findByChartnameXeventtypeid(chartname, xeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameXeventtypeid(String chartname, int xeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', xeventtypeid='"+xeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameXlogid(String chartname, int xlogid) {
        return findByChartnameXlogid(chartname, xlogid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameXlogid(String chartname, int xlogid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', xlogid='"+xlogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameXmegafieldid(String chartname, int xmegafieldid) {
        return findByChartnameXmegafieldid(chartname, xmegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameXmegafieldid(String chartname, int xmegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', xmegafieldid='"+xmegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameYaxiswhattodo(String chartname, int yaxiswhattodo) {
        return findByChartnameYaxiswhattodo(chartname, yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameYaxiswhattodo(String chartname, int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameChartsize(String chartname, int chartsize) {
        return findByChartnameChartsize(chartname, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameChartsize(String chartname, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameCharttype(String chartname, int charttype) {
        return findByChartnameCharttype(chartname, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameCharttype(String chartname, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterange(String chartname, int daterange) {
        return findByChartnameDaterange(chartname, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterange(String chartname, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxdays(String chartname, int lastxdays) {
        return findByChartnameLastxdays(chartname, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxdays(String chartname, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxweeks(String chartname, int lastxweeks) {
        return findByChartnameLastxweeks(chartname, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxweeks(String chartname, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxmonths(String chartname, int lastxmonths) {
        return findByChartnameLastxmonths(chartname, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxmonths(String chartname, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxyears(String chartname, int lastxyears) {
        return findByChartnameLastxyears(chartname, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameLastxyears(String chartname, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefromyyyy(String chartname, int daterangefromyyyy) {
        return findByChartnameDaterangefromyyyy(chartname, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefromyyyy(String chartname, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefrommm(String chartname, int daterangefrommm) {
        return findByChartnameDaterangefrommm(chartname, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefrommm(String chartname, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefromdd(String chartname, int daterangefromdd) {
        return findByChartnameDaterangefromdd(chartname, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangefromdd(String chartname, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetoyyyy(String chartname, int daterangetoyyyy) {
        return findByChartnameDaterangetoyyyy(chartname, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetoyyyy(String chartname, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetomm(String chartname, int daterangetomm) {
        return findByChartnameDaterangetomm(chartname, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetomm(String chartname, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetodd(String chartname, int daterangetodd) {
        return findByChartnameDaterangetodd(chartname, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangetodd(String chartname, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangesavedsearchid(String chartname, int daterangesavedsearchid) {
        return findByChartnameDaterangesavedsearchid(chartname, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameDaterangesavedsearchid(String chartname, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartnameAccountid(String chartname, int accountid) {
        return findByChartnameAccountid(chartname, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartnameAccountid(String chartname, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartname='"+reger.core.Util.cleanForSQL(chartname)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidXlogid(int xeventtypeid, int xlogid) {
        return findByXeventtypeidXlogid(xeventtypeid, xlogid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidXlogid(int xeventtypeid, int xlogid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', xlogid='"+xlogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidXmegafieldid(int xeventtypeid, int xmegafieldid) {
        return findByXeventtypeidXmegafieldid(xeventtypeid, xmegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidXmegafieldid(int xeventtypeid, int xmegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', xmegafieldid='"+xmegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidYaxiswhattodo(int xeventtypeid, int yaxiswhattodo) {
        return findByXeventtypeidYaxiswhattodo(xeventtypeid, yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidYaxiswhattodo(int xeventtypeid, int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidChartsize(int xeventtypeid, int chartsize) {
        return findByXeventtypeidChartsize(xeventtypeid, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidChartsize(int xeventtypeid, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidCharttype(int xeventtypeid, int charttype) {
        return findByXeventtypeidCharttype(xeventtypeid, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidCharttype(int xeventtypeid, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterange(int xeventtypeid, int daterange) {
        return findByXeventtypeidDaterange(xeventtypeid, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterange(int xeventtypeid, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxdays(int xeventtypeid, int lastxdays) {
        return findByXeventtypeidLastxdays(xeventtypeid, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxdays(int xeventtypeid, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxweeks(int xeventtypeid, int lastxweeks) {
        return findByXeventtypeidLastxweeks(xeventtypeid, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxweeks(int xeventtypeid, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxmonths(int xeventtypeid, int lastxmonths) {
        return findByXeventtypeidLastxmonths(xeventtypeid, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxmonths(int xeventtypeid, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxyears(int xeventtypeid, int lastxyears) {
        return findByXeventtypeidLastxyears(xeventtypeid, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidLastxyears(int xeventtypeid, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefromyyyy(int xeventtypeid, int daterangefromyyyy) {
        return findByXeventtypeidDaterangefromyyyy(xeventtypeid, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefromyyyy(int xeventtypeid, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefrommm(int xeventtypeid, int daterangefrommm) {
        return findByXeventtypeidDaterangefrommm(xeventtypeid, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefrommm(int xeventtypeid, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefromdd(int xeventtypeid, int daterangefromdd) {
        return findByXeventtypeidDaterangefromdd(xeventtypeid, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangefromdd(int xeventtypeid, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetoyyyy(int xeventtypeid, int daterangetoyyyy) {
        return findByXeventtypeidDaterangetoyyyy(xeventtypeid, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetoyyyy(int xeventtypeid, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetomm(int xeventtypeid, int daterangetomm) {
        return findByXeventtypeidDaterangetomm(xeventtypeid, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetomm(int xeventtypeid, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetodd(int xeventtypeid, int daterangetodd) {
        return findByXeventtypeidDaterangetodd(xeventtypeid, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangetodd(int xeventtypeid, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangesavedsearchid(int xeventtypeid, int daterangesavedsearchid) {
        return findByXeventtypeidDaterangesavedsearchid(xeventtypeid, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidDaterangesavedsearchid(int xeventtypeid, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidAccountid(int xeventtypeid, int accountid) {
        return findByXeventtypeidAccountid(xeventtypeid, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXeventtypeidAccountid(int xeventtypeid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xeventtypeid='"+xeventtypeid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidXmegafieldid(int xlogid, int xmegafieldid) {
        return findByXlogidXmegafieldid(xlogid, xmegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidXmegafieldid(int xlogid, int xmegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', xmegafieldid='"+xmegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidYaxiswhattodo(int xlogid, int yaxiswhattodo) {
        return findByXlogidYaxiswhattodo(xlogid, yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidYaxiswhattodo(int xlogid, int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidChartsize(int xlogid, int chartsize) {
        return findByXlogidChartsize(xlogid, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidChartsize(int xlogid, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidCharttype(int xlogid, int charttype) {
        return findByXlogidCharttype(xlogid, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidCharttype(int xlogid, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterange(int xlogid, int daterange) {
        return findByXlogidDaterange(xlogid, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterange(int xlogid, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxdays(int xlogid, int lastxdays) {
        return findByXlogidLastxdays(xlogid, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxdays(int xlogid, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxweeks(int xlogid, int lastxweeks) {
        return findByXlogidLastxweeks(xlogid, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxweeks(int xlogid, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxmonths(int xlogid, int lastxmonths) {
        return findByXlogidLastxmonths(xlogid, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxmonths(int xlogid, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxyears(int xlogid, int lastxyears) {
        return findByXlogidLastxyears(xlogid, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidLastxyears(int xlogid, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefromyyyy(int xlogid, int daterangefromyyyy) {
        return findByXlogidDaterangefromyyyy(xlogid, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefromyyyy(int xlogid, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefrommm(int xlogid, int daterangefrommm) {
        return findByXlogidDaterangefrommm(xlogid, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefrommm(int xlogid, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefromdd(int xlogid, int daterangefromdd) {
        return findByXlogidDaterangefromdd(xlogid, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangefromdd(int xlogid, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetoyyyy(int xlogid, int daterangetoyyyy) {
        return findByXlogidDaterangetoyyyy(xlogid, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetoyyyy(int xlogid, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetomm(int xlogid, int daterangetomm) {
        return findByXlogidDaterangetomm(xlogid, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetomm(int xlogid, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetodd(int xlogid, int daterangetodd) {
        return findByXlogidDaterangetodd(xlogid, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangetodd(int xlogid, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangesavedsearchid(int xlogid, int daterangesavedsearchid) {
        return findByXlogidDaterangesavedsearchid(xlogid, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidDaterangesavedsearchid(int xlogid, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXlogidAccountid(int xlogid, int accountid) {
        return findByXlogidAccountid(xlogid, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXlogidAccountid(int xlogid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xlogid='"+xlogid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidYaxiswhattodo(int xmegafieldid, int yaxiswhattodo) {
        return findByXmegafieldidYaxiswhattodo(xmegafieldid, yaxiswhattodo, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidYaxiswhattodo(int xmegafieldid, int yaxiswhattodo, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', yaxiswhattodo='"+yaxiswhattodo+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidChartsize(int xmegafieldid, int chartsize) {
        return findByXmegafieldidChartsize(xmegafieldid, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidChartsize(int xmegafieldid, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidCharttype(int xmegafieldid, int charttype) {
        return findByXmegafieldidCharttype(xmegafieldid, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidCharttype(int xmegafieldid, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterange(int xmegafieldid, int daterange) {
        return findByXmegafieldidDaterange(xmegafieldid, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterange(int xmegafieldid, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxdays(int xmegafieldid, int lastxdays) {
        return findByXmegafieldidLastxdays(xmegafieldid, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxdays(int xmegafieldid, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxweeks(int xmegafieldid, int lastxweeks) {
        return findByXmegafieldidLastxweeks(xmegafieldid, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxweeks(int xmegafieldid, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxmonths(int xmegafieldid, int lastxmonths) {
        return findByXmegafieldidLastxmonths(xmegafieldid, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxmonths(int xmegafieldid, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxyears(int xmegafieldid, int lastxyears) {
        return findByXmegafieldidLastxyears(xmegafieldid, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidLastxyears(int xmegafieldid, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefromyyyy(int xmegafieldid, int daterangefromyyyy) {
        return findByXmegafieldidDaterangefromyyyy(xmegafieldid, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefromyyyy(int xmegafieldid, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefrommm(int xmegafieldid, int daterangefrommm) {
        return findByXmegafieldidDaterangefrommm(xmegafieldid, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefrommm(int xmegafieldid, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefromdd(int xmegafieldid, int daterangefromdd) {
        return findByXmegafieldidDaterangefromdd(xmegafieldid, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangefromdd(int xmegafieldid, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetoyyyy(int xmegafieldid, int daterangetoyyyy) {
        return findByXmegafieldidDaterangetoyyyy(xmegafieldid, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetoyyyy(int xmegafieldid, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetomm(int xmegafieldid, int daterangetomm) {
        return findByXmegafieldidDaterangetomm(xmegafieldid, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetomm(int xmegafieldid, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetodd(int xmegafieldid, int daterangetodd) {
        return findByXmegafieldidDaterangetodd(xmegafieldid, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangetodd(int xmegafieldid, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangesavedsearchid(int xmegafieldid, int daterangesavedsearchid) {
        return findByXmegafieldidDaterangesavedsearchid(xmegafieldid, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidDaterangesavedsearchid(int xmegafieldid, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidAccountid(int xmegafieldid, int accountid) {
        return findByXmegafieldidAccountid(xmegafieldid, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByXmegafieldidAccountid(int xmegafieldid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE xmegafieldid='"+xmegafieldid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoChartsize(int yaxiswhattodo, int chartsize) {
        return findByYaxiswhattodoChartsize(yaxiswhattodo, chartsize, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoChartsize(int yaxiswhattodo, int chartsize, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', chartsize='"+chartsize+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoCharttype(int yaxiswhattodo, int charttype) {
        return findByYaxiswhattodoCharttype(yaxiswhattodo, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoCharttype(int yaxiswhattodo, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterange(int yaxiswhattodo, int daterange) {
        return findByYaxiswhattodoDaterange(yaxiswhattodo, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterange(int yaxiswhattodo, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxdays(int yaxiswhattodo, int lastxdays) {
        return findByYaxiswhattodoLastxdays(yaxiswhattodo, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxdays(int yaxiswhattodo, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxweeks(int yaxiswhattodo, int lastxweeks) {
        return findByYaxiswhattodoLastxweeks(yaxiswhattodo, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxweeks(int yaxiswhattodo, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxmonths(int yaxiswhattodo, int lastxmonths) {
        return findByYaxiswhattodoLastxmonths(yaxiswhattodo, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxmonths(int yaxiswhattodo, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxyears(int yaxiswhattodo, int lastxyears) {
        return findByYaxiswhattodoLastxyears(yaxiswhattodo, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoLastxyears(int yaxiswhattodo, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefromyyyy(int yaxiswhattodo, int daterangefromyyyy) {
        return findByYaxiswhattodoDaterangefromyyyy(yaxiswhattodo, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefromyyyy(int yaxiswhattodo, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefrommm(int yaxiswhattodo, int daterangefrommm) {
        return findByYaxiswhattodoDaterangefrommm(yaxiswhattodo, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefrommm(int yaxiswhattodo, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefromdd(int yaxiswhattodo, int daterangefromdd) {
        return findByYaxiswhattodoDaterangefromdd(yaxiswhattodo, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangefromdd(int yaxiswhattodo, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetoyyyy(int yaxiswhattodo, int daterangetoyyyy) {
        return findByYaxiswhattodoDaterangetoyyyy(yaxiswhattodo, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetoyyyy(int yaxiswhattodo, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetomm(int yaxiswhattodo, int daterangetomm) {
        return findByYaxiswhattodoDaterangetomm(yaxiswhattodo, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetomm(int yaxiswhattodo, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetodd(int yaxiswhattodo, int daterangetodd) {
        return findByYaxiswhattodoDaterangetodd(yaxiswhattodo, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangetodd(int yaxiswhattodo, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangesavedsearchid(int yaxiswhattodo, int daterangesavedsearchid) {
        return findByYaxiswhattodoDaterangesavedsearchid(yaxiswhattodo, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoDaterangesavedsearchid(int yaxiswhattodo, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoAccountid(int yaxiswhattodo, int accountid) {
        return findByYaxiswhattodoAccountid(yaxiswhattodo, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByYaxiswhattodoAccountid(int yaxiswhattodo, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE yaxiswhattodo='"+yaxiswhattodo+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeCharttype(int chartsize, int charttype) {
        return findByChartsizeCharttype(chartsize, charttype, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeCharttype(int chartsize, int charttype, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', charttype='"+charttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterange(int chartsize, int daterange) {
        return findByChartsizeDaterange(chartsize, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterange(int chartsize, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxdays(int chartsize, int lastxdays) {
        return findByChartsizeLastxdays(chartsize, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxdays(int chartsize, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxweeks(int chartsize, int lastxweeks) {
        return findByChartsizeLastxweeks(chartsize, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxweeks(int chartsize, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxmonths(int chartsize, int lastxmonths) {
        return findByChartsizeLastxmonths(chartsize, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxmonths(int chartsize, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxyears(int chartsize, int lastxyears) {
        return findByChartsizeLastxyears(chartsize, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeLastxyears(int chartsize, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefromyyyy(int chartsize, int daterangefromyyyy) {
        return findByChartsizeDaterangefromyyyy(chartsize, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefromyyyy(int chartsize, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefrommm(int chartsize, int daterangefrommm) {
        return findByChartsizeDaterangefrommm(chartsize, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefrommm(int chartsize, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefromdd(int chartsize, int daterangefromdd) {
        return findByChartsizeDaterangefromdd(chartsize, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangefromdd(int chartsize, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetoyyyy(int chartsize, int daterangetoyyyy) {
        return findByChartsizeDaterangetoyyyy(chartsize, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetoyyyy(int chartsize, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetomm(int chartsize, int daterangetomm) {
        return findByChartsizeDaterangetomm(chartsize, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetomm(int chartsize, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetodd(int chartsize, int daterangetodd) {
        return findByChartsizeDaterangetodd(chartsize, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangetodd(int chartsize, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangesavedsearchid(int chartsize, int daterangesavedsearchid) {
        return findByChartsizeDaterangesavedsearchid(chartsize, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeDaterangesavedsearchid(int chartsize, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByChartsizeAccountid(int chartsize, int accountid) {
        return findByChartsizeAccountid(chartsize, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByChartsizeAccountid(int chartsize, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE chartsize='"+chartsize+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterange(int charttype, int daterange) {
        return findByCharttypeDaterange(charttype, daterange, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterange(int charttype, int daterange, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterange='"+daterange+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxdays(int charttype, int lastxdays) {
        return findByCharttypeLastxdays(charttype, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxdays(int charttype, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxweeks(int charttype, int lastxweeks) {
        return findByCharttypeLastxweeks(charttype, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxweeks(int charttype, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxmonths(int charttype, int lastxmonths) {
        return findByCharttypeLastxmonths(charttype, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxmonths(int charttype, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxyears(int charttype, int lastxyears) {
        return findByCharttypeLastxyears(charttype, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeLastxyears(int charttype, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefromyyyy(int charttype, int daterangefromyyyy) {
        return findByCharttypeDaterangefromyyyy(charttype, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefromyyyy(int charttype, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefrommm(int charttype, int daterangefrommm) {
        return findByCharttypeDaterangefrommm(charttype, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefrommm(int charttype, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefromdd(int charttype, int daterangefromdd) {
        return findByCharttypeDaterangefromdd(charttype, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangefromdd(int charttype, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetoyyyy(int charttype, int daterangetoyyyy) {
        return findByCharttypeDaterangetoyyyy(charttype, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetoyyyy(int charttype, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetomm(int charttype, int daterangetomm) {
        return findByCharttypeDaterangetomm(charttype, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetomm(int charttype, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetodd(int charttype, int daterangetodd) {
        return findByCharttypeDaterangetodd(charttype, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangetodd(int charttype, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangesavedsearchid(int charttype, int daterangesavedsearchid) {
        return findByCharttypeDaterangesavedsearchid(charttype, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeDaterangesavedsearchid(int charttype, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByCharttypeAccountid(int charttype, int accountid) {
        return findByCharttypeAccountid(charttype, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByCharttypeAccountid(int charttype, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE charttype='"+charttype+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxdays(int daterange, int lastxdays) {
        return findByDaterangeLastxdays(daterange, lastxdays, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxdays(int daterange, int lastxdays, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', lastxdays='"+lastxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxweeks(int daterange, int lastxweeks) {
        return findByDaterangeLastxweeks(daterange, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxweeks(int daterange, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxmonths(int daterange, int lastxmonths) {
        return findByDaterangeLastxmonths(daterange, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxmonths(int daterange, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxyears(int daterange, int lastxyears) {
        return findByDaterangeLastxyears(daterange, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeLastxyears(int daterange, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefromyyyy(int daterange, int daterangefromyyyy) {
        return findByDaterangeDaterangefromyyyy(daterange, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefromyyyy(int daterange, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefrommm(int daterange, int daterangefrommm) {
        return findByDaterangeDaterangefrommm(daterange, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefrommm(int daterange, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefromdd(int daterange, int daterangefromdd) {
        return findByDaterangeDaterangefromdd(daterange, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangefromdd(int daterange, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetoyyyy(int daterange, int daterangetoyyyy) {
        return findByDaterangeDaterangetoyyyy(daterange, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetoyyyy(int daterange, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetomm(int daterange, int daterangetomm) {
        return findByDaterangeDaterangetomm(daterange, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetomm(int daterange, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetodd(int daterange, int daterangetodd) {
        return findByDaterangeDaterangetodd(daterange, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangetodd(int daterange, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangesavedsearchid(int daterange, int daterangesavedsearchid) {
        return findByDaterangeDaterangesavedsearchid(daterange, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeDaterangesavedsearchid(int daterange, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangeAccountid(int daterange, int accountid) {
        return findByDaterangeAccountid(daterange, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangeAccountid(int daterange, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterange='"+daterange+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxweeks(int lastxdays, int lastxweeks) {
        return findByLastxdaysLastxweeks(lastxdays, lastxweeks, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxweeks(int lastxdays, int lastxweeks, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', lastxweeks='"+lastxweeks+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxmonths(int lastxdays, int lastxmonths) {
        return findByLastxdaysLastxmonths(lastxdays, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxmonths(int lastxdays, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxyears(int lastxdays, int lastxyears) {
        return findByLastxdaysLastxyears(lastxdays, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysLastxyears(int lastxdays, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefromyyyy(int lastxdays, int daterangefromyyyy) {
        return findByLastxdaysDaterangefromyyyy(lastxdays, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefromyyyy(int lastxdays, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefrommm(int lastxdays, int daterangefrommm) {
        return findByLastxdaysDaterangefrommm(lastxdays, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefrommm(int lastxdays, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefromdd(int lastxdays, int daterangefromdd) {
        return findByLastxdaysDaterangefromdd(lastxdays, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangefromdd(int lastxdays, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetoyyyy(int lastxdays, int daterangetoyyyy) {
        return findByLastxdaysDaterangetoyyyy(lastxdays, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetoyyyy(int lastxdays, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetomm(int lastxdays, int daterangetomm) {
        return findByLastxdaysDaterangetomm(lastxdays, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetomm(int lastxdays, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetodd(int lastxdays, int daterangetodd) {
        return findByLastxdaysDaterangetodd(lastxdays, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangetodd(int lastxdays, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangesavedsearchid(int lastxdays, int daterangesavedsearchid) {
        return findByLastxdaysDaterangesavedsearchid(lastxdays, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysDaterangesavedsearchid(int lastxdays, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxdaysAccountid(int lastxdays, int accountid) {
        return findByLastxdaysAccountid(lastxdays, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxdaysAccountid(int lastxdays, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxdays='"+lastxdays+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksLastxmonths(int lastxweeks, int lastxmonths) {
        return findByLastxweeksLastxmonths(lastxweeks, lastxmonths, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksLastxmonths(int lastxweeks, int lastxmonths, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', lastxmonths='"+lastxmonths+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksLastxyears(int lastxweeks, int lastxyears) {
        return findByLastxweeksLastxyears(lastxweeks, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksLastxyears(int lastxweeks, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefromyyyy(int lastxweeks, int daterangefromyyyy) {
        return findByLastxweeksDaterangefromyyyy(lastxweeks, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefromyyyy(int lastxweeks, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefrommm(int lastxweeks, int daterangefrommm) {
        return findByLastxweeksDaterangefrommm(lastxweeks, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefrommm(int lastxweeks, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefromdd(int lastxweeks, int daterangefromdd) {
        return findByLastxweeksDaterangefromdd(lastxweeks, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangefromdd(int lastxweeks, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetoyyyy(int lastxweeks, int daterangetoyyyy) {
        return findByLastxweeksDaterangetoyyyy(lastxweeks, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetoyyyy(int lastxweeks, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetomm(int lastxweeks, int daterangetomm) {
        return findByLastxweeksDaterangetomm(lastxweeks, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetomm(int lastxweeks, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetodd(int lastxweeks, int daterangetodd) {
        return findByLastxweeksDaterangetodd(lastxweeks, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangetodd(int lastxweeks, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangesavedsearchid(int lastxweeks, int daterangesavedsearchid) {
        return findByLastxweeksDaterangesavedsearchid(lastxweeks, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksDaterangesavedsearchid(int lastxweeks, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxweeksAccountid(int lastxweeks, int accountid) {
        return findByLastxweeksAccountid(lastxweeks, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxweeksAccountid(int lastxweeks, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxweeks='"+lastxweeks+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsLastxyears(int lastxmonths, int lastxyears) {
        return findByLastxmonthsLastxyears(lastxmonths, lastxyears, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsLastxyears(int lastxmonths, int lastxyears, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', lastxyears='"+lastxyears+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefromyyyy(int lastxmonths, int daterangefromyyyy) {
        return findByLastxmonthsDaterangefromyyyy(lastxmonths, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefromyyyy(int lastxmonths, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefrommm(int lastxmonths, int daterangefrommm) {
        return findByLastxmonthsDaterangefrommm(lastxmonths, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefrommm(int lastxmonths, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefromdd(int lastxmonths, int daterangefromdd) {
        return findByLastxmonthsDaterangefromdd(lastxmonths, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangefromdd(int lastxmonths, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetoyyyy(int lastxmonths, int daterangetoyyyy) {
        return findByLastxmonthsDaterangetoyyyy(lastxmonths, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetoyyyy(int lastxmonths, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetomm(int lastxmonths, int daterangetomm) {
        return findByLastxmonthsDaterangetomm(lastxmonths, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetomm(int lastxmonths, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetodd(int lastxmonths, int daterangetodd) {
        return findByLastxmonthsDaterangetodd(lastxmonths, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangetodd(int lastxmonths, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangesavedsearchid(int lastxmonths, int daterangesavedsearchid) {
        return findByLastxmonthsDaterangesavedsearchid(lastxmonths, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsDaterangesavedsearchid(int lastxmonths, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsAccountid(int lastxmonths, int accountid) {
        return findByLastxmonthsAccountid(lastxmonths, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxmonthsAccountid(int lastxmonths, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxmonths='"+lastxmonths+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefromyyyy(int lastxyears, int daterangefromyyyy) {
        return findByLastxyearsDaterangefromyyyy(lastxyears, daterangefromyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefromyyyy(int lastxyears, int daterangefromyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangefromyyyy='"+daterangefromyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefrommm(int lastxyears, int daterangefrommm) {
        return findByLastxyearsDaterangefrommm(lastxyears, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefrommm(int lastxyears, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefromdd(int lastxyears, int daterangefromdd) {
        return findByLastxyearsDaterangefromdd(lastxyears, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangefromdd(int lastxyears, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetoyyyy(int lastxyears, int daterangetoyyyy) {
        return findByLastxyearsDaterangetoyyyy(lastxyears, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetoyyyy(int lastxyears, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetomm(int lastxyears, int daterangetomm) {
        return findByLastxyearsDaterangetomm(lastxyears, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetomm(int lastxyears, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetodd(int lastxyears, int daterangetodd) {
        return findByLastxyearsDaterangetodd(lastxyears, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangetodd(int lastxyears, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangesavedsearchid(int lastxyears, int daterangesavedsearchid) {
        return findByLastxyearsDaterangesavedsearchid(lastxyears, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsDaterangesavedsearchid(int lastxyears, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByLastxyearsAccountid(int lastxyears, int accountid) {
        return findByLastxyearsAccountid(lastxyears, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByLastxyearsAccountid(int lastxyears, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE lastxyears='"+lastxyears+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangefrommm(int daterangefromyyyy, int daterangefrommm) {
        return findByDaterangefromyyyyDaterangefrommm(daterangefromyyyy, daterangefrommm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangefrommm(int daterangefromyyyy, int daterangefrommm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangefrommm='"+daterangefrommm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangefromdd(int daterangefromyyyy, int daterangefromdd) {
        return findByDaterangefromyyyyDaterangefromdd(daterangefromyyyy, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangefromdd(int daterangefromyyyy, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetoyyyy(int daterangefromyyyy, int daterangetoyyyy) {
        return findByDaterangefromyyyyDaterangetoyyyy(daterangefromyyyy, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetoyyyy(int daterangefromyyyy, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetomm(int daterangefromyyyy, int daterangetomm) {
        return findByDaterangefromyyyyDaterangetomm(daterangefromyyyy, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetomm(int daterangefromyyyy, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetodd(int daterangefromyyyy, int daterangetodd) {
        return findByDaterangefromyyyyDaterangetodd(daterangefromyyyy, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangetodd(int daterangefromyyyy, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangesavedsearchid(int daterangefromyyyy, int daterangesavedsearchid) {
        return findByDaterangefromyyyyDaterangesavedsearchid(daterangefromyyyy, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyDaterangesavedsearchid(int daterangefromyyyy, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyAccountid(int daterangefromyyyy, int accountid) {
        return findByDaterangefromyyyyAccountid(daterangefromyyyy, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromyyyyAccountid(int daterangefromyyyy, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromyyyy='"+daterangefromyyyy+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangefromdd(int daterangefrommm, int daterangefromdd) {
        return findByDaterangefrommmDaterangefromdd(daterangefrommm, daterangefromdd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangefromdd(int daterangefrommm, int daterangefromdd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', daterangefromdd='"+daterangefromdd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetoyyyy(int daterangefrommm, int daterangetoyyyy) {
        return findByDaterangefrommmDaterangetoyyyy(daterangefrommm, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetoyyyy(int daterangefrommm, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetomm(int daterangefrommm, int daterangetomm) {
        return findByDaterangefrommmDaterangetomm(daterangefrommm, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetomm(int daterangefrommm, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetodd(int daterangefrommm, int daterangetodd) {
        return findByDaterangefrommmDaterangetodd(daterangefrommm, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangetodd(int daterangefrommm, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangesavedsearchid(int daterangefrommm, int daterangesavedsearchid) {
        return findByDaterangefrommmDaterangesavedsearchid(daterangefrommm, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmDaterangesavedsearchid(int daterangefrommm, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmAccountid(int daterangefrommm, int accountid) {
        return findByDaterangefrommmAccountid(daterangefrommm, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefrommmAccountid(int daterangefrommm, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefrommm='"+daterangefrommm+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetoyyyy(int daterangefromdd, int daterangetoyyyy) {
        return findByDaterangefromddDaterangetoyyyy(daterangefromdd, daterangetoyyyy, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetoyyyy(int daterangefromdd, int daterangetoyyyy, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"', daterangetoyyyy='"+daterangetoyyyy+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetomm(int daterangefromdd, int daterangetomm) {
        return findByDaterangefromddDaterangetomm(daterangefromdd, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetomm(int daterangefromdd, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetodd(int daterangefromdd, int daterangetodd) {
        return findByDaterangefromddDaterangetodd(daterangefromdd, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangetodd(int daterangefromdd, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangesavedsearchid(int daterangefromdd, int daterangesavedsearchid) {
        return findByDaterangefromddDaterangesavedsearchid(daterangefromdd, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddDaterangesavedsearchid(int daterangefromdd, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddAccountid(int daterangefromdd, int accountid) {
        return findByDaterangefromddAccountid(daterangefromdd, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangefromddAccountid(int daterangefromdd, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangefromdd='"+daterangefromdd+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangetomm(int daterangetoyyyy, int daterangetomm) {
        return findByDaterangetoyyyyDaterangetomm(daterangetoyyyy, daterangetomm, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangetomm(int daterangetoyyyy, int daterangetomm, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetoyyyy='"+daterangetoyyyy+"', daterangetomm='"+daterangetomm+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangetodd(int daterangetoyyyy, int daterangetodd) {
        return findByDaterangetoyyyyDaterangetodd(daterangetoyyyy, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangetodd(int daterangetoyyyy, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetoyyyy='"+daterangetoyyyy+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangesavedsearchid(int daterangetoyyyy, int daterangesavedsearchid) {
        return findByDaterangetoyyyyDaterangesavedsearchid(daterangetoyyyy, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyDaterangesavedsearchid(int daterangetoyyyy, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetoyyyy='"+daterangetoyyyy+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyAccountid(int daterangetoyyyy, int accountid) {
        return findByDaterangetoyyyyAccountid(daterangetoyyyy, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoyyyyAccountid(int daterangetoyyyy, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetoyyyy='"+daterangetoyyyy+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetommDaterangetodd(int daterangetomm, int daterangetodd) {
        return findByDaterangetommDaterangetodd(daterangetomm, daterangetodd, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetommDaterangetodd(int daterangetomm, int daterangetodd, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetomm='"+daterangetomm+"', daterangetodd='"+daterangetodd+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetommDaterangesavedsearchid(int daterangetomm, int daterangesavedsearchid) {
        return findByDaterangetommDaterangesavedsearchid(daterangetomm, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetommDaterangesavedsearchid(int daterangetomm, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetomm='"+daterangetomm+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetommAccountid(int daterangetomm, int accountid) {
        return findByDaterangetommAccountid(daterangetomm, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetommAccountid(int daterangetomm, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetomm='"+daterangetomm+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoddDaterangesavedsearchid(int daterangetodd, int daterangesavedsearchid) {
        return findByDaterangetoddDaterangesavedsearchid(daterangetodd, daterangesavedsearchid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoddDaterangesavedsearchid(int daterangetodd, int daterangesavedsearchid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetodd='"+daterangetodd+"', daterangesavedsearchid='"+daterangesavedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangetoddAccountid(int daterangetodd, int accountid) {
        return findByDaterangetoddAccountid(daterangetodd, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangetoddAccountid(int daterangetodd, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangetodd='"+daterangetodd+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartDAO> findByDaterangesavedsearchidAccountid(int daterangesavedsearchid, int accountid) {
        return findByDaterangesavedsearchidAccountid(daterangesavedsearchid, accountid, 0, 50000);
    }

    public static ArrayList<MegachartDAO> findByDaterangesavedsearchidAccountid(int daterangesavedsearchid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegachartDAO> resultarraylist = new ArrayList<MegachartDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE daterangesavedsearchid='"+daterangesavedsearchid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}