package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version43ToVersion44 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE mobile ADD accountuserid int(11) NOT NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE mobile DROP accountid");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("DELETE FROM mobile");
            //-----------------------------------
            //-----------------------------------


            


    }


}
