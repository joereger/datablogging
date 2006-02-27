package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.VstransactionDAO;

/**
 * Finder for the 'vstransaction' DAO
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

public class VstransactionFinder {


    public static ArrayList<VstransactionDAO> findByVstransactionid(int vstransactionid) {
        return findByVstransactionid(vstransactionid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionid(int vstransactionid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetime(java.util.Calendar datetime) {
        return findByDatetime(datetime, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetime(java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstring(String vssentstring) {
        return findByVssentstring(vssentstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstring(String vssentstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstring(String vsresultstring) {
        return findByVsresultstring(vsresultstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstring(String vsresultstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddress(String hostaddress) {
        return findByHostaddress(hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddress(String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResult(String result) {
        return findByResult(result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResult(String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcct(String acct) {
        return findByAcct(acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcct(String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAmt(String amt) {
        return findByAmt(amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAmt(String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByStreet(String street) {
        return findByStreet(street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByStreet(String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByZip(String zip) {
        return findByZip(zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByZip(String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByRpref(String rpref) {
        return findByRpref(rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByRpref(String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByProfileid(String profileid) {
        return findByProfileid(profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByProfileid(String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAccountid(int vstransactionid, int accountid) {
        return findByVstransactionidAccountid(vstransactionid, accountid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAccountid(int vstransactionid, int accountid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidDatetime(int vstransactionid, java.util.Calendar datetime) {
        return findByVstransactionidDatetime(vstransactionid, datetime, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidDatetime(int vstransactionid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidVssentstring(int vstransactionid, String vssentstring) {
        return findByVstransactionidVssentstring(vstransactionid, vssentstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidVssentstring(int vstransactionid, String vssentstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidVsresultstring(int vstransactionid, String vsresultstring) {
        return findByVstransactionidVsresultstring(vstransactionid, vsresultstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidVsresultstring(int vstransactionid, String vsresultstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidHostaddress(int vstransactionid, String hostaddress) {
        return findByVstransactionidHostaddress(vstransactionid, hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidHostaddress(int vstransactionid, String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidResult(int vstransactionid, String result) {
        return findByVstransactionidResult(vstransactionid, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidResult(int vstransactionid, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAcct(int vstransactionid, String acct) {
        return findByVstransactionidAcct(vstransactionid, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAcct(int vstransactionid, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAmt(int vstransactionid, String amt) {
        return findByVstransactionidAmt(vstransactionid, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidAmt(int vstransactionid, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidStreet(int vstransactionid, String street) {
        return findByVstransactionidStreet(vstransactionid, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidStreet(int vstransactionid, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidZip(int vstransactionid, String zip) {
        return findByVstransactionidZip(vstransactionid, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidZip(int vstransactionid, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidRpref(int vstransactionid, String rpref) {
        return findByVstransactionidRpref(vstransactionid, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidRpref(int vstransactionid, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidProfileid(int vstransactionid, String profileid) {
        return findByVstransactionidProfileid(vstransactionid, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVstransactionidProfileid(int vstransactionid, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidDatetime(int accountid, java.util.Calendar datetime) {
        return findByAccountidDatetime(accountid, datetime, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidDatetime(int accountid, java.util.Calendar datetime, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidVssentstring(int accountid, String vssentstring) {
        return findByAccountidVssentstring(accountid, vssentstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidVssentstring(int accountid, String vssentstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidVsresultstring(int accountid, String vsresultstring) {
        return findByAccountidVsresultstring(accountid, vsresultstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidVsresultstring(int accountid, String vsresultstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidHostaddress(int accountid, String hostaddress) {
        return findByAccountidHostaddress(accountid, hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidHostaddress(int accountid, String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidResult(int accountid, String result) {
        return findByAccountidResult(accountid, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidResult(int accountid, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidAcct(int accountid, String acct) {
        return findByAccountidAcct(accountid, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidAcct(int accountid, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidAmt(int accountid, String amt) {
        return findByAccountidAmt(accountid, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidAmt(int accountid, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidStreet(int accountid, String street) {
        return findByAccountidStreet(accountid, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidStreet(int accountid, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidZip(int accountid, String zip) {
        return findByAccountidZip(accountid, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidZip(int accountid, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidRpref(int accountid, String rpref) {
        return findByAccountidRpref(accountid, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidRpref(int accountid, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAccountidProfileid(int accountid, String profileid) {
        return findByAccountidProfileid(accountid, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAccountidProfileid(int accountid, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE accountid='"+accountid+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeVssentstring(java.util.Calendar datetime, String vssentstring) {
        return findByDatetimeVssentstring(datetime, vssentstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeVssentstring(java.util.Calendar datetime, String vssentstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeVsresultstring(java.util.Calendar datetime, String vsresultstring) {
        return findByDatetimeVsresultstring(datetime, vsresultstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeVsresultstring(java.util.Calendar datetime, String vsresultstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeHostaddress(java.util.Calendar datetime, String hostaddress) {
        return findByDatetimeHostaddress(datetime, hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeHostaddress(java.util.Calendar datetime, String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeResult(java.util.Calendar datetime, String result) {
        return findByDatetimeResult(datetime, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeResult(java.util.Calendar datetime, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeAcct(java.util.Calendar datetime, String acct) {
        return findByDatetimeAcct(datetime, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeAcct(java.util.Calendar datetime, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeAmt(java.util.Calendar datetime, String amt) {
        return findByDatetimeAmt(datetime, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeAmt(java.util.Calendar datetime, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeStreet(java.util.Calendar datetime, String street) {
        return findByDatetimeStreet(datetime, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeStreet(java.util.Calendar datetime, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeZip(java.util.Calendar datetime, String zip) {
        return findByDatetimeZip(datetime, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeZip(java.util.Calendar datetime, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeRpref(java.util.Calendar datetime, String rpref) {
        return findByDatetimeRpref(datetime, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeRpref(java.util.Calendar datetime, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByDatetimeProfileid(java.util.Calendar datetime, String profileid) {
        return findByDatetimeProfileid(datetime, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByDatetimeProfileid(java.util.Calendar datetime, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringVsresultstring(String vssentstring, String vsresultstring) {
        return findByVssentstringVsresultstring(vssentstring, vsresultstring, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringVsresultstring(String vssentstring, String vsresultstring, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringHostaddress(String vssentstring, String hostaddress) {
        return findByVssentstringHostaddress(vssentstring, hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringHostaddress(String vssentstring, String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringResult(String vssentstring, String result) {
        return findByVssentstringResult(vssentstring, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringResult(String vssentstring, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringAcct(String vssentstring, String acct) {
        return findByVssentstringAcct(vssentstring, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringAcct(String vssentstring, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringAmt(String vssentstring, String amt) {
        return findByVssentstringAmt(vssentstring, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringAmt(String vssentstring, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringStreet(String vssentstring, String street) {
        return findByVssentstringStreet(vssentstring, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringStreet(String vssentstring, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringZip(String vssentstring, String zip) {
        return findByVssentstringZip(vssentstring, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringZip(String vssentstring, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringRpref(String vssentstring, String rpref) {
        return findByVssentstringRpref(vssentstring, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringRpref(String vssentstring, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVssentstringProfileid(String vssentstring, String profileid) {
        return findByVssentstringProfileid(vssentstring, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVssentstringProfileid(String vssentstring, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringHostaddress(String vsresultstring, String hostaddress) {
        return findByVsresultstringHostaddress(vsresultstring, hostaddress, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringHostaddress(String vsresultstring, String hostaddress, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringResult(String vsresultstring, String result) {
        return findByVsresultstringResult(vsresultstring, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringResult(String vsresultstring, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringAcct(String vsresultstring, String acct) {
        return findByVsresultstringAcct(vsresultstring, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringAcct(String vsresultstring, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringAmt(String vsresultstring, String amt) {
        return findByVsresultstringAmt(vsresultstring, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringAmt(String vsresultstring, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringStreet(String vsresultstring, String street) {
        return findByVsresultstringStreet(vsresultstring, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringStreet(String vsresultstring, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringZip(String vsresultstring, String zip) {
        return findByVsresultstringZip(vsresultstring, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringZip(String vsresultstring, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringRpref(String vsresultstring, String rpref) {
        return findByVsresultstringRpref(vsresultstring, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringRpref(String vsresultstring, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringProfileid(String vsresultstring, String profileid) {
        return findByVsresultstringProfileid(vsresultstring, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByVsresultstringProfileid(String vsresultstring, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressResult(String hostaddress, String result) {
        return findByHostaddressResult(hostaddress, result, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressResult(String hostaddress, String result, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', result='"+reger.core.Util.cleanForSQL(result)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressAcct(String hostaddress, String acct) {
        return findByHostaddressAcct(hostaddress, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressAcct(String hostaddress, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressAmt(String hostaddress, String amt) {
        return findByHostaddressAmt(hostaddress, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressAmt(String hostaddress, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressStreet(String hostaddress, String street) {
        return findByHostaddressStreet(hostaddress, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressStreet(String hostaddress, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressZip(String hostaddress, String zip) {
        return findByHostaddressZip(hostaddress, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressZip(String hostaddress, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressRpref(String hostaddress, String rpref) {
        return findByHostaddressRpref(hostaddress, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressRpref(String hostaddress, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByHostaddressProfileid(String hostaddress, String profileid) {
        return findByHostaddressProfileid(hostaddress, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByHostaddressProfileid(String hostaddress, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultAcct(String result, String acct) {
        return findByResultAcct(result, acct, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultAcct(String result, String acct, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultAmt(String result, String amt) {
        return findByResultAmt(result, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultAmt(String result, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultStreet(String result, String street) {
        return findByResultStreet(result, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultStreet(String result, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultZip(String result, String zip) {
        return findByResultZip(result, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultZip(String result, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultRpref(String result, String rpref) {
        return findByResultRpref(result, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultRpref(String result, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByResultProfileid(String result, String profileid) {
        return findByResultProfileid(result, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByResultProfileid(String result, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE result='"+reger.core.Util.cleanForSQL(result)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcctAmt(String acct, String amt) {
        return findByAcctAmt(acct, amt, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcctAmt(String acct, String amt, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcctStreet(String acct, String street) {
        return findByAcctStreet(acct, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcctStreet(String acct, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcctZip(String acct, String zip) {
        return findByAcctZip(acct, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcctZip(String acct, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcctRpref(String acct, String rpref) {
        return findByAcctRpref(acct, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcctRpref(String acct, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAcctProfileid(String acct, String profileid) {
        return findByAcctProfileid(acct, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAcctProfileid(String acct, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE acct='"+reger.core.Util.cleanForSQL(acct)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAmtStreet(String amt, String street) {
        return findByAmtStreet(amt, street, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAmtStreet(String amt, String street, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE amt='"+reger.core.Util.cleanForSQL(amt)+"', street='"+reger.core.Util.cleanForSQL(street)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAmtZip(String amt, String zip) {
        return findByAmtZip(amt, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAmtZip(String amt, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE amt='"+reger.core.Util.cleanForSQL(amt)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAmtRpref(String amt, String rpref) {
        return findByAmtRpref(amt, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAmtRpref(String amt, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE amt='"+reger.core.Util.cleanForSQL(amt)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByAmtProfileid(String amt, String profileid) {
        return findByAmtProfileid(amt, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByAmtProfileid(String amt, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE amt='"+reger.core.Util.cleanForSQL(amt)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByStreetZip(String street, String zip) {
        return findByStreetZip(street, zip, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByStreetZip(String street, String zip, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE street='"+reger.core.Util.cleanForSQL(street)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByStreetRpref(String street, String rpref) {
        return findByStreetRpref(street, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByStreetRpref(String street, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE street='"+reger.core.Util.cleanForSQL(street)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByStreetProfileid(String street, String profileid) {
        return findByStreetProfileid(street, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByStreetProfileid(String street, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE street='"+reger.core.Util.cleanForSQL(street)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByZipRpref(String zip, String rpref) {
        return findByZipRpref(zip, rpref, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByZipRpref(String zip, String rpref, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE zip='"+reger.core.Util.cleanForSQL(zip)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByZipProfileid(String zip, String profileid) {
        return findByZipProfileid(zip, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByZipProfileid(String zip, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE zip='"+reger.core.Util.cleanForSQL(zip)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<VstransactionDAO> findByRprefProfileid(String rpref, String profileid) {
        return findByRprefProfileid(rpref, profileid, 0, 50000);
    }

    public static ArrayList<VstransactionDAO> findByRprefProfileid(String rpref, String profileid, int limitmin, int limitmax) {
        ArrayList<VstransactionDAO> resultarraylist = new ArrayList<VstransactionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE rpref='"+reger.core.Util.cleanForSQL(rpref)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new VstransactionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}