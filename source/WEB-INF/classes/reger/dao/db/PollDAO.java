package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'poll' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPollDAO.java
 * Finders for this DAO: reger.dao.finders.PollFinder.java
 * 
 */

public class PollDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pollDAO";

    protected int pollid = 0;
    protected int eventid = 0;
    protected String question = "";
    protected boolean readerscanaddownanswer = true;
    protected boolean readerscanaddcomments = true;
    protected boolean readerscanvoteonreaderanswers = true;
    protected boolean readerinputismoderated = true;
    protected boolean isopen = true;

    public PollDAO (int pollid){
        this.pollid = pollid;
        load();
    }

    public PollDAO(){


    }

    public void load(){
        if (pollid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pollid), CACHEGROUP);
            if (obj!=null && (obj instanceof PollDAO)){
                setProperties((PollDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pollid, eventid, question, readerscanaddownanswer, readerscanaddcomments, readerscanvoteonreaderanswers, readerinputismoderated, isopen  FROM poll WHERE pollid='"+pollid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pollid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pollid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    question = rstData[0][2];

                    readerscanaddownanswer = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    readerscanaddcomments = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    readerscanvoteonreaderanswers = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    readerinputismoderated = reger.core.Util.booleanFromSQLText(rstData[0][6]);

                    isopen = reger.core.Util.booleanFromSQLText(rstData[0][7]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pollid), CACHEGROUP, this);
            }
        }
    }

    public void save() throws reger.core.ValidationException{
        try{
            validate();
        } catch (reger.core.ValidationException vex){
            throw vex;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid+"' AND pollid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE poll SET pollid='"+pollid+"', eventid='"+eventid+"', question='"+reger.core.Util.cleanForSQL(question)+"', readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"'  WHERE pollid='"+pollid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pollid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pollid = Db.RunSQLInsert("INSERT INTO poll(eventid, question, readerscanaddownanswer, readerscanaddcomments, readerscanvoteonreaderanswers, readerinputismoderated, isopen ) VALUES('"+pollid+"', '"+eventid+"', '"+reger.core.Util.cleanForSQL(question)+"', '"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', '"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', '"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', '"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"', '"+reger.core.Util.booleanAsSQLText(isopen)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pollid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM poll WHERE pollid='"+pollid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pollid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPollDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pollDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pollid;
    }

    public String getPrimaryKeyName(){
        return "pollid";
    }

    public String getTableName(){
        return "poll";
    }

    public void setProperties(PollDAO obj){
        if(obj!=null){
            this.pollid = obj.pollid;
            this.eventid = obj.eventid;
            this.question = obj.question;
            this.readerscanaddownanswer = obj.readerscanaddownanswer;
            this.readerscanaddcomments = obj.readerscanaddcomments;
            this.readerscanvoteonreaderanswers = obj.readerscanvoteonreaderanswers;
            this.readerinputismoderated = obj.readerinputismoderated;
            this.isopen = obj.isopen;
        }
    }


    public int getPollid() {
        return pollid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public boolean getReaderscanaddownanswer() {
        return readerscanaddownanswer;
    }


    public void setReaderscanaddownanswer(boolean readerscanaddownanswer) {
        this.readerscanaddownanswer = readerscanaddownanswer;
    }


    public boolean getReaderscanaddcomments() {
        return readerscanaddcomments;
    }


    public void setReaderscanaddcomments(boolean readerscanaddcomments) {
        this.readerscanaddcomments = readerscanaddcomments;
    }


    public boolean getReaderscanvoteonreaderanswers() {
        return readerscanvoteonreaderanswers;
    }


    public void setReaderscanvoteonreaderanswers(boolean readerscanvoteonreaderanswers) {
        this.readerscanvoteonreaderanswers = readerscanvoteonreaderanswers;
    }


    public boolean getReaderinputismoderated() {
        return readerinputismoderated;
    }


    public void setReaderinputismoderated(boolean readerinputismoderated) {
        this.readerinputismoderated = readerinputismoderated;
    }


    public boolean getIsopen() {
        return isopen;
    }


    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }


}