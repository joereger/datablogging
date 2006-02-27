package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuseracl' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuseraclDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuseraclFinder.java
 * 
 */

public class AccountuseraclDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuseraclDAO";

    protected int accountuseraclid = 0;
    protected int accountuserid = 0;
    protected int aclobjectid = 0;
    protected int accountid = 0;

    public AccountuseraclDAO (int accountuseraclid){
        this.accountuseraclid = accountuseraclid;
        load();
    }

    public AccountuseraclDAO(){


    }

    public void load(){
        if (accountuseraclid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuseraclid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuseraclDAO)){
                setProperties((AccountuseraclDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuseraclid, accountuserid, aclobjectid, accountid  FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuseraclid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuseraclid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        aclobjectid = Integer.parseInt(rstData[0][2]);
                    } else {
                        aclobjectid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuseraclid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuseraclid FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"' AND accountuseraclid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuseracl SET accountuseraclid='"+accountuseraclid+"', accountuserid='"+accountuserid+"', aclobjectid='"+aclobjectid+"', accountid='"+accountid+"'  WHERE accountuseraclid='"+accountuseraclid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuseraclid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuseraclid = Db.RunSQLInsert("INSERT INTO accountuseracl(accountuserid, aclobjectid, accountid ) VALUES('"+accountuseraclid+"', '"+accountuserid+"', '"+aclobjectid+"', '"+accountid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuseraclid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE accountuseraclid='"+accountuseraclid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuseraclid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuseraclDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuseraclDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuseraclid;
    }

    public String getPrimaryKeyName(){
        return "accountuseraclid";
    }

    public String getTableName(){
        return "accountuseracl";
    }

    public void setProperties(AccountuseraclDAO obj){
        if(obj!=null){
            this.accountuseraclid = obj.accountuseraclid;
            this.accountuserid = obj.accountuserid;
            this.aclobjectid = obj.aclobjectid;
            this.accountid = obj.accountid;
        }
    }


    public int getAccountuseraclid() {
        return accountuseraclid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public int getAclobjectid() {
        return aclobjectid;
    }


    public void setAclobjectid(int aclobjectid) {
        this.aclobjectid = aclobjectid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}