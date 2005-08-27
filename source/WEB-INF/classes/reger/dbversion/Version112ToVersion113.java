package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version112ToVersion113 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE event SET locationid='0' WHERE locationid='1'");
            //-----------------------------------
            //-----------------------------------




    }


}
