package reger.demos;

/**
 * Outputs the html required to view a demo
 */
public class DemoRenderHtml {

    public static String getSummary(Demo demo, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();

        String urlOfDemoPage = demo.getDemoBaseUrl() + demo.getDemoFilename() + ".html";



        mb.append("<table cellpadding=0 width=100% cellspacing=2 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top align=right width=58>");
        mb.append("<a href='"+urlOfDemoPage+"' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        mb.append("<img src='"+pathToAppRoot+"images/icon-play.gif' border=0 align=left>");
        mb.append("</a>");
        mb.append("</td>");
        mb.append("<td valign=top>");
        mb.append("<a href='"+urlOfDemoPage+"' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        mb.append("<font face=arial size=+1>");
        mb.append(demo.getDemoName());
        mb.append("</font>");
        mb.append("</a>");
        mb.append("<br>");
        mb.append("<font face=arial size=-1>");
        mb.append(demo.getDemoDescription());
        mb.append("</font>");
        mb.append("<br>");
        mb.append("<a href='"+urlOfDemoPage+"' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        mb.append("<font face=arial size=-2>");
        mb.append("Start the Tour >>");
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb.toString();
    }

//    public static String getActualDemo(Demo demo, String pathToAppRoot){
//        StringBuffer mb = new StringBuffer();
//
//        String baseDirAndFilename = demo.getDemoBaseUrl() + demo.getDemoFilename();
//
//        mb.append("<table border=\"0\" cellpadding=\"0\" align=\"center\" width=\"800\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("  <tr>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("    <td ><object id  =\"flashMovie\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   codeBase =\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   height   =\"617\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   width    =\"800 \"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   classid  =\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" VIEWASTEXT>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"_cx\"                VALUE=\"26\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"_cy\"                VALUE=\"26\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        //mb.append("   <PARAM NAME=\"MovieURL\"           VALUE=\""+baseDirAndFilename+".swf\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"FlashVars\"          VALUE=\"csConfigFile="+baseDirAndFilename+"_config.xml\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        //mb.append("   <PARAM NAME=\"MovieURL\"           VALUE=\""+baseDirAndFilename+".swf\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Movie\"              VALUE=\""+baseDirAndFilename+"_controller.swf?csConfigFile="+baseDirAndFilename+"_config.xml\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Src\"                VALUE=\""+baseDirAndFilename+"_controller.swf?csConfigFile="+baseDirAndFilename+"_config.xml\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"WMode\"              VALUE=\"Window\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Loop\"               VALUE=\"false\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Quality\"            VALUE=\"high\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"SAlign\"             VALUE=\"\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Menu\"               VALUE=\"-1\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Base\"               VALUE=\"\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"AllowScriptAccess\"  VALUE=\"always\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"Scale\"              VALUE=\"ShowAll\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"DeviceFont\"         VALUE=\"0\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"EmbedMovie\"         VALUE=\"0\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"BGColor\"            VALUE=\"#FFFFFF\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"SWRemote\"           VALUE=\"\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"MovieData\"          VALUE=\"\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <PARAM NAME=\"SeamlessTabbing\"    VALUE=\"1\">" + reger.Vars.LINEBREAKCHARFORHTML);
//		mb.append("							 " + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   <EMBED src         =\""+baseDirAndFilename+"_controller.swf?csConfigFile="+baseDirAndFilename+"_config.xml\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          flashvars   =\"csConfigFile="+baseDirAndFilename+"_config.xml\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          quality     =\"high\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          bgcolor     =\"#FFFFFF\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          width       =\"800\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          height      =\"617\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          type        =\"application/x-shockwave-flash\"" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("          pluginspace =\"http://www.macromedia.com/go/getflashplayer\">" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("   </EMBED>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("</OBJECT>  <br></td>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("  </tr>" + reger.Vars.LINEBREAKCHARFORHTML);
//        mb.append("</table>" + reger.Vars.LINEBREAKCHARFORHTML);
//
//
//        return mb.toString();
//    }

}
