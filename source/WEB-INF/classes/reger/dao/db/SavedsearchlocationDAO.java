package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearchlocation' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearchlocationDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearchlocationFinder.java
 * 
 */

public class SavedsearchlocationDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearchlocationDAO";

    protected int savedsearchlocationid = 0;
    protected int savedsearchid = 0;
    protected int locationid = 0;

    public SavedsearchlocationDAO (int savedsearchlocationid){
        this.savedsearchlocationid = savedsearchlocationid;
        load();
    }

    public SavedsearchlocationDAO(){


    }

    public void load(){
        if (savedsearchlocationid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearchlocationid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearchlocationDAO)){
                setProperties((SavedsearchlocationDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid, savedsearchid, locationid  FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearchlocationid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearchlocationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        savedsearchid = Integer.parseInt(rstData[0][1]);
                    } else {
                        savedsearchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        locationid = Integer.parseInt(rstData[0][2]);
                    } else {
                        locationid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearchlocationid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearchlocationid FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"' AND savedsearchlocationid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearchlocation SET savedsearchlocationid='"+savedsearchlocationid+"', savedsearchid='"+savedsearchid+"', locationid='"+locationid+"'  WHERE savedsearchlocationid='"+savedsearchlocationid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchlocationid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearchlocationid = Db.RunSQLInsert("INSERT INTO savedsearchlocation(savedsearchid, locationid ) VALUES('"+savedsearchlocationid+"', '"+savedsearchid+"', '"+locationid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearchlocationid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchlocation WHERE savedsearchlocationid='"+savedsearchlocationid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchlocationid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearchlocationDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearchlocationDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearchlocationid;
    }

    public String getPrimaryKeyName(){
        return "savedsearchlocationid";
    }

    public String getTableName(){
        return "savedsearchlocation";
    }

    public void setProperties(SavedsearchlocationDAO obj){
        if(obj!=null){
            this.savedsearchlocationid = obj.savedsearchlocationid;
            this.savedsearchid = obj.savedsearchid;
            this.locationid = obj.locationid;
        }
    }


    public int getSavedsearchlocationid() {
        return savedsearchlocationid;
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }


    public int getLocationid() {
        return locationid;
    }


    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }


}