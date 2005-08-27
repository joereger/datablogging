package reger.search;

import reger.core.db.Db;
import reger.AllLogsInSystem;
import reger.Log;

import java.util.Vector;

/**
 * Location portion of searches
 */
public class SearchUIChunkLocations implements SearchUIChunk{

    public String getName(){
        return "Locations";
    }

    public String getUniqueIdentifier() {
        return "chunk-locations";
    }

    public String getPageTitle(){
        return "Find Entries in These Locations:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        if (se.getSearchParameters().isAccountBeingSearched(SearchParameters.ALL)){
            mb.append("You have chosen to search all sites on this server so all locations will be searched.");
        } else {

            mb.append("<script src=\"/js/checkallboxes.js\" type=\"text/javascript\"></script>");

            String selectedTextAll = "";
            if (se.getSearchParameters().isLocationidBeingSearched(SearchParameters.ALL)){
                selectedTextAll = " checked ";
            }
            mb.append("<input type='checkbox' name='locationid' value='"+SearchParameters.ALL+"' onclick=\"checkAll(document.getElementById('searchuiform'), 'locationid',this);\" "+selectedTextAll+">");
            mb.append(" All Locations");
            mb.append("<br><br>");

            if (se.getSearchParameters().accountidsToSearch!=null){
                mb.append("<table cellpadding=5 cellspacing=1 border=0>");
                for (int i = 0; i < se.getSearchParameters().accountidsToSearch.length; i++) {
                    reger.Account acct = new reger.Account(se.getSearchParameters().accountidsToSearch[i]);
                    mb.append("<tr>");
                    mb.append("<td bgcolor=#e6e6e6>");
                    mb.append("<font face=arial size=-1 class=mediumfont>");
                    mb.append(acct.getHomepagetitle());
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");

                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstLogs= Db.RunSQL("SELECT DISTINCT location.locationid, locationname FROM event, megalog, location, account WHERE account.accountid='"+acct.getAccountid()+"' AND event.logid=megalog.logid AND event.accountid=account.accountid AND event.locationid=location.locationid AND " + userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())  +se.getSearchParameters().getAccountsToSearchAsSqlStatement()+" ORDER BY name ASC");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstLogs!=null && rstLogs.length>0){
                        for(int j=0; j<rstLogs.length; j++){
                            //Log title and check box
                            String selectedText = "";
                            if (se.getSearchParameters().isLocationidBeingSearched(Integer.parseInt(rstLogs[j][0])) || se.getSearchParameters().isLocationidBeingSearched(SearchParameters.ALL)){
                                selectedText = " checked ";
                            }
                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff>");
                            mb.append("<font face=arial size=-2 class=tinyfont>");
                            mb.append("<input type=checkbox name=locationid class=locationid value='"+rstLogs[j][0]+"' "+selectedText+"> " + rstLogs[j][1]);
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");

                        }
                    } else {
                        mb.append("<tr>");
                        mb.append("<td bgcolor=#ffffff>");
                        mb.append("<font face=arial size=-2 class=tinyfont>");
                        mb.append("No Locations for this Account.");
                        mb.append("</font>");
                        mb.append("</td>");
                        mb.append("</tr>");

                    }




                }
                mb.append("</table>");
            }



        }

        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Set the locations to null
        se.setLocationsToSearch(null);

        //See if the special value SearchParameters.ALL is incoming.
        //If so, simply add it alone to the array of locations to search
        if (request.getParameterValues("locationid")!=null){
            String[] tmpVals = request.getParameterValues("locationid");
            for (int i = 0; i < tmpVals.length; i++) {
                if (reger.core.Util.isinteger(tmpVals[i])){
                    if (Integer.parseInt(tmpVals[i])==SearchParameters.ALL){
                        int[] locationidstosearch = new int[1];
                        locationidstosearch[0]=SearchParameters.ALL;
                        se.setLocationsToSearch(locationidstosearch);
                        return se;
                    }
                }
            }
        }

        //Get any new incoming locations
        int[] locationidstosearch = new int[0];
        if (request.getParameterValues("locationid")!=null){
            String[] tmpVals = request.getParameterValues("locationid");
            for (int i = 0; i < tmpVals.length; i++) {
                if (reger.core.Util.isinteger(tmpVals[i])){
                    locationidstosearch = reger.core.Util.addToIntArray(locationidstosearch, Integer.parseInt(tmpVals[i]));
                }
            }
        }

        //Make the final assignment
        if (locationidstosearch!=null && locationidstosearch.length>0){
            se.setLocationsToSearch(locationidstosearch);
        }

        return se;
    }


}
