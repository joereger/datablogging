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
public class Version105ToVersion106 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `cat` (`catid` int(11) NOT NULL auto_increment, name varchar(16) NOT NULL, sex varchar(1), weight real,  PRIMARY KEY  (`catid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------




    }




}
