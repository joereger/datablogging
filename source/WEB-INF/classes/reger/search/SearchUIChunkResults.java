package reger.search;

import reger.core.db.Db;

/**
 * Results portion of searches
 */
public class SearchUIChunkResults implements SearchUIChunk{

    public String getName(){
        return "Results";
    }

    public String getUniqueIdentifier() {
        return "chunk-searchresults";
    }

    public String getPageTitle(){
        return "Search Results:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();



        //Do the search
        se.doSearch();

        mb.append("<table cellpadding=3 width=100% cellspacing=3 border=0>");

        mb.append("<tr>");
        //Entry Search Results
        mb.append("<td valign=top align=left>");
        if (se.entrySearchResults!=null){
            for (int i = 0; i < se.entrySearchResults.length; i++) {
                mb.append(se.entrySearchResults[i].standardHtmlDisplay() + "<br><br>");
            }
        } else {
            mb.append("<font face=arial size=-2 class=smallfont>No entries were found.  A summary of your search can be found to the right of the screen.  You can adjust this search by using the Back button.  Good luck!</font>");
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Nothing to do
        return se;
    }


}
