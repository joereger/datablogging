package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version117ToVersion118 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------




    }


}
