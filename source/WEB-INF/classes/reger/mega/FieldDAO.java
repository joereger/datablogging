package reger.mega;

/**
 * FieldDAO defines an interface to save and retrieve data from the database
 */
public interface FieldDAO {

    /**
     * Checks to see if data exists already, editing if so, creating if not.
     */
    public void saveData(int megafieldid, int eventid, int logid);

    /**
     * Gets data for a particular field of an event.
     */
    public void loadData(int megafieldid, int eventid, int logid);



    /**
     * Checks to see if data exists already, editing if so, creating if not.
     */
    public void saveDefaultData(int megafieldid, int logid);

    /**
     * Gets default data for a particular field of an event.
     */
    public void loadDefaultData(int megafieldid, int logid);

    /**
     * Accepts an array of ints which represent eventids.
     * Goes to DB with one call and gets the values requested for those eventids.
     * Returns TreeMap of form data(eventid, megavalue)
     */
    public java.util.TreeMap loadDataForMultipleEvents(int[] eventids, Field field);

    /**
     * Deletes data for a particular eventid.
     */
    public void deleteData(int megafieldid, int eventid);

    /**
     * Move to new logid.  Some data storage methods, like
     * megaoption have a logid dependency.  Some don't.
     */
    public void moveDataToNewLogid(int megafieldid, int eventid, int oldlogid, int newlogid);

    /**
     * Move to new eventid.  All data will be moved.  The sourceeventid will no longer have the data.
     */
    public void moveDataToNewEventid(int megafieldid, int sourceeventid, int desteventid);

    /**
     * Copy to new eventid.  All data will be copied.  The sourceeventid will still have the data.
     */
    public void copyDataToNewEventid(int megafieldid, int sourceeventid, int desteventid);


    /**
     * Deletes data for a. entire megafieldid.  Very dangerous function!
     */
    public void deleteAllDataForAFieldAcrossAllLogsAndEntries(int megafieldid);

    /**
     * Fields can have default system values and options (data) that stay with
     * them for all users.  This data is setup with the logtype (not log) on
     * logs-field.log.  The type of data that can be stored is dependent
     * on the FieldDAO that is used for the FieldType.
     * So, this method in FieldType is little more than a way to pass the request to FieldDAO
     * which will send back a string of HTML to pass to the screen.  All
     * configurations must be done with a simple request form back and forth.
     * Form elements will ne named "systemconfig-*" to avoid collission. Only
     * one FieldType's similar method will be called and displayed on a form at
     * any given time.
     */
    public String processSystemDefaultDataConfig(javax.servlet.http.HttpServletRequest request, int megafieldid);

    /**
     * Whether or not any data exists in the database for this megafieldid.
     * This is a precursor to either deletion or hiding
     */
    boolean isThereDataForFieldInDB(int megafieldid);

}
