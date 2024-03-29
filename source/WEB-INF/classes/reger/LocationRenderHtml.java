package reger;

/**
 * Renders locations as html
 */
public class LocationRenderHtml {


    public static String getHtmlForEntryPageTable(Location locOfEntry, boolean displayasadmin, String disabledFormText, UserSession userSession){
        //reger.core.Util.debug(5, "LocationRenderHtml.getHtmlForEntryPageTable()");
        //reger.core.Util.debug(5, "LocationRenderHtml.getHtmlForEntryPageTable()<br>locOfEntry.getLocationname()" + locOfEntry.getLocationname());
        StringBuffer mb = new StringBuffer();
        mb.append("<div class=\"row\">");
        mb.append("<div class=\"col-md-2\">");
        if (displayasadmin) {

            mb.append("<strong>Location</strong>");
        } else {
            if (locOfEntry!=null && locOfEntry.getLocationid()>0) {
//                mb.append("<br>");
//                mb.append("<font face=arial class=smallfont size=-2>");
//                mb.append("<a href='locations.log?locationid="+locOfEntry.getLocationid()+"'>");
//                mb.append("All Entries From This Location");
//                mb.append("</a>");
//                mb.append("</font>");
            } else {
//                mb.append("<br>");
//                mb.append("<font face=arial class=smallfont size=-2>");
//                mb.append("<a href='locations.log'>");
//                mb.append("All Locations");
//                mb.append("</a>");
//                mb.append("</font>");
            }
        }
        mb.append("&nbsp;</div>");
        mb.append("<div class=\"col-md-10\">");

        if (displayasadmin) {
            if (userSession!=null && userSession.getAccountuser()!=null && userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0 && locOfEntry!=null){
                //Get list of locations
                mb.append(getDropdown(Location.getLocationsUserCanView(userSession.getAccountuser(), userSession.getAccount()), disabledFormText, locOfEntry.getLocationid(), "Not Specified/New Location", false));
                String locname = "";
                if (locOfEntry!=null){
                    locname = locOfEntry.getLocationname();
                }
                mb.append("<input type='text' name='locationname' maxlength='254' value=\""+reger.core.Util.cleanForHtml(locname)+"\" size=30 "+disabledFormText+" style=\"font-size: 10px;\">");
                //End get list of locations
            }
        }

        //Output the current location
        if (displayasadmin){
            mb.append(getSingleLocationAsHtml(new Location(0), displayasadmin, disabledFormText));
        } else{
            mb.append(getSingleLocationAsHtml(locOfEntry, displayasadmin, disabledFormText));
        }



        mb.append("</div>");
        mb.append("</div>");

        return mb.toString();
    }

    public static String getSingleLocationAsHtml(Location loc, boolean displayasadmin, String disabledFormText){
        StringBuffer mb = new StringBuffer();

        if (loc==null){
            loc = new Location(0);
        }

        mb.append("<div class=\"row\">");
        mb.append("<div class=\"col-md-2\">");


        if (displayasadmin) {


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
        mb.append("</div>");
        mb.append("<div class=\"col-md-10\">");


//        mb.append("<tr>");
//
//        //City
//        mb.append("<td valign=bottom align=left>");
//        if (displayasadmin || !loc.getCity().equals("")){
//            mb.append("<font face=arial size=-2><strong>City</strong></font><br>");
//        }
//        if (displayasadmin) {
//            mb.append("<input type='text' name='city' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getCity())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
//        } else {
//            if (loc.getLocationid()>0 && !loc.getCity().equals("")){
//                mb.append("<font face=arial class=smallfont size=-1>");
//                mb.append(loc.getCity());
//                mb.append("</font>");
//            }
//        }
//        mb.append("</td>");
//
//
//        //State
//        mb.append("<td valign=bottom align=left>");
//        if (displayasadmin || !loc.getState().equals("")){
//            mb.append("<font face=arial size=-2><strong>State</strong></font><br>");
//        }
//        if (displayasadmin) {
//            mb.append("<input type='text' name='state' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getState())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
//        } else {
//            if (loc.getLocationid()>0 && !loc.getState().equals("")){
//                mb.append("<font face=arial class=smallfont size=-1>");
//                mb.append(loc.getState());
//                mb.append("</font>");
//            }
//        }
//        mb.append("</td>");
//
//        //Country
//        mb.append("<td valign=bottom align=left>");
//        if (displayasadmin || !loc.getCountry().equals("")){
//            mb.append("<font face=arial size=-2><strong>Country</strong></font><br>");
//        }
//        if (displayasadmin) {
//            mb.append("<input type='text' name='country' maxlength='254' value=\""+reger.core.Util.cleanForHtml(loc.getCountry())+"\" size=6 "+disabledFormText+" style=\"font-size: 10px;\">");
//        } else {
//            if (loc.getLocationid()>0 && !loc.getCountry().equals("")){
//                mb.append("<font face=arial class=smallfont size=-1>");
//                mb.append(loc.getCountry());
//                mb.append("</font>");
//            }
//        }
//        mb.append("</td>");
//        mb.append("</tr>");



        //Start GPS coords
//        if (displayasadmin || loc.isGpsDataPresent()){
//            mb.append("<tr>");
//            mb.append("<td valign=top align=left><font face=arial size=-2><strong>GPS Latitude: </strong></font></td>");
//            mb.append("<td valign=top align=left colspan=2>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLatitude()+"' NAME='latitude' SIZE=16 style=\"font-size: 10px;\" "+disabledFormText+">");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLatitude()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("</tr>");
//
//            mb.append("<tr>");
//            mb.append("<td valign=top align=left><font face=arial size=-2><strong>GPS Longitude: </strong></font></td>");
//            mb.append("<td valign=top align=left colspan=2>");
//            if (displayasadmin) {
//                mb.append("<INPUT TYPE='TEXT' VALUE='"+loc.getLongitude()+"' NAME='longitude' SIZE=16 style=\"font-size: 10px;\" "+disabledFormText+">");
//            } else {
//                mb.append("<font face=arial size=-1>"+loc.getLongitude()+"</font>");
//            }
//            mb.append("</td>");
//            mb.append("</tr>");
//
//            if (displayasadmin) {
////                mb.append(reger.core.Util.popup());
////
////                mb.append("<tr>");
////                mb.append("<td valign=top align=left><font face=arial size=-2><strong></strong></font></td>");
////                mb.append("<td valign=top align=left colspan=2>");
////                mb.append("<a href='../entry-googlemaps-chooselatlon.log' onclick=\"javascript:NewWindow(this.href,'name','700','600','yes');return false;\">");
////                mb.append("<font face=arial size=-2><strong>Find Coordinates Easily on a Map</strong></font>");
////                mb.append("</a>");
////                mb.append("</td>");
////                mb.append("</tr>");
//            }










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
//        }
        //End gps coords

        mb.append("</div>");
        mb.append("</div>");

        if (displayasadmin) {
//                mb.append("<br>");
//                mb.append("<font face=arial size=-2><strong>");
//                mb.append("Enter GPS coordinates in any of the following formats:<br>");
//                mb.append("DD.DD, DD:MM.MM(N|S|E|W), DD:MM:SS.SS(N|S|E|W)");
//                mb.append("</strong></font>");
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
