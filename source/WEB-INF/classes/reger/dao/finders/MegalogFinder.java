package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegalogDAO;

/**
 * Finder for the 'megalog' DAO
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

public class MegalogFinder {


    public static ArrayList<MegalogDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccess(int logaccess) {
        return findByLogaccess(logaccess, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccess(int logaccess, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPassword(String password) {
        return findByPassword(password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPassword(String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessage(String message) {
        return findByMessage(message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessage(String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepage(boolean showonhomepage) {
        return findByShowonhomepage(showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepage(boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateid(int maintemplateid) {
        return findByMaintemplateid(maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateid(int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateid(int entlisttemplateid) {
        return findByEntlisttemplateid(entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateid(int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttype(int nestednavparenttype) {
        return findByNestednavparenttype(nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttype(int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparentid(int nestednavparentid) {
        return findByNestednavparentid(nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparentid(int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavorder(int nestednavorder) {
        return findByNestednavorder(nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavorder(int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByFieldorder(String fieldorder) {
        return findByFieldorder(fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByFieldorder(String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByHiddenfields(String hiddenfields) {
        return findByHiddenfields(hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByHiddenfields(String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidAccountid(int logid, int accountid) {
        return findByLogidAccountid(logid, accountid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidAccountid(int logid, int accountid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidEventtypeid(int logid, int eventtypeid) {
        return findByLogidEventtypeid(logid, eventtypeid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidEventtypeid(int logid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidName(int logid, String name) {
        return findByLogidName(logid, name, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidName(int logid, String name, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidLogaccess(int logid, int logaccess) {
        return findByLogidLogaccess(logid, logaccess, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidLogaccess(int logid, int logaccess, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', logaccess='"+logaccess+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidPassword(int logid, String password) {
        return findByLogidPassword(logid, password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidPassword(int logid, String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidMessage(int logid, String message) {
        return findByLogidMessage(logid, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidMessage(int logid, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidShowonhomepage(int logid, boolean showonhomepage) {
        return findByLogidShowonhomepage(logid, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidShowonhomepage(int logid, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidMaintemplateid(int logid, int maintemplateid) {
        return findByLogidMaintemplateid(logid, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidMaintemplateid(int logid, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidEntlisttemplateid(int logid, int entlisttemplateid) {
        return findByLogidEntlisttemplateid(logid, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidEntlisttemplateid(int logid, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavparenttype(int logid, int nestednavparenttype) {
        return findByLogidNestednavparenttype(logid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavparenttype(int logid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavparentid(int logid, int nestednavparentid) {
        return findByLogidNestednavparentid(logid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavparentid(int logid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavorder(int logid, int nestednavorder) {
        return findByLogidNestednavorder(logid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidNestednavorder(int logid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidFieldorder(int logid, String fieldorder) {
        return findByLogidFieldorder(logid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidFieldorder(int logid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogidHiddenfields(int logid, String hiddenfields) {
        return findByLogidHiddenfields(logid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogidHiddenfields(int logid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidEventtypeid(int accountid, int eventtypeid) {
        return findByAccountidEventtypeid(accountid, eventtypeid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidEventtypeid(int accountid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidName(int accountid, String name) {
        return findByAccountidName(accountid, name, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidName(int accountid, String name, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidLogaccess(int accountid, int logaccess) {
        return findByAccountidLogaccess(accountid, logaccess, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidLogaccess(int accountid, int logaccess, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', logaccess='"+logaccess+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidPassword(int accountid, String password) {
        return findByAccountidPassword(accountid, password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidPassword(int accountid, String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidMessage(int accountid, String message) {
        return findByAccountidMessage(accountid, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidMessage(int accountid, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidShowonhomepage(int accountid, boolean showonhomepage) {
        return findByAccountidShowonhomepage(accountid, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidShowonhomepage(int accountid, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidMaintemplateid(int accountid, int maintemplateid) {
        return findByAccountidMaintemplateid(accountid, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidMaintemplateid(int accountid, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidEntlisttemplateid(int accountid, int entlisttemplateid) {
        return findByAccountidEntlisttemplateid(accountid, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidEntlisttemplateid(int accountid, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavparenttype(int accountid, int nestednavparenttype) {
        return findByAccountidNestednavparenttype(accountid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavparenttype(int accountid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavparentid(int accountid, int nestednavparentid) {
        return findByAccountidNestednavparentid(accountid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavparentid(int accountid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavorder(int accountid, int nestednavorder) {
        return findByAccountidNestednavorder(accountid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidNestednavorder(int accountid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidFieldorder(int accountid, String fieldorder) {
        return findByAccountidFieldorder(accountid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidFieldorder(int accountid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByAccountidHiddenfields(int accountid, String hiddenfields) {
        return findByAccountidHiddenfields(accountid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByAccountidHiddenfields(int accountid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidName(int eventtypeid, String name) {
        return findByEventtypeidName(eventtypeid, name, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidName(int eventtypeid, String name, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidLogaccess(int eventtypeid, int logaccess) {
        return findByEventtypeidLogaccess(eventtypeid, logaccess, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidLogaccess(int eventtypeid, int logaccess, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', logaccess='"+logaccess+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidPassword(int eventtypeid, String password) {
        return findByEventtypeidPassword(eventtypeid, password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidPassword(int eventtypeid, String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidMessage(int eventtypeid, String message) {
        return findByEventtypeidMessage(eventtypeid, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidMessage(int eventtypeid, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidShowonhomepage(int eventtypeid, boolean showonhomepage) {
        return findByEventtypeidShowonhomepage(eventtypeid, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidShowonhomepage(int eventtypeid, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidMaintemplateid(int eventtypeid, int maintemplateid) {
        return findByEventtypeidMaintemplateid(eventtypeid, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidMaintemplateid(int eventtypeid, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidEntlisttemplateid(int eventtypeid, int entlisttemplateid) {
        return findByEventtypeidEntlisttemplateid(eventtypeid, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidEntlisttemplateid(int eventtypeid, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavparenttype(int eventtypeid, int nestednavparenttype) {
        return findByEventtypeidNestednavparenttype(eventtypeid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavparenttype(int eventtypeid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavparentid(int eventtypeid, int nestednavparentid) {
        return findByEventtypeidNestednavparentid(eventtypeid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavparentid(int eventtypeid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavorder(int eventtypeid, int nestednavorder) {
        return findByEventtypeidNestednavorder(eventtypeid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidNestednavorder(int eventtypeid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidFieldorder(int eventtypeid, String fieldorder) {
        return findByEventtypeidFieldorder(eventtypeid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidFieldorder(int eventtypeid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEventtypeidHiddenfields(int eventtypeid, String hiddenfields) {
        return findByEventtypeidHiddenfields(eventtypeid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEventtypeidHiddenfields(int eventtypeid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE eventtypeid='"+eventtypeid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameLogaccess(String name, int logaccess) {
        return findByNameLogaccess(name, logaccess, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameLogaccess(String name, int logaccess, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', logaccess='"+logaccess+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNamePassword(String name, String password) {
        return findByNamePassword(name, password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNamePassword(String name, String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameMessage(String name, String message) {
        return findByNameMessage(name, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameMessage(String name, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameShowonhomepage(String name, boolean showonhomepage) {
        return findByNameShowonhomepage(name, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameShowonhomepage(String name, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameMaintemplateid(String name, int maintemplateid) {
        return findByNameMaintemplateid(name, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameMaintemplateid(String name, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameEntlisttemplateid(String name, int entlisttemplateid) {
        return findByNameEntlisttemplateid(name, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameEntlisttemplateid(String name, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameNestednavparenttype(String name, int nestednavparenttype) {
        return findByNameNestednavparenttype(name, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameNestednavparenttype(String name, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameNestednavparentid(String name, int nestednavparentid) {
        return findByNameNestednavparentid(name, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameNestednavparentid(String name, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameNestednavorder(String name, int nestednavorder) {
        return findByNameNestednavorder(name, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameNestednavorder(String name, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameFieldorder(String name, String fieldorder) {
        return findByNameFieldorder(name, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameFieldorder(String name, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNameHiddenfields(String name, String hiddenfields) {
        return findByNameHiddenfields(name, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNameHiddenfields(String name, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE name='"+reger.core.Util.cleanForSQL(name)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessPassword(int logaccess, String password) {
        return findByLogaccessPassword(logaccess, password, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessPassword(int logaccess, String password, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessMessage(int logaccess, String message) {
        return findByLogaccessMessage(logaccess, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessMessage(int logaccess, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessShowonhomepage(int logaccess, boolean showonhomepage) {
        return findByLogaccessShowonhomepage(logaccess, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessShowonhomepage(int logaccess, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessMaintemplateid(int logaccess, int maintemplateid) {
        return findByLogaccessMaintemplateid(logaccess, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessMaintemplateid(int logaccess, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessEntlisttemplateid(int logaccess, int entlisttemplateid) {
        return findByLogaccessEntlisttemplateid(logaccess, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessEntlisttemplateid(int logaccess, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavparenttype(int logaccess, int nestednavparenttype) {
        return findByLogaccessNestednavparenttype(logaccess, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavparenttype(int logaccess, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavparentid(int logaccess, int nestednavparentid) {
        return findByLogaccessNestednavparentid(logaccess, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavparentid(int logaccess, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavorder(int logaccess, int nestednavorder) {
        return findByLogaccessNestednavorder(logaccess, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessNestednavorder(int logaccess, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessFieldorder(int logaccess, String fieldorder) {
        return findByLogaccessFieldorder(logaccess, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessFieldorder(int logaccess, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByLogaccessHiddenfields(int logaccess, String hiddenfields) {
        return findByLogaccessHiddenfields(logaccess, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByLogaccessHiddenfields(int logaccess, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logaccess='"+logaccess+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordMessage(String password, String message) {
        return findByPasswordMessage(password, message, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordMessage(String password, String message, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordShowonhomepage(String password, boolean showonhomepage) {
        return findByPasswordShowonhomepage(password, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordShowonhomepage(String password, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordMaintemplateid(String password, int maintemplateid) {
        return findByPasswordMaintemplateid(password, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordMaintemplateid(String password, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordEntlisttemplateid(String password, int entlisttemplateid) {
        return findByPasswordEntlisttemplateid(password, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordEntlisttemplateid(String password, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavparenttype(String password, int nestednavparenttype) {
        return findByPasswordNestednavparenttype(password, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavparenttype(String password, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavparentid(String password, int nestednavparentid) {
        return findByPasswordNestednavparentid(password, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavparentid(String password, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavorder(String password, int nestednavorder) {
        return findByPasswordNestednavorder(password, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordNestednavorder(String password, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordFieldorder(String password, String fieldorder) {
        return findByPasswordFieldorder(password, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordFieldorder(String password, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByPasswordHiddenfields(String password, String hiddenfields) {
        return findByPasswordHiddenfields(password, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByPasswordHiddenfields(String password, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(password)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageShowonhomepage(String message, boolean showonhomepage) {
        return findByMessageShowonhomepage(message, showonhomepage, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageShowonhomepage(String message, boolean showonhomepage, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageMaintemplateid(String message, int maintemplateid) {
        return findByMessageMaintemplateid(message, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageMaintemplateid(String message, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageEntlisttemplateid(String message, int entlisttemplateid) {
        return findByMessageEntlisttemplateid(message, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageEntlisttemplateid(String message, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavparenttype(String message, int nestednavparenttype) {
        return findByMessageNestednavparenttype(message, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavparenttype(String message, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavparentid(String message, int nestednavparentid) {
        return findByMessageNestednavparentid(message, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavparentid(String message, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavorder(String message, int nestednavorder) {
        return findByMessageNestednavorder(message, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageNestednavorder(String message, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageFieldorder(String message, String fieldorder) {
        return findByMessageFieldorder(message, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageFieldorder(String message, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMessageHiddenfields(String message, String hiddenfields) {
        return findByMessageHiddenfields(message, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMessageHiddenfields(String message, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE message='"+reger.core.Util.cleanForSQL(message)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageMaintemplateid(boolean showonhomepage, int maintemplateid) {
        return findByShowonhomepageMaintemplateid(showonhomepage, maintemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageMaintemplateid(boolean showonhomepage, int maintemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', maintemplateid='"+maintemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageEntlisttemplateid(boolean showonhomepage, int entlisttemplateid) {
        return findByShowonhomepageEntlisttemplateid(showonhomepage, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageEntlisttemplateid(boolean showonhomepage, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavparenttype(boolean showonhomepage, int nestednavparenttype) {
        return findByShowonhomepageNestednavparenttype(showonhomepage, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavparenttype(boolean showonhomepage, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavparentid(boolean showonhomepage, int nestednavparentid) {
        return findByShowonhomepageNestednavparentid(showonhomepage, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavparentid(boolean showonhomepage, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavorder(boolean showonhomepage, int nestednavorder) {
        return findByShowonhomepageNestednavorder(showonhomepage, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageNestednavorder(boolean showonhomepage, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageFieldorder(boolean showonhomepage, String fieldorder) {
        return findByShowonhomepageFieldorder(showonhomepage, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageFieldorder(boolean showonhomepage, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageHiddenfields(boolean showonhomepage, String hiddenfields) {
        return findByShowonhomepageHiddenfields(showonhomepage, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByShowonhomepageHiddenfields(boolean showonhomepage, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidEntlisttemplateid(int maintemplateid, int entlisttemplateid) {
        return findByMaintemplateidEntlisttemplateid(maintemplateid, entlisttemplateid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidEntlisttemplateid(int maintemplateid, int entlisttemplateid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', entlisttemplateid='"+entlisttemplateid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavparenttype(int maintemplateid, int nestednavparenttype) {
        return findByMaintemplateidNestednavparenttype(maintemplateid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavparenttype(int maintemplateid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavparentid(int maintemplateid, int nestednavparentid) {
        return findByMaintemplateidNestednavparentid(maintemplateid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavparentid(int maintemplateid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavorder(int maintemplateid, int nestednavorder) {
        return findByMaintemplateidNestednavorder(maintemplateid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidNestednavorder(int maintemplateid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidFieldorder(int maintemplateid, String fieldorder) {
        return findByMaintemplateidFieldorder(maintemplateid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidFieldorder(int maintemplateid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidHiddenfields(int maintemplateid, String hiddenfields) {
        return findByMaintemplateidHiddenfields(maintemplateid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByMaintemplateidHiddenfields(int maintemplateid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE maintemplateid='"+maintemplateid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavparenttype(int entlisttemplateid, int nestednavparenttype) {
        return findByEntlisttemplateidNestednavparenttype(entlisttemplateid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavparenttype(int entlisttemplateid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavparentid(int entlisttemplateid, int nestednavparentid) {
        return findByEntlisttemplateidNestednavparentid(entlisttemplateid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavparentid(int entlisttemplateid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavorder(int entlisttemplateid, int nestednavorder) {
        return findByEntlisttemplateidNestednavorder(entlisttemplateid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidNestednavorder(int entlisttemplateid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidFieldorder(int entlisttemplateid, String fieldorder) {
        return findByEntlisttemplateidFieldorder(entlisttemplateid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidFieldorder(int entlisttemplateid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidHiddenfields(int entlisttemplateid, String hiddenfields) {
        return findByEntlisttemplateidHiddenfields(entlisttemplateid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByEntlisttemplateidHiddenfields(int entlisttemplateid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE entlisttemplateid='"+entlisttemplateid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid) {
        return findByNestednavparenttypeNestednavparentid(nestednavparenttype, nestednavparentid, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder) {
        return findByNestednavparenttypeNestednavorder(nestednavparenttype, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeFieldorder(int nestednavparenttype, String fieldorder) {
        return findByNestednavparenttypeFieldorder(nestednavparenttype, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeFieldorder(int nestednavparenttype, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparenttype='"+nestednavparenttype+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeHiddenfields(int nestednavparenttype, String hiddenfields) {
        return findByNestednavparenttypeHiddenfields(nestednavparenttype, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparenttypeHiddenfields(int nestednavparenttype, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparenttype='"+nestednavparenttype+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder) {
        return findByNestednavparentidNestednavorder(nestednavparentid, nestednavorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidFieldorder(int nestednavparentid, String fieldorder) {
        return findByNestednavparentidFieldorder(nestednavparentid, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidFieldorder(int nestednavparentid, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparentid='"+nestednavparentid+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidHiddenfields(int nestednavparentid, String hiddenfields) {
        return findByNestednavparentidHiddenfields(nestednavparentid, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavparentidHiddenfields(int nestednavparentid, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavparentid='"+nestednavparentid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavorderFieldorder(int nestednavorder, String fieldorder) {
        return findByNestednavorderFieldorder(nestednavorder, fieldorder, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavorderFieldorder(int nestednavorder, String fieldorder, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavorder='"+nestednavorder+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByNestednavorderHiddenfields(int nestednavorder, String hiddenfields) {
        return findByNestednavorderHiddenfields(nestednavorder, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByNestednavorderHiddenfields(int nestednavorder, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE nestednavorder='"+nestednavorder+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegalogDAO> findByFieldorderHiddenfields(String fieldorder, String hiddenfields) {
        return findByFieldorderHiddenfields(fieldorder, hiddenfields, 0, 50000);
    }

    public static ArrayList<MegalogDAO> findByFieldorderHiddenfields(String fieldorder, String hiddenfields, int limitmin, int limitmax) {
        ArrayList<MegalogDAO> resultarraylist = new ArrayList<MegalogDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegalogDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}