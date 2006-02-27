package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pleventtypeid' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPleventtypeidDAO.java
 * Finders for this DAO: reger.dao.finders.PleventtypeidFinder.java
 * 
 */

public class PleventtypeidDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pleventtypeidDAO";

    protected int pleventtypeid = 0;
    protected int plid = 0;
    protected int eventtypeid = 0;
    protected int priority = 0;

    public PleventtypeidDAO (int pleventtypeid){
        this.pleventtypeid = pleventtypeid;
        load();
    }

    public PleventtypeidDAO(){


    }

    public void load(){
        if (pleventtypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pleventtypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof PleventtypeidDAO)){
                setProperties((PleventtypeidDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pleventtypeid, plid, eventtypeid, priority  FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pleventtypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pleventtypeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventtypeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        priority = Integer.parseInt(rstData[0][3]);
                    } else {
                        priority = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pleventtypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"' AND pleventtypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pleventtypeid SET pleventtypeid='"+pleventtypeid+"', plid='"+plid+"', eventtypeid='"+eventtypeid+"', priority='"+priority+"'  WHERE pleventtypeid='"+pleventtypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pleventtypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pleventtypeid = Db.RunSQLInsert("INSERT INTO pleventtypeid(plid, eventtypeid, priority ) VALUES('"+pleventtypeid+"', '"+plid+"', '"+eventtypeid+"', '"+priority+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pleventtypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pleventtypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPleventtypeidDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pleventtypeidDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pleventtypeid;
    }

    public String getPrimaryKeyName(){
        return "pleventtypeid";
    }

    public String getTableName(){
        return "pleventtypeid";
    }

    public void setProperties(PleventtypeidDAO obj){
        if(obj!=null){
            this.pleventtypeid = obj.pleventtypeid;
            this.plid = obj.plid;
            this.eventtypeid = obj.eventtypeid;
            this.priority = obj.priority;
        }
    }


    public int getPleventtypeid() {
        return pleventtypeid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


}