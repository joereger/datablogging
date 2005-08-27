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
public class Version134ToVersion135 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            String[][] rstUsers= Db.RunSQL("SELECT accountuserid FROM emailapi");
            //-----------------------------------
            //-----------------------------------
            if (rstUsers!=null && rstUsers.length>0){
                int[] recip = new int[rstUsers.length];
                for(int i=0; i<rstUsers.length; i++){
                    recip[i] = Integer.parseInt(rstUsers[i][0]);
                }
                FriendMessage msg = new FriendMessage();
                msg.newMessage(-1, recip, "Notice: Posting to Log by Email Has Changed", "We have implemented a new set of email addresses that you can use to post to your log via email.  This change is made because many users were having trouble with cell phones or other email clients not accepting long email addresses.  Please visit your <a href='tools-emailapi-emailaddresses.log'>Tools -> Email</a> tab to get the new email addresses that you should use to send email to your log.  We apologize for the inconvenience but believe that this is an important upgrade.");
            }



    }




}
