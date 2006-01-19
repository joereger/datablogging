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
public class PlNestedNavDisplayLayoutManager implements NestedNavDisplay {

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


        mb.append("<!-- Start navigation --><table cellpadding=3 cellspacing=1 width=100% border=0 bgcolor=#ffffff>");


        mb.append("<tr><td valign=top align=left bgcolor=#ffffff colspan=2 nowrap><br><a href='plsitecontent-page.log?plid="+plid+"'><img src='../myhome/images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Static Content Page</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='plsitecontent.log?action=showall&plid="+plid+"'><font face=arial size=-1><b>Unhide All</b></a></td></tr>");


        mb.append("<tr><td valign=top align=left bgcolor=#666666 colspan=2>");
        mb.append("<font face=arial size=-1 color=#ffffff>");
        mb.append("These are the pages that appear on your public private label site:");
        mb.append("</font>");
        mb.append("</tr>");



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




        //Output this item in html format
        if (navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){


            //Flip flop colors
            if (cellbgcolor.equals("#ffffff")) {
                cellbgcolor="#e6e6e6";
            } else {
                cellbgcolor="#ffffff";
            }

            //Each log type output
            mb.append("<!-- Begin NavItem -->");
            if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEPLJSPPAGE) {
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> "+ navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                mb.append("<a href='"+thisPageName+"?action=hide&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"&plid="+plid+"'><font face=arial size=-2>Hide</font></a>");
                mb.append("</td>");
                mb.append("</tr>");
            } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEPLCONTENTPAGE) {
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> "+ navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                mb.append("<a href='plsitecontent-page.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"&plcontentpageid="+((PlContentPage)navItem).getPlcontentpageid()+"&plid="+plid+"'><font face=arial size=-2>Edit</font></a>");
                mb.append(" | ");
                mb.append("<a href='plsitecontent-move.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"&plid="+plid+"'><font face=arial size=-2>Move</font></a>");
                mb.append(" | ");
                mb.append("<a href='plsitecontent-delete.log?action=deletestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"&plcontentpageid="+((PlContentPage)navItem).getPlcontentpageid()+"&plid="+plid+"'><font face=arial size=-2>Delete</font></a>");
                mb.append("</td>");
                mb.append("</tr>");
            } else {
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> "+ navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                //mb.append("<a href='"+thisPageName+"?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"&plid="+plid+"'><font face=arial size=-2>Splamma Damma Ding Dong</font></a>");
                mb.append("</td>");
                mb.append("</tr>");
            }
            mb.append("<!-- End NavItem -->");

        }

        //Go get children and append output from each of them.
        //This is the recursive function.
        ArrayList<NestedNavItem> children = collection.getChildrenUserCanView(navItem, userSession.getAccountuser());
        for (Iterator it = children.iterator(); it.hasNext(); ) {
            NestedNavItem childNavItem = (NestedNavItem)it.next();
            mb.append(outputItemHtml(childNavItem, collection, currentNestedLevel+1, userSession, request));
        }

        return mb.toString();
    }





}
