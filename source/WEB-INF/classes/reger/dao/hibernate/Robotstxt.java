package reger.dao.hibernate;
// Generated Mar 7, 2006 3:43:18 PM by Hibernate Tools 3.1.0.beta4



/**
 * Robotstxt generated by hbm2java
 */

public class Robotstxt  implements java.io.Serializable {


    // Fields    

     private int robotstxtid;
     private String robotstxt;


    // Constructors

    /** default constructor */
    public Robotstxt() {
    }

	/** minimal constructor */
    public Robotstxt(int robotstxtid) {
        this.robotstxtid = robotstxtid;
    }
    
    /** full constructor */
    public Robotstxt(int robotstxtid, String robotstxt) {
        this.robotstxtid = robotstxtid;
        this.robotstxt = robotstxt;
    }
    

   
    // Property accessors

    public int getRobotstxtid() {
        return this.robotstxtid;
    }
    
    public void setRobotstxtid(int robotstxtid) {
        this.robotstxtid = robotstxtid;
    }

    public String getRobotstxt() {
        return this.robotstxt;
    }
    
    public void setRobotstxt(String robotstxt) {
        this.robotstxt = robotstxt;
    }
   








}