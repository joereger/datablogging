package reger.dao.hibernate;

import java.util.Set;
import java.util.HashSet;
// Generated Mar 7, 2006 3:43:02 PM by Hibernate Tools 3.1.0.beta4



/**
 * Polarhrm generated by hbm2java
 */

public class Polarhrm  implements java.io.Serializable {


    // Fields    

     private int polarhrmid;
     private int imageid;


    //Association
    private Set<Polarhrmdata> polarhrmdatas = new HashSet<Polarhrmdata>();
    public Set<Polarhrmdata> getPolarhrmdatas() {
        return polarhrmdatas;
    }
    public void setPolarhrmdatas(Set<Polarhrmdata> polarhrmdatas) {
        this.polarhrmdatas = polarhrmdatas;
    }

    // Constructors

    /** default constructor */
    public Polarhrm() {
    }

    
    /** full constructor */
    public Polarhrm(int polarhrmid, int imageid) {
        this.polarhrmid = polarhrmid;
        this.imageid = imageid;
    }
    

   
    // Property accessors

    public int getPolarhrmid() {
        return this.polarhrmid;
    }
    
    public void setPolarhrmid(int polarhrmid) {
        this.polarhrmid = polarhrmid;
    }

    public int getImageid() {
        return this.imageid;
    }
    
    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
   








}
