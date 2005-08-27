package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version25ToVersion26 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `groups` (`groupid` int(11) NOT NULL auto_increment, `groupname` varchar(255) NOT NULL default 'Group', `groupdescription` varchar(255), PRIMARY KEY  (`groupid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `groupentry` (`groupentryid` int(11) NOT NULL auto_increment, `groupid` int(11) NOT NULL, `entryurl` varchar(255), PRIMARY KEY  (`groupentryid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------



    }


}
