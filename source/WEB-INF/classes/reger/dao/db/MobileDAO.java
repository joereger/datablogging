package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'mobile' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMobileDAO.java
 * Finders for this DAO: reger.dao.finders.MobileFinder.java
 * 
 */

public class MobileDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "mobileDAO";

    protected int mobileid = 0;
    protected String xupsubno = "";
    protected int accountuserid = 0;

    public MobileDAO (int mobileid){
        this.mobileid = mobileid;
        load();
    }

    public MobileDAO(){


    }

    public void load(){
        if (mobileid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(mobileid), CACHEGROUP);
            if (obj!=null && (obj instanceof MobileDAO)){
                setProperties((MobileDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT mobileid, xupsubno, accountuserid  FROM mobile WHERE mobileid='"+mobileid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        mobileid = Integer.parseInt(rstData[0][0]);
                    } else {
                        mobileid = 0;
                    }

                    xupsubno = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuserid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuserid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(mobileid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT mobileid FROM mobile WHERE mobileid='"+mobileid+"' AND mobileid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE mobile SET mobileid='"+mobileid+"', xupsubno='"+reger.core.Util.cleanForSQL(xupsubno)+"', accountuserid='"+accountuserid+"'  WHERE mobileid='"+mobileid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(mobileid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            mobileid = Db.RunSQLInsert("INSERT INTO mobile(xupsubno, accountuserid ) VALUES('"+mobileid+"', '"+reger.core.Util.cleanForSQL(xupsubno)+"', '"+accountuserid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(mobileid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM mobile WHERE mobileid='"+mobileid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(mobileid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMobileDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "mobileDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return mobileid;
    }

    public String getPrimaryKeyName(){
        return "mobileid";
    }

    public String getTableName(){
        return "mobile";
    }

    public void setProperties(MobileDAO obj){
        if(obj!=null){
            this.mobileid = obj.mobileid;
            this.xupsubno = obj.xupsubno;
            this.accountuserid = obj.accountuserid;
        }
    }


    public int getMobileid() {
        return mobileid;
    }


    public String getXupsubno() {
        return xupsubno;
    }


    public void setXupsubno(String xupsubno) {
        this.xupsubno = xupsubno;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


}