package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version106ToVersion107 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE pl ADD showbusinesstab int(11) NOT NULL default '1'");
            //-----------------------------------
            //-----------------------------------






    }


}
