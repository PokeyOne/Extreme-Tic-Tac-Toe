package ca.pokeyone.utility;

import ca.pokeyone.tictactoe.states.StateMenu;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Created by Mateo on 12/25/2016.
 */
public class RectUtil {

    /**
     * Returns true if the Point given is inside the Rectangle
     * @param point Point object to test if it's inside
     * @param rectangle Rectangle object to test if the Point is inside
     * @return True if the Point given is inside the Rectangle
     */
    public static boolean isInside(Point point, Rectangle rectangle){
        //FIXME: Something wrong between this and menu state mouseReleased function
        System.out.println("Point is " + point.x + " " + point.y);
        System.out.println("Rectangle is at " + rectangle.x + " " + rectangle.y + " and size of " + rectangle.width + " " + rectangle.height);

        if(point.x > rectangle.x && point.y > rectangle.y){
            if(point.x < rectangle.x + StateMenu.BUTTON_WIDTH && point.x < rectangle.x + StateMenu.BUTTON_HEIGHT){
                return true;
            }
        }

        return false;
    }
}
