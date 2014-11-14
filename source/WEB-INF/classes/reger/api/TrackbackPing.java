package reger.api;

import reger.core.db.Db;
import reger.core.Util;
import reger.core.Debug;
import reger.http.EasySSLProtocolSocketFactory;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.methods.*;
import java.io.*;

/**
 * This class will ping a trackback url and store the results.  It is run as a thread.
 */
public class TrackbackPing extends Thread {

    public String rawUrlsToPing; //Multiple URLs in a single box separated by line end chars
	public String[] urlsToPing = new String[0];
	public int eventid = -1;
	public reger.Account accountOfEntry;

	/**
     * Constructor used to set the properties needed to run
     */
    public TrackbackPing() {
        //this.something = something;
    }

    /**
     * Constructor used to set the properties needed to run
     */
    public void init() {
        run();
    }

	public void run() {
	    //General plan here is to put all urls that need to be pinged into the database first
	    //making sure that I check to dupes and then later ping them all

        //Parse the urls
        parseUrls();

        //Save urls to the database
        for (int i = 0; i < urlsToPing.length; i++) {
            saveUrlToDb(urlsToPing[i]);
        }

        //Clean dead trackbacks
        cleanDeadTrackbacks();

        //Now I go in and start the pinging
        //-----------------------------------
        //-----------------------------------
        String[][] rstUrls= Db.RunSQL("SELECT trackback.url, event.title, event.comments, trackbackid FROM trackback, event WHERE event.eventid=trackback.eventid AND event.eventid='"+eventid+"' AND isoutbound='1' AND ispingedalready='0' AND "+reger.Entry.sqlOfLiveEntry+"");
        //-----------------------------------
        //-----------------------------------
        if (rstUrls!=null && rstUrls.length>0){
        	for(int i=0; i<rstUrls.length; i++){
        	    //Get Blog Name
        	    String blogname = accountOfEntry.getHomepagetitle();
        	    if (blogname.equals("")){
                    blogname = "" + accountOfEntry.getSiteRootUrl() + "/";
                }
        	    //Do the pinging
        	    boolean successfulPing = false;
                successfulPing = pingUrl(rstUrls[i][0], rstUrls[i][1], reger.core.Util.truncateString(rstUrls[i][2], 255), blogname);

        	    //Update the database on success
        	    if (successfulPing){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("UPDATE trackback SET ispingedalready='1' WHERE trackbackid='"+rstUrls[i][3]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
        	}
        }


    }

    private void parseUrls(){
        //Split the rawurl list
        urlsToPing = rawUrlsToPing.split("\\n");
        //Trim the urls
        for (int i = 0; i < urlsToPing.length; i++) {
            urlsToPing[i]=urlsToPing[i].trim();
        }
        //reger.core.Util.logStringArrayToDb("Array of urlsToPing after splitting.", urlsToPing);
    }

    private void saveUrlToDb(String url){
        //-----------------------------------
        //-----------------------------------
        String[][] rstTrackback= Db.RunSQL("SELECT trackbackid FROM trackback WHERE eventid='"+eventid+"' AND url='"+url+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstTrackback!=null && rstTrackback.length>0){
        	//Do nothing, the url already exists in the database
        } else {
            //It doesn't exist so I need to add it
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO trackback(eventid, isoutbound, url, blogname, posttitle, excerpt, datetime) VALUES('"+eventid+"', '1', '"+Util.cleanForSQL(url)+"', '', '', '', '"+reger.core.TimeUtils.nowInGmtString()+"')");
            //-----------------------------------
            //-----------------------------------
        }


    }

    private boolean pingUrl(String urlToPing, String title, String excerpt, String blogname){

        Debug.debug(5, "", "Trackbackping.java - pingUrl called. urlToPing=" + urlToPing);

        //Build this url
        String localUrl = "" + accountOfEntry.getSiteRootUrl() + "/entry-eventid"+eventid+".log";

        //Custom SSL handler
        Protocol.registerProtocol("https", new Protocol("https", new EasySSLProtocolSocketFactory(), 443));

        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        PostMethod method = new PostMethod(urlToPing);

        //Add the parameters
        method.addParameter("title", title);
        method.addParameter("url", localUrl);
        method.addParameter("excerpt", excerpt);
        method.addParameter("blog_name", blogname);

        //Execute the method.
        int statusCode = -1;
        //I will retry up to 3 times.
        for (int attempt = 0; statusCode == -1 && attempt < 3; attempt++) {

            try {
                // execute the method.
                statusCode = client.executeMethod(method);
            } catch (IOException e) {
                //Do nothing... network error
                Debug.debug(5, "", e);
            } catch (Exception e) {
                //Oops... something went wrong
                Debug.errorsave(e, "", "Trying to ping: " + urlToPing);
            }
        }

        // Release the connection.
        method.releaseConnection();

        // Check that we didn't run out of retries.
        if (statusCode == -1) {
            //Oops... something went wrong
            return false;
        }

        return true;

    }

    private void cleanDeadTrackbacks(){
        //Delete URLs that aren't in the current list of urls
        //-----------------------------------
        //-----------------------------------
        String[][] rstTrB= Db.RunSQL("SELECT url, trackbackid FROM trackback WHERE eventid='"+eventid+"' AND isoutbound='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstTrB!=null && rstTrB.length>0){
        	for(int i=0; i<rstTrB.length; i++){
                //Look for this url in the current list of urlstoping
                boolean itIsInCurrentList = false;
                for (int j = 0; j < urlsToPing.length; j++) {
                    if(rstTrB[i][0].equals(urlsToPing[j])){
                        itIsInCurrentList=true;
                    }
                }
                //If it's not found, delete it from the Db... user has erased it
                if (!itIsInCurrentList){
                    //-----------------------------------
                    //-----------------------------------
                    int count = Db.RunSQLUpdate("DELETE FROM trackback WHERE trackbackid='"+rstTrB[i][1]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
        	}
        }
    }

}
