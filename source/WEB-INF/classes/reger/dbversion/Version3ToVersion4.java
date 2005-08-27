package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version3ToVersion4 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE message ADD email varchar(255) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE message ADD ipaddress varchar(50) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE message ADD url varchar(255) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE message ADD emailnotify int(11) default NULL");
            //-----------------------------------
            //-----------------------------------



    }


}
