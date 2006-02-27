package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearchlog' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearchlogDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearchlogFinder.java
 * 
 */

public class SavedsearchlogDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearchlogDAO";

    protected int savedsearchlogid = 0;
    protected int savedsearchid = 0;
    protected int logid = 0;

    public SavedsearchlogDAO (int savedsearchlogid){
        this.savedsearchlogid = savedsearchlogid;
        load();
    }

    public SavedsearchlogDAO(){


    }

    public void load(){
        if (savedsearchlogid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearchlogid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearchlogDAO)){
                setProperties((SavedsearchlogDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearchlogid, savedsearchid, logid  FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearchlogid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearchlogid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        savedsearchid = Integer.parseInt(rstData[0][1]);
                    } else {
                        savedsearchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        logid = Integer.parseInt(rstData[0][2]);
                    } else {
                        logid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearchlogid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearchlogid FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"' AND savedsearchlogid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearchlog SET savedsearchlogid='"+savedsearchlogid+"', savedsearchid='"+savedsearchid+"', logid='"+logid+"'  WHERE savedsearchlogid='"+savedsearchlogid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchlogid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearchlogid = Db.RunSQLInsert("INSERT INTO savedsearchlog(savedsearchid, logid ) VALUES('"+savedsearchlogid+"', '"+savedsearchid+"', '"+logid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearchlogid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchlog WHERE savedsearchlogid='"+savedsearchlogid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchlogid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearchlogDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearchlogDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearchlogid;
    }

    public String getPrimaryKeyName(){
        return "savedsearchlogid";
    }

    public String getTableName(){
        return "savedsearchlog";
    }

    public void setProperties(SavedsearchlogDAO obj){
        if(obj!=null){
            this.savedsearchlogid = obj.savedsearchlogid;
            this.savedsearchid = obj.savedsearchid;
            this.logid = obj.logid;
        }
    }


    public int getSavedsearchlogid() {
        return savedsearchlogid;
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }


    public int getLogid() {
        return logid;
    }


    public void setLogid(int logid) {
        this.logid = logid;
    }


}