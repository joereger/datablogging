package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version115ToVersion116 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE pagenotfound ADD mostrecentreferer varchar(255)");
            //-----------------------------------
            //-----------------------------------





    }


}
