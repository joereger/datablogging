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
public class Version101ToVersion102 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE megachartyaxis CHANGE ylogid ylogid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megachartyaxis CHANGE yeventtypeid yeventtypeid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------



    }




}
