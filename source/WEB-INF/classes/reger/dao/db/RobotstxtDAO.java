package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'robotstxt' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorRobotstxtDAO.java
 * Finders for this DAO: reger.dao.finders.RobotstxtFinder.java
 * 
 */

public class RobotstxtDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "robotstxtDAO";

    protected int robotstxtid = 0;
    protected String robotstxt = "";

    public RobotstxtDAO (int robotstxtid){
        this.robotstxtid = robotstxtid;
        load();
    }

    public RobotstxtDAO(){


    }

    public void load(){
        if (robotstxtid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(robotstxtid), CACHEGROUP);
            if (obj!=null && (obj instanceof RobotstxtDAO)){
                setProperties((RobotstxtDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT robotstxtid, robotstxt  FROM robotstxt WHERE robotstxtid='"+robotstxtid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        robotstxtid = Integer.parseInt(rstData[0][0]);
                    } else {
                        robotstxtid = 0;
                    }

                    robotstxt = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(robotstxtid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT robotstxtid FROM robotstxt WHERE robotstxtid='"+robotstxtid+"' AND robotstxtid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE robotstxt SET robotstxtid='"+robotstxtid+"', robotstxt='"+reger.core.Util.cleanForSQL(robotstxt)+"'  WHERE robotstxtid='"+robotstxtid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(robotstxtid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            robotstxtid = Db.RunSQLInsert("INSERT INTO robotstxt(robotstxt ) VALUES('"+robotstxtid+"', '"+reger.core.Util.cleanForSQL(robotstxt)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(robotstxtid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM robotstxt WHERE robotstxtid='"+robotstxtid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(robotstxtid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorRobotstxtDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "robotstxtDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return robotstxtid;
    }

    public String getPrimaryKeyName(){
        return "robotstxtid";
    }

    public String getTableName(){
        return "robotstxt";
    }

    public void setProperties(RobotstxtDAO obj){
        if(obj!=null){
            this.robotstxtid = obj.robotstxtid;
            this.robotstxt = obj.robotstxt;
        }
    }


    public int getRobotstxtid() {
        return robotstxtid;
    }


    public String getRobotstxt() {
        return robotstxt;
    }


    public void setRobotstxt(String robotstxt) {
        this.robotstxt = robotstxt;
    }


}