package reger;

import reger.core.db.Db;
import reger.core.Debug;
import reger.jcaptcha.CaptchaServiceSingleton;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import com.octo.captcha.service.CaptchaServiceException;

/**
 *
 */
public class MessageListHtml {

    public static StringBuffer tableStart(){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#333333>");
        mb.append("<table cellpadding=10 cellspacing=1 width=100% border=0>");
        return mb;
    }

    public static StringBuffer htmlOut(int accountid, int eventid, String timezoneid, String LogsUserCanViewQueryend, String pagename, String action, int logid, int currentpage, HttpServletRequest request, boolean isAscendingByDate, HttpServletResponse response){
        StringBuffer mb = new StringBuffer();

        mb.append("<tr>");
        mb.append("<td class=logentryheader colspan=6 align=left valign=top>");
        mb.append("Reader Messages:");
        mb.append("</td>");
        mb.append("</tr>");


        String sql = "";
        String sqlCount = "";
        String logidSql = "";
        String eventidSql = "";
        String fieldlistSql = "";
        String fieldlistSqlCount = "";

        if (logid>0){
            logidSql = " AND event.logid='"+logid+"'";
        }

        if (eventid>0){
            eventidSql = " AND event.eventid='" + eventid + "'";
        }

        fieldlistSql = "messagedate, messagefrom, message.message, event.title, event.eventid, message.email, message.ipaddress, message.url, message.emailnotify";
        fieldlistSqlCount = "count(*)";

        //Build order
        String orderBy = "DESC";
        if (isAscendingByDate){
            orderBy = "ASC";
        }

        //Build the final sql strings
        sql      = "SELECT "+fieldlistSql     +" FROM event, message WHERE  "+LogsUserCanViewQueryend+" AND "+reger.Entry.sqlOfLiveEntry+" AND event.accountid='" + accountid + "' AND event.eventid=message.eventid AND message.isapproved='1' "+logidSql+" "+eventidSql+" ORDER BY message.messagedate " + orderBy;
        sqlCount = "SELECT "+fieldlistSqlCount+" FROM event, message WHERE  "+LogsUserCanViewQueryend+" AND "+reger.Entry.sqlOfLiveEntry+" AND event.accountid='" + accountid + "' AND event.eventid=message.eventid AND message.isapproved='1' "+logidSql+" "+eventidSql+" ORDER BY message.messagedate " + orderBy;


        //Get a count of messages
        int recordcount = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCount= Db.RunSQL(sqlCount);
        //-----------------------------------
        //-----------------------------------
        if (rstCount!=null && rstCount.length>0){
            recordcount = Integer.parseInt(rstCount[0][0]);
        }

        //Start Paging
        int perpage = 50;
        if (currentpage<0){
            currentpage=1;
        }

        StringBuffer pagingOut = new StringBuffer();
        if (recordcount>perpage && eventid<=0){
            pagingOut.append("<tr>");
            pagingOut.append("<td colspan=6>");
            pagingOut.append(reger.pagingLinkPrint.getHtml(recordcount, currentpage, perpage, request));
            pagingOut.append("</td>");
            pagingOut.append("</tr>");
            //And finally put it on the page
            mb.append(pagingOut);
        }
        //Limit vars
        int limitMin = (currentpage * perpage) - perpage;
        int limitMax = perpage;
        String sqlLimit = " LIMIT "+ limitMin +","+ limitMax;
        //End paging

        if (eventid>0){
            sqlLimit = "";
        }


        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL(sql + sqlLimit);
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            for(int i=0; i<rstMessage.length; i++) {
                mb.append("<!-- Begin Message -->");
                mb.append("<tr>");
                mb.append("<td class=logentryheader colspan=3 align=right valign=top>");
                mb.append("&nbsp;");
                mb.append("</td><td colspan=3 class=logentrycontent valign=top align=left>");


                //Date
                //@todo Format the message timestamp with time in addition to date.
                mb.append("Date: ");
                mb.append(reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.gmttousertime(reger.core.TimeUtils.dbstringtocalendar(rstMessage[i][0]), timezoneid)));


                //Url
                mb.append("<br>Name: ");
                if (!rstMessage[i][7].equals("")) {
                    mb.append("<a href=\""+rstMessage[i][7]+"\" rel=\"nofollow\">");
                }
                //Name
                if (!rstMessage[i][1].equals("")) {
                    mb.append(rstMessage[i][1]);
                } else {
                    mb.append("Anonymous");
                }
                //Url
                if (!rstMessage[i][7].equals("")) {
                    mb.append("</a>");
                }
                mb.append("<br>");


                //Message
                String message = reger.NoFollowTag.addNoFollowTagToLinks(rstMessage[i][2]);
                mb.append(message.replaceAll("<", "&lt;"));

                //Link to post
                if (eventid<=0){
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2>");
                    String entryurl=reger.Entry.entryFileNameStatic(Integer.parseInt(rstMessage[i][4]), rstMessage[i][3]);
                    mb.append("From Entry:<br><a href='"+entryurl+"'>"+rstMessage[i][3]+"</a>");
                    mb.append("</font><br>");
                }
                mb.append("</td></tr>");
                mb.append("<!-- End Message -->");
            }
        } else {
            mb.append("<tr>");
            mb.append("<td class=logentrycontent colspan=6 align=left valign=top>");
            mb.append("None.");
            mb.append("</td>");
            mb.append("</tr>");
        }

        //See if a message was just submitted
        boolean messageWasJustSubmitted = false;
        if (request.getParameter("submitmessage")!=null && request.getParameter("submitmessage").equals("true")) {
            messageWasJustSubmitted = true;
        }

        if (eventid>0 && !messageWasJustSubmitted){

            mb.append("<tr>");
            mb.append("<td class=logentryheader  colspan=6 align=left valign=top>");
            mb.append("Add a Message:");
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("<tr>");
            mb.append("<td class=logentryheader colspan=3 align=right valign=top>");

            mb.append("</td>");


            mb.append("<td class=logentrycontent colspan=3 align=left valign=top>");


            mb.append("<form action='"+pagename+"' method=post>");
            mb.append("<input type=hidden name=action value='"+action+"'>");
            mb.append("<input type=hidden name=submitmessage value='true'>");
            mb.append("<input type=hidden name=eventid value='" + eventid + "'>");
            mb.append("<input type=hidden name=logid value='" + logid + "'>");
            mb.append("<input type=hidden name=entrykey value='" + request.getParameter("entrykey") + "'>");

            //Name
            mb.append("<font class=smallfont face=arial size=-2>Name (Optional):</font><br>");
            String messagefrom = "";
            if (request.getParameter("messagefrom")!=null && !request.getParameter("messagefrom").equals("")){
                messagefrom = request.getParameter("messagefrom");
                //Set cookie
                if (request.getParameter("rememberme")!=null && request.getParameter("rememberme").equals("1")){
                    Cookie userCookie = new Cookie("message-name", messagefrom);
                    userCookie.setMaxAge(60*60*24*365);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                //Clear cookie
                } else if (request.getParameter("rememberme")==null){
                    Cookie userCookie = new Cookie("message-name", "");
                    userCookie.setMaxAge(0);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }
            } else {
                if (request.getCookies()!=null){
                    if (!reger.core.Util.getCookieValue(request.getCookies(), "message-name", "").equals("")){
                        messagefrom = reger.core.Util.getCookieValue(request.getCookies(), "message-name", "");
                    }
                }
            }
            mb.append("<input type='text' name='messagefrom' size='15' maxlength='50' value=\""+reger.core.Util.cleanForHtml(messagefrom)+"\"><br>");

            //Email
            mb.append("<font class=smallfont face=arial size=-2>Email Address (Optional, not shown to public.):</font><br>");
            String email = "";
            if (request.getParameter("email")!=null && !request.getParameter("email").equals("")){
                email = request.getParameter("email");
                //Set cookie
                if (request.getParameter("rememberme")!=null && request.getParameter("rememberme").equals("1")){
                    Cookie userCookie = new Cookie("message-email", email);
                    userCookie.setMaxAge(60*60*24*365);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                //Clear cookie
                } else if (request.getParameter("rememberme")==null){
                    Cookie userCookie = new Cookie("message-email", "");
                    userCookie.setMaxAge(0);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }
            } else {
                if (request.getCookies()!=null){
                    if (!reger.core.Util.getCookieValue(request.getCookies(), "message-email", "").equals("")){
                        email = reger.core.Util.getCookieValue(request.getCookies(), "message-email", "");
                    }
                }
            }
            mb.append("<input type='text' name='email' size='15' maxlength='255' value=\""+reger.core.Util.cleanForHtml(email)+"\"><br>");

            //Url
            mb.append("<font class=smallfont face=arial size=-2>URL (Optional):</font><br>");
            String url = "";
            if (request.getParameter("url")!=null && !request.getParameter("url").equals("")){
                url = request.getParameter("url");
                //Set cookie
                if (request.getParameter("rememberme")!=null && request.getParameter("rememberme").equals("1")){
                    Cookie userCookie = new Cookie("message-url", url);
                    userCookie.setMaxAge(60*60*24*365);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                //Clear cookie
                } else if (request.getParameter("rememberme")==null){
                    Cookie userCookie = new Cookie("message-url", "");
                    userCookie.setMaxAge(0);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }
            }  else {
                if (request.getCookies()!=null){
                    if (!reger.core.Util.getCookieValue(request.getCookies(), "message-url", "").equals("")){
                        url = reger.core.Util.getCookieValue(request.getCookies(), "message-url", "");
                    }
                }
            }
            mb.append("<input type='text' name='url' size='15' maxlength='255' value=\""+reger.core.Util.cleanForHtml(url)+"\"><br>");

            //Message
            mb.append("<font class=smallfont face=arial size=-2>Message (Required):</font><br>");
            String message = "";
            if (request.getParameter("message")!=null && !request.getParameter("message").equals("")){
                message = request.getParameter("message");
            }
            mb.append("<textarea cols='20' rows='3' name='message' style='width: 100%;font: 10pt monospace'>"+message+"</textarea><br>");

            //Emailnotify
            String emailnotifyCheck = "";
            if (request.getParameter("emailnotify")!=null && request.getParameter("emailnotify").equals("1")){
                emailnotifyCheck = " checked";
                //Set cookie
                if (request.getParameter("rememberme")!=null && request.getParameter("rememberme").equals("1")){
                    String emailnotifyRequestValue = "";
                    if (request.getParameter("emailnotify")!=null && request.getParameter("emailnotify").equals("1")){
                        emailnotifyRequestValue = "1";
                    }
                    Cookie userCookie = new Cookie("message-emailnotify", emailnotifyRequestValue);
                    userCookie.setMaxAge(60*60*24*365);
                    //userCookie.setDomain(userSession.getAccount().getServername());
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }
            } else {
                //Clear cookie
                Cookie userCookie = new Cookie("message-emailnotify", "");
                userCookie.setMaxAge(0);
                //userCookie.setDomain(userSession.getAccount().getServername());
                userCookie.setPath("/");
                response.addCookie(userCookie);
                if (request.getCookies()!=null){
                    if (!reger.core.Util.getCookieValue(request.getCookies(), "message-emailnotify", "").equals("")){
                        if (reger.core.Util.getCookieValue(request.getCookies(), "message-emailnotify", "0").equals("1")){
                            emailnotifyCheck = " checked";
                        }
                    }
                }
            }
            mb.append("<input type='checkbox' name='emailnotify' value='1' "+emailnotifyCheck+">");
            mb.append("<font class=smallfont face=arial size=-2>Email Me When Somebody Replies (Optional)</font><br>");




            //Rememberme
            String remembermeCheck = "";
            if (request.getParameter("rememberme")!=null && request.getParameter("rememberme").equals("1")){
                remembermeCheck = " checked";
                //Set cookie
                Cookie userCookie = new Cookie("message-rememberme", request.getParameter("rememberme"));
                userCookie.setMaxAge(60*60*24*365);
                //userCookie.setDomain(userSession.getAccount().getServername());
                userCookie.setPath("/");
                response.addCookie(userCookie);
            } else if (request.getParameter("rememberme")==null) {
                //Clear cookie
                Cookie userCookie = new Cookie("message-rememberme", "");
                userCookie.setMaxAge(0);
                //userCookie.setDomain(userSession.getAccount().getServername());
                userCookie.setPath("/");
                response.addCookie(userCookie);
            }
            if (request.getCookies()!=null){
                if (!reger.core.Util.getCookieValue(request.getCookies(), "message-rememberme", "").equals("")){
                    if (reger.core.Util.getCookieValue(request.getCookies(), "message-rememberme", "0").equals("1")){
                        remembermeCheck = " checked";
                    }
                }
            }
            mb.append("<input type='checkbox' name='rememberme' value='1' "+remembermeCheck+">");
            mb.append("<font class=smallfont face=arial size=-2>Remember My Info For Next Time (Optional.  Cookie will be set.)</font><br>");

            mb.append("<br>");
            mb.append("<font class=smallfont face=arial size=-2>Prove that you're human by typing the wavy letters into the box below:</font><br>");
            mb.append("<img src=\"/jcaptcha\" style=\"border: 1px solid #000000;\">");
            mb.append("<br><input type='text' name='j_captcha_response' size=10 maxlength=50 value=''>");

            mb.append("<br><br><input type='submit' value='Submit Message'>");
            mb.append("</form>");


            mb.append("</td>");
            mb.append("</tr>");
        }

        return mb;
    }

    public static StringBuffer tableEnd(){
        StringBuffer mb = new StringBuffer();
        mb.append("</table>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }

    public static StringBuffer saveMessage(String message, String messagefrom, int accountid, int eventid, String email, String ipaddress, String url, boolean emailnotify, reger.UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        int messagesapproval = 1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMsgApproval= Db.RunSQL("SELECT messagesapproval FROM account WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMsgApproval!=null && rstMsgApproval.length>0){
            messagesapproval = Integer.parseInt(rstMsgApproval[0][0]);
        }

        //@todo Before saving a visitor message, make sure there's enough space on the account.

        //Save incoming messages
        int messageid = -1;

        //Convert boolean to string
        String emailnotifystring="0";
        if (emailnotify){
            emailnotifystring="1";
        }

        boolean haveValidMessage = true;
        String errortext = "";
        //Message required
        if (message==null || message.equals("")){
            haveValidMessage = false;
            errortext = errortext + "A message body is required. ";
        }
        //Captcha validation
        Boolean isResponseCorrect =Boolean.FALSE;
        String captchaId = request.getSession().getId();
        String resp = request.getParameter("j_captcha_response");
        try {
            isResponseCorrect = CaptchaServiceSingleton.getInstance().validateResponseForID(captchaId, resp);
        } catch (CaptchaServiceException e) {
             isResponseCorrect = new Boolean(false);
             Debug.errorsave(e, "");
        }
        if (!isResponseCorrect.booleanValue()){
            haveValidMessage = false;
            errortext = errortext + "You failed to enter the letters in the box correctly.  Don't despair.  Sometimes they're tough to read.  Please try again.<br>";
        }

        //Need email address if you want to be notified
        if (emailnotify && (email==null || email.equals(""))){
            haveValidMessage = false;
            errortext = errortext + "You requested that we email you when somebody else posts a message but you didn't enter an email address.  Please enter an email address or uncheck the box. ";
        }
        //No duplicate messages
        //-----------------------------------
        //-----------------------------------
        String[][] rstDupe= Db.RunSQL("SELECT count(*) FROM message WHERE eventid='"+eventid+"' AND messagefrom='"+reger.core.Util.cleanForSQL(messagefrom)+"' AND message='"+reger.core.Util.cleanForSQL(message)+"' AND email='"+reger.core.Util.cleanForSQL(email)+"' AND ipaddress='"+reger.core.Util.cleanForSQL(ipaddress)+"' AND url='"+reger.core.Util.cleanForSQL(url)+"' AND emailnotify='"+reger.core.Util.cleanForSQL(emailnotifystring)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstDupe!=null && rstDupe.length>0){
            //If we have more than one
            if (Integer.parseInt(rstDupe[0][0])>0){
                haveValidMessage = false;
                errortext = errortext + "An identical message from the same person already exists for this entry. ";
            }
        }

        //If we have a valid message, let's continue
        if (haveValidMessage){
            String tmpMessagefrom="";
            if (messagefrom!=null && !messagefrom.equals("")){
                tmpMessagefrom = messagefrom;
            }
            String tmpStatus="0";
            if (messagesapproval==0) {
                tmpStatus="1";
            }
            if (eventid<0){
                eventid=0;
            }

            //-----------------------------------
            //-----------------------------------
            messageid = Db.RunSQLInsert("INSERT INTO message(eventid, messagedate, messagefrom, message, isapproved, sizeinbytes, email, ipaddress, url, emailnotify) VALUES('"+eventid+"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(tmpMessagefrom, 50))+"', '"+reger.core.Util.cleanForSQL(message)+"', '"+tmpStatus+"', '"+reger.core.Util.sizeInBytes(message)+"', '"+reger.core.Util.cleanForSQL(email)+"', '"+reger.core.Util.cleanForSQL(ipaddress)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(emailnotifystring)+"')");
            //-----------------------------------
            //-----------------------------------

            mb.append("<tr>");
            mb.append("<td class=logentrycontent colspan=6 align=left valign=top>");
            if (messagesapproval==1){
                mb.append("<font face=arial size=+1 color=#ff0000><b>Your message has been posted.  It will appear when the site owner approves it.</font>");
            } else {
                mb.append("<font face=arial size=+1 color=#ff0000><b>Your message has been posted.</font>");
            }
            mb.append("</td>");
            mb.append("</tr>");

            //If this account doesn't require message approval, send out email notifications
            if (messagesapproval==0){
                emailNotifications(userSession, eventid);
            }


        } else {
            mb.append("<tr>");
            mb.append("<td class=logentrycontent colspan=6 align=left valign=top>");
            mb.append("<font face=arial size=+1 color=#ff0000><b>There is a problem with your message:  "+errortext+"  Please resubmit your message.</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }


        return mb;
    }

    public static void emailNotifications(reger.UserSession userSession, int eventid){
        //Send out email notifications of a new message
        //-----------------------------------
        //-----------------------------------
        String[][] rstEmailnotify= Db.RunSQL("SELECT DISTINCT message.email, event.title, account.accountemail FROM message, event, account WHERE event.accountid=account.accountid AND event.eventid='"+eventid+"' AND message.eventid=event.eventid AND message.emailnotify='1' AND message.isapproved='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstEmailnotify!=null && rstEmailnotify.length>0){
            for(int i=0; i<rstEmailnotify.length; i++){
                try {
                    //From Address
                    String fromaddress=reger.Vars.EMAILDEFAULTFROM;
                    if (!rstEmailnotify[i][2].equals("")){
                        fromaddress = rstEmailnotify[i][2];
                    }
                    String emailBody = reger.emailtext.BasicEmails.messagesEmailNotify(userSession.getAccount().getSiteRootUrl(), eventid, rstEmailnotify[i][1]).toString();
                    reger.core.EmailSend.sendMail(fromaddress, rstEmailnotify[i][0], "New Message Posted to: " + reger.Vars.getHttpUrlPrefix() + userSession.getAccount().getSiteRootUrl() + "/", emailBody, false);
                    Debug.debug(5, "", "Sending email notification of new message to:" + rstEmailnotify[i][0]);
                } catch (Exception e){
                    Debug.errorsave(e, "");
                }
            }
        }
        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(userSession.getAccount().getAccountid());
    }

}
