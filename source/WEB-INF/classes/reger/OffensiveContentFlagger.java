package reger;

import reger.core.Debug;

import java.util.Vector;

/**
 *
 */
public class OffensiveContentFlagger {

    /**
     * Checks an entry for offensiveness, but only uses the default system words.
     * Note: see isOffensive(String in, int plid)
     */
    public static boolean isOffensive(reger.Entry entry){
        return isOffensive(entryToString(entry));
    }

    /**
     * Checks for offensiveness, and uses pl-specific words.

     */
    public static boolean isOffensive(reger.Entry entry, int plid){
        //reger.core.Util.logtodb("OffensiveContentFlagger.isOffensive()");
        return isOffensive(entryToString(entry), plid);
    }
    
    /**
     * Checks a string for offensiveness, but only uses the default system words.
     * Note: see isOffensive(String in, int plid)
     */
    public static boolean isOffensive(String in){
        reger.OffensiveContentList list = new reger.OffensiveContentList();
        return checkAgainstList(in, list.getWordsDefaults());
    }

    /**
     * Checks a string for offensiveness using the default system words and the pl-specific words.
     */
    public static boolean isOffensive(String in, int plid){
        reger.OffensiveContentList list = new reger.OffensiveContentList();
        return checkAgainstList(in, list.getWordsForPl(plid));
    }

    private static boolean checkAgainstList(String in, Vector words){
        boolean isoffensive = false;
        Debug.debug(5, "", "OffensiveContentFlagger.java - in=" + in);
        for (int i = 0; i < words.size(); i++) {
            String wordToLookFor = (String) words.elementAt(i);
            Debug.debug(5, "", "OffensiveContentFlagger.java - wordToLookFor=" + wordToLookFor + "<br>in=" + in);
            if (in.indexOf(wordToLookFor)>0){
                Debug.debug(5, "", "OffensiveContentFlagger.java - found=" + wordToLookFor + " <br>in=" + in);
                isoffensive=true;
                //Leave the loop, we've found an offensive word already
                break;
            }
        }
        Debug.debug(5, "", "OffensiveContentFlagger.java - isoffensive=" + isoffensive);
        return isoffensive;
    }

    private static String entryToString(reger.Entry entry){
        //StringBuffer holds the entry as a string
        StringBuffer str = new StringBuffer();

        //Add values from the entry
        str.append(entry.title + " ");
        str.append(entry.comments + " ");
        if (entry.location!=null){
            str.append(entry.location.getLocationname() + " ");
        }

        //Add the megavalue field values to the string
        if (entry.fields!=null){
            for (int i = 0; i < entry.fields.length; i++) {
                str.append(entry.fields[i].getValuesAsStringForOffensiveContentValidation() + " ");
            }
        }
        return str.toString();
    }

}
