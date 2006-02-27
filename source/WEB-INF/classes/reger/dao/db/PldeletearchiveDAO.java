package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pldeletearchive' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPldeletearchiveDAO.java
 * Finders for this DAO: reger.dao.finders.PldeletearchiveFinder.java
 * 
 */

public class PldeletearchiveDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pldeletearchiveDAO";

    protected int pldeletearchiveid = 0;
    protected int accountid = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected int oldplid = 0;
    protected int newplid = 0;

    public PldeletearchiveDAO (int pldeletearchiveid){
        this.pldeletearchiveid = pldeletearchiveid;
        load();
    }

    public PldeletearchiveDAO(){


    }

    public void load(){
        if (pldeletearchiveid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pldeletearchiveid), CACHEGROUP);
            if (obj!=null && (obj instanceof PldeletearchiveDAO)){
                setProperties((PldeletearchiveDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid, accountid, date, oldplid, newplid  FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pldeletearchiveid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pldeletearchiveid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        oldplid = Integer.parseInt(rstData[0][3]);
                    } else {
                        oldplid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        newplid = Integer.parseInt(rstData[0][4]);
                    } else {
                        newplid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pldeletearchiveid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pldeletearchiveid FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"' AND pldeletearchiveid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pldeletearchive SET pldeletearchiveid='"+pldeletearchiveid+"', accountid='"+accountid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', oldplid='"+oldplid+"', newplid='"+newplid+"'  WHERE pldeletearchiveid='"+pldeletearchiveid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pldeletearchiveid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pldeletearchiveid = Db.RunSQLInsert("INSERT INTO pldeletearchive(accountid, date, oldplid, newplid ) VALUES('"+pldeletearchiveid+"', '"+accountid+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+oldplid+"', '"+newplid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pldeletearchiveid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pldeletearchive WHERE pldeletearchiveid='"+pldeletearchiveid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pldeletearchiveid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPldeletearchiveDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pldeletearchiveDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pldeletearchiveid;
    }

    public String getPrimaryKeyName(){
        return "pldeletearchiveid";
    }

    public String getTableName(){
        return "pldeletearchive";
    }

    public void setProperties(PldeletearchiveDAO obj){
        if(obj!=null){
            this.pldeletearchiveid = obj.pldeletearchiveid;
            this.accountid = obj.accountid;
            this.date = obj.date;
            this.oldplid = obj.oldplid;
            this.newplid = obj.newplid;
        }
    }


    public int getPldeletearchiveid() {
        return pldeletearchiveid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public int getOldplid() {
        return oldplid;
    }


    public void setOldplid(int oldplid) {
        this.oldplid = oldplid;
    }


    public int getNewplid() {
        return newplid;
    }


    public void setNewplid(int newplid) {
        this.newplid = newplid;
    }


}