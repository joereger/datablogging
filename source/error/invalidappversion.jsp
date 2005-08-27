<%@ page import="reger.licensing.ServerLicense"%>
<%@ page import="reger.core.licensing.License"%>

<html>
<head>
<title>Application Version Conflict</title>
</head>
<body bgcolor=#ffcc00>
<center>
<br><br>
<img src='/images/error-tri-large.gif' width=385 height=350>
<br>
<blockquote><blockquote>
<strong><blink><font face=arial size=+3 color=#ffffff style="font-size: 76px;">Invalid application version.</font></blink></strong>
<br><br>
<blockquote><blockquote>
<strong><font face=arial size=-1 color=#ffffff style="font-size: 15px;">We're sorry.  The version of the application that is currently installed is not valid with your license.</font></strong>
<br><br>
<strong><font face=arial size=-1 color=#ffffff style="font-size: 15px;">
Your license supports application upgrades through:
<%=ServerLicense.getLicense().getProperty(License.PROPSTRINGEXPDATEGMT)%>
<br>
The current application version is:
<%=reger.versioninfo.VersionInfo.getVersion(reger.versioninfo.VersionInfo.getMaxVersionNumber()).getVersionName()%>
<br>
The current application version date is:
<%=reger.core.TimeUtils.dateformatfordb(reger.versioninfo.VersionInfo.getVersion(reger.versioninfo.VersionInfo.getMaxVersionNumber()).getDeploymentDateGMT())%>
<br><br>
You must obtain an older version of the application that fits your license.  At that point you can upgrade your server license and then upgrade the application version.  We apopogize for the inconvenience.  We implemented the system in this manner to prevent your data from being automatically upgraded to support a newer version.  If such a one-way upgrade had occurred you would have been forced to upgrade, which we think would be a dirty trick.
</font></strong>
</blockquote></blockquote>
</blockquote></blockquote>
</center>
</body>
</html>

