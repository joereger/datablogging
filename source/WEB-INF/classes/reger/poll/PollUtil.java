package reger.poll;

import reger.core.db.Db;
import reger.core.Debug;
import reger.UserSession;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * PollUtil
 */
public class PollUtil extends Poll {

    public ArrayList getPollData(UserSession userSession) {
        ArrayList dataList = new ArrayList();
        try {
            //-----------------------------------
            //-----------------------------------
            String[][] pollData = Db.RunSQL("SELECT event.eventid, event.title, poll.pollid, poll.question, poll.isopen FROM event, poll WHERE event.accountid='" + userSession.getAccount().getAccountid() + "' AND poll.eventid=event.eventid ORDER BY event.createdate");
            //-----------------------------------
            //-----------------------------------
            String eventid = null;
            String title = null;
            String pollid = null;
            String question = null;
            String isOpen = null;
            int totalVotes = 0;
            int unApprovedCount = 0;
            int commentCount = 0;
            int index = 0;
            if (pollData != null && pollData.length > 0) {
                for (int i = 0; i < pollData.length; i++) {
                    totalVotes = 0;
                    unApprovedCount = 0;
                    commentCount = 0;
                    eventid = pollData[i][0];
                    title = pollData[i][1];
                    pollid = pollData[i][2];
                    question = pollData[i][3];
                    isOpen = pollData[i][4];
                    //-----------------------------------
                    //-----------------------------------
                    String[][] pollAnswerData = Db.RunSQL("SELECT votes FROM pollanswer where pollid='" + pollid + "'");
                    //-----------------------------------
                    //-----------------------------------
                    if (pollAnswerData != null && pollAnswerData.length > 0) {
                        for (int j = 0; j < pollAnswerData.length; j++) {
                            // Total Votes
                            totalVotes += Integer.parseInt(pollAnswerData[j][0]);
                        }
                    }
                    //-----------------------------------
                    //-----------------------------------
                    String[][] pollReaderAnswerData = Db.RunSQL("SELECT votes, isapproved FROM pollreaderanswer where pollid='" + pollid + "'");
                    //-----------------------------------
                    //-----------------------------------
                    if (pollReaderAnswerData != null && pollReaderAnswerData.length > 0) {
                        for (int k = 0; k < pollReaderAnswerData.length; k++) {
                            totalVotes += Integer.parseInt(pollReaderAnswerData[k][0]);
                            // Un Approved Count
                            if (pollReaderAnswerData[k][1].equals("0")) {
                                unApprovedCount += 1;
                            }
                        }
                    }
                    //-----------------------------------
                    //-----------------------------------
                    String[][] pollReaderCOmmentData = Db.RunSQL("SELECT isapproved FROM pollreadercomment where pollid='" + pollid + "'");
                    //-----------------------------------
                    //-----------------------------------
                    if (pollReaderCOmmentData != null && pollReaderCOmmentData.length > 0) {
                        for (int l = 0; l < pollReaderCOmmentData.length; l++) {
                            // Total Comment Count
                            commentCount += 1;
                            if (pollReaderAnswerData[l][0].equals("0")) {
                                unApprovedCount += 1;
                            }
                        }
                    }
                    dataList.add(index, eventid + "~" + title + "~" + pollid + "~" + question + "~" + isOpen + "~" + totalVotes + "~" + commentCount + "~" + unApprovedCount);
                    index ++;
                }
            }
        } catch (Exception e) {
           Debug.errorsave(e, "Exception while getting poll data is " + e.getMessage());
        }
        return dataList;
    }

    public void savePoll(HttpServletRequest request) {
        try {
            // Save Poll
            Poll poll = new Poll();
            if (request.getParameter("eventid") != null) {
                poll.setEventid(Integer.parseInt(request.getParameter("eventid")));
            } else {
                Debug.errorsave(new Exception ("No eventid"), "Eventid is null");
                return;
            }
            poll.setQuestion(request.getParameter("question"));
            if (request.getParameter("readerscanaddownanswer").equalsIgnoreCase("on")) {
                poll.setReaderscanaddownanswer(true);
            } else {
                poll.setReaderscanaddownanswer(false);
            }
            if (request.getParameter("readerscanaddcomments").equalsIgnoreCase("on")) {
                poll.setReaderscanaddcomments(true);
            } else {
                poll.setReaderscanaddcomments(false);
            }
            if (request.getParameter("readerscanvoteonreaderanswers").equalsIgnoreCase("on")) {
                poll.setReaderscanvoteonreaderanswers(true);
            } else {
                poll.setReaderscanvoteonreaderanswers(false);
            }
            if (request.getParameter("readerinputismoderated").equalsIgnoreCase("on")) {
                poll.setReaderinputismoderated(true);
            } else {
                poll.setReaderinputismoderated(false);
            }
            poll.setIsopen(true);
            poll.save();
            // Saving Poll Answer
            PollAnswer pollAnswer = null;
            int noOfTextFields = 0;
            // noOfTextFields gives the total number of answer text fields present in the GUI.
            if (request.getParameter("noOfTextFields") != null) {
               noOfTextFields = Integer.parseInt(request.getParameter("noOfTextFields"));
            }
            for (int i=0;i<noOfTextFields;i++) {
                if (request.getParameter("answer"+i) != null && !request.getParameter("answer"+i).trim().equals("")) {
                    pollAnswer = new PollAnswer();
                    pollAnswer.setPollid(poll.getPollid());
                    pollAnswer.setAnswer(request.getParameter("answer"+i));
                    pollAnswer.save();
                }
            }
        } catch (Exception e) {
           Debug.errorsave(e, "Exception while saving poll data is " + e.getMessage());
        }
    }
}