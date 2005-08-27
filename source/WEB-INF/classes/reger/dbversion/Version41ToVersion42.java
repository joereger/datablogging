package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version41ToVersion42 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `friendinvitationlogid` (`friendinvitationlogidid` int(11) NOT NULL auto_increment, `friendinvitationid` int(11) NOT NULL, `logid` int(11) NOT NULL, PRIMARY KEY  (`friendinvitationlogidid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------


            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `friendinvitationgroupsubscriptionid` (`friendinvitationgroupsubscriptionidid` int(11) NOT NULL auto_increment, `friendinvitationid` int(11) NOT NULL, `groupsubscriptionid` int(11) NOT NULL, PRIMARY KEY  (`friendinvitationgroupsubscriptionidid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("CREATE TABLE `debuglevel` (`debuglevelid` int(11) NOT NULL auto_increment, `debuglevel` int(11) NOT NULL, PRIMARY KEY  (`debuglevelid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }


}
