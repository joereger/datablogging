package reger;

/**
 * Renders locations as html
 */
public class LocationRenderHtml {


    public static String getHtmlForEntryPageTable(Location locOfEntry, boolean displayasadmin, String disabledFormText, UserSession userSession){
        //reger.core.Util.debug(5, "LocationRenderHtml.getHtmlForEntryPageTable()");
        //reger.core.Util.debug(5, "LocationRenderHtml.getHtmlForEntryPageTable()<br>locOfEntry.getLocationname()" + locOfEntry.getLocationname());
        StringBuffer mb = new StringBuffer();
        mb.append("<tr>");
        mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader>");
        mb.append("<font face=arial size=-1><b>Location:</b></font>");
        if (displayasadmin) {
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("<b>");
            mb.append("Track the physical location of your entries to get maps of your travels.");
            mb.append("<br><br>");
            mb.append("Choose from a previously created location or enter a new one.  Only Location Name is required... all other fields are optional.");
            mb.append("<br><br>");
            mb.append("<a href='entries-locations-edit.log'>");
            mb.append("View/Edit All Locations");
            mb.append("</a>");
            mb.append("</b>");
            mb.append("</font>");
        } else {
            if (locOfEntry!=null && locOfEntry.getLocationid()>0) {
                mb.append("<br>");
                mb.append("<font face=arial class=smallfont size=-2>");
                mb.append("<a href='locations.log?locationid="+locOfEntry.getLocationid()+"'>");
                mb.append("All Entries From This Location");
                mb.append("</a>");
                mb.append("</font>");
            } else {
                mb.append("<br>");
                mb.append("<font face=arial class=smallfont size=-2>");
                mb.append("<a href='locations.log'>");
                mb.append("All Locations");
                mb.append("</a>");
                mb.append("</font>");
            }
        }
        mb.append("</td>");
        mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 class=logentrycontent>");
        if (displayasadmin) {
            if (userSession!=null && userSession.getAccountuser()!=null && userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && locOfEntry!=null){
                //Get list of locations
                mb.append(getDropdown(Location.getLocationsUserCanView(userSession.getAccountuser(), userSession.getAccount()), disabledFormText, locOfEntry.getLocationid(), "Not Specified/New Location", false));
                mb.append("<br>");
                //End get list of locations
            }
        }

        //Output the current location
        if (displayasadmin){
            mb.append(getSingleLocationAsHtml(new Location(0), displayasadmin, disabledFormText));
            //mb.append(getSingleLocationAsHtml(locOfEntry, displayasadmin, disabledFormText));
        } else{
            mb.append(getSingleLocationAsHtml(locOfEntry, displayasadmin, disabledFormText));
        }



        mb.append("</td>");
        mb.append("</tr>");

        return mb.toString();
    }

    public static String getSingleLocationAsHtml(Location loc, boolean displayasadmin, String disabledFormText){
        StringBuffer mb = new StringBuffer();

        if (loc==null){
            loc = new Location(0);
        }

        mb.append("<table cellspacing='2' cellpadding='2' border='0'>");

        //Location name
        mb.append("<tr>");
        mb.append("<td valign=bottom align=left colspan=3>");
        if (displayasadmin) {
            mb.append("<font face=arial size=-2><strong>Location Name</strong></font><br>");
            mb.append("<input type='text' name='locationname' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getLocationname())+"\" size=30 "+disabledFormText+" style=\"font-size: 10px;\">");
        } else {
            if (loc.getLocationid()>0){
                mb.append("<font face=arial class=smallfont size=-1>");
                mb.append("<a href='locations.log?locationid="+loc.getLocationid()+"'>");
                mb.append(loc.getLocationname());
                mb.append("</a>");
                mb.append("</font>");
            } else {
                mb.append("<font face=arial class=smallfont size=-1>Not Specified</font>");
            }
        }
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");

        //City
        mb.append("<td valign=bottom align=left>");
        if (displayasadmin || !loc.getCity().equals("")){
            mb.append("<font face=arial size=-2><strong>City</strong></font><br>");
        }
        if (displayasadmin) {
            mb.append("<input type='text' name='city' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getCity())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
        } else {
            if (loc.getLocationid()>0 && !loc.getCity().equals("")){
                mb.append("<font face=arial class=smallfont size=-1>");
                mb.append(loc.getCity());
                mb.append("</font>");
            }
        }
        mb.append("</td>");


        //State
        mb.append("<td valign=bottom align=left>");
        if (displayasadmin || !loc.getState().equals("")){
            mb.append("<font face=arial size=-2><strong>State</strong></font><br>");
        }
        if (displayasadmin) {
            mb.append("<input type='text' name='state' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getState())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
        } else {
            if (loc.getLocationid()>0 && !loc.getState().equals("")){
                mb.append("<font face=arial class=smallfont size=-1>");
                mb.append(loc.getState());
                mb.append("</font>");
            }
        }
        mb.append("</td>");

        //Country
        mb.append("<td valign=bottom align=left>");
        if (displayasadmin || !loc.getCountry().equals("")){
            mb.append("<font face=arial size=-2><strong>Country</strong></font><br>");
        }
        if (displayasadmin) {
            mb.append("<input type='text' name='country' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getCountry())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
        } else {
            if (loc.getLocationid()>0 && !loc.getCountry().equals("")){
                mb.append("<font face=arial class=smallfont size=-1>");
                mb.append(loc.getCountry());
                mb.append("</font>");
            }
        }
        mb.append("</td>");
        mb.append("</tr>");



        //Start GPS coords
        if (displayasadmin || loc.isGpsDataPresent()){
            mb.append("<tr>");
            mb.append("<td valign=top align=left><font face=arial size=-2><strong>GPS Latitude: </strong></font></td>");
            mb.append("<td valign=top align=left colspan=2>");
            if (displayasadmin) {
                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLatitude()+"' NAME='latitude' SIZE=16 style=\"font-size: 10px;\" "+disabledFormText+">");
            } else {
                mb.append("<font face=arial size=-1>"+loc.getLatitude()+"</font>");
            }
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("<tr>");
            mb.append("<td valign=top align=left><font face=arial size=-2><strong>GPS Longitude: </strong></font></td>");
            mb.append("<td valign=top align=left colspan=2>");
            if (displayasadmin) {
                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLongitude()+"' NAME='longitude' SIZE=16 style=\"font-size: 10px;\" "+disabledFormText+">");
            } else {
                mb.append("<font face=arial size=-1>"+loc.getLongitude()+"</font>");
            }
            mb.append("</td>");
            mb.append("</tr>");










//            mb.append("<tr>");
//            mb.append("<td valign=top align=left colspan=4><font face=arial size=-2><strong>GPS Latitude</strong></font></td>");
//            mb.append("</tr>");
//            mb.append("<tr>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLatdeg()+"' NAME='latdeg' SIZE=6 style=\"font-size: 10px;\" "+disabledFormText+"> &deg;<br><font face=arial size=-2>0 to 90<br>Degrees</FONT>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLatdeg()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE=TEXT VALUE='"+loc.getLatmin()+"' NAME='latmin' SIZE=5 style=\"font-size: 10px;\" "+disabledFormText+"> '<br><font face=arial size=-2>0 to 59<br>Minutes</font>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLatmin()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE=TEXT VALUE='"+loc.getLatsec()+"' NAME='latsec' SIZE=5 style=\"font-size: 10px;\" "+disabledFormText+"> \"<br><font face=arial size=-2>0 to 9999<br>Seconds</font>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLatsec()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<SELECT NAME='latns' SIZE=1 style=\"font-size: 10px;\" "+disabledFormText+">");
//                mb.append("<OPTION VALUE='0' ");
//                if (loc.getLatns()==Location.NORTH) {
//                    mb.append("selected");
//                }
//                mb.append(">N");
//                mb.append("<OPTION VALUE='1' ");
//                if (loc.getLatns()==Location.SOUTH) {
//                    mb.append("selected");
//                }
//                mb.append(">S");
//                mb.append("</SELECT>");
//                mb.append("<br><font face=arial size=-2>Hemisphere</font>");
//            } else {
//                if (loc.getLatns()==0) {
//                    mb.append("<font face=arial size=-2>N</font>");
//                }
//                if (loc.getLatns()==1) {
//                    mb.append("<font face=arial size=-2>S</font>");
//                }
//            }
//            mb.append("</td>");
//            mb.append("</tr>");
//            mb.append("<tr>");
//            mb.append("<td valign=top align=left colspan=4><font face=arial size=-2><strong>GPS Longitude</strong></font></td>");
//            mb.append("</tr>");
//            mb.append("<tr>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLondeg()+"' NAME='londeg' SIZE=6 style=\"font-size: 10px;\" "+disabledFormText+"> &deg;<br><font face=arial size=-2>0 to 180<br>Degrees</FONT>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLondeg()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE=TEXT VALUE='"+loc.getLonmin()+"' NAME='lonmin' SIZE=5 style=\"font-size: 10px;\" "+disabledFormText+"> '<br><font face=arial size=-2>0 to 59<br>Minutes</font>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLonmin()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE=TEXT VALUE='"+loc.getLonsec()+"' NAME='lonsec' SIZE=5 style=\"font-size: 10px;\" "+disabledFormText+"> \"<br><font face=arial size=-2>0 to 9999<br>Seconds</font>");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLonsec()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("<td valign=top align=left>");
//            if (displayasadmin) {
//                mb.append("<SELECT NAME='lonew' SIZE=1 style=\"font-size: 10px;\" "+disabledFormText+">");
//                mb.append("<OPTION VALUE='0' ");
//                if (loc.getLonew()==Location.WEST) {
//                    mb.append("selected");
//                }
//                mb.append(">W");
//                mb.append("<OPTION VALUE='1' ");
//                if (loc.getLonew()==Location.EAST) {
//                    mb.append("selected");
//                }
//                mb.append(">E");
//                mb.append("</SELECT>");
//                mb.append("<br><font face=arial size=-2>Hemisphere</font>");
//            } else {
//                if (loc.getLonew()==0) {
//                    mb.append("<font face=arial size=-2>W</font>");
//                }
//                if (loc.getLonew()==1) {
//                    mb.append("<font face=arial size=-2>E</font>");
//                }
//            }
//            mb.append("</td>");
//            mb.append("</tr>");
        }
        //End gps coords

        mb.append("</table>");

        if (displayasadmin) {
                mb.append("<br>");
                mb.append("<font face=arial size=-2><strong>");
                mb.append("Enter GPS coordinates in any of the following formats:<br>");
                mb.append("DD.DD, DD:MM.MM(N|S|E|W), DD:MM:SS.SS(N|S|E|W)");
                mb.append("</strong></font>");
            }

        return mb.toString();
    }

    public static String getDropdown(Location[] locations, String disabledFormText, int activeLocationid, String noneSelectedText, boolean showOnlyLocationsWithValidGPSCoords){
        StringBuffer mb = new StringBuffer();
        mb.append("<select name='locationid' "+disabledFormText+">");
        if (activeLocationid<=0){
            mb.append("<option value='0' selected>"+noneSelectedText+"</option>");
        } else {
            mb.append("<option value='0'>"+noneSelectedText+"</option>");
        }
        for (int i = 0; i < locations.length; i++) {
            Location location = locations[i];
            if (!showOnlyLocationsWithValidGPSCoords || (location.getLongitude()>0 || location.getLatitude()>0)){
                if (activeLocationid==location.getLocationid()){
                    mb.append("<option value='"+ location.getLocationid() +"' selected>");
                    mb.append(location.getLocationname());
                    if (location.getLatitude()!=0){
                        mb.append(" (Lat: "+location.getLatitude()+")");
                    }
                    if (location.getLongitude()!=0){
                        mb.append(" (Lon: "+location.getLongitude()+")");
                    }
                    mb.append("</option>");
                } else {
                    mb.append("<option value='"+ location.getLocationid() +"' >");
                    mb.append(location.getLocationname());
                    mb.append("</option>");
                }
            }
        }
        mb.append("</select>");
        return mb.toString();
    }









}
