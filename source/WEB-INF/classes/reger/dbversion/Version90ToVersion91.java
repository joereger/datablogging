package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version90ToVersion91 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE accountuser SET createdate=Now() WHERE createdate='0000-00-00 00:00:00'");
            //-----------------------------------
            //-----------------------------------

            


    }


}
