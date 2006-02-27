package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.MegaoptionDAO;

/**
 * Finder for the 'megaoption' DAO
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

public class MegaoptionFinder {


    public static ArrayList<MegaoptionDAO> findByMegaoptionid(int megaoptionid) {
        return findByMegaoptionid(megaoptionid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionid(int megaoptionid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogid(int logid) {
        return findByLogid(logid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogid(int logid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldid(int megafieldid) {
        return findByMegafieldid(megafieldid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldid(int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontext(String optiontext) {
        return findByOptiontext(optiontext, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontext(String optiontext, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverride(String optiontextdisplayoverride) {
        return findByOptiontextdisplayoverride(optiontextdisplayoverride, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverride(String optiontextdisplayoverride, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByIsdefault(boolean isdefault) {
        return findByIsdefault(isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByIsdefault(boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByIsactive(boolean isactive) {
        return findByIsactive(isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByIsactive(boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidLogid(int megaoptionid, int logid) {
        return findByMegaoptionidLogid(megaoptionid, logid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidLogid(int megaoptionid, int logid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', logid='"+logid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidMegafieldid(int megaoptionid, int megafieldid) {
        return findByMegaoptionidMegafieldid(megaoptionid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidMegafieldid(int megaoptionid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidOptiontext(int megaoptionid, String optiontext) {
        return findByMegaoptionidOptiontext(megaoptionid, optiontext, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidOptiontext(int megaoptionid, String optiontext, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidOptiontextdisplayoverride(int megaoptionid, String optiontextdisplayoverride) {
        return findByMegaoptionidOptiontextdisplayoverride(megaoptionid, optiontextdisplayoverride, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidOptiontextdisplayoverride(int megaoptionid, String optiontextdisplayoverride, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidIsdefault(int megaoptionid, boolean isdefault) {
        return findByMegaoptionidIsdefault(megaoptionid, isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidIsdefault(int megaoptionid, boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidIsactive(int megaoptionid, boolean isactive) {
        return findByMegaoptionidIsactive(megaoptionid, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegaoptionidIsactive(int megaoptionid, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogidMegafieldid(int logid, int megafieldid) {
        return findByLogidMegafieldid(logid, megafieldid, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogidMegafieldid(int logid, int megafieldid, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"', megafieldid='"+megafieldid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogidOptiontext(int logid, String optiontext) {
        return findByLogidOptiontext(logid, optiontext, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogidOptiontext(int logid, String optiontext, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"', optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogidOptiontextdisplayoverride(int logid, String optiontextdisplayoverride) {
        return findByLogidOptiontextdisplayoverride(logid, optiontextdisplayoverride, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogidOptiontextdisplayoverride(int logid, String optiontextdisplayoverride, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"', optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogidIsdefault(int logid, boolean isdefault) {
        return findByLogidIsdefault(logid, isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogidIsdefault(int logid, boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByLogidIsactive(int logid, boolean isactive) {
        return findByLogidIsactive(logid, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByLogidIsactive(int logid, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+logid+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidOptiontext(int megafieldid, String optiontext) {
        return findByMegafieldidOptiontext(megafieldid, optiontext, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidOptiontext(int megafieldid, String optiontext, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megafieldid='"+megafieldid+"', optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidOptiontextdisplayoverride(int megafieldid, String optiontextdisplayoverride) {
        return findByMegafieldidOptiontextdisplayoverride(megafieldid, optiontextdisplayoverride, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidOptiontextdisplayoverride(int megafieldid, String optiontextdisplayoverride, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megafieldid='"+megafieldid+"', optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidIsdefault(int megafieldid, boolean isdefault) {
        return findByMegafieldidIsdefault(megafieldid, isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidIsdefault(int megafieldid, boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megafieldid='"+megafieldid+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidIsactive(int megafieldid, boolean isactive) {
        return findByMegafieldidIsactive(megafieldid, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByMegafieldidIsactive(int megafieldid, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megafieldid='"+megafieldid+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextOptiontextdisplayoverride(String optiontext, String optiontextdisplayoverride) {
        return findByOptiontextOptiontextdisplayoverride(optiontext, optiontextdisplayoverride, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextOptiontextdisplayoverride(String optiontext, String optiontextdisplayoverride, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"', optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextIsdefault(String optiontext, boolean isdefault) {
        return findByOptiontextIsdefault(optiontext, isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextIsdefault(String optiontext, boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextIsactive(String optiontext, boolean isactive) {
        return findByOptiontextIsactive(optiontext, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextIsactive(String optiontext, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverrideIsdefault(String optiontextdisplayoverride, boolean isdefault) {
        return findByOptiontextdisplayoverrideIsdefault(optiontextdisplayoverride, isdefault, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverrideIsdefault(String optiontextdisplayoverride, boolean isdefault, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverrideIsactive(String optiontextdisplayoverride, boolean isactive) {
        return findByOptiontextdisplayoverrideIsactive(optiontextdisplayoverride, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByOptiontextdisplayoverrideIsactive(String optiontextdisplayoverride, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<MegaoptionDAO> findByIsdefaultIsactive(boolean isdefault, boolean isactive) {
        return findByIsdefaultIsactive(isdefault, isactive, 0, 50000);
    }

    public static ArrayList<MegaoptionDAO> findByIsdefaultIsactive(boolean isdefault, boolean isactive, int limitmin, int limitmax) {
        ArrayList<MegaoptionDAO> resultarraylist = new ArrayList<MegaoptionDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new MegaoptionDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}