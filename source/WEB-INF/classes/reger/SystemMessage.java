package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * A system message appears to all users at once.  It is
 * memory-based and will dissappear the next time the server is restarted.
 */
public class SystemMessage {

    private int systemmessageid = 0;
    private String systemMessage;
    private boolean isLive = true;
    private boolean autoOldOnRestart = true;
    private boolean showToLoggedInUsers = true;
    private boolean showToNotLoggedInUsers = false;
    private Calendar date;


    public SystemMessage(int systemmessageid){
        this.systemmessageid = systemmessageid;
        load();
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL("SELECT systemmessage, islive, autooldonrestart, showtologgedinusers, showtonotloggedinusers, date FROM systemmessage WHERE systemmessageid='"+systemmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            this.systemMessage = rstMessage[0][0];
            this.isLive = reger.core.Util.booleanFromSQLText(rstMessage[0][1]);
            this.autoOldOnRestart = reger.core.Util.booleanFromSQLText(rstMessage[0][2]);
            this.showToLoggedInUsers = reger.core.Util.booleanFromSQLText(rstMessage[0][3]);
            this.showToNotLoggedInUsers = reger.core.Util.booleanFromSQLText(rstMessage[0][4]);
            this.date = reger.core.TimeUtils.dbstringtocalendar(rstMessage[0][5]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL("SELECT systemmessage FROM systemmessage WHERE systemmessageid='"+systemmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE systemmessage SET systemmessage='"+reger.core.Util.cleanForSQL(systemMessage)+"', islive='"+reger.core.Util.booleanAsSQLText(isLive)+"', autooldonrestart='"+reger.core.Util.booleanAsSQLText(autoOldOnRestart)+"', showtologgedinusers='"+reger.core.Util.booleanAsSQLText(showToLoggedInUsers)+"', showtonotloggedinusers='"+reger.core.Util.booleanAsSQLText(showToNotLoggedInUsers)+"' WHERE systemmessageid='"+systemmessageid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO systemmessage(systemmessage, islive, autooldonrestart, showtologgedinusers, showtonotloggedinusers, date) VALUES('"+reger.core.Util.cleanForSQL(systemMessage)+"', '"+reger.core.Util.booleanAsSQLText(isLive)+"', '"+reger.core.Util.booleanAsSQLText(autoOldOnRestart)+"', '"+reger.core.Util.booleanAsSQLText(showToLoggedInUsers)+"', '"+reger.core.Util.booleanAsSQLText(showToNotLoggedInUsers)+"', '"+reger.core.TimeUtils.nowInGmtString()+"')");
            //-----------------------------------
            //-----------------------------------
        }
        //Refresh the memory object
        reger.AllLiveSystemMessagesInSystem.refresh();
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM systemmessage WHERE systemmessageid='"+systemmessageid+"'");
        //-----------------------------------
        //-----------------------------------
        //Refresh the memory object
        reger.AllLiveSystemMessagesInSystem.refresh();
    }

    public int getSystemmessageid() {
        return systemmessageid;
    }

    public void setSystemmessageid(int systemmessageid) {
        this.systemmessageid = systemmessageid;
    }

    public String getSystemMessage() {
        if (systemMessage!=null){
            return systemMessage;
        } else {
            return "";
        }
    }

    public void setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        this.isLive = live;
    }

    public boolean isAutoOldOnRestart() {
        return autoOldOnRestart;
    }

    public void setAutoOldOnRestart(boolean autoOldOnRestart) {
        this.autoOldOnRestart = autoOldOnRestart;
    }

    public boolean isShowToLoggedInUsers() {
        return showToLoggedInUsers;
    }

    public void setShowToLoggedInUsers(boolean showToLoggedInUsers) {
        this.showToLoggedInUsers = showToLoggedInUsers;
    }

    public boolean isShowToNotLoggedInUsers() {
        return showToNotLoggedInUsers;
    }

    public void setShowToNotLoggedInUsers(boolean showToNotLoggedInUsers) {
        this.showToNotLoggedInUsers = showToNotLoggedInUsers;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


}
