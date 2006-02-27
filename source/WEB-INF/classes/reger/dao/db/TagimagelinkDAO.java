package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'tagimagelink' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTagimagelinkDAO.java
 * Finders for this DAO: reger.dao.finders.TagimagelinkFinder.java
 * 
 */

public class TagimagelinkDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "tagimagelinkDAO";

    protected int tagimagelinkid = 0;
    protected int imageid = 0;
    protected int tagid = 0;

    public TagimagelinkDAO (int tagimagelinkid){
        this.tagimagelinkid = tagimagelinkid;
        load();
    }

    public TagimagelinkDAO(){


    }

    public void load(){
        if (tagimagelinkid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(tagimagelinkid), CACHEGROUP);
            if (obj!=null && (obj instanceof TagimagelinkDAO)){
                setProperties((TagimagelinkDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT tagimagelinkid, imageid, tagid  FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        tagimagelinkid = Integer.parseInt(rstData[0][0]);
                    } else {
                        tagimagelinkid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        imageid = Integer.parseInt(rstData[0][1]);
                    } else {
                        imageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        tagid = Integer.parseInt(rstData[0][2]);
                    } else {
                        tagid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(tagimagelinkid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT tagimagelinkid FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"' AND tagimagelinkid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE tagimagelink SET tagimagelinkid='"+tagimagelinkid+"', imageid='"+imageid+"', tagid='"+tagid+"'  WHERE tagimagelinkid='"+tagimagelinkid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(tagimagelinkid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            tagimagelinkid = Db.RunSQLInsert("INSERT INTO tagimagelink(imageid, tagid ) VALUES('"+tagimagelinkid+"', '"+imageid+"', '"+tagid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(tagimagelinkid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM tagimagelink WHERE tagimagelinkid='"+tagimagelinkid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(tagimagelinkid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTagimagelinkDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "tagimagelinkDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return tagimagelinkid;
    }

    public String getPrimaryKeyName(){
        return "tagimagelinkid";
    }

    public String getTableName(){
        return "tagimagelink";
    }

    public void setProperties(TagimagelinkDAO obj){
        if(obj!=null){
            this.tagimagelinkid = obj.tagimagelinkid;
            this.imageid = obj.imageid;
            this.tagid = obj.tagid;
        }
    }


    public int getTagimagelinkid() {
        return tagimagelinkid;
    }


    public int getImageid() {
        return imageid;
    }


    public void setImageid(int imageid) {
        this.imageid = imageid;
    }


    public int getTagid() {
        return tagid;
    }


    public void setTagid(int tagid) {
        this.tagid = tagid;
    }


}