package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccountusertypeDAO;

/**
 * Finder for the 'accountusertype' DAO
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

public class AccountusertypeFinder {


    public static ArrayList<AccountusertypeDAO> findByAccountusertypeid(int accountusertypeid) {
        return findByAccountusertypeid(accountusertypeid, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByAccountusertypeid(int accountusertypeid, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountusertypeDAO> findByType(String type) {
        return findByType(type, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByType(String type, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE type='"+reger.core.Util.cleanForSQL(type)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountusertypeDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountusertypeDAO> findByAccountusertypeidType(int accountusertypeid, String type) {
        return findByAccountusertypeidType(accountusertypeid, type, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByAccountusertypeidType(int accountusertypeid, String type, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"', type='"+reger.core.Util.cleanForSQL(type)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountusertypeDAO> findByAccountusertypeidDescription(int accountusertypeid, String description) {
        return findByAccountusertypeidDescription(accountusertypeid, description, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByAccountusertypeidDescription(int accountusertypeid, String description, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccountusertypeDAO> findByTypeDescription(String type, String description) {
        return findByTypeDescription(type, description, 0, 50000);
    }

    public static ArrayList<AccountusertypeDAO> findByTypeDescription(String type, String description, int limitmin, int limitmax) {
        ArrayList<AccountusertypeDAO> resultarraylist = new ArrayList<AccountusertypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE type='"+reger.core.Util.cleanForSQL(type)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccountusertypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}