package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version116ToVersion117 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `plpeer` (`plpeerid` int(11) NOT NULL auto_increment, `plid` int(11) NOT NULL default '0', `peerplid` int(11) NOT NULL default '0', PRIMARY KEY  (`plpeerid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
