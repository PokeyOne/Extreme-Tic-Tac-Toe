package ca.pokeyone.tictactoe.localization;

import java.io.*;
import java.util.HashMap;

/**
 * Stores information about a language
 */
public class Locale {

    public final String code;
    private final File folder;
    private HashMap<String, String> names = new HashMap<>();

    /**
     * Initialize a new locale with code
     * @param code The language code to translate to
     * @param langFolder The folder containing all the language files
     */
    public Locale(String code, File langFolder){
        this.code = code;
        folder = langFolder;
        load();
    }

    /**
     * Initializes a new locale from file
     * @param langFile Language file to decode
     */
    public Locale(File langFile){
        code = langFile.getName().split("\\.")[0];
        folder = langFile.getParentFile();
        load();
    }

    /**
     * Converts a program string into a human readable string
     * @param id The id to translate
     * @return
     */
    public String localize(String id){
        if(names.containsKey(id)){
            return names.get(id);
        }else{
            return id;
        }
    }

    private void load(){
        File file = new File(folder.getPath() + "/" + code + ".lang");
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            while(bufferedReader.ready()){

                String line = bufferedReader.readLine();
                String[] args = line.split("=");
                if(args.length == 2){
                    names.put(args[0], args[1]);
                }else if(!(args.length <= 1 || line.startsWith("//"))){
                    System.err.println("Language file malformatted\nLine = " + line);
                    return;
                }
            }

            bufferedReader.close();
        }catch(FileNotFoundException e){
            System.err.print("Language file for " + code + " doesn't exist");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
