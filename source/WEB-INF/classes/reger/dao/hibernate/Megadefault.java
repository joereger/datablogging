package reger.dao.hibernate;
// Generated Mar 7, 2006 3:42:46 PM by Hibernate Tools 3.1.0.beta4



/**
 * Megadefault generated by hbm2java
 */

public class Megadefault  implements java.io.Serializable {


    // Fields    

     private int megadefaultid;
     private int logid;
     private int megafieldid;
     private String megadefault;
     private String megadefaultextended;


    // Constructors

    /** default constructor */
    public Megadefault() {
    }

	/** minimal constructor */
    public Megadefault(int megadefaultid) {
        this.megadefaultid = megadefaultid;
    }
    
    /** full constructor */
    public Megadefault(int megadefaultid, Integer logid, Integer megafieldid, String megadefault, String megadefaultextended) {
        this.megadefaultid = megadefaultid;
        this.logid = logid;
        this.megafieldid = megafieldid;
        this.megadefault = megadefault;
        this.megadefaultextended = megadefaultextended;
    }
    

   
    // Property accessors

    public int getMegadefaultid() {
        return this.megadefaultid;
    }
    
    public void setMegadefaultid(int megadefaultid) {
        this.megadefaultid = megadefaultid;
    }

    public int getLogid() {
        return this.logid;
    }
    
    public void setLogid(int logid) {
        this.logid = logid;
    }

    public int getMegafieldid() {
        return this.megafieldid;
    }
    
    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }

    public String getMegadefault() {
        return this.megadefault;
    }
    
    public void setMegadefault(String megadefault) {
        this.megadefault = megadefault;
    }

    public String getMegadefaultextended() {
        return this.megadefaultextended;
    }
    
    public void setMegadefaultextended(String megadefaultextended) {
        this.megadefaultextended = megadefaultextended;
    }
   








}
