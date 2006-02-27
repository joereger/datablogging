package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FavesiteDAO;

/**
 * Finder for the 'favesite' DAO
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

public class FavesiteFinder {


    public static ArrayList<FavesiteDAO> findByFavesiteid(int favesiteid) {
        return findByFavesiteid(favesiteid, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByFavesiteid(int favesiteid, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE favesiteid='"+favesiteid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidName(int favesiteid, String name) {
        return findByFavesiteidName(favesiteid, name, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidName(int favesiteid, String name, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE favesiteid='"+favesiteid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidUrl(int favesiteid, String url) {
        return findByFavesiteidUrl(favesiteid, url, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidUrl(int favesiteid, String url, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE favesiteid='"+favesiteid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidAccountid(int favesiteid, int accountid) {
        return findByFavesiteidAccountid(favesiteid, accountid, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByFavesiteidAccountid(int favesiteid, int accountid, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE favesiteid='"+favesiteid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByNameUrl(String name, String url) {
        return findByNameUrl(name, url, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByNameUrl(String name, String url, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE name='"+reger.core.Util.cleanForSQL(name)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByNameAccountid(String name, int accountid) {
        return findByNameAccountid(name, accountid, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByNameAccountid(String name, int accountid, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FavesiteDAO> findByUrlAccountid(String url, int accountid) {
        return findByUrlAccountid(url, accountid, 0, 50000);
    }

    public static ArrayList<FavesiteDAO> findByUrlAccountid(String url, int accountid, int limitmin, int limitmax) {
        ArrayList<FavesiteDAO> resultarraylist = new ArrayList<FavesiteDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE url='"+reger.core.Util.cleanForSQL(url)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FavesiteDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}