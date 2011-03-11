package reger;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
//import com.sun.image.codec.jpeg.*;

import reger.core.Debug;


import java.io.OutputStream;
import javax.imageio.ImageWriter;
import javax.imageio.ImageWriteParam;
import javax.imageio.IIOImage;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.plugins.jpeg.*;


/**
 * Resize an image that already exists on the filesystem
 */
public class ResizeImage{

    public static boolean resize(String inimagelocation, String outimagelocation, int maxwidth) throws IOException {
        try {
          reger.core.Debug.debug(5, "ResizeImage.java", "resize() called<br>inimagelocation:"+inimagelocation+"<br>outimagelocation:"+outimagelocation);

          int targetWidth=0;
          int targetHeight=0;

          //ImageIcon is a kluge to make sure the image is fully loaded before I proceed.
          Image sourceImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(inimagelocation)).getImage();

          // Calculate the target width and height
          targetWidth = maxwidth;
          targetHeight = getHeightForFixedWidth(sourceImage.getWidth(null), sourceImage.getHeight(null), maxwidth);

          //Do the resize
          BufferedImage resizedImage = scaleImage(sourceImage,targetWidth,targetHeight);

          //Create the output file handler
          //BufferedOutputStream outFile = new BufferedOutputStream(new FileOutputStream(outimagelocation));
          FileImageOutputStream outFile = new FileImageOutputStream(new File(outimagelocation));

          ImageWriter encoder = (ImageWriter) ImageIO.getImageWritersByFormatName("JPEG").next();
          JPEGImageWriteParam param = new JPEGImageWriteParam(null);

          param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
          param.setCompressionQuality(0.9f);

          encoder.setOutput(outFile);
          encoder.write((IIOMetadata) null, new IIOImage(resizedImage,null,null), param);


          //Below is the OLD way which relies on sun's JPEG implementation (not in OpenJDK)

          // Output the finished image straight to the response as a JPEG!
          //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outFile);

          //Set some jpeg parameters
          //JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(resizedImage);
          //int quality = Integer.parseInt("90");
          //quality = Math.max(0, Math.min(quality, 100));
          //param.setQuality((float)quality / 100.0f, false);
          //encoder.setJPEGEncodeParam(param);

          //Do the actual encoding which will save it to the file system
          //encoder.encode(resizedImage);

        } catch(Exception e) {
            //@todo Copy generic file thumbnail working.  (It is coded but failing because it can't find the sourcefile)
            //Try to copy the generic file thumbnail and if it fails record an error.
            //reger.core.Debug.debug(5, "ResizeImage.java", "resize() called<br>inimagelocation:"+inimagelocation+"<br>outimagelocation:"+outimagelocation);
            reger.core.Debug.debug(5, "ResizeImage.java", "fail creating thumbnail: "+e.getMessage());
            Debug.errorsave(e, "ResizeImage.java");
            if (!reger.core.Util.copyFile(reger.Vars.THUMBNAILGENERIC + "", outimagelocation)) {
                Debug.logtodb("Unsuccessful copy of THUMBNAILGENERIC.  See ResizeImage.java around line 49.  Error will be saved to database in next error entry.", "");
                Debug.errorsave(e, "");
            }
            return false;
        }
        return true;
    }

    private static BufferedImage scaleImage(Image sourceImage, int width, int height) {
        ImageFilter filter = new ReplicateScaleFilter(width,height);
        ImageProducer producer = new FilteredImageSource
        (sourceImage.getSource(),filter);
        Image resizedImage = Toolkit.getDefaultToolkit().createImage(producer);
        return toBufferedImage(resizedImage);
    }

    private static BufferedImage toBufferedImage(Image image) {
        image = new ImageIcon(image).getImage();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null) ,image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,image.getWidth(null),image.getHeight(null));
        g.drawImage(image,0,0,null);
        g.dispose();
        return bufferedImage;
    }

    /**
     * Given a goalwidth for an image, this function returns the height that is required to maintain aspect ratio.
     * @param currentwidth = the curent width of the image.
     * @param currentheight = the current height of the image.
     * @param goalwidth = the width that the image is being resized to.
     */
    public static int getHeightForFixedWidth(int currentwidth, int currentheight, int goalwidth) {
        int outheight=0;
        outheight = currentheight * goalwidth / currentwidth;
        return outheight;
    }
}
