package reger.dao.hibernate;
// Generated Mar 7, 2006 3:42:51 PM by Hibernate Tools 3.1.0.beta4



/**
 * Offensivecontentpl generated by hbm2java
 */

public class Offensivecontentpl  implements java.io.Serializable {


    // Fields    

     private int offensivecontentplid;
     private int plid;
     private String content;


    // Constructors

    /** default constructor */
    public Offensivecontentpl() {
    }

	/** minimal constructor */
    public Offensivecontentpl(int offensivecontentplid, int plid) {
        this.offensivecontentplid = offensivecontentplid;
        this.plid = plid;
    }
    
    /** full constructor */
    public Offensivecontentpl(int offensivecontentplid, int plid, String content) {
        this.offensivecontentplid = offensivecontentplid;
        this.plid = plid;
        this.content = content;
    }
    

   
    // Property accessors

    public int getOffensivecontentplid() {
        return this.offensivecontentplid;
    }
    
    public void setOffensivecontentplid(int offensivecontentplid) {
        this.offensivecontentplid = offensivecontentplid;
    }

    public int getPlid() {
        return this.plid;
    }
    
    public void setPlid(int plid) {
        this.plid = plid;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}