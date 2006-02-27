package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuserpladmin' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuserpladminDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuserpladminFinder.java
 * 
 */

public class AccountuserpladminDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuserpladminDAO";

    protected int accountuserpladminid = 0;
    protected int accountuserid = 0;
    protected int plid = 0;

    public AccountuserpladminDAO (int accountuserpladminid){
        this.accountuserpladminid = accountuserpladminid;
        load();
    }

    public AccountuserpladminDAO(){


    }

    public void load(){
        if (accountuserpladminid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuserpladminid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuserpladminDAO)){
                setProperties((AccountuserpladminDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuserpladminid, accountuserid, plid  FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuserpladminid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuserpladminid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        plid = Integer.parseInt(rstData[0][2]);
                    } else {
                        plid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuserpladminid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"' AND accountuserpladminid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuserpladmin SET accountuserpladminid='"+accountuserpladminid+"', accountuserid='"+accountuserid+"', plid='"+plid+"'  WHERE accountuserpladminid='"+accountuserpladminid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuserpladminid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuserpladminid = Db.RunSQLInsert("INSERT INTO accountuserpladmin(accountuserid, plid ) VALUES('"+accountuserpladminid+"', '"+accountuserid+"', '"+plid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuserpladminid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuserpladminid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuserpladminDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuserpladminDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuserpladminid;
    }

    public String getPrimaryKeyName(){
        return "accountuserpladminid";
    }

    public String getTableName(){
        return "accountuserpladmin";
    }

    public void setProperties(AccountuserpladminDAO obj){
        if(obj!=null){
            this.accountuserpladminid = obj.accountuserpladminid;
            this.accountuserid = obj.accountuserid;
            this.plid = obj.plid;
        }
    }


    public int getAccountuserpladminid() {
        return accountuserpladminid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


}