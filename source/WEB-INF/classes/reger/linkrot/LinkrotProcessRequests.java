package reger.linkrot;

import reger.core.Debug;
import reger.PrivateLabel;
import org.apache.commons.httpclient.Header;

/**
 *
 */
public class LinkrotProcessRequests implements Runnable {

    private String url = "";

    public LinkrotProcessRequests(String url){
        this.url = url;
    }

    public void run(){

        //Go get the URL from the web

        Debug.debug(3, "", "url:"+url+"<br>LinkrotProcessRequests.processRequest() - starting call");

        if (!url.equals("")){

            //See if it's a url that's external
            boolean isExternal = true;
            reger.PrivateLabel[] pls = reger.AllPrivateLabelsInSystem.getAllPrivateLabels();
            for (int i = 0; i < pls.length; i++) {
                PrivateLabel pl = pls[i];
                if (url.indexOf(pl.getPlbasedomain())>0){
                    Debug.debug(3, "", "FOUND PL-Centered Url: " + url);
                    isExternal = false;
                }
            }

            //Process results
            if (isExternal){

                //Create the http connection
                reger.http.Http myHttp = new reger.http.Http();
                myHttp.getUrl(url, 10000);

                if (myHttp!=null && myHttp.successfulCallWasMade){
                    //Debug
                    Debug.debug(3, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.processRequest() - successfulCallWasMade myHttp.statusCode=" + myHttp.statusCode);
                    if (myHttp.statusCode<300){
                        process200(myHttp);
                    } else if (myHttp.statusCode==300){
                        process301(myHttp);
                    } else if (myHttp.statusCode==301){
                        process301(myHttp);
                    } else if (myHttp.statusCode>=302 && myHttp.statusCode<=399){
                        process301(myHttp);
                    } else if (myHttp.statusCode>=400 && myHttp.statusCode<403){
                        process404(myHttp);
                    } else if (myHttp.statusCode==404){
                        process404(myHttp);
                    } else if (myHttp.statusCode>=405 && myHttp.statusCode<499){
                        process404(myHttp);
                    } else if (myHttp.statusCode==500){
                        process500(myHttp);
                    } else if (myHttp.statusCode>500){
                        process500(myHttp);
                    } else {
                        process404(myHttp);
                    }
                } else {
                    process404(myHttp);
                }
            }

        }


    }



    //Deal with successful requests that garnered valid data
    private void process200(reger.http.Http myHttp){
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process200() - start");
        //Note the last date that this was verified in the
        //Crunch the page to keywords
        String keywords = reger.linkrot.GenerateKeywords.getKeywords(myHttp.responsebody);
        //Update the sucker
        Util.updateLinkrot(myHttp.url, keywords, false, "", 200);
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process200() - end");
    }

    //Deal with redirects
    private void process301(reger.http.Http myHttp){
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process301() - start");
        String redirectUrl = "";

        for (int i = 0; i < myHttp.headers.length; i++) {
            Header thisHeader = myHttp.headers[i];
            if (thisHeader.getName().equals("Location")){
                redirectUrl = thisHeader.getValue();
            }
        }

        //Go get the URL from the web
        //reger.http.Http myRedirectedHttp = new reger.http.Http();
        //myRedirectedHttp.getUrl(redirectUrl, 10000);

        //Update the sucker without updating keywords
        Util.updateLinkrot(myHttp.url, "", true, redirectUrl, 301);
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process301() - end");

    }

    //Deal with page not founds
    private void process404(reger.http.Http myHttp){
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process404() - start");
        //Update the sucker
        Util.updateLinkrot(myHttp.url, "", true, "", 404);
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process404() - end");
    }

    //Deal with server errors
    private void process500(reger.http.Http myHttp){
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process500() - start");
        //Update the sucker
        Util.updateLinkrot(myHttp.url, "", true, "", 500);
        //Debug
        Debug.debug(5, "", "url:"+myHttp.url+"<br>LinkrotProcessRequests.process500() - end");
    }


}
