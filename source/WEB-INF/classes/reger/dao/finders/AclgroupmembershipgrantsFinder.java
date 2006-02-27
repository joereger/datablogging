package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.AclgroupmembershipgrantsDAO;

/**
 * Finder for the 'aclgroupmembershipgrants' DAO
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

public class AclgroupmembershipgrantsFinder {


    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsid(int aclgroupmembershipgrantsid) {
        return findByAclgroupmembershipgrantsid(aclgroupmembershipgrantsid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsid(int aclgroupmembershipgrantsid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupid(int aclgroupid) {
        return findByAclgroupid(aclgroupid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupid(int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclobjectid(int aclobjectid) {
        return findByAclobjectid(aclobjectid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclobjectid(int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsidAclgroupid(int aclgroupmembershipgrantsid, int aclgroupid) {
        return findByAclgroupmembershipgrantsidAclgroupid(aclgroupmembershipgrantsid, aclgroupid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsidAclgroupid(int aclgroupmembershipgrantsid, int aclgroupid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"', aclgroupid='"+aclgroupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsidAclobjectid(int aclgroupmembershipgrantsid, int aclobjectid) {
        return findByAclgroupmembershipgrantsidAclobjectid(aclgroupmembershipgrantsid, aclobjectid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupmembershipgrantsidAclobjectid(int aclgroupmembershipgrantsid, int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"', aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupidAclobjectid(int aclgroupid, int aclobjectid) {
        return findByAclgroupidAclobjectid(aclgroupid, aclobjectid, 0, 50000);
    }

    public static ArrayList<AclgroupmembershipgrantsDAO> findByAclgroupidAclobjectid(int aclgroupid, int aclobjectid, int limitmin, int limitmax) {
        ArrayList<AclgroupmembershipgrantsDAO> resultarraylist = new ArrayList<AclgroupmembershipgrantsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupid='"+aclgroupid+"', aclobjectid='"+aclobjectid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new AclgroupmembershipgrantsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}