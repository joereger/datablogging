package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'message' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMessageDAO.java
 * Finders for this DAO: reger.dao.finders.MessageFinder.java
 * 
 */

public class MessageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "messageDAO";

    protected int messageid = 0;
    protected int eventid = 0;
    protected java.util.Calendar messagedate = java.util.Calendar.getInstance();
    protected String messagefrom = "";
    protected String message = "";
    protected boolean isapproved = true;
    protected int sizeinbytes = 0;
    protected String email = "";
    protected String ipaddress = "";
    protected String url = "";
    protected int emailnotify = 0;

    public MessageDAO (int messageid){
        this.messageid = messageid;
        load();
    }

    public MessageDAO(){


    }

    public void load(){
        if (messageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(messageid), CACHEGROUP);
            if (obj!=null && (obj instanceof MessageDAO)){
                setProperties((MessageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT messageid, eventid, messagedate, messagefrom, message, isapproved, sizeinbytes, email, ipaddress, url, emailnotify  FROM message WHERE messageid='"+messageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        messageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        messageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    messagedate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    messagefrom = rstData[0][3];

                    message = rstData[0][4];

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        sizeinbytes = Integer.parseInt(rstData[0][6]);
                    } else {
                        sizeinbytes = 0;
                    }

                    email = rstData[0][7];

                    ipaddress = rstData[0][8];

                    url = rstData[0][9];

                    if (reger.core.Util.isinteger(rstData[0][10])){
                        emailnotify = Integer.parseInt(rstData[0][10]);
                    } else {
                        emailnotify = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(messageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT messageid FROM message WHERE messageid='"+messageid+"' AND messageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE message SET messageid='"+messageid+"', eventid='"+eventid+"', messagedate='"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"', message='"+reger.core.Util.cleanForSQL(message)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', sizeinbytes='"+sizeinbytes+"', email='"+reger.core.Util.cleanForSQL(email)+"', ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"', url='"+reger.core.Util.cleanForSQL(url)+"', emailnotify='"+emailnotify+"'  WHERE messageid='"+messageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(messageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            messageid = Db.RunSQLInsert("INSERT INTO message(eventid, messagedate, messagefrom, message, isapproved, sizeinbytes, email, ipaddress, url, emailnotify ) VALUES('"+messageid+"', '"+eventid+"', '"+reger.core.TimeUtils.dateformatfordb(messagedate)+"', '"+reger.core.Util.cleanForSQL(messagefrom)+"', '"+reger.core.Util.cleanForSQL(message)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"', '"+sizeinbytes+"', '"+reger.core.Util.cleanForSQL(email)+"', '"+reger.core.Util.cleanForSQL(ipaddress)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+emailnotify+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(messageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM message WHERE messageid='"+messageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(messageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMessageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "messageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return messageid;
    }

    public String getPrimaryKeyName(){
        return "messageid";
    }

    public String getTableName(){
        return "message";
    }

    public void setProperties(MessageDAO obj){
        if(obj!=null){
            this.messageid = obj.messageid;
            this.eventid = obj.eventid;
            this.messagedate = obj.messagedate;
            this.messagefrom = obj.messagefrom;
            this.message = obj.message;
            this.isapproved = obj.isapproved;
            this.sizeinbytes = obj.sizeinbytes;
            this.email = obj.email;
            this.ipaddress = obj.ipaddress;
            this.url = obj.url;
            this.emailnotify = obj.emailnotify;
        }
    }


    public int getMessageid() {
        return messageid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public java.util.Calendar getMessagedate() {
        return messagedate;
    }


    public void setMessagedate(java.util.Calendar messagedate) {
        this.messagedate = messagedate;
    }


    public String getMessagefrom() {
        return messagefrom;
    }


    public void setMessagefrom(String messagefrom) {
        this.messagefrom = messagefrom;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public boolean getIsapproved() {
        return isapproved;
    }


    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


    public int getSizeinbytes() {
        return sizeinbytes;
    }


    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getIpaddress() {
        return ipaddress;
    }


    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getEmailnotify() {
        return emailnotify;
    }


    public void setEmailnotify(int emailnotify) {
        this.emailnotify = emailnotify;
    }


}