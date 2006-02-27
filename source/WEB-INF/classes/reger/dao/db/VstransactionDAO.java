package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'vstransaction' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorVstransactionDAO.java
 * Finders for this DAO: reger.dao.finders.VstransactionFinder.java
 * 
 */

public class VstransactionDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "vstransactionDAO";

    protected int vstransactionid = 0;
    protected int accountid = 0;
    protected java.util.Calendar datetime = java.util.Calendar.getInstance();
    protected String vssentstring = "";
    protected String vsresultstring = "";
    protected String hostaddress = "";
    protected String result = "";
    protected String acct = "";
    protected String amt = "";
    protected String street = "";
    protected String zip = "";
    protected String rpref = "";
    protected String profileid = "";

    public VstransactionDAO (int vstransactionid){
        this.vstransactionid = vstransactionid;
        load();
    }

    public VstransactionDAO(){


    }

    public void load(){
        if (vstransactionid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(vstransactionid), CACHEGROUP);
            if (obj!=null && (obj instanceof VstransactionDAO)){
                setProperties((VstransactionDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT vstransactionid, accountid, datetime, vssentstring, vsresultstring, hostaddress, result, acct, amt, street, zip, rpref, profileid  FROM vstransaction WHERE vstransactionid='"+vstransactionid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        vstransactionid = Integer.parseInt(rstData[0][0]);
                    } else {
                        vstransactionid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    datetime = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    vssentstring = rstData[0][3];

                    vsresultstring = rstData[0][4];

                    hostaddress = rstData[0][5];

                    result = rstData[0][6];

                    acct = rstData[0][7];

                    amt = rstData[0][8];

                    street = rstData[0][9];

                    zip = rstData[0][10];

                    rpref = rstData[0][11];

                    profileid = rstData[0][12];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(vstransactionid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT vstransactionid FROM vstransaction WHERE vstransactionid='"+vstransactionid+"' AND vstransactionid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE vstransaction SET vstransactionid='"+vstransactionid+"', accountid='"+accountid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', vssentstring='"+reger.core.Util.cleanForSQL(vssentstring)+"', vsresultstring='"+reger.core.Util.cleanForSQL(vsresultstring)+"', hostaddress='"+reger.core.Util.cleanForSQL(hostaddress)+"', result='"+reger.core.Util.cleanForSQL(result)+"', acct='"+reger.core.Util.cleanForSQL(acct)+"', amt='"+reger.core.Util.cleanForSQL(amt)+"', street='"+reger.core.Util.cleanForSQL(street)+"', zip='"+reger.core.Util.cleanForSQL(zip)+"', rpref='"+reger.core.Util.cleanForSQL(rpref)+"', profileid='"+reger.core.Util.cleanForSQL(profileid)+"'  WHERE vstransactionid='"+vstransactionid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(vstransactionid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            vstransactionid = Db.RunSQLInsert("INSERT INTO vstransaction(accountid, datetime, vssentstring, vsresultstring, hostaddress, result, acct, amt, street, zip, rpref, profileid ) VALUES('"+vstransactionid+"', '"+accountid+"', '"+reger.core.TimeUtils.dateformatfordb(datetime)+"', '"+reger.core.Util.cleanForSQL(vssentstring)+"', '"+reger.core.Util.cleanForSQL(vsresultstring)+"', '"+reger.core.Util.cleanForSQL(hostaddress)+"', '"+reger.core.Util.cleanForSQL(result)+"', '"+reger.core.Util.cleanForSQL(acct)+"', '"+reger.core.Util.cleanForSQL(amt)+"', '"+reger.core.Util.cleanForSQL(street)+"', '"+reger.core.Util.cleanForSQL(zip)+"', '"+reger.core.Util.cleanForSQL(rpref)+"', '"+reger.core.Util.cleanForSQL(profileid)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(vstransactionid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM vstransaction WHERE vstransactionid='"+vstransactionid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(vstransactionid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorVstransactionDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "vstransactionDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return vstransactionid;
    }

    public String getPrimaryKeyName(){
        return "vstransactionid";
    }

    public String getTableName(){
        return "vstransaction";
    }

    public void setProperties(VstransactionDAO obj){
        if(obj!=null){
            this.vstransactionid = obj.vstransactionid;
            this.accountid = obj.accountid;
            this.datetime = obj.datetime;
            this.vssentstring = obj.vssentstring;
            this.vsresultstring = obj.vsresultstring;
            this.hostaddress = obj.hostaddress;
            this.result = obj.result;
            this.acct = obj.acct;
            this.amt = obj.amt;
            this.street = obj.street;
            this.zip = obj.zip;
            this.rpref = obj.rpref;
            this.profileid = obj.profileid;
        }
    }


    public int getVstransactionid() {
        return vstransactionid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public java.util.Calendar getDatetime() {
        return datetime;
    }


    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


    public String getVssentstring() {
        return vssentstring;
    }


    public void setVssentstring(String vssentstring) {
        this.vssentstring = vssentstring;
    }


    public String getVsresultstring() {
        return vsresultstring;
    }


    public void setVsresultstring(String vsresultstring) {
        this.vsresultstring = vsresultstring;
    }


    public String getHostaddress() {
        return hostaddress;
    }


    public void setHostaddress(String hostaddress) {
        this.hostaddress = hostaddress;
    }


    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }


    public String getAcct() {
        return acct;
    }


    public void setAcct(String acct) {
        this.acct = acct;
    }


    public String getAmt() {
        return amt;
    }


    public void setAmt(String amt) {
        this.amt = amt;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public String getZip() {
        return zip;
    }


    public void setZip(String zip) {
        this.zip = zip;
    }


    public String getRpref() {
        return rpref;
    }


    public void setRpref(String rpref) {
        this.rpref = rpref;
    }


    public String getProfileid() {
        return profileid;
    }


    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }


}