package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version24ToVersion25 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int aclgroupid = Db.RunSQLInsert("INSERT INTO aclgroup(aclgroupname) VALUES('PLAdmin')");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            String[][] rstPladmin= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectname='PLADMIN'");
            //-----------------------------------
            //-----------------------------------
            int aclobjectid=0;
            if (rstPladmin!=null && rstPladmin.length>0){
                aclobjectid=Integer.parseInt(rstPladmin[0][0]);
            }

            //-----------------------------------
            //-----------------------------------
            int aclgroupmembershipgrantsid = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('"+aclgroupid+"', '"+aclobjectid+"')");
            //-----------------------------------
            //-----------------------------------





    }


}
