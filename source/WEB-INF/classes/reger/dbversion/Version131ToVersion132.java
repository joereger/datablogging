package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version131ToVersion132 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE accountuserlogaccess ADD canread int(11) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE accountuserlogaccess ADD canwrite int(11) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canread='1'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canwrite='1'");
            //-----------------------------------
            //-----------------------------------





    }




}
