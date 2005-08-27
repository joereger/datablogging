package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version84ToVersion85 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------


            


    }


}
