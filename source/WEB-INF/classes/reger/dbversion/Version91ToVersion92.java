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
public class Version91ToVersion92 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE templatenew SET name='Template' WHERE name=''");
            //-----------------------------------
            //-----------------------------------

            


    }


}
