package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendinvitationlogid' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendinvitationlogidDAO.java
 * Finders for this DAO: reger.dao.finders.FriendinvitationlogidFinder.java
 * 
 */

public class FriendinvitationlogidDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendinvitationlogidDAO";

    protected int friendinvitationlogidid = 0;
    protected int friendinvitationid = 0;
    protected int logid = 0;
    protected boolean canread = true;
    protected boolean canwrite = true;

    public FriendinvitationlogidDAO (int friendinvitationlogidid){
        this.friendinvitationlogidid = friendinvitationlogidid;
        load();
    }

    public FriendinvitationlogidDAO(){


    }

    public void load(){
        if (friendinvitationlogidid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendinvitationlogidid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendinvitationlogidDAO)){
                setProperties((FriendinvitationlogidDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid, friendinvitationid, logid, canread, canwrite  FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendinvitationlogidid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendinvitationlogidid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        friendinvitationid = Integer.parseInt(rstData[0][1]);
                    } else {
                        friendinvitationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        logid = Integer.parseInt(rstData[0][2]);
                    } else {
                        logid = 0;
                    }

                    canread = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    canwrite = reger.core.Util.booleanFromSQLText(rstData[0][4]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationlogidid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendinvitationlogidid FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"' AND friendinvitationlogidid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendinvitationlogid SET friendinvitationlogidid='"+friendinvitationlogidid+"', friendinvitationid='"+friendinvitationid+"', logid='"+logid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"'  WHERE friendinvitationlogidid='"+friendinvitationlogidid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationlogidid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendinvitationlogidid = Db.RunSQLInsert("INSERT INTO friendinvitationlogid(friendinvitationid, logid, canread, canwrite ) VALUES('"+friendinvitationlogidid+"', '"+friendinvitationid+"', '"+logid+"', '"+reger.core.Util.booleanAsSQLText(canread)+"', '"+reger.core.Util.booleanAsSQLText(canwrite)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationlogidid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendinvitationlogid WHERE friendinvitationlogidid='"+friendinvitationlogidid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationlogidid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendinvitationlogidDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendinvitationlogidDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendinvitationlogidid;
    }

    public String getPrimaryKeyName(){
        return "friendinvitationlogidid";
    }

    public String getTableName(){
        return "friendinvitationlogid";
    }

    public void setProperties(FriendinvitationlogidDAO obj){
        if(obj!=null){
            this.friendinvitationlogidid = obj.friendinvitationlogidid;
            this.friendinvitationid = obj.friendinvitationid;
            this.logid = obj.logid;
            this.canread = obj.canread;
            this.canwrite = obj.canwrite;
        }
    }


    public int getFriendinvitationlogidid() {
        return friendinvitationlogidid;
    }


    public int getFriendinvitationid() {
        return friendinvitationid;
    }


    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }


    public int getLogid() {
        return logid;
    }


    public void setLogid(int logid) {
        this.logid = logid;
    }


    public boolean getCanread() {
        return canread;
    }


    public void setCanread(boolean canread) {
        this.canread = canread;
    }


    public boolean getCanwrite() {
        return canwrite;
    }


    public void setCanwrite(boolean canwrite) {
        this.canwrite = canwrite;
    }


}