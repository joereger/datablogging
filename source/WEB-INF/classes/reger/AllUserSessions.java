package reger;

import reger.core.Debug;
import reger.cache.jcs.UserSessionCache;

import javax.servlet.http.Cookie;
import java.util.*;

/**
 * This class holds all user sessions that are active on the web system.
 */
public class AllUserSessions {

//    private static Map userSessions;
//    private static int sessionTimeoutInMinutes = 20;

    public AllUserSessions(){

    }

    public static void flushSessions(){
//        userSessions=null;
        UserSessionCache usc = UserSessionCache.getInstance();
        usc.flushUserSessions();

    }

    private void addSession(String userSessionId, reger.UserSession userSession){
//        if (userSessions==null){
//            userSessions = Collections.synchronizedMap(new HashMap());
//        }
//        userSessions.put(userSessionId, userSession);
//        //logListOfUserSessionsToDb();

        UserSessionCache usc = UserSessionCache.getInstance();
        usc.putUserSession(userSessionId, userSession);



    }

    public void removeSession(String userSessionId){
//        if (userSessions.containsKey(userSessionId)){
//            userSessions.remove(userSessionId);
//        }

        UserSessionCache usc = UserSessionCache.getInstance();
        usc.removeUserSession(userSessionId);

    }

    public static int numberOfSessionsCurrentlyLive(){
//        int numberOfSessions = 0;
//        if (userSessions!=null){
//            numberOfSessions = userSessions.size();
//        }
//        return numberOfSessions;
        return 0;
    }



    public UserSession getUserSession(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        //Get the id from the cookie
        String userSessionId = "";
        if (request.getCookies()!=null){
            userSessionId = reger.core.Util.getCookieValue(request.getCookies(), "userSessionId", "");
        }
        //If we have an id, work with it
        if (!userSessionId.equals("")){
            reger.core.Debug.debug(4, "AllUserSessions.java", "AllUserSessions.getUserSession() - userSessionId=" + userSessionId);
            reger.UserSession us = getUserSession(userSessionId);
            if (us!=null){
                reger.core.Debug.debug(4, "AllUserSessions.java", "AllUserSessions.getUserSession() - found a userSession");
                us.processNewRequest(request);
                return us;
            }
        } else {
            //One last try to find the session based on jsessionid
            //Note that this assumes I'm keying my own session scheme off of Tomcat's jsessionid
            reger.core.Debug.debug(5, "AllUserSessions.java", "userSessionId was blank so trying to use sessionid.");
            reger.UserSession us = getUserSession(request.getSession().getId());
            if (us!=null){
                us.processNewRequest(request);
                return us;
            }
        }
        reger.core.Debug.debug(5, "AllUseressions.java", "AllUserSessions.getUserSession() - Existing session not found.  Will create a new session.");
        //Create a new session
        reger.UserSession us = new reger.UserSession(request);
        //Add the session to the session hashtable
        addSession(request.getSession().getId(), us);

        //Get all possible cookies to set
        Cookie[] cookies = getCookies(request, us);
        //Add a cookies to the response
        if (response!=null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                response.addCookie(cookies[i]);
            }
        }

        return us;
    }

    public int expireSessions(){
//        int numberOfSessionsExpired = 0;
//        //reger.core.Util.logtodb("Start Expire-----------");
//        //logListOfUserSessionsToDb();
//        if (userSessions!=null){
//            synchronized(userSessions){
//                for (Iterator i=userSessions.entrySet().iterator(); i.hasNext(); ) {
//                    Map.Entry e = (Map.Entry) i.next();
//                    // retrieve the object_key
//                    String object_key = (String)e.getKey();
//                    // retrieve the object associated with the key
//                    reger.UserSession us = (reger.UserSession)e.getValue();
//                    //Get the last active date
//                    Calendar lastActive = us.getMostRecentActivity();
//                    Calendar now = Calendar.getInstance();
//                    //@todo Make session timeout configurable in context.xml
//                    //String c1 = reger.core.TimeUtils.dateformatcompactwithtime(lastActive);
//                    //String c2 = reger.core.TimeUtils.dateformatcompactwithtime(now);
//                    //reger.core.Util.logtodb("AllUserSessions.expireSessions()<br>cal1=" + c1 + "<br>cal2=" + c2 + "<br>diff= " + reger.core.DateDiff.DateDiff("minute", lastActive, now));
//                    if (reger.core.DateDiff.dateDiff("minute", now, lastActive)>sessionTimeoutInMinutes){
//                        //userSessions.remove(object_key);
//                        i.remove();
//                        numberOfSessionsExpired = numberOfSessionsExpired + 1;
//                        //reger.core.Util.logtodb("Session expired.  key: " + object_key);
//                    }
//                }
//            }
//        }
//        //reger.core.Util.logtodb("End Expire-----------");
//        //logListOfUserSessionsToDb();
//        return numberOfSessionsExpired;
        return 0;
    }

    private UserSession getUserSession(String userSessionId){
//        if (!userSessionId.equals("")){
//            if (userSessions!=null){
//                return (UserSession)userSessions.get(userSessionId);
//            }
//
//        }
//        return null;

        UserSessionCache usc = UserSessionCache.getInstance();
        return usc.getUserSession(userSessionId);

    }

    private Cookie[] getCookies(javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        Cookie[] outCookies = new Cookie[1];
        //Create a cookie with no domain specified
        outCookies[0] = createNewCookie(request, "");
        //Iterate all possible domains
        String[] domains =  userSession.getUrlSplitter().getServernameAllPossibleDomains();
        for (int i = 0; i < domains.length; i++) {
            outCookies = reger.core.Util.addToCookieArray(outCookies, createNewCookie(request, domains[i]));
        }
        return outCookies;
    }

    private Cookie createNewCookie(javax.servlet.http.HttpServletRequest request, String domainNameToSetOn){
        String userSessionId = request.getSession().getId();
        Cookie userCookie = new Cookie("userSessionId", userSessionId);
        userCookie.setMaxAge(-1);
        if (!domainNameToSetOn.equals("")){
            userCookie.setDomain("."+domainNameToSetOn);
            Debug.debug(5, "", "AllUserSessions.java - Creating cookie.<br>userSessionId=" + userSessionId + "<br>domainNameToSetOn=" + domainNameToSetOn);
        } else {
            Debug.debug(5, "", "AllUserSessions.java - Creating cookie.<br>userSessionId=" + userSessionId + "<br>No Domain Set.");
        }
        userCookie.setPath("/");
        if (reger.systemproperties.AllSystemProperties.getProp("SSLISON").equals("1")){
            userCookie.setSecure(true);
        }
        return userCookie;
    }

    private void logListOfUserSessionsToDb(){
//        StringBuffer mb = new StringBuffer();
//        mb.append("AllUserSessions.userSessions<br>");
//        if (userSessions!=null){
//            synchronized(userSessions){
//                for (Iterator i=userSessions.entrySet().iterator(); i.hasNext(); ) {
//                    Map.Entry e = (Map.Entry) i.next();
//                    // retrieve the object_key
//                    String object_key = (String)e.getKey();
//                    // retrieve the object associated with the key
//                    reger.UserSession us = (reger.UserSession)e.getValue();
//                    mb.append("<br>=============<br>userSessionId=" + object_key);
//                    if (us.getAccount()!=null){
//                        mb.append("<br>accountid=" + us.getAccount().getAccountid());
//                    } else {
//                        mb.append("<br>accountid=NULL");
//                    }
//                    mb.append("<br>us.getAccountuser().getAccountuserid()=" + us.getAccountuser().getAccountuserid());
//                    mb.append("<br>us.getPl().getPlid()=" + us.getPl().getPlid() + "<br>========");
//                }
//            }
//        }
//        Debug.logtodb(mb.toString(), "");
    }

    public static Map getUserSessions() {
//        return userSessions;
        return null;
    }

}
