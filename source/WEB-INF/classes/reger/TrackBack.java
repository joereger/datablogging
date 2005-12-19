package reger;

import reger.core.Debug;
import reger.core.TimeUtils;
import reger.core.db.Db;
import java.text.DateFormat;
import java.util.Calendar;

public class TrackBack {

    private int trackbackid = 0;
    private int eventid;
    private int isoutbound;
    private int ispingedalready;
    private String url;
    private String blogname;
    private String posttitle;
    private String excerpt;
    private Calendar datetime;
    private int isapproved;

    public TrackBack(int trckBackId) {
        this.trackbackid = trckBackId;
        load();
    }

    public TrackBack () {

    }

    public void load() {
        //-----------------------------------
        //-----------------------------------
        String[][] rstTrackBack = Db.RunSQL("SELECT eventid, isoutbound, ispingedalready, url, blogname, posttitle, excerpt, datetime, isapproved FROM trackback WHERE trackbackid='" + trackbackid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstTrackBack != null && rstTrackBack.length > 0) {
            try {
                this.eventid = Integer.parseInt(rstTrackBack[0][0]);
                this.isoutbound = Integer.parseInt(rstTrackBack[0][1]);
                this.ispingedalready = Integer.parseInt(rstTrackBack[0][2]);
                this.url = rstTrackBack[0][3];
                this.blogname = rstTrackBack[0][4];
                this.posttitle = rstTrackBack[0][5];
                this.excerpt = rstTrackBack[0][6];
                this.datetime = reger.core.TimeUtils.dbstringtocalendar(rstTrackBack[0][7]);
                this.isapproved = Integer.parseInt(rstTrackBack[0][8]);
            } catch (Exception e) {
                Debug.errorsave(e, "load method in TrackBack", "Exception occurred while retrieving the data from TrackBack table");
            }
        }
    }

    public void save() {

        //-----------------------------------
        //-----------------------------------
        String[][] rstTrackBack = Db.RunSQL("SELECT eventid FROM trackback WHERE trackbackid='" + trackbackid + "'");
        //-----------------------------------
        //-----------------------------------
        if (rstTrackBack != null && rstTrackBack.length > 0) {
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE trackback SET eventid='" + eventid + "', isoutbound='" + isoutbound + "', ispingedalready='" + ispingedalready + "', url='" + reger.core.Util.cleanForSQL(url) + "', blogname='" + reger.core.Util.cleanForSQL(blogname) + "', posttitle='" + reger.core.Util.cleanForSQL(posttitle) + "', excerpt='" + reger.core.Util.cleanForSQL(excerpt) + "', datetime='" + TimeUtils.dateformatfordb(datetime) + "', isapproved='" + isapproved + "' WHERE trackbackid='" + trackbackid + "'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO trackback(eventid, isoutbound, ispingedalready, url, blogname, posttitle, excerpt, datetime, isapproved) VALUES('" + eventid + "', '" + isoutbound + "', '" + ispingedalready + "', '" + reger.core.Util.cleanForSQL(url) + "', '" + reger.core.Util.cleanForSQL(blogname) + "', '" + reger.core.Util.cleanForSQL(posttitle) + "', '" + reger.core.Util.cleanForSQL(excerpt) + "', '" + TimeUtils.dateformatfordb(datetime) + "', '" + isapproved + "')");
            //-----------------------------------
            //-----------------------------------
        }

    }

    public void delete() {
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM trackback WHERE trackbackid='" + this.trackbackid + "'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getTrackbackid() {
        return trackbackid;
    }

    public void setTrackbackid(int trackbackid) {
        this.trackbackid = trackbackid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getIsoutbound() {
        return isoutbound;
    }

    public void setIsoutbound(int isoutbound) {
        this.isoutbound = isoutbound;
    }

    public int getIspingedalready() {
        return ispingedalready;
    }

    public void setIspingedalready(int ispingedalready) {
        this.ispingedalready = ispingedalready;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public int getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(int isapproved) {
        this.isapproved = isapproved;
    }
}