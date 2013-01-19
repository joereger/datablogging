package reger.nav;

import reger.AddToArray;

/**
 * This creates all of the navbuttons
 */
public class AllNavButtons {

    private static NavButton[] allNavButtons;
    private static String defaultNavButtonName = "adminhome";

    public AllNavButtons(){
        if(allNavButtons==null){
            createButtons();
        }
    }

    private static void createButtons(){

        //Top level Admin Tab buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("adminhome", "", "dashboard", "myhome/index.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entries", "", "posts", "myhome/entries-recent.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logs", "", "logs & pages", "myhome/logs-log-list.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("files", "", "Files", "myhome/files.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("traffic", "", "Traffic", "myhome/traffic.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("people", "", "People", "myhome/people.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("groups", "", "Groups", "myhome/groups.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settings", "", "settings", "myhome/settings-siteprops.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("tools", "", "tools", "myhome/tools.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pl", "", "pl", "pl/index.log", false, "PLADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loe", "", "sysadmin", "loe/index.log", false, "MASTERADMIN", null));


        //Sites
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesmain", "adminhome", "Manage Sites", "myhome/sites.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesnewsite", "adminhome", "New Site", "myhome/sites-newsite.log", false, "", null));

        //Versions
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("versionsmain", "adminhome", "Release Notes", "myhome/versions.log", false, "", null));


        //Logs Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsyourlogs", "logs", "Your Logs and Pages", "myhome/logs-log-list.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlog", "logs", "Log Types", "myhome/logs-newlog.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsmain", "logs", "Logs vs Log Types", "myhome/logs.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logslogtypes", "logs", "Make Your Own Log Type", "myhome/logs-type-list.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlogtype", "logs", "Make Your Own Log Type", "myhome/logs-type-properties.log?action=startadd", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewstatic", "logs", "Pages", "myhome/logs-contentpage-edit.log", false, "", null));
        //allNavButtons = reger.core.Util.addToNavButtonArray(allNavButtons, new NavButton("logsstaticcontentpages", "logs", "STATIC CONTENT PAGES", "myhome/logs-contentpage.log", false, ""));

        //Entries Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesrecent", "entries", "Recent", "myhome/entries-recent.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesdraft", "entries", "Drafts", "myhome/entries-draft.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearchtop", "entries", "Search", "myhome/entries-simplesearch.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entrieslocations", "entries", "Locations", "myhome/entries-locations.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodes", "entries", "Episodes", "myhome/episodes.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiods", "entries", "Periods", "myhome/timeperiods.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriespolls", "entries", "Polls", "myhome/entries-polls.log", false, "", null));

        //Entries Search
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessimplesearch", "entriessearchtop", "Simple Search", "myhome/entries-simplesearch.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearch", "entriessearchtop", "Advanced Search", "myhome/entries.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessaved", "entriessearchtop", "Saved Searches", "myhome/entries-savedsearches.log", false, "", null));

        //Files
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("filesbrowse", "files", "BROWSE", "myhome/files.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("filessync", "files", "SYNC TOOL", "myhome/files-synctool.log", false, "", null));

        //Episodes
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodesmain", "episodes", "Your Episodes", "myhome/episodes.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodeswhatare", "episodes", "What Are Episodes?", "myhome/episodes-whatare.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodesnew", "episodes", "New Episode", "myhome/episodes-new.log", false, "", null));


        //Time Periods
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodsmain", "timeperiods", "Main", "myhome/timeperiods.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodsadd", "timeperiods", "New Time Period", "myhome/timeperiods-add.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodshelp", "timeperiods", "What Are Time Periods?", "myhome/timeperiods-help.log", false, "", null));


        //Traffic
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficmain", "traffic", "Main", "myhome/traffic.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficentries", "traffic", "Entries", "myhome/traffic-entries.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficlogs", "traffic", "Logs", "myhome/traffic-logs.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficfiles", "traffic", "Files", "myhome/traffic-images.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficmessages", "traffic", "Messages", "myhome/traffic-messages.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("traffictrackback", "traffic", "Trackbacks", "myhome/traffic-trackback.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficbrowsers", "traffic", "Browsers", "myhome/traffic-browsers.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficreferers", "traffic", "Referers", "myhome/traffic-referers.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficclicks", "traffic", "Clicks", "myhome/traffic-rawclicks.log", false, "", null));

        //People
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplemain", "people", "Main", "myhome/people.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplespecialaccess", "people", "Special Access", "myhome/people-authors.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleaddauthor", "people", "Add Author", "myhome/people-accountuser.log?action=newstart", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplefriends", "people", "Friends", "myhome/people-friends.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleinvite", "people", "Invite", "myhome/people-friends-invite.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplefind", "people", "Find People", "myhome/people-find.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleinbox", "people", "Inbox", "myhome/people-inbox.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplemessage", "people", "Send Message", "myhome/people-newmessage.log", false, "", null));

        //Groups
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("groupsmain", "groups", "Main", "myhome/groups.log", false, "", null));

        //Settings
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingssiteprops", "settings", "Site Settings", "myhome/settings-siteprops.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingssettings", "settings", "User Settings", "myhome/settings-accountuser.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingstemplatetab", "settings", "Look and Feel", "myhome/settings-template-main.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsprofile", "settings", "Your Profile", "myhome/settings-profile.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsfavesites", "settings", "Favorite Sites", "myhome/settings-favesites.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsacctstatus", "settings", "License Status", "myhome/accountstatus.log", false, "", null));

        //Look & Feel
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingstemplateoneclick", "settingstemplatetab", "SIMPLE ONE-CLICK TEMPLATES", "myhome/settings-template-oneclick.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingstemplate", "settingstemplatetab", "Template Editing", "myhome/settings-template-main.log", false, "", null));


        //Profile
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsprofilemain", "settingsprofile", "Main", "myhome/settings-profile.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsaddprofileimage", "settingsprofile", "Add Profile Image", "myhome/settings-addprofileimage.log", false, "", null));

        //Skins
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsskinsmain", "settingsskins", "Easy Skins", "myhome/settings-skin.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingscustomskin", "settingsskins", "Custom Skins", "myhome/settings-skin-custom.log", false, "", null));

        //Tools
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmain", "tools", "Main", "myhome/tools.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsimport", "tools", "Import Posts", "myhome/tools-import.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphone", "tools", "Email/Camphone", "myhome/tools-emailapi-emailaddresses.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsapi", "tools", "Open APIs", "myhome/tools-api.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsrss", "tools", "RSS Feeds", "myhome/tools-rssfeeds.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsinstagram", "tools", "Instagram", "myhome/tools-instagram.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsdropbox", "tools", "Dropbox", "myhome/tools-dropbox.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmobile", "tools", "Mobile Access", "myhome/tools-mobile.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsjavascript", "tools", "JAVASCRIPT", "myhome/tools-javascriptpublishing.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolssupercookie", "tools", "SUPERCOOKIE", "myhome/tools-supercookie.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolstaggame", "tools", "KEYWORD TAG GAME", "myhome/tools-taggame.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolslinkrot", "tools", "LINK ROT", "myhome/tools-linkrot.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolssearchreplace", "tools", "SEARCH/REPLACE", "myhome/tools-searchreplace.log", false, "", null));


        // Import Entries
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsimportmain", "toolsimport", "Main", "myhome/tools-import.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("importrss", "toolsimport", "RSS", "myhome/tools-importrss.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("importmovabletype", "toolsimport", "Movable Type", "myhome/tools-import-movabletype.log", false, "", null));

        //Tools Email/Camphone
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphoneemail", "toolsemailcamphone", "Email Addresses", "myhome/tools-emailapi-emailaddresses.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphonephone", "toolsemailcamphone", "Phone Addresses", "myhome/tools-emailapi-phoneaddresses.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphonesettings", "toolsemailcamphone", "Settings", "myhome/tools-emailapi-settings.log", false, "", null));

        //Private Label
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmain", "pl", "Main", "pl/index.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmanage", "pl", "Settings", "pl/plmanage.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plsitecontent", "pl", "Site Content", "pl/plsitecontent.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pltemplates", "pl", "Templates", "pl/pltemplates.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pleventtype", "pl", "Log Types", "pl/pleventtype.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plpeers", "pl", "Peers", "pl/plpeers.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmoderation", "pl", "Moderation", "pl/plmoderationmain.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("placcounts", "pl", "Accounts", "pl/accounts.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentries", "pl", "Entries", "pl/entries.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plbandwidth", "pl", "Bandwidth", "pl/bandwidth.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plfiles", "pl", "Files", "pl/files.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("ploffensivewords", "pl", "Offensive", "pl/offensivewordslist.log", false, "PLADMIN", new String[]{"plid"}));


        //Private Label Moderation
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmoderationmain", "plmoderation", "Main", "pl/entryapproval.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentryapproval", "plmoderation", "Entries for Approval", "pl/entryapproval.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plflaggedentries", "plmoderation", "Entries for Review", "pl/flaggedentries.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plnewaccountapproval", "plmoderation", "Accounts for Approval", "pl/newaccountapproval.log", false, "PLADMIN", new String[]{"plid"}));

        //LOE
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemain", "loe", "Main", "loe/index.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfig", "loe", "System Setup", "loe/systemproperties.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeperformance", "loe", "Performance", "loe/memory.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeeventlog", "loe", "Event Log", "loe/viewevents.jsp", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loescheduler", "loe", "Scheduler", "loe/schedulerStatus.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaults", "loe", "Defaults", "loe/defaults.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetools", "loe", "Tools", "loe/tools.log", false, "MASTERADMIN", null));

        //LOE Syetem Config
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigprops", "loesystemconfig", "System Props", "loe/systemproperties.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigdb", "loesystemconfig", "Database", "loe/systemdb.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemlicense", "loesystemconfig", "Server License", "loe/systemlicense.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loerobotstxt", "loesystemconfig", "Robots.txt", "loe/systemrobotstxt.log", false, "MASTERADMIN", null));

        //LOE Defaults
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaultsmain", "loedefaults", "Main", "loe/defaults.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypes", "loedefaults", "Log Types", "loe/logtypes-list-system.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplates", "loedefaults", "Templates", "loe/settings-template-main.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loegraphs", "loedefaults", "Graphs", "loe/graphs.log", false, "MASTERADMIN", null));

        //LOE Tools
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetoolsmain", "loetools", "Main", "loe/tools.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemastercookie", "loetools", "Mastercookie", "loe/mastercookie.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeoffensive", "loetools", "Offensive", "loe/offensivewordslist.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebugs", "loetools", "Bugs", "loe/bugs.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemmessage", "loetools", "System Message", "loe/systemmessage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehowto", "loetools", "Howto", "loe/howto.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedaogenerator", "loetools", "DAO Generator", "loe/daogenerator.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedeletedeadaccounts", "loetools", "Delete Dead Accounts", "loe/deletedeadaccounts.log", false, "MASTERADMIN", null));

        //LOE Performance
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loememory", "loeperformance", "Memory", "loe/memory.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedbconnpool", "loeperformance", "DB Conn Pool", "loe/dbconnpool.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loecache", "loeperformance", "Cache", "loe/cache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loecachehibernate", "loeperformance", "Hibernate Cache", "loe/cache-hibernate.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loepagenotfound", "loeperformance", "404s", "loe/pagenotfoundlist.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetrafficbypage", "loeperformance", "Page Load", "loe/trafficbypage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehtmlcache", "loeperformance", "HtmlCache", "loe/htmlcache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetraffichitcache", "loeperformance", "Traffic Cache", "loe/traffichitcache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loestorage", "loeperformance", "Storage", "loe/storage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebandwidthspeed", "loeperformance", "Bandwidth", "loe/bandwidthspeed.log", false, "MASTERADMIN", null));

        //LOE LogTypes
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypessystem", "loelogtypes", "System Log Types", "loe/logtypes-list-system.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesuser", "loelogtypes", "User Log Types", "loe/logtypes-list-user.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesorphan", "loelogtypes", "Orphaned Log Types", "loe/logtypes-list-orphan.log", false, "MASTERADMIN", null));

        //LOE Templates
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesmain", "loetemplates", "System Templates", "loe/settings-template-main.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesuser", "loetemplates", "User Templates", "loe/settings-template-user.log", false, "MASTERADMIN", null));

    }

    public static NavButton[] getAllNavButtons(){
        if(allNavButtons==null){
            createButtons();
        }
        return allNavButtons;
    }

    public static NavButton[] getAllButtonsWithSameParent(String parentNavButton){
        if(allNavButtons==null){
            createButtons();
        }
        NavButton[] out = new NavButton[0];
        for (int i = 0; i < allNavButtons.length; i++) {
            if (allNavButtons[i].parentNavButton.equals(parentNavButton)){
                out = AddToArray.addToNavButtonArray(out, allNavButtons[i]);
            }
        }
        return out;
    }

    public static NavButton getByName(String navButtonName){
        if(allNavButtons==null){
            createButtons();
        }
        for (int i = 0; i < allNavButtons.length; i++) {
            if (allNavButtons[i].navButtonName.equals(navButtonName)){
                return allNavButtons[i];
            }
        }
        return getDefaultNavButton();
    }

    public static NavButton getDefaultNavButton(){
        if(allNavButtons==null){
            createButtons();
        }
        for (int i = 0; i < allNavButtons.length; i++) {
            if (allNavButtons[i].navButtonName.equals(defaultNavButtonName)){
                return allNavButtons[i];
            }
        }
        return null;
    }

}
