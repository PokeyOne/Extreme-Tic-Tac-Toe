package ca.pokeyone.tictactoe.states;

import ca.pokeyone.tictactoe.Constants;

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
        //clear the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        //Render all options
        for(int i = 0; i < options.length; i++){
            //TODO add render of option
        }
    }

    @Override
    public void tick() {

    }
}
