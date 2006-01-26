package reger;

import reger.core.db.Db;
import java.util.TreeMap;
import java.util.Iterator;

public class PrivateLabelCounts {
    private TreeMap smartTagMap = new TreeMap();
    private TreeMap sizeMap = new TreeMap();

    public PrivateLabelCounts() {

    }

    public PrivateLabelCounts(PrivateLabel pl) {
        //-----------------------------------
        //-----------------------------------
        String[][] rstEventTags = Db.RunSQL("SELECT DISTINCT tag.tagid, tag.tag, event.eventid FROM event, eventtaglink, tag, megalog, account, pl WHERE megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND account.accountid=event.accountid AND account.plid=pl.plid AND "+pl.getPeerSql()+" AND " + reger.Entry.sqlOfLiveEntry + " AND eventtaglink.eventid=event.eventid AND megalog.logid=event.logid AND eventtaglink.tagid=tag.tagid");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        String[][] rstImgTags = Db.RunSQL("SELECT DISTINCT tag.tagid, tag.tag, image.imageid FROM image, tagimagelink, tag, event, megalog, account, pl WHERE megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND account.accountid=event.accountid AND account.plid=pl.plid AND "+pl.getPeerSql()+" AND  " + reger.Entry.sqlOfLiveEntry + " AND image.accountid=account.accountid AND event.accountid=account.accountid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND tagimagelink.imageid=image.imageid AND tagimagelink.tagid=tag.tagid AND megalog.logid=event.logid AND image.eventid=event.eventid");
        //-----------------------------------
        //-----------------------------------

        TreeMap tempTagMap = null;
        String tagId = null;
        String tag = null;
        if (rstEventTags != null && rstEventTags.length > 0) {
            for (int i=0;i<rstEventTags.length;i++) {
                tagId = rstEventTags[i][0];
                tag = rstEventTags[i][1];
                if (smartTagMap.containsKey(tag)) {
                    tempTagMap = (TreeMap) smartTagMap.get(tag);
                } else {
                    tempTagMap = new TreeMap();
                }
                tempTagMap.put(rstEventTags[i][2], tagId);
                smartTagMap.put(tag, tempTagMap);
            }
        }
        if (rstImgTags != null && rstImgTags.length > 0) {
            for (int i=0;i<rstImgTags.length;i++) {
                tagId = rstImgTags[i][0];
                tag = rstImgTags[i][1];
                if (smartTagMap.containsKey(tag)) {
                    tempTagMap = (TreeMap) smartTagMap.get(tag);
                } else {
                    tempTagMap = new TreeMap();
                }
                tempTagMap.put(rstImgTags[i][2], tagId);
                smartTagMap.put(tag, tempTagMap);
            }
        }
        Iterator iter = smartTagMap.keySet().iterator();
        while (iter.hasNext()) {
            tag = (String) iter.next();
            tempTagMap = (TreeMap) smartTagMap.get(tag);
            sizeMap.put(tag, new Integer(tempTagMap.size()));
        }
    }
    public TreeMap getSizeMap() {
        return sizeMap;
    }
    public TreeMap getTagMap() {
        return smartTagMap;
    }
}