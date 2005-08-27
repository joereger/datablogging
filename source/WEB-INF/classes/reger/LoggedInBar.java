package reger;

import reger.pageFramework.PageProps;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * The Logged-In Bar Appears at the top of the page whenever you're logged-in
 */
public class LoggedInBar {


    public static StringBuffer getHtml(reger.UserSession userSession, PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        if (userSession.getAccountuser()!=null && userSession.getAccountuser().isLoggedIn){

            String bgcolor = "cccccc";

            mb.append("<table width=100% cellpadding=0 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
            mb.append("</tr>");
            mb.append("<tr>");

            mb.append("<td bgcolor=#"+bgcolor+" valign=middle width=31>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/personicon.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#"+bgcolor+" valign=middle align=left>");
            mb.append("<font face=arial size=-2 class=loggedinbartextsmall>");
            mb.append("<b>");
            mb.append(" Logged In As:");
            mb.append("</b>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 class=loggedinbartextlarge>");
            mb.append("<b>");
            mb.append(userSession.getAccountuser().getFriendlyname());
            mb.append("</b>");
            mb.append("</font>");
            mb.append("</td>");



            mb.append("<td bgcolor=#"+bgcolor+" valign=middle align=right>");

            mb.append("<table bgcolor=#e6e6e6 cellpadding=5 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td class=loggedinbarsubtable>");
            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/index.log' class=loggedinbarlink>");
            mb.append("MY SITE");
            mb.append("</a>");
            mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/myhome/index.log' class=loggedinbarlink>");
            mb.append("MY ADMIN TOOLS");
            mb.append("</a>");
            mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
            mb.append("<a href='"+pageProps.pathToAppRoot+"access.log' class=loggedinbarlink>");
            mb.append("MY PRIVILEGES");
            mb.append("</a>");
            mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
//            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/myhome/index.log?action=togglehelp' class=loggedinbarlink>");
//            if (userSession.getAccountuser().getIsHelpOn()){
//                mb.append("TURN HELP OFF");
//            } else {
//                mb.append("TURN HELP ON");
//            }
//            mb.append("</a>");
//            mb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/login.log?action=logout' class=loggedinbarlink>");
            mb.append("LOG OUT");
            mb.append("</a>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");


            mb.append("</td>");



            mb.append("<td bgcolor=#"+bgcolor+" valign=middle width=15>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=15 height=1 border=0>");
            mb.append("</td>");


            mb.append("</tr>");


            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
            mb.append("</tr>");

            //Start system message
            try{
                if (AllLiveSystemMessagesInSystem.getAllLiveSystemMessagesAsMap()!=null){
                    if (AllLiveSystemMessagesInSystem.getAllLiveSystemMessagesAsMap().size()>0){
                        for (Iterator i=AllLiveSystemMessagesInSystem.getAllLiveSystemMessagesAsMap().entrySet().iterator(); i.hasNext(); ) {
                            Map.Entry e = (Map.Entry) i.next();
                            //e.getKey()
                            //e.getValue()
                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff colspan=13>");
                            mb.append("<blockquote>");
                            mb.append(reger.InfoBox.get(reger.InfoBox.BOXTYPEINFO, pageProps.pathToAppRoot, ((reger.SystemMessage)e.getValue()).getSystemMessage())  );
                            mb.append("</blockquote>");
                            mb.append("</td>");
                            mb.append("</tr>");
                        }
                        mb.append("<tr>");
                        mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
                        mb.append("</tr>");
                    }
                }
            } catch (Exception e){
                reger.core.Util.errorsave(e);
            }

            //End system message




            //Start Help
            if (userSession.getAccountuser().getIsHelpOn()){
                String tmpHlpTxt = "No help is available for this page.";
                if (pageProps.helpText!=null && !pageProps.helpText.equals("")){
                    tmpHlpTxt = pageProps.helpText;
                }

                mb.append("<tr>");
                mb.append("<td bgcolor=#ffffff colspan=13>");
                mb.append("<blockquote>");
                mb.append(reger.Help.helpOnEachPage(tmpHlpTxt, pageProps.pathToAppRoot));
                mb.append("</blockquote>");
                mb.append("<br>");
                mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/myhome/index.log?action=togglehelp' class=loggedinbarlink>");
                if (userSession.getAccountuser().getIsHelpOn()){
                    mb.append("TURN HELP OFF");
                } else {
                    mb.append("TURN HELP ON");
                }
                mb.append("</a>");
                mb.append("</td>");
                mb.append("</tr>");


                mb.append("<tr>");
                mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
                mb.append("</tr>");
            }
            //End Help






            mb.append("</table>");




        }

        return mb;
    }


    public static StringBuffer getHtmlOld(reger.UserSession userSession, PageProps pageProps){
        StringBuffer mb = new StringBuffer();

        if (userSession.getAccountuser()!=null && userSession.getAccountuser().isLoggedIn){

            mb.append("<style type=text/css>");
            mb.append("<--");
            mb.append(".loggedinbarlink:link {color:#0000ff; text-decoration:none;}");
            mb.append(".loggedinbarlink:active {color:#0000ff; text-decoration:underline;}");
            mb.append(".loggedinbarlink:visited {color:#0000ff; text-decoration:none;}");
            mb.append(".loggedinbarlink:hover {color: #ff0000; text-decoration:underline; background-color: #e6e6e6;}");
            mb.append(".loggedinbartextlarge {color:#000000; text-decoration:none; font-size: 16px}");
            mb.append(".loggedinbartext {color:#000000; text-decoration:none; font-size: 10px; font-weight: bold;}");
            mb.append(".loggedinbartextsmall {color:#000000; text-decoration:none; font-size: 8px}");
            mb.append("-->");
            mb.append("<style></style>");

            mb.append("<table width=100% cellpadding=0 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
            mb.append("</tr>");
            mb.append("<tr>");

            mb.append("<td bgcolor=#cccccc valign=middle width=31>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/personicon.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle align=left>");
            mb.append("<font face=arial size=-2 class=loggedinbartextsmall>");
            mb.append("<b>");
            mb.append(" Logged In As:");
            mb.append("</b>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 class=loggedinbartextlarge>");
            mb.append("<b>");
            mb.append(userSession.getAccountuser().getFriendlyname());
            mb.append("</b>");
            mb.append("</font>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle width=2>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/divider.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle align=center>");
            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/index.log' class=loggedinbarlink>");
            mb.append("My Weblog");
            mb.append("</a>");
            mb.append("</font>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle width=2>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/divider.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle align=center>");
            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/myhome/index.log' class=loggedinbarlink>");
            mb.append("My Admin Tools");
            mb.append("</a>");
            mb.append("</font>");
            mb.append("</td>");









            mb.append("<td bgcolor=#cccccc valign=middle width=2>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/divider.gif' border=0>");
            mb.append("</td>");

    //        mb.append("<form action=\""+pathToAppRoot+"redirectToAccountid.log\" method=post>");
            mb.append("<td bgcolor=#cccccc valign=middle align=center>");
    //        mb.append("<font face=arial size=-2 class=loggedinbartextsmall>");
    //        mb.append("<b>");
    //        mb.append("&nbsp;&nbsp;&nbsp;");
    //        mb.append(" You have access to:");
    //        mb.append("</b>");
    //        mb.append("</font>");
    //        mb.append("<br>");
            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("&nbsp;&nbsp;&nbsp;");
            mb.append("<a href='"+pageProps.pathToAppRoot+"access.log'>");
            mb.append("My Privileges");
            mb.append("</a>");
    //        mb.append("<select name=accountid style=\"font-size: 9px; font-face: arial; background-color: #cccccc;\">");
    //        if (userSession.getAccountuser().getAccountsUserHasAccessTo()!=null){
    //            for ( Enumeration e = userSession.getAccountuser().getAccountsUserHasAccessTo().keys() ; e.hasMoreElements() ; ) {
    //                // retrieve the object_key
    //                Integer object_key = (Integer) e.nextElement();
    //                // retrieve the object associated with the key
    //                String sitename = (String) userSession.getAccountuser().getAccountsUserHasAccessTo().get ( object_key );
    //                //Create the dropdown
    //                mb.append("<option value=\""+object_key+"\"");
    //                if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()==object_key.intValue()){
    //                    mb.append(" selected");
    //                }
    //                mb.append(">"+reger.core.Util.cleanForHtml(sitename)+"</option>");
    //            }
    //        }
    //        mb.append("</select>");
    //        mb.append("<input type=submit value='Go' style=\"font-size: 9px;\">");
            mb.append("</font>");
            mb.append("</td>");


            mb.append("<td bgcolor=#cccccc valign=middle width=2>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/divider.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle align=center>");

            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/myhome/index.log?action=togglehelp' class=loggedinbarlink>");
            if (userSession.getAccountuser().getIsHelpOn()){
                mb.append("Turn Help Off");
            } else {
                mb.append("Turn Help On");
            }
            mb.append("</a>");
            mb.append("</font>");

            mb.append("</td>");



            mb.append("<td bgcolor=#cccccc valign=middle width=2>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/divider.gif' border=0>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle align=right>");
            mb.append("<font face=arial size=-2 class=loggedinbartext>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/login.log?action=logout' class=loggedinbarlink>");
            mb.append("Log Out");
            mb.append("</a>");
            mb.append("&nbsp;&nbsp;&nbsp;");
            mb.append("</font>");
            mb.append("</td>");

            mb.append("<td bgcolor=#cccccc valign=middle width=30>");
            mb.append("<a href='"+reger.Vars.getHttpUrlPrefix()+userSession.getAccountuser().getSiteRootUrl()+"/login.log?action=logout' class=loggedinbarlink>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/loggedinbar/logout.gif' border=0>");
            mb.append("</a>");
            mb.append("</td>");

            mb.append("</tr>");


            mb.append("<tr>");
            mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
            mb.append("</tr>");




            //Start Help
            if (userSession.getAccountuser().getIsHelpOn()){
                String tmpHlpTxt = "No help is available for this page.";
                if (pageProps.helpText!=null && !pageProps.helpText.equals("")){
                    tmpHlpTxt = pageProps.helpText;
                }

                mb.append("<tr>");
                mb.append("<td bgcolor=#ffffff colspan=13>");
                mb.append("<blockquote>");
                mb.append(reger.Help.helpOnEachPage(tmpHlpTxt, pageProps.pathToAppRoot));
                mb.append("</blockquote>");
                mb.append("</td>");
                mb.append("</tr>");



//                mb.append("<tr>");
//                mb.append("<td bgcolor=#e6e6e6 colspan=13 valign=middle align=right>");
//                mb.append("<font face=arial size=-2 class=loggedinbartext>");
//                mb.append("<a href='"+pageProps.pathToAppRoot+"myhome/index.log?action=togglehelp'>");
//                mb.append("Turn Help Off");
//                mb.append("<img src='"+pageProps.pathToAppRoot+"images/help-question.gif' width=15 height=15 border=0 align=middle>");
//                mb.append("</a>");
//                mb.append("</font>");
//                mb.append("</td>");
//                mb.append("</tr>");

                mb.append("<tr>");
                mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
                mb.append("</tr>");
            }  else {
//                mb.append("<tr>");
//                mb.append("<td bgcolor=#e6e6e6 colspan=13 valign=middle align=right>");
//                mb.append("<font face=arial size=-2 class=loggedinbartext>");
//                mb.append("<a href='"+pageProps.pathToAppRoot+"myhome/index.log?action=togglehelp'>");
//                mb.append("Turn Help On");
//                mb.append("<img src='"+pageProps.pathToAppRoot+"images/help-question.gif' width=15 height=15 border=0 align=middle>");
//                mb.append("</a>");
//                mb.append("</font>");
//                mb.append("</td>");
//                mb.append("</tr>");
//
//                mb.append("<tr>");
//                mb.append("<td bgcolor=#000000 colspan=13><img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=1 height=1></td>");
//                mb.append("</tr>");
            }
            //End Help






            mb.append("</table>");




        }

        return mb;
    }


}
