package reger.dao;
// Generated Mar 7, 2006 3:43:22 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;


/**
 * Pldeletearchive generated by hbm2java
 */

public class Pldeletearchive  implements java.io.Serializable {


    // Fields    

     private int pldeletearchiveid;
     private int accountid;
     private Date date;
     private int oldplid;
     private int newplid;


    // Constructors

    /** default constructor */
    public Pldeletearchive() {
    }

	/** minimal constructor */
    public Pldeletearchive(int pldeletearchiveid) {
        this.pldeletearchiveid = pldeletearchiveid;
    }
    
    /** full constructor */
    public Pldeletearchive(int pldeletearchiveid, Integer accountid, Date date, Integer oldplid, Integer newplid) {
        this.pldeletearchiveid = pldeletearchiveid;
        this.accountid = accountid;
        this.date = date;
        this.oldplid = oldplid;
        this.newplid = newplid;
    }
    

   
    // Property accessors

    public int getPldeletearchiveid() {
        return this.pldeletearchiveid;
    }
    
    public void setPldeletearchiveid(int pldeletearchiveid) {
        this.pldeletearchiveid = pldeletearchiveid;
    }

    public int getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public int getOldplid() {
        return this.oldplid;
    }
    
    public void setOldplid(int oldplid) {
        this.oldplid = oldplid;
    }

    public int getNewplid() {
        return this.newplid;
    }
    
    public void setNewplid(int newplid) {
        this.newplid = newplid;
    }
   








}