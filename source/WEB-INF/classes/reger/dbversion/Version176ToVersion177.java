package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.Debug;

/**
 * This creates the base database if none exists.
 */
public class Version176ToVersion177 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DROP TABLE groupentry");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count1 = Db.RunSQLUpdate("DROP TABLE groups");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DROP TABLE groupserverkey");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DROP TABLE groupserversubscription");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("DROP TABLE groupsubscription");
        //-----------------------------------
        //-----------------------------------





        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("CREATE TABLE `groups` (`groupid` int(11) NOT NULL auto_increment, name varchar(255), description varchar(255), entriesareprivate int(11), membershipismoderated int(11), plid int(11), accountuserid int(11), PRIMARY KEY  (`groupid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count6 = Db.RunSQLUpdate("CREATE TABLE `groupmembership` (`groupmembershipid` int(11) NOT NULL auto_increment, accountuserid int(11), groupid int(11), sharemembershippublicly int(11), isapproved int(11), ismoderator int(11), PRIMARY KEY  (`groupmembershipid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
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
