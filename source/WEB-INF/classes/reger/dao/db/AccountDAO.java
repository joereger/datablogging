package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'account' database table
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 * Validator for this DAO: reger.dao.validators.ValidatorAccountDAO.java
 * Finders for this DAO: reger.dao.finders.AccountFinder.java
 * 
 */

public class AccountDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "accountDAO";

    protected int accountid = 0;
    protected int accounttypeid = 0;
    protected String customservername = "";
    protected int plid = 0;
    protected String homepagehtml = "";
    protected String homepagetitle = "";
    protected java.util.Calendar createdate = java.util.Calendar.getInstance();
    protected String timezoneid = "";
    protected int jspopup = 0;
    protected boolean homepagecalendar = true;
    protected boolean messagesstatus = true;
    protected boolean messagesapproval = true;
    protected boolean admintools = true;
    protected boolean pingweblogscom = true;
    protected boolean showhometab = true;
    protected String hometabtext = "";
    protected boolean showlogintab = true;
    protected int displaycharsinsummary = 0;
    protected int displaynumberofentries = 0;
    protected boolean userelatedlinks = true;
    protected String favesitetitle = "";
    protected boolean favesiteon = true;
    protected boolean onthisday = true;
    protected int emailnewsletter = 0;
    protected int emailsendhour = 0;
    protected double monthlycharge = 0;
    protected boolean issearchmysiteon = true;
    protected boolean istrackbackon = true;
    protected boolean islistedindirectory = true;
    protected boolean trackbackrequiresapproval = true;
    protected int istimeperiodon = 0;
    protected String accounturl = "";
    protected boolean isactiveaccount = true;
    protected boolean isnewpendingadminapproval = true;
    protected int hptemplateid = 0;
    protected int entlisttemplateid = 0;
    protected int sitetemplateid = 0;
    protected String customservername2 = "";
    protected String customservername3 = "";
    protected String accountemail = "";
    protected String newslettersubject = "";
    protected String encryptedlicense = "";
    protected String isbillingokencrypted = "";
    protected String billingerror = "";
    protected java.util.Calendar lastbillingcheck = java.util.Calendar.getInstance();
    protected String googlemapsapikey = "";
    protected double maxspaceinbytes = 0;

    public AccountDAO (int accountid){
        this.accountid = accountid;
        load();
    }

    public AccountDAO(){


    }

    public void load(){
        if (accountid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountid), CACHEGROUP);
            if (obj!=null && (obj instanceof AccountDAO)){
                setProperties((AccountDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT accountid, accounttypeid, customservername, plid, homepagehtml, homepagetitle, createdate, timezoneid, jspopup, homepagecalendar, messagesstatus, messagesapproval, admintools, pingweblogscom, showhometab, hometabtext, showlogintab, displaycharsinsummary, displaynumberofentries, userelatedlinks, favesitetitle, favesiteon, onthisday, emailnewsletter, emailsendhour, monthlycharge, issearchmysiteon, istrackbackon, islistedindirectory, trackbackrequiresapproval, istimeperiodon, accounturl, isactiveaccount, isnewpendingadminapproval, hptemplateid, entlisttemplateid, sitetemplateid, customservername2, customservername3, accountemail, newslettersubject, encryptedlicense, isbillingokencrypted, billingerror, lastbillingcheck, googlemapsapikey, maxspaceinbytes  FROM account WHERE accountid='"+accountid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        accountid = Integer.parseInt(rstData[0][0]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accounttypeid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accounttypeid = 0;
                    }

                    customservername = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        plid = Integer.parseInt(rstData[0][3]);
                    } else {
                        plid = 0;
                    }

                    homepagehtml = rstData[0][4];

                    homepagetitle = rstData[0][5];

                    createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][6]);

                    timezoneid = rstData[0][7];

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        jspopup = Integer.parseInt(rstData[0][8]);
                    } else {
                        jspopup = 0;
                    }

                    homepagecalendar = reger.core.Util.booleanFromSQLText(rstData[0][9]);

                    messagesstatus = reger.core.Util.booleanFromSQLText(rstData[0][10]);

                    messagesapproval = reger.core.Util.booleanFromSQLText(rstData[0][11]);

                    admintools = reger.core.Util.booleanFromSQLText(rstData[0][12]);

                    pingweblogscom = reger.core.Util.booleanFromSQLText(rstData[0][13]);

                    showhometab = reger.core.Util.booleanFromSQLText(rstData[0][14]);

                    hometabtext = rstData[0][15];

                    showlogintab = reger.core.Util.booleanFromSQLText(rstData[0][16]);

                    if (reger.core.Util.isinteger(rstData[0][17])){
                        displaycharsinsummary = Integer.parseInt(rstData[0][17]);
                    } else {
                        displaycharsinsummary = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][18])){
                        displaynumberofentries = Integer.parseInt(rstData[0][18]);
                    } else {
                        displaynumberofentries = 0;
                    }

                    userelatedlinks = reger.core.Util.booleanFromSQLText(rstData[0][19]);

                    favesitetitle = rstData[0][20];

                    favesiteon = reger.core.Util.booleanFromSQLText(rstData[0][21]);

                    onthisday = reger.core.Util.booleanFromSQLText(rstData[0][22]);

                    if (reger.core.Util.isinteger(rstData[0][23])){
                        emailnewsletter = Integer.parseInt(rstData[0][23]);
                    } else {
                        emailnewsletter = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][24])){
                        emailsendhour = Integer.parseInt(rstData[0][24]);
                    } else {
                        emailsendhour = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][25])){
                        monthlycharge = Double.parseDouble(rstData[0][25]);
                    } else {
                        monthlycharge = 0;
                    }

                    issearchmysiteon = reger.core.Util.booleanFromSQLText(rstData[0][26]);

                    istrackbackon = reger.core.Util.booleanFromSQLText(rstData[0][27]);

                    islistedindirectory = reger.core.Util.booleanFromSQLText(rstData[0][28]);

                    trackbackrequiresapproval = reger.core.Util.booleanFromSQLText(rstData[0][29]);

                    if (reger.core.Util.isinteger(rstData[0][30])){
                        istimeperiodon = Integer.parseInt(rstData[0][30]);
                    } else {
                        istimeperiodon = 0;
                    }

                    accounturl = rstData[0][31];

                    isactiveaccount = reger.core.Util.booleanFromSQLText(rstData[0][32]);

                    isnewpendingadminapproval = reger.core.Util.booleanFromSQLText(rstData[0][33]);

                    if (reger.core.Util.isinteger(rstData[0][34])){
                        hptemplateid = Integer.parseInt(rstData[0][34]);
                    } else {
                        hptemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][35])){
                        entlisttemplateid = Integer.parseInt(rstData[0][35]);
                    } else {
                        entlisttemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][36])){
                        sitetemplateid = Integer.parseInt(rstData[0][36]);
                    } else {
                        sitetemplateid = 0;
                    }

                    customservername2 = rstData[0][37];

                    customservername3 = rstData[0][38];

                    accountemail = rstData[0][39];

                    newslettersubject = rstData[0][40];

                    encryptedlicense = rstData[0][41];

                    isbillingokencrypted = rstData[0][42];

                    billingerror = rstData[0][43];

                    lastbillingcheck = reger.core.TimeUtils.dbstringtocalendar(rstData[0][44]);

                    googlemapsapikey = rstData[0][45];

                    if (reger.core.Util.isnumeric(rstData[0][46])){
                        maxspaceinbytes = Double.parseDouble(rstData[0][46]);
                    } else {
                        maxspaceinbytes = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(accountid), CACHEGROUP, this);
            }
        }
    }

    public void save() throws reger.core.ValidationException{
        try{
            validate();
        } catch (reger.core.ValidationException vex){
            throw vex;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT accountid FROM account WHERE accountid='"+accountid+"' AND accountid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE account SET accountid='"+accountid+"', accounttypeid='"+accounttypeid+"', customservername='"+reger.core.Util.cleanForSQL(customservername)+"', plid='"+plid+"', homepagehtml='"+reger.core.Util.cleanForSQL(homepagehtml)+"', homepagetitle='"+reger.core.Util.cleanForSQL(homepagetitle)+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', timezoneid='"+reger.core.Util.cleanForSQL(timezoneid)+"', jspopup='"+jspopup+"', homepagecalendar='"+reger.core.Util.booleanAsSQLText(homepagecalendar)+"', messagesstatus='"+reger.core.Util.booleanAsSQLText(messagesstatus)+"', messagesapproval='"+reger.core.Util.booleanAsSQLText(messagesapproval)+"', admintools='"+reger.core.Util.booleanAsSQLText(admintools)+"', pingweblogscom='"+reger.core.Util.booleanAsSQLText(pingweblogscom)+"', showhometab='"+reger.core.Util.booleanAsSQLText(showhometab)+"', hometabtext='"+reger.core.Util.cleanForSQL(hometabtext)+"', showlogintab='"+reger.core.Util.booleanAsSQLText(showlogintab)+"', displaycharsinsummary='"+displaycharsinsummary+"', displaynumberofentries='"+displaynumberofentries+"', userelatedlinks='"+reger.core.Util.booleanAsSQLText(userelatedlinks)+"', favesitetitle='"+reger.core.Util.cleanForSQL(favesitetitle)+"', favesiteon='"+reger.core.Util.booleanAsSQLText(favesiteon)+"', onthisday='"+reger.core.Util.booleanAsSQLText(onthisday)+"', emailnewsletter='"+emailnewsletter+"', emailsendhour='"+emailsendhour+"', monthlycharge='"+String.valueOf(monthlycharge)+"', issearchmysiteon='"+reger.core.Util.booleanAsSQLText(issearchmysiteon)+"', istrackbackon='"+reger.core.Util.booleanAsSQLText(istrackbackon)+"', islistedindirectory='"+reger.core.Util.booleanAsSQLText(islistedindirectory)+"', trackbackrequiresapproval='"+reger.core.Util.booleanAsSQLText(trackbackrequiresapproval)+"', istimeperiodon='"+istimeperiodon+"', accounturl='"+reger.core.Util.cleanForSQL(accounturl)+"', isactiveaccount='"+reger.core.Util.booleanAsSQLText(isactiveaccount)+"', isnewpendingadminapproval='"+reger.core.Util.booleanAsSQLText(isnewpendingadminapproval)+"', hptemplateid='"+hptemplateid+"', entlisttemplateid='"+entlisttemplateid+"', sitetemplateid='"+sitetemplateid+"', customservername2='"+reger.core.Util.cleanForSQL(customservername2)+"', customservername3='"+reger.core.Util.cleanForSQL(customservername3)+"', accountemail='"+reger.core.Util.cleanForSQL(accountemail)+"', newslettersubject='"+reger.core.Util.cleanForSQL(newslettersubject)+"', encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"', isbillingokencrypted='"+reger.core.Util.cleanForSQL(isbillingokencrypted)+"', billingerror='"+reger.core.Util.cleanForSQL(billingerror)+"', lastbillingcheck='"+reger.core.TimeUtils.dateformatfordb(lastbillingcheck)+"', googlemapsapikey='"+reger.core.Util.cleanForSQL(googlemapsapikey)+"', maxspaceinbytes='"+String.valueOf(maxspaceinbytes)+"'  WHERE accountid='"+accountid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(accountid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            accountid = Db.RunSQLInsert("INSERT INTO account(accounttypeid, customservername, plid, homepagehtml, homepagetitle, createdate, timezoneid, jspopup, homepagecalendar, messagesstatus, messagesapproval, admintools, pingweblogscom, showhometab, hometabtext, showlogintab, displaycharsinsummary, displaynumberofentries, userelatedlinks, favesitetitle, favesiteon, onthisday, emailnewsletter, emailsendhour, monthlycharge, issearchmysiteon, istrackbackon, islistedindirectory, trackbackrequiresapproval, istimeperiodon, accounturl, isactiveaccount, isnewpendingadminapproval, hptemplateid, entlisttemplateid, sitetemplateid, customservername2, customservername3, accountemail, newslettersubject, encryptedlicense, isbillingokencrypted, billingerror, lastbillingcheck, googlemapsapikey, maxspaceinbytes ) VALUES('"+accountid+"', '"+accounttypeid+"', '"+reger.core.Util.cleanForSQL(customservername)+"', '"+plid+"', '"+reger.core.Util.cleanForSQL(homepagehtml)+"', '"+reger.core.Util.cleanForSQL(homepagetitle)+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.Util.cleanForSQL(timezoneid)+"', '"+jspopup+"', '"+reger.core.Util.booleanAsSQLText(homepagecalendar)+"', '"+reger.core.Util.booleanAsSQLText(messagesstatus)+"', '"+reger.core.Util.booleanAsSQLText(messagesapproval)+"', '"+reger.core.Util.booleanAsSQLText(admintools)+"', '"+reger.core.Util.booleanAsSQLText(pingweblogscom)+"', '"+reger.core.Util.booleanAsSQLText(showhometab)+"', '"+reger.core.Util.cleanForSQL(hometabtext)+"', '"+reger.core.Util.booleanAsSQLText(showlogintab)+"', '"+displaycharsinsummary+"', '"+displaynumberofentries+"', '"+reger.core.Util.booleanAsSQLText(userelatedlinks)+"', '"+reger.core.Util.cleanForSQL(favesitetitle)+"', '"+reger.core.Util.booleanAsSQLText(favesiteon)+"', '"+reger.core.Util.booleanAsSQLText(onthisday)+"', '"+emailnewsletter+"', '"+emailsendhour+"', '"+String.valueOf(monthlycharge)+"', '"+reger.core.Util.booleanAsSQLText(issearchmysiteon)+"', '"+reger.core.Util.booleanAsSQLText(istrackbackon)+"', '"+reger.core.Util.booleanAsSQLText(islistedindirectory)+"', '"+reger.core.Util.booleanAsSQLText(trackbackrequiresapproval)+"', '"+istimeperiodon+"', '"+reger.core.Util.cleanForSQL(accounturl)+"', '"+reger.core.Util.booleanAsSQLText(isactiveaccount)+"', '"+reger.core.Util.booleanAsSQLText(isnewpendingadminapproval)+"', '"+hptemplateid+"', '"+entlisttemplateid+"', '"+sitetemplateid+"', '"+reger.core.Util.cleanForSQL(customservername2)+"', '"+reger.core.Util.cleanForSQL(customservername3)+"', '"+reger.core.Util.cleanForSQL(accountemail)+"', '"+reger.core.Util.cleanForSQL(newslettersubject)+"', '"+reger.core.Util.cleanForSQL(encryptedlicense)+"', '"+reger.core.Util.cleanForSQL(isbillingokencrypted)+"', '"+reger.core.Util.cleanForSQL(billingerror)+"', '"+reger.core.TimeUtils.dateformatfordb(lastbillingcheck)+"', '"+reger.core.Util.cleanForSQL(googlemapsapikey)+"', '"+String.valueOf(maxspaceinbytes)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(accountid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM account WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(accountid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAccountDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "accountDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return accountid;
    }

    public String getPrimaryKeyName(){
        return "accountid";
    }

    public String getTableName(){
        return "account";
    }

    public void setProperties(AccountDAO obj){
        if(obj!=null){
            this.accountid = obj.accountid;
            this.accounttypeid = obj.accounttypeid;
            this.customservername = obj.customservername;
            this.plid = obj.plid;
            this.homepagehtml = obj.homepagehtml;
            this.homepagetitle = obj.homepagetitle;
            this.createdate = obj.createdate;
            this.timezoneid = obj.timezoneid;
            this.jspopup = obj.jspopup;
            this.homepagecalendar = obj.homepagecalendar;
            this.messagesstatus = obj.messagesstatus;
            this.messagesapproval = obj.messagesapproval;
            this.admintools = obj.admintools;
            this.pingweblogscom = obj.pingweblogscom;
            this.showhometab = obj.showhometab;
            this.hometabtext = obj.hometabtext;
            this.showlogintab = obj.showlogintab;
            this.displaycharsinsummary = obj.displaycharsinsummary;
            this.displaynumberofentries = obj.displaynumberofentries;
            this.userelatedlinks = obj.userelatedlinks;
            this.favesitetitle = obj.favesitetitle;
            this.favesiteon = obj.favesiteon;
            this.onthisday = obj.onthisday;
            this.emailnewsletter = obj.emailnewsletter;
            this.emailsendhour = obj.emailsendhour;
            this.monthlycharge = obj.monthlycharge;
            this.issearchmysiteon = obj.issearchmysiteon;
            this.istrackbackon = obj.istrackbackon;
            this.islistedindirectory = obj.islistedindirectory;
            this.trackbackrequiresapproval = obj.trackbackrequiresapproval;
            this.istimeperiodon = obj.istimeperiodon;
            this.accounturl = obj.accounturl;
            this.isactiveaccount = obj.isactiveaccount;
            this.isnewpendingadminapproval = obj.isnewpendingadminapproval;
            this.hptemplateid = obj.hptemplateid;
            this.entlisttemplateid = obj.entlisttemplateid;
            this.sitetemplateid = obj.sitetemplateid;
            this.customservername2 = obj.customservername2;
            this.customservername3 = obj.customservername3;
            this.accountemail = obj.accountemail;
            this.newslettersubject = obj.newslettersubject;
            this.encryptedlicense = obj.encryptedlicense;
            this.isbillingokencrypted = obj.isbillingokencrypted;
            this.billingerror = obj.billingerror;
            this.lastbillingcheck = obj.lastbillingcheck;
            this.googlemapsapikey = obj.googlemapsapikey;
            this.maxspaceinbytes = obj.maxspaceinbytes;
        }
    }


    public int getAccountid() {
        return accountid;
    }


    public int getAccounttypeid() {
        return accounttypeid;
    }


    public void setAccounttypeid(int accounttypeid) {
        this.accounttypeid = accounttypeid;
    }


    public String getCustomservername() {
        return customservername;
    }


    public void setCustomservername(String customservername) {
        this.customservername = customservername;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public String getHomepagehtml() {
        return homepagehtml;
    }


    public void setHomepagehtml(String homepagehtml) {
        this.homepagehtml = homepagehtml;
    }


    public String getHomepagetitle() {
        return homepagetitle;
    }


    public void setHomepagetitle(String homepagetitle) {
        this.homepagetitle = homepagetitle;
    }


    public java.util.Calendar getCreatedate() {
        return createdate;
    }


    public void setCreatedate(java.util.Calendar createdate) {
        this.createdate = createdate;
    }


    public String getTimezoneid() {
        return timezoneid;
    }


    public void setTimezoneid(String timezoneid) {
        this.timezoneid = timezoneid;
    }


    public int getJspopup() {
        return jspopup;
    }


    public void setJspopup(int jspopup) {
        this.jspopup = jspopup;
    }


    public boolean getHomepagecalendar() {
        return homepagecalendar;
    }


    public void setHomepagecalendar(boolean homepagecalendar) {
        this.homepagecalendar = homepagecalendar;
    }


    public boolean getMessagesstatus() {
        return messagesstatus;
    }


    public void setMessagesstatus(boolean messagesstatus) {
        this.messagesstatus = messagesstatus;
    }


    public boolean getMessagesapproval() {
        return messagesapproval;
    }


    public void setMessagesapproval(boolean messagesapproval) {
        this.messagesapproval = messagesapproval;
    }


    public boolean getAdmintools() {
        return admintools;
    }


    public void setAdmintools(boolean admintools) {
        this.admintools = admintools;
    }


    public boolean getPingweblogscom() {
        return pingweblogscom;
    }


    public void setPingweblogscom(boolean pingweblogscom) {
        this.pingweblogscom = pingweblogscom;
    }


    public boolean getShowhometab() {
        return showhometab;
    }


    public void setShowhometab(boolean showhometab) {
        this.showhometab = showhometab;
    }


    public String getHometabtext() {
        return hometabtext;
    }


    public void setHometabtext(String hometabtext) {
        this.hometabtext = hometabtext;
    }


    public boolean getShowlogintab() {
        return showlogintab;
    }


    public void setShowlogintab(boolean showlogintab) {
        this.showlogintab = showlogintab;
    }


    public int getDisplaycharsinsummary() {
        return displaycharsinsummary;
    }


    public void setDisplaycharsinsummary(int displaycharsinsummary) {
        this.displaycharsinsummary = displaycharsinsummary;
    }


    public int getDisplaynumberofentries() {
        return displaynumberofentries;
    }


    public void setDisplaynumberofentries(int displaynumberofentries) {
        this.displaynumberofentries = displaynumberofentries;
    }


    public boolean getUserelatedlinks() {
        return userelatedlinks;
    }


    public void setUserelatedlinks(boolean userelatedlinks) {
        this.userelatedlinks = userelatedlinks;
    }


    public String getFavesitetitle() {
        return favesitetitle;
    }


    public void setFavesitetitle(String favesitetitle) {
        this.favesitetitle = favesitetitle;
    }


    public boolean getFavesiteon() {
        return favesiteon;
    }


    public void setFavesiteon(boolean favesiteon) {
        this.favesiteon = favesiteon;
    }


    public boolean getOnthisday() {
        return onthisday;
    }


    public void setOnthisday(boolean onthisday) {
        this.onthisday = onthisday;
    }


    public int getEmailnewsletter() {
        return emailnewsletter;
    }


    public void setEmailnewsletter(int emailnewsletter) {
        this.emailnewsletter = emailnewsletter;
    }


    public int getEmailsendhour() {
        return emailsendhour;
    }


    public void setEmailsendhour(int emailsendhour) {
        this.emailsendhour = emailsendhour;
    }


    public double getMonthlycharge() {
        return monthlycharge;
    }


    public void setMonthlycharge(double monthlycharge) {
        this.monthlycharge = monthlycharge;
    }


    public boolean getIssearchmysiteon() {
        return issearchmysiteon;
    }


    public void setIssearchmysiteon(boolean issearchmysiteon) {
        this.issearchmysiteon = issearchmysiteon;
    }


    public boolean getIstrackbackon() {
        return istrackbackon;
    }


    public void setIstrackbackon(boolean istrackbackon) {
        this.istrackbackon = istrackbackon;
    }


    public boolean getIslistedindirectory() {
        return islistedindirectory;
    }


    public void setIslistedindirectory(boolean islistedindirectory) {
        this.islistedindirectory = islistedindirectory;
    }


    public boolean getTrackbackrequiresapproval() {
        return trackbackrequiresapproval;
    }


    public void setTrackbackrequiresapproval(boolean trackbackrequiresapproval) {
        this.trackbackrequiresapproval = trackbackrequiresapproval;
    }


    public int getIstimeperiodon() {
        return istimeperiodon;
    }


    public void setIstimeperiodon(int istimeperiodon) {
        this.istimeperiodon = istimeperiodon;
    }


    public String getAccounturl() {
        return accounturl;
    }


    public void setAccounturl(String accounturl) {
        this.accounturl = accounturl;
    }


    public boolean getIsactiveaccount() {
        return isactiveaccount;
    }


    public void setIsactiveaccount(boolean isactiveaccount) {
        this.isactiveaccount = isactiveaccount;
    }


    public boolean getIsnewpendingadminapproval() {
        return isnewpendingadminapproval;
    }


    public void setIsnewpendingadminapproval(boolean isnewpendingadminapproval) {
        this.isnewpendingadminapproval = isnewpendingadminapproval;
    }


    public int getHptemplateid() {
        return hptemplateid;
    }


    public void setHptemplateid(int hptemplateid) {
        this.hptemplateid = hptemplateid;
    }


    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }


    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }


    public int getSitetemplateid() {
        return sitetemplateid;
    }


    public void setSitetemplateid(int sitetemplateid) {
        this.sitetemplateid = sitetemplateid;
    }


    public String getCustomservername2() {
        return customservername2;
    }


    public void setCustomservername2(String customservername2) {
        this.customservername2 = customservername2;
    }


    public String getCustomservername3() {
        return customservername3;
    }


    public void setCustomservername3(String customservername3) {
        this.customservername3 = customservername3;
    }


    public String getAccountemail() {
        return accountemail;
    }


    public void setAccountemail(String accountemail) {
        this.accountemail = accountemail;
    }


    public String getNewslettersubject() {
        return newslettersubject;
    }


    public void setNewslettersubject(String newslettersubject) {
        this.newslettersubject = newslettersubject;
    }


    public String getEncryptedlicense() {
        return encryptedlicense;
    }


    public void setEncryptedlicense(String encryptedlicense) {
        this.encryptedlicense = encryptedlicense;
    }


    public String getIsbillingokencrypted() {
        return isbillingokencrypted;
    }


    public void setIsbillingokencrypted(String isbillingokencrypted) {
        this.isbillingokencrypted = isbillingokencrypted;
    }


    public String getBillingerror() {
        return billingerror;
    }


    public void setBillingerror(String billingerror) {
        this.billingerror = billingerror;
    }


    public java.util.Calendar getLastbillingcheck() {
        return lastbillingcheck;
    }


    public void setLastbillingcheck(java.util.Calendar lastbillingcheck) {
        this.lastbillingcheck = lastbillingcheck;
    }


    public String getGooglemapsapikey() {
        return googlemapsapikey;
    }


    public void setGooglemapsapikey(String googlemapsapikey) {
        this.googlemapsapikey = googlemapsapikey;
    }


    public double getMaxspaceinbytes() {
        return maxspaceinbytes;
    }


    public void setMaxspaceinbytes(double maxspaceinbytes) {
        this.maxspaceinbytes = maxspaceinbytes;
    }


}