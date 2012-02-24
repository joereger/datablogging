package reger.nestednav;

import reger.UserSession;
import reger.core.Debug;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creates the screen to manage nav item layout
 */
public class NestedNavDisplayLogsAndPages implements NestedNavDisplay{

    private String cellbgcolor="#ffffff";

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        Debug.debug(5, "", "NestedNavDisplayLogsAndPages.java - Navbar start.");
        //mb.append("<!-- Start navigation--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>");


        //mb.append("<a href='logs-newlog.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Log</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='logs-contentpage-edit.log'><img src='images/add_16.gif' alt='' border='0'><font face=arial size=-1><b>Create a New Static Content Page</b></a>");


        mb.append("<!-- Start navigation -->");





        mb.append(outputItemHtml(new NestedNavItemBase(), userSession.getAccount().getNestedNavCollection(), 0, userSession, request));




        mb.append("<!-- End navigation -->");
        Debug.debug(5, "", "NestedNavDisplayLogsAndPages.java - Navbar end.");

        return mb.toString();
    }


    public String outputItemHtml(NestedNavItem navItem, NestedNavCollection collection, int currentNestedLevel, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();

        String thisPageName = reger.core.Util.getJspName(request.getRequestURI());

        Debug.debug(5, "", "NestedNavDisplayLogsAndPages.java - Item output called.");



        String nestingNbsp = "";
        for(int i=2; i<=currentNestedLevel; i++){
            nestingNbsp = nestingNbsp + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }




        //Output this item in html format
        if (navItem.getThisNestedNavType()!=NestedNavItem.NESTEDNAVITEMBASE){



                if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPEMEGALOG){
                    mb.append("        <li><a href=\"logmain"+navItem.getThisNestedNavId()+".log\">"+nestingNbsp+navItem.getNestedNavLinkText()+"</a></li>" + "\n");
                } else if (navItem.getThisNestedNavType()==NestedNavItem.NESTEDNAVTYPECONTENTPAGE) {
                    mb.append("        <li><a href=\"contentpage"+navItem.getThisNestedNavId()+".log\">"+nestingNbsp+navItem.getNestedNavLinkText()+"</a></li>" + "\n");
                } else {

                }


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
