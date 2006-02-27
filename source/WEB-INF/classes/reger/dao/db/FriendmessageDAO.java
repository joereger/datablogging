package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendmessage' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendmessageDAO.java
 * Finders for this DAO: reger.dao.finders.FriendmessageFinder.java
 * 
 */

public class FriendmessageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendmessageDAO";

    protected int friendmessageid = 0;
    protected int accountuserid = 0;
    protected String subject = "";
    protected String message = "";
    protected java.util.Calendar datetime = java.util.Calendar.getInstance();
    protected int parentfriendmessageid = 0;

    public FriendmessageDAO (int friendmessageid){
        this.friendmessageid = friendmessageid;
        load();
    }

    public FriendmessageDAO(){


    }

    public void load(){
        if (friendmessageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendmessageid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendmessageDAO)){
                setProperties((FriendmessageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendmessageid, accountuserid, subject, message, datetime, parentfriendmessageid  FROM friendmessage WHERE friendmessageid='"+friendmessageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendmessageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendmessageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    subject = rstData[0][2];

                    message = rstData[0][3];

                    datetime = reger.core.TimeUtils.dbstringtocalendar(rstData[0][4]);

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        parentfriendmessageid = Integer.parseInt(rstData[0][5]);
                    } else {
                        parentfriendmessageid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendmessageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"' AND friendmessageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendmessage SET friendmessageid='"+friendmessageid+"', accountuserid='"+accountuserid+"', subject='"+reger.core.Util.cleanForSQL(subject)+"', message='"+reger.core.Util.cleanForSQL(message)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', parentfriendmessageid='"+parentfriendmessageid+"'  WHERE friendmessageid='"+friendmessageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendmessageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendmessageid = Db.RunSQLInsert("INSERT INTO friendmessage(accountuserid, subject, message, datetime, parentfriendmessageid ) VALUES('"+friendmessageid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(subject)+"', '"+reger.core.Util.cleanForSQL(message)+"', '"+reger.core.TimeUtils.dateformatfordb(datetime)+"', '"+parentfriendmessageid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendmessageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendmessage WHERE friendmessageid='"+friendmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendmessageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendmessageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendmessageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendmessageid;
    }

    public String getPrimaryKeyName(){
        return "friendmessageid";
    }

    public String getTableName(){
        return "friendmessage";
    }

    public void setProperties(FriendmessageDAO obj){
        if(obj!=null){
            this.friendmessageid = obj.friendmessageid;
            this.accountuserid = obj.accountuserid;
            this.subject = obj.subject;
            this.message = obj.message;
            this.datetime = obj.datetime;
            this.parentfriendmessageid = obj.parentfriendmessageid;
        }
    }


    public int getFriendmessageid() {
        return friendmessageid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public java.util.Calendar getDatetime() {
        return datetime;
    }


    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


    public int getParentfriendmessageid() {
        return parentfriendmessageid;
    }


    public void setParentfriendmessageid(int parentfriendmessageid) {
        this.parentfriendmessageid = parentfriendmessageid;
    }


}