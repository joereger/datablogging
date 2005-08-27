package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version30ToVersion31 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `groupserversubscription` (`groupserversubscriptionid` int(11) NOT NULL auto_increment, `accountuserid` int(11) NOT NULL, `serverurl` varchar(255) NOT NULL, `serverusername` varchar(255) NOT NULL, `serverpassword` varchar(255) NOT NULL, PRIMARY KEY  (`groupserversubscriptionid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `groupsubscription` (`groupsubscriptionid` int(11) NOT NULL auto_increment, `accountuserid` int(11) NOT NULL, `groupserversubscriptionid` int(11) NOT NULL, `groupid` int(11) NOT NULL, `groupname` varchar(255) NOT NULL, `groupdescription` varchar(255), PRIMARY KEY  (`groupsubscriptionid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
