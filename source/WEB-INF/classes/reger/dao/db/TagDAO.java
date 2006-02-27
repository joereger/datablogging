package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'tag' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTagDAO.java
 * Finders for this DAO: reger.dao.finders.TagFinder.java
 * 
 */

public class TagDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "tagDAO";

    protected int tagid = 0;
    protected String tag = "";

    public TagDAO (int tagid){
        this.tagid = tagid;
        load();
    }

    public TagDAO(){


    }

    public void load(){
        if (tagid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(tagid), CACHEGROUP);
            if (obj!=null && (obj instanceof TagDAO)){
                setProperties((TagDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT tagid, tag  FROM tag WHERE tagid='"+tagid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        tagid = Integer.parseInt(rstData[0][0]);
                    } else {
                        tagid = 0;
                    }

                    tag = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(tagid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT tagid FROM tag WHERE tagid='"+tagid+"' AND tagid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE tag SET tagid='"+tagid+"', tag='"+reger.core.Util.cleanForSQL(tag)+"'  WHERE tagid='"+tagid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(tagid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            tagid = Db.RunSQLInsert("INSERT INTO tag(tag ) VALUES('"+tagid+"', '"+reger.core.Util.cleanForSQL(tag)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(tagid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM tag WHERE tagid='"+tagid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(tagid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTagDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "tagDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return tagid;
    }

    public String getPrimaryKeyName(){
        return "tagid";
    }

    public String getTableName(){
        return "tag";
    }

    public void setProperties(TagDAO obj){
        if(obj!=null){
            this.tagid = obj.tagid;
            this.tag = obj.tag;
        }
    }


    public int getTagid() {
        return tagid;
    }


    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }


}