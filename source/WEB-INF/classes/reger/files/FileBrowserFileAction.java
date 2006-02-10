package reger.files;

/**
 * Defines an action that can take place on a checked file in the file browser
 */
public class FileBrowserFileAction {

    private String actionName = "";
    private String actionFriendlyName = "";
    private String actionUrl = "";

    public FileBrowserFileAction(String actionName, String actionUrl, String actionFriendlyName){
        this.actionName = actionName;
        this.actionUrl = actionUrl;
        this.actionFriendlyName = actionFriendlyName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getActionFriendlyName() {
        return actionFriendlyName;
    }

    public void setActionFriendlyName(String actionFriendlyName) {
        this.actionFriendlyName = actionFriendlyName;
    }
}
