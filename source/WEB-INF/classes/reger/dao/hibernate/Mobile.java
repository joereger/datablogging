package reger.dao.hibernate;
// Generated Mar 7, 2006 3:42:49 PM by Hibernate Tools 3.1.0.beta4



/**
 * Mobile generated by hbm2java
 */

public class Mobile  implements java.io.Serializable {


    // Fields    

     private int mobileid;
     private String xupsubno;
     private int accountuserid;


    // Constructors

    /** default constructor */
    public Mobile() {
    }

    
    /** full constructor */
    public Mobile(int mobileid, String xupsubno, int accountuserid) {
        this.mobileid = mobileid;
        this.xupsubno = xupsubno;
        this.accountuserid = accountuserid;
    }
    

   
    // Property accessors

    public int getMobileid() {
        return this.mobileid;
    }
    
    public void setMobileid(int mobileid) {
        this.mobileid = mobileid;
    }

    public String getXupsubno() {
        return this.xupsubno;
    }
    
    public void setXupsubno(String xupsubno) {
        this.xupsubno = xupsubno;
    }

    public int getAccountuserid() {
        return this.accountuserid;
    }
    
    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }
   








}
