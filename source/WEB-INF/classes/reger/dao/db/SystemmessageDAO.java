package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'systemmessage' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSystemmessageDAO.java
 * Finders for this DAO: reger.dao.finders.SystemmessageFinder.java
 * 
 */

public class SystemmessageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "systemmessageDAO";

    protected int systemmessageid = 0;
    protected String systemmessage = "";
    protected boolean islive = true;
    protected boolean autooldonrestart = true;
    protected boolean showtologgedinusers = true;
    protected boolean showtonotloggedinusers = true;
    protected java.util.Calendar date = java.util.Calendar.getInstance();

    public SystemmessageDAO (int systemmessageid){
        this.systemmessageid = systemmessageid;
        load();
    }

    public SystemmessageDAO(){


    }

    public void load(){
        if (systemmessageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(systemmessageid), CACHEGROUP);
            if (obj!=null && (obj instanceof SystemmessageDAO)){
                setProperties((SystemmessageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT systemmessageid, systemmessage, islive, autooldonrestart, showtologgedinusers, showtonotloggedinusers, date  FROM systemmessage WHERE systemmessageid='"+systemmessageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        systemmessageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        systemmessageid = 0;
                    }

                    systemmessage = rstData[0][1];

                    islive = reger.core.Util.booleanFromSQLText(rstData[0][2]);

                    autooldonrestart = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    showtologgedinusers = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    showtonotloggedinusers = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][6]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(systemmessageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE systemmessageid='"+systemmessageid+"' AND systemmessageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE systemmessage SET systemmessageid='"+systemmessageid+"', systemmessage='"+reger.core.Util.cleanForSQL(systemmessage)+"', islive='"+reger.core.Util.booleanAsSQLText(islive)+"', autooldonrestart='"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"'  WHERE systemmessageid='"+systemmessageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(systemmessageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            systemmessageid = Db.RunSQLInsert("INSERT INTO systemmessage(systemmessage, islive, autooldonrestart, showtologgedinusers, showtonotloggedinusers, date ) VALUES('"+systemmessageid+"', '"+reger.core.Util.cleanForSQL(systemmessage)+"', '"+reger.core.Util.booleanAsSQLText(islive)+"', '"+reger.core.Util.booleanAsSQLText(autooldonrestart)+"', '"+reger.core.Util.booleanAsSQLText(showtologgedinusers)+"', '"+reger.core.Util.booleanAsSQLText(showtonotloggedinusers)+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(systemmessageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM systemmessage WHERE systemmessageid='"+systemmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(systemmessageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSystemmessageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "systemmessageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return systemmessageid;
    }

    public String getPrimaryKeyName(){
        return "systemmessageid";
    }

    public String getTableName(){
        return "systemmessage";
    }

    public void setProperties(SystemmessageDAO obj){
        if(obj!=null){
            this.systemmessageid = obj.systemmessageid;
            this.systemmessage = obj.systemmessage;
            this.islive = obj.islive;
            this.autooldonrestart = obj.autooldonrestart;
            this.showtologgedinusers = obj.showtologgedinusers;
            this.showtonotloggedinusers = obj.showtonotloggedinusers;
            this.date = obj.date;
        }
    }


    public int getSystemmessageid() {
        return systemmessageid;
    }


    public String getSystemmessage() {
        return systemmessage;
    }


    public void setSystemmessage(String systemmessage) {
        this.systemmessage = systemmessage;
    }


    public boolean getIslive() {
        return islive;
    }


    public void setIslive(boolean islive) {
        this.islive = islive;
    }


    public boolean getAutooldonrestart() {
        return autooldonrestart;
    }


    public void setAutooldonrestart(boolean autooldonrestart) {
        this.autooldonrestart = autooldonrestart;
    }


    public boolean getShowtologgedinusers() {
        return showtologgedinusers;
    }


    public void setShowtologgedinusers(boolean showtologgedinusers) {
        this.showtologgedinusers = showtologgedinusers;
    }


    public boolean getShowtonotloggedinusers() {
        return showtonotloggedinusers;
    }


    public void setShowtonotloggedinusers(boolean showtonotloggedinusers) {
        this.showtonotloggedinusers = showtonotloggedinusers;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


}