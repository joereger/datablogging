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
public class Version87ToVersion88 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO templatenew(template, type, accountid, issystemtemplate, name) VALUES('"+reger.core.Util.cleanForSQL("<$Entry.List$>")+"', '3', '0', '1', '"+reger.core.Util.cleanForSQL("Simple List of Entries")+"')");
        //-----------------------------------
        //-----------------------------------


            



    }


}
