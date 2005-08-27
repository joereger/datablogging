package reger;

import reger.core.db.Db;

/**
 * Holds a single traffic hit event.  These are cached and then
 * written to the database to two tables.  Traffic and trafficbypage
 */
public class TrafficHit {

    private int count = 1;
    private int traffictypeid=0;
    private String url = "";
    private int plid = 0;
    private int accountid = 0;
    private int logid = 0;
    private int eventid = 0;
    private int imageid = 0;
    private String referrer = "";
    private String browser = "";
    private String remotehost = "";
    private boolean isSuperCookieOn = false;
    private int bandwidth = 0;

    public TrafficHit(javax.servlet.http.HttpServletRequest request, int logid, int accountid, int traffictypeid, int plid, String siterooturl, int bandwidth, boolean isSuperCookieOn){

        //Get eventid
        int thisEventid=0;
        if (request.getParameter("eventid")!=null && reger.core.Util.isinteger(request.getParameter("eventid"))){
            thisEventid=Integer.parseInt(request.getParameter("eventid"));
        }
        int thisImageid=0;
        if (request.getParameter("imageid")!=null && reger.core.Util.isinteger(request.getParameter("imageid"))){
            thisImageid=Integer.parseInt(request.getParameter("imageid"));
        }
        //Referrer
        String referrer=reger.core.Util.truncateString(request.getHeader("referer"), 255);
        if (referrer!=null && !referrer.equals("") && referrer.split(siterooturl).length>1){
            referrer="";
        }
        //User-agent
        String useragent=reger.core.Util.truncateString(request.getHeader("user-agent"), 255);
        //Remote host
        String remotehost=reger.core.Util.truncateString(request.getRemoteHost(), 255);
        //Clicked url
        String clickedurl=reger.Vars.getHttpUrlPrefix() + request.getHeader("host") + request.getRequestURI();
        if (request.getQueryString()!=null && !request.getQueryString().equals("")){
            clickedurl=clickedurl+"?"+request.getQueryString();
        }
        clickedurl=reger.core.Util.truncateString(clickedurl, 255);


        //Set the vars appropriately
        this.traffictypeid=traffictypeid;
        this.url = clickedurl;
        this.plid = plid;
        this.accountid = accountid;
        this.logid = logid;
        this.eventid = thisEventid;
        this.imageid = thisImageid;
        this.referrer = referrer;
        this.browser = useragent;
        this.remotehost = remotehost;
        this.bandwidth = bandwidth;
        this.isSuperCookieOn = isSuperCookieOn;
    }

    public String getHitAsRawString(){
        StringBuffer out = new StringBuffer();
        out.append(traffictypeid);
        out.append(url);
        out.append(plid);
        out.append(accountid);
        out.append(logid);
        out.append(eventid);
        out.append(imageid);
        out.append(referrer);
        out.append(browser);
        out.append(remotehost);
        out.append(bandwidth);
        out.append(isSuperCookieOn);
        return out.toString();
    }

    public int getEstimatedMemoryUsage(){
        return reger.core.Util.sizeInBytes(getHitAsRawString());
    }

    public String getHitAsAnnotatedString(){
        StringBuffer out = new StringBuffer();
        out.append("(traffictypeid="+traffictypeid+") ");
        out.append("(url="+url+") ");
        out.append("(plid="+plid+") ");
        out.append("(accountid="+accountid+") ");
        out.append("(logid="+logid+") ");
        out.append("(eventid="+eventid+") ");
        out.append("(imageid="+imageid+") ");
        out.append("(referrer="+referrer+") ");
        out.append("(browser="+browser+") ");
        out.append("(remotehost="+remotehost+") ");
        out.append("(bandwidth="+bandwidth+") ");
        out.append("(isSuperCookieOn="+isSuperCookieOn+") ");
        return out.toString();
    }

    public void save(){
        //Save traffic
        saveTraffic();
        //Save trafficbypage
        saveTrafficByPage();
        //Save bandwidth
        saveBandwidth();
    }

    private void saveTraffic(){
        if (traffictypeid!=reger.Vars.TRAFFICTYPEDONTRECORD && !isSuperCookieOn){
            //-----------------------------------
            //-----------------------------------
            int trafficcountinsert = reger.core.db.Db.RunSQLInsert("INSERT INTO traffic(count, traffictypeid, datetime, url, plid, accountid, logid, eventid, imageid, referrer, browser, remotehost, iscollapsed) VALUES('"+count+"', '"+ traffictypeid +"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+ reger.core.Util.cleanForSQL(url) +"', '"+ plid +"', '"+ accountid +"', '"+ logid +"', '"+ eventid +"', '"+ imageid +"', '"+ reger.core.Util.cleanForSQL(referrer) +"', '"+ reger.core.Util.cleanForSQL(browser) +"', '"+ reger.core.Util.cleanForSQL(remotehost) +"', '0')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    private void saveTrafficByPage(){
        String scriptName = getScriptName(url);
        //-----------------------------------
        //-----------------------------------
        String[][] rstEx= Db.RunSQL("SELECT trafficbypageid FROM trafficbypage WHERE pagename='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(scriptName, 255))+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEx!=null && rstEx.length>0){
            for(int j=0; j<rstEx.length; j++){
                //-----------------------------------
                //-----------------------------------
                int count2 = Db.RunSQLUpdate("UPDATE trafficbypage SET count=count+1 WHERE pagename='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(scriptName, 255))+"'");
                //-----------------------------------
                //-----------------------------------
            }
        } else {
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO trafficbypage(pagename, count) VALUES('"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(scriptName, 255))+"', '1')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    private void saveBandwidth(){
        reger.Bandwidth.addActivity(accountid, bandwidth);
    }

    private static String getScriptName(String in){
        String urlBase = "";
        try{
            String url = in;
            String[] urlSplitOnDoubleSlash = url.split("//", 2);
            if (urlSplitOnDoubleSlash.length>=2){
                String urlHttpStripped = urlSplitOnDoubleSlash[1];
                String[] urlHttpStrippedSplitOnSlash = urlHttpStripped.split("/", 2);
                if (urlHttpStrippedSplitOnSlash.length>=2){
                    String urlDomainStripped = urlHttpStrippedSplitOnSlash[1];
                    String[] urlDomainStrippedSplitOnQuestionMark = urlDomainStripped.split("\\?", 2);
                    if (urlDomainStrippedSplitOnQuestionMark.length>=2){
                        urlBase = urlDomainStrippedSplitOnQuestionMark[0];
                    } else {
                        urlBase = urlDomainStripped;
                    }
                } else {
                    urlBase = urlHttpStripped;
                }
            } else {
                urlBase = url;
            }
        } catch (Exception e){
            reger.core.Util.errorsave(e);
            urlBase = in;
        }
        return urlBase;
    }

    public void incrementCount(){
        count = count + 1;
    }

}
