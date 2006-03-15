package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;

/**
 *
 */
public class StartSmtpListener implements ScheduledTask{

    private String result = "";
    private static reger.core.scheduler.SmtpListener mySmtpListener;

    public String getTaskName() {
        return "Smtp/Inbound Email Listener";
    }

    public int getRunEveryXMinutes() {
        return 1;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        if (mySmtpListener==null || !mySmtpListener.isRunningAsItShouldBe()){
            startListener();
        }
        result = mySmtpListener.statusCheck();
    }

    private void startListener(){
        try{
            //System.out.println("REGER: Starting smtp listener.");
            if (mySmtpListener!=null){
                //System.out.println("REGER: Shutting down smtp listener for a clean startup.");
                mySmtpListener.shutDownSmtpListener();
                mySmtpListener = null;
            }
            mySmtpListener = new reger.core.scheduler.SmtpListener();
        } catch (Exception e){
            Debug.errorsave(e, "");
            //System.out.println("REGER: Unable to start smtp listener:"+e.getMessage());
            result = "Unable to start SMTPListener.  Check event log for details.";
        }
    }

    public static void shutdownListener(){
        //System.out.println("REGER: Shutting down smtp listener.");
        if (mySmtpListener!=null){
            //System.out.println("REGER: Listener not null so will shut down.");
            mySmtpListener.shutDownSmtpListener();
            mySmtpListener = null;
        }
    }


}
