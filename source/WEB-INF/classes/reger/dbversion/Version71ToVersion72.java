package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version71ToVersion72 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE pl ADD minpasswordchars int(11) NOT NULL default '5'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE pl ADD minpassworduppercasechars int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("ALTER TABLE pl ADD minpasswordlowercasechars int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE pl ADD minpasswordspecialchars int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count7 = Db.RunSQLUpdate("ALTER TABLE pl ADD minpasswordnumericchars int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count8 = Db.RunSQLUpdate("ALTER TABLE pl ADD ispasswordcasesensitive int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count9 = Db.RunSQLUpdate("ALTER TABLE pl ADD ispasswordsentviaemail int(11) NOT NULL default '1'");
            //-----------------------------------
            //-----------------------------------
            

            


    }


}
