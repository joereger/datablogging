package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.EmailsubscriberDAO;

/**
 * Finder for the 'emailsubscriber' DAO
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

public class EmailsubscriberFinder {


    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberid(int emailsubscriberid) {
        return findByEmailsubscriberid(emailsubscriberid, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberid(int emailsubscriberid, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdays(int sendeveryxdays) {
        return findBySendeveryxdays(sendeveryxdays, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdays(int sendeveryxdays, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE sendeveryxdays='"+sendeveryxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddress(String emailaddress) {
        return findByEmailaddress(emailaddress, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddress(String emailaddress, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountid(int accountid) {
        return findByAccountid(accountid, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountid(int accountid, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByHtmlemail(boolean htmlemail) {
        return findByHtmlemail(htmlemail, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByHtmlemail(boolean htmlemail, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByLastsentdate(java.util.Calendar lastsentdate) {
        return findByLastsentdate(lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByLastsentdate(java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidSendeveryxdays(int emailsubscriberid, int sendeveryxdays) {
        return findByEmailsubscriberidSendeveryxdays(emailsubscriberid, sendeveryxdays, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidSendeveryxdays(int emailsubscriberid, int sendeveryxdays, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"', sendeveryxdays='"+sendeveryxdays+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidEmailaddress(int emailsubscriberid, String emailaddress) {
        return findByEmailsubscriberidEmailaddress(emailsubscriberid, emailaddress, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidEmailaddress(int emailsubscriberid, String emailaddress, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"', emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidAccountid(int emailsubscriberid, int accountid) {
        return findByEmailsubscriberidAccountid(emailsubscriberid, accountid, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidAccountid(int emailsubscriberid, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidHtmlemail(int emailsubscriberid, boolean htmlemail) {
        return findByEmailsubscriberidHtmlemail(emailsubscriberid, htmlemail, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidHtmlemail(int emailsubscriberid, boolean htmlemail, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"', htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidLastsentdate(int emailsubscriberid, java.util.Calendar lastsentdate) {
        return findByEmailsubscriberidLastsentdate(emailsubscriberid, lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailsubscriberidLastsentdate(int emailsubscriberid, java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysEmailaddress(int sendeveryxdays, String emailaddress) {
        return findBySendeveryxdaysEmailaddress(sendeveryxdays, emailaddress, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysEmailaddress(int sendeveryxdays, String emailaddress, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE sendeveryxdays='"+sendeveryxdays+"', emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysAccountid(int sendeveryxdays, int accountid) {
        return findBySendeveryxdaysAccountid(sendeveryxdays, accountid, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysAccountid(int sendeveryxdays, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE sendeveryxdays='"+sendeveryxdays+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysHtmlemail(int sendeveryxdays, boolean htmlemail) {
        return findBySendeveryxdaysHtmlemail(sendeveryxdays, htmlemail, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysHtmlemail(int sendeveryxdays, boolean htmlemail, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE sendeveryxdays='"+sendeveryxdays+"', htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysLastsentdate(int sendeveryxdays, java.util.Calendar lastsentdate) {
        return findBySendeveryxdaysLastsentdate(sendeveryxdays, lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findBySendeveryxdaysLastsentdate(int sendeveryxdays, java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE sendeveryxdays='"+sendeveryxdays+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressAccountid(String emailaddress, int accountid) {
        return findByEmailaddressAccountid(emailaddress, accountid, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressAccountid(String emailaddress, int accountid, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"', accountid='"+accountid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressHtmlemail(String emailaddress, boolean htmlemail) {
        return findByEmailaddressHtmlemail(emailaddress, htmlemail, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressHtmlemail(String emailaddress, boolean htmlemail, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"', htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressLastsentdate(String emailaddress, java.util.Calendar lastsentdate) {
        return findByEmailaddressLastsentdate(emailaddress, lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByEmailaddressLastsentdate(String emailaddress, java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountidHtmlemail(int accountid, boolean htmlemail) {
        return findByAccountidHtmlemail(accountid, htmlemail, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountidHtmlemail(int accountid, boolean htmlemail, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE accountid='"+accountid+"', htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountidLastsentdate(int accountid, java.util.Calendar lastsentdate) {
        return findByAccountidLastsentdate(accountid, lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByAccountidLastsentdate(int accountid, java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE accountid='"+accountid+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<EmailsubscriberDAO> findByHtmlemailLastsentdate(boolean htmlemail, java.util.Calendar lastsentdate) {
        return findByHtmlemailLastsentdate(htmlemail, lastsentdate, 0, 50000);
    }

    public static ArrayList<EmailsubscriberDAO> findByHtmlemailLastsentdate(boolean htmlemail, java.util.Calendar lastsentdate, int limitmin, int limitmax) {
        ArrayList<EmailsubscriberDAO> resultarraylist = new ArrayList<EmailsubscriberDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new EmailsubscriberDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}