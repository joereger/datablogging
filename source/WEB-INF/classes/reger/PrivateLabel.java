package reger;

import reger.core.db.Db;
import reger.core.ValidationException;
import reger.core.Debug;
import reger.core.licensing.License;
import reger.nestednav.NestedNavCollection;
import reger.nestednav.NestedNavItem;
import reger.plcontentmanagement.PlJspPage;
import reger.plcontentmanagement.AllPlJspPages;
import reger.plcontentmanagement.PlContentPage;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a private label.
 */
public class PrivateLabel {

    private int plid;
    private boolean usedynamicdns = false;
    private String titlebar;
    private String plname;
    private int islive=1;
    private String plbasedomain;
    public boolean issignupenabled = true;
    private boolean iscontentflaggingon = false;
    private boolean doesflaggedcontentneedtobeapproved = false;
    private boolean doallpostsneedtobeapproved = false;
    private long defaultmaxspaceinbytes=0;
    private long defaultmaxbandwidth=0;
    private boolean forcelogintoviewsites = false;
    private boolean istrackbackenabled = true;
    private boolean isweblogscompingon = true;
    private String emailtonotifyofnewaccounts = reger.Vars.EMAILDEFAULTTO;
    private boolean newaccountsrequireadminapproval = false;
    private String emailapiuniqueidentifier = "";
    private String termsofservice = "";
    private String comments = "";
    private String termsofuselinktext = "Terms of Service";
    private String feedbacklinktext = "Feedback";
    private boolean doapplyplusertemplatetopro = false;
    private int publicsitetemplateid = 0;
    private int entlisttemplateid = 0;
    private int hptemplateid = 0;
    private int marketingsitetemplateid = 0;
    private int marketingsitehptemplateid = 0;
    private int defaulteventtypeid = reger.Vars.DEFAULTLOGEVENTTYPEID;
    private String encryptedlicense;
    private double baseaccountprice;
    private double priceper100mbstorage;
    private double pricepergbbandwidth;
    private int plusertemplateid = 0;
    private String bannerone = "";
    private String bannertwo = "";
    private String bannerthree = "";
    private boolean showbannertagsonpro = false;
    private boolean isemailactivationofaccountsrequired = false;
    private String emailtextactivationmessage = "";
    private String emailsubjectactivationmessage = "";
    private String emailtextwelcomemessage = "";
    private String emailsubjectwelcomemessage = "";
    private String accountupgradeurl="";



    private License plLicense;

    //Megalogtypes this pl accepts
    private int[] megaLogTypes;

    //Password vars
    private int minPasswordChars = 5;
    private int minPasswordUpperCaseChars = 0;
    private int minPasswordLowerCaseChars = 0;
    private int minPasswordSpecialChars = 0;
    private int minPasswordNumericChars = 0;
    private boolean isPasswordSentViaEmail = true;

    //The NestedNavItems for this account. Note that this is ALL of them.
    private NestedNavCollection nestedNavCollection = new NestedNavCollection(new ArrayList<NestedNavItem>());

    //Peers of this pl
    PrivateLabelPeerRelationship[] peers = new PrivateLabelPeerRelationship[0];


    /**
     * Loads a private label.
     */
    public PrivateLabel(int plid){
        loadPl(plid);
    }

    public PrivateLabel(){
        //If one isn't provided, load the default private label
        loadPl(reger.Vars.PLIDDEFAULT);
    }

    public void refresh(){
        loadPl(plid);
    }

    public boolean loadPl(int plid){
        //Check for private label using this url
        //-----------------------------------
        //-----------------------------------
        String[][] getPl= Db.RunSQL("SELECT plid, titlebar, plname, islive, plbasedomain, plid, usedynamicdns, defaultmaxspaceinbytes, defaultmaxbandwidth, forcelogintoviewsites, istrackbackenabled, isweblogscompingon, emailtonotifyofnewaccounts, newaccountsrequireadminapproval, emailapiuniqueidentifier, minpasswordchars, minpassworduppercasechars, minpasswordlowercasechars, minpasswordspecialchars, minpasswordnumericchars, ispasswordsentviaemail, termsofservice, comments, termsofuselinktext, feedbacklinktext, doapplyplusertemplatetopro, publicsitetemplateid, entlisttemplateid, hptemplateid, marketingsitetemplateid, marketingsitehptemplateid, iscontentflaggingon, doesflaggedcontentneedtobeapproved, doallpostsneedtobeapproved, issignupenabled, defaulteventtypeid, encryptedlicense, baseaccountprice, priceper100mbstorage, pricepergbbandwidth, plusertemplateid, bannerone, bannertwo, bannerthree, showbannertagsonpro, isemailactivationofaccountsrequired, emailtextactivationmessage, emailsubjectactivationmessage, emailtextwelcomemessage, emailsubjectwelcomemessage, accountupgradeurl FROM pl WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (getPl!=null && getPl.length>0){
            titlebar = getPl[0][1];
            plname = getPl[0][2];
            islive = Integer.parseInt(getPl[0][3]);
            plbasedomain = getPl[0][4];
            this.plid = Integer.parseInt(getPl[0][5]);
            if (getPl[0][6].equals("1")){
                usedynamicdns = true;
            } else {
                usedynamicdns = false;
            }
            defaultmaxspaceinbytes=Long.parseLong(getPl[0][7]);
            defaultmaxbandwidth=Long.parseLong(getPl[0][8]);
            if (getPl[0][9].equals("1")){
                forcelogintoviewsites = true;
            } else {
                forcelogintoviewsites = false;
            }
            if (getPl[0][10].equals("1")){
                istrackbackenabled = true;
            } else {
                istrackbackenabled = false;
            }
            if (getPl[0][11].equals("1")){
                isweblogscompingon = true;
            } else {
                isweblogscompingon = false;
            }
            emailtonotifyofnewaccounts = getPl[0][12];
            if (emailtonotifyofnewaccounts.equals("")){
                emailtonotifyofnewaccounts=reger.Vars.EMAILDEFAULTFROM;
            }
            if (getPl[0][13].equals("1")){
                newaccountsrequireadminapproval = true;
            } else {
                newaccountsrequireadminapproval = false;
            }
            emailapiuniqueidentifier = getPl[0][14];
            minPasswordChars = Integer.parseInt(getPl[0][15]);
            minPasswordUpperCaseChars = Integer.parseInt(getPl[0][16]);
            minPasswordLowerCaseChars = Integer.parseInt(getPl[0][17]);
            minPasswordSpecialChars = Integer.parseInt(getPl[0][18]);
            minPasswordNumericChars = Integer.parseInt(getPl[0][19]);
            if (getPl[0][20].equals("1")){
                isPasswordSentViaEmail = true;
            } else {
                isPasswordSentViaEmail = false;
            }
            termsofservice = getPl[0][21];
            comments = getPl[0][22];
            termsofuselinktext = getPl[0][23];
            feedbacklinktext = getPl[0][24];
            if (getPl[0][25].equals("1")){
                doapplyplusertemplatetopro = true;
            } else {
                doapplyplusertemplatetopro = false;
            }
            publicsitetemplateid = Integer.parseInt(getPl[0][26]);
            entlisttemplateid = Integer.parseInt(getPl[0][27]);
            hptemplateid = Integer.parseInt(getPl[0][28]);
            marketingsitetemplateid = Integer.parseInt(getPl[0][29]);
            marketingsitehptemplateid = Integer.parseInt(getPl[0][30]);
            if (getPl[0][31].equals("1")){
                iscontentflaggingon = true;
            } else {
                iscontentflaggingon = false;
            }
            if (getPl[0][32].equals("1")){
                doesflaggedcontentneedtobeapproved = true;
            } else {
                doesflaggedcontentneedtobeapproved = false;
            }
            if (getPl[0][33].equals("1")){
                doallpostsneedtobeapproved = true;
            } else {
                doallpostsneedtobeapproved = false;
            }
            if (getPl[0][34].equals("1")){
                issignupenabled = true;
            } else {
                issignupenabled = false;
            }
            defaulteventtypeid = Integer.parseInt(getPl[0][35]);
            plLicense = new License(reger.licensing.ServerLicense.getLicense(), getPl[0][36]);
            if (reger.core.Util.isnumeric(getPl[0][37])){
                baseaccountprice = Double.parseDouble(getPl[0][37]);
            }
            if (reger.core.Util.isnumeric(getPl[0][38])){
                priceper100mbstorage = Double.parseDouble(getPl[0][38]);
            }
            if (reger.core.Util.isnumeric(getPl[0][39])){
                pricepergbbandwidth = Double.parseDouble(getPl[0][39]);
            }
            plusertemplateid = Integer.parseInt(getPl[0][40]);
            bannerone = getPl[0][41];
            bannertwo = getPl[0][42];
            bannerthree = getPl[0][43];
            showbannertagsonpro = reger.core.Util.booleanFromSQLText(getPl[0][44]);
            isemailactivationofaccountsrequired = reger.core.Util.booleanFromSQLText(getPl[0][45]);
            emailtextactivationmessage =  getPl[0][46];
            emailsubjectactivationmessage = getPl[0][47];
            emailtextwelcomemessage = getPl[0][48];
            emailsubjectwelcomemessage = getPl[0][49];
            accountupgradeurl = getPl[0][50];

            //Override license values
            if (defaultmaxspaceinbytes<=0){
                defaultmaxspaceinbytes = Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES));
            }
            if (defaultmaxbandwidth<=0){
                defaultmaxbandwidth = Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH));
            }

            //Load up the megalogtypes
            loadMegalogtypes();

            //Load the NestedNavItems
            loadNestedNavItems();

            //Load peers
            loadPeers();

            Debug.debug(5, "", "Found pl.  plid=" + plid);
            return true;
        }
        return false;
    }

    private void loadMegalogtypes(){
        megaLogTypes = new int[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstPlEv= Db.RunSQL("SELECT eventtypeid FROM pleventtypeid WHERE plid='"+plid+"' ORDER BY priority ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstPlEv!=null && rstPlEv.length>0){
            for(int i=0; i<rstPlEv.length; i++){
                megaLogTypes = reger.core.Util.addToIntArray(megaLogTypes, Integer.parseInt(rstPlEv[i][0]));
            }
        }
    }

    private void loadNestedNavItems(){

        //Get nav items from system
        ArrayList<NestedNavItem> staticJspPages = AllPlJspPages.getNestedNavItems();
        //Get list of those that are hidden by this pl
        HashMap hiddenByPl = new HashMap();
        //-----------------------------------
        //-----------------------------------
        String[][] rstHidden= Db.RunSQL("SELECT nestednavid FROM plnavhide WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstHidden!=null && rstHidden.length>0){
            for(int i=0; i<rstHidden.length; i++){
                hiddenByPl.put(new Integer(Integer.parseInt(rstHidden[i][0])), true);
            }
        }
        //Create a new list of staticJspPages without those that are hidden by the pl
        ArrayList<NestedNavItem> staticJspPagesMinusHiddenOnes = new ArrayList<NestedNavItem>();
        for (Iterator it = staticJspPages.iterator(); it.hasNext(); ) {
            NestedNavItem navItem = (NestedNavItem)it.next();
            if (navItem!=null && hiddenByPl!=null && !hiddenByPl.containsKey(navItem.getThisNestedNavId())){
                staticJspPagesMinusHiddenOnes.add(navItem);
            }
        }
        //Get nav items from private label
        //-----------------------------------
        //-----------------------------------
        String[][] rstPlContPage= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPlContPage!=null && rstPlContPage.length>0){
            for(int i=0; i<rstPlContPage.length; i++){
                PlContentPage plContPage = new PlContentPage(Integer.parseInt(rstPlContPage[i][0]));
                reger.core.Debug.debug(5, "PrivateLabel.java", "Found a plcontentpageid: "+plContPage.getPlcontentpageid() + " " + plContPage.getName());
                staticJspPagesMinusHiddenOnes.add((NestedNavItem)plContPage);
            }
        }
        if (nestedNavCollection!=null){
            synchronized(nestedNavCollection){
                nestedNavCollection = new NestedNavCollection(staticJspPagesMinusHiddenOnes);
            }
        }
    }


    private void loadPeers(){
        peers = new PrivateLabelPeerRelationship[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstPeers= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPeers!=null && rstPeers.length>0){
            for(int i=0; i<rstPeers.length; i++){
                peers = AddToArray.addToPeerRelationshipArray(peers, new PrivateLabelPeerRelationship(Integer.parseInt(rstPeers[i][0])));
            }
        }
    }

    public String getPeerSql(){
        StringBuffer sql = new StringBuffer();
        sql.append(" ( pl.plid='"+plid+"' ");
        for (int i = 0; i < peers.length; i++) {
            sql.append(" OR pl.plid='"+peers[i].getPlpeerid()+"' ");
        }
        sql.append(" ) ");
        return sql.toString();
    }

    public boolean isPlidAPeer(int plidOfPeer){
        for (int i = 0; i < peers.length; i++) {
            if (peers[i].getPeerplid()==plidOfPeer){
                return true;
            }
        }
        return false;
    }


    /**
     * Checks to make sure that we're still on the same web site.
     * Each page calls this function.
     */
    public static int findPlid(reger.UrlSplitter urlSplitter){
        Debug.debug(5, "", "PrivateLabel.java - Searching for pl.  urlSplitter.getServername()=" + urlSplitter.getServername());
        //-----------------------------------
        //-----------------------------------
        String[][] rstPl= Db.RunSQL("SELECT plid FROM pl "+
        "WHERE "+
        "("+
        "(plbasedomain='"+ reger.core.Util.cleanForSQL(urlSplitter.getServername()) +"')"+
        ")");
        //-----------------------------------
        //-----------------------------------
        if (rstPl!=null && rstPl.length>0){
            Debug.debug(5, "", "Found PL.  Plid=" + rstPl[0][0]);
            //Return a new and populated private label
            return Integer.parseInt(rstPl[0][0]);
        }
        //If more than one account is returned, we have a problem
        if (rstPl.length>1){
            StringBuffer err = new StringBuffer();
            err.append("Multiple Private Labels found for same incoming request url.  This is a bad thing.  PrivateLabel.findPlid()<br>");
            err.append("urlSplitter.getRawIncomingServername()=" + urlSplitter.getRawIncomingServername() + "<br>");
            err.append("urlSplitter.getServername()=" + urlSplitter.getServername() + "<br>");
            err.append("urlSplitter.getVirtualdir()=" + urlSplitter.getVirtualdir() + "<br>");
            err.append("urlSplitter.getSiterooturl()=" + urlSplitter.getSiterooturl() + "<br>");
            err.append("urlSplitter.getPort()=" + urlSplitter.getPort() + "<br>");
            err.append("Plids affected:<br>");
            for (int i = 0; i < rstPl.length; i++) {
                err.append("Plid=" + rstPl[i][0] + "<br>");
            }
            err.append("This is a problem because it means that for the URL above multiple private labels are found, but only one can be returned.  This means that at least one site is obscured, unavailable.  To correct, the plbasedomain of the private labels above needs to be made such that it does not conflict.  In theory the software has safeguards against this so manual database editing may have happened.  Or a bug in the software.");
            Debug.logtodb(err.toString(), "");
        }
        //No private label found
        Debug.debug(5, "", "PrivateLabel.java - No plid found. urlSplitter.getServername()="+ urlSplitter.getServername());
        return -1;
    }











    public void save() throws ValidationException{

        try{
            validateData();
        } catch (ValidationException valError){
            Debug.debug(5, "", "PrivateLabel.java - save() called. Validation fails.");
            throw valError;
        }
        Debug.debug(5, "", "PrivateLabel.java - save() called. Validation passed.");

        //-----------------------------------
        //-----------------------------------
        String[][] rstPlCt= Db.RunSQL("SELECT plid FROM pl WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPlCt!=null && rstPlCt.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE pl SET plname='"+ reger.core.Util.cleanForSQL(plname)+"',  titlebar='"+ reger.core.Util.cleanForSQL(titlebar)+"', comments='"+ reger.core.Util.cleanForSQL(comments)+"', plbasedomain='"+ reger.core.Util.cleanForSQL(plbasedomain)+"', issignupenabled='"+ reger.core.Util.booleanAsSQLText(issignupenabled)+"', iscontentflaggingon='"+reger.core.Util.booleanAsSQLText(iscontentflaggingon)+"', doesflaggedcontentneedtobeapproved='"+reger.core.Util.booleanAsSQLText(doesflaggedcontentneedtobeapproved)+"', doallpostsneedtobeapproved='"+reger.core.Util.booleanAsSQLText(doallpostsneedtobeapproved)+"', usedynamicdns='"+reger.core.Util.booleanAsSQLText(usedynamicdns)+"', defaultmaxspaceinbytes='"+ defaultmaxspaceinbytes+"', defaultmaxbandwidth='"+ defaultmaxbandwidth+"', termsofservice='"+ reger.core.Util.cleanForSQL(termsofservice)+"', newaccountsrequireadminapproval='"+reger.core.Util.booleanAsSQLText(newaccountsrequireadminapproval)+"', forcelogintoviewsites='"+reger.core.Util.booleanAsSQLText(forcelogintoviewsites)+"', istrackbackenabled='"+reger.core.Util.booleanAsSQLText(istrackbackenabled)+"', isweblogscompingon='"+reger.core.Util.booleanAsSQLText(isweblogscompingon)+"', emailtonotifyofnewaccounts='"+reger.core.Util.cleanForSQL(emailtonotifyofnewaccounts)+"', emailapiuniqueidentifier='"+reger.core.Util.cleanForSQL(emailapiuniqueidentifier)+"', minpasswordchars='"+minPasswordChars+"', minpassworduppercasechars='"+minPasswordUpperCaseChars+"', minpasswordlowercasechars='"+minPasswordLowerCaseChars+"', minpasswordspecialchars='"+minPasswordSpecialChars+"', minpasswordnumericchars='"+minPasswordNumericChars+"', ispasswordsentviaemail='"+reger.core.Util.booleanAsSQLText(isPasswordSentViaEmail)+"', termsofuselinktext='"+ reger.core.Util.cleanForSQL(termsofuselinktext)+"', feedbacklinktext='"+ reger.core.Util.cleanForSQL(feedbacklinktext)+"', doapplyplusertemplatetopro='"+ reger.core.Util.booleanAsSQLText(doapplyplusertemplatetopro)+"', publicsitetemplateid='"+ publicsitetemplateid+"', entlisttemplateid='"+ entlisttemplateid+"', hptemplateid='"+ hptemplateid+"', marketingsitetemplateid='"+ marketingsitetemplateid+"', marketingsitehptemplateid='"+ marketingsitehptemplateid+"', defaulteventtypeid='"+defaulteventtypeid+"', encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedlicense)+"', baseaccountprice='"+baseaccountprice+"', priceper100mbstorage='"+priceper100mbstorage+"', pricepergbbandwidth='"+pricepergbbandwidth+"', plusertemplateid='"+plusertemplateid+"', bannerone='"+reger.core.Util.cleanForSQL(bannerone)+"', bannertwo='"+reger.core.Util.cleanForSQL(bannertwo)+"', bannerthree='"+reger.core.Util.cleanForSQL(bannerthree)+"', showbannertagsonpro='"+reger.core.Util.booleanAsSQLText(showbannertagsonpro)+"', isemailactivationofaccountsrequired='"+reger.core.Util.booleanAsSQLText(isemailactivationofaccountsrequired)+"', emailtextactivationmessage='"+reger.core.Util.cleanForSQL(emailtextactivationmessage)+"', emailsubjectactivationmessage='"+reger.core.Util.cleanForSQL(emailsubjectactivationmessage)+"', emailtextwelcomemessage='"+reger.core.Util.cleanForSQL(emailtextwelcomemessage)+"', emailsubjectwelcomemessage='"+reger.core.Util.cleanForSQL(emailsubjectwelcomemessage)+"', accountupgradeurl='"+reger.core.Util.cleanForSQL(accountupgradeurl)+"' WHERE plid='"+ plid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            Debug.debug(5, "", "PrivateLabel.java - save() called. Validation passed. Couldn't update so adding new.");
            //-----------------------------------
            //-----------------------------------
            plid = Db.RunSQLInsert("INSERT INTO pl(plname, titlebar, comments, plbasedomain, issignupenabled, iscontentflaggingon, doesflaggedcontentneedtobeapproved, doallpostsneedtobeapproved, usedynamicdns, defaultmaxspaceinbytes, defaultmaxbandwidth, termsofservice, newaccountsrequireadminapproval, forcelogintoviewsites, istrackbackenabled, isweblogscompingon, emailtonotifyofnewaccounts, emailapiuniqueidentifier, minpasswordchars, minpassworduppercasechars, minpasswordlowercasechars, minpasswordspecialchars, minpasswordnumericchars, ispasswordsentviaemail, termsofuselinktext, feedbacklinktext, doapplyplusertemplatetopro, publicsitetemplateid, entlisttemplateid, hptemplateid, marketingsitetemplateid, marketingsitehptemplateid, defaulteventtypeid, encryptedlicense, baseaccountprice, priceper100mbstorage, pricepergbbandwidth, plusertemplateid, bannerone, bannertwo, bannerthree, showbannertagsonpro, isemailactivationofaccountsrequired, emailtextactivationmessage, emailsubjectactivationmessage, emailtextwelcomemessage, emailsubjectwelcomemessage, accountupgradeurl, islive) VALUES('"+ reger.core.Util.cleanForSQL(plname)+"','"+ reger.core.Util.cleanForSQL(titlebar)+"','"+ reger.core.Util.cleanForSQL(comments)+"','"+ reger.core.Util.cleanForSQL(plbasedomain)+"','"+ reger.core.Util.booleanAsSQLText(issignupenabled)+"', '"+reger.core.Util.booleanAsSQLText(iscontentflaggingon)+"', '"+reger.core.Util.booleanAsSQLText(doesflaggedcontentneedtobeapproved)+"', '"+reger.core.Util.booleanAsSQLText(doallpostsneedtobeapproved)+"', '"+reger.core.Util.booleanAsSQLText(usedynamicdns)+"', '"+ defaultmaxspaceinbytes+"', '"+ defaultmaxbandwidth+"', '"+ reger.core.Util.cleanForSQL(termsofservice)+"', '"+reger.core.Util.booleanAsSQLText(newaccountsrequireadminapproval)+"', '"+reger.core.Util.booleanAsSQLText(forcelogintoviewsites)+"',  '"+reger.core.Util.booleanAsSQLText(istrackbackenabled)+"', '"+reger.core.Util.booleanAsSQLText(isweblogscompingon)+"', '"+reger.core.Util.cleanForSQL(emailtonotifyofnewaccounts)+"', '"+reger.core.Util.cleanForSQL(emailapiuniqueidentifier)+"', '"+minPasswordChars+"', '"+minPasswordUpperCaseChars+"', '"+minPasswordLowerCaseChars+"', '"+minPasswordSpecialChars+"', '"+ minPasswordNumericChars +"', '"+reger.core.Util.booleanAsSQLText(isPasswordSentViaEmail)+"', '"+ reger.core.Util.cleanForSQL(termsofuselinktext)+"', '"+ reger.core.Util.cleanForSQL(feedbacklinktext)+"', '"+ reger.core.Util.booleanAsSQLText(doapplyplusertemplatetopro)+"', '"+publicsitetemplateid+"', '"+entlisttemplateid+"', '"+hptemplateid+"', '"+marketingsitetemplateid+"', '"+marketingsitehptemplateid+"', '"+defaulteventtypeid+"', '"+reger.core.Util.cleanForSQL(encryptedlicense)+"', '"+baseaccountprice+"', '"+priceper100mbstorage+"', '"+pricepergbbandwidth+"', '"+plusertemplateid+"', '"+reger.core.Util.cleanForSQL(bannerone)+"', '"+reger.core.Util.cleanForSQL(bannertwo)+"', '"+reger.core.Util.cleanForSQL(bannerthree)+"', '"+reger.core.Util.booleanAsSQLText(showbannertagsonpro)+"', '"+reger.core.Util.booleanAsSQLText(isemailactivationofaccountsrequired)+"', '"+reger.core.Util.cleanForSQL(emailtextactivationmessage)+"', '"+reger.core.Util.cleanForSQL(emailsubjectactivationmessage)+"', '"+reger.core.Util.cleanForSQL(emailtextwelcomemessage)+"', '"+reger.core.Util.cleanForSQL(emailsubjectwelcomemessage)+"', '"+reger.core.Util.cleanForSQL(accountupgradeurl)+"', '"+islive+"')");
            //-----------------------------------
            //-----------------------------------
        }


        //Refresh this one, loading the license
        refresh();

        //Refresh the memory object
        reger.AllPrivateLabelsInSystem.refresh();

    }

    public boolean canAddAnotherPrivateLabel(){
        //Maxpl validation
        if (plLicense !=null && plLicense.getProperty(License.PROPSTRINGMAXPRIVATELABELS)!=null && reger.core.Util.isinteger(plLicense.getProperty(License.PROPSTRINGMAXPRIVATELABELS))){
            int maxpls = Integer.parseInt(plLicense.getProperty(License.PROPSTRINGMAXPRIVATELABELS));
            if (maxpls>0){
                if((numberOfPlsInSystem()+1)>maxpls){
                    return false;
                } else {
                    return true;
                }
            } else {
                //A zero setting means infinite pls can be added
                return true;
            }
        }
        //If there's no value
        return false;
    }

    public int numberOfPlsInSystem(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstPls= Db.RunSQL("SELECT count(*) FROM pl");
        //-----------------------------------
        //-----------------------------------
        if (rstPls!=null && rstPls.length>0){
            int numberofpls = Integer.parseInt(rstPls[0][0]);
            return numberofpls;
        }
        return 0;
    }



    private void validateData() throws ValidationException{
        ValidationException valError = new ValidationException();


        //Make sure we can add another pl
        if (plid<=0 && !canAddAnotherPrivateLabel()){
            valError.addValidationError("The current license does not allow another private label to be added.  Please contact your system administrator or increase the number of maximum private labels in your license.");
            throw valError;
        }

        //Defaultmaxspaceinbytes must be less than what the license allows
        if (Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES))>0 && defaultmaxspaceinbytes>Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES))){
            //valError.addValidationError("The current license only allows you to set the MAXSPACEINBYTES for each account to a maximum of:" + plLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES));
            //throw valError;
            defaultmaxspaceinbytes = Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES));
        }

        //Defaultmaxbandwidth must be less than what the license allows
        if (Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH))>0 && defaultmaxbandwidth>Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH))){
            //valError.addValidationError("The current license only allows you to set the MAXBANDWIDTH for each account to a maximum of:" + plLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH));
            //throw valError;
            defaultmaxbandwidth = Long.parseLong(plLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH));
        }

        //Baseaccountprice must be more than what the license allows
        if (baseaccountprice<Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINBASEACCOUNTPRICE))){
            //valError.addValidationError("The current license only allows you to set the BASE ACCOUNT PRICE for each account to a minimum of:" + plLicense.getProperty(License.PROPSTRINGMINBASEACCOUNTPRICE) + ". The current value is: " + baseaccountprice + ". plid=" + plid);
            //throw valError;
            baseaccountprice = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINBASEACCOUNTPRICE));
        }

        //priceper100mbstorage must be more than what the license allows
        if (priceper100mbstorage<Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPER100MBSTORAGE))){
            //valError.addValidationError("The current license only allows you to set the PRICE PER 100MB STORAGE for each account to a minimum of:" + plLicense.getProperty(License.PROPSTRINGMINPRICEPER100MBSTORAGE));
            //throw valError;
            priceper100mbstorage = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPER100MBSTORAGE));
        }

        //pricepergbbandwidth must be more than what the license allows
        if (pricepergbbandwidth<Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPERGBBANDWIDTH))){
            //valError.addValidationError("The current license only allows you to set the PRICE PER 1GB BANDWIDTH for each account to a minimum of:" + plLicense.getProperty(License.PROPSTRINGMINPRICEPERGBBANDWIDTH));
            //throw valError;
            pricepergbbandwidth = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPERGBBANDWIDTH));
        }



        //See if the plbasedomain exists... it must be unique
        //-----------------------------------
        //-----------------------------------
        String[][] rstCreatepathbadflag= Db.RunSQL("SELECT count(*) FROM pl WHERE plbasedomain='"+reger.core.Util.cleanForSQL(plbasedomain)+"' AND plid<>'"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCreatepathbadflag!=null && rstCreatepathbadflag.length>0){
            if (Integer.parseInt(rstCreatepathbadflag[0][0])>0){
                Debug.debug(5, "", "PrivateLabel.java - validating plbasedomain and plbasedomain exists in the count of pls");
                valError.addValidationError("Sorry, that plbasedomain already exists.");
                throw valError;
            }
        }

        //Also need to check for conflicting accounts
        //-----------------------------------
        //-----------------------------------
        String[][] rstAccount= Db.RunSQL("SELECT accountid FROM account, pl "+
        "WHERE account.plid=pl.plid AND "+
        "(concat(account.accounturl, \".\", pl.plbasedomain)='"+reger.core.Util.cleanForSQL(plbasedomain)+"')"+
        " ");
        //-----------------------------------
        //-----------------------------------
        if (rstAccount!=null && rstAccount.length>0){
            for(int i=0; i<rstAccount.length; i++){
                Debug.debug(5, "", "PrivateLabel.java - validating plbasedomain and plbasedomain exists in the account");
                valError.addValidationError("Sorry, that plbasedomain already exists.");
                throw valError;
            }
        }
    }

    public void delete(){
        delete(reger.Vars.PLIDDEFAULT);
    }

    public void delete(int moveuserstothisplid){
        if (moveuserstothisplid<=0){
            moveuserstothisplid = reger.Vars.PLIDDEFAULT;
        }
        if (plid!=reger.Vars.PLIDDEFAULT){

            //Record where all users are being moved with pldeletearchive table for a record
            //-----------------------------------
            //-----------------------------------
            String[][] rstCur= Db.RunSQL("SELECT accountid FROM account WHERE plid='"+ plid +"'");
            //-----------------------------------
            //-----------------------------------
            if (rstCur!=null && rstCur.length>0){
                for(int i=0; i<rstCur.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO pldeletearchive(accountid, oldplid, newplid, date) VALUES('"+ rstCur[i][0] +"','"+ plid +"','"+moveuserstothisplid+"', '"+reger.core.TimeUtils.nowInGmtString()+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }

            //Move all users
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("UPDATE account SET plid='"+ moveuserstothisplid +"' WHERE plid='"+ plid +"'");
            //-----------------------------------
            //-----------------------------------

            //Mark the record dead
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM pl WHERE plid='"+ plid +"'");
            //-----------------------------------
            //-----------------------------------

            //Update all pl objects
            reger.AllPrivateLabelsInSystem.refresh();
        }
    }







    public void populateFromRequest(javax.servlet.http.HttpServletRequest request){
        plid = reger.core.RequestParam.getInt(request, "plid", 0);
        usedynamicdns = reger.core.RequestParam.getBoolean(request, "usedynamicdns", false);
        titlebar = reger.core.RequestParam.getString(request, "titlebar", "");
        issignupenabled = reger.core.RequestParam.getBoolean(request, "issignupenabled", true);
        plname = reger.core.RequestParam.getString(request, "plname", "Private Label");
        islive = reger.core.RequestParam.getInt(request, "islive", 1);
        plbasedomain = reger.core.RequestParam.getString(request, "plbasedomain", "");
        defaultmaxspaceinbytes = reger.core.RequestParam.getLong(request, "defaultmaxspaceinbytes", defaultmaxspaceinbytes);
        defaultmaxbandwidth = reger.core.RequestParam.getLong(request, "defaultmaxbandwidth", defaultmaxbandwidth);
        forcelogintoviewsites = reger.core.RequestParam.getBoolean(request, "forcelogintoviewsites", false);
        istrackbackenabled = reger.core.RequestParam.getBoolean(request, "istrackbackenabled", false);
        isweblogscompingon = reger.core.RequestParam.getBoolean(request, "isweblogscompingon", true);
        emailtonotifyofnewaccounts = reger.core.RequestParam.getString(request, "emailtonotifyofnewaccounts", "");
        newaccountsrequireadminapproval = reger.core.RequestParam.getBoolean(request, "newaccountsrequireadminapproval", false);
        emailapiuniqueidentifier = reger.core.RequestParam.getString(request, "emailapiuniqueidentifier", "");
        termsofservice = reger.core.RequestParam.getString(request, "termsofservice", "");
        comments = reger.core.RequestParam.getString(request, "comments", "");
        minPasswordChars = reger.core.RequestParam.getInt(request, "minpasswordchars", minPasswordChars);
        minPasswordUpperCaseChars = reger.core.RequestParam.getInt(request, "minpassworduppercasechars", minPasswordUpperCaseChars);
        minPasswordLowerCaseChars = reger.core.RequestParam.getInt(request, "minpasswordlowercasechars", minPasswordLowerCaseChars);
        minPasswordSpecialChars = reger.core.RequestParam.getInt(request, "minpasswordspecialchars", minPasswordSpecialChars);
        minPasswordNumericChars = reger.core.RequestParam.getInt(request, "minpasswordnumericchars", minPasswordNumericChars);
        isPasswordSentViaEmail = reger.core.RequestParam.getBoolean(request, "ispasswordsentviaemail", true);
        termsofuselinktext = reger.core.RequestParam.getString(request, "termsofuselinktext", "");
        feedbacklinktext = reger.core.RequestParam.getString(request, "feedbacklinktext", "");
        doapplyplusertemplatetopro = reger.core.RequestParam.getBoolean(request, "doapplyplusertemplatetopro", false);
        publicsitetemplateid = reger.core.RequestParam.getInt(request, "publicsitetemplateid", publicsitetemplateid);
        entlisttemplateid = reger.core.RequestParam.getInt(request, "entlisttemplateid", entlisttemplateid);
        hptemplateid = reger.core.RequestParam.getInt(request, "hptemplateid", hptemplateid);
        marketingsitetemplateid = reger.core.RequestParam.getInt(request, "marketingsitetemplateid", marketingsitetemplateid);
        marketingsitehptemplateid = reger.core.RequestParam.getInt(request, "marketingsitehptemplateid", marketingsitehptemplateid);
        defaulteventtypeid = reger.core.RequestParam.getInt(request, "defaulteventtypeid", defaulteventtypeid);
        encryptedlicense = reger.core.RequestParam.getString(request, "encryptedlicense", "");
        plLicense = plLicense = new License(reger.licensing.ServerLicense.getLicense(), encryptedlicense);
        baseaccountprice = reger.core.RequestParam.getDouble(request, "baseaccountprice", baseaccountprice);
        priceper100mbstorage = reger.core.RequestParam.getDouble(request, "priceper100mbstorage", priceper100mbstorage);
        pricepergbbandwidth = reger.core.RequestParam.getDouble(request, "pricepergbbandwidth", priceper100mbstorage);
        bannerone = reger.core.RequestParam.getString(request, "bannerone", "");
        bannertwo = reger.core.RequestParam.getString(request, "bannertwo", "");
        bannerthree = reger.core.RequestParam.getString(request, "bannerthree", "");
        showbannertagsonpro = reger.core.RequestParam.getBoolean(request, "showbannertagsonpro", false);
        isemailactivationofaccountsrequired = reger.core.RequestParam.getBoolean(request, "isemailactivationofaccountsrequired", true);
        emailtextactivationmessage = reger.core.RequestParam.getString(request, "emailtextactivationmessage", "");
        emailsubjectactivationmessage = reger.core.RequestParam.getString(request, "emailsubjectactivationmessage", "");
        emailtextwelcomemessage = reger.core.RequestParam.getString(request, "emailtextwelcomemessage", "");
        emailsubjectwelcomemessage = reger.core.RequestParam.getString(request, "emailsubjectwelcomemessage", "");
        accountupgradeurl = reger.core.RequestParam.getString(request, "accountupgradeurl", "");

        String contentapproval=reger.core.RequestParam.getString(request, "contentapproval", "unmoderated");;
        if (contentapproval.equals("unmoderated")){
            iscontentflaggingon=false;
            doesflaggedcontentneedtobeapproved=false;
            doallpostsneedtobeapproved=false;
        } else if (contentapproval.equals("flaggedforreview")){
            iscontentflaggingon=true;
            doesflaggedcontentneedtobeapproved=false;
            doallpostsneedtobeapproved=false;
        }  else if (contentapproval.equals("flaggedforapproval")){
            iscontentflaggingon=true;
            doesflaggedcontentneedtobeapproved=true;
            doallpostsneedtobeapproved=false;
        } else {
            iscontentflaggingon=true;
            doesflaggedcontentneedtobeapproved=true;
            doallpostsneedtobeapproved=true;
        }

    }

    public void setPeersDeletingOldOnes(int[] newPeers){
        //Delete current peers at DB level
        for (int i = 0; i < this.peers.length; i++) {
            this.peers[i].delete();
        }
        //Reset internal object
        this.peers = new PrivateLabelPeerRelationship[0];
        //Add/edit/update peers
        for (int i = 0; i < newPeers.length; i++) {
            PrivateLabelPeerRelationship newPlp = new PrivateLabelPeerRelationship(this.plid, newPeers[i]);
            newPlp.save();
            this.peers = AddToArray.addToPeerRelationshipArray(this.peers, newPlp);
        }
    }

    public boolean canAddAnotherUser(){
        if (!plLicense.getProperty(License.PROPSTRINGINDIVIDUALUSERSPAYTOUPGRADEACCOUNTS).equals("1")){
            //Maxusers validation
            if (reger.core.Util.isinteger(plLicense.getProperty(License.PROPSTRINGMAXUSERS))){
                int maxusers = Integer.parseInt(plLicense.getProperty(License.PROPSTRINGMAXUSERS));
                if (maxusers>0){
                    if((numberOfUsersInPl()+1)>maxusers){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int numberOfUsersInPl(){
        //Figure out how many are there already
        //-----------------------------------
        //-----------------------------------
        String[][] rstUsers= Db.RunSQL("SELECT count(DISTINCT accountuserid) FROM accountuser, account WHERE accountuser.accountid=account.accountid AND account.plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUsers!=null && rstUsers.length>0){
            int currentusers = Integer.parseInt(rstUsers[0][0]);
            return currentusers;
        }
        return 0;
    }



    public int getPlid() {
        return plid;
    }

    public boolean getUsedynamicdns() {
        return usedynamicdns;
    }

    public String getTitlebar() {
        return titlebar;
    }

    public String getPlname() {
        return plname;
    }

    public int getIslive() {
        return islive;
    }

    public String getPlbasedomain() {
        return plbasedomain;
    }


    public boolean getIssignupenabled() {
        return issignupenabled;
    }

    public boolean getIscontentflaggingon() {
        return iscontentflaggingon;
    }

    public boolean getDoesflaggedcontentneedtobeapproved() {
        return doesflaggedcontentneedtobeapproved;
    }

    public boolean getDoallpostsneedtobeapproved() {
        return doallpostsneedtobeapproved;
    }

    public long getDefaultmaxspaceinbytes() {
        return defaultmaxspaceinbytes;
    }

    public long getDefaultmaxbandwidth() {
        return defaultmaxbandwidth;
    }

    public boolean getForcelogintoviewsites() {
        return forcelogintoviewsites;
    }

    public boolean getIstrackbackenabled() {
        return istrackbackenabled;
    }

    public boolean getIsweblogscompingon() {
        return isweblogscompingon;
    }

    public String getEmailtonotifyofnewaccounts() {
        return emailtonotifyofnewaccounts;
    }

    public boolean getNewaccountsrequireadminapproval() {
        return newaccountsrequireadminapproval;
    }

    public String getEmailapiuniqueidentifier() {
        return emailapiuniqueidentifier;
    }

    public int[] getMegaLogTypes() {
        return megaLogTypes;
    }

    public int getMinPasswordChars() {
        return minPasswordChars;
    }

    public int getMinPasswordUpperCaseChars() {
        return minPasswordUpperCaseChars;
    }

    public int getMinPasswordLowerCaseChars() {
        return minPasswordLowerCaseChars;
    }

    public int getMinPasswordSpecialChars() {
        return minPasswordSpecialChars;
    }

    public int getMinPasswordNumericChars() {
        return minPasswordNumericChars;
    }

    public boolean getIsPasswordSentViaEmail() {
        return isPasswordSentViaEmail;
    }

    public String getTermsofservice() {
        return termsofservice;
    }

    public String getComments() {
        return comments;
    }

    public int getMarketingsitehptemplateid() {
        return marketingsitehptemplateid;
    }

    public int getMarketingsitetemplateid() {
        return marketingsitetemplateid;
    }

    public int getHptemplateid() {
        return hptemplateid;
    }

    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }

    public int getPublicsitetemplateid() {
        return publicsitetemplateid;
    }

    public boolean getDoapplyplusertemplatetopro() {
        return doapplyplusertemplatetopro;
    }

    public String getFeedbacklinktext() {
        return feedbacklinktext;
    }

    public String getTermsofuselinktext() {
        return termsofuselinktext;
    }

    public void setMarketingsitehptemplateid(int marketingsitehptemplateid) {
        this.marketingsitehptemplateid = marketingsitehptemplateid;
    }

    public void setMarketingsitetemplateid(int marketingsitetemplateid) {
        this.marketingsitetemplateid = marketingsitetemplateid;
    }

    public void setHptemplateid(int hptemplateid) {
        this.hptemplateid = hptemplateid;
    }

    public void setPlbasedomain(String plbasedomain) {
        this.plbasedomain = plbasedomain;
    }

    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }

    public void setPublicsitetemplateid(int publicsitetemplateid) {
        this.publicsitetemplateid = publicsitetemplateid;
    }

    public int getDefaulteventtypeid() {
        return defaulteventtypeid;
    }

    public void setDefaulteventtypeid(int defaulteventtypeid) {
        this.defaulteventtypeid = defaulteventtypeid;
    }

    public int getPlusertemplateid() {
        return plusertemplateid;
    }

    public void setPlusertemplateid(int plusertemplateid) {
        this.plusertemplateid = plusertemplateid;
    }

    public License getLicense() {
        return plLicense;
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

    public double getBaseaccountprice() {
        //Have to make sure amount is not less than what the license permits
        double minbaseaccountprice = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINBASEACCOUNTPRICE));
        if (baseaccountprice<minbaseaccountprice){
            return minbaseaccountprice;
        }
        return baseaccountprice;
    }

    public double getPriceper100mbstorage() {
        //Have to make sure amount is not less than what the license permits
        double minpriceper100mbstorage = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPER100MBSTORAGE));
        if (priceper100mbstorage<minpriceper100mbstorage){
            return minpriceper100mbstorage;
        }
        return priceper100mbstorage;
    }

    public double getPricepergbbandwidth() {
        //Have to make sure amount is not less than what the license permits
        double minpricepergbbandwidth = Double.parseDouble(plLicense.getProperty(License.PROPSTRINGMINPRICEPERGBBANDWIDTH));
        if (pricepergbbandwidth<minpricepergbbandwidth){
            return minpricepergbbandwidth;
        }
        return pricepergbbandwidth;
    }

    public String getPlBaseUrl(){
        return reger.Vars.getHttpUrlPrefix() + plbasedomain;
    }

    public String getPlBaseUrl(UserSession userSession){
        reger.core.Debug.debug(5, "PrivateLabel.java", "sending inUrl="+userSession.getUrlSplitter().getScheme() + "://" + plbasedomain);
        return userSession.getUrlWithPortSmartlyAttached(userSession.getUrlSplitter().getScheme() + "://" + plbasedomain);
    }

    public NestedNavCollection getNestedNavCollection() {
        return nestedNavCollection;
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
