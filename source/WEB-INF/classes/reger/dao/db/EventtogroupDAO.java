package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'eventtogroup' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEventtogroupDAO.java
 * Finders for this DAO: reger.dao.finders.EventtogroupFinder.java
 * 
 */

public class EventtogroupDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "eventtogroupDAO";

    protected int eventtogroupid = 0;
    protected int eventid = 0;
    protected int groupid = 0;

    public EventtogroupDAO (int eventtogroupid){
        this.eventtogroupid = eventtogroupid;
        load();
    }

    public EventtogroupDAO(){


    }

    public void load(){
        if (eventtogroupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventtogroupid), CACHEGROUP);
            if (obj!=null && (obj instanceof EventtogroupDAO)){
                setProperties((EventtogroupDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventtogroupid, eventid, groupid  FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventtogroupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventtogroupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        groupid = Integer.parseInt(rstData[0][2]);
                    } else {
                        groupid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventtogroupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"' AND eventtogroupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE eventtogroup SET eventtogroupid='"+eventtogroupid+"', eventid='"+eventid+"', groupid='"+groupid+"'  WHERE eventtogroupid='"+eventtogroupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventtogroupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventtogroupid = Db.RunSQLInsert("INSERT INTO eventtogroup(eventid, groupid ) VALUES('"+eventtogroupid+"', '"+eventid+"', '"+groupid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventtogroupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventtogroupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEventtogroupDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "eventtogroupDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventtogroupid;
    }

    public String getPrimaryKeyName(){
        return "eventtogroupid";
    }

    public String getTableName(){
        return "eventtogroup";
    }

    public void setProperties(EventtogroupDAO obj){
        if(obj!=null){
            this.eventtogroupid = obj.eventtogroupid;
            this.eventid = obj.eventid;
            this.groupid = obj.groupid;
        }
    }


    public int getEventtogroupid() {
        return eventtogroupid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public int getGroupid() {
        return groupid;
    }


    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }


}