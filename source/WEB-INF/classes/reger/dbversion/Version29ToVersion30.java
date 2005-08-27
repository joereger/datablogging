package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version29ToVersion30 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Add ACLObject for Groups
            //-----------------------------------
            //-----------------------------------
            int id2 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('25', '"+reger.core.Util.cleanForSQL("MANAGEGROUPS")+"', '"+reger.core.Util.cleanForSQL("Manage Groups Membership")+"', '"+reger.core.Util.cleanForSQL("The ability to create/edit/delete group membership and the ability to add a group server.")+"')");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int id2v = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('1', '25')");
            //-----------------------------------
            //-----------------------------------

            //Add ACLObject for Groups
            //-----------------------------------
            //-----------------------------------
            int id2a = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('26', '"+reger.core.Util.cleanForSQL("POSTENTRYTOGROUP")+"', '"+reger.core.Util.cleanForSQL("Post Entry to Group")+"', '"+reger.core.Util.cleanForSQL("The ability to assign a particular post to one or more groups.")+"')");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int id2ve = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('1', '26')");
            //-----------------------------------
            //-----------------------------------




    }


}
