package reger.files;

import reger.UserSession;
import reger.filesync.server.Util;
import reger.pageFramework.PageProps;

import java.util.*;
import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * A utility for browsing files via html
 */
public class FileBrowser {

    private UserSession userSession;
    private ArrayList<FileBrowserDirectoryLink> linksForCurrentDirectory = new ArrayList<FileBrowserDirectoryLink>();
    private ArrayList<FileBrowserFileAction> actionsForAllFiles = new ArrayList<FileBrowserFileAction>();
    private String currentDirectory= "";
    private PageProps pageProps;
    private String currentPageName = "";
    private int eventid = 0;

    private StringBuffer directoryHtml = new StringBuffer();
    private StringBuffer filesHtml = new StringBuffer();


    public FileBrowser(UserSession userSession, String currentDirectory, PageProps pageProps, String currentPageName, int eventid){
        this.userSession = userSession;
        this.currentDirectory = currentDirectory;
        this.pageProps = pageProps;
        this.currentPageName = currentPageName;
        this.eventid = eventid;
    }


    public void addLinkToCurrentDirectory(FileBrowserDirectoryLink fileBrowserDirectoryLink){
        linksForCurrentDirectory.add(fileBrowserDirectoryLink);
    }

    public void addActionForAllCheckedFiles(FileBrowserFileAction fileBrowserFileAction){
        actionsForAllFiles.add(fileBrowserFileAction);
    }

    public void setCurrentDirectory(String currentDirectory){
        this.currentDirectory = currentDirectory;
    }

    public void process(){
        File startDirectories = new File(userSession.getAccount().getPathToAccountFiles());
        File startFiles = new File(userSession.getAccount().getPathToAccountFiles() + currentDirectory);
        processDirectories(startDirectories, 0);
        processFiles(startFiles);
    }

    public String getHtml(){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=10 cellspacing=10 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top colspan=3>");
        //Current folder start
        mb.append("<table cellpadding=10 cellspacing=10 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=middle>");
        mb.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/folder-lg.gif' border=0 align=middle>");
        mb.append("</td>");
        mb.append("<td valign=middle>");
        mb.append("<font face=arial size=+2><b>");
        if (currentDirectory.equals("")){
            mb.append("My Files");
        } else {
            mb.append("My Files"+"\\"+FilenameUtils.normalize(currentDirectory));
        }
        mb.append("</b></font>");
        mb.append("<br>");
        mb.append("<font face=arial size=-2>");
        if (linksForCurrentDirectory.size()>0){
            for (Iterator it = linksForCurrentDirectory.iterator(); it.hasNext(); ) {
                FileBrowserDirectoryLink link = (FileBrowserDirectoryLink)it.next();
                mb.append("<a href='"+link.getLinkUrl()+FilenameUtils.normalize(currentDirectory)+"&eventid="+eventid+"'>");
                mb.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/"+link.getLinkIcon()+"' border=0 align=middle>");
                mb.append(" " + link.getLinkText());
                mb.append("</a>");
                if (it.hasNext()){
                    mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
            }
        }
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        //Current folder end
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign=top nowrap>");
        mb.append("<img src='"+pageProps.pathToAppRoot+"images/clear.gif' width=10 height=1 border=0 align=middle>");
        mb.append("</td>");
        mb.append("<td valign=top nowrap>");
        //Directory list start
        mb.append("<font face=arial size=-1><b>");
        mb.append(directoryHtml.toString());
        mb.append("</b></font>");
        //Directory list end
        mb.append("</td>");
        mb.append("<td valign=top>");
        //File list start
        mb.append("<font face=arial size=-2>");
        if (actionsForAllFiles.size()>0){
            mb.append("<form action='"+currentPageName+"' method=post>");
            mb.append("<input type=hidden name=eventid value='"+eventid+"'>");
            mb.append("<select name=action>");
            for (Iterator it = actionsForAllFiles.iterator(); it.hasNext(); ) {
                FileBrowserFileAction action = (FileBrowserFileAction)it.next();
                mb.append("<option value='"+action.getActionName()+"'>"+action.getActionFriendlyName()+"</option>");
            }
            mb.append("</select>");
            mb.append("<input type=submit value='Go'>");
            mb.append("<br><br>");
        }
        mb.append("</font>");
        mb.append("<font face=arial size=-2>");
        mb.append(filesHtml.toString());
        mb.append("</font>");
        if (actionsForAllFiles.size()>0){
            mb.append("</form>");
        }
        //File list end
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        return mb.toString();
    }





    private void processDirectories(File in, int level) {
        if (in.isDirectory()) {
            if (in.getAbsolutePath().indexOf(".thumbnails")<0){
                for(int i=0; i<level; i++){
                    directoryHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
                String path = Util.getFilenameMinusDirectoryName(in, userSession.getAccount());
                path = FilenameUtils.normalize(path);
                String pathToDisplay = path;

                reger.core.Debug.debug(5, "FileBrowser.java", "path:"+path);

                if (FilenameUtils.indexOfLastSeparator(path)>0){
                    pathToDisplay = path.substring(FilenameUtils.indexOfLastSeparator(path)+1, path.length());
                }
                reger.core.Debug.debug(5, "FileBrowser.java", "pathToDisplay:"+pathToDisplay);


                directoryHtml.append("<a href='"+currentPageName+"?path="+path+"&eventid="+eventid+"'>");
                directoryHtml.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/folder-sm.gif' border=0 align=middle>");
                if (pathToDisplay.equals("")){
                    directoryHtml.append("My Files");
                } else {
                    directoryHtml.append(FilenameUtils.normalize(pathToDisplay));
                }
                directoryHtml.append("</a>");
                directoryHtml.append("<br>");
            }

            level = level + 1;
            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                processDirectories(new File(in, children[i]), level);
            }
        }
    }

    private void processFiles(File in) {
        if (in.isDirectory()) {
            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                File tmp = new File(in, children[i]);
                if (tmp.isFile()){
                    String path = Util.getFilenameMinusDirectoryName(tmp, userSession.getAccount());
                    String filename = FilenameUtils.getName(path);
                    if (actionsForAllFiles.size()>0){
                        filesHtml.append("<input type=checkbox name=file value='"+path+"'>");
                    }
                    filesHtml.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/file-sm.gif' border=0 align=middle>");
                    filesHtml.append(filename);
                    filesHtml.append("<br>");
                }
            }
        }
    }


}
