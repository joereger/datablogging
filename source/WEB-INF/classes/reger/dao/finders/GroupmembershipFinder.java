package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.GroupmembershipDAO;

/**
 * Finder for the 'groupmembership' DAO
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

public class GroupmembershipFinder {


    public static ArrayList<GroupmembershipDAO> findByGroupmembershipid(int groupmembershipid) {
        return findByGroupmembershipid(groupmembershipid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipid(int groupmembershipid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupid(int groupid) {
        return findByGroupid(groupid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupid(int groupid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippublicly(boolean sharemembershippublicly) {
        return findBySharemembershippublicly(sharemembershippublicly, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippublicly(boolean sharemembershippublicly, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByIsmoderator(boolean ismoderator) {
        return findByIsmoderator(ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByIsmoderator(boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidAccountuserid(int groupmembershipid, int accountuserid) {
        return findByGroupmembershipidAccountuserid(groupmembershipid, accountuserid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidAccountuserid(int groupmembershipid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidGroupid(int groupmembershipid, int groupid) {
        return findByGroupmembershipidGroupid(groupmembershipid, groupid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidGroupid(int groupmembershipid, int groupid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidSharemembershippublicly(int groupmembershipid, boolean sharemembershippublicly) {
        return findByGroupmembershipidSharemembershippublicly(groupmembershipid, sharemembershippublicly, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidSharemembershippublicly(int groupmembershipid, boolean sharemembershippublicly, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"', sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidIsapproved(int groupmembershipid, boolean isapproved) {
        return findByGroupmembershipidIsapproved(groupmembershipid, isapproved, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidIsapproved(int groupmembershipid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidIsmoderator(int groupmembershipid, boolean ismoderator) {
        return findByGroupmembershipidIsmoderator(groupmembershipid, ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupmembershipidIsmoderator(int groupmembershipid, boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridGroupid(int accountuserid, int groupid) {
        return findByAccountuseridGroupid(accountuserid, groupid, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridGroupid(int accountuserid, int groupid, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+accountuserid+"', groupid='"+groupid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridSharemembershippublicly(int accountuserid, boolean sharemembershippublicly) {
        return findByAccountuseridSharemembershippublicly(accountuserid, sharemembershippublicly, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridSharemembershippublicly(int accountuserid, boolean sharemembershippublicly, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+accountuserid+"', sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridIsapproved(int accountuserid, boolean isapproved) {
        return findByAccountuseridIsapproved(accountuserid, isapproved, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridIsapproved(int accountuserid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+accountuserid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridIsmoderator(int accountuserid, boolean ismoderator) {
        return findByAccountuseridIsmoderator(accountuserid, ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByAccountuseridIsmoderator(int accountuserid, boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+accountuserid+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidSharemembershippublicly(int groupid, boolean sharemembershippublicly) {
        return findByGroupidSharemembershippublicly(groupid, sharemembershippublicly, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidSharemembershippublicly(int groupid, boolean sharemembershippublicly, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupid='"+groupid+"', sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidIsapproved(int groupid, boolean isapproved) {
        return findByGroupidIsapproved(groupid, isapproved, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidIsapproved(int groupid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupid='"+groupid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidIsmoderator(int groupid, boolean ismoderator) {
        return findByGroupidIsmoderator(groupid, ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByGroupidIsmoderator(int groupid, boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupid='"+groupid+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippubliclyIsapproved(boolean sharemembershippublicly, boolean isapproved) {
        return findBySharemembershippubliclyIsapproved(sharemembershippublicly, isapproved, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippubliclyIsapproved(boolean sharemembershippublicly, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippubliclyIsmoderator(boolean sharemembershippublicly, boolean ismoderator) {
        return findBySharemembershippubliclyIsmoderator(sharemembershippublicly, ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findBySharemembershippubliclyIsmoderator(boolean sharemembershippublicly, boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<GroupmembershipDAO> findByIsapprovedIsmoderator(boolean isapproved, boolean ismoderator) {
        return findByIsapprovedIsmoderator(isapproved, ismoderator, 0, 50000);
    }

    public static ArrayList<GroupmembershipDAO> findByIsapprovedIsmoderator(boolean isapproved, boolean ismoderator, int limitmin, int limitmax) {
        ArrayList<GroupmembershipDAO> resultarraylist = new ArrayList<GroupmembershipDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new GroupmembershipDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}