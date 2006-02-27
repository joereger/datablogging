package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'traffic' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTrafficDAO.java
 * Finders for this DAO: reger.dao.finders.TrafficFinder.java
 * 
 */

public class TrafficDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "trafficDAO";

    protected int trafficid = 0;
    protected int count = 0;
    protected int traffictypeid = 0;
    protected java.util.Calendar datetime = java.util.Calendar.getInstance();
    protected String url = "";
    protected int plid = 0;
    protected int accountid = 0;
    protected int logid = 0;
    protected int eventid = 0;
    protected int imageid = 0;
    protected String referrer = "";
    protected String browser = "";
    protected String remotehost = "";
    protected boolean iscollapsed = true;

    public TrafficDAO (int trafficid){
        this.trafficid = trafficid;
        load();
    }

    public TrafficDAO(){


    }

    public void load(){
        if (trafficid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(trafficid), CACHEGROUP);
            if (obj!=null && (obj instanceof TrafficDAO)){
                setProperties((TrafficDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT trafficid, count, traffictypeid, datetime, url, plid, accountid, logid, eventid, imageid, referrer, browser, remotehost, iscollapsed  FROM traffic WHERE trafficid='"+trafficid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        trafficid = Integer.parseInt(rstData[0][0]);
                    } else {
                        trafficid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        count = Integer.parseInt(rstData[0][1]);
                    } else {
                        count = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        traffictypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        traffictypeid = 0;
                    }

                    datetime = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);

                    url = rstData[0][4];

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        plid = Integer.parseInt(rstData[0][5]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        accountid = Integer.parseInt(rstData[0][6]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        logid = Integer.parseInt(rstData[0][7]);
                    } else {
                        logid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        eventid = Integer.parseInt(rstData[0][8]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        imageid = Integer.parseInt(rstData[0][9]);
                    } else {
                        imageid = 0;
                    }

                    referrer = rstData[0][10];

                    browser = rstData[0][11];

                    remotehost = rstData[0][12];

                    iscollapsed = reger.core.Util.booleanFromSQLText(rstData[0][13]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(trafficid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT trafficid FROM traffic WHERE trafficid='"+trafficid+"' AND trafficid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE traffic SET trafficid='"+trafficid+"', count='"+count+"', traffictypeid='"+traffictypeid+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', url='"+reger.core.Util.cleanForSQL(url)+"', plid='"+plid+"', accountid='"+accountid+"', logid='"+logid+"', eventid='"+eventid+"', imageid='"+imageid+"', referrer='"+reger.core.Util.cleanForSQL(referrer)+"', browser='"+reger.core.Util.cleanForSQL(browser)+"', remotehost='"+reger.core.Util.cleanForSQL(remotehost)+"', iscollapsed='"+reger.core.Util.booleanAsSQLText(iscollapsed)+"'  WHERE trafficid='"+trafficid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(trafficid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            trafficid = Db.RunSQLInsert("INSERT INTO traffic(count, traffictypeid, datetime, url, plid, accountid, logid, eventid, imageid, referrer, browser, remotehost, iscollapsed ) VALUES('"+trafficid+"', '"+count+"', '"+traffictypeid+"', '"+reger.core.TimeUtils.dateformatfordb(datetime)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+plid+"', '"+accountid+"', '"+logid+"', '"+eventid+"', '"+imageid+"', '"+reger.core.Util.cleanForSQL(referrer)+"', '"+reger.core.Util.cleanForSQL(browser)+"', '"+reger.core.Util.cleanForSQL(remotehost)+"', '"+reger.core.Util.booleanAsSQLText(iscollapsed)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(trafficid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM traffic WHERE trafficid='"+trafficid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(trafficid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTrafficDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "trafficDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return trafficid;
    }

    public String getPrimaryKeyName(){
        return "trafficid";
    }

    public String getTableName(){
        return "traffic";
    }

    public void setProperties(TrafficDAO obj){
        if(obj!=null){
            this.trafficid = obj.trafficid;
            this.count = obj.count;
            this.traffictypeid = obj.traffictypeid;
            this.datetime = obj.datetime;
            this.url = obj.url;
            this.plid = obj.plid;
            this.accountid = obj.accountid;
            this.logid = obj.logid;
            this.eventid = obj.eventid;
            this.imageid = obj.imageid;
            this.referrer = obj.referrer;
            this.browser = obj.browser;
            this.remotehost = obj.remotehost;
            this.iscollapsed = obj.iscollapsed;
        }
    }


    public int getTrafficid() {
        return trafficid;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public int getTraffictypeid() {
        return traffictypeid;
    }


    public void setTraffictypeid(int traffictypeid) {
        this.traffictypeid = traffictypeid;
    }


    public java.util.Calendar getDatetime() {
        return datetime;
    }


    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
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


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public int getImageid() {
        return imageid;
    }


    public void setImageid(int imageid) {
        this.imageid = imageid;
    }


    public String getReferrer() {
        return referrer;
    }


    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }


    public String getBrowser() {
        return browser;
    }


    public void setBrowser(String browser) {
        this.browser = browser;
    }


    public String getRemotehost() {
        return remotehost;
    }


    public void setRemotehost(String remotehost) {
        this.remotehost = remotehost;
    }


    public boolean getIscollapsed() {
        return iscollapsed;
    }


    public void setIscollapsed(boolean iscollapsed) {
        this.iscollapsed = iscollapsed;
    }


}