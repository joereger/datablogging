package reger.poll;

import javax.servlet.http.Cookie;

/**
 * Checks for revoting
 */
public class PollNoRevote {
    public static String POLLNOVOTECOOKIENAME = "pollsvotedon";

    public static boolean hasUserVotedBefore(int pollid, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        try{
            Cookie[] cookies = request.getCookies();
            if (cookies!=null && cookies.length>0){
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(POLLNOVOTECOOKIENAME)){
                        String cookievalue = cookies[i].getValue();
                        reger.core.Debug.debug(3, "PollNoRevote.java", "hasUserVotedBefore() cookievalue="+cookievalue);
                        String[] pollsvotedon = cookievalue.split("-");
                        if (pollsvotedon.length>0){
                            for (int j = 0; j < pollsvotedon.length; j++) {
                                String s = pollsvotedon[j];
                                reger.core.Debug.debug(3, "PollNoRevote.java", "hasUserVotedBefore() found a value in the cookie of: "+s);
                                if (s.equals(String.valueOf(pollid))){
                                    reger.core.Debug.debug(3, "PollNoRevote.java", "hasUserVotedBefore() returning true because s.equals(String.valueOf(pollid)="+s+".equals(String.valueOf("+pollid+"))");
                                    return true;
                                }
                            }
                        } else {
                            if (cookievalue.equals(String.valueOf(pollid))){
                                reger.core.Debug.debug(3, "PollNoRevote.java", "hasUserVotedBefore() returning true because cookievalue.equals(String.valueOf(pollid))="+cookievalue+".equals(String.valueOf("+pollid+"))");
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "PollNoRevote.java");
        }
        return false;
    }

    public static void markUserAsVoted(int pollid, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        try{
            String valuetoset = "";
            Cookie[] cookies = request.getCookies();
            if (cookies!=null && cookies.length>0){
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(POLLNOVOTECOOKIENAME)){
                        valuetoset = "";
                        String cookievalue = cookies[i].getValue();
                        reger.core.Debug.debug(3, "PollNoRevote.java", "markUserAsVoted() cookievalue="+cookievalue+"<br>using previously-created cookie");
                        String[] pollsvotedon = cookievalue.split("-");
                        if (pollsvotedon.length>0){
                            for (int j = 0; j < pollsvotedon.length; j++) {
                                String s = pollsvotedon[j];
                                reger.core.Debug.debug(3, "PollNoRevote.java", "markUserAsVoted() found existing value in cookie s="+s);
                                if (reger.core.Util.isinteger(s)){
                                    if (valuetoset.length()>0){
                                        valuetoset =  valuetoset + "-";
                                    }
                                    valuetoset =  valuetoset + s;
                                }
                            }
                        }

                        reger.core.Debug.debug(3, "PollNoRevote.java", "markUserAsVoted() finding valuetoset="+valuetoset+"<br>using previously-created cookie");
                    }
                }
            }
            if (valuetoset.length()>0){
                valuetoset =  valuetoset + "-";
            }
            valuetoset =  valuetoset + pollid;
            reger.core.Debug.debug(3, "PollNoRevote.java", "markUserAsVoted() setting final cookievalue="+valuetoset+"<br>using new cookie");
            Cookie cookieToSet = new Cookie(POLLNOVOTECOOKIENAME, valuetoset);
            cookieToSet.setMaxAge(-1);
            cookieToSet.setPath("/");
            response.addCookie(cookieToSet);
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "PollNoRevote.java");
        }
    }

}
