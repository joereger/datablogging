package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

/**
 * Expires user sessions
 */
public class ExpireUserSessions implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Expire User Sessions";
    }

    public int getRunEveryXMinutes() {
        return 5;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        reger.AllUserSessions aus = new reger.AllUserSessions();
        int numberOfSessionsExpired = aus.expireSessions();
        result = numberOfSessionsExpired + " user sessions expired.";
    }


}
