package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version69ToVersion70 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `megafielduser` (`megafielduserid` int(11) NOT NULL auto_increment, logid int(11), megafieldid int(11), upperleftx int(11), upperlefty int(11), lowerrightx int(11), lowerrighty int(11), fieldname varchar(50), fielddescription varchar(255), isrequired int(11), PRIMARY KEY  (`megafielduserid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            


    }


}
