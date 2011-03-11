package reger.dao;
// Generated Mar 7, 2006 3:43:24 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;


/**
 * Search generated by hbm2java
 */

public class Search  implements java.io.Serializable {


    // Fields    

     private int searchid;
     private int accountid;
     private String searchstring;
     private Date datetime;


    // Constructors

    /** default constructor */
    public Search() {
    }

	/** minimal constructor */
    public Search(int searchid) {
        this.searchid = searchid;
    }
    
    /** full constructor */
    public Search(int searchid, Integer accountid, String searchstring, Date datetime) {
        this.searchid = searchid;
        this.accountid = accountid;
        this.searchstring = searchstring;
        this.datetime = datetime;
    }
    

   
    // Property accessors

    public int getSearchid() {
        return this.searchid;
    }
    
    public void setSearchid(int searchid) {
        this.searchid = searchid;
    }

    public int getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getSearchstring() {
        return this.searchstring;
    }
    
    public void setSearchstring(String searchstring) {
        this.searchstring = searchstring;
    }

    public Date getDatetime() {
        return this.datetime;
    }
    
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
   








}