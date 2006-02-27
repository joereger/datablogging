package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'plpeer' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPlpeerDAO.java
 * Finders for this DAO: reger.dao.finders.PlpeerFinder.java
 * 
 */

public class PlpeerDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "plpeerDAO";

    protected int plpeerid = 0;
    protected int plid = 0;
    protected int peerplid = 0;

    public PlpeerDAO (int plpeerid){
        this.plpeerid = plpeerid;
        load();
    }

    public PlpeerDAO(){


    }

    public void load(){
        if (plpeerid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(plpeerid), CACHEGROUP);
            if (obj!=null && (obj instanceof PlpeerDAO)){
                setProperties((PlpeerDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT plpeerid, plid, peerplid  FROM plpeer WHERE plpeerid='"+plpeerid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        plpeerid = Integer.parseInt(rstData[0][0]);
                    } else {
                        plpeerid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        peerplid = Integer.parseInt(rstData[0][2]);
                    } else {
                        peerplid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(plpeerid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plpeerid='"+plpeerid+"' AND plpeerid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE plpeer SET plpeerid='"+plpeerid+"', plid='"+plid+"', peerplid='"+peerplid+"'  WHERE plpeerid='"+plpeerid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(plpeerid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            plpeerid = Db.RunSQLInsert("INSERT INTO plpeer(plid, peerplid ) VALUES('"+plpeerid+"', '"+plid+"', '"+peerplid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(plpeerid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plpeer WHERE plpeerid='"+plpeerid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(plpeerid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPlpeerDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "plpeerDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return plpeerid;
    }

    public String getPrimaryKeyName(){
        return "plpeerid";
    }

    public String getTableName(){
        return "plpeer";
    }

    public void setProperties(PlpeerDAO obj){
        if(obj!=null){
            this.plpeerid = obj.plpeerid;
            this.plid = obj.plid;
            this.peerplid = obj.peerplid;
        }
    }


    public int getPlpeerid() {
        return plpeerid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getPeerplid() {
        return peerplid;
    }


    public void setPeerplid(int peerplid) {
        this.peerplid = peerplid;
    }


}