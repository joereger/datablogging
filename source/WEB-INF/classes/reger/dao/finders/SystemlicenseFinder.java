package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.SystemlicenseDAO;

/**
 * Finder for the 'systemlicense' DAO
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

public class SystemlicenseFinder {


    public static ArrayList<SystemlicenseDAO> findBySystemlicenseid(int systemlicenseid) {
        return findBySystemlicenseid(systemlicenseid, 0, 50000);
    }

    public static ArrayList<SystemlicenseDAO> findBySystemlicenseid(int systemlicenseid, int limitmin, int limitmax) {
        ArrayList<SystemlicenseDAO> resultarraylist = new ArrayList<SystemlicenseDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemlicenseid FROM systemlicense WHERE systemlicenseid='"+systemlicenseid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemlicenseDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemlicenseDAO> findByEncryptedlicense(String encryptedlicense) {
        return findByEncryptedlicense(encryptedlicense, 0, 50000);
    }

    public static ArrayList<SystemlicenseDAO> findByEncryptedlicense(String encryptedlicense, int limitmin, int limitmax) {
        ArrayList<SystemlicenseDAO> resultarraylist = new ArrayList<SystemlicenseDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemlicenseid FROM systemlicense WHERE encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemlicenseDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<SystemlicenseDAO> findBySystemlicenseidEncryptedlicense(int systemlicenseid, String encryptedlicense) {
        return findBySystemlicenseidEncryptedlicense(systemlicenseid, encryptedlicense, 0, 50000);
    }

    public static ArrayList<SystemlicenseDAO> findBySystemlicenseidEncryptedlicense(int systemlicenseid, String encryptedlicense, int limitmin, int limitmax) {
        ArrayList<SystemlicenseDAO> resultarraylist = new ArrayList<SystemlicenseDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT systemlicenseid FROM systemlicense WHERE systemlicenseid='"+systemlicenseid+"', encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new SystemlicenseDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}