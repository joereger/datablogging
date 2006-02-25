package reger.mega;

import reger.*;
import reger.linkrot.AnchorFinder;
import reger.cache.LogCache;
import reger.cache.AccountCache;
import reger.core.db.Db;
import reger.core.Debug;
import reger.core.ValidationException;
import reger.poll.Poll;
import reger.xforms.EventXformData;
import reger.groups.Group;
import reger.groups.EventToGroup;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main blog entry class
 */
public class Entry extends EntryDAO {

    EventXformData eventXFormData = new EventXformData();
    ArrayList<FieldType> fields = new ArrayList<FieldType>();
    ArrayList<Group> groups = new ArrayList<Group>();
    ArrayList<Integer> episodes = new ArrayList<Integer>();
    ArrayList<Poll> polls = new ArrayList<Poll>();
    ArrayList<MessageDAO> comments = new ArrayList<MessageDAO>();
    ArrayList<EntryFileDAO> files = new ArrayList<EntryFileDAO>();
    ArrayList<Location> locations = new ArrayList<Location>();
    ArrayList<Tag> tags = new ArrayList<Tag>();
    ArrayList<TrackBack> trackbacks = new ArrayList<TrackBack>();

    public Entry(int eventid){
        this.eventid = eventid;
        load();
    }

    public void load(){
        super.load();

        //Location
        locations = new ArrayList<Location>();
        locations.add(new Location(locationid));

        //Comments
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessCount = Db.RunSQL("SELECT messageid FROM message WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        comments = new ArrayList<MessageDAO>();
        if (rstMessCount != null && rstMessCount.length > 0) {
            for (int i = 0; i < rstMessCount.length; i++) {
                comments.add(new MessageDAO(Integer.parseInt(rstMessCount[i][0])));
            }
        }

        //Files
        //-----------------------------------
        //-----------------------------------
        String[][] rstFileCount = Db.RunSQL("SELECT imageid FROM image WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        files = new ArrayList<EntryFileDAO>();
        if (rstFileCount != null && rstFileCount.length > 0) {
            for (int i = 0; i < rstFileCount.length; i++) {
                files.add(new EntryFileDAO(Integer.parseInt(rstFileCount[i][0])));
            }
        }

        //Groups
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroups = Db.RunSQL("SELECT groupid FROM eventtogroup WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        groups = new ArrayList<Group>();
        if (rstGroups != null && rstGroups.length > 0) {
            for (int i = 0; i < rstGroups.length; i++) {
                groups.add(new Group(Integer.parseInt(rstGroups[i][0])));
            }
        }

        //Episodes
        //-----------------------------------
        //-----------------------------------
        String[][] rstEpisodes = Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE eventid='" + eventid + "' ORDER BY episodeid DESC");
        //-----------------------------------
        //-----------------------------------
        episodes = new ArrayList<Integer>();
        if (rstEpisodes != null && rstEpisodes.length > 0) {
            for (int i = 0; i < rstEpisodes.length; i++) {
                episodes.add(Integer.parseInt(rstEpisodes[i][0]));
            }
        }

        //Polls
        //-----------------------------------
        //-----------------------------------
        String[][] rstPolls = Db.RunSQL("SELECT pollid FROM poll WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        polls = new ArrayList<Poll>();
        if (rstPolls != null && rstPolls.length > 0) {
            for (int i = 0; i < rstPolls.length; i++) {
                polls.add(new Poll(Integer.parseInt(rstPolls[i][0])));
            }
        }


        //Tags
        tags = new ArrayList<Tag>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags = Db.RunSQL("SELECT tag.tagid, tag.tag FROM tag, eventtaglink WHERE tag.tagid=eventtaglink.tagid AND eventtaglink.eventid='" + eventid + "' ORDER BY tag.tag");
        //-----------------------------------
        //-----------------------------------
        if (rstTags != null && rstTags.length > 0) {
            for (int i = 0; i < rstTags.length; i++) {
                tags.add(new Tag(Integer.parseInt(rstTags[i][0])));
            }
        }

        //Trackbacks
        trackbacks = new ArrayList<TrackBack>();
        //-----------------------------------
        //-----------------------------------
        String[][] rstTrackbacks = Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='" + eventid + "' ORDER BY trackbackid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstTrackbacks != null && rstTrackbacks.length > 0) {
            for (int i = 0; i < rstTrackbacks.length; i++) {
                trackbacks.add(new TrackBack(Integer.parseInt(rstTrackbacks[i][0])));
            }
        }

        //Go get the fields
        if (fields == null) {
            try {
                Debug.debug(5, "Entry.java", "---------<br> - about to call LogCache for logid=" + logid);
                Log logByLogid = LogCache.get(logid);
                if (logByLogid != null) {
                    Debug.debug(5, "", "Entry.java - logByLogid.getName()=" + logByLogid.getName() + "<br>--------");
                    fields = AllFieldsInSystem.copyFieldTypeArray(logByLogid.getFields());
                }
            } catch (Exception e) {
                Debug.errorsave(e, "Entry.java");
            }
        }

        //Go get the data for those fields
        if (fields != null) {
            for (Iterator it = this.fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                //Populate the object with values from the eventid
                Debug.debug(5, "", "Entry.java - fields[i].loadDataForEventid() will be called for " + ft.getFieldname());
                ft.loadDataForEventid(eventid, logid);
                Debug.debug(5, "", "Entry.java - fieldname= " + ft.getFieldname() + " fields[i].getDataForField()[0].getValue()=" + ft.getDataForField().get(0).getValue());
            }
        }

        //Load xform
        eventXFormData = new EventXformData();
        eventXFormData.loadByEventid(eventid, logid);
    }

    public void save() throws ValidationException {
        ValidationException vex = new ValidationException();
        try{
            super.validate();
        } catch (ValidationException vexsuper){
            vex.addErrorsFromAnotherValidationException(vexsuper);
        }
        try{
            validate();
        } catch (ValidationException vexloc){
            vex.addErrorsFromAnotherValidationException(vexloc);
        }
        if (vex.getErrors().length>0){
            throw vex;
        }



        //Now save sub-objects
        try{
            saveFields();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveGroups();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveEpisodes();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveLocations();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            savePolls();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveTags();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveComments();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveFiles();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            saveTrackbacks();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }




        //Save main entry
        super.save();

        //Only ping when public entries are made
        Account account = AccountCache.get(accountid);
        PrivateLabel pl = AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
        Log log = LogCache.get(logid);
        if (!pl.getForcelogintoviewsites() && pl.getIsweblogscompingon() && log.getLogaccess()==reger.Vars.LOGACCESSPUBLIC && ismoderatorapproved) {
            reger.api.WebLogsComPing.ping(account.getAccountid());
        }

        //Linkrot parse of urls
        try {
            String [] anchors = AnchorFinder.parseUrlsFromText(title + comments);
            reger.linkrot.Util.updateLinkrotEventidRelationship(anchors, eventid);
        } catch (Exception e) {
            Debug.errorsave(e, "");
        }

        //Entry tags
        //@todo handle in an EntryRequestHandler object

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);

        //Refresh log for counts
        LogCache.get(logid).refreshMostRecentEntryDateGMTFromDB();
        LogCache.get(logid).refreshNumberOfLiveEntriesInLogFromDB();

        //Flush the entry cache
        reger.cache.EntryCache.flush(eventid);

        //Flush the related entries cache
        reger.cache.RelatedLinksCache.flush(eventid);

    }

    public void validate() throws ValidationException{
        ValidationException vex = new ValidationException();
        //Validate the entry and the accompanying megadata
        if (fields != null) {
            for (Iterator it = fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                String err = ft.validateCurrentData();
                if (!err.equals("")) {
                    vex.addValidationError(err);
                }
            }
        }

        //Get the account that this entry is tied to
        Account account = AccountCache.get(accountid);

        //Make sure we have enough space on the account before processing it.
        if (account.getMaxspaceinbytes() > 0 && (long) reger.core.Util.sizeInBytes(body) > (account.getMaxspaceinbytes() - account.getSpaceused())) {
            vex.addValidationError("There is not enough storage space remaining in this account. You can upgrade to get more space.");
        }

        //logid must be associated with this account
        if (!Account.isLogidValidForAccountid(account.getAccountid(), logid)) {
            vex.addValidationError("The given log (logid=" + logid + ") is not associated with the given account (accountid=" + accountid + ").");
        }

        //Location validation
        for (Iterator it = locations.iterator(); it.hasNext(); ) {
            Location loc = (Location)it.next();
            try{
                loc.validate();
            } catch (ValidationException locvex){
                vex.addErrorsFromAnotherValidationException(locvex);
            }
        }

    }

    public void delete(){
        //Delete the entry itself
        super.delete();

        //Delete Traffic
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM traffic WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------

        //Delete messages
        for (Iterator it = comments.iterator(); it.hasNext(); ) {
            MessageDAO comment = (MessageDAO)it.next();
            comment.delete();
        }

        //Delete trackbacks
        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DELETE FROM trackback WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------

        //Delete images from DB
        for (Iterator it = files.iterator(); it.hasNext(); ) {
            EntryFileDAO file = (EntryFileDAO)it.next();
            file.delete();
        }

        //Delete tag relationships
        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("DELETE FROM eventtaglink WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------

        //Delete the megadata
        if (fields != null) {
            for (Iterator it = this.fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                ft.deleteData(eventid);
            }
        }

        //Update space usage now that the event is gone
        Account account = reger.cache.AccountCache.get(accountid);
        if (account!=null) {
            account.updateSpaceused();
        }

        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);
    }

    private void saveGroups() throws ValidationException{
        if (groups !=null && !groups.isEmpty()){
            //Clean out groupids not checked any more
            StringBuffer sql = new StringBuffer();
            for (Iterator it = groups.iterator(); it.hasNext(); ) {
                Group group = (Group)it.next();
                sql.append(" AND groupid<>'"+group.getGroupid()+"' ");
            }
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventid='"+eventid+"' "+sql);
            //-----------------------------------
            //-----------------------------------

            //Add groupids not already there
            for (Iterator it = groups.iterator(); it.hasNext(); ) {
                Group group = (Group)it.next();
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventid='"+eventid+"' AND groupid='"+group.getGroupid()+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                    //Do nothing... it's already there
                } else {
                    EventToGroup eventToGroup = new EventToGroup();
                    eventToGroup.setEventid(eventid);
                    eventToGroup.setGroupid(group.getGroupid());
                    eventToGroup.save();
                }
            }
        } else {
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventid='"+eventid+"'");
            //-----------------------------------
            //-----------------------------------
        }

    }

    public void saveEpisodes() throws ValidationException{
        //For new episodes I need to add the episode to the episode table and then
        //add the episodeid to the episodesThisEntryBelongsTo array.  The code
        //below will take care of the rest
//        if (newepisodename != null && !newepisodename.equals("")) {
//            //-----------------------------------
//            //-----------------------------------
//            int newepisodeid = Db.RunSQLInsert("INSERT INTO episode(name, description, accountid, isprivate) VALUES('" + reger.core.Util.cleanForSQL(newepisodename) + "', '" + reger.core.Util.cleanForSQL(newepisodedescription) + "', '" + accountid + "', '0')");
//            //-----------------------------------
//            //-----------------------------------
//
//            episodes.add(newepisodeid);
//        }

        //Add new episodes from the checkbox
        if (episodes != null) {
            for (Iterator it = episodes.iterator(); it.hasNext(); ) {
                Integer episodeid = (Integer)it.next();
                //-----------------------------------
                //-----------------------------------
                String[][] rstEp = Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE episodeid='" + episodeid + "' AND eventid='" + eventid + "'");
                //-----------------------------------
                //-----------------------------------
                if (rstEp != null && rstEp.length > 0) {

                } else {
                    //It needs to be added
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO eventtoepisode(eventid, episodeid) VALUES('" + eventid + "', '" + episodeid + "')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }

        //Remove episodes that were unckecked
        //-----------------------------------
        //-----------------------------------
        String[][] rstEpEv = Db.RunSQL("SELECT episodeid FROM eventtoepisode WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstEpEv != null && rstEpEv.length > 0) {
            for (int i = 0; i < rstEpEv.length; i++) {
                //See if this one appears in the incoming list
                boolean isStillLive = false;
                for (Iterator it = episodes.iterator(); it.hasNext(); ) {
                    Integer episodeid = (Integer)it.next();
                    if (episodeid == Integer.parseInt(rstEpEv[i][0])) {
                        isStillLive = true;
                    }
                }
                //If it doesn't, delete it
                if (!isStillLive) {
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("DELETE FROM eventtoepisode WHERE eventid='" + eventid + "' AND episodeid='" + rstEpEv[i][0] + "'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }


    }

    public void saveFields() throws ValidationException{
        //Parse through fields and call save method on megadata
        if (fields != null) {
            for (Iterator it = this.fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                ft.saveToDb(this.eventid, logid);
            }
        }

    }

    public void saveLocations() throws ValidationException{

    }

    public void savePolls() throws ValidationException{

    }

    public void saveTags() throws ValidationException{

    }

    public void saveFiles() throws ValidationException{

    }

    public void saveTrackbacks() throws ValidationException{

    }

    public void saveComments() throws ValidationException{

    }



    public int getCommentCount(){
        int num = 0;
        for (Iterator it = comments.iterator(); it.hasNext(); ) {
            MessageDAO comment = (MessageDAO)it.next();
            if (comment.getIsapproved()==1){
                num = num + 1;
            }
        }
        return num;
    }

    public int getFileCount(){
        return files.size();
    }

    public ArrayList<FieldType> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldType> fields) {
        this.fields = fields;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Integer> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Integer> episodes) {
        this.episodes = episodes;
    }

    public ArrayList<Poll> getPolls() {
        return polls;
    }

    public void setPolls(ArrayList<Poll> polls) {
        this.polls = polls;
    }

    public ArrayList<MessageDAO> getComments() {
        return comments;
    }

    public void setComments(ArrayList<MessageDAO> comments) {
        this.comments = comments;
    }

    public ArrayList<EntryFileDAO> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<EntryFileDAO> files) {
        this.files = files;
    }

    public EventXformData getEventXFormData() {
        return eventXFormData;
    }

    public void setEventXFormData(EventXformData eventXFormData) {
        this.eventXFormData = eventXFormData;
    }

}
