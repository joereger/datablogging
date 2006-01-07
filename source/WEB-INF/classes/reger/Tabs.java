package reger;

import java.util.Vector;


/**
 * Displays a set of horizontal tabs... used by reger.com itself... not part of template system
 */
public class Tabs {

    private Vector tabs = new Vector(10);
    private String oncolor = "#cccccc";
    private String offcolor = "#ffffff";
    private String onfontcolor = "#000000";
    private String offfontcolor = "#000000";
    public String thispagename = "";


    public Tabs(javax.servlet.http.HttpServletRequest request, String oncolor, String offcolor, String onfontcolor, String offfontcolor){
        setBaseVars(oncolor, offcolor, onfontcolor, offfontcolor);
        setThisPageName(request);
    }

    public Tabs(javax.servlet.http.HttpServletRequest request, Vector tabs, String oncolor, String offcolor, String onfontcolor, String offfontcolor){
        setBaseVars(oncolor, offcolor, onfontcolor, offfontcolor);
        this.tabs = tabs;
        setThisPageName(request);
    }

    public Tabs(javax.servlet.http.HttpServletRequest request){
        setThisPageName(request);
    }

    private void setThisPageName(javax.servlet.http.HttpServletRequest request){
        thispagename = reger.core.Util.getJspName(request.getServletPath());
    }

    private void setBaseVars(String oncolor, String offcolor, String onfontcolor, String offfontcolor){
        this.oncolor = oncolor;
        this.offcolor = offcolor;
        this.onfontcolor = onfontcolor;
        this.offfontcolor = offfontcolor;
    }

    /**
     * Gets the html out
     * @return
     */
    public StringBuffer getHtml(){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=3 cellspacing=1 border=0 width=100% bgcolor="+this.oncolor+">");
        mb.append("<tr>");

        for (int i = 0; i < tabs.size(); i++) {
            //Get the category
            reger.Tab tab = (reger.Tab) tabs.get(i);

            String tabcolor = this.offcolor;
            String fontcolor = this.offfontcolor;

            if (this.thispagename.equalsIgnoreCase(tab.url)){
                //tabcolor = this.oncolor;
                //fontcolor = this.onfontcolor;
            }

            mb.append("<td bgcolor="+tabcolor+" valign=top align=center>");
            mb.append("<a href='"+tab.url+"'>");
            mb.append("<font face=arial size=-2 color="+fontcolor+">");
            mb.append("<strong>");
            mb.append(tab.text);
            mb.append("</strong>");
            mb.append("</font>");
            mb.append("</a>");
            mb.append("</td>");

        }

        mb.append("</tr>");
        mb.append("</table>");

        return mb;
    }

    /**
     * Adds a reger.tab to this set of tabs
     * @param tab
     */
    public void addTab(reger.Tab tab){
        tabs.add(tab);
    }

}
