package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegafieldDAO;

/**
 * Finder for the 'megafield' DAO
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

public class MegafieldFinder {


    public static ArrayList<MegafieldDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtype(int fieldtype) {
        return findByFieldtype(fieldtype, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtype(int fieldtype, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldname(String fieldname) {
        return findByFieldname(fieldname, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldname(String fieldname, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFielddescription(String fielddescription) {
        return findByFielddescription(fielddescription, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFielddescription(String fielddescription, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeid(int megadatatypeid) {
        return findByMegadatatypeid(megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeid(int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByIsrequired(boolean isrequired) {
        return findByIsrequired(isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByIsrequired(boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFieldtype(int megafieldid, int fieldtype) {
        return findByMegafieldidFieldtype(megafieldid, fieldtype, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFieldtype(int megafieldid, int fieldtype, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', fieldtype='"+fieldtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidEventtypeid(int megafieldid, int eventtypeid) {
        return findByMegafieldidEventtypeid(megafieldid, eventtypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidEventtypeid(int megafieldid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFieldname(int megafieldid, String fieldname) {
        return findByMegafieldidFieldname(megafieldid, fieldname, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFieldname(int megafieldid, String fieldname, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFielddescription(int megafieldid, String fielddescription) {
        return findByMegafieldidFielddescription(megafieldid, fielddescription, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidFielddescription(int megafieldid, String fielddescription, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidMegadatatypeid(int megafieldid, int megadatatypeid) {
        return findByMegafieldidMegadatatypeid(megafieldid, megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidMegadatatypeid(int megafieldid, int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidIsrequired(int megafieldid, boolean isrequired) {
        return findByMegafieldidIsrequired(megafieldid, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidIsrequired(int megafieldid, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidLogid(int megafieldid, int logid) {
        return findByMegafieldidLogid(megafieldid, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegafieldidLogid(int megafieldid, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeEventtypeid(int fieldtype, int eventtypeid) {
        return findByFieldtypeEventtypeid(fieldtype, eventtypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeEventtypeid(int fieldtype, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeFieldname(int fieldtype, String fieldname) {
        return findByFieldtypeFieldname(fieldtype, fieldname, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeFieldname(int fieldtype, String fieldname, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeFielddescription(int fieldtype, String fielddescription) {
        return findByFieldtypeFielddescription(fieldtype, fielddescription, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeFielddescription(int fieldtype, String fielddescription, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeMegadatatypeid(int fieldtype, int megadatatypeid) {
        return findByFieldtypeMegadatatypeid(fieldtype, megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeMegadatatypeid(int fieldtype, int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeIsrequired(int fieldtype, boolean isrequired) {
        return findByFieldtypeIsrequired(fieldtype, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeIsrequired(int fieldtype, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeLogid(int fieldtype, int logid) {
        return findByFieldtypeLogid(fieldtype, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldtypeLogid(int fieldtype, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldtype='"+fieldtype+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidFieldname(int eventtypeid, String fieldname) {
        return findByEventtypeidFieldname(eventtypeid, fieldname, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidFieldname(int eventtypeid, String fieldname, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"', fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidFielddescription(int eventtypeid, String fielddescription) {
        return findByEventtypeidFielddescription(eventtypeid, fielddescription, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidFielddescription(int eventtypeid, String fielddescription, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"', fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidMegadatatypeid(int eventtypeid, int megadatatypeid) {
        return findByEventtypeidMegadatatypeid(eventtypeid, megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidMegadatatypeid(int eventtypeid, int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"', megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidIsrequired(int eventtypeid, boolean isrequired) {
        return findByEventtypeidIsrequired(eventtypeid, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidIsrequired(int eventtypeid, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidLogid(int eventtypeid, int logid) {
        return findByEventtypeidLogid(eventtypeid, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByEventtypeidLogid(int eventtypeid, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+eventtypeid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldnameFielddescription(String fieldname, String fielddescription) {
        return findByFieldnameFielddescription(fieldname, fielddescription, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldnameFielddescription(String fieldname, String fielddescription, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"', fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldnameMegadatatypeid(String fieldname, int megadatatypeid) {
        return findByFieldnameMegadatatypeid(fieldname, megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldnameMegadatatypeid(String fieldname, int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"', megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldnameIsrequired(String fieldname, boolean isrequired) {
        return findByFieldnameIsrequired(fieldname, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldnameIsrequired(String fieldname, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFieldnameLogid(String fieldname, int logid) {
        return findByFieldnameLogid(fieldname, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFieldnameLogid(String fieldname, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionMegadatatypeid(String fielddescription, int megadatatypeid) {
        return findByFielddescriptionMegadatatypeid(fielddescription, megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionMegadatatypeid(String fielddescription, int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"', megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionIsrequired(String fielddescription, boolean isrequired) {
        return findByFielddescriptionIsrequired(fielddescription, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionIsrequired(String fielddescription, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionLogid(String fielddescription, int logid) {
        return findByFielddescriptionLogid(fielddescription, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByFielddescriptionLogid(String fielddescription, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeidIsrequired(int megadatatypeid, boolean isrequired) {
        return findByMegadatatypeidIsrequired(megadatatypeid, isrequired, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeidIsrequired(int megadatatypeid, boolean isrequired, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megadatatypeid='"+megadatatypeid+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeidLogid(int megadatatypeid, int logid) {
        return findByMegadatatypeidLogid(megadatatypeid, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByMegadatatypeidLogid(int megadatatypeid, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megadatatypeid='"+megadatatypeid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldDAO> findByIsrequiredLogid(boolean isrequired, int logid) {
        return findByIsrequiredLogid(isrequired, logid, 0, 50000);
    }

    public static ArrayList<MegafieldDAO> findByIsrequiredLogid(boolean isrequired, int logid, int limitmin, int limitmax) {
        ArrayList<MegafieldDAO> resultarraylist = new ArrayList<MegafieldDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}