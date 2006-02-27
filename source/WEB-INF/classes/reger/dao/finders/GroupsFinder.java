package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.GroupsDAO;

/**
 * Finder for the 'groups' DAO
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

public class GroupsFinder {


    public static ArrayList<GroupsDAO> findByGroupid(int groupid) {
        return findByGroupid(groupid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupid(int groupid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByName(String name) {
        return findByName(name, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByName(String name, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByDescription(String description) {
        return findByDescription(description, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByDescription(String description, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivate(int entriesareprivate) {
        return findByEntriesareprivate(entriesareprivate, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivate(int entriesareprivate, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE entriesareprivate='"+entriesareprivate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderated(boolean membershipismoderated) {
        return findByMembershipismoderated(membershipismoderated, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderated(boolean membershipismoderated, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByPlid(int plid) {
        return findByPlid(plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByPlid(int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidName(int groupid, String name) {
        return findByGroupidName(groupid, name, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidName(int groupid, String name, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', name='"+reger.core.Util.cleanForSQL(name)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidDescription(int groupid, String description) {
        return findByGroupidDescription(groupid, description, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidDescription(int groupid, String description, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidEntriesareprivate(int groupid, int entriesareprivate) {
        return findByGroupidEntriesareprivate(groupid, entriesareprivate, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidEntriesareprivate(int groupid, int entriesareprivate, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', entriesareprivate='"+entriesareprivate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidMembershipismoderated(int groupid, boolean membershipismoderated) {
        return findByGroupidMembershipismoderated(groupid, membershipismoderated, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidMembershipismoderated(int groupid, boolean membershipismoderated, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidPlid(int groupid, int plid) {
        return findByGroupidPlid(groupid, plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidPlid(int groupid, int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByGroupidAccountuserid(int groupid, int accountuserid) {
        return findByGroupidAccountuserid(groupid, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByGroupidAccountuserid(int groupid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByNameDescription(String name, String description) {
        return findByNameDescription(name, description, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByNameDescription(String name, String description, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"', description='"+reger.core.Util.cleanForSQL(description)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByNameEntriesareprivate(String name, int entriesareprivate) {
        return findByNameEntriesareprivate(name, entriesareprivate, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByNameEntriesareprivate(String name, int entriesareprivate, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"', entriesareprivate='"+entriesareprivate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByNameMembershipismoderated(String name, boolean membershipismoderated) {
        return findByNameMembershipismoderated(name, membershipismoderated, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByNameMembershipismoderated(String name, boolean membershipismoderated, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByNamePlid(String name, int plid) {
        return findByNamePlid(name, plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByNamePlid(String name, int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByNameAccountuserid(String name, int accountuserid) {
        return findByNameAccountuserid(name, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByNameAccountuserid(String name, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByDescriptionEntriesareprivate(String description, int entriesareprivate) {
        return findByDescriptionEntriesareprivate(description, entriesareprivate, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByDescriptionEntriesareprivate(String description, int entriesareprivate, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE description='"+reger.core.Util.cleanForSQL(description)+"', entriesareprivate='"+entriesareprivate+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByDescriptionMembershipismoderated(String description, boolean membershipismoderated) {
        return findByDescriptionMembershipismoderated(description, membershipismoderated, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByDescriptionMembershipismoderated(String description, boolean membershipismoderated, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE description='"+reger.core.Util.cleanForSQL(description)+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByDescriptionPlid(String description, int plid) {
        return findByDescriptionPlid(description, plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByDescriptionPlid(String description, int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE description='"+reger.core.Util.cleanForSQL(description)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByDescriptionAccountuserid(String description, int accountuserid) {
        return findByDescriptionAccountuserid(description, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByDescriptionAccountuserid(String description, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE description='"+reger.core.Util.cleanForSQL(description)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivateMembershipismoderated(int entriesareprivate, boolean membershipismoderated) {
        return findByEntriesareprivateMembershipismoderated(entriesareprivate, membershipismoderated, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivateMembershipismoderated(int entriesareprivate, boolean membershipismoderated, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE entriesareprivate='"+entriesareprivate+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivatePlid(int entriesareprivate, int plid) {
        return findByEntriesareprivatePlid(entriesareprivate, plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivatePlid(int entriesareprivate, int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE entriesareprivate='"+entriesareprivate+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivateAccountuserid(int entriesareprivate, int accountuserid) {
        return findByEntriesareprivateAccountuserid(entriesareprivate, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByEntriesareprivateAccountuserid(int entriesareprivate, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE entriesareprivate='"+entriesareprivate+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderatedPlid(boolean membershipismoderated, int plid) {
        return findByMembershipismoderatedPlid(membershipismoderated, plid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderatedPlid(boolean membershipismoderated, int plid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', plid='"+plid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderatedAccountuserid(boolean membershipismoderated, int accountuserid) {
        return findByMembershipismoderatedAccountuserid(membershipismoderated, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByMembershipismoderatedAccountuserid(boolean membershipismoderated, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupsDAO> findByPlidAccountuserid(int plid, int accountuserid) {
        return findByPlidAccountuserid(plid, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupsDAO> findByPlidAccountuserid(int plid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupsDAO> resultarraylist = new ArrayList<GroupsDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE plid='"+plid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupsDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}