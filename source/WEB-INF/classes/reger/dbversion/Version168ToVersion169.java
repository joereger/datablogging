package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version168ToVersion169 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){

        //Pawan's first database update

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("RENAME TABLE imagetag TO tag");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        count = Db.RunSQLUpdate("ALTER TABLE tag CHANGE imagetagid tagid int(11) NOT NULL auto_increment");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        count = Db.RunSQLUpdate("ALTER TABLE imagetagimagelink CHANGE imagetagid tagid int(11) NOT NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        count = Db.RunSQLUpdate("CREATE TABLE `eventtaglink` (`eventtaglinkid` int(11) NOT NULL auto_increment, eventid int(11), tagid int(11), PRIMARY KEY (`eventtaglinkid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
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
