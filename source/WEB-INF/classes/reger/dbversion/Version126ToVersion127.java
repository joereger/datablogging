package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version126ToVersion127 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megafield DROP isvisible");
            //-----------------------------------
            //-----------------------------------




    }


}
