package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'timeperiod' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTimeperiodDAO.java
 * Finders for this DAO: reger.dao.finders.TimeperiodFinder.java
 * 
 */

public class TimeperiodDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "timeperiodDAO";

    protected int timeperiodid = 0;
    protected int accountid = 0;
    protected java.util.Calendar startdate = java.util.Calendar.getInstance();
    protected java.util.Calendar enddate = java.util.Calendar.getInstance();
    protected String description = "";
    protected boolean isprivate = true;
    protected String title = "";
    protected boolean isopenended = true;

    public TimeperiodDAO (int timeperiodid){
        this.timeperiodid = timeperiodid;
        load();
    }

    public TimeperiodDAO(){


    }

    public void load(){
        if (timeperiodid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(timeperiodid), CACHEGROUP);
            if (obj!=null && (obj instanceof TimeperiodDAO)){
                setProperties((TimeperiodDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT timeperiodid, accountid, startdate, enddate, description, isprivate, title, isopenended  FROM timeperiod WHERE timeperiodid='"+timeperiodid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        timeperiodid = Integer.parseInt(rstData[0][0]);
                    } else {
                        timeperiodid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    startdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    enddate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);

                    description = rstData[0][4];

                    isprivate = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    title = rstData[0][6];

                    isopenended = reger.core.Util.booleanFromSQLText(rstData[0][7]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(timeperiodid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT timeperiodid FROM timeperiod WHERE timeperiodid='"+timeperiodid+"' AND timeperiodid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE timeperiod SET timeperiodid='"+timeperiodid+"', accountid='"+accountid+"', startdate='"+reger.core.TimeUtils.dateformatfordb(startdate)+"', enddate='"+reger.core.TimeUtils.dateformatfordb(enddate)+"', description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', title='"+reger.core.Util.cleanForSQL(title)+"', isopenended='"+reger.core.Util.booleanAsSQLText(isopenended)+"'  WHERE timeperiodid='"+timeperiodid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(timeperiodid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            timeperiodid = Db.RunSQLInsert("INSERT INTO timeperiod(accountid, startdate, enddate, description, isprivate, title, isopenended ) VALUES('"+timeperiodid+"', '"+accountid+"', '"+reger.core.TimeUtils.dateformatfordb(startdate)+"', '"+reger.core.TimeUtils.dateformatfordb(enddate)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+reger.core.Util.booleanAsSQLText(isprivate)+"', '"+reger.core.Util.cleanForSQL(title)+"', '"+reger.core.Util.booleanAsSQLText(isopenended)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(timeperiodid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM timeperiod WHERE timeperiodid='"+timeperiodid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(timeperiodid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTimeperiodDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "timeperiodDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return timeperiodid;
    }

    public String getPrimaryKeyName(){
        return "timeperiodid";
    }

    public String getTableName(){
        return "timeperiod";
    }

    public void setProperties(TimeperiodDAO obj){
        if(obj!=null){
            this.timeperiodid = obj.timeperiodid;
            this.accountid = obj.accountid;
            this.startdate = obj.startdate;
            this.enddate = obj.enddate;
            this.description = obj.description;
            this.isprivate = obj.isprivate;
            this.title = obj.title;
            this.isopenended = obj.isopenended;
        }
    }


    public int getTimeperiodid() {
        return timeperiodid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public java.util.Calendar getStartdate() {
        return startdate;
    }


    public void setStartdate(java.util.Calendar startdate) {
        this.startdate = startdate;
    }


    public java.util.Calendar getEnddate() {
        return enddate;
    }


    public void setEnddate(java.util.Calendar enddate) {
        this.enddate = enddate;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public boolean getIsprivate() {
        return isprivate;
    }


    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public boolean getIsopenended() {
        return isopenended;
    }


    public void setIsopenended(boolean isopenended) {
        this.isopenended = isopenended;
    }


}