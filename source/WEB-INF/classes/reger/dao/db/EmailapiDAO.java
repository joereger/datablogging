package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'emailapi' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEmailapiDAO.java
 * Finders for this DAO: reger.dao.finders.EmailapiFinder.java
 * 
 */

public class EmailapiDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "emailapiDAO";

    protected int emailapiid = 0;
    protected int accountuserid = 0;
    protected String emailsecret = "";
    protected boolean overridecamphonesubject = true;
    protected String overridecamphonesubjecttext = "";
    protected boolean ignorecamphonebody = true;
    protected boolean consolidatecamphonetoonedailyentry = true;
    protected boolean saveemailpostsasdraft = true;
    protected boolean savecamphonepostsasdraft = true;
    protected String camphoneimagetags = "";

    public EmailapiDAO (int emailapiid){
        this.emailapiid = emailapiid;
        load();
    }

    public EmailapiDAO(){


    }

    public void load(){
        if (emailapiid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(emailapiid), CACHEGROUP);
            if (obj!=null && (obj instanceof EmailapiDAO)){
                setProperties((EmailapiDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT emailapiid, accountuserid, emailsecret, overridecamphonesubject, overridecamphonesubjecttext, ignorecamphonebody, consolidatecamphonetoonedailyentry, saveemailpostsasdraft, savecamphonepostsasdraft, camphoneimagetags  FROM emailapi WHERE emailapiid='"+emailapiid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        emailapiid = Integer.parseInt(rstData[0][0]);
                    } else {
                        emailapiid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    emailsecret = rstData[0][2];

                    overridecamphonesubject = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    overridecamphonesubjecttext = rstData[0][4];

                    ignorecamphonebody = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    consolidatecamphonetoonedailyentry = reger.core.Util.booleanFromSQLText(rstData[0][6]);

                    saveemailpostsasdraft = reger.core.Util.booleanFromSQLText(rstData[0][7]);

                    savecamphonepostsasdraft = reger.core.Util.booleanFromSQLText(rstData[0][8]);

                    camphoneimagetags = rstData[0][9];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(emailapiid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT emailapiid FROM emailapi WHERE emailapiid='"+emailapiid+"' AND emailapiid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE emailapi SET emailapiid='"+emailapiid+"', accountuserid='"+accountuserid+"', emailsecret='"+reger.core.Util.cleanForSQL(emailsecret)+"', overridecamphonesubject='"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', overridecamphonesubjecttext='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', ignorecamphonebody='"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', consolidatecamphonetoonedailyentry='"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"', saveemailpostsasdraft='"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"', savecamphonepostsasdraft='"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"', camphoneimagetags='"+reger.core.Util.cleanForSQL(camphoneimagetags)+"'  WHERE emailapiid='"+emailapiid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(emailapiid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            emailapiid = Db.RunSQLInsert("INSERT INTO emailapi(accountuserid, emailsecret, overridecamphonesubject, overridecamphonesubjecttext, ignorecamphonebody, consolidatecamphonetoonedailyentry, saveemailpostsasdraft, savecamphonepostsasdraft, camphoneimagetags ) VALUES('"+emailapiid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(emailsecret)+"', '"+reger.core.Util.booleanAsSQLText(overridecamphonesubject)+"', '"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"', '"+reger.core.Util.booleanAsSQLText(ignorecamphonebody)+"', '"+reger.core.Util.booleanAsSQLText(consolidatecamphonetoonedailyentry)+"', '"+reger.core.Util.booleanAsSQLText(saveemailpostsasdraft)+"', '"+reger.core.Util.booleanAsSQLText(savecamphonepostsasdraft)+"', '"+reger.core.Util.cleanForSQL(camphoneimagetags)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(emailapiid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM emailapi WHERE emailapiid='"+emailapiid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(emailapiid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEmailapiDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "emailapiDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return emailapiid;
    }

    public String getPrimaryKeyName(){
        return "emailapiid";
    }

    public String getTableName(){
        return "emailapi";
    }

    public void setProperties(EmailapiDAO obj){
        if(obj!=null){
            this.emailapiid = obj.emailapiid;
            this.accountuserid = obj.accountuserid;
            this.emailsecret = obj.emailsecret;
            this.overridecamphonesubject = obj.overridecamphonesubject;
            this.overridecamphonesubjecttext = obj.overridecamphonesubjecttext;
            this.ignorecamphonebody = obj.ignorecamphonebody;
            this.consolidatecamphonetoonedailyentry = obj.consolidatecamphonetoonedailyentry;
            this.saveemailpostsasdraft = obj.saveemailpostsasdraft;
            this.savecamphonepostsasdraft = obj.savecamphonepostsasdraft;
            this.camphoneimagetags = obj.camphoneimagetags;
        }
    }


    public int getEmailapiid() {
        return emailapiid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getEmailsecret() {
        return emailsecret;
    }


    public void setEmailsecret(String emailsecret) {
        this.emailsecret = emailsecret;
    }


    public boolean getOverridecamphonesubject() {
        return overridecamphonesubject;
    }


    public void setOverridecamphonesubject(boolean overridecamphonesubject) {
        this.overridecamphonesubject = overridecamphonesubject;
    }


    public String getOverridecamphonesubjecttext() {
        return overridecamphonesubjecttext;
    }


    public void setOverridecamphonesubjecttext(String overridecamphonesubjecttext) {
        this.overridecamphonesubjecttext = overridecamphonesubjecttext;
    }


    public boolean getIgnorecamphonebody() {
        return ignorecamphonebody;
    }


    public void setIgnorecamphonebody(boolean ignorecamphonebody) {
        this.ignorecamphonebody = ignorecamphonebody;
    }


    public boolean getConsolidatecamphonetoonedailyentry() {
        return consolidatecamphonetoonedailyentry;
    }


    public void setConsolidatecamphonetoonedailyentry(boolean consolidatecamphonetoonedailyentry) {
        this.consolidatecamphonetoonedailyentry = consolidatecamphonetoonedailyentry;
    }


    public boolean getSaveemailpostsasdraft() {
        return saveemailpostsasdraft;
    }


    public void setSaveemailpostsasdraft(boolean saveemailpostsasdraft) {
        this.saveemailpostsasdraft = saveemailpostsasdraft;
    }


    public boolean getSavecamphonepostsasdraft() {
        return savecamphonepostsasdraft;
    }


    public void setSavecamphonepostsasdraft(boolean savecamphonepostsasdraft) {
        this.savecamphonepostsasdraft = savecamphonepostsasdraft;
    }


    public String getCamphoneimagetags() {
        return camphoneimagetags;
    }


    public void setCamphoneimagetags(String camphoneimagetags) {
        this.camphoneimagetags = camphoneimagetags;
    }


}