package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuserlogaccess' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuserlogaccessDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuserlogaccessFinder.java
 * 
 */

public class AccountuserlogaccessDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuserlogaccessDAO";

    protected int accountuserlogaccessid = 0;
    protected int accountuserid = 0;
    protected int logid = 0;
    protected boolean canread = true;
    protected boolean canwrite = true;

    public AccountuserlogaccessDAO (int accountuserlogaccessid){
        this.accountuserlogaccessid = accountuserlogaccessid;
        load();
    }

    public AccountuserlogaccessDAO(){


    }

    public void load(){
        if (accountuserlogaccessid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuserlogaccessid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuserlogaccessDAO)){
                setProperties((AccountuserlogaccessDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid, accountuserid, logid, canread, canwrite  FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuserlogaccessid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuserlogaccessid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        logid = Integer.parseInt(rstData[0][2]);
                    } else {
                        logid = 0;
                    }

                    canread = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    canwrite = reger.core.Util.booleanFromSQLText(rstData[0][4]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuserlogaccessid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"' AND accountuserlogaccessid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET accountuserlogaccessid='"+accountuserlogaccessid+"', accountuserid='"+accountuserid+"', logid='"+logid+"', canread='"+reger.core.Util.booleanAsSQLText(canread)+"', canwrite='"+reger.core.Util.booleanAsSQLText(canwrite)+"'  WHERE accountuserlogaccessid='"+accountuserlogaccessid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuserlogaccessid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuserlogaccessid = Db.RunSQLInsert("INSERT INTO accountuserlogaccess(accountuserid, logid, canread, canwrite ) VALUES('"+accountuserlogaccessid+"', '"+accountuserid+"', '"+logid+"', '"+reger.core.Util.booleanAsSQLText(canread)+"', '"+reger.core.Util.booleanAsSQLText(canwrite)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuserlogaccessid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuserlogaccess WHERE accountuserlogaccessid='"+accountuserlogaccessid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuserlogaccessid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuserlogaccessDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuserlogaccessDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuserlogaccessid;
    }

    public String getPrimaryKeyName(){
        return "accountuserlogaccessid";
    }

    public String getTableName(){
        return "accountuserlogaccess";
    }

    public void setProperties(AccountuserlogaccessDAO obj){
        if(obj!=null){
            this.accountuserlogaccessid = obj.accountuserlogaccessid;
            this.accountuserid = obj.accountuserid;
            this.logid = obj.logid;
            this.canread = obj.canread;
            this.canwrite = obj.canwrite;
        }
    }


    public int getAccountuserlogaccessid() {
        return accountuserlogaccessid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
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