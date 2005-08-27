package reger.linkrot;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Finds links in text
 */
public class AnchorFinder {


    public static String[] parseUrlsFromText(String text){
        String[] anchors = new String[0];

        // Create a pattern to match
        //Pattern p = Pattern.compile("(?i)\\<title(.|\\n)*?\\>(.|\\n)*?\\</title\\>");
        Pattern p = Pattern.compile("(?i)\\<a href=[^\\>]*\\>");
        // Create a matcher with an input string
        Matcher m = p.matcher(text);
        // Loop through
        while(m.find()) {

            //reger.core.Util.logtodb("Found anchor tag: " + m.group() + "<br>Groupcount(): " + m.groupCount());

            //for(int i=0; i<=m.groupCount(); i++){
                //reger.core.Util.logtodb("m.group("+i+"): " + m.group(i));
            //}

            //Get the whole anchor tag
            String wholeAnchortag = m.group();

            //Now, parse out the url
            String url = getUrlFromAnchorTag(wholeAnchortag);

            //Add the url to the array of anchors
            anchors = reger.core.Util.addToStringArray(anchors, url);

            //titleKeywords = m.group(1);
            //reger.core.Util.logtodb("Found title: " + titleKeywords);

        }

        return anchors;
    }

    public static String getUrlFromAnchorTag(String wholeAnchor){
        String url = "";

        //reger.core.Util.logtodb("WholeAnchor: " + reger.core.Util.xmlclean(wholeAnchor));


        int length = wholeAnchor.length();

        int hrefloc = wholeAnchor.indexOf("href");

        //String hreftoend = wholeAnchor.substring(hrefloc, length);
        //reger.core.Util.logtodb("hreftoend:" + hreftoend);

        int startingpoint = hrefloc + 4;

        //These are the things I need to find
        boolean havefoundEquals = false;
        boolean havefoundStartOfUrl = false;
        boolean havefoundEndOfUrl = false;

        //Goal is to set these
        int startOfUrl = -1;
        int endOfUrl = -1;

        //Go character by character
        for(int i=startingpoint; i<length; i++){
            String currentChar = wholeAnchor.substring(i, i+1);

            //If we haven't found the equals
            if (!havefoundEquals){
                if (currentChar.equals("=")){
                    havefoundEquals = true;
                }
            } else {
                //We've found the equals, but we don't have the start of the url
                if (!havefoundStartOfUrl){
                    if (!currentChar.equals(" ")){
                        if (currentChar.equals("'") || currentChar.equals("\"")){
                            havefoundStartOfUrl=true;
                            //Start of url is this index + 1
                            startOfUrl = i+1;
                        } else {
                            havefoundStartOfUrl=true;
                            //Start of url is this index
                            startOfUrl = i;
                        }
                    }
                } else {
                    //We've found the start but haven't found the end
                    if (!havefoundEndOfUrl){
                        if (currentChar.equals("'") || currentChar.equals("\"") || currentChar.equals(" ") || currentChar.equals(">")){
                            havefoundEndOfUrl = true;
                            //End of url is here-1
                            endOfUrl = i;
                        }
                    }
                }
            }
        }

        //reger.core.Util.logtodb("startOfUrl=" + startOfUrl + "<br>endOfUrl=" + endOfUrl);

        if ((startOfUrl>0 && endOfUrl>0) && (startOfUrl<endOfUrl)){
            url = wholeAnchor.substring(startOfUrl, endOfUrl);
        }
        //reger.core.Util.logtodb("URL: " + url);

        return url;
    }
}
