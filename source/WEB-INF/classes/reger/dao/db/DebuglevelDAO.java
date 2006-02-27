package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'debuglevel' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorDebuglevelDAO.java
 * Finders for this DAO: reger.dao.finders.DebuglevelFinder.java
 * 
 */

public class DebuglevelDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "debuglevelDAO";

    protected int debuglevelid = 0;
    protected int debuglevel = 0;

    public DebuglevelDAO (int debuglevelid){
        this.debuglevelid = debuglevelid;
        load();
    }

    public DebuglevelDAO(){


    }

    public void load(){
        if (debuglevelid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(debuglevelid), CACHEGROUP);
            if (obj!=null && (obj instanceof DebuglevelDAO)){
                setProperties((DebuglevelDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT debuglevelid, debuglevel  FROM debuglevel WHERE debuglevelid='"+debuglevelid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        debuglevelid = Integer.parseInt(rstData[0][0]);
                    } else {
                        debuglevelid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        debuglevel = Integer.parseInt(rstData[0][1]);
                    } else {
                        debuglevel = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(debuglevelid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT debuglevelid FROM debuglevel WHERE debuglevelid='"+debuglevelid+"' AND debuglevelid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE debuglevel SET debuglevelid='"+debuglevelid+"', debuglevel='"+debuglevel+"'  WHERE debuglevelid='"+debuglevelid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(debuglevelid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            debuglevelid = Db.RunSQLInsert("INSERT INTO debuglevel(debuglevel ) VALUES('"+debuglevelid+"', '"+debuglevel+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(debuglevelid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM debuglevel WHERE debuglevelid='"+debuglevelid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(debuglevelid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorDebuglevelDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "debuglevelDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return debuglevelid;
    }

    public String getPrimaryKeyName(){
        return "debuglevelid";
    }

    public String getTableName(){
        return "debuglevel";
    }

    public void setProperties(DebuglevelDAO obj){
        if(obj!=null){
            this.debuglevelid = obj.debuglevelid;
            this.debuglevel = obj.debuglevel;
        }
    }


    public int getDebuglevelid() {
        return debuglevelid;
    }


    public int getDebuglevel() {
        return debuglevel;
    }


    public void setDebuglevel(int debuglevel) {
        this.debuglevel = debuglevel;
    }


}