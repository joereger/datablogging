package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'search' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorSearchDAO.java
 * Finders for this DAO: reger.dao.finders.SearchFinder.java
 * 
 */

public class SearchDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "searchDAO";

    protected int searchid = 0;
    protected int accountid = 0;
    protected String searchstring = "";
    protected java.util.Calendar datetime = java.util.Calendar.getInstance();

    public SearchDAO (int searchid){
        this.searchid = searchid;
        load();
    }

    public SearchDAO(){


    }

    public void load(){
        if (searchid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(searchid), CACHEGROUP);
            if (obj!=null && (obj instanceof SearchDAO)){
                setProperties((SearchDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT searchid, accountid, searchstring, datetime  FROM search WHERE searchid='"+searchid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        searchid = Integer.parseInt(rstData[0][0]);
                    } else {
                        searchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    searchstring = rstData[0][2];

                    datetime = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(searchid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT searchid FROM search WHERE searchid='"+searchid+"' AND searchid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE search SET searchid='"+searchid+"', accountid='"+accountid+"', searchstring='"+reger.core.Util.cleanForSQL(searchstring)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"'  WHERE searchid='"+searchid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(searchid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            searchid = Db.RunSQLInsert("INSERT INTO search(accountid, searchstring, datetime ) VALUES('"+searchid+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(searchstring)+"', '"+reger.core.TimeUtils.dateformatfordb(datetime)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(searchid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM search WHERE searchid='"+searchid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(searchid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorSearchDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "searchDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return searchid;
    }

    public String getPrimaryKeyName(){
        return "searchid";
    }

    public String getTableName(){
        return "search";
    }

    public void setProperties(SearchDAO obj){
        if(obj!=null){
            this.searchid = obj.searchid;
            this.accountid = obj.accountid;
            this.searchstring = obj.searchstring;
            this.datetime = obj.datetime;
        }
    }


    public int getSearchid() {
        return searchid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public String getSearchstring() {
        return searchstring;
    }


    public void setSearchstring(String searchstring) {
        this.searchstring = searchstring;
    }


    public java.util.Calendar getDatetime() {
        return datetime;
    }


    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


}