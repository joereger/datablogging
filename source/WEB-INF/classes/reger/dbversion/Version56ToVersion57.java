package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version56ToVersion57 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE pl DROP defaultmaxbandwidth");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE pl ADD defaultmaxbandwidth bigint(20) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------
            


    }


}
