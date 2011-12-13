package reger;

import reger.core.db.Db;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;

/**
 *
 */
public class ImageListHtml {

    public static StringBuffer tableStart() {
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td bgcolor=#333333>");
        mb.append("<table cellpadding=10 cellspacing=1 width=100% border=0>");
        return mb;
    }

    public static String sqlBuilder(boolean getOnlyCountOfRecords, reger.UserSession userSessionOfViewer, int accountid, int tagid, int eventid, boolean displayOnlyImagesFromLiveEntries, boolean onlyDisplayImagesWithNoTag, boolean returnOnlyOneRecordAtRandom, String entrykey) {

        //Entrykeysql logic
        //The main goal of this logic is to grant the user access to this log's image.
        //But I must be careful to make sure that as I grant access to this log
        //I don't overgrant.  To keep thinks secure I make certain that an eventid is present.
        //This guarantees that I'm only granting access to this one event's images.
        String entryKeySql = "";
        //If I have an entrykey and I have an eventid
        if (!entrykey.equals("") && eventid > 0) {
            //Is the entrykey valid for this event?
            if (reger.Entry.checkEntryKey(entrykey, eventid)) {
                //At this point I know that the entrykey is valid and I know that a single event is being displayed
                //To Build the entrykey sql I need to find the logid
                int logidToGrantAccessTo = reger.core.Util.getLogidFromEventid(eventid, userSessionOfViewer.getAccount().getAccountid());
                //So now I can build the proper SQL
                entryKeySql = " OR (megalog.logid='" + logidToGrantAccessTo + "') ";
            }
        }

        String sqlSelect = "SELECT DISTINCT image.imageid, description, title, title, event.eventid, date, originalfilename, image.sizeinbytes, megalog.logid, image.image, image.filename ";

        String sqlSelectCount = "SELECT count(*) ";

        String sqlFrom = " FROM event, megalog, image ";
        if (tagid > 0 || onlyDisplayImagesWithNoTag) {
            sqlFrom = " FROM event, megalog, image " +
                    " LEFT JOIN tagimagelink ON image.imageid=tagimagelink.imageid ";
        }

        String sqlWhere = "WHERE image.eventid=event.eventid AND event.logid=megalog.logid AND ((" + userSessionOfViewer.getAccountuser().LogsUserCanViewQueryend(accountid) + ") " + entryKeySql + ") ";

        String sqlEventid = "";
        if (eventid > 0) {
            sqlEventid = " AND event.eventid='" + eventid + "' ";
        }

        String sqlAccountid = "";
        if (accountid > 0) {
            sqlAccountid = " AND event.accountid='" + accountid + "' ";
        }


        String sqlImagetagid = "";
        if (tagid > 0 || onlyDisplayImagesWithNoTag) {
            sqlImagetagid = " AND tagimagelink.tagid='" + tagid + "' ";
            if (onlyDisplayImagesWithNoTag) {
                sqlImagetagid = " AND tagimagelink.tagimagelinkid IS NULL ";
            }
        }

        String sqlLiveEntry = "";
        if (displayOnlyImagesFromLiveEntries) {
            sqlLiveEntry = " AND " + reger.Entry.sqlOfLiveEntry + " ";
        }

        String sqlOrderBy = " ORDER BY date DESC, imageorder ASC, imageid ASC";
        if (returnOnlyOneRecordAtRandom) {
            sqlOrderBy = " ORDER BY RAND() LIMIT 0,1";
        }

        //Put the string together
        String out = "";
        if (getOnlyCountOfRecords) {
            out = sqlSelectCount + sqlFrom + sqlWhere + sqlEventid + sqlAccountid + sqlImagetagid + sqlLiveEntry;
        } else {
            out = sqlSelect + sqlFrom + sqlWhere + sqlEventid + sqlAccountid + sqlImagetagid + sqlLiveEntry + sqlOrderBy;
        }

        Debug.debug(5, "", "ImageListHtml.sqlBuilder<br>" + out);
        return out;
    }

    public static StringBuffer htmlOut(int accountid, int eventid, int tagid, boolean displayasadmin, UserSession userSessionOfPersonViewing, int currentpage, int perpage, HttpServletRequest request) {
        if (displayasadmin) {
            return htmlOutAdmin(accountid, eventid, tagid, userSessionOfPersonViewing, currentpage, perpage, request);
        }  else {
            return htmlOutDisplay(accountid, eventid, tagid, userSessionOfPersonViewing, currentpage, perpage, request);
        }
    }

    public static StringBuffer htmlOutAdmin(int accountid, int eventid, int tagid, UserSession userSessionOfPersonViewing, int currentpage, int perpage, HttpServletRequest request) {
        StringBuffer mb = new StringBuffer();

        //Entrykey
        String entrykey = "";
        if (request.getParameter("entrykey") != null) {
            entrykey = request.getParameter("entrykey");
        }
        String entrykeyQueryString = "";
        if (request.getParameter("entrykey") != null) {
            entrykeyQueryString = "&entrykey=" + request.getParameter("entrykey");
        }

        //If this is not displayasadmin, only show images from live entries
        boolean displayOnlyImagesFromLiveEntries = false;

        //Make sure we're not in admin mode just about to create an entry
        if (eventid>0) {
            //Start paging
            //reger.core.Util.logtodb(sqlSelectCount+sqlFrom+sqlWhere+sqlEventid+sqlImagetagid+sqlLiveEntry);
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount = Db.RunSQL(sqlBuilder(true, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey));
            //-----------------------------------
            //-----------------------------------
            int recordcount = 0;
            if (rstCount != null && rstCount.length > 0) {
                recordcount = Integer.parseInt(rstCount[0][0]);
            }

            //reger.core.Util.logtodb("ImageListHtml.java - recordcount=" + recordcount);

            if (currentpage < 0) {
                currentpage = 1;
            }

            if (perpage <= 0) {
                perpage = 500;
            }

            if (eventid <= 0) {
                //This is not an entry display so page out.
                perpage = 50;
            }

            StringBuffer pagingOut = new StringBuffer();
            if (recordcount > perpage) {
                pagingOut.append("<tr>");
                pagingOut.append("<td colspan=4>");
                pagingOut.append(reger.pagingLinkPrint.getHtml(recordcount, currentpage, perpage, request));
                pagingOut.append("</td>");
                pagingOut.append("</tr>");
                //And finally put it on the page
                mb.append(pagingOut);
            }
            //Limit vars
            int limitMin = (currentpage * perpage) - perpage;
            int limitMax = perpage;
            String sqlLimit = " LIMIT " + limitMin + "," + limitMax;

            //End paging

            //Add the popup javascript
            mb.append(reger.core.Util.popup());

            //reger.core.Util.logtodb(sqlSelect+sqlFrom+sqlWhere+sqlEventid+sqlImagetagid+sqlLiveEntry+sqlOrderBy);
            //-----------------------------------
            //-----------------------------------
            String[][] rstImagelist = reger.core.db.Db.RunSQL(sqlBuilder(false, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey) + sqlLimit);
            //-----------------------------------
            //-----------------------------------
            if (rstImagelist != null) {
                for (int i = 0; i < rstImagelist.length; i++) {
                    String mediaoutPath = "";
                    mb.append("<!-- Begin individual image listing -->");
                    mb.append("<tr>");
                    mb.append("<td valign=middle align=center bgcolor=#cccccc>");
                    mb.append("<table cellpadding=0 cellspacing=0 border=0>");
                    mb.append("<tr>");
                    mb.append("<td valign=top align=center>");
                    mb.append("<font face=arial size=-2 style=\"font-size: 10px;\" color=#999999>");
                    mb.append("<b>Move<br>Up<br></b>");
                    mb.append("</font>");
                    mb.append("<input type=radio name=imageid-" + rstImagelist[i][0] + "-move value=up>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<tr>");
                    mb.append("<td valign=top align=center>");
                    mb.append("<input type=radio name=imageid-" + rstImagelist[i][0] + "-move value=stay checked>");
                    mb.append("");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<tr>");
                    mb.append("<td valign=top align=center>");
                    mb.append("<input type=radio name=imageid-" + rstImagelist[i][0] + "-move value=down>");
                    mb.append("<font face=arial size=-2 style=\"font-size: 10px;\" color=#999999>");
                    mb.append("<b><br>Move<br>Down</b>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("</table>");
                    mb.append("</td>");
                    mb.append("<td valign=middle align=center bgcolor=#cccccc colspan=2>");

                    mediaoutPath = "../";

                    mb.append("<a href='" + mediaoutPath + "mediaouthtml.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + entrykeyQueryString + "' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
                    mb.append("<img src='" + mediaoutPath + "mediaout.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + "&isthumbnail=yes" + entrykeyQueryString + "' border=0></a>");
                    if (userSessionOfPersonViewing.getAccountuser().getEntrymode()==reger.Vars.ENTRYMODESIMPLE) {
                        mb.append("<br/><a href=\"javascript:appendImageTag("+rstImagelist[i][0]+")\"><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">Add to Entry</font></a>");
                    }
                    if (!rstImagelist[i][6].equals("")) {
                        mb.append("<br><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">" + FilenameUtils.getName(rstImagelist[i][10]) + "</font>");
                    }
                    if (!rstImagelist[i][7].equals("")) {
                        mb.append("<br><font face=arial size=-2 class=smallfont style=\"font-size: 9px;\">" + rstImagelist[i][7] + " bytes</font>");
                    }
                    mb.append("<br><input type='checkbox' name='delete-" + rstImagelist[i][0] + "' value='yes'> <font face=arial size=-2>Delete?</font>");
                    mb.append("</td>");
                    mb.append("<td valign=top bgcolor=#ffffff colspan=9>");
                    mb.append("<font face=arial size=-2>Optional Description:</font><br>");
                    mb.append("<textarea cols='30' rows='3' name='imagedescription-" + rstImagelist[i][0] + "' style='width: 100%;font: 10pt monospace'>" + reger.core.Util.cleanForHtml(rstImagelist[i][1]) + "</textarea>");

                    //Display the entry that this image came from
                    if (eventid <= 0) {
                        mb.append("<br><br>");
                        mb.append("<font face=arial size=-2 class=smallfont>");
                        String entryurl = reger.Entry.entryFileNameStatic(Integer.parseInt(rstImagelist[i][4]), rstImagelist[i][3]);
                        mb.append("From Entry:<br><a href='" + entryurl + "'>" + rstImagelist[i][3] + "</a>");
                        //@todo Display date/time in usertime with the image
                        //mb.append("<br>");
                        //mb.append(rstImagelist[i][5]);
                        mb.append("</font>");
                    }

                    //Image Keyword Tags
                    String imageTags = reger.Tag.getStringOfAllTagsForImage(Integer.parseInt(rstImagelist[i][0]));
                    mb.append("<br>");
                    String helpImagetags = Help.tip("Keyword Tags", "Keyword Tags help you organize and retrieve your files.  Type words that relate to the file.  For example: \"car outside oldsmobile\".  Separate keywords with a space.  Create multi-word tags with quotes (example: car \"blue interior\" oldsmobile.)", false, mediaoutPath);
                    mb.append("<font face=arial size=-2>Optional Keyword Tags " + helpImagetags + ":</font><br><input type='text' name='imagetag-" + rstImagelist[i][0] + "' value=\"" + reger.core.Util.cleanForHtml(imageTags) + "\" size='35' maxlength='254' style=\"font-size: 10px;\"><br>");



                    mb.append("</td>");
                    mb.append("</tr>");


                    mb.append("<!-- End individual image listing -->");
                }
            }

            //Paging footer
            if (recordcount > perpage) {
                mb.append(pagingOut);
            }
        }

        return mb;
    }

    public static StringBuffer htmlOutDisplay(int accountid, int eventid, int tagid, UserSession userSessionOfPersonViewing, int currentpage, int perpage, HttpServletRequest request) {
        StringBuffer mb = new StringBuffer();

        //Entrykey
        String entrykey = "";
        if (request.getParameter("entrykey") != null) {
            entrykey = request.getParameter("entrykey");
        }
        String entrykeyQueryString = "";
        if (request.getParameter("entrykey") != null) {
            entrykeyQueryString = "&entrykey=" + request.getParameter("entrykey");
        }

        //If this is not displayasadmin, only show images from live entries
        boolean displayOnlyImagesFromLiveEntries = true;


        //Make sure we're not in admin mode just about to create an entry
        if (eventid>0) {
            //Start paging
            //reger.core.Util.logtodb(sqlSelectCount+sqlFrom+sqlWhere+sqlEventid+sqlImagetagid+sqlLiveEntry);
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount = Db.RunSQL(sqlBuilder(true, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey));
            //-----------------------------------
            //-----------------------------------
            int recordcount = 0;
            if (rstCount != null && rstCount.length > 0) {
                recordcount = Integer.parseInt(rstCount[0][0]);
            }

            //reger.core.Util.logtodb("ImageListHtml.java - recordcount=" + recordcount);

            if (currentpage < 0) {
                currentpage = 1;
            }

            if (perpage <= 0) {
                perpage = 500;
            }

            if (eventid <= 0) {
                //This is not an entry display so page out.
                perpage = 50;
            }

            StringBuffer pagingOut = new StringBuffer();
            if (recordcount > perpage) {
                pagingOut.append("<tr>");
                pagingOut.append("<td colspan=4>");
                pagingOut.append(reger.pagingLinkPrint.getHtml(recordcount, currentpage, perpage, request));
                pagingOut.append("</td>");
                pagingOut.append("</tr>");
                //And finally put it on the page
                mb.append(pagingOut);
            }
            //Limit vars
            int limitMin = (currentpage * perpage) - perpage;
            int limitMax = perpage;
            String sqlLimit = " LIMIT " + limitMin + "," + limitMax;

            //End paging

            //Add the popup javascript
            mb.append(reger.core.Util.popup());

            mb.append("\n\n\n");
            mb.append("<!-- Begin Images Row -->");
            mb.append("<tr>");
            mb.append("<td valign=middle align=center colspan=12>");
            mb.append("<table cellpadding=10 cellspacing=0 border=0 width=\"100%\">");

            int currentCol = 1;
            int colsPerRow = 4;
            int widthPercent = 25;

            //reger.core.Util.logtodb(sqlSelect+sqlFrom+sqlWhere+sqlEventid+sqlImagetagid+sqlLiveEntry+sqlOrderBy);
            //-----------------------------------
            //-----------------------------------
            String[][] rstImagelist = reger.core.db.Db.RunSQL(sqlBuilder(false, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey) + sqlLimit);
            //-----------------------------------
            //-----------------------------------
            if (rstImagelist != null) {
                for (int i = 0; i < rstImagelist.length; i++) {
                    mb.append("\n");
                    if (currentCol==1){
                        mb.append("<tr>");
                    }

                    mb.append("<td valign=top class=imagecell width=\""+widthPercent+"%\">");
                    mb.append("<center>");
                    String mediaoutPath = "";
                    mb.append("<a href='" + mediaoutPath + "mediaouthtml.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + entrykeyQueryString + "' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
                    mb.append("<img src='" + mediaoutPath + "mediaout.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + "&isthumbnail=yes" + entrykeyQueryString + "' border=0>");
                    mb.append("</a>");
                    if (rstImagelist[i][1]!=null && rstImagelist[i][1].length()>0){
                        mb.append("<br/><font face=arial size=-1 class=normalfont>" + reger.core.Util.cleanForHtml(rstImagelist[i][1]) + "</font>");
                    }
                    String imageTags = reger.Tag.getStringOfAllTagsForImageAsLinks(Integer.parseInt(rstImagelist[i][0]), mediaoutPath);
                    if (!imageTags.equals("")) {
                        mb.append("<br/><font face=arial size=-2 class=smallfont>" + imageTags + "</font><br>");
                    }
                    mb.append("</center>");
                    mb.append("</td>");

                    if (currentCol==colsPerRow){
                        mb.append("</tr>");
                        currentCol = 1;
                    } else {
                        currentCol = currentCol + 1;
                    } 
                }
            }

            mb.append("</table>");
            mb.append("</td>");
            mb.append("</tr>");
            mb.append("<!-- End Images Row -->");
            mb.append("\n\n\n");

            //Paging footer
            if (recordcount > perpage) {
                mb.append(pagingOut);
            }
        }

        return mb;
    }


    public static StringBuffer tableEnd() {
        StringBuffer mb = new StringBuffer();
        mb.append("</table>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }

    public static StringBuffer getImageList(UserSession userSession, HttpServletRequest request, int imagesPerRow) {
        StringBuffer mb = new StringBuffer();

        int currentPage = 1;
        if (request.getParameter("currentImagePage") != null) {
            currentPage = reger.core.Util.getCurrentPage(request.getParameter("currentImagePage"));
            if (currentPage < 0) {
                currentPage = 1;
            }
        }
        int perPage = 50;
        //Limit vars
        int limitMin = (currentPage * perPage) - perPage;
        int limitMax = perPage;

        String tagSql = "";
        boolean isselectingtag = false;
        if (request.getParameter("tagid")!=null && reger.core.Util.isinteger(request.getParameter("tagid"))) {
            isselectingtag = true;
            tagSql += " AND tag.tagid='" + reger.core.Util.cleanForSQL(request.getParameter("tagid")) + "' ";
        } else {
            if (request.getParameter("tag")!=null){
                isselectingtag = true;
                tagSql = " AND tag.tag='" +reger.core.Util.cleanForSQL(request.getParameter("tag"))+ "' ";
            }
        }


        String fromSql = "FROM image, event, megalog ";
        String whereSql = "WHERE event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid(), true)+" AND image.eventid=event.eventid AND "+reger.Entry.sqlOfLiveEntry+" AND image.accountid='" + userSession.getAccount().getAccountid() + "'";
        if (isselectingtag){
            fromSql = " FROM image, tagimagelink, tag, event, megalog ";
            whereSql = " WHERE tagimagelink.tagid=tag.tagid AND image.imageid=tagimagelink.imageid AND event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid(), true)+" AND image.eventid=event.eventid "+tagSql+" AND "+reger.Entry.sqlOfLiveEntry+" AND image.accountid='" + userSession.getAccount().getAccountid() + "'";
        }



        reger.core.Debug.debug(5, "ImageListHtml.java", fromSql + whereSql);

        //-----------------------------------
        //-----------------------------------
        String[][] rstImageList = Db.RunSQL("SELECT DISTINCT image.imageid, image.image, image.description "+fromSql+whereSql+" ORDER BY event.date DESC, image.imageid ASC LIMIT " + limitMin +"," + limitMax);
        //-----------------------------------
        //-----------------------------------
        //-----------------------------------
        //-----------------------------------
        String[][] rstImageCount = Db.RunSQL("SELECT count(DISTINCT image.imageid) "+fromSql+whereSql);
        //-----------------------------------
        //-----------------------------------



        int recordcount = Integer.parseInt(rstImageCount[0][0]);
        mb.append("<table border=0 cellspacing=3 cellpadding=5>");
        mb.append("<tr>");
        StringBuffer pagingOut = new StringBuffer();
        if (recordcount > perPage) {
            pagingOut.append("<td colspan="+imagesPerRow+">");
            pagingOut.append(reger.pagingLinkPrint.getImagePageNumbers(recordcount,currentPage, perPage, request));
            pagingOut.append("</td>");
            //And finally put it on the page
            mb.append(pagingOut);
        }
        mb.append("</tr>");
        mb.append("<tr>");
        //End paging

        String mediaoutPath = "";
        if (rstImageList != null) {
            int imagesInCurrentRow = 0;
            for (int i = 0; i < rstImageList.length; i++) {
                if (imagesInCurrentRow % imagesPerRow == 0) {
                    mb.append("</tr>");
                    mb.append("<tr>");
                }
                mb.append("<td valign=top align=center bgcolor=#cccccc>");
                mb.append("<a href='" + mediaoutPath + "mediaouthtml.log?imageid=" + rstImageList[i][0] + "' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
                mb.append("<img src='" + mediaoutPath + "mediaout.log?imageid=" + rstImageList[i][0] + "&isthumbnail=yes" + "' border=0></a>");
                mb.append("</td>");
                imagesInCurrentRow ++;
            }
        }
        mb.append("</tr>");
        //Paging footer
        if (recordcount > perPage) {
            mb.append("<tr>");
            mb.append(pagingOut);
            mb.append("</tr>");
        }
        mb.append("</table>");

        return mb;
    }
}