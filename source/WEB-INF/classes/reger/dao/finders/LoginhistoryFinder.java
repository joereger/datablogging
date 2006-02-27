package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.LoginhistoryDAO;

/**
 * Finder for the 'loginhistory' DAO
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

public class LoginhistoryFinder {


    public static ArrayList<LoginhistoryDAO> findByLoginhistoryid(int loginhistoryid) {
        return findByLoginhistoryid(loginhistoryid, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryid(int loginhistoryid, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByDate(java.util.Calendar date) {
        return findByDate(date, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByDate(java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByUsertype(String usertype) {
        return findByUsertype(usertype, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByUsertype(String usertype, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE usertype='"+reger.core.Util.cleanForSQL(usertype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByEnteredpassword(String enteredpassword) {
        return findByEnteredpassword(enteredpassword, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByEnteredpassword(String enteredpassword, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findBySuccess(boolean success) {
        return findBySuccess(success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findBySuccess(boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidAccountuserid(int loginhistoryid, int accountuserid) {
        return findByLoginhistoryidAccountuserid(loginhistoryid, accountuserid, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidAccountuserid(int loginhistoryid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidDate(int loginhistoryid, java.util.Calendar date) {
        return findByLoginhistoryidDate(loginhistoryid, date, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidDate(int loginhistoryid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidUsertype(int loginhistoryid, String usertype) {
        return findByLoginhistoryidUsertype(loginhistoryid, usertype, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidUsertype(int loginhistoryid, String usertype, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"', usertype='"+reger.core.Util.cleanForSQL(usertype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidEnteredpassword(int loginhistoryid, String enteredpassword) {
        return findByLoginhistoryidEnteredpassword(loginhistoryid, enteredpassword, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidEnteredpassword(int loginhistoryid, String enteredpassword, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"', enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidSuccess(int loginhistoryid, boolean success) {
        return findByLoginhistoryidSuccess(loginhistoryid, success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByLoginhistoryidSuccess(int loginhistoryid, boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"', success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridDate(int accountuserid, java.util.Calendar date) {
        return findByAccountuseridDate(accountuserid, date, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridDate(int accountuserid, java.util.Calendar date, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE accountuserid='"+accountuserid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridUsertype(int accountuserid, String usertype) {
        return findByAccountuseridUsertype(accountuserid, usertype, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridUsertype(int accountuserid, String usertype, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE accountuserid='"+accountuserid+"', usertype='"+reger.core.Util.cleanForSQL(usertype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridEnteredpassword(int accountuserid, String enteredpassword) {
        return findByAccountuseridEnteredpassword(accountuserid, enteredpassword, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridEnteredpassword(int accountuserid, String enteredpassword, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE accountuserid='"+accountuserid+"', enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridSuccess(int accountuserid, boolean success) {
        return findByAccountuseridSuccess(accountuserid, success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByAccountuseridSuccess(int accountuserid, boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE accountuserid='"+accountuserid+"', success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByDateUsertype(java.util.Calendar date, String usertype) {
        return findByDateUsertype(date, usertype, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByDateUsertype(java.util.Calendar date, String usertype, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', usertype='"+reger.core.Util.cleanForSQL(usertype)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByDateEnteredpassword(java.util.Calendar date, String enteredpassword) {
        return findByDateEnteredpassword(date, enteredpassword, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByDateEnteredpassword(java.util.Calendar date, String enteredpassword, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByDateSuccess(java.util.Calendar date, boolean success) {
        return findByDateSuccess(date, success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByDateSuccess(java.util.Calendar date, boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE date='"+reger.core.TimeUtils.dateformatfordb(date)+"', success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByUsertypeEnteredpassword(String usertype, String enteredpassword) {
        return findByUsertypeEnteredpassword(usertype, enteredpassword, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByUsertypeEnteredpassword(String usertype, String enteredpassword, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE usertype='"+reger.core.Util.cleanForSQL(usertype)+"', enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByUsertypeSuccess(String usertype, boolean success) {
        return findByUsertypeSuccess(usertype, success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByUsertypeSuccess(String usertype, boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE usertype='"+reger.core.Util.cleanForSQL(usertype)+"', success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<LoginhistoryDAO> findByEnteredpasswordSuccess(String enteredpassword, boolean success) {
        return findByEnteredpasswordSuccess(enteredpassword, success, 0, 50000);
    }

    public static ArrayList<LoginhistoryDAO> findByEnteredpasswordSuccess(String enteredpassword, boolean success, int limitmin, int limitmax) {
        ArrayList<LoginhistoryDAO> resultarraylist = new ArrayList<LoginhistoryDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"', success='"+reger.core.Util.booleanAsSQLText(success)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new LoginhistoryDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}