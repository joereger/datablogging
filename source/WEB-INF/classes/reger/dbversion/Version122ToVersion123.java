package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version122ToVersion123 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `systemmessage` (`systemmessageid` int(11) NOT NULL auto_increment, `systemmessage` longtext, `islive` int(11), `autooldonrestart` int(11), `showtologgedinusers` int(11), `showtonotloggedinusers` int(11), `date` datetime NOT NULL default '0000-00-00 00:00:00', PRIMARY KEY  (`systemmessageid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
