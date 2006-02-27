package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'systemproperty' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSystempropertyDAO.java
 * Finders for this DAO: reger.dao.finders.SystempropertyFinder.java
 * 
 */

public class SystempropertyDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "systempropertyDAO";

    protected int systempropertyid = 0;
    protected String propertyname = "";
    protected String propertyvalue = "";

    public SystempropertyDAO (int systempropertyid){
        this.systempropertyid = systempropertyid;
        load();
    }

    public SystempropertyDAO(){


    }

    public void load(){
        if (systempropertyid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(systempropertyid), CACHEGROUP);
            if (obj!=null && (obj instanceof SystempropertyDAO)){
                setProperties((SystempropertyDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT systempropertyid, propertyname, propertyvalue  FROM systemproperty WHERE systempropertyid='"+systempropertyid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        systempropertyid = Integer.parseInt(rstData[0][0]);
                    } else {
                        systempropertyid = 0;
                    }

                    propertyname = rstData[0][1];

                    propertyvalue = rstData[0][2];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(systempropertyid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT systempropertyid FROM systemproperty WHERE systempropertyid='"+systempropertyid+"' AND systempropertyid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE systemproperty SET systempropertyid='"+systempropertyid+"', propertyname='"+reger.core.Util.cleanForSQL(propertyname)+"', propertyvalue='"+reger.core.Util.cleanForSQL(propertyvalue)+"'  WHERE systempropertyid='"+systempropertyid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(systempropertyid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            systempropertyid = Db.RunSQLInsert("INSERT INTO systemproperty(propertyname, propertyvalue ) VALUES('"+systempropertyid+"', '"+reger.core.Util.cleanForSQL(propertyname)+"', '"+reger.core.Util.cleanForSQL(propertyvalue)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(systempropertyid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM systemproperty WHERE systempropertyid='"+systempropertyid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(systempropertyid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSystempropertyDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "systempropertyDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return systempropertyid;
    }

    public String getPrimaryKeyName(){
        return "systempropertyid";
    }

    public String getTableName(){
        return "systemproperty";
    }

    public void setProperties(SystempropertyDAO obj){
        if(obj!=null){
            this.systempropertyid = obj.systempropertyid;
            this.propertyname = obj.propertyname;
            this.propertyvalue = obj.propertyvalue;
        }
    }


    public int getSystempropertyid() {
        return systempropertyid;
    }


    public String getPropertyname() {
        return propertyname;
    }


    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }


    public String getPropertyvalue() {
        return propertyvalue;
    }


    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue;
    }


}