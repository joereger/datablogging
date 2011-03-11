package reger.jcaptcha;


import com.octo.captcha.service.CaptchaServiceException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import reger.core.Debug;


/**
 * Serves a captcha image
 */
public class ImageCaptchaServlet extends HttpServlet {


    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

    }


    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try{
           byte[] captchaChallengeAsJpeg = null;
           // the output stream to render the captcha image as jpeg into
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            try {
                // get the session id that will identify the generated captcha.
                //the same id must be used to validate the response, the session id is a good candidate!
                String captchaId = httpServletRequest.getSession().getId();

                // call the ImageCaptchaService getChallenge method
                BufferedImage challenge = CaptchaServiceSingleton.getInstance().getImageChallengeForID(captchaId, httpServletRequest.getLocale());
      
                // a jpeg encoder
                //JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
                //jpegEncoder.encode(challenge);



                ImageWriter encoder = (ImageWriter) ImageIO.getImageWritersByFormatName("JPEG").next();
                JPEGImageWriteParam param = new JPEGImageWriteParam(null);

                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.9f);

                encoder.setOutput(jpegOutputStream);
                encoder.write((IIOMetadata) null, new IIOImage(challenge,null,null), param);



            } catch (IllegalArgumentException e) {
                httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            } catch (CaptchaServiceException e) {
                httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }

            captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

            // flush it in the response
            httpServletResponse.setHeader("Cache-Control", "no-store");
            httpServletResponse.setHeader("Pragma", "no-cache");
            httpServletResponse.setDateHeader("Expires", 0);
            httpServletResponse.setContentType("image/jpeg");
            ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (Exception e){
            Debug.errorsave(e, "ImageCaptchaServlet.java", "captchaId="+httpServletRequest.getSession().getId());
        }
    }
}
