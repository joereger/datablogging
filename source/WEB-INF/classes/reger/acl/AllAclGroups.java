package reger.acl;

import reger.core.db.Db;
import reger.AddToArray;

/**
 * All acl groups.
 */
public class AllAclGroups {

    public static AclGroup[] allAclGroups;

    public AllAclGroups(){
        loadGroups();
    }

    private static void loadGroups(){
        allAclGroups = new AclGroup[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstAclGroup= Db.RunSQL("SELECT aclgroupid FROM aclgroup");
        //-----------------------------------
        //-----------------------------------
        if (rstAclGroup!=null && rstAclGroup.length>0){
        	for(int i=0; i<rstAclGroup.length; i++){
        	    AclGroup tmpAclGroup = new AclGroup(Integer.parseInt(rstAclGroup[i][0]));
                allAclGroups = AddToArray.addToAclGroupArray(allAclGroups, tmpAclGroup);
        	}
        }
    }

    public static AclGroup[] getAllAclGroups(){
        if (allAclGroups==null){
            loadGroups();
        }
        return allAclGroups;
    }

    public static AclGroup getAclGroupById(int aclgroupid){
        if (allAclGroups==null){
            loadGroups();
        }
        for (int i = 0; i < allAclGroups.length; i++) {
            if (allAclGroups[i].getAclgroupid()==aclgroupid){
                return allAclGroups[i];
            }
        }
        return null;
    }

    public static AclGroup getAclGroupByName(String aclgroupname){
        if (allAclGroups==null){
            loadGroups();
        }
        for (int i = 0; i < allAclGroups.length; i++) {
            if (allAclGroups[i].getAclgroupname().equals(aclgroupname)){
                return allAclGroups[i];
            }
        }
        return null;
    }


}
