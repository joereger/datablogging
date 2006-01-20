package reger.pageFramework;

import reger.UserSession;
import reger.emailtext.BasicEmails;
import reger.licensing.ServerLicense;
import reger.core.db.DbConfig;
import reger.core.WebAppRootDir;
import reger.core.ContextName;
import reger.core.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Big Kahuna which wraps all pages displayed by site
 */
public class GlobalHeader {

    public static void get(HttpServletRequest request, HttpServletResponse response, javax.servlet.jsp.JspWriter out, PageProps pageProps, UserSession userSession){
        try{

            //Get the webapp root
            if (WebAppRootDir.getWebAppRootPath()==null){
                new WebAppRootDir(request);
            }

            //Get the context name
            if (ContextName.getContextName()==null){
                new ContextName(request);
            }

            //Make sure server license allows this version of the app
            if (!ServerLicense.licenseAllowsCurrentApplicationVersion()){
                response.sendRedirect(pageProps.pathToAppRoot + "error/invalidappversion.jsp");
                return;
            }

            //Make sure we have a valid db connection
            if (!DbConfig.haveValidConfig()){
                response.sendRedirect(pageProps.pathToAppRoot + "setup/setup-00.log");
                return;
            }

            //Make sure we have the correct database version
            if (!reger.core.dbupgrade.RequiredDatabaseVersion.havecorrectversion){
                response.sendRedirect(pageProps.pathToAppRoot + "error/invaliddbversion.jsp");
                return;
            }


            //Write request to DB
            if (reger.core.DegubLevel.getDebugLevel()>=5){
                Debug.debug(5, "GlobalHeader", reger.core.ErrorDissect.ServletUtilsdissect(request));
            }

            //If privatelabel requires login and this is a login-worthy page, redirect to the login page.
            if(userSession.getPl().getForcelogintoviewsites()){
                if (pageProps.siteSection!=pageProps.MARKETINGSITE && pageProps.siteSection!=pageProps.API){
                    //If the account is null we know that we have a private label homepage.  Only an issue when user goes to main publicsite index.log but there's no account.
                    if ((userSession.getAccount()==null || userSession.getAccount().getAccountid()==0) && pageProps.siteSection==pageProps.PUBLICSITE){
                        Debug.debug(5, "GlobalHeader", "globalheader.jsp - redirecting to a private label homepage inside of the forced login code.");
                        response.sendRedirect(request.getScheme()+"://"+userSession.getPl().getPlBaseUrl()+"/about/index.log");
                        return;
                    }

                    //If the user isn't logged in
                    //if ((userSession.getAccountuser()==null || userSession.getAccount().getAccountid()==0) || !userSession.getAccountuser().isLoggedIn) {
                    if ((userSession.getAccountuser()==null) || !userSession.getAccountuser().isLoggedIn) {
                        Debug.debug(5, "GlobalHeader", "globalheader.jsp - redirecting to force a login because the user is not logged in.");
                        response.sendRedirect(request.getScheme()+"://"+userSession.getPl().getPlBaseUrl()+"/about/login.log?returnurl=" + java.net.URLEncoder.encode(request.getRequestURL()+"?"+request.getQueryString(), "UTF-8"));
                        return;
                    }
                }
            }



            //Deal with HTTP/HTTPS
            //First, figure out which protocol is being used a
            //reger.core.Util.logtodb("++++++++++New Page: " + request.getServerName() + request.getContextPath() + request.getServletPath());
            pageProps.isCurrentRequestSSL = pageProps.isRequestSSL(request);
            //reger.core.Util.logtodb("Successfully determined isCurrentRequestSSL:" + pageProps.isCurrentRequestSSL + "<br>getProtocol()=" + request.getProtocol());
            //Next, if the page requires SSL but it isn't SSL and SSL is on for this instance we need to do a redirect
            if (!request.isSecure() && reger.systemproperties.AllSystemProperties.getProp("SSLISON").equals("1")){
                //Redirect to https
                try {
                    //reger.core.Util.logtodb(reger.core.ErrorDissect.ServletUtilsdissect(request));
                    String qs = "";
                    if (request.getQueryString()!=null){
                        qs = "?" + request.getQueryString();
                    }
                    //response.sendRedirect("https://" + request.getServerName() + request.getContextPath() + request.getServletPath() + qs);
                    String URL = request.getRequestURL().toString();
                    if(URL.substring(0,7).equals("http://")){
                        URL = "https://" + URL.substring(7, URL.length());
                    } else {
                        Debug.logtodb("globalheader.jsp - Somebody accessed an https:// site via a protocol other than http:// or https://.  The URL is: " + URL, "");
                    }
                    //Append the  querystring
                    URL = URL + qs;
                    //Do the redirect
                    Debug.debug(5, "GlobalHeader", "Redirecting to URL for https: "+URL);
                    response.sendRedirect(URL);
                    return;
                } catch (Exception e){
                    //reger.core.Util.errorsave(e);
                }
                //out.println("<br>You must access this site via secure https://.");
                return;
            }
            //reger.core.Util.logtodb("Past https block.");




            //If it's an Admin or a Public site, we need an account
            if (pageProps.siteSection==pageProps.PUBLICSITE || pageProps.siteSection==pageProps.ADMINSITE){
                //If the account object is null
                if (userSession.getAccount()==null || userSession.getAccount().getAccountid()==0) {
                    try {
                        Debug.debug(5, "GlobalHeader", "Redirecting to marketing site "+userSession.getPl().getPlBaseUrl()+" because it's a public or admin but we don't have an account.");
                        response.sendRedirect(userSession.getPl().getPlBaseUrl() + "/about/index.log");
                        return;
                    } catch (Exception e){
                        Debug.errorsave(e, "GlobalHeader");
                    }
                    //out.println("<br>This is not a valid site.  Please try again.");
                    return;
                } else {
                    //If it's a valid account but it's not active then we need to tell the user what's up
                    if (!userSession.getAccount().getIsActiveAccount()){
                        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccount().getIsNewPendingAdminApproval()){
                            response.sendRedirect(userSession.getPl().getPlBaseUrl() + "/about/login-awaitingapproval.log?accountid="+userSession.getAccount().getAccountid());
                            return;
                        } else {
                            response.sendRedirect(userSession.getPl().getPlBaseUrl() + "/about/login-sitenotactive.log?accountid="+userSession.getAccount().getAccountid());
                            return;
                        }
                    }
                    //Make sure this account has enough free bandwidth to be serving pages
                    Debug.debug(5, "GlobalHeader", "globalheader.log<br>userSession.getAccount().getBandwidthused()=" + String.valueOf(new Long(userSession.getAccount().getBandwidthused())) + "<br>userSession.getAccount().getMaxbandwidth()=" + String.valueOf(new Long(userSession.getAccount().getMaxbandwidth())));
                    if (userSession.getAccount().getMaxbandwidth()>0 && userSession.getAccount().getBandwidthused()>userSession.getAccount().getMaxbandwidth() && pageProps.siteSection==pageProps.PUBLICSITE && (pageProps.adminSection==null || !pageProps.adminSection.equals("LOGIN"))){
                        try {
                            response.sendRedirect(pageProps.pathToAppRoot + "notenoughbandwidthavailable.log");
                            return;
                        } catch (Exception e){
                            Debug.errorsave(e, "GlobalHeader");
                        }
                        //out.println("<br>This account has exceeded its available bandwidth for this month.");
                        return;
                    }
                }
            }
            
            //If this is not a marketing page or an LOE page and we don't have a valid account, redirect to the pl
            if (pageProps.siteSection!=pageProps.API && pageProps.siteSection!=pageProps.MARKETINGSITE && pageProps.siteSection!=pageProps.MARKETINGSITEWITHUSERCONTENT && pageProps.siteSection!=pageProps.GROUPSSITE && pageProps.siteSection!=pageProps.MASTERADMINSITE && pageProps.siteSection!=pageProps.PLADMINSITE && (userSession.getAccount()==null || userSession.getAccount().getAccountid()==0)){
                try {
                    Debug.debug(5, "GlobalHeader", "Bounced to /about/index.log 1.");
                    response.sendRedirect(userSession.getPl().getPlBaseUrl() + "/about/index.log");
                    return;
                } catch (Exception e) {
                    Debug.errorsave(e, "GlobalHeader");
                    return;
                }
            }




            //Populate the pageProps object
            pageProps.populate(request, userSession);


            //QuickPass Login
            //If the parameter qpass=XXXX comes across the wire, URL or form, do a quick login.
            //Only works if the user isn't already logged-in
            if (userSession.getAccountuser()!=null && !userSession.getAccountuser().getIsLoggedIn()){
                if (request.getParameter("qpass")!=null && !request.getParameter("qpass").equals("")){
                    userSession.getAccountuser().quickLogLogin(request.getParameter("qpass"), userSession.getAccount().getAccountid());
                }
            }


            //Mobile login
            if ((pageProps.siteSection==pageProps.MOBILEPRIVATE || pageProps.siteSection==pageProps.MOBILEPUBLIC)){
                Debug.debug(5, "GlobalHeader", "Begin servicing a mobile request. pageProps.siteSection=" + pageProps.siteSection);
                if (request.getHeader("x-up-subno")!=null){
                    Debug.debug(5, "GlobalHeader", "Found x-up-subno for mobile.");
                    userSession.setAccountuser(new reger.Accountuser(request.getHeader("x-up-subno")));
                } else {
                    Debug.debug(5, "GlobalHeader", "No x-up-subno found.");
                    if (pageProps.siteSection==pageProps.MOBILEPRIVATE){
                        Debug.debug(5, "GlobalHeader", "Redirecting mobile user to phone not supported page.");
                        response.sendRedirect("mobilephonenotsupported.log");
                        return;
                    }
                }
                Debug.debug(5, "GlobalHeader", "Mobile User isLoggedIn=" + userSession.getAccountuser().isLoggedIn);
                if (pageProps.siteSection==pageProps.MOBILEPRIVATE && !userSession.getAccountuser().isLoggedIn){
                    Debug.debug(5, "GlobalHeader", "Redirecting mobile user to mobile login page.");
                    response.sendRedirect("mobilelogin.log");
                    return;
                }
            }


            //Make sure the user is allowed to use this ACL object
            //reger.core.Util.logtodb("acl:" + pageProps.aclObjectName + "<br>userSession.getAccountuser().userCanDoAcl(pageProps.aclObjectName, userSession.getAccount().getAccountid())" + userSession.getAccountuser().userCanDoAcl(pageProps.aclObjectName, userSession.getAccount().getAccountid()));
            if ((pageProps.isPasswordProtected) && (!userSession.getAccountuser().userCanDoAcl(pageProps.aclObjectName, userSession.getAccount().getAccountid()))){
                Debug.debug(5, "GlobalHeader", "Bounced to /login.log because user can't do acl.");
                response.sendRedirect(pageProps.pathToAppRoot + "login.log");
                return;
            }


            //Make sure we have the enough logid and/or eventid's to build the page
            boolean passedvalidation=true;
            if (pageProps.isLogidRequired || pageProps.isEventidRequired) {
                //Immediately assume that we've failed validation and make the data prove its correct
                passedvalidation=false;

                //Now do the validation
                //We look at logProps because it does actual database validation to make sure this is a valid logid or eventid for this user
                if (pageProps.isLogidRequired && pageProps.logProps.logid!=-1) {
                    passedvalidation=true;
                }

                if (pageProps.isEventidRequired && pageProps.entry.eventid!=-1) {
                    passedvalidation=true;
                }

                if (!passedvalidation) {
                    //reger.core.Util.logtodb("No logid or eventid found on the page.");
                    try {
                        Debug.debug(5, "GlobalHeader", "Bounced to /login.log because pageProps.passedvalidation=FALSE.");
                        response.sendRedirect("index.log?msg=invalid");
                        return;
                    } catch (Exception e){
                        Debug.errorsave(e, "GlobalHeader");
                    }
                    //out.println("<br>We're sorry.  That log and/or entry could not be found or you don't have permission to view it.  Please try again. Error: 9998");
                    Debug.debug(5, "GlobalHeaderGlobalHeader", "GlobalHeader.java failed.  Error 9998.  Looks like user didn't have enough logid's and/or eventid's to get in.");
                    //out.println(reger.debugInfo.monsterDebug(request, pageProps));
                    return;
                }
            }


            //If  a logid is required, make sure that the user can view or administer that logid
            if (pageProps.isLogidRequired && ((pageProps.siteSection==pageProps.PUBLICSITE && !userSession.getAccountuser().userCanViewLog(pageProps.logProps.logid)) || (pageProps.siteSection==pageProps.ADMINSITE && !userSession.getAccountuser().userCanViewLog(pageProps.logProps.logid)))){
                //If there's an entrykey
                if (request.getParameter("entrykey")!=null){
                    //If entrykey doesn't work for eventid
                    int tmpEventid=pageProps.entry.eventid;
                    if(request.getParameter("eventid")!=null && reger.core.Util.isinteger(request.getParameter("eventid"))){
                        tmpEventid = Integer.parseInt(request.getParameter("eventid"));
                    }
                    if (!reger.Entry.checkEntryKey(request.getParameter("entrykey"), tmpEventid)){
                        //Then send to permission denied
                        Debug.debug(3, "GlobalHeader", "globalheader.jsp - sending to permissiondenied.log because entrykey fails");
                        response.sendRedirect(pageProps.pathToAppRoot + "permissiondenied.log");
                        return;
                    }
                } else {
                    //There's no entry key so send to permission denied
                    Debug.debug(3, "GlobalHeader", "globalheader.jsp - sending to permissiondenied.log because no entry key");
                    response.sendRedirect(pageProps.pathToAppRoot + "permissiondenied.log");
                    return;
                }

            }


            //If it's an Admin site, user must be activated by email
            if (pageProps.siteSection==pageProps.ADMINSITE){
                if (userSession.getAccountuser()==null || !userSession.getAccountuser().isIsactivatedbyemail()){
                    try{
                        BasicEmails.newAccountEmailVerificationMessage(userSession.getAccountuser(), userSession.getAccountuser().getAccountid(), userSession.getPl(), "");
                    } catch (EmailSendException e){
                        reger.core.Debug.debug(3, "GlobalHeader.java", "Error sending email on activation redirect: " + e.getErrorsAsSingleString());
                    } catch(Exception ex){
                        reger.core.Debug.errorsave(ex, "GlobalHeader.java");
                    }
                    userSession.getAccountuser().userLogout();
                    Debug.debug(3, "GlobalHeader", "globalheader.jsp - sending to login-awaitingactivation.log");
                    response.sendRedirect(pageProps.pathToAppRoot + "about/login-awaitingactivation.log");
                    return;
                }
            }

        } catch (java.io.IOException ioex){
            Debug.errorsave(ioex, "GlobalHeader", "Error in GlobalHeader.java");
        }

    }


}
