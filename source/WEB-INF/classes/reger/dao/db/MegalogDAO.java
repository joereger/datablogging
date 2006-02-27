package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megalog' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegalogDAO.java
 * Finders for this DAO: reger.dao.finders.MegalogFinder.java
 * 
 */

public class MegalogDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megalogDAO";

    protected int logid = 0;
    protected int accountid = 0;
    protected int eventtypeid = 0;
    protected String name = "";
    protected int logaccess = 0;
    protected String password = "";
    protected String message = "";
    protected boolean showonhomepage = true;
    protected int maintemplateid = 0;
    protected int entlisttemplateid = 0;
    protected int nestednavparenttype = 0;
    protected int nestednavparentid = 0;
    protected int nestednavorder = 0;
    protected String fieldorder = "";
    protected String hiddenfields = "";

    public MegalogDAO (int logid){
        this.logid = logid;
        load();
    }

    public MegalogDAO(){


    }

    public void load(){
        if (logid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(logid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegalogDAO)){
                setProperties((MegalogDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT logid, accountid, eventtypeid, name, logaccess, password, message, showonhomepage, maintemplateid, entlisttemplateid, nestednavparenttype, nestednavparentid, nestednavorder, fieldorder, hiddenfields  FROM megalog WHERE logid='"+logid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        logid = Integer.parseInt(rstData[0][0]);
                    } else {
                        logid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventtypeid = 0;
                    }

                    name = rstData[0][3];

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        logaccess = Integer.parseInt(rstData[0][4]);
                    } else {
                        logaccess = 0;
                    }

                    password = rstData[0][5];

                    message = rstData[0][6];

                    showonhomepage = reger.core.Util.booleanFromSQLText(rstData[0][7]);

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        maintemplateid = Integer.parseInt(rstData[0][8]);
                    } else {
                        maintemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        entlisttemplateid = Integer.parseInt(rstData[0][9]);
                    } else {
                        entlisttemplateid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][10])){
                        nestednavparenttype = Integer.parseInt(rstData[0][10]);
                    } else {
                        nestednavparenttype = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][11])){
                        nestednavparentid = Integer.parseInt(rstData[0][11]);
                    } else {
                        nestednavparentid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][12])){
                        nestednavorder = Integer.parseInt(rstData[0][12]);
                    } else {
                        nestednavorder = 0;
                    }

                    fieldorder = rstData[0][13];

                    hiddenfields = rstData[0][14];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(logid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"' AND logid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megalog SET logid='"+logid+"', accountid='"+accountid+"', eventtypeid='"+eventtypeid+"', name='"+reger.core.Util.cleanForSQL(name)+"', logaccess='"+logaccess+"', password='"+reger.core.Util.cleanForSQL(password)+"', message='"+reger.core.Util.cleanForSQL(message)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', maintemplateid='"+maintemplateid+"', entlisttemplateid='"+entlisttemplateid+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"'  WHERE logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(logid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            logid = Db.RunSQLInsert("INSERT INTO megalog(accountid, eventtypeid, name, logaccess, password, message, showonhomepage, maintemplateid, entlisttemplateid, nestednavparenttype, nestednavparentid, nestednavorder, fieldorder, hiddenfields ) VALUES('"+logid+"', '"+accountid+"', '"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+logaccess+"', '"+reger.core.Util.cleanForSQL(password)+"', '"+reger.core.Util.cleanForSQL(message)+"', '"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', '"+maintemplateid+"', '"+entlisttemplateid+"', '"+nestednavparenttype+"', '"+nestednavparentid+"', '"+nestednavorder+"', '"+reger.core.Util.cleanForSQL(fieldorder)+"', '"+reger.core.Util.cleanForSQL(hiddenfields)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(logid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megalog WHERE logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(logid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegalogDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megalogDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return logid;
    }

    public String getPrimaryKeyName(){
        return "logid";
    }

    public String getTableName(){
        return "megalog";
    }

    public void setProperties(MegalogDAO obj){
        if(obj!=null){
            this.logid = obj.logid;
            this.accountid = obj.accountid;
            this.eventtypeid = obj.eventtypeid;
            this.name = obj.name;
            this.logaccess = obj.logaccess;
            this.password = obj.password;
            this.message = obj.message;
            this.showonhomepage = obj.showonhomepage;
            this.maintemplateid = obj.maintemplateid;
            this.entlisttemplateid = obj.entlisttemplateid;
            this.nestednavparenttype = obj.nestednavparenttype;
            this.nestednavparentid = obj.nestednavparentid;
            this.nestednavorder = obj.nestednavorder;
            this.fieldorder = obj.fieldorder;
            this.hiddenfields = obj.hiddenfields;
        }
    }


    public int getLogid() {
        return logid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getLogaccess() {
        return logaccess;
    }


    public void setLogaccess(int logaccess) {
        this.logaccess = logaccess;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public boolean getShowonhomepage() {
        return showonhomepage;
    }


    public void setShowonhomepage(boolean showonhomepage) {
        this.showonhomepage = showonhomepage;
    }


    public int getMaintemplateid() {
        return maintemplateid;
    }


    public void setMaintemplateid(int maintemplateid) {
        this.maintemplateid = maintemplateid;
    }


    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }


    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }


    public int getNestednavparenttype() {
        return nestednavparenttype;
    }


    public void setNestednavparenttype(int nestednavparenttype) {
        this.nestednavparenttype = nestednavparenttype;
    }


    public int getNestednavparentid() {
        return nestednavparentid;
    }


    public void setNestednavparentid(int nestednavparentid) {
        this.nestednavparentid = nestednavparentid;
    }


    public int getNestednavorder() {
        return nestednavorder;
    }


    public void setNestednavorder(int nestednavorder) {
        this.nestednavorder = nestednavorder;
    }


    public String getFieldorder() {
        return fieldorder;
    }


    public void setFieldorder(String fieldorder) {
        this.fieldorder = fieldorder;
    }


    public String getHiddenfields() {
        return hiddenfields;
    }


    public void setHiddenfields(String hiddenfields) {
        this.hiddenfields = hiddenfields;
    }


}