package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.HelpDAO;

/**
 * Finder for the 'help' DAO
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

public class HelpFinder {


    public static ArrayList<HelpDAO> findByHelpid(int helpid) {
        return findByHelpid(helpid, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpid(int helpid, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpkey(String helpkey) {
        return findByHelpkey(helpkey, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpkey(String helpkey, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpsection(int helpsection) {
        return findByHelpsection(helpsection, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpsection(int helpsection, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpsection='"+helpsection+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByTitle(String title) {
        return findByTitle(title, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByTitle(String title, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByBody(String body) {
        return findByBody(body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByBody(String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpidHelpkey(int helpid, String helpkey) {
        return findByHelpidHelpkey(helpid, helpkey, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpidHelpkey(int helpid, String helpkey, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"', helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpidHelpsection(int helpid, int helpsection) {
        return findByHelpidHelpsection(helpid, helpsection, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpidHelpsection(int helpid, int helpsection, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"', helpsection='"+helpsection+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpidEventtypeid(int helpid, int eventtypeid) {
        return findByHelpidEventtypeid(helpid, eventtypeid, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpidEventtypeid(int helpid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpidTitle(int helpid, String title) {
        return findByHelpidTitle(helpid, title, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpidTitle(int helpid, String title, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpidBody(int helpid, String body) {
        return findByHelpidBody(helpid, body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpidBody(int helpid, String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"', body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpkeyHelpsection(String helpkey, int helpsection) {
        return findByHelpkeyHelpsection(helpkey, helpsection, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpkeyHelpsection(String helpkey, int helpsection, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"', helpsection='"+helpsection+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpkeyEventtypeid(String helpkey, int eventtypeid) {
        return findByHelpkeyEventtypeid(helpkey, eventtypeid, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpkeyEventtypeid(String helpkey, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpkeyTitle(String helpkey, String title) {
        return findByHelpkeyTitle(helpkey, title, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpkeyTitle(String helpkey, String title, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpkeyBody(String helpkey, String body) {
        return findByHelpkeyBody(helpkey, body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpkeyBody(String helpkey, String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"', body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpsectionEventtypeid(int helpsection, int eventtypeid) {
        return findByHelpsectionEventtypeid(helpsection, eventtypeid, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpsectionEventtypeid(int helpsection, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpsection='"+helpsection+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpsectionTitle(int helpsection, String title) {
        return findByHelpsectionTitle(helpsection, title, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpsectionTitle(int helpsection, String title, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpsection='"+helpsection+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByHelpsectionBody(int helpsection, String body) {
        return findByHelpsectionBody(helpsection, body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByHelpsectionBody(int helpsection, String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpsection='"+helpsection+"', body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByEventtypeidTitle(int eventtypeid, String title) {
        return findByEventtypeidTitle(eventtypeid, title, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByEventtypeidTitle(int eventtypeid, String title, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE eventtypeid='"+eventtypeid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByEventtypeidBody(int eventtypeid, String body) {
        return findByEventtypeidBody(eventtypeid, body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByEventtypeidBody(int eventtypeid, String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE eventtypeid='"+eventtypeid+"', body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<HelpDAO> findByTitleBody(String title, String body) {
        return findByTitleBody(title, body, 0, 50000);
    }

    public static ArrayList<HelpDAO> findByTitleBody(String title, String body, int limitmin, int limitmax) {
        ArrayList<HelpDAO> resultarraylist = new ArrayList<HelpDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE title='"+reger.core.Util.cleanForSQL(title)+"', body='"+reger.core.Util.cleanForSQL(body)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new HelpDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}