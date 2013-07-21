package reger;

import reger.nestednav.NestedNavItem;
import reger.nestednav.NestedNavCollection;
import reger.core.db.Db;
import reger.core.*;
import reger.core.licensing.License;
import reger.core.licensing.RegerLicensingApiClient;
import reger.cache.LogCache;
import reger.cache.providers.jboss.Cacheable;
import reger.files.FileAcl;
import reger.util.Num;

import java.util.*;

/**
* This important class is constructed for every session.  It holds
* critical information to build pages.
* The constructor grabs account-specific information.
* Once the userLogin() function is called user-specific vars are
* populated.
*/
@Cacheable
public class Account implements java.io.Serializable {

    //Basic account variables
    private int accountid=0;
    private String accounturl="";
    private int plid=1;
    private String timezoneid=Vars.TIMEZONEIDDEFAULT;
    private int jspopup=1;
    private int homepagecalendar=1;
    private int messagesstatus=1;
    private int messagesapproval=1;
    private String homepagetitle="";
    private String homepagehtml="";
    private String aboutthisbloghtml="";
    private String aboutthisblogtitle="";
    private int admintools=0;
    private int pingweblogscom=1;
    private int displaycharsinsummary=0;
    private int displaynumberofentries=10;
    private int userelatedlinks=1;
    private Calendar createdate = Calendar.getInstance();
    private String favesitetitle="";
    private int favesiteon=1;
    private int onthisday=1;
    private String customservername="";
    private String customservername2="";
    private String customservername3="";
    private int emailnewsletter=1;
    private int emailsendhour=3;
    private int issearchmysiteon=1;
    public boolean istrackbackon = false;
    public boolean islistedindirectory = true;
    public boolean trackbackrequiresapproval = true;
    private boolean istimeperiodon = true;
    private boolean isActiveAccount=false;
    private boolean isNewPendingAdminApproval=false;
    private boolean showhometab = true;
    private String hometabtext = "";
    private boolean showlogintab = true;
    private int hptemplateid = 0;
    private int entlisttemplateid = 0;
    private int sitetemplateid = 0;
    private long maxbandwidth = 0;
    private long maxspaceinbytes = 0;
    private String accountemail="";
    private String newslettersubject="";
    private String isbillingokencrypted;
    private Calendar lastbillingcheck = Calendar.getInstance();
    private String billingerror;
    private License accountLicense;
    private String googlemapsapikey;
    private Calendar datemarkedinactive = Calendar.getInstance();




    //Account space vars
    private long imagespaceused=0;
    private long textspaceused=0;
    private long bandwidthused=0;
    private long spaceused=0;

    //Calculated once at object refresh
    private boolean isPro = false;

    //This is the calculated site root URL
    private String siteRootUrl="";

    //The NestedNavItems for this account. Note that this is ALL of them.
    private NestedNavCollection nestedNavCollection = new NestedNavCollection(new ArrayList<NestedNavItem>());

    //Holds integer identifiers of all logs for this account
    private ArrayList<Integer> alllogsforaccountid = new ArrayList<Integer>();

    //Whether the account space var has been called
    private boolean hasUpdateSpaceBeenCalled=false;

    //Holds file permissions
    private ArrayList<FileAcl> fileacls = new ArrayList<FileAcl>();


    public Account(int accountid){
        this.accountid = accountid;
        refresh();
    }

    public void refresh(){

        //-----------------------------------
        //-----------------------------------
        String[][] rs= Db.RunSQL("SELECT " +
        "accountid, " + 			//0
        "plid, " + 			        //1
        "accounturl, " +	        //2
        "jspopup, " +				//3
        "homepagecalendar, " +		//4
        "messagesstatus, " +		//5
        "messagesapproval, " +		//6
        "homepagetitle, " +			//7
        "homepagehtml, " +			//8
        "admintools, " +			//9
        "pingweblogscom, " +		//10
        "displaycharsinsummary, " +	//11
        "displaynumberofentries, " +//12
        "userelatedlinks, " +		//13
        "createdate, " +			//14
        "favesitetitle, " +			//15
        "favesiteon, " +			//16
        "onthisday, " +				//17
        "customservername, " +		//18
        "emailnewsletter, " +		//19
        "emailsendhour," +			//20
        "timezoneid, " +			//21
        "issearchmysiteon," +       //22
        "istrackbackon," +          //23
        "islistedindirectory," +    //24
        "trackbackrequiresapproval," + //25
        "istimeperiodon," +         //26
        "isactiveaccount," +        //27
        "isnewpendingadminapproval," +  //28
        "showhometab," +            //29
        "hometabtext," +             //30
        "showlogintab," +             //31
        "hptemplateid," +             //32
        "entlisttemplateid," +        //33
        "sitetemplateid," +             //34
        "customservername2," +             //35
        "customservername3," +             //36
        "accountemail," +             //37
        "newslettersubject," +             //38
        "encryptedlicense," +          //39
        "isbillingokencrypted,"+       //40
        "lastbillingcheck,"+            //41
        "billingerror,"+                 //42
        "googlemapsapikey,"+             //43
        "datemarkedinactive,"+            //44
        "aboutthisblogtitle,"+            //45
        "aboutthisbloghtml"+            //46
        " FROM account WHERE accountid='"+accountid+"'" +
        " ORDER BY customservername DESC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if(rs!=null && rs.length>0) {
            this.accountid = Integer.parseInt(rs[0][0]);
            plid = Integer.parseInt(rs[0][1]);
            accounturl = rs[0][2];
            jspopup = Integer.parseInt(rs[0][3]);
            homepagecalendar = Integer.parseInt(rs[0][4]);
            messagesstatus = Integer.parseInt(rs[0][5]);
            messagesapproval = Integer.parseInt(rs[0][6]);
            homepagetitle = rs[0][7];
            homepagehtml = rs[0][8];
            if (reger.core.Util.isinteger(rs[0][9])){
                admintools = Integer.parseInt(rs[0][9]);
            }
            if (reger.core.Util.isinteger(rs[0][10])){
                pingweblogscom = Integer.parseInt(rs[0][10]);
            }
            displaycharsinsummary = Integer.parseInt(rs[0][11]);
            displaynumberofentries = Integer.parseInt(rs[0][12]);
            if (reger.core.Util.isinteger(rs[0][13])){
                userelatedlinks = Integer.parseInt(rs[0][13]);
            }
            createdate = TimeUtils.dbstringtocalendar(rs[0][14]);
            favesitetitle = rs[0][15];
            favesiteon = Integer.parseInt(rs[0][16]);
            onthisday = Integer.parseInt(rs[0][17]);
            customservername = rs[0][18];
            emailnewsletter = Integer.parseInt(rs[0][19]);
            emailsendhour = Integer.parseInt(rs[0][20]);
            timezoneid= rs[0][21];
            if (reger.core.Util.isinteger(rs[0][22])){
                issearchmysiteon= Integer.parseInt(rs[0][22]);
            }

            if (rs[0][23].equals("1")){
                istrackbackon = true;
            } else {
                istrackbackon = false;
            }
            if (rs[0][24].equals("0")){
                islistedindirectory = false;
            } else {
                islistedindirectory = true;
            }
            if (rs[0][25].equals("0")){
                trackbackrequiresapproval = false;
            } else {
                trackbackrequiresapproval = true;
            }
            if (rs[0][26].equals("0")){
                istimeperiodon = false;
            } else {
                istimeperiodon = true;
            }

            if (rs[0][27].equals("1")){
                isActiveAccount = true;
            } else {
                isActiveAccount = false;
            }
            if (rs[0][28].equals("1")){
                isNewPendingAdminApproval = true;
            } else {
                isNewPendingAdminApproval = false;
            }
            if (rs[0][29].equals("0")){
                showhometab = false;
            } else {
                showhometab = true;
            }
            hometabtext= rs[0][30];
            if (rs[0][31].equals("0")){
                showlogintab = false;
            } else {
                showlogintab = true;
            }

            hptemplateid = Integer.parseInt(rs[0][32]);
            entlisttemplateid = Integer.parseInt(rs[0][33]);
            sitetemplateid = Integer.parseInt(rs[0][34]);
            customservername2 = rs[0][35];
            customservername3 = rs[0][36];
            accountemail = rs[0][37];
            newslettersubject = rs[0][38];
            accountLicense = new License(AllPrivateLabelsInSystem.getPrivateLabel(plid).getLicense(), rs[0][39]);
            isbillingokencrypted = rs[0][40];
            lastbillingcheck = TimeUtils.dbstringtocalendar(rs[0][41]);
            billingerror = rs[0][42];
            googlemapsapikey = rs[0][43];
            datemarkedinactive = TimeUtils.dbstringtocalendar(rs[0][44]);
            aboutthisblogtitle = rs[0][45];
            aboutthisbloghtml = rs[0][46];

            //Set the site root url
            siteRootUrl = setSiteRootUrlViaAccountid(accountid);

            //Set the maxspace and maxbandwidth vars
            loadMaxSpaceInBytesFromLicense();
            loadMaxBandwidthFromLicense();

            //Update traffic hits used
            updateBandwidthused();

            //Update space used
            //updateSpaceused();

            //Load the logs for this account
            loadAllLogsForAccountid();

            //Load the NestedNavItems
            loadNestedNavItems();

            //Calculate isPro
            calculateIsPro();

            //Load file acls
            loadFileAcls();

        } else {
            //Fail to find an account
            this.accountid=0;
        }
    }

    private void loadFileAcls(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                fileacls.add(new FileAcl(Integer.parseInt(rstData[i][0])));
            }
        }
    }

    private void loadMaxSpaceInBytesFromLicense(){
        if (reger.core.Util.isnumeric(accountLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES))){
            this.maxspaceinbytes = Long.parseLong(accountLicense.getProperty(License.PROPSTRINGMAXSPACEINBYTES));
        }
    }

    private void loadMaxBandwidthFromLicense(){
        if (reger.core.Util.isnumeric(accountLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH))){
            this.maxbandwidth = Long.parseLong(accountLicense.getProperty(License.PROPSTRINGMAXBANDWIDTH));
        }
    }

    private void loadNestedNavItems(){
        ArrayList<NestedNavItem> allNestedNavItems = new ArrayList<NestedNavItem>();

        //Add all logs
        for (Iterator it = alllogsforaccountid.iterator(); it.hasNext(); ) {
           Integer logid = (Integer)it.next();
            Log log = LogCache.get(logid);
            Debug.debug(5, "", "Account.java - log added:" + log.getName());
            allNestedNavItems.add((NestedNavItem)log);
        }
        Debug.debug(5, "", "Account.java - allNestedNavItems.length:" + allNestedNavItems.size());


        //contentPages added to allNestedNavItems
        //-----------------------------------
        //-----------------------------------
        String[][] rstCp= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCp!=null && rstCp.length>0){
            for(int i=0; i<rstCp.length; i++){
                ContentPage cp = new ContentPage(Integer.parseInt(rstCp[i][0]));
                allNestedNavItems.add((NestedNavItem)cp);
            }
        }

        //Put them into a collection
        nestedNavCollection = new NestedNavCollection(allNestedNavItems);
    }


    public void save() throws ValidationException{
        //Clean up the customservernames
        customservername = reger.core.Util.stripHttpHttpsAndTrailingSlashFromUrl(customservername);
        customservername2 = reger.core.Util.stripHttpHttpsAndTrailingSlashFromUrl(customservername2);
        customservername3 = reger.core.Util.stripHttpHttpsAndTrailingSlashFromUrl(customservername3);

        //Make sure we have a timezoneid
        if (timezoneid==null|| timezoneid.equals("")){
            timezoneid = reger.Vars.TIMEZONEIDDEFAULT;
        }


        try{
            //Validate the data
            validate();
            //Write the preferences to the database
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE account SET timezoneid='"+timezoneid+"', homepagetitle='"+ reger.core.Util.cleanForSQL(homepagetitle) +"', homepagehtml='"+ reger.core.Util.cleanForSQL(homepagehtml) +"', homepagecalendar='"+ homepagecalendar +"', messagesstatus='"+ messagesstatus +"', messagesapproval='"+ messagesapproval +"', admintools='"+ admintools +"', jspopup='"+ jspopup +"', pingweblogscom='"+ pingweblogscom +"', showhometab='"+ reger.core.Util.booleanAsSQLText(showhometab) +"', hometabtext='"+ reger.core.Util.cleanForSQL(hometabtext) +"', showlogintab='"+ reger.core.Util.booleanAsSQLText(showlogintab) +"', displaycharsinsummary='"+ displaycharsinsummary +"', displaynumberofentries='"+ displaynumberofentries +"', userelatedlinks='"+ userelatedlinks +"', favesiteon='"+ favesiteon +"', onthisday='"+ onthisday +"', customservername='"+ reger.core.Util.cleanForSQL(customservername) +"', customservername2='"+ reger.core.Util.cleanForSQL(customservername2) +"', customservername3='"+ reger.core.Util.cleanForSQL(customservername3) +"', emailnewsletter='"+ emailnewsletter +"', emailsendhour='"+ emailsendhour +"', issearchmysiteon='"+issearchmysiteon+"', istrackbackon='"+reger.core.Util.booleanAsSQLText(istrackbackon)+"', islistedindirectory='"+reger.core.Util.booleanAsSQLText(islistedindirectory)+"', trackbackrequiresapproval='"+reger.core.Util.booleanAsSQLText(trackbackrequiresapproval)+"', istimeperiodon='"+reger.core.Util.booleanAsSQLText(istimeperiodon)+"', accountemail='"+reger.core.Util.cleanForSQL(accountemail)+"', newslettersubject='"+reger.core.Util.cleanForSQL(newslettersubject)+"', googlemapsapikey='"+reger.core.Util.cleanForSQL(googlemapsapikey)+"', entlisttemplateid='"+entlisttemplateid+"', sitetemplateid='"+sitetemplateid+"', hptemplateid='"+hptemplateid+"', aboutthisblogtitle='"+reger.core.Util.cleanForSQL(aboutthisblogtitle)+"', aboutthisbloghtml='"+reger.core.Util.cleanForSQL(aboutthisbloghtml)+"'   WHERE accountid='"+ accountid +"'");
            //-----------------------------------
            //-----------------------------------
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
    }

    private void validate() throws ValidationException {
        ValidationException error = new ValidationException();

        //Make sure customservernames are acceptable
        if (customservername!=null && !customservername.equals("")) {
            if (!validateCustomServerName(customservername, this.accountid)){
                error.addValidationError("The first custom domain name is in use.  Please choose another.");
            }
        }
        if (customservername2!=null && !customservername2.equals("")) {
            if (!validateCustomServerName(customservername2, this.accountid)){
                error.addValidationError("The second custom domain name is in use.  Please choose another.");
            }
        }
        if (customservername3!=null && !customservername3.equals("")) {
            if (!validateCustomServerName(customservername3, this.accountid)){
                error.addValidationError("The third custom domain name is in use.  Please choose another.");
            }
        }

        //Must have a site name
        if (homepagetitle==null || homepagetitle.equals("")){
            error.addValidationError("Your site must have a name.");
        }

        //If there are validation errors, throw them
        if (error.getErrors()!=null && error.getErrors().length>0){
            throw error;
        }

    }




  private void loadAllLogsForAccountid(){
      //-----------------------------------
      //-----------------------------------
      String[][] rsAllLgs=Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+ accountid +"'");
      //-----------------------------------
      //-----------------------------------
      //Create an array of the size of the result set
      alllogsforaccountid = new ArrayList<Integer>();
      for(int i=0; i<rsAllLgs.length; i++){
          alllogsforaccountid.add(new Integer(rsAllLgs[i][0]));
      }
  }

  /**
  * Number of days until this account's free trial ends
  */
  public int daysuntilexpiration(){

    int daysSignupAgo = DateDiff.dateDiff("day", Calendar.getInstance(), createdate);

    int daysleft= Vars.TRIALACCOUNTDAYS - daysSignupAgo;

    if (daysleft<0){
        daysleft=0;
    }

    return daysleft;
  }

  /**
   * Updates total and individual space usage
   */
  public void updateSpaceused(){
    Debug.debug(5, "", "Account.java- updateSpaceUsed() called.");
    updateImagespaceused();
    updateTextspaceused();
    this.spaceused = this.imagespaceused + this.textspaceused;
    this.hasUpdateSpaceBeenCalled = true;
  }

  public long getFreespace(){
      if (!hasUpdateSpaceBeenCalled){
        updateSpaceused();
      }
      return maxspaceinbytes - spaceused;
  }

  /**
   * Returns the number of bytes that the account has in media/images
   */
   private void updateImagespaceused(){
//        //Get used image space
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstImageSpace= Db.RunSQL("SELECT SUM(image.sizeinbytes) FROM event, image WHERE event.accountid='"+accountid+"' AND event.eventid=image.eventid");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstImageSpace!=null && rstImageSpace.length>0 && Util.isnumeric(rstImageSpace[0][0])){
//            this.imagespaceused=Long.parseLong(rstImageSpace[0][0]);
//        } else {
//            this.imagespaceused=0;
//        }
        this.imagespaceused = AccountUtil.getSpaceOfAllFilesInADirectory(getPathToAccountFiles());

  }

  public String getPathToAccountFiles(){
      return reger.systemprops.AllSystemProperties.getProp("PATHUPLOADMEDIA")+"files"+java.io.File.separator+accountid+java.io.File.separator;
  }

  /**
   * Returns the number of bytes that the account has in text
   */
   private void updateTextspaceused(){
        //Get used event space
        //-----------------------------------
        //-----------------------------------
        String[][] rstEventSpace= Db.RunSQL("SELECT SUM(event.sizeinbytes) FROM event WHERE event.accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        long eventspaceused=0;
        if (rstEventSpace!=null && rstEventSpace.length>0 && Util.isnumeric(rstEventSpace[0][0])){
            eventspaceused=Long.parseLong(rstEventSpace[0][0]);
        }
        //Get used messages space
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessageSpace= Db.RunSQL("SELECT SUM(message.sizeinbytes) FROM event, message WHERE event.accountid='"+accountid+"' AND event.eventid=message.eventid");
        //-----------------------------------
        //-----------------------------------
        long messagespaceused=0;
        if (rstMessageSpace!=null && rstMessageSpace.length>0 && Util.isnumeric(rstMessageSpace[0][0])){
            messagespaceused=Long.parseLong(rstMessageSpace[0][0]);
        }

        this.textspaceused=eventspaceused+messagespaceused;
  }

  /**
   * Returns the number of hits that have been made in this month
   */
   public void updateBandwidthused(){
       this.bandwidthused=reger.Bandwidth.getBytesUsedThisMonth(accountid);
   }







    /**
     * Accepts the host name and returns the accountid.  Returns -1 if none is found.
     */
//    public static int getAccountidFromAccountUrlAndPlid(String accounturl, int plid){
//        int accountid=-1;
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstGetAccountid= Db.RunSQL("SELECT accountid FROM account, pl WHERE account.plid=pl.plid AND accounturl='"+accounturl+"' AND pl.plid='"+plid+"'");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstGetAccountid!=null && rstGetAccountid.length>0){
//            accountid=Integer.parseInt(rstGetAccountid[0][0]);
//        }
//        return accountid;
//    }



    /**
     * Accepts the host name and returns the accountid.  Returns -1 if none is found.
     */
//    public static int getAccountidFromAccountUrlAndPlbasedomain(String accounturl, String plbasedomain){
//        int accountid=-1;
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstGetAccountid= Db.RunSQL("SELECT accountid FROM account, pl WHERE account.plid=pl.plid AND accounturl='"+accounturl+"' AND pl.plbasedomain='"+plbasedomain+"'");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstGetAccountid!=null && rstGetAccountid.length>0){
//            accountid=Integer.parseInt(rstGetAccountid[0][0]);
//        }
//        return accountid;
//    }


    /**
     * Gets timezoneid from accountid
     */
    public static String getTimezoneidFromAccountid(int accountid){
        String timezoneid = Vars.TIMEZONEIDDEFAULT;
        //-----------------------------------
        //-----------------------------------
        String[][] rstGetTzid= Db.RunSQL("SELECT timezoneid FROM account WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGetTzid!=null && rstGetTzid.length>0){
            timezoneid=rstGetTzid[0][0];
        }
        return timezoneid;
    }




    /**
     * Gets a site's root URL. Example: bob.reger.com.
     * Note that this is a static function and has no effect on instantiated properties.
     */
    private String setSiteRootUrlViaAccountid(int accountid){
        String siteRootUrl = "";
        //@todo Use pl cache instead of database call... low priority
        reger.core.Debug.debug(5, "Account.java", "setSiteRootUrlViaAccountid("+accountid+") called");
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pl.usedynamicdns, pl.plbasedomain, account.accounturl, account.customservername, account.customservername2, account.customservername3 FROM account, pl WHERE account.plid=pl.plid AND account.accountid='"+accountid+"' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            reger.core.Debug.debug(5, "Account.java", "setSiteRootUrlViaAccountid("+accountid+") found a record");
            String usedynamicdns = rstData[0][0];
            String plbasedomain = rstData[0][1];
            String accounturl = rstData[0][2];
            String customservername = rstData[0][3];
            String customservername2 = rstData[0][4];
            String customservername3 = rstData[0][5];

            if (customservername.equals("") && customservername2.equals("") && customservername3.equals("")){
                if (usedynamicdns.equals("1")){
                    siteRootUrl = accounturl + "." + plbasedomain;
                } else {
                    siteRootUrl = plbasedomain + "/~" + accounturl;
                }
            } else {
                if (!customservername.equals("")){
                    siteRootUrl = customservername;
                } else if (!customservername2.equals("")){
                    siteRootUrl = customservername2;
                } else if (!customservername3.equals("")){
                    siteRootUrl = customservername3;
                }
            }
        }
        reger.core.Debug.debug(5, "Account.java", "setSiteRootUrlViaAccountid("+accountid+") siteRootUrl: "+siteRootUrl);
        return siteRootUrl;
    }

    public static int findLogidByCustomDomain(int accountid, reger.UrlSplitter urlSplitter){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGet= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"' AND (customdomain1='"+urlSplitter.getRawIncomingServername()+"' OR customdomain2='"+urlSplitter.getRawIncomingServername()+"' OR customdomain3='"+urlSplitter.getRawIncomingServername()+"')");
        //-----------------------------------
        //-----------------------------------
        if (rstGet!=null && rstGet.length>0){
        if (Num.isinteger(rstGet[0][0]))
            return Integer.parseInt(rstGet[0][0]);
        }
        return 0;
    }

    /**
     * Checks to make sure that we're still on the same web site.
     * Each page calls this function.
     */
    public static int findAccountid(reger.UrlSplitter urlSplitter){
        if (!urlSplitter.getRawIncomingServername().equals("")){
            reger.core.Debug.debug(3, "Account.java", "Calling findAccountid() database search for account.");
            //-----------------------------------
            //-----------------------------------
            String[][] rstAccount= Db.RunSQL("SELECT DISTINCT account.accountid FROM account, pl, megalog "+
            "WHERE account.plid=pl.plid AND account.accountid=megalog.accountid AND "+
            "("+
            //Case for http://user.plbasedomain/
            "(concat(account.accounturl, \".\", pl.plbasedomain)='"+reger.core.Util.cleanForSQL(urlSplitter.getServername())+"')"+
            " OR "+
            //Case for http://plbasedomain/~user/
            "(account.accounturl='"+reger.core.Util.cleanForSQL(urlSplitter.getVirtualdir())+"' AND pl.plbasedomain='"+reger.core.Util.cleanForSQL(urlSplitter.getServername())+"' )"+
            " OR "+
            //Case for http://customservername/
            "(account.customservername='"+urlSplitter.getRawIncomingServername()+"')"+
            " OR "+
            //Case for http://customservername2/
            "(account.customservername2='"+urlSplitter.getRawIncomingServername()+"')"+
            " OR "+
            //Case for http://customservername3/
            "(account.customservername3='"+urlSplitter.getRawIncomingServername()+"')"+
            " OR "+
            //Case for http://customdomain1/
            "(megalog.customdomain1='"+urlSplitter.getRawIncomingServername()+"')"+
            " OR "+
            //Case for http://customdomain2/
            "(megalog.customdomain2='"+urlSplitter.getRawIncomingServername()+"')"+
            " OR "+
            //Case for http://customdomain3/
            "(megalog.customdomain3='"+urlSplitter.getRawIncomingServername()+"')"+
            " )");
            //-----------------------------------
            //-----------------------------------
            if (rstAccount!=null && rstAccount.length>0){
                //This sets the account as the active account for this UserSession
                //reger.core.Util.logtodb("New Account object created.  Accountid=" + rstAccount[0][0]);
                //If more than one account is returned, we have a problem
                if (rstAccount.length>1){
                    StringBuffer err = new StringBuffer();
                    err.append("Multiple Accounts found for same incoming request url.  This is a bad thing.  Account.findAccountid()<br>");
                    err.append("urlSplitter.getRawIncomingServername()=" + urlSplitter.getRawIncomingServername() + "<br>");
                    err.append("urlSplitter.getServername()=" + urlSplitter.getServername() + "<br>");
                    err.append("urlSplitter.getVirtualdir()=" + urlSplitter.getVirtualdir() + "<br>");
                    err.append("urlSplitter.getSiterooturl()=" + urlSplitter.getSiterooturl() + "<br>");
                    err.append("urlSplitter.getPort()=" + urlSplitter.getPort() + "<br>");
                    err.append("Accountids affected:<br>");
                    for (int i = 0; i < rstAccount.length; i++) {
                        err.append("Accountid=" + rstAccount[i][0] + "<br>");
                    }
                    err.append("This is a problem because it means that for the URL above multiple sites are found, but only one can be returned.  This means that at least one site is obscured, unavailable.  To correct, the accounturl of the accounts above needs to be made such that it does not conflict.  In theory the software has safeguards against this so manual database editing may have happened.  Or a bug in the software.");
                    Debug.logtodb(err.toString(), "");
                }
                //return reger.cache.AccountCache.get(Integer.parseInt(rstAccount[0][0]));
                //return new reger.Account(Integer.parseInt(rstAccount[0][0]));
                reger.core.Debug.debug(3, "Account.java", "Returning accountid="+rstAccount[0][0]);
                return Integer.parseInt(rstAccount[0][0]);
            }
        }
        //No account found
        return 0;
    }

    public String getSiteRootUrl(){
        return reger.Vars.getHttpUrlPrefix() + siteRootUrl;
    }

    public String getSiteRootUrl(UserSession userSession){
        reger.core.Debug.debug(5, "Account.java", "sending inUrl="+userSession.getUrlSplitter().getScheme()+"://"+siteRootUrl);
        return userSession.getUrlWithPortSmartlyAttached(userSession.getUrlSplitter().getScheme()+"://"+siteRootUrl);
    }

    public int getAccountid() {
        return accountid;
    }

    public String getAccounturl() {
        return accounturl;
    }

    public int getPlid() {
        return plid;
    }

    public String getTimezoneid() {
        return timezoneid;
    }

    public int getJspopup() {
        return jspopup;
    }

    public int getHomepagecalendar() {
        return homepagecalendar;
    }

    public int getMessagesstatus() {
        return messagesstatus;
    }

    public int getMessagesapproval() {
        return messagesapproval;
    }

    public String getHomepagetitle() {
        return homepagetitle;
    }

    public String getHomepagehtml() {
        return homepagehtml;
    }

    public int getAdmintools() {
        return admintools;
    }

    public int getPingweblogscom() {
        return pingweblogscom;
    }

    public int getDisplaycharsinsummary() {
        return displaycharsinsummary;
    }

    public int getDisplaynumberofentries() {
        return displaynumberofentries;
    }

    public int getUserelatedlinks() {
        return userelatedlinks;
    }

    public Calendar getCreatedate() {
        return createdate;
    }

    public String getFavesitetitle() {
        return favesitetitle;
    }

    public int getFavesiteon() {
        return favesiteon;
    }

    public int getOnthisday() {
        return onthisday;
    }

    public String getCustomservername() {
        return customservername;
    }

    public int getEmailnewsletter() {
        return emailnewsletter;
    }

    public int getEmailsendhour() {
        return emailsendhour;
    }

    public int getIssearchmysiteon() {
        return issearchmysiteon;
    }

    public boolean getIstrackbackon() {
        return istrackbackon;
    }

    public boolean getIslistedindirectory() {
        return islistedindirectory;
    }

    public boolean getTrackbackrequiresapproval() {
        return trackbackrequiresapproval;
    }

    public boolean getIstimeperiodon() {
        return istimeperiodon;
    }

    public boolean getIsActiveAccount() {
        return isActiveAccount;
    }

    public boolean getIsNewPendingAdminApproval() {
        return isNewPendingAdminApproval;
    }

    //public Template getTemplate() {
        //return template;
    //}

    public long getMaxbandwidth() {
        return maxbandwidth;
    }

    public long getMaxspaceinbytes() {
        return maxspaceinbytes;
    }

    public long getImagespaceused() {
        if (!hasUpdateSpaceBeenCalled){
          updateSpaceused();
        }
        return imagespaceused;
    }

    public long getTextspaceused() {
        if (!hasUpdateSpaceBeenCalled){
          updateSpaceused();
        }
        return textspaceused;
    }

    public long getBandwidthused() {
        return bandwidthused;
    }

    public long getSpaceused() {
        if (!hasUpdateSpaceBeenCalled){
          updateSpaceused();
        }
        return spaceused;
    }



    public boolean getShowhometab() {
        return showhometab;
    }

    public String getHometabtext() {
        return hometabtext;
    }

    public boolean getShowlogintab() {
        return showlogintab;
    }

    public int getHptemplateid() {
        return hptemplateid;
    }

    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }

    public int getSitetemplateid() {
        return sitetemplateid;
    }

    public String getCustomservername2() {
        return customservername2;
    }

    public String getCustomservername3() {
        return customservername3;
    }


    public void setTimezoneid(String timezoneid) {
        this.timezoneid = timezoneid;
    }

    public void setJspopup(int jspopup) {
        this.jspopup = jspopup;
    }

    public void setHomepagecalendar(int homepagecalendar) {
        this.homepagecalendar = homepagecalendar;
    }

    public void setMessagesstatus(int messagesstatus) {
        this.messagesstatus = messagesstatus;
    }

    public void setMessagesapproval(int messagesapproval) {
        this.messagesapproval = messagesapproval;
    }

    public void setHomepagetitle(String homepagetitle) {
        this.homepagetitle = homepagetitle;
    }

    public void setHomepagehtml(String homepagehtml) {
        this.homepagehtml = homepagehtml;
    }



    public void setAdmintools(int admintools) {
        this.admintools = admintools;
    }

    public void setPingweblogscom(int pingweblogscom) {
        this.pingweblogscom = pingweblogscom;
    }

    public void setDisplaycharsinsummary(int displaycharsinsummary) {
        this.displaycharsinsummary = displaycharsinsummary;
    }

    public void setDisplaynumberofentries(int displaynumberofentries) {
        this.displaynumberofentries = displaynumberofentries;
    }

    public void setUserelatedlinks(int userelatedlinks) {
        this.userelatedlinks = userelatedlinks;
    }

    public void setFavesitetitle(String favesitetitle) {
        this.favesitetitle = favesitetitle;
    }

    public void setFavesiteon(int favesiteon) {
        this.favesiteon = favesiteon;
    }

    public void setOnthisday(int onthisday) {
        this.onthisday = onthisday;
    }

    public void setCustomservername(String customservername) {
        this.customservername = customservername;
    }

    public void setCustomservername2(String customservername2) {
        this.customservername2 = customservername2;
    }

    public void setCustomservername3(String customservername3) {
        this.customservername3 = customservername3;
    }

    public void setEmailnewsletter(int emailnewsletter) {
        this.emailnewsletter = emailnewsletter;
    }

    public void setEmailsendhour(int emailsendhour) {
        this.emailsendhour = emailsendhour;
    }

    public void setIssearchmysiteon(int issearchmysiteon) {
        this.issearchmysiteon = issearchmysiteon;
    }

    public void setIstrackbackon(boolean istrackbackon) {
        this.istrackbackon = istrackbackon;
    }

    public void setIslistedindirectory(boolean islistedindirectory) {
        this.islistedindirectory = islistedindirectory;
    }

    public void setTrackbackrequiresapproval(boolean trackbackrequiresapproval) {
        this.trackbackrequiresapproval = trackbackrequiresapproval;
    }

    public void setIstimeperiodon(boolean istimeperiodon) {
        this.istimeperiodon = istimeperiodon;
    }

    public void setShowhometab(boolean showhometab) {
        this.showhometab = showhometab;
    }

    public void setHometabtext(String hometabtext) {
        this.hometabtext = hometabtext;
    }

    public void setShowlogintab(boolean showlogintab) {
        this.showlogintab = showlogintab;
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

    public NestedNavCollection getNestedNavCollection() {
        return nestedNavCollection;
    }

    /**
     * Checks to see if a given logid is valid for a given accountid
     */
     public static boolean isLogidValidForAccountid(int accountid, int logid){
        boolean isValid=false;


        //-----------------------------------
        //-----------------------------------
        String[][] rstPass= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"' AND logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPass!=null && rstPass.length>0){
            isValid=true;
        }

        //reger.core.Util.logtodb("isLogidValidForAccountid - accountid=" + accountid + "  logid=" + logid + " isValid=" + isValid);

        return isValid;
    }

    public static int getDefaultLogid(int accountid){
            //-----------------------------------
            //-----------------------------------
            String[][] rstPass= Db.RunSQL("SELECT logid FROM megalog WHERE accountid='"+accountid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstPass!=null && rstPass.length>0){
                return Integer.parseInt(rstPass[0][0]);
            }
            return 0;
        }



    public static String validateServername(String accounturl, int accountid){
        String errortext = "";

        //If accountid=-1 then this is a new account being created
        String accountidSql = " (account.accountid<>'"+accountid+"') ";
        if (accountid<0){
            //This is just a rhetorical sql statement to make sure we search all accounts
            accountidSql = " (account.accountid>0) ";
        }



        //Check to see if the accounturl or email is taken
        //-----------------------------------
        //-----------------------------------
        String[][] rstUser= Db.RunSQL("SELECT count(*) FROM account WHERE "+accountidSql+" AND accounturl='"+ Util.cleanForSQL(accounturl)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUser!=null && rstUser.length>0){
            if (Integer.parseInt(rstUser[0][0])>0){
                errortext="We're sorry.  '"+ accounturl +"' is already in use.<br>";
            }
        }

        //You can't add an accounturl which is the same as any single domain or subdomain of a plbasedomain... strict no conflicts
        //-----------------------------------
        //-----------------------------------
        String[][] rstPl= Db.RunSQL("SELECT plid, plbasedomain FROM pl");
        //-----------------------------------
        //-----------------------------------
        if (rstPl!=null && rstPl.length>0){
            for(int i=0; i<rstPl.length; i++){
                String[] domainsOfPl = rstPl[i][0].split(".");
                for (int j = 0; j < domainsOfPl.length; j++) {
                    if (accounturl.equals(domainsOfPl[j])){
                        errortext="We're sorry.  '"+ accounturl +"' is already in use.<br>";
                    }
                }
            }
        }


        //Can't choose "www"
        if ((accounturl.equals("www"))) {
            errortext="We're sorry.  '"+ accounturl +"' is already in use.<br>";
        }

        //Can't choose "mail"
        if ((accounturl.equals("mail"))) {
            errortext="We're sorry.  '"+ accounturl +"' is already in use.<br>";
        }


        //check to see if the url is blank
        if (accounturl.equals("")) {
            errortext=errortext + "Your URL can't be blank.<br>";
        } else {

            //check to see that it doesn't have invalid characters in it
            if (accounturl.split("[a-zA-Z0-9\\-]").length>1){
                errortext=errortext+"The URL can only be made up of letters, numbers and dashes.  No spaces or other characters are allowed.<br>";
            }

            //check to see if the url doesn't start with a non-valid char
            if (accounturl.substring(0,1).equals("-")){
                errortext=errortext+"The URL can't begin with a dash (-) but you can use a dash elsewhere in the URL.<br>";
            }

        }

        return errortext;
    }

    public static boolean validateCustomServerName(String customservername, int accountid){
        boolean isGoodDomain = true;
        //Clean up the customdomain
        String customdomain = Util.stripHttpHttpsAndTrailingSlashFromUrl(customservername);

        //-----------------------------------
        //-----------------------------------
        String[][] rstAcctDomChk= Db.RunSQL("SELECT accountid FROM account WHERE (customservername='"+ Util.cleanForSQL(customdomain) +"') AND accountid<>'"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAcctDomChk!=null && rstAcctDomChk.length>0){
            isGoodDomain = false;
        }

        //String[][] rstPlDomChk= Db.RunSQL("SELECT plid FROM pl WHERE ((concat(subdomain, \".\", plbasedomain)='"+ reger.core.Util.cleanForSQL(customdomain) +"') OR (plbasedomain='"+reger.core.Util.cleanForSQL(customdomain)+"'))");


        //-----------------------------------
        //-----------------------------------
        String[][] rstPlDomChk= Db.RunSQL("SELECT plid FROM pl WHERE plbasedomain='"+Util.cleanForSQL(customdomain)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPlDomChk!=null && rstPlDomChk.length>0){
            isGoodDomain = false;
        }
        return isGoodDomain;
    }

    public boolean isPro(){
        return isPro;
    }

    public void calculateIsPro(){
        //@todo As is, this will be run on every page... should I populate an ispro var once on Account object creation?
        Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+". Function has been called.");
        if (accountLicense!=null){
            if (accountLicense.getProperty(License.PROPSTRINGINDIVIDUALUSERSPAYTOUPGRADEACCOUNTS).equals("1")){
                Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" Individual users pay to upgrade.");
                if (accountLicense.getProperty(License.PROPSTRINGISRECURRINGBILLING).equals("1")){
                    Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" PROPSTRINGISRECURRINGBILLING is blank.");
                    if (reger.IsBillingOk.isbillingok(isbillingokencrypted, accountid)){
                        Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning true.  Individual users do pay to upgrade, isrecurringbilling=true and isBillingok came back true.");
                        isPro=true;
                        return;
                    }
                    Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" reger.IsBillingOk.isbillingok(isbillingokencrypted, accountid) came back false.");
                } else {
                    Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" PROPSTRINGISRECURRINGBILLING is not 1.");
                    if (!accountLicense.getProperty(License.PROPSTRINGEXPDATEGMT).equals("")){
                        try{
                            Calendar expDate = reger.core.TimeUtils.dbstringtocalendar(accountLicense.getProperty(License.PROPSTRINGEXPDATEGMT));
                            if (expDate.after(reger.core.TimeUtils.nowInGmtCalendar())){
                                if (reger.IsBillingOk.isbillingok(isbillingokencrypted, accountid)){
                                    Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning true.  Expiration date is after today.  Individual users do pay to upgrade and isBillingok came back true.");
                                    isPro=true;
                                    return;
                                }
                            }
                        } catch (Exception e){
                            Debug.debug(4, "Account.isPro()", e);
                            Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning false.  There was an exception: " + e.getMessage());
                            isPro=false;
                            return;
                        }
                    }
                }
            } else {
                Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning true.  Individual users to not pay to upgrade.");
                isPro=true;
                return;
            }
        } else {
            Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning false because the license is null.");
            isPro=false;
            return;
        }
        Debug.debug(4, "Account.isPro()", "Account.isPro() - accountid = "+accountid+" returning false because no true result was found... false is the default.");
        isPro=false;
        return;
    }

    public License getLicense() {
        return accountLicense;
    }

    public void cancelLicense(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET encryptedlicense='' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public void generateSimpleLicenseWithExpirationDate(Calendar expDateGMT){
        HashMap props = new HashMap();
        props.put(License.PROPSTRINGEXPDATEGMT, String.valueOf(reger.core.TimeUtils.dateformatfordb(expDateGMT)));
        License lic = new License(null, props);

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET encryptedlicense='"+reger.core.Util.cleanForSQL(lic.getEncryptedLicense())+"' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public void setEncryptedLicense(String encryptedLicense){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET encryptedlicense='"+reger.core.Util.cleanForSQL(encryptedLicense)+"' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------

        refresh();
    }

    public void doBilling(){
        Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid);
        //Only call if accounts are required to upgrade
        if (accountLicense!=null){
            if (((String)accountLicense.getProperty(License.PROPSTRINGINDIVIDUALUSERSPAYTOUPGRADEACCOUNTS)).equals("1")){
                //There must be a licenseid to call the licensing server
                if (reger.core.Util.isinteger(accountLicense.getPropertyWithoutInheritingFromParent(License.PROPSTRINGLICENSEID)) && Integer.parseInt(accountLicense.getPropertyWithoutInheritingFromParent(License.PROPSTRINGLICENSEID))>0){
                    //Call Licensing Server
                    Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid + "<br>licenseid="+accountLicense.getPropertyWithoutInheritingFromParent(License.PROPSTRINGLICENSEID)+"<br>Calling licensing server.");
                    Hashtable result = RegerLicensingApiClient.isLicenseBillingOk(accountLicense.getEncryptedLicense());
                    //Save the result
                    if (result.get("successful")!=null && result.get("successful").equals("true")){
                        Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid + "<br>Successful call.");
                        //Save to DB
                        setBillingIsOkInDb();
                    } else {
                        String billingerror = "";
                        if (result.get("errormessage")!=null){
                            billingerror = (String)result.get("errormessage");
                        }
                        Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid + "<br>Failed call.<br>billingerror=" + billingerror);
                        //Save to Db
                        setBillingIsNotOkInDb(billingerror);
                    }
                } else {
                    Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid + "<br>No licenseid so no call to billing server.");
                    setBillingIsOkInDb();
                }
            } else {
                Debug.debug(5, "", "Account.doBilling() called on accountid=" + accountid + "<br>PROPSTRINGINDIVIDUALUSERSPAYTOUPGRADEACCOUNTS is: " + accountLicense.getProperty(License.PROPSTRINGINDIVIDUALUSERSPAYTOUPGRADEACCOUNTS));
                setBillingIsOkInDb();
            }
        } else {
            Debug.logtodb("NULL accountLicense found on accountid=" + accountid, "");
        }

        //Update the last checked date
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET lastbillingcheck='"+reger.core.Util.cleanForSQL(TimeUtils.dateformatfordb(TimeUtils.nowInGmtCalendar()))+"' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------

        //Refresh the account object
        refresh();

    }

    private void setBillingIsOkInDb(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET isbillingokencrypted='"+reger.core.Util.cleanForSQL(reger.IsBillingOk.getIsbillingokString(true, accountid))+"', billingerror='' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        this.billingerror = "";
    }

    private void setBillingIsNotOkInDb(String billingerror){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET isbillingokencrypted='"+reger.core.Util.cleanForSQL(reger.IsBillingOk.getIsbillingokString(false, accountid))+"', billingerror='"+reger.core.Util.cleanForSQL(billingerror)+"' WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        this.billingerror = billingerror;
    }

    public Calendar getLastbillingcheck() {
        return lastbillingcheck;
    }

    public String getBillingerror() {
        return billingerror;
    }

    public String getGooglemapsapikey() {
        return googlemapsapikey;
    }

    public void setGooglemapsapikey(String googlemapsapikey) {
        this.googlemapsapikey = googlemapsapikey;
    }

    public void setHptemplateid(int hptemplateid) {
        this.hptemplateid = hptemplateid;
    }

    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }

    public void setSitetemplateid(int sitetemplateid) {
        this.sitetemplateid = sitetemplateid;
    }

    public ArrayList<Integer> getAlllogsforaccountid() {
        return alllogsforaccountid;
    }

    public ArrayList<FileAcl> getFileacls() {
        return fileacls;
    }

    public void setFileacls(ArrayList<FileAcl> fileacls) {
        this.fileacls = fileacls;
    }

    public Calendar getDatemarkedinactive() {
        return datemarkedinactive;
    }

    public void setDatemarkedinactive(Calendar datemarkedinactive) {
        this.datemarkedinactive=datemarkedinactive;
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
}