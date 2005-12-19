package reger.template;

import reger.core.db.Db;
import reger.PrivateLabel;
import reger.core.db.Db;

/**
 * Represents a template.
 */
public class Template {

    private int templateid=0;
    private String template;
    private int type;
    private int accountid;
    private boolean issystemtemplate;
    private String name;

    public static final int TEMPLATETYPESITE = 1;
    public static final int TEMPLATETYPEENTRYLIST = 2;
    public static final int TEMPLATETYPEHOMEPAGE = 3;
    public static final int TEMPLATETYPEMARKETINGSITE = 4;
    public static final int TEMPLATETYPEMARKETINGHOMEPAGE = 5;
    public static final int TEMPLATETYPEPLUSER = 6;

    public Template(int templateid){
        load(templateid);
    }

    public Template(String template, int type, int accountid, boolean issystemtemplate, String name){
        populate(0, template, type, accountid, issystemtemplate, name);
    }

    public Template(int templateid, String template, int type, int accountid, boolean issystemtemplate, String name){
        populate(templateid, template, type, accountid, issystemtemplate, name);
    }

    public void populate(int templateid, String template, int type, int accountid, boolean issystemtemplate, String name){
        this.templateid = templateid;
        this.template = template;
        this.type = type;
        this.accountid = accountid;
        this.issystemtemplate = issystemtemplate;
        this.name = name;
    }
    

    public void load(int templateid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstTemplate= Db.RunSQL("SELECT templateid, template, type, accountid, issystemtemplate, name FROM templatenew WHERE templateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTemplate!=null && rstTemplate.length>0){
            this.templateid = Integer.parseInt(rstTemplate[0][0]);
            this.template = rstTemplate[0][1];
            this.type = Integer.parseInt(rstTemplate[0][2]);
            this.accountid = Integer.parseInt(rstTemplate[0][3]);
            if (rstTemplate[0][4].equals("1")){
                this.issystemtemplate = true;
            } else {
                this.issystemtemplate = false;
            }
            this.name = rstTemplate[0][5];
        }
    }

    public void save(){
        String issystemtemplateText = "0";
        if (issystemtemplate){
            issystemtemplateText = "1";
        }

        if (accountid>0){
            issystemtemplateText = "0";    
        }

        if (name==null || name.equals("")){
            name="New Template";
        }

        //See if the exact same template already exists
        boolean alreadyExists = false;
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT templateid FROM templatenew WHERE template='"+reger.core.Util.cleanForSQL(template)+"' AND name='"+reger.core.Util.cleanForSQL(name)+"' AND type='"+type+"' AND (accountid='"+accountid+"' OR accountid<='0') ORDER BY accountid DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //It exists
            this.templateid = Integer.parseInt(rstData[0][0]);
        } else {
            //It doesn't exist
            //Try to update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE templatenew SET template='"+reger.core.Util.cleanForSQL(template)+"', type='"+type+"', accountid='"+accountid+"', issystemtemplate='"+issystemtemplateText+"', name='"+reger.core.Util.cleanForSQL(name)+"' WHERE templateid='"+templateid+"' AND accountid='"+accountid+"'");
            //-----------------------------------
            //-----------------------------------
            reger.template.AllTemplatesInSystem.refresh(templateid);

            //If none was updated I need to create one.
            if (count<1){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO templatenew(template, type, accountid, issystemtemplate, name) VALUES('"+reger.core.Util.cleanForSQL(template)+"', '"+type+"', '"+accountid+"', '"+issystemtemplateText+"', '"+reger.core.Util.cleanForSQL(name)+"')");
                //-----------------------------------
                //-----------------------------------
                reger.template.AllTemplatesInSystem.refresh(identity);
            }
        }



    }

    public int countUsesOfTemplate(){

        int totalInUse = 0;

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT count(*) FROM account WHERE hptemplateid='"+templateid+"' OR entlisttemplateid='"+templateid+"' OR sitetemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            totalInUse = totalInUse + Integer.parseInt(rstData[0][0]);
        }


        //-----------------------------------
        //-----------------------------------
        String[][] rstData2= Db.RunSQL("SELECT count(*) FROM megalog WHERE maintemplateid='"+templateid+"' OR entlisttemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData2!=null && rstData2.length>0){
            totalInUse = totalInUse + Integer.parseInt(rstData2[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData3= Db.RunSQL("SELECT count(*) FROM pl WHERE marketingsitetemplateid='"+templateid+"' OR marketingsitehptemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData3!=null && rstData3.length>0){
            totalInUse = totalInUse + Integer.parseInt(rstData3[0][0]);
        }

         return totalInUse;
    }

    public void delete(){
        delete(-1);
    }

    public void delete(int convertUsesToTemplateid){

        //Be sure that we have a valid new templateid
        int newtemplateid = convertUsesToTemplateid;
        if (newtemplateid<=0){
            PrivateLabel pl = new PrivateLabel();
            Template tmpSys = AllTemplatesInSystem.getSystemDefaultByType(type);
            if(tmpSys!=null){
                newtemplateid = tmpSys.getTemplateid();
            } else {
                Template tmpAll = AllTemplatesInSystem.getSystemTemplatesByType(type)[0];
                newtemplateid = tmpAll.getTemplateid();
            }
        }

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE account SET hptemplateid='"+newtemplateid+"' WHERE hptemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count1 = Db.RunSQLUpdate("UPDATE account SET entlisttemplateid='"+newtemplateid+"' WHERE entlisttemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("UPDATE account SET sitetemplateid='"+newtemplateid+"' WHERE sitetemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("UPDATE megalog SET maintemplateid='"+newtemplateid+"' WHERE maintemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("UPDATE megalog SET entlisttemplateid='"+newtemplateid+"' WHERE entlisttemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("UPDATE pl SET marketingsitetemplateid='"+newtemplateid+"' WHERE marketingsitetemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count6 = Db.RunSQLUpdate("UPDATE pl SET marketingsitehptemplateid='"+newtemplateid+"' WHERE marketingsitehptemplateid='"+templateid+"'");
        //-----------------------------------
        //-----------------------------------

        //Do the delete if no uses of the template exist
        if (countUsesOfTemplate()<=0){
            //-----------------------------------
            //-----------------------------------
            int countDelete = Db.RunSQLUpdate("DELETE FROM templatenew WHERE templateid='"+templateid+"'");
            //-----------------------------------
            //-----------------------------------
        }

        AllTemplatesInSystem.refresh(templateid);
    }

    public int getTemplateid() {
        return templateid;
    }

    public String getTemplate() {
        return template;
    }

    public int getType() {
        return type;
    }

    public boolean getIssystemtemplate() {
        return issystemtemplate;
    }

    public int getAccountid() {
        return accountid;
    }

    public String getName() {
        return name;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssystemtemplate(boolean issystemtemplate) {
        this.issystemtemplate = issystemtemplate;
    }
}
