package reger.versioninfo;

/**
 * Renders versions in html
 */
public class VersionInfoRenderer {

    public static String getVersionAsHtml(int versionId){
        Version ver = VersionInfo.getVersion(versionId);
        if (ver!=null){
            StringBuffer mb = new StringBuffer();

            mb.append("<font face=arial size=+2>");
            mb.append("<b>");
            mb.append("Version "  + ver.getVersionName());
            mb.append("</b>");
            mb.append("</font>");

            mb.append("<br>");

            mb.append("<font face=arial size=-2>");
            mb.append(reger.core.TimeUtils.dateformatdate(ver.getDeploymentDateGMT()));
            mb.append("</font>");

            mb.append("<br><br>");

            mb.append("<font face=arial size=-1>");
            mb.append("<b>");
            mb.append(ver.getQuickSummary());
            mb.append("</b>");
            mb.append("</font>");

            mb.append("<br><br>");

            mb.append("<font face=arial size=-1>");
            mb.append(ver.getDescription());
            mb.append("</font>");

            return mb.toString();
        } else {
            return "Version not found.";
        }
    }

    public static String getVersionList(String versionDetailPageName){
        StringBuffer mb = new StringBuffer();

        Version[] versions = VersionInfo.getAllVersions();
        mb.append("<ul>");
        for (int i = versions.length - 1; i >= 0; i--) {
            Version version = versions[i];
            mb.append("<li>");
            mb.append("<font face=arial size=+1>");
            mb.append("<a href='"+versionDetailPageName+"?versionid="+(i+1)+"'>");
            mb.append("Version " + version.getVersionName());
            mb.append("</a>");
            mb.append("</font>");
            mb.append(" ");
            mb.append("<font face=arial size=-1>");
            mb.append(" (" + reger.core.TimeUtils.dateformatdate(version.getDeploymentDateGMT()) + ") ");
            mb.append(version.getQuickSummary());
            mb.append("</font>");
            mb.append("</li>");
        }
        mb.append("</ul>");

        return mb.toString();
    }

}
