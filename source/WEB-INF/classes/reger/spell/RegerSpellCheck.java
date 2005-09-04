package reger.spell;

import com.swabunga.spell.engine.*;
import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import reger.core.Debug;


/**
 * Class used for spell check operations
 */
public class RegerSpellCheck implements SpellCheckListener {

    private static String dictFile = reger.systemproperties.AllSystemProperties.getProp("SPELLINGDICTIONARYFILE");
    private static String phonetFile = reger.systemproperties.AllSystemProperties.getProp("SPELLINGPHONETICFILE");

    private static SpellDictionary dictionary = null;

    private SpellChecker spellCheck = null;

    private ArrayList spellCheckEvents = new ArrayList();

    private String textToSpellCheck;

    public RegerSpellCheck(String textToSpellCheck) {
        //Do the spell check
        doCheck(textToSpellCheck);
    }

    public RegerSpellCheck(String textToSpellCheck, HttpServletRequest request){
        //Do the spell check
        doCheck(textToSpellCheck);
        //Store results in the session
        //HttpSession session = request.getSession(true);
        //session.setAttribute("spellCheckEvents", spellCheckEvents);
        //session.setAttribute("entryText", textToSpellCheck);
    }

    private void doCheck(String textToSpellCheck){
        this.textToSpellCheck = textToSpellCheck;
        try {
                if (dictionary == null){
                    dictionary = new SpellDictionaryHashMap(new File(dictFile), new File(phonetFile));
                    //SpellDictionary dictionary = new SpellDictionaryDichoDisk(new File(dictFile), new File(phonetFile));
                }

                spellCheck = new SpellChecker(dictionary);
                spellCheck.addSpellCheckListener(this);

                spellCheck.checkSpelling(new StringWordTokenizer(textToSpellCheck));

        } catch (Exception e) {
                Debug.errorsave(e, "", "RegerSpellCheck error.");
        }
    }

    public void spellingError(SpellCheckEvent event) {
        //Add to array of errors
        spellCheckEvents.add(event);
    }

    public String getDebugInfo(){
        StringBuffer tst = new StringBuffer();
        for(int i=0; i<spellCheckEvents.size(); i++) {
            SpellCheckEvent event = (SpellCheckEvent)spellCheckEvents.get(i);
            List suggestions = event.getSuggestions();
            if (suggestions.size() > 0) {
                  tst.append("<br><br>MISSPELT WORD: " + event.getInvalidWord());
                  for (Iterator suggestedWord = suggestions.iterator(); suggestedWord.hasNext();) {
                        tst.append("<br>Suggested Word: " + suggestedWord.next());
                  }
            } else {
                  tst.append("<br><br>MISSPELT WORD: " + event.getInvalidWord());
                  tst.append("<br>No suggestions");
            }
        }
        return tst.toString();
    }


    public int getNumberOfSpellingErrors(){
        return spellCheckEvents.size();
    }


    public String getTextWithSuggestionsAsDropdowns(){

        String escapeText = textToSpellCheck.replaceAll("<", "\\{");
        escapeText = escapeText.replaceAll(">", "\\}");

        StringBuffer newText = new StringBuffer(escapeText);
        ArrayList events = (ArrayList) spellCheckEvents;
        SpellCheckEvent event = null;
        String word = null;
        int start = -1;
        int end = -1;
        String select = null;
        int wordnum = 0;
        for(ListIterator it=events.listIterator(events.size()); it.hasPrevious();){
            wordnum=wordnum+1;
            event = (SpellCheckEvent)it.previous();
            word = event.getInvalidWord();
            start = event.getWordContextPosition();
            end = start + word.length();

            //Create the dropdown
            select = makeSelectAdvanced(word, event.getSuggestions(), wordnum);

            newText.replace( start, end, select );
        }
        escapeText = newText.toString().replaceAll("\\}", "&gt;" );
        escapeText = escapeText.replaceAll("\\{", "&lt;" );

        return escapeText;
    }

    private static String makeSelect(String word, List words, int wordnum){
        StringBuffer buf = new StringBuffer();


        buf.append("<select name=\"");
        buf.append("replacementWords-"+wordnum+"-manual\" style=\"font-size: 10px;\">");
        buf.append("<option selected=\"selected\" value=\"").append(reger.core.Util.cleanForHtml(word));
        buf.append("\">").append(word).append("</option>");
        if (words == null || words.size() < 1){
            buf.append("<option value=\"").append(reger.core.Util.cleanForHtml(word));
            buf.append("\">No Suggestions</option>");
        }else{
            for (Iterator it2=words.iterator(); it2.hasNext();){
                word = it2.next().toString();
                buf.append("<option value=\"").append(reger.core.Util.cleanForHtml(word));
                buf.append("\">").append(word).append("</option>");
            }
        }
        buf.append("</select>");



        return buf.toString();
    }

     private static String makeSelectAdvanced(String word, List words, int wordnum){
        StringBuffer buf = new StringBuffer();

        String origWord = word;

        String radioName = "replacementWords-"+wordnum;

        buf.append("<font style=\"background=#ffcc00\">");
        //buf.append("<a href=\"javascript:show('spelltip-"+wordnum+"')\" onmouseover=\"javascript:show('spelltip-"+wordnum+"')\">");
        //buf.append(word);
        buf.append("<input id=\"spellinputbox-"+wordnum+"\" type=text name=\"" + radioName + "-manual\" size="+origWord.length()+" maxlength=75 value=\""+reger.core.Util.cleanForHtml(origWord)+"\" style=\"font-size: 16px; color: #000000; background: #ffcc00;\" onmouseover=\"javascript:show('spelltip-"+wordnum+"')\">");
        //buf.append("</a>");
        buf.append("</font>");
        buf.append(" ");

        buf.append("<div id=\"spelltip-"+wordnum+"\" style=\"visibility: hidden; display: none; z-index:2000; position: absolute;\">");

        buf.append("<table bgcolor=#ffcc00>");
        buf.append("<tr><td bgcolor=#666666>");
        buf.append("<font face=arial size=-1 color=#ffffff><b>");
        buf.append("Suggestions&nbsp;&nbsp;&nbsp;&nbsp;");
        buf.append("</b></font>");
        buf.append("</td></tr>");

        //buf.append("<tr><td bgcolor=#e6e6e6>");
        //buf.append("<font face=arial size=-1>");
        //buf.append("<input id=\"spellinputbox-"+wordnum+"\" type=text name=\"" + radioName + "-manual\" size=10 maxlength=75 value=\""+reger.core.Util.cleanForHtml(origWord)+"\" style=\"font-size: 16px;\">");
        //buf.append("</font>");
        //buf.append("</td></tr>");

        buf.append("<tr><td bgcolor=#ffcc00>");
        buf.append("<font face=arial size=-1>");
        if (words == null || words.size() < 1){
            buf.append("No Suggestions");
            buf.append("<br>");
        }else{
            for (Iterator it2=words.iterator(); it2.hasNext();){
                word = it2.next().toString();
                buf.append("<input type=radio name="+radioName+" value=\"" + reger.core.Util.cleanForHtml(word) + "\" onclick=\"javascript:changevalueofinputbox('spellinputbox-"+wordnum+"', '"+reger.core.Util.cleanForHtml(word)+"')\">");
                buf.append(word);
                buf.append("<br>");
            }
        }

        buf.append("</font>");
        buf.append("</td></tr>");


        buf.append("<tr><td bgcolor=#ffffcc>");
        buf.append("<font face=arial size=-1><b>");
        buf.append("<a href=\"javascript:hide('spelltip-"+wordnum+"')\">");
        buf.append("Close");
        buf.append("</a>");
        buf.append("</b></font>");
        buf.append("</td></tr>");


        buf.append("</table>");

        buf.append("</div>");

        return buf.toString();
    }

    public String replaceWithChosenRecommendation(HttpServletRequest request){

        //reger.core.Util.logtodb("RegerSpellCheck.java - 1");

        //HttpSession session = request.getSession(true);
        //StringBuffer entryText = new StringBuffer((String) session.getAttribute("entryText"));
        //ArrayList events = (ArrayList) session.getAttribute("spellCheckEvents");
        StringBuffer entryText = new StringBuffer(textToSpellCheck);
        ArrayList events = spellCheckEvents;

        //reger.core.Util.logtodb("RegerSpellCheck.java - 2");

        SpellCheckEvent event = null;
        String oldWord = null;
        String newWord = null;
        int start = -1;
        int end = -1;
        int wordnum=0;
        for(ListIterator it=events.listIterator(events.size()); it.hasPrevious();){
            //reger.core.Util.logtodb("RegerSpellCheck.java - 3");
            event = (SpellCheckEvent)it.previous();
            oldWord = event.getInvalidWord();
            //reger.core.Util.logtodb("RegerSpellCheck.java - 4 - oldWord=" + oldWord);
            wordnum=wordnum+1;
            if (request.getParameter("replacementWords-" + wordnum + "-manual")!=null && !request.getParameter("replacementWords-" + wordnum + "-manual").equals("")){
                newWord =  request.getParameter("replacementWords-" + wordnum + "-manual");
            } else {
                newWord = oldWord;
            }
            //newWord = replacementWords[ --count ];
            if (!oldWord.equals(newWord)){
                start = event.getWordContextPosition();
                end = start + oldWord.length();
                entryText.replace( start, end, newWord );
            }
            //reger.core.Util.logtodb("RegerSpellCheck.java - 5");
        }

        //reger.core.Util.logtodb("RegerSpellCheck.java - 6");

        //clearSessionVars(request);

        //reger.core.Util.logtodb("RegerSpellCheck.java - 7");

        return entryText.toString();
    }

    //public static void clearSessionVars(HttpServletRequest request){
        //HttpSession session = request.getSession(true);
        //session.removeAttribute("spellCheckEvents");
        //session.removeAttribute("entryText");
    //}

}
