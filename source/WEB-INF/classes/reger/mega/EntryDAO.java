package reger.mega;

import reger.core.db.Db;
import reger.core.ValidationException;

import java.util.Calendar;

/**
 * Entry DAO
 */
public class EntryDAO {

    protected int eventid = 0;
    protected int eventtypeid = 0;
    protected int accountid = 0;
    protected int logid = 0;
    protected int accountuserid = 0;
    protected Calendar createdate;
    protected Calendar date;
    protected Calendar lastmodifiedbyuserdate;
    protected String title = "";
    protected String body = "";
    protected String entrykey = "";
    protected int sizeinbytes = 0;
    protected boolean isdraft = false;
    protected boolean isapproved = true;
    protected boolean favorite = false;
    protected boolean istemporary = false;
    protected boolean ismoderatorapproved = true;
    protected boolean isflaggedformoderator = false;
    protected boolean requiresmoderatorapproval = false;
    protected int locationid = 0;


    public EntryDAO (int eventid){
        this.eventid = eventid;
        load();
    }

    public EntryDAO(){


    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid, eventtypeid, accountid, logid, accountuserid, createdate, date, lastmodifiedbyuserdate, title, comments, entrykey, sizeinbytes, isdraft, isapproved, favorite, istemporary, ismoderatorapproved, isflaggedformoderator, requiresmoderatorapproval, locationid FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            if (reger.core.Util.isinteger(rstData[0][0])){
                eventid=Integer.parseInt(rstData[0][0]);
            }
            if (reger.core.Util.isinteger(rstData[0][1])){
                eventtypeid=Integer.parseInt(rstData[0][1]);
            }
            if (reger.core.Util.isinteger(rstData[0][2])){
                accountid=Integer.parseInt(rstData[0][2]);
            }
            if (reger.core.Util.isinteger(rstData[0][3])){
                logid=Integer.parseInt(rstData[0][3]);
            }
            if (reger.core.Util.isinteger(rstData[0][4])){
                accountuserid=Integer.parseInt(rstData[0][4]);
            }
            createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][5]);
            date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][6]);
            lastmodifiedbyuserdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][7]);
            title = rstData[0][8];
            body = rstData[0][9];
            entrykey = rstData[0][10];
            isdraft = reger.core.Util.booleanFromSQLText(rstData[0][11]);
            isapproved = reger.core.Util.booleanFromSQLText(rstData[0][12]);
            favorite = reger.core.Util.booleanFromSQLText(rstData[0][13]);
            istemporary = reger.core.Util.booleanFromSQLText(rstData[0][14]);
            ismoderatorapproved = reger.core.Util.booleanFromSQLText(rstData[0][15]);
            isflaggedformoderator = reger.core.Util.booleanFromSQLText(rstData[0][16]);
            requiresmoderatorapproval = reger.core.Util.booleanFromSQLText(rstData[0][17]);
            if (reger.core.Util.isinteger(rstData[0][18])){
                locationid=Integer.parseInt(rstData[0][18]);
            }
        }
    }

    public void save() throws ValidationException {
        try{
            validate();
        } catch (ValidationException vex){
            throw vex;
        }

        lastmodifiedbyuserdate = reger.core.TimeUtils.nowInGmtCalendar();  

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"' AND eventid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE event SET eventid='"+eventid+"', eventtypeid='"+eventtypeid+"', accountid='"+accountid+"', logid='"+logid+"', accountuserid='"+accountuserid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', title='"+reger.core.Util.cleanForSQL(title)+"', comments='"+reger.core.Util.cleanForSQL(body)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"', sizeinbytes='"+sizeinbytes+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"', locationid='"+locationid+"' WHERE eventidid='"+eventid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            eventid = Db.RunSQLInsert("INSERT INTO event(eventid, eventtypeid, accountid, logid, accountuserid, createdate, date, lastmodifiedbyuserdate, title, comments, entrykey, sizeinbytes, isdraft, isapproved, favorite, istemporary, ismoderatorapproved, isflaggedformoderator, requiresmoderatorapproval, locationid) VALUES('"+eventid+"', '"+eventtypeid+"', '"+accountid+"', '"+logid+"', '"+accountuserid+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', '"+reger.core.Util.cleanForSQL(title)+"', '"+reger.core.Util.cleanForSQL(body)+"', '"+reger.core.Util.cleanForSQL(entrykey)+"', '"+sizeinbytes+"', '"+reger.core.Util.booleanAsSQLText(isdraft)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"', '"+reger.core.Util.booleanAsSQLText(favorite)+"', '"+reger.core.Util.booleanAsSQLText(istemporary)+"', '"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', '"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', '"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"', '"+locationid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM event WHERE eventid='"+eventid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    protected void validate() throws ValidationException {
        ValidationException vex = new ValidationException();
        if (title.equals("")){
            vex.addValidationError("Title cannot be blank.");
        }
    }

    public int getEventid() {
        return eventid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public Calendar getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Calendar createdate) {
        this.createdate = createdate;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getLastmodifiedbyuserdate() {
        return lastmodifiedbyuserdate;
    }

    public void setLastmodifiedbyuserdate(Calendar lastmodifiedbyuserdate) {
        this.lastmodifiedbyuserdate = lastmodifiedbyuserdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEntrykey() {
        return entrykey;
    }

    public void setEntrykey(String entrykey) {
        this.entrykey = entrykey;
    }

    public int getSizeinbytes() {
        return sizeinbytes;
    }

    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }

    public boolean getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(boolean isdraft) {
        this.isdraft = isdraft;
    }

    public boolean getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }

    public boolean getIsFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean getIstemporary() {
        return istemporary;
    }

    public void setIstemporary(boolean istemporary) {
        this.istemporary = istemporary;
    }

    public boolean getIsmoderatorapproved() {
        return ismoderatorapproved;
    }

    public void setIsmoderatorapproved(boolean ismoderatorapproved) {
        this.ismoderatorapproved = ismoderatorapproved;
    }

    public boolean getIsflaggedformoderator() {
        return isflaggedformoderator;
    }

    public void setIsflaggedformoderator(boolean isflaggedformoderator) {
        this.isflaggedformoderator = isflaggedformoderator;
    }

    public boolean getRequiresmoderatorapproval() {
        return requiresmoderatorapproval;
    }

    public void setRequiresmoderatorapproval(boolean requiresmoderatorapproval) {
        this.requiresmoderatorapproval = requiresmoderatorapproval;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }
}
