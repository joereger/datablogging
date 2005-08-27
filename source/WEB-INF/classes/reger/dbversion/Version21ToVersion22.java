package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version21ToVersion22 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("CREATE TABLE `aclgroup` (`aclgroupid` int(11) NOT NULL auto_increment, aclgroupname varchar(255), PRIMARY KEY  (`aclgroupid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("CREATE TABLE `aclgroupmembershipgrants` (`aclgroupmembershipgrantsid` int(11) NOT NULL auto_increment, aclgroupid int(11) NOT NULL, aclobjectid int(11) NOT NULL, PRIMARY KEY  (`aclgroupmembershipgrantsid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("CREATE TABLE `accountuseraclgroup` (`accountuseraclgroupid` int(11) NOT NULL auto_increment, accountuserid int(11) NOT NULL, aclgroupid int(11) NOT NULL, PRIMARY KEY  (`accountuseraclgroupid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
            //-----------------------------------
            //-----------------------------------

            //Populate the aclgroup
            //-----------------------------------
            //-----------------------------------
            int aclgroupidOfSiteOwner = Db.RunSQLInsert("INSERT INTO aclgroup(aclgroupname) VALUES('SiteOwner')");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int aclgroupidOfLOEAdmin = Db.RunSQLInsert("INSERT INTO aclgroup(aclgroupname) VALUES('LOEAdmin')");
            //-----------------------------------
            //-----------------------------------

            //Add the aclobject pladmin
            //-----------------------------------
            //-----------------------------------
            int identity12 = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectid, aclobjectname, aclfriendlyname, acldesc) VALUES('24', '"+reger.core.Util.cleanForSQL("PLADMIN")+"', '"+reger.core.Util.cleanForSQL("Private Label Admin Section")+"', '"+reger.core.Util.cleanForSQL("The ability to administer private labels.")+"')");
            //-----------------------------------
            //-----------------------------------

            //Populate the owner group
            //-----------------------------------
            //-----------------------------------
            String[][] rstACLS= Db.RunSQL("SELECT aclobjectid, aclobjectname FROM aclobject");
            //-----------------------------------
            //-----------------------------------
            if (rstACLS!=null && rstACLS.length>0){
            	for(int i=0; i<rstACLS.length; i++){
            	    if (!rstACLS[i][1].equals("MASTERADMIN") && !rstACLS[i][1].equals("PLADMIN")){
                        //-----------------------------------
                        //-----------------------------------
                        int identity = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('"+aclgroupidOfSiteOwner+"', '"+rstACLS[i][0]+"')");
                        //-----------------------------------
                        //-----------------------------------
                    }
            	}
            }

            //Populate the LOE group
            //-----------------------------------
            //-----------------------------------
            String[][] rstACLSLoe= Db.RunSQL("SELECT aclobjectid, aclobjectname FROM aclobject");
            //-----------------------------------
            //-----------------------------------
            if (rstACLSLoe!=null && rstACLSLoe.length>0){
                for(int i=0; i<rstACLSLoe.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid) VALUES('"+aclgroupidOfLOEAdmin+"', '"+rstACLSLoe[i][0]+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }

            //Now, find all account owners and make them part of the site owners group
            //-----------------------------------
            //-----------------------------------
            String[][] rstOwners= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountusertypeid<>'2' AND accountusertypeid<>'3'");
            //-----------------------------------
            //-----------------------------------
            if (rstOwners!=null && rstOwners.length>0){
            	for(int i=0; i<rstOwners.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO accountuseraclgroup(accountuserid, aclgroupid) VALUES('"+rstOwners[i][0]+"', '"+aclgroupidOfSiteOwner+"')");
                    //-----------------------------------
                    //-----------------------------------
            	}
            }

            //Now, find all masteradmins and make them part of the masteradmins group
            //-----------------------------------
            //-----------------------------------
            String[][] rstMa= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountusertypeid='4'");
            //-----------------------------------
            //-----------------------------------
            if (rstMa!=null && rstMa.length>0){
                for(int i=0; i<rstMa.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int identity = Db.RunSQLInsert("INSERT INTO accountuseraclgroup(accountuserid, aclgroupid) VALUES('"+rstMa[i][0]+"', '"+aclgroupidOfLOEAdmin+"')");
                    //-----------------------------------
                    //-----------------------------------
                }
            }


            //Delete accountusertype table
            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("DROP TABLE accountusertype");
            //-----------------------------------
            //-----------------------------------

            //Remove accountusertypeid from accountuser
            //-----------------------------------
            //-----------------------------------
            int count44 = Db.RunSQLUpdate("ALTER TABLE accountuser DROP accountusertypeid");
            //-----------------------------------
            //-----------------------------------



    }





}
