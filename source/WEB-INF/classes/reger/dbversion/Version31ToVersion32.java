package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version31ToVersion32 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE groupsubscription ADD feedurlofgroup varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int countd = Db.RunSQLUpdate("ALTER TABLE groupsubscription ADD weburlofgroup varchar(255)");
            //-----------------------------------
            //-----------------------------------



    }


}
