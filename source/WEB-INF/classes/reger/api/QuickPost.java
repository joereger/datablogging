package reger.api;

import reger.core.Debug;
import reger.core.ValidationException;
import reger.core.TimeUtils;
import reger.core.Util;
import reger.core.db.Db;
import reger.Account;
import reger.Accountuser;

import java.util.Calendar;

/**
 * User: Joe Reger Jr
 * Date: Oct 19, 2006
 * Time: 8:47:22 PM
 */
public class QuickPost {

    public static void quickPost(Accountuser accountuser, Account account, String entrytext, int logid){

        //Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        try {


            //Get this user's timezone
            int accountid = account.getAccountid();
            String timezoneid = reger.Account.getTimezoneidFromAccountid(accountid);
            reger.Account accountOfEntry = new reger.Account(accountid);
            reger.PrivateLabel plOfEntry = new reger.PrivateLabel(accountOfEntry.getPlid());
            reger.Accountuser accountuserOfPersonAccessing = accountuser;
            int accountuserid = accountuser.getAccountuserid();

            //Create the entry
            entry = new reger.Entry();
            entry.logid = logid;
            entry.accountid = accountid;

            //Set the title
            String tmpsubj = reger.core.TimeUtils.dateformatFullNoTime(reger.core.TimeUtils.nowInUserTimezone(timezoneid));
            entry.title=reger.core.Util.truncateString(tmpsubj, 255);


            //Set the draft/live status
            entry.isDraft = 0;

            entry.isApproved=1;

            //Set the logid
            entry.logid=logid;


            //Populate the date/time vars in the event object
            entry.dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

            //Set the author in the EmailApi posts.
            entry.accountuserid = accountuserid;

            //Do camphone consolidation of entries into one daily entry.
            //All I need to do is find an entry today... or create one.
            //I need to know the GMT time of the start of today in the user's timezone.
            //I have tmpCal which is now in the user's timezone.
            //Email comes in at servertime and must be converted usertime first.
            //Then inside of eventGeneric.java it's converted to GMT.
            Calendar tmpCal = Calendar.getInstance();
            tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(tmpCal, tmpCal.getTimeZone().getID(), timezoneid);

            //So I should set that time to 00:00:00 in their timezone.
            Calendar startOfDay = reger.core.TimeUtils.xDaysAgoStart(tmpCal, 0);

            //And then convert that value to GMT.
            System.out.println("QuickPost.java +++++++=======+++++++=======");
            System.out.println("QuickPost.java +++++++ dateformatfordb(startOfDay): " +reger.core.TimeUtils.dateformatfordb(startOfDay));
            Calendar startOfDayGMT = reger.core.TimeUtils.usertogmttime(startOfDay, timezoneid);
            System.out.println("QuickPost.java +++++++ dateformatfordb(startOfDayGMT): " +reger.core.TimeUtils.dateformatfordb(startOfDayGMT));

            //And then do the same for the end of the day.
            //Calendar endOfDay = reger.core.TimeUtils.xDaysAgoEnd(tmpCal, 0);
            //System.out.println("QuickPost.java +++++++ dateformatfordb(endOfDay): " +reger.core.TimeUtils.dateformatfordb(endOfDay));

            //And then convert that value to GMT.
            //Calendar endOfDayGMT = reger.core.TimeUtils.usertogmttime(endOfDay, timezoneid);
            Calendar endOfDayGMT = TimeUtils.AddOneDay(startOfDayGMT);
            System.out.println("QuickPost.java +++++++ dateformatfordb(endOfDayGMT): " +reger.core.TimeUtils.dateformatfordb(endOfDayGMT));

            //Debug.debug(3, "QuickPost", "timezoneid:"+timezoneid+"<br>reger.core.TimeUtils.dateformatfordb(tmpCal): " +reger.core.TimeUtils.dateformatfordb(tmpCal)+ "<br>reger.core.TimeUtils.dateformatfordb(startOfDay): " +reger.core.TimeUtils.dateformatfordb(startOfDay)+ "<br>reger.core.TimeUtils.dateformatfordb(startOfDayGMT):" + reger.core.TimeUtils.dateformatfordb(startOfDayGMT) + "<br>reger.core.TimeUtils.dateformatfordb(endOfDay): " + reger.core.TimeUtils.dateformatfordb(endOfDay) + "<br>reger.core.TimeUtils.dateformatfordb(endOfDayGMT): " + reger.core.TimeUtils.dateformatfordb(endOfDayGMT));

            //And then search for an eventid within this range.
            String sql = "SELECT eventid, comments FROM event WHERE date>'"+reger.core.TimeUtils.dateformatfordb(startOfDayGMT)+"' AND date<'"+reger.core.TimeUtils.dateformatfordb(endOfDayGMT)+"' AND logid='"+logid+"' AND accountid='"+accountid+"' AND title='"+reger.core.Util.cleanForSQL(entry.title)+"' ORDER BY eventid DESC LIMIT 0,1";
            System.out.println(sql);
            //-----------------------------------
            //-----------------------------------
            String[][] rstEventToday= Db.RunSQL(sql);
            //-----------------------------------
            //-----------------------------------
            if (rstEventToday!=null && rstEventToday.length>0){
                //And if there is one, set entry.eventid to it.
                if (reger.core.Util.isinteger(rstEventToday[0][0])){
                    entry.eventid = Integer.parseInt(rstEventToday[0][0]);
                    entry.comments = rstEventToday[0][1];
                }
            } else {
                //And if there isn't one, create one with a call to entry.newEntryAll();
                entry.newEntryTemporary(accountOfEntry, accountuserOfPersonAccessing);
            }
            //Set the body of the entry... called comments... poorly
            String datestamp = TimeUtils.dateformattimeWithAMPM(TimeUtils.nowInUserTimezone(timezoneid));
            String lineBr = "";
            if (entry.comments.length()>0){
                lineBr = "\r\n" + "\r\n";
            }
            entry.comments = entry.comments + lineBr + datestamp + ": " + entrytext;
            //Save/update it
            try{
                entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
            } catch (ValidationException error){
                Debug.debug(3, "QuickPost", "QuickPost.java - There was an error in QuickPost.java:" + error.getErrorsAsSingleString());
                return;
            }
        } catch (Exception e){
            Debug.errorsave(e, "QuickPost", "QuickPost.java");
        }




    }




}
