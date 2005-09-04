package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;
import reger.core.db.Db;
import reger.core.TimeUtils;
import reger.core.Debug;
import reger.Account;

import java.util.Calendar;

/**
 * Expires user sessions
 */
public class DoBilling implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Do Billing Checks";
    }

    public int getRunEveryXMinutes() {
        return 60;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        int numOfDaysBetweenChecks = 30;
        int numOfHoursBetweenChecks = numOfDaysBetweenChecks * 24;
        int numberOfAccountsChecked = 0;

        Calendar cutoffTime = TimeUtils.xHoursAgoStart(TimeUtils.nowInGmtCalendar(), numOfHoursBetweenChecks);

        String sql = "SELECT accountid FROM account WHERE lastbillingcheck<'"+reger.core.TimeUtils.dateformatfordb(cutoffTime)+"' OR lastbillingcheck IS NULL ORDER BY accountid ASC";

        Debug.debug(3, "", "DoBilling.java<br>"+sql);

        //-----------------------------------
        //-----------------------------------
        String[][] rstAcct= Db.RunSQL(sql, 500000);
        //-----------------------------------
        //-----------------------------------
        if (rstAcct!=null && rstAcct.length>0){
            Debug.debug(3, "", "DoBilling.java<br>" + rstAcct.length + " accounts to be checked.");
            for(int i=0; i<rstAcct.length; i++){
                Account acct = new Account(Integer.parseInt(rstAcct[i][0]));
                numberOfAccountsChecked = numberOfAccountsChecked + 1;
                acct.doBilling();
            }
        }

        result = numberOfAccountsChecked + " account licenses checked.";
    }


}
