package reger;


import reger.core.Debug;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Parses html and looks for links to add the NoFollow tag.
 * http://www.google.com/googleblog/2005/01/preventing-comment-spam.html
 */
public class NoFollowTag {




    public static String addNoFollowTagToLinks(String in){
        try {
            StringBuffer out = new StringBuffer();

            // Create a pattern to match
            Pattern p = Pattern.compile("(?i)\\<a[^\\>]*\\>");

            // Create a matcher with an input string
            Matcher m = p.matcher(in);
            // Loop through
            while(m.find()) {
                String wholeAnchortag = m.group();
                m.appendReplacement(out, reger.core.Util.cleanForAppendreplacement(addNoFollowTag(wholeAnchortag)));
            }

            // Add the last segment
            try{
                m.appendTail(out);
            } catch (Exception e){
                //Do nothing... just null pointer
            }

            return out.toString();
        } catch (Exception e){
            Debug.debug(5, "", e);
            return in;
        }
    }

    private static String addNoFollowTag(String wholeAnchorTag){
        String out = "";

        String noEnd = wholeAnchorTag.substring(0, (wholeAnchorTag.length()-1));
        String end = " rel=\"nofollow\">";
        out = noEnd + end;
        
        return out;
    }





}
