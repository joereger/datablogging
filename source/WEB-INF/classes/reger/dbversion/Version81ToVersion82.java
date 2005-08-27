package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version81ToVersion82 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `templatenew` ( `templateid` int(11) NOT NULL auto_increment, `template` longtext, `type` int(11) NOT NULL, `thumbnail` varchar(255) default NULL, `accountid` int(11), `issystemtemplate` int(11) NOT NULL default '0', `name` varchar(255) NOT NULL default 'Template', PRIMARY KEY (`templateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE megalog ADD maintemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE megalog ADD entlisttemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE account ADD hptemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count5 = Db.RunSQLUpdate("ALTER TABLE account ADD entlisttemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count6 = Db.RunSQLUpdate("ALTER TABLE account ADD sitetemplateid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------


            //-----------------------------------
            //-----------------------------------
            String[][] rstTemplate= Db.RunSQL("SELECT templateid, templatemainbody, templateentry, templatename, thumbnail, showwithsignup  FROM template");
            //-----------------------------------
            //-----------------------------------
            if (rstTemplate!=null && rstTemplate.length>0){
            	for(int i=0; i<rstTemplate.length; i++){

                    int oldTemplateid = Integer.parseInt(rstTemplate[i][0]);

                    //Move site templates over
                    //-----------------------------------
                    //-----------------------------------
                    int newSiteTemplateid = Db.RunSQLInsert("INSERT INTO templatenew(template, type, thumbnail, accountid, issystemtemplate, name) VALUES('"+reger.core.Util.cleanForSQL(rstTemplate[i][1])+"', '"+reger.template.Template.TEMPLATETYPESITE+"', '"+reger.core.Util.cleanForSQL(rstTemplate[i][4])+"', '0', '"+rstTemplate[i][5]+"', '"+reger.core.Util.cleanForSQL(rstTemplate[i][3])+"')");
                    //-----------------------------------
                    //-----------------------------------
                    //Convert users of site template to new scheme
                    //-----------------------------------
                    //-----------------------------------
                    int count34 = Db.RunSQLUpdate("UPDATE account SET sitetemplateid='"+newSiteTemplateid+"' WHERE templateid='"+oldTemplateid+"'");
                    //-----------------------------------
                    //-----------------------------------

                    //Move entry list templates over
                    //-----------------------------------
                    //-----------------------------------
                    int newEntryListTemplateid = Db.RunSQLInsert("INSERT INTO templatenew(template, type, thumbnail, accountid, issystemtemplate, name) VALUES('"+reger.core.Util.cleanForSQL(rstTemplate[i][2])+"', '"+reger.template.Template.TEMPLATETYPEENTRYLIST+"', '', '0', '"+rstTemplate[i][5]+"', '"+reger.core.Util.cleanForSQL(rstTemplate[i][3])+"')");
                    //-----------------------------------
                    //-----------------------------------
                    //Convert users of entry template to new scheme
                    //-----------------------------------
                    //-----------------------------------
                    int count34e = Db.RunSQLUpdate("UPDATE account SET entlisttemplateid='"+newEntryListTemplateid+"' WHERE templateid='"+oldTemplateid+"'");
                    //-----------------------------------
                    //-----------------------------------


            	}
            }



    }


}
