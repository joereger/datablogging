package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegachartyaxisDAO;

/**
 * Finder for the 'megachartyaxis' DAO
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

public class MegachartyaxisFinder {


    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisid(int megachartyaxisid) {
        return findByMegachartyaxisid(megachartyaxisid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisid(int megachartyaxisid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartid(int megachartid) {
        return findByMegachartid(megachartid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartid(int megachartid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartid='"+megachartid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldid(int ymegafieldid) {
        return findByYmegafieldid(ymegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldid(int ymegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE ymegafieldid='"+ymegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYlogid(int ylogid) {
        return findByYlogid(ylogid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYlogid(int ylogid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE ylogid='"+ylogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYeventtypeid(int yeventtypeid) {
        return findByYeventtypeid(yeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYeventtypeid(int yeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE yeventtypeid='"+yeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidMegachartid(int megachartyaxisid, int megachartid) {
        return findByMegachartyaxisidMegachartid(megachartyaxisid, megachartid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidMegachartid(int megachartyaxisid, int megachartid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"', megachartid='"+megachartid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYmegafieldid(int megachartyaxisid, int ymegafieldid) {
        return findByMegachartyaxisidYmegafieldid(megachartyaxisid, ymegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYmegafieldid(int megachartyaxisid, int ymegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"', ymegafieldid='"+ymegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYlogid(int megachartyaxisid, int ylogid) {
        return findByMegachartyaxisidYlogid(megachartyaxisid, ylogid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYlogid(int megachartyaxisid, int ylogid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"', ylogid='"+ylogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYeventtypeid(int megachartyaxisid, int yeventtypeid) {
        return findByMegachartyaxisidYeventtypeid(megachartyaxisid, yeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartyaxisidYeventtypeid(int megachartyaxisid, int yeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"', yeventtypeid='"+yeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYmegafieldid(int megachartid, int ymegafieldid) {
        return findByMegachartidYmegafieldid(megachartid, ymegafieldid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYmegafieldid(int megachartid, int ymegafieldid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartid='"+megachartid+"', ymegafieldid='"+ymegafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYlogid(int megachartid, int ylogid) {
        return findByMegachartidYlogid(megachartid, ylogid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYlogid(int megachartid, int ylogid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartid='"+megachartid+"', ylogid='"+ylogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYeventtypeid(int megachartid, int yeventtypeid) {
        return findByMegachartidYeventtypeid(megachartid, yeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByMegachartidYeventtypeid(int megachartid, int yeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartid='"+megachartid+"', yeventtypeid='"+yeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldidYlogid(int ymegafieldid, int ylogid) {
        return findByYmegafieldidYlogid(ymegafieldid, ylogid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldidYlogid(int ymegafieldid, int ylogid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE ymegafieldid='"+ymegafieldid+"', ylogid='"+ylogid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldidYeventtypeid(int ymegafieldid, int yeventtypeid) {
        return findByYmegafieldidYeventtypeid(ymegafieldid, yeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYmegafieldidYeventtypeid(int ymegafieldid, int yeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE ymegafieldid='"+ymegafieldid+"', yeventtypeid='"+yeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegachartyaxisDAO> findByYlogidYeventtypeid(int ylogid, int yeventtypeid) {
        return findByYlogidYeventtypeid(ylogid, yeventtypeid, 0, 50000);
    }

    public static ArrayList<MegachartyaxisDAO> findByYlogidYeventtypeid(int ylogid, int yeventtypeid, int limitmin, int limitmax) {
        ArrayList<MegachartyaxisDAO> resultarraylist = new ArrayList<MegachartyaxisDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE ylogid='"+ylogid+"', yeventtypeid='"+yeventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegachartyaxisDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}