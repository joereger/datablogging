package reger.nestednav;

import reger.UserSession;
import reger.core.Debug;

/**
 * A Horizontal navbar
 */
public class NestedNavDisplayHorizontal implements NestedNavDisplay{


    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        //Start
        Debug.debug(5, "", "NestedNavbarHorizontal.java - Navbar start.");
        mb.append("<!-- Start Navigation -->");

        //Call the rows
        mb.append(outputRow(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), userSession, request, 0));

        //End
        mb.append("<!-- End Navigation -->");
        Debug.debug(5, "", "NestedNavbarHorizontal.java - Navbar end.");

        return mb.toString();
    }

    private String outputRow(NestedNavItem navItem, NestedNavCollection collection, UserSession userSession, javax.servlet.http.HttpServletRequest request, int currentNestedLevel){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "NestedNavbarHorizontal.java - Row called. parent="+navItem.getNestedNavLinkText());

        //Get the children of the current parent
        NestedNavItem[] children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());

        //Which tab is active
        NestedNavItem turnedOnNavItem = null;

        //Start the row
        mb.append("<!-- Start row--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>");

        mb.append("<tr>");

        //Home tab?
        if (currentNestedLevel==0){
            mb.append(homeTab(userSession, request));
        }

        //Output each tab... these are the children
        if (children!=null && children.length>0){
            for (int i = 0; i < children.length; i++) {
                //See if this is active, or if any of its children are active
                if (children[i].isActive(request) || NestedNavCollection.isAnyChildActive(children[i], collection, userSession, request)){
                    turnedOnNavItem = children[i];
                }
                //Do the nested items as columns
                mb.append(outputItemHtml(children[i], collection, currentNestedLevel, userSession, request));
            }

        }

        //Login tab?
        if (currentNestedLevel==0){
            mb.append(loginTab(userSession, request));
        }

        //End the row
        mb.append("</tr>");
        mb.append("</table><!-- End row -->");

        //If we have an active tab because there are active children, do another row
        if (turnedOnNavItem!=null){
            mb.append(outputRow(turnedOnNavItem, collection, userSession, request, currentNestedLevel+1));
        }

        return mb.toString();
    }


    private String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "NestedNavbarHorizontal.java - Item output called. navItem=" + navItem.getNestedNavLinkText());

        String isOnText = "off";
        if (NestedNavCollection.isAnyChildActive(navItem, collection, userSession, request) || navItem.isActive(request)){
            isOnText = "on";
        }

        //@todo Multiple CSS Selectors?  i.e. navcellon is always applied, but can be overridden with navcell-level0-on

        //Output this item in html format
        if (navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){
            mb.append("<!-- Begin Tab -->");
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            if (1==2){
                mb.append("(order="+navItem.getNestedNavOrder()+")(level="+currentNestedLevel+")(id="+navItem.getThisNestedNavId()+")");
            }
            mb.append("<a class=navfont" + isOnText + " href='"+navItem.getNestedNavLinkUrl()+"'>" + navItem.getNestedNavLinkText() + "</a>");
            mb.append("</td>");
            mb.append("<!-- End Tab -->");
        }

        Debug.debug(5, "", mb.toString());

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
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            mb.append("<a class=navfont" + isOnText + " href='index.log'>" + hometabtext + "</a>");
            mb.append("</td>");
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
            mb.append("<td class=navcell"+ isOnText +" align=left valign=top>");
            if (userSession.getAccountuser().getIsLoggedIn()){
                mb.append("<a class=navfont" + isOnText + " href='login.log?action=logout'>Logout</a>");
            } else {
                mb.append("<a class=navfont" + isOnText + " href='login.log'>Login</a>");
            }
            mb.append("</td>");
            mb.append("<!-- End Tab -->");
        }

        return mb.toString();
    }

}
