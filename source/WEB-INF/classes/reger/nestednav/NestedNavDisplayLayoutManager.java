package reger.nestednav;

import reger.UserSession;
import reger.core.Debug;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creates the screen to manage nav item layout
 */
public class NestedNavDisplayLayoutManager implements NestedNavDisplay{

    private String cellbgcolor="#ffffff";

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "NestedNavLayoutManager.java - Navbar start.");
        //mb.append("<!-- Start navigation--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>");


        mb.append("<!-- Start navigation --><table cellpadding=3 cellspacing=1 width=100% border=0 bgcolor=#ffffff>");


        mb.append("<tr><td valign=top align=left bgcolor=#ffffff colspan=2 nowrap><br><a href='logs-newlog.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Log</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='logs-contentpage-edit.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Static Content Page</b></a></td></tr>");


        mb.append("<tr><td valign=top align=left bgcolor=#666666 colspan=2>");
        mb.append("<font face=arial size=-1 color=#ffffff>");
        mb.append("These are your logs:");
        mb.append("</font>");
        mb.append("</tr>");



        mb.append(outputItemHtml(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), 0, userSession, request));






        mb.append("</table><!-- End navigation -->");
        Debug.debug(5, "", "NestedNavLayoutManager.java - Navbar end.");

        return mb.toString();
    }


    public String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String thisPageName = reger.core.Util.getJspName(request.getRequestURI());

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
            if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEMEGALOG){
                //reger.Log log = LogCache.get(navItem.getThisNestedNavId());
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> " + navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                mb.append("<a href='logs-log-properties.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Properties</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-fieldlayout.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>datablogging Fields</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-templates.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Look & Feel</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-move.log?logid="+ navItem.getThisNestedNavId() +"&action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"'><font face=arial size=-2>Move</font></a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-permissions.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Permissions</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='people-friends-invite.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Invite Friends</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-delete.log?logid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Delete</a>");
                if (1==2){
                    mb.append("(order="+navItem.getNestedNavOrder()+")(level="+currentNestedLevel+")(id="+navItem.getThisNestedNavId()+")");
                }
                mb.append("</td>");
                mb.append("</tr>");
            } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE) {
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> "+ navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                mb.append("<a href='logs-contentpage-edit.log?contentpageid="+ navItem.getThisNestedNavId() +"'><font face=arial size=-2>Edit Static Content Page</a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-log-move.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"'><font face=arial size=-2>Move</font></a>");
                mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
                mb.append("<a href='logs-contentpage-delete.log?action=deletestart&contentpageid="+navItem.getThisNestedNavId()+"'><font face=arial size=-2>Delete</font></a>");
                mb.append("</td>");
                mb.append("</tr>");
            } else {
                mb.append("<tr>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>"+nestingNbsp+"<img src='../images/round-arrow-green.gif' width='15' height='15' alt='' border='0'><font face=arial size=-1><b> "+ navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td valign=top align=left bgcolor="+ cellbgcolor +" nowrap>");
                mb.append("<a href='"+thisPageName+"?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"'><font face=arial size=-2>Move</font></a>");
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
