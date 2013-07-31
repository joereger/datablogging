package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

/**
 * This creates the base database if none exists.
 */
public class Version201ToVersion202 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        int counta = Db.RunSQLUpdate("ALTER TABLE account ADD issplashpageon BOOLEAN");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int countb = Db.RunSQLUpdate("ALTER TABLE account ADD splashpagehtml TEXT");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("UPDATE account SET issplashpageon=false");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("UPDATE account SET splashpagehtml=''");
        //-----------------------------------
        //-----------------------------------





    }

        //Sample sql statements

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE daterangesavedsearchid daterangesavedsearchid int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE account DROP gps");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
        //-----------------------------------
        //-----------------------------------


}
