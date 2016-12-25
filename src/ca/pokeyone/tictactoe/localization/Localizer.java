package ca.pokeyone.tictactoe.localization;

import ca.pokeyone.tictactoe.Constants;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

/**
 * Used to localize text into native language
 */
public class Localizer {

    private File folder;
    private String currentLanguage = Constants.LANGUAGE_ENGLISH;
    private HashMap<String, Locale> langs = new HashMap<>();

    /**
     * Creates a new localize for language folder specified
     * @param langFolder Folder containing all language files
     */
    public Localizer(File langFolder){
        folder = langFolder;
        loadLanguages();
    }

    public void setCurrentLanguage(String languageID){
        if(langs.containsKey(languageID)){
            currentLanguage = languageID;
        }
    }

    /**
     * Load all the languages in the language folder into memory
     */
    private void loadLanguages(){
        File[] langFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".lang")){
                    return true;
                }

                return false;
            }
        });

        System.out.print("Loaded languages");
        for(File file : langFiles){
            Locale locale = new Locale(file);
            langs.put(locale.code, locale);
            System.out.print(", " + locale.code);
        }
        System.out.print(".\n");
    }

    /**
     * Convert an id into a human readable String
     * @param id The id of element
     * @return Human readable string in language specified
     */
    public String localize(String id){
        return langs.get(currentLanguage).localize(id);
    }
}
