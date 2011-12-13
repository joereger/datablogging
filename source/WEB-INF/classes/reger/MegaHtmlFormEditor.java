package reger;

/**
 *
 */
public class MegaHtmlFormEditor {

    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletRequest request){
        StringBuffer mb = new StringBuffer();


        //Spelling errors
        if (1==2 || pageProps.entry.haveSpellingErrors){

            //First, show a radio allowing user to choose to use recommendations or edit manually
            mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#ffcc00>");
            mb.append("<input type=radio name=usespellingrecommendations value=1 checked onclick=\"javascript:hideandshow('manualentry', 'spellingrecommendations');\">");
            //mb.append("<input type=radio name=usespellingrecommendations value=1 checked>");
            mb.append("<font face=arial size=-1>");
            mb.append("Use Spelling Recommendations:");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Roll over the yellow words to see suggestions.  Make your choice and/or manually edit the word.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");

            //Next, display the entry with errors as recommendations
            mb.append("<div id=\"spellingrecommendations\" style=\"visibility: visible; display: inline;\">");
            mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#ffffff>");
            //Spell check is only for pro accounts
            if (userSession.getAccount().isPro()) {
                mb.append(pageProps.entry.textWithSuggestionsAsDropdowns);
            } else {
                mb.append("<a href='accountstatus.log'><img src='../images/pro-only-in.gif' alt='' border='0'><br><font face=arial size=-1>The spell check feature is only available in the Pro version.  Click the radio in the grey area below to manually edit your entry.  Your entry has not yet been saved so you must continue.</a>");
            }
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");
            mb.append("</div>");

            //Next, show a radio allowing user to choose to use recommendations or edit manually
            mb.append("<table width=100% cellpadding=5 cellspacing=0 border=0>");
            mb.append("<tr>");
            mb.append("<td bgcolor=#cccccc>");
            mb.append("<input type=radio name=usespellingrecommendations value=0 onclick=\"javascript:hideandshow('spellingrecommendations', 'manualentry');\">");
            //mb.append("<input type=radio name=usespellingrecommendations value=0>");
            mb.append("<font face=arial size=-1>");
            mb.append("Or manually edit your entry:");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Make sure that you select the radio button to the left to tell the system that you want to manually fix the errors.");
            mb.append("</font>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");

            mb.append("<div id=\"manualentry\" style=\"visibility: hidden; display: none;\">");
        }


        if (userSession.getAccountuser().getEntrymode()==reger.Vars.ENTRYMODESIMPLE) {
            //Get the text-based editor
            mb.append("\n" + "<script language=\"JavaScript\"><!--" + "\n");
            mb.append("function submitPost() {" + "\n");
            //mb.append("    document.entryform.submit();" + "\n");
            mb.append("    xGetElementById('entryform').submit();");
            mb.append("}" + "\n");
            mb.append("//--></script>" + "\n");

            mb.append("\n" + "<script language=\"JavaScript\"><!--" + "\n");
            mb.append("function appendImageTag(imageid) {" + "\n");
            mb.append("    $(\"#entrybodyinput\").append('<$image id=\"' + imageid + '\"$>');");
            //mb.append("    $(\"#entrybodyinput\").append('<$image id=\"').append($imageid).append('\"$>');");
            mb.append("}" + "\n");
            mb.append("//--></script>" + "\n");

            //mb.append("<textarea cols='45' rows='10' name='comments' wrap='virtual' style='width: 75%;font: 10pt monospace' class=\"expandify\">"+pageProps.entry.comments+"</textarea>");
            mb.append("<textarea name=\"comments\" id=\"entrybodyinput\" wrap=\"virtual\" rows=\"5\" style=\"overflow: hidden; height: 80px; width: 75%;\" class=\"expand80-200000\">"+pageProps.entry.comments+"</textarea>");
            //Expanding input box script
            mb.append("<script type='text/javascript' src='"+pageProps.pathToAppRoot+"/js/jquery.textarea-expander.js'></script>" + reger.Vars.LINEBREAKCHARFORHTML);
            mb.append("");
        } else {
            //Get the Wysiwyg editor
            mb.append(reger.MegaHtmlFormFckeditor.getHtml(userSession, pageProps, true, pageProps.entry.comments, request));
        }


        if (1==2 || pageProps.entry.haveSpellingErrors){
            mb.append("</div>");
        }


        return mb;
    }

}
