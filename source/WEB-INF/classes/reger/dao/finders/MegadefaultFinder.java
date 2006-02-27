package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegadefaultDAO;

/**
 * Finder for the 'megadefault' DAO
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

public class MegadefaultFinder {


    public static ArrayList<MegadefaultDAO> findByMegadefaultid(int megadefaultid) {
        return findByMegadefaultid(megadefaultid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultid(int megadefaultid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefault(String megadefault) {
        return findByMegadefault(megadefault, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefault(String megadefault, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultextended(String megadefaultextended) {
        return findByMegadefaultextended(megadefaultextended, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultextended(String megadefaultextended, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidLogid(int megadefaultid, int logid) {
        return findByMegadefaultidLogid(megadefaultid, logid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidLogid(int megadefaultid, int logid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegafieldid(int megadefaultid, int megafieldid) {
        return findByMegadefaultidMegafieldid(megadefaultid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegafieldid(int megadefaultid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegadefault(int megadefaultid, String megadefault) {
        return findByMegadefaultidMegadefault(megadefaultid, megadefault, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegadefault(int megadefaultid, String megadefault, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"', megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegadefaultextended(int megadefaultid, String megadefaultextended) {
        return findByMegadefaultidMegadefaultextended(megadefaultid, megadefaultextended, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultidMegadefaultextended(int megadefaultid, String megadefaultextended, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"', megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegafieldid(int logid, int megafieldid) {
        return findByLogidMegafieldid(logid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegafieldid(int logid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE logid='"+logid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegadefault(int logid, String megadefault) {
        return findByLogidMegadefault(logid, megadefault, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegadefault(int logid, String megadefault, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE logid='"+logid+"', megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegadefaultextended(int logid, String megadefaultextended) {
        return findByLogidMegadefaultextended(logid, megadefaultextended, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByLogidMegadefaultextended(int logid, String megadefaultextended, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE logid='"+logid+"', megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldidMegadefault(int megafieldid, String megadefault) {
        return findByMegafieldidMegadefault(megafieldid, megadefault, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldidMegadefault(int megafieldid, String megadefault, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megafieldid='"+megafieldid+"', megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldidMegadefaultextended(int megafieldid, String megadefaultextended) {
        return findByMegafieldidMegadefaultextended(megafieldid, megadefaultextended, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegafieldidMegadefaultextended(int megafieldid, String megadefaultextended, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megafieldid='"+megafieldid+"', megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultMegadefaultextended(String megadefault, String megadefaultextended) {
        return findByMegadefaultMegadefaultextended(megadefault, megadefaultextended, 0, 50000);
    }

    public static ArrayList<MegadefaultDAO> findByMegadefaultMegadefaultextended(String megadefault, String megadefaultextended, int limitmin, int limitmax) {
        ArrayList<MegadefaultDAO> resultarraylist = new ArrayList<MegadefaultDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"', megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadefaultDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}