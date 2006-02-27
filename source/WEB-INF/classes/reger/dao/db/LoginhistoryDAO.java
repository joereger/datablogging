package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'loginhistory' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLoginhistoryDAO.java
 * Finders for this DAO: reger.dao.finders.LoginhistoryFinder.java
 * 
 */

public class LoginhistoryDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "loginhistoryDAO";

    protected int loginhistoryid = 0;
    protected int accountuserid = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected String usertype = "";
    protected String enteredpassword = "";
    protected boolean success = true;

    public LoginhistoryDAO (int loginhistoryid){
        this.loginhistoryid = loginhistoryid;
        load();
    }

    public LoginhistoryDAO(){


    }

    public void load(){
        if (loginhistoryid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(loginhistoryid), CACHEGROUP);
            if (obj!=null && (obj instanceof LoginhistoryDAO)){
                setProperties((LoginhistoryDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT loginhistoryid, accountuserid, date, usertype, enteredpassword, success  FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        loginhistoryid = Integer.parseInt(rstData[0][0]);
                    } else {
                        loginhistoryid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    usertype = rstData[0][3];

                    enteredpassword = rstData[0][4];

                    success = reger.core.Util.booleanFromSQLText(rstData[0][5]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(loginhistoryid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT loginhistoryid FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"' AND loginhistoryid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE loginhistory SET loginhistoryid='"+loginhistoryid+"', accountuserid='"+accountuserid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', usertype='"+reger.core.Util.cleanForSQL(usertype)+"', enteredpassword='"+reger.core.Util.cleanForSQL(enteredpassword)+"', success='"+reger.core.Util.booleanAsSQLText(success)+"'  WHERE loginhistoryid='"+loginhistoryid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(loginhistoryid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            loginhistoryid = Db.RunSQLInsert("INSERT INTO loginhistory(accountuserid, date, usertype, enteredpassword, success ) VALUES('"+loginhistoryid+"', '"+accountuserid+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+reger.core.Util.cleanForSQL(usertype)+"', '"+reger.core.Util.cleanForSQL(enteredpassword)+"', '"+reger.core.Util.booleanAsSQLText(success)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(loginhistoryid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM loginhistory WHERE loginhistoryid='"+loginhistoryid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(loginhistoryid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLoginhistoryDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "loginhistoryDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return loginhistoryid;
    }

    public String getPrimaryKeyName(){
        return "loginhistoryid";
    }

    public String getTableName(){
        return "loginhistory";
    }

    public void setProperties(LoginhistoryDAO obj){
        if(obj!=null){
            this.loginhistoryid = obj.loginhistoryid;
            this.accountuserid = obj.accountuserid;
            this.date = obj.date;
            this.usertype = obj.usertype;
            this.enteredpassword = obj.enteredpassword;
            this.success = obj.success;
        }
    }


    public int getLoginhistoryid() {
        return loginhistoryid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public String getUsertype() {
        return usertype;
    }


    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }


    public String getEnteredpassword() {
        return enteredpassword;
    }


    public void setEnteredpassword(String enteredpassword) {
        this.enteredpassword = enteredpassword;
    }


    public boolean getSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


}