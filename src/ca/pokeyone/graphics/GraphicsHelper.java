package ca.pokeyone.graphics;

import java.awt.*;

/**
 * Provides static methods for helping with graphics
 */
public class GraphicsHelper {

    /**
     * Draws a rectangle with a set thickness
     * @param g The Graphics object to render to
     * @param x The x coordinate of the rectangle
     * @param y The y coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param thickness The thickness of all the lines
     */
    public static void thickBox(Graphics g, int x, int y, int width, int height, int thickness){
        for(int i = 0; i < thickness; i++){
            g.drawRect(x + i, y + i, width - 2 * i, height - 2 * i);
        }
    }
}
