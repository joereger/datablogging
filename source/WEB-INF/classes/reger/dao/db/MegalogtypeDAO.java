package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megalogtype' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegalogtypeDAO.java
 * Finders for this DAO: reger.dao.finders.MegalogtypeFinder.java
 * 
 */

public class MegalogtypeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megalogtypeDAO";

    protected int eventtypeid = 0;
    protected String megalogname = "";
    protected String description = "";
    protected String longdescription = "";
    protected boolean showlocation = true;
    protected String icon = "";
    protected boolean showonhomepage = true;
    protected boolean issystemlogtype = true;
    protected boolean isprivate = true;
    protected int accountuserid = 0;
    protected String hiddenfields = "";
    protected String fieldorder = "";

    public MegalogtypeDAO (int eventtypeid){
        this.eventtypeid = eventtypeid;
        load();
    }

    public MegalogtypeDAO(){


    }

    public void load(){
        if (eventtypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventtypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegalogtypeDAO)){
                setProperties((MegalogtypeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT eventtypeid, megalogname, description, longdescription, showlocation, icon, showonhomepage, issystemlogtype, isprivate, accountuserid, hiddenfields, fieldorder  FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        eventtypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        eventtypeid = 0;
                    }

                    megalogname = rstData[0][1];

                    description = rstData[0][2];

                    longdescription = rstData[0][3];

                    showlocation = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    icon = rstData[0][5];

                    showonhomepage = reger.core.Util.booleanFromSQLText(rstData[0][6]);

                    issystemlogtype = reger.core.Util.booleanFromSQLText(rstData[0][7]);

                    isprivate = reger.core.Util.booleanFromSQLText(rstData[0][8]);

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        accountuserid = Integer.parseInt(rstData[0][9]);
                    } else {
                        accountuserid = 0;
                    }

                    hiddenfields = rstData[0][10];

                    fieldorder = rstData[0][11];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(eventtypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT eventtypeid FROM megalogtype WHERE eventtypeid='"+eventtypeid+"' AND eventtypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megalogtype SET eventtypeid='"+eventtypeid+"', megalogname='"+reger.core.Util.cleanForSQL(megalogname)+"', description='"+reger.core.Util.cleanForSQL(description)+"', longdescription='"+reger.core.Util.cleanForSQL(longdescription)+"', showlocation='"+reger.core.Util.booleanAsSQLText(showlocation)+"', icon='"+reger.core.Util.cleanForSQL(icon)+"', showonhomepage='"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', issystemlogtype='"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', accountuserid='"+accountuserid+"', hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfields)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"'  WHERE eventtypeid='"+eventtypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(eventtypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            eventtypeid = Db.RunSQLInsert("INSERT INTO megalogtype(megalogname, description, longdescription, showlocation, icon, showonhomepage, issystemlogtype, isprivate, accountuserid, hiddenfields, fieldorder ) VALUES('"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(megalogname)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+reger.core.Util.cleanForSQL(longdescription)+"', '"+reger.core.Util.booleanAsSQLText(showlocation)+"', '"+reger.core.Util.cleanForSQL(icon)+"', '"+reger.core.Util.booleanAsSQLText(showonhomepage)+"', '"+reger.core.Util.booleanAsSQLText(issystemlogtype)+"', '"+reger.core.Util.booleanAsSQLText(isprivate)+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(hiddenfields)+"', '"+reger.core.Util.cleanForSQL(fieldorder)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(eventtypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(eventtypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegalogtypeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megalogtypeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return eventtypeid;
    }

    public String getPrimaryKeyName(){
        return "eventtypeid";
    }

    public String getTableName(){
        return "megalogtype";
    }

    public void setProperties(MegalogtypeDAO obj){
        if(obj!=null){
            this.eventtypeid = obj.eventtypeid;
            this.megalogname = obj.megalogname;
            this.description = obj.description;
            this.longdescription = obj.longdescription;
            this.showlocation = obj.showlocation;
            this.icon = obj.icon;
            this.showonhomepage = obj.showonhomepage;
            this.issystemlogtype = obj.issystemlogtype;
            this.isprivate = obj.isprivate;
            this.accountuserid = obj.accountuserid;
            this.hiddenfields = obj.hiddenfields;
            this.fieldorder = obj.fieldorder;
        }
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public String getMegalogname() {
        return megalogname;
    }


    public void setMegalogname(String megalogname) {
        this.megalogname = megalogname;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getLongdescription() {
        return longdescription;
    }


    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }


    public boolean getShowlocation() {
        return showlocation;
    }


    public void setShowlocation(boolean showlocation) {
        this.showlocation = showlocation;
    }


    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }


    public boolean getShowonhomepage() {
        return showonhomepage;
    }


    public void setShowonhomepage(boolean showonhomepage) {
        this.showonhomepage = showonhomepage;
    }


    public boolean getIssystemlogtype() {
        return issystemlogtype;
    }


    public void setIssystemlogtype(boolean issystemlogtype) {
        this.issystemlogtype = issystemlogtype;
    }


    public boolean getIsprivate() {
        return isprivate;
    }


    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getHiddenfields() {
        return hiddenfields;
    }


    public void setHiddenfields(String hiddenfields) {
        this.hiddenfields = hiddenfields;
    }


    public String getFieldorder() {
        return fieldorder;
    }


    public void setFieldorder(String fieldorder) {
        this.fieldorder = fieldorder;
    }


}