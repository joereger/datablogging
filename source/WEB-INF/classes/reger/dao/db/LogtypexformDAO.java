package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'logtypexform' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLogtypexformDAO.java
 * Finders for this DAO: reger.dao.finders.LogtypexformFinder.java
 * 
 */

public class LogtypexformDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "logtypexformDAO";

    protected int logtypexformid = 0;
    protected int eventtypeid = 0;
    protected String xform = "";
    protected String xformdefinition = "";

    public LogtypexformDAO (int logtypexformid){
        this.logtypexformid = logtypexformid;
        load();
    }

    public LogtypexformDAO(){


    }

    public void load(){
        if (logtypexformid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(logtypexformid), CACHEGROUP);
            if (obj!=null && (obj instanceof LogtypexformDAO)){
                setProperties((LogtypexformDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT logtypexformid, eventtypeid, xform, xformdefinition  FROM logtypexform WHERE logtypexformid='"+logtypexformid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        logtypexformid = Integer.parseInt(rstData[0][0]);
                    } else {
                        logtypexformid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventtypeid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventtypeid = 0;
                    }

                    xform = rstData[0][2];

                    xformdefinition = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(logtypexformid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"' AND logtypexformid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE logtypexform SET logtypexformid='"+logtypexformid+"', eventtypeid='"+eventtypeid+"', xform='"+reger.core.Util.cleanForSQL(xform)+"', xformdefinition='"+reger.core.Util.cleanForSQL(xformdefinition)+"'  WHERE logtypexformid='"+logtypexformid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(logtypexformid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            logtypexformid = Db.RunSQLInsert("INSERT INTO logtypexform(eventtypeid, xform, xformdefinition ) VALUES('"+logtypexformid+"', '"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(xform)+"', '"+reger.core.Util.cleanForSQL(xformdefinition)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(logtypexformid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM logtypexform WHERE logtypexformid='"+logtypexformid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(logtypexformid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLogtypexformDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "logtypexformDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return logtypexformid;
    }

    public String getPrimaryKeyName(){
        return "logtypexformid";
    }

    public String getTableName(){
        return "logtypexform";
    }

    public void setProperties(LogtypexformDAO obj){
        if(obj!=null){
            this.logtypexformid = obj.logtypexformid;
            this.eventtypeid = obj.eventtypeid;
            this.xform = obj.xform;
            this.xformdefinition = obj.xformdefinition;
        }
    }


    public int getLogtypexformid() {
        return logtypexformid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


    public String getXform() {
        return xform;
    }


    public void setXform(String xform) {
        this.xform = xform;
    }


    public String getXformdefinition() {
        return xformdefinition;
    }


    public void setXformdefinition(String xformdefinition) {
        this.xformdefinition = xformdefinition;
    }


}