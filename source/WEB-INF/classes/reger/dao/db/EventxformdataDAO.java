package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'eventxformdata' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEventxformdataDAO.java
 * Finders for this DAO: reger.dao.finders.EventxformdataFinder.java
 * 
 */

public class EventxformdataDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "eventxformdataDAO";

    protected int eventxformdataid = 0;
    protected int eventid = 0;
    protected String xformdata = "";

    public EventxformdataDAO (int eventxformdataid){
        this.eventxformdataid = eventxformdataid;
        load();
    }

    public EventxformdataDAO(){


    }

    public void load(){
        if (eventxformdataid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventxformdataid), CACHEGROUP);
            if (obj!=null && (obj instanceof EventxformdataDAO)){
                setProperties((EventxformdataDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventxformdataid, eventid, xformdata  FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventxformdataid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventxformdataid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    xformdata = rstData[0][2];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventxformdataid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"' AND eventxformdataid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE eventxformdata SET eventxformdataid='"+eventxformdataid+"', eventid='"+eventid+"', xformdata='"+reger.core.Util.cleanForSQL(xformdata)+"'  WHERE eventxformdataid='"+eventxformdataid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventxformdataid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventxformdataid = Db.RunSQLInsert("INSERT INTO eventxformdata(eventid, xformdata ) VALUES('"+eventxformdataid+"', '"+eventid+"', '"+reger.core.Util.cleanForSQL(xformdata)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventxformdataid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventxformdataid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEventxformdataDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "eventxformdataDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventxformdataid;
    }

    public String getPrimaryKeyName(){
        return "eventxformdataid";
    }

    public String getTableName(){
        return "eventxformdata";
    }

    public void setProperties(EventxformdataDAO obj){
        if(obj!=null){
            this.eventxformdataid = obj.eventxformdataid;
            this.eventid = obj.eventid;
            this.xformdata = obj.xformdata;
        }
    }


    public int getEventxformdataid() {
        return eventxformdataid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public String getXformdata() {
        return xformdata;
    }


    public void setXformdata(String xformdata) {
        this.xformdata = xformdata;
    }


}