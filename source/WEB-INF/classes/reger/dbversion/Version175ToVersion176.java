package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.Debug;

/**
 * This creates the base database if none exists.
 */
public class Version175ToVersion176 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){

            //This was a production issue... code no longer needed

            StringBuffer debug = new StringBuffer();
            //-----------------------------------
            //-----------------------------------
            String[][] rstDuplicateEmails = Db.RunSQL("SELECT email, count(*) as cnt FROM accountuser WHERE email<>'' GROUP BY email ORDER BY cnt DESC");
            //-----------------------------------
            //-----------------------------------
            if (rstDuplicateEmails !=null && rstDuplicateEmails.length>0){
                for(int i=0; i<rstDuplicateEmails.length; i++){
                    //If this username conflicts with another email
                    if (Integer.parseInt(rstDuplicateEmails[i][1])>1){
                        //Find the users with this duplicated email
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstFindUsers= Db.RunSQL("SELECT accountuserid, username, email FROM accountuser WHERE accountuser.email='"+reger.core.Util.cleanForSQL(rstDuplicateEmails[i][0])+"' ORDER BY accountuser.lastlogindate DESC");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstFindUsers!=null && rstFindUsers.length>0){
                            for(int j=0; j<rstFindUsers.length; j++){
                                //Append accounturl to the username
                                String oldemail = rstFindUsers[j][2];
                                String newemail = "";
                                //The accountuserid that was most recently logged in to is used
                                if (j==0){
                                    newemail = oldemail;
                                }
                                //-----------------------------------
                                //-----------------------------------
                                int count = Db.RunSQLUpdate("UPDATE accountuser SET email='"+reger.core.Util.cleanForSQL(newemail)+"' WHERE accountuserid='"+rstFindUsers[j][0]+"'");
                                //-----------------------------------
                                //-----------------------------------
                                //Note this change in the log
                                debug.append("EMAIL CHANGED: from '" + oldemail + "' to '" + newemail + "' for accountuserid=" + rstFindUsers[j][0] + " username was="+rstFindUsers[j][1]+"<br>");
                                System.out.println("EMAIL CHANGED: from '" + oldemail + "' to " + newemail + "' for accountuserid=" + rstFindUsers[j][0] + " username was="+rstFindUsers[j][1]);
                            }
                        }
                    }
                }
            }



    }


}
