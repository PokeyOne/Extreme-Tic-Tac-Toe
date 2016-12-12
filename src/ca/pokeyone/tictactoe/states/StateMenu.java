package ca.pokeyone.tictactoe.states;

import ca.pokeyone.tictactoe.Constants;
import ca.pokeyone.tictactoe.resources.ResourceHandler;

import java.awt.*;

/**
 * Displays a menu of options to the user
 */
public class StateMenu extends State{

    /**
     * An option for the menu
     */
    public static class MenuOption {

        /**
         * The name of the option that the user sees
         */
        public String name;

        /**
         * The UID of the state that appears on the activation of the option
         */
        public long stateUID;

        /**
         * Creates a menu option
         * @param name The name of the option that the user sees
         * @param stateUID The UID of the state that appears on the activation of the option
         */
        public MenuOption(String name, long stateUID){
            this.name = name;
            this.stateUID = stateUID;
        }
    }

    /**
     * The options that get displayed
     */
    private MenuOption[] options;

    public static final int BUTTON_WIDTH = 500, //Width of displayed options
                            BUTTON_HEIGHT = 100, //Height of displayed options
                            BUTTON_VSPACE = 10; //Vertical space between each option

    /**
     * Initialize a new menu with name and options given
     * @param displayName The name that the user could see and read
     * @param options The options that the user can choose.
     */
    public StateMenu(String displayName, MenuOption... options){
        super("Menu State: " + displayName);

        this.options = options;
    }

    @Override
    public void render(Graphics g) {
        //Set render hints
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Turn on antialiasing

        //clear the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        //Button rendering start
        Point renderStart = new Point(Constants.WIDTH/2 - BUTTON_WIDTH/2,
                Constants.HEIGHT/2 - (options.length * (BUTTON_HEIGHT + BUTTON_VSPACE))/2);
        //Font to render menu items
        g.setFont(new Font("Arial", Font.BOLD, BUTTON_HEIGHT - 20));

        //title
        g.drawImage(ResourceHandler.getImage(Constants.IMAGE_TITLE), renderStart.x, 20, null);

        //Render all options
        for(int i = 0; i < options.length; i++){
            int y = renderStart.y + (i * (BUTTON_HEIGHT + BUTTON_VSPACE));

            //TODO: render indicator for current option
            g.setColor(Color.BLACK);
            g.fillRect(renderStart.x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString(options[i].name.toUpperCase(), renderStart.x + 20, y + BUTTON_HEIGHT - 20);
        }
    }

    @Override
    public void tick() {

    }

    //TODO: Arrow and WASD keys to change option
    //TODO: Enter to perform action
}
