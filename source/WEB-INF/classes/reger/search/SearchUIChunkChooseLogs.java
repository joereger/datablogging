package reger.search;

import reger.Log;
import reger.MegaLogType;
import reger.cache.LogCache;

import java.util.Vector;

/**
 * Logid portion of searches
 */
public class SearchUIChunkChooseLogs implements SearchUIChunk{

    public String getName(){
        return "Logs";
    }

    public String getUniqueIdentifier() {
        return "chunk-chooselogs";
    }

    public String getPageTitle(){
        return "Find Entries in These Logs:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //If no setting has been made for which accounts to search, make a default of the current account
        if (se.getSearchParameters().getAccountidsToSearch()==null || se.getSearchParameters().getAccountidsToSearch().length<1){
            if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                //We have a user and a valid account, assume a search of that account
                int[] tmpAccts = new int[1];
                tmpAccts[0] = userSession.getAccount().getAccountid();
                se.setAccountsToSearch(tmpAccts);
            } else {
                //We don't have an account, assume a search of all accounts
                int[] tmpAccts = new int[1];
                tmpAccts[0] = SearchParameters.ALL;
                se.setAccountsToSearch(tmpAccts);
            }
        }

        //Searching all logs in system
        if (se.getSearchParameters().isAccountBeingSearched(SearchParameters.ALL)){
            mb.append("<script src=\"/js/checkallboxes.js\" type=\"text/javascript\"></script>");


            String selectedTextAll = "";
            if (se.getSearchParameters().isEventtypeidBeingSearched(SearchParameters.ALL)){
                selectedTextAll = " checked ";
            }
            mb.append("<input type='checkbox' name='eventtypeids' value='"+SearchParameters.ALL+"' onclick=\"checkAll(document.getElementById('searchuiform'), 'eventtypeids',this);\" "+selectedTextAll+">");
            mb.append(" All Log Types");
            mb.append("<br><br>");

            mb.append("<table cellpadding=5 cellspacing=1 border=0>");

            Vector eventTypeidsForPlid = reger.AllMegaLogTypesInSystem.allMegaLogTypesForPlid(userSession.getPl().getPlid());

            for (int j = 0; j < eventTypeidsForPlid.size(); j++) {
                MegaLogType logType = (MegaLogType) eventTypeidsForPlid.elementAt(j);

                String selectedText = "";
                if (se.getSearchParameters().isEventtypeidBeingSearched(logType.getEventtypeid()) || se.getSearchParameters().isEventtypeidBeingSearched(SearchParameters.ALL)){
                    selectedText = " checked ";
                }
                mb.append("<tr>");
                mb.append("<td bgcolor=#ffffff>");
                mb.append("<font face=arial size=-1 class=smallfont>");
                mb.append("<input type=checkbox name=eventtypeids class=eventtypeids value='"+logType.getEventtypeid()+"' "+selectedText+"> " + logType.getMegalogname());
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");


            }

            mb.append("</table>");


        //Searching specific logs in system
        } else {
            mb.append("<script src=\"/js/checkallboxes.js\" type=\"text/javascript\"></script>");


            String selectedTextAll = "";
            if (se.getSearchParameters().isLogidBeingSearched(SearchParameters.ALL)){
                selectedTextAll = " checked ";
            }
            mb.append("<input type='checkbox' name='logids' value='"+SearchParameters.ALL+"' onclick=\"checkAll(document.getElementById('searchuiform'), 'logids',this);\" "+selectedTextAll+">");
            mb.append(" All Logs");
            mb.append("<br><br>");


            if (se!=null && se.getSearchParameters()!=null && se.getSearchParameters().accountidsToSearch!=null){
                mb.append("<table cellpadding=5 cellspacing=1 border=0>");
                for (int i = 0; i < se.getSearchParameters().accountidsToSearch.length; i++) {
                    Vector logsForAcct = LogCache.allLogsForAccount(se.getSearchParameters().accountidsToSearch[i]);
                    reger.Account acct = new reger.Account(se.getSearchParameters().accountidsToSearch[i]);
                    mb.append("<tr>");
                    mb.append("<td bgcolor=#e6e6e6>");
                    mb.append("<font face=arial size=-1 class=mediumfont>");
                    mb.append(acct.getHomepagetitle());
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    for (int j = 0; j < logsForAcct.size(); j++) {
                        Log log = (Log) logsForAcct.elementAt(j);
                        //If the user can view this log
                        if (userSession.getAccountuser().userCanViewLog(log.getLogid())){
                            String selectedText = "";
                            if (se.getSearchParameters().isLogidBeingSearched(log.getLogid()) || se.getSearchParameters().isLogidBeingSearched(SearchParameters.ALL)){
                                selectedText = " checked ";
                            }
                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff>");
                            mb.append("<font face=arial size=-1 class=smallfont>");
                            mb.append("<input type=checkbox name=logids class=logids value='"+log.getLogid()+"' "+selectedText+"> " + log.getName());
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");
                        }

                    }

                }
                mb.append("</table>");
            }

        }




        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){

        //Set the logs to null
        se.setLogsToSearch(null);

        //See if the special value SearchParameters.ALL is incoming.
        //If so, simply add it alone to the array of logs to search
        if (request.getParameterValues("logids")!=null){
            String[] tmpVals = request.getParameterValues("logids");
            for (int i = 0; i < tmpVals.length; i++) {
                if (reger.core.Util.isinteger(tmpVals[i])){
                    if (Integer.parseInt(tmpVals[i])==SearchParameters.ALL){
                        int[] logids = new int[1];
                        logids[0]=SearchParameters.ALL;
                        se.setLogsToSearch(logids);
                        return se;
                    }
                }
            }
        }

        //Get any new incoming logs to search
        int[] logids = new int[0];
        if (request.getParameterValues("logids")!=null && request.getParameterValues("logids").length>0){
            for (int i = 0; i < request.getParameterValues("logids").length; i++) {
                if (reger.core.Util.isinteger(request.getParameterValues("logids")[i])){
                    logids = reger.core.Util.addToIntArray(logids, Integer.parseInt(request.getParameterValues("logids")[i]));
                }
            }
        }

        //Make the final assignment
        if (logids!=null && logids.length>0){
            se.setLogsToSearch(logids);
        }




        //Set the eventtypes to null
        se.setEventtypesToSearch(null);

        //See if the special value SearchParameters.ALL is incoming.
        //If so, simply add it alone to the array of logs to search
        if (request.getParameterValues("eventtypeids")!=null){
            String[] tmpVals = request.getParameterValues("eventtypeids");
            for (int i = 0; i < tmpVals.length; i++) {
                if (reger.core.Util.isinteger(tmpVals[i])){
                    if (Integer.parseInt(tmpVals[i])==SearchParameters.ALL){
                        int[] eventtypeids = new int[1];
                        eventtypeids[0]=SearchParameters.ALL;
                        se.setEventtypesToSearch(eventtypeids);
                        return se;
                    }
                }
            }
        }

        //Get any new incoming logs to search
        int[] eventtypeids = new int[0];
        if (request.getParameterValues("eventtypeids")!=null && request.getParameterValues("eventtypeids").length>0){
            for (int i = 0; i < request.getParameterValues("eventtypeids").length; i++) {
                if (reger.core.Util.isinteger(request.getParameterValues("eventtypeids")[i])){
                    eventtypeids = reger.core.Util.addToIntArray(eventtypeids, Integer.parseInt(request.getParameterValues("eventtypeids")[i]));
                }
            }
        }

        //Make the final assignment
        if (eventtypeids!=null && eventtypeids.length>0){
            se.setEventtypesToSearch(eventtypeids);
        }

        return se;
    }


}
