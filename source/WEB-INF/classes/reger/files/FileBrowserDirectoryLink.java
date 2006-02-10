package reger.files;

/**
 * Defines an action that can take place on a checked file in the file browser
 */
public class FileBrowserDirectoryLink {

    private String linkIcon = "";
    private String linkText = "";
    private String linkUrl = "";

    public FileBrowserDirectoryLink(String linkText, String linkUrl, String linkIcon){
        this.linkIcon = linkIcon;
        this.linkUrl = linkUrl;
        this.linkText = linkText;
    }

    public String getLinkIcon() {
        return linkIcon;
    }

    public void setLinkIcon(String linkIcon) {
        this.linkIcon = linkIcon;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }
}
