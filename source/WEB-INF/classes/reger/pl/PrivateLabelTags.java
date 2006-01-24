package reger.pl;

import reger.UserSession;
import reger.Entry;
import reger.Log;
import reger.cache.LogCache;
import reger.template.Template;
import reger.core.db.Db;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

public class PrivateLabelTags {

    public static StringBuffer getEventList(UserSession userSession, HttpServletRequest request) {
        StringBuffer eventList = new StringBuffer();
        try {
            int currentPage = 1;
            if (request.getParameter("currentpage") != null) {
                currentPage = reger.core.Util.getCurrentPage(request.getParameter("currentpage"));
                if (currentPage < 0) {
                    currentPage = 1;
                }
            }
            int perPage = userSession.getAccount().getDisplaynumberofentries();
            //Limit vars
            int limitMin = (currentPage * perPage) - perPage;
            int limitMax = perPage;
            //-----------------------------------
            //-----------------------------------
            String[][] rstEventList = Db.RunSQL("SELECT eventid, title, account.accountid, megalog.logid FROM event, account, megalog, pl WHERE " + userSession.getPl().getPeerSql() + " AND account.plid=pl.plid AND " + reger.Entry.sqlOfLiveEntry + " AND event.accountid=account.accountid AND event.logid=megalog.logid AND megalog.logaccess='" + reger.Vars.LOGACCESSPUBLIC + "' AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='" + userSession.getPl().getPlid() + "'  ORDER BY event.date DESC LIMIT " + limitMin + "," + limitMax);
            //-----------------------------------
            //-----------------------------------
            //-----------------------------------
            //-----------------------------------
            String[][] rstEventCount = Db.RunSQL("SELECT eventid FROM event, account, megalog, pl WHERE " + userSession.getPl().getPeerSql() + " AND account.plid=pl.plid AND " + reger.Entry.sqlOfLiveEntry + " AND event.accountid=account.accountid AND event.logid=megalog.logid AND megalog.logaccess='" + reger.Vars.LOGACCESSPUBLIC + "' AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='" + userSession.getPl().getPlid() + "'  ORDER BY event.date");
            //-----------------------------------
            //-----------------------------------
            System.out.println("SELECT eventid, title, account.accountid, megalog.logid FROM event, account, megalog, pl WHERE " + userSession.getPl().getPeerSql() + " AND account.plid=pl.plid AND " + reger.Entry.sqlOfLiveEntry + " AND event.accountid=account.accountid AND event.logid=megalog.logid AND megalog.logaccess='" + reger.Vars.LOGACCESSPUBLIC + "' AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='" + userSession.getPl().getPlid() + "'  ORDER BY event.date DESC LIMIT " + limitMin + "," + limitMax);
            System.out.println("EVENTS ARE ************** " + rstEventList.length);
            int recordcount = rstEventCount.length;
            eventList.append("<table border=0>");
            eventList.append("<tr>");
            StringBuffer pagingOut = new StringBuffer();
            if (recordcount > perPage) {
                pagingOut.append("<td colspan=4>");
                pagingOut.append(reger.pagingLinkPrint.getHtml(recordcount, currentPage, perPage, request));
                pagingOut.append("</td>");
                //And finally put it on the page
                eventList.append(pagingOut);
            }
            eventList.append("</tr>");
            eventList.append("<tr>");
            //End paging

            if (rstEventList != null) {
                for (int i = 0; i < rstEventList.length; i++) {
                    //Go get the entry from the cache
                    Entry entry = reger.cache.EntryCache.get(Integer.parseInt(rstEventList[i][0]));
                    String entryurl = reger.Entry.entryFileNameStatic(entry.logid, entry.eventid, entry.title);
                    String entryurladmin = "entry.log?logid=" + entry.logid + "&eventid=" + entry.eventid + "&action=edit";
                    //Add the servername and port
                    if (request.getLocalPort() == 80 || request.getLocalPort() == 443) {
                        entryurl = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/" + entryurl;
                        entryurladmin = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/myhome/" + entryurladmin;
                    } else {
                        entryurl = "" + userSession.getAccount().getSiteRootUrl(userSession) + ":" + request.getLocalPort() + "/" + entryurl;
                        entryurladmin = "" + userSession.getAccount().getSiteRootUrl(userSession) + ":" + request.getLocalPort() + "/myhome/" + entryurladmin;
                    }
                    //How many chars to display?
                    int displaycharsinsummary = userSession.getAccount().getDisplaycharsinsummary();
                    if ((displaycharsinsummary <= 0) || (displaycharsinsummary >= entry.comments.length())) {
                        displaycharsinsummary = entry.comments.length();
                    }
                    String entrybody = "";
                    entrybody = entry.comments.substring(0, displaycharsinsummary);
                    //Put line breaks in there
                    //entrybody=replace(entrybody, VbCrlf  & VbCrlf, "<br><br>")
                    entrybody = entrybody.replaceAll(reger.Vars.LINEBREAKCHAR, "<br><br>");
                    //Add the More Link if needed
                    if (entry.comments.length() > displaycharsinsummary) {
                        entrybody = entrybody + " ...<a href=" + entryurl + ">More</a>";
                    }
                    String templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(userSession.getAccount().getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();

                    //Try to override with specific template for log
//                    if (logid > 0) {
//                        Log log = LogCache.get(logid);
//                        if (log.getEntlisttemplateid() > 0) {
//                            templateText = reger.template.AllTemplatesInSystem.getTemplateByTemplateid(log.getEntlisttemplateid(), Template.TEMPLATETYPEENTRYLIST).getTemplate();
//                        }
//                    }

                    //Get log name
                    String logname = "";
                    Log log = reger.cache.LogCache.get(entry.logid);
                    if (log != null) {
                        logname = log.getName();
                    }

                    //If we're on edit.log and the logged-in user can't administer this logid then don't display the result.
//                    if (!thispagename.equals("entries.log")) {
//                        list.append(reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(entry.dateGmt, userSession.getAccount().getTimezoneid()), entry.title, entryurl, reger.core.Util.truncateString(entry.comments, userSession.getAccount().getDisplaycharsinsummary()), logname, entry.filecount, entry.messagecount, entry.accountuserid));
//                    } else if ((thispagename.equals("entries.log") && userSession.getAccountuser().userCanViewLog(entry.logid))) {
//                        list.append(reger.template.EntryListTemplateProcessor.entryout(templateText, reger.core.TimeUtils.gmttousertime(entry.dateGmt, userSession.getAccount().getTimezoneid()), entry.title, entryurladmin, reger.core.Util.truncateString(entry.comments, userSession.getAccount().getDisplaycharsinsummary()), logname, entry.filecount, entry.messagecount, entry.accountuserid));
//                    }
                }
            }
            eventList.append("</tr>");
            //Paging footer
            if (recordcount > perPage) {
                eventList.append("<tr>");
                eventList.append(pagingOut);
                eventList.append("</tr>");
            }
            eventList.append("</table>");
        } catch (Exception e) {
            Debug.errorsave(e, "Exception occurred in getEventList in PrivateLabelTags");
        }
        return eventList;
    }

    public static StringBuffer getImageList(UserSession userSession, HttpServletRequest request) {
        StringBuffer imageList = new StringBuffer();
        try {
            int currentPage = 1;
            if (request.getParameter("currentImagePage") != null) {
                currentPage = reger.core.Util.getCurrentPage(request.getParameter("currentImagePage"));
                if (currentPage < 0) {
                    currentPage = 1;
                }
            }
            int perPage = userSession.getAccount().getDisplaynumberofentries();
            //Limit vars
            int limitMin = (currentPage * perPage) - perPage;
            int limitMax = perPage;
            String[][] rstImageList = null;
            String[][] rstImageCount = null;
            // IF tagid is null, retrieve data based on tag.
            if (request.getParameter("tagid") != null) {
                int tagId = Integer.parseInt(request.getParameter("tagid"));
                //-----------------------------------
                //-----------------------------------
                rstImageList = Db.RunSQL("select image.imageid, image.image, image.description, image.sizeinbytes, image.originalfilename from image, tag, tagimagelink, account where tag.tagid='" + tagId + "' and account.plid = '" + userSession.getPl().getPlid() + "' and tagimagelink.tagid=tag.tagid and image.imageid=tagimagelink.imageid and image.accountid=account.accountid  LIMIT " + limitMin + "," + limitMax);
                //-----------------------------------
                //-----------------------------------
                //-----------------------------------
                //-----------------------------------
                rstImageCount = Db.RunSQL("select image.imageid, image.image, image.description, image.sizeinbytes, image.originalfilename from image, tag, tagimagelink, account where tag.tagid='" + tagId + "' and  account.plid = '" + userSession.getPl().getPlid() + "' and tagimagelink.tagid=tag.tagid and image.imageid=tagimagelink.imageid and image.accountid=account.accountid");
                //-----------------------------------
                //-----------------------------------
                System.out.println("select image.imageid, image.image, image.description, image.sizeinbytes, image.originalfilename from image, tag, tagimagelink, account where tag.tagid='" + tagId + "' and account.plid = '" + userSession.getPl().getPlid() + "' and tagimagelink.tagid=tag.tagid and image.imageid=tagimagelink.imageid and image.accountid=account.accountid  LIMIT " + limitMin + "," + limitMax);
            } else if ((request.getParameter("tagid") == null) && (request.getParameter("tag") != null)) {
                String tag = request.getParameter("tag");
                //-----------------------------------
                //-----------------------------------
                rstImageList = Db.RunSQL("select image.imageid, image.image, image.description, image.sizeinbytes, image.originalfilename from image, tag, tagimagelink, account where tag.tag='" + tag + "' and  account.plid = '" + userSession.getPl().getPlid() + "' and tagimagelink.tagid=tag.tagid and image.imageid=tagimagelink.imageid and image.accountid=account.accountid  LIMIT " + limitMin + "," + limitMax);
                //-----------------------------------
                //-----------------------------------
                //-----------------------------------
                //-----------------------------------
                rstImageCount = Db.RunSQL("select image.imageid, image.image, image.description, image.sizeinbytes, image.originalfilename from image, tag, tagimagelink where tag.tag='" + tag + "' and tagimagelink.tagid=tag.tagid and image.imageid=tagimagelink.imageid and image.accountid='" + userSession.getAccount().getAccountid() + "'");
                //-----------------------------------
                //-----------------------------------
            }
            System.out.println("IMAGES ARE ************** " + rstImageCount.length);
            int recordcount = rstImageCount.length;
            imageList.append("<table border=0>");
            imageList.append("<tr>");
            StringBuffer pagingOut = new StringBuffer();
            if (recordcount > perPage) {
                pagingOut.append("<td colspan=4>");
                pagingOut.append(reger.pagingLinkPrint.getImagePageNumbers(recordcount, currentPage, perPage, request));
                pagingOut.append("</td>");
                //And finally put it on the page
                imageList.append(pagingOut);
            }
            imageList.append("</tr>");
            imageList.append("<tr>");
            //End paging

            String mediaoutPath = "../";
            if (rstImageList != null) {
                int imagesPerRow = 1;
                for (int i = 0; i < rstImageList.length; i++) {
                    if (imagesPerRow % 3 == 0) {
                        imageList.append("</tr>");
                        imageList.append("<tr>");
                    }
                    imageList.append("<td valign=middle align=center bgcolor=#cccccc>");
                    imageList.append("<a href='" + mediaoutPath + "mediaouthtml.log?imageid=" + rstImageList[i][0] + "' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
                    imageList.append("<img src='" + mediaoutPath + "mediaout.log?imageid=" + rstImageList[i][0] + "&isthumbnail=yes" + "' border=0></a>");
                    imageList.append("<br><font face=arial size=-2 class=smallfont style=\"font-size: 10px;\">" + rstImageList[i][4] + "</font><br><font face=arial size=-2 class=smallfont style=\"font-size: 9px;\">" + rstImageList[i][3] + " bytes</font>");
                    imageList.append("</td>");
                    imagesPerRow ++;
                }
            }
            imageList.append("</tr>");
            //Paging footer
            if (recordcount > perPage) {
                imageList.append("<tr>");
                imageList.append(pagingOut);
                imageList.append("</tr>");
            }
            imageList.append("</table>");
        } catch (Exception e) {
            Debug.errorsave(e, "Exception occurred in getImageList in PrivateLabelTags");
        }
        return imageList;
    }
}