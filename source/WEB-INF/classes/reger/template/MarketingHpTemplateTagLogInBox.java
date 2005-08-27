package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 *
 */
public class MarketingHpTemplateTagLogInBox implements MarketingHpTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "LogInBox";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Box where users can log in.  If they're logged-in they are able to log out.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @return
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps){

        StringBuffer mb = new StringBuffer();

        String loginerrortext = "";

        //Get any returnurl
        String returnurl = "";
        if (request.getParameter("returnurl")!=null){
            returnurl = request.getParameter("returnurl");
        }

        //Login Action
        if (pageProps.action.equals("login")){
            userSession.setAccountuser(new reger.Accountuser(request.getParameter("username"), request.getParameter("password")));
            if (userSession.getAccountuser().isLoggedIn){
                //response.sendRedirect("" + reger.Vars.getHttpUrlPrefix() + userSession.getAccountuser().getSiteRootUrl() + "/login.log?action=login&username="+userSession.getAccountuser().getUsername()+"&password="+request.getParameter("password")+"&keepmeloggedin="+request.getParameter("keepmeloggedin")+"&returnurl=" + returnurl);
            } else {
                loginerrortext = loginerrortext + "Username or password incorrect.  Please try again.<br>";
            }
        }


        //Login
        mb.append("<font face=arial size=-1><b>Existing Users</b></font>");
        if (!loginerrortext.equals("")){
            mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEERROR, pageProps.pathToAppRoot, loginerrortext));
        }

        if (userSession.getAccountuser()==null || !userSession.getAccountuser().isLoggedIn){
            mb.append("<table>");
            mb.append("<form action=index.log method=post>");
            mb.append("<input type=hidden name=action value='login'>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-2>");
            mb.append("<strong>Username:</strong>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<input type=text name=username size=18 maxlength=50 style=\"font-size: 10px;\">");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-2>");
            mb.append("<strong>Password:</strong>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<input type=password name=password size=18 maxlength=50 style=\"font-size: 10px;\">");
            mb.append("<br>");
            mb.append("<font class=smallfont face=arial size=-2>");
            mb.append("<a href='"+pageProps.pathToAppRoot+"about/passwordreset1.log'>");
            mb.append("Lost Your Password?");
            mb.append("</a>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left>");
            mb.append("<input type='checkbox' name='keepmeloggedin' value='1'>");
            mb.append("<font class=smallfont face=arial size=-2>");
            mb.append("<strong>Stay Logged-In on this Computer Until I Log Out</strong>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td>");
            mb.append("<input type=submit value='Log In' style=\"font-size: 10px\">");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</form>");
            mb.append("</table>");
        } else {
            //User is logged-in
            String userSiteRootUrl = userSession.getAccountuser().getSiteRootUrl();
            mb.append("<table>");
            mb.append("<form action='"+reger.Vars.getHttpUrlPrefix()+userSiteRootUrl+"/login.log' method=post>");
            mb.append("<input type=hidden name=action value='logout'>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-2>");
            mb.append("<strong>You are currently logged in.</strong>");
            mb.append("<br>Links to your weblog and admin tools are at the top of the screen.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td>");
            mb.append("<input type=submit value='Log Out' style=\"font-size: 10px\">");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</form>");
            mb.append("</table>");
        }


        return mb.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview available.";
    }

}
