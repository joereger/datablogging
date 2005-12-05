package reger.search;

import reger.mega.FieldQueryElement;
import reger.mega.FieldType;
import reger.*;
import reger.cache.LogCache;
import reger.core.db.Db;
import reger.core.XmlSerializer;
import reger.core.Debug;

import java.util.Calendar;
import java.util.Vector;


/**
 * Searches entries.
 */
public class SearchEntries {

    //Things a user can set to affect the results of a search.
    private SearchParameters searchParameters = new SearchParameters();
    private boolean linkResultsToAdmin = false;


    //The session of the searcher for security purposes
    private reger.UserSession userSessionOfSearcher=null;

    //Entry results
    public SearchResult[] entrySearchResults=null;

    //Sql Strings
    private String fieldSql = "";
    private String accountSql = "";
    private String logidSql = "";
    private String eventtypeidSql = "";
    private String permissionSql = "";
    private String locationidSql = "";
    private int limitMin = 0;
    private int limitMax = 25;
    private int currentpage = 1;
    private String dateSql = "";
    private String plSql = "";

    //Flag telling the object that it's exhausted database entries that fulfill non-megadata parameters like date, log, etc.
    private boolean exhaustedDatabase = false;

    public SearchEntries(){

    }

    public SearchEntries(int savedSearchId){
        searchParameters = new SearchParameters(savedSearchId);
    }

    public SearchEntries(SearchParameters searchParameters){
        this.searchParameters = searchParameters;
    }

    public void doSearch() {

        //If we need to go get more results, let's do it
        while (getNumberOfResults()<searchParameters.numberOfResultsToReturn && !exhaustedDatabase){
            runSqlToGetResults();
            //This causes the calls to the database to get the next set of results.
            currentpage = currentpage + 1;
        }

        Debug.debug(5, "", "SearchEntries.java - searchParameters serialized:<br>"+reger.core.Util.serializeToString(searchParameters));

    }



    public void populateSearchParametersFromSerializedFormField(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("serializedsearch")!=null && !request.getParameter("serializedsearch").equals("")){
            try{
                searchParameters = (SearchParameters)XmlSerializer.deSerializeFromXML(java.net.URLDecoder.decode(request.getParameter("serializedsearch"), "UTF-8"));
            } catch (Exception e){
                Debug.errorsave(e, "");
            }
        }
    }

    public void populateSearchParametersFromDB(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("savedsearchid")!=null && reger.core.Util.isinteger(request.getParameter("savedsearchid"))){
            int savedSearchId = Integer.parseInt(request.getParameter("savedsearchid"));
            searchParameters = new SearchParameters(savedSearchId);
        }
    }

    public String getSearchParametersAsSerializedFormTag(){
        String str = XmlSerializer.serializeToXML(searchParameters);
        String tag = "";
        try{
            tag = "<input type=hidden name='serializedsearch' value=\""+java.net.URLEncoder.encode(str, "UTF-8")+"\">";
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
        return tag;
    }




    private void setupSqlStrings(){
        //Set all strings to ""
        fieldSql = "";
        accountSql = "";
        logidSql = "";
        eventtypeidSql = "";
        permissionSql = "";
        locationidSql = "";
        plSql = "";

        //Accounts to search
        accountSql = searchParameters.getAccountsToSearchAsSqlStatement();

        //Fields to return
        fieldSql = "DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid";

        //Logs to search
        logidSql = searchParameters.getLogsToSearchAsSqlStatement();

        //Eventtypes to search
        eventtypeidSql = searchParameters.getEventtypesToSearchAsSqlStatement();

        //Permission sql
        if (userSessionOfSearcher!=null && userSessionOfSearcher.getAccount()!=null && userSessionOfSearcher.getAccount().getAccountid()>0){
            //Limit to public logs and those logs that the user has explicit access to
            //@todo Only searches your own site... not all those you have access to
            permissionSql = permissionSql + " AND (megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' OR " + userSessionOfSearcher.getAccountuser().LogsUserCanViewQueryend(userSessionOfSearcher.getAccount().getAccountid()) + ") ";
        } else {
            //There's no user so only search public logs
            permissionSql = permissionSql + " AND (megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"') ";
        }

        //Private Label sql
        if (userSessionOfSearcher!=null && userSessionOfSearcher.getPl()!=null){
            //Limit to this pl and those that it has a peering agreement with
            plSql = userSessionOfSearcher.getPl().getPeerSql();
        } else {
            //@todo There's no user so search all pls?
        }

        //Locations to search
        locationidSql = searchParameters.getLocationssToSearchAsSqlStatement();

        //Paging is used here not for the user's UI but so that
        //I can go to the database in small chunks to find the proper number of
        //results when people search on megadata
        limitMin = (currentpage * searchParameters.numberOfResultsToReturn) - searchParameters.numberOfResultsToReturn;
        limitMax = searchParameters.numberOfResultsToReturn;


        //Start Build the date-limiting SQL
        if (searchParameters.daterange==reger.Vars.DATERANGEALLTIME){
            //Do nothing... no limiting sql for date... user chose all time
        } else if (searchParameters.daterange==reger.Vars.DATERANGELASTXUNITS) {
            if (searchParameters.lastxunits==Calendar.DATE){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xDaysAgoStart(Calendar.getInstance(), searchParameters.lastx)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (searchParameters.lastxunits==Calendar.WEEK_OF_YEAR){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoStart(Calendar.getInstance(), searchParameters.lastx)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (searchParameters.lastxunits==Calendar.MONTH){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoStart(Calendar.getInstance(), searchParameters.lastx)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (searchParameters.lastxunits==Calendar.YEAR){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xYearsAgoStart(Calendar.getInstance(), searchParameters.lastx)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            }
        } else if (searchParameters.daterange==reger.Vars.DATERANGESPECIFIED) {
            dateSql = " AND event.date>='"+reger.core.TimeUtils.dateformatfordb(searchParameters.dateFromGmt)+"' AND event.date<='"+reger.core.TimeUtils.dateformatfordb(searchParameters.dateToGmt)+"'";
        }
        Debug.debug(5, "", "SearchEntries.java - dateSql=<br>" + dateSql);

    }

    private void runSqlToGetResults(){

        //Setup the SQL Strings
        setupSqlStrings();

        //Reusable vars
        String sql="";

        //Build the match statements.  If no searchTerms, don't do Match search.
        String sqlMatchEntries = "(1=1)";
        String sqlMatchEntriesScore = "'1'";
        String sqlMatchFiles = "(1=1)";
        String sqlMatchFilesScore = "'1'";
        String sqlMatchTrackback = "(1=1)";
        String sqlMatchTrackbackScore = "'1'";
        String sqlMatchMessage = "(1=1)";
        String sqlMatchMessageScore = "'1'";
        if (!searchParameters.searchTerms.equals("")){
            sqlMatchEntries = "MATCH (title,event.comments) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)>0";
            sqlMatchEntriesScore = "MATCH (title,event.comments) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)";
            sqlMatchFiles = "MATCH (image.description,image.image) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)>0";
            sqlMatchFilesScore = "MATCH (image.description,image.image) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)";
            sqlMatchTrackback = "MATCH (trackback.blogname,trackback.posttitle,trackback.excerpt) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)>0";
            sqlMatchTrackbackScore = "MATCH (trackback.blogname,trackback.posttitle,trackback.excerpt) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)";
            sqlMatchMessage = "MATCH (message.messagefrom,message.message) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)>0";
            sqlMatchMessageScore = "MATCH (message.messagefrom,message.message) AGAINST ('"+ reger.core.Util.cleanForSQL(searchParameters.searchTerms) +"' IN BOOLEAN MODE)";
        }

        //Note the structure here.
        //Four search queries united by UNIONS.
        //fieldSQL is a list of entry fields common to all search results.
        //After that is a text string telling me which type of result it is.
        //And after that are fields that are specific (i.e. imageid, message text, etc)

        //Entry Search
        sql="(SELECT "+ fieldSql +", '"+SearchResult.SEARCHRESULTOBJECTTYPEENTRY+"',"+sqlMatchEntriesScore+" AS score FROM event, megalog, account, pl WHERE "+plSql+" AND account.plid=pl.plid AND "+sqlMatchEntries+" AND event.accountid=account.accountid AND event.logid=megalog.logid "+accountSql+" AND "+reger.Entry.sqlOfLiveEntry+" "+ logidSql + " " + eventtypeidSql + " " + locationidSql + " " + permissionSql + " " + dateSql +")";

        //Files Search
        sql= sql + " UNION " + "(SELECT "+ fieldSql +", '"+SearchResult.SEARCHRESULTOBJECTTYPEFILE+"',"+sqlMatchFilesScore+" AS score FROM event, megalog, account, image, pl WHERE "+plSql+" AND account.plid=pl.plid AND "+sqlMatchFiles+" AND image.eventid=event.eventid AND event.accountid=account.accountid AND event.logid=megalog.logid "+accountSql+" AND "+reger.Entry.sqlOfLiveEntry+" "+ logidSql + " " + eventtypeidSql + " " + locationidSql + " " + permissionSql + " " + dateSql +")";

        //Trackback Search
        sql= sql + " UNION " + "(SELECT "+ fieldSql +", '"+SearchResult.SEARCHRESULTOBJECTTYPETRACKBACK+"',"+sqlMatchTrackbackScore+" AS score FROM event, megalog, account, trackback, pl WHERE "+plSql+" AND account.plid=pl.plid AND "+sqlMatchTrackback+" AND trackback.eventid=event.eventid AND event.accountid=account.accountid AND trackback.isapproved='1' AND event.logid=megalog.logid "+accountSql+" AND "+reger.Entry.sqlOfLiveEntry+" "+ logidSql + " " + eventtypeidSql + " " + locationidSql + " " + permissionSql + " " + dateSql +")";

        //Message Search
        sql= sql + " UNION " + "(SELECT "+ fieldSql +", '"+SearchResult.SEARCHRESULTOBJECTTYPEMESSAGE+"',"+sqlMatchMessageScore+" AS score FROM event, megalog, account, message, pl WHERE "+plSql+" AND account.plid=pl.plid AND "+sqlMatchMessage+" AND message.eventid=event.eventid AND message.isapproved='1' AND event.accountid=account.accountid AND event.logid=megalog.logid "+accountSql+" AND "+reger.Entry.sqlOfLiveEntry+" "+ logidSql + " " + eventtypeidSql + " " + locationidSql + " " + permissionSql + " " + dateSql +")";

        //Put the ORDER BY and LIMIT statements in there
        sql = sql + "ORDER BY score DESC, eventdate DESC LIMIT "+ limitMin +","+ limitMax;



        //Good
        //(SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '1','1' AS score FROM event, megalog, account WHERE (1=1) AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1' OR (megalog.accountid='50' AND (megalog.logaccess='1' OR megalog.logaccess='0' OR megalog.logid='40'))) AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '2','1' AS score FROM event, megalog, account, image WHERE (1=1) AND image.eventid=event.eventid AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1' OR (megalog.accountid='50' AND (megalog.logaccess='1' OR megalog.logaccess='0' OR megalog.logid='40'))) AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '3','1' AS score FROM event, megalog, account, trackback WHERE (1=1) AND trackback.eventid=event.eventid AND event.accountid=account.accountid AND trackback.isapproved='1' AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1' OR (megalog.accountid='50' AND (megalog.logaccess='1' OR megalog.logaccess='0' OR megalog.logid='40'))) AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '4','1' AS score FROM event, megalog, account, message WHERE (1=1) AND message.eventid=event.eventid AND message.isapproved='1' AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1' OR (megalog.accountid='50' AND (megalog.logaccess='1' OR megalog.logaccess='0' OR megalog.logid='40'))) AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00')ORDER BY score DESC, eventdate DESC LIMIT 200,25

        //Bad
        //(SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '1','1' AS score FROM event, megalog, account WHERE (1=1) AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1') AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '2','1' AS score FROM event, megalog, account, image WHERE (1=1) AND image.eventid=event.eventid AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1') AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '3','1' AS score FROM event, megalog, account, trackback WHERE (1=1) AND trackback.eventid=event.eventid AND event.accountid=account.accountid AND trackback.isapproved='1' AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1') AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00') UNION (SELECT DISTINCT event.title, event.comments, event.date AS eventdate, event.eventid, event.logid, event.accountid, account.accounturl, megalog.eventtypeid, '4','1' AS score FROM event, megalog, account, message WHERE (1=1) AND message.eventid=event.eventid AND message.isapproved='1' AND event.accountid=account.accountid AND event.logid=megalog.logid AND (event.isdraft='0' AND event.isapproved='1' AND event.istemporary='0' AND event.ismoderatorapproved='1' AND event.requiresmoderatorapproval='0') AND megalog.logid IN(2) AND (megalog.logaccess='1') AND event.date>='2000-03-06 00:00:00' AND event.date<='2005-03-06 00:00:00')ORDER BY score DESC, eventdate DESC LIMIT 0,5000



        Debug.debug(5, "", "SearchEntries.java sql for search: <br>"+sql);
        //Return the actual records needed
        //-----------------------------------
        //-----------------------------------
        String[][] rsEvent= reger.core.db.Db.RunSQL(sql, 5000);
        //-----------------------------------
        //-----------------------------------
        if (rsEvent!=null && rsEvent.length>0){

            //If the number of results from the database was less than the
            Debug.debug(5, "", "SearchEntries.java - We have "+rsEvent.length+" search results.");
            if (rsEvent.length<=searchParameters.numberOfResultsToReturn){
                exhaustedDatabase = true;
            }

            //Iterate the results from the database
            for(int i=0; i<rsEvent.length; i++){

                boolean addToResults = true;


                //So, now we have a list of entries
                //Need to do the mega search fields
                if (searchParameters.fieldQueryElements!=null){
                    Debug.debug(5, "", "SearchEntries.java: we have fieldQueryElements. eventid=" + rsEvent[i][3]);

                    //Create an Entry object, loading
                    //reger.Entry entry = new reger.Entry(Integer.parseInt(rsEvent[i][3]));

                    //Get the fields that relate to this entry's log
                    Log logByLogid = LogCache.get(Integer.parseInt(rsEvent[i][4]));
                    reger.mega.FieldType[] fieldsInEntryLog = AllFieldsInSystem.copyFieldTypeArray(logByLogid.getFields());



                    //See if it fulfills megadata search
                    if (fieldsInEntryLog!=null){
                        Debug.debug(5, "", "SearchEntries.java: we have megafields. eventid=" + rsEvent[i][3]);
                        for (int j = 0; j < fieldsInEntryLog.length; j++) {

                            //The flag determining whether this fulfills.
                            boolean fulfillsSearch = false;


                            //See if this field is in the list of fieldqueryelements
                            boolean loadAndSearchThisField = false;
                            for (int k = 0; k < searchParameters.fieldQueryElements.length; k++) {
                                FieldQueryElement tmpFqe = searchParameters.fieldQueryElements[k];
                                if (tmpFqe.megafieldid==fieldsInEntryLog[j].getMegafieldid()){
                                    loadAndSearchThisField = true;
                                    break;
                                }
                            }

                            //Load and search
                            if (loadAndSearchThisField){
                                Debug.debug(5, "", "SearchEntries.java: Starting field search.<br>title=" + rsEvent[i][3] + "<br>field=" + fieldsInEntryLog[j].getFieldname());
                                //Load the data
                                fieldsInEntryLog[j].loadDataForEventid(Integer.parseInt(rsEvent[i][3]), Integer.parseInt(rsEvent[i][4]));
                                //See whether to search the log or the eventtype
                                if (searchParameters.isAccountBeingSearched(SearchParameters.ALL)){
                                    //Run fulfillsquery by eventtypeid
                                    fulfillsSearch = fieldsInEntryLog[j].fulfillsQuery(searchParameters.fieldQueryElements, Integer.parseInt(rsEvent[i][7]));
                                } else {
                                    //Run fulfillsquery by logid
                                    fulfillsSearch = fieldsInEntryLog[j].fulfillsQuery(searchParameters.fieldQueryElements, Integer.parseInt(rsEvent[i][4]));
                                }
                                Debug.debug(5, "", "SearchEntries.java: Finished field search.<br>eventid=" + rsEvent[i][3] + "<br>field=" + fieldsInEntryLog[j].getFieldname() + "<br>fulfillsSearch=" + fulfillsSearch);

                            } else {
                                //There were no specific query items for this field so I need to return true
                                fulfillsSearch = true;
                            }

                            //All fields must fulfill the search terms.
                            //It's an AND situation.
                            //So, if any single field fails, I set the flag to false and break the loop to save CPU time.
                            if (!fulfillsSearch){
                                addToResults = false;
                                break;
                            }
                        }
                    }
                }


                if (addToResults){
                    //Create a SearchResult Object
                    reger.search.SearchResult sr = new reger.search.SearchResult();
                    sr.associatedAccountid = Integer.parseInt(rsEvent[i][5]);
                    sr.associatedEventid = Integer.parseInt(rsEvent[i][3]);
                    sr.excerpt = reger.core.Util.truncateString(rsEvent[i][1], 500);
                    sr.idOfObjectReturned = Integer.parseInt(rsEvent[i][3]);
                    sr.title = rsEvent[i][0];
                    sr.typeOfObjectReturned = Integer.parseInt(rsEvent[i][8]);
                    reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rsEvent[i][5]));
                    if (linkResultsToAdmin){
                        if (userSessionOfSearcher!=null && userSessionOfSearcher.getAccountuser().userCanDoAcl("ADDEDITENTRIES", Integer.parseInt(rsEvent[i][5]))){
                            sr.url = ""+acctTmp.getSiteRootUrl() + "/myhome/entry.log?eventid=" + rsEvent[i][3] + "&action=edit";
                        } else {
                            sr.url = ""+acctTmp.getSiteRootUrl() + "/entry.log?eventid=" + rsEvent[i][3];
                        }
                    } else {
                        sr.url = ""+ acctTmp.getSiteRootUrl() + "/entry.log?eventid=" + rsEvent[i][3];
                    }
                    sr.siteName = ""+ acctTmp.getSiteRootUrl() + "/";
                    sr.score = rsEvent[i][9];
                    //Add it to the results array
                    entrySearchResults = AddToArray.addToSearchResultArray(entrySearchResults, sr);
                }
            }
        } else {
            //No results from the DB to work with so make sure the object knows not to continue going to it.
            exhaustedDatabase = true;
            Debug.debug(5, "", "SearchEntries.java - We have 0 search results.");
        }


    }

    /**
     * Figure out how many results are currently in the result set
     */
    public int getNumberOfResults(){
        int numberOfResultsSoFar = 0;
        if (entrySearchResults!=null){
            numberOfResultsSoFar = entrySearchResults.length;
        }
        return numberOfResultsSoFar;
    }



    public String getSearchSummaryHtml(){
        StringBuffer mb = new StringBuffer();


        //Saved Name
        if (!searchParameters.name.equals("")){
            mb.append("This Search is Saved As: ");
            mb.append("<br>");
            mb.append("<font face=arial size=-2 class=tinyfont>");
            mb.append(searchParameters.name);
            mb.append("</font>");
            mb.append("<br><br>");
        }


        //Keywords
        mb.append("Search Keywords: ");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 class=tinyfont>");
        if (!searchParameters.searchTerms.equals("")){
            mb.append(searchParameters.searchTerms);
        } else {
            mb.append("None.");
        }
        mb.append("</font>");
        mb.append("<br><br>");


        //Dates
        mb.append("Date Range to Search:");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 class=tinyfont>");
        if (searchParameters.daterange==reger.Vars.DATERANGEALLTIME){
            mb.append("All Dates.");
        } else if (searchParameters.daterange==reger.Vars.DATERANGELASTXUNITS) {
            mb.append("Last");
            mb.append(" ");
            mb.append(searchParameters.lastx);
            mb.append(" ");
            if (searchParameters.lastxunits==Calendar.DATE){
                mb.append("Day(s)");
            } else if (searchParameters.lastxunits==Calendar.WEEK_OF_YEAR){
                mb.append("Week(s)");
            } else if (searchParameters.lastxunits==Calendar.MONTH){
                mb.append("Month(s)");
            } else if (searchParameters.lastxunits==Calendar.YEAR){
                mb.append("Year(s)");
            }
        } else if (searchParameters.daterange==reger.Vars.DATERANGESPECIFIED) {
            mb.append("From Date:");
            if (searchParameters.dateFromGmt!=null){
                mb.append(reger.core.TimeUtils.dateformatdate(reger.core.TimeUtils.gmttousertime(searchParameters.dateFromGmt, userSessionOfSearcher.getAccount().getTimezoneid())));
            } else {
                mb.append("Not Specified.");
            }
            mb.append("<br>");

            mb.append("To Date:");
            if (searchParameters.dateToGmt!=null){
                mb.append(reger.core.TimeUtils.dateformatdate(reger.core.TimeUtils.gmttousertime(searchParameters.dateToGmt, userSessionOfSearcher.getAccount().getTimezoneid())));
            } else {
                mb.append("Not Specified.");
            }
        } else {
            mb.append("All Dates.");
        }
        mb.append("</font>");
        mb.append("<br><br>");



        //Accounts
        if (searchParameters.accountidsToSearch!=null && searchParameters.accountidsToSearch.length>0){
            if (!searchParameters.isAccountBeingSearched(SearchParameters.ALL)){
                for (int i = 0; i < searchParameters.accountidsToSearch.length; i++) {
                    reger.Account tmpAcct = new reger.Account(searchParameters.accountidsToSearch[i]);
                    mb.append(tmpAcct.getHomepagetitle() + ":");
                    mb.append("<font face=arial size=-2 class=tinyfont>");
                    //Logs Begin
                    if (searchParameters.logsToSearch!=null){
                        mb.append("<ul>");
                        //Get all logs for this account
                        Vector logsForThisAcct = LogCache.allLogsForAccount(searchParameters.accountidsToSearch[i]);
                        for (int xx = 0; xx < logsForThisAcct.size(); xx++) {
                            Log log = (Log) logsForThisAcct.elementAt(xx);
                            //If this is being searched or ALL is being searched
                            if (searchParameters.isLogidBeingSearched(log.getLogid()) || searchParameters.isLogidBeingSearched(SearchParameters.ALL)){
                                //Only show if the log is for this account
                                if(log.getAccountid()==tmpAcct.getAccountid()){
                                    //Only show if user can view
                                    if (userSessionOfSearcher.getAccountuser().userCanViewLog(log.getLogid())){
                                        mb.append("<li>");
                                        mb.append(log.getName());
                                        //Now show activity-specific search params
                                        FieldType[] megaFields = log.getFields();
                                        if (megaFields!=null){
                                            mb.append("<ul>");
                                            for (int k = 0; k < megaFields.length; k++) {
                                                FieldType field = megaFields[k];
                                                //field.loadDefaultData(searchParameters.logsToSearch[i]);
                                                String fieldSummary = field.queryDisplayHtmlSummary(searchParameters.fieldQueryElements, log.getLogid());
                                                //Only if it's not blank
                                                if (!fieldSummary.equals("")){
                                                    //Field title
                                                    mb.append("<li>");
                                                    mb.append(field.getFieldname());

                                                    //Now display the search summary in html form
                                                    mb.append("<ul>");
                                                    mb.append("<li>");
                                                    mb.append(fieldSummary);
                                                    mb.append("</li>");
                                                    mb.append("</ul>");
                                                    mb.append("</li>");
                                                }
                                            }
                                            mb.append("</ul>");
                                        }
                                        mb.append("</li>");
                                    }
                                }
                            }
                        }
                        mb.append("</ul>");
                    } else {
                        mb.append("<ul>");
                        mb.append("<li>");
                        mb.append("All logs being searched on this site.");
                        mb.append("</li>");
                        mb.append("</ul>");
                    }
                    //Logs End




                    mb.append("</font>");

                    mb.append("<br>");
                }
            } else {
                mb.append("All Sites:");
                mb.append("<br>");

                //Eventtypes Begin
                if (searchParameters.eventtypeidsToSearch!=null){
                    mb.append("<ul>");
                    //Get all logs for this account
                    Vector eventTypeidsForPlid = reger.AllMegaLogTypesInSystem.allMegaLogTypesForPlid(userSessionOfSearcher.getPl().getPlid());
                    for (int xx = 0; xx < eventTypeidsForPlid.size(); xx++) {
                        MegaLogType logType = (MegaLogType) eventTypeidsForPlid.elementAt(xx);
                        //If this is being searched or ALL is being searched
                        if (searchParameters.isEventtypeidBeingSearched(logType.getEventtypeid()) || searchParameters.isEventtypeidBeingSearched(SearchParameters.ALL)){

                            mb.append("<li>");
                            mb.append(logType.getMegalogname());
                            //Now show activity-specific search params
                            FieldType[] megaFields = logType.getMegaFields();
                            if (megaFields!=null){
                                mb.append("<ul>");
                                for (int k = 0; k < megaFields.length; k++) {
                                    FieldType field = megaFields[k];
                                    //field.loadDefaultData(searchParameters.logsToSearch[i]);
                                    String fieldSummary = field.queryDisplayHtmlSummary(searchParameters.fieldQueryElements, logType.getEventtypeid());
                                    //Only if it's not blank
                                    if (!fieldSummary.equals("")){
                                        //Field title
                                        mb.append("<li>");
                                        mb.append(field.getFieldname());

                                        //Now display the search summary in html form
                                        mb.append("<ul>");
                                        mb.append("<li>");
                                        mb.append(fieldSummary);
                                        mb.append("</li>");
                                        mb.append("</ul>");
                                        mb.append("</li>");
                                    }
                                }
                                mb.append("</ul>");
                            }
                            mb.append("</li>");

                        }
                    }
                    mb.append("</ul>");
                } else {
                    mb.append("<ul>");
                    mb.append("<li>");
                    mb.append("All log types being searched.");
                    mb.append("</li>");
                    mb.append("</ul>");
                }
                //Eventtypes End



            }
        }
        mb.append("</font>");
        mb.append("<br>");


        //Locations
        mb.append("Locations to Search:");
        mb.append("<br>");
        mb.append("<font face=arial size=-2 class=tinyfont>");
        if (searchParameters.locationidsToSearch!=null && searchParameters.locationidsToSearch.length>0){
            if (!searchParameters.isLocationidBeingSearched(SearchParameters.ALL)){
                String locSql = " (";
                for (int i = 0; i < searchParameters.locationidsToSearch.length; i++) {
                    locSql = locSql + " location.locationid='" + searchParameters.locationidsToSearch[i] + "'";
                    if ((i+1)<searchParameters.locationidsToSearch.length){
                        locSql = locSql + " OR ";
                    }
                }
                locSql = locSql + ") ";
                //-----------------------------------
                //-----------------------------------
                String[][] rstLogs= Db.RunSQL("SELECT DISTINCT location.locationid, locationname FROM location, megalog, event WHERE event.locationid=location.locationid AND event.logid=megalog.logid AND "+locSql+" AND "+userSessionOfSearcher.getAccountuser().LogsUserCanViewQueryend(userSessionOfSearcher.getAccount().getAccountid())+" ORDER BY locationname ASC");
                //-----------------------------------
                //-----------------------------------
                if (rstLogs!=null && rstLogs.length>0){
                    for(int i=0; i<rstLogs.length; i++){
                        mb.append(rstLogs[i][1]);
                        mb.append("<br>");
                    }
                }
            } else {
                mb.append("All.");
            }
        } else {
            mb.append("All.");
        }
        mb.append("</font>");
        mb.append("<br><br>");


        return mb.toString();
    }


    public void setSearchTerms(String searchTerms) {
        searchParameters.searchTerms = searchTerms;
    }

    public void setCoreOfSearcher(reger.UserSession userSessionOfSearcher) {
        this.userSessionOfSearcher = userSessionOfSearcher;
    }

    public void setAccountsToSearch(int[] accountidsToSearch){
        searchParameters.accountidsToSearch = accountidsToSearch;
    }

    public void setLocationsToSearch(int[] locationidsToSearch){
        searchParameters.locationidsToSearch = locationidsToSearch;
    }

    public void setLogsToSearch(int[] logids) {
        searchParameters.logsToSearch = logids;
    }

    public void setEventtypesToSearch(int[] eventtypeids) {
        searchParameters.eventtypeidsToSearch = eventtypeids;
    }

    public void setNumberOfResultsToReturn(int numberOfResultsToReturn) {
        searchParameters.numberOfResultsToReturn = numberOfResultsToReturn;
    }

    public void setLinkResultsToAdmin(boolean linkResultsToAdmin) {
        this.linkResultsToAdmin = linkResultsToAdmin;
    }

    public void setFieldQueryElements(FieldQueryElement[] fieldQueryElements) {
        searchParameters.fieldQueryElements = fieldQueryElements;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    

}
