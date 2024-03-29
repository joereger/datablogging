package reger.dao;
// Generated Mar 7, 2006 3:42:58 PM by Hibernate Tools 3.1.0.beta4



/**
 * Banner generated by hbm2java
 */

public class Banner  implements java.io.Serializable {


    // Fields    

     private int bannerid;
     private String url;
     private String filename;
     private int width;
     private int height;
     private boolean active;
     private int impressions;


    // Constructors

    /** default constructor */
    public Banner() {
    }

	/** minimal constructor */
    public Banner(int bannerid) {
        this.bannerid = bannerid;
    }
    
    /** full constructor */
    public Banner(int bannerid, String url, String filename, Integer width, Integer height, boolean active, Integer impressions) {
        this.bannerid = bannerid;
        this.url = url;
        this.filename = filename;
        this.width = width;
        this.height = height;
        this.active = active;
        this.impressions = impressions;
    }
    

   
    // Property accessors

    public int getBannerid() {
        return this.bannerid;
    }
    
    public void setBannerid(int bannerid) {
        this.bannerid = bannerid;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getWidth() {
        return this.width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    public int getImpressions() {
        return this.impressions;
    }
    
    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }
   








}
