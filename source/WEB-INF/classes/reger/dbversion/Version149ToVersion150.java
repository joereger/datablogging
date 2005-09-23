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
public class Version149ToVersion150 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        StringBuffer mb = new StringBuffer();
        mb.append("<$Quick.Stats$>" + "<br>");
        mb.append("<$Small.Calendar$>" + "<br>");
        mb.append("<$On.This.Day$>" + "<br>");
        mb.append("<$Blogroll$>" + "<br>");
        mb.append("<$Comments$>" + "<br>");
        mb.append("<$Search.Box$>" + "<br>");
        mb.append("<$Email.Subscribe.Box$>" + "<br>");
        mb.append("<$Graphs.List$>" + "<br>");
        mb.append("<Rss.Link$>" + "<br>");
        mb.append("<Wap.Link$>" + "<br>");



        //-----------------------------------
        //-----------------------------------
        String[][] rstTemplate= Db.RunSQL("SELECT templateid, template FROM templatenew WHERE type='"+ Template.TEMPLATETYPESITE+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTemplate!=null && rstTemplate.length>0){
            for(int i=0; i<rstTemplate.length; i++){
                int templateid = Integer.parseInt(rstTemplate[i][0]);
                String templateOriginal = rstTemplate[i][1];

                //String templateReplaced = templateOriginal.replaceAll("\\<\\$Side.Column\\$\\>", mb.toString());


                //This is the main page output stringbuffer
                StringBuffer pg = new StringBuffer();

                // Create a pattern to match cat
                //Pattern p = Pattern.compile("(\\<\\$(.|\\n)*?\\$\\>)");
                Pattern p = Pattern.compile("(\\<\\$(Side\\.Column)*?\\$\\>)");
                // Create a matcher with an input string
                Matcher m = p.matcher(templateOriginal);
                // Loop through
                while(m!=null && m.find()) {
                    m.appendReplacement(pg, reger.core.Util.cleanForAppendreplacement(mb.toString()));
                }
                // Add the last segment
                try{
                    m.appendTail(pg);
                } catch (Exception e){
                    //Do nothing... just null pointer... there was no tail because a tag was last char
                }


                String templateReplaced = pg.toString();

                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE templatenew SET template='"+reger.core.Util.cleanForSQL(templateReplaced)+"' WHERE templateid='"+templateid+"'");
                //-----------------------------------
                //-----------------------------------

                reger.core.Debug.debug(3, "Version149ToVersion150.java", "Original:<br>" + templateOriginal.replaceAll("<", "&lt;") + "<br><br>Final:<br>" + templateReplaced.replaceAll("<", "&lt;"));

            }
        }


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
