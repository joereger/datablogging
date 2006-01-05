package reger;

import reger.core.Debug;
import reger.cache.jboss.Cacheable;

/**
 * Splits incoming urls into an accounturl, plbasedomain and virtualdir.
 */
@Cacheable
public class UrlSplitter implements java.io.Serializable {

    private String rawIncomingServername = "";
    private String servername = "";
    private String virtualdir = "";
    private String siterooturl = "";
    private int port = 80;
    private String scheme = "http://";

    private String[] servernameAllPossibleDomains=new String[0];


    public UrlSplitter(String servername, String accounturl, String plbasedomain, String virtualdir, int port, String siterooturl, String rawIncomingServername){
        this.rawIncomingServername = rawIncomingServername;
        this.servername = servername;
        this.virtualdir = virtualdir;
        this.port = port;
        this.siterooturl = siterooturl;
    }

    public UrlSplitter(javax.servlet.http.HttpServletRequest request){
        //Get the host
        rawIncomingServername = request.getServerName();
        Debug.debug(5, "", " rawIncomingServername=" + rawIncomingServername);

        //Start Here
        servername = rawIncomingServername;

        //Strip www... it's always in the way
        if (servername.length()>=4){
            if (servername.substring(0,4).equalsIgnoreCase("www.")){
                if (servername.length()>=5){
                    servername = servername.substring(4, servername.length());
                }
            }
        }
        Debug.debug(5, "", " servername www removed=" + servername);

        //Get the virtualdir
        if (request.getParameter("virtualdir")!=null && !request.getParameter("virtualdir").equals("")){
            virtualdir = request.getParameter("virtualdir");
        }

        //Sequentially rip off subdomains from the servername
        String tmpServername = rawIncomingServername;
        servernameAllPossibleDomains = reger.core.Util.addToStringArray(servernameAllPossibleDomains, rawIncomingServername);
        //See if we have any subdomains
        while (tmpServername.indexOf(".")>-1 && tmpServername.split("\\.").length>=3){
            //Grab what's to the right of the dot
            tmpServername = tmpServername.substring(tmpServername.indexOf(".")+1, tmpServername.length());
            //Add it to the array
            servernameAllPossibleDomains = reger.core.Util.addToStringArray(servernameAllPossibleDomains, tmpServername);
        }



        //Set the siteRawUrl based on whether or not we have a virtualDir
        if (virtualdir==null || virtualdir.equals("")){
            siterooturl = servername;
        } else {
            siterooturl = servername + "/~" + virtualdir;
        }

        //Set the port
        port = request.getServerPort();

        //Set the protocol
        scheme = request.getScheme();
    }

    public String getUrlSplitterAsString(){
        return rawIncomingServername+":"+servername+":"+virtualdir+":"+siterooturl;
    }

    public String getVirtualdir() {
        return virtualdir;
    }

    public String getServername() {
        return servername;
    }



    public int getPort() {
        return port;
    }

    public String getSiterooturlPlusPortNum(){
        String portStr="";
        if (port!=80 && port!=443){
            portStr = ":"+port;
        }
        if (virtualdir==null || virtualdir.equals("")){
            return servername+portStr;
        } else {
            return servername + portStr + "/~" + virtualdir;
        }
    }


    public String getSiterooturl() {
        return siterooturl;
    }

    public String getRawIncomingServername() {
        return rawIncomingServername;
    }

    public String[] getServernameAllPossibleDomains() {
        return servernameAllPossibleDomains;
    }

    public String getScheme(){
        return scheme;
    }

}
