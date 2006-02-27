package reger.dao.ext;

import reger.dao.db.*;
import reger.dao.db.MessageDAO;
import reger.dao.finders.*;
import reger.dao.util.ValidateArrayListOfDAOs;
import reger.dao.util.SaveArrayListOfDAOs;
import reger.dao.util.DeleteDAOsNoLongerInArrayList;
import reger.mega.FieldType;
import reger.linkrot.AnchorFinder;
import reger.cache.LogCache;
import reger.cache.AccountCache;
import reger.core.Debug;
import reger.core.ValidationException;
import reger.xforms.EventXformData;
import reger.*;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main blog entry class
 */
public class Event extends EventDAO {

    EventXformData eventXFormData = new EventXformData();
    ArrayList<FieldType> fields = new ArrayList<FieldType>();
    ArrayList<EventtogroupDAO> eventtogroups = new ArrayList<EventtogroupDAO>();
    ArrayList<EventtoepisodeDAO> eventtoepisodes = new ArrayList<EventtoepisodeDAO>();
    ArrayList<PollDAO> polls = new ArrayList<PollDAO>();
    ArrayList<MessageDAO> messages = new ArrayList<MessageDAO>();
    ArrayList<ImageDAO> files = new ArrayList<ImageDAO>();
    ArrayList<LocationtoeventDAO> locationtoevents = new ArrayList<LocationtoeventDAO>();
    ArrayList<EventtaglinkDAO> eventtaglinks = new ArrayList<EventtaglinkDAO>();
    ArrayList<TrackbackDAO> trackbacks = new ArrayList<TrackbackDAO>();

    public Event(int eventid){
        this.eventid = eventid;
        load();
    }

    public void load(){
        //Load the base entry object
        super.load();

        //Load other objects
        eventtogroups = EventtogroupFinder.findByEventid(eventid);
        eventtoepisodes = EventtoepisodeFinder.findByEventid(eventid);
        polls = PollFinder.findByEventid(eventid);
        messages = MessageFinder.findByEventid(eventid);
        files = ImageFinder.findByEventid(eventid);
        locationtoevents = LocationtoeventFinder.findByEventid(eventid);
        eventtaglinks = EventtaglinkFinder.findByEventid(eventid);
        trackbacks = TrackbackFinder.findByEventid(eventid);

        //Go get the fields
        if (fields == null) {
            try {
                Debug.debug(5, "Event.java", "---------<br> - about to call LogCache for logid=" + logid);
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

        //Validate
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
            SaveArrayListOfDAOs.save(eventtogroups);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(eventtoepisodes);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(polls);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(messages);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(files);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(locationtoevents);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(eventtaglinks);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            SaveArrayListOfDAOs.save(trackbacks);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }

        //Save main entry
        try{
            super.save();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }

        //Parse through fields and call save method on megadata
        if (fields != null) {
            for (Iterator it = this.fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                ft.saveToDb(this.eventid, logid);
            }
        }

        //Throw 'em if you've got 'em
        if (vex.getErrors().length>0){
            throw vex;
        }

        //Only ping when public entries are made
        Account account = AccountCache.get(accountid);
        PrivateLabel pl = AllPrivateLabelsInSystem.getPrivateLabel(account.getPlid());
        Log log = LogCache.get(logid);
        if (!pl.getForcelogintoviewsites() && pl.getIsweblogscompingon() && log.getLogaccess()==reger.Vars.LOGACCESSPUBLIC && ismoderatorapproved) {
            reger.api.WebLogsComPing.ping(account.getAccountid());
        }

        //Linkrot parse of urls
        try {
            String [] anchors = AnchorFinder.parseUrlsFromText(title + messages);
            reger.linkrot.Util.updateLinkrotEventidRelationship(anchors, eventid);
        } catch (Exception e) {
            Debug.errorsave(e, "");
        }

        //Refresh caches
        refreshCaches();
    }

    private void refreshCaches(){
        //Update the AccountCounts cache
        reger.cache.AccountCountCache.flushByAccountid(accountid);

        //Refresh log for counts
        LogCache.get(logid).refreshMostRecentEntryDateGMTFromDB();
        LogCache.get(logid).refreshNumberOfLiveEntriesInLogFromDB();

        //Flush the entry cache
        reger.cache.EntryCache.flush(eventid);

        //Flush the related entries cache
        reger.cache.RelatedLinksCache.flush(eventid);

        //Update space usage
        Account account = reger.cache.AccountCache.get(accountid);
        if (account!=null) {
            account.updateSpaceused();
        }

    }

    public void validate() throws ValidationException{
        ValidationException vex = new ValidationException();

        //Validate the base class
        try{
            super.validate();
        } catch (ValidationException vexsuper){
            vex.addErrorsFromAnotherValidationException(vexsuper);
        }

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

        //Validate each of the sub-objects
        try{
            ValidateArrayListOfDAOs.validate(eventtogroups);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(eventtoepisodes);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(polls);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(messages);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(files);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(locationtoevents);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(eventtaglinks);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }
        try{
            ValidateArrayListOfDAOs.validate(trackbacks);
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }

        //Get the account that this entry is tied to
        Account account = AccountCache.get(accountid);

        //Make sure we have enough space on the account before processing it.
        if (account.getMaxspaceinbytes() > 0 && (long) reger.core.Util.sizeInBytes(super.comments) > (account.getMaxspaceinbytes() - account.getSpaceused())) {
            vex.addValidationError("There is not enough storage space remaining in this account. You can upgrade to get more space.");
        }

        //logid must be associated with this account
        if (!Account.isLogidValidForAccountid(account.getAccountid(), logid)) {
            vex.addValidationError("The given log (logid=" + logid + ") is not associated with the given account (accountid=" + accountid + ").");
        }

        //Throw 'em if you've got 'em
        if (vex.getErrors().length>0){
            throw vex;
        }

    }

    public void delete(){
        //Delete the entry itself
        super.delete();

        //Delete sub-objects
        DeleteDAOsNoLongerInArrayList.delete(EventtogroupFinder.findByEventid(eventid), eventtogroups);
        DeleteDAOsNoLongerInArrayList.delete(EventtoepisodeFinder.findByEventid(eventid), eventtoepisodes);
        DeleteDAOsNoLongerInArrayList.delete(PollFinder.findByEventid(eventid), polls);
        DeleteDAOsNoLongerInArrayList.delete(MessageFinder.findByEventid(eventid), messages);
        DeleteDAOsNoLongerInArrayList.delete(ImageFinder.findByEventid(eventid), files);
        DeleteDAOsNoLongerInArrayList.delete(LocationtoeventFinder.findByEventid(eventid), locationtoevents);
        DeleteDAOsNoLongerInArrayList.delete(EventtaglinkFinder.findByEventid(eventid), eventtaglinks);
        DeleteDAOsNoLongerInArrayList.delete(TrackbackFinder.findByEventid(eventid), trackbacks);

        //Delete the megadata
        if (fields != null) {
            for (Iterator it = this.fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                ft.deleteData(eventid);
            }
        }

        //Refresh caches
        refreshCaches();
    }

    public int getCommentCount(){
        int num = 0;
        for (Iterator it = messages.iterator(); it.hasNext(); ) {
            MessageDAO comment = (MessageDAO)it.next();
            if (comment.getIsapproved()){
                num = num + 1;
            }
        }
        return num;
    }

    public int getFileCount(){
        return files.size();
    }

    public EventXformData getEventXFormData() {
        return eventXFormData;
    }

    public void setEventXFormData(EventXformData eventXFormData) {
        this.eventXFormData = eventXFormData;
    }

    public ArrayList<FieldType> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldType> fields) {
        this.fields = fields;
    }

    public ArrayList<EventtogroupDAO> getEventtogroups() {
        return eventtogroups;
    }

    public void setEventtogroups(ArrayList<EventtogroupDAO> eventtogroups) {
        this.eventtogroups = eventtogroups;
    }

    public ArrayList<EventtoepisodeDAO> getEventtoepisodes() {
        return eventtoepisodes;
    }

    public void setEventtoepisodes(ArrayList<EventtoepisodeDAO> eventtoepisodes) {
        this.eventtoepisodes = eventtoepisodes;
    }

    public ArrayList<PollDAO> getPolls() {
        return polls;
    }

    public void setPolls(ArrayList<PollDAO> polls) {
        this.polls = polls;
    }

    public ArrayList<MessageDAO> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDAO> messages) {
        this.messages = messages;
    }

    public ArrayList<ImageDAO> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<ImageDAO> files) {
        this.files = files;
    }

    public ArrayList<LocationtoeventDAO> getLocationtoevents() {
        return locationtoevents;
    }

    public void setLocationtoevents(ArrayList<LocationtoeventDAO> locationtoevents) {
        this.locationtoevents = locationtoevents;
    }

    public ArrayList<EventtaglinkDAO> getEventtaglinks() {
        return eventtaglinks;
    }

    public void setEventtaglinks(ArrayList<EventtaglinkDAO> eventtaglinks) {
        this.eventtaglinks = eventtaglinks;
    }

    public ArrayList<TrackbackDAO> getTrackbacks() {
        return trackbacks;
    }

    public void setTrackbacks(ArrayList<TrackbackDAO> trackbacks) {
        this.trackbacks = trackbacks;
    }

}
