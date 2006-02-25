package reger.dbversion;

import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.db.Db;

/**
 * WARNING: After any database update you must update the classes in reger.dao.
 *
 *     1) Make your changes to the database with this class
 *     2) QuickBuild or fully deploy the app so that the database is updated
 *     3) Log in with superuser privileges
 *     4) Go to LOE Admin -> Tools -> DAO Generator
 *     5) Use this screen to update the affected DAOs
 *     6) Access the database via the DAOs only
 * 
 */
public class Version185ToVersion186 implements UpgradeDatabaseOneVersion {

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count1 = Db.RunSQLUpdate("ALTER TABLE account CHANGE pingweblogscom pingweblogscom tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("ALTER TABLE account CHANGE homepagecalendar homepagecalendar tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("ALTER TABLE account CHANGE messagesstatus messagesstatus tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4 = Db.RunSQLUpdate("ALTER TABLE account CHANGE messagesapproval messagesapproval tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count5 = Db.RunSQLUpdate("ALTER TABLE account CHANGE admintools admintools tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count6 = Db.RunSQLUpdate("ALTER TABLE account CHANGE showhometab showhometab tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count7 = Db.RunSQLUpdate("ALTER TABLE account CHANGE showlogintab showlogintab tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count8 = Db.RunSQLUpdate("ALTER TABLE account CHANGE userelatedlinks userelatedlinks tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count9 = Db.RunSQLUpdate("ALTER TABLE account CHANGE favesiteon favesiteon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count11 = Db.RunSQLUpdate("ALTER TABLE account CHANGE onthisday onthisday tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count22 = Db.RunSQLUpdate("ALTER TABLE account CHANGE issearchmysiteon issearchmysiteon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count33 = Db.RunSQLUpdate("ALTER TABLE account CHANGE istrackbackon istrackbackon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count44 = Db.RunSQLUpdate("ALTER TABLE account CHANGE islistedindirectory islistedindirectory tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count55 = Db.RunSQLUpdate("ALTER TABLE account CHANGE trackbackrequiresapproval trackbackrequiresapproval tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count66 = Db.RunSQLUpdate("ALTER TABLE account CHANGE isactiveaccount isactiveaccount tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count77 = Db.RunSQLUpdate("ALTER TABLE account CHANGE isnewpendingadminapproval isnewpendingadminapproval tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------



        //-----------------------------------
        //-----------------------------------
        int count88 = Db.RunSQLUpdate("ALTER TABLE accountuser CHANGE isactive isactive tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count99 = Db.RunSQLUpdate("ALTER TABLE accountuser CHANGE ishelpon ishelpon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count111 = Db.RunSQLUpdate("ALTER TABLE accountuser CHANGE isactivatedbyemail isactivatedbyemail tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------



        //-----------------------------------
        //-----------------------------------
        int count222 = Db.RunSQLUpdate("ALTER TABLE accountuserlogaccess CHANGE canread canread tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count333 = Db.RunSQLUpdate("ALTER TABLE accountuserlogaccess CHANGE canwrite canwrite tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int count444 = Db.RunSQLUpdate("ALTER TABLE banner CHANGE active active tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int count555 = Db.RunSQLUpdate("ALTER TABLE bug CHANGE isopen isopen tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count666 = Db.RunSQLUpdate("ALTER TABLE emailapi CHANGE overridecamphonesubject overridecamphonesubject tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count777 = Db.RunSQLUpdate("ALTER TABLE emailapi CHANGE ignorecamphonebody ignorecamphonebody tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count888 = Db.RunSQLUpdate("ALTER TABLE emailapi CHANGE consolidatecamphonetoonedailyentry consolidatecamphonetoonedailyentry tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count999 = Db.RunSQLUpdate("ALTER TABLE emailapi CHANGE saveemailpostsasdraft saveemailpostsasdraft tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count1111 = Db.RunSQLUpdate("ALTER TABLE emailapi CHANGE savecamphonepostsasdraft savecamphonepostsasdraft tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2222 = Db.RunSQLUpdate("ALTER TABLE emailsubscriber CHANGE htmlemail htmlemail tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3333 = Db.RunSQLUpdate("ALTER TABLE episode CHANGE isprivate isprivate tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count4444 = Db.RunSQLUpdate("ALTER TABLE event CHANGE isdraft isdraft tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count5555 = Db.RunSQLUpdate("ALTER TABLE event CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count6666 = Db.RunSQLUpdate("ALTER TABLE event CHANGE favorite favorite tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count7777 = Db.RunSQLUpdate("ALTER TABLE event CHANGE istemporary istemporary tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int countdhg = Db.RunSQLUpdate("ALTER TABLE event CHANGE ismoderatorapproved ismoderatorapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int countdsg = Db.RunSQLUpdate("ALTER TABLE event CHANGE isflaggedformoderator isflaggedformoderator tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coufdgsnt = Db.RunSQLUpdate("ALTER TABLE event CHANGE requiresmoderatorapproval requiresmoderatorapproval tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int coudfghnt = Db.RunSQLUpdate("ALTER TABLE friendinvitationlogid CHANGE canread canread tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coundhgt = Db.RunSQLUpdate("ALTER TABLE friendinvitationlogid CHANGE canwrite canwrite tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudfhgnt = Db.RunSQLUpdate("ALTER TABLE friendmessagerecipient CHANGE isread isread tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudfhnt = Db.RunSQLUpdate("ALTER TABLE groupmembership CHANGE sharemembershippublicly sharemembershippublicly tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int codfhunt = Db.RunSQLUpdate("ALTER TABLE groupmembership CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudggfghnt = Db.RunSQLUpdate("ALTER TABLE groupmembership CHANGE ismoderator ismoderator tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudfdfghnt = Db.RunSQLUpdate("ALTER TABLE groups CHANGE membershipismoderated membershipismoderated tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int codfhgunt = Db.RunSQLUpdate("ALTER TABLE linkrot CHANGE isbroken isbroken tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudfggerhnt = Db.RunSQLUpdate("ALTER TABLE loginhistory CHANGE success success tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int codghunt = Db.RunSQLUpdate("ALTER TABLE megafield CHANGE isrequired isrequired tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int gcoudfghnt = Db.RunSQLUpdate("ALTER TABLE megalog CHANGE showonhomepage showonhomepage tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cofdhunt = Db.RunSQLUpdate("ALTER TABLE megalogtype CHANGE showlocation showlocation tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int codfhergergunt = Db.RunSQLUpdate("ALTER TABLE megalogtype CHANGE showonhomepage showonhomepage tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int codfghunt = Db.RunSQLUpdate("ALTER TABLE megalogtype CHANGE issystemlogtype issystemlogtype tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int coudfegehgnt = Db.RunSQLUpdate("ALTER TABLE megalogtype CHANGE isprivate isprivate tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudghnt = Db.RunSQLUpdate("ALTER TABLE megaoption CHANGE isdefault isdefault tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cougfhnt = Db.RunSQLUpdate("ALTER TABLE megaoption CHANGE isactive isactive tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int codghergerunt = Db.RunSQLUpdate("ALTER TABLE message CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------


        //-----------------------------------
        //-----------------------------------
        int coundtehgt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE islive islive tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couerhtnt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE issignupenabled issignupenabled tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couegtrnt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE iscontentflaggingon iscontentflaggingon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int courkir7nt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE doesflaggedcontentneedtobeapproved doesflaggedcontentneedtobeapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cou54ggnt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE doallpostsneedtobeapproved doallpostsneedtobeapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coug54e545tgnt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE usedynamicdns usedynamicdns tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coune4g54tst = Db.RunSQLUpdate("ALTER TABLE pl CHANGE newaccountsrequireadminapproval newaccountsrequireadminapproval tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coung4t5g45t = Db.RunSQLUpdate("ALTER TABLE pl CHANGE forcelogintoviewsites forcelogintoviewsites tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cougrsrtnt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE isweblogscompingon isweblogscompingon tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coreyh56hunt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE ispasswordsentviaemail ispasswordsentviaemail tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int counrehtrtt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE doapplyplusertemplatetopro doapplyplusertemplatetopro tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coureytyyhytynt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE istrackbackenabled istrackbackenabled tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coutyutynt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE showbannertagsonpro showbannertagsonpro tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int courtyunt = Db.RunSQLUpdate("ALTER TABLE pl CHANGE isemailactivationofaccountsrequired isemailactivationofaccountsrequired tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cougeg5nt = Db.RunSQLUpdate("ALTER TABLE poll CHANGE readerscanaddownanswer readerscanaddownanswer tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couertyrtnt = Db.RunSQLUpdate("ALTER TABLE poll CHANGE readerscanaddcomments readerscanaddcomments tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int courteyrtynt = Db.RunSQLUpdate("ALTER TABLE poll CHANGE readerscanvoteonreaderanswers readerscanvoteonreaderanswers tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couetryertynt = Db.RunSQLUpdate("ALTER TABLE poll CHANGE readerinputismoderated readerinputismoderated tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couretertnt = Db.RunSQLUpdate("ALTER TABLE poll CHANGE isopen isopen tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int couerternt = Db.RunSQLUpdate("ALTER TABLE pollreaderanswer CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coufdfdgnt = Db.RunSQLUpdate("ALTER TABLE pollreadercomment CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cofdsfdsunt = Db.RunSQLUpdate("ALTER TABLE systemmessage CHANGE islive islive tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int counsdffsdt = Db.RunSQLUpdate("ALTER TABLE systemmessage CHANGE autooldonrestart autooldonrestart tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int counsdffdst = Db.RunSQLUpdate("ALTER TABLE systemmessage CHANGE showtologgedinusers showtologgedinusers tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdfnt = Db.RunSQLUpdate("ALTER TABLE systemmessage CHANGE showtonotloggedinusers showtonotloggedinusers tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int coudsffnt = Db.RunSQLUpdate("ALTER TABLE templatenew CHANGE issystemtemplate issystemtemplate tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdffdnt = Db.RunSQLUpdate("ALTER TABLE timeperiod CHANGE isprivate isprivate tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdsfdnt = Db.RunSQLUpdate("ALTER TABLE timeperiod CHANGE isopenended isopenended tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdfdsnt = Db.RunSQLUpdate("ALTER TABLE trackback CHANGE isoutbound isoutbound tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdfsdfnt = Db.RunSQLUpdate("ALTER TABLE trackback CHANGE ispingedalready ispingedalready tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cousdfsdnt = Db.RunSQLUpdate("ALTER TABLE trackback CHANGE isapproved isapproved tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int cougrergnt = Db.RunSQLUpdate("ALTER TABLE traffic CHANGE iscollapsed iscollapsed tinyint(1) default NULL");
        //-----------------------------------
        //-----------------------------------




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


}
