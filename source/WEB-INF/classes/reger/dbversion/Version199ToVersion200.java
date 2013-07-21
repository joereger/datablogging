package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

/**
 *
 *
 */
public class Version199ToVersion200 implements UpgradeDatabaseOneVersion {

    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        int counta = Db.RunSQLUpdate("ALTER TABLE megalog ADD customdomain1 varchar(255)");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int countb = Db.RunSQLUpdate("ALTER TABLE megalog ADD customdomain2 varchar(255)");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int countc = Db.RunSQLUpdate("ALTER TABLE megalog ADD customdomain3 varchar(255)");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("UPDATE megalog SET customdomain1=''");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("UPDATE megalog SET customdomain2=''");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("UPDATE megalog SET customdomain3=''");
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