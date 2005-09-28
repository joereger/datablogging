package reger.linkrot;


//import com.google.soap.search.GoogleSearch;
//import com.google.soap.search.GoogleSearchResult;
//import com.google.soap.search.GoogleSearchResultElement;
import reger.core.Debug;

/**
 * Class to call the Google API
 */
public class Google {

//To re-implement, remember that I must use the reger version of the jar file, not the one that is downloaded from the site


//    public static GoogleSearchResult search(String searchString){
//        //StringBuffer mb = new StringBuffer();
//
//        String clientKey = "GOGEzx5QFHKOTM/7Tw6p1T/9IFVFLh9i";
//        String directive = "search";
//        String directiveArg = searchString;
//
//        //Debug
//        //reger.core.Util.logtodb("Google API Call: <br>clientkey:" + clientKey + "<br>Directive:" + directive + "<br>Args:" + directiveArg);
//
//        //Create a Google Search object, set our authorization key
//        GoogleSearch s = new GoogleSearch();
//        s.setKey(clientKey);
//
//        //Do search
//        GoogleSearchResult r = new GoogleSearchResult();
//        try {
//            s.setQueryString(directiveArg);
//            r = s.doSearch();
//        } catch (Exception e) {
//            Debug.errorsave(e, "");
//        }
//
//        return r;
//    }
//
//    public static StringBuffer searchResultsHtml(String searchString){
//        StringBuffer mb = new StringBuffer();
//
//        //Do the search
//        GoogleSearchResult r = search(searchString);
//
//        //Get individual results
//        GoogleSearchResultElement[] results = r.getResultElements();
//
//        //Iterate
//        for (int i = 0; i < results.length; i++) {
//            String title = results[i].getTitle();
//            String url = results[i].getURL();
//            String summary = results[i].getSummary();
//        }
//
//        return mb;
//    }


}
