package reger;

import reger.core.Debug;

public class navBars {



  public static StringBuffer preview(int isvertical, Accountuser accountUser, int accountid, int currentlogid, boolean showhometab, String hometabtext, boolean showlogintab, String currentpagename) {

    //Create the StringBuffer that will hold the navbar
    StringBuffer nb=new StringBuffer();

    try {



        if (hometabtext.equals("")) {
            hometabtext="Home";
        }



        //Declare vars
        String opentr;
        String closetr;
        String outopentr;
        String outclosetr;
        String flag;

        //Figure out whether or not we need the start and end <tr></tr> on the cell
        //opentr is for the TR/TR that can go on each button
        //outopentr is for the tr/tr that can go on horizontals
        //Vertical
        if (isvertical==1) {
            opentr="<tr>";
            closetr="</tr>";
            outopentr="";
            outclosetr="";

        } else {
            opentr="";
            closetr="";
            outopentr="<tr>";
            outclosetr="</tr>";
        }

        nb.append("<!-- start navigation--><table class=navigation cellpadding=0 cellspacing=0 width=100% border=0>" + outopentr);

        //Begin Home Tab
        //@todo The home tab and the login tab do not get highlighted. This is because scriptname is not being populated properly.
        if (currentpagename.indexOf("index.log")>0) {
            flag="on";
        } else {
            flag="off";
        }
        if (showhometab){
            if (hometabtext.equals("")){
                hometabtext="Home";
            }
            nb.append(opentr + "<td class=navcell" + flag + " align=left valign=top><a class=navfont" + flag + " href='index.log'>" + hometabtext + "</a></td>" + closetr);
        }
        //End Home Tab

        //SQL Query helper
        String logsusercanviewqueryend = "megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"'";
        if (accountUser!=null){
            logsusercanviewqueryend = accountUser.LogsUserCanViewQueryend(accountid);
        }


            //This is a preview so I should spoof some log names
            nb.append("<!-- Begin Tab -->");
            nb.append(opentr + "<td class=navcell"+ flag +" align=left valign=top><a class=navfont" + flag + " href='#'>My Swimming Log</a></td>" + closetr);
            nb.append("<!-- End Tab -->");
            nb.append("<!-- Begin Tab -->");
            nb.append(opentr + "<td class=navcell"+ flag +" align=left valign=top><a class=navfont" + flag + " href='#'>My Dream Log</a></td>" + closetr);
            nb.append("<!-- End Tab -->");
            nb.append("<!-- Begin Tab -->");
            nb.append(opentr + "<td class=navcell"+ flag +" align=left valign=top><a class=navfont" + flag + " href='#'>My Politics Log</a></td>" + closetr);
            nb.append("<!-- End Tab -->");
            nb.append("<!-- Begin Tab -->");
            nb.append(opentr + "<td class=navcell"+ flag +" align=left valign=top><a class=navfont" + flag + " href='#'>My Running Log</a></td>" + closetr);
            nb.append("<!-- End Tab -->");





        //Begin login tab
        if (showlogintab){
            //Determine the color of the tab
            if (currentpagename.indexOf("login.log")>0){
                flag="on";
            } else {
                flag="off";
            }
            nb.append(opentr + "<td class=navcell"+ flag +" align=left valign=top><a class=navfont" + flag + " href='login.log'>Login</a></td>" + closetr);
        }
        //End login tab

        //Close table
        nb.append(outclosetr + "</table><!-- end navigation -->");

    } catch (Exception e) {
        Debug.errorsave(e, "");
    }


    //Return the navbar as a StringBuffer
    return nb;
  }


}