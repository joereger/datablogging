package reger.http;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.InputStream;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 *
 */
public class Http {

    public int statusCode = -1;
    public String responsebody = "";
    public boolean successfulCallWasMade = false;
    public Header[] headers;
    public String url = "";

    /**
     * Call with bytesToGet = -1 to get all bytes
     * @param urlToGet
     * @param bytesToGet
     */
    public void getUrl(String urlToGet, int bytesToGet){
        if (urlToGet!=null && !urlToGet.equals("")){
            //reger.core.Util.logtodb("getUrl called. urlToGet=" + urlToGet);

            //Save the url
            this.url = urlToGet;

            //Custom SSL handler
            Protocol.registerProtocol("https", new Protocol("https", new EasySSLProtocolSocketFactory(), 443));


            //Create an instance of HttpClient.
            HttpClient client = new HttpClient();
            client.setTimeout(10000);
            client.setConnectionTimeout(10000);

            // Create a method instance.
            GetMethod method = new GetMethod();
            boolean goodURI = true;
            try {
                method = new GetMethod(urlToGet);
            } catch (Exception e){
                goodURI=false;
            }


            //Retry up to 3 times.
            for (int attempt = 0; statusCode == -1 && attempt < 3 && goodURI && method.validate(); attempt++) {
                //reger.core.Util.logtodb("attempt="+attempt+"<br> urlToGet=" + urlToGet);

                try {
                    //This is a problem
                    //http://kotisivu.mtv3.fi/zurm/kuramutkankutsu.mp3

                    //Execute the get method.
                    statusCode = client.executeMethod(method);

                    //Set the headers, etc.
                    headers = method.getResponseHeaders();

                    //Read the results
                    //responsebody = method.getResponseBodyAsString();

                    InputStream is = method.getResponseBodyAsStream();
                    int k;
                    int aBuffSize = bytesToGet;
                    if (aBuffSize<=0){
                        aBuffSize = 50000;   
                    }
                    byte buff[] = new byte[aBuffSize];
                    OutputStream xOutputStream = new ByteArrayOutputStream(aBuffSize);
                    //How many times should the buffer be filled?
                    //This is just a way to limit the amount of data collected.
                    int bufferCounts=1;
                    //reger.core.Util.logtodb("Before while loop.  attempt="+attempt+"<br> urlToGet=" + urlToGet);
                    while (is!=null && buff!=null && (k=is.read(buff))!=-1 && bufferCounts<=1){
                        xOutputStream.write(buff,0,k);
                        if (bytesToGet>0){
                            bufferCounts=bufferCounts+1;
                        }
                    }
                    //reger.core.Util.logtodb("After while loop. attempt="+attempt+"<br> urlToGet=" + urlToGet);
                    responsebody = responsebody + xOutputStream.toString();
                    if (is!=null){
                        is.close();
                    }
                    method.recycle();

                    //Set the flag
                    successfulCallWasMade = true;

                    //Debug
                    //reger.core.Util.logtodb("statusCode:" + statusCode);

                } catch (HttpRecoverableException e) {
                    //Do nothing... retry
                    reger.core.Util.debug(5, e);
                } catch (IOException e) {
                    //Do nothing... network error
                    reger.core.Util.debug(5, e);
                } catch (java.lang.IllegalArgumentException iae){
                    //Do nothing... the host param was null
                    reger.core.Util.debug(5, iae);
                } catch (Exception e) {
                    //Oops... something went wrong
                    reger.core.Util.errorsave(e, "Trying to get via http in Http.getUrl: " + urlToGet);
                }
            }

            // Release the connection.
            method.releaseConnection();
        }
    }


}
