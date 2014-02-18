package reger;

import reger.core.licensing.DesEncrypter;
import reger.core.licensing.License;

import java.util.Hashtable;
import java.util.HashMap;

/**
 * Handles storage of the isbillingok variable in the database
 */
public class IsBillingOk {

    private static String passPhrase = "pupper";
    public static String PROPSTRINGISBILLINGOK = "ibo";
    public static String PROPSTRINGRANDOMSALT = "rds";
    public static String PROPSTRINGACCOUNTID = "act";

    public static boolean isbillingok(String isbillingokencrypted, int accountid){
        //Create a decrypter object
        DesEncrypter encrypter2 = new DesEncrypter(passPhrase);
        //Do the decryption
        String decrypted = encrypter2.decrypt(isbillingokencrypted);
        //Split the name/valuepairs
        HashMap props = reger.core.licensing.License.putLicensePropsIntoHashmap(decrypted);
        //See if we have the correct value
        if (props.get(PROPSTRINGISBILLINGOK)!=null){
            if (props.get(PROPSTRINGISBILLINGOK).equals("1") || props.get(PROPSTRINGISBILLINGOK).equals("true")){
                if (props.get(PROPSTRINGACCOUNTID)!=null){
                    if (reger.core.Util.isinteger(String.valueOf(props.get(PROPSTRINGACCOUNTID)))){
                        if (Integer.parseInt(String.valueOf(props.get(PROPSTRINGACCOUNTID)))==accountid){
                            return true;
                        }
                    }
                }
            }
        }
        return true;
        //HACK TO KILL LICENSING
        //return false;
    }


    public static String getIsbillingokString(boolean isbillingok, int accountid){
        //Can't just return a simple string... must be encrypted and include a random salt

        //Start with an empty stringbuffer
        StringBuffer tmpLic = new StringBuffer();

        //Add boolean to props
        HashMap props = new HashMap();
        //HACK TO KILL LICENSING
        //if(isbillingok){
            props.put(PROPSTRINGISBILLINGOK, "1");
        //} else {
        //    props.put(PROPSTRINGISBILLINGOK, "0");
        //}

        //Add the accountid
        props.put(PROPSTRINGACCOUNTID, String.valueOf(accountid));

        //Add props
        tmpLic.append(License.addHashtablePropsToLongString(props));

        //Add the randomSalt
        tmpLic = License.addNameValuePairToLicense(tmpLic, PROPSTRINGRANDOMSALT, reger.core.RandomString.randomAlphanumeric(6));

        //Encrypt it
        DesEncrypter encrypter2 = new DesEncrypter(passPhrase);
        String encIsBillOk = encrypter2.encrypt(tmpLic.toString());

        return encIsBillOk;
    }




}
