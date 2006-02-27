package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'emailapiaddress' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEmailapiaddressDAO.java
 * Finders for this DAO: reger.dao.finders.EmailapiaddressFinder.java
 * 
 */

public class EmailapiaddressDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "emailapiaddressDAO";

    protected int emailapiaddressid = 0;
    protected String uniquekey = "";
    protected int accountuserid = 0;
    protected int accountid = 0;
    protected int logid = 0;
    protected int emailtype = 0;

    public EmailapiaddressDAO (int emailapiaddressid){
        this.emailapiaddressid = emailapiaddressid;
        load();
    }

    public EmailapiaddressDAO(){


    }

    public void load(){
        if (emailapiaddressid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(emailapiaddressid), CACHEGROUP);
            if (obj!=null && (obj instanceof EmailapiaddressDAO)){
                setProperties((EmailapiaddressDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT emailapiaddressid, uniquekey, accountuserid, accountid, logid, emailtype  FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        emailapiaddressid = Integer.parseInt(rstData[0][0]);
                    } else {
                        emailapiaddressid = 0;
                    }

                    uniquekey = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuserid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        logid = Integer.parseInt(rstData[0][4]);
                    } else {
                        logid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        emailtype = Integer.parseInt(rstData[0][5]);
                    } else {
                        emailtype = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(emailapiaddressid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"' AND emailapiaddressid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE emailapiaddress SET emailapiaddressid='"+emailapiaddressid+"', uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"', accountuserid='"+accountuserid+"', accountid='"+accountid+"', logid='"+logid+"', emailtype='"+emailtype+"'  WHERE emailapiaddressid='"+emailapiaddressid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(emailapiaddressid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            emailapiaddressid = Db.RunSQLInsert("INSERT INTO emailapiaddress(uniquekey, accountuserid, accountid, logid, emailtype ) VALUES('"+emailapiaddressid+"', '"+reger.core.Util.cleanForSQL(uniquekey)+"', '"+accountuserid+"', '"+accountid+"', '"+logid+"', '"+emailtype+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(emailapiaddressid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(emailapiaddressid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEmailapiaddressDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "emailapiaddressDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return emailapiaddressid;
    }

    public String getPrimaryKeyName(){
        return "emailapiaddressid";
    }

    public String getTableName(){
        return "emailapiaddress";
    }

    public void setProperties(EmailapiaddressDAO obj){
        if(obj!=null){
            this.emailapiaddressid = obj.emailapiaddressid;
            this.uniquekey = obj.uniquekey;
            this.accountuserid = obj.accountuserid;
            this.accountid = obj.accountid;
            this.logid = obj.logid;
            this.emailtype = obj.emailtype;
        }
    }


    public int getEmailapiaddressid() {
        return emailapiaddressid;
    }


    public String getUniquekey() {
        return uniquekey;
    }


    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getLogid() {
        return logid;
    }


    public void setLogid(int logid) {
        this.logid = logid;
    }


    public int getEmailtype() {
        return emailtype;
    }


    public void setEmailtype(int emailtype) {
        this.emailtype = emailtype;
    }


}