package reger.chiba.adapter.flux;

import org.apache.log4j.Category;
import org.chiba.adapter.ChibaAdapter;
//import org.chiba.adapter.servlet.ChibaServlet;
//import org.chiba.adapter.servlet.ServletAdapter;
import org.chiba.xml.xforms.config.Config;
import org.chiba.xml.xforms.exception.XFormsException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Adapter for processing DWR calls and building appropriate responses.
 *
 * @author Joern Turner
 * @version $Version: $
 */
public class DWRAdapter {

    public DWRAdapter() {
    }

    public void updateControl(String id, String value){
    }

    public void dispatch(String id){
    }
}

