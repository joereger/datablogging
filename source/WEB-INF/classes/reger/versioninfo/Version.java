package reger.versioninfo;

import java.util.Calendar;

/**
 * Defines a simple interface for a class that holds information about a version.
 */
public interface Version {

    public String getVersionName();

    public Calendar getDeploymentDateGMT();

    public String getQuickSummary();

    public String getDescription();

}
