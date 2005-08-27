package reger.geo;

import java.io.IOException;
import java.util.Properties;
import java.util.Vector;
import java.awt.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.bbn.openmap.Layer;
import com.bbn.openmap.util.ComponentFactory;
import com.bbn.openmap.util.Debug;
import com.bbn.openmap.image.*;
import com.bbn.openmap.proj.Projection;
import com.bbn.openmap.proj.ProjectionFactory;
import reger.UserSession;

public class MapGenerator {

    public static Layer polLayer;
    public static Layer gratLayer;
    //public static Layer blogLayer;
    public static Layer[] defaultLayers;
    //public static ImageServer imageServer;
    public static SunJPEGFormatter  formatter = new SunJPEGFormatter ();
    public static Properties configProperties;
    public static Projection defaultProjection;

    public MapGenerator() {

        Debug.init();
        Debug.put("imageserver");

        //Political Boundaries Layer
        if (polLayer==null){
            Properties shapeLayerProps = new Properties();
            shapeLayerProps.put("prettyName", "Political Solid");
            shapeLayerProps.put("lineColor", "000000");
            shapeLayerProps.put("fillColor", "BDDE83");
            //shapeLayerProps.put("fillColor", "ffcc00");
            shapeLayerProps.put("shapeFile", reger.core.WebAppRootDir.getWebAppRootPath()+"geodata\\shape\\cntry02\\cntry02.shp");
            shapeLayerProps.put("spatialIndex", reger.core.WebAppRootDir.getWebAppRootPath()+"geodata\\shape\\cntry02\\cntry02.ssx");
            polLayer = (Layer)ComponentFactory.create("com.bbn.openmap.layer.shape.ShapeLayer", shapeLayerProps);
		    System.out.println("polLayer created: " + polLayer.toString());
        }

        //Graticule Layer
        if (gratLayer==null){
            Properties gratLayerProps = new Properties();
            gratLayerProps.put("prettyName", "Graticule Layer");
            gratLayerProps.put("showRuler", "true");
            gratLayerProps.put("show1And5Lines", "true");
            gratLayerProps.put("threshold", "2");
            gratLayerProps.put("10DegreeColor", "99000000");
            gratLayerProps.put("5DegreeColor", "99009900");
            gratLayerProps.put("1DegreeColor", "99003300");
            gratLayerProps.put("equatorColor", "99FF0000");
            gratLayerProps.put("specialLineColor", "99000000");
            gratLayerProps.put("textColor", "99000000");
            gratLayer = (Layer)ComponentFactory.create("com.bbn.openmap.layer.GraticuleLayer", gratLayerProps);
		    System.out.println("gratLayer created: " + gratLayer.toString());
        }

        //Store the defaultLayers in an array
        if (defaultLayers==null){
		    defaultLayers = new Layer[1];
		    //defaultLayers[0] = gratLayer;
		    defaultLayers[0] = polLayer;
        }

        //Initialize the projection
        if (defaultProjection==null){
            defaultProjection = ProjectionFactory.makeProjection(ProjectionFactory.getProjClassForName("com.bbn.openmap.proj.Mercator"), 0f, 0f, 3000000000f, 640, 480);
            System.out.println("defaultProjection created: " + defaultProjection.getName());
        }

        //Initialize the imageServer
        //if (imageServer==null){
            //imageServer = new ImageServer(defaultLayers, formatter);
            //System.out.println("ImageServer created: " + imageServer.toString());
        //}
    }



	public void drawMap(HttpServletRequest request, HttpServletResponse response, Layer[] addonlayers, Projection projection) throws IOException {
        Debug.init();
        Debug.put("imageserver");
        //Add defaultLayers to the finalLayers array
        Layer[] finalLayers = new Layer[addonlayers.length + defaultLayers.length];
        for (int i = 0; i < addonlayers.length; i++) {
            finalLayers[i] = addonlayers[i];
        }
        for (int i = 0; i < defaultLayers.length; i++) {
            finalLayers[i+addonlayers.length] = defaultLayers[i];
        }
        //Setup the imageserver
        ImageServer imageServer = new ImageServer(finalLayers, formatter);
        imageServer.setBackground(Color.WHITE);
        //Create the image using the ImageServer and the projection
        byte[] image = null;
        if (projection==null){
            image = imageServer.createImage(defaultProjection);
        } else {
            image = imageServer.createImage(projection);
        }
        //Send the image to the client
        response.setContentType("image/jpeg");
        response.setContentLength(image.length);
        response.getOutputStream().write(image);
        response.getOutputStream().close();
    }
}

