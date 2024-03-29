package reger.dao;
// Generated Mar 7, 2006 3:43:02 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


/**
 * Savedsearch generated by hbm2java
 */

public class Savedsearch  implements java.io.Serializable {


    // Fields    

     private int savedsearchid;
     private String name;
     private int accountid;
     private int lastx;
     private int lastxunits;
     private int daterange;
     private Date datefromgmt;
     private Date datetogmt;
     private String searchterms;


    //Association
    private Set<Savedsearchaccount> savedsearchaccounts = new HashSet<Savedsearchaccount>();
    public Set<Savedsearchaccount> getSavedsearchaccounts() {
        return savedsearchaccounts;
    }
    public void setSavedsearchaccounts(Set<Savedsearchaccount> savedsearchaccounts) {
        this.savedsearchaccounts = savedsearchaccounts;
    }

    //Association
    private Set<Savedsearcheventtype> savedsearcheventtypes = new HashSet<Savedsearcheventtype>();
    public Set<Savedsearcheventtype> getSavedsearcheventtypes() {
        return savedsearcheventtypes;
    }
    public void setSavedsearcheventtypes(Set<Savedsearcheventtype> savedsearcheventtypes) {
        this.savedsearcheventtypes = savedsearcheventtypes;
    }

    //Association
    private Set<Savedsearchfqe> savedsearchfqes = new HashSet<Savedsearchfqe>();
    public Set<Savedsearchfqe> getSavedsearchfqes() {
        return savedsearchfqes;
    }
    public void setSavedsearchfqes(Set<Savedsearchfqe> savedsearchfqes) {
        this.savedsearchfqes = savedsearchfqes;
    }

    //Association
    private Set<Savedsearchlocation> savedsearchlocations = new HashSet<Savedsearchlocation>();
    public Set<Savedsearchlocation> getSavedsearchlocations() {
        return savedsearchlocations;
    }
    public void setSavedsearchlocations(Set<Savedsearchlocation> savedsearchlocations) {
        this.savedsearchlocations = savedsearchlocations;
    }

    //Association
    private Set<Savedsearchlog> savedsearchlogs = new HashSet<Savedsearchlog>();
    public Set<Savedsearchlog> getSavedsearchlogs() {
        return savedsearchlogs;
    }
    public void setSavedsearchlogs(Set<Savedsearchlog> savedsearchlogs) {
        this.savedsearchlogs = savedsearchlogs;
    }

    // Constructors

    /** default constructor */
    public Savedsearch() {
    }

    /** minimal constructor */
    public Savedsearch(int savedsearchid) {
        this.savedsearchid = savedsearchid;
    }

    /** full constructor */
    public Savedsearch(int savedsearchid, String name, Integer accountid, Integer lastx, Integer lastxunits, Integer daterange, Date datefromgmt, Date datetogmt, String searchterms) {
        this.savedsearchid = savedsearchid;
        this.name = name;
        this.accountid = accountid;
        this.lastx = lastx;
        this.lastxunits = lastxunits;
        this.daterange = daterange;
        this.datefromgmt = datefromgmt;
        this.datetogmt = datetogmt;
        this.searchterms = searchterms;
    }



    // Property accessors

    public int getSavedsearchid() {
        return this.savedsearchid;
    }

    public void setSavedsearchid(int savedsearchid) {
        this.savedsearchid = savedsearchid;
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

    public int getLastx() {
        return this.lastx;
    }

    public void setLastx(int lastx) {
        this.lastx = lastx;
    }

    public int getLastxunits() {
        return this.lastxunits;
    }

    public void setLastxunits(int lastxunits) {
        this.lastxunits = lastxunits;
    }

    public int getDaterange() {
        return this.daterange;
    }

    public void setDaterange(int daterange) {
        this.daterange = daterange;
    }

    public Date getDatefromgmt() {
        return this.datefromgmt;
    }

    public void setDatefromgmt(Date datefromgmt) {
        this.datefromgmt = datefromgmt;
    }

    public Date getDatetogmt() {
        return this.datetogmt;
    }

    public void setDatetogmt(Date datetogmt) {
        this.datetogmt = datetogmt;
    }

    public String getSearchterms() {
        return this.searchterms;
    }

    public void setSearchterms(String searchterms) {
        this.searchterms = searchterms;
    }









}
