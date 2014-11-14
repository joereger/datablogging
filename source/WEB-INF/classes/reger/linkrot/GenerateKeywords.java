package reger.linkrot;

import reger.core.Debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Accepts a string, removes html tags, filters out most used words in language and identifies top 50 words in post.
 */
public class GenerateKeywords {

    public static String[] mostusedwords;

    public static String getKeywords(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.getKeywords - start");
        String keywords = "";

        String titleKeywords = "";
        titleKeywords = getTitleKeywords(webPage);

        keywords = webPage;
        Debug.debug(5, "", "Before removing tags/scripts/head:"+reger.core.Util.xmlclean(keywords));
        keywords = removeHeadSection(keywords);
        keywords = removeScripts(keywords);
        keywords = removeStyles(keywords);
        keywords = removeHtmlTags(keywords);
        keywords = removePunctuation(keywords);
        keywords = removeMisc(keywords);
        Debug.debug(5, "", "After removing tags/scripts/head:"+reger.core.Util.xmlclean(keywords));
        keywords = getKeywordsFromHashmap(getUsedWords(keywords), 50);

        //Debug
        Debug.debug(5, "", "GenerateKeywords.getKeywords - end");

        return titleKeywords + " " + keywords;

    }

    public static String getTitleKeywords(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.getTitleKeywords - start");
        String titleKeywords = "";

        Debug.debug(5, "", "Before trying to find title:"+reger.core.Util.xmlclean(webPage));

        // Create a pattern to match cat
        //Pattern p = Pattern.compile("(?i)\\<title(.|\\n)*?\\>(.|\\n)*?\\</title\\>");
        Pattern p = Pattern.compile("(?i)\\<title[^\\>]*\\>(.*?)\\</title\\>");
        // Create a matcher with an input string
        Matcher m = p.matcher(webPage);
        // Loop through
        if(m.find()) {
            titleKeywords = m.group(1);
        }

        titleKeywords = truncateToXWords(titleKeywords, 3);
        //Debug
        Debug.debug(5, "", "GenerateKeywords.getTitleKeywords - end");
        return titleKeywords;
    }

    public static String truncateToXWords(String inString, int numberofwords){

        String out = "";
        String[] words = inString.split("\\b");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()>2 && count<numberofwords){
                out = out + words[i] + " ";
                count=count+1;
            }
        }

        return out;
    }

    public static String removeScripts(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeScripts() - start");

        int start = -1;
        int end = -1;
        int length = -1;
        String tmp = "";

        Debug.debug(5, "", "Before remove scripts:"+reger.core.Util.xmlclean(webPage));
        int infiniteLoopSafetyCounter = 0;
        while (webPage.indexOf("<script")>0 && infiniteLoopSafetyCounter<200){
            infiniteLoopSafetyCounter = infiniteLoopSafetyCounter + 1;
            webPage = webPage.toLowerCase();
            start = webPage.indexOf("<script");
            end = webPage.indexOf("/script>") + 8;
            length = webPage.length();
            if ((start>0 && end>0) && (start<end)){
                tmp = webPage.substring(0,start) + webPage.substring(end, length);
                webPage = tmp;
            }
        }
        Debug.debug(5, "", "After remove scripts:"+reger.core.Util.xmlclean(webPage));

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeScripts() - end");

        return webPage;
    }

    public static String removeStyles(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeStyles() - start");
        int start = -1;
        int end = -1;
        int length = -1;
        String tmp = "";

        int infiniteLoopSafetyCounter = 0;
        while (webPage.indexOf("<style")>0 && infiniteLoopSafetyCounter<200){
            infiniteLoopSafetyCounter = infiniteLoopSafetyCounter + 1;
            webPage = webPage.toLowerCase();
            start = webPage.indexOf("<style");
            end = webPage.indexOf("/style>") + 7;
            length = webPage.length();
            if ((start>0 && end>0) && (start<end)){
                tmp = webPage.substring(0,start) + webPage.substring(end, length);
                webPage = tmp;
            }
        }

        return webPage;
    }

    public static String removeHeadSection(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeHeadSection() - start");
        int start = -1;
        int end = -1;
        int length = -1;
        String tmp = "";

        Debug.debug(5, "", "Before remove style:"+reger.core.Util.xmlclean(webPage));
        int infiniteLoopSafetyCounter = 0;
        while (webPage.indexOf("<head")>0 && infiniteLoopSafetyCounter<200){
            infiniteLoopSafetyCounter = infiniteLoopSafetyCounter + 1;
            webPage = webPage.toLowerCase();
            start = webPage.indexOf("<head");
            end = webPage.indexOf("/head>") + 6;
            length = webPage.length();
            if ((start>0 && end>0) && (start<end)){
                tmp = webPage.substring(0,start) + webPage.substring(end, length);
                webPage = tmp;
            }
        }
        Debug.debug(5, "", "After remove style:"+reger.core.Util.xmlclean(webPage));

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeHeadSection - end");

        return webPage;
    }

    public static String removeHtmlTags(String webPage){

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeHtmlTags - start");

        Debug.debug(5, "", "Before remove html:"+reger.core.Util.xmlclean(webPage));
        try {
            //webPage = webPage.replaceAll("\\<(.|\\n)*?\\>", " ");
            webPage = webPage.replaceAll("\\<[^\\>]*\\>", " ");
        } catch (Throwable e){
            Debug.errorsave(e, "");

        }
        Debug.debug(5, "", "After remove html:"+reger.core.Util.xmlclean(webPage));

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeHtmlTags - end");

        return webPage;
    }


    public static String removePunctuation(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.removePunctuation - start");

        StringBuffer sbTemp = new StringBuffer ( webPage ) ;
        Debug.debug(5, "", "Before remove Punctuation:"+reger.core.Util.xmlclean(webPage));
        for ( int i = sbTemp.length () - 1 ; i >= 0 ; i -- ){
            if (!Character.isLetterOrDigit(sbTemp.charAt(i)) && !Character.isWhitespace(sbTemp.charAt(i))){
                sbTemp.deleteCharAt(i) ;
            }
        }
        Debug.debug(5, "", "After remove Punctuation:"+webPage);


        //Debug
        Debug.debug(5, "", "GenerateKeywords.removePunctuation - end");

        return sbTemp.toString () ;
    }


    public static String removeMisc(String webPage){

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeMisc - start");

        //Remove &nbsp; and the like.
        Debug.debug(5, "", "Before remove Misc:"+reger.core.Util.xmlclean(webPage));
        webPage = webPage.replaceAll("nbsp", " ");
        Debug.debug(5, "", "After remove Misc:"+webPage);

        //Debug
        Debug.debug(5, "", "GenerateKeywords.removeMisc - end");

        return webPage;
    }



    public static boolean isPopularWord(String word){
        for (int i = 0; i < mostUsedWords().length; i++) {
            if (mostUsedWords()[i].equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }

    public static String[] breakIntoWordArray(String webPage){
        String [] out = webPage.split("\\b");
        //reger.core.Util.logStringArrayToDb("Words on page.", out);
        return out;
    }

    /**
     * HashMap holds key=word value=number of times word used.
     * Returned unordered.
     * @param webPage
     * @return
     */
    public static HashMap getUsedWords(String webPage){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.getUsedwords - start");

        HashMap map = new HashMap();

        //Get an array of words
        String [] words = breakIntoWordArray(webPage);
        //Go through the words
        for (int i = 0; i < words.length; i++) {
            //Trim
            //If it's not a popular word and it's greater than 2 chars
            if (!isPopularWord(words[i].trim()) && words[i].trim().length()>=3){
                //Add to the final hashmap and/or increment the value
                addWordToHashMapCounter(map, words[i]);
            }
        }

        //reger.core.Util.logHashMapToDb("Used Words:", map);

        //Debug
        Debug.debug(5, "", "GenerateKeywords.getUsedwords - end");

        return map;
    }

    /**
     * Adds key/value pair or
     * @param map
     * @param word
     * @return
     */
    public static HashMap addWordToHashMapCounter(HashMap map, String word){
        int count = 0;
        if (map.containsKey(word)){
            try {
                count = Integer.parseInt(map.get(word).toString());
                count = count + 1;
            } catch (Exception e) {
                Debug.errorsave(e, "");
            }
        }
        map.put(word, new Integer(count));
        return map;
    }

    /**
     * Accepts a HashMap of words as keys and number of occurrences as values.
     * Returns a string with the most used words first
     * @param map
     * @return
     */
    public static String getKeywordsFromHashmap(HashMap map, int numbertoget){
        //Debug
        Debug.debug(5, "", "GenerateKeywords.getKeyWordsFromHashMap - start");

        String keywords = "";

        //reger.core.Util.logHashMapToDb("Into getKeywordsFromHashmap():", map);

        StringBuffer tst = new StringBuffer();

        //First, convert the hashmap into a sorted string array
        String [] sorted = SortHashMapOnValue(map);

        //Then iterate through it
        for (int i = 0; (i<sorted.length) && (i<=numbertoget); i++) {
            //tst.append("<br>" + sorted[i] + "--" + map.get(sorted[i]));
            tst.append(sorted[i] + " ");
        }

        keywords = tst.toString();

        //Debug
        Debug.debug(5, "", "GenerateKeywords.getKeywordsFromHashmap - end");

        return keywords;
    }



    /**
     * Creates a string array of the most used words first
     * @param map
     * @return
     */
    public static String[] SortHashMapOnValue(HashMap map){

        String [] sorted = new String[0];

        //Get the highest value
        int max = getMaxValue(map);

        //Go backwards through the values
        for(int lookingforvalue=max; lookingforvalue>=0; lookingforvalue--){
            for (Iterator i=map.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                //If one of the mapped items has this value
                if (Integer.parseInt(e.getValue().toString())==lookingforvalue){
                    //Add it to the sorted array
                    sorted = reger.core.Util.addToStringArray(sorted, e.getKey().toString());
                }
            }
        }

        return sorted;

    }

    public static int getMaxValue(HashMap map){
        int  max = 0;
        for (Iterator i=map.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //out.println(e.getKey() + ": " + e.getValue());
            try {
                if (Integer.parseInt(e.getValue().toString())>max){
                    max = Integer.parseInt(e.getValue().toString());
                }
            } catch (Exception ex){
                //Do nothing
            }
        }
        return max;
    }




    public static String[] mostUsedWords(){
        //String[] mostusedwords = new String[0];

        if (mostusedwords==null){

            mostusedwords = new String[0];

            //Source: http://esl.about.com/library/vocabulary/bl1000_list1.htm

            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "the");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "of");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "to");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "and");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "a");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "in");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "is");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "it");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "you");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "that");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "he");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "was");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "for");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "on");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "are");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "with");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "as");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "I");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "his");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "they");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "be");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "at");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "one");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "have");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "this");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "from");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "or");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "had");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "by");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "hot");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "word");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "but");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "what");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "some");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "we");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "can");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "out");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "other");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "were");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "all");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "there");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "when");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "up");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "use");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "your");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "how");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "said");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "an");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "inch");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "she");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "which");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "do");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "their");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "time");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "if");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "will");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "way");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "about");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "many");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "then");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "them");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "write");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "would");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "like");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "so");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "these");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "her");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "long");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "make");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "thing");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "see");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "him");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "two");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "has");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "look");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "more");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "day");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "could");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "go");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "come");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "did");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "number");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "sound");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "no");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "most");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "people");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "my");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "over");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "know");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "water");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "than");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "call");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "first");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "who");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "may");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "down");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "side");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "been");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "now");
            mostusedwords = reger.core.Util.addToStringArray(mostusedwords, "find");


            //reger.core.Util.logStringArrayToDb("Popular Words:", mostusedwords);
        }

        return mostusedwords;
    }

}
