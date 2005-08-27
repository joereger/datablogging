package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.FriendMessage;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version135ToVersion136 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Randomize the linkrot spider dates
            reger.linkrot.Util.randomizeDates(31);



    }




}
