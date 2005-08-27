package reger.search;

/**
 * Keyword portion of searches
 */
public class SearchUIChunkKeywords implements SearchUIChunk{

    public String getName(){
        return "Keywords";
    }

    public String getUniqueIdentifier() {
        return "chunk-keywords";
    }

    public String getPageTitle(){
        return "Enter Keywords to Search For and Click Next:";
    }

    public StringBuffer getHtml(reger.search.SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

      
        mb.append("<input type=text name=searchterms value=\""+reger.core.Util.cleanForHtml(se.getSearchParameters().searchTerms)+"\" size=45 maxlength=255>");

        mb.append("<br>");
        mb.append("<br>");

        mb.append("<blockquote>");

        mb.append("<font face=arial size=-2 class=smallfont color=#333333>");
        mb.append("Keyword search will look for the keywords you enter in the title, body, comments and file descriptions of entries.");
        mb.append("<br>");
        mb.append("<br>");
        mb.append("You don't have to enter any keywords.  You can narrow your search in other ways on the next pages.");
        mb.append("<br>");
        mb.append("<br>");

        mb.append("Sample Searches:");
        mb.append("<ul>");
        mb.append("<li>blue - Returns entries with the text \"blue\" in their title, body, comments or file descriptions.</li>");
        mb.append("<li>+blue +red - The plus sign (note that there is no space after the plus sign) means that entries with both \"red\" AND \"blue\" are included in the results.</li>");
        mb.append("<li>\"big blue\" moon - Note the quotes which require that the complete phrase \"big blue\" is found in the entry.</li>");
        mb.append("</ul>");


        mb.append("Boolean Search Operators:");
        mb.append("<ul>");
        mb.append("<li>+	The word is mandatory in all rows returned.</li>");
        mb.append("<li>-	The word cannot appear in any row returned.</li>");
        mb.append("<li><	The word that follows has a lower relevance than other words, although rows containing it will still match</li>");
        mb.append("<li>>	The word that follows has a higher relevance than other words.</li>");
        mb.append("<li>()	Used to group words into subexpressions.</li>");
        mb.append("<li>~	The word following contributes negatively to the relevance of the row (which is different to the '-' operator, which specifically excludes the word, or the '<' operator, which still causes the word to contribute positively to the relevance of the row.</li>");
        mb.append("<li>*	The wildcard, indicating zero or more characters. It can only appear at the end of a word.</li>");
        mb.append("<li>\"	Anything enclosed in the double quotes is taken as a whole (so you can match phrases, for example).</li>");
        mb.append("</ul>");

        mb.append("Keyword Search Notes:");
        mb.append("<ul>");
        mb.append("<li>Excludes partial words</li>");
        mb.append("<li>Excludes words less than 4 characters in length (3 or less)</li>");
        mb.append("<li>Excludes words that appear in more than half the entries.  In other words, if one of the keywords you've entered appears too frequently, it is ignored.</li>");
        mb.append("<li>Hyphenated words are treated as two words</li>");
        mb.append("<li>Common English words like \"the\", \"and\", \"also\" and \"did\" are also ignored.  This doesn't hurt the search however... it just makes it more accurate.</li>");
        mb.append("</ul>");

        mb.append("</blockquote>");

        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){
        //Get any new incoming searchterms
        if (request.getParameter("searchterms")!=null){
            se.setSearchTerms(request.getParameter("searchterms"));
        } else {
            se.setSearchTerms("");
        }
        return se;
    }


}
