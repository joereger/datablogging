package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'location' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLocationDAO.java
 * Finders for this DAO: reger.dao.finders.LocationFinder.java
 * 
 */

public class LocationDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "locationDAO";

    protected int locationid = 0;
    protected String locationname = "";
    protected int accountid = 0;
    protected int latdeg = 0;
    protected int latmin = 0;
    protected int latsec = 0;
    protected int latns = 0;
    protected int londeg = 0;
    protected int lonmin = 0;
    protected int lonsec = 0;
    protected int lonew = 0;
    protected String city = "";
    protected String state = "";
    protected String country = "";
    protected double latitude = 0;
    protected double longitude = 0;

    public LocationDAO (int locationid){
        this.locationid = locationid;
        load();
    }

    public LocationDAO(){


    }

    public void load(){
        if (locationid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(locationid), CACHEGROUP);
            if (obj!=null && (obj instanceof LocationDAO)){
                setProperties((LocationDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT locationid, locationname, accountid, latdeg, latmin, latsec, latns, londeg, lonmin, lonsec, lonew, city, state, country, latitude, longitude  FROM location WHERE locationid='"+locationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        locationid = Integer.parseInt(rstData[0][0]);
                    } else {
                        locationid = 0;
                    }

                    locationname = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        latdeg = Integer.parseInt(rstData[0][3]);
                    } else {
                        latdeg = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        latmin = Integer.parseInt(rstData[0][4]);
                    } else {
                        latmin = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        latsec = Integer.parseInt(rstData[0][5]);
                    } else {
                        latsec = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        latns = Integer.parseInt(rstData[0][6]);
                    } else {
                        latns = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        londeg = Integer.parseInt(rstData[0][7]);
                    } else {
                        londeg = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        lonmin = Integer.parseInt(rstData[0][8]);
                    } else {
                        lonmin = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        lonsec = Integer.parseInt(rstData[0][9]);
                    } else {
                        lonsec = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][10])){
                        lonew = Integer.parseInt(rstData[0][10]);
                    } else {
                        lonew = 0;
                    }

                    city = rstData[0][11];

                    state = rstData[0][12];

                    country = rstData[0][13];

                    if (reger.core.Util.isnumeric(rstData[0][14])){
                        latitude = Double.parseDouble(rstData[0][14]);
                    } else {
                        latitude = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][15])){
                        longitude = Double.parseDouble(rstData[0][15]);
                    } else {
                        longitude = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(locationid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"' AND locationid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE location SET locationid='"+locationid+"', locationname='"+reger.core.Util.cleanForSQL(locationname)+"', accountid='"+accountid+"', latdeg='"+latdeg+"', latmin='"+latmin+"', latsec='"+latsec+"', latns='"+latns+"', londeg='"+londeg+"', lonmin='"+lonmin+"', lonsec='"+lonsec+"', lonew='"+lonew+"', city='"+reger.core.Util.cleanForSQL(city)+"', state='"+reger.core.Util.cleanForSQL(state)+"', country='"+reger.core.Util.cleanForSQL(country)+"', latitude='"+String.valueOf(latitude)+"', longitude='"+String.valueOf(longitude)+"'  WHERE locationid='"+locationid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(locationid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            locationid = Db.RunSQLInsert("INSERT INTO location(locationname, accountid, latdeg, latmin, latsec, latns, londeg, lonmin, lonsec, lonew, city, state, country, latitude, longitude ) VALUES('"+locationid+"', '"+reger.core.Util.cleanForSQL(locationname)+"', '"+accountid+"', '"+latdeg+"', '"+latmin+"', '"+latsec+"', '"+latns+"', '"+londeg+"', '"+lonmin+"', '"+lonsec+"', '"+lonew+"', '"+reger.core.Util.cleanForSQL(city)+"', '"+reger.core.Util.cleanForSQL(state)+"', '"+reger.core.Util.cleanForSQL(country)+"', '"+String.valueOf(latitude)+"', '"+String.valueOf(longitude)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(locationid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM location WHERE locationid='"+locationid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(locationid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLocationDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "locationDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return locationid;
    }

    public String getPrimaryKeyName(){
        return "locationid";
    }

    public String getTableName(){
        return "location";
    }

    public void setProperties(LocationDAO obj){
        if(obj!=null){
            this.locationid = obj.locationid;
            this.locationname = obj.locationname;
            this.accountid = obj.accountid;
            this.latdeg = obj.latdeg;
            this.latmin = obj.latmin;
            this.latsec = obj.latsec;
            this.latns = obj.latns;
            this.londeg = obj.londeg;
            this.lonmin = obj.lonmin;
            this.lonsec = obj.lonsec;
            this.lonew = obj.lonew;
            this.city = obj.city;
            this.state = obj.state;
            this.country = obj.country;
            this.latitude = obj.latitude;
            this.longitude = obj.longitude;
        }
    }


    public int getLocationid() {
        return locationid;
    }


    public String getLocationname() {
        return locationname;
    }


    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getLatdeg() {
        return latdeg;
    }


    public void setLatdeg(int latdeg) {
        this.latdeg = latdeg;
    }


    public int getLatmin() {
        return latmin;
    }


    public void setLatmin(int latmin) {
        this.latmin = latmin;
    }


    public int getLatsec() {
        return latsec;
    }


    public void setLatsec(int latsec) {
        this.latsec = latsec;
    }


    public int getLatns() {
        return latns;
    }


    public void setLatns(int latns) {
        this.latns = latns;
    }


    public int getLondeg() {
        return londeg;
    }


    public void setLondeg(int londeg) {
        this.londeg = londeg;
    }


    public int getLonmin() {
        return lonmin;
    }


    public void setLonmin(int lonmin) {
        this.lonmin = lonmin;
    }


    public int getLonsec() {
        return lonsec;
    }


    public void setLonsec(int lonsec) {
        this.lonsec = lonsec;
    }


    public int getLonew() {
        return lonew;
    }


    public void setLonew(int lonew) {
        this.lonew = lonew;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


}