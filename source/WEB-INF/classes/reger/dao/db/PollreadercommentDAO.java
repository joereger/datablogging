package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pollreadercomment' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPollreadercommentDAO.java
 * Finders for this DAO: reger.dao.finders.PollreadercommentFinder.java
 * 
 */

public class PollreadercommentDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pollreadercommentDAO";

    protected int pollreadercommentid = 0;
    protected int pollid = 0;
    protected String readername = "";
    protected String comment = "";
    protected boolean isapproved = true;

    public PollreadercommentDAO (int pollreadercommentid){
        this.pollreadercommentid = pollreadercommentid;
        load();
    }

    public PollreadercommentDAO(){


    }

    public void load(){
        if (pollreadercommentid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pollreadercommentid), CACHEGROUP);
            if (obj!=null && (obj instanceof PollreadercommentDAO)){
                setProperties((PollreadercommentDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pollreadercommentid, pollid, readername, comment, isapproved  FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pollreadercommentid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pollreadercommentid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        pollid = Integer.parseInt(rstData[0][1]);
                    } else {
                        pollid = 0;
                    }

                    readername = rstData[0][2];

                    comment = rstData[0][3];

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][4]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pollreadercommentid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"' AND pollreadercommentid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pollreadercomment SET pollreadercommentid='"+pollreadercommentid+"', pollid='"+pollid+"', readername='"+reger.core.Util.cleanForSQL(readername)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"'  WHERE pollreadercommentid='"+pollreadercommentid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pollreadercommentid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pollreadercommentid = Db.RunSQLInsert("INSERT INTO pollreadercomment(pollid, readername, comment, isapproved ) VALUES('"+pollreadercommentid+"', '"+pollid+"', '"+reger.core.Util.cleanForSQL(readername)+"', '"+reger.core.Util.cleanForSQL(comment)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pollreadercommentid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pollreadercommentid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPollreadercommentDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pollreadercommentDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pollreadercommentid;
    }

    public String getPrimaryKeyName(){
        return "pollreadercommentid";
    }

    public String getTableName(){
        return "pollreadercomment";
    }

    public void setProperties(PollreadercommentDAO obj){
        if(obj!=null){
            this.pollreadercommentid = obj.pollreadercommentid;
            this.pollid = obj.pollid;
            this.readername = obj.readername;
            this.comment = obj.comment;
            this.isapproved = obj.isapproved;
        }
    }


    public int getPollreadercommentid() {
        return pollreadercommentid;
    }


    public int getPollid() {
        return pollid;
    }


    public void setPollid(int pollid) {
        this.pollid = pollid;
    }


    public String getReadername() {
        return readername;
    }


    public void setReadername(String readername) {
        this.readername = readername;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public boolean getIsapproved() {
        return isapproved;
    }


    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


}