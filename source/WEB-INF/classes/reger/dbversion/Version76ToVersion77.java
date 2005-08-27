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
public class Version76ToVersion77 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //And backup the passwords, just in case
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megafield DROP fieldorder");
            //-----------------------------------
            //-----------------------------------




    }


}
