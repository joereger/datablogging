package reger.geo;



import java.awt.Color;


import com.bbn.openmap.layer.OMGraphicHandlerLayer;
import com.bbn.openmap.omGraphics.*;
import com.bbn.openmap.proj.Projection;
import reger.UserSession;
import reger.Location;

/**
 * Blog entries on a map
 */
public class BlogEntryMapLayer extends OMGraphicHandlerLayer {

    private UserSession userSession;
    private int activeLocationid=0;


    /**
     * Construct a default route layer. Initializes omgraphics to a
     * new OMGraphicList, and invokes createGraphics to create the
     * canned list of routes.
     */
    public BlogEntryMapLayer() {
        //omgraphics = new OMGraphicList();
        //createGraphics(omgraphics);

    }

    public OMGraphicList prepare(){
        System.out.println("prepare() called. ");
        if (getList()==null){
            setList(createGraphics(getProjection()));
            System.out.println("list of graphics refreshed: " + getList().getDescription());
        }
        return getList();
    }


    public OMLine createLine(float lat1, float lon1, float lat2, float lon2, Color color) {
        OMLine line = new OMLine(lat1, lon1, lat2, lon2, OMGraphic.LINETYPE_GREATCIRCLE);
        line.setLinePaint(color);
        return line;
    }

    public OMCircle createCircle(float lat, float lon, int size, Color fillColor, Color lineColor){
        OMCircle circle = new OMCircle(lat, lon, size, size);
        circle.setFillPaint(fillColor);
        circle.setLinePaint(lineColor);
        return circle;
    }

    public OMText createText(float lat, float lon, String text){
        OMText circle = new OMText(lat, lon, text, OMText.JUSTIFY_LEFT);
        return circle;
    }

    /**
     * Clears and then fills the given OMGraphicList. Creates three
     * lines for display on the map.
     */
    public OMGraphicList createGraphics(Projection p) {


        OMGraphicList graphics = new OMGraphicList();

        System.out.println("createGraphics called: " + graphics.getDescription());



        if (userSession!=null){
            Location[] locations = Location.getLocationsUserCanView(userSession.getAccountuser(), userSession.getAccount());
            for (int i = 0; i < locations.length; i++) {
                Location location = locations[i];
                reger.core.Util.debug(5, "BlogEntryMapLayer.java - location=" + location.getLocationname() + "<br>lat=" + location.getLatitude() + "<br>lon=" + location.getLongitude());
                if (activeLocationid==0 || activeLocationid==location.getLocationid()){
                    if (location.getLatitude()>0 || location.getLongitude()>0){
                        if (activeLocationid==location.getLocationid()){
                            graphics.addOMGraphic(createText(Float.parseFloat(String.valueOf(location.getLatitude())), Float.parseFloat(String.valueOf(location.getLongitude())), location.getLocationname()));
                        }
                        graphics.addOMGraphic(createCircle(Float.parseFloat(String.valueOf(location.getLatitude())), Float.parseFloat(String.valueOf(location.getLongitude())), 10, Color.YELLOW, Color.DARK_GRAY));

                    }
                }
            }
        }


        //Generate them
        graphics.generate(p);

        System.out.println("graphics.getDescription(): " + graphics.getDescription());


        return graphics;
    }

    public void setUserSession(UserSession userSession){
        this.userSession=userSession;
    }

    public void setActiveLocationid(int activeLocationid) {
        this.activeLocationid = activeLocationid;
    }


}
