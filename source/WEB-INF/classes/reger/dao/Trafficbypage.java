package reger.dao;
// Generated Mar 7, 2006 3:43:17 PM by Hibernate Tools 3.1.0.beta4



/**
 * Trafficbypage generated by hbm2java
 */

public class Trafficbypage  implements java.io.Serializable {


    // Fields    

     private int trafficbypageid;
     private String pagename;
     private int count;


    // Constructors

    /** default constructor */
    public Trafficbypage() {
    }

	/** minimal constructor */
    public Trafficbypage(int trafficbypageid) {
        this.trafficbypageid = trafficbypageid;
    }
    
    /** full constructor */
    public Trafficbypage(int trafficbypageid, String pagename, Integer count) {
        this.trafficbypageid = trafficbypageid;
        this.pagename = pagename;
        this.count = count;
    }
    

   
    // Property accessors

    public int getTrafficbypageid() {
        return this.trafficbypageid;
    }
    
    public void setTrafficbypageid(int trafficbypageid) {
        this.trafficbypageid = trafficbypageid;
    }

    public String getPagename() {
        return this.pagename;
    }
    
    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
   








}