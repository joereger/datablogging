package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AclgroupDAO;

/**
 * Finder for the 'aclgroup' DAO
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

public class AclgroupFinder {


    public static ArrayList<AclgroupDAO> findByAclgroupid(int aclgroupid) {
        return findByAclgroupid(aclgroupid, 0, 50000);
    }

    public static ArrayList<AclgroupDAO> findByAclgroupid(int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AclgroupDAO> resultarraylist = new ArrayList<AclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupDAO> findByAclgroupname(String aclgroupname) {
        return findByAclgroupname(aclgroupname, 0, 50000);
    }

    public static ArrayList<AclgroupDAO> findByAclgroupname(String aclgroupname, int limitmin, int limitmax) {
        ArrayList<AclgroupDAO> resultarraylist = new ArrayList<AclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupDAO> findByAclgroupidAclgroupname(int aclgroupid, String aclgroupname) {
        return findByAclgroupidAclgroupname(aclgroupid, aclgroupname, 0, 50000);
    }

    public static ArrayList<AclgroupDAO> findByAclgroupidAclgroupname(int aclgroupid, String aclgroupname, int limitmin, int limitmax) {
        ArrayList<AclgroupDAO> resultarraylist = new ArrayList<AclgroupDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupid='"+aclgroupid+"', aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}