package reger.dao;
// Generated Mar 7, 2006 3:43:25 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


/**
 * Friendmessage generated by hbm2java
 */

public class Friendmessage  implements java.io.Serializable {


    // Fields    

     private int friendmessageid;
     private int accountuserid;
     private String subject;
     private String message;
     private Date datetime;
     private int parentfriendmessageid;

    //Association
    private Set<Friendmessagerecipient> friendmessagerecipients = new HashSet<Friendmessagerecipient>();
    public Set<Friendmessagerecipient> getFriendmessagerecipients() {
        return friendmessagerecipients;
    }
    public void setFriendmessagerecipients(Set<Friendmessagerecipient> friendmessagerecipients) {
        this.friendmessagerecipients = friendmessagerecipients;
    }

    // Constructors

    /** default constructor */
    public Friendmessage() {
    }

    /** minimal constructor */
    public Friendmessage(int friendmessageid, int accountuserid) {
        this.friendmessageid = friendmessageid;
        this.accountuserid = accountuserid;
    }

    /** full constructor */
    public Friendmessage(int friendmessageid, int accountuserid, String subject, String message, Date datetime, Integer parentfriendmessageid) {
        this.friendmessageid = friendmessageid;
        this.accountuserid = accountuserid;
        this.subject = subject;
        this.message = message;
        this.datetime = datetime;
        this.parentfriendmessageid = parentfriendmessageid;
    }



    // Property accessors

    public int getFriendmessageid() {
        return this.friendmessageid;
    }

    public void setFriendmessageid(int friendmessageid) {
        this.friendmessageid = friendmessageid;
    }

    public int getAccountuserid() {
        return this.accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getParentfriendmessageid() {
        return this.parentfriendmessageid;
    }

    public void setParentfriendmessageid(int parentfriendmessageid) {
        this.parentfriendmessageid = parentfriendmessageid;
    }









}