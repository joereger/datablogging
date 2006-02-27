package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'eventtoepisode' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEventtoepisodeDAO.java
 * Finders for this DAO: reger.dao.finders.EventtoepisodeFinder.java
 * 
 */

public class EventtoepisodeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "eventtoepisodeDAO";

    protected int eventtoepisodeid = 0;
    protected int eventid = 0;
    protected int episodeid = 0;

    public EventtoepisodeDAO (int eventtoepisodeid){
        this.eventtoepisodeid = eventtoepisodeid;
        load();
    }

    public EventtoepisodeDAO(){


    }

    public void load(){
        if (eventtoepisodeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventtoepisodeid), CACHEGROUP);
            if (obj!=null && (obj instanceof EventtoepisodeDAO)){
                setProperties((EventtoepisodeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid, eventid, episodeid  FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventtoepisodeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventtoepisodeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        episodeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        episodeid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventtoepisodeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT eventtoepisodeid FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"' AND eventtoepisodeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE eventtoepisode SET eventtoepisodeid='"+eventtoepisodeid+"', eventid='"+eventid+"', episodeid='"+episodeid+"'  WHERE eventtoepisodeid='"+eventtoepisodeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventtoepisodeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventtoepisodeid = Db.RunSQLInsert("INSERT INTO eventtoepisode(eventid, episodeid ) VALUES('"+eventtoepisodeid+"', '"+eventid+"', '"+episodeid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventtoepisodeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtoepisode WHERE eventtoepisodeid='"+eventtoepisodeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventtoepisodeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEventtoepisodeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "eventtoepisodeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventtoepisodeid;
    }

    public String getPrimaryKeyName(){
        return "eventtoepisodeid";
    }

    public String getTableName(){
        return "eventtoepisode";
    }

    public void setProperties(EventtoepisodeDAO obj){
        if(obj!=null){
            this.eventtoepisodeid = obj.eventtoepisodeid;
            this.eventid = obj.eventid;
            this.episodeid = obj.episodeid;
        }
    }


    public int getEventtoepisodeid() {
        return eventtoepisodeid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public int getEpisodeid() {
        return episodeid;
    }


    public void setEpisodeid(int episodeid) {
        this.episodeid = episodeid;
    }


}