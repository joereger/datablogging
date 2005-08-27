package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version4ToVersion5 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Add the timeperiod table
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `timeperiod` (`timeperiodid` int(11) NOT NULL auto_increment, `accountid` int(11) NOT NULL default '0', `startdate` datetime, `enddate` datetime, `description` longtext, `isprivate` int(11) NOT NULL default '1', `title` varchar(255) default NULL, `isopenended` int(11) NOT NULL default '1', PRIMARY KEY  (`timeperiodid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
