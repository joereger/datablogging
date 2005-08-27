package reger;

/**
 *
 */
public class MegaHtmlFormJscalendar {

    //This needs to be added before the form that the calendar updates
    public static StringBuffer scriptHtmlSetup(String pathToAppRoot, String initialDate){
        StringBuffer mb = new StringBuffer();

        mb.append("<!-- calendar stylesheet -->" + "\n");
        mb.append("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\""+pathToAppRoot+"js/jscalendar/calendar-win2k-cold-1.css\" title=\"win2k-cold-1\" />" + "\n");

        mb.append("<!-- main calendar program -->" + "\n");
        mb.append("<script type=\"text/javascript\" src=\""+pathToAppRoot+"js/jscalendar/calendar.js\"></script>" + "\n");

        mb.append("<!-- language for the calendar -->" + "\n");
        mb.append("<script type=\"text/javascript\" src=\""+pathToAppRoot+"js/jscalendar/lang/calendar-en.js\"></script>" + "\n");

        mb.append("<!-- the following script defines the Calendar.setup helper function, which makes adding a calendar a matter of 1 or 2 lines of code. -->" + "\n");
        mb.append("<script type=\"text/javascript\" src=\""+pathToAppRoot+"js/jscalendar/calendar-setup.js\"></script>" + "\n");


        //mb.append("<form action=\"#\" method=\"get\" style=\"visibility: hidden\">" + "\n");
        //mb.append("<form action=\"#\" method=\"get\">" + "\n");
        mb.append("<input type=\"hidden\" name=\"date\" id=\"f_date_a\" value=\""+initialDate+"\"/>" + "\n");
        //mb.append("</form>" + "\n");

        return mb;
    }

    //This needs to be called after the form fields that need to be edited are presented
    public static StringBuffer theScript(reger.pageFramework.PageProps pageProps){
        StringBuffer mb = new StringBuffer();

          mb.append("<script type=\"text/javascript\">" + "\n");
            mb.append("function catcalc(cal) {" + "\n");
                mb.append("var date = cal.date;" + "\n");
                mb.append("var time = date.getTime()" + "\n");
                mb.append("var jField" + "\n");
                mb.append("//Day" + "\n");
                mb.append("jField = document.getElementById(\"j_dd\");" + "\n");
                mb.append("jField.selectedIndex = date.getDate()-1;" + "\n");
                mb.append("//Month" + "\n");
                mb.append("jField = document.getElementById(\"j_mm\");" + "\n");
                mb.append("jField.selectedIndex = date.getMonth();" + "\n");
                mb.append("//Year" + "\n");
                mb.append("jField = document.getElementById(\"j_yyyy\");" + "\n");
                mb.append("jField.selectedIndex = date.print(\"%Y\")-1900;" + "\n");
                mb.append("//Hour" + "\n");
                mb.append("jField = document.getElementById(\"j_h\");" + "\n");
                mb.append("jField.selectedIndex = date.print(\"%l\") - 1;" + "\n");
                mb.append("//Minute" + "\n");
                mb.append("jField = document.getElementById(\"j_m\");" + "\n");
                mb.append("jField.selectedIndex = date.print(\"%M\");" + "\n");
                mb.append("//AM/PM" + "\n");
                mb.append("jField = document.getElementById(\"j_ampm\");" + "\n");
                mb.append("if (date.print(\"%p\")==\"AM\"){" + "\n");
                    mb.append("jField.selectedIndex = 0;" + "\n");
                mb.append("} else {" + "\n");
                    mb.append("jField.selectedIndex = 1;" + "\n");
                mb.append("}" + "\n");
            mb.append("}" + "\n");

            mb.append("Calendar.setup({" + "\n");
                mb.append("inputField     :    \"f_date_a\",   // id of the input field" + "\n");
                mb.append("ifFormat       :    \"%Y-%m-%d %l:%M %p\",   // format of the input field" + "\n");
                mb.append("showsTime      :    true," + "\n");
                mb.append("weekNumbers    :    false," + "\n");
                mb.append("singleClick    :    false," + "\n");
                mb.append("button         :    \"f_trigger_a\"," + "\n");
                mb.append("timeFormat     :    \"12\"," + "\n");
                mb.append("onUpdate       :    catcalc" + "\n");
            mb.append("});" + "\n");

        mb.append("</script> " + "\n");

        return mb;
    }

}
