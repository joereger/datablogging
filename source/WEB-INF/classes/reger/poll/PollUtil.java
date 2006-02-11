package reger.poll;

import reger.core.db.Db;
import reger.core.Debug;
import reger.UserSession;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.math.BigInteger;

/**
 * PollUtil
 */
public class PollUtil extends Poll {

    private UserSession userSession;
    private ArrayList orderdPollList = new ArrayList();
    private HashMap pollMap = new HashMap();
    private ArrayList answerList = null;
    private HashMap answerMap = null;
    private HashMap readerAnswerMap = null;
    private HashMap commentMap = null;
    private String eventid = null;
    private String title = null;
    private String pollid = null;
    private String question = null;
    private String readersCanAddOwnAnswer = null;
    private String readersCanAddComments = null;
    private String readersCanVoteonReaderAnswers = null;
    private String readerInputIsModerated = null;
    private String isOpen = null;
    private String pollAnswerId = null;
    private String ownerAnswer = null;
    private String ownerAnswerVotes = null;
    private String pollReaderAnswerId = null;
    private String readerAnswer = null;
    private String readerName = null;
    private String readerAnswerVotes = null;
    private String answerIsApproved = null;
    private String pollReaderCommentid = null;
    private String comment = null;
    private String commentReaderName = null;
    private String commentIsApproved = null;
    private Iterator ansIter = null;
    private Iterator commentIter = null;
    private Iterator iter = null;
    private ArrayList dataList = new ArrayList();

    public ArrayList getPollData(UserSession userSession) {
        this.userSession = userSession;
        pollMap = getData("byAccountId");
        processData(pollMap);
        return dataList;
    }

    public HashMap getPollByEventId(int eventId) {
        this.eventid = new Integer(eventId).toString();
        pollMap = getData("byEventId");
        processData(pollMap);
        return this.pollMap;
    }

    public void savePoll(HttpServletRequest request) {
        try {
            if (request.getParameter("submitPoll") != null) {
                if (request.getParameter("submitPoll").equalsIgnoreCase("Save") || request.getParameter("submitPoll").equalsIgnoreCase("Open") || request.getParameter("submitPoll").equalsIgnoreCase("Closed")) {
                    // Save Poll
                    Poll poll = null;
                    if (request.getParameter("pollid") != null) {
                        poll = new Poll(Integer.parseInt(request.getParameter("pollid")));
                    } else {
                        poll = new Poll();
                    }
                    if (request.getParameter("eventid") != null) {
                        poll.setEventid(Integer.parseInt(request.getParameter("eventid")));
                    }
                    poll.setQuestion(request.getParameter("question"));
                    if (request.getParameter("readerscanaddownanswer") == null) {
                        poll.setReaderscanaddownanswer(false);
                    } else if (request.getParameter("readerscanaddownanswer").equalsIgnoreCase("on")) {
                        poll.setReaderscanaddownanswer(true);
                    }
                    if (request.getParameter("readerscanaddcomments") == null) {
                        poll.setReaderscanaddcomments(false);
                    } else if (request.getParameter("readerscanaddcomments").equalsIgnoreCase("on")) {
                        poll.setReaderscanaddcomments(true);
                    }
                    if (request.getParameter("readerscanvoteonreaderanswers") == null) {
                        poll.setReaderscanvoteonreaderanswers(false);
                    } else if (request.getParameter("readerscanvoteonreaderanswers").equalsIgnoreCase("on")) {
                        poll.setReaderscanvoteonreaderanswers(true);
                    }
                    if (request.getParameter("readerinputismoderated") == null) {
                        poll.setReaderinputismoderated(false);
                    } else if (request.getParameter("readerinputismoderated").equalsIgnoreCase("on")) {
                        poll.setReaderinputismoderated(true);
                    }
                    if (request.getParameter("submitPoll").equalsIgnoreCase("Open") || request.getParameter("submitPoll").equalsIgnoreCase("Save")) {
                        poll.setIsopen(true);
                    } else if (request.getParameter("submitPoll").equalsIgnoreCase("Closed")) {
                        poll.setIsopen(false);
                    }
                    poll.save();
                    // Saving Poll Answer
                    PollAnswer pollAnswer = null;
                    int noOfTextFields = 0;
                    // noOfTextFields gives the total number of answer text fields present in the GUI.
                    if (request.getParameter("noOfTextFields") != null) {
                        noOfTextFields = Integer.parseInt(request.getParameter("noOfTextFields"));
                    }
                    for (int i = 0; i < noOfTextFields; i++) {
                        if (request.getParameter("answer" + i) != null && !request.getParameter("answer" + i).trim().equals("")) {
                            pollAnswer = new PollAnswer();
                            pollAnswer.setPollid(poll.getPollid());
                            pollAnswer.setAnswer(request.getParameter("answer" + i));
                            pollAnswer.save();
                        }
                    }
                    // Save approved Answers, if owner approves any.
                    String[] unApprovedAnswers = request.getParameterValues("unApprovedAnswers");
                    if (unApprovedAnswers != null && unApprovedAnswers.length > 0) {
                        PollReaderAnswer pollReaderAnswer = null;
                        for (int i=0;i<unApprovedAnswers.length;i++) {
                            pollReaderAnswer = new PollReaderAnswer(Integer.parseInt(unApprovedAnswers[i]));
                            pollReaderAnswer.setIsapproved(true);
                            pollReaderAnswer.save();
                        }
                    }
                    // Save approved comments, if owner approves any.
                    String[] unApprovedComments = request.getParameterValues("unApprovedComments");
                    if (unApprovedAnswers != null && unApprovedAnswers.length > 0) {
                        PollReaderComment pollReaderComment = null;
                        for (int i=0;i<unApprovedAnswers.length;i++) {
                            pollReaderComment = new PollReaderComment(Integer.parseInt(unApprovedComments[i]));
                            pollReaderComment.setIsapproved(true);
                            pollReaderComment.save();
                        }
                    }
                }
            }
        } catch (Exception e) {
            Debug.errorsave(e, "Exception while saving poll data is " + e.getMessage());
        }
    }

    public ArrayList getAnswersByPollId(int pollId) {
        HashMap answerMap = null;
        HashMap eventMap = null;
        HashMap unApprovedAnswersMap = null;
        HashMap unApprovedCommentsMap = null;
        ArrayList dataList = null;
        if (pollId != 0) {
            //-----------------------------------
            //-----------------------------------
            //String[][] pollAnswerData = Db.RunSQL("SELECT poll.readerscanaddownanswer, pollanswer.answer, pollreaderanswer.answer, pollreaderanswer.isapproved, event.eventid, event.title FROM event, poll, pollanswer, pollreaderanswer WHERE poll.eventid=event.eventid AND poll.pollid='" + pollId + "' AND pollanswer.pollid=poll.pollid AND pollreaderanswer.pollid=poll.pollid");
            String[][] pollAnswerData = Db.RunSQL("SELECT poll.readerscanaddownanswer, pollanswer.answer, pollreaderanswer.answer, pollreaderanswer.isapproved, event.eventid, event.title, pollreadercomment.comment, pollreadercomment.pollreadercommentid, pollreaderanswer.pollreaderanswerid FROM event, poll LEFT JOIN pollanswer ON pollanswer.pollid=poll.pollid LEFT JOIN pollreaderanswer ON  pollreaderanswer.pollid=poll.pollid  AND pollreaderanswer.isapproved = 0 LEFT JOIN pollreadercomment ON pollreadercomment.pollid=poll.pollid AND pollreadercomment.isapproved = 0 WHERE poll.eventid=event.eventid AND poll.pollid='" + pollId + "'");
            //-----------------------------------
            //-----------------------------------
            if (pollAnswerData != null && pollAnswerData.length > 0) {
                answerMap = new HashMap();
                eventMap = new HashMap();
                unApprovedAnswersMap = new HashMap();
                unApprovedCommentsMap  = new HashMap();
                dataList = new ArrayList(4);
                for (int i = 0; i < pollAnswerData.length; i++) {
                    answerMap.put(pollAnswerData[i][1], pollAnswerData[i][1]);
                    // checking if readerscanaddownanswer is true or not. Considering 1 as true.
                    if (pollAnswerData[i][0].equalsIgnoreCase("1") && pollAnswerData[i][3].equalsIgnoreCase("1")) {
                        answerMap.put(pollAnswerData[i][2], pollAnswerData[i][2]);
                    } if (pollAnswerData[i][3].equalsIgnoreCase("0")) {
                        // reader answer and reader answer id
                        unApprovedAnswersMap.put(pollAnswerData[i][2]+"~"+pollAnswerData[i][8], pollAnswerData[i][2]);
                    }
                    // comment and comment id
                    unApprovedCommentsMap.put(pollAnswerData[i][6]+"~"+pollAnswerData[i][7], pollAnswerData[i][6]);
                    eventMap.put(pollAnswerData[i][4], pollAnswerData[i][5]);
                }
                dataList.add(0, answerMap);
                dataList.add(1, eventMap);
                dataList.add(2, unApprovedAnswersMap);
                dataList.add(3, unApprovedCommentsMap);
            }
        }
        return dataList;
    }

    private HashMap getData(String method) {
        try {
            //-----------------------------------
            //-----------------------------------
            String[][] pollData = Db.RunSQL(getQuery(method));
            //-----------------------------------
            //-----------------------------------
            if (pollData != null && pollData.length > 0) {
                int index = 0;
                for (int i = 0; i < pollData.length; i++) {
                    eventid = pollData[i][0];
                    title = pollData[i][1];
                    pollid = pollData[i][2];
                    question = pollData[i][3];
                    readersCanAddOwnAnswer = pollData[i][4];
                    readersCanAddComments = pollData[i][5];
                    readersCanVoteonReaderAnswers = pollData[i][6];
                    readerInputIsModerated = pollData[i][7];
                    isOpen = pollData[i][8];
                    pollAnswerId = pollData[i][9];
                    if (pollAnswerId != null && pollAnswerId.trim().equals("")) {
                        pollAnswerId = " ";
                    }
                    ownerAnswer = pollData[i][10];
                    if (ownerAnswer != null && ownerAnswer.trim().equals("")) {
                        ownerAnswer = " ";
                    }
                    ownerAnswerVotes = pollData[i][11];
                    if (ownerAnswerVotes != null && ownerAnswerVotes.trim().equals("")) {
                        ownerAnswerVotes = " ";
                    }
                    pollReaderAnswerId = pollData[i][12];
                    if (pollReaderAnswerId != null && pollReaderAnswerId.trim().equals("")) {
                        pollReaderAnswerId = " ";
                    }
                    readerAnswer = pollData[i][13];
                    if (readerAnswer != null && readerAnswer.trim().equals("")) {
                        readerAnswer = " ";
                    }
                    readerName = pollData[i][14];
                    if (readerName != null && readerName.trim().equals("")) {
                        readerName = " ";
                    }
                    readerAnswerVotes = pollData[i][15];
                    if (readerAnswerVotes != null && readerAnswerVotes.trim().equals("")) {
                        readerAnswerVotes = " ";
                    }
                    answerIsApproved = pollData[i][16];
                    if (answerIsApproved != null && answerIsApproved.trim().equals("")) {
                        answerIsApproved = " ";
                    }
                    pollReaderCommentid = pollData[i][17];
                    if (pollReaderCommentid != null && pollReaderCommentid.trim().equals("")) {
                        pollReaderCommentid = " ";
                    }
                    comment = pollData[i][18];
                    if (comment != null && comment.trim().equals("")) {
                        comment = " ";
                    }
                    commentReaderName = pollData[i][19];
                    if (commentReaderName != null && commentReaderName.trim().equals("")) {
                        commentReaderName = " ";
                    }
                    commentIsApproved = pollData[i][20];
                    if (commentIsApproved != null && commentIsApproved.trim().equals("")) {
                        commentIsApproved = " ";
                    }

                    if (pollMap.containsKey(eventid + "~" + title + "~" + pollid + "~" + question + "~" + readersCanAddOwnAnswer + "~" + readersCanAddComments + "~" + readersCanVoteonReaderAnswers + "~" + readerInputIsModerated + "~" + isOpen)) {
                        answerList = (ArrayList) pollMap.get(eventid + "~" + title + "~" + pollid + "~" + question + "~" + readersCanAddOwnAnswer + "~" + readersCanAddComments + "~" + readersCanVoteonReaderAnswers + "~" + readerInputIsModerated + "~" + isOpen);
                    } else {
                        answerList = new ArrayList(2);
                        answerMap = null;
                        readerAnswerMap = null;
                    }
                    // Retrieve answerMap and readerAnswerMap from the list if the list size is > 0
                    if (answerList != null && answerList.size() > 0) {
                        answerMap = (HashMap) answerList.get(0);
                        readerAnswerMap = (HashMap) answerList.get(1);
                    }
                    if (answerMap == null) {
                        answerMap = new HashMap();
                    }
                    if (readerAnswerMap == null) {
                        readerAnswerMap = new HashMap();
                    }
                    // Key is combination of pollanswerid, answer, votes
                    answerMap.put(pollAnswerId + "~" + ownerAnswer + "~" + ownerAnswerVotes, pollAnswerId + "~" + ownerAnswer + "~" + ownerAnswerVotes);
                    if (readerAnswerMap.containsKey(pollReaderAnswerId + "~" + readerAnswer + "~" + readerName + "~" + readerAnswerVotes + "~" + answerIsApproved)) {
                        commentMap = (HashMap) readerAnswerMap.get(pollReaderAnswerId + "~" + readerAnswer + "~" + readerName + "~" + readerAnswerVotes + "~" + answerIsApproved);
                    } else {
                        commentMap = new HashMap();
                    }
                    // add Comments.
                    // Key is combination of pollreadercommentid, comment, readername, isapproved
                    commentMap.put(pollReaderCommentid + "~" + comment + "~" + commentReaderName + "~" + commentIsApproved, pollReaderCommentid + "~" + comment + "~" + commentReaderName + "~" + commentIsApproved);
                    // add Comments to reader answer Map.
                    // Key is combination of pollreaderanswerid, answer, readername, votes, isapproved
                    readerAnswerMap.put(pollReaderAnswerId + "~" + readerAnswer + "~" + readerName + "~" + readerAnswerVotes + "~" + answerIsApproved, commentMap);
                    // Owner answer HashMap at index 0.
                    // Reader answer map at index 1.
                    answerList.add(0, answerMap);
                    answerList.add(1, readerAnswerMap);
                    // Key is combination of eventid, event, pollid, question,readerscanaddownanswer, readerscanaddcomments,
                    // readerscanvoteonreaderanswers, readerinputismoderated,isOpen
                    pollMap.put(eventid + "~" + title + "~" + pollid + "~" + question + "~" + readersCanAddOwnAnswer + "~" + readersCanAddComments + "~" + readersCanVoteonReaderAnswers + "~" + readerInputIsModerated + "~" + isOpen, answerList);
                    // Following is done to not to lose the order of the poll. (ex: by event create date).
                    if (!orderdPollList.contains(eventid + "~" + title + "~" + pollid + "~" + question + "~" + readersCanAddOwnAnswer + "~" + readersCanAddComments + "~" + readersCanVoteonReaderAnswers + "~" + readerInputIsModerated + "~" + isOpen)) {
                        orderdPollList.add(index++, eventid + "~" + title + "~" + pollid + "~" + question + "~" + readersCanAddOwnAnswer + "~" + readersCanAddComments + "~" + readersCanVoteonReaderAnswers + "~" + readerInputIsModerated + "~" + isOpen);
                    }
                }
            }
        } catch (Exception e) {
            Debug.errorsave(e, "Exception while retrieving poll data for a given event id is " + e.getMessage());
        }
        return pollMap;
    }

    private String getQuery(String method) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT event.eventid, event.title, poll.pollid, poll.question, poll.readerscanaddownanswer, poll.readerscanaddcomments, poll.readerscanvoteonreaderanswers, poll.readerinputismoderated, poll.isopen, pollanswer.pollanswerid, pollanswer.answer, pollanswer.votes, pollreaderanswer.pollreaderanswerid, pollreaderanswer.answer, pollreaderanswer.readername, pollreaderanswer.votes, pollreaderanswer.isapproved, pollreadercomment.pollreadercommentid, pollreadercomment.comment, pollreadercomment.readername, pollreadercomment.isapproved FROM event, megalog, poll LEFT JOIN pollanswer ON pollanswer.pollid = poll.pollid LEFT JOIN pollreaderanswer ON pollreaderanswer.pollid = poll.pollid LEFT JOIN pollreadercomment ON pollreadercomment.pollid = poll.pollid WHERE ");
        if (method.equals("byAccountId")) {
            query.append("poll.eventid = event.eventid AND event.logid=megalog.logid AND " + userSession.getAccountuser().LogsUserCanAdministerQueryend(userSession.getAccount().getAccountid()) + " ORDER BY event.createdate");
        }
        if (method.equals("byEventId")) {
            query.append("poll.eventid=event.eventid AND event.eventid='" + eventid + "' ORDER BY event.createdate");
        }
        return query.toString();
    }

    private void processData(HashMap pollMap) {
        try {
            int index = 0;
            if (orderdPollList != null && orderdPollList.size() > 0) {
                iter = orderdPollList.iterator();
                StringTokenizer stkr = null;
                String key = null;
                BigInteger totalVotes = null;
                BigInteger unApprovedCount = null;
                BigInteger commentCount = null;
                while (iter.hasNext()) {
                    totalVotes = new BigInteger("0");
                    unApprovedCount = new BigInteger("0");
                    commentCount = new BigInteger("0");
                    key = (String) iter.next();
                    answerList = (ArrayList) pollMap.get(key);
                    answerMap = (HashMap) answerList.get(0);
                    readerAnswerMap = (HashMap) answerList.get(1);
                    stkr = new StringTokenizer(key, "~");
                    while (stkr.hasMoreElements()) {
                        eventid = (String) stkr.nextElement();
                        title = (String) stkr.nextElement();
                        pollid = (String) stkr.nextElement();
                        question = (String) stkr.nextElement();
                        readersCanAddOwnAnswer = (String) stkr.nextElement();
                        readersCanAddComments = (String) stkr.nextElement();
                        readersCanVoteonReaderAnswers = (String) stkr.nextElement();
                        readerInputIsModerated = (String) stkr.nextElement();
                        isOpen = (String) stkr.nextElement();
                    }
                    ansIter = answerMap.keySet().iterator();
                    while (ansIter.hasNext()) {
                        key = (String) ansIter.next();
                        stkr = new StringTokenizer(key, "~");
                        pollAnswerId = (String) stkr.nextElement();
                        ownerAnswer = (String) stkr.nextElement();
                        ownerAnswerVotes = (String) stkr.nextElement();
                        if (ownerAnswerVotes != null && ownerAnswerVotes.trim().equalsIgnoreCase("")) {
                            ownerAnswerVotes = "0";
                        }
                        totalVotes = totalVotes.add(new BigInteger(ownerAnswerVotes));
                    }
                    ansIter = readerAnswerMap.keySet().iterator();
                    while (ansIter.hasNext()) {
                        key = (String) ansIter.next();
                        stkr = new StringTokenizer(key, "~");
                        while (stkr.hasMoreElements()) {
                            pollReaderAnswerId = (String) stkr.nextElement();
                            readerAnswer = (String) stkr.nextElement();
                            readerName = (String) stkr.nextElement();
                            readerAnswerVotes = (String) stkr.nextElement();
                            if (readerAnswerVotes != null && readerAnswerVotes.trim().equalsIgnoreCase("")) {
                                readerAnswerVotes = "0";
                            }
                            totalVotes = totalVotes.add(new BigInteger(readerAnswerVotes));
                            answerIsApproved = (String) stkr.nextElement();
                            if (answerIsApproved.equalsIgnoreCase("0")) {
                                unApprovedCount = unApprovedCount.add(new BigInteger("1"));
                            }
                        }
                        commentMap = (HashMap) readerAnswerMap.get(key);
                        commentCount = commentCount.add(new BigInteger(new Integer(commentMap.size()).toString()));
                        commentIter = commentMap.keySet().iterator();
                        while (commentIter.hasNext()) {
                            stkr = new StringTokenizer((String) commentIter.next(), "~");
                            while (stkr.hasMoreElements()) {
                                pollReaderCommentid = (String) stkr.nextElement();
                                comment = (String) stkr.nextElement();
                                commentReaderName = (String) stkr.nextElement();
                                commentIsApproved = (String) stkr.nextElement();
                                if (commentIsApproved.equalsIgnoreCase("0")) {
                                    unApprovedCount = unApprovedCount.add(new BigInteger("1"));
                                }
                            }
                        }
                    }
                    dataList.add(index++, eventid + "~" + title + "~" + pollid + "~" + question + "~" + isOpen + "~" + totalVotes + "~" + commentCount + "~" + unApprovedCount);
                }
            }
        } catch (Exception e) {
            Debug.errorsave(e, "Exception while getting poll data is " + e.getMessage());
        }
    }
}