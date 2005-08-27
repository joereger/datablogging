package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version6ToVersion7 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE account ADD istimeperiodon int(11) NOT NULL default '1'");
            //-----------------------------------
            //-----------------------------------



    }


}
