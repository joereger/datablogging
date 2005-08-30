
package reger.pageFramework;

public class PageProps{

	//Basic page vars
	public String title;
	public boolean isPasswordProtected=false;
	public String aclObjectName;
	public String adminSection;
	public String navButtonName;
    public String masterAdminSection;
    public String plAdminSection;
	public boolean isLogidRequired=false;
	public boolean isEventidRequired=false;
    public int siteSection;
    public int trafficType;
    public String pathToAppRoot = "";
    public boolean isUploadPage = false;
    public String helpText = "";
    public int marketingSiteSection = MARKETINGSITESECTIONHOME;


    //Static site section vars
    public static int PUBLICSITE=0;
    public static int ADMINSITE=1;
    public static int MASTERADMINSITE=2;
    public static int MARKETINGSITE=3;
    public static int HELPPOPUP=4;
    public static int MOBILEPUBLIC=5;
    public static int API=6;
    public static int PLADMINSITE=7;
    public static int GROUPSSITE=8;
    public static int MOBILEPRIVATE=9;
    public static int MARKETINGSITEWITHUSERCONTENT=10;

    //Marketing site static vars
    public static int MARKETINGSITESECTIONHOME=1;
    public static int MARKETINGSITESECTIONFEATURES=2;
    public static int MARKETINGSITESECTIONTOUR=3;
    public static int MARKETINGSITESECTIONSIGNUP=4;
    public static int MARKETINGSITESECTIONBIZ=5;
    public static int MARKETINGSITESECTIONCOMMUNITY=6;

	//Log and event-specific vars - will be deprecated
	//public int eventid=-1;
    //public int logid=-1;

    //Other internal objects
    public reger.logProps logProps = new reger.logProps();
    public reger.Entry entry = new reger.Entry();

	//Flow pagevars
	public String action="";

	//These are for the public site
	//public StringBuffer nb = new StringBuffer();
	//public StringBuffer hd = new StringBuffer();

	//SSL vars
	public boolean isCurrentRequestSSL = false;

	//This cool little variable sets the onload handler in the page's main <body> tag.
    //Leave null to not have anything called.
    //Set to the name of a javascript method to call it.
    //i.e. "myCoolLoadHandler("blah", 34, false)"
    //Only works in admin section where tRexAdminPageEngine
    public String onloadJavascriptMethod;
    public String onunloadJavascriptMethod;



	/**
	* Populates the object
	*/
	public void populate(javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){

        //Get incoming eventid
        int tmpeventid=-1;
        if (request.getParameter("eventid")!=null && !request.getParameter("eventid").equals("")){
			if (reger.core.Util.isinteger(request.getParameter("eventid"))) {
				tmpeventid=Integer.parseInt(request.getParameter("eventid"));
			}
		}

        //Get incoming logid
        int tmplogid=-1;
        if (request.getParameter("logid")!=null && !request.getParameter("logid").equals("")){
			if (reger.core.Util.isinteger(request.getParameter("logid"))) {
				tmplogid=Integer.parseInt(request.getParameter("logid"));
			}
		}

        //Populate the action
		if (request.getParameter("action")!=null && !request.getParameter("action").equals("")){
			action=request.getParameter("action");
		}

        //Get the logProps object setup
        if (tmplogid!=-1){
            //Use logid to populate logProps
            logProps.populateLogidData(tmplogid, userSession.getAccount().getAccountid());
        } else if (tmpeventid!=-1) {
            //Use eventid to populate logProps
            logProps.populateEventidData(tmpeventid, userSession.getAccount().getAccountid());
        }


        //Get the event object setup
        //if (userSession.getAccount()!=null && tmpeventid!=-1){
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            //entry.populate(userSession.getAccountuser(), userSession.getAccount(), userSession.getPl(), logProps.logid, request);
        }


        //Set the SSL var
        isCurrentRequestSSL = isRequestSSL(request);

	}

	public boolean isRequestSSL(javax.servlet.http.HttpServletRequest request){
	    if (request.isSecure()){
            return true;
        }
        return false;
    }


}


