package reger.poll;

import reger.core.db.Db;

/**
 * Poll DAO
 */
public class PollReaderAnswer {

    private int pollreaderanswerid = 0;
    private int pollid = 0;
    private String answer = "";
    private String readername = "";
    private int votes = 0;
    private boolean isapproved = true;


    public PollReaderAnswer (int pollreaderanswerid){
        this.pollreaderanswerid = pollreaderanswerid;
        load();
    }

    public PollReaderAnswer(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid, pollid, answer, readername, votes, isapproved FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            pollreaderanswerid = Integer.parseInt(rstData[0][0]);
            pollid = Integer.parseInt(rstData[0][1]);
            answer = rstData[0][2];
            readername = rstData[0][3];
            votes = Integer.parseInt(rstData[0][4]);
            isapproved = reger.core.Util.booleanFromSQLText(rstData[0][5]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreaderanswerid FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE pollreaderanswer SET pollid='"+pollid +"', answer='"+reger.core.Util.cleanForSQL(answer) +"', readername='"+reger.core.Util.cleanForSQL(readername) +"', votes='"+votes+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' WHERE pollreaderanswerid='"+pollreaderanswerid +"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            pollreaderanswerid = Db.RunSQLInsert("INSERT INTO pollreaderanswer(pollid, answer, readername, votes, isapproved) VALUES('"+pollid +"', '"+reger.core.Util.cleanForSQL(answer) +"', '"+reger.core.Util.cleanForSQL(readername) +"', '"+votes+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollreaderanswer WHERE pollreaderanswerid='"+pollreaderanswerid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getPollreaderanswerid() {
        return pollreaderanswerid;
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

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }

}
