package reger.dao.hibernate;
// Generated Mar 7, 2006 3:43:03 PM by Hibernate Tools 3.1.0.beta4



/**
 * Favesite generated by hbm2java
 */

public class Favesite  implements java.io.Serializable {


    // Fields    

     private int favesiteid;
     private String name;
     private String url;
     private int accountid;


    // Constructors

    /** default constructor */
    public Favesite() {
    }

    
    /** full constructor */
    public Favesite(int favesiteid, String name, String url, int accountid) {
        this.favesiteid = favesiteid;
        this.name = name;
        this.url = url;
        this.accountid = accountid;
    }
    

   
    // Property accessors

    public int getFavesiteid() {
        return this.favesiteid;
    }
    
    public void setFavesiteid(int favesiteid) {
        this.favesiteid = favesiteid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public int getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }
   








}
