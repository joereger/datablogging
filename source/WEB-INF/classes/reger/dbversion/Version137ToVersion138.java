package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version137ToVersion138 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){



        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("ALTER TABLE pl DROP iscreditcarduserupgradeon");
        //-----------------------------------
        //-----------------------------------



    }

}
