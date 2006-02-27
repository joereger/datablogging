package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendinvitationgroup' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendinvitationgroupDAO.java
 * Finders for this DAO: reger.dao.finders.FriendinvitationgroupFinder.java
 * 
 */

public class FriendinvitationgroupDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendinvitationgroupDAO";

    protected int friendinvitationgroupid = 0;
    protected int friendinvitationid = 0;
    protected int groupid = 0;

    public FriendinvitationgroupDAO (int friendinvitationgroupid){
        this.friendinvitationgroupid = friendinvitationgroupid;
        load();
    }

    public FriendinvitationgroupDAO(){


    }

    public void load(){
        if (friendinvitationgroupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendinvitationgroupid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendinvitationgroupDAO)){
                setProperties((FriendinvitationgroupDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid, friendinvitationid, groupid  FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendinvitationgroupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendinvitationgroupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        friendinvitationid = Integer.parseInt(rstData[0][1]);
                    } else {
                        friendinvitationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        groupid = Integer.parseInt(rstData[0][2]);
                    } else {
                        groupid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationgroupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"' AND friendinvitationgroupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendinvitationgroup SET friendinvitationgroupid='"+friendinvitationgroupid+"', friendinvitationid='"+friendinvitationid+"', groupid='"+groupid+"'  WHERE friendinvitationgroupid='"+friendinvitationgroupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationgroupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendinvitationgroupid = Db.RunSQLInsert("INSERT INTO friendinvitationgroup(friendinvitationid, groupid ) VALUES('"+friendinvitationgroupid+"', '"+friendinvitationid+"', '"+groupid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationgroupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationgroupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendinvitationgroupDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendinvitationgroupDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendinvitationgroupid;
    }

    public String getPrimaryKeyName(){
        return "friendinvitationgroupid";
    }

    public String getTableName(){
        return "friendinvitationgroup";
    }

    public void setProperties(FriendinvitationgroupDAO obj){
        if(obj!=null){
            this.friendinvitationgroupid = obj.friendinvitationgroupid;
            this.friendinvitationid = obj.friendinvitationid;
            this.groupid = obj.groupid;
        }
    }


    public int getFriendinvitationgroupid() {
        return friendinvitationgroupid;
    }


    public int getFriendinvitationid() {
        return friendinvitationid;
    }


    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }


    public int getGroupid() {
        return groupid;
    }


    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }


}