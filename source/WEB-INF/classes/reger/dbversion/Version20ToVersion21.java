package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version20ToVersion21 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `offensivecontentdefaults` (`offensivecontentdefaultsid` int(11) NOT NULL auto_increment, `content` varchar(255) default NULL, PRIMARY KEY  (`offensivecontentdefaultsid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `offensivecontentpl` (`offensivecontentplid` int(11) NOT NULL auto_increment, `plid` int(11) NOT NULL default '0', `content` varchar(255) default NULL, PRIMARY KEY  (`offensivecontentplid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //Add bad words to the database
            addAllWordsToDb();

   }


    private void addAllWordsToDb(){
        for (int i = 0; i < getWords().size(); i++) {
            String word = (String) getWords().get(i);
            insertOneWordToDb(word);
        }
    }


    private void insertOneWordToDb(String word){
        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO offensivecontentdefaults(content) VALUES('"+reger.core.Util.cleanForSQL(word)+"')");
        //-----------------------------------
        //-----------------------------------
    }


    private java.util.Vector getWords(){
        java.util.Vector words = new java.util.Vector();



        return words;
    }


}
