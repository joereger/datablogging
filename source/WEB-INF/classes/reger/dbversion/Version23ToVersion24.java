package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version23ToVersion24 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            String[][] rstDuplicateUsernames= Db.RunSQL("SELECT username, count(*) as cnt FROM accountuser GROUP BY username ORDER BY cnt DESC");
            //-----------------------------------
            //-----------------------------------
            if (rstDuplicateUsernames!=null && rstDuplicateUsernames.length>0){
            	for(int i=0; i<rstDuplicateUsernames.length; i++){
            	    //If this username conflicts with another username
                    if (Integer.parseInt(rstDuplicateUsernames[i][1])>1){
                        //Find the users with this duplicated username
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstFindUsers= Db.RunSQL("SELECT accountuserid, accounturl, username, email FROM accountuser, account WHERE account.accountid=accountuser.accountuserid AND accountuser.username='"+reger.core.Util.cleanForSQL(rstDuplicateUsernames[i][0])+"'");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstFindUsers!=null && rstFindUsers.length>0){
                        	for(int j=0; j<rstFindUsers.length; j++){
                                //Append accounturl to the username
                                String oldUserName = rstFindUsers[j][2];
                                String newUserName = rstFindUsers[j][1] + rstFindUsers[j][2];
                                //-----------------------------------
                                //-----------------------------------
                                int count = Db.RunSQLUpdate("UPDATE accountuser SET username='"+reger.core.Util.cleanForSQL(newUserName)+"' WHERE accountuserid='"+rstFindUsers[j][0]+"'");
                                //-----------------------------------
                                //-----------------------------------
                                //Note this change in the log
                                reger.core.Util.logtodb("Username changed from " + oldUserName + " to " + newUserName + " for accountuserid=" + rstFindUsers[j][0]);
                                //Send them a notification email
                                StringBuffer message = new StringBuffer();
                                message.append("Your username has changed from '" + oldUserName + "' to '" + newUserName + "'.  We apologize for the inconvenience.  If you don't like the new username you can log back into your account and change it to something easier to remember.  If you have questions, please email help@reger.com.  Best, Joe Reger");
                                reger.core.EmailSend.sendMail("server@reger.com", rstFindUsers[j][3], "Weblogging Username Changed", message.toString());
                        	}
                        }
                    }
            	}
            }




    }


}
