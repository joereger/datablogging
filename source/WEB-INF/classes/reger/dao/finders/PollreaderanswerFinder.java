package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PollreaderanswerDAO;

/**
 * Finder for the 'pollreaderanswer' DAO
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

public class PollreaderanswerFinder {


    public static ArrayList<PollreaderanswerDAO> findByPollreaderanswerid(int pollreaderanswerid) {
        return findByPollreaderanswerid(pollreaderanswerid, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderanswerid(int pollreaderanswerid, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollid(int pollid) {
        return findByPollid(pollid, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollid(int pollid, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswer(String answer) {
        return findByAnswer(answer, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswer(String answer, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByReadername(String readername) {
        return findByReadername(readername, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByReadername(String readername, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByVotes(int votes) {
        return findByVotes(votes, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByVotes(int votes, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByIsapproved(boolean isapproved) {
        return findByIsapproved(isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByIsapproved(boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridPollid(int pollreaderanswerid, int pollid) {
        return findByPollreaderansweridPollid(pollreaderanswerid, pollid, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridPollid(int pollreaderanswerid, int pollid, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"', pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridAnswer(int pollreaderanswerid, String answer) {
        return findByPollreaderansweridAnswer(pollreaderanswerid, answer, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridAnswer(int pollreaderanswerid, String answer, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridReadername(int pollreaderanswerid, String readername) {
        return findByPollreaderansweridReadername(pollreaderanswerid, readername, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridReadername(int pollreaderanswerid, String readername, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"', readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridVotes(int pollreaderanswerid, int votes) {
        return findByPollreaderansweridVotes(pollreaderanswerid, votes, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridVotes(int pollreaderanswerid, int votes, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridIsapproved(int pollreaderanswerid, boolean isapproved) {
        return findByPollreaderansweridIsapproved(pollreaderanswerid, isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollreaderansweridIsapproved(int pollreaderanswerid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidAnswer(int pollid, String answer) {
        return findByPollidAnswer(pollid, answer, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidAnswer(int pollid, String answer, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidReadername(int pollid, String readername) {
        return findByPollidReadername(pollid, readername, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidReadername(int pollid, String readername, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"', readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidVotes(int pollid, int votes) {
        return findByPollidVotes(pollid, votes, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidVotes(int pollid, int votes, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidIsapproved(int pollid, boolean isapproved) {
        return findByPollidIsapproved(pollid, isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByPollidIsapproved(int pollid, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerReadername(String answer, String readername) {
        return findByAnswerReadername(answer, readername, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerReadername(String answer, String readername, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"', readername='"+reger.core.Util.cleanForSQL(readername)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerVotes(String answer, int votes) {
        return findByAnswerVotes(answer, votes, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerVotes(String answer, int votes, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerIsapproved(String answer, boolean isapproved) {
        return findByAnswerIsapproved(answer, isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByAnswerIsapproved(String answer, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByReadernameVotes(String readername, int votes) {
        return findByReadernameVotes(readername, votes, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByReadernameVotes(String readername, int votes, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByReadernameIsapproved(String readername, boolean isapproved) {
        return findByReadernameIsapproved(readername, isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByReadernameIsapproved(String readername, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE readername='"+reger.core.Util.cleanForSQL(readername)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollreaderanswerDAO> findByVotesIsapproved(int votes, boolean isapproved) {
        return findByVotesIsapproved(votes, isapproved, 0, 50000);
    }

    public static ArrayList<PollreaderanswerDAO> findByVotesIsapproved(int votes, boolean isapproved, int limitmin, int limitmax) {
        ArrayList<PollreaderanswerDAO> resultarraylist = new ArrayList<PollreaderanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE votes='"+votes+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollreaderanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}