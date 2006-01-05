package reger;

import reger.core.Debug;
import reger.cache.jboss.UserSessionCache;

import javax.servlet.http.Cookie;
import java.util.*;

/**
 * This class holds all user sessions that are active on the web system...
 * actually, it doesn't... it acts as a front for the cache.
 *
 * Sessions themselves are stored in the session cache.
 */
public class AllUserSessions {

    public AllUserSessions(){

    }

    public static void flushSessions(){
        //UserSessionCache usc = UserSessionCache.getInstance();
        UserSessionCache.flushUserSessions();

    }

    private void addSession(String userSessionId, reger.UserSession userSession){
        //UserSessionCache usc = UserSessionCache.getInstance();
        UserSessionCache.putUserSession(userSessionId, userSession);
    }

    public void removeSession(String userSessionId){
        //UserSessionCache usc = UserSessionCache.getInstance();
        UserSessionCache.removeUserSession(userSessionId);
    }

    public static int numberOfSessionsCurrentlyLive(){
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
        return 0;
    }

    private UserSession getUserSession(String userSessionId){
        //UserSessionCache usc = UserSessionCache.getInstance();
        return UserSessionCache.getUserSession(userSessionId);
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



    public static Map getUserSessions() {
        return null;
    }

}
