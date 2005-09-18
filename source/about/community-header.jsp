<%@ page import="reger.nav.NavButton,
                 reger.nav.NavPanel,
                 reger.AddToArray"%>
<%
NavButton[] communityButtons = new NavButton[0];
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-main", "", "COMMUNITY HOME", "about/community.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-discuss", "", "DISCUSS", "about/community-discuss.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-sites", "", "SITES", "about/community-sites.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-entries", "", "ENTRIES", "about/community-entries.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-entries-logtypes", "", "ENTRIES BY LOG TYPE", "about/community-entries-logtypes.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-logtypes", "", "LOG TYPES", "about/community-logtypes.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-findsite", "", "FIND A SITE", "about/community-findsite.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-search", "", "SEARCH ENTRIES", "about/community-search.log", false, ""));
communityButtons = AddToArray.addToNavButtonArray(communityButtons, new NavButton("community-search", "", "TELL A FRIEND", "about/community-tellfriend.log", false, ""));

NavPanel navPanel = new NavPanel("", currentNavButtonName, communityButtons, 1);
mb.append("<br><br>");
mb.append(navPanel.getHtmlStart(pageProps.pathToAppRoot, userSession));
%>