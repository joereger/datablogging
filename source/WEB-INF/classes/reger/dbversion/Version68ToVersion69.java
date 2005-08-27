package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version68ToVersion69 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE megafield ADD upperleftx int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE megafield ADD upperlefty int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megafield ADD lowerrightx int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE megafield ADD lowerrighty int(11)");
            //-----------------------------------
            //-----------------------------------

            

            

    }


}
