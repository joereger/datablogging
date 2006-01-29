package reger.poll;

import reger.core.db.Db;

/**
 * Poll DAO
 */
public class PollReaderComment {

    private int pollreadercommentid = 0;
    private int pollid = 0;
    private String comment = "";
    private String readername = "";
    private boolean isapproved = true;


    public PollReaderComment (int pollreadercommentid){
        this.pollreadercommentid = pollreadercommentid;
        load();
    }

    public PollReaderComment(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid, pollid, comment, readername, isapproved FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            pollreadercommentid = Integer.parseInt(rstData[0][0]);
            pollid = Integer.parseInt(rstData[0][1]);
            comment = rstData[0][2];
            readername = rstData[0][3];
            isapproved = reger.core.Util.booleanFromSQLText(rstData[0][4]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollreadercommentid FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE pollreadercomment SET pollid='"+pollid +"', comment='"+reger.core.Util.cleanForSQL(comment) +"', readername='"+reger.core.Util.cleanForSQL(readername) +"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"' WHERE pollreadercommentid='"+pollreadercommentid +"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            pollreadercommentid = Db.RunSQLInsert("INSERT INTO pollreadercomment(pollid, comment, readername, isapproved) VALUES('"+pollid +"', '"+reger.core.Util.cleanForSQL(comment) +"', '"+reger.core.Util.cleanForSQL(readername) +"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pollreadercomment WHERE pollreadercommentid='"+pollreadercommentid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getPollreadercommentid() {
        return pollreadercommentid;
    }

    public int getPollid() {
        return pollid;
    }

    public void setPollid(int pollid) {
        this.pollid = pollid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }
}
