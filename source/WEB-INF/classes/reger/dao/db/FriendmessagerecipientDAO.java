package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendmessagerecipient' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendmessagerecipientDAO.java
 * Finders for this DAO: reger.dao.finders.FriendmessagerecipientFinder.java
 * 
 */

public class FriendmessagerecipientDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendmessagerecipientDAO";

    protected int friendmessagerecipientid = 0;
    protected int friendmessageid = 0;
    protected int accountuserid = 0;
    protected boolean isread = true;

    public FriendmessagerecipientDAO (int friendmessagerecipientid){
        this.friendmessagerecipientid = friendmessagerecipientid;
        load();
    }

    public FriendmessagerecipientDAO(){


    }

    public void load(){
        if (friendmessagerecipientid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendmessagerecipientid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendmessagerecipientDAO)){
                setProperties((FriendmessagerecipientDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid, friendmessageid, accountuserid, isread  FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendmessagerecipientid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendmessagerecipientid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        friendmessageid = Integer.parseInt(rstData[0][1]);
                    } else {
                        friendmessageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuserid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuserid = 0;
                    }

                    isread = reger.core.Util.booleanFromSQLText(rstData[0][3]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendmessagerecipientid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendmessagerecipientid FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"' AND friendmessagerecipientid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendmessagerecipient SET friendmessagerecipientid='"+friendmessagerecipientid+"', friendmessageid='"+friendmessageid+"', accountuserid='"+accountuserid+"', isread='"+reger.core.Util.booleanAsSQLText(isread)+"'  WHERE friendmessagerecipientid='"+friendmessagerecipientid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendmessagerecipientid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendmessagerecipientid = Db.RunSQLInsert("INSERT INTO friendmessagerecipient(friendmessageid, accountuserid, isread ) VALUES('"+friendmessagerecipientid+"', '"+friendmessageid+"', '"+accountuserid+"', '"+reger.core.Util.booleanAsSQLText(isread)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendmessagerecipientid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendmessagerecipient WHERE friendmessagerecipientid='"+friendmessagerecipientid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendmessagerecipientid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendmessagerecipientDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendmessagerecipientDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendmessagerecipientid;
    }

    public String getPrimaryKeyName(){
        return "friendmessagerecipientid";
    }

    public String getTableName(){
        return "friendmessagerecipient";
    }

    public void setProperties(FriendmessagerecipientDAO obj){
        if(obj!=null){
            this.friendmessagerecipientid = obj.friendmessagerecipientid;
            this.friendmessageid = obj.friendmessageid;
            this.accountuserid = obj.accountuserid;
            this.isread = obj.isread;
        }
    }


    public int getFriendmessagerecipientid() {
        return friendmessagerecipientid;
    }


    public int getFriendmessageid() {
        return friendmessageid;
    }


    public void setFriendmessageid(int friendmessageid) {
        this.friendmessageid = friendmessageid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public boolean getIsread() {
        return isread;
    }


    public void setIsread(boolean isread) {
        this.isread = isread;
    }


}