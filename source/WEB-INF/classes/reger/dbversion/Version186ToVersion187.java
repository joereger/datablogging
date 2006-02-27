package reger.dbversion;

import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.db.Db;

/**
 * WARNING: After any database update you must update the classes in reger.dao.
 *
 *     1) Make your changes to the database with this class
 *     2) QuickBuild or fully deploy the app so that the database is updated
 *     3) Log in with superuser privileges
 *     4) Go to LOE Admin -> Tools -> DAO Generator
 *     5) Use this screen to update the affected DAOs
 *     6) Access the database via the DAOs only
 *
 */
public class Version186ToVersion187 implements UpgradeDatabaseOneVersion {

    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("CREATE TABLE `locationtoevent` (`locationtoeventid` int(11) NOT NULL auto_increment, locationid int(11), eventid int(11), PRIMARY KEY  (`locationtoeventid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
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
