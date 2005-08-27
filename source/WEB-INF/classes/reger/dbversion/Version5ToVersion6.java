package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version5ToVersion6 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Add ACLObject for TimePeriods
            //-----------------------------------
            //-----------------------------------
            int id2 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('22', '"+reger.core.Util.cleanForSQL("CREATETIMEPERIODS")+"', '"+reger.core.Util.cleanForSQL("Create Time Periods")+"', '"+reger.core.Util.cleanForSQL("The ability to create/edit/delete time periods.")+"')");
            //-----------------------------------
            //-----------------------------------

            //Add ACLObject for TimePeriods
            //-----------------------------------
            //-----------------------------------
            int id3 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('23', '"+reger.core.Util.cleanForSQL("TIMEPERIODSVIEWPRIVATE")+"', '"+reger.core.Util.cleanForSQL("View Private Time Periods")+"', '"+reger.core.Util.cleanForSQL("The ability to view time periods marked as private.")+"')");
            //-----------------------------------
            //-----------------------------------



    }


}
