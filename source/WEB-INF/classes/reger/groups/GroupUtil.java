package reger.groups;

import reger.Accountuser;
import reger.core.db.Db;


public class GroupUtil {

    public static boolean canAccountuserReadGroup(Accountuser au, Group group){
        if (!group.getEntriesareprivate()){
            return true;    
        }
        if (group.getAccountuserid()==au.getAccountuserid()){
            return true;
        }
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE accountuserid='"+au.getAccountuserid()+"' AND groupid='"+group.getGroupid()+"' AND isapproved='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            return true;
        }
        return false;
    }


}
