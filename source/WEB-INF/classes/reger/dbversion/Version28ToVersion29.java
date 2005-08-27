package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version28ToVersion29 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `accountuserpersistentlogin` (`accountuserpersistentloginid` int(11) NOT NULL auto_increment, `accountuserid` int(11) NOT NULL, `randomstring` varchar(255) NOT NULL, `lastusedtologin` datetime, PRIMARY KEY  (`accountuserpersistentloginid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
