package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EventDAO;

/**
 * Finder for the 'event' DAO
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

public class EventFinder {


    public static ArrayList<EventDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeid(int eventtypeid) {
        return findByEventtypeid(eventtypeid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeid(int eventtypeid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationid(int locationid) {
        return findByLocationid(locationid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationid(int locationid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedate(java.util.Calendar createdate) {
        return findByCreatedate(createdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedate(java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitle(String title) {
        return findByTitle(title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitle(String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByComments(String comments) {
        return findByComments(comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByComments(String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraft(boolean isdraft) {
        return findByIsdraft(isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraft(boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavorite(boolean favorite) {
        return findByFavorite(favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavorite(boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytes(int sizeinbytes) {
        return findBySizeinbytes(sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytes(int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporary(boolean istemporary) {
        return findByIstemporary(istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporary(boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsmoderatorapproved(boolean ismoderatorapproved) {
        return findByIsmoderatorapproved(ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsmoderatorapproved(boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdate(java.util.Calendar lastmodifiedbyuserdate) {
        return findByLastmodifiedbyuserdate(lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdate(java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderator(boolean isflaggedformoderator) {
        return findByIsflaggedformoderator(isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderator(boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByRequiresmoderatorapproval(boolean requiresmoderatorapproval) {
        return findByRequiresmoderatorapproval(requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByRequiresmoderatorapproval(boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEntrykey(String entrykey) {
        return findByEntrykey(entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEntrykey(String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidEventtypeid(int eventid, int eventtypeid) {
        return findByEventidEventtypeid(eventid, eventtypeid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidEventtypeid(int eventid, int eventtypeid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', eventtypeid='"+eventtypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidLocationid(int eventid, int locationid) {
        return findByEventidLocationid(eventid, locationid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidLocationid(int eventid, int locationid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidCreatedate(int eventid, java.util.Calendar createdate) {
        return findByEventidCreatedate(eventid, createdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidCreatedate(int eventid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidDate(int eventid, java.util.Calendar date) {
        return findByEventidDate(eventid, date, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidDate(int eventid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidTitle(int eventid, String title) {
        return findByEventidTitle(eventid, title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidTitle(int eventid, String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidComments(int eventid, String comments) {
        return findByEventidComments(eventid, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidComments(int eventid, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidAccountid(int eventid, int accountid) {
        return findByEventidAccountid(eventid, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidAccountid(int eventid, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidLogid(int eventid, int logid) {
        return findByEventidLogid(eventid, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidLogid(int eventid, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidAccountuserid(int eventid, int accountuserid) {
        return findByEventidAccountuserid(eventid, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidAccountuserid(int eventid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidIsdraft(int eventid, boolean isdraft) {
        return findByEventidIsdraft(eventid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidIsdraft(int eventid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidIsapproved(int eventid, boolean isapproved) {
        return findByEventidIsapproved(eventid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidIsapproved(int eventid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidFavorite(int eventid, boolean favorite) {
        return findByEventidFavorite(eventid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidFavorite(int eventid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes) {
        return findByEventidSizeinbytes(eventid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidIstemporary(int eventid, boolean istemporary) {
        return findByEventidIstemporary(eventid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidIstemporary(int eventid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidIsmoderatorapproved(int eventid, boolean ismoderatorapproved) {
        return findByEventidIsmoderatorapproved(eventid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidIsmoderatorapproved(int eventid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidLastmodifiedbyuserdate(int eventid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByEventidLastmodifiedbyuserdate(eventid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidLastmodifiedbyuserdate(int eventid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidIsflaggedformoderator(int eventid, boolean isflaggedformoderator) {
        return findByEventidIsflaggedformoderator(eventid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidIsflaggedformoderator(int eventid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidRequiresmoderatorapproval(int eventid, boolean requiresmoderatorapproval) {
        return findByEventidRequiresmoderatorapproval(eventid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidRequiresmoderatorapproval(int eventid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventidEntrykey(int eventid, String entrykey) {
        return findByEventidEntrykey(eventid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventidEntrykey(int eventid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidLocationid(int eventtypeid, int locationid) {
        return findByEventtypeidLocationid(eventtypeid, locationid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidLocationid(int eventtypeid, int locationid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', locationid='"+locationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidCreatedate(int eventtypeid, java.util.Calendar createdate) {
        return findByEventtypeidCreatedate(eventtypeid, createdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidCreatedate(int eventtypeid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidDate(int eventtypeid, java.util.Calendar date) {
        return findByEventtypeidDate(eventtypeid, date, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidDate(int eventtypeid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidTitle(int eventtypeid, String title) {
        return findByEventtypeidTitle(eventtypeid, title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidTitle(int eventtypeid, String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidComments(int eventtypeid, String comments) {
        return findByEventtypeidComments(eventtypeid, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidComments(int eventtypeid, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidAccountid(int eventtypeid, int accountid) {
        return findByEventtypeidAccountid(eventtypeid, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidAccountid(int eventtypeid, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidLogid(int eventtypeid, int logid) {
        return findByEventtypeidLogid(eventtypeid, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidLogid(int eventtypeid, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidAccountuserid(int eventtypeid, int accountuserid) {
        return findByEventtypeidAccountuserid(eventtypeid, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidAccountuserid(int eventtypeid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidIsdraft(int eventtypeid, boolean isdraft) {
        return findByEventtypeidIsdraft(eventtypeid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidIsdraft(int eventtypeid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidIsapproved(int eventtypeid, boolean isapproved) {
        return findByEventtypeidIsapproved(eventtypeid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidIsapproved(int eventtypeid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidFavorite(int eventtypeid, boolean favorite) {
        return findByEventtypeidFavorite(eventtypeid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidFavorite(int eventtypeid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidSizeinbytes(int eventtypeid, int sizeinbytes) {
        return findByEventtypeidSizeinbytes(eventtypeid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidSizeinbytes(int eventtypeid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidIstemporary(int eventtypeid, boolean istemporary) {
        return findByEventtypeidIstemporary(eventtypeid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidIstemporary(int eventtypeid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidIsmoderatorapproved(int eventtypeid, boolean ismoderatorapproved) {
        return findByEventtypeidIsmoderatorapproved(eventtypeid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidIsmoderatorapproved(int eventtypeid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidLastmodifiedbyuserdate(int eventtypeid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByEventtypeidLastmodifiedbyuserdate(eventtypeid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidLastmodifiedbyuserdate(int eventtypeid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidIsflaggedformoderator(int eventtypeid, boolean isflaggedformoderator) {
        return findByEventtypeidIsflaggedformoderator(eventtypeid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidIsflaggedformoderator(int eventtypeid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidRequiresmoderatorapproval(int eventtypeid, boolean requiresmoderatorapproval) {
        return findByEventtypeidRequiresmoderatorapproval(eventtypeid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidRequiresmoderatorapproval(int eventtypeid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByEventtypeidEntrykey(int eventtypeid, String entrykey) {
        return findByEventtypeidEntrykey(eventtypeid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByEventtypeidEntrykey(int eventtypeid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventtypeid='"+eventtypeid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidCreatedate(int locationid, java.util.Calendar createdate) {
        return findByLocationidCreatedate(locationid, createdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidCreatedate(int locationid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidDate(int locationid, java.util.Calendar date) {
        return findByLocationidDate(locationid, date, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidDate(int locationid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidTitle(int locationid, String title) {
        return findByLocationidTitle(locationid, title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidTitle(int locationid, String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidComments(int locationid, String comments) {
        return findByLocationidComments(locationid, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidComments(int locationid, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidAccountid(int locationid, int accountid) {
        return findByLocationidAccountid(locationid, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidAccountid(int locationid, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidLogid(int locationid, int logid) {
        return findByLocationidLogid(locationid, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidLogid(int locationid, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidAccountuserid(int locationid, int accountuserid) {
        return findByLocationidAccountuserid(locationid, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidAccountuserid(int locationid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidIsdraft(int locationid, boolean isdraft) {
        return findByLocationidIsdraft(locationid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidIsdraft(int locationid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidIsapproved(int locationid, boolean isapproved) {
        return findByLocationidIsapproved(locationid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidIsapproved(int locationid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidFavorite(int locationid, boolean favorite) {
        return findByLocationidFavorite(locationid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidFavorite(int locationid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidSizeinbytes(int locationid, int sizeinbytes) {
        return findByLocationidSizeinbytes(locationid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidSizeinbytes(int locationid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidIstemporary(int locationid, boolean istemporary) {
        return findByLocationidIstemporary(locationid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidIstemporary(int locationid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidIsmoderatorapproved(int locationid, boolean ismoderatorapproved) {
        return findByLocationidIsmoderatorapproved(locationid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidIsmoderatorapproved(int locationid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidLastmodifiedbyuserdate(int locationid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByLocationidLastmodifiedbyuserdate(locationid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidLastmodifiedbyuserdate(int locationid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidIsflaggedformoderator(int locationid, boolean isflaggedformoderator) {
        return findByLocationidIsflaggedformoderator(locationid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidIsflaggedformoderator(int locationid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidRequiresmoderatorapproval(int locationid, boolean requiresmoderatorapproval) {
        return findByLocationidRequiresmoderatorapproval(locationid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidRequiresmoderatorapproval(int locationid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLocationidEntrykey(int locationid, String entrykey) {
        return findByLocationidEntrykey(locationid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLocationidEntrykey(int locationid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE locationid='"+locationid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateDate(java.util.Calendar createdate, java.util.Calendar date) {
        return findByCreatedateDate(createdate, date, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateDate(java.util.Calendar createdate, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateTitle(java.util.Calendar createdate, String title) {
        return findByCreatedateTitle(createdate, title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateTitle(java.util.Calendar createdate, String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateComments(java.util.Calendar createdate, String comments) {
        return findByCreatedateComments(createdate, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateComments(java.util.Calendar createdate, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateAccountid(java.util.Calendar createdate, int accountid) {
        return findByCreatedateAccountid(createdate, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateAccountid(java.util.Calendar createdate, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateLogid(java.util.Calendar createdate, int logid) {
        return findByCreatedateLogid(createdate, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateLogid(java.util.Calendar createdate, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateAccountuserid(java.util.Calendar createdate, int accountuserid) {
        return findByCreatedateAccountuserid(createdate, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateAccountuserid(java.util.Calendar createdate, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateIsdraft(java.util.Calendar createdate, boolean isdraft) {
        return findByCreatedateIsdraft(createdate, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateIsdraft(java.util.Calendar createdate, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateIsapproved(java.util.Calendar createdate, boolean isapproved) {
        return findByCreatedateIsapproved(createdate, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateIsapproved(java.util.Calendar createdate, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateFavorite(java.util.Calendar createdate, boolean favorite) {
        return findByCreatedateFavorite(createdate, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateFavorite(java.util.Calendar createdate, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateSizeinbytes(java.util.Calendar createdate, int sizeinbytes) {
        return findByCreatedateSizeinbytes(createdate, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateSizeinbytes(java.util.Calendar createdate, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateIstemporary(java.util.Calendar createdate, boolean istemporary) {
        return findByCreatedateIstemporary(createdate, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateIstemporary(java.util.Calendar createdate, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateIsmoderatorapproved(java.util.Calendar createdate, boolean ismoderatorapproved) {
        return findByCreatedateIsmoderatorapproved(createdate, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateIsmoderatorapproved(java.util.Calendar createdate, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateLastmodifiedbyuserdate(java.util.Calendar createdate, java.util.Calendar lastmodifiedbyuserdate) {
        return findByCreatedateLastmodifiedbyuserdate(createdate, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateLastmodifiedbyuserdate(java.util.Calendar createdate, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateIsflaggedformoderator(java.util.Calendar createdate, boolean isflaggedformoderator) {
        return findByCreatedateIsflaggedformoderator(createdate, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateIsflaggedformoderator(java.util.Calendar createdate, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateRequiresmoderatorapproval(java.util.Calendar createdate, boolean requiresmoderatorapproval) {
        return findByCreatedateRequiresmoderatorapproval(createdate, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateRequiresmoderatorapproval(java.util.Calendar createdate, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCreatedateEntrykey(java.util.Calendar createdate, String entrykey) {
        return findByCreatedateEntrykey(createdate, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCreatedateEntrykey(java.util.Calendar createdate, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateTitle(java.util.Calendar date, String title) {
        return findByDateTitle(date, title, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateTitle(java.util.Calendar date, String title, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', title='"+reger.core.Util.cleanForSQL(title)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateComments(java.util.Calendar date, String comments) {
        return findByDateComments(date, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateComments(java.util.Calendar date, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateAccountid(java.util.Calendar date, int accountid) {
        return findByDateAccountid(date, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateAccountid(java.util.Calendar date, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateLogid(java.util.Calendar date, int logid) {
        return findByDateLogid(date, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateLogid(java.util.Calendar date, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateAccountuserid(java.util.Calendar date, int accountuserid) {
        return findByDateAccountuserid(date, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateAccountuserid(java.util.Calendar date, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateIsdraft(java.util.Calendar date, boolean isdraft) {
        return findByDateIsdraft(date, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateIsdraft(java.util.Calendar date, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateIsapproved(java.util.Calendar date, boolean isapproved) {
        return findByDateIsapproved(date, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateIsapproved(java.util.Calendar date, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateFavorite(java.util.Calendar date, boolean favorite) {
        return findByDateFavorite(date, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateFavorite(java.util.Calendar date, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateSizeinbytes(java.util.Calendar date, int sizeinbytes) {
        return findByDateSizeinbytes(date, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateSizeinbytes(java.util.Calendar date, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateIstemporary(java.util.Calendar date, boolean istemporary) {
        return findByDateIstemporary(date, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateIstemporary(java.util.Calendar date, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateIsmoderatorapproved(java.util.Calendar date, boolean ismoderatorapproved) {
        return findByDateIsmoderatorapproved(date, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateIsmoderatorapproved(java.util.Calendar date, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateLastmodifiedbyuserdate(java.util.Calendar date, java.util.Calendar lastmodifiedbyuserdate) {
        return findByDateLastmodifiedbyuserdate(date, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateLastmodifiedbyuserdate(java.util.Calendar date, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateIsflaggedformoderator(java.util.Calendar date, boolean isflaggedformoderator) {
        return findByDateIsflaggedformoderator(date, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateIsflaggedformoderator(java.util.Calendar date, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateRequiresmoderatorapproval(java.util.Calendar date, boolean requiresmoderatorapproval) {
        return findByDateRequiresmoderatorapproval(date, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateRequiresmoderatorapproval(java.util.Calendar date, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByDateEntrykey(java.util.Calendar date, String entrykey) {
        return findByDateEntrykey(date, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByDateEntrykey(java.util.Calendar date, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleComments(String title, String comments) {
        return findByTitleComments(title, comments, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleComments(String title, String comments, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', comments='"+reger.core.Util.cleanForSQL(comments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleAccountid(String title, int accountid) {
        return findByTitleAccountid(title, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleAccountid(String title, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleLogid(String title, int logid) {
        return findByTitleLogid(title, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleLogid(String title, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleAccountuserid(String title, int accountuserid) {
        return findByTitleAccountuserid(title, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleAccountuserid(String title, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleIsdraft(String title, boolean isdraft) {
        return findByTitleIsdraft(title, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleIsdraft(String title, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleIsapproved(String title, boolean isapproved) {
        return findByTitleIsapproved(title, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleIsapproved(String title, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleFavorite(String title, boolean favorite) {
        return findByTitleFavorite(title, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleFavorite(String title, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleSizeinbytes(String title, int sizeinbytes) {
        return findByTitleSizeinbytes(title, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleSizeinbytes(String title, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleIstemporary(String title, boolean istemporary) {
        return findByTitleIstemporary(title, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleIstemporary(String title, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleIsmoderatorapproved(String title, boolean ismoderatorapproved) {
        return findByTitleIsmoderatorapproved(title, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleIsmoderatorapproved(String title, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleLastmodifiedbyuserdate(String title, java.util.Calendar lastmodifiedbyuserdate) {
        return findByTitleLastmodifiedbyuserdate(title, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleLastmodifiedbyuserdate(String title, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleIsflaggedformoderator(String title, boolean isflaggedformoderator) {
        return findByTitleIsflaggedformoderator(title, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleIsflaggedformoderator(String title, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleRequiresmoderatorapproval(String title, boolean requiresmoderatorapproval) {
        return findByTitleRequiresmoderatorapproval(title, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleRequiresmoderatorapproval(String title, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByTitleEntrykey(String title, String entrykey) {
        return findByTitleEntrykey(title, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByTitleEntrykey(String title, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE title='"+reger.core.Util.cleanForSQL(title)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsAccountid(String comments, int accountid) {
        return findByCommentsAccountid(comments, accountid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsAccountid(String comments, int accountid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsLogid(String comments, int logid) {
        return findByCommentsLogid(comments, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsLogid(String comments, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsAccountuserid(String comments, int accountuserid) {
        return findByCommentsAccountuserid(comments, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsAccountuserid(String comments, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsIsdraft(String comments, boolean isdraft) {
        return findByCommentsIsdraft(comments, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsIsdraft(String comments, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsIsapproved(String comments, boolean isapproved) {
        return findByCommentsIsapproved(comments, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsIsapproved(String comments, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsFavorite(String comments, boolean favorite) {
        return findByCommentsFavorite(comments, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsFavorite(String comments, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsSizeinbytes(String comments, int sizeinbytes) {
        return findByCommentsSizeinbytes(comments, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsSizeinbytes(String comments, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsIstemporary(String comments, boolean istemporary) {
        return findByCommentsIstemporary(comments, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsIstemporary(String comments, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsIsmoderatorapproved(String comments, boolean ismoderatorapproved) {
        return findByCommentsIsmoderatorapproved(comments, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsIsmoderatorapproved(String comments, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsLastmodifiedbyuserdate(String comments, java.util.Calendar lastmodifiedbyuserdate) {
        return findByCommentsLastmodifiedbyuserdate(comments, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsLastmodifiedbyuserdate(String comments, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsIsflaggedformoderator(String comments, boolean isflaggedformoderator) {
        return findByCommentsIsflaggedformoderator(comments, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsIsflaggedformoderator(String comments, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsRequiresmoderatorapproval(String comments, boolean requiresmoderatorapproval) {
        return findByCommentsRequiresmoderatorapproval(comments, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsRequiresmoderatorapproval(String comments, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByCommentsEntrykey(String comments, String entrykey) {
        return findByCommentsEntrykey(comments, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByCommentsEntrykey(String comments, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE comments='"+reger.core.Util.cleanForSQL(comments)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidLogid(int accountid, int logid) {
        return findByAccountidLogid(accountid, logid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidLogid(int accountid, int logid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidAccountuserid(int accountid, int accountuserid) {
        return findByAccountidAccountuserid(accountid, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidAccountuserid(int accountid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidIsdraft(int accountid, boolean isdraft) {
        return findByAccountidIsdraft(accountid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidIsdraft(int accountid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidIsapproved(int accountid, boolean isapproved) {
        return findByAccountidIsapproved(accountid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidIsapproved(int accountid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidFavorite(int accountid, boolean favorite) {
        return findByAccountidFavorite(accountid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidFavorite(int accountid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidSizeinbytes(int accountid, int sizeinbytes) {
        return findByAccountidSizeinbytes(accountid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidSizeinbytes(int accountid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidIstemporary(int accountid, boolean istemporary) {
        return findByAccountidIstemporary(accountid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidIstemporary(int accountid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidIsmoderatorapproved(int accountid, boolean ismoderatorapproved) {
        return findByAccountidIsmoderatorapproved(accountid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidIsmoderatorapproved(int accountid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidLastmodifiedbyuserdate(int accountid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByAccountidLastmodifiedbyuserdate(accountid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidLastmodifiedbyuserdate(int accountid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidIsflaggedformoderator(int accountid, boolean isflaggedformoderator) {
        return findByAccountidIsflaggedformoderator(accountid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidIsflaggedformoderator(int accountid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidRequiresmoderatorapproval(int accountid, boolean requiresmoderatorapproval) {
        return findByAccountidRequiresmoderatorapproval(accountid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidRequiresmoderatorapproval(int accountid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountidEntrykey(int accountid, String entrykey) {
        return findByAccountidEntrykey(accountid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountidEntrykey(int accountid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+accountid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidAccountuserid(int logid, int accountuserid) {
        return findByLogidAccountuserid(logid, accountuserid, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidAccountuserid(int logid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidIsdraft(int logid, boolean isdraft) {
        return findByLogidIsdraft(logid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidIsdraft(int logid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidIsapproved(int logid, boolean isapproved) {
        return findByLogidIsapproved(logid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidIsapproved(int logid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidFavorite(int logid, boolean favorite) {
        return findByLogidFavorite(logid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidFavorite(int logid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidSizeinbytes(int logid, int sizeinbytes) {
        return findByLogidSizeinbytes(logid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidSizeinbytes(int logid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidIstemporary(int logid, boolean istemporary) {
        return findByLogidIstemporary(logid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidIstemporary(int logid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidIsmoderatorapproved(int logid, boolean ismoderatorapproved) {
        return findByLogidIsmoderatorapproved(logid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidIsmoderatorapproved(int logid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidLastmodifiedbyuserdate(int logid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByLogidLastmodifiedbyuserdate(logid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidLastmodifiedbyuserdate(int logid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidIsflaggedformoderator(int logid, boolean isflaggedformoderator) {
        return findByLogidIsflaggedformoderator(logid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidIsflaggedformoderator(int logid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidRequiresmoderatorapproval(int logid, boolean requiresmoderatorapproval) {
        return findByLogidRequiresmoderatorapproval(logid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidRequiresmoderatorapproval(int logid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLogidEntrykey(int logid, String entrykey) {
        return findByLogidEntrykey(logid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLogidEntrykey(int logid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE logid='"+logid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridIsdraft(int accountuserid, boolean isdraft) {
        return findByAccountuseridIsdraft(accountuserid, isdraft, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridIsdraft(int accountuserid, boolean isdraft, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridIsapproved(int accountuserid, boolean isapproved) {
        return findByAccountuseridIsapproved(accountuserid, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridIsapproved(int accountuserid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridFavorite(int accountuserid, boolean favorite) {
        return findByAccountuseridFavorite(accountuserid, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridFavorite(int accountuserid, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridSizeinbytes(int accountuserid, int sizeinbytes) {
        return findByAccountuseridSizeinbytes(accountuserid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridSizeinbytes(int accountuserid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridIstemporary(int accountuserid, boolean istemporary) {
        return findByAccountuseridIstemporary(accountuserid, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridIstemporary(int accountuserid, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridIsmoderatorapproved(int accountuserid, boolean ismoderatorapproved) {
        return findByAccountuseridIsmoderatorapproved(accountuserid, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridIsmoderatorapproved(int accountuserid, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridLastmodifiedbyuserdate(int accountuserid, java.util.Calendar lastmodifiedbyuserdate) {
        return findByAccountuseridLastmodifiedbyuserdate(accountuserid, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridLastmodifiedbyuserdate(int accountuserid, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridIsflaggedformoderator(int accountuserid, boolean isflaggedformoderator) {
        return findByAccountuseridIsflaggedformoderator(accountuserid, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridIsflaggedformoderator(int accountuserid, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridRequiresmoderatorapproval(int accountuserid, boolean requiresmoderatorapproval) {
        return findByAccountuseridRequiresmoderatorapproval(accountuserid, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridRequiresmoderatorapproval(int accountuserid, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByAccountuseridEntrykey(int accountuserid, String entrykey) {
        return findByAccountuseridEntrykey(accountuserid, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByAccountuseridEntrykey(int accountuserid, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE accountuserid='"+accountuserid+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftIsapproved(boolean isdraft, boolean isapproved) {
        return findByIsdraftIsapproved(isdraft, isapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftIsapproved(boolean isdraft, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftFavorite(boolean isdraft, boolean favorite) {
        return findByIsdraftFavorite(isdraft, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftFavorite(boolean isdraft, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftSizeinbytes(boolean isdraft, int sizeinbytes) {
        return findByIsdraftSizeinbytes(isdraft, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftSizeinbytes(boolean isdraft, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftIstemporary(boolean isdraft, boolean istemporary) {
        return findByIsdraftIstemporary(isdraft, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftIstemporary(boolean isdraft, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftIsmoderatorapproved(boolean isdraft, boolean ismoderatorapproved) {
        return findByIsdraftIsmoderatorapproved(isdraft, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftIsmoderatorapproved(boolean isdraft, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftLastmodifiedbyuserdate(boolean isdraft, java.util.Calendar lastmodifiedbyuserdate) {
        return findByIsdraftLastmodifiedbyuserdate(isdraft, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftLastmodifiedbyuserdate(boolean isdraft, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftIsflaggedformoderator(boolean isdraft, boolean isflaggedformoderator) {
        return findByIsdraftIsflaggedformoderator(isdraft, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftIsflaggedformoderator(boolean isdraft, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftRequiresmoderatorapproval(boolean isdraft, boolean requiresmoderatorapproval) {
        return findByIsdraftRequiresmoderatorapproval(isdraft, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftRequiresmoderatorapproval(boolean isdraft, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsdraftEntrykey(boolean isdraft, String entrykey) {
        return findByIsdraftEntrykey(isdraft, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsdraftEntrykey(boolean isdraft, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedFavorite(boolean isapproved, boolean favorite) {
        return findByIsapprovedFavorite(isapproved, favorite, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedFavorite(boolean isapproved, boolean favorite, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedSizeinbytes(boolean isapproved, int sizeinbytes) {
        return findByIsapprovedSizeinbytes(isapproved, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedSizeinbytes(boolean isapproved, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedIstemporary(boolean isapproved, boolean istemporary) {
        return findByIsapprovedIstemporary(isapproved, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedIstemporary(boolean isapproved, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedIsmoderatorapproved(boolean isapproved, boolean ismoderatorapproved) {
        return findByIsapprovedIsmoderatorapproved(isapproved, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedIsmoderatorapproved(boolean isapproved, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedLastmodifiedbyuserdate(boolean isapproved, java.util.Calendar lastmodifiedbyuserdate) {
        return findByIsapprovedLastmodifiedbyuserdate(isapproved, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedLastmodifiedbyuserdate(boolean isapproved, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedIsflaggedformoderator(boolean isapproved, boolean isflaggedformoderator) {
        return findByIsapprovedIsflaggedformoderator(isapproved, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedIsflaggedformoderator(boolean isapproved, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedRequiresmoderatorapproval(boolean isapproved, boolean requiresmoderatorapproval) {
        return findByIsapprovedRequiresmoderatorapproval(isapproved, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedRequiresmoderatorapproval(boolean isapproved, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsapprovedEntrykey(boolean isapproved, String entrykey) {
        return findByIsapprovedEntrykey(isapproved, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsapprovedEntrykey(boolean isapproved, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteSizeinbytes(boolean favorite, int sizeinbytes) {
        return findByFavoriteSizeinbytes(favorite, sizeinbytes, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteSizeinbytes(boolean favorite, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteIstemporary(boolean favorite, boolean istemporary) {
        return findByFavoriteIstemporary(favorite, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteIstemporary(boolean favorite, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteIsmoderatorapproved(boolean favorite, boolean ismoderatorapproved) {
        return findByFavoriteIsmoderatorapproved(favorite, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteIsmoderatorapproved(boolean favorite, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteLastmodifiedbyuserdate(boolean favorite, java.util.Calendar lastmodifiedbyuserdate) {
        return findByFavoriteLastmodifiedbyuserdate(favorite, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteLastmodifiedbyuserdate(boolean favorite, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteIsflaggedformoderator(boolean favorite, boolean isflaggedformoderator) {
        return findByFavoriteIsflaggedformoderator(favorite, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteIsflaggedformoderator(boolean favorite, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteRequiresmoderatorapproval(boolean favorite, boolean requiresmoderatorapproval) {
        return findByFavoriteRequiresmoderatorapproval(favorite, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteRequiresmoderatorapproval(boolean favorite, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByFavoriteEntrykey(boolean favorite, String entrykey) {
        return findByFavoriteEntrykey(favorite, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByFavoriteEntrykey(boolean favorite, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesIstemporary(int sizeinbytes, boolean istemporary) {
        return findBySizeinbytesIstemporary(sizeinbytes, istemporary, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesIstemporary(int sizeinbytes, boolean istemporary, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesIsmoderatorapproved(int sizeinbytes, boolean ismoderatorapproved) {
        return findBySizeinbytesIsmoderatorapproved(sizeinbytes, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesIsmoderatorapproved(int sizeinbytes, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesLastmodifiedbyuserdate(int sizeinbytes, java.util.Calendar lastmodifiedbyuserdate) {
        return findBySizeinbytesLastmodifiedbyuserdate(sizeinbytes, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesLastmodifiedbyuserdate(int sizeinbytes, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesIsflaggedformoderator(int sizeinbytes, boolean isflaggedformoderator) {
        return findBySizeinbytesIsflaggedformoderator(sizeinbytes, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesIsflaggedformoderator(int sizeinbytes, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesRequiresmoderatorapproval(int sizeinbytes, boolean requiresmoderatorapproval) {
        return findBySizeinbytesRequiresmoderatorapproval(sizeinbytes, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesRequiresmoderatorapproval(int sizeinbytes, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findBySizeinbytesEntrykey(int sizeinbytes, String entrykey) {
        return findBySizeinbytesEntrykey(sizeinbytes, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findBySizeinbytesEntrykey(int sizeinbytes, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE sizeinbytes='"+sizeinbytes+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporaryIsmoderatorapproved(boolean istemporary, boolean ismoderatorapproved) {
        return findByIstemporaryIsmoderatorapproved(istemporary, ismoderatorapproved, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporaryIsmoderatorapproved(boolean istemporary, boolean ismoderatorapproved, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporaryLastmodifiedbyuserdate(boolean istemporary, java.util.Calendar lastmodifiedbyuserdate) {
        return findByIstemporaryLastmodifiedbyuserdate(istemporary, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporaryLastmodifiedbyuserdate(boolean istemporary, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporaryIsflaggedformoderator(boolean istemporary, boolean isflaggedformoderator) {
        return findByIstemporaryIsflaggedformoderator(istemporary, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporaryIsflaggedformoderator(boolean istemporary, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporaryRequiresmoderatorapproval(boolean istemporary, boolean requiresmoderatorapproval) {
        return findByIstemporaryRequiresmoderatorapproval(istemporary, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporaryRequiresmoderatorapproval(boolean istemporary, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIstemporaryEntrykey(boolean istemporary, String entrykey) {
        return findByIstemporaryEntrykey(istemporary, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIstemporaryEntrykey(boolean istemporary, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedLastmodifiedbyuserdate(boolean ismoderatorapproved, java.util.Calendar lastmodifiedbyuserdate) {
        return findByIsmoderatorapprovedLastmodifiedbyuserdate(ismoderatorapproved, lastmodifiedbyuserdate, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedLastmodifiedbyuserdate(boolean ismoderatorapproved, java.util.Calendar lastmodifiedbyuserdate, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedIsflaggedformoderator(boolean ismoderatorapproved, boolean isflaggedformoderator) {
        return findByIsmoderatorapprovedIsflaggedformoderator(ismoderatorapproved, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedIsflaggedformoderator(boolean ismoderatorapproved, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedRequiresmoderatorapproval(boolean ismoderatorapproved, boolean requiresmoderatorapproval) {
        return findByIsmoderatorapprovedRequiresmoderatorapproval(ismoderatorapproved, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedRequiresmoderatorapproval(boolean ismoderatorapproved, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedEntrykey(boolean ismoderatorapproved, String entrykey) {
        return findByIsmoderatorapprovedEntrykey(ismoderatorapproved, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsmoderatorapprovedEntrykey(boolean ismoderatorapproved, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateIsflaggedformoderator(java.util.Calendar lastmodifiedbyuserdate, boolean isflaggedformoderator) {
        return findByLastmodifiedbyuserdateIsflaggedformoderator(lastmodifiedbyuserdate, isflaggedformoderator, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateIsflaggedformoderator(java.util.Calendar lastmodifiedbyuserdate, boolean isflaggedformoderator, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateRequiresmoderatorapproval(java.util.Calendar lastmodifiedbyuserdate, boolean requiresmoderatorapproval) {
        return findByLastmodifiedbyuserdateRequiresmoderatorapproval(lastmodifiedbyuserdate, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateRequiresmoderatorapproval(java.util.Calendar lastmodifiedbyuserdate, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateEntrykey(java.util.Calendar lastmodifiedbyuserdate, String entrykey) {
        return findByLastmodifiedbyuserdateEntrykey(lastmodifiedbyuserdate, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByLastmodifiedbyuserdateEntrykey(java.util.Calendar lastmodifiedbyuserdate, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderatorRequiresmoderatorapproval(boolean isflaggedformoderator, boolean requiresmoderatorapproval) {
        return findByIsflaggedformoderatorRequiresmoderatorapproval(isflaggedformoderator, requiresmoderatorapproval, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderatorRequiresmoderatorapproval(boolean isflaggedformoderator, boolean requiresmoderatorapproval, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderatorEntrykey(boolean isflaggedformoderator, String entrykey) {
        return findByIsflaggedformoderatorEntrykey(isflaggedformoderator, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByIsflaggedformoderatorEntrykey(boolean isflaggedformoderator, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EventDAO> findByRequiresmoderatorapprovalEntrykey(boolean requiresmoderatorapproval, String entrykey) {
        return findByRequiresmoderatorapprovalEntrykey(requiresmoderatorapproval, entrykey, 0, 50000);
    }

    public static ArrayList<EventDAO> findByRequiresmoderatorapprovalEntrykey(boolean requiresmoderatorapproval, String entrykey, int limitmin, int limitmax) {
        ArrayList<EventDAO> resultarraylist = new ArrayList<EventDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EventDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}