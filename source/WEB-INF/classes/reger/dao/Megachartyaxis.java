package reger.dao;
// Generated Mar 7, 2006 3:43:09 PM by Hibernate Tools 3.1.0.beta4



/**
 * Megachartyaxis generated by hbm2java
 */

public class Megachartyaxis  implements java.io.Serializable {


    // Fields    

     private int megachartyaxisid;
     private int megachartid;
     private int ymegafieldid;
     private int ylogid;
     private int yeventtypeid;


    // Constructors

    /** default constructor */
    public Megachartyaxis() {
    }

    
    /** full constructor */
    public Megachartyaxis(int megachartyaxisid, int megachartid, int ymegafieldid, int ylogid, int yeventtypeid) {
        this.megachartyaxisid = megachartyaxisid;
        this.megachartid = megachartid;
        this.ymegafieldid = ymegafieldid;
        this.ylogid = ylogid;
        this.yeventtypeid = yeventtypeid;
    }
    

   
    // Property accessors

    public int getMegachartyaxisid() {
        return this.megachartyaxisid;
    }
    
    public void setMegachartyaxisid(int megachartyaxisid) {
        this.megachartyaxisid = megachartyaxisid;
    }

    public int getMegachartid() {
        return this.megachartid;
    }
    
    public void setMegachartid(int megachartid) {
        this.megachartid = megachartid;
    }

    public int getYmegafieldid() {
        return this.ymegafieldid;
    }
    
    public void setYmegafieldid(int ymegafieldid) {
        this.ymegafieldid = ymegafieldid;
    }

    public int getYlogid() {
        return this.ylogid;
    }
    
    public void setYlogid(int ylogid) {
        this.ylogid = ylogid;
    }

    public int getYeventtypeid() {
        return this.yeventtypeid;
    }
    
    public void setYeventtypeid(int yeventtypeid) {
        this.yeventtypeid = yeventtypeid;
    }
   








}
