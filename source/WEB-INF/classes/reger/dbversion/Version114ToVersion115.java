package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version114ToVersion115 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `pagenotfound` (`pagenotfoundid` int(11) NOT NULL auto_increment, `pagename` varchar(255) default NULL, `count` int(11), PRIMARY KEY  (`pagenotfoundid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `trafficbypage` (`trafficbypageid` int(11) NOT NULL auto_increment, `pagename` varchar(255) default NULL, `count` int(11), PRIMARY KEY  (`trafficbypageid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
