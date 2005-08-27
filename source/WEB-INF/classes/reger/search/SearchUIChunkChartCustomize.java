package reger.search;

import reger.core.db.Db;

/**
 * Results portion of searches
 */
public class SearchUIChunkChartCustomize implements SearchUIChunk{

    public String getName(){
        return "Chart";
    }

    public String getUniqueIdentifier() {
        return "chunk-chartcustomize";
    }

    public String getPageTitle(){
        return "Chart:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();





        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Nothing to do
        return se;
    }


}
