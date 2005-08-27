package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version107ToVersion108 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE megalog ADD nestednavparenttype int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megalog ADD nestednavparentid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE megalog ADD nestednavorder int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `contentpage` (`contentpageid` int(11) NOT NULL auto_increment, `accountid` int(11) NOT NULL, `name` varchar(255), content longtext, nestednavparenttype int(11) NOT NULL default '0', nestednavparentid int(11) NOT NULL default '0', nestednavorder int(11) NOT NULL default '0',  PRIMARY KEY  (`contentpageid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
