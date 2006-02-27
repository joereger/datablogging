package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'polarhrmdata' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPolarhrmdataDAO.java
 * Finders for this DAO: reger.dao.finders.PolarhrmdataFinder.java
 * 
 */

public class PolarhrmdataDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "polarhrmdataDAO";

    protected int polarhrmdataid = 0;
    protected int polarhrmid = 0;
    protected int timeinseconds = 0;
    protected int heartrate = 0;
    protected double speed = 0;
    protected double cadence = 0;
    protected double altitude = 0;
    protected double power = 0;
    protected double leftpowerbalance = 0;
    protected double pedalingindex = 0;

    public PolarhrmdataDAO (int polarhrmdataid){
        this.polarhrmdataid = polarhrmdataid;
        load();
    }

    public PolarhrmdataDAO(){


    }

    public void load(){
        if (polarhrmdataid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(polarhrmdataid), CACHEGROUP);
            if (obj!=null && (obj instanceof PolarhrmdataDAO)){
                setProperties((PolarhrmdataDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT polarhrmdataid, polarhrmid, timeinseconds, heartrate, speed, cadence, altitude, power, leftpowerbalance, pedalingindex  FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        polarhrmdataid = Integer.parseInt(rstData[0][0]);
                    } else {
                        polarhrmdataid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        polarhrmid = Integer.parseInt(rstData[0][1]);
                    } else {
                        polarhrmid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        timeinseconds = Integer.parseInt(rstData[0][2]);
                    } else {
                        timeinseconds = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        heartrate = Integer.parseInt(rstData[0][3]);
                    } else {
                        heartrate = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][4])){
                        speed = Double.parseDouble(rstData[0][4]);
                    } else {
                        speed = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][5])){
                        cadence = Double.parseDouble(rstData[0][5]);
                    } else {
                        cadence = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][6])){
                        altitude = Double.parseDouble(rstData[0][6]);
                    } else {
                        altitude = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][7])){
                        power = Double.parseDouble(rstData[0][7]);
                    } else {
                        power = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][8])){
                        leftpowerbalance = Double.parseDouble(rstData[0][8]);
                    } else {
                        leftpowerbalance = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][9])){
                        pedalingindex = Double.parseDouble(rstData[0][9]);
                    } else {
                        pedalingindex = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(polarhrmdataid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT polarhrmdataid FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"' AND polarhrmdataid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE polarhrmdata SET polarhrmdataid='"+polarhrmdataid+"', polarhrmid='"+polarhrmid+"', timeinseconds='"+timeinseconds+"', heartrate='"+heartrate+"', speed='"+String.valueOf(speed)+"', cadence='"+String.valueOf(cadence)+"', altitude='"+String.valueOf(altitude)+"', power='"+String.valueOf(power)+"', leftpowerbalance='"+String.valueOf(leftpowerbalance)+"', pedalingindex='"+String.valueOf(pedalingindex)+"'  WHERE polarhrmdataid='"+polarhrmdataid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(polarhrmdataid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            polarhrmdataid = Db.RunSQLInsert("INSERT INTO polarhrmdata(polarhrmid, timeinseconds, heartrate, speed, cadence, altitude, power, leftpowerbalance, pedalingindex ) VALUES('"+polarhrmdataid+"', '"+polarhrmid+"', '"+timeinseconds+"', '"+heartrate+"', '"+String.valueOf(speed)+"', '"+String.valueOf(cadence)+"', '"+String.valueOf(altitude)+"', '"+String.valueOf(power)+"', '"+String.valueOf(leftpowerbalance)+"', '"+String.valueOf(pedalingindex)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(polarhrmdataid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM polarhrmdata WHERE polarhrmdataid='"+polarhrmdataid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(polarhrmdataid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPolarhrmdataDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "polarhrmdataDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return polarhrmdataid;
    }

    public String getPrimaryKeyName(){
        return "polarhrmdataid";
    }

    public String getTableName(){
        return "polarhrmdata";
    }

    public void setProperties(PolarhrmdataDAO obj){
        if(obj!=null){
            this.polarhrmdataid = obj.polarhrmdataid;
            this.polarhrmid = obj.polarhrmid;
            this.timeinseconds = obj.timeinseconds;
            this.heartrate = obj.heartrate;
            this.speed = obj.speed;
            this.cadence = obj.cadence;
            this.altitude = obj.altitude;
            this.power = obj.power;
            this.leftpowerbalance = obj.leftpowerbalance;
            this.pedalingindex = obj.pedalingindex;
        }
    }


    public int getPolarhrmdataid() {
        return polarhrmdataid;
    }


    public int getPolarhrmid() {
        return polarhrmid;
    }


    public void setPolarhrmid(int polarhrmid) {
        this.polarhrmid = polarhrmid;
    }


    public int getTimeinseconds() {
        return timeinseconds;
    }


    public void setTimeinseconds(int timeinseconds) {
        this.timeinseconds = timeinseconds;
    }


    public int getHeartrate() {
        return heartrate;
    }


    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }


    public double getSpeed() {
        return speed;
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public double getCadence() {
        return cadence;
    }


    public void setCadence(double cadence) {
        this.cadence = cadence;
    }


    public double getAltitude() {
        return altitude;
    }


    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }


    public double getPower() {
        return power;
    }


    public void setPower(double power) {
        this.power = power;
    }


    public double getLeftpowerbalance() {
        return leftpowerbalance;
    }


    public void setLeftpowerbalance(double leftpowerbalance) {
        this.leftpowerbalance = leftpowerbalance;
    }


    public double getPedalingindex() {
        return pedalingindex;
    }


    public void setPedalingindex(double pedalingindex) {
        this.pedalingindex = pedalingindex;
    }


}