package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version73ToVersion74 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //Create a password backup field
            //-----------------------------------
            //-----------------------------------
            int count1 = Db.RunSQLUpdate("ALTER TABLE accountuser ADD oldpassword varchar(50)");
            //-----------------------------------
            //-----------------------------------

            //And backup the passwords, just in case
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("UPDATE accountuser SET oldpassword=password");
            //-----------------------------------
            //-----------------------------------

            //Change the password field
            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE accountuser MODIFY password varchar(255) NOT NULL");
            //-----------------------------------
            //-----------------------------------

            //And now convert to hash
            //-----------------------------------
            //-----------------------------------
            String[][] rstPass= Db.RunSQL("SELECT accountuserid, password FROM accountuser", 50000);
            //-----------------------------------
            //-----------------------------------
            if (rstPass!=null && rstPass.length>0){
            	for(int i=0; i<rstPass.length; i++){
            	    String plaintextPassword = rstPass[i][1];
            	    String passwordHash = PasswordHash.getHash(plaintextPassword);
            	    //-----------------------------------
            	    //-----------------------------------
            	    int count = Db.RunSQLUpdate("UPDATE accountuser SET password='"+reger.core.Util.cleanForSQL(passwordHash)+"' WHERE accountuserid='"+rstPass[i][0]+"'");
            	    //-----------------------------------
            	    //-----------------------------------
            	}
            }

            


    }


}
