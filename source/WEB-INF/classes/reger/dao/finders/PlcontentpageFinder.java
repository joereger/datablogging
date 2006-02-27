package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PlcontentpageDAO;

/**
 * Finder for the 'plcontentpage' DAO
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

public class PlcontentpageFinder {


    public static ArrayList<PlcontentpageDAO> findByPlcontentpageid(int plcontentpageid) {
        return findByPlcontentpageid(plcontentpageid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageid(int plcontentpageid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByContent(String content) {
        return findByContent(content, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByContent(String content, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttype(int nestednavparenttype) {
        return findByNestednavparenttype(nestednavparenttype, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttype(int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparentid(int nestednavparentid) {
        return findByNestednavparentid(nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparentid(int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavorder(int nestednavorder) {
        return findByNestednavorder(nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavorder(int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidPlid(int plcontentpageid, int plid) {
        return findByPlcontentpageidPlid(plcontentpageid, plid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidPlid(int plcontentpageid, int plid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidName(int plcontentpageid, String name) {
        return findByPlcontentpageidName(plcontentpageid, name, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidName(int plcontentpageid, String name, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidContent(int plcontentpageid, String content) {
        return findByPlcontentpageidContent(plcontentpageid, content, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidContent(int plcontentpageid, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavparenttype(int plcontentpageid, int nestednavparenttype) {
        return findByPlcontentpageidNestednavparenttype(plcontentpageid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavparenttype(int plcontentpageid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavparentid(int plcontentpageid, int nestednavparentid) {
        return findByPlcontentpageidNestednavparentid(plcontentpageid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavparentid(int plcontentpageid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavorder(int plcontentpageid, int nestednavorder) {
        return findByPlcontentpageidNestednavorder(plcontentpageid, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlcontentpageidNestednavorder(int plcontentpageid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlidName(int plid, String name) {
        return findByPlidName(plid, name, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlidName(int plid, String name, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlidContent(int plid, String content) {
        return findByPlidContent(plid, content, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlidContent(int plid, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavparenttype(int plid, int nestednavparenttype) {
        return findByPlidNestednavparenttype(plid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavparenttype(int plid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavparentid(int plid, int nestednavparentid) {
        return findByPlidNestednavparentid(plid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavparentid(int plid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavorder(int plid, int nestednavorder) {
        return findByPlidNestednavorder(plid, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByPlidNestednavorder(int plid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNameContent(String name, String content) {
        return findByNameContent(name, content, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNameContent(String name, String content, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavparenttype(String name, int nestednavparenttype) {
        return findByNameNestednavparenttype(name, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavparenttype(String name, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavparentid(String name, int nestednavparentid) {
        return findByNameNestednavparentid(name, nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavparentid(String name, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavorder(String name, int nestednavorder) {
        return findByNameNestednavorder(name, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNameNestednavorder(String name, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavparenttype(String content, int nestednavparenttype) {
        return findByContentNestednavparenttype(content, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavparenttype(String content, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavparentid(String content, int nestednavparentid) {
        return findByContentNestednavparentid(content, nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavparentid(String content, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavorder(String content, int nestednavorder) {
        return findByContentNestednavorder(content, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByContentNestednavorder(String content, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid) {
        return findByNestednavparenttypeNestednavparentid(nestednavparenttype, nestednavparentid, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder) {
        return findByNestednavparenttypeNestednavorder(nestednavparenttype, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder) {
        return findByNestednavparentidNestednavorder(nestednavparentid, nestednavorder, 0, 50000);
    }

    public static ArrayList<PlcontentpageDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<PlcontentpageDAO> resultarraylist = new ArrayList<PlcontentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PlcontentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}