package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EpisodeDAO;

/**
 * Finder for the 'episode' DAO
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

public class EpisodeFinder {


    public static ArrayList<EpisodeDAO> findByEpisodeid(int episodeid) {
        return findByEpisodeid(episodeid, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByEpisodeid(int episodeid, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByIsprivate(boolean isprivate) {
        return findByIsprivate(isprivate, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByIsprivate(boolean isprivate, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidName(int episodeid, String name) {
        return findByEpisodeidName(episodeid, name, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidName(int episodeid, String name, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidAccountid(int episodeid, int accountid) {
        return findByEpisodeidAccountid(episodeid, accountid, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidAccountid(int episodeid, int accountid, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidDescription(int episodeid, String description) {
        return findByEpisodeidDescription(episodeid, description, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidDescription(int episodeid, String description, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidIsprivate(int episodeid, boolean isprivate) {
        return findByEpisodeidIsprivate(episodeid, isprivate, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByEpisodeidIsprivate(int episodeid, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByNameAccountid(String name, int accountid) {
        return findByNameAccountid(name, accountid, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByNameAccountid(String name, int accountid, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByNameDescription(String name, String description) {
        return findByNameDescription(name, description, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByNameDescription(String name, String description, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE name='"+reger.core.Util.cleanForSQL(name)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByNameIsprivate(String name, boolean isprivate) {
        return findByNameIsprivate(name, isprivate, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByNameIsprivate(String name, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE name='"+reger.core.Util.cleanForSQL(name)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByAccountidDescription(int accountid, String description) {
        return findByAccountidDescription(accountid, description, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByAccountidDescription(int accountid, String description, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE accountid='"+accountid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByAccountidIsprivate(int accountid, boolean isprivate) {
        return findByAccountidIsprivate(accountid, isprivate, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByAccountidIsprivate(int accountid, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE accountid='"+accountid+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EpisodeDAO> findByDescriptionIsprivate(String description, boolean isprivate) {
        return findByDescriptionIsprivate(description, isprivate, 0, 50000);
    }

    public static ArrayList<EpisodeDAO> findByDescriptionIsprivate(String description, boolean isprivate, int limitmin, int limitmax) {
        ArrayList<EpisodeDAO> resultarraylist = new ArrayList<EpisodeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EpisodeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}