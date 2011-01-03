package reger;

import reger.core.Debug;
import reger.core.Util;
import reger.cache.providers.jboss.Cacheable;
import reger.systemprops.AllSystemProperties;

import javax.servlet.http.Cookie;
import java.util.Calendar;
import java.util.HashMap;

/**
 * A user session that holds all critical login, pl and account information.
 */
@Cacheable
public class UserSession implements java.io.Serializable {

    private int accountid=0;
    private Account account;
    private Accountuser accountuser;
    private int plid = reger.Vars.PLIDDEFAULT;
    private UrlSplitter urlSplitter;
    private Calendar mostRecentActivity = Calendar.getInstance();
    private HashMap attributes = new HashMap();

    public UserSession(javax.servlet.http.HttpServletRequest request){
        reger.core.Debug.debug(5, "UserSession.java", "New UserSession created.");
        //Get the basic information
        processNewRequest(request);
        if (accountuser!=null && !accountuser.isLoggedIn){
            //reger.core.Util.logtodb("UserSession - accountuser not logged in.");
            //Now, see if the incoming request has a persistent login cookie
            Cookie[] cookies = request.getCookies();
            if (cookies!=null && cookies.length>0){
                //reger.core.Util.logtodb("UserSession - cookies found.");
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(reger.PersistentLogin.cookieName)){
                        //reger.core.Util.logtodb("UserSession - persistent cookie found.");
                        int accountuseridFromCookie = reger.PersistentLogin.checkPersistentLogin(cookies[i]);
                        if (accountuseridFromCookie>-1){
                            accountuser = new reger.Accountuser(accountid);
                            accountuser.forceLogin(accountuseridFromCookie);
                        }
                    }
                }
            }
        }
    }


    /**
     * A new request is being made so I need to update the mostRecentActivity var and make sure this is the same site, etc.
     */
    public void processNewRequest(javax.servlet.http.HttpServletRequest request){
        //Update the last touched date
        this.mostRecentActivity = Calendar.getInstance();

        //Parse the heck out of that URL... yeah, yeah, yeah!
        UrlSplitter urlSplitter = new UrlSplitter(request);

        //If we're seeing a new url scheme, refresh the objects in the session
        if (this.urlSplitter==null || (!urlSplitter.getServername().equals(this.urlSplitter.getServername()) || !urlSplitter.getVirtualdir().equals(this.urlSplitter.getVirtualdir()) || !urlSplitter.getScheme().equals(this.urlSplitter.getScheme()) || !String.valueOf(urlSplitter.getPort()).equals(String.valueOf(this.urlSplitter.getPort())))) {
            Debug.debug(5, "", "Refresh of UserSession object triggered.");
            Debug.debug(5, "", "UserSession.processNewRequest() - after urlSplitter. <br>urlSplitter.getRawIncomingServername()=" + urlSplitter.getRawIncomingServername() + "<br>urlSplitter.getServername()=" + urlSplitter.getServername() + "<br>urlSplitter.getVirtualdir()=" + urlSplitter.getVirtualdir() + "<br>urlSplitter.getSiterooturl()=" + urlSplitter.getSiterooturl());

            //Set the new urlSplitter to be the one for the session
            this.urlSplitter = urlSplitter;
            //Find the account using the URL Splitter
            this.accountid = reger.cache.UrlToAccountidLookupCache.get(urlSplitter);
            this.account=null;
            if (accountid>0){
                if (getAccount().getPlid()>0){
                    this.plid = getAccount().getPlid();
                }
            } else {
                //Find the private label using the URL Splitter
                this.plid = reger.PrivateLabel.findPlid(urlSplitter);
            }

            //If we still don't have a private label, use the default one
            if (this.plid<0){
                this.plid = reger.Vars.PLIDDEFAULT;
            }
            //Make sure we have an accountuser, even if empty
            if (accountuser==null){
                if (accountid>0){
                    accountuser = new reger.Accountuser(accountid);
                } else {
                    accountuser = new reger.Accountuser(-1);
                }
            }
        }
    }

    public String getUrlWithPortSmartlyAttached(String inUrl){
        String outUrl = inUrl;
        reger.core.Debug.debug(5, "UserSession.java", "inUrl = " + inUrl);
        try{
            //Parse the incoming URL
            java.net.URL urlParsed = new java.net.URL(inUrl);
            reger.core.Debug.debug(5, "UserSession.java", "urlParsed.toString() = " + urlParsed.toString() + "<br>urlParsed.getProtocol() = "+urlParsed.getProtocol()+"<br>getUrlSplitter().getPort() = "+getUrlSplitter().getPort());

            //Now create a new version of the URL, manually controlling the port num, scheme
            int port = getUrlSplitter().getPort();
            String forceportStr = AllSystemProperties.getProp("FORCEPORT");
            if (Util.isinteger(forceportStr)){
                port = Integer.parseInt(forceportStr);
            }
            java.net.URL urlPortControlled = new java.net.URL(getUrlSplitter().getScheme(), urlParsed.getHost(), urlParsed.getFile());
            if (port!=80){
                urlPortControlled = new java.net.URL(getUrlSplitter().getScheme(), urlParsed.getHost(), port, urlParsed.getFile());
            }
            //Now get the output
            outUrl = urlPortControlled.toString();
        } catch (Exception ex){
            reger.core.Debug.debug(5, "UserSession.java", ex);
        }
        reger.core.Debug.debug(5, "UserSession.java", "outUrl = " + outUrl);
        return outUrl;
    }



    public void setAttribute(String attributename, Object obj){
        try{
            attributes.put(attributename, obj);
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "UserSession.java");
        }
    }

    public Object getAttribute(String attributename){
        return attributes.get(attributename);
    }

    public void removeAttribute(String attributename){
        attributes.remove(attributename);
    }

    public void removeAllAttributes(){
        attributes = new HashMap();
    }

    /**
     * Once logged-in, set the accountuser using this method
     */
    public void setAccountuser(reger.Accountuser au){
        this.accountuser = au;
    }

    public void setMostRecentActivity(Calendar date){
        this.mostRecentActivity = date;
    }

    public void setMostRecentActivityToNow(){
        this.mostRecentActivity = Calendar.getInstance();
    }

    public Calendar getMostRecentActivity() {
        return mostRecentActivity;
    }

    public Account getAccount() {
        if (account==null){
            account = reger.cache.AccountCache.get(accountid);
        }
        return account;
    }

    public Accountuser getAccountuser() {
        return accountuser;
    }

    public PrivateLabel getPl() {
        return reger.AllPrivateLabelsInSystem.getPrivateLabel(this.plid);
    }

    public UrlSplitter getUrlSplitter() {
        return urlSplitter;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}
