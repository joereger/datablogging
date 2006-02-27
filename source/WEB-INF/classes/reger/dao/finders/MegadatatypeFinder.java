package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegadatatypeDAO;

/**
 * Finder for the 'megadatatype' DAO
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

public class MegadatatypeFinder {


    public static ArrayList<MegadatatypeDAO> findByMegadatatypeid(int megadatatypeid) {
        return findByMegadatatypeid(megadatatypeid, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypeid(int megadatatypeid, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypename(String megadatatypename) {
        return findByMegadatatypename(megadatatypename, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypename(String megadatatypename, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypename='"+reger.core.Util.cleanForSQL(megadatatypename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypedescription(String megadatatypedescription) {
        return findByMegadatatypedescription(megadatatypedescription, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypedescription(String megadatatypedescription, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypedescription='"+reger.core.Util.cleanForSQL(megadatatypedescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypeidMegadatatypename(int megadatatypeid, String megadatatypename) {
        return findByMegadatatypeidMegadatatypename(megadatatypeid, megadatatypename, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypeidMegadatatypename(int megadatatypeid, String megadatatypename, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"', megadatatypename='"+reger.core.Util.cleanForSQL(megadatatypename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypeidMegadatatypedescription(int megadatatypeid, String megadatatypedescription) {
        return findByMegadatatypeidMegadatatypedescription(megadatatypeid, megadatatypedescription, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypeidMegadatatypedescription(int megadatatypeid, String megadatatypedescription, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"', megadatatypedescription='"+reger.core.Util.cleanForSQL(megadatatypedescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypenameMegadatatypedescription(String megadatatypename, String megadatatypedescription) {
        return findByMegadatatypenameMegadatatypedescription(megadatatypename, megadatatypedescription, 0, 50000);
    }

    public static ArrayList<MegadatatypeDAO> findByMegadatatypenameMegadatatypedescription(String megadatatypename, String megadatatypedescription, int limitmin, int limitmax) {
        ArrayList<MegadatatypeDAO> resultarraylist = new ArrayList<MegadatatypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypename='"+reger.core.Util.cleanForSQL(megadatatypename)+"', megadatatypedescription='"+reger.core.Util.cleanForSQL(megadatatypedescription)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegadatatypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}