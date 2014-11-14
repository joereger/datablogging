package reger;

import reger.core.db.Db;
import reger.core.Debug;

import javax.servlet.http.Cookie;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Handles functions regarding persistent login via a browser cookie.
 * The cookie should consist of the user�s username, followed by a
 * separator character (-), followed by some large random number.
 * The server keeps a table of number->username associations, which is
 * looked up to verify the validity of the cookie. If the cookie supplies
 * a random number and username that are mapped to each other in the table,
 * the login is accepted.
 * At any time, a username may be mapped to several such numbers,
 * due to login at multiple browsers.
 * Also, while incredibly unlikely, it does not matter if two usernames
 * are mapped to the same random number.  They will not interfere.
 *
 */
public class PersistentLogin {

    public static int daysToKeepPersistentRecordWithoutLogin = 365;
    public static String cookieName = "keepmeloggedin";


    public static int checkPersistentLogin(javax.servlet.http.Cookie cookie){

        if (cookie!=null && cookie.getName().equals(cookieName)){

            //Split the value on the dash and get the accountid
            String value = cookie.getValue();
            String[] split = value.split("-", 2);
            if (split!=null && split.length>1){
                String firstVal = split[0];
                String secondVal = split[1];
                if (reger.core.Util.isinteger(firstVal)){
                    //Let's see if we have a valid login
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstPersistentLogin= Db.RunSQL("SELECT accountuserpersistentloginid, accountuserid FROM accountuserpersistentlogin WHERE accountuserid='"+firstVal+"' AND randomstring='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(secondVal, 254))+"'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstPersistentLogin!=null && rstPersistentLogin.length>0){
                        for(int i=0; i<rstPersistentLogin.length; i++){
                            //We have a match.  Record the latest accessed date.
                            //-----------------------------------
                            //-----------------------------------
                            int count = Db.RunSQLUpdate("UPDATE accountuserpersistentlogin SET lastusedtologin='"+reger.core.TimeUtils.nowInGmtString()+"' WHERE accountuserpersistentloginid='"+rstPersistentLogin[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                            return Integer.parseInt(rstPersistentLogin[i][1]);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static Cookie[] getPersistentCookies(int accountuserid, javax.servlet.http.HttpServletRequest request){
        //Create the domain
        reger.UrlSplitter urlSplitter = new reger.UrlSplitter(request);
        Cookie[] outCookies = new Cookie[1];
        //Create a cookie with no domain specified
        outCookies[0] = createPersistentCookie(accountuserid, request, "");
        //Iterate all possible domains
        ArrayList<String> domains =  urlSplitter.getServernameAllPossibleDomains();
        for (Iterator it = domains.iterator(); it.hasNext(); ) {
            String domain = (String)it.next();
            outCookies = reger.core.Util.addToCookieArray(outCookies, createPersistentCookie(accountuserid, request, domain));
        }
        return outCookies;
    }

    public static Cookie createPersistentCookie(int accountuserid, javax.servlet.http.HttpServletRequest request, String domainToSetCookieOn){
        String randomString = reger.core.Util.truncateString(request.getSession().getId(), 240);

        Cookie userCookie = new Cookie(cookieName, accountuserid+"-"+randomString);
        userCookie.setMaxAge(31536000);  //One Year
        if (!domainToSetCookieOn.equals("")){
            userCookie.setDomain("."+domainToSetCookieOn);
        }
        if (reger.systemprops.AllSystemProperties.getProp("SSLISON").equals("1")){
            userCookie.setSecure(true);
        }
        userCookie.setPath("/");
        Debug.debug(5, "", "PersistentLogin.java - Creating cookie.<br>value=" + randomString + "<br>domainToSetCookieOn=" + domainToSetCookieOn);

        //Store this persistent cookie to the database
        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO accountuserpersistentlogin(accountuserid, randomstring, lastusedtologin) VALUES('"+accountuserid+"', '"+reger.core.Util.cleanForSQL(randomString)+"', '"+reger.core.TimeUtils.nowInGmtString()+"')");
        //-----------------------------------
        //-----------------------------------

        return userCookie;
    }

    public static Cookie createCookieToClearPersistentLogin(javax.servlet.http.HttpServletRequest request){
        Cookie userCookie = new Cookie(cookieName, " ");
        userCookie.setMaxAge(0);  //Delete Cookie
        userCookie.setPath("/");
        if (reger.systemprops.AllSystemProperties.getProp("SSLISON").equals("")){
            userCookie.setSecure(true);
        }

        //Now, delete the database record
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0){
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i]!=null && cookies[i].getName().equals(cookieName)){
                    //Split the value on the dash and get the accountid
                    String value = cookies[i].getValue();
                    String[] split = value.split("-", 2);
                    if (split!=null && split.length>1){
                        String firstVal = split[0];
                        String secondVal = split[1];
                        if (reger.core.Util.isinteger(firstVal)){
                            //Let's see if we have a valid login
                            //-----------------------------------
                            //-----------------------------------
                            String[][] rstPersistentLogin= Db.RunSQL("SELECT accountuserpersistentloginid, accountuserid FROM accountuserpersistentlogin WHERE accountuserid='"+firstVal+"' AND randomstring='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(secondVal, 254))+"'");
                            //-----------------------------------
                            //-----------------------------------
                            if (rstPersistentLogin!=null && rstPersistentLogin.length>0){
                                for(int j=0; j<rstPersistentLogin.length; j++){
                                    //We have a match.  Record the latest accessed date.
                                    //-----------------------------------
                                    //-----------------------------------
                                    int count = Db.RunSQLUpdate("DELETE FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+rstPersistentLogin[j][0]+"'");
                                    //-----------------------------------
                                    //-----------------------------------
                                }
                            }
                        }
                    }
                }
            }


        }

        return userCookie;
    }

    public static int deleteOldPersistentLogins(){
        int numberDeleted = 0;

        Calendar now = reger.core.TimeUtils.nowInGmtCalendar();

        //-----------------------------------
        //-----------------------------------
        String[][] rstPers= Db.RunSQL("SELECT accountuserpersistentloginid, lastusedtologin FROM accountuserpersistentlogin");
        //-----------------------------------
        //-----------------------------------
        if (rstPers!=null && rstPers.length>0){
            for(int i=0; i<rstPers.length; i++){
                //Get the last active date
                Calendar lastActive = reger.core.TimeUtils.dbstringtocalendar(rstPers[i][1]);

                if (reger.core.DateDiff.dateDiff("day", now, lastActive)>daysToKeepPersistentRecordWithoutLogin){
                   //-----------------------------------
                   //-----------------------------------
                   int count = Db.RunSQLUpdate("DELETE FROM accountuserpersistentlogin WHERE accountuserpersistentloginid='"+rstPers[i][0]+"'");
                   //-----------------------------------
                   //-----------------------------------

                   numberDeleted=numberDeleted + 1;
                }
            }
        }

        return numberDeleted;
    }


}
