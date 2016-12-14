package ca.pokeyone.tictactoe.resources;

import ca.pokeyone.tictactoe.Constants;
import ca.pokeyone.tictactoe.localization.Localizer;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

/**
 * Handles the deep and dangerous sea of loading and unloading files. Should not be initialized, as the class is
 * completely static.
 */
public class ResourceHandler {

    /**
     * Used to localize strings
     */
    public static Localizer localizer = new Localizer(new File("resources/lang"));

    /**
     * A map of all images to there corresponding UID
     */
    public static HashMap<String, ImageResource> images = new HashMap<>();
    static {
        images.put(Constants.IMAGE_LOGO, new ImageResource(new File("resources/logo.png")));
        images.put(Constants.IMAGE_TITLE, new ImageResource(new File("resources/title.png")));
    }

    /**
     * All paths to files based on UID
     */
    public static HashMap<Long, File> sounds = new HashMap<>();
    static {
        long[] ids = {
                Constants.SOUND_PLAY,
                Constants.SOUND_INIT,
                Constants.SOUND_EXIT,
                Constants.SOUND_BUP,
                Constants.SOUND_GAME_27,
                Constants.SOUND_GAME_9,
                Constants.SOUND_GAME_3
        };

        String[] paths = {
                "play",
                "init",
                "exit",
                "bup",
                "27x27Game",
                "9x9Game",
                "3x3Game"
        };

        for(int i = 0; i < ids.length; i++){
            sounds.put(ids[i], new File("resources/audio/" + paths[i] + ".wav"));
        }
    }

    /**
     * Load an image into memory for faster access later.
     * @param id The ID of the image
     */
    public static void loadImage(String id){
        if(images.containsKey(id)){
            images.get(id).load();
        }
    }

    /**
     * Gets the image with the given id
     * @param id The id of the image to return
     * @return A BufferedImage of the requested ID. May be null if file/image does not exist
     */
    public static BufferedImage getImage(String id){
        if(images.containsKey(id)){
            return images.get(id).getImage();
        }else{
            return null;
        }
    }

    /**
     * Gets a File representative of sound
     * @param uid The UID of the sound
     * @return File of sound
     */
    public static File getAudioFile(long uid){
        if(sounds.containsKey(uid)){
            return sounds.get(uid);
        }else{
            return null;
        }
    }

    /**
     * Returns an InputStream of the audio file
     * @param uid The uid of the audio file
     * @return InputStream of audio file
     */
    public static InputStream getAudioStream(long uid){
        try {
            FileInputStream fis = new FileInputStream(getAudioFile(uid));
            return new BufferedInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
