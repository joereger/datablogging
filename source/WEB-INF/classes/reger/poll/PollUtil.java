package reger.poll;

import reger.core.db.Db;
import reger.UserSession;
import java.util.ArrayList;

/**
 * PollUtil
 */
public class PollUtil extends Poll {

    public ArrayList getPollData(UserSession userSession) {
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
        ArrayList dataList = new ArrayList();
        if (pollData != null && pollData.length > 0) {
            for (int i=0;i<pollData.length;i++) {
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
                    for (int j=0;j<pollAnswerData.length;j++) {
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
                    for (int k=0;k<pollReaderAnswerData.length;k++) {
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
                    for (int l=0;l<pollReaderCOmmentData.length;l++) {
                        // Total Comment Count
                        commentCount += 1;
                        if (pollReaderAnswerData[l][0].equals("0")) {
                            unApprovedCount += 1;
                        }
                    }
                }
                dataList.add(index, eventid+"~"+title+"~"+pollid+"~"+question+"~"+isOpen+"~"+totalVotes+"~"+commentCount+"~"+unApprovedCount);
                index ++;
            }
        }
        return dataList;
    }
}