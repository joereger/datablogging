package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pollreaderanswer' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPollreaderanswerDAO.java
 * Finders for this DAO: reger.dao.finders.PollreaderanswerFinder.java
 * 
 */

public class PollreaderanswerDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pollreaderanswerDAO";

    protected int pollreaderanswerid = 0;
    protected int pollid = 0;
    protected String answer = "";
    protected String readername = "";
    protected int votes = 0;
    protected boolean isapproved = true;

    public PollreaderanswerDAO (int pollreaderanswerid){
        this.pollreaderanswerid = pollreaderanswerid;
        load();
    }

    public PollreaderanswerDAO(){


    }

    public void load(){
        if (pollreaderanswerid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pollreaderanswerid), CACHEGROUP);
            if (obj!=null && (obj instanceof PollreaderanswerDAO)){
                setProperties((PollreaderanswerDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid, pollid, answer, readername, votes, isapproved  FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pollreaderanswerid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pollreaderanswerid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        pollid = Integer.parseInt(rstData[0][1]);
                    } else {
                        pollid = 0;
                    }

                    answer = rstData[0][2];

                    readername = rstData[0][3];

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        votes = Integer.parseInt(rstData[0][4]);
                    } else {
                        votes = 0;
                    }

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][5]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pollreaderanswerid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"' AND pollreaderanswerid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pollreaderanswer SET pollreaderanswerid='"+pollreaderanswerid+"', pollid='"+pollid+"', answer='"+reger.core.Util.cleanForSQL(answer)+"', readername='"+reger.core.Util.cleanForSQL(readername)+"', votes='"+votes+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"'  WHERE pollreaderanswerid='"+pollreaderanswerid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pollreaderanswerid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pollreaderanswerid = Db.RunSQLInsert("INSERT INTO pollreaderanswer(pollid, answer, readername, votes, isapproved ) VALUES('"+pollreaderanswerid+"', '"+pollid+"', '"+reger.core.Util.cleanForSQL(answer)+"', '"+reger.core.Util.cleanForSQL(readername)+"', '"+votes+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pollreaderanswerid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pollreaderanswerid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPollreaderanswerDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pollreaderanswerDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pollreaderanswerid;
    }

    public String getPrimaryKeyName(){
        return "pollreaderanswerid";
    }

    public String getTableName(){
        return "pollreaderanswer";
    }

    public void setProperties(PollreaderanswerDAO obj){
        if(obj!=null){
            this.pollreaderanswerid = obj.pollreaderanswerid;
            this.pollid = obj.pollid;
            this.answer = obj.answer;
            this.readername = obj.readername;
            this.votes = obj.votes;
            this.isapproved = obj.isapproved;
        }
    }


    public int getPollreaderanswerid() {
        return pollreaderanswerid;
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


    public String getReadername() {
        return readername;
    }


    public void setReadername(String readername) {
        this.readername = readername;
    }


    public int getVotes() {
        return votes;
    }


    public void setVotes(int votes) {
        this.votes = votes;
    }


    public boolean getIsapproved() {
        return isapproved;
    }


    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


}