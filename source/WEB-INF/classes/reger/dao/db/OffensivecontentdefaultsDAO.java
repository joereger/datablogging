package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'offensivecontentdefaults' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorOffensivecontentdefaultsDAO.java
 * Finders for this DAO: reger.dao.finders.OffensivecontentdefaultsFinder.java
 * 
 */

public class OffensivecontentdefaultsDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "offensivecontentdefaultsDAO";

    protected int offensivecontentdefaultsid = 0;
    protected String content = "";

    public OffensivecontentdefaultsDAO (int offensivecontentdefaultsid){
        this.offensivecontentdefaultsid = offensivecontentdefaultsid;
        load();
    }

    public OffensivecontentdefaultsDAO(){


    }

    public void load(){
        if (offensivecontentdefaultsid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(offensivecontentdefaultsid), CACHEGROUP);
            if (obj!=null && (obj instanceof OffensivecontentdefaultsDAO)){
                setProperties((OffensivecontentdefaultsDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT offensivecontentdefaultsid, content  FROM offensivecontentdefaults WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        offensivecontentdefaultsid = Integer.parseInt(rstData[0][0]);
                    } else {
                        offensivecontentdefaultsid = 0;
                    }

                    content = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(offensivecontentdefaultsid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT offensivecontentdefaultsid FROM offensivecontentdefaults WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"' AND offensivecontentdefaultsid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE offensivecontentdefaults SET offensivecontentdefaultsid='"+offensivecontentdefaultsid+"', content='"+reger.core.Util.cleanForSQL(content)+"'  WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(offensivecontentdefaultsid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            offensivecontentdefaultsid = Db.RunSQLInsert("INSERT INTO offensivecontentdefaults(content ) VALUES('"+offensivecontentdefaultsid+"', '"+reger.core.Util.cleanForSQL(content)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(offensivecontentdefaultsid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM offensivecontentdefaults WHERE offensivecontentdefaultsid='"+offensivecontentdefaultsid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(offensivecontentdefaultsid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorOffensivecontentdefaultsDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "offensivecontentdefaultsDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return offensivecontentdefaultsid;
    }

    public String getPrimaryKeyName(){
        return "offensivecontentdefaultsid";
    }

    public String getTableName(){
        return "offensivecontentdefaults";
    }

    public void setProperties(OffensivecontentdefaultsDAO obj){
        if(obj!=null){
            this.offensivecontentdefaultsid = obj.offensivecontentdefaultsid;
            this.content = obj.content;
        }
    }


    public int getOffensivecontentdefaultsid() {
        return offensivecontentdefaultsid;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


}