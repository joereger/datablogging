package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version9ToVersion10 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE event ADD isflaggedformoderator int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            //int count2 = Db.RunSQLUpdate("ALTER TABLE event ADD originaleventid int(11)");
            //-----------------------------------
            //-----------------------------------




    }


}
