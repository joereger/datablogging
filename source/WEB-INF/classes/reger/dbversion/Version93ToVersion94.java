package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.UserSession;
import reger.mega.FieldType;
import reger.mega.Field;
import reger.mega.FieldLayout;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version93ToVersion94 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE pl DROP plhost");
            //-----------------------------------
            //-----------------------------------

            


    }



}
