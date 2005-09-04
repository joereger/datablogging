package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.licensing.License;
import reger.core.Debug;

import java.util.Calendar;
import java.util.Hashtable;


/**
 * This creates the base database if none exists.
 */
public class Version140ToVersion141 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){


        //-----------------------------------
        //-----------------------------------
        String[][] rstAcct= Db.RunSQL("SELECT accountid, createdate, accounttypeid, maxspaceinbytes, maxbandwidth, accounturl, accountemail FROM account");
        //-----------------------------------
        //-----------------------------------
        if (rstAcct!=null && rstAcct.length>0){
            for(int i=0; i<rstAcct.length; i++){
                try{

                    //License props
                    Hashtable licenseProps = new Hashtable();
                    Calendar expDate = reger.core.TimeUtils.nowInGmtCalendar();
                    //Create the license
                    License accountLicense = new License(null, "");
                    String encryptedlicense = "";

                    if (reger.core.Util.isinteger(rstAcct[i][2]) &&  Integer.parseInt(rstAcct[i][2])>=reger.Vars.ACCTYPEPRO){
                        //Expiration date - 3 years from now
                        expDate = reger.core.TimeUtils.xYearsAgoEnd(reger.core.TimeUtils.nowInGmtCalendar(), (-1*3));
                        licenseProps.put(License.PROPSTRINGLICENSETYPE, String.valueOf(License.LICENSETYPEACCOUNTSUBSCRIPTION));
                        licenseProps.put(License.PROPSTRINGISCHARGEDTOCREDITCARD, "0");
                        licenseProps.put(License.PROPSTRINGEXPDATEGMT, String.valueOf(reger.core.TimeUtils.dateformatfordb(expDate)));
                        if (reger.core.Util.isnumeric(rstAcct[i][3]) && Long.parseLong(rstAcct[i][3])>1000000){
                            licenseProps.put(License.PROPSTRINGMAXSPACEINBYTES, String.valueOf(rstAcct[i][3]));
                        }
                        if (reger.core.Util.isnumeric(rstAcct[i][4]) && Long.parseLong(rstAcct[i][4])>0){
                            licenseProps.put(License.PROPSTRINGMAXBANDWIDTH, String.valueOf(rstAcct[i][4]));
                        }
                        accountLicense = new License(null, licenseProps);
                        encryptedlicense = accountLicense.getEncryptedLicense();
                        //Go to licensing server and create a license
                        Hashtable result = reger.core.licensing.RegerLicensingApiClient.createLicense("", encryptedlicense, rstAcct[i][5], "NA", "NA", "NA", "NA", "NA", "NA", "", "", "", "NA", rstAcct[i][6]);
                        if (result.get("encryptedlicense")!=null && !((String)result.get("encryptedlicense")).equals("")){
                            encryptedlicense = (String)result.get("encryptedlicense");
                        } else {
                            Debug.logtodb("Upgrading Error for VIP Accountid=" + rstAcct[i][0] + "<br>This license may not be properly configured.  Please check.<br>Errormessage=" + result.get("errormessage"), "");
                        }
                    } else if (reger.core.Util.isinteger(rstAcct[i][2]) &&  Integer.parseInt(rstAcct[i][2])==reger.Vars.ACCTYPETRIAL){
                        //Expiration date - Restart the trial period
                        expDate = reger.core.TimeUtils.xDaysAgoEnd(reger.core.TimeUtils.nowInGmtCalendar(), (-1*reger.Vars.TRIALACCOUNTDAYS));
                        licenseProps.put(License.PROPSTRINGLICENSETYPE, String.valueOf(License.LICENSETYPEACCOUNTSUBSCRIPTION));
                        licenseProps.put(License.PROPSTRINGEXPDATEGMT, String.valueOf(reger.core.TimeUtils.dateformatfordb(expDate)));
                        if (reger.core.Util.isinteger(rstAcct[i][3]) && Integer.parseInt(rstAcct[i][3])>1000000){
                            licenseProps.put(License.PROPSTRINGMAXSPACEINBYTES, String.valueOf(rstAcct[i][3]));
                        }
                        if (reger.core.Util.isinteger(rstAcct[i][4]) && Integer.parseInt(rstAcct[i][4])>0){
                            licenseProps.put(License.PROPSTRINGMAXBANDWIDTH, String.valueOf(rstAcct[i][4]));
                        }
                        accountLicense = new License(null, licenseProps);
                        encryptedlicense = accountLicense.getEncryptedLicense();
                    } else {
                        //Expiration date - Expire the acct
                        expDate = reger.core.TimeUtils.xDaysAgoEnd(reger.core.TimeUtils.nowInGmtCalendar(), (1));
                        licenseProps.put(License.PROPSTRINGLICENSETYPE, String.valueOf(License.LICENSETYPEACCOUNTSUBSCRIPTION));
                        licenseProps.put(License.PROPSTRINGEXPDATEGMT, String.valueOf(reger.core.TimeUtils.dateformatfordb(expDate)));
                        if (reger.core.Util.isinteger(rstAcct[i][3]) && Integer.parseInt(rstAcct[i][3])>1000000){
                            licenseProps.put(License.PROPSTRINGMAXSPACEINBYTES, String.valueOf(rstAcct[i][3]));
                        }
                        if (reger.core.Util.isinteger(rstAcct[i][4]) && Integer.parseInt(rstAcct[i][4])>0){
                            licenseProps.put(License.PROPSTRINGMAXBANDWIDTH, String.valueOf(rstAcct[i][4]));
                        }
                        accountLicense = new License(null, licenseProps);
                        encryptedlicense = accountLicense.getEncryptedLicense();
                    }

                    //Save the license to the database
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE account SET encryptedlicense='"+encryptedlicense+"' WHERE accountid='"+rstAcct[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                } catch (Exception e){
                    Debug.errorsave(e, "");
                }
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
