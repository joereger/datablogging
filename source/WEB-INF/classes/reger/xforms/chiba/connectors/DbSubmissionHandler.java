package reger.xforms.chiba.connectors;

import org.chiba.adapter.ChibaAdapter;
import org.chiba.xml.xforms.Submission;
import org.chiba.xml.xforms.connector.AbstractConnector;
import org.chiba.xml.xforms.connector.SubmissionHandler;
import org.chiba.xml.xforms.connector.serializer.XMLSerializer;
import org.chiba.xml.xforms.exception.XFormsException;
import org.chiba.xml.util.DOMUtil;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import reger.xforms.EventXformData;

/**
 * The file submission driver serializes and submits instance data to a file.
 * <p/>
 * When using the <code>put</code> submission method, the driver only supports
 * the replace mode <code>none</code>. It simply serializes the instance data to
 * the file denoted by the connector URI. When this file exists, it will be
 * overwritten silently, otherwise it will be created.
 * <p/>
 * When using the <code>get</code> submission method, the driver ignores any
 * replace mode. Furthermore, it ignores the instance data completely and
 * returns the file denoted by the connector URI as a response stream.
 *
 */
public class DbSubmissionHandler extends AbstractConnector implements SubmissionHandler {

    public DbSubmissionHandler(){
        reger.core.Debug.debug(3, "DbSubmissionHandler.java", "DbSubmissionHandler instantiated");
    }

    /**
     * Serializes and submits the specified instance data over the
     * <code>file</code> protocol.
     *
     * @param submission the submission issuing the request.
     * @param instance the instance data to be serialized and submitted.
     * @return <code>null</code>.
     * @throws XFormsException if any error occurred during submission.
     */
    public Map submit(Submission submission, Node instance) throws XFormsException {
        reger.core.Debug.debug(3, "DbSubmissionHandler.java", "DbSubmissionHandler.submit() called");

        //@todo What is submission replace all about?
        if (!submission.getReplace().equals("none")) {
            reger.core.Debug.debug(3, "DbSubmissionHandler.java", "submission mode '" + submission.getReplace() + "' not supported");
            throw new XFormsException("submission mode '" + submission.getReplace() + "' not supported");
        }

        try {

            // use scheme specific part in order to handle UNC names
            //This is how to get data from the scheme line
            URI uri = new URI(getURI());
            String uriSpecific = uri.getSchemeSpecificPart();
            reger.core.Debug.debug(3, "DbSubmissionHandler.java", "getContext().get(\"eventid\")="+getContext().get("eventid"));
            reger.core.Debug.debug(3, "DbSubmissionHandler.java", "getContext().get(\"logid\")="+getContext().get("logid"));
            reger.core.Debug.debug(3, "DbSubmissionHandler.java", "putting instance data to database");
            int eventid=0;
            if (getContext().get("eventid")!=null && reger.core.Util.isinteger(String.valueOf(getContext().get("eventid")))){
                eventid=Integer.parseInt(String.valueOf(getContext().get("eventid")));
            }
            int logid=0;
            if (getContext().get("logid")!=null && reger.core.Util.isinteger(String.valueOf(getContext().get("logid")))){
                logid=Integer.parseInt(String.valueOf(getContext().get("logid")));
            }


            // create output steam and serialize instance data
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            BufferedOutputStream bufferedStream = new BufferedOutputStream(byteStream);
            registerSerializer("regerdb", "*", "*", new XMLSerializer());
            serialize(submission, instance, bufferedStream);

            String serializedData = byteStream.toString();

            bufferedStream.close();
            byteStream.close();


            EventXformData eventXformData = new EventXformData();
            eventXformData.loadByEventid(eventid, logid);
            eventXformData.setEventid(eventid);
            eventXformData.setXformdata(serializedData);
            eventXformData.save();


            reger.core.Debug.debug(3, "DbSubmissionHandler.java", "serializedData = <br>"+serializedData.replaceAll("<", "&lt;"));



        } catch (Exception e) {
            reger.core.Debug.debug(3, "DbSubmissionHandler.java", e);
            throw new XFormsException(e);
        }

        return new HashMap();


    }
}

