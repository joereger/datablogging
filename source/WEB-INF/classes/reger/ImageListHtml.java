package reger;

import reger.cache.LogCache;
import reger.core.Util;
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
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount = Db.RunSQL(sqlBuilder(true, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey));
            //-----------------------------------
            //-----------------------------------
            int recordcount = 0;
            if (rstCount != null && rstCount.length > 0) {
                recordcount = Integer.parseInt(rstCount[0][0]);
            }


            if (currentpage < 0) {
                currentpage = 1;
            }

            if (perpage <= 0) {
                perpage = 5000;
            }

            if (eventid <= 0) {
                //This is not an entry display so page out.
                perpage = 5000;
            }

            StringBuffer pagingOut = new StringBuffer();
//            if (recordcount > perpage) {
//                pagingOut.append("<tr>");
//                pagingOut.append("<td colspan=4>");
//                pagingOut.append(reger.pagingLinkPrint.getHtml(recordcount, currentpage, perpage, request));
//                pagingOut.append("</td>");
//                pagingOut.append("</tr>");
//                //And finally put it on the page
//                mb.append(pagingOut);
//            }
            //Limit vars
            int limitMin = (currentpage * perpage) - perpage;
            int limitMax = perpage;
            String sqlLimit = " LIMIT " + limitMin + "," + limitMax;

            //End paging


            //-----------------------------------
            //-----------------------------------
            String[][] rstImagelist = reger.core.db.Db.RunSQL(sqlBuilder(false, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey) + sqlLimit);
            //-----------------------------------
            //-----------------------------------
            if (rstImagelist != null) {
                mb.append("<ul class=\"thumbnails\">");
                for (int i = 0; i < rstImagelist.length; i++) {
                    String mediaoutPath = "";
                    mb.append("<!-- Begin individual image listing -->");
                    mb.append("<li class=\"col-md-3\">");
                    mb.append("<div class=\"thumbnail\">");


                    //mb.append("<tr>");
                    //mb.append("<td valign=middle align=center>");
                    //mb.append("</td>");
                    //mb.append("<td valign=middle align=center colspan=2>");

                    mediaoutPath = "../";



                    String ext = FilenameUtils.getExtension(rstImagelist[i][10]);



                    String bigurl = "mediaout/file."+ext+"?imageid="+rstImagelist[i][0]+"&entrykey="+entrykeyQueryString;
                    String thumburl =  "mediaout.log?imageid="+rstImagelist[i][0]+"&isthumbnail=yes&entrykey="+entrykeyQueryString;
                    String entryurl = "entry.log?eventid="+rstImagelist[i][4];
                    String entrytitle = rstImagelist[i][2];

                    //mb.append("<li>"+"\n");
                    mb.append("<a class=\"thumbnail\" href=\""+bigurl+"\" rel=\"prettyPhoto[Images]\" title=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(entrytitle)+"</a>\" >"+"\n");
                    mb.append("<img alt=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(entrytitle)+"</a>\" src=\""+thumburl+"\" width=\"100\" >"+"\n");
                    mb.append("</a>"+"\n");
                    //mb.append("</li>"+"\n");



//                        mb.append("<a href=\"mediaout/file."+ext+"?imageid="+rstImagelist[i][0]+"&entrykey="+entrykeyQueryString+"\" rel=\"prettyPhoto[Images"+eventid+"]\">");
//                        mb.append("<img src=\"mediaout.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + "&isthumbnail=yes" + entrykeyQueryString + "\" border=0>" + "\n");
//                        mb.append("</a>" + "\n");



                    //if (userSessionOfPersonViewing.getAccountuser().getEntrymode()==reger.Vars.ENTRYMODESIMPLE) {
                        //mb.append("<br/><a href=\"javascript:appendImageTag("+rstImagelist[i][0]+")\"><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">Add to Post Body</font></a></font><br/>");
                    //}

                    mb.append("<center><textarea cols='30' rows='3' name='imagedescription-" + rstImagelist[i][0] + "' style='width:95%; font: 10pt monospace'>" + reger.core.Util.cleanForHtml(rstImagelist[i][1]) + "</textarea></center>");

                    mb.append("<div style=\"float:right;\">");
                    if (userSessionOfPersonViewing.getAccountuser().getEntrymode()==reger.Vars.ENTRYMODESIMPLE) {
                        mb.append("<a href=\"javascript:appendImageTag("+rstImagelist[i][0]+")\"><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">Add to Post Body</font></a></font><br/>");
                    }
                    mb.append("<input type='checkbox' name='delete-" + rstImagelist[i][0] + "' value='yes'> <font face=arial size=-2>Delete?</font></div>");


                    //Image Keyword Tags
                    String imageTags = reger.Tag.getStringOfAllTagsForImage(Integer.parseInt(rstImagelist[i][0]));
                    mb.append("<br>");
                    mb.append("<font face=arial size=-2>Tags <input type='text' name='imagetag-" + rstImagelist[i][0] + "' value=\"" + reger.core.Util.cleanForHtml(imageTags) + "\" maxlength='254' style=\"font-size: 10px;\" class=\"col-md-1\"><br>");



//                    if (!rstImagelist[i][6].equals("")) {
//                        mb.append("<br><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">" + FilenameUtils.getName(rstImagelist[i][10]) + "</font>");
//                    }
//                    if (!rstImagelist[i][7].equals("")) {
//                        mb.append("<br><font face=arial size=-2 class=smallfont style=\"font-size: 9px;\">" + rstImagelist[i][7] + " bytes</font>");
//                    }





                    //Display the entry that this image came from
                    if (eventid <= 0) {
                        mb.append("<br><br>");
                        mb.append("<font face=arial size=-2 class=smallfont>");
                        String entryurltmp = reger.Entry.entryFileNameStatic(Integer.parseInt(rstImagelist[i][4]), rstImagelist[i][3]);
                        mb.append("From Entry:<br><a href='" + entryurltmp + "'>" + rstImagelist[i][3] + "</a>");
                        //@todo Display date/time in usertime with the image
                        //mb.append("<br>");
                        //mb.append(rstImagelist[i][5]);
                        mb.append("</font>");
                    }



                    //mb.append("</td>");
                    //mb.append("</tr>");
                    mb.append("</div>");
                    mb.append("</li>");

                    mb.append("<!-- End individual image listing -->");
                }
                mb.append("</div>");
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

            Entry entry = new Entry(eventid);

            //Hide posts older than hideolderthanxdays unless the user is logged in
            Log log = LogCache.get(entry.logid);
            boolean hidebecauseolderthanxdays = false;
            try{
                if (log.getHideolderthanxdays() > 0 && (userSessionOfPersonViewing.getAccountuser()==null || userSessionOfPersonViewing.getAccountuser().isLoggedIn==false )){
                    java.util.Calendar today = java.util.Calendar.getInstance();
                    int entryDaysAgo = reger.core.DateDiff.dateDiff("day", today, entry.dateGmt);
                    if (Math.abs(entryDaysAgo) > log.getHideolderthanxdays()){
                        hidebecauseolderthanxdays = true;
                    }
                }
            } catch (Exception ex){
                Debug.errorsave(ex, "ImageListHtml hideolderthanxdays");
            }

            if (hidebecauseolderthanxdays==false) {


                mb.append("\n\n\n");
                mb.append("<!-- Begin Images -->");


                mb.append("<ul class=\"thumbnails\">" + "\n");

                //-----------------------------------
                //-----------------------------------
                String[][] rstImagelist = reger.core.db.Db.RunSQL(sqlBuilder(false, userSessionOfPersonViewing, accountid, tagid, eventid, displayOnlyImagesFromLiveEntries, false, false, entrykey));
                //-----------------------------------
                //-----------------------------------
                if (rstImagelist != null) {
                    for (int i = 0; i < rstImagelist.length; i++) {


                        mb.append("\n");

                        String ext = FilenameUtils.getExtension(rstImagelist[i][10]);


                        mb.append("<li style=\"width:100px;\">" + "\n");
                        mb.append("<div class=\"thumbnail\">" + "\n");


                        //                    if (ext.indexOf("jpg")>-1 || ext.indexOf("gif")>-1 || ext.indexOf("png")>-1){
                        mb.append("<a href=\"mediaout/file." + ext + "?imageid=" + rstImagelist[i][0] + "&entrykey=" + entrykeyQueryString + "\" rel=\"prettyPhoto[Images" + eventid + "]\">");
                        mb.append("<img src=\"mediaout.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + "&isthumbnail=yes" + entrykeyQueryString + "\" border=0>" + "\n");
                        mb.append("</a>" + "\n");
                        //                    } else {
                        //                        mb.append("<a href=\"mediaouthtml.log?imageid="+rstImagelist[i][0]+"&ext=page."+ext+"\" rel=\"prettyPhoto[Images"+eventid+"]\">");
                        //                        mb.append("<img src=\"mediaout.log?logid=" + rstImagelist[i][8] + "&imageid=" + rstImagelist[i][0] + "&isthumbnail=yes" + entrykeyQueryString + "\" border=0>" + "\n");
                        //                        mb.append("</a>" + "\n");
                        //                    }

                        String imageTags = reger.Tag.getStringOfAllTagsForImageAsLinks(Integer.parseInt(rstImagelist[i][0]), "");
                        if (imageTags != null && imageTags.length() > 0) {
                            mb.append("<h5>" + imageTags + "</h5>" + "\n");
                        }

                        if (rstImagelist[i][1] != null && rstImagelist[i][1].length() > 0) {
                            //mb.append("<p>"+reger.core.Util.cleanForHtml(rstImagelist[i][1])+"</p>" + "\n");
                        }

                        mb.append("</div>" + "\n");
                        mb.append("</li>" + "\n");


                    }
                }

                mb.append("</ul>" + "\n");
                mb.append("<!-- End Images  -->" + "\n");
                mb.append("\n\n\n");
            }
        }

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
        int perPage = 100;
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
        String[][] rstImageList = Db.RunSQL("SELECT DISTINCT image.imageid, image.image, image.description, megalog.logid, image.filename, event.eventid, event.title "+fromSql+whereSql+" ORDER BY event.date DESC, image.imageid ASC LIMIT " + limitMin +"," + limitMax);
        //-----------------------------------
        //-----------------------------------
        //-----------------------------------
        //-----------------------------------
        String[][] rstImageCount = Db.RunSQL("SELECT count(DISTINCT image.imageid) "+fromSql+whereSql);
        //-----------------------------------
        //-----------------------------------



        int recordcount = Integer.parseInt(rstImageCount[0][0]);

        StringBuffer pagingOut = new StringBuffer();
        if (recordcount > perPage) {
            pagingOut.append(reger.pagingLinkPrint.getImagePageNumbers(recordcount,currentPage, perPage, request));
            pagingOut.append("<br/><br/>");
            //And finally put it on the page
            mb.append(pagingOut);
        }
        //End paging

        mb.append("<ul class=\"thumbnails\">" + "\n");

        String mediaoutPath = "";
        if (rstImageList != null) {
            for (int i = 0; i < rstImageList.length; i++) {






                String ext = FilenameUtils.getExtension(rstImageList[i][4]);


                    mb.append("<li style=\"width:100px;\">" + "\n");
                    mb.append("<div class=\"thumbnail\">" + "\n");




                    String entrykeyQueryString = request.getParameter("entrykey");
                    String bigurl = "mediaout/file."+ext+"?imageid="+rstImageList[i][0]+"&entrykey="+entrykeyQueryString;
                    String thumburl =  "mediaout.log?imageid="+rstImageList[i][0]+"&isthumbnail=yes&entrykey="+entrykeyQueryString;
                    String entryurl = "entry.log?eventid="+rstImageList[i][5];
                    String entrytitle = rstImageList[i][6];

                    //mb.append("<li>"+"\n");
                    mb.append("<a href=\""+bigurl+"\" rel=\"prettyPhoto[Images]\" title=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(entrytitle)+"</a>\" >"+"\n");
                    mb.append("<img alt=\"<a href='"+entryurl+"'>"+Util.cleanRemoveDoubleQuotes(entrytitle)+"</a>\" src=\""+thumburl+"\" width=\"100\" >"+"\n");
                    mb.append("</a>"+"\n");
                    //mb.append("</li>"+"\n");


//                        mb.append("<a href=\"mediaout/file."+ext+"?imageid="+rstImageList[i][0]+"\" rel=\"prettyPhoto[ImagesFilesDotLog]\">");
//                        mb.append("<img src=\"mediaout.log?logid=" + rstImageList[i][3] + "&imageid=" + rstImageList[i][0] + "&isthumbnail=yes\" border=0>" + "\n");
//                        mb.append("</a>" + "\n");


                    mb.append("</div>" + "\n");
                    mb.append("</li>" + "\n");








            }
        }
        mb.append("</ul>");


        //Paging footer
        if (recordcount > perPage) {
            mb.append("<br/><br/>");
            mb.append(pagingOut);
        }
        //End paging


        return mb;
    }
}