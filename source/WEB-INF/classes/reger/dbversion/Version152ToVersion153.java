package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.template.Template;
import reger.template.SiteTemplateTag;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * This creates the base database if none exists.
 */
public class Version152ToVersion153 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("ALTER TABLE image ADD accountid int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //Fill in the accountids of existing images
        //-----------------------------------
        //-----------------------------------
        String[][] rstImages= Db.RunSQL("SELECT image.imageid, event.accountid FROM event, image WHERE image.eventid=event.eventid");
        //-----------------------------------
        //-----------------------------------
        if (rstImages!=null && rstImages.length>0){
            for(int i=0; i<rstImages.length; i++){
                //Update the accountid
                //-----------------------------------
                //-----------------------------------
                int count2 = Db.RunSQLUpdate("UPDATE image SET accountid='"+rstImages[i][1]+"' WHERE imageid='"+rstImages[i][0]+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }



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

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
        //-----------------------------------
        //-----------------------------------
