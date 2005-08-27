package reger.nav;

import reger.UserSession;

/**
 * A NavPanel displays a tier of navigation
 */
public class NavPanelLevelOne {




    public static String getHtmlStart(String pathToAppRoot, UserSession userSession, NavButton[] navButtons, String currentNavButtonName){
        StringBuffer mb = new StringBuffer();




//        mb.append("<div id=\"navlevel-one-div\">");
//        mb.append("<div id=\"navlevel-one-holder\">");
//        mb.append("<div id=\"navlevel-one\">");
//
//        //Need one for each button
//        String url = "";
//        String text = "";
//        for(int i=0; i<navButtons.length; i++){
//            //Make sure the user has enough permissions to view this button
//            if (navButtons[i].aclNameRequiredToShowButton.equals("") || userSession.getAccountuser().userCanDoAcl(navButtons[i].aclNameRequiredToShowButton, userSession.getAccount().getAccountid())){
//                url = pathToAppRoot + navButtons[i].buttonUrlFromSiteRoot;
//                text = navButtons[i].buttonTitle;
//                if (navButtons[i].navButtonName.equals(currentNavButtonName)){
//                    mb.append("<div class=\"tab\" id=\"navlevel-one-here\"><a href=\""+url+"\">"+text+"</a></div>");
//                } else {
//                    mb.append("<div class=\"tab\"><a href=\""+url+"\">"+text+"</a></div>");
//                }
//            }
//        }
//
//        mb.append("</div>");
//        mb.append("</div>");
//        mb.append("</div>");
//
//
//        mb.append("<div id=\"navlevel-one-body\">");

        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr bgcolor=#ffffff>");
        mb.append("<td class=navtabtopbar><img src='images/clear.gif' width=1 height=10></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr bgcolor=#ffffff>");

        mb.append("<td width=15>");
        mb.append("<img src='images/clear.gif' width=15 height=20>");
        mb.append("</td>");

        mb.append("<td class=navtablevel1spacer width=35>");
        mb.append("<img src='images/clear.gif' width=35 height=25>");
        mb.append("</td>");


        //Need one for each button
        String url = "";
        String text = "";
        for(int i=0; i<navButtons.length; i++){
            if (navButtons[i].aclNameRequiredToShowButton.equals("") || (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && userSession.getAccountuser()!=null)){
                //Make sure the user has enough permissions to view this button
                if (navButtons[i].aclNameRequiredToShowButton.equals("") || userSession.getAccountuser().userCanDoAcl(navButtons[i].aclNameRequiredToShowButton, userSession.getAccount().getAccountid())){

                    mb.append("<td class=navtablevel1spacer width=4>");
                    mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=4 height=1>");
                    mb.append("</td>");

                    url = pathToAppRoot + navButtons[i].buttonUrlFromSiteRoot;
                    text = navButtons[i].buttonTitle;
                    if (navButtons[i].navButtonName.equals(currentNavButtonName)){
                        //mb.append("<div class=\"tab\" id=\"navlevel-one-here\"><a href=\""+url+"\">"+text+"</a></div>");
                        mb.append("<td class=navtablevel1tabon width=1% align=center valign=top nowrap>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("<a href=\""+url+"\">"+text+"</a>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("</td>");
                    } else {
                        //mb.append("<div class=\"tab\"><a href=\""+url+"\">"+text+"</a></div>");
                        mb.append("<td class=navtablevel1taboff width=1% align=center valign=top nowrap>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("<a href=\""+url+"\">"+text+"</a>");
                        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=5 height=1>");
                        mb.append("</td>");
                    }
                }
            }
        }



        mb.append("<td class=navtablevel1spacer>");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=25 height=1>");
        mb.append("</td>");

        mb.append("<td width=15>");
        mb.append("<img src='"+pathToAppRoot+"images/clear.gif' width=15 height=25>");
        mb.append("</td>");


        mb.append("</tr>");
        mb.append("</table>");


        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr bgcolor=#ffffff>");
        mb.append("<td width=15><img src='"+pathToAppRoot+"images/clear.gif' width=15 height=1></td>");

        mb.append("<td class=navlevel1body>");



        //Body of page goes here

        return mb.toString();
    }

    public static String getHtmlEnd(String pathToAppRoot, NavButton[] navButtons, String currentNavButtonName){
        StringBuffer mb = new StringBuffer();

        mb.append("</td>");

        mb.append("<td width=15><img src='"+pathToAppRoot+"images/clear.gif' width=15 height=1></td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("<br><br>");

        return mb.toString();
    }

}
