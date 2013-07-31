package reger.dao;
// Generated Mar 7, 2006 3:43:18 PM by Hibernate Tools 3.1.0.beta4

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


public class Account  implements java.io.Serializable {


    // Fields    

     private int accountid;
     private int accounttypeid;
     private String customservername;
     private int plid;
     private String homepagehtml;
     private String homepagetitle;
     private String aboutthisbloghtml;
     private String aboutthisblogtitle;
     private Date createdate;
     private String timezoneid;
     private int jspopup;
     private boolean homepagecalendar;
     private boolean messagesstatus;
     private boolean messagesapproval;
     private boolean admintools;
     private boolean pingweblogscom;
     private boolean showhometab;
     private String hometabtext;
     private boolean showlogintab;
     private int displaycharsinsummary;
     private int displaynumberofentries;
     private boolean userelatedlinks;
     private String favesitetitle;
     private boolean favesiteon;
     private boolean onthisday;
     private int emailnewsletter;
     private int emailsendhour;
     private float monthlycharge;
     private boolean issearchmysiteon;
     private boolean istrackbackon;
     private boolean islistedindirectory;
     private boolean trackbackrequiresapproval;
     private int istimeperiodon;
     private String accounturl;
     private boolean isactiveaccount;
     private boolean isnewpendingadminapproval;
     private int hptemplateid;
     private int entlisttemplateid;
     private int sitetemplateid;
     private String customservername2;
     private String customservername3;
     private String accountemail;
     private String newslettersubject;
     private String encryptedlicense;
     private String isbillingokencrypted;
     private String billingerror;
     private Date lastbillingcheck;
     private String googlemapsapikey;
     private Date datemarkedinactive;
     private boolean issplashpageon;
     private String splashpagehtml;


    //Association
    private Set<Accountuseracl> accountuseracls = new HashSet<Accountuseracl>();
    public Set<Accountuseracl> getAccountuseracls() {
        return accountuseracls;
    }
    public void setAccountuseracls(Set<Accountuseracl> accountuseracls) {
        this.accountuseracls = accountuseracls;
    }

    //Association
    private Set<Accountuseraclgroup> accountuseraclgroups = new HashSet<Accountuseraclgroup>();
    public Set<Accountuseraclgroup> getAccountuseraclgroups() {
        return accountuseraclgroups;
    }
    public void setAccountuseraclgroups(Set<Accountuseraclgroup> accountuseraclgroups) {
        this.accountuseraclgroups = accountuseraclgroups;
    }

    //Association
    private Set<Bandwidth> bandwidths = new HashSet<Bandwidth>();
    public Set<Bandwidth> getBandwidths() {
        return bandwidths;
    }
    public void setBandwidths(Set<Bandwidth> bandwidths) {
        this.bandwidths = bandwidths;
    }

    //Association
    private Set<Contentpage> contentpages = new HashSet<Contentpage>();
    public Set<Contentpage> getContentpages() {
        return contentpages;
    }
    public void setContentpages(Set<Contentpage> contentpages) {
        this.contentpages = contentpages;
    }

    //Association
    private Set<Emailapiaddress> emailapiaddresses = new HashSet<Emailapiaddress>();
    public Set<Emailapiaddress> getEmailapiaddresses() {
        return emailapiaddresses;
    }
    public void setEmailapiaddresses(Set<Emailapiaddress> emailapiaddresses) {
        this.emailapiaddresses = emailapiaddresses;
    }

    //Association
    private Set<Emailsubscriber> emailsubscribers = new HashSet<Emailsubscriber>();
    public Set<Emailsubscriber> getEmailsubscribers() {
        return emailsubscribers;
    }
    public void setEmailsubscribers(Set<Emailsubscriber> emailsubscribers) {
        this.emailsubscribers = emailsubscribers;
    }

    //Association
    private Set<Episode> episodes = new HashSet<Episode>();
    public Set<Episode> getEpisodes() {
        return episodes;
    }
    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    //Association
    private Set<Event> events = new HashSet<Event>();
    public Set<Event> getEvents() {
        return events;
    }
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    //Association
    private Set<Favesite> favesites = new HashSet<Favesite>();
    public Set<Favesite> getFavesites() {
        return favesites;
    }
    public void setFavesites(Set<Favesite> favesites) {
        this.favesites = favesites;
    }

    //Association
    private Set<Fileacl> fileacls = new HashSet<Fileacl>();
    public Set<Fileacl> getFileacls() {
        return fileacls;
    }
    public void setFileacls(Set<Fileacl> fileacls) {
        this.fileacls = fileacls;
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
    private Set<Megachart> megacharts = new HashSet<Megachart>();
    public Set<Megachart> getMegacharts() {
        return megacharts;
    }
    public void setMegacharts(Set<Megachart> megacharts) {
        this.megacharts = megacharts;
    }

    //Association
    private Set<Megalog> megalogs = new HashSet<Megalog>();
    public Set<Megalog> getMegalogs() {
        return megalogs;
    }
    public void setMegalogs(Set<Megalog> megalogs) {
        this.megalogs = megalogs;
    }

    //Association
    private Set<Savedsearch> savedsearches = new HashSet<Savedsearch>();
    public Set<Savedsearch> getSavedsearches() {
        return savedsearches;
    }
    public void setSavedsearches(Set<Savedsearch> savedsearches) {
        this.savedsearches = savedsearches;
    }

    //Association
    private Set<Templatenew> templatenews = new HashSet<Templatenew>();
    public Set<Templatenew> getTemplatenews() {
        return templatenews;
    }
    public void setTemplatenews(Set<Templatenew> templatenews) {
        this.templatenews = templatenews;
    }

    //Association
    private Set<Traffic> traffics = new HashSet<Traffic>();
    public Set<Traffic> getTraffics() {
        return traffics;
    }
    public void setTraffics(Set<Traffic> traffics) {
        this.traffics = traffics;
    }

    // Constructors

    /** default constructor */
    public Account() {
    }

    /** minimal constructor */
    public Account(int accountid, int accounttypeid, int plid, Date createdate, String timezoneid, int jspopup, int displaycharsinsummary, int displaynumberofentries, int emailnewsletter, int emailsendhour, float monthlycharge, int istimeperiodon, int hptemplateid, int entlisttemplateid, int sitetemplateid, String isbillingokencrypted) {
        this.accountid = accountid;
        this.accounttypeid = accounttypeid;
        this.plid = plid;
        this.createdate = createdate;
        this.timezoneid = timezoneid;
        this.jspopup = jspopup;
        this.displaycharsinsummary = displaycharsinsummary;
        this.displaynumberofentries = displaynumberofentries;
        this.emailnewsletter = emailnewsletter;
        this.emailsendhour = emailsendhour;
        this.monthlycharge = monthlycharge;
        this.istimeperiodon = istimeperiodon;
        this.hptemplateid = hptemplateid;
        this.entlisttemplateid = entlisttemplateid;
        this.sitetemplateid = sitetemplateid;
        this.isbillingokencrypted = isbillingokencrypted;
    }

    /** full constructor */
    public Account(int accountid, int accounttypeid, String customservername, int plid, String homepagehtml, String homepagetitle, Date createdate, String timezoneid, int jspopup, boolean homepagecalendar, boolean messagesstatus, boolean messagesapproval, boolean admintools, boolean pingweblogscom, boolean showhometab, String hometabtext, boolean showlogintab, int displaycharsinsummary, int displaynumberofentries, boolean userelatedlinks, String favesitetitle, boolean favesiteon, boolean onthisday, int emailnewsletter, int emailsendhour, float monthlycharge, boolean issearchmysiteon, boolean istrackbackon, boolean islistedindirectory, boolean trackbackrequiresapproval, int istimeperiodon, String accounturl, boolean isactiveaccount, boolean isnewpendingadminapproval, int hptemplateid, int entlisttemplateid, int sitetemplateid, String customservername2, String customservername3, String accountemail, String newslettersubject, String encryptedlicense, String isbillingokencrypted, String billingerror, Date lastbillingcheck, String googlemapsapikey, Double maxspaceinbytes) {
        this.accountid = accountid;
        this.accounttypeid = accounttypeid;
        this.customservername = customservername;
        this.plid = plid;
        this.homepagehtml = homepagehtml;
        this.homepagetitle = homepagetitle;
        this.createdate = createdate;
        this.timezoneid = timezoneid;
        this.jspopup = jspopup;
        this.homepagecalendar = homepagecalendar;
        this.messagesstatus = messagesstatus;
        this.messagesapproval = messagesapproval;
        this.admintools = admintools;
        this.pingweblogscom = pingweblogscom;
        this.showhometab = showhometab;
        this.hometabtext = hometabtext;
        this.showlogintab = showlogintab;
        this.displaycharsinsummary = displaycharsinsummary;
        this.displaynumberofentries = displaynumberofentries;
        this.userelatedlinks = userelatedlinks;
        this.favesitetitle = favesitetitle;
        this.favesiteon = favesiteon;
        this.onthisday = onthisday;
        this.emailnewsletter = emailnewsletter;
        this.emailsendhour = emailsendhour;
        this.monthlycharge = monthlycharge;
        this.issearchmysiteon = issearchmysiteon;
        this.istrackbackon = istrackbackon;
        this.islistedindirectory = islistedindirectory;
        this.trackbackrequiresapproval = trackbackrequiresapproval;
        this.istimeperiodon = istimeperiodon;
        this.accounturl = accounturl;
        this.isactiveaccount = isactiveaccount;
        this.isnewpendingadminapproval = isnewpendingadminapproval;
        this.hptemplateid = hptemplateid;
        this.entlisttemplateid = entlisttemplateid;
        this.sitetemplateid = sitetemplateid;
        this.customservername2 = customservername2;
        this.customservername3 = customservername3;
        this.accountemail = accountemail;
        this.newslettersubject = newslettersubject;
        this.encryptedlicense = encryptedlicense;
        this.isbillingokencrypted = isbillingokencrypted;
        this.billingerror = billingerror;
        this.lastbillingcheck = lastbillingcheck;
        this.googlemapsapikey = googlemapsapikey;

    }



    // Property accessors

    public int getAccountid() {
        return this.accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getAccounttypeid() {
        return this.accounttypeid;
    }

    public void setAccounttypeid(int accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public String getCustomservername() {
        return this.customservername;
    }

    public void setCustomservername(String customservername) {
        this.customservername = customservername;
    }

    public int getPlid() {
        return this.plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public String getHomepagehtml() {
        return this.homepagehtml;
    }

    public void setHomepagehtml(String homepagehtml) {
        this.homepagehtml = homepagehtml;
    }

    public String getHomepagetitle() {
        return this.homepagetitle;
    }

    public void setHomepagetitle(String homepagetitle) {
        this.homepagetitle = homepagetitle;
    }

    public String getAboutthisbloghtml() {
        return aboutthisbloghtml;
    }

    public void setAboutthisbloghtml(String aboutthisbloghtml) {
        this.aboutthisbloghtml = aboutthisbloghtml;
    }

    public String getAboutthisblogtitle() {
        return aboutthisblogtitle;
    }

    public void setAboutthisblogtitle(String aboutthisblogtitle) {
        this.aboutthisblogtitle = aboutthisblogtitle;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getTimezoneid() {
        return this.timezoneid;
    }

    public void setTimezoneid(String timezoneid) {
        this.timezoneid = timezoneid;
    }

    public int getJspopup() {
        return this.jspopup;
    }

    public void setJspopup(int jspopup) {
        this.jspopup = jspopup;
    }

    public boolean getHomepagecalendar() {
        return this.homepagecalendar;
    }

    public void setHomepagecalendar(boolean homepagecalendar) {
        this.homepagecalendar = homepagecalendar;
    }

    public boolean getMessagesstatus() {
        return this.messagesstatus;
    }

    public void setMessagesstatus(boolean messagesstatus) {
        this.messagesstatus = messagesstatus;
    }

    public boolean getMessagesapproval() {
        return this.messagesapproval;
    }

    public void setMessagesapproval(boolean messagesapproval) {
        this.messagesapproval = messagesapproval;
    }

    public boolean getAdmintools() {
        return this.admintools;
    }

    public void setAdmintools(boolean admintools) {
        this.admintools = admintools;
    }

    public boolean getPingweblogscom() {
        return this.pingweblogscom;
    }

    public void setPingweblogscom(boolean pingweblogscom) {
        this.pingweblogscom = pingweblogscom;
    }

    public boolean getShowhometab() {
        return this.showhometab;
    }

    public void setShowhometab(boolean showhometab) {
        this.showhometab = showhometab;
    }

    public String getHometabtext() {
        return this.hometabtext;
    }

    public void setHometabtext(String hometabtext) {
        this.hometabtext = hometabtext;
    }

    public boolean getShowlogintab() {
        return this.showlogintab;
    }

    public void setShowlogintab(boolean showlogintab) {
        this.showlogintab = showlogintab;
    }

    public int getDisplaycharsinsummary() {
        return this.displaycharsinsummary;
    }

    public void setDisplaycharsinsummary(int displaycharsinsummary) {
        this.displaycharsinsummary = displaycharsinsummary;
    }

    public int getDisplaynumberofentries() {
        return this.displaynumberofentries;
    }

    public void setDisplaynumberofentries(int displaynumberofentries) {
        this.displaynumberofentries = displaynumberofentries;
    }

    public boolean getUserelatedlinks() {
        return this.userelatedlinks;
    }

    public void setUserelatedlinks(boolean userelatedlinks) {
        this.userelatedlinks = userelatedlinks;
    }

    public String getFavesitetitle() {
        return this.favesitetitle;
    }

    public void setFavesitetitle(String favesitetitle) {
        this.favesitetitle = favesitetitle;
    }

    public boolean getFavesiteon() {
        return this.favesiteon;
    }

    public void setFavesiteon(boolean favesiteon) {
        this.favesiteon = favesiteon;
    }

    public boolean getOnthisday() {
        return this.onthisday;
    }

    public void setOnthisday(boolean onthisday) {
        this.onthisday = onthisday;
    }

    public int getEmailnewsletter() {
        return this.emailnewsletter;
    }

    public void setEmailnewsletter(int emailnewsletter) {
        this.emailnewsletter = emailnewsletter;
    }

    public int getEmailsendhour() {
        return this.emailsendhour;
    }

    public void setEmailsendhour(int emailsendhour) {
        this.emailsendhour = emailsendhour;
    }

    public float getMonthlycharge() {
        return this.monthlycharge;
    }

    public void setMonthlycharge(float monthlycharge) {
        this.monthlycharge = monthlycharge;
    }

    public boolean getIssearchmysiteon() {
        return this.issearchmysiteon;
    }

    public void setIssearchmysiteon(boolean issearchmysiteon) {
        this.issearchmysiteon = issearchmysiteon;
    }

    public boolean getIstrackbackon() {
        return this.istrackbackon;
    }

    public void setIstrackbackon(boolean istrackbackon) {
        this.istrackbackon = istrackbackon;
    }

    public boolean getIslistedindirectory() {
        return this.islistedindirectory;
    }

    public void setIslistedindirectory(boolean islistedindirectory) {
        this.islistedindirectory = islistedindirectory;
    }

    public boolean getTrackbackrequiresapproval() {
        return this.trackbackrequiresapproval;
    }

    public void setTrackbackrequiresapproval(boolean trackbackrequiresapproval) {
        this.trackbackrequiresapproval = trackbackrequiresapproval;
    }

    public int getIstimeperiodon() {
        return this.istimeperiodon;
    }

    public void setIstimeperiodon(int istimeperiodon) {
        this.istimeperiodon = istimeperiodon;
    }

    public String getAccounturl() {
        return this.accounturl;
    }

    public void setAccounturl(String accounturl) {
        this.accounturl = accounturl;
    }

    public boolean getIsactiveaccount() {
        return this.isactiveaccount;
    }

    public void setIsactiveaccount(boolean isactiveaccount) {
        this.isactiveaccount = isactiveaccount;
    }

    public boolean getIsnewpendingadminapproval() {
        return this.isnewpendingadminapproval;
    }

    public void setIsnewpendingadminapproval(boolean isnewpendingadminapproval) {
        this.isnewpendingadminapproval = isnewpendingadminapproval;
    }

    public int getHptemplateid() {
        return this.hptemplateid;
    }

    public void setHptemplateid(int hptemplateid) {
        this.hptemplateid = hptemplateid;
    }

    public int getEntlisttemplateid() {
        return this.entlisttemplateid;
    }

    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }

    public int getSitetemplateid() {
        return this.sitetemplateid;
    }

    public void setSitetemplateid(int sitetemplateid) {
        this.sitetemplateid = sitetemplateid;
    }

    public String getCustomservername2() {
        return this.customservername2;
    }

    public void setCustomservername2(String customservername2) {
        this.customservername2 = customservername2;
    }

    public String getCustomservername3() {
        return this.customservername3;
    }

    public void setCustomservername3(String customservername3) {
        this.customservername3 = customservername3;
    }

    public String getAccountemail() {
        return this.accountemail;
    }

    public void setAccountemail(String accountemail) {
        this.accountemail = accountemail;
    }

    public String getNewslettersubject() {
        return this.newslettersubject;
    }

    public void setNewslettersubject(String newslettersubject) {
        this.newslettersubject = newslettersubject;
    }

    public String getEncryptedlicense() {
        return this.encryptedlicense;
    }

    public void setEncryptedlicense(String encryptedlicense) {
        this.encryptedlicense = encryptedlicense;
    }

    public String getIsbillingokencrypted() {
        return this.isbillingokencrypted;
    }

    public void setIsbillingokencrypted(String isbillingokencrypted) {
        this.isbillingokencrypted = isbillingokencrypted;
    }

    public String getBillingerror() {
        return this.billingerror;
    }

    public void setBillingerror(String billingerror) {
        this.billingerror = billingerror;
    }

    public Date getLastbillingcheck() {
        return this.lastbillingcheck;
    }

    public void setLastbillingcheck(Date lastbillingcheck) {
        this.lastbillingcheck = lastbillingcheck;
    }

    public String getGooglemapsapikey() {
        return this.googlemapsapikey;
    }

    public void setGooglemapsapikey(String googlemapsapikey) {
        this.googlemapsapikey = googlemapsapikey;
    }

    public Date getDatemarkedinactive() {
        return datemarkedinactive;
    }

    public void setDatemarkedinactive(Date datemarkedinactive) {
        this.datemarkedinactive=datemarkedinactive;
    }

    public boolean getIssplashpageon() {
        return issplashpageon;
    }

    public void setIssplashpageon(boolean issplashpageon) {
        this.issplashpageon = issplashpageon;
    }

    public String getSplashpagehtml() {
        return splashpagehtml;
    }

    public void setSplashpagehtml(String splashpagehtml) {
        this.splashpagehtml = splashpagehtml;
    }
}
