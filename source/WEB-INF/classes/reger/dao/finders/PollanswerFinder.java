package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PollanswerDAO;

/**
 * Finder for the 'pollanswer' DAO
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

public class PollanswerFinder {


    public static ArrayList<PollanswerDAO> findByPollanswerid(int pollanswerid) {
        return findByPollanswerid(pollanswerid, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollanswerid(int pollanswerid, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollid(int pollid) {
        return findByPollid(pollid, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollid(int pollid, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByAnswer(String answer) {
        return findByAnswer(answer, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByAnswer(String answer, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByVotes(int votes) {
        return findByVotes(votes, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByVotes(int votes, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollansweridPollid(int pollanswerid, int pollid) {
        return findByPollansweridPollid(pollanswerid, pollid, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollansweridPollid(int pollanswerid, int pollid, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid+"', pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollansweridAnswer(int pollanswerid, String answer) {
        return findByPollansweridAnswer(pollanswerid, answer, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollansweridAnswer(int pollanswerid, String answer, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollansweridVotes(int pollanswerid, int votes) {
        return findByPollansweridVotes(pollanswerid, votes, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollansweridVotes(int pollanswerid, int votes, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollidAnswer(int pollid, String answer) {
        return findByPollidAnswer(pollid, answer, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollidAnswer(int pollid, String answer, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollid='"+pollid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByPollidVotes(int pollid, int votes) {
        return findByPollidVotes(pollid, votes, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByPollidVotes(int pollid, int votes, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollid='"+pollid+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollanswerDAO> findByAnswerVotes(String answer, int votes) {
        return findByAnswerVotes(answer, votes, 0, 50000);
    }

    public static ArrayList<PollanswerDAO> findByAnswerVotes(String answer, int votes, int limitmin, int limitmax) {
        ArrayList<PollanswerDAO> resultarraylist = new ArrayList<PollanswerDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE answer='"+reger.core.Util.cleanForSQL(answer)+"', votes='"+votes+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollanswerDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}