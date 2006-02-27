package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'bugcomment' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBugcommentDAO.java
 * Finders for this DAO: reger.dao.finders.BugcommentFinder.java
 * 
 */

public class BugcommentDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bugcommentDAO";

    protected int bugcommentid = 0;
    protected int bugid = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected String comment = "";

    public BugcommentDAO (int bugcommentid){
        this.bugcommentid = bugcommentid;
        load();
    }

    public BugcommentDAO(){


    }

    public void load(){
        if (bugcommentid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bugcommentid), CACHEGROUP);
            if (obj!=null && (obj instanceof BugcommentDAO)){
                setProperties((BugcommentDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bugcommentid, bugid, date, comment  FROM bugcomment WHERE bugcommentid='"+bugcommentid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bugcommentid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bugcommentid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        bugid = Integer.parseInt(rstData[0][1]);
                    } else {
                        bugid = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    comment = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bugcommentid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bugcommentid FROM bugcomment WHERE bugcommentid='"+bugcommentid+"' AND bugcommentid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE bugcomment SET bugcommentid='"+bugcommentid+"', bugid='"+bugid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', comment='"+reger.core.Util.cleanForSQL(comment)+"'  WHERE bugcommentid='"+bugcommentid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bugcommentid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bugcommentid = Db.RunSQLInsert("INSERT INTO bugcomment(bugid, date, comment ) VALUES('"+bugcommentid+"', '"+bugid+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+reger.core.Util.cleanForSQL(comment)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bugcommentid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM bugcomment WHERE bugcommentid='"+bugcommentid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bugcommentid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBugcommentDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bugcommentDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bugcommentid;
    }

    public String getPrimaryKeyName(){
        return "bugcommentid";
    }

    public String getTableName(){
        return "bugcomment";
    }

    public void setProperties(BugcommentDAO obj){
        if(obj!=null){
            this.bugcommentid = obj.bugcommentid;
            this.bugid = obj.bugid;
            this.date = obj.date;
            this.comment = obj.comment;
        }
    }


    public int getBugcommentid() {
        return bugcommentid;
    }


    public int getBugid() {
        return bugid;
    }


    public void setBugid(int bugid) {
        this.bugid = bugid;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


}