package reger;

import reger.core.db.Db;
import reger.core.Debug;

import java.util.Vector;

public class EventTagLink {

    private int eventtaglinkid;
    private int eventid = -1;
    private int tagid;

    public EventTagLink(int eventId) {
        this.eventid = eventId;
        load();
    }

    public EventTagLink() {

    }

    public void load() {
        reger.core.Debug.debug(5, "EventTagLink.java", "load(eventid="+eventid+") called.");
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvtTagLnk = Db.RunSQL("SELECT eventtaglinkid, eventid, tagid FROM eventtaglink WHERE eventid='" + eventid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstEvtTagLnk != null && rstEvtTagLnk.length > 0) {
            try {
                this.eventtaglinkid = Integer.parseInt(rstEvtTagLnk[0][0]);
                this.eventid = Integer.parseInt(rstEvtTagLnk[0][1]);
                this.tagid = Integer.parseInt(rstEvtTagLnk[0][2]);
            } catch (Exception e) {
                Debug.errorsave(e, "load method in EventTagLink", "Exception occurred while retrieving the data from EventTagLink table");
            }
        }
    }

    public void save() {
        reger.core.Debug.debug(5, "EventTagLink.java", "save(eventid="+eventid+") called.");
        try {
            //-----------------------------------
            //-----------------------------------
            String[][] rstEvtTagLnk = Db.RunSQL("SELECT eventtaglinkid FROM eventtaglink WHERE eventtaglinkid='" + eventtaglinkid + "'");
            //-----------------------------------
            //-----------------------------------
            if (rstEvtTagLnk != null && rstEvtTagLnk.length > 0) {
                //Update
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE eventtaglink SET eventid='" + eventid + "', tagid='" + tagid + "' WHERE eventtaglinkid='" + eventtaglinkid + "'");
                //-----------------------------------
                //-----------------------------------
            } else {
                //Insert
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO eventtaglinkid(eventtaglinkid, eventid, tagid) VALUES('" + eventtaglinkid + "', '" + eventid + "', '" + tagid + "')");
                //-----------------------------------
                //-----------------------------------
            }
        } catch (Exception e) {
            Debug.errorsave(e, "save method in EventTagLink", "Exception occurred while saving the data from EventTagLink table");
        }
    }

    public void delete() {
        try {
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM eventtaglinkid WHERE eventtaglinkid='" + eventtaglinkid + "'");
            //-----------------------------------
            //-----------------------------------
        } catch (Exception e) {
            Debug.errorsave(e, "delete method in EventTagLink", "Exception occurred while deleting the data from EventTagLink table");
        }
    }

    public static String getAllTagsForEntry(int eventid) {
        reger.core.Debug.debug(5, "EventTagLink.java", "getAllTagsForEntry(eventid="+eventid+") called.");
        StringBuffer tags = new StringBuffer("");
        //-----------------------------------
        //-----------------------------------
        String[][] rstTags = Db.RunSQL("SELECT tag.tag FROM tag tag, eventtaglink event WHERE tag.tagid=event.tagid AND event.eventid='" + eventid + "' order by tag");
        //-----------------------------------
        //-----------------------------------
        if (rstTags != null && rstTags.length > 0) {
            for (int i = 0; i < rstTags.length; i++) {
                tags.append(rstTags[i][0].toLowerCase());
                tags.append(" ");
            }
        }
        return tags.toString();
    }

    public static void addTagsToEntry(String tags, int eventId) {
        //Delete the tags for a given eventid
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtaglink WHERE eventid='" + eventId + "'");
        //-----------------------------------
        //-----------------------------------
        TagParser tagParser = new TagParser(tags);
        String[] tagsArray = tagParser.parseImageTagText();
        Vector tempVector = new Vector(tagsArray.length);
        String tag = null;
        int tagId;
        for (int i = 0; i < tagsArray.length; i++) {
            tag = tagsArray[i].trim();
            tagId = Tag.gettagidFromTagText(tag);
            if (tagId < 0) {
                //If tag is not present, create it
                //-----------------------------------
                //-----------------------------------
                tagId = Db.RunSQLInsert("INSERT INTO tag(tag) VALUES('" + reger.core.Util.cleanForSQL(reger.core.Util.truncateString(tag.trim(), 254)) + "')");
                //-----------------------------------
                //-----------------------------------
            } else {
                //See if there are other eventids using this same tag
                //-----------------------------------
                //-----------------------------------
                String[][] rstCountTags = Db.RunSQL("SELECT eventid FROM eventtaglink WHERE tagid='" + tagId + "'");
                //-----------------------------------
                //-----------------------------------
                if ((rstCountTags != null) && (rstCountTags.length == 0)) {
                    //Delete the tag from eventtaglink if a tagid is not associated with eventid
                    //-----------------------------------
                    //-----------------------------------
                    count = Db.RunSQLUpdate("DELETE FROM eventtaglink WHERE tagid='" + tagId + "'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
            if (!tempVector.contains(tag)) {
                // Associate eventid with the tagid.
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO eventtaglink(eventid, tagid) VALUES('" + eventId + "', '" + tagId + "')");
                //-----------------------------------
                //-----------------------------------
                tempVector.add(tag);
            }
        }
    }

    public int getEventtaglinkid() {
        return eventtaglinkid;
    }

    public void setEventtaglinkid(int eventtaglinkid) {
        this.eventtaglinkid = eventtaglinkid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }
}