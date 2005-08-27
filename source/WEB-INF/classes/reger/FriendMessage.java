package reger;

import reger.core.db.Db;
import reger.core.Util;

import java.util.Calendar;

/**
 * Class to represent a message between friends
 */
public class FriendMessage {

    public int friendmessageid;
    public int accountuserid;
    public String subject;
    public String message;
    public Calendar datetime;

    public boolean havevalidmessage = false;

    public FriendMessage(){

    }

    public FriendMessage(int friendmessageid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL("SELECT accountuserid, subject, message, datetime, parentfriendmessageid FROM friendmessage WHERE friendmessageid='"+friendmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
        	for(int i=0; i<rstMessage.length; i++){
        	    this.friendmessageid = friendmessageid;
        	    this.accountuserid=Integer.parseInt(rstMessage[i][0]);
        	    this.subject=rstMessage[i][1];
        	    this.message=rstMessage[i][2];
        	    this.datetime=reger.core.TimeUtils.dbstringtocalendar(rstMessage[i][3]);

        	    this.havevalidmessage=true;
        	}
        }
    }
    

    public String newMessage(int accountuserid, int[] recipientaccountuserids, String subject, String message){
        String errortext = "";

        //Must have a subject
        if (subject.equals("")){
            errortext = errortext + "You must provide a subject for your message.<br>";
        }

        //Get now in GMT
        Calendar now = reger.core.TimeUtils.nowInUserTimezone("GMT");

        //Do the insert if there are no errors
        if (errortext.equals("")){

            //Create the message in friendmessage table
            //-----------------------------------
            //-----------------------------------
            int friendmessageid = Db.RunSQLInsert("INSERT INTO friendmessage(accountuserid, subject, message, datetime, parentfriendmessageid) VALUES('"+accountuserid+"', '"+Util.cleanForSQL(subject)+"', '"+Util.cleanForSQL(message)+"', '"+reger.core.TimeUtils.dateformatfordb(now)+"', '-1')");
            //-----------------------------------
            //-----------------------------------

            //Add the recipients in the friendmessagerecipient table
            for (int i = 0; i < recipientaccountuserids.length; i++) {
                //-----------------------------------
                //-----------------------------------
                int identity2 = Db.RunSQLInsert("INSERT INTO friendmessagerecipient(friendmessageid, accountuserid, isread) VALUES('"+friendmessageid+"', '"+recipientaccountuserids[i]+"', '0')");
                //-----------------------------------
                //-----------------------------------

                //Send an email notification of new message
                Accountuser au = new Accountuser(recipientaccountuserids[i]);
                if (!au.getEmail().equals("")){
                    reger.core.EmailSend.sendMail("", au.getEmail(), "There is a New Message in Your Inbox", "There is a new message in your weblogging account inbox.  You can find it by logging in <a href='"+reger.Vars.getHttpUrlPrefix()+au.getSiteRootUrl()+"/myhome/'>"+reger.Vars.getHttpUrlPrefix()+au.getSiteRootUrl()+"/myhome/</a>.");
                }
            }

        }

        return errortext;
    }

    



}
