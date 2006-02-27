package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'systemlicense' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSystemlicenseDAO.java
 * Finders for this DAO: reger.dao.finders.SystemlicenseFinder.java
 * 
 */

public class SystemlicenseDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "systemlicenseDAO";

    protected int systemlicenseid = 0;
    protected String encryptedlicense = "";

    public SystemlicenseDAO (int systemlicenseid){
        this.systemlicenseid = systemlicenseid;
        load();
    }

    public SystemlicenseDAO(){


    }

    public void load(){
        if (systemlicenseid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(systemlicenseid), CACHEGROUP);
            if (obj!=null && (obj instanceof SystemlicenseDAO)){
                setProperties((SystemlicenseDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT systemlicenseid, encryptedlicense  FROM systemlicense WHERE systemlicenseid='"+systemlicenseid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        systemlicenseid = Integer.parseInt(rstData[0][0]);
                    } else {
                        systemlicenseid = 0;
                    }

                    encryptedlicense = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(systemlicenseid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT systemlicenseid FROM systemlicense WHERE systemlicenseid='"+systemlicenseid+"' AND systemlicenseid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE systemlicense SET systemlicenseid='"+systemlicenseid+"', encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"'  WHERE systemlicenseid='"+systemlicenseid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(systemlicenseid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            systemlicenseid = Db.RunSQLInsert("INSERT INTO systemlicense(encryptedlicense ) VALUES('"+systemlicenseid+"', '"+reger.core.Util.cleanForSQL(encryptedlicense)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(systemlicenseid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM systemlicense WHERE systemlicenseid='"+systemlicenseid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(systemlicenseid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSystemlicenseDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "systemlicenseDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return systemlicenseid;
    }

    public String getPrimaryKeyName(){
        return "systemlicenseid";
    }

    public String getTableName(){
        return "systemlicense";
    }

    public void setProperties(SystemlicenseDAO obj){
        if(obj!=null){
            this.systemlicenseid = obj.systemlicenseid;
            this.encryptedlicense = obj.encryptedlicense;
        }
    }


    public int getSystemlicenseid() {
        return systemlicenseid;
    }


    public String getEncryptedlicense() {
        return encryptedlicense;
    }


    public void setEncryptedlicense(String encryptedlicense) {
        this.encryptedlicense = encryptedlicense;
    }


}