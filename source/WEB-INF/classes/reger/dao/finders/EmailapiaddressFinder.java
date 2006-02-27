package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EmailapiaddressDAO;

/**
 * Finder for the 'emailapiaddress' DAO
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

public class EmailapiaddressFinder {


    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressid(int emailapiaddressid) {
        return findByEmailapiaddressid(emailapiaddressid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressid(int emailapiaddressid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekey(String uniquekey) {
        return findByUniquekey(uniquekey, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekey(String uniquekey, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailtype(int emailtype) {
        return findByEmailtype(emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailtype(int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidUniquekey(int emailapiaddressid, String uniquekey) {
        return findByEmailapiaddressidUniquekey(emailapiaddressid, uniquekey, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidUniquekey(int emailapiaddressid, String uniquekey, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"', uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidAccountuserid(int emailapiaddressid, int accountuserid) {
        return findByEmailapiaddressidAccountuserid(emailapiaddressid, accountuserid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidAccountuserid(int emailapiaddressid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidAccountid(int emailapiaddressid, int accountid) {
        return findByEmailapiaddressidAccountid(emailapiaddressid, accountid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidAccountid(int emailapiaddressid, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidLogid(int emailapiaddressid, int logid) {
        return findByEmailapiaddressidLogid(emailapiaddressid, logid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidLogid(int emailapiaddressid, int logid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidEmailtype(int emailapiaddressid, int emailtype) {
        return findByEmailapiaddressidEmailtype(emailapiaddressid, emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByEmailapiaddressidEmailtype(int emailapiaddressid, int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"', emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyAccountuserid(String uniquekey, int accountuserid) {
        return findByUniquekeyAccountuserid(uniquekey, accountuserid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyAccountuserid(String uniquekey, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyAccountid(String uniquekey, int accountid) {
        return findByUniquekeyAccountid(uniquekey, accountid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyAccountid(String uniquekey, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyLogid(String uniquekey, int logid) {
        return findByUniquekeyLogid(uniquekey, logid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyLogid(String uniquekey, int logid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyEmailtype(String uniquekey, int emailtype) {
        return findByUniquekeyEmailtype(uniquekey, emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByUniquekeyEmailtype(String uniquekey, int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"', emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridAccountid(int accountuserid, int accountid) {
        return findByAccountuseridAccountid(accountuserid, accountid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridAccountid(int accountuserid, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridLogid(int accountuserid, int logid) {
        return findByAccountuseridLogid(accountuserid, logid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridLogid(int accountuserid, int logid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridEmailtype(int accountuserid, int emailtype) {
        return findByAccountuseridEmailtype(accountuserid, emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountuseridEmailtype(int accountuserid, int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"', emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountidLogid(int accountid, int logid) {
        return findByAccountidLogid(accountid, logid, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountidLogid(int accountid, int logid, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountid='"+accountid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountidEmailtype(int accountid, int emailtype) {
        return findByAccountidEmailtype(accountid, emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByAccountidEmailtype(int accountid, int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountid='"+accountid+"', emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiaddressDAO> findByLogidEmailtype(int logid, int emailtype) {
        return findByLogidEmailtype(logid, emailtype, 0, 50000);
    }

    public static ArrayList<EmailapiaddressDAO> findByLogidEmailtype(int logid, int emailtype, int limitmin, int limitmax) {
        ArrayList<EmailapiaddressDAO> resultarraylist = new ArrayList<EmailapiaddressDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE logid='"+logid+"', emailtype='"+emailtype+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiaddressDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}