package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegavalueDAO;

/**
 * Finder for the 'megavalue' DAO
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

public class MegavalueFinder {


    public static ArrayList<MegavalueDAO> findByMegavalueid(int megavalueid) {
        return findByMegavalueid(megavalueid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueid(int megavalueid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalue(String megavalue) {
        return findByMegavalue(megavalue, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalue(String megavalue, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueextended(String megavalueextended) {
        return findByMegavalueextended(megavalueextended, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueextended(String megavalueextended, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegafieldid(int megavalueid, int megafieldid) {
        return findByMegavalueidMegafieldid(megavalueid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegafieldid(int megavalueid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidEventid(int megavalueid, int eventid) {
        return findByMegavalueidEventid(megavalueid, eventid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidEventid(int megavalueid, int eventid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegavalue(int megavalueid, String megavalue) {
        return findByMegavalueidMegavalue(megavalueid, megavalue, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegavalue(int megavalueid, String megavalue, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"', megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegavalueextended(int megavalueid, String megavalueextended) {
        return findByMegavalueidMegavalueextended(megavalueid, megavalueextended, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueidMegavalueextended(int megavalueid, String megavalueextended, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"', megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidEventid(int megafieldid, int eventid) {
        return findByMegafieldidEventid(megafieldid, eventid, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidEventid(int megafieldid, int eventid, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megafieldid='"+megafieldid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidMegavalue(int megafieldid, String megavalue) {
        return findByMegafieldidMegavalue(megafieldid, megavalue, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidMegavalue(int megafieldid, String megavalue, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megafieldid='"+megafieldid+"', megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidMegavalueextended(int megafieldid, String megavalueextended) {
        return findByMegafieldidMegavalueextended(megafieldid, megavalueextended, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegafieldidMegavalueextended(int megafieldid, String megavalueextended, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megafieldid='"+megafieldid+"', megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByEventidMegavalue(int eventid, String megavalue) {
        return findByEventidMegavalue(eventid, megavalue, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByEventidMegavalue(int eventid, String megavalue, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE eventid='"+eventid+"', megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByEventidMegavalueextended(int eventid, String megavalueextended) {
        return findByEventidMegavalueextended(eventid, megavalueextended, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByEventidMegavalueextended(int eventid, String megavalueextended, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE eventid='"+eventid+"', megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegavalueDAO> findByMegavalueMegavalueextended(String megavalue, String megavalueextended) {
        return findByMegavalueMegavalueextended(megavalue, megavalueextended, 0, 50000);
    }

    public static ArrayList<MegavalueDAO> findByMegavalueMegavalueextended(String megavalue, String megavalueextended, int limitmin, int limitmax) {
        ArrayList<MegavalueDAO> resultarraylist = new ArrayList<MegavalueDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"', megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegavalueDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}