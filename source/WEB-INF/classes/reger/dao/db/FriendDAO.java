package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friend' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendDAO.java
 * Finders for this DAO: reger.dao.finders.FriendFinder.java
 * 
 */

public class FriendDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendDAO";

    protected int friendid = 0;
    protected int accountuseridsource = 0;
    protected int accountuseridtarget = 0;

    public FriendDAO (int friendid){
        this.friendid = friendid;
        load();
    }

    public FriendDAO(){


    }

    public void load(){
        if (friendid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendDAO)){
                setProperties((FriendDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendid, accountuseridsource, accountuseridtarget  FROM friend WHERE friendid='"+friendid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuseridsource = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuseridsource = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuseridtarget = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuseridtarget = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendid FROM friend WHERE friendid='"+friendid+"' AND friendid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friend SET friendid='"+friendid+"', accountuseridsource='"+accountuseridsource+"', accountuseridtarget='"+accountuseridtarget+"'  WHERE friendid='"+friendid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendid = Db.RunSQLInsert("INSERT INTO friend(accountuseridsource, accountuseridtarget ) VALUES('"+friendid+"', '"+accountuseridsource+"', '"+accountuseridtarget+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friend WHERE friendid='"+friendid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendid;
    }

    public String getPrimaryKeyName(){
        return "friendid";
    }

    public String getTableName(){
        return "friend";
    }

    public void setProperties(FriendDAO obj){
        if(obj!=null){
            this.friendid = obj.friendid;
            this.accountuseridsource = obj.accountuseridsource;
            this.accountuseridtarget = obj.accountuseridtarget;
        }
    }


    public int getFriendid() {
        return friendid;
    }


    public int getAccountuseridsource() {
        return accountuseridsource;
    }


    public void setAccountuseridsource(int accountuseridsource) {
        this.accountuseridsource = accountuseridsource;
    }


    public int getAccountuseridtarget() {
        return accountuseridtarget;
    }


    public void setAccountuseridtarget(int accountuseridtarget) {
        this.accountuseridtarget = accountuseridtarget;
    }


}