package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'friendinvitation' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFriendinvitationDAO.java
 * Finders for this DAO: reger.dao.finders.FriendinvitationFinder.java
 * 
 */

public class FriendinvitationDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "friendinvitationDAO";

    protected int friendinvitationid = 0;
    protected int accountuseridsource = 0;
    protected int accountuseridtarget = 0;
    protected int status = 0;
    protected String email = "";
    protected String subject = "";
    protected String message = "";
    protected java.util.Calendar createdate = java.util.Calendar.getInstance();
    protected java.util.Calendar emaillastsentdate = java.util.Calendar.getInstance();
    protected String friendinvitationkey = "";

    public FriendinvitationDAO (int friendinvitationid){
        this.friendinvitationid = friendinvitationid;
        load();
    }

    public FriendinvitationDAO(){


    }

    public void load(){
        if (friendinvitationid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(friendinvitationid), CACHEGROUP);
            if (obj!=null && (obj instanceof FriendinvitationDAO)){
                setProperties((FriendinvitationDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT friendinvitationid, accountuseridsource, accountuseridtarget, status, email, subject, message, createdate, emaillastsentdate, friendinvitationkey  FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        friendinvitationid = Integer.parseInt(rstData[0][0]);
                    } else {
                        friendinvitationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuseridsource = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuseridsource = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuseridtarget = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuseridtarget = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        status = Integer.parseInt(rstData[0][3]);
                    } else {
                        status = 0;
                    }

                    email = rstData[0][4];

                    subject = rstData[0][5];

                    message = rstData[0][6];

                    createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][7]);

                    emaillastsentdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][8]);

                    friendinvitationkey = rstData[0][9];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT friendinvitationid FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"' AND friendinvitationid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE friendinvitation SET friendinvitationid='"+friendinvitationid+"', accountuseridsource='"+accountuseridsource+"', accountuseridtarget='"+accountuseridtarget+"', status='"+status+"', email='"+reger.core.Util.cleanForSQL(email)+"', subject='"+reger.core.Util.cleanForSQL(subject)+"', message='"+reger.core.Util.cleanForSQL(message)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', emaillastsentdate='"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"', friendinvitationkey='"+reger.core.Util.cleanForSQL(friendinvitationkey)+"'  WHERE friendinvitationid='"+friendinvitationid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            friendinvitationid = Db.RunSQLInsert("INSERT INTO friendinvitation(accountuseridsource, accountuseridtarget, status, email, subject, message, createdate, emaillastsentdate, friendinvitationkey ) VALUES('"+friendinvitationid+"', '"+accountuseridsource+"', '"+accountuseridtarget+"', '"+status+"', '"+reger.core.Util.cleanForSQL(email)+"', '"+reger.core.Util.cleanForSQL(subject)+"', '"+reger.core.Util.cleanForSQL(message)+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.TimeUtils.dateformatfordb(emaillastsentdate)+"', '"+reger.core.Util.cleanForSQL(friendinvitationkey)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(friendinvitationid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(friendinvitationid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFriendinvitationDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "friendinvitationDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return friendinvitationid;
    }

    public String getPrimaryKeyName(){
        return "friendinvitationid";
    }

    public String getTableName(){
        return "friendinvitation";
    }

    public void setProperties(FriendinvitationDAO obj){
        if(obj!=null){
            this.friendinvitationid = obj.friendinvitationid;
            this.accountuseridsource = obj.accountuseridsource;
            this.accountuseridtarget = obj.accountuseridtarget;
            this.status = obj.status;
            this.email = obj.email;
            this.subject = obj.subject;
            this.message = obj.message;
            this.createdate = obj.createdate;
            this.emaillastsentdate = obj.emaillastsentdate;
            this.friendinvitationkey = obj.friendinvitationkey;
        }
    }


    public int getFriendinvitationid() {
        return friendinvitationid;
    }


    public int getAccountuseridsource() {
        return accountuseridsource;
    }


    public void setAccountuseridsource(int accountuseridsource) {
        this.accountuseridsource = accountuseridsource;
    }


    public int getAccountuseridtarget() {
        return accountuseridtarget;
    }


    public void setAccountuseridtarget(int accountuseridtarget) {
        this.accountuseridtarget = accountuseridtarget;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public java.util.Calendar getCreatedate() {
        return createdate;
    }


    public void setCreatedate(java.util.Calendar createdate) {
        this.createdate = createdate;
    }


    public java.util.Calendar getEmaillastsentdate() {
        return emaillastsentdate;
    }


    public void setEmaillastsentdate(java.util.Calendar emaillastsentdate) {
        this.emaillastsentdate = emaillastsentdate;
    }


    public String getFriendinvitationkey() {
        return friendinvitationkey;
    }


    public void setFriendinvitationkey(String friendinvitationkey) {
        this.friendinvitationkey = friendinvitationkey;
    }


}