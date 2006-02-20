package reger.api.saaj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.xml.soap.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 */
public class HelloWorld extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            reger.core.Debug.debug(5, "HelloWorld.java", "Made it to doPost()");

            //Do SOAP Stuff... Clean Hands
            MimeHeaders mimeHeaders = new MimeHeaders();
            Enumeration en = request.getHeaderNames();
            while (en.hasMoreElements()) {
                String headerName = (String)en.nextElement();
                String headerVal = request.getHeader(headerName);
                StringTokenizer tk = new StringTokenizer(headerVal, ",");
                while (tk.hasMoreTokens()){
                    mimeHeaders.addHeader(headerName, tk.nextToken().trim());
                }
            }
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage(mimeHeaders, request.getInputStream());
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPBody body = message.getSOAPBody();

            //Get the base info
            Iterator filesyncfiles = body.getChildElements(soapFactory.createName("FileSyncFile", "fileSync", "http://www.reger.com/soap/FileSync"));
            SOAPElement filesyncfile = (SOAPElement)filesyncfiles.next();
            if (filesyncfile!=null){
                Iterator ageIt = filesyncfile.getChildElements(soapFactory.createName("email"));
                SOAPElement emailEl = (SOAPElement)ageIt.next();
                String email = "";
                if (emailEl!=null){
                    email = emailEl.getValue();
                }

                Iterator pwIt = filesyncfile.getChildElements(soapFactory.createName("password"));
                SOAPElement pwEl = (SOAPElement)pwIt.next();
                String password = "";
                if (pwEl!=null){
                    password = pwEl.getValue();
                }

                //Attachment
                Iterator attachments = message.getAttachments();
                while (attachments.hasNext()) {
                    AttachmentPart att = (AttachmentPart)attachments.next();
                    String filenameandpath = att.getContentId();
                    InputStream is = att.getDataHandler().getInputStream();
                    FileOutputStream os = new FileOutputStream("C:/blogTestSync/infromsoap/" + filenameandpath);
                    byte[] buff = new byte[1024];
                    int read = 0;
                    while ((read = is.read(buff, 0, buff.length)) != -1) {
                        os.write(buff, 0, read);
                    }
                    os.flush();
                    os.close();
                }
            }

            //Response
            SOAPMessage reply = messageFactory.createMessage();
            SOAPHeader header = reply.getSOAPHeader();
            header.detachNode();
            SOAPBody replyBody = reply.getSOAPBody();
            SOAPBodyElement bodyElement = replyBody.addBodyElement(soapFactory.createName("ack"));
            bodyElement.addTextNode("OK");
            response.setHeader("Content-Type", "text/xml");
            OutputStream os = response.getOutputStream();
            reply.writeTo(os);
            os.flush();

        } catch (Exception e){
            reger.core.Debug.errorsave(e, "HelloWorld.java");
        }

    }


}
