package reger;

import reger.cache.providers.jboss.Cacheable;

/**
 * A single related entry
 */
@Cacheable
public class RelatedLink {

    private int eventid;
    private String title;
    private String rank;

    public RelatedLink(int eventid, String title, String rank){
        this.eventid = eventid;
        this.title = title;
        this.rank = rank;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
