package reger.dao.finders;

import reger.core.db.Db;
import java.util.ArrayList;
import reger.dao.db.PollDAO;

/**
 * Finder for the 'poll' DAO
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

public class PollFinder {


    public static ArrayList<PollDAO> findByPollid(int pollid) {
        return findByPollid(pollid, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollid(int pollid, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventid(int eventid) {
        return findByEventid(eventid, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventid(int eventid, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestion(String question) {
        return findByQuestion(question, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestion(String question, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswer(boolean readerscanaddownanswer) {
        return findByReaderscanaddownanswer(readerscanaddownanswer, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswer(boolean readerscanaddownanswer, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddcomments(boolean readerscanaddcomments) {
        return findByReaderscanaddcomments(readerscanaddcomments, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddcomments(boolean readerscanaddcomments, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswers(boolean readerscanvoteonreaderanswers) {
        return findByReaderscanvoteonreaderanswers(readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswers(boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderinputismoderated(boolean readerinputismoderated) {
        return findByReaderinputismoderated(readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderinputismoderated(boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByIsopen(boolean isopen) {
        return findByIsopen(isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByIsopen(boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidEventid(int pollid, int eventid) {
        return findByPollidEventid(pollid, eventid, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidEventid(int pollid, int eventid, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', eventid='"+eventid+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidQuestion(int pollid, String question) {
        return findByPollidQuestion(pollid, question, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidQuestion(int pollid, String question, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', question='"+reger.core.Util.cleanForSQL(question)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidReaderscanaddownanswer(int pollid, boolean readerscanaddownanswer) {
        return findByPollidReaderscanaddownanswer(pollid, readerscanaddownanswer, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidReaderscanaddownanswer(int pollid, boolean readerscanaddownanswer, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidReaderscanaddcomments(int pollid, boolean readerscanaddcomments) {
        return findByPollidReaderscanaddcomments(pollid, readerscanaddcomments, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidReaderscanaddcomments(int pollid, boolean readerscanaddcomments, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidReaderscanvoteonreaderanswers(int pollid, boolean readerscanvoteonreaderanswers) {
        return findByPollidReaderscanvoteonreaderanswers(pollid, readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidReaderscanvoteonreaderanswers(int pollid, boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidReaderinputismoderated(int pollid, boolean readerinputismoderated) {
        return findByPollidReaderinputismoderated(pollid, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidReaderinputismoderated(int pollid, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByPollidIsopen(int pollid, boolean isopen) {
        return findByPollidIsopen(pollid, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByPollidIsopen(int pollid, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidQuestion(int eventid, String question) {
        return findByEventidQuestion(eventid, question, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidQuestion(int eventid, String question, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', question='"+reger.core.Util.cleanForSQL(question)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidReaderscanaddownanswer(int eventid, boolean readerscanaddownanswer) {
        return findByEventidReaderscanaddownanswer(eventid, readerscanaddownanswer, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidReaderscanaddownanswer(int eventid, boolean readerscanaddownanswer, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidReaderscanaddcomments(int eventid, boolean readerscanaddcomments) {
        return findByEventidReaderscanaddcomments(eventid, readerscanaddcomments, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidReaderscanaddcomments(int eventid, boolean readerscanaddcomments, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidReaderscanvoteonreaderanswers(int eventid, boolean readerscanvoteonreaderanswers) {
        return findByEventidReaderscanvoteonreaderanswers(eventid, readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidReaderscanvoteonreaderanswers(int eventid, boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidReaderinputismoderated(int eventid, boolean readerinputismoderated) {
        return findByEventidReaderinputismoderated(eventid, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidReaderinputismoderated(int eventid, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByEventidIsopen(int eventid, boolean isopen) {
        return findByEventidIsopen(eventid, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByEventidIsopen(int eventid, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE eventid='"+eventid+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanaddownanswer(String question, boolean readerscanaddownanswer) {
        return findByQuestionReaderscanaddownanswer(question, readerscanaddownanswer, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanaddownanswer(String question, boolean readerscanaddownanswer, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"', readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanaddcomments(String question, boolean readerscanaddcomments) {
        return findByQuestionReaderscanaddcomments(question, readerscanaddcomments, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanaddcomments(String question, boolean readerscanaddcomments, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanvoteonreaderanswers(String question, boolean readerscanvoteonreaderanswers) {
        return findByQuestionReaderscanvoteonreaderanswers(question, readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestionReaderscanvoteonreaderanswers(String question, boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestionReaderinputismoderated(String question, boolean readerinputismoderated) {
        return findByQuestionReaderinputismoderated(question, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestionReaderinputismoderated(String question, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByQuestionIsopen(String question, boolean isopen) {
        return findByQuestionIsopen(question, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByQuestionIsopen(String question, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE question='"+reger.core.Util.cleanForSQL(question)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderscanaddcomments(boolean readerscanaddownanswer, boolean readerscanaddcomments) {
        return findByReaderscanaddownanswerReaderscanaddcomments(readerscanaddownanswer, readerscanaddcomments, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderscanaddcomments(boolean readerscanaddownanswer, boolean readerscanaddcomments, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderscanvoteonreaderanswers(boolean readerscanaddownanswer, boolean readerscanvoteonreaderanswers) {
        return findByReaderscanaddownanswerReaderscanvoteonreaderanswers(readerscanaddownanswer, readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderscanvoteonreaderanswers(boolean readerscanaddownanswer, boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderinputismoderated(boolean readerscanaddownanswer, boolean readerinputismoderated) {
        return findByReaderscanaddownanswerReaderinputismoderated(readerscanaddownanswer, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerReaderinputismoderated(boolean readerscanaddownanswer, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerIsopen(boolean readerscanaddownanswer, boolean isopen) {
        return findByReaderscanaddownanswerIsopen(readerscanaddownanswer, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddownanswerIsopen(boolean readerscanaddownanswer, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsReaderscanvoteonreaderanswers(boolean readerscanaddcomments, boolean readerscanvoteonreaderanswers) {
        return findByReaderscanaddcommentsReaderscanvoteonreaderanswers(readerscanaddcomments, readerscanvoteonreaderanswers, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsReaderscanvoteonreaderanswers(boolean readerscanaddcomments, boolean readerscanvoteonreaderanswers, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsReaderinputismoderated(boolean readerscanaddcomments, boolean readerinputismoderated) {
        return findByReaderscanaddcommentsReaderinputismoderated(readerscanaddcomments, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsReaderinputismoderated(boolean readerscanaddcomments, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsIsopen(boolean readerscanaddcomments, boolean isopen) {
        return findByReaderscanaddcommentsIsopen(readerscanaddcomments, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanaddcommentsIsopen(boolean readerscanaddcomments, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswersReaderinputismoderated(boolean readerscanvoteonreaderanswers, boolean readerinputismoderated) {
        return findByReaderscanvoteonreaderanswersReaderinputismoderated(readerscanvoteonreaderanswers, readerinputismoderated, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswersReaderinputismoderated(boolean readerscanvoteonreaderanswers, boolean readerinputismoderated, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswersIsopen(boolean readerscanvoteonreaderanswers, boolean isopen) {
        return findByReaderscanvoteonreaderanswersIsopen(readerscanvoteonreaderanswers, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderscanvoteonreaderanswersIsopen(boolean readerscanvoteonreaderanswers, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }

    public static ArrayList<PollDAO> findByReaderinputismoderatedIsopen(boolean readerinputismoderated, boolean isopen) {
        return findByReaderinputismoderatedIsopen(readerinputismoderated, isopen, 0, 50000);
    }

    public static ArrayList<PollDAO> findByReaderinputismoderatedIsopen(boolean readerinputismoderated, boolean isopen, int limitmin, int limitmax) {
        ArrayList<PollDAO> resultarraylist = new ArrayList<PollDAO>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' LIMIT "+limitmin+", "+limitmax+" ");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                 resultarraylist.add(new PollDAO(Integer.parseInt(rstData[i][0])));
            }
        }
        return resultarraylist;
    }


}