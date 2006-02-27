package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendinvitationDAO;

/**
 * Finder for the 'friendinvitation' DAO
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

public class FriendinvitationFinder {


    public static ArrayList<FriendinvitationDAO> findByFriendinvitationid(int friendinvitationid) {
        return findByFriendinvitationid(friendinvitationid, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationid(int friendinvitationid, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsource(int accountuseridsource) {
        return findByAccountuseridsource(accountuseridsource, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsource(int accountuseridsource, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtarget(int accountuseridtarget) {
        return findByAccountuseridtarget(accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtarget(int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatus(int status) {
        return findByStatus(status, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatus(int status, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmail(String email) {
        return findByEmail(email, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmail(String email, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findBySubject(String subject) {
        return findBySubject(subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findBySubject(String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByMessage(String message) {
        return findByMessage(message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByMessage(String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedate(java.util.Calendar createdate) {
        return findByCreatedate(createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedate(java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmaillastsentdate(java.util.Calendar emaillastsentdate) {
        return findByEmaillastsentdate(emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmaillastsentdate(java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationkey(String friendinvitationkey) {
        return findByFriendinvitationkey(friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationkey(String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidAccountuseridsource(int friendinvitationid, int accountuseridsource) {
        return findByFriendinvitationidAccountuseridsource(friendinvitationid, accountuseridsource, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidAccountuseridsource(int friendinvitationid, int accountuseridsource, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', accountuseridsource='"+accountuseridsource+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidAccountuseridtarget(int friendinvitationid, int accountuseridtarget) {
        return findByFriendinvitationidAccountuseridtarget(friendinvitationid, accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidAccountuseridtarget(int friendinvitationid, int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidStatus(int friendinvitationid, int status) {
        return findByFriendinvitationidStatus(friendinvitationid, status, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidStatus(int friendinvitationid, int status, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', status='"+status+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidEmail(int friendinvitationid, String email) {
        return findByFriendinvitationidEmail(friendinvitationid, email, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidEmail(int friendinvitationid, String email, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidSubject(int friendinvitationid, String subject) {
        return findByFriendinvitationidSubject(friendinvitationid, subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidSubject(int friendinvitationid, String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidMessage(int friendinvitationid, String message) {
        return findByFriendinvitationidMessage(friendinvitationid, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidMessage(int friendinvitationid, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidCreatedate(int friendinvitationid, java.util.Calendar createdate) {
        return findByFriendinvitationidCreatedate(friendinvitationid, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidCreatedate(int friendinvitationid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidEmaillastsentdate(int friendinvitationid, java.util.Calendar emaillastsentdate) {
        return findByFriendinvitationidEmaillastsentdate(friendinvitationid, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidEmaillastsentdate(int friendinvitationid, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidFriendinvitationkey(int friendinvitationid, String friendinvitationkey) {
        return findByFriendinvitationidFriendinvitationkey(friendinvitationid, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByFriendinvitationidFriendinvitationkey(int friendinvitationid, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceAccountuseridtarget(int accountuseridsource, int accountuseridtarget) {
        return findByAccountuseridsourceAccountuseridtarget(accountuseridsource, accountuseridtarget, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceAccountuseridtarget(int accountuseridsource, int accountuseridtarget, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', accountuseridtarget='"+accountuseridtarget+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceStatus(int accountuseridsource, int status) {
        return findByAccountuseridsourceStatus(accountuseridsource, status, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceStatus(int accountuseridsource, int status, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', status='"+status+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceEmail(int accountuseridsource, String email) {
        return findByAccountuseridsourceEmail(accountuseridsource, email, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceEmail(int accountuseridsource, String email, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceSubject(int accountuseridsource, String subject) {
        return findByAccountuseridsourceSubject(accountuseridsource, subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceSubject(int accountuseridsource, String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceMessage(int accountuseridsource, String message) {
        return findByAccountuseridsourceMessage(accountuseridsource, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceMessage(int accountuseridsource, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceCreatedate(int accountuseridsource, java.util.Calendar createdate) {
        return findByAccountuseridsourceCreatedate(accountuseridsource, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceCreatedate(int accountuseridsource, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceEmaillastsentdate(int accountuseridsource, java.util.Calendar emaillastsentdate) {
        return findByAccountuseridsourceEmaillastsentdate(accountuseridsource, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceEmaillastsentdate(int accountuseridsource, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceFriendinvitationkey(int accountuseridsource, String friendinvitationkey) {
        return findByAccountuseridsourceFriendinvitationkey(accountuseridsource, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridsourceFriendinvitationkey(int accountuseridsource, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridsource='"+accountuseridsource+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetStatus(int accountuseridtarget, int status) {
        return findByAccountuseridtargetStatus(accountuseridtarget, status, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetStatus(int accountuseridtarget, int status, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', status='"+status+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetEmail(int accountuseridtarget, String email) {
        return findByAccountuseridtargetEmail(accountuseridtarget, email, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetEmail(int accountuseridtarget, String email, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetSubject(int accountuseridtarget, String subject) {
        return findByAccountuseridtargetSubject(accountuseridtarget, subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetSubject(int accountuseridtarget, String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetMessage(int accountuseridtarget, String message) {
        return findByAccountuseridtargetMessage(accountuseridtarget, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetMessage(int accountuseridtarget, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetCreatedate(int accountuseridtarget, java.util.Calendar createdate) {
        return findByAccountuseridtargetCreatedate(accountuseridtarget, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetCreatedate(int accountuseridtarget, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetEmaillastsentdate(int accountuseridtarget, java.util.Calendar emaillastsentdate) {
        return findByAccountuseridtargetEmaillastsentdate(accountuseridtarget, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetEmaillastsentdate(int accountuseridtarget, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetFriendinvitationkey(int accountuseridtarget, String friendinvitationkey) {
        return findByAccountuseridtargetFriendinvitationkey(accountuseridtarget, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByAccountuseridtargetFriendinvitationkey(int accountuseridtarget, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE accountuseridtarget='"+accountuseridtarget+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusEmail(int status, String email) {
        return findByStatusEmail(status, email, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusEmail(int status, String email, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusSubject(int status, String subject) {
        return findByStatusSubject(status, subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusSubject(int status, String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusMessage(int status, String message) {
        return findByStatusMessage(status, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusMessage(int status, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusCreatedate(int status, java.util.Calendar createdate) {
        return findByStatusCreatedate(status, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusCreatedate(int status, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusEmaillastsentdate(int status, java.util.Calendar emaillastsentdate) {
        return findByStatusEmaillastsentdate(status, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusEmaillastsentdate(int status, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByStatusFriendinvitationkey(int status, String friendinvitationkey) {
        return findByStatusFriendinvitationkey(status, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByStatusFriendinvitationkey(int status, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE status='"+status+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmailSubject(String email, String subject) {
        return findByEmailSubject(email, subject, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmailSubject(String email, String subject, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmailMessage(String email, String message) {
        return findByEmailMessage(email, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmailMessage(String email, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmailCreatedate(String email, java.util.Calendar createdate) {
        return findByEmailCreatedate(email, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmailCreatedate(String email, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmailEmaillastsentdate(String email, java.util.Calendar emaillastsentdate) {
        return findByEmailEmaillastsentdate(email, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmailEmaillastsentdate(String email, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmailFriendinvitationkey(String email, String friendinvitationkey) {
        return findByEmailFriendinvitationkey(email, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmailFriendinvitationkey(String email, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE email='"+reger.core.Util.cleanForSQL(email)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectMessage(String subject, String message) {
        return findBySubjectMessage(subject, message, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectMessage(String subject, String message, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectCreatedate(String subject, java.util.Calendar createdate) {
        return findBySubjectCreatedate(subject, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectCreatedate(String subject, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectEmaillastsentdate(String subject, java.util.Calendar emaillastsentdate) {
        return findBySubjectEmaillastsentdate(subject, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectEmaillastsentdate(String subject, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectFriendinvitationkey(String subject, String friendinvitationkey) {
        return findBySubjectFriendinvitationkey(subject, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findBySubjectFriendinvitationkey(String subject, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByMessageCreatedate(String message, java.util.Calendar createdate) {
        return findByMessageCreatedate(message, createdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByMessageCreatedate(String message, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE message='"+reger.core.Util.cleanForSQL(message)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByMessageEmaillastsentdate(String message, java.util.Calendar emaillastsentdate) {
        return findByMessageEmaillastsentdate(message, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByMessageEmaillastsentdate(String message, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE message='"+reger.core.Util.cleanForSQL(message)+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByMessageFriendinvitationkey(String message, String friendinvitationkey) {
        return findByMessageFriendinvitationkey(message, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByMessageFriendinvitationkey(String message, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE message='"+reger.core.Util.cleanForSQL(message)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedateEmaillastsentdate(java.util.Calendar createdate, java.util.Calendar emaillastsentdate) {
        return findByCreatedateEmaillastsentdate(createdate, emaillastsentdate, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedateEmaillastsentdate(java.util.Calendar createdate, java.util.Calendar emaillastsentdate, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedateFriendinvitationkey(java.util.Calendar createdate, String friendinvitationkey) {
        return findByCreatedateFriendinvitationkey(createdate, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByCreatedateFriendinvitationkey(java.util.Calendar createdate, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendinvitationDAO> findByEmaillastsentdateFriendinvitationkey(java.util.Calendar emaillastsentdate, String friendinvitationkey) {
        return findByEmaillastsentdateFriendinvitationkey(emaillastsentdate, friendinvitationkey, 0, 50000);
    }

    public static ArrayList<FriendinvitationDAO> findByEmaillastsentdateFriendinvitationkey(java.util.Calendar emaillastsentdate, String friendinvitationkey, int limitmin, int limitmax) {
        ArrayList<FriendinvitationDAO> resultarraylist = new ArrayList<FriendinvitationDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendinvitationDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}