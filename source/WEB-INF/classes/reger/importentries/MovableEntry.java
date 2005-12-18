package reger.importentries;

import java.util.Calendar;
import java.util.ArrayList;

public class MovableEntry {

    private String title;
    private String author;
    private Calendar date;
    private String primaryCategory;
    private String category;
    private String status;
    private int allowComments;
    private int allowPings;
    private int convertBreaks;
    private String noEntry;
    private StringBuffer bodies = new StringBuffer();
    private StringBuffer extendedBodies = new StringBuffer();
    private StringBuffer excerpts = new StringBuffer();
    private ArrayList comments;
    private ArrayList pings;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(int allowComments) {
        this.allowComments = allowComments;
    }

    public int getAllowPings() {
        return allowPings;
    }

    public void setAllowPings(int allowPings) {
        this.allowPings = allowPings;
    }

    public int getConvertBreaks() {
        return convertBreaks;
    }

    public void setConvertBreaks(int convertBreaks) {
        this.convertBreaks = convertBreaks;
    }

    public String getNoEntry() {
        return noEntry;
    }

    public void setNoEntry(String noEntry) {
        this.noEntry = noEntry;
    }

    public StringBuffer getBodies() {
        return bodies;
    }

    public void setBodies(StringBuffer bodies) {
        this.bodies.append(bodies);
    }

    public StringBuffer getExtendedBodies() {
        return extendedBodies;
    }

    public void setExtendedBodies(StringBuffer extendedBodies) {
        this.extendedBodies.append(extendedBodies);
    }

    public StringBuffer getExcerpts() {
        return excerpts;
    }

    public void setExcerpts(StringBuffer excerpts) {
        this.excerpts.append(excerpts);
    }

    public ArrayList getComments() {
        return comments;
    }

    public void setComments(ArrayList comments) {
        this.comments = comments;
    }

    public ArrayList getPings() {
        return pings;
    }

    public void setPings(ArrayList pings) {
        this.pings = pings;
    }
}
