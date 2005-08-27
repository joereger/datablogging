package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version118ToVersion119 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `friendinvitationeventtypeid` (`friendinvitationeventtypeidid` int(11) NOT NULL auto_increment, `friendinvitationid` int(11) NOT NULL default '0', `eventtypeid` int(11) NOT NULL default '0', `accountidofpersoninvited` int(11) NOT NULL default '0', PRIMARY KEY  (`friendinvitationeventtypeidid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
