package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'linkroteventlookup' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLinkroteventlookupDAO.java
 * Finders for this DAO: reger.dao.finders.LinkroteventlookupFinder.java
 * 
 */

public class LinkroteventlookupDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "linkroteventlookupDAO";

    protected int linkroteventlookupid = 0;
    protected int linkrotid = 0;
    protected int eventid = 0;

    public LinkroteventlookupDAO (int linkroteventlookupid){
        this.linkroteventlookupid = linkroteventlookupid;
        load();
    }

    public LinkroteventlookupDAO(){


    }

    public void load(){
        if (linkroteventlookupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(linkroteventlookupid), CACHEGROUP);
            if (obj!=null && (obj instanceof LinkroteventlookupDAO)){
                setProperties((LinkroteventlookupDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid, linkrotid, eventid  FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        linkroteventlookupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        linkroteventlookupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        linkrotid = Integer.parseInt(rstData[0][1]);
                    } else {
                        linkrotid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(linkroteventlookupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT linkroteventlookupid FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"' AND linkroteventlookupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE linkroteventlookup SET linkroteventlookupid='"+linkroteventlookupid+"', linkrotid='"+linkrotid+"', eventid='"+eventid+"'  WHERE linkroteventlookupid='"+linkroteventlookupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(linkroteventlookupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            linkroteventlookupid = Db.RunSQLInsert("INSERT INTO linkroteventlookup(linkrotid, eventid ) VALUES('"+linkroteventlookupid+"', '"+linkrotid+"', '"+eventid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(linkroteventlookupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM linkroteventlookup WHERE linkroteventlookupid='"+linkroteventlookupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(linkroteventlookupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLinkroteventlookupDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "linkroteventlookupDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return linkroteventlookupid;
    }

    public String getPrimaryKeyName(){
        return "linkroteventlookupid";
    }

    public String getTableName(){
        return "linkroteventlookup";
    }

    public void setProperties(LinkroteventlookupDAO obj){
        if(obj!=null){
            this.linkroteventlookupid = obj.linkroteventlookupid;
            this.linkrotid = obj.linkrotid;
            this.eventid = obj.eventid;
        }
    }


    public int getLinkroteventlookupid() {
        return linkroteventlookupid;
    }


    public int getLinkrotid() {
        return linkrotid;
    }


    public void setLinkrotid(int linkrotid) {
        this.linkrotid = linkrotid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


}