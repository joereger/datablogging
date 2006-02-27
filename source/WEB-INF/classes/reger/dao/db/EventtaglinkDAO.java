package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'eventtaglink' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEventtaglinkDAO.java
 * Finders for this DAO: reger.dao.finders.EventtaglinkFinder.java
 * 
 */

public class EventtaglinkDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "eventtaglinkDAO";

    protected int eventtaglinkid = 0;
    protected int eventid = 0;
    protected int tagid = 0;

    public EventtaglinkDAO (int eventtaglinkid){
        this.eventtaglinkid = eventtaglinkid;
        load();
    }

    public EventtaglinkDAO(){


    }

    public void load(){
        if (eventtaglinkid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventtaglinkid), CACHEGROUP);
            if (obj!=null && (obj instanceof EventtaglinkDAO)){
                setProperties((EventtaglinkDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventtaglinkid, eventid, tagid  FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventtaglinkid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventtaglinkid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        tagid = Integer.parseInt(rstData[0][2]);
                    } else {
                        tagid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventtaglinkid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"' AND eventtaglinkid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE eventtaglink SET eventtaglinkid='"+eventtaglinkid+"', eventid='"+eventid+"', tagid='"+tagid+"'  WHERE eventtaglinkid='"+eventtaglinkid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventtaglinkid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventtaglinkid = Db.RunSQLInsert("INSERT INTO eventtaglink(eventid, tagid ) VALUES('"+eventtaglinkid+"', '"+eventid+"', '"+tagid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventtaglinkid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtaglink WHERE eventtaglinkid='"+eventtaglinkid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventtaglinkid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEventtaglinkDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "eventtaglinkDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventtaglinkid;
    }

    public String getPrimaryKeyName(){
        return "eventtaglinkid";
    }

    public String getTableName(){
        return "eventtaglink";
    }

    public void setProperties(EventtaglinkDAO obj){
        if(obj!=null){
            this.eventtaglinkid = obj.eventtaglinkid;
            this.eventid = obj.eventid;
            this.tagid = obj.tagid;
        }
    }


    public int getEventtaglinkid() {
        return eventtaglinkid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public int getTagid() {
        return tagid;
    }


    public void setTagid(int tagid) {
        this.tagid = tagid;
    }


}