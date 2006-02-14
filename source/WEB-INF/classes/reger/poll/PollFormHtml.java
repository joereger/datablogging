package reger.poll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 *
 */
public class PollFormHtml {

    public static StringBuffer getPollForm(Poll poll){
        StringBuffer mb = new StringBuffer();

        mb.append("<form action=entries-poll-votes.log method=post style=\"margin: 3px;\">");
        mb.append("<input type=hidden name=action value='voteonpoll'>");
        mb.append("<input type=hidden name=pollid value='"+poll.getPollid()+"'>");

        mb.append("<table cellpadding=1 cellspacing=1 border=0>");
        //Display the question
        mb.append("<tr>");
        mb.append("<td valign=top align=left colspan=2>");
        mb.append("<font face=arial size=-1><b>");
        mb.append(poll.getQuestion());
        mb.append("</b></font>");
        mb.append("</td>");
        mb.append("</tr>");
        //Display owner answers
        for (Iterator it = poll.getPollAnswers().iterator(); it.hasNext(); ) {
            PollAnswer answer = (PollAnswer)it.next();
            mb.append("<tr>");
            mb.append("<td valign=top align=left>");
            mb.append("<input type=radio name=answer value=o~" + answer.getPollanswerid() + ">");
            mb.append("</td>");
            mb.append("<td valign=top align=left>");
            mb.append("<font face=arial size=-2>");
            mb.append(answer.getAnswer());
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }
        //If readers can add their own answers
        if (poll.getReaderscanaddownanswer()){
            //Display reader answers
            for (Iterator it = poll.getPollReaderAnswers().iterator(); it.hasNext(); ) {
                PollReaderAnswer answer = (PollReaderAnswer)it.next();
                //If the answer is approved
                if (answer.getIsapproved()){
                    //If readers can vote on each other's answers
                    if (poll.getReaderscanvoteonreaderanswers()){
                        mb.append("<tr>");
                        mb.append("<td valign=top align=left>");
                        mb.append("<input type=radio name=answer value=r~" + answer.getPollreaderanswerid() + ">");
                        mb.append("</td>");
                        mb.append("<td valign=top align=left>");
                        mb.append("<font face=arial size=-2>");
                        mb.append(answer.getAnswer());
                        mb.append("</font>");
                        mb.append("</td>");
                        mb.append("</tr>");
                    }
                }
            }
            //Allow readers to add their own answer
            if (poll.getIsopen()){
                mb.append("<tr>");
                mb.append("<td valign=top align=left>");
                mb.append("<input type=radio name=answer value=newreaderanswer>");
                mb.append("</td>");
                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-2>");
                mb.append("Provide your own answer:<br>");
                mb.append("<input type=text name=readeranswer size=10 value='Answer' style=\"font-size: 9px;\"><br>");
                mb.append("<input type=text name=readername size=10 value='Name (optional)' style=\"font-size: 9px;\"><br>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
        }
        mb.append("<tr>");
        mb.append("<td valign=top align=left>");
        mb.append("");
        mb.append("</td>");
        mb.append("<td valign=top align=left>");
        mb.append("<font face=arial size=-2>");
        mb.append("<input type=submit name=Vote value=Vote><br>");
        mb.append("<a href='entries-poll-votes.log?pollid="+poll.getPollid()+"'>");
        mb.append("View Results");
        mb.append("</a>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        mb.append("</form>");

        return mb;
    }



}
