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
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("adminhome", "", "MY HOME", "myhome/index.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logs", "", "LOGS", "myhome/logs.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entries", "", "ENTRIES", "myhome/entries-recent.log", false, ""));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodes", "", "EPISODES", "myhome/episodes.log", false, ""));
        //allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiods", "", "PERIODS", "myhome/timeperiods.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("graphs", "", "GRAPHS", "myhome/graphs.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("traffic", "", "TRAFFIC", "myhome/traffic.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("people", "", "PEOPLE", "myhome/people.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("groups", "", "GROUPS", "myhome/groups.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settings", "", "SETTINGS", "myhome/settings-siteprops.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("tools", "", "TOOLS", "myhome/tools.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("pl", "", "PRIVATE LABEL", "pl/index.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loe", "", "LOE ADMIN", "loe/index.log", false, "MASTERADMIN"));


        //Sites
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesmain", "adminhome", "MANAGE SITES", "myhome/sites.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("sitesnewsite", "adminhome", "CREATE A NEW SITE", "myhome/sites-newsite.log", false, ""));

        //Versions
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("versionsmain", "adminhome", "RELEASE NOTES", "myhome/versions.log", false, ""));


        //Logs Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsmain", "logs", "LOGS VS. LOG TYPES", "myhome/logs.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsyourlogs", "logs", "YOUR LOGS", "myhome/logs-log-list.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logslogtypes", "logs", "YOUR CUSTOM LOG TYPES", "myhome/logs-type-list.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlog", "logs", "CREATE A NEW LOG", "myhome/logs-newlog.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewlogtype", "logs", "CREATE A NEW CUSTOM LOG TYPE", "myhome/logs-type-properties.log?action=startadd", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("logsnewstatic", "logs", "STATIC PAGES", "myhome/logs-contentpage-edit.log", false, ""));
        //allNavButtons = reger.core.Util.addToNavButtonArray(allNavButtons, new NavButton("logsstaticcontentpages", "logs", "STATIC CONTENT PAGES", "myhome/logs-contentpage.log", false, ""));

        //Entries Buttons
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesrecent", "entries", "RECENT", "myhome/entries-recent.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearchtop", "entries", "SEARCH", "myhome/entries-simplesearch.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriesdraft", "entries", "DRAFTS", "myhome/entries-draft.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entrieslocations", "entries", "LOCATIONS", "myhome/entries-locations.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodes", "entries", "EPISODES", "myhome/episodes.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiods", "entries", "PERIODS", "myhome/timeperiods.log", false, ""));

        //Entries Search
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessimplesearch", "entriessearchtop", "SIMPLE SEARCH", "myhome/entries-simplesearch.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessearch", "entriessearchtop", "ADVANCED SEARCH", "myhome/entries.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("entriessaved", "entriessearchtop", "SAVED SEARCHES", "myhome/entries-savedsearches.log", false, ""));

        //Graphs
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("graphsmain", "graphs", "GRAPHS", "myhome/graphs.log", false, ""));


        //Episodes
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodesmain", "episodes", "YOUR EPISODES", "myhome/episodes.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodeswhatare", "episodes", "WHAT ARE EPISODES?", "myhome/episodes-whatare.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("episodesnew", "episodes", "ADD A NEW EPISODE", "myhome/episodes-new.log", false, ""));


        //Time Periods
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodsmain", "timeperiods", "MAIN", "myhome/timeperiods.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodsadd", "timeperiods", "ADD TIME PERIOD", "myhome/timeperiods-add.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("timeperiodshelp", "timeperiods", "WHAT ARE TIME PERIODS?", "myhome/timeperiods-help.log", false, ""));


        //Traffic
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficmain", "traffic", "MAIN", "myhome/traffic.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficentries", "traffic", "ENTRIES", "myhome/traffic-entries.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficlogs", "traffic", "LOGS", "myhome/traffic-logs.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficfiles", "traffic", "FILES", "myhome/traffic-images.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficmessages", "traffic", "MESSAGES", "myhome/traffic-messages.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("traffictrackback", "traffic", "TRACKBACKS", "myhome/traffic-trackback.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficbrowsers", "traffic", "BROWSERS", "myhome/traffic-browsers.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficreferers", "traffic", "REFERERS", "myhome/traffic-referers.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("trafficclicks", "traffic", "CLICKS", "myhome/traffic-rawclicks.log", false, ""));

        //People
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplemain", "people", "MAIN", "myhome/people.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplespecialaccess", "people", "PEOPLE SPECIAL ACCESS", "myhome/people-authors.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleaddauthor", "people", "ADD AUTHOR", "myhome/people-accountuser.log?action=newstart", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplefriends", "people", "FRIENDS", "myhome/people-friends.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleinvite", "people", "INVITE", "myhome/people-friends-invite.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplefind", "people", "FIND PEOPLE", "myhome/people-find.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peopleinbox", "people", "INBOX", "myhome/people-inbox.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("peoplemessage", "people", "SEND MESSAGE", "myhome/people-newmessage.log", false, ""));

        //Groups
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("groupsmain", "groups", "MAIN", "myhome/groups.log", false, ""));

        //Settings
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingssiteprops", "settings", "SITE SETTINGS", "myhome/settings-siteprops.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingssettings", "settings", "USER SETTINGS", "myhome/settings-accountuser.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingstemplate", "settings", "SITE LOOK & FEEL TEMPLATES", "myhome/settings-template-main.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsprofile", "settings", "YOUR PROFILE", "myhome/settings-profile.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsfavesites", "settings", "FAVORITE SITES", "myhome/settings-favesites.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsacctstatus", "settings", "LICENSE STATUS", "myhome/accountstatus.log", false, ""));



        //Profile
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsprofilemain", "settingsprofile", "MAIN", "myhome/settings-profile.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsaddprofileimage", "settingsprofile", "ADD PROFILE IMAGE", "myhome/settings-addprofileimage.log", false, ""));

        //Skins
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingsskinsmain", "settingsskins", "EASY SKINS", "myhome/settings-skin.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("settingscustomskin", "settingsskins", "CUSTOM SKINS", "myhome/settings-skin-custom.log", false, ""));

        //Tools
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmain", "tools", "MAIN", "myhome/tools.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphone", "tools", "EMAIL/CAMPHONE", "myhome/tools-emailapi-emailaddresses.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsapi", "tools", "OPEN APIs", "myhome/tools-api.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsrss", "tools", "RSS XML FEEDS", "myhome/tools-rssfeeds.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsmobile", "tools", "MOBILE ACCESS", "myhome/tools-mobile.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsjavascript", "tools", "JAVASCRIPT", "myhome/tools-javascriptpublishing.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolssupercookie", "tools", "SUPERCOOKIE", "myhome/tools-supercookie.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolstaggame", "tools", "KEYWORD TAG GAME", "myhome/tools-taggame.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolslinkrot", "tools", "LINK ROT", "myhome/tools-linkrot.log", false, ""));

        //Tools Email/Camphone
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphoneemail", "toolsemailcamphone", "EMAIL ADDRESSES", "myhome/tools-emailapi-emailaddresses.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphonephone", "toolsemailcamphone", "PHONE ADDRESSES", "myhome/tools-emailapi-phoneaddresses.log", false, ""));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("toolsemailcamphonesettings", "toolsemailcamphone", "SETTINGS", "myhome/tools-emailapi-settings.log", false, ""));

        //PL
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plmain", "pl", "MAIN", "pl/index.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentryapproval", "pl", "ENTRY APPROVAL", "pl/entryapproval.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plflaggedentries", "pl", "FLAGGED ENTRIES", "pl/flaggedentries.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plnewaccountapproval", "pl", "NEW ACCOUNT APPROVAL", "pl/newaccountapproval.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("placcounts", "pl", "ACCOUNTS", "pl/accounts.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plentries", "pl", "ENTRIES", "pl/entries.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plbandwidth", "pl", "BANDWIDTH", "pl/bandwidth.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("plfiles", "pl", "FILES", "pl/files.log", false, "PLADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("ploffensivewords", "pl", "OFFENSIVE WORDS", "pl/offensivewordslist.log", false, "PLADMIN"));

        //LOE
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemain", "loe", "MAIN", "loe/index.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfig", "loe", "SYSTEM SETUP", "loe/systemproperties.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeperformance", "loe", "PERFORMANCE", "loe/memory.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeeventlog", "loe", "EVENT LOG", "loe/viewevents.jsp", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loescheduler", "loe", "SCHEDULER", "loe/schedulerStatus.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loepladmin", "loe", "PRIVATE LABELS", "loe/pl.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaults", "loe", "DEFAULTS", "loe/defaults.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetools", "loe", "TOOLS", "loe/tools.log", false, "MASTERADMIN"));

        //LOE Syetem Config
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigprops", "loesystemconfig", "SYSTEM PROPS", "loe/systemproperties.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemconfigdb", "loesystemconfig", "DATABASE SETUP", "loe/systemdb.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemlicense", "loesystemconfig", "SERVER LICENSE", "loe/systemlicense.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loerobotstxt", "loesystemconfig", "ROBOTS.TXT", "loe/systemrobotstxt.log", false, "MASTERADMIN"));


        //LOE Defaults
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedefaultsmain", "loedefaults", "MAIN", "loe/defaults.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypes", "loedefaults", "LOG TYPES", "loe/logtypes-list-system.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplates", "loedefaults", "TEMPLATES", "loe/settings-template-main.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loegraphs", "loedefaults", "GRAPHS", "loe/graphs.log", false, "MASTERADMIN"));

        //LOE Tools
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetoolsmain", "loetools", "MAIN", "loe/tools.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loemastercookie", "loetools", "MASTERCOOKIE", "loe/mastercookie.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loeoffensive", "loetools", "OFFENSIVE", "loe/offensivewordslist.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebugs", "loetools", "BUGS", "loe/bugs.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesystemmessage", "loetools", "SYSTEM MESSAGE", "loe/systemmessage.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehowto", "loetools", "HOWTO", "loe/howto.log", false, "MASTERADMIN"));

        //LOE Performance
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loememory", "loeperformance", "MEMORY", "loe/memory.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loedbconnpool", "loeperformance", "DB CONNECTION POOL", "loe/dbconnpool.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loesessions", "loeperformance", "SESSIONS", "loe/sessions.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loepagenotfound", "loeperformance", "404s", "loe/pagenotfoundlist.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetrafficbypage", "loeperformance", "PAGE LOAD", "loe/trafficbypage.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loehtmlcache", "loeperformance", "HTMLCACHE", "loe/htmlcache.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetraffichitcache", "loeperformance", "TRAFFIC CACHE", "loe/traffichitcache.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loestorage", "loeperformance", "STORAGE", "loe/storage.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loebandwidthspeed", "loeperformance", "BANDWIDTH SPEED", "loe/bandwidthspeed.log", false, "MASTERADMIN"));

        //LOE LogTypes
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypessystem", "loelogtypes", "SYSTEM LOG TYPES", "loe/logtypes-list-system.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesuser", "loelogtypes", "USER LOG TYPES", "loe/logtypes-list-user.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loelogtypesorphan", "loelogtypes", "ORPHANED LOG TYPES", "loe/logtypes-list-orphan.log", false, "MASTERADMIN"));

        //LOE Templates
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesmain", "loetemplates", "SYSTEM TEMPLATES", "loe/settings-template-main.log", false, "MASTERADMIN"));
        allNavButtons = AddToArray.addToNavButtonArray(allNavButtons, new NavButton("loetemplatesuser", "loetemplates", "USER TEMPLATES", "loe/settings-template-user.log", false, "MASTERADMIN"));

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
