package reger.dao;
// Generated Mar 7, 2006 3:42:54 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;


/**
 * Message generated by hbm2java
 */

public class Message  implements java.io.Serializable {


    // Fields    

     private int messageid;
     private int eventid;
     private Date messagedate;
     private String messagefrom;
     private String message;
     private boolean isapproved;
     private int sizeinbytes;
     private String email;
     private String ipaddress;
     private String url;
     private int emailnotify;


    // Constructors

    /** default constructor */
    public Message() {
    }

	/** minimal constructor */
    public Message(int messageid, int eventid, Date messagedate, String message, int sizeinbytes) {
        this.messageid = messageid;
        this.eventid = eventid;
        this.messagedate = messagedate;
        this.message = message;
        this.sizeinbytes = sizeinbytes;
    }
    
    /** full constructor */
    public Message(int messageid, int eventid, Date messagedate, String messagefrom, String message, boolean isapproved, int sizeinbytes, String email, String ipaddress, String url, Integer emailnotify) {
        this.messageid = messageid;
        this.eventid = eventid;
        this.messagedate = messagedate;
        this.messagefrom = messagefrom;
        this.message = message;
        this.isapproved = isapproved;
        this.sizeinbytes = sizeinbytes;
        this.email = email;
        this.ipaddress = ipaddress;
        this.url = url;
        this.emailnotify = emailnotify;
    }
    

   
    // Property accessors

    public int getMessageid() {
        return this.messageid;
    }
    
    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public int getEventid() {
        return this.eventid;
    }
    
    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public Date getMessagedate() {
        return this.messagedate;
    }
    
    public void setMessagedate(Date messagedate) {
        this.messagedate = messagedate;
    }

    public String getMessagefrom() {
        return this.messagefrom;
    }
    
    public void setMessagefrom(String messagefrom) {
        this.messagefrom = messagefrom;
    }

    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsapproved() {
        return this.isapproved;
    }
    
    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }

    public int getSizeinbytes() {
        return this.sizeinbytes;
    }
    
    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpaddress() {
        return this.ipaddress;
    }
    
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public int getEmailnotify() {
        return this.emailnotify;
    }
    
    public void setEmailnotify(int emailnotify) {
        this.emailnotify = emailnotify;
    }
   








}
