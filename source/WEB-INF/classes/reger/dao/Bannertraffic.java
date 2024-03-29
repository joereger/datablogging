package reger.dao;
// Generated Mar 7, 2006 3:43:26 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;


/**
 * Bannertraffic generated by hbm2java
 */

public class Bannertraffic  implements java.io.Serializable {


    // Fields    

     private int bannertrafficid;
     private int bannerid;
     private Date date;
     private int impressions;
     private int clicks;
     private int plid;
     private int eventtypeid;


    // Constructors

    /** default constructor */
    public Bannertraffic() {
    }

	/** minimal constructor */
    public Bannertraffic(int bannertrafficid) {
        this.bannertrafficid = bannertrafficid;
    }
    
    /** full constructor */
    public Bannertraffic(int bannertrafficid, Integer bannerid, Date date, Integer impressions, Integer clicks, Integer plid, Integer eventtypeid) {
        this.bannertrafficid = bannertrafficid;
        this.bannerid = bannerid;
        this.date = date;
        this.impressions = impressions;
        this.clicks = clicks;
        this.plid = plid;
        this.eventtypeid = eventtypeid;
    }
    

   
    // Property accessors

    public int getBannertrafficid() {
        return this.bannertrafficid;
    }
    
    public void setBannertrafficid(int bannertrafficid) {
        this.bannertrafficid = bannertrafficid;
    }

    public int getBannerid() {
        return this.bannerid;
    }
    
    public void setBannerid(int bannerid) {
        this.bannerid = bannerid;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public int getImpressions() {
        return this.impressions;
    }
    
    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public int getClicks() {
        return this.clicks;
    }
    
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getPlid() {
        return this.plid;
    }
    
    public void setPlid(int plid) {
        this.plid = plid;
    }

    public int getEventtypeid() {
        return this.eventtypeid;
    }
    
    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }
   








}
