package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

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
            if (mySmtpListener!=null){
                mySmtpListener.shutDownSmtpListener();
                mySmtpListener = null;
            }
            mySmtpListener = new reger.core.scheduler.SmtpListener();
        } catch (Exception e){
            reger.core.Util.errorsave(e);
            result = "Unable to start SMTPListener.  Check event log for details.";
        }
    }


}
