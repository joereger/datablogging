package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'scheduler' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSchedulerDAO.java
 * Finders for this DAO: reger.dao.finders.SchedulerFinder.java
 * 
 */

public class SchedulerDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "schedulerDAO";

    protected int schedulerid = 0;
    protected int masterthreadid = 0;
    protected String task = "";
    protected java.util.Calendar lastrun = java.util.Calendar.getInstance();
    protected int timesrun = 0;
    protected String comment = "";

    public SchedulerDAO (int schedulerid){
        this.schedulerid = schedulerid;
        load();
    }

    public SchedulerDAO(){


    }

    public void load(){
        if (schedulerid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(schedulerid), CACHEGROUP);
            if (obj!=null && (obj instanceof SchedulerDAO)){
                setProperties((SchedulerDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT schedulerid, masterthreadid, task, lastrun, timesrun, comment  FROM scheduler WHERE schedulerid='"+schedulerid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        schedulerid = Integer.parseInt(rstData[0][0]);
                    } else {
                        schedulerid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        masterthreadid = Integer.parseInt(rstData[0][1]);
                    } else {
                        masterthreadid = 0;
                    }

                    task = rstData[0][2];

                    lastrun = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        timesrun = Integer.parseInt(rstData[0][4]);
                    } else {
                        timesrun = 0;
                    }

                    comment = rstData[0][5];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(schedulerid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT schedulerid FROM scheduler WHERE schedulerid='"+schedulerid+"' AND schedulerid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE scheduler SET schedulerid='"+schedulerid+"', masterthreadid='"+masterthreadid+"', task='"+reger.core.Util.cleanForSQL(task)+"', lastrun='"+reger.core.TimeUtils.dateformatfordb(lastrun)+"', timesrun='"+timesrun+"', comment='"+reger.core.Util.cleanForSQL(comment)+"'  WHERE schedulerid='"+schedulerid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(schedulerid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            schedulerid = Db.RunSQLInsert("INSERT INTO scheduler(masterthreadid, task, lastrun, timesrun, comment ) VALUES('"+schedulerid+"', '"+masterthreadid+"', '"+reger.core.Util.cleanForSQL(task)+"', '"+reger.core.TimeUtils.dateformatfordb(lastrun)+"', '"+timesrun+"', '"+reger.core.Util.cleanForSQL(comment)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(schedulerid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM scheduler WHERE schedulerid='"+schedulerid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(schedulerid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSchedulerDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "schedulerDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return schedulerid;
    }

    public String getPrimaryKeyName(){
        return "schedulerid";
    }

    public String getTableName(){
        return "scheduler";
    }

    public void setProperties(SchedulerDAO obj){
        if(obj!=null){
            this.schedulerid = obj.schedulerid;
            this.masterthreadid = obj.masterthreadid;
            this.task = obj.task;
            this.lastrun = obj.lastrun;
            this.timesrun = obj.timesrun;
            this.comment = obj.comment;
        }
    }


    public int getSchedulerid() {
        return schedulerid;
    }


    public int getMasterthreadid() {
        return masterthreadid;
    }


    public void setMasterthreadid(int masterthreadid) {
        this.masterthreadid = masterthreadid;
    }


    public String getTask() {
        return task;
    }


    public void setTask(String task) {
        this.task = task;
    }


    public java.util.Calendar getLastrun() {
        return lastrun;
    }


    public void setLastrun(java.util.Calendar lastrun) {
        this.lastrun = lastrun;
    }


    public int getTimesrun() {
        return timesrun;
    }


    public void setTimesrun(int timesrun) {
        this.timesrun = timesrun;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


}