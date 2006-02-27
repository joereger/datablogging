package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'event' database table
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 * Validator for this DAO: reger.dao.validators.ValidatorEventDAO.java
 * Finders for this DAO: reger.dao.finders.EventFinder.java
 * 
 */

public class EventDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "eventDAO";

    protected int eventid = 0;
    protected int eventtypeid = 0;
    protected int locationid = 0;
    protected java.util.Calendar createdate = java.util.Calendar.getInstance();
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected String title = "";
    protected String comments = "";
    protected int accountid = 0;
    protected int logid = 0;
    protected int accountuserid = 0;
    protected boolean isdraft = true;
    protected boolean isapproved = true;
    protected boolean favorite = true;
    protected int sizeinbytes = 0;
    protected boolean istemporary = true;
    protected boolean ismoderatorapproved = true;
    protected java.util.Calendar lastmodifiedbyuserdate = java.util.Calendar.getInstance();
    protected boolean isflaggedformoderator = true;
    protected boolean requiresmoderatorapproval = true;
    protected String entrykey = "";

    public EventDAO (int eventid){
        this.eventid = eventid;
        load();
    }

    public EventDAO(){


    }

    public void load(){
        if (eventid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventid), CACHEGROUP);
            if (obj!=null && (obj instanceof EventDAO)){
                setProperties((EventDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventid, eventtypeid, locationid, createdate, date, title, comments, accountid, logid, accountuserid, isdraft, isapproved, favorite, sizeinbytes, istemporary, ismoderatorapproved, lastmodifiedbyuserdate, isflaggedformoderator, requiresmoderatorapproval, entrykey  FROM event WHERE eventid='"+eventid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventtypeid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventtypeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        locationid = Integer.parseInt(rstData[0][2]);
                    } else {
                        locationid = 0;
                    }

                    createdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][4]);

                    title = rstData[0][5];

                    comments = rstData[0][6];

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        accountid = Integer.parseInt(rstData[0][7]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        logid = Integer.parseInt(rstData[0][8]);
                    } else {
                        logid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        accountuserid = Integer.parseInt(rstData[0][9]);
                    } else {
                        accountuserid = 0;
                    }

                    isdraft = reger.core.Util.booleanFromSQLText(rstData[0][10]);

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][11]);

                    favorite = reger.core.Util.booleanFromSQLText(rstData[0][12]);

                    if (reger.core.Util.isinteger(rstData[0][13])){
                        sizeinbytes = Integer.parseInt(rstData[0][13]);
                    } else {
                        sizeinbytes = 0;
                    }

                    istemporary = reger.core.Util.booleanFromSQLText(rstData[0][14]);

                    ismoderatorapproved = reger.core.Util.booleanFromSQLText(rstData[0][15]);

                    lastmodifiedbyuserdate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][16]);

                    isflaggedformoderator = reger.core.Util.booleanFromSQLText(rstData[0][17]);

                    requiresmoderatorapproval = reger.core.Util.booleanFromSQLText(rstData[0][18]);

                    entrykey = rstData[0][19];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventid), CACHEGROUP, this);
            }
        }
    }

    public void save() throws reger.core.ValidationException{
        try{
            validate();
        } catch (reger.core.ValidationException vex){
            throw vex;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventid FROM event WHERE eventid='"+eventid+"' AND eventid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE event SET eventid='"+eventid+"', eventtypeid='"+eventtypeid+"', locationid='"+locationid+"', createdate='"+reger.core.TimeUtils.dateformatfordb(createdate)+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', title='"+reger.core.Util.cleanForSQL(title)+"', comments='"+reger.core.Util.cleanForSQL(comments)+"', accountid='"+accountid+"', logid='"+logid+"', accountuserid='"+accountuserid+"', isdraft='"+reger.core.Util.booleanAsSQLText(isdraft)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', favorite='"+reger.core.Util.booleanAsSQLText(favorite)+"', sizeinbytes='"+sizeinbytes+"', istemporary='"+reger.core.Util.booleanAsSQLText(istemporary)+"', ismoderatorapproved='"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', lastmodifiedbyuserdate='"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', isflaggedformoderator='"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', requiresmoderatorapproval='"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"', entrykey='"+reger.core.Util.cleanForSQL(entrykey)+"'  WHERE eventid='"+eventid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventid = Db.RunSQLInsert("INSERT INTO event(eventtypeid, locationid, createdate, date, title, comments, accountid, logid, accountuserid, isdraft, isapproved, favorite, sizeinbytes, istemporary, ismoderatorapproved, lastmodifiedbyuserdate, isflaggedformoderator, requiresmoderatorapproval, entrykey ) VALUES('"+eventid+"', '"+eventtypeid+"', '"+locationid+"', '"+reger.core.TimeUtils.dateformatfordb(createdate)+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+reger.core.Util.cleanForSQL(title)+"', '"+reger.core.Util.cleanForSQL(comments)+"', '"+accountid+"', '"+logid+"', '"+accountuserid+"', '"+reger.core.Util.booleanAsSQLText(isdraft)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"', '"+reger.core.Util.booleanAsSQLText(favorite)+"', '"+sizeinbytes+"', '"+reger.core.Util.booleanAsSQLText(istemporary)+"', '"+reger.core.Util.booleanAsSQLText(ismoderatorapproved)+"', '"+reger.core.TimeUtils.dateformatfordb(lastmodifiedbyuserdate)+"', '"+reger.core.Util.booleanAsSQLText(isflaggedformoderator)+"', '"+reger.core.Util.booleanAsSQLText(requiresmoderatorapproval)+"', '"+reger.core.Util.cleanForSQL(entrykey)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM event WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEventDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "eventDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventid;
    }

    public String getPrimaryKeyName(){
        return "eventid";
    }

    public String getTableName(){
        return "event";
    }

    public void setProperties(EventDAO obj){
        if(obj!=null){
            this.eventid = obj.eventid;
            this.eventtypeid = obj.eventtypeid;
            this.locationid = obj.locationid;
            this.createdate = obj.createdate;
            this.date = obj.date;
            this.title = obj.title;
            this.comments = obj.comments;
            this.accountid = obj.accountid;
            this.logid = obj.logid;
            this.accountuserid = obj.accountuserid;
            this.isdraft = obj.isdraft;
            this.isapproved = obj.isapproved;
            this.favorite = obj.favorite;
            this.sizeinbytes = obj.sizeinbytes;
            this.istemporary = obj.istemporary;
            this.ismoderatorapproved = obj.ismoderatorapproved;
            this.lastmodifiedbyuserdate = obj.lastmodifiedbyuserdate;
            this.isflaggedformoderator = obj.isflaggedformoderator;
            this.requiresmoderatorapproval = obj.requiresmoderatorapproval;
            this.entrykey = obj.entrykey;
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


    public int getLocationid() {
        return locationid;
    }


    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }


    public java.util.Calendar getCreatedate() {
        return createdate;
    }


    public void setCreatedate(java.util.Calendar createdate) {
        this.createdate = createdate;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
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


    public boolean getFavorite() {
        return favorite;
    }


    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }


    public int getSizeinbytes() {
        return sizeinbytes;
    }


    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
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


    public java.util.Calendar getLastmodifiedbyuserdate() {
        return lastmodifiedbyuserdate;
    }


    public void setLastmodifiedbyuserdate(java.util.Calendar lastmodifiedbyuserdate) {
        this.lastmodifiedbyuserdate = lastmodifiedbyuserdate;
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


    public String getEntrykey() {
        return entrykey;
    }


    public void setEntrykey(String entrykey) {
        this.entrykey = entrykey;
    }


}