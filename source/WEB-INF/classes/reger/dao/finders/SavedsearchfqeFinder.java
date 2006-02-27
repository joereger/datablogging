package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SavedsearchfqeDAO;

/**
 * Finder for the 'savedsearchfqe' DAO
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

public class SavedsearchfqeFinder {


    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeid(int savedsearchfqeid) {
        return findBySavedsearchfqeid(savedsearchfqeid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeid(int savedsearchfqeid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamname(String paramname) {
        return findByParamname(paramname, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamname(String paramname, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE paramname='"+reger.core.Util.cleanForSQL(paramname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamvalue(String paramvalue) {
        return findByParamvalue(paramvalue, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamvalue(String paramvalue, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchid(int savedsearchid) {
        return findBySavedsearchid(savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchid(int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidMegafieldid(int savedsearchfqeid, int megafieldid) {
        return findBySavedsearchfqeidMegafieldid(savedsearchfqeid, megafieldid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidMegafieldid(int savedsearchfqeid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidParamname(int savedsearchfqeid, String paramname) {
        return findBySavedsearchfqeidParamname(savedsearchfqeid, paramname, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidParamname(int savedsearchfqeid, String paramname, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"', paramname='"+reger.core.Util.cleanForSQL(paramname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidParamvalue(int savedsearchfqeid, String paramvalue) {
        return findBySavedsearchfqeidParamvalue(savedsearchfqeid, paramvalue, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidParamvalue(int savedsearchfqeid, String paramvalue, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"', paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidSavedsearchid(int savedsearchfqeid, int savedsearchid) {
        return findBySavedsearchfqeidSavedsearchid(savedsearchfqeid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findBySavedsearchfqeidSavedsearchid(int savedsearchfqeid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidParamname(int megafieldid, String paramname) {
        return findByMegafieldidParamname(megafieldid, paramname, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidParamname(int megafieldid, String paramname, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE megafieldid='"+megafieldid+"', paramname='"+reger.core.Util.cleanForSQL(paramname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidParamvalue(int megafieldid, String paramvalue) {
        return findByMegafieldidParamvalue(megafieldid, paramvalue, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidParamvalue(int megafieldid, String paramvalue, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE megafieldid='"+megafieldid+"', paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidSavedsearchid(int megafieldid, int savedsearchid) {
        return findByMegafieldidSavedsearchid(megafieldid, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByMegafieldidSavedsearchid(int megafieldid, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE megafieldid='"+megafieldid+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamnameParamvalue(String paramname, String paramvalue) {
        return findByParamnameParamvalue(paramname, paramvalue, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamnameParamvalue(String paramname, String paramvalue, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE paramname='"+reger.core.Util.cleanForSQL(paramname)+"', paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamnameSavedsearchid(String paramname, int savedsearchid) {
        return findByParamnameSavedsearchid(paramname, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamnameSavedsearchid(String paramname, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE paramname='"+reger.core.Util.cleanForSQL(paramname)+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamvalueSavedsearchid(String paramvalue, int savedsearchid) {
        return findByParamvalueSavedsearchid(paramvalue, savedsearchid, 0, 50000);
    }

    public static ArrayList<SavedsearchfqeDAO> findByParamvalueSavedsearchid(String paramvalue, int savedsearchid, int limitmin, int limitmax) {
        ArrayList<SavedsearchfqeDAO> resultarraylist = new ArrayList<SavedsearchfqeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"', savedsearchid='"+savedsearchid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SavedsearchfqeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}