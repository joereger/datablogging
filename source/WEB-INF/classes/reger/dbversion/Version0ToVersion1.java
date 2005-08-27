package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version0ToVersion1 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){

        //Execute the base sql file.  This creates the base which all other database updates are made from.

        //Base SQL file is created by exporting a base database structure from MySQL and then:
        //1) Remove the first two line "create database if not exists `baseqlogger`;"
        //   and the line "use `baseqlogger`;"  These two lines aren't relevant because we're telling
        //   the JDBC driver which database to connect to.  Bottom line: user has to have at least the database
        //   created with the correct name configured in the context.xml.
        //2) Save the file into the /setup directory and make sure that the br below can find it.

        //Note: Once this is tested and working it shouldn't need to be exported from MySQL again.


        //Execute the batch SQL file
        reger.core.dbupgrade.ExecuteSQLFile.execute(reger.core.WebAppRootDir.getWebAppRootPath() + "setup/dbversionzero.sql");




    }


}
