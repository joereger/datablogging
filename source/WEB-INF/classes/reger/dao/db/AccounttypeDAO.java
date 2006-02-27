package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accounttype' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccounttypeDAO.java
 * Finders for this DAO: reger.dao.finders.AccounttypeFinder.java
 * 
 */

public class AccounttypeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accounttypeDAO";

    protected int accounttypeid = 0;
    protected String accounttypename = "";

    public AccounttypeDAO (int accounttypeid){
        this.accounttypeid = accounttypeid;
        load();
    }

    public AccounttypeDAO(){


    }

    public void load(){
        if (accounttypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accounttypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccounttypeDAO)){
                setProperties((AccounttypeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accounttypeid, accounttypename  FROM accounttype WHERE accounttypeid='"+accounttypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accounttypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accounttypeid = 0;
                    }

                    accounttypename = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accounttypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accounttypeid FROM accounttype WHERE accounttypeid='"+accounttypeid+"' AND accounttypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accounttype SET accounttypeid='"+accounttypeid+"', accounttypename='"+reger.core.Util.cleanForSQL(accounttypename)+"'  WHERE accounttypeid='"+accounttypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accounttypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accounttypeid = Db.RunSQLInsert("INSERT INTO accounttype(accounttypename ) VALUES('"+accounttypeid+"', '"+reger.core.Util.cleanForSQL(accounttypename)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accounttypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accounttype WHERE accounttypeid='"+accounttypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accounttypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccounttypeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accounttypeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accounttypeid;
    }

    public String getPrimaryKeyName(){
        return "accounttypeid";
    }

    public String getTableName(){
        return "accounttype";
    }

    public void setProperties(AccounttypeDAO obj){
        if(obj!=null){
            this.accounttypeid = obj.accounttypeid;
            this.accounttypename = obj.accounttypename;
        }
    }


    public int getAccounttypeid() {
        return accounttypeid;
    }


    public String getAccounttypename() {
        return accounttypename;
    }


    public void setAccounttypename(String accounttypename) {
        this.accounttypename = accounttypename;
    }


}