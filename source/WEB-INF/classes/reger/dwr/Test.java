package reger.dwr;
import uk.ltd.getahead.dwr.ExecutionContext;

import javax.servlet.http.HttpServletRequest;

import reger.UserSession;

/**
 * Remoting test class
 */
public class Test {

    private int count = 0;
    private UserSession userSession;

    public Test(){
        HttpServletRequest request = ExecutionContext.get().getHttpServletRequest();
        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        userSession = allUserSessions.getUserSession(request, null);
    }

    public int add(){
        count++;
        return count;
    }

    public int getAccountid(){
        if (userSession!=null){
            return userSession.getAccount().getAccountid();
        }
        return 0;
    }

    public boolean getIsloggedin(){
        if (userSession!=null){
            return userSession.getAccountuser().getIsLoggedIn();
        }
        return false;
    }

    public String getPlbasedomain(){
        return userSession.getPl().getPlbasedomain();
    }

}
