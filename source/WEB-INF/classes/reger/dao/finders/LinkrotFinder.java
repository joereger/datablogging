package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LinkrotDAO;

/**
 * Finder for the 'linkrot' DAO
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

public class LinkrotFinder {


    public static ArrayList<LinkrotDAO> findByLinkrotid(int linkrotid) {
        return findByLinkrotid(linkrotid, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotid(int linkrotid, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByKeywords(String keywords) {
        return findByKeywords(keywords, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByKeywords(String keywords, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE keywords='"+reger.core.Util.cleanForSQL(keywords)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddate(java.util.Calendar lastcheckeddate) {
        return findByLastcheckeddate(lastcheckeddate, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddate(java.util.Calendar lastcheckeddate, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByIsbroken(boolean isbroken) {
        return findByIsbroken(isbroken, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByIsbroken(boolean isbroken, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByHttpstatuscode(int httpstatuscode) {
        return findByHttpstatuscode(httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByHttpstatuscode(int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidUrl(int linkrotid, String url) {
        return findByLinkrotidUrl(linkrotid, url, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidUrl(int linkrotid, String url, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidKeywords(int linkrotid, String keywords) {
        return findByLinkrotidKeywords(linkrotid, keywords, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidKeywords(int linkrotid, String keywords, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"', keywords='"+reger.core.Util.cleanForSQL(keywords)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidLastcheckeddate(int linkrotid, java.util.Calendar lastcheckeddate) {
        return findByLinkrotidLastcheckeddate(linkrotid, lastcheckeddate, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidLastcheckeddate(int linkrotid, java.util.Calendar lastcheckeddate, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"', lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidIsbroken(int linkrotid, boolean isbroken) {
        return findByLinkrotidIsbroken(linkrotid, isbroken, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidIsbroken(int linkrotid, boolean isbroken, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"', isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidHttpstatuscode(int linkrotid, int httpstatuscode) {
        return findByLinkrotidHttpstatuscode(linkrotid, httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLinkrotidHttpstatuscode(int linkrotid, int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"', httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByUrlKeywords(String url, String keywords) {
        return findByUrlKeywords(url, keywords, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByUrlKeywords(String url, String keywords, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"', keywords='"+reger.core.Util.cleanForSQL(keywords)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByUrlLastcheckeddate(String url, java.util.Calendar lastcheckeddate) {
        return findByUrlLastcheckeddate(url, lastcheckeddate, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByUrlLastcheckeddate(String url, java.util.Calendar lastcheckeddate, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"', lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByUrlIsbroken(String url, boolean isbroken) {
        return findByUrlIsbroken(url, isbroken, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByUrlIsbroken(String url, boolean isbroken, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"', isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByUrlHttpstatuscode(String url, int httpstatuscode) {
        return findByUrlHttpstatuscode(url, httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByUrlHttpstatuscode(String url, int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE url='"+reger.core.Util.cleanForSQL(url)+"', httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByKeywordsLastcheckeddate(String keywords, java.util.Calendar lastcheckeddate) {
        return findByKeywordsLastcheckeddate(keywords, lastcheckeddate, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByKeywordsLastcheckeddate(String keywords, java.util.Calendar lastcheckeddate, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE keywords='"+reger.core.Util.cleanForSQL(keywords)+"', lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByKeywordsIsbroken(String keywords, boolean isbroken) {
        return findByKeywordsIsbroken(keywords, isbroken, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByKeywordsIsbroken(String keywords, boolean isbroken, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE keywords='"+reger.core.Util.cleanForSQL(keywords)+"', isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByKeywordsHttpstatuscode(String keywords, int httpstatuscode) {
        return findByKeywordsHttpstatuscode(keywords, httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByKeywordsHttpstatuscode(String keywords, int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE keywords='"+reger.core.Util.cleanForSQL(keywords)+"', httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddateIsbroken(java.util.Calendar lastcheckeddate, boolean isbroken) {
        return findByLastcheckeddateIsbroken(lastcheckeddate, isbroken, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddateIsbroken(java.util.Calendar lastcheckeddate, boolean isbroken, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"', isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddateHttpstatuscode(java.util.Calendar lastcheckeddate, int httpstatuscode) {
        return findByLastcheckeddateHttpstatuscode(lastcheckeddate, httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByLastcheckeddateHttpstatuscode(java.util.Calendar lastcheckeddate, int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"', httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotDAO> findByIsbrokenHttpstatuscode(boolean isbroken, int httpstatuscode) {
        return findByIsbrokenHttpstatuscode(isbroken, httpstatuscode, 0, 50000);
    }

    public static ArrayList<LinkrotDAO> findByIsbrokenHttpstatuscode(boolean isbroken, int httpstatuscode, int limitmin, int limitmax) {
        ArrayList<LinkrotDAO> resultarraylist = new ArrayList<LinkrotDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"', httpstatuscode='"+httpstatuscode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}