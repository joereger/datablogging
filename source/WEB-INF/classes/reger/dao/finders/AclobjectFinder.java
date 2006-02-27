package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AclobjectDAO;

/**
 * Finder for the 'aclobject' DAO
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

public class AclobjectFinder {


    public static ArrayList<AclobjectDAO> findByAclobjectid(int aclobjectid) {
        return findByAclobjectid(aclobjectid, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectid(int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectname(String aclobjectname) {
        return findByAclobjectname(aclobjectname, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectname(String aclobjectname, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectname='"+reger.core.Util.cleanForSQL(aclobjectname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclfriendlyname(String aclfriendlyname) {
        return findByAclfriendlyname(aclfriendlyname, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclfriendlyname(String aclfriendlyname, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclfriendlyname='"+reger.core.Util.cleanForSQL(aclfriendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAcldesc(String acldesc) {
        return findByAcldesc(acldesc, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAcldesc(String acldesc, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE acldesc='"+reger.core.Util.cleanForSQL(acldesc)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAclobjectname(int aclobjectid, String aclobjectname) {
        return findByAclobjectidAclobjectname(aclobjectid, aclobjectname, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAclobjectname(int aclobjectid, String aclobjectname, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectid='"+aclobjectid+"', aclobjectname='"+reger.core.Util.cleanForSQL(aclobjectname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAclfriendlyname(int aclobjectid, String aclfriendlyname) {
        return findByAclobjectidAclfriendlyname(aclobjectid, aclfriendlyname, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAclfriendlyname(int aclobjectid, String aclfriendlyname, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectid='"+aclobjectid+"', aclfriendlyname='"+reger.core.Util.cleanForSQL(aclfriendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAcldesc(int aclobjectid, String acldesc) {
        return findByAclobjectidAcldesc(aclobjectid, acldesc, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectidAcldesc(int aclobjectid, String acldesc, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectid='"+aclobjectid+"', acldesc='"+reger.core.Util.cleanForSQL(acldesc)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectnameAclfriendlyname(String aclobjectname, String aclfriendlyname) {
        return findByAclobjectnameAclfriendlyname(aclobjectname, aclfriendlyname, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectnameAclfriendlyname(String aclobjectname, String aclfriendlyname, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectname='"+reger.core.Util.cleanForSQL(aclobjectname)+"', aclfriendlyname='"+reger.core.Util.cleanForSQL(aclfriendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclobjectnameAcldesc(String aclobjectname, String acldesc) {
        return findByAclobjectnameAcldesc(aclobjectname, acldesc, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclobjectnameAcldesc(String aclobjectname, String acldesc, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectname='"+reger.core.Util.cleanForSQL(aclobjectname)+"', acldesc='"+reger.core.Util.cleanForSQL(acldesc)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclobjectDAO> findByAclfriendlynameAcldesc(String aclfriendlyname, String acldesc) {
        return findByAclfriendlynameAcldesc(aclfriendlyname, acldesc, 0, 50000);
    }

    public static ArrayList<AclobjectDAO> findByAclfriendlynameAcldesc(String aclfriendlyname, String acldesc, int limitmin, int limitmax) {
        ArrayList<AclobjectDAO> resultarraylist = new ArrayList<AclobjectDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclfriendlyname='"+reger.core.Util.cleanForSQL(aclfriendlyname)+"', acldesc='"+reger.core.Util.cleanForSQL(acldesc)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclobjectDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}