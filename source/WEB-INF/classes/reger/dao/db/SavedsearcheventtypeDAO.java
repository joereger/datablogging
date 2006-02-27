package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearcheventtype' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearcheventtypeDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearcheventtypeFinder.java
 * 
 */

public class SavedsearcheventtypeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearcheventtypeDAO";

    protected int savedsearcheventtypeid = 0;
    protected int savedsearchid = 0;
    protected int eventtypeid = 0;

    public SavedsearcheventtypeDAO (int savedsearcheventtypeid){
        this.savedsearcheventtypeid = savedsearcheventtypeid;
        load();
    }

    public SavedsearcheventtypeDAO(){


    }

    public void load(){
        if (savedsearcheventtypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearcheventtypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearcheventtypeDAO)){
                setProperties((SavedsearcheventtypeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid, savedsearchid, eventtypeid  FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearcheventtypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearcheventtypeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        savedsearchid = Integer.parseInt(rstData[0][1]);
                    } else {
                        savedsearchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventtypeid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearcheventtypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearcheventtypeid FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"' AND savedsearcheventtypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearcheventtype SET savedsearcheventtypeid='"+savedsearcheventtypeid+"', savedsearchid='"+savedsearchid+"', eventtypeid='"+eventtypeid+"'  WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearcheventtypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearcheventtypeid = Db.RunSQLInsert("INSERT INTO savedsearcheventtype(savedsearchid, eventtypeid ) VALUES('"+savedsearcheventtypeid+"', '"+savedsearchid+"', '"+eventtypeid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearcheventtypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearcheventtype WHERE savedsearcheventtypeid='"+savedsearcheventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearcheventtypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearcheventtypeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearcheventtypeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearcheventtypeid;
    }

    public String getPrimaryKeyName(){
        return "savedsearcheventtypeid";
    }

    public String getTableName(){
        return "savedsearcheventtype";
    }

    public void setProperties(SavedsearcheventtypeDAO obj){
        if(obj!=null){
            this.savedsearcheventtypeid = obj.savedsearcheventtypeid;
            this.savedsearchid = obj.savedsearchid;
            this.eventtypeid = obj.eventtypeid;
        }
    }


    public int getSavedsearcheventtypeid() {
        return savedsearcheventtypeid;
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


}