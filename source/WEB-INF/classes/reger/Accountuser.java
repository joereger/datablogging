package reger;

import reger.acl.AccountUserAcl;
import reger.acl.AccountUserAclGroup;
import reger.acl.AclObject;
import reger.core.db.Db;
import reger.core.Util;
import reger.core.PasswordHash;
import reger.core.PasswordVerifier;
import reger.core.Debug;
import reger.cache.LogCache;

import java.util.*;

/**
 * Represents an account user.  This could be an owner or an author, for example.
 */
public class Accountuser {



    //Permission vars
    //These hold the aclnames and logids that user can view.
    //Note that outside code should use userCanViewLog()
    //and userCanDoAcl() as much as possible.
    private Vector accountUserAcls=null; //The ACL Perms that this user explicitly has
    private Vector accountUserAclGroups=null;
    private int[] logsUserHasExlicitPermissionToAccess=null;
    private int[] logsUserHasExlicitPermissionToAuthor=null;

    private Hashtable accountsUserHasAccessTo = null;

    //Logged-in flag
    public boolean isLoggedIn=false;

    //User properties
    public int accountid = -1;
    private String username = "";
    private String password = "";
    private String verifypassword = "";
    private String friendlyname = "";
    private String onelinesummary = "";
    private String passphrasequestion = "";
    private String passphraseanswer = "";
    private String email = "";
    private java.util.Calendar lastlogindate = Calendar.getInstance();
    private int entrymode = reger.Vars.ENTRYMODESIMPLE;
    private String usertimezoneid = reger.Vars.TIMEZONEIDDEFAULT;
    public int accountuserid=-1;
    public boolean isactive = true;
    private java.util.Calendar createdate = Calendar.getInstance();
    private boolean isHelpOn = true;
    //private String siteRootUrl = "";



    //Accountuserfields
    private Vector accountuserfields = new Vector(10);

    //Quick pass
    private Vector quickpass = null;

    /**
     * Constructor
     */
    public Accountuser(int accountid){
        this.accountid = accountid;
        populate();
    }

    /**
     * Constructor
     */
    public Accountuser(String xUpSubNo){

        //-----------------------------------
        //-----------------------------------
        String[][] rstAcctUsr= Db.RunSQL("SELECT accountuserid FROM mobile WHERE xupsubno='"+reger.core.Util.cleanForSQL(xUpSubNo)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAcctUsr!=null && rstAcctUsr.length>0){
            forceLogin(Integer.parseInt(rstAcctUsr[0][0]));
        }

    }

    /**
     * Constructor
     */
    public Accountuser(String username, String password){
        Debug.debug(5, "", "Accountuser(username, password) constructor<br>username=" + username + "<br>password=" + password);
        //-----------------------------------
        //-----------------------------------
        String[][] rstUser= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE username='"+reger.core.Util.cleanForSQL(username)+"' AND password='"+reger.core.Util.cleanForSQL(PasswordHash.getHash(password))+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUser!=null && rstUser.length>0){
            this.accountuserid = Integer.parseInt(rstUser[0][0]);
            populate();
            userAuthenticate(username, password);
        }
    }

    /**
     * Constructor
     */
    public Accountuser(int accountuserid, boolean dummy){
        this.accountuserid = accountuserid;
        //-----------------------------------
        //-----------------------------------
        String[][] rstAccountid= Db.RunSQL("SELECT accountid FROM accountuser WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAccountid!=null && rstAccountid.length>0){
            this.accountid = Integer.parseInt(rstAccountid[0][0]);
        }
        //Populate the object
        populate();
    }

    /**
     * Constructor.
     */
    public Accountuser(int accountid, int accountuserid){
        this.accountid = accountid;
        this.accountuserid = accountuserid;
        //Populate data
        populate();
    }

    /**
     * Constructor
     */
    public Accountuser(int accountid, int accountuserid, String username, String password){
        this.accountuserid = accountuserid;
        populate();
        userAuthenticate(username, password);
    }

    public void populate(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstAccountuser= Db.RunSQL("SELECT username, password, friendlyname, passphrasequestion, passphraseanswer, email, lastlogindate, entrymode, usertimezoneid, accountuser.isactive, accountuser.accountid, accountuser.createdate, onelinesummary, ishelpon FROM accountuser WHERE accountuser.accountuserid='"+accountuserid+"' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstAccountuser!=null && rstAccountuser.length>0){
            this.accountid = Integer.parseInt(rstAccountuser[0][10]);
            this.username = rstAccountuser[0][0];
            this.friendlyname = rstAccountuser[0][2];
            this.passphrasequestion = rstAccountuser[0][3];
            this.passphraseanswer = rstAccountuser[0][4];
            this.email = rstAccountuser[0][5];
            this.lastlogindate = reger.core.TimeUtils.dbstringtocalendar(rstAccountuser[0][6]);
            this.entrymode = Integer.parseInt(rstAccountuser[0][7]);
            this.usertimezoneid = rstAccountuser[0][8];
            if (rstAccountuser[0][9].equals("1")){
                this.isactive = true;
            } else {
                this.isactive = false;
            }
            this.createdate = reger.core.TimeUtils.dbstringtocalendar(rstAccountuser[0][11]);
            this.onelinesummary = rstAccountuser[0][12];
            if (rstAccountuser[0][13].equals("1")){
                this.isHelpOn = true;
            } else {
                this.isHelpOn = false;
            }
        } else {
            this.accountuserid = -1;
        }

        //reger.Account acct = reger.cache.AccountCache.get(this.accountid);
        //siteRootUrl = acct.getSiteRootUrl();

        //Populate permissions from the database
        populatePermissionsFromDb();

        //Populate the accountsUserHasAccessTo
        populateAccountsUserHasAccessTo();

        //Get the fields and store them in the Vector accountuserfields
        if (this.accountuserid>0){
            accountuserfields = new Vector(10);
            //-----------------------------------
            //-----------------------------------
            String[][] rstAcUf= Db.RunSQL("SELECT accountuserfieldid, fieldtitle, fielddata, accountuserfield.order FROM accountuserfield WHERE accountuserid='"+this.accountuserid+"' ORDER BY accountuserfield.order ASC");
            //-----------------------------------
            //-----------------------------------
            if (rstAcUf!=null && rstAcUf.length>0){
                for(int i=0; i<rstAcUf.length; i++){
                    accountuserfields.add(new Accountuserfield(Integer.parseInt(rstAcUf[i][0]), rstAcUf[i][1], rstAcUf[i][2], Integer.parseInt(rstAcUf[i][3])));
                }
            }
        }

        //reger.core.Util.logtodb("Accountuser.populate() complete.  accountuserid=" + accountuserid);
    }

    /**
    * Log the user out
    */
    public void userLogout() {
        //Clear logged-in status
        isLoggedIn=false;
        //Clear user-specific vars
        username=null;
        password=null;
        onelinesummary=null;
        friendlyname=null;
        passphrasequestion=null;
        passphraseanswer=null;
        email=null;
        lastlogindate=null;
        entrymode=0;
        usertimezoneid=null;
        accountuserid=-1;
        quickpass = null;
        //Clear the permission objects
        populatePermissionsFromDb();
    }

    /**
     * Checks to see if this user is entering a valid username/password combo
     * @param username
     * @param password
     */
    public boolean userAuthenticate(String username, String password){

        Debug.debug(5, "", "Accountuser.userAuthenticate() called.<br>username=" + username + "<br>password=" + password);


        //-----------------------------------
        //-----------------------------------
        String[][] rs= reger.core.db.Db.RunSQL("SELECT accountuserid, password, accountid FROM accountuser WHERE username='"+ reger.core.Util.cleanForSQL(username) +"' AND isactive='1' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if(rs!=null && rs.length>=1){

            Debug.debug(5, "", "Attempted Login<br>username=" + username + "<br>password=" + password + "<br>rs[0][1]=" + rs[0][1] + "<br>PasswordHash.getHash()=" + PasswordHash.getHash(password));

            //If the hash of the incoming password equals the hash that we have in the database, it's a valid login.
            if (PasswordHash.getHash(password).equals(rs[0][1])){

                this.accountid = Integer.parseInt(rs[0][2]);
                //Set the accountuserid
                this.accountuserid = Integer.parseInt(rs[0][0]);
                //It's a valid user so flip the authenticated boolean
                this.isLoggedIn = true;
                //Populate the data
                populate();
                //Save the last login date to the database
                saveLastLoginDate();
                //Return
                return true;

            }
        }
        return false;
    }

    public void forceLogin(int accountuserid){
        //-----------------------------------
        //-----------------------------------
        String[][] rs= reger.core.db.Db.RunSQL("SELECT accountuserid, password, accountid FROM accountuser WHERE accountuserid='"+ accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if(rs!=null && rs.length>=1){
            this.accountid = Integer.parseInt(rs[0][2]);
            //Set the accountuserid
            this.accountuserid = Integer.parseInt(rs[0][0]);
            //It's a valid user so flip the authenticated boolean
            this.isLoggedIn = true;
            //Populate the data
            populate();
            //Save the last login date to the database
            saveLastLoginDate();
        }
    }

    /**
     * Checks to see if this user is entering a valid username/password combo
     * @param username
     * @param password
     */
    public boolean userAuthenticateEmailsecret(String username, String password){
        //-----------------------------------
        //-----------------------------------
        String[][] rs= reger.core.db.Db.RunSQL("SELECT accountuser.accountuserid, emailsecret, password, accountuser.accountid FROM accountuser, emailapi WHERE accountuser.accountuserid=emailapi.accountuserid AND username='"+ reger.core.Util.cleanForSQL(username) +"' AND isactive='1' LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if(rs!=null && rs.length>=1){
            if (rs[0][1].equalsIgnoreCase(password)){
                this.accountid = Integer.parseInt(rs[0][3]);
                //Set the accountuserid
                this.accountuserid = Integer.parseInt(rs[0][0]);
                //It's a valid user so flip the authenticated boolean
                this.isLoggedIn = true;
                //Populate the data
                populate();
                //Save the last login date to the database
                saveLastLoginDate();
                //reger.core.Util.logtodb("Accountuser.userAuthenticateEmailsecret().  ");
                //Return
                return true;
            }
        }
        return false;
    }

    /**
    * Function that does a quick log login.  This isn't a full login but it gives users access to logs with this password.
    */
    public boolean quickLogLogin(String pass, int accountidToLogInTo){
        //Check password
        //-----------------------------------
        //-----------------------------------
        String[][] rstPass= Db.RunSQL("SELECT logid FROM megalog WHERE password='"+reger.core.Util.cleanForSQL(pass)+"' AND password<>''");
        //-----------------------------------
        //-----------------------------------
        if (rstPass!=null && rstPass.length>0){
            if (!quickPassAccountidComboExists(pass, accountidToLogInTo)){
                //Create a new quickpass object
                reger.AccountUserQuickpass qp = new reger.AccountUserQuickpass();
                qp.quickpass = pass;
                qp.accountid = accountidToLogInTo;
                //Add to quickpass
                if (quickpass==null){
                    quickpass=new Vector();
                }
                quickpass.add(qp);
                //Update the permissions
                populatePermissionsFromDb();
            }
            //Return
            return true;
        }

        return false;
    }

    private boolean quickPassAccountidComboExists(String pass, int accountidToLogInTo){
        if (quickpass!=null){
            for (int i = 0; i < quickpass.size(); i++) {
                AccountUserQuickpass qp = (AccountUserQuickpass) quickpass.elementAt(i);
                if (qp.quickpass.equals(pass) && qp.accountid==accountidToLogInTo){
                    return true;
                }
            }
        }
        return false;
    }


    /**
    * Go to the database and populate the permissions for this user
    */
    private void populatePermissionsFromDb() {
        //Clear the permissions for this user so that we have a blank slate
        accountUserAcls=null;
        accountUserAclGroups=null;

        //Load group membership
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroups= Db.RunSQL("SELECT aclgroup.aclgroupid, aclgroup.aclgroupname, accountuseraclgroup.accountid FROM accountuseraclgroup, aclgroup WHERE accountuseraclgroup.aclgroupid=aclgroup.aclgroupid AND accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroups!=null && rstGroups.length>0){
            for(int i=0; i<rstGroups.length; i++){
                if (accountUserAclGroups==null){
                    accountUserAclGroups = new Vector();
                }
                //Create a new aclgroup object
                AccountUserAclGroup accountUserAclGroup = new reger.acl.AccountUserAclGroup();
                accountUserAclGroup.aclgroupid = Integer.parseInt(rstGroups[i][0]);
                accountUserAclGroup.accountid = Integer.parseInt(rstGroups[i][2]);
                accountUserAclGroup.aclgroupname = rstGroups[i][1];
                //Add this acl to the vector of acls that this user can do
                accountUserAclGroups.add(accountUserAclGroup);

                //Grant those permissions that this group gets.  First, get the group.
                reger.acl.AclGroup aclGroup = reger.acl.AllAclGroups.getAclGroupById(Integer.parseInt(rstGroups[i][0]));
                //Then get the array of aclobjects that this group can access
                reger.acl.AclObject[] aclObjects = aclGroup.getAclObjectsThisGroupCanDo();
                //Iterate through them, adding those that the user doesn't already have access to
                for (int j = 0; j < aclObjects.length; j++) {
                    //Add to acl array
                    if (accountUserAcls==null){
                        accountUserAcls = new Vector();
                    }
                    if (aclObjects[j]!=null){
                        if (!userCanDoAcl(aclObjects[j].aclobjectid, Integer.parseInt(rstGroups[i][2]))){
                            //Create a new acl object
                            AccountUserAcl acl = new reger.acl.AccountUserAcl();
                            acl.aclobjectid = aclObjects[j].aclobjectid;
                            acl.accountid = Integer.parseInt(rstGroups[i][2]);
                            acl.aclobjectname = aclObjects[j].aclobjectname;
                            //Add this acl to the vector of acls that this user can do
                            accountUserAcls.add(acl);
                        }
                    }
                }
            }
        }




        //Populate the aclperms hashmap with the explicit permissions for this user
        //-----------------------------------
        //-----------------------------------
        String[][] rsAcl=reger.core.db.Db.RunSQL("SELECT accountuseracl.aclobjectid, accountuseracl.accountid  FROM accountuseracl WHERE accountuseracl.accountuserid>0 AND accountuseracl.accountuserid='"+ accountuserid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rsAcl!=null && rsAcl.length>0){
            for(int i=0; i<rsAcl.length; i++){
                //Create this AclObject
                reger.acl.AclObject aclObject = reger.acl.AllAclObjects.getAclObjectById(Integer.parseInt(rsAcl[i][0]));
                //Add to acl array
                if (accountUserAcls==null){
                    accountUserAcls = new Vector();
                }
                if (!userCanDoAcl(aclObject.aclobjectid, Integer.parseInt(rsAcl[i][1]))){
                    //Create a new acl object
                    AccountUserAcl acl = new reger.acl.AccountUserAcl();
                    acl.aclobjectid = aclObject.aclobjectid;
                    acl.accountid = Integer.parseInt(rsAcl[i][1]);
                    acl.aclobjectname = aclObject.aclobjectname;
                    //Add this acl to the vector of acls that this user can do
                    accountUserAcls.add(acl);
                }
            }
        }

        //Look for explicit log access permissions
        //Clear the logaccess vector so that we have a blank slate
        logsUserHasExlicitPermissionToAccess=null;
        logsUserHasExlicitPermissionToAuthor=null;

        //Explicitly defined user permissions
        //-----------------------------------
        //-----------------------------------
        String[][] rstAdminLogAccess= Db.RunSQL("SELECT megalog.logid, megalog.accountid, accountuserlogaccess.canread, accountuserlogaccess.canwrite FROM accountuserlogaccess, megalog WHERE accountuserlogaccess.logid=megalog.logid AND accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAdminLogAccess!=null && rstAdminLogAccess.length>0){
            for(int i=0; i<rstAdminLogAccess.length; i++){
                //Read permission
                if (rstAdminLogAccess[i][2].equals("1")){
                    //If I currently don't have an entry for this log
                    if (!isAlreadyInlogsUserHasExplicitPermissionToAccess(Integer.parseInt(rstAdminLogAccess[i][0]))){
                        //Add to the accountUserLogAccess array
                        logsUserHasExlicitPermissionToAccess=reger.core.Util.addToIntArray(logsUserHasExlicitPermissionToAccess, Integer.parseInt(rstAdminLogAccess[i][0]));
                    }
                }
                //Write permission
                if (rstAdminLogAccess[i][3].equals("1")){
                    //If I currently don't have an entry for this log
                    if (!isAlreadyInlogsUserHasExplicitPermissionToAuthor(Integer.parseInt(rstAdminLogAccess[i][0]))){
                        //Add to the accountUserLogAccess array
                        logsUserHasExlicitPermissionToAuthor=reger.core.Util.addToIntArray(logsUserHasExlicitPermissionToAuthor, Integer.parseInt(rstAdminLogAccess[i][0]));
                    }
                }
            }
        }

        //New quickpass query
        if (quickpass!=null){
            //Build the SQL
            String quickpassSql = "";

            for (int i = 0; i < quickpass.size(); i++) {
                AccountUserQuickpass qpass = (AccountUserQuickpass) quickpass.elementAt(i);
                if (i==0){
                    quickpassSql = " ( ";
                }

                if (i>=1) {
                    quickpassSql = quickpassSql + " OR ";
                }

                quickpassSql = quickpassSql + " (megalog.password='"+reger.core.Util.cleanForSQL(qpass.quickpass)+"' AND megalog.accountid='"+qpass.accountid+"') ";

                if (i==(quickpass.size()-1)){
                    quickpassSql = quickpassSql + " ) ";
                }
            }
            //Execute the SQL
            Debug.debug(5, "", "Accountuser.java - quickpassSql = " + quickpassSql);
            //-----------------------------------
            //-----------------------------------
            String[][] rsLgs=reger.core.db.Db.RunSQL("SELECT megalog.logid, megalog.accountid FROM megalog WHERE "+quickpassSql);
            //-----------------------------------
            //-----------------------------------
            if (rsLgs!=null && rsLgs.length>0){
                for(int i=0; i<rsLgs.length; i++){
                    //If I currently don't have an entry for this log
                    if (!isAlreadyInlogsUserHasExplicitPermissionToAccess(Integer.parseInt(rsLgs[i][0]))){
                        //Add to the accountUserLogAccess array
                        logsUserHasExlicitPermissionToAccess=reger.core.Util.addToIntArray(logsUserHasExlicitPermissionToAccess, Integer.parseInt(rsLgs[i][0]));
                    }
                }
            }
        }



    }

    /**
     * Find those accounts where this accountuserid has some sort of specially granted permission.
     * This is mainly used on the logged-in bar where we need a list of sites.
     */
    private void populateAccountsUserHasAccessTo(){
        accountsUserHasAccessTo = null;

        String sql = "SELECT account.accountid, homepagetitle, accounturl FROM accountuser, account WHERE accountuser.accountid=account.accountid AND accountuserid='"+accountuserid+"'" +
                     " UNION DISTINCT " +
                     "SELECT account.accountid, homepagetitle, accounturl FROM accountuseracl, account WHERE accountuseracl.accountid=account.accountid AND accountuserid='"+accountuserid+"'" +
                     " UNION DISTINCT " +
                     "SELECT account.accountid, homepagetitle, accounturl FROM accountuseraclgroup, account WHERE accountuseraclgroup.accountid=account.accountid AND accountuserid='"+accountuserid+"'"+
                     " UNION DISTINCT " +
                     "SELECT account.accountid, homepagetitle, accounturl FROM accountuserlogaccess, account, megalog WHERE accountuserlogaccess.logid=megalog.logid AND megalog.accountid=account.accountid AND accountuserlogaccess.accountuserid='"+accountuserid+"'";
        //-----------------------------------
        //-----------------------------------
        String[][] rstAccounts= Db.RunSQL(sql);
        //-----------------------------------
        //-----------------------------------
        if (rstAccounts!=null && rstAccounts.length>0){
            for(int i=0; i<rstAccounts.length; i++){
                if (accountsUserHasAccessTo==null){
                    accountsUserHasAccessTo = new Hashtable();
                }
                String sitetitle = rstAccounts[i][1];
                if (sitetitle.equals("")){
                    sitetitle = rstAccounts[i][2];
                }
                accountsUserHasAccessTo.put(new Integer(Integer.parseInt(rstAccounts[i][0])), sitetitle);
            }
        }
    }

    private boolean isAlreadyInlogsUserHasExplicitPermissionToAccess(int logid){
        if (logsUserHasExlicitPermissionToAccess!=null){
            for (int i = 0; i < logsUserHasExlicitPermissionToAccess.length; i++) {
                if (logsUserHasExlicitPermissionToAccess[i]==logid){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAlreadyInlogsUserHasExplicitPermissionToAuthor(int logid){
        if (logsUserHasExlicitPermissionToAuthor!=null){
            for (int i = 0; i < logsUserHasExlicitPermissionToAuthor.length; i++) {
                if (logsUserHasExlicitPermissionToAuthor[i]==logid){
                    return true;
                }
            }
        }
        return false;
    }




    public boolean isInAclgroup(int aclgroupid, int accountid){
        if (accountUserAclGroups!=null){
            for (int i = 0; i < accountUserAclGroups.size(); i++) {
                AccountUserAclGroup accountUserAclGroup = (AccountUserAclGroup) accountUserAclGroups.elementAt(i);
                if (accountUserAclGroup.aclgroupid==aclgroupid && accountUserAclGroup.accountid==accountid){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInAclgroup(String aclgroupname, int accountid){
        if (accountUserAclGroups!=null){
            for (int i = 0; i < accountUserAclGroups.size(); i++) {
                AccountUserAclGroup accountUserAclGroup = (AccountUserAclGroup) accountUserAclGroups.elementAt(i);
                if (accountUserAclGroup.aclgroupname.equals(aclgroupname) && accountUserAclGroup.accountid==accountid){
                    return true;
                }
            }
        }
        return false;
    }

    private void addToListOfLogsUserHasExplicitPermissionToAccess(int logid){
        //If I currently don't have an entry for this log
        if (!isAlreadyInlogsUserHasExplicitPermissionToAccess(logid)){
            //Add to the accountUserLogAccess array
            if (logsUserHasExlicitPermissionToAccess==null){
                logsUserHasExlicitPermissionToAccess=new int[0];
            }
            logsUserHasExlicitPermissionToAccess=reger.core.Util.addToIntArray(logsUserHasExlicitPermissionToAccess, logid);
        }
    }

    /**
    * Method to determine whether a user can access a particular log.
    * It relies on the this object's logaccess property.
    */
    public boolean userCanViewLog(int logid) {
        //Look for the logid in the logaccess array
        if (logsUserHasExlicitPermissionToAccess!=null){
            for (int i = 0; i < logsUserHasExlicitPermissionToAccess.length; i++) {
                if(logsUserHasExlicitPermissionToAccess[i]==logid){
                    return true;
                }
            }
        }

        //It's not explicitly defined.  If this is the SiteOwner of the logid in question then they have access to it.
        //Get the log
        Log log = LogCache.get(logid);
        if (log!=null){
            //If this accountuser is the SiteOwner of this log's account then they get access
            if (isInAclgroup("SiteOwner", log.getAccountid())){
                addToListOfLogsUserHasExplicitPermissionToAccess(logid);
                return true;
            }
            //If this is a public log, they can see it
            if (log.getLogaccess()==reger.Vars.LOGACCESSPUBLIC){
                addToListOfLogsUserHasExplicitPermissionToAccess(logid);
                return true;
            }
        }

        //Otherwise the user can't access
        return false;
    }

    /**
    * Method to determine whether a user can access a particular log.
    * It relies on the this object's logaccess property.
    */
    public boolean userCanAuthorLog(int logid) {
        //Look for the logid in the logaccess array
        if (logsUserHasExlicitPermissionToAuthor!=null){
            for (int i = 0; i < logsUserHasExlicitPermissionToAuthor.length; i++) {
                if(logsUserHasExlicitPermissionToAuthor[i]==logid){
                    return true;
                }
            }
        }

        //It's not explicitly defined.  If this is the SiteOwner of the logid in question then they have access to it.
        //Get the log
        Log log = LogCache.get(logid);
        if (log!=null){
            //If this accountuser is the SiteOwner of this log's account then they get access
            if (isInAclgroup("SiteOwner", log.getAccountid())){
                addToListOfLogsUserHasExplicitPermissionToAccess(logid);
                return true;
            }
        }

        //Otherwise the user can't access
        return false;
    }




    /**
    * Method to determine whether a user can do a particular ACL on a particular accountid
    */
    public boolean userCanDoAcl(String aclobjectname, int accountid) {
        if (accountUserAcls!=null){
            for (int i = 0; i < accountUserAcls.size(); i++) {
                AccountUserAcl accountUserAcl = (AccountUserAcl) accountUserAcls.elementAt(i);
                if (accountUserAcl.aclobjectname.equals(aclobjectname) && accountUserAcl.accountid==accountid){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to determine whether a user can do a particular ACL on a particular accountid
     */
    public boolean userCanDoAcl(int aclobjectid, int accountid){
        if (accountUserAcls!=null){
            for (int i = 0; i < accountUserAcls.size(); i++) {
                AccountUserAcl accountUserAcl = (AccountUserAcl) accountUserAcls.elementAt(i);
                if (accountUserAcl.aclobjectid==aclobjectid && accountUserAcl.accountid==accountid){
                    return true;
                }
            }
        }
        return false;
    }



    /**
    * Get SQL query piece list of what user can view
    * Example: OR megalog.logid='3' OR megalog.logid='6'
    */
    public String LogsUserCanViewQueryend(int accountid){
        //If this accountuser is the siteowner of this account then the query is simpler
        if (isInAclgroup("SiteOwner", accountid)){
            return " (megalog.accountid='"+accountid+"') ";
        }
        //Start the SQL out by making sure we only grab logs in this accountid
        String queryend="(megalog.accountid='"+accountid+"' AND (megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' ";
        //And finally, add ORs to make sure any logs this user has been granted explicit permission to view are included
        if (logsUserHasExlicitPermissionToAccess!=null){
             if (logsUserHasExlicitPermissionToAccess.length>0){
                for(int i=0; i<logsUserHasExlicitPermissionToAccess.length; i++){
                    queryend=queryend + " OR megalog.logid='"+ logsUserHasExlicitPermissionToAccess[i] +"'";
                    if (i==(logsUserHasExlicitPermissionToAccess.length-1)){
                        queryend = queryend + "))";
                    }
                }
            } else {
                //There was nothing in the logaccess array so I need to close the string
                queryend = queryend + "))";
            }
        } else {
            //There was nothing in the logaccess array so I need to close the string
            queryend = queryend + "))";
        }
        //If, for some crazy reason it's still blank, then return this docile SQL
        if (queryend.equals("")){
            return " (megalog.logid<'-1') ";
        }
        return queryend;
    }

    /**
     * Logs this user can administer/author
     */
    public String LogsUserCanAdministerQueryend(int accountid){
        //If this accountuser is the siteowner of this account then the query is simpler
        if (isInAclgroup("SiteOwner", accountid)){
            return " (megalog.accountid='"+accountid+"') ";
        }
        //Start the SQL out by making sure we only grab logs in this accountid
        String queryend="(megalog.accountid='"+accountid+"' AND ( ";
        //Add ORs to make sure any logs this user has been granted explicit permission to are included
        if (logsUserHasExlicitPermissionToAuthor!=null){
             if (logsUserHasExlicitPermissionToAuthor.length>0){
                for(int i=0; i<logsUserHasExlicitPermissionToAuthor.length; i++){
                    queryend=queryend + " megalog.logid='"+ logsUserHasExlicitPermissionToAuthor[i] +"'";
                    if (i<=(logsUserHasExlicitPermissionToAuthor.length-2) && logsUserHasExlicitPermissionToAuthor.length>1){
                        queryend = queryend + " OR ";
                    }
                    if (i==(logsUserHasExlicitPermissionToAuthor.length-1)){
                        queryend = queryend + "))";
                    }
                }
            } else {
                //There was nothing in the logaccess array so I need to close the string
                queryend = queryend + "))";
            }
        } else {
            //There was nothing in the logaccess array so I need to close the string
            queryend = queryend + " megalog.logid<'-1' ))";
        }
        //If, for some crazy reason it's still blank, then return this docile SQL
        if (queryend.equals("")){
            return " (megalog.logid<'-1') ";
        }
        return queryend;
    }

    /**
    * Get SQL query piece list of what user can view
    * Example: logid='3' OR logid='6'
    */
    public String LogsUserCanViewQueryendNoMegalog(int accountid){
        return LogsUserCanViewQueryendNoMegalog(accountid, true);
    }

    public String LogsUserCanViewQueryendNoMegalog(int accountid, boolean includelogshiddenfromhomepage){
        StringBuffer queryend=new StringBuffer();
        int numberoflogsusercanview = 0;
        Account acct = reger.cache.AccountCache.get(accountid);
        if (acct!=null){
            int[] alllogidsforaccount = acct.getAllLogids();
            for (int i = 0; i < alllogidsforaccount.length; i++) {
                if(userCanViewLog(alllogidsforaccount[i])){
                    Log log = reger.cache.LogCache.get(alllogidsforaccount[i]);
                    if (includelogshiddenfromhomepage || (!includelogshiddenfromhomepage && log.getShowonhomepage())){
                        numberoflogsusercanview = numberoflogsusercanview + 1;
                        if (numberoflogsusercanview==1){
                            queryend.append(" ( ");
                        } else {
                            queryend.append(" OR ");
                        }
                        queryend.append(" logid='"+alllogidsforaccount[i]+"' ");
                    }
                }
            }
            if (numberoflogsusercanview>0){
                queryend.append(" ) ");
            }
        }
        //Return
        if (queryend.length()>0){
            return queryend.toString();
        } else {
            return " (logid<'-1') ";
        }
    }

    /**
     * Logs this user can administer/author
     */
    public String LogsUserCanAdministerQueryendNoMegalog(int accountid){
        return LogsUserCanAdministerQueryendNoMegalog(accountid, true);
    }

    public String LogsUserCanAdministerQueryendNoMegalog(int accountid, boolean includelogshiddenfromhomepage){
        StringBuffer queryend=new StringBuffer();
        int numberoflogsusercanview = 0;
        Account acct = reger.cache.AccountCache.get(accountid);
        if (acct!=null){
            int[] alllogidsforaccount = acct.getAllLogids();
            for (int i = 0; i < alllogidsforaccount.length; i++) {
                if(userCanAuthorLog(alllogidsforaccount[i])){
                    Log log = reger.cache.LogCache.get(alllogidsforaccount[i]);
                    if (includelogshiddenfromhomepage || (!includelogshiddenfromhomepage && log.getShowonhomepage())){
                        numberoflogsusercanview = numberoflogsusercanview + 1;
                        if (numberoflogsusercanview==1){
                            queryend.append(" ( ");
                        } else {
                            queryend.append(" OR ");
                        }
                        queryend.append(" logid='"+alllogidsforaccount[i]+"' ");
                    }
                }
            }
            if (numberoflogsusercanview>0){
                queryend.append(" ) ");
            }
        }
        //Return
        if (queryend.length()>0){
            return queryend.toString();
        } else {
            return " (logid<'-1') ";
        }
    }

    /**
     * Checks for mobile logon.  Each time the mobile device makes a request it sends xUpSubNo.
     * We can't rely on cookies so this must be called for each request.
     * @param xUpSubNo
     */
    public boolean mobileCheckLogin(String xUpSubNo) {
        //-----------------------------------
        //-----------------------------------
        String[][] rstMobileLogon= Db.RunSQL("SELECT mobileid FROM mobile WHERE xupsubno='"+reger.core.Util.cleanForSQL(xUpSubNo)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMobileLogon!=null && rstMobileLogon.length>0){
            return true;
        } else {
            return false;
        }
    }


    /**
    * Record last login date to database
    */
    private void saveLastLoginDate(){
        //-----------------------------------
        //-----------------------------------
        int count = reger.core.db.Db.RunSQLUpdate("UPDATE accountuser SET lastlogindate='"+reger.core.TimeUtils.nowInGmtString()+"' WHERE accountuserid='"+ accountuserid +"'");
        //-----------------------------------
        //-----------------------------------
    }



    /**
     *  Toggles this user's entry mode
     */
    public void toggleEntryMode(){
        if (accountuserid>0){
            int newVal = reger.Vars.ENTRYMODESIMPLE;
            if (entrymode==reger.Vars.ENTRYMODESIMPLE){
                newVal = reger.Vars.ENTRYMODEADVANCED;
            }
            //-----------------------------------
            //-----------------------------------
            int count = reger.core.db.Db.RunSQLUpdate("UPDATE accountuser SET entrymode='"+newVal+"' WHERE accountuserid='"+accountuserid+"'");
            //-----------------------------------
            //-----------------------------------

            //Make sure I update this object with the correct value
            entrymode = newVal;
        }
    }

    /**
     * Changes the password
     * @param newpassword
     */
    public String changePassword(String newpassword){
        String errortext = "";

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE accountuser SET password='"+reger.core.Util.cleanForSQL(password)+"' WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------

        return errortext;
    }


    public void grantAcl(String aclobjectname, int accountidRelatedTo){
        //Get the aclobjectid
        int aclobjectid=reger.acl.AllAclObjects.getAclObjectIdByName(aclobjectname);
        //Do the work
        grantAcl(aclobjectid, accountidRelatedTo);
    }

    public void grantAcl(int aclobjectid, int accountidRelatedTo){
        if (accountuserid>0){
            //reger.core.Util.logtodb("Granting accountuserid="+accountuserid+" aclaclobjectid=" + aclobjectid + " on accountid=" + accountidRelatedTo);
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountidRelatedTo+"' AND aclobjectid='"+aclobjectid+"'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO accountuseracl(accountuserid, aclobjectid, accountid) VALUES('"+accountuserid+"', '"+aclobjectid+"', '"+accountidRelatedTo+"')");
            //-----------------------------------
            //-----------------------------------

            //Populate the object
            populate();
        }
    }



    public void revokeAcl(String aclobjectname, int accountidRelatedTo){
        //Get the aclobjectid
        int aclobjectid=reger.acl.AllAclObjects.getAclObjectIdByName(aclobjectname);
        //Do the work
        revokeAcl(aclobjectid, accountidRelatedTo);
    }

    public void revokeAcl(int aclobjectid, int accountidRelatedTo){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountidRelatedTo+"' AND aclobjectid='"+aclobjectid+"'");
        //-----------------------------------
        //-----------------------------------

        //Populate the object
        populate();
    }

    public void grantLogAccess(int logid){
        if (accountuserid>0){

            //-----------------------------------
            //-----------------------------------
            String[][] rstUsr= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' AND logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstUsr!=null && rstUsr.length>0){
                for(int i=0; i<rstUsr.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canread='1' WHERE accountuserlogaccessid='"+rstUsr[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            } else {
                //Need to create the record
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO accountuserlogaccess(accountuserid, logid, canread) VALUES('"+accountuserid+"', '"+logid+"', '1')");
                //-----------------------------------
                //-----------------------------------
            }

            //Populate the object
            populate();
        }
    }

    public void revokeLogAccess(int logid){
        if (accountuserid>0){

            //-----------------------------------
            //-----------------------------------
            String[][] rstUsr= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' AND logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstUsr!=null && rstUsr.length>0){
                for(int i=0; i<rstUsr.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canread='0' WHERE accountuserlogaccessid='"+rstUsr[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }

            //Cleanup empty rows
            cleanupLogaccessPermissionRowsWithNoPermissions();

            //Populate the object
            populate();
        }
    }

    public void grantLogAuthoring(int logid){
        if (accountuserid>0){

            //-----------------------------------
            //-----------------------------------
            String[][] rstUsr= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' AND logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstUsr!=null && rstUsr.length>0){
                for(int i=0; i<rstUsr.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canwrite='1' WHERE accountuserlogaccessid='"+rstUsr[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            } else {
                //Need to create the record
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO accountuserlogaccess(accountuserid, logid, canwrite) VALUES('"+accountuserid+"', '"+logid+"', '1')");
                //-----------------------------------
                //-----------------------------------
            }

            //Also grant raedership
            grantLogAccess(logid);

            //Populate the object
            populate();
        }
    }

    public void revokeLogAuthoring(int logid){
        if (accountuserid>0){

            //-----------------------------------
            //-----------------------------------
            String[][] rstUsr= Db.RunSQL("SELECT accountuserlogaccessid FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' AND logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstUsr!=null && rstUsr.length>0){
                for(int i=0; i<rstUsr.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE accountuserlogaccess SET canwrite='0' WHERE accountuserlogaccessid='"+rstUsr[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }

            //Cleanup empty rows
            cleanupLogaccessPermissionRowsWithNoPermissions();

            //Populate the object
            populate();
        }
    }



    private void cleanupLogaccessPermissionRowsWithNoPermissions(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstUsr= Db.RunSQL("SELECT accountuserlogaccessid, canread, canwrite FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUsr!=null && rstUsr.length>0){
            for(int i=0; i<rstUsr.length; i++){
                if (!rstUsr[i][1].equals("1") && !rstUsr[i][2].equals("1")){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("DELETE FROM accountuserlogaccess WHERE accountuserlogaccessid='"+rstUsr[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }
        }
    }


    public void addUserToAclGroup(String aclgroupname, int accountidRelatedTo){
        int aclgroupid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstGp= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGp!=null && rstGp.length>0){
            //Now do the work
            addUserToAclGroup(Integer.parseInt(rstGp[0][0]), accountidRelatedTo);
        }

    }

    public void addUserToAclGroup(int aclgroupid, int accountidRelatedTo){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuseraclgroup WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountidRelatedTo+"' AND aclgroupid='"+aclgroupid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO accountuseraclgroup(accountuserid, aclgroupid, accountid) VALUES('"+accountuserid+"', '"+aclgroupid+"', '"+accountidRelatedTo+"')");
        //-----------------------------------
        //-----------------------------------

        //Repopulate
        populate();
    }

    public void removeUserFromAclGroup(String aclgroupname, int accountidRelatedTo){
        int aclgroupid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstGp= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGp!=null && rstGp.length>0){
            //Now do the work
            removeUserFromAclGroup(Integer.parseInt(rstGp[0][0]), accountidRelatedTo);
        }

    }

    public void removeUserFromAclGroup(int aclgroupid, int accountidRelatedTo){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuseraclgroup WHERE accountuserid='"+accountuserid+"' AND aclgroupid='"+aclgroupid+"' AND accountid='"+accountidRelatedTo+"'");
        //-----------------------------------
        //-----------------------------------

        //Repopulate
        populate();
    }



    public String saveSettings(PrivateLabel pl){

        String errortext = "";

        String isactivetext = "0";
        if (this.isactive){
            isactivetext = "1";
        }

        //Validate the info first
        errortext = errortext + validateAccountuser(pl);

        //If we have no errors, save
        if (errortext.equals("")){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE accountuser SET accountid='"+accountid+"', username='"+reger.core.Util.cleanForSQL(this.username)+"', friendlyname='"+reger.core.Util.cleanForSQL(this.friendlyname)+"', passphrasequestion='"+reger.core.Util.cleanForSQL(this.passphrasequestion)+"', passphraseanswer='"+reger.core.Util.cleanForSQL(this.passphraseanswer)+"', email='"+reger.core.Util.cleanForSQL(this.email)+"', entrymode='"+this.entrymode+"', usertimezoneid='"+reger.core.Util.cleanForSQL(this.usertimezoneid)+"', onelinesummary='"+reger.core.Util.cleanForSQL(this.onelinesummary)+"', isactive='"+isactivetext+"' WHERE accountuserid='"+this.accountuserid+"'");
            //-----------------------------------
            //-----------------------------------

            //Don't forget to save the password, but only validate/change if there's a new one inbound
            if (!password.equals("") && !verifypassword.equals("")){
                errortext = errortext + savePassword(password, verifypassword, pl);
            }
        }

        return errortext;
    }

    public String savePassword(String password, String verifypassword, PrivateLabel pl){
        Debug.debug(5, "", "Accountuser.java: savePassword():  <br>password="+password+"<br>verifypassword="+verifypassword);

            String errortext = validateNewPassword(password, verifypassword, pl);
            if (errortext.equals("")){
                String passwordHash = PasswordHash.getHash(password);
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE accountuser SET password='"+reger.core.Util.cleanForSQL(passwordHash)+"' WHERE accountuserid='"+accountuserid+"'");
                //-----------------------------------
                //-----------------------------------
            }
            return errortext;
    }


    public String newAccountuser(PrivateLabel pl){

        String errortext ="";

        String isactivetext = "0";
        if (isactive){
            isactivetext = "1";
        }

        //Validate the account
        errortext = errortext + validateAccountuser(pl);

        if (errortext.equals("")){
            //-----------------------------------
            //-----------------------------------
            this.accountuserid = Db.RunSQLInsert("INSERT INTO accountuser(accountid, username, friendlyname, passphrasequestion, passphraseanswer, email, lastlogindate, entrymode, usertimezoneid, isactive, onelinesummary, createdate, ishelpon) VALUES('"+accountid+"', '"+Util.cleanForSQL(this.username)+"', '"+Util.cleanForSQL(this.friendlyname)+"', '"+Util.cleanForSQL(this.passphrasequestion)+"', '"+Util.cleanForSQL(this.passphraseanswer)+"', '"+Util.cleanForSQL(this.email)+"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+this.entrymode+"', '"+Util.cleanForSQL(this.usertimezoneid)+"', '"+Util.cleanForSQL(isactivetext)+"', '"+Util.cleanForSQL(this.onelinesummary)+"', Now(), '0')");
            //-----------------------------------
            //-----------------------------------

            //Don't forget to save the password
            errortext = errortext + savePassword(password, verifypassword, pl);
        }

        return errortext;
    }

    public String validateNewPassword(String password, String verifypassword, PrivateLabel pl){
        //Password validation
        PasswordVerifier pwdv = new PasswordVerifier(pl);
        String errortext = pwdv.validatePassword(password, verifypassword);
        return errortext;
    }



    public String validateAccountuser(PrivateLabel pl){
        String errortext = "";

        //Maxusers validation
        if(!pl.canAddAnotherUser()){
            errortext = errortext + "<br>The current license does not another user to be added.  Please contact your system administrator or increase the number of maximum users in your license.";
        }

        //Username validation
        errortext = errortext + reger.core.Util.validateUsername(username);

        //Only validate password if a new one has been sent in
        String passwordError = "";
        if (!password.equals("") && !verifypassword.equals("")){
            Debug.debug(5, "", "Accountuser.java: validateAccountuser():  <br>password="+password+"<br>verifypassword="+verifypassword);
            passwordError = validateNewPassword(password, verifypassword, pl);
        }
        errortext = errortext + passwordError;

        //Don't duplicate usernames
        //-----------------------------------
        //-----------------------------------
        String[][] rstCheckUsername= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountuserid<>'"+accountuserid+"' AND username='"+reger.core.Util.cleanForSQL(username)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheckUsername!=null && rstCheckUsername.length>0){
            errortext = errortext + "<br>We're sorry:  '"+ username +"' is already in use.";
        }


        //Make sure friendlyname isn't blank
        if (friendlyname.equals("")) {
            friendlyname = username;
        }

        //Make sure one line summary isn't blank
        if (onelinesummary.equals("")) {
            onelinesummary = friendlyname;
        }

        //Make sure passphrasequestion isn't blank
        if (passphrasequestion.equals("")) {
            errortext=errortext + "Your Passphrase Question can't be blank.<br>";
        }

        //Make sure passphraseanswer isn't blank
        if (passphraseanswer.equals("")) {
            errortext=errortext + "Your Passphrase Answer can't be blank.<br>";
        }

        //Make sure email isn't blank
        if (email.equals("")) {
            errortext=errortext + "You must provide an email address so that you can recover your password if you forget it.<br>";
        }

        return errortext;
    }


    public void permissionsUpdateFromRequest(javax.servlet.http.HttpServletRequest request, reger.Accountuser accountUserOfDoer, int accountidOfChanges){
        //Store the permissions
        //And then add the new ones.
        //Get a list of what this user can do.
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstPermissions= Db.RunSQL("SELECT aclobjectid FROM aclobject");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstPermissions!=null && rstPermissions.length>0){
//            for(int i=0; i<rstPermissions.length; i++){

        //Then get the array of aclobjects that this group can access
        reger.acl.AclObject[] aclObjects = reger.acl.AllAclObjects.getAllAclObjects();
        //Iterate through them, adding those that the user doesn't already have access to
        for (int i = 0; i < aclObjects.length; i++) {

            //Only work with the permission if the logged-in user can do it
            if (accountUserOfDoer.userCanDoAcl(aclObjects[i].aclobjectid, accountidOfChanges)){

                //Start by deleting the old permissions
                //-----------------------------------
                //-----------------------------------
                int countDeleted = Db.RunSQLUpdate("DELETE FROM accountuseracl WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountidOfChanges+"' AND aclobjectid='"+aclObjects[i].aclobjectid+"'");
                //-----------------------------------
                //-----------------------------------

                if (request.getParameter("aclobjectid-"+aclObjects[i].aclobjectid)!=null && request.getParameter("aclobjectid-"+aclObjects[i].aclobjectid).equals("1")){
                    //Grant the permission
                    grantAcl(aclObjects[i].aclobjectid, accountidOfChanges);
                }
            }

        }
//            }
//        }
    }

    public void logaccessUpdateFromRequest(javax.servlet.http.HttpServletRequest request, reger.UserSession userSessionOfChanger){

        //Store log permissions
        //Next, add back the ones selected on the screen
        //-----------------------------------
        //-----------------------------------
        String[][] rsAllLgs=reger.core.db.Db.RunSQL("SELECT logid, name FROM megalog WHERE accountid='"+ userSessionOfChanger.getAccount().getAccountid() +"'");
        //-----------------------------------
        //-----------------------------------
        for(int i=0; i<rsAllLgs.length; i++){
            //If the logged-in user can view this log
            if (userSessionOfChanger.getAccountuser().userCanViewLog(Integer.parseInt(rsAllLgs[i][0]))){
                //Start by deleting the old permissions
                //-----------------------------------
                //-----------------------------------
                int countDeletedLogPerms = Db.RunSQLUpdate("DELETE FROM accountuserlogaccess WHERE accountuserid='"+accountuserid+"' AND logid='"+rsAllLgs[i][0]+"'");
                //-----------------------------------
                //-----------------------------------

                //View permissions
                if (request.getParameter("canviewlogid-"+rsAllLgs[i][0])!=null && request.getParameter("canviewlogid-"+rsAllLgs[i][0]).equals("1")){
                    //Don't create a relationship if the accountuserid=-1
                    if (accountuserid>0){
                        if (!isInAclgroup("SiteOwner", userSessionOfChanger.getAccount().getAccountid())){
                            //Grant access to this log
                            grantLogAccess(Integer.parseInt(rsAllLgs[i][0]));
                        }
                    }
                }

                //Author permissions
                if (request.getParameter("canauthorlogid-"+rsAllLgs[i][0])!=null && request.getParameter("canauthorlogid-"+rsAllLgs[i][0]).equals("1")){
                    //Don't create a relationship if the accountuserid=-1
                    if (accountuserid>0){
                        if (!isInAclgroup("SiteOwner", userSessionOfChanger.getAccount().getAccountid())){
                            //Grant access to this log
                            grantLogAuthoring(Integer.parseInt(rsAllLgs[i][0]));
                        }
                    }
                }
            }
        }

    }


    public void populateFromRequest(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("acctuserusername")!=null && !request.getParameter("acctuserusername").equals("")){
            setUsername(request.getParameter("acctuserusername"));
        }
        if (request.getParameter("friendlyname")!=null && !request.getParameter("friendlyname").equals("")){
            setFriendlyname(request.getParameter("friendlyname"));
        }
        if (request.getParameter("onelinesummary")!=null && !request.getParameter("onelinesummary").equals("")){
            setOnelinesummary(request.getParameter("onelinesummary"));
        }
        if (request.getParameter("email")!=null && !request.getParameter("email").equals("")){
            setEmail(request.getParameter("email"));
        }
        if (request.getParameter("acctuserpassword")!=null && !request.getParameter("acctuserpassword").equals("")){
            setPassword(request.getParameter("acctuserpassword"));
        }
        if (request.getParameter("acctuserverifypassword")!=null && !request.getParameter("acctuserverifypassword").equals("")){
            setVerifypassword(request.getParameter("acctuserverifypassword"));
        }
        if (request.getParameter("passphrasequestion")!=null && !request.getParameter("passphrasequestion").equals("")){
            setPassphrasequestion(request.getParameter("passphrasequestion"));
        }
        if (request.getParameter("passphraseanswer")!=null && !request.getParameter("passphraseanswer").equals("")){
            setPassphraseanswer(request.getParameter("passphraseanswer"));
        }
        if (request.getParameter("isactive")!=null && !request.getParameter("isactive").equals("") && reger.core.Util.isinteger(request.getParameter("isactive"))){
            if (Integer.parseInt(request.getParameter("isactive"))==1){
                setIsactive(true);
            } else {
                setIsactive(false);
            }
        }
        if (request.getParameter("usertimezoneid")!=null && !request.getParameter("usertimezoneid").equals("")){
            setUsertimezoneid(request.getParameter("usertimezoneid"));
        }
    }

    public String primaryImage(String pathToAppRoot, boolean isthumbnail){

        //-----------------------------------
        //-----------------------------------
        String[][] rstImg= Db.RunSQL("SELECT imageid FROM image WHERE accountuserid='"+accountuserid+"' ORDER BY image.order ASC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstImg!=null && rstImg.length>0){
            String isthumbnailtext = "yes";
            if (!isthumbnail){
                isthumbnailtext = "no";
            }
            return pathToAppRoot + "mediaout.log?imageid=" + rstImg[0][0] + "&isProfileImage=true&isthumbnail=" + isthumbnailtext;
        } else {
            return pathToAppRoot + reger.Vars.PROFILEGENERICIMAGE;
        }

    }

    public StringBuffer primaryImageHtml(String pathToAppRoot, boolean isthumbnail){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=10 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top align=center bgcolor=#e6e6e6>");
        mb.append("<a href='mediaouthtml.log' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        mb.append("<img src='"+primaryImage(pathToAppRoot, isthumbnail)+"' border=0>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append("<a href='profile-editimage.log'>");
        mb.append("Edit/Delete");
        mb.append("</a>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }

    public void deleteImage(int imageid, reger.Accountuser accountUserOfDoer){
        //Only the user themselves can delete an image
        if (accountUserOfDoer.getAccountuserid()==accountuserid){
            String imagename = "blah.jpg";

            //-----------------------------------
            //-----------------------------------
            String[][] rstImg= Db.RunSQL("SELECT image FROM image WHERE imageid='"+imageid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstImg!=null && rstImg.length>0){
                imagename = rstImg[0][0];
            }

            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+imageid+"' AND accountuserid='"+accountuserid+"'");
            //-----------------------------------
            //-----------------------------------


            //Delete the file
            reger.core.Util.deleteFile(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+imagename);
            //Delete the thumbnail
            reger.core.Util.deleteFile(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+"thumbnails/"+imagename);

        }
    }


    public void updateAccountuserfieldsFromRequest(javax.servlet.http.HttpServletRequest request){
        //Get the fields and store them in the Vector accountuserfields
        accountuserfields = new Vector(10);
        //-----------------------------------
        //-----------------------------------
        String[][] rstAcUf= Db.RunSQL("SELECT accountuserfieldid, fieldtitle, fielddata, accountuserfield.order FROM accountuserfield WHERE accountuserid='"+this.accountuserid+"' ORDER BY accountuserfield.order ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstAcUf!=null && rstAcUf.length>0){
            for(int i=0; i<rstAcUf.length; i++){
                String title = "";
                String body = "";
                if (request.getParameter("title-accountuserfieldid-" + rstAcUf[i][0])!=null && !request.getParameter("title-accountuserfieldid-" + rstAcUf[i][0]).equals("")){
                    title = request.getParameter("title-accountuserfieldid-" + rstAcUf[i][0]);
                }
                if (request.getParameter("fielddata-accountuserfieldid-" + rstAcUf[i][0])!=null && !request.getParameter("fielddata-accountuserfieldid-" + rstAcUf[i][0]).equals("")){
                    body = request.getParameter("fielddata-accountuserfieldid-" + rstAcUf[i][0]);
                    //reger.core.Util.logtodb("title=" + title + "<br>body=" + body);
                }
                if (!title.equals("")){
                    accountuserfields.add(new Accountuserfield(Integer.parseInt(rstAcUf[i][0]), title, body, Integer.parseInt(rstAcUf[i][3])));
                }

            }
        }
    }

    public void saveAccountuserfields(reger.Accountuser accountuser){

        if (accountuser.getAccountuserid()==accountuserid){
            //Iterate the accountuserfields and insert them into the database
            for (int i = 0; i < accountuserfields.size(); i++) {
                //Get the field
                reger.Accountuserfield field = (reger.Accountuserfield) accountuserfields.elementAt(i);
                field.saveFieldToDatabase(accountuserid);
                //-----------------------------------
                //-----------------------------------
                //int identity = Db.RunSQLInsert("INSERT INTO accountuserfield(accountuserid, fieldtitle, fielddata, accountuserfield.order) VALUES('"+accountuserid+"', '"+reger.core.Util.cleanForSQL(field.fieldtitle)+"', '"+reger.core.Util.cleanForSQL(field.fielddata)+"', '"+field.order+"')");
                //-----------------------------------
                //-----------------------------------

            }
        }

    }


    public StringBuffer accountSettingsHtmlForm(PrivateLabel pl){
        StringBuffer mb = new StringBuffer();

        //Display the data in a form.  Yummy form.  Yummy.
        mb.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");

        //Friendlyname
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff width=50% >");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Friendly Name:</b>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append("Your name as you would like it to appear on the site to other users.  For example, \"Joe Smith.\"");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=friendlyname value=\""+reger.core.Util.cleanForHtml(friendlyname)+"\" size=15 maxlength=100>");
        mb.append("</td>");
        mb.append("</tr>");

        //One Line Summary
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>One Line Summary:</b>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append("A quick, pithy summary of you.  This will give readers a quick sense of who you are before reading your full profile.  Example: I'm a tall goofy looking physics major from Georgia Tech.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=onelinesummary value=\""+reger.core.Util.cleanForHtml(onelinesummary)+"\" size=15 maxlength=100>");
        mb.append("</td>");
        mb.append("</tr>");

        //Username
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Username:</b>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append("You will use this to log in to your site.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=acctuserusername value=\""+reger.core.Util.cleanForHtml(username)+"\" size=15 maxlength=50>");
        mb.append("</td>");
        mb.append("</tr>");

        //Password
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Password:</b>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        PasswordVerifier pwdv = new PasswordVerifier(pl);
        mb.append("Choose your password carefully and make sure you remember it.  Requirements: " + pwdv.getPasswordRequirementsAsHtml());
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=password name=acctuserpassword value='' size=15 maxlength=50>");
        mb.append("</td>");
        mb.append("</tr>");

        //Password Verify
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Retype Password:</b>");
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        mb.append("Please retype your password for higher security.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=password name=acctuserverifypassword value='' size=15 maxlength=50>");
        mb.append("</td>");
        mb.append("</tr>");

        //Isactive
        if (accountuserid>0 && !isInAclgroup("SiteOwner", accountid) && !isInAclgroup("LOEAdmin", accountid)){
            mb.append("<tr>");
            mb.append("<td valign=top align=right bgcolor=#ffffff>");
            mb.append("<font face=arial size=-1>");
            mb.append("Active?");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top align=left bgcolor=#ffffff>");
            mb.append("<font face=arial size=-2>");
            mb.append("<input type=checkbox name=isactive value='1'");
            if (isactive) {
                mb.append(" checked");
            }
            mb.append("> Yes, this account is active.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        } else {
            mb.append("<input type=hidden name=isactive value=1>");
        }




        //Email
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Email:</b>");
        mb.append("</font>");
        mb.append("<br><font face=arial size=-2>");
        mb.append("Your information will be kept confidential.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=email value=\""+email+"\" size=15 maxlength=100>");
        mb.append("</td>");
        mb.append("</tr>");





        //passphrase question
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Passphrase Question:</b>");
        mb.append("</font>");
        mb.append("<br><font face=arial size=-2>");
        mb.append("A question that only you know the answer to.  This is used in case you forget your password.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=passphrasequestion value=\""+reger.core.Util.cleanForHtml(passphrasequestion)+"\" size=15 maxlength=255>");
        mb.append("</td>");
        mb.append("</tr>");

        //passphrase answer
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Passphrase Answer:</b>");
        mb.append("</font>");
        mb.append("<br><font face=arial size=-2>");
        mb.append("The answer to the passphrase question that you entered above.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<input type=text name=passphraseanswer value=\""+reger.core.Util.cleanForHtml(passphraseanswer)+"\" size=15 maxlength=50>");
        mb.append("</td>");
        mb.append("</tr>");

        //usertimezoneid
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#ffffff>");
        mb.append("<font face=arial size=-1>");
        mb.append("<b>Timezone:</b>");
        mb.append("</font>");
        mb.append("<br><font face=arial size=-2>");
        mb.append("You can set each user's timezone individually so that their entry timestamps are accurate.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#ffffff>");
        mb.append("<select name=usertimezoneid>");
        String[] timezone = TimeZone.getAvailableIDs();
        TreeSet timezoneids = new TreeSet();
        //Add the timezoneid's to a treeset
        for (int i = 0; i < timezone.length; i++) {
            timezoneids.add(timezone[i]);
        }
        //Output to the screen
        for (Iterator iterator = timezoneids.iterator(); iterator.hasNext();) {
            String tzid = (String) iterator.next();
            mb.append("<option value=\""+reger.core.Util.cleanForHtml(tzid)+"\" ");
            if (usertimezoneid!=null && usertimezoneid.equalsIgnoreCase(tzid)) {
                mb.append("selected");
            }
            mb.append(">");
            mb.append(tzid);
            mb.append("</option>");
        }
        mb.append("</select>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("</table>");


        return mb;
    }


    public void deleteAccountuser(reger.Accountuser accountuserOfDoer){
        //Make sure this user has permission to delete somebody
        //Users can only delete other users if they're deleting a user in the same account.
        if (accountuserOfDoer.userCanDoAcl("MANAGEACCOUNTS", accountuserOfDoer.getAccountid()) && (accountuserOfDoer.getAccountid()==accountid || accountuserOfDoer.isInAclgroup("LOEAdmin", accountid) ) && !isInAclgroup("SiteOwner", accountid) && !isInAclgroup("LOEAdmin", accountid)){
            //Delete the account
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM accountuser WHERE accountuserid='"+accountuserid+"'");
            //-----------------------------------
            //-----------------------------------

            //Change authorship to account owner
            //@todo Wouldn't it be nice to allow the user to choose who authorship should be attributed to when they delete a user?
            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("UPDATE event SET accountuserid='"+getAccountOwnerForThisAccountUser()+"' WHERE accountuserid='"+accountuserid+"'");
            //-----------------------------------
            //-----------------------------------



        }
    }

    public void revokeAllPermissionsForAnAccount(int accountid){
        //Logs
        Log[] logs = LogCache.allLogsForAccountAlphabetized(accountid);
        for (int i = 0; i < logs.length; i++) {
            Log log = logs[i];
            revokeLogAccess(log.getLogid());
            revokeLogAuthoring(log.getLogid());
        }

        //ACL Perms
        AclObject[] acls = reger.acl.AllAclObjects.getAllAclObjects();
        for (int i = 0; i < acls.length; i++) {
            AclObject acl = acls[i];
            revokeAcl(acl.aclobjectid, accountid);
        }
    }

    public int getAccountOwnerForThisAccountUser(){
        //Get the account owner
        int  accountownerid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstOwner= Db.RunSQL("SELECT accountuser.accountuserid FROM accountuser, accountuseraclgroup, aclgroup WHERE accountuser.accountid='"+accountid+"' AND accountuser.accountuserid=accountuseraclgroup.accountuserid AND accountuseraclgroup.aclgroupid=aclgroup.aclgroupid AND aclgroup.aclgroupname='LOEAdmin' ORDER BY accountuser.accountuserid ASC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstOwner!=null && rstOwner.length>0){
            accountownerid = Integer.parseInt(rstOwner[0][0]);
        }
        return accountownerid;
    }

    public boolean isFriend(int accountuseridoffriend){
        //-----------------------------------
        //-----------------------------------
        String[][] rstFriend= Db.RunSQL("SELECT friendid FROM friend WHERE accountuseridsource='"+this.accountuserid+"' AND accountuseridtarget='"+accountuseridoffriend+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFriend!=null && rstFriend.length>0){
            return true;
        }
        return false;
    }

    public void addFriend(int newfriendaccountuserid){
        if (newfriendaccountuserid!=accountuserid){
            //-----------------------------------
            //-----------------------------------
            String[][] rstExisting= Db.RunSQL("SELECT count(*) FROM friend WHERE accountuseridsource='"+this.accountuserid+"' AND accountuseridtarget='"+newfriendaccountuserid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstExisting!=null && rstExisting.length>0){
                if (Integer.parseInt(rstExisting[0][0])==0){
                    //Only add if there is not already an existing relationship
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO friend(accountuseridsource, accountuseridtarget) VALUES('"+this.accountuserid+"', '"+newfriendaccountuserid+"')");
                    //-----------------------------------
                    //-----------------------------------

                    //Update the static reger.Friend.friends var
                    reger.Friend friend = new reger.Friend();
                    friend.refreshFriendsFromDb();
                }
            }
        }
    }

    public void deleteFriend(int friendaccountuseridtodelete){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM friend WHERE accountuseridsource='"+accountuserid+"' AND accountuseridtarget='"+friendaccountuseridtodelete+"'");
        //-----------------------------------
        //-----------------------------------

        //Update the static reger.Friend.friends var
        reger.Friend friend = new reger.Friend();
        friend.refreshFriendsFromDb();
    }


    public StringBuffer htmlShortestRelationshipToPerson(int accountuseridofperson, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //First, go get the path
        reger.Friend friend = new reger.Friend();
        int[] relationship = friend.getShortestRelationship(accountuserid, accountuseridofperson);

        //Now, get the html representing the relationship
        mb.append(htmlFormatSingleRelationship(relationship, userSession));

        return mb;
    }

    public StringBuffer htmlAllRelationshipsToPerson(int accountuseridofperson, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //First, go get the path
        reger.Friend friend = new reger.Friend();
        int[][] relationship = friend.getAllRelationships(accountuserid, accountuseridofperson);

        //Iterate through the relationships
        if (relationship!=null){
            for (int i = 0; i < relationship.length; i++) {
                //Now, get the html representing the relationship
                mb.append(htmlFormatSingleRelationship(relationship[i], userSession));
                //mb.append("<br>");
            }
        } else {
            mb.append("None.");
            return mb;
        }


        return mb;
    }

    public StringBuffer htmlFormatSingleRelationship(int[] relationship, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //We have an array of accountuserid's and need to convert them into a linear representation of the relationship
        //Order in the array is important... you are 0 index.

        if (relationship.length>0){

            //First, need to create dynamic sql
            String sqlSelect = "(";
            for (int i = 0; i < relationship.length; i++) {
                sqlSelect = sqlSelect + "accountuser.accountuserid='"+relationship[i]+"'";
                if (i<(relationship.length-1)){
                    sqlSelect = sqlSelect + " OR ";
                }
            }
            sqlSelect = sqlSelect + ")";

            //Next, go to the database
            //-----------------------------------
            //-----------------------------------
            String[][] rstAcc= Db.RunSQL("SELECT accountuserid, friendlyname, onelinesummary, account.accountid FROM accountuser, account WHERE " + sqlSelect + " AND isactive=1 AND account.accountid=accountuser.accountid");
            //-----------------------------------
            //-----------------------------------
            if (rstAcc!=null && rstAcc.length>0){
                //Start the table
                mb.append("<table cellpadding=3 cellspacing=0 border=0>");
                mb.append("<tr>");

                //Iterate through the relationship
                for (int i = 0; i < relationship.length; i++) {
                    //Go get the info that's held in the Db
                    for(int j=0; j<rstAcc.length; j++){
                        //If we're working with the Db record that has the correct accountuserid
                        if (Integer.parseInt(rstAcc[j][0])==relationship[i]){
                            mb.append("<td valign=top>");
                            mb.append("<font face=arial size=-2>");
                            reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstAcc[j][3]));
                            mb.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/author.log?accountuserid="+rstAcc[j][0]+"'>");
                            if (rstAcc[j][1].equals(friendlyname)){
                                mb.append("You");
                            } else {
                                mb.append(rstAcc[j][1]);
                            }
                            mb.append("</a>");
                            mb.append("</font>");
                            mb.append("</td>");
                            //Little arrow
                            if (i<(relationship.length-1)){
                                mb.append("<td valign=top>");
                                mb.append("<font face=arial size=-2>");
                                mb.append("<b>");
                                mb.append(">");
                                mb.append("</b>");
                                mb.append("</font>");
                                mb.append("</td>");
                            }

                        }
                    }
                }

                //End the table
                mb.append("</tr>");
                mb.append("</table>");

            } else {
                mb.append("<font face=arial size=-1>None.</a>");
            }

        } else {
            mb.append("<font face=arial size=-1>None.</a>");
        }



        return mb;
    }

    public StringBuffer thingsUserCanAccessHtml(boolean isHttps, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=15 cellspacing=3 width=100% border=0>");


        Hashtable accts = getAccountsUserHasAccessTo();
        if (accts!=null){

            for ( Enumeration e = accts.keys() ; e.hasMoreElements() ; ) {
                // retrieve the object_key
                Integer accountid = (Integer) e.nextElement();
                // retrieve the object associated with the key
                String sitename = (String) accts.get ( accountid );

                //Create an account object
                reger.Account acct = new reger.Account(accountid.intValue());

                //Site name
                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#cccccc colspan=2>");
                mb.append("<a href='"+ acct.getSiteRootUrl(userSession) + "/'>");
                mb.append("<font face=arial size=+1>");
                mb.append(""+ acct.getSiteRootUrl(userSession) + "/");
                mb.append("</font>");
                mb.append("</a>");
                if (userCanDoAcl("ADMINHOME", accountid.intValue())){
                    mb.append(" ");
                    mb.append("<a href='"+ acct.getSiteRootUrl(userSession) + "/myhome/'>");
                    mb.append("<font face=arial size=-1>");
                    mb.append("(Admin)");
                    mb.append("</font>");
                    mb.append("</a>");
                }
                mb.append("</td>");
                mb.append("</tr>");

                //Column headers
                mb.append("<tr>");
                mb.append("<td width=50% valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=-2>");
                mb.append("Logs You Have Access To On This Site");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td width=50% valign=top bgcolor=#e6e6e6>");
                mb.append("<font face=arial size=-2>");
                mb.append("Permissions You Have On This Site");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");


                //Logs
                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#ffffff nowrap>");

                //mb.append("Logs You Have Access To On This Site:");

                Vector allLogs = LogCache.allLogsForAccount(accountid.intValue());
                for (int i = 0; i < allLogs.size(); i++) {
                    Log log = (Log) allLogs.elementAt(i);
                    //reger.core.Util.logtodb("Logid=" + log.getLogid() + "<br>userCanViewLog(log.getLogid())=" + userCanViewLog(log.getLogid()));
                    if (userCanViewLog(log.getLogid()) || userCanAuthorLog(log.getLogid())){
                        if (log.getLogaccess()==reger.Vars.LOGACCESSPRIVATE){
                            mb.append("<img src='"+acct.getSiteRootUrl(userSession)+"/images/icon-private.gif' border=0>");
                        } else {
                            mb.append("<img src='"+acct.getSiteRootUrl(userSession)+"/images/icon-public.gif' border=0>");
                        }
                        mb.append(" ");
                        mb.append("<font face=arial size=-1>");
                        mb.append("<b>");
                        mb.append(log.getName());
                        mb.append("</b>");
                        mb.append("</font>");
                        mb.append("<font face=arial size=-2>");
                        mb.append(" (<a href='"+acct.getSiteRootUrl(userSession)+"/logmain"+log.getLogid()+".log'>");
                        mb.append("View");
                        mb.append("</a>)");
                        if (userCanAuthorLog(log.getLogid()) && userCanDoAcl("ADDEDITENTRIES", accountid.intValue())){
                            mb.append(" ");
                            mb.append("(<a href='"+acct.getSiteRootUrl(userSession)+"/myhome/entry.log?logid="+log.getLogid()+"&action=add'>");
                            mb.append("Add Entry");
                            mb.append("</a>)");
                        }
                        mb.append("</font>");
                        mb.append("<br>");
                    }

                }

                mb.append("</td>");
                //mb.append("</tr>");

                //Permissions
                //mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#ffffff>");
                mb.append("<font face=arial size=-2>");
                //mb.append("Permissions You Have On This Site:<br>");
                AclObject[] allAclObjects = reger.acl.AllAclObjects.getAllAclObjects();
                for (int i = 0; i < allAclObjects.length; i++) {
                    if (userCanDoAcl(allAclObjects[i].aclobjectid, acct.getAccountid())){
                        mb.append("(");
                        mb.append(allAclObjects[i].aclfriendlyname);
                        mb.append(") ");
                    }
                }
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");


            }
        }

        //Groups
        if (isLoggedIn){
            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#cccccc colspan=2>");
            mb.append("<a href='"+getSiteRootUrlOfPrimaryAccount(userSession)+"/myhome/groups.log'>");
            mb.append("<font face=arial size=+1>");
            mb.append("Groups");
            mb.append("</font>");
            mb.append("</a>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Post to a group by creating an entry and specifying the group at the bottom of the page.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td width=50% valign=top bgcolor=#e6e6e6 colspan=2>");
            mb.append("<font face=arial size=-2>");
            mb.append("Groups You Are Subscribed To:");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("<tr>");
            mb.append("<td width=50% valign=top bgcolor=#ffffff colspan=2>");
            mb.append("<font face=arial size=-1>");

                //-----------------------------------
                //-----------------------------------
                String[][] rstGroup= Db.RunSQL("SELECT groupsubscriptionid, groupname, groupkey, groupadminkey, weburlofgroup FROM groupsubscription WHERE accountuserid='"+accountuserid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstGroup!=null && rstGroup.length>0){
                    for(int i=0; i<rstGroup.length; i++){
                        mb.append("<b>");
                        mb.append(rstGroup[i][1]);
                        mb.append("</b>");
                        mb.append("</font>");
                        mb.append("<font face=arial size=-2>");
                        mb.append(" (<a href='"+rstGroup[i][4]+"?groupkey="+rstGroup[i][2]+"&groupadminkey="+rstGroup[i][3]+"'>");
                        mb.append("View");
                        mb.append("</a>)");
                        mb.append(" (<a href='"+getSiteRootUrlOfPrimaryAccount(userSession)+"/myhome/people-friends-invite.log?groupsubscriptionid="+rstGroup[i][0]+"'>");
                            mb.append("Invite Friends");
                            mb.append("</a>)");
                        if (!rstGroup[i][3].equals("")){
                            mb.append(" (<a href='"+getSiteRootUrlOfPrimaryAccount(userSession)+"/myhome/groups-administer.log?groupsubscriptionid="+rstGroup[i][0]+"'>");
                            mb.append("Administer");
                            mb.append("</a>)");
                        }
                    }
                } else {
                    mb.append("<b>");
                    mb.append("None.");
                    mb.append("</b>");
                }

            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }


        mb.append("</table>");

        return mb;
    }


    public void toggleHelp(){
        String tmpText = "";
        if (isHelpOn){
            tmpText = "0";
            isHelpOn = false;
        } else {
            tmpText = "1";
            isHelpOn = true;
        }
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE accountuser SET ishelpon='"+tmpText+"' WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public void setDefaultAccountidForThisUser(int accountid, PrivateLabel pl){
        Hashtable accts = getAccountsUserHasAccessTo();
        if (accts!=null){
            if (userCanDoAcl("ADMINHOME", accountid)){
                this.accountid=accountid;
                saveSettings(pl);
            }
        }
    }

    public String getSiteRootUrlOfPrimaryAccount() {
        reger.Account acct = reger.cache.AccountCache.get(this.accountid);
        reger.core.Debug.debug(5, "Accountuser.java", "acct.getSiteRootUrl()="+acct.getSiteRootUrl());
        return acct.getSiteRootUrl();
    }

    public String getSiteRootUrlOfPrimaryAccount(UserSession userSession){
        reger.core.Debug.debug(5, "Accountuser.java", "sending inUrl="+getSiteRootUrlOfPrimaryAccount());
        return userSession.getUrlWithPortSmartlyAttached(getSiteRootUrlOfPrimaryAccount());
    }


    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getUsername() {
        Debug.debug(5, "", "Accountuser.java - getUsername() called.  returning:" + username);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public void setVerifypassword(String verifypassword) {
        this.verifypassword = verifypassword;
    }

    public String getFriendlyname() {
        return friendlyname;
    }

    public void setFriendlyname(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public String getPassphrasequestion() {
        return passphrasequestion;
    }

    public void setPassphrasequestion(String passphrasequestion) {
        this.passphrasequestion = passphrasequestion;
    }

    public String getPassphraseanswer() {
        return passphraseanswer;
    }

    public void setPassphraseanswer(String passphraseanswer) {
        this.passphraseanswer = passphraseanswer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Calendar lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public int getEntrymode() {
        return entrymode;
    }

    public void setEntrymode(int entrymode) {
        this.entrymode = entrymode;
    }

    public String getUsertimezoneid() {
        return usertimezoneid;
    }

    public void setUsertimezoneid(String usertimezoneid) {
        this.usertimezoneid = usertimezoneid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }



    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public Vector getAccountuserfields() {
        return accountuserfields;
    }

    public void setAccountuserfields(Vector accountuserfields) {
        this.accountuserfields = accountuserfields;
    }

    public Calendar getCreatedate() {
        return createdate;
    }

    public String getOnelinesummary() {
        return onelinesummary;
    }

    public void setOnelinesummary(String onelinesummary) {
        this.onelinesummary = onelinesummary;
    }



    public Vector getAccountUserAcls() {
        return accountUserAcls;
    }

    public Hashtable getAccountsUserHasAccessTo() {
        return accountsUserHasAccessTo;
    }

    public boolean getIsHelpOn() {
        return isHelpOn;
    }
}
