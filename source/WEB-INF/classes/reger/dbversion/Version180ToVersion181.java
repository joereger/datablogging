package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.Debug;

/**
 * This creates the base database if none exists.
 */
public class Version180ToVersion181 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count7 = Db.RunSQLUpdate("CREATE TABLE `poll` (`pollid` int(11) NOT NULL auto_increment, eventid int(11), question varchar(255), readerscanaddownanswer int(11), readerscanaddcomments int(11), readerscanvoteonreaderanswers int(11), readerinputismoderated int(11), PRIMARY KEY  (`pollid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int count8 = Db.RunSQLUpdate("CREATE TABLE `pollanswer` (`pollanswerid` int(11) NOT NULL auto_increment, pollid int(11), answer varchar(255), votes int(11), PRIMARY KEY  (`pollanswerid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count9 = Db.RunSQLUpdate("CREATE TABLE `pollreaderanswer` (`pollreaderanswerid` int(11) NOT NULL auto_increment, pollid int(11), answer varchar(255), readername varchar(255), votes int(11), isapproved int(11), PRIMARY KEY  (`pollreaderanswerid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count10 = Db.RunSQLUpdate("CREATE TABLE `pollreadercomment` (`pollreadercommentid` int(11) NOT NULL auto_increment, pollid int(11), readername varchar(255), comment longtext, isapproved int(11), PRIMARY KEY  (`pollreadercommentid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
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
