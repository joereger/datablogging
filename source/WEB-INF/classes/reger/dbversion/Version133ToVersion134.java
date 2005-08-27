package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version133ToVersion134 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `emailapiaddress` (`emailapiaddressid` int(11) NOT NULL auto_increment, `uniquekey` varchar(15) default NULL, `accountuserid` int(11) default NULL, `accountid` int(11) default NULL, `logid` int(11) default NULL, `emailtype` int(11) default NULL, PRIMARY KEY  (`emailapiaddressid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------



    }




}
