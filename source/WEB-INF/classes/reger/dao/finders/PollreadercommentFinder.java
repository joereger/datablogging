package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PollreadercommentDAO;

/**
 * Finder for the 'pollreadercomment' DAO
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

public class PollreadercommentFinder {


    public static ArrayList<PollreadercommentDAO> findByPollreadercommentid(int pollreadercommentid) {
        return findByPollreadercommentid(pollreadercommentid, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentid(int pollreadercommentid, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollid(int pollid) {
        return findByPollid(pollid, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollid(int pollid, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByReadername(String readername) {
        return findByReadername(readername, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByReadername(String readername, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByComment(String comment) {
        return findByComment(comment, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByComment(String comment, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidPollid(int pollreadercommentid, int pollid) {
        return findByPollreadercommentidPollid(pollreadercommentid, pollid, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidPollid(int pollreadercommentid, int pollid, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"', pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidReadername(int pollreadercommentid, String readername) {
        return findByPollreadercommentidReadername(pollreadercommentid, readername, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidReadername(int pollreadercommentid, String readername, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"', readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidComment(int pollreadercommentid, String comment) {
        return findByPollreadercommentidComment(pollreadercommentid, comment, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidComment(int pollreadercommentid, String comment, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidIsapproved(int pollreadercommentid, boolean isapproved) {
        return findByPollreadercommentidIsapproved(pollreadercommentid, isapproved, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollreadercommentidIsapproved(int pollreadercommentid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollidReadername(int pollid, String readername) {
        return findByPollidReadername(pollid, readername, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollidReadername(int pollid, String readername, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollid='"+pollid+"', readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollidComment(int pollid, String comment) {
        return findByPollidComment(pollid, comment, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollidComment(int pollid, String comment, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollid='"+pollid+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByPollidIsapproved(int pollid, boolean isapproved) {
        return findByPollidIsapproved(pollid, isapproved, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByPollidIsapproved(int pollid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollid='"+pollid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByReadernameComment(String readername, String comment) {
        return findByReadernameComment(readername, comment, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByReadernameComment(String readername, String comment, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByReadernameIsapproved(String readername, boolean isapproved) {
        return findByReadernameIsapproved(readername, isapproved, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByReadernameIsapproved(String readername, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreadercommentDAO> findByCommentIsapproved(String comment, boolean isapproved) {
        return findByCommentIsapproved(comment, isapproved, 0, 50000);
    }

    public static ArrayList<PollreadercommentDAO> findByCommentIsapproved(String comment, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreadercommentDAO> resultarraylist = new ArrayList<PollreadercommentDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE comment='"+reger.core.Util.cleanForSQL(comment)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreadercommentDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}