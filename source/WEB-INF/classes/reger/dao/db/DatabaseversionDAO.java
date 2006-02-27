package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'databaseversion' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorDatabaseversionDAO.java
 * Finders for this DAO: reger.dao.finders.DatabaseversionFinder.java
 * 
 */

public class DatabaseversionDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "databaseversionDAO";

    protected int databaseversionid = 0;
    protected int version = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();

    public DatabaseversionDAO (int databaseversionid){
        this.databaseversionid = databaseversionid;
        load();
    }

    public DatabaseversionDAO(){


    }

    public void load(){
        if (databaseversionid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(databaseversionid), CACHEGROUP);
            if (obj!=null && (obj instanceof DatabaseversionDAO)){
                setProperties((DatabaseversionDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT databaseversionid, version, date  FROM databaseversion WHERE databaseversionid='"+databaseversionid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        databaseversionid = Integer.parseInt(rstData[0][0]);
                    } else {
                        databaseversionid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        version = Integer.parseInt(rstData[0][1]);
                    } else {
                        version = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(databaseversionid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT databaseversionid FROM databaseversion WHERE databaseversionid='"+databaseversionid+"' AND databaseversionid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE databaseversion SET databaseversionid='"+databaseversionid+"', version='"+version+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"'  WHERE databaseversionid='"+databaseversionid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(databaseversionid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            databaseversionid = Db.RunSQLInsert("INSERT INTO databaseversion(version, date ) VALUES('"+databaseversionid+"', '"+version+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(databaseversionid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM databaseversion WHERE databaseversionid='"+databaseversionid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(databaseversionid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorDatabaseversionDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "databaseversionDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return databaseversionid;
    }

    public String getPrimaryKeyName(){
        return "databaseversionid";
    }

    public String getTableName(){
        return "databaseversion";
    }

    public void setProperties(DatabaseversionDAO obj){
        if(obj!=null){
            this.databaseversionid = obj.databaseversionid;
            this.version = obj.version;
            this.date = obj.date;
        }
    }


    public int getDatabaseversionid() {
        return databaseversionid;
    }


    public int getVersion() {
        return version;
    }


    public void setVersion(int version) {
        this.version = version;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


}