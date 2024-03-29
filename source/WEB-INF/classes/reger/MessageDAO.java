package reger;

import reger.core.Debug;
import reger.core.TimeUtils;
import reger.core.db.Db;
import java.text.DateFormat;
import java.util.Calendar;

public class MessageDAO {

    private int messageid = 0;
    private int eventid;
    private Calendar messagedate;
    private String messagefrom;
    private String message;
    private int isapproved;
    private int sizeinbytes;
    private String email;
    private String ipaddress;
    private String url;
    private int emailnotify;

    public MessageDAO(int messageid) {
        this.messageid = messageid;
        load();
    }

    public MessageDAO() {
        
    }

    public void load() {
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage = Db.RunSQL("SELECT eventid, messagedate, messagefrom, message, isapproved, sizeinbytes, email, ipaddress, url, emailnotify FROM message WHERE messageid='" + messageid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage != null && rstMessage.length > 0) {
            try {
                this.eventid = Integer.parseInt(rstMessage[0][0]);
                this.messagedate = reger.core.TimeUtils.dbstringtocalendar(rstMessage[0][1]);
                this.messagefrom = rstMessage[0][2];
                this.message = rstMessage[0][3];
                this.isapproved = Integer.parseInt(rstMessage[0][4]);
                this.sizeinbytes = Integer.parseInt(rstMessage[0][5]);
                this.email = rstMessage[0][6];
                this.ipaddress = rstMessage[0][7];
                this.url = rstMessage[0][8];
                this.emailnotify = Integer.parseInt(rstMessage[0][9]);
            } catch (Exception e) {
                Debug.errorsave(e, "load method in Message", "Exception occurred while retrieving the data from Message table");
            }
        }
    }

    public void save() {

        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage = Db.RunSQL("SELECT message FROM message WHERE messageid='" + messageid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage != null && rstMessage.length > 0) {
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE message SET eventid='" + eventid + "', messagedate='" + TimeUtils.dateformatfordb(messagedate) + "', messagefrom='" + reger.core.Util.cleanForSQL(messagefrom) + "', message='" + reger.core.Util.cleanForSQL(message) + "', isapproved='" + isapproved + "', sizeinbytes='" + sizeinbytes + "', email='" + reger.core.Util.cleanForSQL(email) + "', ipaddress='" + reger.core.Util.cleanForSQL(ipaddress) + "', url='" + reger.core.Util.cleanForSQL(url) + "', emailnotify='" + emailnotify + "' WHERE messageid='" + messageid + "'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO message(eventid, messagedate, messagefrom, message, isapproved, sizeinbytes, email, ipaddress, url, emailnotify) VALUES('" + eventid + "', '" + TimeUtils.dateformatfordb(messagedate) + "', '" + reger.core.Util.cleanForSQL(messagefrom) + "', '" + reger.core.Util.cleanForSQL(message) + "', '" + isapproved + "', '" + sizeinbytes + "', '" + reger.core.Util.cleanForSQL(email) + "', '" + reger.core.Util.cleanForSQL(ipaddress) + "', '" + reger.core.Util.cleanForSQL(url) + "', '" + emailnotify + "')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete() {
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM message WHERE messageid='" + this.messageid + "'");
        //-----------------------------------
        //-----------------------------------
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public void setMessagedate(Calendar messagedate) {
        this.messagedate = messagedate;
    }

    public void setMessagefrom(String messagefrom) {
        this.messagefrom = messagefrom;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIsapproved(int isapproved) {
        this.isapproved = isapproved;
    }

    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEmailnotify(int emailnotify) {
        this.emailnotify = emailnotify;
    }

    public int getMessageid() {
        return messageid;
    }

    public int getEventid() {
        return eventid;
    }

    public Calendar getMessagedate() {
        return messagedate;
    }

    public String getMessagefrom() {
        return messagefrom;
    }

    public String getMessage() {
        return message;
    }

    public int getIsapproved() {
        return isapproved;
    }

    public int getSizeinbytes() {
        return sizeinbytes;
    }

    public String getEmail() {
        return email;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public String getUrl() {
        return url;
    }

    public int getEmailnotify() {
        return emailnotify;
    }
}