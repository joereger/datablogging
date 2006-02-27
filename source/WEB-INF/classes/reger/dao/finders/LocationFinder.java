package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LocationDAO;

/**
 * Finder for the 'location' DAO
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

public class LocationFinder {


    public static ArrayList<LocationDAO> findByLocationid(int locationid) {
        return findByLocationid(locationid, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationid(int locationid, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationname(String locationname) {
        return findByLocationname(locationname, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationname(String locationname, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdeg(int latdeg) {
        return findByLatdeg(latdeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdeg(int latdeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatmin(int latmin) {
        return findByLatmin(latmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatmin(int latmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsec(int latsec) {
        return findByLatsec(latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsec(int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatns(int latns) {
        return findByLatns(latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatns(int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondeg(int londeg) {
        return findByLondeg(londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondeg(int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonmin(int lonmin) {
        return findByLonmin(lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonmin(int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsec(int lonsec) {
        return findByLonsec(lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsec(int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonew(int lonew) {
        return findByLonew(lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonew(int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCity(String city) {
        return findByCity(city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCity(String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByState(String state) {
        return findByState(state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByState(String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCountry(String country) {
        return findByCountry(country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCountry(String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatitude(double latitude) {
        return findByLatitude(latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatitude(double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLongitude(double longitude) {
        return findByLongitude(longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLongitude(double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLocationname(int locationid, String locationname) {
        return findByLocationidLocationname(locationid, locationname, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLocationname(int locationid, String locationname, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', locationname='"+reger.core.Util.cleanForSQL(locationname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidAccountid(int locationid, int accountid) {
        return findByLocationidAccountid(locationid, accountid, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidAccountid(int locationid, int accountid, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLatdeg(int locationid, int latdeg) {
        return findByLocationidLatdeg(locationid, latdeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLatdeg(int locationid, int latdeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', latdeg='"+latdeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLatmin(int locationid, int latmin) {
        return findByLocationidLatmin(locationid, latmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLatmin(int locationid, int latmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', latmin='"+latmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLatsec(int locationid, int latsec) {
        return findByLocationidLatsec(locationid, latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLatsec(int locationid, int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLatns(int locationid, int latns) {
        return findByLocationidLatns(locationid, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLatns(int locationid, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLondeg(int locationid, int londeg) {
        return findByLocationidLondeg(locationid, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLondeg(int locationid, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLonmin(int locationid, int lonmin) {
        return findByLocationidLonmin(locationid, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLonmin(int locationid, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLonsec(int locationid, int lonsec) {
        return findByLocationidLonsec(locationid, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLonsec(int locationid, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLonew(int locationid, int lonew) {
        return findByLocationidLonew(locationid, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLonew(int locationid, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidCity(int locationid, String city) {
        return findByLocationidCity(locationid, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidCity(int locationid, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidState(int locationid, String state) {
        return findByLocationidState(locationid, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidState(int locationid, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidCountry(int locationid, String country) {
        return findByLocationidCountry(locationid, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidCountry(int locationid, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLatitude(int locationid, double latitude) {
        return findByLocationidLatitude(locationid, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLatitude(int locationid, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationidLongitude(int locationid, double longitude) {
        return findByLocationidLongitude(locationid, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationidLongitude(int locationid, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameAccountid(String locationname, int accountid) {
        return findByLocationnameAccountid(locationname, accountid, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameAccountid(String locationname, int accountid, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLatdeg(String locationname, int latdeg) {
        return findByLocationnameLatdeg(locationname, latdeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLatdeg(String locationname, int latdeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', latdeg='"+latdeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLatmin(String locationname, int latmin) {
        return findByLocationnameLatmin(locationname, latmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLatmin(String locationname, int latmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', latmin='"+latmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLatsec(String locationname, int latsec) {
        return findByLocationnameLatsec(locationname, latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLatsec(String locationname, int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLatns(String locationname, int latns) {
        return findByLocationnameLatns(locationname, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLatns(String locationname, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLondeg(String locationname, int londeg) {
        return findByLocationnameLondeg(locationname, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLondeg(String locationname, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLonmin(String locationname, int lonmin) {
        return findByLocationnameLonmin(locationname, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLonmin(String locationname, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLonsec(String locationname, int lonsec) {
        return findByLocationnameLonsec(locationname, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLonsec(String locationname, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLonew(String locationname, int lonew) {
        return findByLocationnameLonew(locationname, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLonew(String locationname, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameCity(String locationname, String city) {
        return findByLocationnameCity(locationname, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameCity(String locationname, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameState(String locationname, String state) {
        return findByLocationnameState(locationname, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameState(String locationname, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameCountry(String locationname, String country) {
        return findByLocationnameCountry(locationname, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameCountry(String locationname, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLatitude(String locationname, double latitude) {
        return findByLocationnameLatitude(locationname, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLatitude(String locationname, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLocationnameLongitude(String locationname, double longitude) {
        return findByLocationnameLongitude(locationname, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLocationnameLongitude(String locationname, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(locationname)+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLatdeg(int accountid, int latdeg) {
        return findByAccountidLatdeg(accountid, latdeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLatdeg(int accountid, int latdeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', latdeg='"+latdeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLatmin(int accountid, int latmin) {
        return findByAccountidLatmin(accountid, latmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLatmin(int accountid, int latmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', latmin='"+latmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLatsec(int accountid, int latsec) {
        return findByAccountidLatsec(accountid, latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLatsec(int accountid, int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLatns(int accountid, int latns) {
        return findByAccountidLatns(accountid, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLatns(int accountid, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLondeg(int accountid, int londeg) {
        return findByAccountidLondeg(accountid, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLondeg(int accountid, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLonmin(int accountid, int lonmin) {
        return findByAccountidLonmin(accountid, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLonmin(int accountid, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLonsec(int accountid, int lonsec) {
        return findByAccountidLonsec(accountid, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLonsec(int accountid, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLonew(int accountid, int lonew) {
        return findByAccountidLonew(accountid, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLonew(int accountid, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidCity(int accountid, String city) {
        return findByAccountidCity(accountid, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidCity(int accountid, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidState(int accountid, String state) {
        return findByAccountidState(accountid, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidState(int accountid, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidCountry(int accountid, String country) {
        return findByAccountidCountry(accountid, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidCountry(int accountid, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLatitude(int accountid, double latitude) {
        return findByAccountidLatitude(accountid, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLatitude(int accountid, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByAccountidLongitude(int accountid, double longitude) {
        return findByAccountidLongitude(accountid, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByAccountidLongitude(int accountid, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE accountid='"+accountid+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLatmin(int latdeg, int latmin) {
        return findByLatdegLatmin(latdeg, latmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLatmin(int latdeg, int latmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', latmin='"+latmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLatsec(int latdeg, int latsec) {
        return findByLatdegLatsec(latdeg, latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLatsec(int latdeg, int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLatns(int latdeg, int latns) {
        return findByLatdegLatns(latdeg, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLatns(int latdeg, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLondeg(int latdeg, int londeg) {
        return findByLatdegLondeg(latdeg, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLondeg(int latdeg, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLonmin(int latdeg, int lonmin) {
        return findByLatdegLonmin(latdeg, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLonmin(int latdeg, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLonsec(int latdeg, int lonsec) {
        return findByLatdegLonsec(latdeg, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLonsec(int latdeg, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLonew(int latdeg, int lonew) {
        return findByLatdegLonew(latdeg, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLonew(int latdeg, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegCity(int latdeg, String city) {
        return findByLatdegCity(latdeg, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegCity(int latdeg, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegState(int latdeg, String state) {
        return findByLatdegState(latdeg, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegState(int latdeg, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegCountry(int latdeg, String country) {
        return findByLatdegCountry(latdeg, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegCountry(int latdeg, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLatitude(int latdeg, double latitude) {
        return findByLatdegLatitude(latdeg, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLatitude(int latdeg, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatdegLongitude(int latdeg, double longitude) {
        return findByLatdegLongitude(latdeg, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatdegLongitude(int latdeg, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latdeg='"+latdeg+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLatsec(int latmin, int latsec) {
        return findByLatminLatsec(latmin, latsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLatsec(int latmin, int latsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', latsec='"+latsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLatns(int latmin, int latns) {
        return findByLatminLatns(latmin, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLatns(int latmin, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLondeg(int latmin, int londeg) {
        return findByLatminLondeg(latmin, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLondeg(int latmin, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLonmin(int latmin, int lonmin) {
        return findByLatminLonmin(latmin, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLonmin(int latmin, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLonsec(int latmin, int lonsec) {
        return findByLatminLonsec(latmin, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLonsec(int latmin, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLonew(int latmin, int lonew) {
        return findByLatminLonew(latmin, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLonew(int latmin, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminCity(int latmin, String city) {
        return findByLatminCity(latmin, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminCity(int latmin, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminState(int latmin, String state) {
        return findByLatminState(latmin, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminState(int latmin, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminCountry(int latmin, String country) {
        return findByLatminCountry(latmin, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminCountry(int latmin, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLatitude(int latmin, double latitude) {
        return findByLatminLatitude(latmin, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLatitude(int latmin, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatminLongitude(int latmin, double longitude) {
        return findByLatminLongitude(latmin, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatminLongitude(int latmin, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latmin='"+latmin+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLatns(int latsec, int latns) {
        return findByLatsecLatns(latsec, latns, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLatns(int latsec, int latns, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', latns='"+latns+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLondeg(int latsec, int londeg) {
        return findByLatsecLondeg(latsec, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLondeg(int latsec, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLonmin(int latsec, int lonmin) {
        return findByLatsecLonmin(latsec, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLonmin(int latsec, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLonsec(int latsec, int lonsec) {
        return findByLatsecLonsec(latsec, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLonsec(int latsec, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLonew(int latsec, int lonew) {
        return findByLatsecLonew(latsec, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLonew(int latsec, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecCity(int latsec, String city) {
        return findByLatsecCity(latsec, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecCity(int latsec, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecState(int latsec, String state) {
        return findByLatsecState(latsec, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecState(int latsec, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecCountry(int latsec, String country) {
        return findByLatsecCountry(latsec, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecCountry(int latsec, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLatitude(int latsec, double latitude) {
        return findByLatsecLatitude(latsec, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLatitude(int latsec, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatsecLongitude(int latsec, double longitude) {
        return findByLatsecLongitude(latsec, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatsecLongitude(int latsec, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latsec='"+latsec+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLondeg(int latns, int londeg) {
        return findByLatnsLondeg(latns, londeg, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLondeg(int latns, int londeg, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', londeg='"+londeg+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLonmin(int latns, int lonmin) {
        return findByLatnsLonmin(latns, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLonmin(int latns, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLonsec(int latns, int lonsec) {
        return findByLatnsLonsec(latns, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLonsec(int latns, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLonew(int latns, int lonew) {
        return findByLatnsLonew(latns, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLonew(int latns, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsCity(int latns, String city) {
        return findByLatnsCity(latns, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsCity(int latns, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsState(int latns, String state) {
        return findByLatnsState(latns, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsState(int latns, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsCountry(int latns, String country) {
        return findByLatnsCountry(latns, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsCountry(int latns, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLatitude(int latns, double latitude) {
        return findByLatnsLatitude(latns, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLatitude(int latns, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatnsLongitude(int latns, double longitude) {
        return findByLatnsLongitude(latns, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatnsLongitude(int latns, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latns='"+latns+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegLonmin(int londeg, int lonmin) {
        return findByLondegLonmin(londeg, lonmin, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegLonmin(int londeg, int lonmin, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', lonmin='"+lonmin+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegLonsec(int londeg, int lonsec) {
        return findByLondegLonsec(londeg, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegLonsec(int londeg, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegLonew(int londeg, int lonew) {
        return findByLondegLonew(londeg, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegLonew(int londeg, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegCity(int londeg, String city) {
        return findByLondegCity(londeg, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegCity(int londeg, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegState(int londeg, String state) {
        return findByLondegState(londeg, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegState(int londeg, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegCountry(int londeg, String country) {
        return findByLondegCountry(londeg, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegCountry(int londeg, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegLatitude(int londeg, double latitude) {
        return findByLondegLatitude(londeg, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegLatitude(int londeg, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLondegLongitude(int londeg, double longitude) {
        return findByLondegLongitude(londeg, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLondegLongitude(int londeg, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE londeg='"+londeg+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminLonsec(int lonmin, int lonsec) {
        return findByLonminLonsec(lonmin, lonsec, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminLonsec(int lonmin, int lonsec, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', lonsec='"+lonsec+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminLonew(int lonmin, int lonew) {
        return findByLonminLonew(lonmin, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminLonew(int lonmin, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminCity(int lonmin, String city) {
        return findByLonminCity(lonmin, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminCity(int lonmin, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminState(int lonmin, String state) {
        return findByLonminState(lonmin, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminState(int lonmin, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminCountry(int lonmin, String country) {
        return findByLonminCountry(lonmin, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminCountry(int lonmin, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminLatitude(int lonmin, double latitude) {
        return findByLonminLatitude(lonmin, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminLatitude(int lonmin, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonminLongitude(int lonmin, double longitude) {
        return findByLonminLongitude(lonmin, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonminLongitude(int lonmin, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonmin='"+lonmin+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecLonew(int lonsec, int lonew) {
        return findByLonsecLonew(lonsec, lonew, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecLonew(int lonsec, int lonew, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', lonew='"+lonew+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecCity(int lonsec, String city) {
        return findByLonsecCity(lonsec, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecCity(int lonsec, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecState(int lonsec, String state) {
        return findByLonsecState(lonsec, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecState(int lonsec, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecCountry(int lonsec, String country) {
        return findByLonsecCountry(lonsec, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecCountry(int lonsec, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecLatitude(int lonsec, double latitude) {
        return findByLonsecLatitude(lonsec, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecLatitude(int lonsec, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonsecLongitude(int lonsec, double longitude) {
        return findByLonsecLongitude(lonsec, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonsecLongitude(int lonsec, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonsec='"+lonsec+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonewCity(int lonew, String city) {
        return findByLonewCity(lonew, city, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonewCity(int lonew, String city, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"', city='"+reger.core.Util.cleanForSQL(city)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonewState(int lonew, String state) {
        return findByLonewState(lonew, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonewState(int lonew, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonewCountry(int lonew, String country) {
        return findByLonewCountry(lonew, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonewCountry(int lonew, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonewLatitude(int lonew, double latitude) {
        return findByLonewLatitude(lonew, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonewLatitude(int lonew, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLonewLongitude(int lonew, double longitude) {
        return findByLonewLongitude(lonew, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLonewLongitude(int lonew, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE lonew='"+lonew+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCityState(String city, String state) {
        return findByCityState(city, state, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCityState(String city, String state, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE city='"+reger.core.Util.cleanForSQL(city)+"', state='"+reger.core.Util.cleanForSQL(state)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCityCountry(String city, String country) {
        return findByCityCountry(city, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCityCountry(String city, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE city='"+reger.core.Util.cleanForSQL(city)+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCityLatitude(String city, double latitude) {
        return findByCityLatitude(city, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCityLatitude(String city, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE city='"+reger.core.Util.cleanForSQL(city)+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCityLongitude(String city, double longitude) {
        return findByCityLongitude(city, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCityLongitude(String city, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE city='"+reger.core.Util.cleanForSQL(city)+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByStateCountry(String state, String country) {
        return findByStateCountry(state, country, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByStateCountry(String state, String country, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE state='"+reger.core.Util.cleanForSQL(state)+"', country='"+reger.core.Util.cleanForSQL(country)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByStateLatitude(String state, double latitude) {
        return findByStateLatitude(state, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByStateLatitude(String state, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE state='"+reger.core.Util.cleanForSQL(state)+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByStateLongitude(String state, double longitude) {
        return findByStateLongitude(state, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByStateLongitude(String state, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE state='"+reger.core.Util.cleanForSQL(state)+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCountryLatitude(String country, double latitude) {
        return findByCountryLatitude(country, latitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCountryLatitude(String country, double latitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE country='"+reger.core.Util.cleanForSQL(country)+"', latitude='"+String.valueOf(latitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByCountryLongitude(String country, double longitude) {
        return findByCountryLongitude(country, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByCountryLongitude(String country, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE country='"+reger.core.Util.cleanForSQL(country)+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LocationDAO> findByLatitudeLongitude(double latitude, double longitude) {
        return findByLatitudeLongitude(latitude, longitude, 0, 50000);
    }

    public static ArrayList<LocationDAO> findByLatitudeLongitude(double latitude, double longitude, int limitmin, int limitmax) {
        ArrayList<LocationDAO> resultarraylist = new ArrayList<LocationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE latitude='"+String.valueOf(latitude)+"', longitude='"+String.valueOf(longitude)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LocationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}