package reger.dao.hibernate;
// Generated Mar 7, 2006 3:43:00 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


/**
 * Event generated by hbm2java
 */

public class Event  implements java.io.Serializable {


    // Fields
     private int eventid;
     private int eventtypeid;
     private int locationid;
     private Date createdate;
     private Date date;
     private String title;
     private String comments;
     private int accountid;
     private int logid;
     private int accountuserid;
     private boolean isdraft;
     private boolean isapproved;
     private boolean favorite;
     private int sizeinbytes;
     private boolean istemporary;
     private boolean ismoderatorapproved;
     private Date lastmodifiedbyuserdate;
     private boolean isflaggedformoderator;
     private boolean requiresmoderatorapproval;
     private String entrykey;

     //Association
     private Set<Image> images = new HashSet<Image>();
     public void setImages(Set<Image> images){
        this.images = images;
     }
     public Set<Image> getImages(){
        return images;
     }

     //Association
     private Set<Groups> groups = new HashSet<Groups>();
     public void setGroups(Set<Groups> groups){
        this.groups = groups;
     }
     public Set<Groups> getGroups(){
        return groups;
     }

     //Association
     private Set<Episode> episodes = new HashSet<Episode>();
     public void setEpisodes(Set<Episode> episodes){
        this.episodes = episodes;
     }
     public Set<Episode> getEpisodes(){
        return episodes;
     }

     //Association
     private Set<Poll> polls = new HashSet<Poll>();
     public void setPolls(Set<Poll> polls){
        this.polls = polls;
     }
     public Set<Poll> getPolls(){
        return polls;
     }

     //Association
     private Set<Message> messages = new HashSet<Message>();
     public Set<Message> getMessages() {
        return messages;
     }
     public void setMessages(Set<Message> messages) {
        this.messages = messages;
     }

     //Association
     private Set<Location> locations = new HashSet<Location>();
     public Set<Location> getLocations() {
        return locations;
     }
     public void setLocations(Set<Location> locations) {
        this.locations = locations;
     }

     //Association
     private Set<Tag> tags = new HashSet<Tag>();
     public Set<Tag> getTags() {
        return tags;
     }
     public void setTags(Set<Tag> tags) {
        this.tags = tags;
     }

     //Association
     private Set<Trackback> trackbacks = new HashSet<Trackback>();
     public Set<Trackback> getTrackbacks() {
        return trackbacks;
     }
     public void setTrackbacks(Set<Trackback> trackbacks) {
        this.trackbacks = trackbacks;
     }

     //Association
     private Set<Megavalue> megavalues = new HashSet<Megavalue>();
     public Set<Megavalue> getMegavalues() {
        return megavalues;
     }
     public void setMegavalues(Set<Megavalue> megavalues) {
        this.megavalues = megavalues;
     }

    //Association
     private Set<Eventxformdata> eventxformdatas = new HashSet<Eventxformdata>();
     public Set<Eventxformdata> getEventxformdatas() {
        return eventxformdatas;
     }
     public void setEventxformdatas(Set<Eventxformdata> eventxformdatas) {
        this.eventxformdatas = eventxformdatas;
     }

     //Association
     private Set<Linkrot> linkrots = new HashSet<Linkrot>();
     public Set<Linkrot> getLinkrots() {
        return linkrots;
     }
     public void setLinkrots(Set<Linkrot> linkrots) {
        this.linkrots = linkrots;
     }

    // Constructors

    /** default constructor */
    public Event() {
    }

    /** minimal constructor */
    public Event(int eventid, int eventtypeid, int locationid, Date createdate, Date date, String title, int accountid, int logid, int accountuserid, int sizeinbytes) {
        this.eventid = eventid;
        this.eventtypeid = eventtypeid;
        this.locationid = locationid;
        this.createdate = createdate;
        this.date = date;
        this.title = title;
        this.accountid = accountid;
        this.logid = logid;
        this.accountuserid = accountuserid;
        this.sizeinbytes = sizeinbytes;
    }

    /** full constructor */
    public Event(int eventid, int eventtypeid, int locationid, Date createdate, Date date, String title, String comments, int accountid, int logid, int accountuserid, boolean isdraft, boolean isapproved, boolean favorite, int sizeinbytes, boolean istemporary, boolean ismoderatorapproved, Date lastmodifiedbyuserdate, boolean isflaggedformoderator, boolean requiresmoderatorapproval, String entrykey) {
        this.eventid = eventid;
        this.eventtypeid = eventtypeid;
        this.locationid = locationid;
        this.createdate = createdate;
        this.date = date;
        this.title = title;
        this.comments = comments;
        this.accountid = accountid;
        this.logid = logid;
        this.accountuserid = accountuserid;
        this.isdraft = isdraft;
        this.isapproved = isapproved;
        this.favorite = favorite;
        this.sizeinbytes = sizeinbytes;
        this.istemporary = istemporary;
        this.ismoderatorapproved = ismoderatorapproved;
        this.lastmodifiedbyuserdate = lastmodifiedbyuserdate;
        this.isflaggedformoderator = isflaggedformoderator;
        this.requiresmoderatorapproval = requiresmoderatorapproval;
        this.entrykey = entrykey;
    }



    // Property accessors

    public int getEventid() {
        return this.eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getEventtypeid() {
        return this.eventtypeid;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public int getLocationid() {
        return this.locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getAccountid() {
        return this.accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getLogid() {
        return this.logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public int getAccountuserid() {
        return this.accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public boolean getIsdraft() {
        return this.isdraft;
    }

    public void setIsdraft(boolean isdraft) {
        this.isdraft = isdraft;
    }

    public boolean getIsapproved() {
        return this.isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }

    public boolean getFavorite() {
        return this.favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getSizeinbytes() {
        return this.sizeinbytes;
    }

    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }

    public boolean getIstemporary() {
        return this.istemporary;
    }

    public void setIstemporary(boolean istemporary) {
        this.istemporary = istemporary;
    }

    public boolean getIsmoderatorapproved() {
        return this.ismoderatorapproved;
    }

    public void setIsmoderatorapproved(boolean ismoderatorapproved) {
        this.ismoderatorapproved = ismoderatorapproved;
    }

    public Date getLastmodifiedbyuserdate() {
        return this.lastmodifiedbyuserdate;
    }

    public void setLastmodifiedbyuserdate(Date lastmodifiedbyuserdate) {
        this.lastmodifiedbyuserdate = lastmodifiedbyuserdate;
    }

    public boolean getIsflaggedformoderator() {
        return this.isflaggedformoderator;
    }

    public void setIsflaggedformoderator(boolean isflaggedformoderator) {
        this.isflaggedformoderator = isflaggedformoderator;
    }

    public boolean getRequiresmoderatorapproval() {
        return this.requiresmoderatorapproval;
    }

    public void setRequiresmoderatorapproval(boolean requiresmoderatorapproval) {
        this.requiresmoderatorapproval = requiresmoderatorapproval;
    }

    public String getEntrykey() {
        return this.entrykey;
    }

    public void setEntrykey(String entrykey) {
        this.entrykey = entrykey;
    }









}