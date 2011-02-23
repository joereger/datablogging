package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version47ToVersion48 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            String termsofservice = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "setup/regercom-tos-privacy.txt").toString();

            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE PL SET termsofservice='"+reger.core.Util.cleanForSQL(termsofservice)+"'");
            //-----------------------------------
            //-----------------------------------


            

    }


}
