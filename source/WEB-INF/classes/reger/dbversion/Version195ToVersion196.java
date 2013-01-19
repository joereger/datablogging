package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

/**
 *
 *
 */
public class Version195ToVersion196 implements UpgradeDatabaseOneVersion {

    public void doUpgrade(){





        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("CREATE TABLE `dropbox` (`dropboxid` int(11) NOT NULL auto_increment, accountid int(11), access_key varchar(255), access_secret varchar(255), oauth_token varchar(255), PRIMARY KEY  (`dropboxid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
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