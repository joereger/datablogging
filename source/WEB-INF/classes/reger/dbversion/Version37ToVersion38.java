package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version37ToVersion38 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE groups ADD viewingentriesrequiresgroupkey int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE groups ADD addingentriesrequiresgroupkey int(11)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE groupentry ADD author varchar(255)");
            //-----------------------------------
            //-----------------------------------
            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE groupentry ADD authorurl varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("ALTER TABLE groupsubscription ADD groupkey varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE groupsubscription ADD groupadminkey varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count7 = Db.RunSQLUpdate("ALTER TABLE groupserversubscription ADD serverkey varchar(255)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count8 = Db.RunSQLUpdate("ALTER TABLE groupserversubscription ADD serveradminkey varchar(255)");
            //-----------------------------------
            //-----------------------------------



    }


}
