package reger.filesync.server.soap;

import reger.filesync.server.FileSyncServer;
import reger.filesync.server.Util;
import reger.Accountuser;
import reger.Account;
import reger.cache.AccountCache;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.xml.soap.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Hashtable;

/**
 *
 */
public class DownloadFileFromServer extends HttpServlet {

    static MessageFactory messageFactory = null;

    static {
        try {
            messageFactory = MessageFactory.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            reger.core.Debug.debug(5, "DownloadFileFromServer.java", "Made it to doPost()");

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
            //MessageFactory messageFactory = MessageFactory.newInstance();
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

                Iterator fnIt = filesyncfile.getChildElements(soapFactory.createName("file"));
                SOAPElement fnEl = (SOAPElement)fnIt.next();
                String file = "";
                if (fnEl!=null){
                    file = fnEl.getValue();
                }

                reger.core.Debug.debug(5, "DownloadFileFromServer.java", "email:"+email+"<br>file:"+file);

                //Go to the original XML-RPC API
                FileSyncServer fss = new FileSyncServer();
                Hashtable res = fss.downloadFileFromServer(email, password, file);
                downloadFileFromServerRespose(email, password, res, response);
            }



        } catch (Exception e){
            reger.core.Debug.errorsave(e, "DownloadFileFromServer.java");
        }

    }

//    private void downloadFileFromServerRespose(String email, String password, Hashtable res, HttpServletResponse response){
//        try{
//            if (((String)res.get("success")).equals("1")){
//                byte[] filebytes = (byte[])res.get("filebytes");
//                String lastmodifieddateinmillis = (String)res.get("lastmodifieddateinmillis");
//                MessageFactory messageFactoryOut = MessageFactory.newInstance();
//                SOAPFactory soapFactoryOut = SOAPFactory.newInstance();
//                SOAPMessage reply = messageFactoryOut.createMessage();
//                SOAPHeader header = reply.getSOAPHeader();
//                header.detachNode();
//                SOAPBody replyBody = reply.getSOAPBody();
//
//
//                SOAPBodyElement fileElement = replyBody.addBodyElement(soapFactoryOut.createName("FileSyncFile", "fileSync", "http://www.reger.com/soap/FileSync"));
//
//                SOAPElement lmEl = fileElement.addChildElement("lastmodifieddateinmillis");
//                lmEl.addTextNode(lastmodifieddateinmillis);
//
//                Accountuser au = new reger.Accountuser(email, password);
//                if (au.isLoggedIn){
//                    Account account = AccountCache.get(au.getAccountid());
//                    File fileToSend = new File(Util.getFilenamePlusDirectoryName((String)res.get("file"), account));
//                    DataHandler dataHandler = new DataHandler(new FileDataSource(fileToSend));
//                    AttachmentPart att = reply.createAttachmentPart(dataHandler);
//                    att.setContentId((String)res.get("file"));
//                    reply.addAttachmentPart(att);
//                } else {
//                    sendError("Failed authentication.", response);
//                }
//                response.setHeader("Content-Type", "text/xml");
//                OutputStream os = response.getOutputStream();
//                reply.writeTo(os);
//                os.flush();
//                reger.core.Debug.debug(5, "DownloadFileFromServer.java", "Successfully sent file, in theory.");
//            } else {
//                sendError((String)res.get("error"), response);
//            }
//        } catch (Exception e){
//            reger.core.Debug.errorsave(e, "DownloadFileFromServer.java");
//        }
//    }

    private void downloadFileFromServerRespose(String email, String password, Hashtable res, HttpServletResponse response){
        try{
            if (((String)res.get("success")).equals("1")){
                SOAPMessage reply = null;
                Accountuser au = new reger.Accountuser(email, password);
                if (au.isLoggedIn){
                    Account account = AccountCache.get(au.getAccountid());
                    File fileToSend = new File(Util.getFilenamePlusDirectoryName((String)res.get("file"), account));
                    reply = getDownloadMessage((String)res.get("file"), (String)res.get("lastmodifieddateinmillis"), fileToSend);
                } else {
                    sendError("Failed authentication.", response);
                }
                if (reply!=null){

                    //response.setHeader("Content-Type", "text/xml");
                    reply.saveChanges();
                    response.setStatus(HttpServletResponse.SC_OK);
                    putHeaders(reply.getMimeHeaders(), response);

                    OutputStream os = response.getOutputStream();
                    reply.writeTo(os);
                    os.flush();
                    os.close();
                    reger.core.Debug.debug(5, "DownloadFileFromServer.java", "Successfully sent file, in theory.");
                } else {
                    sendError ("Problem writing output.", response);
                }
            } else {
                sendError((String)res.get("error"), response);
            }
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "DownloadFileFromServer.java");
        }
    }



    public static SOAPMessage getDownloadMessage(String file, String lastmodifieddateinmillis, File fileToSend){
        try{
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            //MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();
            SOAPHeader header = message.getSOAPHeader();
            header.detachNode();
            SOAPBody body = message.getSOAPBody();

            Name filesyncfile = soapFactory.createName("FileSyncFile", "fileSync", "http://www.reger.com/soap/FileSync");
            SOAPBodyElement fileElement = body.addBodyElement(filesyncfile);

            SOAPElement lmEl = fileElement.addChildElement("lastmodifieddateinmillis");
            lmEl.addTextNode(lastmodifieddateinmillis);

            DataHandler dataHandler = new DataHandler(new FileDataSource(fileToSend));
            AttachmentPart att = message.createAttachmentPart(dataHandler);
            att.setContentId(file);
            message.addAttachmentPart(att);

            message.saveChanges();

            //ByteArrayOutputStream os = new ByteArrayOutputStream();
            //message.writeTo(os);
            //reger.core.Debug.debug(5, "DownloadFileFromServer.java", os.toString().replaceAll("<", "&lt;"));

            return message;
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "DownloadFileFromServer.java");
        }
        return null;
    }



    private void sendError(String error, HttpServletResponse response){
        try{
            //MessageFactory messageFactoryOut = MessageFactory.newInstance();
            SOAPFactory soapFactoryOut = SOAPFactory.newInstance();
            SOAPMessage reply = messageFactory.createMessage();
            SOAPHeader header = reply.getSOAPHeader();
            header.detachNode();
            SOAPBody replyBody = reply.getSOAPBody();
            SOAPBodyElement bodyElement = replyBody.addBodyElement(soapFactoryOut.createName("error"));
            bodyElement.addTextNode(error);
            response.setHeader("Content-Type", "text/xml");
            OutputStream os = response.getOutputStream();
            reply.writeTo(os);
            os.flush();
            reger.core.Debug.debug(5, "DownloadFileFromServer.java", "Fail, sending error message:" + error);
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "DownloadFileFromServer.java");
        }
    }


    static void putHeaders(MimeHeaders headers, HttpServletResponse res) {
        Iterator it = headers.getAllHeaders();

        while (it.hasNext()) {
            MimeHeader header = (MimeHeader) it.next();

            String[] values = headers.getHeader(header.getName());

            if (values.length == 1) {
                res.setHeader(header.getName(), header.getValue());
            } else {
                StringBuffer concat = new StringBuffer();
                int i = 0;

                while (i < values.length) {
                    if (i != 0) {
                        concat.append(',');
                    }

                    concat.append(values[i++]);
                }

                res.setHeader(header.getName(), concat.toString());
            }
        }
    }





}
