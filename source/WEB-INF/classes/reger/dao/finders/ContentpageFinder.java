package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.ContentpageDAO;

/**
 * Finder for the 'contentpage' DAO
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

public class ContentpageFinder {


    public static ArrayList<ContentpageDAO> findByContentpageid(int contentpageid) {
        return findByContentpageid(contentpageid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageid(int contentpageid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContent(String content) {
        return findByContent(content, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContent(String content, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttype(int nestednavparenttype) {
        return findByNestednavparenttype(nestednavparenttype, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttype(int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentid(int nestednavparentid) {
        return findByNestednavparentid(nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentid(int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavorder(int nestednavorder) {
        return findByNestednavorder(nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavorder(int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findBySizeinbytes(int sizeinbytes) {
        return findBySizeinbytes(sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findBySizeinbytes(int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidAccountid(int contentpageid, int accountid) {
        return findByContentpageidAccountid(contentpageid, accountid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidAccountid(int contentpageid, int accountid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidName(int contentpageid, String name) {
        return findByContentpageidName(contentpageid, name, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidName(int contentpageid, String name, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidContent(int contentpageid, String content) {
        return findByContentpageidContent(contentpageid, content, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidContent(int contentpageid, String content, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavparenttype(int contentpageid, int nestednavparenttype) {
        return findByContentpageidNestednavparenttype(contentpageid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavparenttype(int contentpageid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavparentid(int contentpageid, int nestednavparentid) {
        return findByContentpageidNestednavparentid(contentpageid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavparentid(int contentpageid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavorder(int contentpageid, int nestednavorder) {
        return findByContentpageidNestednavorder(contentpageid, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidNestednavorder(int contentpageid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentpageidSizeinbytes(int contentpageid, int sizeinbytes) {
        return findByContentpageidSizeinbytes(contentpageid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentpageidSizeinbytes(int contentpageid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidName(int accountid, String name) {
        return findByAccountidName(accountid, name, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidName(int accountid, String name, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidContent(int accountid, String content) {
        return findByAccountidContent(accountid, content, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidContent(int accountid, String content, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavparenttype(int accountid, int nestednavparenttype) {
        return findByAccountidNestednavparenttype(accountid, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavparenttype(int accountid, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavparentid(int accountid, int nestednavparentid) {
        return findByAccountidNestednavparentid(accountid, nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavparentid(int accountid, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavorder(int accountid, int nestednavorder) {
        return findByAccountidNestednavorder(accountid, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidNestednavorder(int accountid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByAccountidSizeinbytes(int accountid, int sizeinbytes) {
        return findByAccountidSizeinbytes(accountid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByAccountidSizeinbytes(int accountid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNameContent(String name, String content) {
        return findByNameContent(name, content, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNameContent(String name, String content, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavparenttype(String name, int nestednavparenttype) {
        return findByNameNestednavparenttype(name, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavparenttype(String name, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavparentid(String name, int nestednavparentid) {
        return findByNameNestednavparentid(name, nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavparentid(String name, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavorder(String name, int nestednavorder) {
        return findByNameNestednavorder(name, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNameNestednavorder(String name, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNameSizeinbytes(String name, int sizeinbytes) {
        return findByNameSizeinbytes(name, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNameSizeinbytes(String name, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE name='"+reger.core.Util.cleanForSQL(name)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavparenttype(String content, int nestednavparenttype) {
        return findByContentNestednavparenttype(content, nestednavparenttype, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavparenttype(String content, int nestednavparenttype, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavparentid(String content, int nestednavparentid) {
        return findByContentNestednavparentid(content, nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavparentid(String content, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavorder(String content, int nestednavorder) {
        return findByContentNestednavorder(content, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentNestednavorder(String content, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByContentSizeinbytes(String content, int sizeinbytes) {
        return findByContentSizeinbytes(content, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByContentSizeinbytes(String content, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE content='"+reger.core.Util.cleanForSQL(content)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid) {
        return findByNestednavparenttypeNestednavparentid(nestednavparenttype, nestednavparentid, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeNestednavparentid(int nestednavparenttype, int nestednavparentid, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder) {
        return findByNestednavparenttypeNestednavorder(nestednavparenttype, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeNestednavorder(int nestednavparenttype, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparenttype='"+nestednavparenttype+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeSizeinbytes(int nestednavparenttype, int sizeinbytes) {
        return findByNestednavparenttypeSizeinbytes(nestednavparenttype, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparenttypeSizeinbytes(int nestednavparenttype, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparenttype='"+nestednavparenttype+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder) {
        return findByNestednavparentidNestednavorder(nestednavparentid, nestednavorder, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentidNestednavorder(int nestednavparentid, int nestednavorder, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentidSizeinbytes(int nestednavparentid, int sizeinbytes) {
        return findByNestednavparentidSizeinbytes(nestednavparentid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavparentidSizeinbytes(int nestednavparentid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavparentid='"+nestednavparentid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<ContentpageDAO> findByNestednavorderSizeinbytes(int nestednavorder, int sizeinbytes) {
        return findByNestednavorderSizeinbytes(nestednavorder, sizeinbytes, 0, 50000);
    }

    public static ArrayList<ContentpageDAO> findByNestednavorderSizeinbytes(int nestednavorder, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<ContentpageDAO> resultarraylist = new ArrayList<ContentpageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE nestednavorder='"+nestednavorder+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new ContentpageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}