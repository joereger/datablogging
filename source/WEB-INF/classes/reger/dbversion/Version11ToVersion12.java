package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version11ToVersion12 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE image ADD FULLTEXT searchImagesIndex (description, image)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE trackback ADD FULLTEXT searchTrackbackIndex (blogname, posttitle, excerpt)");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE message ADD FULLTEXT searchMessagesIndex (messagefrom, message)");
            //-----------------------------------
            //-----------------------------------



    }


}
