package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FriendmessageDAO;

/**
 * Finder for the 'friendmessage' DAO
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

public class FriendmessageFinder {


    public static ArrayList<FriendmessageDAO> findByFriendmessageid(int friendmessageid) {
        return findByFriendmessageid(friendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageid(int friendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findBySubject(String subject) {
        return findBySubject(subject, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findBySubject(String subject, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByMessage(String message) {
        return findByMessage(message, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByMessage(String message, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByDatetime(java.util.Calendar datetime) {
        return findByDatetime(datetime, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByDatetime(java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByParentfriendmessageid(int parentfriendmessageid) {
        return findByParentfriendmessageid(parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByParentfriendmessageid(int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidAccountuserid(int friendmessageid, int accountuserid) {
        return findByFriendmessageidAccountuserid(friendmessageid, accountuserid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidAccountuserid(int friendmessageid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidSubject(int friendmessageid, String subject) {
        return findByFriendmessageidSubject(friendmessageid, subject, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidSubject(int friendmessageid, String subject, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidMessage(int friendmessageid, String message) {
        return findByFriendmessageidMessage(friendmessageid, message, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidMessage(int friendmessageid, String message, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidDatetime(int friendmessageid, java.util.Calendar datetime) {
        return findByFriendmessageidDatetime(friendmessageid, datetime, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidDatetime(int friendmessageid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidParentfriendmessageid(int friendmessageid, int parentfriendmessageid) {
        return findByFriendmessageidParentfriendmessageid(friendmessageid, parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByFriendmessageidParentfriendmessageid(int friendmessageid, int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"', parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridSubject(int accountuserid, String subject) {
        return findByAccountuseridSubject(accountuserid, subject, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridSubject(int accountuserid, String subject, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE accountuserid='"+accountuserid+"', subject='"+reger.core.Util.cleanForSQL(subject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridMessage(int accountuserid, String message) {
        return findByAccountuseridMessage(accountuserid, message, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridMessage(int accountuserid, String message, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE accountuserid='"+accountuserid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridDatetime(int accountuserid, java.util.Calendar datetime) {
        return findByAccountuseridDatetime(accountuserid, datetime, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridDatetime(int accountuserid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE accountuserid='"+accountuserid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridParentfriendmessageid(int accountuserid, int parentfriendmessageid) {
        return findByAccountuseridParentfriendmessageid(accountuserid, parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByAccountuseridParentfriendmessageid(int accountuserid, int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE accountuserid='"+accountuserid+"', parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findBySubjectMessage(String subject, String message) {
        return findBySubjectMessage(subject, message, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findBySubjectMessage(String subject, String message, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findBySubjectDatetime(String subject, java.util.Calendar datetime) {
        return findBySubjectDatetime(subject, datetime, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findBySubjectDatetime(String subject, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findBySubjectParentfriendmessageid(String subject, int parentfriendmessageid) {
        return findBySubjectParentfriendmessageid(subject, parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findBySubjectParentfriendmessageid(String subject, int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE subject='"+reger.core.Util.cleanForSQL(subject)+"', parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByMessageDatetime(String message, java.util.Calendar datetime) {
        return findByMessageDatetime(message, datetime, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByMessageDatetime(String message, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE message='"+reger.core.Util.cleanForSQL(message)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByMessageParentfriendmessageid(String message, int parentfriendmessageid) {
        return findByMessageParentfriendmessageid(message, parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByMessageParentfriendmessageid(String message, int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE message='"+reger.core.Util.cleanForSQL(message)+"', parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FriendmessageDAO> findByDatetimeParentfriendmessageid(java.util.Calendar datetime, int parentfriendmessageid) {
        return findByDatetimeParentfriendmessageid(datetime, parentfriendmessageid, 0, 50000);
    }

    public static ArrayList<FriendmessageDAO> findByDatetimeParentfriendmessageid(java.util.Calendar datetime, int parentfriendmessageid, int limitmin, int limitmax) {
        ArrayList<FriendmessageDAO> resultarraylist = new ArrayList<FriendmessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', parentfriendmessageid='"+parentfriendmessageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FriendmessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}