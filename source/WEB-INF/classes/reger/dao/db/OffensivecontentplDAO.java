package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'offensivecontentpl' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorOffensivecontentplDAO.java
 * Finders for this DAO: reger.dao.finders.OffensivecontentplFinder.java
 * 
 */

public class OffensivecontentplDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "offensivecontentplDAO";

    protected int offensivecontentplid = 0;
    protected int plid = 0;
    protected String content = "";

    public OffensivecontentplDAO (int offensivecontentplid){
        this.offensivecontentplid = offensivecontentplid;
        load();
    }

    public OffensivecontentplDAO(){


    }

    public void load(){
        if (offensivecontentplid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(offensivecontentplid), CACHEGROUP);
            if (obj!=null && (obj instanceof OffensivecontentplDAO)){
                setProperties((OffensivecontentplDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT offensivecontentplid, plid, content  FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        offensivecontentplid = Integer.parseInt(rstData[0][0]);
                    } else {
                        offensivecontentplid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    content = rstData[0][2];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(offensivecontentplid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT offensivecontentplid FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"' AND offensivecontentplid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE offensivecontentpl SET offensivecontentplid='"+offensivecontentplid+"', plid='"+plid+"', content='"+reger.core.Util.cleanForSQL(content)+"'  WHERE offensivecontentplid='"+offensivecontentplid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(offensivecontentplid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            offensivecontentplid = Db.RunSQLInsert("INSERT INTO offensivecontentpl(plid, content ) VALUES('"+offensivecontentplid+"', '"+plid+"', '"+reger.core.Util.cleanForSQL(content)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(offensivecontentplid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM offensivecontentpl WHERE offensivecontentplid='"+offensivecontentplid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(offensivecontentplid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorOffensivecontentplDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "offensivecontentplDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return offensivecontentplid;
    }

    public String getPrimaryKeyName(){
        return "offensivecontentplid";
    }

    public String getTableName(){
        return "offensivecontentpl";
    }

    public void setProperties(OffensivecontentplDAO obj){
        if(obj!=null){
            this.offensivecontentplid = obj.offensivecontentplid;
            this.plid = obj.plid;
            this.content = obj.content;
        }
    }


    public int getOffensivecontentplid() {
        return offensivecontentplid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


}