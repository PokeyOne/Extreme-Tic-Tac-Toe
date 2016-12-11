package ca.pokeyone.tictactoe.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A simple object the holds the location and value of an image resource
 */
public class ImageResource {

    private BufferedImage image;
    public File file;

    /**
     * Initialize a new image resource with path
     * @param file file to load
     */
    public ImageResource(File file){
        this.file = file;
    }

    /**
     * loads the value of image into memory
     */
    public void load(){
        try {
            ImageIO.read(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Gets the image stored in the resource. Will load the image if not already loaded.
     * @return The image in stored. May return null if file doesn't exist.
     */
    public BufferedImage getImage(){
        if(image == null){
            load();
        }

        return image;
    }
}
