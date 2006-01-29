package reger.poll;

import reger.core.db.Db;

/**
 * Poll DAO
 */
public class PollAnswer {

    private int pollanswerid = 0;
    private int pollid = 0;
    private String answer = "";
    private int votes = 0;


    public PollAnswer (int pollanswerid){
        this.pollanswerid = pollanswerid;
        load();
    }

    public PollAnswer(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid, pollid, answer, votes FROM pollanswer WHERE pollanswerid='"+pollanswerid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            pollanswerid = Integer.parseInt(rstData[0][0]);
            pollid = Integer.parseInt(rstData[0][1]);
            answer = rstData[0][2];
            votes = Integer.parseInt(rstData[0][3]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollanswerid FROM pollanswer WHERE pollanswerid='"+pollanswerid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE pollanswer SET pollid='"+pollid +"', answer='"+reger.core.Util.cleanForSQL(answer) +"', votes='"+votes+"' WHERE pollanswerid='"+pollanswerid +"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            pollanswerid = Db.RunSQLInsert("INSERT INTO pollanswer(pollid, answer, votes) VALUES('"+pollid +"', '"+reger.core.Util.cleanForSQL(answer) +"', '"+votes+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollanswer WHERE pollanswerid='"+pollanswerid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getPollanswerid() {
        return pollanswerid;
    }

    public int getPollid() {
        return pollid;
    }

    public void setPollid(int pollid) {
        this.pollid = pollid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


}
