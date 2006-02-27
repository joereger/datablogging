package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'plcontentoverride' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPlcontentoverrideDAO.java
 * Finders for this DAO: reger.dao.finders.PlcontentoverrideFinder.java
 * 
 */

public class PlcontentoverrideDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "plcontentoverrideDAO";

    protected int plcontentoverrideid = 0;
    protected int plid = 0;
    protected int pljspidtooverride = 0;
    protected String content = "";

    public PlcontentoverrideDAO (int plcontentoverrideid){
        this.plcontentoverrideid = plcontentoverrideid;
        load();
    }

    public PlcontentoverrideDAO(){


    }

    public void load(){
        if (plcontentoverrideid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(plcontentoverrideid), CACHEGROUP);
            if (obj!=null && (obj instanceof PlcontentoverrideDAO)){
                setProperties((PlcontentoverrideDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid, plid, pljspidtooverride, content  FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        plcontentoverrideid = Integer.parseInt(rstData[0][0]);
                    } else {
                        plcontentoverrideid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        pljspidtooverride = Integer.parseInt(rstData[0][2]);
                    } else {
                        pljspidtooverride = 0;
                    }

                    content = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(plcontentoverrideid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT plcontentoverrideid FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"' AND plcontentoverrideid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE plcontentoverride SET plcontentoverrideid='"+plcontentoverrideid+"', plid='"+plid+"', pljspidtooverride='"+pljspidtooverride+"', content='"+reger.core.Util.cleanForSQL(content)+"'  WHERE plcontentoverrideid='"+plcontentoverrideid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(plcontentoverrideid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            plcontentoverrideid = Db.RunSQLInsert("INSERT INTO plcontentoverride(plid, pljspidtooverride, content ) VALUES('"+plcontentoverrideid+"', '"+plid+"', '"+pljspidtooverride+"', '"+reger.core.Util.cleanForSQL(content)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(plcontentoverrideid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plcontentoverride WHERE plcontentoverrideid='"+plcontentoverrideid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(plcontentoverrideid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPlcontentoverrideDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "plcontentoverrideDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return plcontentoverrideid;
    }

    public String getPrimaryKeyName(){
        return "plcontentoverrideid";
    }

    public String getTableName(){
        return "plcontentoverride";
    }

    public void setProperties(PlcontentoverrideDAO obj){
        if(obj!=null){
            this.plcontentoverrideid = obj.plcontentoverrideid;
            this.plid = obj.plid;
            this.pljspidtooverride = obj.pljspidtooverride;
            this.content = obj.content;
        }
    }


    public int getPlcontentoverrideid() {
        return plcontentoverrideid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getPljspidtooverride() {
        return pljspidtooverride;
    }


    public void setPljspidtooverride(int pljspidtooverride) {
        this.pljspidtooverride = pljspidtooverride;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


}