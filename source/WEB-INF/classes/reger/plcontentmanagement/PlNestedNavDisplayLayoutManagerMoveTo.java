package reger.plcontentmanagement;

import reger.UserSession;
import reger.nestednav.NestedNavDisplay;
import reger.nestednav.NestedNavItemBase;
import reger.nestednav.NestedNavItem;
import reger.nestednav.NestedNavCollection;
import reger.core.Debug;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creates the screen to manage nav item layout
 */
public class PlNestedNavDisplayLayoutManagerMoveTo implements NestedNavDisplay {

    private String cellbgcolor="#ffffff";

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        //We must start with a plid
        int plid = 0;
        if (reger.core.Util.isinteger(request.getParameter("plid"))){
            plid = Integer.parseInt(request.getParameter("plid"));
        }

        Debug.debug(5, "", "NestedNavLayoutManager.java - Navbar start.");
        //mb.append("<!-- Start navigation--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>");

        mb.append("<!-- Start navigation --><table cellpadding=3 cellspacing=1 border=0 bgcolor=#ffffff>");


//        mb.append("<tr><td valign=top align=left bgcolor=#666666>");
//        mb.append("<font face=arial size=-1 color=#ffffff>");
//        mb.append("&nbsp;");
//        mb.append("</font>");
//        mb.append("</tr>");

        mb.append(outputItemHtml(new NestedNavItemBase(), nestedNavCollection, 0, userSession, request));

        mb.append("</table><!-- End navigation -->");
        Debug.debug(5, "", "NestedNavLayoutManager.java - Navbar end.");

        return mb.toString();
    }

    public String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String thisPageName = reger.core.Util.getJspName(request.getRequestURI());


        //We must start with a plid
        int plid = 0;
        if (reger.core.Util.isinteger(request.getParameter("plid"))){
            plid = Integer.parseInt(request.getParameter("plid"));
        }

        Debug.debug(5, "", "NestedNavLayoutManager.java - Item output called.");

        String isOnText = "off";
        if (navItem.isActive(request)){
            isOnText = "on";
        }

        String nestingNbsp = "";
        for(int i=2; i<=currentNestedLevel; i++){
            nestingNbsp = nestingNbsp + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }

        String nestingNbspPlusOne = "";
        for(int i=2; i<=currentNestedLevel+1; i++){
            nestingNbspPlusOne = nestingNbspPlusOne + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }




        //Output this item in html format
        if (navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){



            //Flip flop colors
            if (cellbgcolor.equals("#ffffff")) {
                cellbgcolor="#ffffff";
            } else {
                cellbgcolor="#ffffff";
            }

            //Each log type output
            mb.append("<!-- Begin NavItem -->");
            mb.append("<tr>");
            mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
            mb.append(nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> " + navItem.getNestedNavLinkText() +"</b>");

            //Move below current item, indented one level, but not if this is the item being moved
            if (Integer.parseInt(request.getParameter("nestednavtype"))==navItem.getThisNestedNavType() && Integer.parseInt(request.getParameter("nestednavid"))==navItem.getThisNestedNavId()){
                //Can't move under self
            } else {
                mb.append("<br>");
                mb.append(nestingNbspPlusOne+"<img src='../images/clear.gif' width='15' height='1' alt='' border='0'><img src='../about/images/arrow-sm-yellow.gif' width='9' height='9' alt='' border='0'><a href='"+thisPageName+"?action=movefinish&nestednavtype="+request.getParameter("nestednavtype")+"&nestednavid="+request.getParameter("nestednavid")+"&parenttype="+navItem.getThisNestedNavType()+"&parentid="+navItem.getThisNestedNavId()+"&order=1&plid="+plid+"'><font face=arial size=-2><b>Here</b></a>");
            }
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End NavItem -->");



        }

        //Go get children and append output from each of them.
        //This is the recursive function.
        ArrayList<NestedNavItem> children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());
        for (Iterator it = children.iterator(); it.hasNext(); ) {
            NestedNavItem childNavItem = (NestedNavItem)it.next();
            mb.append(outputItemHtml(childNavItem, collection, currentNestedLevel+1, userSession, request));
        }

        if (Integer.parseInt(request.getParameter("nestednavtype"))==navItem.getThisNestedNavType() && Integer.parseInt(request.getParameter("nestednavid"))==navItem.getThisNestedNavId()){
            //Can't move under self
        } else {

            //Flip flop colors
            if (cellbgcolor.equals("#ffffff")) {
                cellbgcolor="#ffffff";
            } else {
                cellbgcolor="#ffffff";
            }

            //Move below current item and children
            mb.append("<!-- Begin NavItem -->");
            mb.append("<tr>");
            mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
            mb.append(nestingNbsp+"<img src='../about/images/arrow-sm-yellow.gif' width='9' height='9' alt='' border='0'><a href='"+thisPageName+"?action=movefinish&nestednavtype="+request.getParameter("nestednavtype")+"&nestednavid="+request.getParameter("nestednavid")+"&parenttype="+navItem.getNestedNavParentType()+"&parentid="+navItem.getNestedNavParentId()+"&order="+(navItem.getNestedNavOrder()+1)+"&plid="+plid+"'><font face=arial size=-2><b>Here</b></a>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End NavItem -->");
        }





        return mb.toString();
    }



}
