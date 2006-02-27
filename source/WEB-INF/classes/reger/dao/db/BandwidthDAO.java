package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'bandwidth' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBandwidthDAO.java
 * Finders for this DAO: reger.dao.finders.BandwidthFinder.java
 * 
 */

public class BandwidthDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bandwidthDAO";

    protected int bandwidthid = 0;
    protected int accountid = 0;
    protected int month = 0;
    protected int year = 0;
    protected int bytes = 0;

    public BandwidthDAO (int bandwidthid){
        this.bandwidthid = bandwidthid;
        load();
    }

    public BandwidthDAO(){


    }

    public void load(){
        if (bandwidthid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bandwidthid), CACHEGROUP);
            if (obj!=null && (obj instanceof BandwidthDAO)){
                setProperties((BandwidthDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bandwidthid, accountid, month, year, bytes  FROM bandwidth WHERE bandwidthid='"+bandwidthid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bandwidthid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bandwidthid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        month = Integer.parseInt(rstData[0][2]);
                    } else {
                        month = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        year = Integer.parseInt(rstData[0][3]);
                    } else {
                        year = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        bytes = Integer.parseInt(rstData[0][4]);
                    } else {
                        bytes = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bandwidthid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bandwidthid FROM bandwidth WHERE bandwidthid='"+bandwidthid+"' AND bandwidthid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE bandwidth SET bandwidthid='"+bandwidthid+"', accountid='"+accountid+"', month='"+month+"', year='"+year+"', bytes='"+bytes+"'  WHERE bandwidthid='"+bandwidthid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bandwidthid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bandwidthid = Db.RunSQLInsert("INSERT INTO bandwidth(accountid, month, year, bytes ) VALUES('"+bandwidthid+"', '"+accountid+"', '"+month+"', '"+year+"', '"+bytes+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bandwidthid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM bandwidth WHERE bandwidthid='"+bandwidthid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bandwidthid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBandwidthDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bandwidthDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bandwidthid;
    }

    public String getPrimaryKeyName(){
        return "bandwidthid";
    }

    public String getTableName(){
        return "bandwidth";
    }

    public void setProperties(BandwidthDAO obj){
        if(obj!=null){
            this.bandwidthid = obj.bandwidthid;
            this.accountid = obj.accountid;
            this.month = obj.month;
            this.year = obj.year;
            this.bytes = obj.bytes;
        }
    }


    public int getBandwidthid() {
        return bandwidthid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getMonth() {
        return month;
    }


    public void setMonth(int month) {
        this.month = month;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public int getBytes() {
        return bytes;
    }


    public void setBytes(int bytes) {
        this.bytes = bytes;
    }


}