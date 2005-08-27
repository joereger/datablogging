package reger;

import java.util.*;

public class uriVars {
    
    /**
    * Accepts a URI like /somedir/logid68768-entryid34322.jsp
    * Example getVarFromURI("/somedir/logid68768-entryid34322.jsp", "logid")
    * Returns 68768
    * Page names must be in the format variablevardata-variablevardata.jsp
    * Extension after . is ignored.
    * Page names can not include periods.  Period.
    *
    */
    public String getVar(String uri, String vartoget) {
    
        //Split on the - symbol
        String vrs[]=getJspBase(uri).split("-");
        String hldvar="";
        for(int i = 0; i <= vrs.length-1; i++) {
            if ( vartoget.equals(vrs[i].substring(0,vartoget.length())) ){
                hldvar = vrs[i].substring(vartoget.length());
            } 
		} 
        
        //Return the correct value, "" if not found
        return hldvar;
    }
    
    
    
    private String getJspBase(String uri){
        //Base jsp name no extension
        String tmpjsp[]=getJspName(uri).split("\\.");
        String basejsp=tmpjsp[0];
        return basejsp;
    }
    
    /* 
	 * Formats time intervals from #of seconds to hh:mm:ss format.
	 */
     private String getJspName(String uri){
        //jsp name including extension
        String tmp[]=uri.split("/");
        String jsp=tmp[tmp.length-1];
        return jsp;
    }
    
    
}
