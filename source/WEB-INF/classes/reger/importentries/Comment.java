package reger.importentries;

import java.util.Calendar;

public class Comment {

    private String author;
    private String email;
    private String url;
    private String ip;
    private Calendar date;
    private StringBuffer commentText = new StringBuffer();
    
    public StringBuffer getCommentText() {
        return commentText;
    }

    public void setCommentText(StringBuffer commentText) {
        this.commentText.append(commentText);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
