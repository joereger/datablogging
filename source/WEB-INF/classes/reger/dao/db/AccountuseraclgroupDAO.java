package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuseraclgroup' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuseraclgroupDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuseraclgroupFinder.java
 * 
 */

public class AccountuseraclgroupDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuseraclgroupDAO";

    protected int accountuseraclgroupid = 0;
    protected int accountuserid = 0;
    protected int aclgroupid = 0;
    protected int accountid = 0;

    public AccountuseraclgroupDAO (int accountuseraclgroupid){
        this.accountuseraclgroupid = accountuseraclgroupid;
        load();
    }

    public AccountuseraclgroupDAO(){


    }

    public void load(){
        if (accountuseraclgroupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuseraclgroupid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuseraclgroupDAO)){
                setProperties((AccountuseraclgroupDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid, accountuserid, aclgroupid, accountid  FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuseraclgroupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuseraclgroupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        aclgroupid = Integer.parseInt(rstData[0][2]);
                    } else {
                        aclgroupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuseraclgroupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"' AND accountuseraclgroupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuseraclgroup SET accountuseraclgroupid='"+accountuseraclgroupid+"', accountuserid='"+accountuserid+"', aclgroupid='"+aclgroupid+"', accountid='"+accountid+"'  WHERE accountuseraclgroupid='"+accountuseraclgroupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuseraclgroupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuseraclgroupid = Db.RunSQLInsert("INSERT INTO accountuseraclgroup(accountuserid, aclgroupid, accountid ) VALUES('"+accountuseraclgroupid+"', '"+accountuserid+"', '"+aclgroupid+"', '"+accountid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuseraclgroupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuseraclgroup WHERE accountuseraclgroupid='"+accountuseraclgroupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuseraclgroupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuseraclgroupDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuseraclgroupDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuseraclgroupid;
    }

    public String getPrimaryKeyName(){
        return "accountuseraclgroupid";
    }

    public String getTableName(){
        return "accountuseraclgroup";
    }

    public void setProperties(AccountuseraclgroupDAO obj){
        if(obj!=null){
            this.accountuseraclgroupid = obj.accountuseraclgroupid;
            this.accountuserid = obj.accountuserid;
            this.aclgroupid = obj.aclgroupid;
            this.accountid = obj.accountid;
        }
    }


    public int getAccountuseraclgroupid() {
        return accountuseraclgroupid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public int getAclgroupid() {
        return aclgroupid;
    }


    public void setAclgroupid(int aclgroupid) {
        this.aclgroupid = aclgroupid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}