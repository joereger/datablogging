package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version19ToVersion20 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE account ADD FULLTEXT accounturlFulltextIndex (accounturl)");
            //-----------------------------------
            //-----------------------------------





    }


}
