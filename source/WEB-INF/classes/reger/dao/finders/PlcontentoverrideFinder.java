package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PlcontentoverrideDAO;

/**
 * Finder for the 'plcontentoverride' DAO
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

public class PlcontentoverrideFinder {


    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideid(int plcontentoverrideid) {
        return findByPlcontentoverrideid(plcontentoverrideid, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideid(int plcontentoverrideid, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPljspidtooverride(int pljspidtooverride) {
        return findByPljspidtooverride(pljspidtooverride, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPljspidtooverride(int pljspidtooverride, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE pljspidtooverride='"+pljspidtooverride+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByContent(String content) {
        return findByContent(content, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByContent(String content, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidPlid(int plcontentoverrideid, int plid) {
        return findByPlcontentoverrideidPlid(plcontentoverrideid, plid, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidPlid(int plcontentoverrideid, int plid, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidPljspidtooverride(int plcontentoverrideid, int pljspidtooverride) {
        return findByPlcontentoverrideidPljspidtooverride(plcontentoverrideid, pljspidtooverride, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidPljspidtooverride(int plcontentoverrideid, int pljspidtooverride, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"', pljspidtooverride='"+pljspidtooverride+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidContent(int plcontentoverrideid, String content) {
        return findByPlcontentoverrideidContent(plcontentoverrideid, content, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlcontentoverrideidContent(int plcontentoverrideid, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlidPljspidtooverride(int plid, int pljspidtooverride) {
        return findByPlidPljspidtooverride(plid, pljspidtooverride, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlidPljspidtooverride(int plid, int pljspidtooverride, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plid='"+plid+"', pljspidtooverride='"+pljspidtooverride+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlidContent(int plid, String content) {
        return findByPlidContent(plid, content, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPlidContent(int plid, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plid='"+plid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentoverrideDAO> findByPljspidtooverrideContent(int pljspidtooverride, String content) {
        return findByPljspidtooverrideContent(pljspidtooverride, content, 0, 50000);
    }

    public static ArrayList<PlcontentoverrideDAO> findByPljspidtooverrideContent(int pljspidtooverride, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentoverrideDAO> resultarraylist = new ArrayList<PlcontentoverrideDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE pljspidtooverride='"+pljspidtooverride+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentoverrideDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}