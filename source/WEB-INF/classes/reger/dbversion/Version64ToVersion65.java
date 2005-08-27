package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version64ToVersion65 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('1', '27')");
            //-----------------------------------
            //-----------------------------------

            


    }


}
