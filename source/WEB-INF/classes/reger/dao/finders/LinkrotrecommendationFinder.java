package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LinkrotrecommendationDAO;

/**
 * Finder for the 'linkrotrecommendation' DAO
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

public class LinkrotrecommendationFinder {


    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationid(int linkrotrecommendationid) {
        return findByLinkrotrecommendationid(linkrotrecommendationid, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationid(int linkrotrecommendationid, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotid(int linkrotid) {
        return findByLinkrotid(linkrotid, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotid(int linkrotid, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotid='"+linkrotid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findBySource(String source) {
        return findBySource(source, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findBySource(String source, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE source='"+reger.core.Util.cleanForSQL(source)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidLinkrotid(int linkrotrecommendationid, int linkrotid) {
        return findByLinkrotrecommendationidLinkrotid(linkrotrecommendationid, linkrotid, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidLinkrotid(int linkrotrecommendationid, int linkrotid, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"', linkrotid='"+linkrotid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidUrl(int linkrotrecommendationid, String url) {
        return findByLinkrotrecommendationidUrl(linkrotrecommendationid, url, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidUrl(int linkrotrecommendationid, String url, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidSource(int linkrotrecommendationid, String source) {
        return findByLinkrotrecommendationidSource(linkrotrecommendationid, source, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotrecommendationidSource(int linkrotrecommendationid, String source, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"', source='"+reger.core.Util.cleanForSQL(source)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotidUrl(int linkrotid, String url) {
        return findByLinkrotidUrl(linkrotid, url, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotidUrl(int linkrotid, String url, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotid='"+linkrotid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotidSource(int linkrotid, String source) {
        return findByLinkrotidSource(linkrotid, source, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByLinkrotidSource(int linkrotid, String source, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotid='"+linkrotid+"', source='"+reger.core.Util.cleanForSQL(source)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkrotrecommendationDAO> findByUrlSource(String url, String source) {
        return findByUrlSource(url, source, 0, 50000);
    }

    public static ArrayList<LinkrotrecommendationDAO> findByUrlSource(String url, String source, int limitmin, int limitmax) {
        ArrayList<LinkrotrecommendationDAO> resultarraylist = new ArrayList<LinkrotrecommendationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE url='"+reger.core.Util.cleanForSQL(url)+"', source='"+reger.core.Util.cleanForSQL(source)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkrotrecommendationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}