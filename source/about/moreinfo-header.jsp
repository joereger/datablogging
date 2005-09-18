<%@ page import="reger.nav.NavButton,
                 reger.nav.NavPanel,
                 reger.AddToArray"%>
<%
NavButton[] communityButtons = new NavButton[0];
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("moreinfo-main", "", "MAIN", "about/moreinfo.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("moreinfo-whatisdatablogging", "", "WHAT IS DATABLOGGING?", "about/what-is-datablogging.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("moreinfo-tour", "", "DEMO TOURS", "about/tour.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("moreinfo-features", "", "FEATURES", "about/features.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("moreinfo-business", "", "ENTERPRISE BUSINESS", "biz/index.log", false, ""));

NavPanel navPanel = new NavPanel("", currentNavButtonName, communityButtons, 1);
mb.append("<br><br>");
mb.append(navPanel.getHtmlStart(pageProps.pathToAppRoot, userSession));
%>