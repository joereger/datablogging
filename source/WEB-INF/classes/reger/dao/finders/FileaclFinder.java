package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.FileaclDAO;

/**
 * Finder for the 'fileacl' DAO
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

public class FileaclFinder {


    public static ArrayList<FileaclDAO> findByFileaclid(int fileaclid) {
        return findByFileaclid(fileaclid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByFileaclid(int fileaclid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByPathandorfilename(String pathandorfilename) {
        return findByPathandorfilename(pathandorfilename, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByPathandorfilename(String pathandorfilename, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByFileaclidAccountid(int fileaclid, int accountid) {
        return findByFileaclidAccountid(fileaclid, accountid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByFileaclidAccountid(int fileaclid, int accountid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByFileaclidAccountuserid(int fileaclid, int accountuserid) {
        return findByFileaclidAccountuserid(fileaclid, accountuserid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByFileaclidAccountuserid(int fileaclid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByFileaclidPathandorfilename(int fileaclid, String pathandorfilename) {
        return findByFileaclidPathandorfilename(fileaclid, pathandorfilename, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByFileaclidPathandorfilename(int fileaclid, String pathandorfilename, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid+"', pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByAccountidAccountuserid(int accountid, int accountuserid) {
        return findByAccountidAccountuserid(accountid, accountuserid, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByAccountidAccountuserid(int accountid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountid='"+accountid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByAccountidPathandorfilename(int accountid, String pathandorfilename) {
        return findByAccountidPathandorfilename(accountid, pathandorfilename, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByAccountidPathandorfilename(int accountid, String pathandorfilename, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountid='"+accountid+"', pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<FileaclDAO> findByAccountuseridPathandorfilename(int accountuserid, String pathandorfilename) {
        return findByAccountuseridPathandorfilename(accountuserid, pathandorfilename, 0, 50000);
    }

    public static ArrayList<FileaclDAO> findByAccountuseridPathandorfilename(int accountuserid, String pathandorfilename, int limitmin, int limitmax) {
        ArrayList<FileaclDAO> resultarraylist = new ArrayList<FileaclDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountuserid='"+accountuserid+"', pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new FileaclDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}