package reger;

import reger.core.db.Db;
import reger.core.Util;
import reger.core.ValidationException;
import reger.core.Debug;
import reger.cache.providers.jboss.Cacheable;

/**
 * This class models a content page.
 */
@Cacheable
public class Location {

    private int locationid=0;
    private String locationname="";
    private int accountid=0;
    private double latitude=0;
    private double longitude=0;
    private String city="";
    private String state="";
    private String country="";

    public Location(int locationid){
        this.locationid = locationid;
        load();
    }

    public Location(int locationid, String locationname, int accountid, String city, String state, String country, double latitude, double longitude){
        this.locationid=locationid;
        this.locationname=locationname;
        this.accountid=accountid;
        this.latitude=latitude;
        this.longitude=longitude;
        this.city=city;
        this.state=state;
        this.country=country;
    }

    public void load(){
        if (locationid>0){
            //-----------------------------------
            //-----------------------------------
            String[][] rstLoc= Db.RunSQL("SELECT locationid, locationname, accountid, latitude, longitude, city, state, country FROM location WHERE locationid='"+this.locationid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstLoc!=null && rstLoc.length>0){
                for(int i=0; i<rstLoc.length; i++){
                    this.locationname=rstLoc[i][1];
                    if (reger.core.Util.isinteger(rstLoc[i][2])){
                        this.accountid=Integer.parseInt(rstLoc[i][2]);
                    } else {
                        this.accountid=0;
                    }
                    if (reger.core.Util.isnumeric(rstLoc[i][3])){
                        this.latitude=Double.parseDouble(rstLoc[i][3]);
                    } else {
                        this.latitude=0;
                    }
                    if (reger.core.Util.isnumeric(rstLoc[i][4])){
                        this.longitude=Double.parseDouble(rstLoc[i][4]);
                    } else {
                        this.longitude=0;
                    }
                    Debug.debug(5, "", "Location.load()<br>locationid="+locationid+"<br>latitude=" + latitude + "<br>longitude=" + longitude);
                    this.city=rstLoc[i][5];
                    this.state=rstLoc[i][6];
                    this.country=rstLoc[i][7];
                }
            }
        }
    }


    public void save() throws ValidationException{
        try{
            validate();
        } catch (ValidationException error){
            throw error;
        }
        String[][] rstLoc = null;
        // Flag to check if the record is updated or not.
        boolean updated = false;
        // select on locationid only if locationid is >0, because user could enter either location name or select location from drop down
        // while creating an entry.
        if (locationid > 0) {
            //-----------------------------------
            //-----------------------------------
            rstLoc= Db.RunSQL("SELECT locationid FROM location WHERE locationid='"+locationid+"'");
            //-----------------------------------
            //-----------------------------------
            // select on locationname only if locationname is not empty, because user could enter either location name or select location from
            // drop down while creating an entry.
        } else if (!locationname.equals("") && rstLoc == null || (rstLoc != null && rstLoc.length == 0)) {
            //-----------------------------------
            //-----------------------------------
            rstLoc= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+locationname+"'");
            //-----------------------------------
            //-----------------------------------
        } if (rstLoc!=null && rstLoc.length>0){
            // location id is sent to the one retrieved, so that it can be displayed in drop down
            locationid = Integer.parseInt(rstLoc[0][0]);
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE location SET locationname='"+Util.cleanForSQL(locationname)+"', accountid='"+accountid+"', longitude='"+longitude+"', latitude='"+latitude+"', city='"+reger.core.Util.cleanForSQL(city)+"', state='"+reger.core.Util.cleanForSQL(state)+"', country='"+reger.core.Util.cleanForSQL(country)+"'  WHERE locationid='"+locationid+"'");
            //-----------------------------------
            //-----------------------------------
            // Flag to check if the record is updated or not.
            updated = true;
        } else {
            // Insert only if record not updated (based on updated flag that is set above).
            if ((isGpsDataPresent() || isCityStateCountryInfoAvailable() || !locationname.equals("")) &&  !updated ){
                if (locationname.equals("")){
                    locationname="Location";
                }

                //-----------------------------------
                //-----------------------------------
                locationid = Db.RunSQLInsert("INSERT INTO location(locationname, accountid, latitude, longitude, city, state, country) VALUES('"+Util.cleanForSQL(locationname)+"', '"+accountid+"', '"+latitude+"', '"+longitude+"', '"+Util.cleanForSQL(city)+"', '"+Util.cleanForSQL(state)+"', '"+Util.cleanForSQL(country)+"')");
                //-----------------------------------
                //-----------------------------------

                //Update the AccountCounts cache
                reger.cache.AccountCountCache.flushByAccountid(accountid);
            }
        }



    }


    public void delete(){
        //Delete the record
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM location WHERE locationid='"+locationid+"'");
        //-----------------------------------
        //-----------------------------------
        //Set all locations for entries using it to 0
        //-----------------------------------
        //-----------------------------------
        int count1 = Db.RunSQLUpdate("UPDATE event SET locationid='0' WHERE locationid='"+locationid+"'");
        //-----------------------------------
        //-----------------------------------
        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);
    }

    public static Location[] getLocationsUserCanView(Accountuser accountUser, Account accountLookingForLocationsIn){
        Location[] out = new Location[0];

        String sql = "SELECT DISTINCT location.locationid, locationname, location.accountid, latitude, longitude, city, state, country FROM location, event WHERE location.accountid>0 AND "+reger.Entry.sqlOfLiveEntry+" AND event.locationid=location.locationid AND "+accountUser.LogsUserCanViewQueryendNoMegalog(accountLookingForLocationsIn.getAccountid())+" AND event.accountid='"+ accountLookingForLocationsIn.getAccountid() +"' ORDER BY locationname ASC";

        Debug.debug(5, "", "Location.java - getLocationsUserCanView()<br>" + sql);
        //-----------------------------------
        //-----------------------------------
        String[][] rstLocation= reger.core.db.Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstLocation!=null){
            for(int i=0; i<rstLocation.length; i++){
                double tmpLatitude = 0;
                if (reger.core.Util.isnumeric(rstLocation[i][3])){
                    tmpLatitude = Double.parseDouble(rstLocation[i][3]);
                }
                double tmpLongitude = 0;
                if (reger.core.Util.isnumeric(rstLocation[i][4])){
                    tmpLongitude = Double.parseDouble(rstLocation[i][4]);
                }
                Location tmpLoc = new Location(Integer.parseInt(rstLocation[i][0]), rstLocation[i][1], Integer.parseInt(rstLocation[i][2]), rstLocation[i][5], rstLocation[i][6], rstLocation[i][7], tmpLatitude, tmpLongitude);
                out = AddToArray.addToLocationArray(out, tmpLoc);
            }
        }
        return out;
    }

    public Location(javax.servlet.http.HttpServletRequest request, int accountid){
        populateFromRequest(request);
        this.accountid=accountid;
    }

    public void populateFromRequest(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("locationname")!=null) {
            this.setLocationname(request.getParameter("locationname"));
        }
        if (request.getParameter("locationid")!=null && reger.core.Util.isinteger(request.getParameter("locationid"))) {
            this.locationid=Integer.parseInt(request.getParameter("locationid"));
        }
        if (request.getParameter("latitude")!=null || request.getParameter("longitude")!=null) {
            try{
                reger.geo.GISCoordinate gis = reger.geo.GISCoordinate.FromString(request.getParameter("latitude"), request.getParameter("longitude"));
                this.latitude = gis.getLatInDecDeg();
                this.longitude = gis.getLonInDecDeg();
            } catch (Exception e){
                //reger.core.Util.debug(5, "Location.java - GIS conversion<br>request.getParameter(\"latitude\")=" + request.getParameter("latitude") + "<br>request.getParameter(\"longitude\")=" + request.getParameter("longitude") + "<br>error: " + e.getMessage());
                Debug.errorsave(e, "", "Location.java - GIS conversion<br>request.getParameter(\"latitude\")=" + request.getParameter("latitude") + "<br>request.getParameter(\"longitude\")=" + request.getParameter("longitude"));
                this.latitude = 0;
                this.longitude = 0;
            }
        }

        if (request.getParameter("city")!=null) {
            this.city=request.getParameter("city");
        }
        if (request.getParameter("state")!=null) {
            this.state=request.getParameter("state");
        }
        if (request.getParameter("country")!=null) {
            this.country=request.getParameter("country");
        }
    }

    public boolean isGpsDataPresent(){
        if (latitude>0 || longitude>0) {
            return true;
        }
        return false;
    }

    public boolean isCityStateCountryInfoAvailable(){
        if (!city.equals("") || !state.equals("") || !country.equals("")){
            return true;
        }
        return false;
    }

    public void validate() throws ValidationException{
        ValidationException error = new ValidationException();

        //Only verify gps if there was typed into one of the gps fields
        if (isGpsDataPresent()) {
            try{
                reger.geo.GISCoordinate gis = new reger.geo.GISCoordinate(latitude, longitude, false);
            } catch (Exception e){
                error.addValidationError(e.getMessage());
            }
        }
        //END Only verify gps if there's a new location and something was typed into one of the gps fields
        if (error.getErrors().length>0){
            throw error;
        }
    }

//    public static float convertDegMinSecToDecimal(int degrees, int minutes, int seconds){
//        float minasdeg = ((float)minutes)/(60);
//        float secasdeg = ((float)seconds)/(60*60);
//        return degrees + minasdeg + secasdeg;
//    }

    public double getLatitude(){
//        float decimalLat = convertDegMinSecToDecimal(latdeg, latmin, latsec);
//        if (latns==NORTH){
//            return decimalLat;
//        } else {
//            return decimalLat * -1f;
//        }
        return latitude;
    }

    public double getLongitude(){
//        float decimalLon = convertDegMinSecToDecimal(londeg, lonmin, lonsec);
//        if (latns==EAST){
//            return decimalLon;
//        } else {
//            return decimalLon * -1f;
//        }
        return longitude;
    }

    public boolean hasGpsCoordinates(){
        if (getLongitude()>0 || getLatitude()>0){
            return true;
        }
        return false;
    }



    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
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


}
