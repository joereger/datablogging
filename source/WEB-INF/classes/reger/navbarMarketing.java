package reger;

import reger.pageFramework.PageProps;

/**
 * The marketing site navbar
 */
public class navbarMarketing {

    public static StringBuffer htmlOut(int marketingSection, PrivateLabel privateLabel, PageProps pageProps){
        StringBuffer nb = new StringBuffer();

        if (marketingSection<=0){
            marketingSection = pageProps.MARKETINGSITESECTIONHOME;    
        }

        nb.append("<table cellspacing='0' cellpadding='5' width=100% border='0'>");

        nb.append("<tr>");
        nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONHOME, marketingSection)+" align=center nowrap>");
        nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"about/index.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONHOME, marketingSection)+"' width='15' height='15' alt='' border='0' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONHOME, marketingSection)+"><b>Home</b></font></a>&nbsp;");
        nb.append("</td>");
        nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONFEATURES, marketingSection)+" align=center nowrap>");
        nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"about/features.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONFEATURES, marketingSection)+"' width='15' height='15' alt='' border='0'' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONFEATURES, marketingSection)+"><b>Features</b></font></a>&nbsp;");
        nb.append("</td>");
        nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONTOUR, marketingSection)+" align=center nowrap>");
        nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"about/tour.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONTOUR, marketingSection)+"' width='15' height='15' alt='' border='0'' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONTOUR, marketingSection)+"><b>Tour</b></font></a>&nbsp;");
        nb.append("</td>");
        nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONCOMMUNITY, marketingSection)+" align=center nowrap>");
        nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"about/community.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONCOMMUNITY, marketingSection)+"' width='15' height='15' alt='' border='0'' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONCOMMUNITY, marketingSection)+"><b>Community</b></font></a>&nbsp;");
        nb.append("</td>");
        if (privateLabel.getShowbusinesstab()){
            nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONBIZ, marketingSection)+" align=center nowrap>");
            nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"biz/index.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONBIZ, marketingSection)+"' width='15' height='15' alt='' border='0' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONBIZ, marketingSection)+"><b>Business</b></font></a>&nbsp;");
            nb.append("</td>");
        }
        nb.append("<td bgcolor="+tabColor(pageProps.MARKETINGSITESECTIONSIGNUP, marketingSection)+" align=center nowrap>");
        nb.append("&nbsp;<a href='"+pageProps.pathToAppRoot+"about/signup.log'><img src='../images/"+buttonToUse(pageProps.MARKETINGSITESECTIONSIGNUP, marketingSection)+"' width='15' height='15' alt='' border='0' align=middle><font face=arial size=-1 color="+textColor(pageProps.MARKETINGSITESECTIONSIGNUP, marketingSection)+"><b>Get Started</b></font></a>&nbsp;");
        nb.append("</td>");
        nb.append("</tr>");

        int taglinecolspan = 6;
        if (!privateLabel.getShowbusinesstab()){
            taglinecolspan = 5;
        }

        nb.append("<tr>");
        nb.append("<td colspan='"+taglinecolspan+"' bgcolor=#333333 valign=middle align=right>");
        nb.append("<font face=arial size=+2 color=#ffffff>"+headerText(marketingSection, privateLabel)+"</font>");
        nb.append("</td>");
        nb.append("</tr>");

        nb.append("</table>");

        return nb;
    }

    private static String headerText(int marketingSection, PrivateLabel privateLabel){

        if (marketingSection==PageProps.MARKETINGSITESECTIONHOME){
            if (!privateLabel.getSectionhome().equals("")){
                return privateLabel.getSectionhome();
            }
            return "howdy.";
        } else if (marketingSection==PageProps.MARKETINGSITESECTIONTOUR){
            if (!privateLabel.getSectiontour().equals("")){
                return privateLabel.getSectiontour();
            }
            return "the nickel tour.";
        } else if (marketingSection==PageProps.MARKETINGSITESECTIONSIGNUP){
            if (!privateLabel.getSectionsignup().equals("")){
                return privateLabel.getSectionsignup();
            }
            return "wahoo.  free signup.  simple.";
        }  else if (marketingSection==PageProps.MARKETINGSITESECTIONFEATURES){
              if (!privateLabel.getSectionfeatures().equals("")){
                return privateLabel.getSectionfeatures();
            }
            return "features.";
        }  else if (marketingSection==PageProps.MARKETINGSITESECTIONBIZ){
            return "&nbsp;";
        } else {
            return "&nbsp;";
        }
    }

    private static String tabColor(int thistab, int selectedtab){
        if (thistab==selectedtab){
            return "#333333";
        } else {
            return "#cccccc";
        }
    }

    private static String textColor(int thistab, int selectedtab){
        if (thistab==selectedtab){
            return "#ffffff";
        } else {
            return "#000000";
        }
    }

    private static String buttonToUse(int thistab, int selectedtab){
        if (thistab==selectedtab){
            return "round-down-arrow-green.gif";
        } else {
            return "round-arrow-blue.gif";
        }
    }



}
