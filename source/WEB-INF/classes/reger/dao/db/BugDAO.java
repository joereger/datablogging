package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'bug' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBugDAO.java
 * Finders for this DAO: reger.dao.finders.BugFinder.java
 * 
 */

public class BugDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bugDAO";

    protected int bugid = 0;
    protected java.util.Calendar createdate = java.util.Calendar.getInstance();
    protected boolean isopen = true;
    protected int severity = 0;
    protected int bugcategoryid = 0;
    protected String title = "";

    public BugDAO (int bugid){
        this.bugid = bugid;
        load();
    }

    public BugDAO(){


    }

    public void load(){
        if (bugid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bugid), CACHEGROUP);
            if (obj!=null && (obj instanceof BugDAO)){
                setProperties((BugDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bugid, createdate, isopen, severity, bugcategoryid, title  FROM bug WHERE bugid='"+bugid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bugid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bugid = 0;
                    }

                    createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][1]);

                    isopen = reger.core.Util.booleanFromSQLText(rstData[0][2]);

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        severity = Integer.parseInt(rstData[0][3]);
                    } else {
                        severity = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        bugcategoryid = Integer.parseInt(rstData[0][4]);
                    } else {
                        bugcategoryid = 0;
                    }

                    title = rstData[0][5];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bugid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bugid FROM bug WHERE bugid='"+bugid+"' AND bugid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE bug SET bugid='"+bugid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"', severity='"+severity+"', bugcategoryid='"+bugcategoryid+"', title='"+reger.core.Util.cleanForSQL(title)+"'  WHERE bugid='"+bugid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bugid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bugid = Db.RunSQLInsert("INSERT INTO bug(createdate, isopen, severity, bugcategoryid, title ) VALUES('"+bugid+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.Util.booleanAsSQLText(isopen)+"', '"+severity+"', '"+bugcategoryid+"', '"+reger.core.Util.cleanForSQL(title)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bugid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM bug WHERE bugid='"+bugid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bugid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBugDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bugDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bugid;
    }

    public String getPrimaryKeyName(){
        return "bugid";
    }

    public String getTableName(){
        return "bug";
    }

    public void setProperties(BugDAO obj){
        if(obj!=null){
            this.bugid = obj.bugid;
            this.createdate = obj.createdate;
            this.isopen = obj.isopen;
            this.severity = obj.severity;
            this.bugcategoryid = obj.bugcategoryid;
            this.title = obj.title;
        }
    }


    public int getBugid() {
        return bugid;
    }


    public java.util.Calendar getCreatedate() {
        return createdate;
    }


    public void setCreatedate(java.util.Calendar createdate) {
        this.createdate = createdate;
    }


    public boolean getIsopen() {
        return isopen;
    }


    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }


    public int getSeverity() {
        return severity;
    }


    public void setSeverity(int severity) {
        this.severity = severity;
    }


    public int getBugcategoryid() {
        return bugcategoryid;
    }


    public void setBugcategoryid(int bugcategoryid) {
        this.bugcategoryid = bugcategoryid;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


}