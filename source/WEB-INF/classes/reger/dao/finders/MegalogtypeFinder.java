package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegalogtypeDAO;

/**
 * Finder for the 'megalogtype' DAO
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

public class MegalogtypeFinder {


    public static ArrayList<MegalogtypeDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalogname(String megalogname) {
        return findByMegalogname(megalogname, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalogname(String megalogname, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescription(String longdescription) {
        return findByLongdescription(longdescription, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescription(String longdescription, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocation(boolean showlocation) {
        return findByShowlocation(showlocation, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocation(boolean showlocation, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIcon(String icon) {
        return findByIcon(icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIcon(String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepage(boolean showonhomepage) {
        return findByShowonhomepage(showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepage(boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtype(boolean issystemlogtype) {
        return findByIssystemlogtype(issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtype(boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivate(boolean isprivate) {
        return findByIsprivate(isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivate(boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByHiddenfields(String hiddenfields) {
        return findByHiddenfields(hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByHiddenfields(String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByFieldorder(String fieldorder) {
        return findByFieldorder(fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByFieldorder(String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidMegalogname(int eventtypeid, String megalogname) {
        return findByEventtypeidMegalogname(eventtypeid, megalogname, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidMegalogname(int eventtypeid, String megalogname, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidDescription(int eventtypeid, String description) {
        return findByEventtypeidDescription(eventtypeid, description, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidDescription(int eventtypeid, String description, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidLongdescription(int eventtypeid, String longdescription) {
        return findByEventtypeidLongdescription(eventtypeid, longdescription, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidLongdescription(int eventtypeid, String longdescription, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidShowlocation(int eventtypeid, boolean showlocation) {
        return findByEventtypeidShowlocation(eventtypeid, showlocation, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidShowlocation(int eventtypeid, boolean showlocation, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIcon(int eventtypeid, String icon) {
        return findByEventtypeidIcon(eventtypeid, icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIcon(int eventtypeid, String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidShowonhomepage(int eventtypeid, boolean showonhomepage) {
        return findByEventtypeidShowonhomepage(eventtypeid, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidShowonhomepage(int eventtypeid, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIssystemlogtype(int eventtypeid, boolean issystemlogtype) {
        return findByEventtypeidIssystemlogtype(eventtypeid, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIssystemlogtype(int eventtypeid, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIsprivate(int eventtypeid, boolean isprivate) {
        return findByEventtypeidIsprivate(eventtypeid, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidIsprivate(int eventtypeid, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidAccountuserid(int eventtypeid, int accountuserid) {
        return findByEventtypeidAccountuserid(eventtypeid, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidAccountuserid(int eventtypeid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidHiddenfields(int eventtypeid, String hiddenfields) {
        return findByEventtypeidHiddenfields(eventtypeid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidHiddenfields(int eventtypeid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidFieldorder(int eventtypeid, String fieldorder) {
        return findByEventtypeidFieldorder(eventtypeid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByEventtypeidFieldorder(int eventtypeid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameDescription(String megalogname, String description) {
        return findByMegalognameDescription(megalogname, description, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameDescription(String megalogname, String description, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameLongdescription(String megalogname, String longdescription) {
        return findByMegalognameLongdescription(megalogname, longdescription, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameLongdescription(String megalogname, String longdescription, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameShowlocation(String megalogname, boolean showlocation) {
        return findByMegalognameShowlocation(megalogname, showlocation, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameShowlocation(String megalogname, boolean showlocation, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIcon(String megalogname, String icon) {
        return findByMegalognameIcon(megalogname, icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIcon(String megalogname, String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameShowonhomepage(String megalogname, boolean showonhomepage) {
        return findByMegalognameShowonhomepage(megalogname, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameShowonhomepage(String megalogname, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIssystemlogtype(String megalogname, boolean issystemlogtype) {
        return findByMegalognameIssystemlogtype(megalogname, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIssystemlogtype(String megalogname, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIsprivate(String megalogname, boolean isprivate) {
        return findByMegalognameIsprivate(megalogname, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameIsprivate(String megalogname, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameAccountuserid(String megalogname, int accountuserid) {
        return findByMegalognameAccountuserid(megalogname, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameAccountuserid(String megalogname, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameHiddenfields(String megalogname, String hiddenfields) {
        return findByMegalognameHiddenfields(megalogname, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameHiddenfields(String megalogname, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameFieldorder(String megalogname, String fieldorder) {
        return findByMegalognameFieldorder(megalogname, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByMegalognameFieldorder(String megalogname, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionLongdescription(String description, String longdescription) {
        return findByDescriptionLongdescription(description, longdescription, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionLongdescription(String description, String longdescription, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionShowlocation(String description, boolean showlocation) {
        return findByDescriptionShowlocation(description, showlocation, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionShowlocation(String description, boolean showlocation, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIcon(String description, String icon) {
        return findByDescriptionIcon(description, icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIcon(String description, String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionShowonhomepage(String description, boolean showonhomepage) {
        return findByDescriptionShowonhomepage(description, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionShowonhomepage(String description, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIssystemlogtype(String description, boolean issystemlogtype) {
        return findByDescriptionIssystemlogtype(description, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIssystemlogtype(String description, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIsprivate(String description, boolean isprivate) {
        return findByDescriptionIsprivate(description, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionIsprivate(String description, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionAccountuserid(String description, int accountuserid) {
        return findByDescriptionAccountuserid(description, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionAccountuserid(String description, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionHiddenfields(String description, String hiddenfields) {
        return findByDescriptionHiddenfields(description, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionHiddenfields(String description, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionFieldorder(String description, String fieldorder) {
        return findByDescriptionFieldorder(description, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByDescriptionFieldorder(String description, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE description='"+reger.core.Util.cleanForSQL(description)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionShowlocation(String longdescription, boolean showlocation) {
        return findByLongdescriptionShowlocation(longdescription, showlocation, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionShowlocation(String longdescription, boolean showlocation, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIcon(String longdescription, String icon) {
        return findByLongdescriptionIcon(longdescription, icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIcon(String longdescription, String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionShowonhomepage(String longdescription, boolean showonhomepage) {
        return findByLongdescriptionShowonhomepage(longdescription, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionShowonhomepage(String longdescription, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIssystemlogtype(String longdescription, boolean issystemlogtype) {
        return findByLongdescriptionIssystemlogtype(longdescription, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIssystemlogtype(String longdescription, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIsprivate(String longdescription, boolean isprivate) {
        return findByLongdescriptionIsprivate(longdescription, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionIsprivate(String longdescription, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionAccountuserid(String longdescription, int accountuserid) {
        return findByLongdescriptionAccountuserid(longdescription, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionAccountuserid(String longdescription, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionHiddenfields(String longdescription, String hiddenfields) {
        return findByLongdescriptionHiddenfields(longdescription, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionHiddenfields(String longdescription, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionFieldorder(String longdescription, String fieldorder) {
        return findByLongdescriptionFieldorder(longdescription, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByLongdescriptionFieldorder(String longdescription, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIcon(boolean showlocation, String icon) {
        return findByShowlocationIcon(showlocation, icon, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIcon(boolean showlocation, String icon, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', icon='"+reger.core.Util.cleanForSQL(icon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationShowonhomepage(boolean showlocation, boolean showonhomepage) {
        return findByShowlocationShowonhomepage(showlocation, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationShowonhomepage(boolean showlocation, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIssystemlogtype(boolean showlocation, boolean issystemlogtype) {
        return findByShowlocationIssystemlogtype(showlocation, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIssystemlogtype(boolean showlocation, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIsprivate(boolean showlocation, boolean isprivate) {
        return findByShowlocationIsprivate(showlocation, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationIsprivate(boolean showlocation, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationAccountuserid(boolean showlocation, int accountuserid) {
        return findByShowlocationAccountuserid(showlocation, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationAccountuserid(boolean showlocation, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationHiddenfields(boolean showlocation, String hiddenfields) {
        return findByShowlocationHiddenfields(showlocation, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationHiddenfields(boolean showlocation, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationFieldorder(boolean showlocation, String fieldorder) {
        return findByShowlocationFieldorder(showlocation, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowlocationFieldorder(boolean showlocation, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconShowonhomepage(String icon, boolean showonhomepage) {
        return findByIconShowonhomepage(icon, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconShowonhomepage(String icon, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconIssystemlogtype(String icon, boolean issystemlogtype) {
        return findByIconIssystemlogtype(icon, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconIssystemlogtype(String icon, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconIsprivate(String icon, boolean isprivate) {
        return findByIconIsprivate(icon, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconIsprivate(String icon, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconAccountuserid(String icon, int accountuserid) {
        return findByIconAccountuserid(icon, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconAccountuserid(String icon, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconHiddenfields(String icon, String hiddenfields) {
        return findByIconHiddenfields(icon, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconHiddenfields(String icon, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIconFieldorder(String icon, String fieldorder) {
        return findByIconFieldorder(icon, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIconFieldorder(String icon, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE icon='"+reger.core.Util.cleanForSQL(icon)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageIssystemlogtype(boolean showonhomepage, boolean issystemlogtype) {
        return findByShowonhomepageIssystemlogtype(showonhomepage, issystemlogtype, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageIssystemlogtype(boolean showonhomepage, boolean issystemlogtype, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageIsprivate(boolean showonhomepage, boolean isprivate) {
        return findByShowonhomepageIsprivate(showonhomepage, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageIsprivate(boolean showonhomepage, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageAccountuserid(boolean showonhomepage, int accountuserid) {
        return findByShowonhomepageAccountuserid(showonhomepage, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageAccountuserid(boolean showonhomepage, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageHiddenfields(boolean showonhomepage, String hiddenfields) {
        return findByShowonhomepageHiddenfields(showonhomepage, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageHiddenfields(boolean showonhomepage, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageFieldorder(boolean showonhomepage, String fieldorder) {
        return findByShowonhomepageFieldorder(showonhomepage, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByShowonhomepageFieldorder(boolean showonhomepage, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeIsprivate(boolean issystemlogtype, boolean isprivate) {
        return findByIssystemlogtypeIsprivate(issystemlogtype, isprivate, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeIsprivate(boolean issystemlogtype, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeAccountuserid(boolean issystemlogtype, int accountuserid) {
        return findByIssystemlogtypeAccountuserid(issystemlogtype, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeAccountuserid(boolean issystemlogtype, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeHiddenfields(boolean issystemlogtype, String hiddenfields) {
        return findByIssystemlogtypeHiddenfields(issystemlogtype, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeHiddenfields(boolean issystemlogtype, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeFieldorder(boolean issystemlogtype, String fieldorder) {
        return findByIssystemlogtypeFieldorder(issystemlogtype, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIssystemlogtypeFieldorder(boolean issystemlogtype, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateAccountuserid(boolean isprivate, int accountuserid) {
        return findByIsprivateAccountuserid(isprivate, accountuserid, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateAccountuserid(boolean isprivate, int accountuserid, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateHiddenfields(boolean isprivate, String hiddenfields) {
        return findByIsprivateHiddenfields(isprivate, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateHiddenfields(boolean isprivate, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateFieldorder(boolean isprivate, String fieldorder) {
        return findByIsprivateFieldorder(isprivate, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByIsprivateFieldorder(boolean isprivate, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuseridHiddenfields(int accountuserid, String hiddenfields) {
        return findByAccountuseridHiddenfields(accountuserid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuseridHiddenfields(int accountuserid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE accountuserid='"+accountuserid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuseridFieldorder(int accountuserid, String fieldorder) {
        return findByAccountuseridFieldorder(accountuserid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByAccountuseridFieldorder(int accountuserid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE accountuserid='"+accountuserid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogtypeDAO> findByHiddenfieldsFieldorder(String hiddenfields, String fieldorder) {
        return findByHiddenfieldsFieldorder(hiddenfields, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogtypeDAO> findByHiddenfieldsFieldorder(String hiddenfields, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogtypeDAO> resultarraylist = new ArrayList<MegalogtypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogtypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}