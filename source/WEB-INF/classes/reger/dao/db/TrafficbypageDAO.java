package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'trafficbypage' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTrafficbypageDAO.java
 * Finders for this DAO: reger.dao.finders.TrafficbypageFinder.java
 * 
 */

public class TrafficbypageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "trafficbypageDAO";

    protected int trafficbypageid = 0;
    protected String pagename = "";
    protected int count = 0;

    public TrafficbypageDAO (int trafficbypageid){
        this.trafficbypageid = trafficbypageid;
        load();
    }

    public TrafficbypageDAO(){


    }

    public void load(){
        if (trafficbypageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(trafficbypageid), CACHEGROUP);
            if (obj!=null && (obj instanceof TrafficbypageDAO)){
                setProperties((TrafficbypageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT trafficbypageid, pagename, count  FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        trafficbypageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        trafficbypageid = 0;
                    }

                    pagename = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        count = Integer.parseInt(rstData[0][2]);
                    } else {
                        count = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(trafficbypageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"' AND trafficbypageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE trafficbypage SET trafficbypageid='"+trafficbypageid+"', pagename='"+reger.core.Util.cleanForSQL(pagename)+"', count='"+count+"'  WHERE trafficbypageid='"+trafficbypageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(trafficbypageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            trafficbypageid = Db.RunSQLInsert("INSERT INTO trafficbypage(pagename, count ) VALUES('"+trafficbypageid+"', '"+reger.core.Util.cleanForSQL(pagename)+"', '"+count+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(trafficbypageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM trafficbypage WHERE trafficbypageid='"+trafficbypageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(trafficbypageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTrafficbypageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "trafficbypageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return trafficbypageid;
    }

    public String getPrimaryKeyName(){
        return "trafficbypageid";
    }

    public String getTableName(){
        return "trafficbypage";
    }

    public void setProperties(TrafficbypageDAO obj){
        if(obj!=null){
            this.trafficbypageid = obj.trafficbypageid;
            this.pagename = obj.pagename;
            this.count = obj.count;
        }
    }


    public int getTrafficbypageid() {
        return trafficbypageid;
    }


    public String getPagename() {
        return pagename;
    }


    public void setPagename(String pagename) {
        this.pagename = pagename;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


}