package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version123ToVersion124 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megafield DROP upperleftx");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE megafield DROP upperlefty");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE megafield DROP lowerrightx");
            //-----------------------------------
            //-----------------------------------
            
            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("ALTER TABLE megafield DROP lowerrighty");
            //-----------------------------------
            //-----------------------------------


    }


}
