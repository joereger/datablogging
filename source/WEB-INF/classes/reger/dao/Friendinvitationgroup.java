package reger.dao;
// Generated Mar 7, 2006 3:43:05 PM by Hibernate Tools 3.1.0.beta4



/**
 * Friendinvitationgroup generated by hbm2java
 */

public class Friendinvitationgroup  implements java.io.Serializable {


    // Fields    

     private int friendinvitationgroupid;
     private int friendinvitationid;
     private int groupid;


    // Constructors

    /** default constructor */
    public Friendinvitationgroup() {
    }

	/** minimal constructor */
    public Friendinvitationgroup(int friendinvitationgroupid) {
        this.friendinvitationgroupid = friendinvitationgroupid;
    }
    
    /** full constructor */
    public Friendinvitationgroup(int friendinvitationgroupid, Integer friendinvitationid, Integer groupid) {
        this.friendinvitationgroupid = friendinvitationgroupid;
        this.friendinvitationid = friendinvitationid;
        this.groupid = groupid;
    }
    

   
    // Property accessors

    public int getFriendinvitationgroupid() {
        return this.friendinvitationgroupid;
    }
    
    public void setFriendinvitationgroupid(int friendinvitationgroupid) {
        this.friendinvitationgroupid = friendinvitationgroupid;
    }

    public int getFriendinvitationid() {
        return this.friendinvitationid;
    }
    
    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }

    public int getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
   








}
