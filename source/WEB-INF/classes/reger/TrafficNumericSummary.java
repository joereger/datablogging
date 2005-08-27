package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * Outputs WML traffic summaries
 */
public class TrafficNumericSummary {

    public static int countMessages(int accountid) {
        int countMessages=0;

        //@todo Check the mobile message status in the sql below... make sure it correctly identifies new messages.
        //-----------------------------------
        //-----------------------------------
        String[][] rstTotalEntries= Db.RunSQL("SELECT count(*) FROM message, event WHERE message.eventid=event.eventid AND "+reger.Entry.sqlOfLiveEntry+" AND message.isapproved='0' AND event.accountid='"+ accountid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTotalEntries!=null && rstTotalEntries.length>0){
        	countMessages=Integer.parseInt(rstTotalEntries[0][0]);
        }

        return countMessages;
    }

    public static int countAll(Account account, int daysago){
        //Only upgraded customers get to see today's traffic
        String appendsql="";
        if (account.isPro()) {
            appendsql=" AND datetime<'" + getTimeAgo(1, account.getTimezoneid()) + "'";
        }

        int countAll=0;


        //-----------------------------------
        //-----------------------------------
        String[][] rstTotalEntries= Db.RunSQL("SELECT SUM(count) FROM traffic WHERE datetime>'"+ getTimeAgo(daysago, account.getTimezoneid()) +"' AND (traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICENTRYDETAIL+"' OR traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICHOMEPAGE+"' OR traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICLOGSECTION+"' OR traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICMISC+"') AND accountid='"+ account.getAccountid() +"'"+appendsql);
        //-----------------------------------
        //-----------------------------------
        if (rstTotalEntries!=null && rstTotalEntries.length>0){
            if (reger.core.Util.isinteger(rstTotalEntries[0][0])){
        	    countAll=Integer.parseInt(rstTotalEntries[0][0]);
            }
        }

        return countAll;
    }

    public static int countHome(Account account, int daysago){
        //Only upgraded customers get to see today's traffic
        String appendsql="";
        if (account.isPro()) {
            appendsql=" AND datetime<'" + getTimeAgo(1, account.getTimezoneid()) + "'";
        }

        int countHome=0;

        //-----------------------------------
        //-----------------------------------
        String[][] rstTotalEntries= Db.RunSQL("SELECT SUM(count) FROM traffic WHERE datetime>'"+ getTimeAgo(daysago, account.getTimezoneid()) +"' AND traffictypeid='"+reger.Vars.TRAFFICTYPEPUBLICHOMEPAGE+"' AND accountid='"+ account.getAccountid() +"'"+appendsql);
        //-----------------------------------
        //-----------------------------------
        if (rstTotalEntries!=null && rstTotalEntries.length>0){
            if (reger.core.Util.isinteger(rstTotalEntries[0][0])){
        	    countHome=Integer.parseInt(rstTotalEntries[0][0]);
            }
        }

        return countHome;

    }

    public static int countEntries(Account account, int daysago){
        //Only upgraded customers get to see today's traffic
        String appendsql="";
        if (account.isPro()) {
            appendsql=" AND datetime<'" + getTimeAgo(1, account.getTimezoneid()) + "'";
        }

        int countEntries=0;

        //-----------------------------------
        //-----------------------------------
        String[][] rstTotalEntries= Db.RunSQL("SELECT SUM(traffic.count) FROM traffic, event WHERE traffic.datetime>'"+ getTimeAgo(daysago, account.getTimezoneid()) +"' AND traffic.eventid=event.eventid AND traffic.eventid>0 AND traffic.accountid='"+ account.getAccountid() +"'"+ appendsql);
        //-----------------------------------
        //-----------------------------------
        if (rstTotalEntries!=null && rstTotalEntries.length>0){
            if (reger.core.Util.isinteger(rstTotalEntries[0][0])){
        	    countEntries=Integer.parseInt(rstTotalEntries[0][0]);
            }
        }

        return countEntries;

    }


    public static String getTimeAgo(int daysago, String timezoneid) {

        //Get now in user's timezone
        Calendar cal = reger.core.TimeUtils.nowInUserTimezone(timezoneid);

        //Get beginning of x days ago in the user's timezone
        cal = reger.core.TimeUtils.xDaysAgoStart(cal, daysago);

        //Convert to a gmt time for query
        cal = reger.core.TimeUtils.usertogmttime(cal, timezoneid);

        //Convert to a string
        return reger.core.TimeUtils.dateformatfordb(cal);

    }


}
