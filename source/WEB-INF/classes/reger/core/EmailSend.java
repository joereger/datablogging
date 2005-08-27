package reger.core;



/**
 * Send email class.
 */
public class EmailSend {

    public static void sendMail(String from, String to, String subject, String message, boolean isHtmlEmail){
        reger.core.Util.debug(5, "Email Sent<br>To:" +to+"<br>From:" + from + "<br>Subject:" + subject + "<br>Body:" + message + "<br>isHtmlEmail:" + isHtmlEmail);
        try {
            //Kick off a thread to send the email
            reger.core.EmailSendThread eThr = new reger.core.EmailSendThread();
            eThr.setPriority(Thread.MIN_PRIORITY);
            eThr.to = to;
            eThr.from = from;
            eThr.subject = subject;
            eThr.message = message;
            eThr.isHtmlEmail = isHtmlEmail;
            eThr.start();
        }catch (Exception e) {
            reger.core.Util.errorsave(e, "Error starting email thread.  Should have been sending to: " + reger.systemproperties.AllSystemProperties.getProp("EMAILSERVER"));
        }
	}

    public static void sendMail(String from, String to, String subject, String message){
        sendMail(from, to, subject, message, false);
    }




}
