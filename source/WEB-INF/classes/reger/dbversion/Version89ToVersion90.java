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
public class Version89ToVersion90 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            //int count1 = Db.RunSQLUpdate("ALTER TABLE pl ADD sectionfeatures varchar(50) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------


            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE pl ADD sectionfeatures varchar(50)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE pl ADD termsofuselinktext varchar(50)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE pl ADD feedbacklinktext varchar(50)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE pl ADD doapplyplusertemplatetopro int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("ALTER TABLE pl ADD publicsitetemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE pl ADD entlisttemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count7 = Db.RunSQLUpdate("ALTER TABLE pl ADD hptemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count8 = Db.RunSQLUpdate("ALTER TABLE pl ADD marketingsitetemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count9 = Db.RunSQLUpdate("ALTER TABLE pl ADD marketingsitehptemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count10 = Db.RunSQLUpdate("DROP TABLE pltemplate");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count11 = Db.RunSQLUpdate("ALTER TABLE pl DROP hpcontent");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count12 = Db.RunSQLUpdate("ALTER TABLE pl DROP plmarketingtemplate");
            //-----------------------------------
            //-----------------------------------


            

    }


}
