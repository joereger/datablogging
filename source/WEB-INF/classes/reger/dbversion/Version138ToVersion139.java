package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version138ToVersion139 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){



        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("CREATE TABLE `systemlicense` (`systemlicenseid` int(11) NOT NULL auto_increment, encryptedlicense text, PRIMARY KEY  (`systemlicenseid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------



    }

}
