package reger.episodes;

import reger.core.db.Db;
import reger.Entry;
import reger.AddToArray;
import reger.core.Debug;

import java.util.*;

/**
 * Represents a single episode in the system
 */
public class Episode {

    private int episodeid;
    private String name;
    private int accountid;
    private String description;
    private boolean isprivate;
    private reger.Entry[] entriesInEpisode;
    private Calendar startDateGMT;
    private Calendar endDateGMT;
    private int defaultScaleOfDisplay;
    private int numberOfDefaultScalePeriodsInEpisode;
    private ArrayList episodeTimePeriodBuckets;

    public static final int SCALEMINUTES = 1;
    public static final int SCALEHOURS = 2;
    public static final int SCALEDAYS = 3;
    public static final int SCALEWEEKS = 4;
    public static final int SCALEMONTHS = 5;
    public static final int SCALEYEARS = 6;

    private String timezoneid = "GMT";


    public Episode(int episodeid, reger.Accountuser accountUser){
        load(episodeid, accountUser);
    }

    public Episode(Episode episode){
        this.episodeid = episode.episodeid;
        this.name = episode.name;
        this.accountid = episode.accountid;
        this.description = episode.description;
        this.isprivate = episode.isprivate;
        this.entriesInEpisode = episode.entriesInEpisode;
        this.startDateGMT = episode.startDateGMT;
        this.endDateGMT = episode.endDateGMT;
        this.defaultScaleOfDisplay = episode.defaultScaleOfDisplay;
        this.numberOfDefaultScalePeriodsInEpisode = episode.numberOfDefaultScalePeriodsInEpisode;
        this.episodeTimePeriodBuckets = episode.episodeTimePeriodBuckets;
    }

    public Episode(String name, int accountid, String description, boolean isprivate, reger.Entry[] entriesInEpisode){
        this.name = name;
        this.accountid = accountid;
        this.description = description;
        this.isprivate = isprivate;
        this.entriesInEpisode = entriesInEpisode;
        populateStartAndEndDates();
        chooseDefaultScaleToDisplay();
    }

    public void load(int episodeid, reger.Accountuser accountUser){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEpisode= Db.RunSQL("SELECT episodeid, name, episode.accountid, description, isprivate, account.timezoneid FROM episode, account WHERE episodeid='"+episodeid+"' AND episode.accountid=account.accountid");
        //-----------------------------------
        //-----------------------------------
        if (rstEpisode!=null && rstEpisode.length>0){
            this.episodeid = Integer.parseInt(rstEpisode[0][0]);
            this.name = rstEpisode[0][1];
            this.accountid = Integer.parseInt(rstEpisode[0][2]);
            this.description = rstEpisode[0][3];
            this.isprivate = reger.core.Util.booleanFromSQLText(rstEpisode[0][4]);
            this.timezoneid = rstEpisode[0][5];

            if (accountUser!=null){
                Debug.debug(5, "", "Episode.java: accountUser!=null.");
                Debug.debug(5, "", "Episode.java: " + "SELECT event.eventid, event.title, event.comments, event.date FROM eventtoepisode, event, megalog WHERE eventtoepisode.eventid=event.eventid AND event.logid=megalog.logid AND episodeid='"+this.episodeid+"' AND " + accountUser.LogsUserCanViewQueryend(accountid));

                //Populate entries that belong to this episode
                //-----------------------------------
                //-----------------------------------
                String[][] rstEntries= Db.RunSQL("SELECT event.eventid, event.title, event.comments, event.date FROM eventtoepisode, event, megalog WHERE eventtoepisode.eventid=event.eventid AND event.logid=megalog.logid AND episodeid='"+this.episodeid+"' AND " + accountUser.LogsUserCanViewQueryend(accountid));
                //-----------------------------------
                //-----------------------------------
                entriesInEpisode = new reger.Entry[0];
                if (rstEntries!=null && rstEntries.length>0){
                    Debug.debug(5, "", "Episode.java: rstEntries.length="+rstEntries.length);
                    for(int i=0; i<rstEntries.length; i++){
                        //Create an entry object and manually populate it
                        reger.Entry entry = new reger.Entry(Integer.parseInt(rstEntries[i][0]), rstEntries[i][1], reger.core.Util.truncateString(rstEntries[i][2], 150), reger.core.TimeUtils.dbstringtocalendar(rstEntries[i][3]));
                        //Add it to the array of entries
                        entriesInEpisode = AddToArray.addToEntryArray(entriesInEpisode, entry);
                    }
                    Debug.debug(5, "", "Episode.java: entriesInEpisode.length="+entriesInEpisode.length);
                }
            } else {
                Debug.debug(5, "", "Episode.java: accountUser==null.");
            }

            //Populate start and end dates of episode
            populateStartAndEndDates();

            //Choose optimal scale for display
            chooseDefaultScaleToDisplay();

            //Put the entries into the buckets
            putEntriesIntoBuckets();

        }

    }

    public void populateStartAndEndDates(){
        StringBuffer debug = new StringBuffer();
        for (int i = 0; i < entriesInEpisode.length; i++) {
            Entry entry = entriesInEpisode[i];

            Calendar entryDate = reger.core.TimeUtils.formtocalendar(entry.yyyy, entry.mm+1, entry.dd, entry.h, entry.m, 0, entry.ampm);

            debug.append("<br><br>eventid=" + entry.eventid + "<br>entryDate=" + reger.core.TimeUtils.dateformatfordb(entryDate));

            if (startDateGMT==null || entryDate.before(startDateGMT)){
                startDateGMT = entryDate;
            }

            if (endDateGMT==null || entryDate.after(endDateGMT)){
                endDateGMT = entryDate;
            }

        }

        debug.append("<br><br>startDateGMT=" + reger.core.TimeUtils.dateformatfordb(startDateGMT));
        debug.append("<br><br>endDateGMT=" + reger.core.TimeUtils.dateformatfordb(endDateGMT));
        Debug.debug(5, "", debug.toString());
    }

    public void chooseDefaultScaleToDisplay(){
        //Goal is to find an optimal number of buckets to fit between the start and end dates .
        int targetNumberOfBuckets = 6;

        HashMap numOfPeriodsInEpisode = new HashMap();

        //Units for reger.core.Util.datediff: "year", "month", "week", "day", "hour", "minute"
        numOfPeriodsInEpisode.put(new Integer(SCALEMINUTES) , new Integer(reger.core.DateDiff.dateDiff("minute", endDateGMT, startDateGMT)));
        numOfPeriodsInEpisode.put(new Integer(SCALEHOURS) , new Integer(reger.core.DateDiff.dateDiff("hour", endDateGMT, startDateGMT)));
        numOfPeriodsInEpisode.put(new Integer(SCALEDAYS) , new Integer(reger.core.DateDiff.dateDiff("day", endDateGMT, startDateGMT)));
        numOfPeriodsInEpisode.put(new Integer(SCALEWEEKS) , new Integer(reger.core.DateDiff.dateDiff("week", endDateGMT, startDateGMT)));
        numOfPeriodsInEpisode.put(new Integer(SCALEMONTHS) , new Integer(reger.core.DateDiff.dateDiff("month", endDateGMT, startDateGMT)));
        numOfPeriodsInEpisode.put(new Integer(SCALEYEARS) , new Integer(reger.core.DateDiff.dateDiff("year", endDateGMT, startDateGMT)));

        //Now find the value closest to the target
        defaultScaleOfDisplay = SCALEDAYS;
        int closestAbsoluteDistanceFromTarget = -1;

        for (Iterator i=numOfPeriodsInEpisode.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //e.getKey()
            //e.getValue()

            int proposedNumberOfBuckets = ((Integer)e.getValue()).intValue() + 2;

            Debug.debug(5, "", "Episode.java: Iterating numOfPeriodsInEpisode.<br>e.getKey()=" + e.getKey() + "<br>e.getValue()=" + e.getValue() + "<br>proposedNumberOfBuckets=" + proposedNumberOfBuckets);

            int distanceFromTarget =  Math.abs(targetNumberOfBuckets - proposedNumberOfBuckets);

            Debug.debug(5, "", "Episode.java: distanceFromTarget=" + distanceFromTarget);

            if (distanceFromTarget==0){
                Debug.debug(5, "", "Episode.java: It's right on the target number of buckets.");
                defaultScaleOfDisplay = ((Integer)e.getKey()).intValue();
                numberOfDefaultScalePeriodsInEpisode = proposedNumberOfBuckets;
                break;
            }
            if (distanceFromTarget<closestAbsoluteDistanceFromTarget || closestAbsoluteDistanceFromTarget==-1){
                Debug.debug(5, "", "Episode.java: Not on target, but closer than the current value.");
                closestAbsoluteDistanceFromTarget = distanceFromTarget;
                defaultScaleOfDisplay = ((Integer)e.getKey()).intValue();
                numberOfDefaultScalePeriodsInEpisode = proposedNumberOfBuckets;
            }
        }

    }

    public void putEntriesIntoBuckets(){

        StringBuffer debug = new StringBuffer();

        debug.append("Episode.java.putEntriesIntoBuckets()");
        debug.append("<br>getNameOfScale()=" + getNameOfScale());

        episodeTimePeriodBuckets = new ArrayList();

        if (entriesInEpisode!=null && entriesInEpisode.length>0){

            //To make sure I don't overwrite the start date
            Calendar startDateGMT = reger.core.TimeUtils.gmttousertime((Calendar)this.startDateGMT.clone(), timezoneid);
            Calendar endDateGMT = reger.core.TimeUtils.gmttousertime((Calendar)this.endDateGMT.clone(), timezoneid);

            debug.append("<br><br>Initial startDateGMT=" + reger.core.TimeUtils.dateformatfordb(startDateGMT));
            debug.append("<br>Initial endDateGMT=" + reger.core.TimeUtils.dateformatfordb(endDateGMT));

            //Important that I set the start date to the start of the unit.
            //For example, if the unit is days, this should be 12:00AM of that day
            if (defaultScaleOfDisplay==SCALEMINUTES){
                startDateGMT = reger.core.TimeUtils.xMinutesAgoStart(startDateGMT, 0);
            } else if (defaultScaleOfDisplay==SCALEHOURS){
                startDateGMT = reger.core.TimeUtils.xHoursAgoStart(startDateGMT, 0);
            } else if (defaultScaleOfDisplay==SCALEDAYS){
                startDateGMT = reger.core.TimeUtils.xDaysAgoStart(startDateGMT, 0);
            } else if (defaultScaleOfDisplay==SCALEWEEKS){
                startDateGMT = reger.core.TimeUtils.xWeeksAgoStart(startDateGMT, 0);;
            } else if (defaultScaleOfDisplay==SCALEMONTHS){
                startDateGMT = reger.core.TimeUtils.xMonthsAgoStart(startDateGMT, 0);
            } else if (defaultScaleOfDisplay==SCALEYEARS){
                startDateGMT = reger.core.TimeUtils.xYearsAgoStart(startDateGMT, 0);
            }

            debug.append("<br><br>Final startDateGMT=" + reger.core.TimeUtils.dateformatfordb(startDateGMT));
            debug.append("<br>Final endDateGMT=" + reger.core.TimeUtils.dateformatfordb(endDateGMT));

            int timePeriodBucket = 1;
            while (timePeriodBucket<=numberOfDefaultScalePeriodsInEpisode){
                //Create an int array to hold the events that fall into this bucket
                reger.Entry[] eventsInThisPeriod = new reger.Entry[0];

                //Iterate records returned
                for (int i = 0; i < entriesInEpisode.length; i++) {
                    Entry entry = entriesInEpisode[i];

                    //Calculate the min and max dates for this period... this may be inefficient
                    Calendar min = ((Calendar)startDateGMT.clone());
                    min.add(lookupCalendarDateFromEpisodeDate(), timePeriodBucket-1);
                    Calendar max = ((Calendar)startDateGMT.clone());
                    max.add(lookupCalendarDateFromEpisodeDate(), timePeriodBucket);

                    debug.append("<br><br>timePeriodBucket=" + timePeriodBucket);
                    debug.append("<br>min=" + reger.core.TimeUtils.dateformatfordb(min));
                    debug.append("<br>max=" + reger.core.TimeUtils.dateformatfordb(max));

                    //Get the event's date
                    Calendar entryDate = reger.core.TimeUtils.formtocalendar(entry.yyyy, entry.mm+1, entry.dd, entry.h, entry.m, 0, entry.ampm);
                    debug.append("<br>entryDate(before timezone)=" + reger.core.TimeUtils.dateformatfordb(entryDate));

                    entryDate = reger.core.TimeUtils.gmttousertime(entryDate, timezoneid);

                    debug.append("<br>entryDate(after timezone)=" + reger.core.TimeUtils.dateformatfordb(entryDate));

                    //See if this event falls into the current timePeriodBucket
                    if ((entryDate.after(min) && entryDate.before(max)) || entryDate.equals(min) || entryDate.equals(max)){
                        eventsInThisPeriod = AddToArray.addToEntryArray(eventsInThisPeriod, entry);
                        debug.append("<br>eventid="+entry.eventid+" is included in timePeriodBucket "+timePeriodBucket+".");
                    } else {
                        debug.append("<br>eventid="+entry.eventid+" is NOT included in timePeriodBucket "+timePeriodBucket+".");
                    }

                }


                //Store the array of eventids into the correct bucket
                episodeTimePeriodBuckets.add(timePeriodBucket-1, eventsInThisPeriod);

                //Increment the bucket
                timePeriodBucket = timePeriodBucket + 1;



            }
        }

        Debug.debug(5, "", debug.toString());

    }


    private int lookupCalendarDateFromEpisodeDate(){
        if (defaultScaleOfDisplay==SCALEMINUTES){
            return Calendar.MINUTE;
        }
        if (defaultScaleOfDisplay==SCALEHOURS){
            return Calendar.HOUR;
        }
        if (defaultScaleOfDisplay==SCALEDAYS){
            return Calendar.DATE;
        }
        if (defaultScaleOfDisplay==SCALEWEEKS){
            return Calendar.WEEK_OF_YEAR;
        }
        if (defaultScaleOfDisplay==SCALEMONTHS){
            return Calendar.MONTH;
        }
        if (defaultScaleOfDisplay==SCALEYEARS){
            return Calendar.YEAR;
        }
        return Calendar.DATE;
    }

    public String getNameOfScale(){
        if (defaultScaleOfDisplay==SCALEMINUTES){
            return "Minutes";
        }
        if (defaultScaleOfDisplay==SCALEHOURS){
            return "Hours";
        }
        if (defaultScaleOfDisplay==SCALEDAYS){
            return "Days";
        }
        if (defaultScaleOfDisplay==SCALEWEEKS){
            return "Weeks";
        }
        if (defaultScaleOfDisplay==SCALEMONTHS){
            return "Months";
        }
        if (defaultScaleOfDisplay==SCALEYEARS){
            return "Years";
        }
        return "";
    }

    public void save() throws reger.core.ValidationException{
        reger.core.ValidationException error = new reger.core.ValidationException();
        if (name.equals("")){
            name="Episode";
        }
        if (accountid<=0){
            error.addValidationError("An accountid is required for the Episode to be saved.");
        }
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE episode SET name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"', description='"+reger.core.Util.cleanForSQL(description)+"' , isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"' WHERE episodeid='"+episodeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (count<=0){
            //-----------------------------------
            //-----------------------------------
            episodeid = Db.RunSQLInsert("INSERT INTO episode(name, accountid, description, isprivate) VALUES('"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"', description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"')");
            //-----------------------------------
            //-----------------------------------

            //Update the AccountCounts cache
            reger.cache.AccountCountCache.flushByAccountid(accountid);
        }

    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM episode WHERE episodeid='"+episodeid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM eventtoepisode WHERE episodeid='"+episodeid+"'");
        //-----------------------------------
        //-----------------------------------

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);
    }

    public void removeEntryFromEpisode(int eventid){
        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM eventtoepisode WHERE episodeid='"+episodeid+"' AND eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getEpisodeid() {
        return episodeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }

    public int getNumberOfDefaultScalePeriodsInEpisode() {
        return numberOfDefaultScalePeriodsInEpisode;
    }

    public int getDefaultScaleOfDisplay() {
        return defaultScaleOfDisplay;
    }

    public Calendar getEndDateGMT() {
        return endDateGMT;
    }

    public Calendar getStartDateGMT() {
        return startDateGMT;
    }

    public reger.Entry[] getEntriesInEpisode() {
        return entriesInEpisode;
    }

    public void setEntriesInEpisode(reger.Entry[] entriesInEpisode) {
        this.entriesInEpisode = entriesInEpisode;
    }

    public ArrayList getEpisodeTimePeriodBuckets() {
        return episodeTimePeriodBuckets;
    }
}
