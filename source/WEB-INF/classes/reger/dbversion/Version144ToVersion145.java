package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version144ToVersion145 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        String[][] rstLoc= Db.RunSQL("SELECT locationid FROM location WHERE locationname='Location'");
        //-----------------------------------
        //-----------------------------------
        if (rstLoc!=null && rstLoc.length>0){
            for(int i=0; i<rstLoc.length; i++){
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE event SET locationid='0' WHERE locationid='"+rstLoc[i][0]+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM location WHERE locationname='Location'");
        //-----------------------------------
        //-----------------------------------



    }

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
