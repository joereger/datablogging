package reger.dao;
// Generated Mar 7, 2006 3:43:25 PM by Hibernate Tools 3.1.0.beta4



/**
 * Tagimagelink generated by hbm2java
 */

public class Tagimagelink  implements java.io.Serializable {


    // Fields    

     private int tagimagelinkid;
     private int imageid;
     private int tagid;


    // Constructors

    /** default constructor */
    public Tagimagelink() {
    }

    
    /** full constructor */
    public Tagimagelink(int tagimagelinkid, int imageid, int tagid) {
        this.tagimagelinkid = tagimagelinkid;
        this.imageid = imageid;
        this.tagid = tagid;
    }
    

   
    // Property accessors

    public int getTagimagelinkid() {
        return this.tagimagelinkid;
    }
    
    public void setTagimagelinkid(int tagimagelinkid) {
        this.tagimagelinkid = tagimagelinkid;
    }

    public int getImageid() {
        return this.imageid;
    }
    
    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public int getTagid() {
        return this.tagid;
    }
    
    public void setTagid(int tagid) {
        this.tagid = tagid;
    }
   








}
