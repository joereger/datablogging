package reger.importentries;

import java.util.Calendar;

public class Ping {

    private String title;
    private String url;
    private String ip;
    private String blogName;
    private Calendar date;
    private StringBuffer pingText = new StringBuffer();

    public StringBuffer getPingText() {
        return pingText;
    }

    public void setPingText(StringBuffer pingText) {
        this.pingText.append(pingText);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
