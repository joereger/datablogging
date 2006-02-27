package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MessageDAO;

/**
 * Finder for the 'message' DAO
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

public class MessageFinder {


    public static ArrayList<MessageDAO> findByMessageid(int messageid) {
        return findByMessageid(messageid, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageid(int messageid, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedate(java.util.Calendar messagedate) {
        return findByMessagedate(messagedate, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedate(java.util.Calendar messagedate, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefrom(String messagefrom) {
        return findByMessagefrom(messagefrom, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefrom(String messagefrom, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessage(String message) {
        return findByMessage(message, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessage(String message, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findBySizeinbytes(int sizeinbytes) {
        return findBySizeinbytes(sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findBySizeinbytes(int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEmail(String email) {
        return findByEmail(email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEmail(String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIpaddress(String ipaddress) {
        return findByIpaddress(ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIpaddress(String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByUrl(String url) {
        return findByUrl(url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByUrl(String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEmailnotify(int emailnotify) {
        return findByEmailnotify(emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEmailnotify(int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidEventid(int messageid, int eventid) {
        return findByMessageidEventid(messageid, eventid, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidEventid(int messageid, int eventid, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidMessagedate(int messageid, java.util.Calendar messagedate) {
        return findByMessageidMessagedate(messageid, messagedate, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidMessagedate(int messageid, java.util.Calendar messagedate, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidMessagefrom(int messageid, String messagefrom) {
        return findByMessageidMessagefrom(messageid, messagefrom, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidMessagefrom(int messageid, String messagefrom, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidMessage(int messageid, String message) {
        return findByMessageidMessage(messageid, message, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidMessage(int messageid, String message, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidIsapproved(int messageid, boolean isapproved) {
        return findByMessageidIsapproved(messageid, isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidIsapproved(int messageid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidSizeinbytes(int messageid, int sizeinbytes) {
        return findByMessageidSizeinbytes(messageid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidSizeinbytes(int messageid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidEmail(int messageid, String email) {
        return findByMessageidEmail(messageid, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidEmail(int messageid, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidIpaddress(int messageid, String ipaddress) {
        return findByMessageidIpaddress(messageid, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidIpaddress(int messageid, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidUrl(int messageid, String url) {
        return findByMessageidUrl(messageid, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidUrl(int messageid, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageidEmailnotify(int messageid, int emailnotify) {
        return findByMessageidEmailnotify(messageid, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageidEmailnotify(int messageid, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidMessagedate(int eventid, java.util.Calendar messagedate) {
        return findByEventidMessagedate(eventid, messagedate, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidMessagedate(int eventid, java.util.Calendar messagedate, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidMessagefrom(int eventid, String messagefrom) {
        return findByEventidMessagefrom(eventid, messagefrom, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidMessagefrom(int eventid, String messagefrom, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidMessage(int eventid, String message) {
        return findByEventidMessage(eventid, message, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidMessage(int eventid, String message, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidIsapproved(int eventid, boolean isapproved) {
        return findByEventidIsapproved(eventid, isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidIsapproved(int eventid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes) {
        return findByEventidSizeinbytes(eventid, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidSizeinbytes(int eventid, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidEmail(int eventid, String email) {
        return findByEventidEmail(eventid, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidEmail(int eventid, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidIpaddress(int eventid, String ipaddress) {
        return findByEventidIpaddress(eventid, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidIpaddress(int eventid, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidUrl(int eventid, String url) {
        return findByEventidUrl(eventid, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidUrl(int eventid, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEventidEmailnotify(int eventid, int emailnotify) {
        return findByEventidEmailnotify(eventid, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEventidEmailnotify(int eventid, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE eventid='"+eventid+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateMessagefrom(java.util.Calendar messagedate, String messagefrom) {
        return findByMessagedateMessagefrom(messagedate, messagefrom, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateMessagefrom(java.util.Calendar messagedate, String messagefrom, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateMessage(java.util.Calendar messagedate, String message) {
        return findByMessagedateMessage(messagedate, message, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateMessage(java.util.Calendar messagedate, String message, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateIsapproved(java.util.Calendar messagedate, boolean isapproved) {
        return findByMessagedateIsapproved(messagedate, isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateIsapproved(java.util.Calendar messagedate, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateSizeinbytes(java.util.Calendar messagedate, int sizeinbytes) {
        return findByMessagedateSizeinbytes(messagedate, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateSizeinbytes(java.util.Calendar messagedate, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateEmail(java.util.Calendar messagedate, String email) {
        return findByMessagedateEmail(messagedate, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateEmail(java.util.Calendar messagedate, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateIpaddress(java.util.Calendar messagedate, String ipaddress) {
        return findByMessagedateIpaddress(messagedate, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateIpaddress(java.util.Calendar messagedate, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateUrl(java.util.Calendar messagedate, String url) {
        return findByMessagedateUrl(messagedate, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateUrl(java.util.Calendar messagedate, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagedateEmailnotify(java.util.Calendar messagedate, int emailnotify) {
        return findByMessagedateEmailnotify(messagedate, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagedateEmailnotify(java.util.Calendar messagedate, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromMessage(String messagefrom, String message) {
        return findByMessagefromMessage(messagefrom, message, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromMessage(String messagefrom, String message, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', message='"+reger.core.Util.cleanForSQL(message)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromIsapproved(String messagefrom, boolean isapproved) {
        return findByMessagefromIsapproved(messagefrom, isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromIsapproved(String messagefrom, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromSizeinbytes(String messagefrom, int sizeinbytes) {
        return findByMessagefromSizeinbytes(messagefrom, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromSizeinbytes(String messagefrom, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromEmail(String messagefrom, String email) {
        return findByMessagefromEmail(messagefrom, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromEmail(String messagefrom, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromIpaddress(String messagefrom, String ipaddress) {
        return findByMessagefromIpaddress(messagefrom, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromIpaddress(String messagefrom, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromUrl(String messagefrom, String url) {
        return findByMessagefromUrl(messagefrom, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromUrl(String messagefrom, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessagefromEmailnotify(String messagefrom, int emailnotify) {
        return findByMessagefromEmailnotify(messagefrom, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessagefromEmailnotify(String messagefrom, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageIsapproved(String message, boolean isapproved) {
        return findByMessageIsapproved(message, isapproved, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageIsapproved(String message, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageSizeinbytes(String message, int sizeinbytes) {
        return findByMessageSizeinbytes(message, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageSizeinbytes(String message, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageEmail(String message, String email) {
        return findByMessageEmail(message, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageEmail(String message, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageIpaddress(String message, String ipaddress) {
        return findByMessageIpaddress(message, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageIpaddress(String message, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageUrl(String message, String url) {
        return findByMessageUrl(message, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageUrl(String message, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByMessageEmailnotify(String message, int emailnotify) {
        return findByMessageEmailnotify(message, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByMessageEmailnotify(String message, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE message='"+reger.core.Util.cleanForSQL(message)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapprovedSizeinbytes(boolean isapproved, int sizeinbytes) {
        return findByIsapprovedSizeinbytes(isapproved, sizeinbytes, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapprovedSizeinbytes(boolean isapproved, int sizeinbytes, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', sizeinbytes='"+sizeinbytes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapprovedEmail(boolean isapproved, String email) {
        return findByIsapprovedEmail(isapproved, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapprovedEmail(boolean isapproved, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapprovedIpaddress(boolean isapproved, String ipaddress) {
        return findByIsapprovedIpaddress(isapproved, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapprovedIpaddress(boolean isapproved, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapprovedUrl(boolean isapproved, String url) {
        return findByIsapprovedUrl(isapproved, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapprovedUrl(boolean isapproved, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIsapprovedEmailnotify(boolean isapproved, int emailnotify) {
        return findByIsapprovedEmailnotify(isapproved, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIsapprovedEmailnotify(boolean isapproved, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findBySizeinbytesEmail(int sizeinbytes, String email) {
        return findBySizeinbytesEmail(sizeinbytes, email, 0, 50000);
    }

    public static ArrayList<MessageDAO> findBySizeinbytesEmail(int sizeinbytes, String email, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE sizeinbytes='"+sizeinbytes+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findBySizeinbytesIpaddress(int sizeinbytes, String ipaddress) {
        return findBySizeinbytesIpaddress(sizeinbytes, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findBySizeinbytesIpaddress(int sizeinbytes, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE sizeinbytes='"+sizeinbytes+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findBySizeinbytesUrl(int sizeinbytes, String url) {
        return findBySizeinbytesUrl(sizeinbytes, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findBySizeinbytesUrl(int sizeinbytes, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE sizeinbytes='"+sizeinbytes+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findBySizeinbytesEmailnotify(int sizeinbytes, int emailnotify) {
        return findBySizeinbytesEmailnotify(sizeinbytes, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findBySizeinbytesEmailnotify(int sizeinbytes, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE sizeinbytes='"+sizeinbytes+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEmailIpaddress(String email, String ipaddress) {
        return findByEmailIpaddress(email, ipaddress, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEmailIpaddress(String email, String ipaddress, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE email='"+reger.core.Util.cleanForSQL(email)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEmailUrl(String email, String url) {
        return findByEmailUrl(email, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEmailUrl(String email, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE email='"+reger.core.Util.cleanForSQL(email)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByEmailEmailnotify(String email, int emailnotify) {
        return findByEmailEmailnotify(email, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByEmailEmailnotify(String email, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE email='"+reger.core.Util.cleanForSQL(email)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIpaddressUrl(String ipaddress, String url) {
        return findByIpaddressUrl(ipaddress, url, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIpaddressUrl(String ipaddress, String url, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"', url='"+reger.core.Util.cleanForSQL(url)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByIpaddressEmailnotify(String ipaddress, int emailnotify) {
        return findByIpaddressEmailnotify(ipaddress, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByIpaddressEmailnotify(String ipaddress, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MessageDAO> findByUrlEmailnotify(String url, int emailnotify) {
        return findByUrlEmailnotify(url, emailnotify, 0, 50000);
    }

    public static ArrayList<MessageDAO> findByUrlEmailnotify(String url, int emailnotify, int limitmin, int limitmax) {
        ArrayList<MessageDAO> resultarraylist = new ArrayList<MessageDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE url='"+reger.core.Util.cleanForSQL(url)+"', emailnotify='"+emailnotify+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MessageDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}