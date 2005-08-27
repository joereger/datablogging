package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.UserSession;
import reger.core.db.Db;
import reger.mega.FieldType;
import reger.mega.Field;
import reger.mega.FieldLayout;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version98ToVersion99 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE eventtypeid xeventtypeid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------



    }




}
