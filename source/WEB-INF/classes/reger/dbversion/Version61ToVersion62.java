package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version61ToVersion62 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `savedsearch` (`savedsearchid` int(11) NOT NULL auto_increment, name varchar(255), accountid int(11), lastx int(11), lastxunits int(11), daterange int(11), datefromgmt datetime, datetogmt datetime, PRIMARY KEY  (`savedsearchid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("CREATE TABLE `savedsearchfqe` (`savedsearchfqeid` int(11) NOT NULL auto_increment, megafieldid int(11), paramname varchar(255), paramvalue varchar(255),  PRIMARY KEY  (`savedsearchfqeid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `savedsearchlog` (`savedsearchlogid` int(11) NOT NULL auto_increment, savedsearchid int(11), logid int(11),  PRIMARY KEY  (`savedsearchlogid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            


    }


}
