package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegafieldparamDAO;

/**
 * Finder for the 'megafieldparam' DAO
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

public class MegafieldparamFinder {


    public static ArrayList<MegafieldparamDAO> findByMegafieldparamid(int megafieldparamid) {
        return findByMegafieldparamid(megafieldparamid, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamid(int megafieldparamid, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekey(String oneworddatabasekey) {
        return findByOneworddatabasekey(oneworddatabasekey, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekey(String oneworddatabasekey, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE oneworddatabasekey='"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByValue(String value) {
        return findByValue(value, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByValue(String value, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE value='"+reger.core.Util.cleanForSQL(value)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidOneworddatabasekey(int megafieldparamid, String oneworddatabasekey) {
        return findByMegafieldparamidOneworddatabasekey(megafieldparamid, oneworddatabasekey, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidOneworddatabasekey(int megafieldparamid, String oneworddatabasekey, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"', oneworddatabasekey='"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidMegafieldid(int megafieldparamid, int megafieldid) {
        return findByMegafieldparamidMegafieldid(megafieldparamid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidMegafieldid(int megafieldparamid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidValue(int megafieldparamid, String value) {
        return findByMegafieldparamidValue(megafieldparamid, value, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldparamidValue(int megafieldparamid, String value, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"', value='"+reger.core.Util.cleanForSQL(value)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekeyMegafieldid(String oneworddatabasekey, int megafieldid) {
        return findByOneworddatabasekeyMegafieldid(oneworddatabasekey, megafieldid, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekeyMegafieldid(String oneworddatabasekey, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE oneworddatabasekey='"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekeyValue(String oneworddatabasekey, String value) {
        return findByOneworddatabasekeyValue(oneworddatabasekey, value, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByOneworddatabasekeyValue(String oneworddatabasekey, String value, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE oneworddatabasekey='"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"', value='"+reger.core.Util.cleanForSQL(value)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldidValue(int megafieldid, String value) {
        return findByMegafieldidValue(megafieldid, value, 0, 50000);
    }

    public static ArrayList<MegafieldparamDAO> findByMegafieldidValue(int megafieldid, String value, int limitmin, int limitmax) {
        ArrayList<MegafieldparamDAO> resultarraylist = new ArrayList<MegafieldparamDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldid='"+megafieldid+"', value='"+reger.core.Util.cleanForSQL(value)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegafieldparamDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}