package reger.groups;

import reger.core.db.Db;
import reger.core.ValidationException;

/**
 * Represents a single group membership
 */
public class GroupMembership {

    private int groupmembershipid = 0;
    private int accountuserid = 0;
    private int groupid = 0;
    private boolean sharemembershippublicly = true;
    private boolean isapproved = true;
    private boolean ismoderator = false;


    public GroupMembership (int groupmembershipid){
        this.groupmembershipid = groupmembershipid;
        load();
    }

    public GroupMembership(){
        
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid, accountuserid, groupid, sharemembershippublicly, isapproved, ismoderator FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            groupmembershipid = Integer.parseInt(rstData[0][0]);
            accountuserid = Integer.parseInt(rstData[0][1]);
            groupid = Integer.parseInt(rstData[0][2]);
            sharemembershippublicly = reger.core.Util.booleanFromSQLText(rstData[0][3]);
            isapproved = reger.core.Util.booleanFromSQLText(rstData[0][4]);
            ismoderator = reger.core.Util.booleanFromSQLText(rstData[0][5]);
        }
    }

    public void save() throws ValidationException{
        try{
            validate();
        } catch (ValidationException vex){
            throw vex;
        }
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE groupmembership SET accountuserid='"+accountuserid+"', groupid='"+groupid+"', sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"' WHERE groupmembershipid='"+groupmembershipid+"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            groupid = Db.RunSQLInsert("INSERT INTO groupmembership(accountuserid, groupid, sharemembershippublicly, isapproved, ismoderator) VALUES('"+accountuserid+"', '"+groupid+"', '"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"', '"+reger.core.Util.booleanAsSQLText(ismoderator)+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    private void validate() throws ValidationException {
        ValidationException vex = new ValidationException();
        if(accountuserid==0){
            vex.addValidationError("Sorry, a system error has occurred.  The accountuserid was not properly set.");
        }
        if(groupid==0){
            vex.addValidationError("Sorry, a system error has occurred.  The groupid was not properly set.");
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }

    public int getGroupmembershipid() {
        return groupmembershipid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public boolean getSharemembershippublicly() {
        return sharemembershippublicly;
    }

    public void setSharemembershippublicly(boolean sharemembershippublicly) {
        this.sharemembershippublicly = sharemembershippublicly;
    }

    public boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }

    public boolean getIsmoderator() {
        return ismoderator;
    }

    public void setIsmoderator(boolean ismoderator) {
        this.ismoderator = ismoderator;
    }

}
