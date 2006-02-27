package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'plnavhide' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPlnavhideDAO.java
 * Finders for this DAO: reger.dao.finders.PlnavhideFinder.java
 * 
 */

public class PlnavhideDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "plnavhideDAO";

    protected int plnavhideid = 0;
    protected int plid = 0;
    protected int nestednavid = 0;

    public PlnavhideDAO (int plnavhideid){
        this.plnavhideid = plnavhideid;
        load();
    }

    public PlnavhideDAO(){


    }

    public void load(){
        if (plnavhideid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(plnavhideid), CACHEGROUP);
            if (obj!=null && (obj instanceof PlnavhideDAO)){
                setProperties((PlnavhideDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT plnavhideid, plid, nestednavid  FROM plnavhide WHERE plnavhideid='"+plnavhideid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        plnavhideid = Integer.parseInt(rstData[0][0]);
                    } else {
                        plnavhideid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        nestednavid = Integer.parseInt(rstData[0][2]);
                    } else {
                        nestednavid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(plnavhideid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT plnavhideid FROM plnavhide WHERE plnavhideid='"+plnavhideid+"' AND plnavhideid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE plnavhide SET plnavhideid='"+plnavhideid+"', plid='"+plid+"', nestednavid='"+nestednavid+"'  WHERE plnavhideid='"+plnavhideid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(plnavhideid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            plnavhideid = Db.RunSQLInsert("INSERT INTO plnavhide(plid, nestednavid ) VALUES('"+plnavhideid+"', '"+plid+"', '"+nestednavid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(plnavhideid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plnavhide WHERE plnavhideid='"+plnavhideid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(plnavhideid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPlnavhideDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "plnavhideDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return plnavhideid;
    }

    public String getPrimaryKeyName(){
        return "plnavhideid";
    }

    public String getTableName(){
        return "plnavhide";
    }

    public void setProperties(PlnavhideDAO obj){
        if(obj!=null){
            this.plnavhideid = obj.plnavhideid;
            this.plid = obj.plid;
            this.nestednavid = obj.nestednavid;
        }
    }


    public int getPlnavhideid() {
        return plnavhideid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getNestednavid() {
        return nestednavid;
    }


    public void setNestednavid(int nestednavid) {
        this.nestednavid = nestednavid;
    }


}