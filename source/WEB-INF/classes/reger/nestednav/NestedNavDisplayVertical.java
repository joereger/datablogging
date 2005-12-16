package reger.nestednav;

import reger.UserSession;
import reger.core.Debug;

/**
 * A vertical navbar
 */
public class NestedNavDisplayVertical implements NestedNavDisplay{

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        //Start the table
        Debug.debug(5, "", "NestedNavbarVertical.java - Navbar start.");
        mb.append("<!-- Start navigation--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>");

        //Home tab
        mb.append(homeTab(userSession, request));

        //Do the nested items
        mb.append(outputItemHtml(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), 0, userSession, request));

        //Login tab
        mb.append(loginTab(userSession, request));

        //End the table
        mb.append("</table><!-- End navigation -->");
        Debug.debug(5, "", "NestedNavbarVertical.java - Navbar end.");

        return mb.toString();
    }


    private String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "NestedNavbarVertical.java - Item output called.");

        String isOnText = "off";
        if (navItem.isActive(request)){
            isOnText = "on";
        }

        String nestingNbsp = "";
        for(int i=2; i<=currentNestedLevel; i++){
            nestingNbsp = nestingNbsp + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }

        int nestingPixels = 1;
        for(int i=2; i<=currentNestedLevel; i++){
            nestingPixels = nestingPixels + 15;
        }


        //@todo Multiple CSS Selectors?  i.e. navcellon is always applied, but can be overridden with navcell-level0-on

        //Output this item in html format
        if (navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){
            mb.append("<!-- Begin Tab -->");
            mb.append("<tr>");
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            if (1==2){
                mb.append("(order="+navItem.getNestedNavOrder()+")(level="+currentNestedLevel+")(id="+navItem.getThisNestedNavId()+")");
            }
            mb.append("<img src='images/clear.gif' border=0 width="+nestingPixels+" height=1>");
            mb.append("<a class=navfont" + isOnText + " href='"+navItem.getNestedNavLinkUrl()+"'>" + navItem.getNestedNavLinkText() + "</a>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End Tab -->");
        }

        //Go get children and append output from each of them.
        //This is the recursive function.
        NestedNavItem[] children = null;
        if (collection!=null && userSession!=null){
            children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());
        }
        if (children!=null){
            for (int i = 0; i < children.length; i++) {
                NestedNavItem childNavItem = children[i];
                mb.append(outputItemHtml(childNavItem, collection, currentNestedLevel+1, userSession, request));
            }
        }
        return mb.toString();
    }

    private String homeTab(UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String isOnText = "off";
        if (reger.core.Util.getJspName(request.getRequestURI()).equals("index.log")){
            isOnText = "on";
        }

        if (userSession.getAccount().getShowhometab()){
            String hometabtext = userSession.getAccount().getHometabtext();
            if (hometabtext.equals("")){
                hometabtext="Home";
            }
            mb.append("<!-- Begin Tab -->");
            mb.append("<tr>");
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            mb.append("<a class=navfont" + isOnText + " href='index.log'>" + hometabtext + "</a>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End Tab -->");
        }

        return mb.toString();
    }

    private String loginTab(UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String isOnText = "off";
        if (reger.core.Util.getJspName(request.getRequestURI()).equals("login.log")){
            isOnText = "on";
        }

        if (userSession.getAccount().getShowlogintab()){
            mb.append("<!-- Begin Tab -->");
            mb.append("<tr>");
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            if (userSession.getAccountuser().getIsLoggedIn()){
                mb.append("<a class=navfont" + isOnText + " href='login.log?action=logout'>Logout</a>");
            } else {
                mb.append("<a class=navfont" + isOnText + " href='login.log'>Login</a>");
            }
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End Tab -->");
        }

        return mb.toString();
    }

}
