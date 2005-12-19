package reger.template;

import reger.core.Debug;


/**
 * Factory used to get a template processor
 */
public class TemplateProcessorFactory {


    public static TemplateProcessor[] getAllProcessors(){
        TemplateProcessor[] tmp = new TemplateProcessor[6];
        tmp[0] = new SiteTemplateProcessor();
        tmp[1] = new EntryListTemplateProcessor();
        tmp[2] = new HpTemplateProcessor();
        tmp[3] = new MarketingHpTemplateProcessor();
        tmp[4] = new MarketingSiteTemplateProcessor();
        tmp[5] = new PlUserTemplateProcessor();
        return tmp;
    }

    public static TemplateProcessor getProcessorByType(int type){
        TemplateProcessor[] tmp = getAllProcessors();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].getType()==type){
                return tmp[i];
            }
        }
        Debug.debug(5, "", "No handler found: TemplateProcessorFactory.getProcessorByType - incoming type=" + type);
        return null;
    }




}
