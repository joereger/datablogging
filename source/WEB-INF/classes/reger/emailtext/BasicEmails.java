package reger.emailtext;

import reger.core.db.Db;
import reger.PrivateLabel;
import reger.core.db.Db;
import reger.core.EmailSendException;

/**
 *
 */
public class BasicEmails {

    public static void newAccountEmailVerificationMessage(reger.Accountuser au, int accountid, PrivateLabel pl, String cleartextPassword) throws EmailSendException{
        StringBuffer content=new StringBuffer();
        reger.Account acct = new reger.Account(accountid);

        //Start Make sure accountuser is ready for emailverification
        String errortext = "";
        if (au.getEmailactivationkey().equals("")){
            au.setEmailactivationkey(reger.core.RandomString.randomAlphanumeric(10));

        }
        au.setEmailactivationlastsent(reger.core.TimeUtils.nowInGmtCalendar());
        errortext = errortext + au.saveSettings(pl);
        if (!errortext.equals("")){
            EmailSendException ex = new EmailSendException(errortext);
            throw ex;
        }
        //End Make sure accountuser is ready for emailverification

        String to = au.getEmail();
        String from = pl.getEmailtonotifyofnewaccounts();
        String subject = pl.getEmailsubjectactivationmessage();
        String body = pl.getEmailtextactivationmessage();
        if (body.equals("")){
            body = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "emailmessages/activationmessage.txt").toString();
        }
        if (subject.equals("")){
            subject = "Activate your new datablog!";
        }

        content.append("Hi " + au.getFriendlyname() + ":" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Please click here to activate your account: " + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(pl.getPlBaseUrl() + "/about/login-emailactivation.log?accountuserid="+au.getAccountuserid()+"&key=" + au.getEmailactivationkey() + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(body);

        //Send the email
        try{
            reger.core.EmailSend.sendMailNoThread(from, to, subject, content.toString(), false);
        } catch (EmailSendException ex){
            throw ex;
        }
    }

    public static void passwordResetMessage(reger.Accountuser au, int accountid, PrivateLabel pl, String cleartextPassword) throws EmailSendException{
        StringBuffer content=new StringBuffer();
        reger.Account acct = new reger.Account(accountid);

        //Start Make sure accountuser is ready for emailverification
        String errortext = "";
        if (au.getEmailactivationkey().equals("")){
            au.setEmailactivationkey(reger.core.RandomString.randomAlphanumeric(10));
            errortext = errortext + au.saveSettings(pl);
        }
        if (!errortext.equals("")){
            EmailSendException ex = new EmailSendException(errortext);
            throw ex;
        }
        //End Make sure accountuser is ready for emailverification

        String to = au.getEmail();
        String from = pl.getEmailtonotifyofnewaccounts();
        String subject = pl.getEmailsubjectactivationmessage();

        if (subject.equals("")){
            subject = "datablogging Account Password Reset Message";
        }

        content.append("Please click here to reset your password: ");
        content.append(pl.getPlBaseUrl() + "/about/login-passwordreset.log?action=reset&accountuserid="+au.getAccountuserid()+"&key=" + au.getEmailactivationkey() + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your public blog: " + acct.getSiteRootUrl() + "/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Administer your site: " + acct.getSiteRootUrl() + "/myhome/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your Email: " + au.getEmail() + reger.Vars.LINEBREAKCHARFOREMAIL);
        if (pl.getIsPasswordSentViaEmail() && !cleartextPassword.equals("")){
            content.append("Your Password: " + cleartextPassword + reger.Vars.LINEBREAKCHARFOREMAIL);
        }
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(reger.Vars.LINEBREAKCHARFOREMAIL);

        //Send the email
        try{
            reger.core.EmailSend.sendMailNoThread(from, to, subject, content.toString(), false);
        } catch (EmailSendException ex){
            throw ex;
        }
    }

    public static void newAccountWelcome(reger.Accountuser au, int accountid, PrivateLabel pl, String cleartextPassword){
        StringBuffer content=new StringBuffer();
        reger.Account acct = new reger.Account(accountid);

        String to = au.getEmail();
        String from = pl.getEmailtonotifyofnewaccounts();
        String subject = pl.getEmailsubjectwelcomemessage();
        String body = pl.getEmailtextwelcomemessage();
        if (body.equals("")){
            body = reger.core.Util.textFileRead(reger.core.WebAppRootDir.getWebAppRootPath() + "emailmessages/welcomemessage.txt").toString();
        }
        if (subject.equals("")){
            subject = "Hi " + au.getFriendlyname() + ", welcome to your new datablogging Account!";
        }

        content.append("Hi " + au.getFriendlyname() + "!" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Thanks for signing up for your new datablogging account. We are glad that you have selected us!" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your account has been created, so please save this email for your records and for future reference, as important information regarding your account is provided in this email." + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your public datablog is: " + acct.getSiteRootUrl() + "/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        if(!cleartextPassword.equals("")){
            content.append("Your Password is: " + cleartextPassword + reger.Vars.LINEBREAKCHARFOREMAIL);
        }
        content.append("Administer your site here: " + acct.getSiteRootUrl() + "/myhome/" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("Your Email: " + au.getEmail() + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append("----------------------------------" + reger.Vars.LINEBREAKCHARFOREMAIL);
        content.append(body);

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
                    mes.append("Your Email: " + au.getEmail() + reger.Vars.LINEBREAKCHARFOREMAIL);
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
        mes.append(""+pl.getPlBaseUrl()+"/about/login-fid-"+friendinvitationid+"-fkey-"+friendinvitationkey+".log");
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
