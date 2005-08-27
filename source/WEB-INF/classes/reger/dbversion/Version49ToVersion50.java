package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version49ToVersion50 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Make sure all LOEAdmins are also site owners.
            //-----------------------------------
            //-----------------------------------
            String[][] rstAcctusers= Db.RunSQL("SELECT accountuser.accountuserid, accountuser.accountid FROM accountuser, accountuseraclgroup WHERE accountuser.accountuserid=accountuseraclgroup.accountuserid and (accountuseraclgroup.aclgroupid='2' OR accountuseraclgroup.aclgroupid='3');");
            //-----------------------------------
            //-----------------------------------
            if (rstAcctusers!=null && rstAcctusers.length>0){
            	for(int i=0; i<rstAcctusers.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstGroup= Db.RunSQL("SELECT accountuseraclgroupid FROM accountuseraclgroup WHERE accountuserid='"+rstAcctusers[i][0]+"' AND aclgroupid='1'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstGroup!=null && rstGroup.length>0){
                        //Do nothing, the user is already a site owner
                    } else {
                        //-----------------------------------
                        //-----------------------------------
                        int identity = Db.RunSQLInsert("INSERT INTO accountuseraclgroup(accountuserid, aclgroupid, accountid) VALUES('"+rstAcctusers[i][0]+"', '1', '"+rstAcctusers[i][1]+"')");
                        //-----------------------------------
                        //-----------------------------------
                    }
            	}
            }



    }


}
