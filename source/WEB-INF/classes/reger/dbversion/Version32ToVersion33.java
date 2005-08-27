package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version32ToVersion33 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE groupserversubscription DROP serverusername");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE groupserversubscription DROP serverpassword");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int countd = Db.RunSQLUpdate("ALTER TABLE groupentry ADD controlkey varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int countda = Db.RunSQLUpdate("ALTER TABLE `group` ADD accountuserid int(11)");
            //-----------------------------------
            //-----------------------------------


    }


}
