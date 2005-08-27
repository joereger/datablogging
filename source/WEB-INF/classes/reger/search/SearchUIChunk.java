package reger.search;

/**
 * A piece of a search ui.
 */
public interface SearchUIChunk {

    /**
     * The name of this chunk as it appears in the user interface.
     * Something short like:
     * Keywords
     */
    public String getName();

    /**
     * The name to be displayed as the main title of this chunk.
     */
    public String getPageTitle();

    /**
     * A unique identifying string for this chunk.
     * Nothing special here... just must be unique amongst other chunks.
     * Something like 'keywords' is fine.
     * It will be passed in a form to tell the SearchUI object what's being sent.
     */
    public String getUniqueIdentifier();

    /**
     * This method simply looks at the current SearchEntries object and displays
     * a form for users to add new information or edit existing.
     */
    public StringBuffer getHtml(reger.search.SearchEntries se, reger.UserSession userSession);

    /**
     * This method handles incoming data from the request and appends/edits/adds
     * it to the SearchEntries object
     */
    public SearchEntries processRequest(reger.search.SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession);


}
