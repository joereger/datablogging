package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version159ToVersion160 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `plcontentpage` (`plcontentpageid` int(11) NOT NULL auto_increment, `plid` int(11) NOT NULL, `name` varchar(255), content longtext, nestednavparenttype int(11) NOT NULL default '0', nestednavparentid int(11) NOT NULL default '0', nestednavorder int(11) NOT NULL default '0',  PRIMARY KEY  (`plcontentpageid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------
    }


}
