package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.OffensivecontentdefaultsDAO;

/**
 * Finder for the 'offensivecontentdefaults' DAO
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

public class OffensivecontentdefaultsFinder {


    public static ArrayList<OffensivecontentdefaultsDAO> findByOffensivecontentdefaultsid(int offensivecontentdefaultsid) {
        return findByOffensivecontentdefaultsid(offensivecontentdefaultsid, 0, 50000);
    }

    public static ArrayList<OffensivecontentdefaultsDAO> findByOffensivecontentdefaultsid(int offensivecontentdefaultsid, int limitmin, int limitmax) {
        ArrayList<OffensivecontentdefaultsDAO> resultarraylist = new ArrayList<OffensivecontentdefaultsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentdefaultsid FROM offensivecontentdefaults WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentdefaultsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentdefaultsDAO> findByContent(String content) {
        return findByContent(content, 0, 50000);
    }

    public static ArrayList<OffensivecontentdefaultsDAO> findByContent(String content, int limitmin, int limitmax) {
        ArrayList<OffensivecontentdefaultsDAO> resultarraylist = new ArrayList<OffensivecontentdefaultsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentdefaultsid FROM offensivecontentdefaults WHERE content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentdefaultsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<OffensivecontentdefaultsDAO> findByOffensivecontentdefaultsidContent(int offensivecontentdefaultsid, String content) {
        return findByOffensivecontentdefaultsidContent(offensivecontentdefaultsid, content, 0, 50000);
    }

    public static ArrayList<OffensivecontentdefaultsDAO> findByOffensivecontentdefaultsidContent(int offensivecontentdefaultsid, String content, int limitmin, int limitmax) {
        ArrayList<OffensivecontentdefaultsDAO> resultarraylist = new ArrayList<OffensivecontentdefaultsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT offensivecontentdefaultsid FROM offensivecontentdefaults WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"', content='"+reger.core.Util.cleanForSQL(content)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new OffensivecontentdefaultsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}