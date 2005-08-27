package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version136ToVersion137 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("ALTER TABLE account ADD encryptedlicense TEXT default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("ALTER TABLE pl ADD encryptedlicense TEXT default NULL");
        //-----------------------------------
        //-----------------------------------



    }

}
