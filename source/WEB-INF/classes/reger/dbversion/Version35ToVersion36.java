package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version35ToVersion36 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `eventtogroup` (`eventtogroupid` int(11) NOT NULL auto_increment, `eventid` int(11) NOT NULL, `groupsubscriptionid` int(11) NOT NULL, `controlkey` varchar(255),  PRIMARY KEY  (`eventtogroupid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------



    }


}
