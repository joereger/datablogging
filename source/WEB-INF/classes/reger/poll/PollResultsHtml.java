package reger.poll;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.cache.EntryCache;

import java.util.Iterator;

/**
 * Used to display poll results
 */
public class PollResultsHtml {


    public static void doVoting(Poll poll, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, PageProps pageProps, UserSession userSession){
        if (poll.getIsopen()){
            if (request.getParameter("action")!=null && request.getParameter("action").equals("voteonpoll")){
                if (request.getParameter("answer")!=null){
                    String[] answerSplit = request.getParameter("answer").split("~");
                    if (answerSplit.length>=2 && reger.core.Util.isinteger(answerSplit[1])){
                        //The voter has chosen an existing answer
                        if (answerSplit[0].equals("o")){
                            //It's an owner answer, go to the Poll object so that we know this answer is part of this poll
                            PollAnswer answer = poll.getAnswerByPollAnswerid(Integer.parseInt(answerSplit[1]));
                            if (answer!=null){
                                //Since it's not null we know that this answer exists in this poll... somebody's not trying to hack the voting system
                                answer.setVotes(answer.getVotes() + 1);
                                answer.save();
                            }
                        } else if (answerSplit[0].equals("r")) {
                            //It's an owner answer, go to the Poll object so that we know this answer is part of this poll
                            PollReaderAnswer answer = poll.getReaderAnswerByPollAnswerid(Integer.parseInt(answerSplit[1]));
                            if (answer!=null){
                                //Since it's not null we know that this answer exists in this poll... somebody's not trying to hack the voting system
                                answer.setVotes(answer.getVotes() + 1);
                                answer.save();
                            }
                        }
                    } else if (request.getParameter("answer").equals("newreaderanswer")) {
                        //The voter is adding their own vote... let's make sure this is allowed in this poll
                        if (poll.getReaderscanaddownanswer()){
                            if (request.getParameter("readeranswer")!=null && !request.getParameter("readeranswer").equals("Answer")){
                                PollReaderAnswer pollReaderAnswer = new PollReaderAnswer();
                                pollReaderAnswer.setPollid(poll.getPollid());
                                pollReaderAnswer.setAnswer(request.getParameter("readeranswer"));
                                if (request.getParameter("readername")!=null && !request.getParameter("readername").equals("Name (optional)")){
                                    pollReaderAnswer.setReadername(request.getParameter("readername"));
                                }
                                pollReaderAnswer.setVotes(1);
                                if (poll.getReaderinputismoderated()){
                                    pollReaderAnswer.setIsapproved(false);
                                } else {
                                    pollReaderAnswer.setIsapproved(true);
                                }
                                pollReaderAnswer.save();
                            }
                        }
                    }
                    poll.load();
                    EntryCache.get(poll.getEventid()).loadPolls();
                }
            }
        }
    }

    public static void doCommenting(Poll poll, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, PageProps pageProps, UserSession userSession){
        if (poll.getIsopen()){
            if (request.getParameter("action")!=null && request.getParameter("action").equals("commentonpoll")){
                if (request.getParameter("comment")!=null){
                    PollReaderComment pollReaderComment = new PollReaderComment();
                    pollReaderComment.setPollid(poll.getPollid());
                    pollReaderComment.setComment(request.getParameter("comment"));
                    if (request.getParameter("commentname")!=null){
                        pollReaderComment.setReadername(request.getParameter("commentname"));
                    }
                    if (poll.getReaderinputismoderated()){
                        pollReaderComment.setIsapproved(false);
                    } else {
                        pollReaderComment.setIsapproved(true);
                    }
                    pollReaderComment.save();

                    poll.load();
                    EntryCache.get(poll.getEventid()).loadPolls();
                }
            }
        }
    }

    public static int calculateWidthOfAnswerBar(int totalvotes, int votesforthisanswer, int maxvotesforasingleanswer){
        double maxPossibleWidth = 300;
        double percentageOfTotal = Double.parseDouble(String.valueOf(votesforthisanswer))/Double.parseDouble(String.valueOf(totalvotes));
        double percentageOfMaxVotes = Double.parseDouble(String.valueOf(votesforthisanswer))/Double.parseDouble(String.valueOf(maxvotesforasingleanswer));
        double widthTmp = percentageOfMaxVotes * maxPossibleWidth;
        reger.core.Debug.debug(5, "PollResultsHtml.java", "percentageOfMaxVotes="+percentageOfMaxVotes+"<br>percentageOfTotal="+percentageOfTotal+"<br>widthTmp="+widthTmp);
        return (int)widthTmp;
    }

    public static StringBuffer getResultsGraphOnly(Poll poll, javax.servlet.http.HttpServletRequest request, PageProps pageProps, UserSession userSession){
        StringBuffer mb = new StringBuffer();

        int totalvotes = poll.getTotalVotes();
        int maxvotesforasingleanswer = poll.getMaxVotesForASingleAnswer();

        mb.append("<table cellpadding=5 cellspacing=3 border=0>");
        //Display question
        mb.append("<tr>");
        mb.append("<td valign=top align=left colspan=3>");
        mb.append("<font face=arial size=+1>");
        mb.append(poll.getQuestion());
        mb.append("</font>");
        mb.append("<td>");
        mb.append("</tr>");
        //Display owner answers
        for (Iterator it = poll.getPollAnswers().iterator(); it.hasNext(); ) {
            PollAnswer answer = (PollAnswer)it.next();
            mb.append("<tr>");
            mb.append("<td valign=top align=right>");
            mb.append("<font face=arial size=-2>");
            mb.append(answer.getAnswer());
            mb.append("</font>");
            mb.append("<td>");
            mb.append("<td valign=top align=left nowrap>");
            mb.append("<img src='"+pageProps.pathToAppRoot+"images/bar_blue.gif' border=0 width="+calculateWidthOfAnswerBar(totalvotes, answer.getVotes(), maxvotesforasingleanswer)+" height=10>");
            mb.append("<font face=arial size=-2 style=\"font-size: 9px;\">");
            mb.append(" "+answer.getVotes() + "");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top align=right>");
            mb.append("<font face=arial size=-2>");
            mb.append(" ");
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
                        mb.append("<td valign=top align=right>");
                        mb.append("<font face=arial size=-2>");
                        mb.append(answer.getAnswer());
                        mb.append("</font>");
                        mb.append("<td>");
                        mb.append("<td valign=top align=left nowrap>");
                        mb.append("<img src='"+pageProps.pathToAppRoot+"images/bar_grey.gif' border=0 width="+calculateWidthOfAnswerBar(totalvotes, answer.getVotes(), maxvotesforasingleanswer)+" height=10>");
                        mb.append("<font face=arial size=-2 style=\"font-size: 9px;\">");
                        mb.append(" "+answer.getVotes() + " ");
                        mb.append("</font>");
                        mb.append("</td>");
                        mb.append("<td valign=top align=left>");
                        mb.append("<font face=arial size=-2 style=\"font-size: 9px;\">");
                        mb.append("Answer By: ");
                        if (!answer.getReadername().equals("")){
                            mb.append(answer.getReadername());
                        } else {
                            mb.append("Anonymous");
                        }
                        mb.append("</font>");
                        mb.append("</td>");
                        mb.append("</tr>");
                    }
                }
            }
        }
        mb.append("<tr>");
        mb.append("<td valign=top align=right>");
        mb.append("<font face=arial size=-2>");
        mb.append("");
        mb.append("</font>");
        mb.append("<td>");
        mb.append("<td valign=top align=left>");
        mb.append("<font face=arial size=-2 style=\"font-size: 9px;\">");
        mb.append(totalvotes + " Total Votes");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=right>");
        mb.append("<font face=arial size=-2>");
        mb.append(" ");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }

    public static StringBuffer getResults(Poll poll, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, PageProps pageProps, UserSession userSession){
        StringBuffer mb = new StringBuffer();


        mb.append(reger.ui.RoundedCorners.start("ffffff", "cccccc", 100));
        mb.append(getResultsGraphOnly(poll, request, pageProps, userSession));
        mb.append(reger.ui.RoundedCorners.end());

        //Display comments
        if (poll.getReaderscanaddcomments() && poll.getPollReaderComments().size()>0){
            mb.append(reger.ui.RoundedCorners.start("ffffff", "cccccc", 100));
            mb.append("<table cellpadding=10 cellspacing=3 border=0>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left colspan=2>");
            mb.append("<font face=arial size=+1>");
            mb.append("Comments on this Poll");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            for (Iterator it = poll.getPollReaderComments().iterator(); it.hasNext(); ) {
                PollReaderComment comment = (PollReaderComment)it.next();
                mb.append("<tr>");
                mb.append("<td valign=top align=right>");
                mb.append("<font face=arial size=-2>");
                if (!comment.getReadername().equals("")){
                    mb.append(comment.getReadername());
                } else {
                    mb.append("Anonymous");
                }
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-1>");
                mb.append(comment.getComment().replaceAll("<", "&lt;"));
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
            mb.append("</table>");
            mb.append(reger.ui.RoundedCorners.end());
        }

        if (poll.getIsopen() && poll.getReaderscanaddcomments()){
            mb.append("<form action=entries-poll-votes.log method=post>");
            mb.append("<input type=hidden name=action value='commentonpoll'>");
            mb.append("<input type=hidden name=pollid value='"+poll.getPollid()+"'>");

            mb.append(reger.ui.RoundedCorners.start("ffffff", "cccccc", 100));
            mb.append("<table cellpadding=5 cellspacing=3 border=0>");
            mb.append("<tr>");
            mb.append("<td valign=top align=left colspan=2>");
            mb.append("<font face=arial size=+1>");
            mb.append("What do you think?");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top align=right>");
            mb.append("<font face=arial size=-2>");
            mb.append("Name (Optional)");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top align=left>");
            mb.append("<input type=text name=commentname size=45 maxsize=255>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top align=right>");
            mb.append("<font face=arial size=-2>");
            mb.append("Comment");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top align=left>");
            mb.append("<textarea name=comment cols=45 rows=5></textarea>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<tr>");
            mb.append("<td valign=top align=right>");
            mb.append("<font face=arial size=-1>");
            mb.append("");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top align=left>");
            mb.append("<input type=submit value='Add Comment'>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("</table>");
            mb.append(reger.ui.RoundedCorners.end());

            mb.append("</form>");
        }




        return mb;
    }


}
