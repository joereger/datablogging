package reger;

import reger.core.db.Db;

import java.util.HashMap;

public class PrivateLabelCounts {
    private int tagCount;
    private HashMap smartTagMap = new HashMap();

    public PrivateLabelCounts() {

    }

    public PrivateLabelCounts(PrivateLabel pl) {
        //-----------------------------------
        //-----------------------------------
        String[][] rstEventTags = Db.RunSQL("SELECT DISTINCT tag.tagid, tag.tag, event.eventid FROM event, eventtaglink, tag, megalog WHERE " + reger.Entry.sqlOfLiveEntry + " AND event.accountid='"+pl.getPlid()+"' AND eventtaglink.eventid=event.eventid AND megalog.logid=event.logid AND eventtaglink.tagid=tag.tagid");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        String[][] rstImgTags = Db.RunSQL("SELECT DISTINCT tag.tagid, tag.tag, image.imageid FROM image, tagimagelink, tag, event, megalog, account WHERE " + reger.Entry.sqlOfLiveEntry + " AND image.accountid=account.accountid AND event.accountid=account.accountid AND account.plid='"+pl.getPlid()+"' AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND tagimagelink.imageid=image.imageid AND tagimagelink.tagid=tag.tagid AND megalog.logid=event.logid AND image.eventid=event.eventid");
        //-----------------------------------
        //-----------------------------------

        HashMap tempTagMap = null;
        HashMap tagMap = new HashMap();
        String tagId = null;
        String tag = null;
        if (rstEventTags != null && rstEventTags.length > 0) {
            for (int i=0;i<rstEventTags.length;i++) {
                tagId = rstEventTags[i][0];
                tag = rstEventTags[i][1];
                if (smartTagMap.containsKey(tagId+"_event")) {
                    tempTagMap = (HashMap) smartTagMap.get(tagId+"_event");
                } else {
                    tempTagMap = new HashMap();
                }
                tempTagMap.put(rstEventTags[i][2], tag);
                smartTagMap.put(tagId+"_event", tempTagMap);
                tagMap.put(tag, tagId);
            }
        }
        if (rstImgTags != null && rstImgTags.length > 0) {
            for (int i=0;i<rstImgTags.length;i++) {
                tagId = rstImgTags[i][0];
                tag = rstImgTags[i][1];
                if (smartTagMap.containsKey(tagId+"_img")) {
                    tempTagMap = (HashMap) smartTagMap.get(tagId+"_img");
                } else {
                    tempTagMap = new HashMap();
                }
                tempTagMap.put(rstImgTags[i][2], tag);
                smartTagMap.put(tagId+"_img", tempTagMap);
                tagMap.put(tag, tagId);
            }
        }
        tagCount = tagMap.size();
    }

    public HashMap getSmartTagMap() {
        return smartTagMap;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }
}