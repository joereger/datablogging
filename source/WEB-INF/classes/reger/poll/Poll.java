package reger.poll;

import reger.core.db.Db;

/**
 * Poll DAO
 */
public class Poll {

    private int pollid = 0;
    private int eventid = 0;
    private String question = "";
    private boolean readerscanaddownanswer = true;
    private boolean readerscanaddcomments = true;
    private boolean readerscanvoteonreaderanswers = true;
    private boolean readerinputismoderated = false;
    private boolean isopen = true;


    public Poll (int pollid){
        this.pollid = pollid;
        load();
    }

    public Poll(){


    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid, eventid, question, readerscanaddownanswer, readerscanaddcomments, readerscanvoteonreaderanswers, readerinputismoderated, isopen FROM poll WHERE pollid='"+pollid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            pollid = Integer.parseInt(rstData[0][0]);
            eventid = Integer.parseInt(rstData[0][1]);
            question = rstData[0][2];
            readerscanaddownanswer = reger.core.Util.booleanFromSQLText(rstData[0][3]);
            readerscanaddcomments = reger.core.Util.booleanFromSQLText(rstData[0][4]);
            readerscanvoteonreaderanswers = reger.core.Util.booleanFromSQLText(rstData[0][5]);
            readerinputismoderated = reger.core.Util.booleanFromSQLText(rstData[0][6]);
            isopen = reger.core.Util.booleanFromSQLText(rstData[0][7]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT pollid FROM poll WHERE pollid='"+pollid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE poll SET eventid='"+eventid+"', question='"+reger.core.Util.cleanForSQL(question) +"', readerscanaddownanswer='"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', readerscanaddcomments='"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', readerscanvoteonreaderanswers='"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', readerinputismoderated='"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"', isopen='"+reger.core.Util.booleanAsSQLText(isopen)+"' WHERE pollid='"+pollid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            pollid = Db.RunSQLInsert("INSERT INTO poll(eventid, question, readerscanaddownanswer, readerscanaddcomments, readerscanvoteonreaderanswers, readerinputismoderated, isopen) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(question) +"', '"+reger.core.Util.booleanAsSQLText(readerscanaddownanswer)+"', '"+reger.core.Util.booleanAsSQLText(readerscanaddcomments)+"', '"+reger.core.Util.booleanAsSQLText(readerscanvoteonreaderanswers)+"', '"+reger.core.Util.booleanAsSQLText(readerinputismoderated)+"', '"+reger.core.Util.booleanAsSQLText(isopen)+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM poll WHERE pollid='"+pollid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getPollid() {
        return pollid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean getReaderscanaddownanswer() {
        return readerscanaddownanswer;
    }

    public void setReaderscanaddownanswer(boolean readerscanaddownanswer) {
        this.readerscanaddownanswer = readerscanaddownanswer;
    }

    public boolean getReaderscanaddcomments() {
        return readerscanaddcomments;
    }

    public void setReaderscanaddcomments(boolean readerscanaddcomments) {
        this.readerscanaddcomments = readerscanaddcomments;
    }

    public boolean getReaderscanvoteonreaderanswers() {
        return readerscanvoteonreaderanswers;
    }

    public void setReaderscanvoteonreaderanswers(boolean readerscanvoteonreaderanswers) {
        this.readerscanvoteonreaderanswers = readerscanvoteonreaderanswers;
    }

    public boolean getReaderinputismoderated() {
        return readerinputismoderated;
    }

    public void setReaderinputismoderated(boolean readerinputismoderated) {
        this.readerinputismoderated = readerinputismoderated;
    }

    public boolean getIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }
}
