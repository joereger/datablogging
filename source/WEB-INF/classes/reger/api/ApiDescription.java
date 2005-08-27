package reger.api;

/**
 * Created by IntelliJ IDEA.
 * User: jreger
 * Date: Mar 3, 2004
 * Time: 1:33:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApiDescription {


    public static StringBuffer getHtml(){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=3 width=100% cellspacing=1 border=0>");

        //MetaWebLogAPI
        mb.append("<tr>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+2 color=#666666>");
        mb.append("MetaWebLogAPI");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+1 color=#666666>");
        mb.append("Returns");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+1 color=#666666>");
        mb.append("Notes");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("metaWeblog.newPost(logid, username, password, struct, publish) ");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A String indicating the postid of the new post.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("metaWeblog.editPost(postid, username, password, struct, publish)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A boolean indicating success or failure.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("metaWeblog.getPost(postid, username, password)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A struct containing the requested post.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("metaWeblog.newMediaObject(blogid, username, password, content)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A String indicating the postid of the new post.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("metaWeblog.getRecentPosts(appkey, blogid, inusername, password, numberOfPosts)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("An array of posts.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //BloggerAPI
        mb.append("<tr>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+2 color=#666666>");
        mb.append("bloggerAPI");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+1 color=#666666>");
        mb.append("Returns");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=bottom bgcolor=#ffffff>");
        mb.append("<font face=arial size=+1 color=#666666>");
        mb.append("Notes");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("blogger.newPost(appkey, logid, username, password, struct, publish)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A String indicating the postid of the new post.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("blogger.editPost(appkey, postid, username, password, struct, publish)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A boolean indicating success or failure.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("blogger.getPost(appkey, postid, username, password)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("A struct containing the requested post.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("blogger.getUsersBlogs(appkey, username, password)");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("An array of structs.");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("</table>");

        return mb;
    }


}
