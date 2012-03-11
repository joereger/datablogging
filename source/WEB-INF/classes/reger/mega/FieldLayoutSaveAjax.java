package reger.mega;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;
import reger.Log;
import reger.MegaLogType;
import reger.cache.LogCache;
import reger.util.Num;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joereger
 * Date: 3/10/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class FieldLayoutSaveAjax extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass().getName());

        //Pull up the userSession
        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        reger.UserSession userSession = allUserSessions.getUserSession(request, response);

        int logid = 0;
        if (Num.isinteger(request.getParameter("logid"))){
            logid = Integer.parseInt(request.getParameter("logid"));
        }

        int eventtypeid = 0;
        if (Num.isinteger(request.getParameter("eventtypeid"))){
            eventtypeid = Integer.parseInt(request.getParameter("eventtypeid"));
        }


        //Security check
        boolean doUpdate = false;

        //Log security
        if (logid>0){
            if (userSession.getAccountuser().userCanViewLog(logid)){
                if (userSession.getAccountuser().userCanDoAcl("CUSTOMIZELOG", userSession.getAccount().getAccountid())){
                    doUpdate = true;
                }
            }
        }

        //Log type security
        if (eventtypeid>0){
            MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
            if (mlt!=null){
                if (mlt.getAccountuserid()==userSession.getAccountuser().getAccountuserid()){
                    doUpdate = true;
                }
            }
        }

        //Do the update
        if (doUpdate){
            String[] megafieldcol1 = request.getParameterValues("megafieldidcol1");
            String[] megafieldcol2 = request.getParameterValues("megafieldidcol2");
            String[] megafieldcol3 = request.getParameterValues("megafieldidcol3");

            //Debug
            logger.debug("logid="+logid+" eventtypeid="+eventtypeid);
            for (int i = 0; i < megafieldcol1.length; i++) {
                String m = megafieldcol1[i];
                logger.debug("col1: "+m);
            }
            for (int i = 0; i < megafieldcol2.length; i++) {
                String m = megafieldcol2[i];
                logger.debug("col2: "+m);
            }
            for (int i = 0; i < megafieldcol3.length; i++) {
                String m = megafieldcol3[i];
                logger.debug("col3: "+m);
            }

            //Rebuild into a single string
            //Just use (and save) incoming querystring... it'll have extraneous logid/eventtypeid name/vars with it but those can be filtered out later on
            String fieldorder = request.getQueryString();


            //Save
            if (logid>0){
                Log log = LogCache.get(logid);
                log.setFieldorder(fieldorder);
                log.save();
            } else if (eventtypeid>0){
                MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
                mlt.setFieldorder(fieldorder);
                mlt.save();
            }

            //Test
            logger.debug("Outputting parsed namevaluepairs");
            List<NameValuePair> nvs = URLEncodedUtils.parse(URI.create("http://foo.com/bar.html?" + fieldorder), "UTF-8");
            for (Iterator<NameValuePair> iterator = nvs.iterator(); iterator.hasNext();) {
                NameValuePair nv = iterator.next();
                logger.debug(nv.getName()+"="+nv.getValue());
            }

        } else {
            logger.debug("doUpdate=false, not saving");
        }







    }
}
