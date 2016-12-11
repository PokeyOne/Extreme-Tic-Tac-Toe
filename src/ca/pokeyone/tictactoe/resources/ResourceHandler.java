package ca.pokeyone.tictactoe.resources;

import ca.pokeyone.tictactoe.Constants;

import java.io.File;
import java.util.HashMap;

/**
 * Handles the deep and dangerous sea of loading and unloading files. Should not be initialized, as the class is
 * completely static.
 */
public class ResourceHandler {

    public static HashMap<String, ImageResource> images = new HashMap<>();
    static {
        images.put(Constants.IMAGE_LOGO, new ImageResource(new File("resources/logo.png")));
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
}
