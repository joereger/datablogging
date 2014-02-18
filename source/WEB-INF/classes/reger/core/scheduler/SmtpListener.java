package reger.core.scheduler;

import reger.core.Debug;
import reger.util.Num;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class creates a listener with SMTPListenerConnHandler which
 * gives it a raw message by calling gotMailMessage().  This class
 * then passes that raw message on to the api.
 */

public class SmtpListener implements Runnable  {
    ServerSocket slisten;
    Thread thread;
    reger.executionTime execTime;
    boolean isPortSuccessfullyBound = false;
    public static boolean keepMeRunning = true;

    public SmtpListener() {
        execTime=new reger.executionTime();
        if (reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERISON").equals("1")){
            //System.out.println("REGER: New smtplistener being started.");
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }

    public void shutDownSmtpListener(){
        //System.out.println("REGER: SmtpListener.shutDownSmtpListener() called");
        try{
            keepMeRunning = false;
            slisten.close();
            thread = null;
        } catch (Exception e){
            Debug.debug(4, "", e);
        }
    }


    // Callback from SmtpListenerConnHandler
    public synchronized void gotMailMessage(javax.mail.internet.MimeMessage mimeMessage) {
        reger.api.EmailApi emailApi = new reger.api.EmailApi(mimeMessage);
    }

    //Status check called from MasterThread
    public String statusCheck(){
        String status="";
        if (reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERISON").equals("1")){
            if (isPortSuccessfullyBound){
                status = "Listening for " + execTime.getElapsedMillis() + " millis.<br><font face=arial size=-2>IP: " + reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP");
            } else {
                status = "Couldn't bind to port 25.</font><br><font face=arial size=-2>Tried " + execTime.getElapsedMillis() + " millis ago.<br>IP: " + reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP");
            }
        } else {
            status = "Not turned on in System Properties.<br><font face=arial size=-2>(Set variable EMAILLISTENERISON and EMAILLISTENERIP)";
        }
        return status;
    }

    public boolean isRunningAsItShouldBe(){
        if (reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERISON").equals("1")){
            if (isPortSuccessfullyBound){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void run()  {
        bindPort();
    }


    public void bindPort(){
        int port = 25;
        try {

            if (Num.isinteger(reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERPORT"))){
                int portTmp = Integer.parseInt(reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERPORT"));
                if (portTmp>0){
                    port = portTmp;
                }
            }

            System.out.println("Starting SMTP listener on: " + reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP") +" port "+port);

            if (reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP").equals("*")){
                slisten = new ServerSocket(port);
            } else {
                slisten = new ServerSocket(port, 50, InetAddress.getByName(reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP")));
            }
            isPortSuccessfullyBound = true;
            keepMeRunning = true;
            Socket sconn = null;
            SmtpListenerConnHandler smtpHandler = null;
            while(keepMeRunning) {
                sconn = slisten.accept();
                smtpHandler = new SmtpListenerConnHandler(sconn, this);
            }
            //System.out.println("REGER: Freeing up SMTP Listener socket port in SmtpListener.java");
            sconn.close();
            sconn = null;
            smtpHandler = null;
            slisten.close();
            thread = null;
        } catch (java.net.BindException e)  {
            //System.out.println("REGER: SMTP Listener did not bind to port 25: " + e.getMessage());
            e.printStackTrace();
            Debug.debug(4, "", e);
            Debug.debug(4, "", "SMTP Listener did not bind to port "+port+".  Incoming email API will not function properly.");
            //reger.core.EmailSend.sendMail(reger.Vars.EMAILDEFAULTTO, reger.Vars.EMAILDEFAULTTO, "Weblogs SMTP Listener Failed to Bind to Port 25", "This is generally caused by another service running on port 25 or by a conflict with Tomcat on startup.  It can generally be fixed by restarting Tomcat.");
        } catch (java.net.SocketException sockex){
            //System.out.println("REGER: SMTP Listener socket exception: " + sockex.getMessage());
            sockex.printStackTrace();
            Debug.debug(4, "", sockex);
        } catch (Exception e)  {
            //System.out.println("REGER: SMTP Listener general exception: " + e.getMessage());
            e.printStackTrace();
            Debug.errorsave(e, "");
            //reger.core.EmailSend.sendMail(reger.Vars.EMAILDEFAULTTO, reger.Vars.EMAILDEFAULTTO, "Weblogs SMTP Listener Failed to Bind to Port 25", "This is generally caused by another service running on port 25 or by a conflict with Tomcat on startup.  It can generally be fixed by restarting Tomcat.");
        }
        //System.out.println("REGER: SMTP Listener thread at end of run() method.");
    }

    //was port 8025
//    public void bindPortFromConfig(int port){
//
//        System.out.println("Starting SMTP listener on: " + reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP") +" port "+port+" from config");
//        try {
//
//
//
//            System.out.println("Starting SMTP listener on: " + reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP") +" port "+port);
//
//
//            if (reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP").equals("*")){
//                slisten = new ServerSocket(port);
//            } else {
//                slisten = new ServerSocket(port, 50, InetAddress.getByName(reger.systemprops.AllSystemProperties.getProp("EMAILLISTENERIP")));
//            }
//            isPortSuccessfullyBound = true;
//            keepMeRunning = true;
//            Socket sconn = null;
//            SmtpListenerConnHandler smtpHandler = null;
//            while(keepMeRunning) {
//                sconn = slisten.accept();
//                smtpHandler = new SmtpListenerConnHandler(sconn, this);
//            }
//            //System.out.println("REGER: Freeing up SMTP Listener socket port in SmtpListener.java");
//            sconn.close();
//            sconn = null;
//            smtpHandler = null;
//            slisten.close();
//            thread = null;
//        } catch (java.net.BindException e)  {
//            //System.out.println("REGER: SMTP Listener did not bind to port 25: " + e.getMessage());
//            e.printStackTrace();
//            Debug.debug(4, "", e);
//            Debug.debug(4, "", "SMTP Listener did not bind to port from system properties.  Incoming email API will not function properly.");
//            System.out.println("SMTP Listener did not bind to port from system properties.");
//            //reger.core.EmailSend.sendMail(reger.Vars.EMAILDEFAULTTO, reger.Vars.EMAILDEFAULTTO, "Weblogs SMTP Listener Failed to Bind to Port 25", "This is generally caused by another service running on port 25 or by a conflict with Tomcat on startup.  It can generally be fixed by restarting Tomcat.");
//        } catch (java.net.SocketException sockex){
//            //System.out.println("REGER: SMTP Listener socket exception: " + sockex.getMessage());
//            sockex.printStackTrace();
//            Debug.debug(4, "", sockex);
//        } catch (Exception e)  {
//            //System.out.println("REGER: SMTP Listener general exception: " + e.getMessage());
//            e.printStackTrace();
//            Debug.errorsave(e, "");
//            //reger.core.EmailSend.sendMail(reger.Vars.EMAILDEFAULTTO, reger.Vars.EMAILDEFAULTTO, "Weblogs SMTP Listener Failed to Bind to Port 25", "This is generally caused by another service running on port 25 or by a conflict with Tomcat on startup.  It can generally be fixed by restarting Tomcat.");
//        }
//        //System.out.println("REGER: SMTP Listener thread at end of run() method.");
//    }

    public static void main (String args[]) {
	    new SmtpListener();
    }
}

