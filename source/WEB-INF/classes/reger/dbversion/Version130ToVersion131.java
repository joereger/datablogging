package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version130ToVersion131 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE megafield SET megadatatypeid='1' WHERE fieldtype='7'");
            //-----------------------------------
            //-----------------------------------





    }




}
