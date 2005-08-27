package reger.systemproperties;

import reger.core.SystemProperty;
import reger.core.WebAppRootDir;

public class SpellingPhoneticFile extends SystemProperty{

    public SpellingPhoneticFile(){
        setPropertyName("SPELLINGPHONETICFILE");
        setPropertyDefault(WebAppRootDir.getWebAppRootPath() + "spelldict\\phonet.en");
        setPropertyDescription("You are able to choose a custom spelling check phonetic file.  The default value you see is for the built-in file.");
        load();
    }

}
