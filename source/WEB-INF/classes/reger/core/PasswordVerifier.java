package reger.core;

import edu.vt.middleware.password.*;

import java.io.File;

import reger.PrivateLabel;

/**
 * Verifies that a password is valid for the given PL
 */
public class PasswordVerifier {

    private int minPasswordCharacters = 5;
    private int minPasswordUpperCaseChars = 0;
    private int minPasswordLowerCaseChars = 0;
    private int minPasswordSpecialChars = 0;
    private int minPasswordNumericChars = 0;

    public PasswordVerifier(PrivateLabel pl){
        this.minPasswordCharacters = pl.getMinPasswordChars();
        this.minPasswordUpperCaseChars = pl.getMinPasswordUpperCaseChars();
        this.minPasswordLowerCaseChars = pl.getMinPasswordLowerCaseChars();
        this.minPasswordSpecialChars = pl.getMinPasswordSpecialChars();
        this.minPasswordNumericChars = pl.getMinPasswordNumericChars();
    }

    public String validatePassword(String password, String verifypassword){
        reger.core.Util.debug(5, "PasswordVerifier.java: Verifying passwords.  <br>password="+password+"<br>verifypassword="+verifypassword);

        if (!password.equals(verifypassword)){
            return "Password and Verify Password must match.";
        }

        int numberofrules = 0;

        PasswordLengthRule lengthRule = new PasswordLengthRule(minPasswordCharacters, 50); // password must be between 8 and 16 chars long
        PasswordWhitespaceRule whitespaceRule = new PasswordWhitespaceRule(); // don't allow whitespace
        PasswordCharacterRule charRule = new PasswordCharacterRule();
        //charRule.setNumberOfAlphabetical(0); // require at least 0 alphabetical chars
        if (minPasswordNumericChars>0){
            charRule.setNumberOfDigits(minPasswordNumericChars); // require at least 1 digit in passwords
            numberofrules = numberofrules + 1;
        }
        if (minPasswordSpecialChars>0){
            charRule.setNumberOfNonAlphanumeric(minPasswordSpecialChars); // require at least 1 non-alphanumeric char
            numberofrules = numberofrules + 1;
        }
        if (minPasswordUpperCaseChars>0){
            charRule.setNumberOfUppercase(minPasswordUpperCaseChars); // require at least 1 upper case char
            numberofrules = numberofrules + 1;
        }
        if (minPasswordLowerCaseChars>0){
            charRule.setNumberOfLowercase(minPasswordLowerCaseChars); // require at least 1 lower case char
            numberofrules = numberofrules + 1;
        }

        //Now tell it how many explicit rules there are
        charRule.setNumberOfCharacteristics(numberofrules); // require at least X of the previous rules be met

        //PasswordDictionaryRule dictRule = new PasswordDictionaryRule();
        //dictRule.ignoreCase(); // ignore case when search for words
        //dictRule.importDictionary(new File("dictionary1.txt")); // import dictionary
        //dictRule.importDictionary(new File("dictionary2.txt")); // import dictionary
        //dictRule.setNumberOfCharacters(5); // allow dictionary words < 5 chars long
        //dictRule.matchBackwards(); // match dictionary words forwards and backwards
        //dictRule.buildDictionary(); // create dictionary tree
        //PasswordSequenceRule seqRule = new PasswordSequenceRule();
        //seqRule.ignoreCase(); // ignore case when looking for sequences

        PasswordChecker checker = new PasswordChecker();
        checker.addPasswordRule(lengthRule);
        checker.addPasswordRule(whitespaceRule);
        checker.addPasswordRule(charRule);
        //checker.addPasswordRule(dictRule);
        //checker.addPasswordRule(seqRule);
        try {
          checker.checkPassword(new Password(password));
          // password passed check
        } catch (PasswordException e) {
          // password failed check
          return e.getMessage();
        }



        return "";
    }

    public String getPasswordRequirementsAsHtml(){
        StringBuffer out = new StringBuffer();


        out.append("Password is case sensitive. ");
        out.append("Spaces are not allowed. ");

        if (minPasswordCharacters>0){
            out.append("Password must be at least " + minPasswordCharacters + " and less than 50 characters in length. ");
        } else {
            out.append("Password must less than 50 characters in length. ");
        }

        if (minPasswordUpperCaseChars>0){
            out.append("Password must contain at least " + minPasswordUpperCaseChars + " upper case characters. ");
        }

        if (minPasswordLowerCaseChars>0){
            out.append("Password must contain at least " + minPasswordLowerCaseChars + " lower case characters. ");
        }

        if (minPasswordSpecialChars>0){
            out.append("Password must contain at least " + minPasswordSpecialChars + " non-alphanumeric characters (like !, &, -). ");
        }

        if (minPasswordNumericChars>0){
            out.append("Password must contain at least " + minPasswordNumericChars + " numbers. ");
        }



        return out.toString();
    }



}
