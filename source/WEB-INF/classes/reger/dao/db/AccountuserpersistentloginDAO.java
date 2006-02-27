package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuserpersistentlogin' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuserpersistentloginDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuserpersistentloginFinder.java
 * 
 */

public class AccountuserpersistentloginDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuserpersistentloginDAO";

    protected int accountuserpersistentloginid = 0;
    protected int accountuserid = 0;
    protected String randomstring = "";
    protected java.util.Calendar lastusedtologin = java.util.Calendar.getInstance();

    public AccountuserpersistentloginDAO (int accountuserpersistentloginid){
        this.accountuserpersistentloginid = accountuserpersistentloginid;
        load();
    }

    public AccountuserpersistentloginDAO(){


    }

    public void load(){
        if (accountuserpersistentloginid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuserpersistentloginid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuserpersistentloginDAO)){
                setProperties((AccountuserpersistentloginDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid, accountuserid, randomstring, lastusedtologin  FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuserpersistentloginid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuserpersistentloginid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    randomstring = rstData[0][2];

                    lastusedtologin = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuserpersistentloginid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuserpersistentloginid FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"' AND accountuserpersistentloginid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuserpersistentlogin SET accountuserpersistentloginid='"+accountuserpersistentloginid+"', accountuserid='"+accountuserid+"', randomstring='"+reger.core.Util.cleanForSQL(randomstring)+"', lastusedtologin='"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"'  WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuserpersistentloginid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuserpersistentloginid = Db.RunSQLInsert("INSERT INTO accountuserpersistentlogin(accountuserid, randomstring, lastusedtologin ) VALUES('"+accountuserpersistentloginid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(randomstring)+"', '"+reger.core.TimeUtils.dateformatfordb(lastusedtologin)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuserpersistentloginid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+accountuserpersistentloginid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuserpersistentloginid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuserpersistentloginDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuserpersistentloginDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuserpersistentloginid;
    }

    public String getPrimaryKeyName(){
        return "accountuserpersistentloginid";
    }

    public String getTableName(){
        return "accountuserpersistentlogin";
    }

    public void setProperties(AccountuserpersistentloginDAO obj){
        if(obj!=null){
            this.accountuserpersistentloginid = obj.accountuserpersistentloginid;
            this.accountuserid = obj.accountuserid;
            this.randomstring = obj.randomstring;
            this.lastusedtologin = obj.lastusedtologin;
        }
    }


    public int getAccountuserpersistentloginid() {
        return accountuserpersistentloginid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getRandomstring() {
        return randomstring;
    }


    public void setRandomstring(String randomstring) {
        this.randomstring = randomstring;
    }


    public java.util.Calendar getLastusedtologin() {
        return lastusedtologin;
    }


    public void setLastusedtologin(java.util.Calendar lastusedtologin) {
        this.lastusedtologin = lastusedtologin;
    }


}