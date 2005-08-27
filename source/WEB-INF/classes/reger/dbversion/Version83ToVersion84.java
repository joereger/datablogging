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
public class Version83ToVersion84 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("DROP TABLE homepageconfig");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2s = Db.RunSQLUpdate("DROP TABLE homepageconfigobject");
            //-----------------------------------
            //-----------------------------------



    }


}
