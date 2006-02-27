package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearchfqe' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearchfqeDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearchfqeFinder.java
 * 
 */

public class SavedsearchfqeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearchfqeDAO";

    protected int savedsearchfqeid = 0;
    protected int megafieldid = 0;
    protected String paramname = "";
    protected String paramvalue = "";
    protected int savedsearchid = 0;

    public SavedsearchfqeDAO (int savedsearchfqeid){
        this.savedsearchfqeid = savedsearchfqeid;
        load();
    }

    public SavedsearchfqeDAO(){


    }

    public void load(){
        if (savedsearchfqeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearchfqeid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearchfqeDAO)){
                setProperties((SavedsearchfqeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid, megafieldid, paramname, paramvalue, savedsearchid  FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearchfqeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearchfqeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        megafieldid = Integer.parseInt(rstData[0][1]);
                    } else {
                        megafieldid = 0;
                    }

                    paramname = rstData[0][2];

                    paramvalue = rstData[0][3];

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        savedsearchid = Integer.parseInt(rstData[0][4]);
                    } else {
                        savedsearchid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearchfqeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearchfqeid FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"' AND savedsearchfqeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearchfqe SET savedsearchfqeid='"+savedsearchfqeid+"', megafieldid='"+megafieldid+"', paramname='"+reger.core.Util.cleanForSQL(paramname)+"', paramvalue='"+reger.core.Util.cleanForSQL(paramvalue)+"', savedsearchid='"+savedsearchid+"'  WHERE savedsearchfqeid='"+savedsearchfqeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchfqeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearchfqeid = Db.RunSQLInsert("INSERT INTO savedsearchfqe(megafieldid, paramname, paramvalue, savedsearchid ) VALUES('"+savedsearchfqeid+"', '"+megafieldid+"', '"+reger.core.Util.cleanForSQL(paramname)+"', '"+reger.core.Util.cleanForSQL(paramvalue)+"', '"+savedsearchid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearchfqeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchfqeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearchfqeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearchfqeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearchfqeid;
    }

    public String getPrimaryKeyName(){
        return "savedsearchfqeid";
    }

    public String getTableName(){
        return "savedsearchfqe";
    }

    public void setProperties(SavedsearchfqeDAO obj){
        if(obj!=null){
            this.savedsearchfqeid = obj.savedsearchfqeid;
            this.megafieldid = obj.megafieldid;
            this.paramname = obj.paramname;
            this.paramvalue = obj.paramvalue;
            this.savedsearchid = obj.savedsearchid;
        }
    }


    public int getSavedsearchfqeid() {
        return savedsearchfqeid;
    }


    public int getMegafieldid() {
        return megafieldid;
    }


    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }


    public String getParamname() {
        return paramname;
    }


    public void setParamname(String paramname) {
        this.paramname = paramname;
    }


    public String getParamvalue() {
        return paramvalue;
    }


    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }


}