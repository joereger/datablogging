package reger.dao;
// Generated Mar 7, 2006 3:43:16 PM by Hibernate Tools 3.1.0.beta4



/**
 * Friendinvitationlogid generated by hbm2java
 */

public class Friendinvitationlogid  implements java.io.Serializable {


    // Fields    

     private int friendinvitationlogidid;
     private int friendinvitationid;
     private int logid;
     private boolean canread;
     private boolean canwrite;


    // Constructors

    /** default constructor */
    public Friendinvitationlogid() {
    }

	/** minimal constructor */
    public Friendinvitationlogid(int friendinvitationlogidid, int friendinvitationid, int logid) {
        this.friendinvitationlogidid = friendinvitationlogidid;
        this.friendinvitationid = friendinvitationid;
        this.logid = logid;
    }
    
    /** full constructor */
    public Friendinvitationlogid(int friendinvitationlogidid, int friendinvitationid, int logid, boolean canread, boolean canwrite) {
        this.friendinvitationlogidid = friendinvitationlogidid;
        this.friendinvitationid = friendinvitationid;
        this.logid = logid;
        this.canread = canread;
        this.canwrite = canwrite;
    }
    

   
    // Property accessors

    public int getFriendinvitationlogidid() {
        return this.friendinvitationlogidid;
    }
    
    public void setFriendinvitationlogidid(int friendinvitationlogidid) {
        this.friendinvitationlogidid = friendinvitationlogidid;
    }

    public int getFriendinvitationid() {
        return this.friendinvitationid;
    }
    
    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }

    public int getLogid() {
        return this.logid;
    }
    
    public void setLogid(int logid) {
        this.logid = logid;
    }

    public boolean getCanread() {
        return this.canread;
    }
    
    public void setCanread(boolean canread) {
        this.canread = canread;
    }

    public boolean getCanwrite() {
        return this.canwrite;
    }
    
    public void setCanwrite(boolean canwrite) {
        this.canwrite = canwrite;
    }
   








}
