package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuserfield' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuserfieldDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuserfieldFinder.java
 * 
 */

public class AccountuserfieldDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuserfieldDAO";

    protected int accountuserfieldid = 0;
    protected int accountuserid = 0;
    protected String fieldtitle = "";
    protected String fielddata = "";
    protected int order = 0;

    public AccountuserfieldDAO (int accountuserfieldid){
        this.accountuserfieldid = accountuserfieldid;
        load();
    }

    public AccountuserfieldDAO(){


    }

    public void load(){
        if (accountuserfieldid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuserfieldid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuserfieldDAO)){
                setProperties((AccountuserfieldDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuserfieldid, accountuserid, fieldtitle, fielddata, order  FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuserfieldid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuserfieldid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    fieldtitle = rstData[0][2];

                    fielddata = rstData[0][3];

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        order = Integer.parseInt(rstData[0][4]);
                    } else {
                        order = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuserfieldid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuserfieldid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"' AND accountuserfieldid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuserfield SET accountuserfieldid='"+accountuserfieldid+"', accountuserid='"+accountuserid+"', fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"', fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"', order='"+order+"'  WHERE accountuserfieldid='"+accountuserfieldid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuserfieldid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuserfieldid = Db.RunSQLInsert("INSERT INTO accountuserfield(accountuserid, fieldtitle, fielddata, order ) VALUES('"+accountuserfieldid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(fieldtitle)+"', '"+reger.core.Util.cleanForSQL(fielddata)+"', '"+order+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuserfieldid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuserfieldid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuserfieldDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuserfieldDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuserfieldid;
    }

    public String getPrimaryKeyName(){
        return "accountuserfieldid";
    }

    public String getTableName(){
        return "accountuserfield";
    }

    public void setProperties(AccountuserfieldDAO obj){
        if(obj!=null){
            this.accountuserfieldid = obj.accountuserfieldid;
            this.accountuserid = obj.accountuserid;
            this.fieldtitle = obj.fieldtitle;
            this.fielddata = obj.fielddata;
            this.order = obj.order;
        }
    }


    public int getAccountuserfieldid() {
        return accountuserfieldid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getFieldtitle() {
        return fieldtitle;
    }


    public void setFieldtitle(String fieldtitle) {
        this.fieldtitle = fieldtitle;
    }


    public String getFielddata() {
        return fielddata;
    }


    public void setFielddata(String fielddata) {
        this.fielddata = fielddata;
    }


    public int getOrder() {
        return order;
    }


    public void setOrder(int order) {
        this.order = order;
    }


}