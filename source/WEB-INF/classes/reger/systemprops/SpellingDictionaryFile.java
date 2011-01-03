package reger.systemprops;

import reger.core.SystemProperty;
import reger.core.WebAppRootDir;

public class SpellingDictionaryFile extends SystemProperty{

    public SpellingDictionaryFile(){
        setPropertyName("SPELLINGDICTIONARYFILE");
        setPropertyDefault(WebAppRootDir.getWebAppRootPath() + "spelldict"+java.io.File.separator+"dict-large.txt");
        setPropertyDescription("You are able to choose a custom spelling check dictionary file.  The default value you see is for the built-in dictionary.");
        load();
    }

}
