package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'error' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorErrorDAO.java
 * Finders for this DAO: reger.dao.finders.ErrorFinder.java
 * 
 */

public class ErrorDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "errorDAO";

    protected int errorid = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected String url = "";
    protected String description = "";
    protected String status = "";
    protected int accountid = 0;
    protected int count = 0;
    protected String label = "";

    public ErrorDAO (int errorid){
        this.errorid = errorid;
        load();
    }

    public ErrorDAO(){


    }

    public void load(){
        if (errorid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(errorid), CACHEGROUP);
            if (obj!=null && (obj instanceof ErrorDAO)){
                setProperties((ErrorDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT errorid, date, url, description, status, accountid, count, label  FROM error WHERE errorid='"+errorid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        errorid = Integer.parseInt(rstData[0][0]);
                    } else {
                        errorid = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][1]);

                    url = rstData[0][2];

                    description = rstData[0][3];

                    status = rstData[0][4];

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        accountid = Integer.parseInt(rstData[0][5]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        count = Integer.parseInt(rstData[0][6]);
                    } else {
                        count = 0;
                    }

                    label = rstData[0][7];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(errorid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT errorid FROM error WHERE errorid='"+errorid+"' AND errorid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE error SET errorid='"+errorid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', url='"+reger.core.Util.cleanForSQL(url)+"', description='"+reger.core.Util.cleanForSQL(description)+"', status='"+reger.core.Util.cleanForSQL(status)+"', accountid='"+accountid+"', count='"+count+"', label='"+reger.core.Util.cleanForSQL(label)+"'  WHERE errorid='"+errorid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(errorid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            errorid = Db.RunSQLInsert("INSERT INTO error(date, url, description, status, accountid, count, label ) VALUES('"+errorid+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+reger.core.Util.cleanForSQL(status)+"', '"+accountid+"', '"+count+"', '"+reger.core.Util.cleanForSQL(label)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(errorid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM error WHERE errorid='"+errorid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(errorid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorErrorDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "errorDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return errorid;
    }

    public String getPrimaryKeyName(){
        return "errorid";
    }

    public String getTableName(){
        return "error";
    }

    public void setProperties(ErrorDAO obj){
        if(obj!=null){
            this.errorid = obj.errorid;
            this.date = obj.date;
            this.url = obj.url;
            this.description = obj.description;
            this.status = obj.status;
            this.accountid = obj.accountid;
            this.count = obj.count;
            this.label = obj.label;
        }
    }


    public int getErrorid() {
        return errorid;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


}