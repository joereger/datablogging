package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'bugcategory' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBugcategoryDAO.java
 * Finders for this DAO: reger.dao.finders.BugcategoryFinder.java
 * 
 */

public class BugcategoryDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bugcategoryDAO";

    protected int bugcategoryid = 0;
    protected String bugcategory = "";

    public BugcategoryDAO (int bugcategoryid){
        this.bugcategoryid = bugcategoryid;
        load();
    }

    public BugcategoryDAO(){


    }

    public void load(){
        if (bugcategoryid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bugcategoryid), CACHEGROUP);
            if (obj!=null && (obj instanceof BugcategoryDAO)){
                setProperties((BugcategoryDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bugcategoryid, bugcategory  FROM bugcategory WHERE bugcategoryid='"+bugcategoryid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bugcategoryid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bugcategoryid = 0;
                    }

                    bugcategory = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bugcategoryid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bugcategoryid FROM bugcategory WHERE bugcategoryid='"+bugcategoryid+"' AND bugcategoryid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE bugcategory SET bugcategoryid='"+bugcategoryid+"', bugcategory='"+reger.core.Util.cleanForSQL(bugcategory)+"'  WHERE bugcategoryid='"+bugcategoryid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bugcategoryid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bugcategoryid = Db.RunSQLInsert("INSERT INTO bugcategory(bugcategory ) VALUES('"+bugcategoryid+"', '"+reger.core.Util.cleanForSQL(bugcategory)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bugcategoryid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM bugcategory WHERE bugcategoryid='"+bugcategoryid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bugcategoryid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBugcategoryDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bugcategoryDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bugcategoryid;
    }

    public String getPrimaryKeyName(){
        return "bugcategoryid";
    }

    public String getTableName(){
        return "bugcategory";
    }

    public void setProperties(BugcategoryDAO obj){
        if(obj!=null){
            this.bugcategoryid = obj.bugcategoryid;
            this.bugcategory = obj.bugcategory;
        }
    }


    public int getBugcategoryid() {
        return bugcategoryid;
    }


    public String getBugcategory() {
        return bugcategory;
    }


    public void setBugcategory(String bugcategory) {
        this.bugcategory = bugcategory;
    }


}