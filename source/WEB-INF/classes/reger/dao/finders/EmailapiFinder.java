package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EmailapiDAO;

/**
 * Finder for the 'emailapi' DAO
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

public class EmailapiFinder {


    public static ArrayList<EmailapiDAO> findByEmailapiid(int emailapiid) {
        return findByEmailapiid(emailapiid, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiid(int emailapiid, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuserid(int accountuserid) {
        return findByAccountuserid(accountuserid, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuserid(int accountuserid, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecret(String emailsecret) {
        return findByEmailsecret(emailsecret, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecret(String emailsecret, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubject(boolean overridecamphonesubject) {
        return findByOverridecamphonesubject(overridecamphonesubject, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubject(boolean overridecamphonesubject, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttext(String overridecamphonesubjecttext) {
        return findByOverridecamphonesubjecttext(overridecamphonesubjecttext, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttext(String overridecamphonesubjecttext, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebody(boolean ignorecamphonebody) {
        return findByIgnorecamphonebody(ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebody(boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentry(boolean consolidatecamphonetoonedailyentry) {
        return findByConsolidatecamphonetoonedailyentry(consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentry(boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraft(boolean saveemailpostsasdraft) {
        return findBySaveemailpostsasdraft(saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraft(boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findBySavecamphonepostsasdraft(boolean savecamphonepostsasdraft) {
        return findBySavecamphonepostsasdraft(savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findBySavecamphonepostsasdraft(boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByCamphoneimagetags(String camphoneimagetags) {
        return findByCamphoneimagetags(camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByCamphoneimagetags(String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidAccountuserid(int emailapiid, int accountuserid) {
        return findByEmailapiidAccountuserid(emailapiid, accountuserid, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidAccountuserid(int emailapiid, int accountuserid, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', accountuserid='"+accountuserid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidEmailsecret(int emailapiid, String emailsecret) {
        return findByEmailapiidEmailsecret(emailapiid, emailsecret, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidEmailsecret(int emailapiid, String emailsecret, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidOverridecamphonesubject(int emailapiid, boolean overridecamphonesubject) {
        return findByEmailapiidOverridecamphonesubject(emailapiid, overridecamphonesubject, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidOverridecamphonesubject(int emailapiid, boolean overridecamphonesubject, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidOverridecamphonesubjecttext(int emailapiid, String overridecamphonesubjecttext) {
        return findByEmailapiidOverridecamphonesubjecttext(emailapiid, overridecamphonesubjecttext, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidOverridecamphonesubjecttext(int emailapiid, String overridecamphonesubjecttext, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidIgnorecamphonebody(int emailapiid, boolean ignorecamphonebody) {
        return findByEmailapiidIgnorecamphonebody(emailapiid, ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidIgnorecamphonebody(int emailapiid, boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidConsolidatecamphonetoonedailyentry(int emailapiid, boolean consolidatecamphonetoonedailyentry) {
        return findByEmailapiidConsolidatecamphonetoonedailyentry(emailapiid, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidConsolidatecamphonetoonedailyentry(int emailapiid, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidSaveemailpostsasdraft(int emailapiid, boolean saveemailpostsasdraft) {
        return findByEmailapiidSaveemailpostsasdraft(emailapiid, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidSaveemailpostsasdraft(int emailapiid, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidSavecamphonepostsasdraft(int emailapiid, boolean savecamphonepostsasdraft) {
        return findByEmailapiidSavecamphonepostsasdraft(emailapiid, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidSavecamphonepostsasdraft(int emailapiid, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidCamphoneimagetags(int emailapiid, String camphoneimagetags) {
        return findByEmailapiidCamphoneimagetags(emailapiid, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailapiidCamphoneimagetags(int emailapiid, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridEmailsecret(int accountuserid, String emailsecret) {
        return findByAccountuseridEmailsecret(accountuserid, emailsecret, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridEmailsecret(int accountuserid, String emailsecret, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridOverridecamphonesubject(int accountuserid, boolean overridecamphonesubject) {
        return findByAccountuseridOverridecamphonesubject(accountuserid, overridecamphonesubject, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridOverridecamphonesubject(int accountuserid, boolean overridecamphonesubject, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridOverridecamphonesubjecttext(int accountuserid, String overridecamphonesubjecttext) {
        return findByAccountuseridOverridecamphonesubjecttext(accountuserid, overridecamphonesubjecttext, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridOverridecamphonesubjecttext(int accountuserid, String overridecamphonesubjecttext, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridIgnorecamphonebody(int accountuserid, boolean ignorecamphonebody) {
        return findByAccountuseridIgnorecamphonebody(accountuserid, ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridIgnorecamphonebody(int accountuserid, boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridConsolidatecamphonetoonedailyentry(int accountuserid, boolean consolidatecamphonetoonedailyentry) {
        return findByAccountuseridConsolidatecamphonetoonedailyentry(accountuserid, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridConsolidatecamphonetoonedailyentry(int accountuserid, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridSaveemailpostsasdraft(int accountuserid, boolean saveemailpostsasdraft) {
        return findByAccountuseridSaveemailpostsasdraft(accountuserid, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridSaveemailpostsasdraft(int accountuserid, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridSavecamphonepostsasdraft(int accountuserid, boolean savecamphonepostsasdraft) {
        return findByAccountuseridSavecamphonepostsasdraft(accountuserid, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridSavecamphonepostsasdraft(int accountuserid, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridCamphoneimagetags(int accountuserid, String camphoneimagetags) {
        return findByAccountuseridCamphoneimagetags(accountuserid, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByAccountuseridCamphoneimagetags(int accountuserid, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE accountuserid='"+accountuserid+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretOverridecamphonesubject(String emailsecret, boolean overridecamphonesubject) {
        return findByEmailsecretOverridecamphonesubject(emailsecret, overridecamphonesubject, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretOverridecamphonesubject(String emailsecret, boolean overridecamphonesubject, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretOverridecamphonesubjecttext(String emailsecret, String overridecamphonesubjecttext) {
        return findByEmailsecretOverridecamphonesubjecttext(emailsecret, overridecamphonesubjecttext, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretOverridecamphonesubjecttext(String emailsecret, String overridecamphonesubjecttext, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretIgnorecamphonebody(String emailsecret, boolean ignorecamphonebody) {
        return findByEmailsecretIgnorecamphonebody(emailsecret, ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretIgnorecamphonebody(String emailsecret, boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretConsolidatecamphonetoonedailyentry(String emailsecret, boolean consolidatecamphonetoonedailyentry) {
        return findByEmailsecretConsolidatecamphonetoonedailyentry(emailsecret, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretConsolidatecamphonetoonedailyentry(String emailsecret, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretSaveemailpostsasdraft(String emailsecret, boolean saveemailpostsasdraft) {
        return findByEmailsecretSaveemailpostsasdraft(emailsecret, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretSaveemailpostsasdraft(String emailsecret, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretSavecamphonepostsasdraft(String emailsecret, boolean savecamphonepostsasdraft) {
        return findByEmailsecretSavecamphonepostsasdraft(emailsecret, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretSavecamphonepostsasdraft(String emailsecret, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretCamphoneimagetags(String emailsecret, String camphoneimagetags) {
        return findByEmailsecretCamphoneimagetags(emailsecret, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByEmailsecretCamphoneimagetags(String emailsecret, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectOverridecamphonesubjecttext(boolean overridecamphonesubject, String overridecamphonesubjecttext) {
        return findByOverridecamphonesubjectOverridecamphonesubjecttext(overridecamphonesubject, overridecamphonesubjecttext, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectOverridecamphonesubjecttext(boolean overridecamphonesubject, String overridecamphonesubjecttext, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectIgnorecamphonebody(boolean overridecamphonesubject, boolean ignorecamphonebody) {
        return findByOverridecamphonesubjectIgnorecamphonebody(overridecamphonesubject, ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectIgnorecamphonebody(boolean overridecamphonesubject, boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectConsolidatecamphonetoonedailyentry(boolean overridecamphonesubject, boolean consolidatecamphonetoonedailyentry) {
        return findByOverridecamphonesubjectConsolidatecamphonetoonedailyentry(overridecamphonesubject, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectConsolidatecamphonetoonedailyentry(boolean overridecamphonesubject, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectSaveemailpostsasdraft(boolean overridecamphonesubject, boolean saveemailpostsasdraft) {
        return findByOverridecamphonesubjectSaveemailpostsasdraft(overridecamphonesubject, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectSaveemailpostsasdraft(boolean overridecamphonesubject, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectSavecamphonepostsasdraft(boolean overridecamphonesubject, boolean savecamphonepostsasdraft) {
        return findByOverridecamphonesubjectSavecamphonepostsasdraft(overridecamphonesubject, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectSavecamphonepostsasdraft(boolean overridecamphonesubject, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectCamphoneimagetags(boolean overridecamphonesubject, String camphoneimagetags) {
        return findByOverridecamphonesubjectCamphoneimagetags(overridecamphonesubject, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjectCamphoneimagetags(boolean overridecamphonesubject, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextIgnorecamphonebody(String overridecamphonesubjecttext, boolean ignorecamphonebody) {
        return findByOverridecamphonesubjecttextIgnorecamphonebody(overridecamphonesubjecttext, ignorecamphonebody, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextIgnorecamphonebody(String overridecamphonesubjecttext, boolean ignorecamphonebody, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextConsolidatecamphonetoonedailyentry(String overridecamphonesubjecttext, boolean consolidatecamphonetoonedailyentry) {
        return findByOverridecamphonesubjecttextConsolidatecamphonetoonedailyentry(overridecamphonesubjecttext, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextConsolidatecamphonetoonedailyentry(String overridecamphonesubjecttext, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextSaveemailpostsasdraft(String overridecamphonesubjecttext, boolean saveemailpostsasdraft) {
        return findByOverridecamphonesubjecttextSaveemailpostsasdraft(overridecamphonesubjecttext, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextSaveemailpostsasdraft(String overridecamphonesubjecttext, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextSavecamphonepostsasdraft(String overridecamphonesubjecttext, boolean savecamphonepostsasdraft) {
        return findByOverridecamphonesubjecttextSavecamphonepostsasdraft(overridecamphonesubjecttext, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextSavecamphonepostsasdraft(String overridecamphonesubjecttext, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextCamphoneimagetags(String overridecamphonesubjecttext, String camphoneimagetags) {
        return findByOverridecamphonesubjecttextCamphoneimagetags(overridecamphonesubjecttext, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByOverridecamphonesubjecttextCamphoneimagetags(String overridecamphonesubjecttext, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodyConsolidatecamphonetoonedailyentry(boolean ignorecamphonebody, boolean consolidatecamphonetoonedailyentry) {
        return findByIgnorecamphonebodyConsolidatecamphonetoonedailyentry(ignorecamphonebody, consolidatecamphonetoonedailyentry, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodyConsolidatecamphonetoonedailyentry(boolean ignorecamphonebody, boolean consolidatecamphonetoonedailyentry, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodySaveemailpostsasdraft(boolean ignorecamphonebody, boolean saveemailpostsasdraft) {
        return findByIgnorecamphonebodySaveemailpostsasdraft(ignorecamphonebody, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodySaveemailpostsasdraft(boolean ignorecamphonebody, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodySavecamphonepostsasdraft(boolean ignorecamphonebody, boolean savecamphonepostsasdraft) {
        return findByIgnorecamphonebodySavecamphonepostsasdraft(ignorecamphonebody, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodySavecamphonepostsasdraft(boolean ignorecamphonebody, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodyCamphoneimagetags(boolean ignorecamphonebody, String camphoneimagetags) {
        return findByIgnorecamphonebodyCamphoneimagetags(ignorecamphonebody, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByIgnorecamphonebodyCamphoneimagetags(boolean ignorecamphonebody, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentrySaveemailpostsasdraft(boolean consolidatecamphonetoonedailyentry, boolean saveemailpostsasdraft) {
        return findByConsolidatecamphonetoonedailyentrySaveemailpostsasdraft(consolidatecamphonetoonedailyentry, saveemailpostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentrySaveemailpostsasdraft(boolean consolidatecamphonetoonedailyentry, boolean saveemailpostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentrySavecamphonepostsasdraft(boolean consolidatecamphonetoonedailyentry, boolean savecamphonepostsasdraft) {
        return findByConsolidatecamphonetoonedailyentrySavecamphonepostsasdraft(consolidatecamphonetoonedailyentry, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentrySavecamphonepostsasdraft(boolean consolidatecamphonetoonedailyentry, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentryCamphoneimagetags(boolean consolidatecamphonetoonedailyentry, String camphoneimagetags) {
        return findByConsolidatecamphonetoonedailyentryCamphoneimagetags(consolidatecamphonetoonedailyentry, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findByConsolidatecamphonetoonedailyentryCamphoneimagetags(boolean consolidatecamphonetoonedailyentry, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraftSavecamphonepostsasdraft(boolean saveemailpostsasdraft, boolean savecamphonepostsasdraft) {
        return findBySaveemailpostsasdraftSavecamphonepostsasdraft(saveemailpostsasdraft, savecamphonepostsasdraft, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraftSavecamphonepostsasdraft(boolean saveemailpostsasdraft, boolean savecamphonepostsasdraft, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraftCamphoneimagetags(boolean saveemailpostsasdraft, String camphoneimagetags) {
        return findBySaveemailpostsasdraftCamphoneimagetags(saveemailpostsasdraft, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findBySaveemailpostsasdraftCamphoneimagetags(boolean saveemailpostsasdraft, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailapiDAO> findBySavecamphonepostsasdraftCamphoneimagetags(boolean savecamphonepostsasdraft, String camphoneimagetags) {
        return findBySavecamphonepostsasdraftCamphoneimagetags(savecamphonepostsasdraft, camphoneimagetags, 0, 50000);
    }

    public static ArrayList<EmailapiDAO> findBySavecamphonepostsasdraftCamphoneimagetags(boolean savecamphonepostsasdraft, String camphoneimagetags, int limitmin, int limitmax) {
        ArrayList<EmailapiDAO> resultarraylist = new ArrayList<EmailapiDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailapiDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}