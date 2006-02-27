package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'emailsubscriber' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEmailsubscriberDAO.java
 * Finders for this DAO: reger.dao.finders.EmailsubscriberFinder.java
 * 
 */

public class EmailsubscriberDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "emailsubscriberDAO";

    protected int emailsubscriberid = 0;
    protected int sendeveryxdays = 0;
    protected String emailaddress = "";
    protected int accountid = 0;
    protected boolean htmlemail = true;
    protected java.util.Calendar lastsentdate = java.util.Calendar.getInstance();

    public EmailsubscriberDAO (int emailsubscriberid){
        this.emailsubscriberid = emailsubscriberid;
        load();
    }

    public EmailsubscriberDAO(){


    }

    public void load(){
        if (emailsubscriberid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(emailsubscriberid), CACHEGROUP);
            if (obj!=null && (obj instanceof EmailsubscriberDAO)){
                setProperties((EmailsubscriberDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT emailsubscriberid, sendeveryxdays, emailaddress, accountid, htmlemail, lastsentdate  FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        emailsubscriberid = Integer.parseInt(rstData[0][0]);
                    } else {
                        emailsubscriberid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        sendeveryxdays = Integer.parseInt(rstData[0][1]);
                    } else {
                        sendeveryxdays = 0;
                    }

                    emailaddress = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }

                    htmlemail = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    lastsentdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][5]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(emailsubscriberid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT emailsubscriberid FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"' AND emailsubscriberid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE emailsubscriber SET emailsubscriberid='"+emailsubscriberid+"', sendeveryxdays='"+sendeveryxdays+"', emailaddress='"+reger.core.Util.cleanForSQL(emailaddress)+"', accountid='"+accountid+"', htmlemail='"+reger.core.Util.booleanAsSQLText(htmlemail)+"', lastsentdate='"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"'  WHERE emailsubscriberid='"+emailsubscriberid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(emailsubscriberid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            emailsubscriberid = Db.RunSQLInsert("INSERT INTO emailsubscriber(sendeveryxdays, emailaddress, accountid, htmlemail, lastsentdate ) VALUES('"+emailsubscriberid+"', '"+sendeveryxdays+"', '"+reger.core.Util.cleanForSQL(emailaddress)+"', '"+accountid+"', '"+reger.core.Util.booleanAsSQLText(htmlemail)+"', '"+reger.core.TimeUtils.dateformatfordb(lastsentdate)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(emailsubscriberid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM emailsubscriber WHERE emailsubscriberid='"+emailsubscriberid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(emailsubscriberid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEmailsubscriberDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "emailsubscriberDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return emailsubscriberid;
    }

    public String getPrimaryKeyName(){
        return "emailsubscriberid";
    }

    public String getTableName(){
        return "emailsubscriber";
    }

    public void setProperties(EmailsubscriberDAO obj){
        if(obj!=null){
            this.emailsubscriberid = obj.emailsubscriberid;
            this.sendeveryxdays = obj.sendeveryxdays;
            this.emailaddress = obj.emailaddress;
            this.accountid = obj.accountid;
            this.htmlemail = obj.htmlemail;
            this.lastsentdate = obj.lastsentdate;
        }
    }


    public int getEmailsubscriberid() {
        return emailsubscriberid;
    }


    public int getSendeveryxdays() {
        return sendeveryxdays;
    }


    public void setSendeveryxdays(int sendeveryxdays) {
        this.sendeveryxdays = sendeveryxdays;
    }


    public String getEmailaddress() {
        return emailaddress;
    }


    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public boolean getHtmlemail() {
        return htmlemail;
    }


    public void setHtmlemail(boolean htmlemail) {
        this.htmlemail = htmlemail;
    }


    public java.util.Calendar getLastsentdate() {
        return lastsentdate;
    }


    public void setLastsentdate(java.util.Calendar lastsentdate) {
        this.lastsentdate = lastsentdate;
    }


}