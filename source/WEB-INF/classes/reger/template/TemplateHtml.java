package reger.template;

/**
 * Used to display a template box in the configuration of templates screen
 */
public class TemplateHtml {


    public static StringBuffer getBox(Template activeTemplate, Template[] userTemplates, Template[] systemTemplates, String upperLeftTitle, String upperLeftSubtitle, int logid, int type, String thisPageName, String editPageName, boolean showEditButton, boolean showUseThisOneButton, boolean showCreateNewTemplateLink, boolean outputFormTags, String dropdownName, boolean showExportAsJavaButton){
        StringBuffer topLeft;
        StringBuffer topRight;
        StringBuffer mb = new StringBuffer();

        topLeft = new StringBuffer();

        TemplateProcessor tmpp = TemplateProcessorFactory.getProcessorByType(type);
        String icon = "";
        if (tmpp!=null){
            icon = tmpp.getNameOfIconShowingHowTemplateWorks();
        }
        if (!icon.equals("")){
            topLeft.append("<img src=/myhome/images/"+icon+" border=0 align=left>");    
        }

        topLeft.append("<font face=arial size=+1>");
        topLeft.append(upperLeftTitle);
        topLeft.append("</font>");
        topLeft.append("<br>");
        topLeft.append("<font face=arial size=-2>");
        topLeft.append(upperLeftSubtitle);
        topLeft.append("</font>");

        topRight = new StringBuffer();
        if (activeTemplate!=null){
            topRight.append("<font face=arial size=+1>");
            topRight.append("Active Template: ");
            topRight.append(activeTemplate.getName());
            topRight.append("</font>");
            topRight.append("<br>");
        }
        if (outputFormTags){
            topRight.append("<form action="+thisPageName+" method=post>");
            topRight.append("<input type=hidden name=action value='usethisone'>");
            topRight.append("<input type=hidden name=logid value='"+logid+"'>");
            topRight.append("<input type=hidden name=type value='"+type+"'>");
            topRight.append("<input type=hidden name=returnurl value='"+thisPageName+"'>");
        }
        topRight.append("<select name="+dropdownName+">");

        //System default
        topRight.append("<option value=0>Default Template</option>");

        //User templates
        if (userTemplates!=null && userTemplates.length>0){
            for (int i = 0; i < userTemplates.length; i++) {
                String selectedText = "";
                if (activeTemplate!=null && activeTemplate.getTemplateid()==userTemplates[i].getTemplateid()){
                    selectedText = " selected";
                }
                topRight.append("<option value="+userTemplates[i].getTemplateid()+" "+selectedText+">(Your Custom)"+userTemplates[i].getName()+"</option>");
            }
        }

        //System templates
        for (int i = 0; i < systemTemplates.length; i++) {
            String selectedText = "";
            if (activeTemplate!=null && activeTemplate.getTemplateid()==systemTemplates[i].getTemplateid()){
                selectedText = " selected";
            }
            topRight.append("<option value="+systemTemplates[i].getTemplateid()+" "+selectedText+">"+systemTemplates[i].getName()+"</option>");
        }


        topRight.append("</select>");
        topRight.append("<br>");
        topRight.append("<input type=submit value='Preview' onclick=\"javascript:NewWindow('../templatepreview.log?type="+type+"&templateid=' + this.form.elements['"+dropdownName+"'].value,'name','0','0','yes');return false;\">");
        if (showEditButton){
            topRight.append("<input type=submit value='Edit' onclick=\"this.form.elements['action'].value ='edit'\">");
            topRight.append("<input type=submit value='Delete' onclick=\"this.form.elements['action'].value ='delete'\">");
        }
        if (showUseThisOneButton){
            topRight.append("<input type=submit value='Use this One' onclick=\"this.form.elements['action'].value ='usethisone'\">");
        }
        if (showExportAsJavaButton){
            topRight.append("<input type=submit value='Export As Java' onclick=\"this.form.elements['action'].value ='export'\">");
        }
        if (showCreateNewTemplateLink){
            topRight.append("<br>");
            topRight.append("<font face=arial size=-2>");
            topRight.append("<a href='"+editPageName+"?type="+type+"&logid="+logid+"&action=new&returnurl="+thisPageName+"'>");
            topRight.append("Create a New Template");
            topRight.append("</a>");
            topRight.append("</font>");
        }
        if (outputFormTags){
            topRight.append("</form>");
        }




//        bottom = new StringBuffer();
//        bottom.append("<font face=arial size=-1>");
//        bottom.append("You have created " + userTemplates.length + " templates of this type to choose from.");
//        bottom.append("<br>");
//        bottom.append("There are " + systemTemplates.length + " pre-built system templates of this type to choose from.");
//        bottom.append("</font>");
        mb.append(reger.ui.TwoPaneBox.getHtml(topLeft.toString(), topRight.toString()));

        return mb;
    }


}
