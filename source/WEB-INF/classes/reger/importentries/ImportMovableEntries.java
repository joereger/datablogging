package reger.importentries;

import reger.Message;
import reger.TrackBack;
import reger.UserSession;
import reger.Entry;
import reger.Accountuser;
import reger.Account;
import reger.PrivateLabel;
import reger.core.Debug;
import reger.core.ValidationException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;

public class ImportMovableEntries {

    public void importMovableFromFile(UserSession userSession, InputStream inputStream, String logid, String timezoneid) throws Exception {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(inputStream);
            br = new BufferedReader(isr);
            String line = null;
            MovableEntry entry = null;
            Comment comment = null;
            Ping ping = null;
            String date = null;
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            Calendar cal = Calendar.getInstance();
            ArrayList entryList = new ArrayList();
            ArrayList commentsList = null;
            ArrayList pingsList = null;
            String body = "";
            boolean text = false;
            while ((line = br.readLine()) != null) {
                if ((line != null) && (!line.trim().equals(""))) {
                    entry = new MovableEntry();
                    commentsList = new ArrayList();
                    pingsList = new ArrayList();
                    while ((line != null) && (!line.trim().equals("--------"))) {
                        if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("TITLE")) {
                            entry.setTitle(line.substring(line.indexOf(":") + 1, line.length()));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("AUTHOR")) {
                            entry.setAuthor(line.substring(line.indexOf(":") + 1, line.length()));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("DATE")) {
                            date = line.substring(line.indexOf(":") + 1, line.length());
                            if ((date.indexOf("AM") > -1) || (date.indexOf("PM") > -1)) {
                                cal.setTime(sdf1.parse(date));
                            } else {
                                cal.setTime(sdf2.parse(date));
                            }
                            entry.setDate(cal);
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("PRIMARY CATEGORY")) {
                            entry.setPrimaryCategory(line.substring(line.indexOf(":") + 1, line.length()));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("CATEGORY")) {
                            entry.setCategory(line.substring(line.indexOf(":") + 1, line.length()));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("STATUS")) {
                            entry.setStatus(line.substring(line.indexOf(":") + 1, line.length()));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("ALLOW COMMENTS")) {
                            entry.setAllowComments(Integer.parseInt(line.substring(line.indexOf(":") + 1, line.length())));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("ALLOW PINGS")) {
                            entry.setAllowPings(Integer.parseInt(line.substring(line.indexOf(":") + 1, line.length())));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("CONVERT BREAKS")) {
                            entry.setConvertBreaks(Integer.parseInt(line.substring(line.indexOf(":") + 1, line.length())));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("NO ENTRY")) {
                            entry.setNoEntry(line.substring(line.indexOf(":") + 1, line.length()));
                        }
                        if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("BODY")) {
                            while ((line != null) && (!line.trim().equals("-----"))) {
                                line = br.readLine();
                                body = body + line;
                            }
                            entry.setBodies(new StringBuffer(body));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("EXTENDED BODY")) {
                            body = "";
                            while ((line != null) && (!line.trim().equals("-----"))) {
                                line = br.readLine();
                                body = body + line;
                            }
                            entry.setExtendedBodies(new StringBuffer(body));
                        }
                        else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("EXCERPT")) {
                            body = "";
                            while ((line != null) && (!line.trim().equals("-----"))) {
                                line = br.readLine();
                                body = body + line;
                            }
                            entry.setExcerpts(new StringBuffer(body));
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("COMMENT")) {
                            comment = new Comment();
                            line = br.readLine();
                            while ((line != null) && (!line.trim().equals("-----"))) {
                                if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("AUTHOR")) {
                                    comment.setAuthor(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("DATE")) {
                                    date = line.substring(line.indexOf(":") + 1, line.length());
                                    if ((date.indexOf("AM") > -1) || (date.indexOf("PM") > -1)) {
                                        cal.setTime(sdf1.parse(date));
                                    } else {
                                        cal.setTime(sdf2.parse(date));
                                    }
                                    comment.setDate(cal);
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("IP")) {
                                    comment.setIp(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("EMAIL")) {
                                    comment.setEmail(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("URL")) {
                                    comment.setUrl(line.substring(line.indexOf(":") + 1, line.length()));
                                } else {
                                    text = true;
                                    body = "";
                                    while ((line != null) && (!line.trim().equals("-----"))) {
                                        body = body + line;
                                        line = br.readLine();
                                    }
                                    comment.setCommentText(new StringBuffer(body));
                                }
                                if (!text) {
                                    line = br.readLine();
                                }
                                text = false;
                            }
                            commentsList.add(comment);
                        } else if ((line != null) && (line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("PING")) {
                            ping = new Ping();
                            line = br.readLine();
                            while ((line != null) && (!line.trim().equals("-----"))) {
                                if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("TITLE")) {
                                    ping.setTitle(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("URL")) {
                                    ping.setUrl(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("IP")) {
                                    ping.setIp(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("BLOG NAME")) {
                                    ping.setBlogName(line.substring(line.indexOf(":") + 1, line.length()));
                                } else if ((line.indexOf(":") > -1) && (line.substring(0, line.indexOf(":"))).equals("DATE")) {
                                    date = line.substring(line.indexOf(":") + 1, line.length());
                                    if ((date.indexOf("AM") > -1) || (date.indexOf("PM") > -1)) {
                                        cal.setTime(sdf1.parse(date));
                                    } else {
                                        cal.setTime(sdf2.parse(date));
                                    }
                                    ping.setDate(cal);
                                } else {
                                    text = true;
                                    body = "";
                                    while ((line != null) && (!line.trim().equals("-----"))) {
                                        body = body + line;
                                        line = br.readLine();
                                    }
                                    ping.setPingText(new StringBuffer(body));
                                }
                                if (!text) {
                                    line = br.readLine();
                                }
                                text = false;
                            }
                            pingsList.add(ping);
                        }
                        line = br.readLine();
                    }
                    entry.setComments(commentsList);
                    entry.setPings(pingsList);
                    entryList.add(entry);
                }
            }
            storeInDB(entryList, userSession, logid);
        } catch (Exception e) {
            Debug.errorsave(e, "Exception occurred in importMovableFromFile method of ImportMovableEntries class while parsing the file");
            throw e;
        } finally {
            try {
               if (br != null) {
                    br.close();
               } if (isr != null) {
                    isr.close();
               }
            } catch  (Exception e) {
            }
        }
    }

    private void storeInDB (ArrayList entryList, UserSession userSession, String logid) throws Exception {
        try {
            ArrayList list = null;
            ArrayList commentsList = null;
            ArrayList pingsList = null;
            Iterator iter = null;
            Iterator commentsIter = null;
            Iterator pingsIter = null;
            MovableEntry entry = null;
            int eventid = 0;
            Iterator entryIter = entryList.iterator();
            Entry entryDAO = null;
            Message msgDAO = null;
            TrackBack trackBackDAO = null;
            //Try to log the user in
            Accountuser au = userSession.getAccountuser();
            //Get the account
            Account account = userSession.getAccount();
            //Get the pl
            PrivateLabel pl = userSession.getPl();
            while (entryIter.hasNext()) {
                entry = (MovableEntry) entryIter.next();
                entryDAO = new Entry();
                entryDAO.logid = Integer.parseInt(logid);
                entryDAO.title = entry.getTitle();
                entryDAO.dateGmt = entry.getDate();
                entryDAO.isDraft = 0;
                entryDAO.comments = entry.getExcerpts().toString() + entry.getBodies().toString() + entry.getExtendedBodies().toString();
                try {
                    //Save the entry to the database
                    entryDAO.newEntryTemporary(account, au);
                    entryDAO.editEntryAll(account, au, pl);
                } catch (ValidationException error) {
                    Debug.errorsave(error, "ValidationException while storing in database");
                }
                eventid = entryDAO.eventid;
                commentsList = entry.getComments();
                commentsIter = commentsList.iterator();
                while (commentsIter.hasNext()) {
                    Comment c = (Comment) commentsIter.next();
                    msgDAO = new Message();
                    msgDAO.setEventid(eventid);
                    msgDAO.setEmailnotify(0);
                    msgDAO.setSizeinbytes(reger.core.Util.sizeInBytes(c.getCommentText().toString()));
                    msgDAO.setMessagefrom(c.getAuthor());
                    msgDAO.setEmail(c.getEmail());
                    msgDAO.setUrl(c.getUrl());
                    msgDAO.setIpaddress(c.getIp());
                    msgDAO.setMessagedate(c.getDate());
                    msgDAO.setMessage(c.getCommentText().toString());
                    msgDAO.save();
                }
                pingsList = entry.getPings();
                pingsIter = pingsList.iterator();
                while (pingsIter.hasNext()) {
                    Ping p = (Ping) pingsIter.next();
                    trackBackDAO = new TrackBack();
                    trackBackDAO.setEventid(eventid);
                    trackBackDAO.setIsoutbound(0);
                    trackBackDAO.setIspingedalready(1);
                    trackBackDAO.setPosttitle(p.getTitle());
                    trackBackDAO.setUrl(p.getUrl());
                    trackBackDAO.setBlogname(p.getBlogName());
                    trackBackDAO.setDatetime(p.getDate());
                    trackBackDAO.setExcerpt(reger.core.Util.truncateString(p.getPingText().toString(), 255));
                    trackBackDAO.save();
                }
            }
        } catch (Exception e) {
            Debug.errorsave(e, "Exception occurred in storeInDB method of ImportMovableEntries class while storing in the database");
            throw e;
        }
    }
}