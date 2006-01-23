package reger.groups;

import reger.core.db.Db;

/**
 * Represents a single event to group relationship
 */
public class FriendInvitationGroup {

    private int friendinvitationgroupid = 0;
    private int friendinvitationid = 0;
    private int groupid = 0;



    public FriendInvitationGroup (int friendinvitationgroupid){
        this.friendinvitationgroupid = friendinvitationgroupid;
        load();
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid, friendinvitationid, groupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            friendinvitationgroupid = Integer.parseInt(rstData[0][0]);
            friendinvitationid = Integer.parseInt(rstData[0][1]);
            groupid = Integer.parseInt(rstData[0][2]);
        }
    }
    
    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT friendinvitationgroupid FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE friendinvitationgroup SET friendinvitationid='"+friendinvitationid +"', groupid='"+groupid+"' WHERE friendinvitationgroupid='"+friendinvitationgroupid +"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            groupid = Db.RunSQLInsert("INSERT INTO friendinvitationgroup(friendinvitationid, groupid) VALUES('"+friendinvitationid +"', '"+groupid+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }
    
    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friendinvitationgroup WHERE friendinvitationgroupid='"+friendinvitationgroupid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getFriendinvitationgroupid() {
        return friendinvitationgroupid;
    }

    public int getFriendinvitationid() {
        return friendinvitationid;
    }

    public void setFriendinvitationid(int friendinvitationid) {
        this.friendinvitationid = friendinvitationid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

}
