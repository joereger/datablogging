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
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("adminhome", "", "Dashboard", "myhome/index.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logs", "", "Logs", "myhome/logs-log-list.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entries", "", "Posts", "myhome/entries-recent.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("files", "", "Files", "myhome/files.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("graphs", "", "Graphs", "myhome/graphs.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("traffic", "", "Traffic", "myhome/traffic.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("people", "", "People", "myhome/people.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("groups", "", "Groups", "myhome/groups.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settings", "", "Settings", "myhome/settings-siteprops.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("tools", "", "Tools", "myhome/tools.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pl", "", "Pl", "pl/index.log", false, "PLADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loe", "", "Sysadmin", "loe/index.log", false, "MASTERADMIN", null));


        //Sites
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesmain", "adminhome", "Manage Sites", "myhome/sites.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesnewsite", "adminhome", "New Site", "myhome/sites-newsite.log", false, "", null));

        //Versions
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("versionsmain", "adminhome", "Release Notes", "myhome/versions.log", false, "", null));


        //Logs Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsyourlogs", "logs", "Your Logs", "myhome/logs-log-list.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsmain", "logs", "Logs vs Log Types", "myhome/logs.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logslogtypes", "logs", "Custom Log Types", "myhome/logs-type-list.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlog", "logs", "New Log", "myhome/logs-newlog.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlogtype", "logs", "New Log Type", "myhome/logs-type-properties.log?action=startadd", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewstatic", "logs", "Pages", "myhome/logs-contentpage-edit.log", false, "", null));
        //allNavButtons = reger.core.Util.addToNavButtonArray(allNavButtons, new NavButton("logsstaticcontentpages", "logs", "STATIC CONTENT PAGES", "myhome/logs-contentpage.log", false, ""));

        //Entries Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesrecent", "entries", "Recent", "myhome/entries-recent.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearchtop", "entries", "Search", "myhome/entries-simplesearch.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesdraft", "entries", "Drafts", "myhome/entries-draft.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entrieslocations", "entries", "Locations", "myhome/entries-locations.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodes", "entries", "Episodes", "myhome/episodes.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiods", "entries", "Periods", "myhome/timeperiods.log", false, "", null));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriespolls", "entries", "Polls", "myhome/entries-polls.log", false, "", null));

        //Entries Search
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessimplesearch", "entriessearchtop", "Simple Search", "myhome/entries-simplesearch.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearch", "entriessearchtop", "Advanced Search", "myhome/entries.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessaved", "entriessearchtop", "Saved Searches", "myhome/entries-savedsearches.log", false, "", null));

        //Graphs
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("graphsmain", "graphs", "Graphs", "myhome/graphs.log", false, "", null));

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
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsprofile", "settings", "Your Profile", "myhome/settings-profile.log", false, "", null));
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
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmain", "tools", "MAIN", "myhome/tools.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsimport", "tools", "IMPORT ENTRIES", "myhome/tools-import.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphone", "tools", "EMAIL/CAMPHONE", "myhome/tools-emailapi-emailaddresses.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsapi", "tools", "OPEN APIs", "myhome/tools-api.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsrss", "tools", "RSS XML FEEDS", "myhome/tools-rssfeeds.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmobile", "tools", "MOBILE ACCESS", "myhome/tools-mobile.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsjavascript", "tools", "JAVASCRIPT", "myhome/tools-javascriptpublishing.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolssupercookie", "tools", "SUPERCOOKIE", "myhome/tools-supercookie.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolstaggame", "tools", "KEYWORD TAG GAME", "myhome/tools-taggame.log", false, "", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolslinkrot", "tools", "LINK ROT", "myhome/tools-linkrot.log", false, "", null));
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
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmain", "pl", "MAIN", "pl/index.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmanage", "pl", "SETTINGS", "pl/plmanage.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plsitecontent", "pl", "SITE CONTENT", "pl/plsitecontent.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pltemplates", "pl", "TEMPLATES", "pl/pltemplates.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pleventtype", "pl", "LOG TYPES", "pl/pleventtype.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plpeers", "pl", "PEERS", "pl/plpeers.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmoderation", "pl", "MODERATION", "pl/plmoderationmain.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("placcounts", "pl", "ACCOUNTS", "pl/accounts.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentries", "pl", "ENTRIES", "pl/entries.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plbandwidth", "pl", "BANDWIDTH", "pl/bandwidth.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plfiles", "pl", "FILES", "pl/files.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("ploffensivewords", "pl", "OFFENSIVE", "pl/offensivewordslist.log", false, "PLADMIN", new String[]{"plid"}));


        //Private Label Moderation
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmoderationmain", "plmoderation", "MAIN", "pl/entryapproval.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentryapproval", "plmoderation", "ENTRIES REQUIRING APPROVAL", "pl/entryapproval.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plflaggedentries", "plmoderation", "ENTRIES FLAGGED FOR REVIEW", "pl/flaggedentries.log", false, "PLADMIN", new String[]{"plid"}));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plnewaccountapproval", "plmoderation", "NEW ACCOUNTS REQUIRING APPROVAL", "pl/newaccountapproval.log", false, "PLADMIN", new String[]{"plid"}));

        //LOE
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemain", "loe", "MAIN", "loe/index.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfig", "loe", "SYSTEM SETUP", "loe/systemproperties.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeperformance", "loe", "PERFORMANCE", "loe/memory.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeeventlog", "loe", "EVENT LOG", "loe/viewevents.jsp", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loescheduler", "loe", "SCHEDULER", "loe/schedulerStatus.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaults", "loe", "DEFAULTS", "loe/defaults.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetools", "loe", "TOOLS", "loe/tools.log", false, "MASTERADMIN", null));

        //LOE Syetem Config
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigprops", "loesystemconfig", "SYSTEM PROPS", "loe/systemproperties.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigdb", "loesystemconfig", "DATABASE SETUP", "loe/systemdb.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemlicense", "loesystemconfig", "SERVER LICENSE", "loe/systemlicense.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loerobotstxt", "loesystemconfig", "ROBOTS.TXT", "loe/systemrobotstxt.log", false, "MASTERADMIN", null));

        //LOE Defaults
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaultsmain", "loedefaults", "MAIN", "loe/defaults.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypes", "loedefaults", "LOG TYPES", "loe/logtypes-list-system.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplates", "loedefaults", "TEMPLATES", "loe/settings-template-main.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loegraphs", "loedefaults", "GRAPHS", "loe/graphs.log", false, "MASTERADMIN", null));

        //LOE Tools
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetoolsmain", "loetools", "MAIN", "loe/tools.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemastercookie", "loetools", "MASTERCOOKIE", "loe/mastercookie.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeoffensive", "loetools", "OFFENSIVE", "loe/offensivewordslist.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebugs", "loetools", "BUGS", "loe/bugs.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemmessage", "loetools", "SYSTEM MESSAGE", "loe/systemmessage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehowto", "loetools", "HOWTO", "loe/howto.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedaogenerator", "loetools", "DAO GENERATOR", "loe/daogenerator.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedeletedeadaccounts", "loetools", "DELETE DEAD ACCOUNTS", "loe/deletedeadaccounts.log", false, "MASTERADMIN", null));

        //LOE Performance
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loememory", "loeperformance", "MEMORY", "loe/memory.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedbconnpool", "loeperformance", "DB CONNECTION POOL", "loe/dbconnpool.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loecache", "loeperformance", "CACHE", "loe/cache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loecachehibernate", "loeperformance", "HIBERNATE CACHE", "loe/cache-hibernate.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loepagenotfound", "loeperformance", "404s", "loe/pagenotfoundlist.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetrafficbypage", "loeperformance", "PAGE LOAD", "loe/trafficbypage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehtmlcache", "loeperformance", "HTMLCACHE", "loe/htmlcache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetraffichitcache", "loeperformance", "TRAFFIC CACHE", "loe/traffichitcache.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loestorage", "loeperformance", "STORAGE", "loe/storage.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebandwidthspeed", "loeperformance", "BANDWIDTH SPEED", "loe/bandwidthspeed.log", false, "MASTERADMIN", null));

        //LOE LogTypes
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypessystem", "loelogtypes", "SYSTEM LOG TYPES", "loe/logtypes-list-system.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesuser", "loelogtypes", "USER LOG TYPES", "loe/logtypes-list-user.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesorphan", "loelogtypes", "ORPHANED LOG TYPES", "loe/logtypes-list-orphan.log", false, "MASTERADMIN", null));

        //LOE Templates
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesmain", "loetemplates", "SYSTEM TEMPLATES", "loe/settings-template-main.log", false, "MASTERADMIN", null));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesuser", "loetemplates", "USER TEMPLATES", "loe/settings-template-user.log", false, "MASTERADMIN", null));

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
