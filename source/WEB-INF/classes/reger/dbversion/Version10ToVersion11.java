package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version10ToVersion11 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE event ADD requiresmoderatorapproval int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------



    }


}
