package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pollanswer' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPollanswerDAO.java
 * Finders for this DAO: reger.dao.finders.PollanswerFinder.java
 * 
 */

public class PollanswerDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pollanswerDAO";

    protected int pollanswerid = 0;
    protected int pollid = 0;
    protected String answer = "";
    protected int votes = 0;

    public PollanswerDAO (int pollanswerid){
        this.pollanswerid = pollanswerid;
        load();
    }

    public PollanswerDAO(){


    }

    public void load(){
        if (pollanswerid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pollanswerid), CACHEGROUP);
            if (obj!=null && (obj instanceof PollanswerDAO)){
                setProperties((PollanswerDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pollanswerid, pollid, answer, votes  FROM pollanswer WHERE pollanswerid='"+pollanswerid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pollanswerid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pollanswerid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        pollid = Integer.parseInt(rstData[0][1]);
                    } else {
                        pollid = 0;
                    }

                    answer = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        votes = Integer.parseInt(rstData[0][3]);
                    } else {
                        votes = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pollanswerid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid+"' AND pollanswerid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pollanswer SET pollanswerid='"+pollanswerid+"', pollid='"+pollid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"', votes='"+votes+"'  WHERE pollanswerid='"+pollanswerid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pollanswerid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pollanswerid = Db.RunSQLInsert("INSERT INTO pollanswer(pollid, answer, votes ) VALUES('"+pollanswerid+"', '"+pollid+"', '"+reger.core.Util.cleanForSQL(answer)+"', '"+votes+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pollanswerid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollanswer WHERE pollanswerid='"+pollanswerid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pollanswerid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPollanswerDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pollanswerDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pollanswerid;
    }

    public String getPrimaryKeyName(){
        return "pollanswerid";
    }

    public String getTableName(){
        return "pollanswer";
    }

    public void setProperties(PollanswerDAO obj){
        if(obj!=null){
            this.pollanswerid = obj.pollanswerid;
            this.pollid = obj.pollid;
            this.answer = obj.answer;
            this.votes = obj.votes;
        }
    }


    public int getPollanswerid() {
        return pollanswerid;
    }


    public int getPollid() {
        return pollid;
    }


    public void setPollid(int pollid) {
        this.pollid = pollid;
    }


    public String getAnswer() {
        return answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public int getVotes() {
        return votes;
    }


    public void setVotes(int votes) {
        this.votes = votes;
    }


}