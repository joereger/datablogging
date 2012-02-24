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


        //mb.append("<a href='logs-newlog.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Log</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='logs-contentpage-edit.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Static Content Page</b></a>");


        mb.append("<!-- Start navigation --><table  class=\"table table-striped\">");




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




            //Each log type output
            mb.append("<!-- Begin NavItem -->");

                //reger.Log log = LogCache.get(navItem.getThisNestedNavId());
                mb.append("<tr>");
                mb.append("<td nowrap>"+nestingNbsp+"<font face=arial size=-1><b> " + navItem.getNestedNavLinkText() +"</b></td>");
                mb.append("<td nowrap>");

                mb.append("<div class=\"btn-group\">" + "\n");
                if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEMEGALOG){
                    mb.append("<a class=\"btn btn-success\" href=\"entry.log?logid="+navItem.getThisNestedNavId()+"&action=add\"><i class=\"icon-plus-sign icon-white\"></i> New Post</a>" + "\n");
                } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE) {
                    mb.append("<a class=\"btn btn-success\" href=\"logs-contentpage-edit.log?contentpageid="+navItem.getThisNestedNavId()+"\"><i class=\"icon-edit icon-white\"></i> Edit Page</a>" + "\n");
                } else {
                    mb.append("<a class=\"btn btn-success\" href=\"logs-log-move.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"\"><i class=\"icon-move icon-white\"></i> Move</a>" + "\n");
                }

                mb.append("<a class=\"btn dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">" + "\n");
                mb.append("<span class=\"caret\"></span>" + "\n");
                mb.append("</a>" + "\n");
                mb.append("<ul class=\"dropdown-menu\">" + "\n");

                if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEMEGALOG){
                    mb.append("<li><a href=\"logs-log-properties.log?logid="+ navItem.getThisNestedNavId() +"\">Properties</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-log-templates.log?logid="+ navItem.getThisNestedNavId() +"\">Look & Feel</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-log-move.log?logid="+ navItem.getThisNestedNavId() +"&action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"\">Move</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-log-permissions.log?logid="+ navItem.getThisNestedNavId() +"\">Permissions</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-log-delete.log?logid="+ navItem.getThisNestedNavId() +"\">Delete</a></li>" + "\n");
                } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE) {
                    //mb.append("<li><a href=\"logs-contentpage-edit.log?contentpageid="+ navItem.getThisNestedNavId() +"\">Edit Static Content Page</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-log-move.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"\">Move</a></li>" + "\n");
                    mb.append("<li><a href=\"logs-contentpage-delete.log?action=deletestart&contentpageid="+ navItem.getThisNestedNavId() +"\">Delete</a></li>" + "\n");
                } else {
                    mb.append("<li><a href=\"logs-log-move.log?action=movestart&nestednavtype="+navItem.getThisNestedNavType()+"&nestednavid="+navItem.getThisNestedNavId()+"\">Move</a></li>" + "\n");
                }

                mb.append("</ul>" + "\n");
                mb.append("</div>" + "\n");

            }
            mb.append("<!-- End NavItem -->");



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
