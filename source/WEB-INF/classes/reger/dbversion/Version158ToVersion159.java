package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.template.Template;
import reger.template.SiteTemplateTag;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * This creates the base database if none exists.
 */
public class Version158ToVersion159 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

         StringBuffer mb = new StringBuffer();
         StringBuffer nu = new StringBuffer();

        //-----------------------------------
        //-----------------------------------
        String[][] rstTemplate= Db.RunSQL("SELECT templateid, template FROM templatenew WHERE type='"+ Template.TEMPLATETYPESITE+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTemplate!=null && rstTemplate.length>0){
            for(int i=0; i<rstTemplate.length; i++){
                int templateid = Integer.parseInt(rstTemplate[i][0]);
                String templateOriginal = rstTemplate[i][1];
                String templateFinal = templateOriginal;

                //Find second occurrence of <html, delete everything after it
                mb.append("<br><br>templateid:"+templateid);
                mb.append("<br>templateOriginal.length(): " + templateOriginal.length());

                int indexOfClosingLCHtmlTag = templateOriginal.indexOf("</html>");
                mb.append("<br>indexOfClosingLCHtmlTag: " + indexOfClosingLCHtmlTag);
                if (templateOriginal.length()>indexOfClosingLCHtmlTag+7 && indexOfClosingLCHtmlTag>0){
                    templateFinal = templateOriginal.substring(0,indexOfClosingLCHtmlTag+7);
                    mb.append("<br>found lc html and fixed.  substring(0, "+(indexOfClosingLCHtmlTag+7)+")");
                } else {
                    mb.append("<br>lc html not found");
                    int indexOfClosingUCHtmlTag = templateOriginal.indexOf("</HTML>");
                    mb.append("<br>indexOfClosingUCHtmlTag: " + indexOfClosingUCHtmlTag);
                    if (templateOriginal.length()>indexOfClosingUCHtmlTag+7 && indexOfClosingUCHtmlTag>0){
                        templateFinal = templateOriginal.substring(0,indexOfClosingUCHtmlTag+7);
                        mb.append("<br>found uc html and fixed.  substring(0, "+(indexOfClosingUCHtmlTag+7)+")");
                    } else {
                        mb.append("<br><b>UC html NOT FOUND. NO FIX DONE.</b>");
                        nu.append("<br><b>Templateid="+templateid+" UC html NOT FOUND. NO FIX DONE.</b>");
                        reger.core.Debug.debug(0, "TEMPLATE NOT UPDATED", "templateid="+templateid+" not fixed.");
                    }
                }

                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE templatenew SET template='"+reger.core.Util.cleanForSQL(templateFinal)+"' WHERE templateid='"+templateid+"'");
                //-----------------------------------
                //-----------------------------------

                reger.core.Debug.debug(0, "Version158ToVersion159.java", "Templateid="+templateid+"<br><br>Original:<br>" + templateOriginal.replaceAll("<", "&lt;") + "<br><br>Final:<br>" + templateFinal.replaceAll("<", "&lt;"));
            }

        }

        reger.core.Debug.debug(0, "TEMPLATE FIX SUMMARY", "TEMPLATE FIX SUMMARY:<br>"+mb.toString());
        reger.core.Debug.debug(0, "TEMPLATE FIX SUMMARY", "THOSE NOT FIXED:<br>"+nu.toString());

    }

}

        //Sample sql statements

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE daterangesavedsearchid daterangesavedsearchid int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE account DROP gps");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
        //-----------------------------------
        //-----------------------------------
