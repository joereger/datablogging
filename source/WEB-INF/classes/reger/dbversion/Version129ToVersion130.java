package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version129ToVersion130 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE megalog SET fieldorder=''");
            //-----------------------------------
            //-----------------------------------


            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("UPDATE megalogtype SET fieldorder=''");
            //-----------------------------------
            //-----------------------------------



    }

    private static float convertDegMinSecToDecimal(int degrees, int minutes, int seconds){
        float minasdeg = ((float)minutes)/(60);
        float secasdeg = ((float)seconds)/(60*60);
        return degrees + minasdeg + secasdeg;
    }


}
