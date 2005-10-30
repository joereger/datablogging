package reger.nav;

import reger.Accountuser;
import reger.UserSession;

/**
 * A NavPanel displays a tier of navigation
 */
public class NavPanelLevelZero {



    public static String getHtmlStart(String pathToAppRoot, UserSession userSession, NavButton[] navButtons, String currentNavButtonName){
        StringBuffer mb = new StringBuffer();


        //mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffcc00 background='"+pathToAppRoot+"images/pattern-yellowsquigglies.gif'>");
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffcc00 background='"+pathToAppRoot+"images/navlevel0bg2.gif'>");
        mb.append("<tr>");
        mb.append("<td class=navlevel0topbar colspan=10><img src='images/clear.gif' width=1 height=85 align=right>");
//        mb.append("<font face=impact size=+2 style=\"font-size: 30px; color: ffffcc;\">");
//        mb.append(reger.Vars.getHttpUrlPrefix()+userSession.getSiteRootUrl()+"/");
//        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        //mb.append("</table>");

        //mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0 background='"+pathToAppRoot+"images/pattern-yellowblocks.gif'>");
        mb.append("<tr>");

        mb.append("<td class=navtablevel0spacer width=35>");
        mb.append("<img src='images/clear.gif' width=35 height=35>");
        mb.append("</td>");


        //Need one for each button
        String url = "";
        String text = "";
        for(int i=0; i<navButtons.length; i++){
            if (navButtons[i].aclNameRequiredToShowButton.equals("") || (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccountuser()!=null)){
                //Make sure the user has enough permissions to view this button
                if (navButtons[i].aclNameRequiredToShowButton.equals("") || userSession.getAccountuser().userCanDoAcl(navButtons[i].aclNameRequiredToShowButton, userSession.getAccount().getAccountid())){

                    mb.append("<td class=navtablevel0spacer width=6>");
                    mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=6 height=1>");
                    mb.append("</td>");

                    url = pathToAppRoot + navButtons[i].buttonUrlFromSiteRoot;
                    text = navButtons[i].buttonTitle;
                    if (navButtons[i].navButtonName.equals(currentNavButtonName)){
                        //mb.append("<div class=\"tab\" id=\"navlevel-one-here\"><a href=\""+url+"\">"+text+"</a></div>");
                        mb.append("<td class=navtablevel0tabon align=center valign=top nowrap>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("<a href=\""+url+"\">"+text+"</a>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("</td>");
                    } else {
                        //mb.append("<div class=\"tab\"><a href=\""+url+"\">"+text+"</a></div>");
                        mb.append("<td class=navtablevel0taboff align=center valign=top nowrap>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("<a href=\""+url+"\">"+text+"</a>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("</td>");
                    }
                }
            }
        }

        mb.append("<td class=navtablevel0spacer width=50% >");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=25 height=1>");
        mb.append("</td>");


        mb.append("</tr>");
        mb.append("</table>");


        //Body of page goes here

        return mb.toString();
    }

    public static String getHtmlEnd(String pathToAppRoot, NavButton[] navButtons, String currentNavButtonName){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr bgcolor=#ffcc00>");
        mb.append("<td class=navlevel0bottom><img src='"+pathToAppRoot+"images/clear.gif' width=1 height=15></td>");
        mb.append("</tr>");
        mb.append("</table>");


        return mb.toString();
    }

}
