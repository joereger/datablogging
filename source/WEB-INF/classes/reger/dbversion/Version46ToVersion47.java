package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version46ToVersion47 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            String hpcontent = "<center><a href='signup.log'><img src='images/getone.jpg' border=0></a></center>";

            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE PL SET hpcontent='"+reger.core.Util.cleanForSQL(hpcontent)+"'");
            //-----------------------------------
            //-----------------------------------



    }


}
