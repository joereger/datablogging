package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;

import java.util.Calendar;


/**
 * Sends automated email subscription emails
 */
public class EmailSubscription implements ScheduledTask{


    private String result = "";

    public String getTaskName() {
        return "Email Subscriptions";
    }

    public int getRunEveryXMinutes() {
        return 30;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

	public void doTask() {

	    int messagecount=0;

		try{
			String messagebody="";
			String toaddress="";
			String fromaddress="";
			String url="";
			int usermessagecount=0;
			boolean htmlemail=false;

            //Select accounts that have their emailnewsletter turned on
            //-----------------------------------
            //-----------------------------------
            String[][] rstAcct= Db.RunSQL("SELECT accountid, timezoneid, emailsendhour FROM account a WHERE emailnewsletter='1' AND (SELECT count(*) FROM emailsubscriber WHERE accountid=a.accountid)>0");
            //-----------------------------------
            //-----------------------------------
            if (rstAcct!=null && rstAcct.length>0){
            	for(int k=0; k<rstAcct.length; k++){

            	    try {

                        //Get now in servertime
                        Calendar cal = Calendar.getInstance();

                        //Save server timezoneid
                        String servertimezoneid = cal.getTimeZone().getID().toString();

                        //Convert now to usertime
                        cal = reger.core.TimeUtils.nowInUserTimezone(rstAcct[k][1]);

                        //Manually set usertime hour to emailsendhour
                        int emailsendhourfromdb = 0;
                        try {
                            emailsendhourfromdb = Integer.parseInt(rstAcct[k][2]);
                        } catch (Exception e) {
                            //Do nothing
                        }
                        cal = reger.core.TimeUtils.dbstringtocalendar(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+emailsendhourfromdb+":00:00");

                        //Convert to servertime
                        cal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(cal, rstAcct[k][1], servertimezoneid);

                        //Get hour... that's email send hour in servertime terms
                        int emailsendhourcalculated = cal.get(Calendar.HOUR_OF_DAY);


                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstSubs= Db.RunSQL("SELECT account.accounturl, htmlemail, account.accountid, lastsentdate, account.accountid, timezoneid, emailsubscriberid, emailaddress, account.customservername, account.accountemail, account.newslettersubject FROM emailsubscriber, account, pl WHERE account.accountid='"+rstAcct[k][0]+"' AND account.accountid=emailsubscriber.accountid AND account.emailnewsletter='1' AND DATE_ADD(emailsubscriber.lastsentdate, INTERVAL emailsubscriber.sendeveryxdays DAY)<'"+reger.core.TimeUtils.nowInGmtString()+"' AND HOUR('"+reger.core.TimeUtils.nowInGmtString()+"')='"+emailsendhourcalculated+"' AND account.plid=pl.plid");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstSubs!=null && rstSubs.length>0){
                            for(int i=0; i<rstSubs.length; i++){

                                //@todo Need a way to not send to those who had email subscriptions before an account's license expired

                                //Make sure we're starting from scratch with the email body
                                messagebody="";

                                //Get the site root url
                                reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstSubs[i][2]));

                                //Calculate the url of the site
                                url="" + acctTmp.getSiteRootUrl() + "/";


                                //Subject
                                String newslettersubject = "Email update for: " + url;
                                if (!rstSubs[i][10].equals("")){
                                    newslettersubject = rstSubs[i][10];
                                }

                                //Set htmlemail boolean
                                if (rstSubs[i][1].equals("1")) {
                                    htmlemail=true;
                                } else {
                                    htmlemail=false;
                                }


                                if (htmlemail) {
                                    //Create html email header
                                    messagebody=messagebody + newslettersubject + "<br><br>";
                                } else {
                                    //Create plain text header
                                    messagebody=messagebody + newslettersubject + reger.Vars.LINEBREAKCHAR + reger.Vars.LINEBREAKCHAR;
                                }


                                //Set usermessagecount to zero
                                usermessagecount=0;

                                //-----------------------------------
                                //-----------------------------------
                                String[][] rstEvents= Db.RunSQL("SELECT eventid, title, comments, date, event.logid FROM event, megalog WHERE event.date>='"+ rstSubs[i][3] +"' AND event.accountid='"+ rstSubs[i][4] +"' AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND event.logid=megalog.logid AND "+reger.Entry.sqlOfLiveEntry+" ORDER BY event.date DESC, event.eventid DESC");
                                //-----------------------------------
                                //-----------------------------------
                                if (rstEvents!=null && rstEvents.length>0){
                                    for(int j=0; j<rstEvents.length; j++){
                                        usermessagecount=usermessagecount+1;

                                        if (htmlemail) {
                                            //Create html email event listing
                                            messagebody=messagebody + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.gmttousertime(rstEvents[j][3], rstSubs[i][5]));
                                            messagebody=messagebody + "<br>";
                                            messagebody=messagebody + "<a href=\"";
                                            messagebody=messagebody + url;
                                            messagebody=messagebody + reger.Entry.entryFileNameStatic(Integer.parseInt(rstEvents[j][4]), Integer.parseInt(rstEvents[j][0]), rstEvents[j][2]);
                                            messagebody=messagebody + "\">";
                                            messagebody=messagebody + rstEvents[j][1];
                                            messagebody=messagebody + "</a>";
                                            messagebody=messagebody + "<br>";
                                            messagebody=messagebody + rstEvents[j][2];
                                            messagebody=messagebody + "<br>";
                                            messagebody=messagebody + "<br>";
                                        } else {
                                            //Create plain text event listing
                                            messagebody=messagebody + "=============================" + reger.Vars.LINEBREAKCHAR;
                                            messagebody=messagebody + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.gmttousertime(rstEvents[j][3], rstSubs[i][5])) + reger.Vars.LINEBREAKCHAR;
                                            messagebody=messagebody + rstEvents[j][1] + reger.Vars.LINEBREAKCHAR;
                                            messagebody=messagebody + url;
                                            messagebody=messagebody + reger.Entry.entryFileNameStatic(Integer.parseInt(rstEvents[j][4]), Integer.parseInt(rstEvents[j][0]), rstEvents[j][2]);
                                            messagebody=messagebody + rstEvents[j][2] + reger.Vars.LINEBREAKCHAR;
                                            messagebody=messagebody + reger.Vars.LINEBREAKCHAR;
                                        }
                                    }
                                }




                                if (htmlemail){
                                    //Create html email footer
                                    messagebody=messagebody + "<br>";
                                    messagebody=messagebody + "<br>";
                                    messagebody=messagebody + "<br>";
                                    messagebody=messagebody + "Unsubscribe or manage preferences <a href='"+ url +"emailsubscription.log?emailsubscriberid="+ rstSubs[i][6] +"'>here</a>.";
                                } else {
                                    //Create plain text footer
                                    messagebody=messagebody + reger.Vars.LINEBREAKCHAR;
                                    messagebody=messagebody + reger.Vars.LINEBREAKCHAR;
                                    messagebody=messagebody + reger.Vars.LINEBREAKCHAR;
                                    messagebody=messagebody + "Unsubscribe or manage preferences here:"+ url +"emailsubscription.log?emailsubscriberid="+ rstSubs[i][6] + reger.Vars.LINEBREAKCHAR;
                                }

                                //Only send if there's actually a new event
                                if (usermessagecount>0) {

                                    //-----------------------------------
                                    //-----------------------------------
                                    int count = Db.RunSQLUpdate("UPDATE emailsubscriber SET lastsentdate='"+reger.core.TimeUtils.nowInGmtString()+"' WHERE emailsubscriberid='"+ rstSubs[i][6] +"'");
                                    //-----------------------------------
                                    //-----------------------------------

                                    //To Address
                                    toaddress=rstSubs[i][7];

                                    //From Address
                                    fromaddress=reger.Vars.EMAILDEFAULTFROM;
                                    if (!rstSubs[i][9].equals("")){
                                        fromaddress = rstSubs[i][9];
                                    }



                                    //Send the email
                                    try {
                                        if (!toaddress.equals("")){
                                            reger.core.EmailSend.sendMail(fromaddress, toaddress, newslettersubject, messagebody, htmlemail);
                                        }
                                    } catch (Exception e) {
                                        Debug.errorsave(e, "");
                                    }

                                    //Increment the message counter
                                    messagecount=messagecount+1;

                                }
                            }
                        }
                    } catch (Exception e){
                        Debug.errorsave(e, "");
                    }
                }
            }

        } catch (Exception e) {
			Debug.errorsave(e, "");
			result = "Error.  See event log for details.";
        }

        result = messagecount + " emails sent.";
    }

}
