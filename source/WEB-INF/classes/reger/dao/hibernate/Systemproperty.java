package reger.dao.hibernate;
// Generated Mar 7, 2006 3:42:50 PM by Hibernate Tools 3.1.0.beta4



/**
 * Systemproperty generated by hbm2java
 */

public class Systemproperty  implements java.io.Serializable {


    // Fields    

     private int systempropertyid;
     private String propertyname;
     private String propertyvalue;


    // Constructors

    /** default constructor */
    public Systemproperty() {
    }

	/** minimal constructor */
    public Systemproperty(int systempropertyid) {
        this.systempropertyid = systempropertyid;
    }
    
    /** full constructor */
    public Systemproperty(int systempropertyid, String propertyname, String propertyvalue) {
        this.systempropertyid = systempropertyid;
        this.propertyname = propertyname;
        this.propertyvalue = propertyvalue;
    }
    

   
    // Property accessors

    public int getSystempropertyid() {
        return this.systempropertyid;
    }
    
    public void setSystempropertyid(int systempropertyid) {
        this.systempropertyid = systempropertyid;
    }

    public String getPropertyname() {
        return this.propertyname;
    }
    
    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getPropertyvalue() {
        return this.propertyvalue;
    }
    
    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue;
    }
   








}