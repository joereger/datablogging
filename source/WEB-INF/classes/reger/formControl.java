package reger;

import reger.core.db.Db;

import java.util.*;

/**
 * General radios and other form controls.
 */
public class formControl {

    public static StringBuffer simpleSelect(TreeMap selectoptions, String currentvalue, String fieldname){
        StringBuffer sb=new StringBuffer();

        sb.append("<SELECT name='"+ fieldname +"' size=1>");

        for (Iterator i=selectoptions.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            sb.append("<OPTION value=\""+ e.getKey() +"\" ");
            if (e.getKey().equals(currentvalue)) {
                sb.append("selected");
            }
            sb.append(">"+ reger.core.Util.cleanForHtml(String.valueOf(e.getValue())) +"</OPTION>");
        }

        sb.append("</SELECT>");

        return sb;
    }




    public static StringBuffer radioList(TreeMap radios, String currentvalue, String fieldname, String orientation) {
        StringBuffer sb=new StringBuffer();

        if (orientation.equals("horizontal")) {
            sb.append("<table align='left' cellspacing='1' cellpadding='1' border='0'><tr>");
        }



        for (Iterator i=radios.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            if (orientation.equals("horizontal")) {
                sb.append("<td valign=top>");
            }

            sb.append("<input type='radio' name=\""+ fieldname +"\" value=\""+ e.getKey() +"\" ");
            if (e.getKey().equals(currentvalue)) {
                sb.append("checked");
            }

            sb.append("><font face=arial size=-1> " + e.getValue() + "</font>");

            if (orientation.equals("vertical")) {
                sb.append("<br>");
            }

            if (orientation.equals("horizontal")) {
                sb.append("</td>");
            }
        }

        if (orientation.equals("horizontal")) {
            sb.append("</tr></table>");
        }

        return sb;
}





    public static StringBuffer dropdownFixedNumberRange(int minnumber, int maxnumber, int stepbetween, TreeMap labels, String currentvalue, String fieldname){

        StringBuffer sb = new StringBuffer();
        sb.append("<select name='"+ fieldname +"' size='1'>");

        int count=minnumber;
        String labeltext="";

        while (count<=maxnumber){

            sb.append("<option value=\"" + count + "\"");
            if (count==Integer.parseInt(currentvalue)) {
                sb.append(" selected");
            }

            //Get the labels
            if (labels.containsKey(String.valueOf(count))) {
                labeltext=" " + labels.get(String.valueOf(count));
            } else {
                labeltext="";
            }

            sb.append(">" + count + labeltext +"</option>");

            count=count+stepbetween;

        }

        return sb;
    }



    public static StringBuffer dropdownWithAddnewInput(String fieldname, String tablename, TreeMap dropdownlist, String currentvaluedropdown, int logid, int accountid){

        StringBuffer sb = new StringBuffer();
        sb.append("<select name='"+ fieldname +"' size='1'>");

        //-----------------------------------
        //-----------------------------------
        String[][] rstDropdownlist= Db.RunSQL("SELECT DISTINCT " + fieldname + " FROM event," + tablename + " WHERE event.logid='"+ logid +"' AND event.accountid='"+ accountid +"' AND event.eventid=" + tablename + ".eventid AND "+reger.Entry.sqlOfLiveEntry+"");
        //-----------------------------------
        //-----------------------------------
        if (rstDropdownlist!=null && rstDropdownlist.length>0){
        	for(int i=0; i<rstDropdownlist.length; i++){
        		dropdownlist = processFromDb(rstDropdownlist[i][0], currentvaluedropdown, dropdownlist);
        	}
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstDropdownlistdefaults= Db.RunSQL("SELECT DISTINCT " + fieldname + " FROM " + tablename + "default WHERE logid='"+ logid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstDropdownlistdefaults!=null && rstDropdownlistdefaults.length>0){
        	for(int i=0; i<rstDropdownlistdefaults.length; i++){
        		dropdownlist = processFromDb(rstDropdownlistdefaults[i][0], currentvaluedropdown, dropdownlist);
        	}
        }

        //Output the list to html
        for (Iterator i=dropdownlist.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            sb.append("<option value=\"" + reger.core.Util.cleanForHtml(String.valueOf(e.getKey())) + "\"");
            if (e.getValue().equals("selected")) {
                sb.append(" selected");
            }
            sb.append(">" + reger.core.Util.cleanForHtml(String.valueOf(e.getKey())) + "</option>");
        }

        sb.append("</select>");

        return sb;
    }

    public static TreeMap processFromDb(String fieldfromdb, String currentvaluedropdown, TreeMap dropdownlist) {
        //Make sure this doesn't already exist in the list
        if (dropdownlist.containsKey(fieldfromdb)==false) {
            if (fieldfromdb == currentvaluedropdown) {
                //Turn off all entries marked as selected
                dropdownlist=turnoffallselected(dropdownlist);
                //And add this one as selected
                dropdownlist.put(fieldfromdb,"selected");
            } else {
                dropdownlist.put(fieldfromdb,"off");
            }
        //The list already has this key
        } else {
            if (fieldfromdb == currentvaluedropdown) {
                if (dropdownlist.get(fieldfromdb).equals("selected")) {
                    //Turn off all entries marked as selected
                    dropdownlist=turnoffallselected(dropdownlist);
                    //Then remove this one and add it back
                    dropdownlist.remove(fieldfromdb);
                    dropdownlist.put(fieldfromdb,"selected");
                }
            }
        }
        return dropdownlist;
    }

    public static TreeMap turnoffallselected(TreeMap inHash) {
        //Turn off any options that are currently selected
        String tempholdkey="";
        int count=1;
        while (count>0){

            count=0;

            for (Iterator i=inHash.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry e = (Map.Entry) i.next();
                if (e.getValue().equals("selected")) {
                    count=count+1;
                    tempholdkey=String.valueOf(e.getKey());
                }
            }

            inHash.remove(tempholdkey);
            inHash.put(tempholdkey,"off");

            count=count-1;
        }
        return inHash;
    }







}
