package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountusertype' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountusertypeDAO.java
 * Finders for this DAO: reger.dao.finders.AccountusertypeFinder.java
 * 
 */

public class AccountusertypeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountusertypeDAO";

    protected int accountusertypeid = 0;
    protected String type = "";
    protected String description = "";

    public AccountusertypeDAO (int accountusertypeid){
        this.accountusertypeid = accountusertypeid;
        load();
    }

    public AccountusertypeDAO(){


    }

    public void load(){
        if (accountusertypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountusertypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountusertypeDAO)){
                setProperties((AccountusertypeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountusertypeid, type, description  FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountusertypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountusertypeid = 0;
                    }

                    type = rstData[0][1];

                    description = rstData[0][2];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountusertypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountusertypeid FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"' AND accountusertypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountusertype SET accountusertypeid='"+accountusertypeid+"', type='"+reger.core.Util.cleanForSQL(type)+"', description='"+reger.core.Util.cleanForSQL(description)+"'  WHERE accountusertypeid='"+accountusertypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountusertypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountusertypeid = Db.RunSQLInsert("INSERT INTO accountusertype(type, description ) VALUES('"+accountusertypeid+"', '"+reger.core.Util.cleanForSQL(type)+"', '"+reger.core.Util.cleanForSQL(description)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountusertypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountusertype WHERE accountusertypeid='"+accountusertypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountusertypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountusertypeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountusertypeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountusertypeid;
    }

    public String getPrimaryKeyName(){
        return "accountusertypeid";
    }

    public String getTableName(){
        return "accountusertype";
    }

    public void setProperties(AccountusertypeDAO obj){
        if(obj!=null){
            this.accountusertypeid = obj.accountusertypeid;
            this.type = obj.type;
            this.description = obj.description;
        }
    }


    public int getAccountusertypeid() {
        return accountusertypeid;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


}