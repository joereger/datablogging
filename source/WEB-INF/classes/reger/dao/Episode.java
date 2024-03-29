package reger.dao;
// Generated Mar 7, 2006 3:43:10 PM by Hibernate Tools 3.1.0.beta4



/**
 * Episode generated by hbm2java
 */

public class Episode  implements java.io.Serializable {


    // Fields    

     private int episodeid;
     private String name;
     private int accountid;
     private String description;
     private boolean isprivate;


    // Constructors

    /** default constructor */
    public Episode() {
    }

	/** minimal constructor */
    public Episode(int episodeid) {
        this.episodeid = episodeid;
    }
    
    /** full constructor */
    public Episode(int episodeid, String name, Integer accountid, String description, boolean isprivate) {
        this.episodeid = episodeid;
        this.name = name;
        this.accountid = accountid;
        this.description = description;
        this.isprivate = isprivate;
    }
    

   
    // Property accessors

    public int getEpisodeid() {
        return this.episodeid;
    }
    
    public void setEpisodeid(int episodeid) {
        this.episodeid = episodeid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsprivate() {
        return this.isprivate;
    }
    
    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }
   








}
