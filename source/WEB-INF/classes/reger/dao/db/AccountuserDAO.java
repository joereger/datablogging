package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'accountuser' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAccountuserDAO.java
 * Finders for this DAO: reger.dao.finders.AccountuserFinder.java
 * 
 */

public class AccountuserDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountuserDAO";

    protected int accountuserid = 0;
    protected boolean isactive = true;
    protected int accountid = 0;
    protected String password = "";
    protected String username = "";
    protected String friendlyname = "";
    protected String onelinesummary = "";
    protected String passphrasequestion = "";
    protected String passphraseanswer = "";
    protected String email = "";
    protected java.util.Calendar lastlogindate = java.util.Calendar.getInstance();
    protected int entrymode = 0;
    protected String usertimezoneid = "";
    protected java.util.Calendar createdate = java.util.Calendar.getInstance();
    protected boolean ishelpon = true;
    protected boolean isactivatedbyemail = true;
    protected String emailactivationkey = "";
    protected java.util.Calendar emailactivationlastsent = java.util.Calendar.getInstance();
    protected int profileimageid = 0;

    public AccountuserDAO (int accountuserid){
        this.accountuserid = accountuserid;
        load();
    }

    public AccountuserDAO(){


    }

    public void load(){
        if (accountuserid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountuserid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountuserDAO)){
                setProperties((AccountuserDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountuserid, isactive, accountid, password, username, friendlyname, onelinesummary, passphrasequestion, passphraseanswer, email, lastlogindate, entrymode, usertimezoneid, createdate, ishelpon, isactivatedbyemail, emailactivationkey, emailactivationlastsent, profileimageid  FROM accountuser WHERE accountuserid='"+accountuserid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountuserid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountuserid = 0;
                    }

                    isactive = reger.core.Util.booleanFromSQLText(rstData[0][1]);

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountid = 0;
                    }

                    password = rstData[0][3];

                    username = rstData[0][4];

                    friendlyname = rstData[0][5];

                    onelinesummary = rstData[0][6];

                    passphrasequestion = rstData[0][7];

                    passphraseanswer = rstData[0][8];

                    email = rstData[0][9];

                    lastlogindate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][10]);

                    if (reger.core.Util.isinteger(rstData[0][11])){
                        entrymode = Integer.parseInt(rstData[0][11]);
                    } else {
                        entrymode = 0;
                    }

                    usertimezoneid = rstData[0][12];

                    createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][13]);

                    ishelpon = reger.core.Util.booleanFromSQLText(rstData[0][14]);

                    isactivatedbyemail = reger.core.Util.booleanFromSQLText(rstData[0][15]);

                    emailactivationkey = rstData[0][16];

                    emailactivationlastsent = reger.core.TimeUtils.dbstringtocalendar(rstData[0][17]);

                    if (reger.core.Util.isinteger(rstData[0][18])){
                        profileimageid = Integer.parseInt(rstData[0][18]);
                    } else {
                        profileimageid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountuserid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid='"+accountuserid+"' AND accountuserid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE accountuser SET accountuserid='"+accountuserid+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"', accountid='"+accountid+"', password='"+reger.core.Util.cleanForSQL(password)+"', username='"+reger.core.Util.cleanForSQL(username)+"', friendlyname='"+reger.core.Util.cleanForSQL(friendlyname)+"', onelinesummary='"+reger.core.Util.cleanForSQL(onelinesummary)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(passphrasequestion)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(passphraseanswer)+"', email='"+reger.core.Util.cleanForSQL(email)+"', lastlogindate='"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', entrymode='"+entrymode+"', usertimezoneid='"+reger.core.Util.cleanForSQL(usertimezoneid)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', ishelpon='"+reger.core.Util.booleanAsSQLText(ishelpon)+"', isactivatedbyemail='"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"', emailactivationkey='"+reger.core.Util.cleanForSQL(emailactivationkey)+"', emailactivationlastsent='"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"', profileimageid='"+profileimageid+"'  WHERE accountuserid='"+accountuserid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountuserid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountuserid = Db.RunSQLInsert("INSERT INTO accountuser(isactive, accountid, password, username, friendlyname, onelinesummary, passphrasequestion, passphraseanswer, email, lastlogindate, entrymode, usertimezoneid, createdate, ishelpon, isactivatedbyemail, emailactivationkey, emailactivationlastsent, profileimageid ) VALUES('"+accountuserid+"', '"+reger.core.Util.booleanAsSQLText(isactive)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(password)+"', '"+reger.core.Util.cleanForSQL(username)+"', '"+reger.core.Util.cleanForSQL(friendlyname)+"', '"+reger.core.Util.cleanForSQL(onelinesummary)+"', '"+reger.core.Util.cleanForSQL(passphrasequestion)+"', '"+reger.core.Util.cleanForSQL(passphraseanswer)+"', '"+reger.core.Util.cleanForSQL(email)+"', '"+reger.core.TimeUtils.dateformatfordb(lastlogindate)+"', '"+entrymode+"', '"+reger.core.Util.cleanForSQL(usertimezoneid)+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.Util.booleanAsSQLText(ishelpon)+"', '"+reger.core.Util.booleanAsSQLText(isactivatedbyemail)+"', '"+reger.core.Util.cleanForSQL(emailactivationkey)+"', '"+reger.core.TimeUtils.dateformatfordb(emailactivationlastsent)+"', '"+profileimageid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountuserid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuser WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountuserid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountuserDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountuserDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountuserid;
    }

    public String getPrimaryKeyName(){
        return "accountuserid";
    }

    public String getTableName(){
        return "accountuser";
    }

    public void setProperties(AccountuserDAO obj){
        if(obj!=null){
            this.accountuserid = obj.accountuserid;
            this.isactive = obj.isactive;
            this.accountid = obj.accountid;
            this.password = obj.password;
            this.username = obj.username;
            this.friendlyname = obj.friendlyname;
            this.onelinesummary = obj.onelinesummary;
            this.passphrasequestion = obj.passphrasequestion;
            this.passphraseanswer = obj.passphraseanswer;
            this.email = obj.email;
            this.lastlogindate = obj.lastlogindate;
            this.entrymode = obj.entrymode;
            this.usertimezoneid = obj.usertimezoneid;
            this.createdate = obj.createdate;
            this.ishelpon = obj.ishelpon;
            this.isactivatedbyemail = obj.isactivatedbyemail;
            this.emailactivationkey = obj.emailactivationkey;
            this.emailactivationlastsent = obj.emailactivationlastsent;
            this.profileimageid = obj.profileimageid;
        }
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public boolean getIsactive() {
        return isactive;
    }


    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getFriendlyname() {
        return friendlyname;
    }


    public void setFriendlyname(String friendlyname) {
        this.friendlyname = friendlyname;
    }


    public String getOnelinesummary() {
        return onelinesummary;
    }


    public void setOnelinesummary(String onelinesummary) {
        this.onelinesummary = onelinesummary;
    }


    public String getPassphrasequestion() {
        return passphrasequestion;
    }


    public void setPassphrasequestion(String passphrasequestion) {
        this.passphrasequestion = passphrasequestion;
    }


    public String getPassphraseanswer() {
        return passphraseanswer;
    }


    public void setPassphraseanswer(String passphraseanswer) {
        this.passphraseanswer = passphraseanswer;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public java.util.Calendar getLastlogindate() {
        return lastlogindate;
    }


    public void setLastlogindate(java.util.Calendar lastlogindate) {
        this.lastlogindate = lastlogindate;
    }


    public int getEntrymode() {
        return entrymode;
    }


    public void setEntrymode(int entrymode) {
        this.entrymode = entrymode;
    }


    public String getUsertimezoneid() {
        return usertimezoneid;
    }


    public void setUsertimezoneid(String usertimezoneid) {
        this.usertimezoneid = usertimezoneid;
    }


    public java.util.Calendar getCreatedate() {
        return createdate;
    }


    public void setCreatedate(java.util.Calendar createdate) {
        this.createdate = createdate;
    }


    public boolean getIshelpon() {
        return ishelpon;
    }


    public void setIshelpon(boolean ishelpon) {
        this.ishelpon = ishelpon;
    }


    public boolean getIsactivatedbyemail() {
        return isactivatedbyemail;
    }


    public void setIsactivatedbyemail(boolean isactivatedbyemail) {
        this.isactivatedbyemail = isactivatedbyemail;
    }


    public String getEmailactivationkey() {
        return emailactivationkey;
    }


    public void setEmailactivationkey(String emailactivationkey) {
        this.emailactivationkey = emailactivationkey;
    }


    public java.util.Calendar getEmailactivationlastsent() {
        return emailactivationlastsent;
    }


    public void setEmailactivationlastsent(java.util.Calendar emailactivationlastsent) {
        this.emailactivationlastsent = emailactivationlastsent;
    }


    public int getProfileimageid() {
        return profileimageid;
    }


    public void setProfileimageid(int profileimageid) {
        this.profileimageid = profileimageid;
    }


}