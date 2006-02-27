package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LinkroteventlookupDAO;

/**
 * Finder for the 'linkroteventlookup' DAO
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

public class LinkroteventlookupFinder {


    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupid(int linkroteventlookupid) {
        return findByLinkroteventlookupid(linkroteventlookupid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupid(int linkroteventlookupid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkrotid(int linkrotid) {
        return findByLinkrotid(linkrotid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkrotid(int linkrotid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkrotid='"+linkrotid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkroteventlookupDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupidLinkrotid(int linkroteventlookupid, int linkrotid) {
        return findByLinkroteventlookupidLinkrotid(linkroteventlookupid, linkrotid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupidLinkrotid(int linkroteventlookupid, int linkrotid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"', linkrotid='"+linkrotid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupidEventid(int linkroteventlookupid, int eventid) {
        return findByLinkroteventlookupidEventid(linkroteventlookupid, eventid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkroteventlookupidEventid(int linkroteventlookupid, int eventid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkrotidEventid(int linkrotid, int eventid) {
        return findByLinkrotidEventid(linkrotid, eventid, 0, 50000);
    }

    public static ArrayList<LinkroteventlookupDAO> findByLinkrotidEventid(int linkrotid, int eventid, int limitmin, int limitmax) {
        ArrayList<LinkroteventlookupDAO> resultarraylist = new ArrayList<LinkroteventlookupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkrotid='"+linkrotid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LinkroteventlookupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}