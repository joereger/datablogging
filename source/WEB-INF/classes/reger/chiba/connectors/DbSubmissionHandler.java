package reger.chiba.connectors;

import org.chiba.adapter.ChibaAdapter;
import org.chiba.xml.xforms.Submission;
import org.chiba.xml.xforms.connector.AbstractConnector;
import org.chiba.xml.xforms.connector.SubmissionHandler;
import org.chiba.xml.xforms.exception.XFormsException;
import org.chiba.xml.util.DOMUtil;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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
        if (submission.getMethod().equalsIgnoreCase("get")) {
            try {
                // create uri
                URI uri = new URI(getURI());

                // use scheme specific part in order to handle UNC names
                String fileName = uri.getSchemeSpecificPart();
                reger.core.Debug.debug(3, "DbSubmissionHandler.java", "getting file '" + fileName + "'");

                // create file
                File file = new File(fileName);
                InputStream inputStream;

                // check for directory
                if (file.isDirectory()) {
                    // create input stream from directory listing
                    Document document = DbURIResolver.buildDirectoryListing(file);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    DOMUtil.prettyPrintDOM(document, outputStream);
                    inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                }
                else {
                    // create file input stream
                    inputStream = new FileInputStream(new File(fileName));
                }

                Map response = new HashMap();
                response.put(ChibaAdapter.SUBMISSION_RESPONSE_STREAM, inputStream);

                return response;
            }
            catch (Exception e) {
                throw new XFormsException(e);
            }
        }

        if (submission.getMethod().equalsIgnoreCase("put")) {
            if (!submission.getReplace().equals("none")) {
                throw new XFormsException("submission mode '" + submission.getReplace() + "' not supported");
            }

            try {
                // create uri
                URI uri = new URI(getURI());

                // use scheme specific part in order to handle UNC names
                String fileName = uri.getSchemeSpecificPart();
                reger.core.Debug.debug(3, "DbSubmissionHandler.java", "putting file '" + fileName + "'");

                // create output steam and serialize instance data
                FileOutputStream stream = new FileOutputStream(new File(fileName));
                serialize(submission, instance, stream);
                stream.close();
            }
            catch (Exception e) {
                throw new XFormsException(e);
            }

            return new HashMap();
        }

        throw new XFormsException("submission method '" + submission.getMethod() + "' not supported");
    }
}

