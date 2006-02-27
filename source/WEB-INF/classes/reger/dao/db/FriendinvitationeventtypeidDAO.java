package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendinvitationeventtypeid' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendinvitationeventtypeidDAO.java
 * Finders for this DAO: reger.dao.finders.FriendinvitationeventtypeidFinder.java
 * 
 */

public class FriendinvitationeventtypeidDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendinvitationeventtypeidDAO";

    protected int friendinvitationeventtypeidid = 0;
    protected int friendinvitationid = 0;
    protected int eventtypeid = 0;

    public FriendinvitationeventtypeidDAO (int friendinvitationeventtypeidid){
        this.friendinvitationeventtypeidid = friendinvitationeventtypeidid;
        load();
    }

    public FriendinvitationeventtypeidDAO(){


    }

    public void load(){
        if (friendinvitationeventtypeidid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendinvitationeventtypeidid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendinvitationeventtypeidDAO)){
                setProperties((FriendinvitationeventtypeidDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid, friendinvitationid, eventtypeid  FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendinvitationeventtypeidid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendinvitationeventtypeidid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        friendinvitationid = Integer.parseInt(rstData[0][1]);
                    } else {
                        friendinvitationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventtypeid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationeventtypeidid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendinvitationeventtypeidid FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"' AND friendinvitationeventtypeidid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendinvitationeventtypeid SET friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"', friendinvitationid='"+friendinvitationid+"', eventtypeid='"+eventtypeid+"'  WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationeventtypeidid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendinvitationeventtypeidid = Db.RunSQLInsert("INSERT INTO friendinvitationeventtypeid(friendinvitationid, eventtypeid ) VALUES('"+friendinvitationeventtypeidid+"', '"+friendinvitationid+"', '"+eventtypeid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationeventtypeidid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendinvitationeventtypeid WHERE friendinvitationeventtypeidid='"+friendinvitationeventtypeidid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationeventtypeidid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendinvitationeventtypeidDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendinvitationeventtypeidDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendinvitationeventtypeidid;
    }

    public String getPrimaryKeyName(){
        return "friendinvitationeventtypeidid";
    }

    public String getTableName(){
        return "friendinvitationeventtypeid";
    }

    public void setProperties(FriendinvitationeventtypeidDAO obj){
        if(obj!=null){
            this.friendinvitationeventtypeidid = obj.friendinvitationeventtypeidid;
            this.friendinvitationid = obj.friendinvitationid;
            this.eventtypeid = obj.eventtypeid;
        }
    }


    public int getFriendinvitationeventtypeidid() {
        return friendinvitationeventtypeidid;
    }


    public int getFriendinvitationid() {
        return friendinvitationid;
    }


    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


}