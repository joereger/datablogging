package reger;

import reger.core.db.Db;
import reger.core.Debug;

import java.util.Iterator;

/**
 *
 */
public class MegaHtmlFormBottom {

    public static StringBuffer getHtml(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, boolean displayasadmin, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        StringBuffer mb = new StringBuffer();

        boolean editLayout = false;
        String disabledFormText = "";
        if (request.getParameter("mode") != null && request.getParameter("mode").equals("editlayout")) {
            editLayout = true;
            disabledFormText = "disabled=\"true\"";
        }

        //Look for default form
        if (pageProps.action.equals("default") || pageProps.action.equals("defaultsubmit")) {

            //Change the text on the submit button
            String submittext;

            if (pageProps.action.equals("edit") || pageProps.action.equals("editsubmit")) {
                submittext = "Edit Log Entry";
            } else if (pageProps.action.equals("default") || pageProps.action.equals("defaultsubmit")) {
                submittext = "Set Default Values";
            } else {
                submittext = "Add Log Entry";
            }

            mb.append("<tr>");
            mb.append("<td colspan=3 bgcolor=#cccccc align=center valign=top><input type='submit' value='" + submittext + "' " + disabledFormText + "></td>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=9>");
            mb.append("&nbsp;");
            mb.append("</td>");
            mb.append("</tr>");

            mb.append("</form>");
            mb.append("</table>");
            mb.append("</td></tr></table>");
            mb.append("<!-- end  log entry table -->");
            mb.append("<br><br>");

        } else {

            String temptext;
            String submittext;
            String thestep;

            //Save as Draft?
            if (displayasadmin) {
                mb.append("<tr>");
                mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top><font face=arial size=-1><b>Publish Now?</b></font><br><font face=arial size=-2><b></b></font><br>");
                mb.append("</td>");
                mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap>");
                mb.append("<input type='radio' name='isdraft' value='0' " + disabledFormText + " ");
                if (pageProps.entry.isDraft != 1) {
                    mb.append("checked");
                }
                mb.append("> ");
                mb.append("<font face=arial size=-1><b>Yes, Publish Now</b></font>");
                mb.append("<br>");
                mb.append("<input type='radio' name='isdraft' value='1' " + disabledFormText + " ");
                if (pageProps.entry.isDraft == 1) {
                    mb.append("checked");
                }
                mb.append("> ");
                mb.append("<font face=arial size=-2>No, Save as Draft</font>");

                mb.append("</font></td>");
                mb.append("</tr>");
            }

            //Approve?
            if (displayasadmin && userSession.getAccountuser().userCanDoAcl("APPROVEENTRIES", userSession.getAccount().getAccountid())) {
                if (pageProps.entry.isApproved == 0) {
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top><font face=arial size=-1><b>Approve?</b></font><br><font face=arial size=-2><b></b></font><br>");
                    mb.append("</td>");
                    mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap>");
                    mb.append("<input type='radio' name='isapproved' value='1' " + disabledFormText + " ");
                    if (pageProps.entry.isApproved != 0) {
                        mb.append("checked");
                    }
                    mb.append("> ");
                    mb.append("<font face=arial size=-1><b>Yes, Approve Now</b></font>");
                    mb.append("<br>");
                    mb.append("<input type='radio' name='isapproved' value='0' " + disabledFormText + " ");
                    if (pageProps.entry.isApproved == 0) {
                        mb.append("checked");
                    }
                    mb.append("> ");
                    mb.append("<font face=arial size=-2>No, Do Not Approve</font>");

                    mb.append("</font></td>");
                    mb.append("</tr>");
                } else {
                    mb.append("<input type='hidden' name='isapproved' value='1'>");
                }
            }

            //Action buttons
            if (displayasadmin) {
                mb.append("<!-- Begin Action Buttons -->");

                //Change the text on the submit button
                if (pageProps.action.equals("edit") || pageProps.action.equals("editsubmit")) {
                    submittext = "Save Log Entry";
                } else if (pageProps.action.equals("default") || pageProps.action.equals("defaultsubmit")) {
                    submittext = "Save Default Values";
                } else {
                    submittext = "Save Log Entry";
                }


                mb.append("<tr>");
                mb.append("<td colspan=3 bgcolor=#cccccc align=center valign=top>");

                //Put the submit button on the page, sometimes with the javascript, sometimes without
                if (userSession.getAccountuser().getEntrymode() == reger.Vars.ENTRYMODEADVANCED) {
                    mb.append("<INPUT TYPE=submit NAME=newreview VALUE='" + submittext + "' onclick=\"submitPost();\" " + disabledFormText + ">");
                    //mb.append("<INPUT TYPE=submit NAME=newreview VALUE='"+submittext+"' "+disabledFormText+">");

                } else {
                    mb.append("<input type='submit' value='" + submittext + "' onclick=\"submitPost();\" " + disabledFormText + ">");
                }

                //Spelling
                mb.append("<br>");
                mb.append("<input type='checkbox' name='dospellcheck' value='1' " + disabledFormText + ">");
                mb.append(" <font face=arial size=-2 color=#000000>Do Spell Check.</font>");
                mb.append("<br>");
                mb.append("</font>");

                mb.append("</td>");
                mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3>");

                if (pageProps.action.equals("edit") || pageProps.action.equals("editsubmit")) {
                    mb.append("<table align=right cellspacing=2 cellpadding=4 bgcolor=#ffffff>");
                    mb.append("<tr>");
                    mb.append("<td bgcolor=#e6e6e6 align=right valign=middle>");
                    mb.append("<font face=arial size=-2>");
                    //mb.append("<a href='entry-move.log?eventid="+pageProps.entry.eventid+"' onclick=\"leaveEntryPage(this.href); return false;\">");
                    mb.append("<a href='entry-move.log?eventid=" + pageProps.entry.eventid + "'>");
                    mb.append("Move Entry to Another Log");
                    mb.append("</a>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("<tr>");
                    mb.append("<td bgcolor=#e6e6e6 align=right valign=middle>");
                    mb.append("<font face=arial size=-2>");
                    mb.append("<a href='entry-delete.log?eventid=" + pageProps.entry.eventid + "'>");
                    mb.append("Delete This Entry");
                    mb.append("</a>");
                    mb.append("</font>");
                    mb.append("</td>");
                    mb.append("</tr>");
                    mb.append("</table>");
                }

                mb.append("<font face=arial size=-1>");

                if (pageProps.logProps.megalogaccess == reger.Vars.LOGACCESSPRIVATE) {
                    mb.append("<img src='../images/icon-private.gif' width='16' height='16' alt='' border='0'> Private Entry");
                } else if (pageProps.logProps.megalogaccess == reger.Vars.LOGACCESSPUBLIC) {
                    mb.append("<img src='../images/icon-public.gif' width='16' height='16' alt='' border='0'> Public Entry");
                }

                //mb.append("</font><br><font face=arial size=-2>To change this log's properties, please click <a href='logs-log-properties.log?logid="+pageProps.logProps.logid+"' onclick=\"leaveEntryPage(this.href); return false;\">here</a>.");
                //mb.append("</font><br><font face=arial size=-2>Visibility determined by log property.<br>To change this log's properties, please click <a href='logs-log-properties.log?logid="+pageProps.logProps.logid+"'>here</a>.");
                mb.append("</font>");

                mb.append("</td>");
                mb.append("</tr>");

                mb.append("<!-- End Action Buttons -->");
            }

            //Optional Stuff
            if (displayasadmin) {
                mb.append("<tr>");
                mb.append("<td colspan=6 bgcolor=#ffffff align=left valign=top class=logentryheader>");
                mb.append("<font face=arial size=-2>");
                mb.append("<b>");
                mb.append("Extended Entry Information");
                mb.append("</b>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }

            //Smart Entry Tags
            mb.append("<tr>");
            mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
            if (displayasadmin) {
                mb.append("Keyword Tags</b></font><br><font face=arial size=-2><b>Enter keyword tags to help organize and find your entries.");
            } else {
                mb.append("Keyword Tags");
            }
            mb.append("</b></font><br>");
            mb.append("</td>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
            if (displayasadmin) {
                //This is where the admin side is shown.
                //Users can enter and edit tag information here as a single input text field
                mb.append("<input type='text' name='entrykeywordtags' value=\"" + reger.core.Util.cleanForHtml(pageProps.entry.entryKeywordTags) + "\">");
            } else {
                //This is where the public side is shown.
                //Readers view keyword tags as links to the keyword tag page.
                mb.append(pageProps.entry.entryKeywordTagsWithLinks);
            }
            mb.append("</td>");
            mb.append("</tr>");

            //Location
            if (pageProps.entry.location != null) {
                Debug.debug(5, "", "Megahtmlformbottom.java calling location locationid=" + pageProps.entry.location.getLocationid() + "<br>getLongitude()=" + pageProps.entry.location.getLongitude());
            }
            mb.append(LocationRenderHtml.getHtmlForEntryPageTable(pageProps.entry.location, displayasadmin, disabledFormText, userSession));


            mb.append("<a name='images'><!-- Begin Images -->");
            //Begin image-add link
            if (displayasadmin) {
                mb.append("<tr>");
                mb.append("<td valign=top align=right bgcolor=#cccccc colspan=3 class=logentryheader>");
                mb.append("<font face=arial size=-1>");
                mb.append("<b>");
                mb.append("Files/Images/Media");
                mb.append("</b>");
                mb.append("</font>");
                mb.append("<br>");
                mb.append("<font face=arial size=-2>");
                mb.append("<b>");
                mb.append("Images, video, mp3 or any other file that you want to attach to this entry.");
                mb.append("</b>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=center nowrap bgcolor=#ffffff colspan=3 class=logentrycontent>");
                mb.append("<font face=arial size=-1>");
                if (pageProps.entry.eventid != -1) {
                    if (!editLayout) {
                        mb.append("<a href='entry-addmedia.log?eventid=" + pageProps.entry.eventid + "' onclick=\"javascript:NewWindow(this.href,'name','750','0','yes');return false;\">");
                        mb.append("<img src='" + pageProps.pathToAppRoot + "images/icon-file-upload.gif' border=0 align=left>");
                        mb.append("Click Here to<br>Add Images or Files<br>to This Entry");
                        mb.append("</a>");
                    }
                } else {
                    mb.append("You can add images after the entry is created.");
                }
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
            //End image-add link

            //Output the images in html format, but only if we're not doing a preview
            int perpage = 500;
            //Imagetagid
            int imagetagid = -1;
            if (request.getParameter("imagetagid") != null && reger.core.Util.isinteger(request.getParameter("imagetagid"))) {
                imagetagid = Integer.parseInt(request.getParameter("imagetagid"));
            }
            mb.append(reger.ImageListHtml.htmlOut(userSession.getAccount().getAccountid(), pageProps.entry.eventid, imagetagid, displayasadmin, userSession, -1, perpage, request));

            mb.append("<!-- End Images -->");

            //Related Links
            if (!displayasadmin && userSession.getAccount().getUserelatedlinks() == 1) {
                String searchterms = pageProps.entry.title + " " + pageProps.entry.comments;
                reger.RelatedLinks relatedLinks = reger.cache.RelatedLinksCache.get(pageProps.entry.eventid, searchterms, userSession);
                if (relatedLinks.getRelatedLinks().size() > 0) {
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                    mb.append("Related Entries");
                    mb.append("</b></font><br>");
                    mb.append("</td>");
                    mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
                    //Rip through the related entries
                    //@todo Display rank of related links.  We have relatedLinks.relatedRank[] available with the info.
                    for (Iterator it = relatedLinks.getRelatedLinks().iterator(); it.hasNext();) {
                        RelatedLink rl = (RelatedLink) it.next();
                        mb.append("<a href='" + reger.Entry.entryFileNameStatic(rl.getEventid(), rl.getTitle()) + "'>" + rl.getTitle() + "</a><br>");
                    }
                    mb.append("</td>");
                    mb.append("</tr>");
                }
            }

            

            //Episodes
            if (displayasadmin) {
                mb.append("<tr>");
                mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top  class=logentryheader><font face=arial size=-1><b>Episodes</b></font><br><font face=arial size=-2><b>This entry is part of these episodes.</b></font><br>");
                mb.append("</td>");
                mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
                //-----------------------------------
                //-----------------------------------
                String[][] rstEpisodes = Db.RunSQL("SELECT episode.episodeid, episode.name FROM episode WHERE accountid='" + userSession.getAccount().getAccountid() + "' ORDER BY episode.episodeid DESC");
                //-----------------------------------
                //-----------------------------------
                if (rstEpisodes != null && rstEpisodes.length > 0) {
                    mb.append("<select multiple name=episodeid size=3 style=\"font-size: 10px;\" " + disabledFormText + ">");
                    for (int i = 0; i < rstEpisodes.length; i++) {
                        String selectedText = "";
                        for (Iterator it = pageProps.entry.episodesThisEntryBelongsTo.iterator(); it.hasNext();) {
                            Integer episodeid = (Integer) it.next();
                            if (episodeid == Integer.parseInt(rstEpisodes[i][0])) {
                                selectedText = " selected";
                            }
                        }
                        mb.append("<option value=" + rstEpisodes[i][0] + " " + selectedText + ">" + rstEpisodes[i][1] + "</option>");
                    }
                    mb.append("<option value=''>(None)</option>");
                    mb.append("</select>");
                    mb.append("<br>");
                    mb.append("<br>");
                }
                mb.append("<table cellpadding=0 cellspacing=0 border=0>");
                mb.append("<tr>");
                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-2>");
                mb.append("New Episode Name:");
                mb.append("</font>");
                mb.append("<br>");
                mb.append("<input type=text name=newepisodename size=35 maxlength=254 style=\"font-size: 10px;\" " + disabledFormText + ">");
                mb.append("</td>");
                mb.append("<td valign=top>");
                mb.append("&nbsp;&nbsp;");
                mb.append("</td>");
                mb.append("<td valign=top>");
                mb.append("<font face=arial size=-2>");
                mb.append("New Episode Description:");
                mb.append("</font>");
                mb.append("<br>");
                mb.append("<textarea name=newepisodedescription cols=15 rows=1 style=\"font-size: 10px;\" " + disabledFormText + ">");
                mb.append("</textarea>");
                mb.append("</td>");
                mb.append("</tr>");
                mb.append("</table>");
                mb.append("</td>");
                mb.append("</tr>");
            } else {
                if (pageProps.entry.episodesThisEntryBelongsTo.size() > 0) {
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top  class=logentryheader><font face=arial size=-1><b>Episodes</b></font><br><font face=arial size=-2><b>This entry is part of these episodes.</b></font><br>");
                    mb.append("</td>");
                    mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
                    for (Iterator it = pageProps.entry.episodesThisEntryBelongsTo.iterator(); it.hasNext();) {
                        Integer episodeid = (Integer) it.next();
                        reger.episodes.Episode episode = new reger.episodes.Episode(episodeid, userSession.getAccountuser());
                        mb.append(reger.episodes.EpisodeRender.getHtml(episode, userSession.getAccount(), false, ""));
                    }
                    mb.append("</td>");
                    mb.append("</tr>");
                }
            }

            //Time Periods
            if (userSession.getAccount().getIstimeperiodon() && !displayasadmin) {
                reger.TimeLine tl = new reger.TimeLine(null, null, pageProps.entry.dateGmt, userSession.getAccount().getAccountid(), userSession);
                if (tl.timeperiodids.length > 0) {
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top  class=logentryheader><font face=arial size=-1><b>Time Period</b></font><br><font face=arial size=-2><b>This entry took place during these time periods.</b></font><br>");
                    mb.append("</td>");
                    mb.append("<td bgcolor='#ffffff' align=center valign=top colspan=3 nowrap class=logentrycontent>");
                    mb.append(tl.getTimelineHtml(pageProps.pathToAppRoot, 300));
                    mb.append("</td>");
                    mb.append("</tr>");
                }
            }

            //Favorite Selection
            mb.append("<tr>");
            mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
            if (displayasadmin) {
                mb.append("List as Favorite?</b></font><br><font face=arial size=-2><b>Appears in a \"Favorites\" list on all pages of this log.");
            } else {
                mb.append("Favorite Entry?");
            }
            mb.append("</b></font><br>");
            mb.append("</td>");
            mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
            if (displayasadmin) {
                mb.append("<input type='radio' name='favorite' value='0' " + disabledFormText + " ");
                if (pageProps.entry.favorite != 1) {
                    mb.append("checked");
                }
                mb.append("><font face=arial size=-1><b>No</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                mb.append("<input type='radio' name='favorite' value='1' " + disabledFormText + " ");
                if (pageProps.entry.favorite == 1) {
                    mb.append("checked");
                }
                mb.append("><font face=arial size=-1><b>Yes</b></font>");
            } else {
                if (pageProps.entry.favorite != 1) {
                    mb.append("No");
                } else {
                    mb.append("Yes");
                }
            }
            mb.append("</td>");
            mb.append("</tr>");

            //Author Selection
            if (displayasadmin && userSession.getAccountuser().userCanDoAcl("CHANGEAUTHORSHIP", userSession.getAccount().getAccountid())) {
                mb.append("<tr>");
                mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                mb.append("Author:");
                mb.append("</b></font><br>");
                mb.append("</td>");
                mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
                mb.append("<select name=accountuserid style=\"font-size: 10px;\" " + disabledFormText + " >");
                //-----------------------------------
                //-----------------------------------
                String[][] rstAuthors = Db.RunSQL("SELECT accountuserid, friendlyname FROM accountuser WHERE accountid='" + userSession.getAccount().getAccountid() + "'");
                //-----------------------------------
                //-----------------------------------
                if (rstAuthors != null && rstAuthors.length > 0) {
                    for (int i = 0; i < rstAuthors.length; i++) {
                        String selText = "";
                        if (pageProps.entry.accountuserid == Integer.parseInt(rstAuthors[i][0])) {
                            selText = " selected";
                        }
                        mb.append("<option value='" + rstAuthors[i][0] + "' " + selText + ">");
                        mb.append(reger.core.Util.cleanForHtml(rstAuthors[i][1]));
                        mb.append("</option>");
                    }
                }
                mb.append("</select>");
                mb.append("<br>");

                mb.append("<font face=arial size=-2>");
                mb.append("<a href='people-accountuser.log?action=newstart'>");
                mb.append("Add an Author");
                mb.append("</a>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
            //End Authors

            //Begin Groups
            if (displayasadmin && userSession.getAccountuser().userCanDoAcl("POSTENTRYTOGROUP", userSession.getAccount().getAccountid())) {
                mb.append("<tr>");
                mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                mb.append("Groups:");
                mb.append("</b></font><br><font face=arial size=-2><b>");
                mb.append("This entry is posted to these groups.");
                mb.append("</b></font></td>");
                mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 class=logentrycontent>");
                //Get all groups this accountuser is subscribed to
                //-----------------------------------
                //-----------------------------------
                String[][] rstGroups = Db.RunSQL("SELECT groups.groupid, groups.name FROM groupmembership, groups  WHERE groups.groupid=groupmembership.groupid AND groupmembership.accountuserid='" + userSession.getAccountuser().getAccountuserid() + "' AND groupmembership.isapproved='1' ORDER BY name ASC");
                //-----------------------------------
                //-----------------------------------
                if (rstGroups != null && rstGroups.length > 0) {

                    if (pageProps.logProps.megalogaccess == reger.Vars.LOGACCESSPRIVATE) {
                        mb.append("<img src='" + pageProps.pathToAppRoot + "images/info-icon.gif' border=0>");
                        mb.append(" ");
                        mb.append("<font face=arial size=-2>");
                        mb.append("Note: posting entries from private logs (like this one) to groups will make it visible to readers and members of the group.  You are sharing something otherwise private with the group.  Readers of the group will not be able to view other entries in the this private log.  You're granting them a pass for this single entry.");
                        mb.append("</font>");
                        mb.append("<br>");
                    }

                    for (int i = 0; i < rstGroups.length; i++) {
                        mb.append("<input type=checkbox name=groupid value='" + rstGroups[i][0] + "' " + disabledFormText + " ");
                        if (pageProps.entry.isInGroup(Integer.parseInt(rstGroups[i][0]))) {
                            mb.append(" checked ");
                        }
                        mb.append(" >");
                        mb.append(" ");
                        mb.append("<font face=arial size=-2>");
                        mb.append(rstGroups[i][1]);
                        mb.append("</font>");
                        mb.append("<br>");
                    }

                } else {
                    mb.append("<font face=arial size=-2>");
                    mb.append("You are not subscribed to any groups.");
                    if (!editLayout) {
                        mb.append("Click <a href='groups.log'>here</a> to find groups.");
                    }
                    mb.append("</font>");
                }
                mb.append("</td>");
                mb.append("</tr>");
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstGroupsThisEventIsIn = Db.RunSQL("SELECT groups.groupid, groups.name FROM eventtogroup, groups WHERE eventtogroup.groupid=groups.groupid AND eventtogroup.eventid='" + pageProps.entry.eventid + "'");
                //-----------------------------------
                //-----------------------------------
                if (rstGroupsThisEventIsIn != null && rstGroupsThisEventIsIn.length > 0) {
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                    mb.append("Groups:");
                    mb.append("</b></font><br><font face=arial size=-2><b>");
                    mb.append("This entry is posted to these groups.");
                    mb.append("</b></font></td>");
                    mb.append("<td bgcolor='#ffffff' align=left valign=top colspan=3 nowrap class=logentrycontent>");
                    for (int i = 0; i < rstGroupsThisEventIsIn.length; i++) {
                        mb.append("<font face=arial size=-2 class=smallfont>");
                        mb.append("<a href='" + userSession.getPl().getPlBaseUrl(userSession) + "/about/community-group-view.log?groupid=" + rstGroupsThisEventIsIn[i][0] + "'>");
                        mb.append(rstGroupsThisEventIsIn[i][1]);
                        mb.append("</a>");
                        mb.append("</font> ");
                    }
                    mb.append("</td>");
                    mb.append("</tr>");
                }
            }
            //End Groups

            //Trackback Selection
            if (userSession.getAccount().getIstrackbackon() && userSession.getPl().getIstrackbackenabled()) {


                if (displayasadmin) {

                    //Main table
                    mb.append("<tr>");
                    mb.append("<td colspan=3 bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                    mb.append("Trackback URLs to Ping</b></font><br><font face=arial size=-2><b>Enter a list of URLs to ping.  Each URL on its own line.");
                    mb.append("</b></font><br>");
                    mb.append("</td>");
                    mb.append("<td colspan=3 width=300 bgcolor='#ffffff' align=left valign=top nowrap class=logentrycontent>");
                    mb.append("<textarea name=trackbackurl cols='45' rows='3' style='width: 100%;font: 10pt monospace' " + disabledFormText + ">");
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstTrackbacks = Db.RunSQL("SELECT url FROM trackback WHERE eventid='" + pageProps.entry.eventid + "' AND isoutbound='1'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstTrackbacks != null && rstTrackbacks.length > 0) {
                        for (int i = 0; i < rstTrackbacks.length; i++) {
                            mb.append(rstTrackbacks[i][0] + "\n");
                        }
                    }
                    mb.append("</textarea>");
                    mb.append("</td>");
                    mb.append("</tr>");


                } else {


                    mb.append("<tr>");
                    mb.append("<td colspan='3' bgcolor=#cccccc align=right valign=top class=logentryheader><font face=arial size=-1><b>");
                    mb.append("Trackback");
                    mb.append("</b></font><br>");
                    mb.append("</td>");
                    mb.append("<td bgcolor='#ffffff' align=left valign=top colspan='6' nowrap class=logentrycontent>");
                    //Show trackback URL for this entry
                    mb.append("<font face=arial size=-2>");
                    mb.append("<b>Trackback URL for this entry:</b>");
                    mb.append("<br>");
                    String trackbackurl = "" + userSession.getAccount().getSiteRootUrl(userSession) + "/trackback-eventid" + pageProps.entry.eventid + ".log";
                    mb.append("<i>");
                    mb.append(trackbackurl);
                    mb.append("</i>");
                    mb.append("</font>");
                    mb.append("<br>");
                    mb.append("<br>");

                    //Get a list of trackbacks
                    mb.append("<font face=arial size=-2>");
                    mb.append("<b>Trackbacks:</b>");
                    mb.append("</font>");
                    mb.append("<br>");
                    mb.append("<table cellpadding=0 cellspacing=1 width=100% border=0>");
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstListTrackbacks = Db.RunSQL("SELECT url, posttitle, blogname, excerpt, datetime FROM trackback WHERE eventid='" + pageProps.entry.eventid + "' AND isoutbound='0' AND isapproved='1' ORDER BY datetime ASC");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstListTrackbacks != null && rstListTrackbacks.length > 0) {
                        for (int i = 0; i < rstListTrackbacks.length; i++) {

                            mb.append("<tr>");
                            mb.append("<td bgcolor=#e6e6e6 class=logentryheader>");
                            mb.append("<font face=arial size=-2>");
                            mb.append("<a href=\"" + reger.core.Util.cleanForHtml(rstListTrackbacks[i][0]) + "\" rel=\"nofollow\">");
                            mb.append("<b>" + reger.NoFollowTag.addNoFollowTagToLinks(rstListTrackbacks[i][1]) + "</b>");
                            mb.append("</a>");
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");

                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff class=logentrycontent>");
                            mb.append("<font face=arial size=-2>");
                            mb.append("<b>" + reger.NoFollowTag.addNoFollowTagToLinks(rstListTrackbacks[i][2]) + "</b>");
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");

                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff class=logentrycontent>");
                            mb.append("<font face=arial size=-2>");
                            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(reger.core.TimeUtils.dbstringtocalendar(rstListTrackbacks[i][4]), userSession.getAccount().getTimezoneid())));
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");

                            mb.append("<tr>");
                            mb.append("<td bgcolor=#ffffff class=logentrycontent>");
                            mb.append("<font face=arial size=-2>");
                            String trackbackBody = reger.NoFollowTag.addNoFollowTagToLinks(rstListTrackbacks[i][3]);
                            mb.append(trackbackBody.replaceAll("<", "&lt;"));
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");


                        }
                    } else {
                        mb.append("<tr>");
                        mb.append("<td bgcolor=#ffffff class=logentrycontent>");
                        mb.append("<font face=arial size=-2>");
                        mb.append("None.");
                        mb.append("</font>");
                        mb.append("</td>");
                        mb.append("</tr>");
                    }
                    mb.append("</table>");
                    mb.append("</td>");
                    mb.append("</tr>");

                }


            }

            //Close the form
            if (displayasadmin) {
                mb.append("</form>");
            }

            //@todo Wouldn't it be cool to be able to approve/delete messages directly on the entry page if you're logged in?  I thought so.
            mb.append("<a name='comments'><!-- Begin Messages -->");
            if (userSession.getAccount().getMessagesstatus() == 1 && !displayasadmin) {
                boolean emailnotify = false;
                if (request.getParameter("emailnotify") != null && request.getParameter("emailnotify").equals("1")) {
                    emailnotify = true;
                }
                String ipaddress = request.getRemoteAddr();
                String message = "";
                if (request.getParameter("message") != null && !request.getParameter("message").equals("")) {
                    message = request.getParameter("message");
                }
                String messagefrom = "";
                if (request.getParameter("messagefrom") != null && !request.getParameter("messagefrom").equals("")) {
                    messagefrom = request.getParameter("messagefrom");
                }
                String email = "";
                if (request.getParameter("email") != null && !request.getParameter("email").equals("")) {
                    email = request.getParameter("email");
                }
                String url = "";
                if (request.getParameter("url") != null && !request.getParameter("url").equals("")) {
                    url = request.getParameter("url");
                }
                //Save messages
                if (request.getParameter("submitmessage") != null && request.getParameter("submitmessage").equals("true")) {
                    mb.append(reger.MessageListHtml.saveMessage(message, messagefrom, userSession.getAccount().getAccountid(), pageProps.entry.eventid, email, ipaddress, url, emailnotify, userSession, request));
                }
                //Display messages
                mb.append(reger.MessageListHtml.htmlOut(userSession.getAccount().getAccountid(), pageProps.entry.eventid, userSession.getAccount().getTimezoneid(), userSession.getAccountuser().LogsUserCanViewQueryendNoMegalog(userSession.getAccount().getAccountid()), "entry.log", pageProps.action, pageProps.logProps.logid, -1, request, true, response));
            }
            mb.append("<!-- End Messages -->");


            mb.append("</table>");
            //mb.append("</td></tr></table>");

            mb.append("<!-- end  log entry table -->");
            mb.append("<br><br>");


        } //End if that looks for default form

        if (displayasadmin) {
            mb.append("</form>");
        }


        return mb;
    }

}
