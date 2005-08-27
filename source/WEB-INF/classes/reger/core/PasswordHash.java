package reger.core;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

/**
 * Gives passwords as a hash
 */
public class PasswordHash {


    public static String getHash(String plaintextPassword){
        MessageDigest md = null;

        try{
          md = MessageDigest.getInstance("SHA"); //step 1
        }catch(Exception e){
            reger.core.Util.errorsave(e);
        }

        try{
            if (plaintextPassword!=null && md!=null){
                md.update(plaintextPassword.getBytes("UTF-8")); //step 2
            }
        }catch(Exception e){
            reger.core.Util.errorsave(e);
        }

        byte raw[] = md.digest(); //step 3
        String hash = (new BASE64Encoder()).encode(raw); //step 4
        return hash; //step 5
    }

}
