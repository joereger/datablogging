package reger.plcontentmanagement;

import reger.UserSession;
import reger.nestednav.NestedNavDisplay;
import reger.nestednav.NestedNavItemBase;
import reger.nestednav.NestedNavItem;
import reger.nestednav.NestedNavCollection;
import reger.core.Debug;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

/**
 * A vertical navbar
 */
public class PlNestedNavDisplayVertical implements NestedNavDisplay {

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();


        //Figure out the ID of the current item
        int idofpageuserison = 0;
        if (reger.core.Util.isinteger(request.getParameter("plcontentpageid"))){
            idofpageuserison = Integer.parseInt(request.getParameter("plcontentpageid"));
        } else {
            String thispagename = FilenameUtils.getName(request.getServletPath());
            for (Iterator it = AllPlJspPages.getNestedNavItems().iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
                if (navItem.getNestedNavLinkUrl().equals(thispagename) && !thispagename.equals("index.log")){
                    idofpageuserison = navItem.getThisNestedNavId();
                }
            }
        }

        //Figure out the parent of the page the user is on
        int parentidofpageuserison = 0;
        if (idofpageuserison!=0){
            NestedNavItem navItemUserIsOn = nestedNavCollection.getNestedNavItemById(idofpageuserison);
            if (navItemUserIsOn!=null){
                parentidofpageuserison = navItemUserIsOn.getNestedNavParentId();
            }
        }

        //Start the table
        Debug.debug(5, "", "PlNestedNavbarVertical.java - Navbar start.");

        mb.append(reger.ui.RoundedCorners.start("marketinghpnav", "e6e6e6", "666666"));



        mb.append("<!-- Start navigation--><table cellpadding=0 cellspacing=0 width=100% border=0 style=\"margin: 5px;\">");


        //Do the nested items

        mb.append(outputItemHtml(new NestedNavItemBase(), nestedNavCollection, 0, userSession, request, idofpageuserison, parentidofpageuserison));



        //End the table
        mb.append("</table><br><!-- End navigation -->");
        mb.append(reger.ui.RoundedCorners.end("marketinghpnav"));
        Debug.debug(5, "", "PlNestedNavbarVertical.java - Navbar end.");

        return mb.toString();
    }


    private String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request, int idofpageuserison, int parentidofpageuserison){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "PlNestedNavbarVertical.java - Item output called.");

        //Criteria for display
        if (idofpageuserison==navItem.getThisNestedNavId() || parentidofpageuserison==navItem.getNestedNavParentId() || idofpageuserison==navItem.getNestedNavParentId() || isIdDescendantOfId(navItem, collection, idofpageuserison) || navItem.getNestedNavParentId()==0){

            String isOnText = "off";
            if (idofpageuserison==navItem.getThisNestedNavId()){
                isOnText = "on";
            }
            isOnText = "off";

            String nestingNbsp = "";
            for(int i=2; i<=currentNestedLevel; i++){
                nestingNbsp = nestingNbsp + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            }

            int nestingPixels = 1;
            for(int i=2; i<=currentNestedLevel; i++){
                nestingPixels = nestingPixels + 15;
            }

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
        }

        //Go get children and append output from each of them.
        //This is the recursive function.
        ArrayList<NestedNavItem> children = null;
        if (collection!=null && userSession!=null){
            children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());
        }
        if (children!=null){
            for (Iterator it = children.iterator(); it.hasNext(); ) {
                NestedNavItem childNavItem = (NestedNavItem)it.next();
                mb.append(outputItemHtml(childNavItem, collection, currentNestedLevel+1, userSession, request, idofpageuserison, parentidofpageuserison));
            }
        }


        return mb.toString();
    }

    private boolean isIdDescendantOfId(NestedNavItem thisone, NestedNavCollection collection, int possiblechildid){
        ArrayList<NestedNavItem> children = null;
        if (collection!=null){
            collection.getAllChildrenApplyNoPermissions(thisone);
        }
        if (children!=null){
            for (Iterator it = children.iterator(); it.hasNext(); ) {
                NestedNavItem childNavItem = (NestedNavItem)it.next();
                if (childNavItem.getThisNestedNavId()==possiblechildid){
                    return true;
                }
                return isIdDescendantOfId(childNavItem, collection, possiblechildid);
            }
        }
        return false;
    }



}
