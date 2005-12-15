package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version160ToVersion161 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `plnavhide` (`plnavhideid` int(11) NOT NULL auto_increment, `plid` int(11) NOT NULL, `pljspidtohide` int(11),  PRIMARY KEY  (`plnavhideid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `plcontentoverride` (`plcontentoverrideid` int(11) NOT NULL auto_increment, `plid` int(11) NOT NULL, `pljspidtooverride` int(11), `content` longtext,  PRIMARY KEY  (`plcontentoverrideid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------
    }


}
