package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pl' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPlDAO.java
 * Finders for this DAO: reger.dao.finders.PlFinder.java
 * 
 */

public class PlDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "plDAO";

    protected int plid = 0;
    protected String plname = "";
    protected String plbasedomain = "";
    protected String titlebar = "";
    protected String comments = "";
    protected boolean islive = true;
    protected boolean issignupenabled = true;
    protected boolean iscontentflaggingon = true;
    protected boolean doesflaggedcontentneedtobeapproved = true;
    protected boolean doallpostsneedtobeapproved = true;
    protected boolean usedynamicdns = true;
    protected int defaultaccounttypeidatsignup = 0;
    protected int defaultmaxspaceinbytes = 0;
    protected String termsofservice = "";
    protected boolean newaccountsrequireadminapproval = true;
    protected boolean forcelogintoviewsites = true;
    protected boolean isweblogscompingon = true;
    protected String emailtonotifyofnewaccounts = "";
    protected String emailapiuniqueidentifier = "";
    protected int defaultmaxbandwidth = 0;
    protected int minpasswordchars = 0;
    protected int minpassworduppercasechars = 0;
    protected int minpasswordlowercasechars = 0;
    protected int minpasswordspecialchars = 0;
    protected int minpasswordnumericchars = 0;
    protected boolean ispasswordsentviaemail = true;
    protected String termsofuselinktext = "";
    protected String feedbacklinktext = "";
    protected boolean doapplyplusertemplatetopro = true;
    protected int publicsitetemplateid = 0;
    protected int entlisttemplateid = 0;
    protected int hptemplateid = 0;
    protected int marketingsitetemplateid = 0;
    protected int marketingsitehptemplateid = 0;
    protected int defaulteventtypeid = 0;
    protected String encryptedlicense = "";
    protected double baseaccountprice = 0;
    protected double priceper100mbstorage = 0;
    protected double pricepergbbandwidth = 0;
    protected boolean istrackbackenabled = true;
    protected int plusertemplateid = 0;
    protected String bannerone = "";
    protected String bannertwo = "";
    protected String bannerthree = "";
    protected boolean showbannertagsonpro = true;
    protected boolean isemailactivationofaccountsrequired = true;
    protected String emailtextactivationmessage = "";
    protected String emailsubjectactivationmessage = "";
    protected String emailtextwelcomemessage = "";
    protected String emailsubjectwelcomemessage = "";
    protected String accountupgradeurl = "";

    public PlDAO (int plid){
        this.plid = plid;
        load();
    }

    public PlDAO(){


    }

    public void load(){
        if (plid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(plid), CACHEGROUP);
            if (obj!=null && (obj instanceof PlDAO)){
                setProperties((PlDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT plid, plname, plbasedomain, titlebar, comments, islive, issignupenabled, iscontentflaggingon, doesflaggedcontentneedtobeapproved, doallpostsneedtobeapproved, usedynamicdns, defaultaccounttypeidatsignup, defaultmaxspaceinbytes, termsofservice, newaccountsrequireadminapproval, forcelogintoviewsites, isweblogscompingon, emailtonotifyofnewaccounts, emailapiuniqueidentifier, defaultmaxbandwidth, minpasswordchars, minpassworduppercasechars, minpasswordlowercasechars, minpasswordspecialchars, minpasswordnumericchars, ispasswordsentviaemail, termsofuselinktext, feedbacklinktext, doapplyplusertemplatetopro, publicsitetemplateid, entlisttemplateid, hptemplateid, marketingsitetemplateid, marketingsitehptemplateid, defaulteventtypeid, encryptedlicense, baseaccountprice, priceper100mbstorage, pricepergbbandwidth, istrackbackenabled, plusertemplateid, bannerone, bannertwo, bannerthree, showbannertagsonpro, isemailactivationofaccountsrequired, emailtextactivationmessage, emailsubjectactivationmessage, emailtextwelcomemessage, emailsubjectwelcomemessage, accountupgradeurl  FROM pl WHERE plid='"+plid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        plid = Integer.parseInt(rstData[0][0]);
                    } else {
                        plid = 0;
                    }

                    plname = rstData[0][1];

                    plbasedomain = rstData[0][2];

                    titlebar = rstData[0][3];

                    comments = rstData[0][4];

                    islive = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    issignupenabled = reger.core.Util.booleanFromSQLText(rstData[0][6]);

                    iscontentflaggingon = reger.core.Util.booleanFromSQLText(rstData[0][7]);

                    doesflaggedcontentneedtobeapproved = reger.core.Util.booleanFromSQLText(rstData[0][8]);

                    doallpostsneedtobeapproved = reger.core.Util.booleanFromSQLText(rstData[0][9]);

                    usedynamicdns = reger.core.Util.booleanFromSQLText(rstData[0][10]);

                    if (reger.core.Util.isinteger(rstData[0][11])){
                        defaultaccounttypeidatsignup = Integer.parseInt(rstData[0][11]);
                    } else {
                        defaultaccounttypeidatsignup = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][12])){
                        defaultmaxspaceinbytes = Integer.parseInt(rstData[0][12]);
                    } else {
                        defaultmaxspaceinbytes = 0;
                    }

                    termsofservice = rstData[0][13];

                    newaccountsrequireadminapproval = reger.core.Util.booleanFromSQLText(rstData[0][14]);

                    forcelogintoviewsites = reger.core.Util.booleanFromSQLText(rstData[0][15]);

                    isweblogscompingon = reger.core.Util.booleanFromSQLText(rstData[0][16]);

                    emailtonotifyofnewaccounts = rstData[0][17];

                    emailapiuniqueidentifier = rstData[0][18];

                    if (reger.core.Util.isinteger(rstData[0][19])){
                        defaultmaxbandwidth = Integer.parseInt(rstData[0][19]);
                    } else {
                        defaultmaxbandwidth = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][20])){
                        minpasswordchars = Integer.parseInt(rstData[0][20]);
                    } else {
                        minpasswordchars = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][21])){
                        minpassworduppercasechars = Integer.parseInt(rstData[0][21]);
                    } else {
                        minpassworduppercasechars = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][22])){
                        minpasswordlowercasechars = Integer.parseInt(rstData[0][22]);
                    } else {
                        minpasswordlowercasechars = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][23])){
                        minpasswordspecialchars = Integer.parseInt(rstData[0][23]);
                    } else {
                        minpasswordspecialchars = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][24])){
                        minpasswordnumericchars = Integer.parseInt(rstData[0][24]);
                    } else {
                        minpasswordnumericchars = 0;
                    }

                    ispasswordsentviaemail = reger.core.Util.booleanFromSQLText(rstData[0][25]);

                    termsofuselinktext = rstData[0][26];

                    feedbacklinktext = rstData[0][27];

                    doapplyplusertemplatetopro = reger.core.Util.booleanFromSQLText(rstData[0][28]);

                    if (reger.core.Util.isinteger(rstData[0][29])){
                        publicsitetemplateid = Integer.parseInt(rstData[0][29]);
                    } else {
                        publicsitetemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][30])){
                        entlisttemplateid = Integer.parseInt(rstData[0][30]);
                    } else {
                        entlisttemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][31])){
                        hptemplateid = Integer.parseInt(rstData[0][31]);
                    } else {
                        hptemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][32])){
                        marketingsitetemplateid = Integer.parseInt(rstData[0][32]);
                    } else {
                        marketingsitetemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][33])){
                        marketingsitehptemplateid = Integer.parseInt(rstData[0][33]);
                    } else {
                        marketingsitehptemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][34])){
                        defaulteventtypeid = Integer.parseInt(rstData[0][34]);
                    } else {
                        defaulteventtypeid = 0;
                    }

                    encryptedlicense = rstData[0][35];

                    if (reger.core.Util.isnumeric(rstData[0][36])){
                        baseaccountprice = Double.parseDouble(rstData[0][36]);
                    } else {
                        baseaccountprice = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][37])){
                        priceper100mbstorage = Double.parseDouble(rstData[0][37]);
                    } else {
                        priceper100mbstorage = 0;
                    }

                    if (reger.core.Util.isnumeric(rstData[0][38])){
                        pricepergbbandwidth = Double.parseDouble(rstData[0][38]);
                    } else {
                        pricepergbbandwidth = 0;
                    }

                    istrackbackenabled = reger.core.Util.booleanFromSQLText(rstData[0][39]);

                    if (reger.core.Util.isinteger(rstData[0][40])){
                        plusertemplateid = Integer.parseInt(rstData[0][40]);
                    } else {
                        plusertemplateid = 0;
                    }

                    bannerone = rstData[0][41];

                    bannertwo = rstData[0][42];

                    bannerthree = rstData[0][43];

                    showbannertagsonpro = reger.core.Util.booleanFromSQLText(rstData[0][44]);

                    isemailactivationofaccountsrequired = reger.core.Util.booleanFromSQLText(rstData[0][45]);

                    emailtextactivationmessage = rstData[0][46];

                    emailsubjectactivationmessage = rstData[0][47];

                    emailtextwelcomemessage = rstData[0][48];

                    emailsubjectwelcomemessage = rstData[0][49];

                    accountupgradeurl = rstData[0][50];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(plid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT plid FROM pl WHERE plid='"+plid+"' AND plid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pl SET plid='"+plid+"', plname='"+reger.core.Util.cleanForSQL(plname)+"', plbasedomain='"+reger.core.Util.cleanForSQL(plbasedomain)+"', titlebar='"+reger.core.Util.cleanForSQL(titlebar)+"', comments='"+reger.core.Util.cleanForSQL(comments)+"', islive='"+reger.core.Util.booleanAsSQLText(islive)+"', issignupenabled='"+reger.core.Util.booleanAsSQLText(issignupenabled)+"', iscontentflaggingon='"+reger.core.Util.booleanAsSQLText(iscontentflaggingon)+"', doesflaggedcontentneedtobeapproved='"+reger.core.Util.booleanAsSQLText(doesflaggedcontentneedtobeapproved)+"', doallpostsneedtobeapproved='"+reger.core.Util.booleanAsSQLText(doallpostsneedtobeapproved)+"', usedynamicdns='"+reger.core.Util.booleanAsSQLText(usedynamicdns)+"', defaultaccounttypeidatsignup='"+defaultaccounttypeidatsignup+"', defaultmaxspaceinbytes='"+defaultmaxspaceinbytes+"', termsofservice='"+reger.core.Util.cleanForSQL(termsofservice)+"', newaccountsrequireadminapproval='"+reger.core.Util.booleanAsSQLText(newaccountsrequireadminapproval)+"', forcelogintoviewsites='"+reger.core.Util.booleanAsSQLText(forcelogintoviewsites)+"', isweblogscompingon='"+reger.core.Util.booleanAsSQLText(isweblogscompingon)+"', emailtonotifyofnewaccounts='"+reger.core.Util.cleanForSQL(emailtonotifyofnewaccounts)+"', emailapiuniqueidentifier='"+reger.core.Util.cleanForSQL(emailapiuniqueidentifier)+"', defaultmaxbandwidth='"+defaultmaxbandwidth+"', minpasswordchars='"+minpasswordchars+"', minpassworduppercasechars='"+minpassworduppercasechars+"', minpasswordlowercasechars='"+minpasswordlowercasechars+"', minpasswordspecialchars='"+minpasswordspecialchars+"', minpasswordnumericchars='"+minpasswordnumericchars+"', ispasswordsentviaemail='"+reger.core.Util.booleanAsSQLText(ispasswordsentviaemail)+"', termsofuselinktext='"+reger.core.Util.cleanForSQL(termsofuselinktext)+"', feedbacklinktext='"+reger.core.Util.cleanForSQL(feedbacklinktext)+"', doapplyplusertemplatetopro='"+reger.core.Util.booleanAsSQLText(doapplyplusertemplatetopro)+"', publicsitetemplateid='"+publicsitetemplateid+"', entlisttemplateid='"+entlisttemplateid+"', hptemplateid='"+hptemplateid+"', marketingsitetemplateid='"+marketingsitetemplateid+"', marketingsitehptemplateid='"+marketingsitehptemplateid+"', defaulteventtypeid='"+defaulteventtypeid+"', encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"', baseaccountprice='"+String.valueOf(baseaccountprice)+"', priceper100mbstorage='"+String.valueOf(priceper100mbstorage)+"', pricepergbbandwidth='"+String.valueOf(pricepergbbandwidth)+"', istrackbackenabled='"+reger.core.Util.booleanAsSQLText(istrackbackenabled)+"', plusertemplateid='"+plusertemplateid+"', bannerone='"+reger.core.Util.cleanForSQL(bannerone)+"', bannertwo='"+reger.core.Util.cleanForSQL(bannertwo)+"', bannerthree='"+reger.core.Util.cleanForSQL(bannerthree)+"', showbannertagsonpro='"+reger.core.Util.booleanAsSQLText(showbannertagsonpro)+"', isemailactivationofaccountsrequired='"+reger.core.Util.booleanAsSQLText(isemailactivationofaccountsrequired)+"', emailtextactivationmessage='"+reger.core.Util.cleanForSQL(emailtextactivationmessage)+"', emailsubjectactivationmessage='"+reger.core.Util.cleanForSQL(emailsubjectactivationmessage)+"', emailtextwelcomemessage='"+reger.core.Util.cleanForSQL(emailtextwelcomemessage)+"', emailsubjectwelcomemessage='"+reger.core.Util.cleanForSQL(emailsubjectwelcomemessage)+"', accountupgradeurl='"+reger.core.Util.cleanForSQL(accountupgradeurl)+"'  WHERE plid='"+plid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(plid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            plid = Db.RunSQLInsert("INSERT INTO pl(plname, plbasedomain, titlebar, comments, islive, issignupenabled, iscontentflaggingon, doesflaggedcontentneedtobeapproved, doallpostsneedtobeapproved, usedynamicdns, defaultaccounttypeidatsignup, defaultmaxspaceinbytes, termsofservice, newaccountsrequireadminapproval, forcelogintoviewsites, isweblogscompingon, emailtonotifyofnewaccounts, emailapiuniqueidentifier, defaultmaxbandwidth, minpasswordchars, minpassworduppercasechars, minpasswordlowercasechars, minpasswordspecialchars, minpasswordnumericchars, ispasswordsentviaemail, termsofuselinktext, feedbacklinktext, doapplyplusertemplatetopro, publicsitetemplateid, entlisttemplateid, hptemplateid, marketingsitetemplateid, marketingsitehptemplateid, defaulteventtypeid, encryptedlicense, baseaccountprice, priceper100mbstorage, pricepergbbandwidth, istrackbackenabled, plusertemplateid, bannerone, bannertwo, bannerthree, showbannertagsonpro, isemailactivationofaccountsrequired, emailtextactivationmessage, emailsubjectactivationmessage, emailtextwelcomemessage, emailsubjectwelcomemessage, accountupgradeurl ) VALUES('"+plid+"', '"+reger.core.Util.cleanForSQL(plname)+"', '"+reger.core.Util.cleanForSQL(plbasedomain)+"', '"+reger.core.Util.cleanForSQL(titlebar)+"', '"+reger.core.Util.cleanForSQL(comments)+"', '"+reger.core.Util.booleanAsSQLText(islive)+"', '"+reger.core.Util.booleanAsSQLText(issignupenabled)+"', '"+reger.core.Util.booleanAsSQLText(iscontentflaggingon)+"', '"+reger.core.Util.booleanAsSQLText(doesflaggedcontentneedtobeapproved)+"', '"+reger.core.Util.booleanAsSQLText(doallpostsneedtobeapproved)+"', '"+reger.core.Util.booleanAsSQLText(usedynamicdns)+"', '"+defaultaccounttypeidatsignup+"', '"+defaultmaxspaceinbytes+"', '"+reger.core.Util.cleanForSQL(termsofservice)+"', '"+reger.core.Util.booleanAsSQLText(newaccountsrequireadminapproval)+"', '"+reger.core.Util.booleanAsSQLText(forcelogintoviewsites)+"', '"+reger.core.Util.booleanAsSQLText(isweblogscompingon)+"', '"+reger.core.Util.cleanForSQL(emailtonotifyofnewaccounts)+"', '"+reger.core.Util.cleanForSQL(emailapiuniqueidentifier)+"', '"+defaultmaxbandwidth+"', '"+minpasswordchars+"', '"+minpassworduppercasechars+"', '"+minpasswordlowercasechars+"', '"+minpasswordspecialchars+"', '"+minpasswordnumericchars+"', '"+reger.core.Util.booleanAsSQLText(ispasswordsentviaemail)+"', '"+reger.core.Util.cleanForSQL(termsofuselinktext)+"', '"+reger.core.Util.cleanForSQL(feedbacklinktext)+"', '"+reger.core.Util.booleanAsSQLText(doapplyplusertemplatetopro)+"', '"+publicsitetemplateid+"', '"+entlisttemplateid+"', '"+hptemplateid+"', '"+marketingsitetemplateid+"', '"+marketingsitehptemplateid+"', '"+defaulteventtypeid+"', '"+reger.core.Util.cleanForSQL(encryptedlicense)+"', '"+String.valueOf(baseaccountprice)+"', '"+String.valueOf(priceper100mbstorage)+"', '"+String.valueOf(pricepergbbandwidth)+"', '"+reger.core.Util.booleanAsSQLText(istrackbackenabled)+"', '"+plusertemplateid+"', '"+reger.core.Util.cleanForSQL(bannerone)+"', '"+reger.core.Util.cleanForSQL(bannertwo)+"', '"+reger.core.Util.cleanForSQL(bannerthree)+"', '"+reger.core.Util.booleanAsSQLText(showbannertagsonpro)+"', '"+reger.core.Util.booleanAsSQLText(isemailactivationofaccountsrequired)+"', '"+reger.core.Util.cleanForSQL(emailtextactivationmessage)+"', '"+reger.core.Util.cleanForSQL(emailsubjectactivationmessage)+"', '"+reger.core.Util.cleanForSQL(emailtextwelcomemessage)+"', '"+reger.core.Util.cleanForSQL(emailsubjectwelcomemessage)+"', '"+reger.core.Util.cleanForSQL(accountupgradeurl)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(plid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pl WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(plid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPlDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "plDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return plid;
    }

    public String getPrimaryKeyName(){
        return "plid";
    }

    public String getTableName(){
        return "pl";
    }

    public void setProperties(PlDAO obj){
        if(obj!=null){
            this.plid = obj.plid;
            this.plname = obj.plname;
            this.plbasedomain = obj.plbasedomain;
            this.titlebar = obj.titlebar;
            this.comments = obj.comments;
            this.islive = obj.islive;
            this.issignupenabled = obj.issignupenabled;
            this.iscontentflaggingon = obj.iscontentflaggingon;
            this.doesflaggedcontentneedtobeapproved = obj.doesflaggedcontentneedtobeapproved;
            this.doallpostsneedtobeapproved = obj.doallpostsneedtobeapproved;
            this.usedynamicdns = obj.usedynamicdns;
            this.defaultaccounttypeidatsignup = obj.defaultaccounttypeidatsignup;
            this.defaultmaxspaceinbytes = obj.defaultmaxspaceinbytes;
            this.termsofservice = obj.termsofservice;
            this.newaccountsrequireadminapproval = obj.newaccountsrequireadminapproval;
            this.forcelogintoviewsites = obj.forcelogintoviewsites;
            this.isweblogscompingon = obj.isweblogscompingon;
            this.emailtonotifyofnewaccounts = obj.emailtonotifyofnewaccounts;
            this.emailapiuniqueidentifier = obj.emailapiuniqueidentifier;
            this.defaultmaxbandwidth = obj.defaultmaxbandwidth;
            this.minpasswordchars = obj.minpasswordchars;
            this.minpassworduppercasechars = obj.minpassworduppercasechars;
            this.minpasswordlowercasechars = obj.minpasswordlowercasechars;
            this.minpasswordspecialchars = obj.minpasswordspecialchars;
            this.minpasswordnumericchars = obj.minpasswordnumericchars;
            this.ispasswordsentviaemail = obj.ispasswordsentviaemail;
            this.termsofuselinktext = obj.termsofuselinktext;
            this.feedbacklinktext = obj.feedbacklinktext;
            this.doapplyplusertemplatetopro = obj.doapplyplusertemplatetopro;
            this.publicsitetemplateid = obj.publicsitetemplateid;
            this.entlisttemplateid = obj.entlisttemplateid;
            this.hptemplateid = obj.hptemplateid;
            this.marketingsitetemplateid = obj.marketingsitetemplateid;
            this.marketingsitehptemplateid = obj.marketingsitehptemplateid;
            this.defaulteventtypeid = obj.defaulteventtypeid;
            this.encryptedlicense = obj.encryptedlicense;
            this.baseaccountprice = obj.baseaccountprice;
            this.priceper100mbstorage = obj.priceper100mbstorage;
            this.pricepergbbandwidth = obj.pricepergbbandwidth;
            this.istrackbackenabled = obj.istrackbackenabled;
            this.plusertemplateid = obj.plusertemplateid;
            this.bannerone = obj.bannerone;
            this.bannertwo = obj.bannertwo;
            this.bannerthree = obj.bannerthree;
            this.showbannertagsonpro = obj.showbannertagsonpro;
            this.isemailactivationofaccountsrequired = obj.isemailactivationofaccountsrequired;
            this.emailtextactivationmessage = obj.emailtextactivationmessage;
            this.emailsubjectactivationmessage = obj.emailsubjectactivationmessage;
            this.emailtextwelcomemessage = obj.emailtextwelcomemessage;
            this.emailsubjectwelcomemessage = obj.emailsubjectwelcomemessage;
            this.accountupgradeurl = obj.accountupgradeurl;
        }
    }


    public int getPlid() {
        return plid;
    }


    public String getPlname() {
        return plname;
    }


    public void setPlname(String plname) {
        this.plname = plname;
    }


    public String getPlbasedomain() {
        return plbasedomain;
    }


    public void setPlbasedomain(String plbasedomain) {
        this.plbasedomain = plbasedomain;
    }


    public String getTitlebar() {
        return titlebar;
    }


    public void setTitlebar(String titlebar) {
        this.titlebar = titlebar;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }


    public boolean getIslive() {
        return islive;
    }


    public void setIslive(boolean islive) {
        this.islive = islive;
    }


    public boolean getIssignupenabled() {
        return issignupenabled;
    }


    public void setIssignupenabled(boolean issignupenabled) {
        this.issignupenabled = issignupenabled;
    }


    public boolean getIscontentflaggingon() {
        return iscontentflaggingon;
    }


    public void setIscontentflaggingon(boolean iscontentflaggingon) {
        this.iscontentflaggingon = iscontentflaggingon;
    }


    public boolean getDoesflaggedcontentneedtobeapproved() {
        return doesflaggedcontentneedtobeapproved;
    }


    public void setDoesflaggedcontentneedtobeapproved(boolean doesflaggedcontentneedtobeapproved) {
        this.doesflaggedcontentneedtobeapproved = doesflaggedcontentneedtobeapproved;
    }


    public boolean getDoallpostsneedtobeapproved() {
        return doallpostsneedtobeapproved;
    }


    public void setDoallpostsneedtobeapproved(boolean doallpostsneedtobeapproved) {
        this.doallpostsneedtobeapproved = doallpostsneedtobeapproved;
    }


    public boolean getUsedynamicdns() {
        return usedynamicdns;
    }


    public void setUsedynamicdns(boolean usedynamicdns) {
        this.usedynamicdns = usedynamicdns;
    }


    public int getDefaultaccounttypeidatsignup() {
        return defaultaccounttypeidatsignup;
    }


    public void setDefaultaccounttypeidatsignup(int defaultaccounttypeidatsignup) {
        this.defaultaccounttypeidatsignup = defaultaccounttypeidatsignup;
    }


    public int getDefaultmaxspaceinbytes() {
        return defaultmaxspaceinbytes;
    }


    public void setDefaultmaxspaceinbytes(int defaultmaxspaceinbytes) {
        this.defaultmaxspaceinbytes = defaultmaxspaceinbytes;
    }


    public String getTermsofservice() {
        return termsofservice;
    }


    public void setTermsofservice(String termsofservice) {
        this.termsofservice = termsofservice;
    }


    public boolean getNewaccountsrequireadminapproval() {
        return newaccountsrequireadminapproval;
    }


    public void setNewaccountsrequireadminapproval(boolean newaccountsrequireadminapproval) {
        this.newaccountsrequireadminapproval = newaccountsrequireadminapproval;
    }


    public boolean getForcelogintoviewsites() {
        return forcelogintoviewsites;
    }


    public void setForcelogintoviewsites(boolean forcelogintoviewsites) {
        this.forcelogintoviewsites = forcelogintoviewsites;
    }


    public boolean getIsweblogscompingon() {
        return isweblogscompingon;
    }


    public void setIsweblogscompingon(boolean isweblogscompingon) {
        this.isweblogscompingon = isweblogscompingon;
    }


    public String getEmailtonotifyofnewaccounts() {
        return emailtonotifyofnewaccounts;
    }


    public void setEmailtonotifyofnewaccounts(String emailtonotifyofnewaccounts) {
        this.emailtonotifyofnewaccounts = emailtonotifyofnewaccounts;
    }


    public String getEmailapiuniqueidentifier() {
        return emailapiuniqueidentifier;
    }


    public void setEmailapiuniqueidentifier(String emailapiuniqueidentifier) {
        this.emailapiuniqueidentifier = emailapiuniqueidentifier;
    }


    public int getDefaultmaxbandwidth() {
        return defaultmaxbandwidth;
    }


    public void setDefaultmaxbandwidth(int defaultmaxbandwidth) {
        this.defaultmaxbandwidth = defaultmaxbandwidth;
    }


    public int getMinpasswordchars() {
        return minpasswordchars;
    }


    public void setMinpasswordchars(int minpasswordchars) {
        this.minpasswordchars = minpasswordchars;
    }


    public int getMinpassworduppercasechars() {
        return minpassworduppercasechars;
    }


    public void setMinpassworduppercasechars(int minpassworduppercasechars) {
        this.minpassworduppercasechars = minpassworduppercasechars;
    }


    public int getMinpasswordlowercasechars() {
        return minpasswordlowercasechars;
    }


    public void setMinpasswordlowercasechars(int minpasswordlowercasechars) {
        this.minpasswordlowercasechars = minpasswordlowercasechars;
    }


    public int getMinpasswordspecialchars() {
        return minpasswordspecialchars;
    }


    public void setMinpasswordspecialchars(int minpasswordspecialchars) {
        this.minpasswordspecialchars = minpasswordspecialchars;
    }


    public int getMinpasswordnumericchars() {
        return minpasswordnumericchars;
    }


    public void setMinpasswordnumericchars(int minpasswordnumericchars) {
        this.minpasswordnumericchars = minpasswordnumericchars;
    }


    public boolean getIspasswordsentviaemail() {
        return ispasswordsentviaemail;
    }


    public void setIspasswordsentviaemail(boolean ispasswordsentviaemail) {
        this.ispasswordsentviaemail = ispasswordsentviaemail;
    }


    public String getTermsofuselinktext() {
        return termsofuselinktext;
    }


    public void setTermsofuselinktext(String termsofuselinktext) {
        this.termsofuselinktext = termsofuselinktext;
    }


    public String getFeedbacklinktext() {
        return feedbacklinktext;
    }


    public void setFeedbacklinktext(String feedbacklinktext) {
        this.feedbacklinktext = feedbacklinktext;
    }


    public boolean getDoapplyplusertemplatetopro() {
        return doapplyplusertemplatetopro;
    }


    public void setDoapplyplusertemplatetopro(boolean doapplyplusertemplatetopro) {
        this.doapplyplusertemplatetopro = doapplyplusertemplatetopro;
    }


    public int getPublicsitetemplateid() {
        return publicsitetemplateid;
    }


    public void setPublicsitetemplateid(int publicsitetemplateid) {
        this.publicsitetemplateid = publicsitetemplateid;
    }


    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }


    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }


    public int getHptemplateid() {
        return hptemplateid;
    }


    public void setHptemplateid(int hptemplateid) {
        this.hptemplateid = hptemplateid;
    }


    public int getMarketingsitetemplateid() {
        return marketingsitetemplateid;
    }


    public void setMarketingsitetemplateid(int marketingsitetemplateid) {
        this.marketingsitetemplateid = marketingsitetemplateid;
    }


    public int getMarketingsitehptemplateid() {
        return marketingsitehptemplateid;
    }


    public void setMarketingsitehptemplateid(int marketingsitehptemplateid) {
        this.marketingsitehptemplateid = marketingsitehptemplateid;
    }


    public int getDefaulteventtypeid() {
        return defaulteventtypeid;
    }


    public void setDefaulteventtypeid(int defaulteventtypeid) {
        this.defaulteventtypeid = defaulteventtypeid;
    }


    public String getEncryptedlicense() {
        return encryptedlicense;
    }


    public void setEncryptedlicense(String encryptedlicense) {
        this.encryptedlicense = encryptedlicense;
    }


    public double getBaseaccountprice() {
        return baseaccountprice;
    }


    public void setBaseaccountprice(double baseaccountprice) {
        this.baseaccountprice = baseaccountprice;
    }


    public double getPriceper100mbstorage() {
        return priceper100mbstorage;
    }


    public void setPriceper100mbstorage(double priceper100mbstorage) {
        this.priceper100mbstorage = priceper100mbstorage;
    }


    public double getPricepergbbandwidth() {
        return pricepergbbandwidth;
    }


    public void setPricepergbbandwidth(double pricepergbbandwidth) {
        this.pricepergbbandwidth = pricepergbbandwidth;
    }


    public boolean getIstrackbackenabled() {
        return istrackbackenabled;
    }


    public void setIstrackbackenabled(boolean istrackbackenabled) {
        this.istrackbackenabled = istrackbackenabled;
    }


    public int getPlusertemplateid() {
        return plusertemplateid;
    }


    public void setPlusertemplateid(int plusertemplateid) {
        this.plusertemplateid = plusertemplateid;
    }


    public String getBannerone() {
        return bannerone;
    }


    public void setBannerone(String bannerone) {
        this.bannerone = bannerone;
    }


    public String getBannertwo() {
        return bannertwo;
    }


    public void setBannertwo(String bannertwo) {
        this.bannertwo = bannertwo;
    }


    public String getBannerthree() {
        return bannerthree;
    }


    public void setBannerthree(String bannerthree) {
        this.bannerthree = bannerthree;
    }


    public boolean getShowbannertagsonpro() {
        return showbannertagsonpro;
    }


    public void setShowbannertagsonpro(boolean showbannertagsonpro) {
        this.showbannertagsonpro = showbannertagsonpro;
    }


    public boolean getIsemailactivationofaccountsrequired() {
        return isemailactivationofaccountsrequired;
    }


    public void setIsemailactivationofaccountsrequired(boolean isemailactivationofaccountsrequired) {
        this.isemailactivationofaccountsrequired = isemailactivationofaccountsrequired;
    }


    public String getEmailtextactivationmessage() {
        return emailtextactivationmessage;
    }


    public void setEmailtextactivationmessage(String emailtextactivationmessage) {
        this.emailtextactivationmessage = emailtextactivationmessage;
    }


    public String getEmailsubjectactivationmessage() {
        return emailsubjectactivationmessage;
    }


    public void setEmailsubjectactivationmessage(String emailsubjectactivationmessage) {
        this.emailsubjectactivationmessage = emailsubjectactivationmessage;
    }


    public String getEmailtextwelcomemessage() {
        return emailtextwelcomemessage;
    }


    public void setEmailtextwelcomemessage(String emailtextwelcomemessage) {
        this.emailtextwelcomemessage = emailtextwelcomemessage;
    }


    public String getEmailsubjectwelcomemessage() {
        return emailsubjectwelcomemessage;
    }


    public void setEmailsubjectwelcomemessage(String emailsubjectwelcomemessage) {
        this.emailsubjectwelcomemessage = emailsubjectwelcomemessage;
    }


    public String getAccountupgradeurl() {
        return accountupgradeurl;
    }


    public void setAccountupgradeurl(String accountupgradeurl) {
        this.accountupgradeurl = accountupgradeurl;
    }


}