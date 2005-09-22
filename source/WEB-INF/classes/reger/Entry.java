package reger;

import reger.core.db.Db;
import reger.core.ValidationException;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.linkrot.AnchorFinder;
import reger.cache.LogCache;

import java.util.Calendar;
import java.util.ArrayList;

/**
 * Represents an entry
 */
public class Entry {

    //Public Properties
    public int accountid;
    public int accountuserid;
    public int eventid=-1;
    public int logid=-1;

    //Some basic entry fields
    public String title="";
    public String comments="";
    public int favorite=0;
    public int isDraft=0;
    public int isApproved=-1;
    public int istemporary = 0;
    private Calendar lastmodifiedbyuserdate;

    /**
     * Here's how these moderator approval flags work:
     *
     *                              / Live Approved  / Declined   / Pending
     * requiresmoderatorapproval    |      0         |     0      |    1
     * ismoderatorapproved          |      1         |     0      |   0/1
     * isflaggedformoderator        |     0/1        |    0/1     |   0/1
     *
     * Note that the isflaggedformoderator doesn't actually play a role in
     * the live/hidden nature of the entry.  It's just a flag telling
     * moderators that they may want to check it out.
     */
    public int requiresmoderatorapproval = 0;
    public int ismoderatorapproved = 1;
    public int isflaggedformoderator = 0;

    //This important piece of SQL should be used any time you want to show only live entries.
    //Live entries are considered the primary entry.
    //All others are backup versioninfo, pending changes for moderator approval or temporary entries.
    public static final String sqlOfLiveEntry = "(event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0')";

    public String author="";

    public Calendar dateGmt;

    //public int mm=1;
    //public int dd=1;
    //public int yyyy=2004;
    //public int h=12;
    //public int m=0;
    //public String ampm="AM";

    public int eventtypeid;

    public Location location;

    //Error flags and errortext storage
    //public String errortext = "";
    //public boolean gooddata = true;

    //Trackback
    public String trackbackurl = "";

    //Spelling check vars
    public boolean dospellcheck = false;
    public boolean haveSpellingErrors = false;
    public String textWithSuggestionsAsDropdowns = "";
    public String originalEntryTextBeforeSpellcheck = "";
    public ArrayList spellCheckEvents = null;

    //MegaData validation flag
    public boolean validateRequiredFields = true;

    //This important property holds all of the MegaData fields for this entry
    public reger.mega.FieldType[] fields = null;

    //Groups
    int[] groupsubscriptionids = null;
    String entryKey;

    //Episodes
    int[] episodesThisEntryBelongsTo = null;
    String newepisodename;
    String newepisodedescription;

    //Counts
    int messagecount = 0;
    int filecount = 0;

    /**
     * Constructor:
     */
    public Entry(int eventid){
        getEntryAll(eventid);
    }

//    /**
//     * Constructor: minimal load just for searching
//     */
//    public Entry(int eventid, int[] megafieldidsToLoad){
//        loadMinEntryForSearch(eventid, megafieldidsToLoad);
//    }

    /**
     * Constructor used to manually populate an entry.
     */
    public Entry(int eventid, String title, String comments, Calendar cal){
        this.eventid = eventid;
        this.title = title;
        this.comments = comments;
        this.dateGmt = cal;
    }


    /**
     * Constructor:
     */
//    public Entry(reger.Accountuser accountuserOfPersonAccessing, reger.Account accountOfEntry, reger.PrivateLabel plOfEntry, int logid, javax.servlet.http.HttpServletRequest request){
//        populate(plOfEntry, logid, request, "XOXOXOXO");
//    }

    /**
     * Constructor:
     */
//    public Entry(reger.Accountuser accountuserOfAuthor, reger.Account accountOfEntry, reger.PrivateLabel plOfEntry, int logid){
//        populate(plOfEntry, logid, null, "XOXOXOXO");
//    }


    public void populate(int logid, javax.servlet.http.HttpServletRequest request, String timezoneid){
        //Set logid
        this.logid=logid;
        if (request!=null){
            //Fills in generic fields like title, comments, etc.
            populateGenericObjectFromRequest(request, timezoneid);
            //Puts megadata fields into megafieldvalues hashtable.
            populateMegafieldValuesFromRequest(request);
        }
    }

    /**
     * Constructor:
     * I don't like this empty constructor.  Should be more validation.
     */
    public Entry(){
        //@todo Find Usages of this empty Entry constructor and squash them.

    }



    private void populateGenericObjectFromRequest(javax.servlet.http.HttpServletRequest request, String timezoneid){
        reger.core.Debug.debug(4, "Entry.java", "Entry.populateGenericObjectFromRequest().");

        if (request.getParameter("logid")!=null && reger.core.Util.isinteger(request.getParameter("logid"))) {
            this.logid=Integer.parseInt(request.getParameter("logid"));
        }
        if (request.getParameter("eventid")!=null && reger.core.Util.isinteger(request.getParameter("eventid"))) {
            this.eventid=Integer.parseInt(request.getParameter("eventid"));
        }
        if (request.getParameter("title")!=null) {
            this.title=request.getParameter("title");
        }
        if (request.getParameter("originalEntryTextBeforeSpellcheck")!=null) {
            this.originalEntryTextBeforeSpellcheck=request.getParameter("originalEntryTextBeforeSpellcheck");
        }
        if (request.getParameter("comments")!=null) {
            //Get the main form entry
            this.comments=request.getParameter("comments");
            //Now, deal with spell check situation if the usespellingrecommendations radio is selected
            if ((request.getParameter("usespellingrecommendations")!=null) && reger.core.Util.isinteger(request.getParameter("usespellingrecommendations"))){
                if (Integer.parseInt(request.getParameter("usespellingrecommendations"))==1){
                    //So we need to do the
                    //reger.core.Util.logtodb("Starting to replace spelling errors with recommendations.");
                    reger.spell.RegerSpellCheck spellCheck = new reger.spell.RegerSpellCheck(originalEntryTextBeforeSpellcheck);
                    this.comments = spellCheck.replaceWithChosenRecommendation(request);
                    //reger.core.Util.logtodb("Done replacing spelling errors with recommendations.");
                }
            }
        }
        if (request.getParameter("favorite")!=null && reger.core.Util.isinteger(request.getParameter("favorite"))) {
            this.favorite=Integer.parseInt(request.getParameter("favorite"));
        }
        if (request.getParameter("isdraft")!=null && reger.core.Util.isinteger(request.getParameter("isdraft"))) {
            this.isDraft=Integer.parseInt(request.getParameter("isdraft"));
        }
        if (request.getParameter("isapproved")!=null && reger.core.Util.isinteger(request.getParameter("isapproved"))) {
            this.isApproved=Integer.parseInt(request.getParameter("isapproved"));
        }
        //Start date
        reger.core.Debug.debug(3, "Entry.java", "dateGmt before populateGenericObjectFromRequest()=" + reger.core.TimeUtils.dateformatfordb(dateGmt));
        int mm = 0;
        if (request.getParameter("mm")!=null && reger.core.Util.isinteger(request.getParameter("mm"))) {
            mm=Integer.parseInt(request.getParameter("mm"));
        }
        int dd = 0;
        if (request.getParameter("dd")!=null && reger.core.Util.isinteger(request.getParameter("dd"))) {
            dd=Integer.parseInt(request.getParameter("dd"));
        }
        int yyyy = 0;
        if (request.getParameter("yyyy")!=null && reger.core.Util.isinteger(request.getParameter("yyyy"))) {
            yyyy=Integer.parseInt(request.getParameter("yyyy"));
        }
        int h=0;
        if (request.getParameter("h")!=null && reger.core.Util.isinteger(request.getParameter("h"))) {
            h=Integer.parseInt(request.getParameter("h"));
        }
        int m = 0;
        if (request.getParameter("m")!=null && reger.core.Util.isinteger(request.getParameter("m"))) {
            m=Integer.parseInt(request.getParameter("m"));
        }
        String ampm = "am";
        if (request.getParameter("ampm")!=null) {
            ampm=request.getParameter("ampm");
        }
        if (mm==0 && dd==0 && yyyy==0 && h==0 && m==0){
            dateGmt = TimeUtils.nowInGmtCalendar();
        } else {
            try{
                Calendar dateFromForm = reger.core.TimeUtils.formtocalendar(yyyy, mm, dd, h, m, 0, ampm);
                dateGmt = reger.core.TimeUtils.usertogmttime(dateFromForm, timezoneid);
            } catch (Exception e){
                reger.core.Debug.errorsave(e, "Entry.java");
            }
        }
        reger.core.Debug.debug(3, "Entry.java", "dateGmt after populateGenericObjectFromRequest()=" + reger.core.TimeUtils.dateformatfordb(dateGmt));
        //End date
        if (request.getParameter("eventtypeid")!=null  && !request.getParameter("eventtypeid").equals("") && reger.core.Util.isinteger(request.getParameter("eventtypeid"))) {
            this.eventtypeid=Integer.parseInt(request.getParameter("eventtypeid"));
        }
        if (request.getParameter("trackbackurl")!=null) {
            this.trackbackurl=request.getParameter("trackbackurl");
        }
        if (request.getParameter("dospellcheck")!=null) {
            if (request.getParameter("dospellcheck").equals("1")){
                //Default behavior is that spellcheck will not happen.
                //Only by sending dospellckeck=1 will it happen.
                this.dospellcheck=true;
                this.originalEntryTextBeforeSpellcheck = this.comments;
                //Do the spelling check
                isSpellingError(request);
            }
        }
        if (request.getParameter("accountuserid")!=null && reger.core.Util.isinteger(request.getParameter("accountuserid"))) {
            this.accountuserid=Integer.parseInt(request.getParameter("accountuserid"));
        }
        groupsubscriptionids = new int[0];
        if (request.getParameterValues("groupsubscriptionid")!=null){
            String[] inGroups = request.getParameterValues("groupsubscriptionid");
            for (int i = 0; i < inGroups.length; i++) {
                if (reger.core.Util.isinteger(inGroups[i])){
                    groupsubscriptionids = reger.core.Util.addToIntArray(groupsubscriptionids, Integer.parseInt(inGroups[i]));
                }
            }
        }

        episodesThisEntryBelongsTo = new int[0];
        if (request.getParameterValues("episodeid")!=null){
            String[] inEpisodes = request.getParameterValues("episodeid");
            for (int i = 0; i < inEpisodes.length; i++) {
                if (reger.core.Util.isinteger(inEpisodes[i])){
                    episodesThisEntryBelongsTo = reger.core.Util.addToIntArray(episodesThisEntryBelongsTo, Integer.parseInt(inEpisodes[i]));
                }
            }
        }

        if (request.getParameter("newepisodename")!=null) {
            this.newepisodename=request.getParameter("newepisodename");
        }

        if (request.getParameter("newepisodedescription")!=null) {
            this.newepisodedescription=request.getParameter("newepisodedescription");
        }

        //Create and populate the request object
        if ((request.getParameter("locationname")==null || request.getParameter("locationname").equals("")) && request.getParameter("locationid")!=null && reger.core.Util.isinteger(request.getParameter("locationid")) && Integer.parseInt(request.getParameter("locationid"))>0){
            this.location = new Location(Integer.parseInt(request.getParameter("locationid")));
        } else {
            this.location = new Location(0);
            this.location.setAccountid(accountid);
            this.location.populateFromRequest(request);
        }


    }

    public void populateMegafieldValuesFromRequest(javax.servlet.http.HttpServletRequest request){


            //Get a list of fields from the log
            if (logid>0){
                Log log = LogCache.get(logid);
                    if (log!=null){
                        fields=log.getFields();
                }
            //Otherwise, get a list of fields from the logtype
            } else if (eventtypeid>0) {
              MegaLogType lt = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
              if (lt!=null){
                fields=lt.getMegaFields();
              }
            }

            //Populate from request
            if (fields!=null){
                for (int i = 0; i < this.fields.length; i++) {
                    this.fields[i].populateFromRequest(request);
                }
            }
    }



    /**
     * This is used immediately upon clicking to create a new entry.  An eventid is created so that other elements like files
     * have a key to work off of.
     */
    public boolean newEntryTemporary(Account account, Accountuser accountUser) {
        boolean wasAGeneratedTitleUsed = false;
        this.accountid = account.getAccountid();
        this.accountuserid = accountUser.getAccountuserid();
        if (title.equals("")){
            wasAGeneratedTitleUsed = true;
            String logname = "";
            //-----------------------------------
            //-----------------------------------
            String[][] rstLogname= Db.RunSQL("SELECT name FROM megalog WHERE logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstLogname!=null && rstLogname.length>0){
                logname = rstLogname[0][0] + ": ";
            }
            title = logname + "Autosaved Entry";
        }

        int tmpAcctuserid = -1;

        //Add a new record to the Event Table.  This is a temporary entry.
        //-------------------------------------------------
        //---------------------=======---------------------
        eventid = reger.core.db.Db.RunSQLInsert("INSERT INTO event(eventtypeid, locationid, date, title, comments, accountid, logid, favorite, isdraft, createdate, sizeinbytes, isapproved, accountuserid, istemporary) VALUES('"+ eventtypeid +"','0','"+ TimeUtils.dateformatfordb(dateGmt) +"','"+ reger.core.Util.cleanForSQL(title) +"','"+ reger.core.Util.cleanForSQL(comments) +"','"+ accountid +"','"+ logid +"','"+ favorite +"','"+ isDraft +"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+reger.core.Util.sizeInBytes(comments)+"','"+ isApproved +"', '"+tmpAcctuserid+"', '1')");
        //---------------------=======---------------------
        //-------------------------------------------------


        //Set the istemporary flag
        istemporary = 1;

        //Now, set the title back to blank.
        if (wasAGeneratedTitleUsed){
            title = "";
        }

        return true;
    }




    public void editEntryAll(Account account, Accountuser accountUser, PrivateLabel pl) throws ValidationException{
        ValidationException validationErrors = new ValidationException();



        this.accountid=account.getAccountid();
        this.accountuserid = accountUser.getAccountuserid();

        Debug.debug(3, "Entry.java", "Edit entry called: eventid=" + eventid + ", accountid=" + accountid + ", accountuserid=" + accountuserid);

        //Validate the entry and the accompanying megadata
        try {
            validateEntryMega();
        } catch (ValidationException megaErrors){
            validationErrors.addErrorsFromAnotherValidationException(megaErrors);
        }
        //Validate main entry
        try {
            validateEntryAll(account, accountUser);
        } catch (ValidationException mainErrors){
            validationErrors.addErrorsFromAnotherValidationException(mainErrors);
        }
        //Validate location
        try {
            if (location!=null){
                location.validate();
            }
        } catch (ValidationException locErrors){
            validationErrors.addErrorsFromAnotherValidationException(locErrors);
        }


        //Throw errors if anything has failed validation
        if (validationErrors.getErrors().length>0) {
            throw validationErrors;
        }

        //Draft status
        if (isDraft!=1) {
            isDraft=0;
        }

        //If the user can't publish without approval
        if (!accountUser.userCanDoAcl("PUBLISHWITHOUTAPPROVAL", account.getAccountid()) || isApproved!=1){
            isApproved = 0;
        }

        //Ping trackbacks
        if (isApproved==1 && isDraft==0){
            pingTrackback(account);
        }

        //Content flagging
        if (pl.getIscontentflaggingon()){
            if (reger.OffensiveContentFlagger.isOffensive(this, pl.getPlid())){
                isflaggedformoderator = 1;
                if (pl.getDoesflaggedcontentneedtobeapproved()){
                    ismoderatorapproved = 0;
                    requiresmoderatorapproval = 1;
                }
            }
        }

        //Deal with pl.doallpostsneedtobeapproved
        if (pl.getDoallpostsneedtobeapproved()){
            ismoderatorapproved = 0;
            requiresmoderatorapproval = 1;
        }


        //Set lastmodifiedbyuserdate to now
        lastmodifiedbyuserdate = reger.core.TimeUtils.nowInGmtCalendar();
        //reger.core.Util.logtodb("isflaggedformoderator=" + isflaggedformoderator + "<br>ismoderatorapproved=" + ismoderatorapproved);


        //Save location
        if (location!=null){
            location.save();
        }

        //Get a locationid
        int locationid = 0;
        if (location!=null){
            locationid = location.getLocationid();
        }


        //Edit the entry in the database
        //-------------------------------------------------
        //---------------------=======---------------------
        int rs2 = reger.core.db.Db.RunSQLUpdate("UPDATE event SET locationid='"+ locationid +"', date='"+ TimeUtils.dateformatfordb(dateGmt) +"', title='"+ reger.core.Util.cleanForSQL(title) +"', comments='"+ reger.core.Util.cleanForSQL(comments) +"', favorite='"+ favorite +"', isdraft='"+ isDraft +"', sizeinbytes='"+reger.core.Util.sizeInBytes(comments)+"', isapproved='"+ isApproved +"', accountuserid='"+accountuserid+"', istemporary='0', isflaggedformoderator='"+isflaggedformoderator+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', ismoderatorapproved='"+ismoderatorapproved+"', requiresmoderatorapproval='"+requiresmoderatorapproval+"' WHERE eventid='"+ this.eventid +"' AND accountid='"+ accountid +"'");
        //---------------------=======---------------------
        //-------------------------------------------------

        //Flush the entry cache
        reger.cache.EntryCache.flush(eventid);

        //Flush the related entries cache
        reger.cache.RelatedLinksCache.flush(eventid);

        //Groups
        reger.GroupsClient.addEntryToGroups(eventid, groupsubscriptionids, accountuserid);

        //Episodes
        saveEpisodes();

        //Parse through fields and call save method on megadata
        if (fields!=null){
            for (int i = 0; i < this.fields.length; i++) {
                this.fields[i].saveToDb(this.eventid, logid);
            }
        }


        //Only ping when public entries are made
        if (!pl.getForcelogintoviewsites() && pl.getIsweblogscompingon() && getLogPermission(logid)==reger.Vars.LOGACCESSPUBLIC && ismoderatorapproved==1) {
            reger.api.WebLogsComPing.ping(account.getAccountid());
        }

        //Linkrot parse of urls
        try{
            String [] anchors = AnchorFinder.parseUrlsFromText(title + comments);
            reger.linkrot.Util.updateLinkrotEventidRelationship(anchors, eventid);
        } catch (Exception e){
            Debug.errorsave(e, "");
        }



        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);

        //Refresh log for counts
        LogCache.get(logid).refreshMostRecentEntryDateGMTFromDB();
        LogCache.get(logid).refreshNumberOfLiveEntriesInLogFromDB();



        Debug.debug(3, "Entry.java", "Entry edited: eventid=" + eventid);

    }


    public boolean getEntryAll(){
        return getEntryAll(this.eventid);
    }

    public boolean getEntryAll(int eventid){


        //First, set all of the public properties to values from the database
        //-----------------------------------
        //-----------------------------------
        String[][] rstEventdetails= reger.core.db.Db.RunSQL("SELECT date, megalog.eventtypeid, title, comments, favorite, locationid, event.logid, isdraft, isapproved, accountuserid, isflaggedformoderator, ismoderatorapproved, istemporary, lastmodifiedbyuserdate, entrykey FROM event, megalog WHERE eventid='"+ eventid +"' AND event.logid=megalog.logid");
        //-----------------------------------
        //-----------------------------------
        if(rstEventdetails!=null && rstEventdetails.length>0){

            this.eventid = eventid;

            //Get date
            try{
                dateGmt = reger.core.TimeUtils.dbstringtocalendar(rstEventdetails[0][0]);
            } catch (Exception e){
                dateGmt = reger.core.TimeUtils.nowInGmtCalendar();
                Debug.errorsave(e, "");
            }



            eventtypeid = Integer.parseInt(rstEventdetails[0][1]);
            title = rstEventdetails[0][2];
            comments = rstEventdetails[0][3];
            favorite = Integer.parseInt(rstEventdetails[0][4]);
            //Set location
            Debug.debug(5, "", "Entry.java load() setting location for locationid=" + rstEventdetails[0][5]);
            location=new Location(Integer.parseInt(rstEventdetails[0][5]));
            Debug.debug(5, "", "Entry.java load() setting location done setting for locationid=" + rstEventdetails[0][5] + "<br>location.getLongitude()=" + location.getLongitude());
            logid = Integer.parseInt(rstEventdetails[0][6]);
            isDraft = Integer.parseInt(rstEventdetails[0][7]);
            isApproved = Integer.parseInt(rstEventdetails[0][8]);
            //Populate this.author from accountuserid
            if (reger.core.Util.isinteger(rstEventdetails[0][9])){
                this.accountuserid = Integer.parseInt(rstEventdetails[0][9]);
                this.author = setAuthorFromAccountuserid(Integer.parseInt(rstEventdetails[0][9]));
            } else {
                this.accountuserid=0;
                this.author="";
            }
            isflaggedformoderator = Integer.parseInt(rstEventdetails[0][10]);
            ismoderatorapproved = Integer.parseInt(rstEventdetails[0][11]);
            istemporary = Integer.parseInt(rstEventdetails[0][12]);
            lastmodifiedbyuserdate = reger.core.TimeUtils.dbstringtocalendar(rstEventdetails[0][13]);
            entryKey = rstEventdetails[0][14];
        }

        //Message count
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessCount= Db.RunSQL("SELECT count(*) FROM message WHERE eventid='"+eventid+"' and isapproved='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessCount!=null && rstMessCount.length>0){
            messagecount = Integer.parseInt(rstMessCount[0][0]);
        }

        //File count
        //-----------------------------------
        //-----------------------------------
        String[][] rstFileCount= Db.RunSQL("SELECT count(*) FROM image WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFileCount!=null && rstFileCount.length>0){
            filecount = Integer.parseInt(rstFileCount[0][0]);
        }


        //Groups
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroups= Db.RunSQL("SELECT groupsubscriptionid FROM eventtogroup WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        groupsubscriptionids = new int[0];
        if (rstGroups!=null && rstGroups.length>0){
        	for(int i=0; i<rstGroups.length; i++){
        	    groupsubscriptionids = reger.core.Util.addToIntArray(groupsubscriptionids, Integer.parseInt(rstGroups[i][0]));
        	}
        }

        //Episodes
        //-----------------------------------
        //-----------------------------------
        String[][] rstEpisodes= Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE eventid='"+eventid+"' ORDER BY episodeid DESC");
        //-----------------------------------
        //-----------------------------------
        episodesThisEntryBelongsTo = new int[0];
        if (rstEpisodes!=null && rstEpisodes.length>0){
        	for(int i=0; i<rstEpisodes.length; i++){
        	    episodesThisEntryBelongsTo = reger.core.Util.addToIntArray(episodesThisEntryBelongsTo, Integer.parseInt(rstEpisodes[i][0]));
        	}
        }

        //Go get the fields
        if (fields==null){
            try{
                Debug.debug(5, "", "---------<br>Entry.java - about to call LogCache for logid=" + logid);
                Log logByLogid = LogCache.get(logid);
                if (logByLogid!=null){
                    Debug.debug(5, "", "Entry.java - logByLogid.getName()=" + logByLogid.getName() + "<br>--------");
                    fields = AllFieldsInSystem.copyFieldTypeArray(logByLogid.getFields());
                }
            } catch (Exception e) {
                Debug.errorsave(e, "");
            }
        }

        //Go get the data for those fields
        if (fields!=null) {
            for (int i = 0; i < fields.length; i++) {
                //Populate the object with values from the eventid
                Debug.debug(5, "", "Entry.java - fields[i].loadDataForEventid() will be called for " + fields[i].getFieldname());
                fields[i].loadDataForEventid(eventid, logid);
                Debug.debug(5, "", "Entry.java - fieldname= " + fields[i].getFieldname() + " fields[i].getDataForField()[0].getValue()=" + fields[i].getDataForField()[0].getValue());
            }
        }

        return true;

    }




    public boolean getBlankEntryAll() {

        //-----------------------------------
        //-----------------------------------
        String[][] rstEventdetails= reger.core.db.Db.RunSQL("SELECT eventtypeid FROM megalog WHERE accountid='"+ accountid +"' AND logid='"+ logid +"'");
        //-----------------------------------
        //-----------------------------------
        if ( rstEventdetails.length>0 ) {
            eventtypeid = Integer.parseInt(rstEventdetails[0][0]);
        } else {
            return false;
        }

        dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

        //Set the accountuserid to the currently logged-in user
        //this.accountuserid = accountuserOfPersonAccessing.getAccountuserid();
        this.author = setAuthorFromAccountuserid(accountuserid);

        //Set some basic values
        title = "";
        comments = "";
        favorite = 0;
        location = new Location(0);

        //Tell the field to get its default MegaData
        if (fields!=null){
            for (int i = 0; i < fields.length; i++) {
                //Populate the object with default values from the logid
                fields[i].loadDefaultData(logid);
            }
        }

        return true;

    }


    public void setDefaultMega() throws ValidationException {

        validateRequiredFields=false;

        try{
            validateEntryMega();
        } catch (ValidationException error){
            throw error;
        }

        //Parse through fields and call save method
        if (fields!=null){
            for (int i = 0; i < this.fields.length; i++) {
                this.fields[i].saveDefaultToDb(logid);
            }
        }



    }




    private void validateEntryAll(Account account, Accountuser accountUser) throws ValidationException {
        ValidationException validationErrors = new ValidationException();
        //Spell check
        if (dospellcheck && haveSpellingErrors){
            validationErrors.addValidationError("Please check spelling.  Your text is *not* yet saved.");
        }

        //Make sure we have enough space on the account before processing it.
        if (account.getMaxspaceinbytes()>0 && (long)reger.core.Util.sizeInBytes(comments)>(account.getMaxspaceinbytes() - account.getSpaceused())){
            validationErrors.addValidationError("There is not enough text space available in this account. You can upgrade to <a href='accountstatus.log'>Pro</a> for more space.");
        }

        //Make sure the logged-in user can administer this log
        if (!accountUser.userCanAuthorLog(logid)){
            validationErrors.addValidationError("The logged-in user doesn't have access to this log.");
        }

        //logid must be associated with this account
        if (!Account.isLogidValidForAccountid(account.getAccountid(), logid)){
            validationErrors.addValidationError("The given log (logid="+logid+") is not associated with the given account (accountid="+accountid+").");
        }

        //Title must not be blank
        if  (title==null || title.equals("")) {
            validationErrors.addValidationError("Title is a required field.");
        }
        //End Title Verify

        //Location
        try{
            if (location!=null){
                location.validate();
            }
        } catch (ValidationException locErrors){
            validationErrors.addErrorsFromAnotherValidationException(locErrors);
        }


        //End Date Verify

        if (validationErrors.getErrors().length>0){
            throw validationErrors;
        }

    }

    public void validateEntryMega() throws ValidationException{
        ValidationException validationException = new ValidationException();
        if (fields!=null){
            //Iterate the fields, calling the validate function
            for (int i = 0; i < this.fields.length; i++) {
                String err = this.fields[i].validateCurrentData();
                if (!err.equals("")){
                    validationException.addValidationError(err);
                }
            }
        }
        if (validationException.getErrors().length>0){
            throw validationException;
        }
    }

    public void saveEpisodes(){
        //For new episodes I need to add the episode to the episode table and then
        //add the episodeid to the episodesThisEntryBelongsTo array.  The code
        //below will take care of the rest
        if (newepisodename!=null && !newepisodename.equals("")){
            //-----------------------------------
            //-----------------------------------
            int newepisodeid = Db.RunSQLInsert("INSERT INTO episode(name, description, accountid, isprivate) VALUES('"+reger.core.Util.cleanForSQL(newepisodename)+"', '"+reger.core.Util.cleanForSQL(newepisodedescription)+"', '"+accountid+"', '0')");
            //-----------------------------------
            //-----------------------------------

            episodesThisEntryBelongsTo = reger.core.Util.addToIntArray(episodesThisEntryBelongsTo, newepisodeid);
        }

        //Add new episodes from the checkbox
        if (episodesThisEntryBelongsTo!=null){
            for (int i = 0; i < episodesThisEntryBelongsTo.length; i++) {
                int episodeid = episodesThisEntryBelongsTo[i];
                //-----------------------------------
                //-----------------------------------
                String[][] rstEp= Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE episodeid='"+episodeid+"' AND eventid='"+eventid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstEp!=null && rstEp.length>0){

                }  else {
                    //It needs to be added
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO eventtoepisode(eventid, episodeid) VALUES('"+eventid+"', '"+episodeid+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Remove episodes that were unckecked
        //-----------------------------------
        //-----------------------------------
        String[][] rstEpEv= Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEpEv!=null && rstEpEv.length>0){
            for(int i=0; i<rstEpEv.length; i++){
                //See if this one appears in the incoming list
                boolean isStillLive = false;
                for (int j = 0; j < episodesThisEntryBelongsTo.length; j++) {
                    if (episodesThisEntryBelongsTo[j]==Integer.parseInt(rstEpEv[j][0])){
                        isStillLive = true;
                    }
                }
                //If it doesn't, delete it
                if (!isStillLive){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("DELETE FROM eventtoepisode WHERE eventid='"+eventid+"' AND episodeid='"+rstEpEv[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }


    }


    public boolean isSpellingError(javax.servlet.http.HttpServletRequest request){
        //Do spell check
        reger.spell.RegerSpellCheck rspchk = new reger.spell.RegerSpellCheck(comments);
        //Return true if there are errors
        if (rspchk.getNumberOfSpellingErrors()>0){
            haveSpellingErrors = true;
            //Save the entry with suggestions as dropdowns
            textWithSuggestionsAsDropdowns = rspchk.getTextWithSuggestionsAsDropdowns();
            return true;
        }
        //Return false if no spelling errors
        return false;
    }


    /*
    * Converts the incoming time to a String
    */
//    public String convertUsingEntrytimezoneid() {
//        //dbstringtocalendar(String instr)
//        Calendar convertTime = reger.core.TimeUtils.formtocalendar(yyyy, mm+1, dd, h, m, 0, ampm);
//        convertTime=reger.core.TimeUtils.usertogmttime(convertTime, entryTimezoneid);
//
//        //Format as string
//        String out = reger.core.TimeUtils.dateformatfordb(convertTime);
//
//        return out;
//    }









    /*
    * Gets the timezoneid for a given accountid.
    */
    public String getTimezoneIdFromAccountuserid(int accountuserid){
        String tmp="GMT";
        //-----------------------------------
        //-----------------------------------
        String[][] rstTimezone= reger.core.db.Db.RunSQL("SELECT usertimezoneid FROM accountuser WHERE accountuserid='"+ accountuserid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTimezone!=null && rstTimezone.length>0) {
            tmp = rstTimezone[0][0];
        }
        return tmp;
    }


    //--------------------------------------
    //Start---------------------------------
    private int getEventtypeidFromLogid(){
        int tmp=0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstGetEventtypeid= reger.core.db.Db.RunSQL("SELECT eventtypeid FROM megalog WHERE logid='"+ logid +"' AND accountid='"+ accountid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGetEventtypeid.length>0) {
            tmp=Integer.parseInt(rstGetEventtypeid[0][0]);
        }
        return tmp;

    }
    //End-----------------------------------
    //--------------------------------------

    public String setAuthorFromAccountuserid(int accountuserid){
        String author = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstAuth= Db.RunSQL("SELECT username, friendlyname FROM accountuser WHERE accountuserid='"+accountuserid+"' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstAuth!=null && rstAuth.length>0){
            if (!rstAuth[0][1].equals("")){
                author = rstAuth[0][1];
            } else {
                author = rstAuth[0][0];
            }
        }
        return author;
    }


    public void pingTrackback(Account account){
        if (account.getIstrackbackon() && !trackbackurl.equals("")){
            //The thread is initialized
            reger.api.TrackbackPing tThr = new reger.api.TrackbackPing();
            //Set some vars
            tThr.rawUrlsToPing = this.trackbackurl;
            tThr.eventid = this.eventid;
            tThr.accountOfEntry = account;
            //The thread is started
            tThr.start();
        }
    }

    /**
     * Gets a calendar using the current values in mm, dd, yyyy h:m
     */
//    public Calendar getCalendar(){
//        return dateGmt;
//    }


    /**
     * Creates the url of format entry-logid1-eventid2374-this-is-the-title.log
     * Use this if you haven't instantiated the event class.
     * @param logid
     * @param eventid
     * @param title
     */
    public static String entryFileNameStatic(int logid, int eventid, String title){
        String stripped = reger.linkrot.GenerateKeywords.removePunctuation(title);
        String[] words = stripped.split(" ");

        String wordswithdashes = "";

        for (int i = 0; i < words.length && i<5 ; i++) {
            wordswithdashes = wordswithdashes + "-" + words[i];
        }

        String filename = "entry-logid"+logid+"-eventid"+eventid+wordswithdashes+".log";

        return filename;
    }

    /**
     * Creates the url of format entry-logid1-eventid2374-this-is-the-title.log
     * Use this if you haven't instantiated the event class.
     * @param eventid
     * @param title
     */
    public static String entryFileNameStatic(int eventid, String title){
        String stripped = reger.linkrot.GenerateKeywords.removePunctuation(title);
        String[] words = stripped.split(" ");

        String wordswithdashes = "";

        for (int i = 0; i < words.length && i<5 ; i++) {
            wordswithdashes = wordswithdashes + "-" + words[i];
        }

        String filename = "entry-eventid"+eventid+wordswithdashes+".log";

        return filename;
    }

    /**
     * This is the complete url including the base...
     * Example, http://www.joereger.com/entry4343-softball-game.log
     * @param eventid
     * @param appendEntryKeyIfAvailable -  Security.  Will append the entrykey if there is one, to allow the event to be viewed.
     */
    public static String entryCompleteUrl(int eventid, boolean appendEntryKeyIfAvailable){
        String entryFileName = "";
        String baseUrl = "";
        String entryKeyString = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT title, date, comments, accountid, entrykey FROM event WHERE event.eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
        	entryFileName = reger.Entry.entryFileNameStatic(eventid, rstEvent[0][0]);

        	Account acct = reger.cache.AccountCache.get(Integer.parseInt(rstEvent[0][3]));
        	if (acct!=null){
                baseUrl = acct.getSiteRootUrl();
            } else {
                baseUrl = reger.Account.getSiteRootUrlViaAccountid(Integer.parseInt(rstEvent[0][3]));
            }

            if (appendEntryKeyIfAvailable){
                if (!rstEvent[0][4].equals("")){
                    entryKeyString = "?entrykey=" + rstEvent[0][4];
                }
            }

            return reger.Vars.getHttpUrlPrefix() + baseUrl + "/" + entryFileName + entryKeyString;
        }
        return "";
    }


    /**
     * Deletes an entry.
     */
    public void deleteEntryAll(){
        //Delete Traffic
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM traffic WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------

        //Delete messages
        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM message WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------

        //Delete trackbacks
        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DELETE FROM trackback WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------

        //Go get image filenames and delete them from file system
        //-----------------------------------
        //-----------------------------------
        String[][] rstImg= Db.RunSQL("SELECT image FROM image WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstImg!=null && rstImg.length>0){
            for(int i=0; i<rstImg.length; i++){
                try {
                    //Delete the file
                    reger.core.Util.deleteFile(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+rstImg[i][0]);
                    //Delete the thumbnail
                    reger.core.Util.deleteFile(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+"thumbnails/"+rstImg[i][0]);
                } catch (Exception e) {
                    Debug.logtodb("Failure to delete the image="+ rstImg[i][0] +" from the filesystem.", "");
                }
            }
        }

        //Delete images from DB
        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("DELETE FROM image WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------


        //Delete the entry itself
        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("DELETE FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------


        //Delete the megadata
        deleteOnlyMegaData();


        //Update space usage now that the event is gone
        Account account = reger.cache.AccountCache.get(accountid);
        if (account!=null){
            account.updateSpaceused();
        }

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);

    }

    private void deleteOnlyMegaData(){
        //Delete any data with megafields that exists
        if (fields!=null){
            //Iterate the fields, calling the delete function
            for (int i = 0; i < this.fields.length; i++) {
                this.fields[i].deleteData(eventid);
            }
        }
    }

    public void moveEntryToLogId(int oldlogid, int newLogid){
        //See what this logtype is
        int thisEventTypeId = this.eventtypeid;

        //See what the current logtype is
        int oldEventtypeid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstOldLogtype= Db.RunSQL("SELECT eventtypeid FROM megalog WHERE logid='"+oldlogid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstOldLogtype!=null && rstOldLogtype.length>0){
            for(int i=0; i<rstOldLogtype.length; i++){
                oldEventtypeid = Integer.parseInt(rstOldLogtype[i][0]);
            }
        }

        //See what the new logtype is
        int newEventTypeId = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLogtype= Db.RunSQL("SELECT eventtypeid FROM megalog WHERE logid='"+newLogid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstLogtype!=null && rstLogtype.length>0){
            for(int i=0; i<rstLogtype.length; i++){
                //Set the neweventtype
                newEventTypeId = Integer.parseInt(rstLogtype[i][0]);


                //If they're not the same then we need to delete any megafield data
                //reger.core.Util.logtodb("oldEventtypeid=" + oldEventtypeid + "<br>newEventTypeId=" + newEventTypeId);
                if (oldEventtypeid!=newEventTypeId){
                    deleteOnlyMegaData();
                } else {
                    //Move the data
                    if (fields!=null){
                        //Iterate the fields, calling the move function
                        for (int j = 0; j < this.fields.length; j++) {
                            this.fields[j].moveDataToAnotherLog(eventid, logid, newLogid);
                        }
                    }
                }

                //Change the logid
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE event SET logid='"+newLogid+"' WHERE eventid='"+eventid+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }



    }

    private static int getLogPermission(int logid){
        //Get logid permission
        //-----------------------------------
        //-----------------------------------
        String[][] rstGetLogPermission= reger.core.db.Db.RunSQL("SELECT logaccess FROM megalog WHERE logid='"+ logid +"'");
        //-----------------------------------
        //-----------------------------------
        int logaccess=reger.Vars.LOGACCESSPRIVATE;
        if ( rstGetLogPermission.length>0 ) {
            logaccess=Integer.parseInt(rstGetLogPermission[0][0]);
        }
        return logaccess;
    }

//    public void saveLocationGetLocationid(int eventid){
//
//        //Add new locations, if necessary
//        if ( !newlocationname.equals("") ) {
//
//            if (!reger.core.Util.isinteger(latdeg)){
//                latdeg = "";
//            }
//            if (!reger.core.Util.isinteger(latmin)){
//                latmin = "";
//            }
//            if (!reger.core.Util.isinteger(latsec)){
//                latsec = "";
//            }
//            if (!reger.core.Util.isinteger(latns)){
//                latns = "";
//            }
//            if (!reger.core.Util.isinteger(londeg)){
//                londeg = "";
//            }
//            if (!reger.core.Util.isinteger(lonmin)){
//                lonmin = "";
//            }
//            if (!reger.core.Util.isinteger(lonsec)){
//                lonsec = "";
//            }
//            if (!reger.core.Util.isinteger(lonew)){
//                lonew = "";
//            }
//
//
//            //-----------------------------------
//            //-----------------------------------
//            String[][] rstCheckLoc= Db.RunSQL("SELECT locationid FROM location WHERE locationname='"+reger.core.Util.cleanForSQL(newlocationname)+"' AND accountid='"+accountid+"'");
//            //-----------------------------------
//            //-----------------------------------
//            if (rstCheckLoc!=null && rstCheckLoc.length>0){
//                locationid=Integer.parseInt(rstCheckLoc[0][0]);
//            } else {
//                //Add a new one
//                //-------------------------------------------------
//                //---------------------=======---------------------
//                locationid = reger.core.Db.Db.RunSQLInsert("INSERT INTO location(locationname, accountid, latdeg, latmin, latsec, latns, londeg, lonmin, lonsec, lonew) VALUES('"+ reger.core.Util.cleanForSQL(newlocationname) +"','"+ accountid +"', '"+ latdeg +"', '"+ latmin +"', '"+ latsec +"', '"+ latns +"', '"+ londeg +"', '"+ lonmin +"', '"+ lonsec +"', '"+ lonew +"')");
//                //---------------------=======---------------------
//                //-------------------------------------------------
//            }
//
//        }
//
//
//        //If changing the location to another one that already exists, we don't want to overwrite the gps coordinates
//        //First get the locationid for the existing eventid directly from the database
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstGetcurrentlocationid= reger.core.Db.Db.RunSQL("SELECT locationid FROM event WHERE eventid='"+ eventid +"'");
//        //-----------------------------------
//        //-----------------------------------
//        int currentlocationid=0;
//        if(rstGetcurrentlocationid.length>0){
//            currentlocationid = Integer.parseInt(rstGetcurrentlocationid[0][0]);
//        }
//
//        //If this is the same as the one that we have in the database then we can assume that they're editing the GPS coordinates
//        if (currentlocationid == locationid) {
//
//            //Edit record to the location table
//            //-------------------------------------------------
//            //---------------------=======---------------------
//            int rs2 = reger.core.Db.Db.RunSQLUpdate("UPDATE location set latdeg='"+ latdeg +"', latmin='"+ latmin +"', latsec='"+ latsec +"', latns='"+ latns +"', londeg='"+ londeg +"', lonmin='"+ lonmin +"', lonsec='"+ lonsec +"', lonew='"+ lonew +"' WHERE accountid='"+ accountid +"' AND locationid='"+ locationid +"'");
//            //---------------------=======---------------------
//            //-------------------------------------------------
//
//        }
//
//
//    }



    /**
     * Approves an entry by a moderator. Very similar to promoteToPrimaryEntry,
     * but will force it.  If I used promoteToPrimaryEntry, then it may get bounced
     * back into the moderator approval queue based on pl settings.  Infinite loop.
     */
    public boolean approveEntryByModerator(){

        this.ismoderatorapproved = 1;
        this.requiresmoderatorapproval = 0;

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE event SET ismoderatorapproved='1', requiresmoderatorapproval='0' WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------


        return true;
    }

    public boolean declineEntryByModerator(){

        this.ismoderatorapproved = 0;
        this.requiresmoderatorapproval = 0;

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE event SET ismoderatorapproved='0', requiresmoderatorapproval='0' WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------

        return true;
    }

    public boolean clearFlaggedStatusByModerator(){

        this.isflaggedformoderator = 0;

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE event SET isflaggedformoderator='0' WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------

        return true;
    }

    public static boolean checkEntryKey(String entryKey, int eventid){
        Debug.debug(5, "", "Checking entryKey. eventid=" + eventid + " entryKey=" + entryKey);
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntry= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"' AND entrykey='"+reger.core.Util.cleanForSQL(entryKey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEntry!=null && rstEntry.length>0){
            Debug.debug(5, "", "Returning True. eventid=" + eventid + " entryKey=" + entryKey);
        	return true;
        }
        Debug.debug(5, "", "Returning False. eventid=" + eventid + " entryKey=" + entryKey);
        return false;
    }

    public static boolean checkEntryKeyByImageid(String entryKey, int imageid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT eventid FROM image WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
            return checkEntryKey(entryKey, Integer.parseInt(rstEvent[0][0]));
        }

        return false;
    }

    public static String createNewEntryKey(int eventid){
        String tmp = reger.core.RandomString.randomAlphanumeric(10);
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE event SET entrykey='"+reger.core.Util.cleanForSQL(tmp)+"' WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        return tmp;
    }

    public static void clearEntryKey(int eventid){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE event SET entrykey='' WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public static String getEntryKeyCreateOneIfNecessary(int eventid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntry= Db.RunSQL("SELECT entrykey FROM event WHERE eventid='"+eventid+"' AND entrykey<>''");
        //-----------------------------------
        //-----------------------------------
        if (rstEntry!=null && rstEntry.length>0){
            return rstEntry[0][0];
        } else {
            return createNewEntryKey(eventid);
        }
    }

    public static String getEntryKeyDontCreateNew(int eventid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntry= Db.RunSQL("SELECT entrykey FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEntry!=null && rstEntry.length>0){
            return rstEntry[0][0];
        }
        return "";
    }

    /**
     * Gets an entry title from an eventid
     */
     public static String entryTitleFromEventid(int eventid){
        String title="";
        //-----------------------------------
        //-----------------------------------
        String[][] rstTitle= Db.RunSQL("SELECT title FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTitle!=null && rstTitle.length>0){
        	title = rstTitle[0][0];
        }
        return title;
    }

    /**
     * Gets an accountid from an eventid
     *
     */
    public static int getAccountidFromEventid(int eventid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGetaccountid= Db.RunSQL("SELECT accountid FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGetaccountid!=null && rstGetaccountid.length>0){
            return Integer.parseInt(rstGetaccountid[0][0]);
        }

        return -1;
    }
}
