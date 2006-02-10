package reger.files;

import reger.filesync.server.Util;
import reger.Account;
import reger.pageFramework.PageProps;

import java.io.*;
import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * Presents a list of directories to choose from
 */
public class DirectoryChooser {


    public static StringBuffer listDirectoriesForFileMove(java.io.File in, int level, Account account, PageProps pageProps, String[] filesToMove, String thisPageName) {
        StringBuffer directoryHtml = new StringBuffer();
        if (in.isDirectory()) {
            if (in.getAbsolutePath().indexOf(".thumbnails")<0){

                String path = Util.getFilenameMinusDirectoryName(in, account);
                path = FilenameUtils.normalize(path);
                String pathToDisplay = path;
                if (FilenameUtils.indexOfLastSeparator(path)>0){
                    pathToDisplay = path.substring(FilenameUtils.indexOfLastSeparator(path)+1, path.length());
                }

                directoryHtml.append("<form action='"+thisPageName+"' method=post style=\"border: 0px; margin: 0px;\">");
                for(int i=0; i<level; i++){
                    directoryHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
                directoryHtml.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/folder-sm.gif' border=0 align=middle>");
                directoryHtml.append("<font face=arial size=-1><b>");
                if (pathToDisplay.equals("")){
                    directoryHtml.append("My Files");
                } else {
                    directoryHtml.append(FilenameUtils.normalize(pathToDisplay));
                }
                directoryHtml.append("</b></font>");
                directoryHtml.append("<input type=hidden name=action value='movefilesend'>");
                directoryHtml.append("<input type=hidden name=moveto value=\""+reger.core.Util.cleanForHtml(path)+"\">");
                directoryHtml.append("<input type=submit value='Move to Here' style=\"font-size: 12px;\">");
                for (int i = 0; i < filesToMove.length; i++) {
                    java.lang.String filename = filesToMove[i];
                    directoryHtml.append("<input type=hidden name='file' value=\""+reger.core.Util.cleanForHtml(filename)+"\">");
                }
                directoryHtml.append("</form>");
                directoryHtml.append("<br>");
            }

            level = level + 1;
            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                directoryHtml.append(listDirectoriesForFileMove(new File(in, children[i]), level, account, pageProps, filesToMove, thisPageName));
            }
        }
        return directoryHtml;
    }

    public static StringBuffer listDirectoriesForDirectoryMove(java.io.File in, int level, Account account, PageProps pageProps, String pathToMove, String thisPageName) {
        StringBuffer directoryHtml = new StringBuffer();
        if (in.isDirectory()) {
            if (in.getAbsolutePath().indexOf(".thumbnails")<0){

                String path = Util.getFilenameMinusDirectoryName(in, account);
                path = FilenameUtils.normalize(path);
                String pathToDisplay = path;
                pathToDisplay = path.substring(FilenameUtils.indexOfLastSeparator(path)+1, path.length());


                directoryHtml.append("<form action='"+thisPageName+"' method=post style=\"border: 0px; margin: 0px;\">");
                for(int i=0; i<level; i++){
                    directoryHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
                directoryHtml.append("<img src='"+pageProps.pathToAppRoot+"images/filebrowser/folder-sm.gif' border=0 align=middle>");
                directoryHtml.append("<font face=arial size=-1><b>");
                if (pathToDisplay.equals("")){
                    directoryHtml.append("My Files");
                } else {
                    directoryHtml.append(FilenameUtils.normalize(pathToDisplay));
                }
                directoryHtml.append("</b></font>");
                directoryHtml.append("<input type=hidden name=action value='movedirectoryend'>");
                directoryHtml.append("<input type=hidden name=moveto value=\""+reger.core.Util.cleanForHtml(path)+"\">");
                directoryHtml.append("<input type=submit value='Move to Here' style=\"font-size: 12px;\">");
                directoryHtml.append("<input type=hidden name='path' value=\""+reger.core.Util.cleanForHtml(pathToMove)+"\">");
                directoryHtml.append("</form>");
                directoryHtml.append("<br>");
            }

            level = level + 1;
            String[] children = in.list();
            for (int i=0; i<children.length; i++) {
                directoryHtml.append(listDirectoriesForDirectoryMove(new File(in, children[i]), level, account, pageProps, pathToMove, thisPageName));
            }
        }
        return directoryHtml;
    }

}
