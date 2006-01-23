package reger.groups;

import reger.core.db.Db;
import reger.core.ValidationException;

/**
 * Represents a single group
 */
public class Group {

    private int groupid = 0;
    private String name = "";
    private String description = "";
    private boolean entriesareprivate = false;
    private boolean membershipismoderated = false;
    private int plid = 0;
    private int accountuserid = 0;

    public Group (int groupid){
        this.groupid = groupid;
        load();
    }

    public Group(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupid, name, description, entriesareprivate, membershipismoderated, plid, accountuserid FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            groupid = Integer.parseInt(rstData[0][0]);
            name = rstData[0][1];
            description = rstData[0][2];
            entriesareprivate = reger.core.Util.booleanFromSQLText(rstData[0][3]);
            membershipismoderated = reger.core.Util.booleanFromSQLText(rstData[0][4]);
            plid = Integer.parseInt(rstData[0][5]);
            accountuserid = Integer.parseInt(rstData[0][6]);
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
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE groups SET name='"+reger.core.Util.cleanForSQL(name)+"', description='"+reger.core.Util.cleanForSQL(description)+"', entriesareprivate='"+reger.core.Util.booleanAsSQLText(entriesareprivate)+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', plid='"+plid+"', accountuserid='"+accountuserid+"' WHERE groupid='"+groupid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            groupid = Db.RunSQLInsert("INSERT INTO groups(name, description, entriesareprivate, membershipismoderated, plid, accountuserid) VALUES('"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+reger.core.Util.booleanAsSQLText(entriesareprivate)+"', '"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', '"+plid+"', '"+accountuserid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    private void validate() throws ValidationException {
        ValidationException vex = new ValidationException();
        if (name==null || name.equals("")){
            vex.addValidationError("Group name can not be blank.");
        } else {
            //-----------------------------------
            //-----------------------------------
            String[][] rstData= reger.core.db.Db.RunSQL("SELECT groupid FROM groups WHERE name='"+reger.core.Util.cleanForSQL(name)+"' AND groupid<>'"+groupid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstData!=null && rstData.length>0){
                vex.addValidationError("Sorry, a group with that name already exists.  You may not be able to find it via search because it is private.  Please choose another name for your new group.");
            }
        }
        if (description==null){
            description="";
        }
        if(plid==0){
            vex.addValidationError("Sorry, a system error has occurred.  The plid was not properly set.");
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }

    public int getGroupid() {
        return groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEntriesareprivate() {
        return entriesareprivate;
    }

    public void setEntriesareprivate(boolean entriesareprivate) {
        this.entriesareprivate = entriesareprivate;
    }

    public boolean getMembershipismoderated() {
        return membershipismoderated;
    }

    public void setMembershipismoderated(boolean membershipismoderated) {
        this.membershipismoderated = membershipismoderated;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }
}
