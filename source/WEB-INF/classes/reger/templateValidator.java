package reger;

public class templateValidator {

    public static String validateBody(String instring){
        String errormessage="";

        //Check for Main.Body tag
        if (instring.split("\\<\\$Main.Body\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Main.Body.";
        }
        //End Check for Main.Body tag

        //Check for SideColumn tag
        if (instring.split("\\<\\$Side.Column\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Side.Column.";
        }
        //End Check for SideColumn tag

        //Check for a navbar tag tag
        if (instring.split("\\<\\$Navbar\\.(.|\\n)*?\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Navbar.*.";
        }
        //End Check for navbar tag

        return errormessage;
    }

    public static String validateEntry(String instring){
        String errormessage="";

        //Check for a Logentry.Title tag tag
        if (instring.split("\\<\\$Logentry\\.Title\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Logentry.Title.";
        }
        //End Check for Logentry.Title tag

        //Check for a Logentry.Url tag tag
        if (instring.split("\\<\\$Logentry\\.Url\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Logentry.Url.";
        }
        //End Check for Logentry.Url tag

        //Check for a Logentry.Body tag tag
        if (instring.split("\\<\\$Logentry\\.Body\\$\\>").length<=1) {
            errormessage = errormessage + "<br>Missing Logentry.Body.";
        }
        //End Check for Logentry.Body tag

        return errormessage;
    }

}
