package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountuserDAO;

/**
 * Finder for the 'accountuser' DAO
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

public class AccountuserFinder {


    public static ArrayList<AccountuserDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactive(boolean isactive) {
        return findByIsactive(isactive, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactive(boolean isactive, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassword(String password) {
        return findByPassword(password, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassword(String password, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsername(String username) {
        return findByUsername(username, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsername(String username, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlyname(String friendlyname) {
        return findByFriendlyname(friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlyname(String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummary(String onelinesummary) {
        return findByOnelinesummary(onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummary(String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestion(String passphrasequestion) {
        return findByPassphrasequestion(passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestion(String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswer(String passphraseanswer) {
        return findByPassphraseanswer(passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswer(String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmail(String email) {
        return findByEmail(email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmail(String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindate(java.util.Calendar lastlogindate) {
        return findByLastlogindate(lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindate(java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymode(int entrymode) {
        return findByEntrymode(entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymode(int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneid(String usertimezoneid) {
        return findByUsertimezoneid(usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneid(String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedate(java.util.Calendar createdate) {
        return findByCreatedate(createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedate(java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIshelpon(boolean ishelpon) {
        return findByIshelpon(ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIshelpon(boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemail(boolean isactivatedbyemail) {
        return findByIsactivatedbyemail(isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemail(boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkey(String emailactivationkey) {
        return findByEmailactivationkey(emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkey(String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationlastsent(java.util.Calendar emailactivationlastsent) {
        return findByEmailactivationlastsent(emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationlastsent(java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByProfileimageid(int profileimageid) {
        return findByProfileimageid(profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByProfileimageid(int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIsactive(int accountuserid, boolean isactive) {
        return findByAccountuseridIsactive(accountuserid, isactive, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIsactive(int accountuserid, boolean isactive, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridAccountid(int accountuserid, int accountid) {
        return findByAccountuseridAccountid(accountuserid, accountid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridAccountid(int accountuserid, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassword(int accountuserid, String password) {
        return findByAccountuseridPassword(accountuserid, password, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassword(int accountuserid, String password, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridUsername(int accountuserid, String username) {
        return findByAccountuseridUsername(accountuserid, username, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridUsername(int accountuserid, String username, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', username='"+reger.core.Util.cleanForSQL(username)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridFriendlyname(int accountuserid, String friendlyname) {
        return findByAccountuseridFriendlyname(accountuserid, friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridFriendlyname(int accountuserid, String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridOnelinesummary(int accountuserid, String onelinesummary) {
        return findByAccountuseridOnelinesummary(accountuserid, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridOnelinesummary(int accountuserid, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassphrasequestion(int accountuserid, String passphrasequestion) {
        return findByAccountuseridPassphrasequestion(accountuserid, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassphrasequestion(int accountuserid, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassphraseanswer(int accountuserid, String passphraseanswer) {
        return findByAccountuseridPassphraseanswer(accountuserid, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridPassphraseanswer(int accountuserid, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmail(int accountuserid, String email) {
        return findByAccountuseridEmail(accountuserid, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmail(int accountuserid, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridLastlogindate(int accountuserid, java.util.Calendar lastlogindate) {
        return findByAccountuseridLastlogindate(accountuserid, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridLastlogindate(int accountuserid, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEntrymode(int accountuserid, int entrymode) {
        return findByAccountuseridEntrymode(accountuserid, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEntrymode(int accountuserid, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridUsertimezoneid(int accountuserid, String usertimezoneid) {
        return findByAccountuseridUsertimezoneid(accountuserid, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridUsertimezoneid(int accountuserid, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridCreatedate(int accountuserid, java.util.Calendar createdate) {
        return findByAccountuseridCreatedate(accountuserid, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridCreatedate(int accountuserid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIshelpon(int accountuserid, boolean ishelpon) {
        return findByAccountuseridIshelpon(accountuserid, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIshelpon(int accountuserid, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIsactivatedbyemail(int accountuserid, boolean isactivatedbyemail) {
        return findByAccountuseridIsactivatedbyemail(accountuserid, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridIsactivatedbyemail(int accountuserid, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmailactivationkey(int accountuserid, String emailactivationkey) {
        return findByAccountuseridEmailactivationkey(accountuserid, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmailactivationkey(int accountuserid, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmailactivationlastsent(int accountuserid, java.util.Calendar emailactivationlastsent) {
        return findByAccountuseridEmailactivationlastsent(accountuserid, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridEmailactivationlastsent(int accountuserid, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridProfileimageid(int accountuserid, int profileimageid) {
        return findByAccountuseridProfileimageid(accountuserid, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountuseridProfileimageid(int accountuserid, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveAccountid(boolean isactive, int accountid) {
        return findByIsactiveAccountid(isactive, accountid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveAccountid(boolean isactive, int accountid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassword(boolean isactive, String password) {
        return findByIsactivePassword(isactive, password, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassword(boolean isactive, String password, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveUsername(boolean isactive, String username) {
        return findByIsactiveUsername(isactive, username, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveUsername(boolean isactive, String username, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', username='"+reger.core.Util.cleanForSQL(username)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveFriendlyname(boolean isactive, String friendlyname) {
        return findByIsactiveFriendlyname(isactive, friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveFriendlyname(boolean isactive, String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveOnelinesummary(boolean isactive, String onelinesummary) {
        return findByIsactiveOnelinesummary(isactive, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveOnelinesummary(boolean isactive, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassphrasequestion(boolean isactive, String passphrasequestion) {
        return findByIsactivePassphrasequestion(isactive, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassphrasequestion(boolean isactive, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassphraseanswer(boolean isactive, String passphraseanswer) {
        return findByIsactivePassphraseanswer(isactive, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivePassphraseanswer(boolean isactive, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmail(boolean isactive, String email) {
        return findByIsactiveEmail(isactive, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmail(boolean isactive, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveLastlogindate(boolean isactive, java.util.Calendar lastlogindate) {
        return findByIsactiveLastlogindate(isactive, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveLastlogindate(boolean isactive, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEntrymode(boolean isactive, int entrymode) {
        return findByIsactiveEntrymode(isactive, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEntrymode(boolean isactive, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveUsertimezoneid(boolean isactive, String usertimezoneid) {
        return findByIsactiveUsertimezoneid(isactive, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveUsertimezoneid(boolean isactive, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveCreatedate(boolean isactive, java.util.Calendar createdate) {
        return findByIsactiveCreatedate(isactive, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveCreatedate(boolean isactive, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveIshelpon(boolean isactive, boolean ishelpon) {
        return findByIsactiveIshelpon(isactive, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveIshelpon(boolean isactive, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveIsactivatedbyemail(boolean isactive, boolean isactivatedbyemail) {
        return findByIsactiveIsactivatedbyemail(isactive, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveIsactivatedbyemail(boolean isactive, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmailactivationkey(boolean isactive, String emailactivationkey) {
        return findByIsactiveEmailactivationkey(isactive, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmailactivationkey(boolean isactive, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmailactivationlastsent(boolean isactive, java.util.Calendar emailactivationlastsent) {
        return findByIsactiveEmailactivationlastsent(isactive, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveEmailactivationlastsent(boolean isactive, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactiveProfileimageid(boolean isactive, int profileimageid) {
        return findByIsactiveProfileimageid(isactive, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactiveProfileimageid(boolean isactive, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassword(int accountid, String password) {
        return findByAccountidPassword(accountid, password, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassword(int accountid, String password, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', password='"+reger.core.Util.cleanForSQL(password)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidUsername(int accountid, String username) {
        return findByAccountidUsername(accountid, username, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidUsername(int accountid, String username, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', username='"+reger.core.Util.cleanForSQL(username)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidFriendlyname(int accountid, String friendlyname) {
        return findByAccountidFriendlyname(accountid, friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidFriendlyname(int accountid, String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidOnelinesummary(int accountid, String onelinesummary) {
        return findByAccountidOnelinesummary(accountid, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidOnelinesummary(int accountid, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassphrasequestion(int accountid, String passphrasequestion) {
        return findByAccountidPassphrasequestion(accountid, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassphrasequestion(int accountid, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassphraseanswer(int accountid, String passphraseanswer) {
        return findByAccountidPassphraseanswer(accountid, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidPassphraseanswer(int accountid, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmail(int accountid, String email) {
        return findByAccountidEmail(accountid, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmail(int accountid, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidLastlogindate(int accountid, java.util.Calendar lastlogindate) {
        return findByAccountidLastlogindate(accountid, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidLastlogindate(int accountid, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidEntrymode(int accountid, int entrymode) {
        return findByAccountidEntrymode(accountid, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidEntrymode(int accountid, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidUsertimezoneid(int accountid, String usertimezoneid) {
        return findByAccountidUsertimezoneid(accountid, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidUsertimezoneid(int accountid, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidCreatedate(int accountid, java.util.Calendar createdate) {
        return findByAccountidCreatedate(accountid, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidCreatedate(int accountid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidIshelpon(int accountid, boolean ishelpon) {
        return findByAccountidIshelpon(accountid, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidIshelpon(int accountid, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidIsactivatedbyemail(int accountid, boolean isactivatedbyemail) {
        return findByAccountidIsactivatedbyemail(accountid, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidIsactivatedbyemail(int accountid, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmailactivationkey(int accountid, String emailactivationkey) {
        return findByAccountidEmailactivationkey(accountid, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmailactivationkey(int accountid, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmailactivationlastsent(int accountid, java.util.Calendar emailactivationlastsent) {
        return findByAccountidEmailactivationlastsent(accountid, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidEmailactivationlastsent(int accountid, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByAccountidProfileimageid(int accountid, int profileimageid) {
        return findByAccountidProfileimageid(accountid, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByAccountidProfileimageid(int accountid, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+accountid+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordUsername(String password, String username) {
        return findByPasswordUsername(password, username, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordUsername(String password, String username, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', username='"+reger.core.Util.cleanForSQL(username)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordFriendlyname(String password, String friendlyname) {
        return findByPasswordFriendlyname(password, friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordFriendlyname(String password, String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordOnelinesummary(String password, String onelinesummary) {
        return findByPasswordOnelinesummary(password, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordOnelinesummary(String password, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordPassphrasequestion(String password, String passphrasequestion) {
        return findByPasswordPassphrasequestion(password, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordPassphrasequestion(String password, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordPassphraseanswer(String password, String passphraseanswer) {
        return findByPasswordPassphraseanswer(password, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordPassphraseanswer(String password, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmail(String password, String email) {
        return findByPasswordEmail(password, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmail(String password, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordLastlogindate(String password, java.util.Calendar lastlogindate) {
        return findByPasswordLastlogindate(password, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordLastlogindate(String password, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordEntrymode(String password, int entrymode) {
        return findByPasswordEntrymode(password, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordEntrymode(String password, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordUsertimezoneid(String password, String usertimezoneid) {
        return findByPasswordUsertimezoneid(password, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordUsertimezoneid(String password, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordCreatedate(String password, java.util.Calendar createdate) {
        return findByPasswordCreatedate(password, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordCreatedate(String password, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordIshelpon(String password, boolean ishelpon) {
        return findByPasswordIshelpon(password, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordIshelpon(String password, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordIsactivatedbyemail(String password, boolean isactivatedbyemail) {
        return findByPasswordIsactivatedbyemail(password, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordIsactivatedbyemail(String password, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmailactivationkey(String password, String emailactivationkey) {
        return findByPasswordEmailactivationkey(password, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmailactivationkey(String password, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmailactivationlastsent(String password, java.util.Calendar emailactivationlastsent) {
        return findByPasswordEmailactivationlastsent(password, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordEmailactivationlastsent(String password, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPasswordProfileimageid(String password, int profileimageid) {
        return findByPasswordProfileimageid(password, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPasswordProfileimageid(String password, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE password='"+reger.core.Util.cleanForSQL(password)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameFriendlyname(String username, String friendlyname) {
        return findByUsernameFriendlyname(username, friendlyname, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameFriendlyname(String username, String friendlyname, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameOnelinesummary(String username, String onelinesummary) {
        return findByUsernameOnelinesummary(username, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameOnelinesummary(String username, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernamePassphrasequestion(String username, String passphrasequestion) {
        return findByUsernamePassphrasequestion(username, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernamePassphrasequestion(String username, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernamePassphraseanswer(String username, String passphraseanswer) {
        return findByUsernamePassphraseanswer(username, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernamePassphraseanswer(String username, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmail(String username, String email) {
        return findByUsernameEmail(username, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmail(String username, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameLastlogindate(String username, java.util.Calendar lastlogindate) {
        return findByUsernameLastlogindate(username, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameLastlogindate(String username, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameEntrymode(String username, int entrymode) {
        return findByUsernameEntrymode(username, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameEntrymode(String username, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameUsertimezoneid(String username, String usertimezoneid) {
        return findByUsernameUsertimezoneid(username, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameUsertimezoneid(String username, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameCreatedate(String username, java.util.Calendar createdate) {
        return findByUsernameCreatedate(username, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameCreatedate(String username, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameIshelpon(String username, boolean ishelpon) {
        return findByUsernameIshelpon(username, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameIshelpon(String username, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameIsactivatedbyemail(String username, boolean isactivatedbyemail) {
        return findByUsernameIsactivatedbyemail(username, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameIsactivatedbyemail(String username, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmailactivationkey(String username, String emailactivationkey) {
        return findByUsernameEmailactivationkey(username, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmailactivationkey(String username, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmailactivationlastsent(String username, java.util.Calendar emailactivationlastsent) {
        return findByUsernameEmailactivationlastsent(username, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameEmailactivationlastsent(String username, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsernameProfileimageid(String username, int profileimageid) {
        return findByUsernameProfileimageid(username, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsernameProfileimageid(String username, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameOnelinesummary(String friendlyname, String onelinesummary) {
        return findByFriendlynameOnelinesummary(friendlyname, onelinesummary, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameOnelinesummary(String friendlyname, String onelinesummary, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynamePassphrasequestion(String friendlyname, String passphrasequestion) {
        return findByFriendlynamePassphrasequestion(friendlyname, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynamePassphrasequestion(String friendlyname, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynamePassphraseanswer(String friendlyname, String passphraseanswer) {
        return findByFriendlynamePassphraseanswer(friendlyname, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynamePassphraseanswer(String friendlyname, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmail(String friendlyname, String email) {
        return findByFriendlynameEmail(friendlyname, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmail(String friendlyname, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameLastlogindate(String friendlyname, java.util.Calendar lastlogindate) {
        return findByFriendlynameLastlogindate(friendlyname, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameLastlogindate(String friendlyname, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEntrymode(String friendlyname, int entrymode) {
        return findByFriendlynameEntrymode(friendlyname, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEntrymode(String friendlyname, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameUsertimezoneid(String friendlyname, String usertimezoneid) {
        return findByFriendlynameUsertimezoneid(friendlyname, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameUsertimezoneid(String friendlyname, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameCreatedate(String friendlyname, java.util.Calendar createdate) {
        return findByFriendlynameCreatedate(friendlyname, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameCreatedate(String friendlyname, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameIshelpon(String friendlyname, boolean ishelpon) {
        return findByFriendlynameIshelpon(friendlyname, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameIshelpon(String friendlyname, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameIsactivatedbyemail(String friendlyname, boolean isactivatedbyemail) {
        return findByFriendlynameIsactivatedbyemail(friendlyname, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameIsactivatedbyemail(String friendlyname, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmailactivationkey(String friendlyname, String emailactivationkey) {
        return findByFriendlynameEmailactivationkey(friendlyname, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmailactivationkey(String friendlyname, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmailactivationlastsent(String friendlyname, java.util.Calendar emailactivationlastsent) {
        return findByFriendlynameEmailactivationlastsent(friendlyname, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameEmailactivationlastsent(String friendlyname, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameProfileimageid(String friendlyname, int profileimageid) {
        return findByFriendlynameProfileimageid(friendlyname, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByFriendlynameProfileimageid(String friendlyname, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryPassphrasequestion(String onelinesummary, String passphrasequestion) {
        return findByOnelinesummaryPassphrasequestion(onelinesummary, passphrasequestion, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryPassphrasequestion(String onelinesummary, String passphrasequestion, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryPassphraseanswer(String onelinesummary, String passphraseanswer) {
        return findByOnelinesummaryPassphraseanswer(onelinesummary, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryPassphraseanswer(String onelinesummary, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmail(String onelinesummary, String email) {
        return findByOnelinesummaryEmail(onelinesummary, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmail(String onelinesummary, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryLastlogindate(String onelinesummary, java.util.Calendar lastlogindate) {
        return findByOnelinesummaryLastlogindate(onelinesummary, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryLastlogindate(String onelinesummary, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEntrymode(String onelinesummary, int entrymode) {
        return findByOnelinesummaryEntrymode(onelinesummary, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEntrymode(String onelinesummary, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryUsertimezoneid(String onelinesummary, String usertimezoneid) {
        return findByOnelinesummaryUsertimezoneid(onelinesummary, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryUsertimezoneid(String onelinesummary, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryCreatedate(String onelinesummary, java.util.Calendar createdate) {
        return findByOnelinesummaryCreatedate(onelinesummary, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryCreatedate(String onelinesummary, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryIshelpon(String onelinesummary, boolean ishelpon) {
        return findByOnelinesummaryIshelpon(onelinesummary, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryIshelpon(String onelinesummary, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryIsactivatedbyemail(String onelinesummary, boolean isactivatedbyemail) {
        return findByOnelinesummaryIsactivatedbyemail(onelinesummary, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryIsactivatedbyemail(String onelinesummary, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmailactivationkey(String onelinesummary, String emailactivationkey) {
        return findByOnelinesummaryEmailactivationkey(onelinesummary, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmailactivationkey(String onelinesummary, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmailactivationlastsent(String onelinesummary, java.util.Calendar emailactivationlastsent) {
        return findByOnelinesummaryEmailactivationlastsent(onelinesummary, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryEmailactivationlastsent(String onelinesummary, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryProfileimageid(String onelinesummary, int profileimageid) {
        return findByOnelinesummaryProfileimageid(onelinesummary, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByOnelinesummaryProfileimageid(String onelinesummary, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionPassphraseanswer(String passphrasequestion, String passphraseanswer) {
        return findByPassphrasequestionPassphraseanswer(passphrasequestion, passphraseanswer, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionPassphraseanswer(String passphrasequestion, String passphraseanswer, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmail(String passphrasequestion, String email) {
        return findByPassphrasequestionEmail(passphrasequestion, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmail(String passphrasequestion, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionLastlogindate(String passphrasequestion, java.util.Calendar lastlogindate) {
        return findByPassphrasequestionLastlogindate(passphrasequestion, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionLastlogindate(String passphrasequestion, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEntrymode(String passphrasequestion, int entrymode) {
        return findByPassphrasequestionEntrymode(passphrasequestion, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEntrymode(String passphrasequestion, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionUsertimezoneid(String passphrasequestion, String usertimezoneid) {
        return findByPassphrasequestionUsertimezoneid(passphrasequestion, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionUsertimezoneid(String passphrasequestion, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionCreatedate(String passphrasequestion, java.util.Calendar createdate) {
        return findByPassphrasequestionCreatedate(passphrasequestion, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionCreatedate(String passphrasequestion, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionIshelpon(String passphrasequestion, boolean ishelpon) {
        return findByPassphrasequestionIshelpon(passphrasequestion, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionIshelpon(String passphrasequestion, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionIsactivatedbyemail(String passphrasequestion, boolean isactivatedbyemail) {
        return findByPassphrasequestionIsactivatedbyemail(passphrasequestion, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionIsactivatedbyemail(String passphrasequestion, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmailactivationkey(String passphrasequestion, String emailactivationkey) {
        return findByPassphrasequestionEmailactivationkey(passphrasequestion, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmailactivationkey(String passphrasequestion, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmailactivationlastsent(String passphrasequestion, java.util.Calendar emailactivationlastsent) {
        return findByPassphrasequestionEmailactivationlastsent(passphrasequestion, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionEmailactivationlastsent(String passphrasequestion, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionProfileimageid(String passphrasequestion, int profileimageid) {
        return findByPassphrasequestionProfileimageid(passphrasequestion, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphrasequestionProfileimageid(String passphrasequestion, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmail(String passphraseanswer, String email) {
        return findByPassphraseanswerEmail(passphraseanswer, email, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmail(String passphraseanswer, String email, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', email='"+reger.core.Util.cleanForSQL(email)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerLastlogindate(String passphraseanswer, java.util.Calendar lastlogindate) {
        return findByPassphraseanswerLastlogindate(passphraseanswer, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerLastlogindate(String passphraseanswer, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEntrymode(String passphraseanswer, int entrymode) {
        return findByPassphraseanswerEntrymode(passphraseanswer, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEntrymode(String passphraseanswer, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerUsertimezoneid(String passphraseanswer, String usertimezoneid) {
        return findByPassphraseanswerUsertimezoneid(passphraseanswer, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerUsertimezoneid(String passphraseanswer, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerCreatedate(String passphraseanswer, java.util.Calendar createdate) {
        return findByPassphraseanswerCreatedate(passphraseanswer, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerCreatedate(String passphraseanswer, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerIshelpon(String passphraseanswer, boolean ishelpon) {
        return findByPassphraseanswerIshelpon(passphraseanswer, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerIshelpon(String passphraseanswer, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerIsactivatedbyemail(String passphraseanswer, boolean isactivatedbyemail) {
        return findByPassphraseanswerIsactivatedbyemail(passphraseanswer, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerIsactivatedbyemail(String passphraseanswer, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmailactivationkey(String passphraseanswer, String emailactivationkey) {
        return findByPassphraseanswerEmailactivationkey(passphraseanswer, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmailactivationkey(String passphraseanswer, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmailactivationlastsent(String passphraseanswer, java.util.Calendar emailactivationlastsent) {
        return findByPassphraseanswerEmailactivationlastsent(passphraseanswer, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerEmailactivationlastsent(String passphraseanswer, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerProfileimageid(String passphraseanswer, int profileimageid) {
        return findByPassphraseanswerProfileimageid(passphraseanswer, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByPassphraseanswerProfileimageid(String passphraseanswer, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailLastlogindate(String email, java.util.Calendar lastlogindate) {
        return findByEmailLastlogindate(email, lastlogindate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailLastlogindate(String email, java.util.Calendar lastlogindate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailEntrymode(String email, int entrymode) {
        return findByEmailEntrymode(email, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailEntrymode(String email, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailUsertimezoneid(String email, String usertimezoneid) {
        return findByEmailUsertimezoneid(email, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailUsertimezoneid(String email, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailCreatedate(String email, java.util.Calendar createdate) {
        return findByEmailCreatedate(email, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailCreatedate(String email, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailIshelpon(String email, boolean ishelpon) {
        return findByEmailIshelpon(email, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailIshelpon(String email, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailIsactivatedbyemail(String email, boolean isactivatedbyemail) {
        return findByEmailIsactivatedbyemail(email, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailIsactivatedbyemail(String email, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailEmailactivationkey(String email, String emailactivationkey) {
        return findByEmailEmailactivationkey(email, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailEmailactivationkey(String email, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailEmailactivationlastsent(String email, java.util.Calendar emailactivationlastsent) {
        return findByEmailEmailactivationlastsent(email, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailEmailactivationlastsent(String email, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailProfileimageid(String email, int profileimageid) {
        return findByEmailProfileimageid(email, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailProfileimageid(String email, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE email='"+reger.core.Util.cleanForSQL(email)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEntrymode(java.util.Calendar lastlogindate, int entrymode) {
        return findByLastlogindateEntrymode(lastlogindate, entrymode, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEntrymode(java.util.Calendar lastlogindate, int entrymode, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', entrymode='"+entrymode+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateUsertimezoneid(java.util.Calendar lastlogindate, String usertimezoneid) {
        return findByLastlogindateUsertimezoneid(lastlogindate, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateUsertimezoneid(java.util.Calendar lastlogindate, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateCreatedate(java.util.Calendar lastlogindate, java.util.Calendar createdate) {
        return findByLastlogindateCreatedate(lastlogindate, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateCreatedate(java.util.Calendar lastlogindate, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateIshelpon(java.util.Calendar lastlogindate, boolean ishelpon) {
        return findByLastlogindateIshelpon(lastlogindate, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateIshelpon(java.util.Calendar lastlogindate, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateIsactivatedbyemail(java.util.Calendar lastlogindate, boolean isactivatedbyemail) {
        return findByLastlogindateIsactivatedbyemail(lastlogindate, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateIsactivatedbyemail(java.util.Calendar lastlogindate, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEmailactivationkey(java.util.Calendar lastlogindate, String emailactivationkey) {
        return findByLastlogindateEmailactivationkey(lastlogindate, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEmailactivationkey(java.util.Calendar lastlogindate, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEmailactivationlastsent(java.util.Calendar lastlogindate, java.util.Calendar emailactivationlastsent) {
        return findByLastlogindateEmailactivationlastsent(lastlogindate, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateEmailactivationlastsent(java.util.Calendar lastlogindate, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateProfileimageid(java.util.Calendar lastlogindate, int profileimageid) {
        return findByLastlogindateProfileimageid(lastlogindate, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByLastlogindateProfileimageid(java.util.Calendar lastlogindate, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeUsertimezoneid(int entrymode, String usertimezoneid) {
        return findByEntrymodeUsertimezoneid(entrymode, usertimezoneid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeUsertimezoneid(int entrymode, String usertimezoneid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeCreatedate(int entrymode, java.util.Calendar createdate) {
        return findByEntrymodeCreatedate(entrymode, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeCreatedate(int entrymode, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeIshelpon(int entrymode, boolean ishelpon) {
        return findByEntrymodeIshelpon(entrymode, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeIshelpon(int entrymode, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeIsactivatedbyemail(int entrymode, boolean isactivatedbyemail) {
        return findByEntrymodeIsactivatedbyemail(entrymode, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeIsactivatedbyemail(int entrymode, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeEmailactivationkey(int entrymode, String emailactivationkey) {
        return findByEntrymodeEmailactivationkey(entrymode, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeEmailactivationkey(int entrymode, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeEmailactivationlastsent(int entrymode, java.util.Calendar emailactivationlastsent) {
        return findByEntrymodeEmailactivationlastsent(entrymode, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeEmailactivationlastsent(int entrymode, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeProfileimageid(int entrymode, int profileimageid) {
        return findByEntrymodeProfileimageid(entrymode, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEntrymodeProfileimageid(int entrymode, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE entrymode='"+entrymode+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidCreatedate(String usertimezoneid, java.util.Calendar createdate) {
        return findByUsertimezoneidCreatedate(usertimezoneid, createdate, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidCreatedate(String usertimezoneid, java.util.Calendar createdate, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidIshelpon(String usertimezoneid, boolean ishelpon) {
        return findByUsertimezoneidIshelpon(usertimezoneid, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidIshelpon(String usertimezoneid, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidIsactivatedbyemail(String usertimezoneid, boolean isactivatedbyemail) {
        return findByUsertimezoneidIsactivatedbyemail(usertimezoneid, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidIsactivatedbyemail(String usertimezoneid, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidEmailactivationkey(String usertimezoneid, String emailactivationkey) {
        return findByUsertimezoneidEmailactivationkey(usertimezoneid, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidEmailactivationkey(String usertimezoneid, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidEmailactivationlastsent(String usertimezoneid, java.util.Calendar emailactivationlastsent) {
        return findByUsertimezoneidEmailactivationlastsent(usertimezoneid, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidEmailactivationlastsent(String usertimezoneid, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidProfileimageid(String usertimezoneid, int profileimageid) {
        return findByUsertimezoneidProfileimageid(usertimezoneid, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByUsertimezoneidProfileimageid(String usertimezoneid, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedateIshelpon(java.util.Calendar createdate, boolean ishelpon) {
        return findByCreatedateIshelpon(createdate, ishelpon, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedateIshelpon(java.util.Calendar createdate, boolean ishelpon, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedateIsactivatedbyemail(java.util.Calendar createdate, boolean isactivatedbyemail) {
        return findByCreatedateIsactivatedbyemail(createdate, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedateIsactivatedbyemail(java.util.Calendar createdate, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedateEmailactivationkey(java.util.Calendar createdate, String emailactivationkey) {
        return findByCreatedateEmailactivationkey(createdate, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedateEmailactivationkey(java.util.Calendar createdate, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedateEmailactivationlastsent(java.util.Calendar createdate, java.util.Calendar emailactivationlastsent) {
        return findByCreatedateEmailactivationlastsent(createdate, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedateEmailactivationlastsent(java.util.Calendar createdate, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByCreatedateProfileimageid(java.util.Calendar createdate, int profileimageid) {
        return findByCreatedateProfileimageid(createdate, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByCreatedateProfileimageid(java.util.Calendar createdate, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIshelponIsactivatedbyemail(boolean ishelpon, boolean isactivatedbyemail) {
        return findByIshelponIsactivatedbyemail(ishelpon, isactivatedbyemail, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIshelponIsactivatedbyemail(boolean ishelpon, boolean isactivatedbyemail, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIshelponEmailactivationkey(boolean ishelpon, String emailactivationkey) {
        return findByIshelponEmailactivationkey(ishelpon, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIshelponEmailactivationkey(boolean ishelpon, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIshelponEmailactivationlastsent(boolean ishelpon, java.util.Calendar emailactivationlastsent) {
        return findByIshelponEmailactivationlastsent(ishelpon, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIshelponEmailactivationlastsent(boolean ishelpon, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIshelponProfileimageid(boolean ishelpon, int profileimageid) {
        return findByIshelponProfileimageid(ishelpon, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIshelponProfileimageid(boolean ishelpon, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailEmailactivationkey(boolean isactivatedbyemail, String emailactivationkey) {
        return findByIsactivatedbyemailEmailactivationkey(isactivatedbyemail, emailactivationkey, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailEmailactivationkey(boolean isactivatedbyemail, String emailactivationkey, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailEmailactivationlastsent(boolean isactivatedbyemail, java.util.Calendar emailactivationlastsent) {
        return findByIsactivatedbyemailEmailactivationlastsent(isactivatedbyemail, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailEmailactivationlastsent(boolean isactivatedbyemail, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailProfileimageid(boolean isactivatedbyemail, int profileimageid) {
        return findByIsactivatedbyemailProfileimageid(isactivatedbyemail, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByIsactivatedbyemailProfileimageid(boolean isactivatedbyemail, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkeyEmailactivationlastsent(String emailactivationkey, java.util.Calendar emailactivationlastsent) {
        return findByEmailactivationkeyEmailactivationlastsent(emailactivationkey, emailactivationlastsent, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkeyEmailactivationlastsent(String emailactivationkey, java.util.Calendar emailactivationlastsent, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkeyProfileimageid(String emailactivationkey, int profileimageid) {
        return findByEmailactivationkeyProfileimageid(emailactivationkey, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationkeyProfileimageid(String emailactivationkey, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationlastsentProfileimageid(java.util.Calendar emailactivationlastsent, int profileimageid) {
        return findByEmailactivationlastsentProfileimageid(emailactivationlastsent, profileimageid, 0, 50000);
    }

    public static ArrayList<AccountuserDAO> findByEmailactivationlastsentProfileimageid(java.util.Calendar emailactivationlastsent, int profileimageid, int limitmin, int limitmax) {
        ArrayList<AccountuserDAO> resultarraylist = new ArrayList<AccountuserDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"', profileimageid='"+profileimageid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountuserDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}