package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'templatenew' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTemplatenewDAO.java
 * Finders for this DAO: reger.dao.finders.TemplatenewFinder.java
 * 
 */

public class TemplatenewDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "templatenewDAO";

    protected int templateid = 0;
    protected String template = "";
    protected int type = 0;
    protected int accountid = 0;
    protected boolean issystemtemplate = true;
    protected String name = "";

    public TemplatenewDAO (int templateid){
        this.templateid = templateid;
        load();
    }

    public TemplatenewDAO(){


    }

    public void load(){
        if (templateid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(templateid), CACHEGROUP);
            if (obj!=null && (obj instanceof TemplatenewDAO)){
                setProperties((TemplatenewDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT templateid, template, type, accountid, issystemtemplate, name  FROM templatenew WHERE templateid='"+templateid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        templateid = Integer.parseInt(rstData[0][0]);
                    } else {
                        templateid = 0;
                    }

                    template = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        type = Integer.parseInt(rstData[0][2]);
                    } else {
                        type = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }

                    issystemtemplate = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    name = rstData[0][5];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(templateid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE templateid='"+templateid+"' AND templateid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE templatenew SET templateid='"+templateid+"', template='"+reger.core.Util.cleanForSQL(template)+"', type='"+type+"', accountid='"+accountid+"', issystemtemplate='"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"', name='"+reger.core.Util.cleanForSQL(name)+"'  WHERE templateid='"+templateid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(templateid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            templateid = Db.RunSQLInsert("INSERT INTO templatenew(template, type, accountid, issystemtemplate, name ) VALUES('"+templateid+"', '"+reger.core.Util.cleanForSQL(template)+"', '"+type+"', '"+accountid+"', '"+reger.core.Util.booleanAsSQLText(issystemtemplate)+"', '"+reger.core.Util.cleanForSQL(name)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(templateid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM templatenew WHERE templateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(templateid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTemplatenewDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "templatenewDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return templateid;
    }

    public String getPrimaryKeyName(){
        return "templateid";
    }

    public String getTableName(){
        return "templatenew";
    }

    public void setProperties(TemplatenewDAO obj){
        if(obj!=null){
            this.templateid = obj.templateid;
            this.template = obj.template;
            this.type = obj.type;
            this.accountid = obj.accountid;
            this.issystemtemplate = obj.issystemtemplate;
            this.name = obj.name;
        }
    }


    public int getTemplateid() {
        return templateid;
    }


    public String getTemplate() {
        return template;
    }


    public void setTemplate(String template) {
        this.template = template;
    }


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public boolean getIssystemtemplate() {
        return issystemtemplate;
    }


    public void setIssystemtemplate(boolean issystemtemplate) {
        this.issystemtemplate = issystemtemplate;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}