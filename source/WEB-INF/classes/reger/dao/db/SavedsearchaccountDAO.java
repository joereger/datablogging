package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearchaccount' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearchaccountDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearchaccountFinder.java
 * 
 */

public class SavedsearchaccountDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearchaccountDAO";

    protected int savedsearchaccountid = 0;
    protected int savedsearchid = 0;
    protected int accountid = 0;

    public SavedsearchaccountDAO (int savedsearchaccountid){
        this.savedsearchaccountid = savedsearchaccountid;
        load();
    }

    public SavedsearchaccountDAO(){


    }

    public void load(){
        if (savedsearchaccountid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearchaccountid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearchaccountDAO)){
                setProperties((SavedsearchaccountDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid, savedsearchid, accountid  FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearchaccountid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearchaccountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        savedsearchid = Integer.parseInt(rstData[0][1]);
                    } else {
                        savedsearchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearchaccountid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearchaccountid FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"' AND savedsearchaccountid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearchaccount SET savedsearchaccountid='"+savedsearchaccountid+"', savedsearchid='"+savedsearchid+"', accountid='"+accountid+"'  WHERE savedsearchaccountid='"+savedsearchaccountid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchaccountid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearchaccountid = Db.RunSQLInsert("INSERT INTO savedsearchaccount(savedsearchid, accountid ) VALUES('"+savedsearchaccountid+"', '"+savedsearchid+"', '"+accountid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearchaccountid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchaccount WHERE savedsearchaccountid='"+savedsearchaccountid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchaccountid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearchaccountDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearchaccountDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearchaccountid;
    }

    public String getPrimaryKeyName(){
        return "savedsearchaccountid";
    }

    public String getTableName(){
        return "savedsearchaccount";
    }

    public void setProperties(SavedsearchaccountDAO obj){
        if(obj!=null){
            this.savedsearchaccountid = obj.savedsearchaccountid;
            this.savedsearchid = obj.savedsearchid;
            this.accountid = obj.accountid;
        }
    }


    public int getSavedsearchaccountid() {
        return savedsearchaccountid;
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}