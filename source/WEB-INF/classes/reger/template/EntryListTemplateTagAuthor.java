package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class EntryListTemplateTagAuthor implements EntryListTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Author";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "The name of the author who wrote the entry and a link to their profile.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(String templateentry, Calendar entrydate, String logentrytitle, String logentryurl, String logentrybody, String logname, int imagescount, int messagescount, int accountuserid) {
        return AuthorStringFromAccountuserid(accountuserid);
    }

    private static String AuthorStringFromAccountuserid(int accountuserid){
        String authorlink = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstAuth= Db.RunSQL("SELECT friendlyname FROM accountuser WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAuth!=null && rstAuth.length>0){
        	for(int i=0; i<rstAuth.length; i++){
                authorlink = "<a href='author.log?accountuserid="+accountuserid+"'>"+rstAuth[0][0]+"</a>";
        	}
        }
        return authorlink;
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "John Doe";
    }

}
