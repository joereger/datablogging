package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'help' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorHelpDAO.java
 * Finders for this DAO: reger.dao.finders.HelpFinder.java
 * 
 */

public class HelpDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "helpDAO";

    protected int helpid = 0;
    protected String helpkey = "";
    protected int helpsection = 0;
    protected int eventtypeid = 0;
    protected String title = "";
    protected String body = "";

    public HelpDAO (int helpid){
        this.helpid = helpid;
        load();
    }

    public HelpDAO(){


    }

    public void load(){
        if (helpid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(helpid), CACHEGROUP);
            if (obj!=null && (obj instanceof HelpDAO)){
                setProperties((HelpDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT helpid, helpkey, helpsection, eventtypeid, title, body  FROM help WHERE helpid='"+helpid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        helpid = Integer.parseInt(rstData[0][0]);
                    } else {
                        helpid = 0;
                    }

                    helpkey = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        helpsection = Integer.parseInt(rstData[0][2]);
                    } else {
                        helpsection = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        eventtypeid = Integer.parseInt(rstData[0][3]);
                    } else {
                        eventtypeid = 0;
                    }

                    title = rstData[0][4];

                    body = rstData[0][5];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(helpid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT helpid FROM help WHERE helpid='"+helpid+"' AND helpid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE help SET helpid='"+helpid+"', helpkey='"+reger.core.Util.cleanForSQL(helpkey)+"', helpsection='"+helpsection+"', eventtypeid='"+eventtypeid+"', title='"+reger.core.Util.cleanForSQL(title)+"', body='"+reger.core.Util.cleanForSQL(body)+"'  WHERE helpid='"+helpid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(helpid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            helpid = Db.RunSQLInsert("INSERT INTO help(helpkey, helpsection, eventtypeid, title, body ) VALUES('"+helpid+"', '"+reger.core.Util.cleanForSQL(helpkey)+"', '"+helpsection+"', '"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(title)+"', '"+reger.core.Util.cleanForSQL(body)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(helpid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM help WHERE helpid='"+helpid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(helpid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorHelpDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "helpDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return helpid;
    }

    public String getPrimaryKeyName(){
        return "helpid";
    }

    public String getTableName(){
        return "help";
    }

    public void setProperties(HelpDAO obj){
        if(obj!=null){
            this.helpid = obj.helpid;
            this.helpkey = obj.helpkey;
            this.helpsection = obj.helpsection;
            this.eventtypeid = obj.eventtypeid;
            this.title = obj.title;
            this.body = obj.body;
        }
    }


    public int getHelpid() {
        return helpid;
    }


    public String getHelpkey() {
        return helpkey;
    }


    public void setHelpkey(String helpkey) {
        this.helpkey = helpkey;
    }


    public int getHelpsection() {
        return helpsection;
    }


    public void setHelpsection(int helpsection) {
        this.helpsection = helpsection;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
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


}