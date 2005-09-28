package reger.systemproperties;

import reger.core.SystemProperty;

/**
 * This class uses the SystemProperty object to hold the system properties
 */
public class AllSystemProperties {

    private static SystemProperty[] properties;

    public static void loadProperties(){
        properties = new SystemProperty[11];
        properties[0] = new PathUploadMedia();
        properties[1] = new EmailServer();
        properties[2] = new EmailListenerIsOn();
        properties[3] = new EmailListenerIp();
        properties[4] = new EmailListenerHostName();
        properties[5] = new SpellingDictionaryFile();
        properties[6] = new SpellingPhoneticFile();
        properties[7] = new SslIsOn();
        properties[8] = new DemosDirectoryUrl();
        properties[9] = new LicensingServerUrl();
        properties[10] = new IsLinkrotFixerOn();
    }

    public static SystemProperty[] getAllSystemProperties(){
        if (properties==null){
            loadProperties();
        }
        return properties;
    }

    public static String getProp(String propertyName){
        if (properties!=null && propertyName!=null){
            for (int i = 0; i < properties.length; i++) {
                if (properties[i].getPropertyName()!=null && properties[i].getPropertyName().equals(propertyName)){
                    return properties[i].getPropertyValue();
                }
            }
        }
        return "";
    }

    public static SystemProperty getProperty(String propertyName){
        if (properties!=null && propertyName!=null){
            for (int i = 0; i < properties.length; i++) {
                if (properties[i].getPropertyName()!=null && properties[i].getPropertyName().equals(propertyName)){
                    return properties[i];
                }
            }
        }
        return null;
    }




}
