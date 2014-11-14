package reger.http;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.InputStream;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import reger.core.Debug;

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
                    while (is!=null && buff!=null && (k=is.read(buff))!=-1 && bufferCounts<=1){
                        xOutputStream.write(buff,0,k);
                        if (bytesToGet>0){
                            bufferCounts=bufferCounts+1;
                        }
                    }
                    responsebody = responsebody + xOutputStream.toString();
                    if (is!=null){
                        is.close();
                    }
                    method.recycle();

                    //Set the flag
                    successfulCallWasMade = true;


                } catch (HttpRecoverableException e) {
                    //Do nothing... retry
                    Debug.debug(5, "", e);
                } catch (IOException e) {
                    //Do nothing... network error
                    Debug.debug(5, "", e);
                } catch (java.lang.IllegalArgumentException iae){
                    //Do nothing... the host param was null
                    Debug.debug(5, "", iae);
                } catch (Exception e) {
                    //Oops... something went wrong
                    Debug.errorsave(e, "", "Trying to get via http in Http.getUrl: " + urlToGet);
                }
            }

            // Release the connection.
            method.releaseConnection();
        }
    }


}
