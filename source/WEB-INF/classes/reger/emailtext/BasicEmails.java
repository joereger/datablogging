package reger.emailtext;

import reger.core.db.Db;
import reger.PrivateLabel;
import reger.core.db.Db;

/**
 *
 */
public class BasicEmails {

    public static StringBuffer friendEmailTop(String friendlyname){
        StringBuffer mes = new StringBuffer();
        //mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        //mes.append(friendlyname + " has sent you the following links.");
        //mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        return mes;
    }

    public static void newAccountWelcome(reger.Accountuser au, int accountid, PrivateLabel pl, String cleartextPassword){
        StringBuffer content=new StringBuffer();

        reger.Account acct = new reger.Account(accountid);

        String to = au.getEmail();
        String from = reger.Vars.EMAILDEFAULTFROM;
        String subject = "Welcome to Your Weblogging Account!";

        content.append("Welcome!  Your account has been created.  Keep this email for your records." + reger.Vars.LINEBREAKCHARFOREMAIL + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your public weblog is here: " + acct.getSiteRootUrl() + "/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Administer your site here: " + acct.getSiteRootUrl() + "/myhome/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your Username: " + au.getUsername() + reger.Vars.LINEBREAKCHARFOREMAIL);
        if (pl.getIsPasswordSentViaEmail()){
            content.append("Your Password: " + cleartextPassword + reger.Vars.LINEBREAKCHARFOREMAIL);
        }
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("To add log entries, go to the administration URL" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("and you will be presented with a list of your logs." + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Click the Create a New Log button to add more logs. We're" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("constantly adding log types to fit your needs." + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Happy logging!" + reger.Vars.LINEBREAKCHARFOREMAIL);

        //Send the email
        reger.core.EmailSend.sendMail(from, to, subject, content.toString(), false);
    }

    public static void accountActivated(int accountid){
        //Find the owner of this account and send them an email notifying them that their account has been activated
        //-----------------------------------
        //-----------------------------------
        String[][] rstOwner= Db.RunSQL("SELECT accountuserid, email FROM accountuser WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstOwner!=null && rstOwner.length>0){
            for(int i=0; i<rstOwner.length; i++){

                reger.Accountuser au = new reger.Accountuser(Integer.parseInt(rstOwner[i][0]), false);

                String emailTo = au.getEmail();
                if (!emailTo.equals("")){
                    String emailFrom = reger.Vars.EMAILDEFAULTFROM;
                    String subject =  au.getFriendlyname() + ", Your Weblogging Account is Active!";
                    StringBuffer mes = new StringBuffer();
                    mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("Your weblogging account is now active:");
                    mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("Your public weblog is here: "+ au.getSiteRootUrlOfPrimaryAccount() + "/" + reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("Administer your site here: "+ au.getSiteRootUrlOfPrimaryAccount() + "/myhome/" + reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("Your Username: " + au.getUsername() + reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
                    mes.append("Enjoy!");
                    //Send the email
                    reger.core.EmailSend.sendMail(emailFrom, emailTo, subject, mes.toString());
                }

            }
        }
    }

    public static void newAccountRequiringAdminApproval(reger.PrivateLabel pl, int accountid){
        String emailToNotify = pl.getEmailtonotifyofnewaccounts();
            if (!emailToNotify.equals("")){
                String newAcctMsg = "";
                newAcctMsg = newAcctMsg + "A new weblogging account has been created.  It requires your approval to be activated.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;

                reger.Account acct = new reger.Account(accountid);

                newAcctMsg = newAcctMsg + "" + acct.getSiteRootUrl() + "/";

                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;

                newAcctMsg = newAcctMsg + "Approve new accounts by following these steps:";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "1) Go to your weblogging account and log in.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "2) Click the Private Label tab in the upper right of the screen.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "3) On the left side of the screen, choose New Accounts Requiring Approval.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "4) You will see a list of accounts requiring approval.  Choose the one you'd like to approve.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "5) Set the 'Is Account Active?' setting to 'Yes'.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;
                newAcctMsg = newAcctMsg + "6) Click Save.";
                newAcctMsg = newAcctMsg + reger.Vars.LINEBREAKCHARFOREMAIL;

                //Send the email
                reger.core.EmailSend.sendMail(emailToNotify, emailToNotify, "New Weblogging Account Requires Approval", newAcctMsg);
            }
    }

    public static StringBuffer invitationEmail(reger.Accountuser accountUserOfInviter, reger.PrivateLabel pl , int friendinvitationid){

        String message = "";
        String friendinvitationkey = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstInv= Db.RunSQL("SELECT message, friendinvitationkey FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstInv!=null && rstInv.length>0){
        	message = rstInv[0][0];
        	friendinvitationkey = rstInv[0][1];
        }

        StringBuffer mes = new StringBuffer();
        if (!message.equals("")){
            mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
            mes.append(message);
        }
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        mes.append(accountUserOfInviter.getFriendlyname() +" has invited you to their site.");
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        mes.append("Click below to see the invitation:");
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        mes.append(""+pl.getPlBaseUrl()+"/about/invitation-"+friendinvitationid+"-"+friendinvitationkey+".log");
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        return mes;
    }



    public static StringBuffer messagesEmailNotify(String servername, int eventid, String eventTitle){
        StringBuffer mes = new StringBuffer();

        mes.append("A new message has been posted to \""+eventTitle+"\".  You requested that we email you.  The new message is at:");
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        mes.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        String entryurl=reger.Entry.entryFileNameStatic(eventid, "");
        mes.append(""+servername+"/" + entryurl);

        return mes;
    }


}
