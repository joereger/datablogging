package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.CatDAO;

/**
 * Finder for the 'cat' DAO
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

public class CatFinder {


    public static ArrayList<CatDAO> findByCatid(int catid) {
        return findByCatid(catid, 0, 50000);
    }

    public static ArrayList<CatDAO> findByCatid(int catid, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE catid='"+catid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<CatDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findBySex(String sex) {
        return findBySex(sex, 0, 50000);
    }

    public static ArrayList<CatDAO> findBySex(String sex, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE sex='"+reger.core.Util.cleanForSQL(sex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByWeight(double weight) {
        return findByWeight(weight, 0, 50000);
    }

    public static ArrayList<CatDAO> findByWeight(double weight, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE weight='"+String.valueOf(weight)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByCatidName(int catid, String name) {
        return findByCatidName(catid, name, 0, 50000);
    }

    public static ArrayList<CatDAO> findByCatidName(int catid, String name, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE catid='"+catid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByCatidSex(int catid, String sex) {
        return findByCatidSex(catid, sex, 0, 50000);
    }

    public static ArrayList<CatDAO> findByCatidSex(int catid, String sex, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE catid='"+catid+"', sex='"+reger.core.Util.cleanForSQL(sex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByCatidWeight(int catid, double weight) {
        return findByCatidWeight(catid, weight, 0, 50000);
    }

    public static ArrayList<CatDAO> findByCatidWeight(int catid, double weight, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE catid='"+catid+"', weight='"+String.valueOf(weight)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByNameSex(String name, String sex) {
        return findByNameSex(name, sex, 0, 50000);
    }

    public static ArrayList<CatDAO> findByNameSex(String name, String sex, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE name='"+reger.core.Util.cleanForSQL(name)+"', sex='"+reger.core.Util.cleanForSQL(sex)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findByNameWeight(String name, double weight) {
        return findByNameWeight(name, weight, 0, 50000);
    }

    public static ArrayList<CatDAO> findByNameWeight(String name, double weight, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE name='"+reger.core.Util.cleanForSQL(name)+"', weight='"+String.valueOf(weight)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<CatDAO> findBySexWeight(String sex, double weight) {
        return findBySexWeight(sex, weight, 0, 50000);
    }

    public static ArrayList<CatDAO> findBySexWeight(String sex, double weight, int limitmin, int limitmax) {
        ArrayList<CatDAO> resultarraylist = new ArrayList<CatDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT catid FROM cat WHERE sex='"+reger.core.Util.cleanForSQL(sex)+"', weight='"+String.valueOf(weight)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new CatDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}