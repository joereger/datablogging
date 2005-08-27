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
public class Version75ToVersion76 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Create a password backup field
            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE megafield ADD logid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //And backup the passwords, just in case
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megafield DROP issystemfield");
            //-----------------------------------
            //-----------------------------------



    }


}
