package reger.marketingSite;


public class SignupProgressBar {

    public static StringBuffer getBar(int currentstep){
        StringBuffer mb = new StringBuffer();

        int width=33;
        boolean ison=false;
        String helpertext = "";

        mb.append("<table cellpadding=15 align=center cellspacing=3 bgcolor=#ffffff border=0>");

        mb.append("<tr>");


        if (currentstep==1){
            ison=true;
            helpertext = "Choose which log type to start with.  It'll be easy to add more later.";
        } else {
            ison=false;
        }
        mb.append(tab("Step 1", "Choose a Log Type", width, ison, "signup.log"));


        if (currentstep==2){
            ison=true;
            helpertext = "Make sure you remember your account information so that you can log in.";
        } else {
            ison=false;
        }
        mb.append(tab("Step 2", "Login or Create an Account", width, ison, ""));

        if (currentstep==3){
            ison=true;
            helpertext = "";
        } else {
            ison=false;
        }
        mb.append(tab("Step 3", "Start Blogging!", width, ison, ""));


        mb.append("</tr>");


//        if (!helpertext.equals("")){
//            mb.append("<tr>");
//            mb.append("<td bgcolor=#ffffff colspan=2>");
//            mb.append("<font face=arial size=-2>");
//            mb.append(helpertext);
//            mb.append("</font>");
//            mb.append("</td>");
//            mb.append("</tr>");
//        }

        mb.append("</table> ");

        return mb;
    }

    public static StringBuffer tab(String boldtext, String desc, int width, boolean ison, String url){
        StringBuffer mb = new StringBuffer();

        if (ison){
            mb.append("<td valign=top align=middle width="+width+"% bgcolor=#ffffff>");
            mb.append("<font face=arial size=-1>");
            mb.append("<strong>");
            if (!url.equals("")){
                mb.append("<a href='"+url+"'>");
            }
            mb.append(" >> " + boldtext + "&lt;&lt;");
            if (!url.equals("")){
                mb.append("</a>");
            }
            mb.append("</strong>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append(desc);
            mb.append("</font>");
            mb.append("</td>");
        } else {
            mb.append("<td valign=top align=middle width="+width+"% bgcolor=#ffffff>");
            mb.append("<font face=arial size=-1>");
            mb.append("<strong>");
            if (!url.equals("")){
                mb.append("<a href='"+url+"'>");
            }
            mb.append(boldtext);
            if (!url.equals("")){
                mb.append("</a>");
            }
            mb.append("</strong>");
            mb.append("</font>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append(desc);
            mb.append("</font>");
            mb.append("</td>");
        }

        return mb;
    }


}
