package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version108ToVersion109 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            String[][] rstAccount= Db.RunSQL("SELECT accountid FROM account");
            //-----------------------------------
            //-----------------------------------
            if (rstAccount!=null && rstAccount.length>0){
                for(int i=0; i<rstAccount.length; i++){
                    reger.Account acct = new reger.Account(Integer.parseInt(rstAccount[i][0]));
                    acct.getNestedNavCollection().resetEntireLayout();
                }
            }





    }


}
