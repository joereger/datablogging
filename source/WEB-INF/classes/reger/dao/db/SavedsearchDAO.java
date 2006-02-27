package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'savedsearch' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSavedsearchDAO.java
 * Finders for this DAO: reger.dao.finders.SavedsearchFinder.java
 * 
 */

public class SavedsearchDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "savedsearchDAO";

    protected int savedsearchid = 0;
    protected String name = "";
    protected int accountid = 0;
    protected int lastx = 0;
    protected int lastxunits = 0;
    protected int daterange = 0;
    protected java.util.Calendar datefromgmt = java.util.Calendar.getInstance();
    protected java.util.Calendar datetogmt = java.util.Calendar.getInstance();
    protected String searchterms = "";

    public SavedsearchDAO (int savedsearchid){
        this.savedsearchid = savedsearchid;
        load();
    }

    public SavedsearchDAO(){


    }

    public void load(){
        if (savedsearchid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(savedsearchid), CACHEGROUP);
            if (obj!=null && (obj instanceof SavedsearchDAO)){
                setProperties((SavedsearchDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT savedsearchid, name, accountid, lastx, lastxunits, daterange, datefromgmt, datetogmt, searchterms  FROM savedsearch WHERE savedsearchid='"+savedsearchid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        savedsearchid = Integer.parseInt(rstData[0][0]);
                    } else {
                        savedsearchid = 0;
                    }

                    name = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        lastx = Integer.parseInt(rstData[0][3]);
                    } else {
                        lastx = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        lastxunits = Integer.parseInt(rstData[0][4]);
                    } else {
                        lastxunits = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        daterange = Integer.parseInt(rstData[0][5]);
                    } else {
                        daterange = 0;
                    }

                    datefromgmt = reger.core.TimeUtils.dbstringtocalendar(rstData[0][6]);

                    datetogmt = reger.core.TimeUtils.dbstringtocalendar(rstData[0][7]);

                    searchterms = rstData[0][8];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(savedsearchid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT savedsearchid FROM savedsearch WHERE savedsearchid='"+savedsearchid+"' AND savedsearchid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE savedsearch SET savedsearchid='"+savedsearchid+"', name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"', lastx='"+lastx+"', lastxunits='"+lastxunits+"', daterange='"+daterange+"', datefromgmt='"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"', datetogmt='"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"', searchterms='"+reger.core.Util.cleanForSQL(searchterms)+"'  WHERE savedsearchid='"+savedsearchid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            savedsearchid = Db.RunSQLInsert("INSERT INTO savedsearch(name, accountid, lastx, lastxunits, daterange, datefromgmt, datetogmt, searchterms ) VALUES('"+savedsearchid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+accountid+"', '"+lastx+"', '"+lastxunits+"', '"+daterange+"', '"+reger.core.TimeUtils.dateformatfordb(datefromgmt)+"', '"+reger.core.TimeUtils.dateformatfordb(datetogmt)+"', '"+reger.core.Util.cleanForSQL(searchterms)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(savedsearchid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearch WHERE savedsearchid='"+savedsearchid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(savedsearchid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSavedsearchDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "savedsearchDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return savedsearchid;
    }

    public String getPrimaryKeyName(){
        return "savedsearchid";
    }

    public String getTableName(){
        return "savedsearch";
    }

    public void setProperties(SavedsearchDAO obj){
        if(obj!=null){
            this.savedsearchid = obj.savedsearchid;
            this.name = obj.name;
            this.accountid = obj.accountid;
            this.lastx = obj.lastx;
            this.lastxunits = obj.lastxunits;
            this.daterange = obj.daterange;
            this.datefromgmt = obj.datefromgmt;
            this.datetogmt = obj.datetogmt;
            this.searchterms = obj.searchterms;
        }
    }


    public int getSavedsearchid() {
        return savedsearchid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getLastx() {
        return lastx;
    }


    public void setLastx(int lastx) {
        this.lastx = lastx;
    }


    public int getLastxunits() {
        return lastxunits;
    }


    public void setLastxunits(int lastxunits) {
        this.lastxunits = lastxunits;
    }


    public int getDaterange() {
        return daterange;
    }


    public void setDaterange(int daterange) {
        this.daterange = daterange;
    }


    public java.util.Calendar getDatefromgmt() {
        return datefromgmt;
    }


    public void setDatefromgmt(java.util.Calendar datefromgmt) {
        this.datefromgmt = datefromgmt;
    }


    public java.util.Calendar getDatetogmt() {
        return datetogmt;
    }


    public void setDatetogmt(java.util.Calendar datetogmt) {
        this.datetogmt = datetogmt;
    }


    public String getSearchterms() {
        return searchterms;
    }


    public void setSearchterms(String searchterms) {
        this.searchterms = searchterms;
    }


}