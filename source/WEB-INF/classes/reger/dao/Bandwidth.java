package reger.dao;
// Generated Mar 7, 2006 3:43:03 PM by Hibernate Tools 3.1.0.beta4



/**
 * Bandwidth generated by hbm2java
 */

public class Bandwidth  implements java.io.Serializable {


    // Fields    

     private int bandwidthid;
     private int accountid;
     private int month;
     private int year;
     private long bytes;


    // Constructors

    /** default constructor */
    public Bandwidth() {
    }

	/** minimal constructor */
    public Bandwidth(int bandwidthid, long bytes) {
        this.bandwidthid = bandwidthid;
        this.bytes = bytes;
    }
    
    /** full constructor */
    public Bandwidth(int bandwidthid, Integer accountid, Integer month, Integer year, long bytes) {
        this.bandwidthid = bandwidthid;
        this.accountid = accountid;
        this.month = month;
        this.year = year;
        this.bytes = bytes;
    }
    

   
    // Property accessors

    public int getBandwidthid() {
        return this.bandwidthid;
    }
    
    public void setBandwidthid(int bandwidthid) {
        this.bandwidthid = bandwidthid;
    }

    public int getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getMonth() {
        return this.month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    public long getBytes() {
        return this.bytes;
    }
    
    public void setBytes(long bytes) {
        this.bytes = bytes;
    }
   








}
