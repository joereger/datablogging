package reger.dao.hibernate;
// Generated Mar 7, 2006 3:43:08 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;


/**
 * Bugcomment generated by hbm2java
 */

public class Bugcomment  implements java.io.Serializable {


    // Fields    

     private int bugcommentid;
     private int bugid;
     private Date date;
     private String comment;


    // Constructors

    /** default constructor */
    public Bugcomment() {
    }

	/** minimal constructor */
    public Bugcomment(int bugcommentid) {
        this.bugcommentid = bugcommentid;
    }
    
    /** full constructor */
    public Bugcomment(int bugcommentid, Integer bugid, Date date, String comment) {
        this.bugcommentid = bugcommentid;
        this.bugid = bugid;
        this.date = date;
        this.comment = comment;
    }
    

   
    // Property accessors

    public int getBugcommentid() {
        return this.bugcommentid;
    }
    
    public void setBugcommentid(int bugcommentid) {
        this.bugcommentid = bugcommentid;
    }

    public int getBugid() {
        return this.bugid;
    }
    
    public void setBugid(int bugid) {
        this.bugid = bugid;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
   








}
