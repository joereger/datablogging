package reger.poll;

import reger.core.db.Db;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main Poll class
 */
public class Poll extends PollDAO{

    protected ArrayList<PollAnswer> pollAnswers = new ArrayList<PollAnswer>();
    protected ArrayList<PollReaderAnswer> pollReaderAnswers = new ArrayList<PollReaderAnswer>();
    protected ArrayList<PollReaderComment> pollReaderComments = new ArrayList<PollReaderComment>();

    public Poll (int pollid){
        this.pollid = pollid;
        this.load();
    }

    public void load(){
        super.load();
        loadChildren();
    }

    private void loadChildren(){
        pollAnswers = new ArrayList<PollAnswer>();
        pollReaderAnswers = new ArrayList<PollReaderAnswer>();
        pollReaderComments = new ArrayList<PollReaderComment>();

        //-----------------------------------
        //-----------------------------------
        String[][] rstAnswers= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollid='"+pollid+"' ORDER BY pollanswerid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstAnswers!=null && rstAnswers.length>0){
            for(int i=0; i<rstAnswers.length; i++){
                pollAnswers.add(new PollAnswer(Integer.parseInt(rstAnswers[i][0])));
            }
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstReaderAnswers = Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollid='"+pollid+"' ORDER BY pollreaderanswerid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstReaderAnswers !=null && rstReaderAnswers.length>0){
            for(int i=0; i<rstReaderAnswers.length; i++){
                pollReaderAnswers.add(new PollReaderAnswer(Integer.parseInt(rstReaderAnswers[i][0])));
            }
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstReaderComments = Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollid='"+pollid+"' ORDER BY pollreadercommentid ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstReaderComments !=null && rstReaderComments.length>0){
            for(int i=0; i<rstReaderComments.length; i++){
                pollReaderComments.add(new PollReaderComment(Integer.parseInt(rstReaderComments[i][0])));
            }
        }
    }

    public int getTotalVotes(){
        int totalvotes = 0;
        for (Iterator it = pollAnswers.iterator(); it.hasNext(); ) {
            PollAnswer answer = (PollAnswer)it.next();
            totalvotes = totalvotes + answer.getVotes();
        }
        for (Iterator it = pollReaderAnswers.iterator(); it.hasNext(); ) {
            PollReaderAnswer answer = (PollReaderAnswer)it.next();
            if (answer.getIsapproved()){
                totalvotes = totalvotes + answer.getVotes();
            }
        }
        return totalvotes;
    }

    public int getMaxVotesForASingleAnswer(){
        int maxvotes = 0;
        for (Iterator it = pollAnswers.iterator(); it.hasNext(); ) {
            PollAnswer answer = (PollAnswer)it.next();
            if (answer.getVotes()>maxvotes){
                maxvotes = answer.getVotes();
            }
        }
        for (Iterator it = pollReaderAnswers.iterator(); it.hasNext(); ) {
            PollReaderAnswer answer = (PollReaderAnswer)it.next();
            if (answer.getIsapproved()){
                if (answer.getVotes()>maxvotes){
                    maxvotes = answer.getVotes();
                }
            }
        }
        return maxvotes;
    }

    public int getNumberOfComments(){
        int comments = 0;
        for (Iterator it = pollReaderComments.iterator(); it.hasNext(); ) {
            PollReaderComment comment = (PollReaderComment)it.next();
            if (comment.getIsapproved()){
                comments = comments + 1;
            }
        }
        return comments;
    }

    public int getNumberOfUnapprovedCommentsAndAnswers(){
        int number = 0;
        for (Iterator it = pollReaderComments.iterator(); it.hasNext(); ) {
            PollReaderComment comment = (PollReaderComment)it.next();
            if (!comment.getIsapproved()){
                number = number + 1;
            }
        }
        for (Iterator it = pollReaderAnswers.iterator(); it.hasNext(); ) {
            PollReaderAnswer answer = (PollReaderAnswer)it.next();
            if(!answer.getIsapproved()){
                number = number + 1;
            }
        }
        return number;
    }

    public PollAnswer getAnswerByPollAnswerid(int pollanswerid){
        for (Iterator it = pollAnswers.iterator(); it.hasNext(); ) {
            PollAnswer answer = (PollAnswer)it.next();
            if(answer.getPollanswerid()==pollanswerid){
                return answer;
            }
        }
        return null;
    }

    public PollReaderAnswer getReaderAnswerByPollAnswerid(int pollreaderanswerid){
        for (Iterator it = pollReaderAnswers.iterator(); it.hasNext(); ) {
            PollReaderAnswer answer = (PollReaderAnswer)it.next();
            if(answer.getPollreaderanswerid()==pollreaderanswerid){
                return answer;
            }
        }
        return null;
    }

    public ArrayList<PollAnswer> getPollAnswers() {
        return pollAnswers;
    }

    public void setPollAnswers(ArrayList<PollAnswer> pollAnswers) {
        this.pollAnswers = pollAnswers;
    }

    public ArrayList<PollReaderAnswer> getPollReaderAnswers() {
        return pollReaderAnswers;
    }

    public void setPollReaderAnswers(ArrayList<PollReaderAnswer> pollReaderAnswers) {
        this.pollReaderAnswers = pollReaderAnswers;
    }

    public ArrayList<PollReaderComment> getPollReaderComments() {
        return pollReaderComments;
    }

    public void setPollReaderComments(ArrayList<PollReaderComment> pollReaderComments) {
        this.pollReaderComments = pollReaderComments;
    }


}
