package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version8ToVersion9 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE event ADD ismoderatorapproved int(11) NOT NULL default '1'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            //int count1 = Db.RunSQLUpdate("ALTER TABLE event ADD moderatoraccountuserid int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE event ADD lastmodifiedbyuserdate datetime default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            //int count3 = Db.RunSQLUpdate("ALTER TABLE event ADD lastmodifiedbymoderatordate datetime default NULL");
            //-----------------------------------
            //-----------------------------------



    }


}
