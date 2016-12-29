package ca.pokeyone.utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by pokeyone on 2016-12-28.
 */
public class RectUtilTest {

    public static final int TEST_REPEATS_INSIDE = 300;
    public static final int TEST_REPEATS_OUTSIDE = 300;

    @BeforeAll
    public static void begin() {
        System.out.println("RectUtil test started");
    }

    /**
     * Validates isInside method of RectUtil
     */
    @Test
    public void isInside() {
        System.out.println("RectUtil.isInside test started");

        //Random for getting integers
        Random random = new Random();

        //Bounds of rectangle
        int x = random.nextInt(50);
        int y = random.nextInt(50);
        int width = random.nextInt(1000);
        int height = random.nextInt(1000);

        //Rectangle to use for tests
        Rectangle rectangle = new Rectangle(x, y, width, height);

        //turns to false if unexpected result occurs
        boolean weGood = true;

        //test points inside
        for(int i = 0; i < TEST_REPEATS_INSIDE && weGood; i++) {
            //The point to use
            Point point = new Point(random.nextInt(width) + x, random.nextInt(height) + y);
            weGood = RectUtil.isInside(point, rectangle);
            if(weGood == false) System.out.println("Apparently (" + point.x + ", " + point.y + ") is not inside (" + x +
                    ", " + y + ", " + width + ", " + height + ")");
        }

        //test point outside
        for(int i = 0; i < TEST_REPEATS_OUTSIDE && weGood; i++){
            //The point to use
            int px, py;

            //x before or after box
            if(random.nextBoolean()) {
                px = random.nextInt(y);
            }else{
                px = random.nextInt(1000) + x + width;
            }

            //y before of after box
            if(random.nextBoolean()) {
                py = random.nextInt(y);
            }else{
                py = random.nextInt(1000) + y + height;
            }
        }

        assertTrue(weGood == true);
    }

}