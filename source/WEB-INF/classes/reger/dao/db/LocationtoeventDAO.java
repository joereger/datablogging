package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'locationtoevent' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLocationtoeventDAO.java
 * Finders for this DAO: reger.dao.finders.LocationtoeventFinder.java
 * 
 */

public class LocationtoeventDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "locationtoeventDAO";

    protected int locationtoeventid = 0;
    protected int locationid = 0;
    protected int eventid = 0;

    public LocationtoeventDAO (int locationtoeventid){
        this.locationtoeventid = locationtoeventid;
        load();
    }

    public LocationtoeventDAO(){


    }

    public void load(){
        if (locationtoeventid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(locationtoeventid), CACHEGROUP);
            if (obj!=null && (obj instanceof LocationtoeventDAO)){
                setProperties((LocationtoeventDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT locationtoeventid, locationid, eventid  FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        locationtoeventid = Integer.parseInt(rstData[0][0]);
                    } else {
                        locationtoeventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        locationid = Integer.parseInt(rstData[0][1]);
                    } else {
                        locationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(locationtoeventid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT locationtoeventid FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"' AND locationtoeventid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE locationtoevent SET locationtoeventid='"+locationtoeventid+"', locationid='"+locationid+"', eventid='"+eventid+"'  WHERE locationtoeventid='"+locationtoeventid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(locationtoeventid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            locationtoeventid = Db.RunSQLInsert("INSERT INTO locationtoevent(locationid, eventid ) VALUES('"+locationtoeventid+"', '"+locationid+"', '"+eventid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(locationtoeventid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM locationtoevent WHERE locationtoeventid='"+locationtoeventid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(locationtoeventid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLocationtoeventDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "locationtoeventDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return locationtoeventid;
    }

    public String getPrimaryKeyName(){
        return "locationtoeventid";
    }

    public String getTableName(){
        return "locationtoevent";
    }

    public void setProperties(LocationtoeventDAO obj){
        if(obj!=null){
            this.locationtoeventid = obj.locationtoeventid;
            this.locationid = obj.locationid;
            this.eventid = obj.eventid;
        }
    }


    public int getLocationtoeventid() {
        return locationtoeventid;
    }


    public int getLocationid() {
        return locationid;
    }


    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


}