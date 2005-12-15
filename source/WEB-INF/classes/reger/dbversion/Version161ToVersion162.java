package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version161ToVersion162 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `accountuserpladmin` (`accountuserpladminid` int(11) NOT NULL auto_increment, `accountuserid` int(11) NOT NULL, `plid` int(11),  PRIMARY KEY  (`accountuserpladminid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------
    }


}
