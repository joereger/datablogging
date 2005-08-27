package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version1ToVersion2 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


            //Add ACLObject for People TAB
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('18', '"+reger.core.Util.cleanForSQL("PEOPLE")+"', '"+reger.core.Util.cleanForSQL("People Section")+"', '"+reger.core.Util.cleanForSQL("The ability to work with features in the People tab.  These features include social networking, author creation and others.")+"')");
            //-----------------------------------
            //-----------------------------------

            //Add ACLObject for People Invite
            //-----------------------------------
            //-----------------------------------
            int id2 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('19', '"+reger.core.Util.cleanForSQL("INVITEPEOPLE")+"', '"+reger.core.Util.cleanForSQL("Invite People to the Site")+"', '"+reger.core.Util.cleanForSQL("The ability to use automated tools to send email invites to people.")+"')");
            //-----------------------------------
            //-----------------------------------

            //Add ACLObject for Add Author
            //-----------------------------------
            //-----------------------------------
            int id3 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('20', '"+reger.core.Util.cleanForSQL("ADDAUTHOR")+"', '"+reger.core.Util.cleanForSQL("Add Author")+"', '"+reger.core.Util.cleanForSQL("The ability to add an author to the account.")+"')");
            //-----------------------------------
            //-----------------------------------

            //Add ACLObject for Traffic
            //-----------------------------------
            //-----------------------------------
            int id4 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('21', '"+reger.core.Util.cleanForSQL("TRAFFIC")+"', '"+reger.core.Util.cleanForSQL("Traffic")+"', '"+reger.core.Util.cleanForSQL("The ability to view traffic data for the site.")+"')");
            //-----------------------------------
            //-----------------------------------



    }


}
