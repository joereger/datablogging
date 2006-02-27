package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AccounttypeDAO;

/**
 * Finder for the 'accounttype' DAO
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

public class AccounttypeFinder {


    public static ArrayList<AccounttypeDAO> findByAccounttypeid(int accounttypeid) {
        return findByAccounttypeid(accounttypeid, 0, 50000);
    }

    public static ArrayList<AccounttypeDAO> findByAccounttypeid(int accounttypeid, int limitmin, int limitmax) {
        ArrayList<AccounttypeDAO> resultarraylist = new ArrayList<AccounttypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accounttypeid FROM accounttype WHERE accounttypeid='"+accounttypeid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccounttypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccounttypeDAO> findByAccounttypename(String accounttypename) {
        return findByAccounttypename(accounttypename, 0, 50000);
    }

    public static ArrayList<AccounttypeDAO> findByAccounttypename(String accounttypename, int limitmin, int limitmax) {
        ArrayList<AccounttypeDAO> resultarraylist = new ArrayList<AccounttypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accounttypeid FROM accounttype WHERE accounttypename='"+reger.core.Util.cleanForSQL(accounttypename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccounttypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AccounttypeDAO> findByAccounttypeidAccounttypename(int accounttypeid, String accounttypename) {
        return findByAccounttypeidAccounttypename(accounttypeid, accounttypename, 0, 50000);
    }

    public static ArrayList<AccounttypeDAO> findByAccounttypeidAccounttypename(int accounttypeid, String accounttypename, int limitmin, int limitmax) {
        ArrayList<AccounttypeDAO> resultarraylist = new ArrayList<AccounttypeDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accounttypeid FROM accounttype WHERE accounttypeid='"+accounttypeid+"', accounttypename='"+reger.core.Util.cleanForSQL(accounttypename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AccounttypeDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}