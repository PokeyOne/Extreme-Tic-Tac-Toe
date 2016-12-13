package ca.pokeyone.tictactoe.states;

import java.awt.*;

/**
 * Performs clean-up and exits program when loaded
 */
public class StateExit extends State {

    boolean isError = false;

    /**
     * Exits program normally
     */
    public StateExit(){
        super("Exit State");
    }

    /**
     * Exits the program for an error if specifed
     * @param isError Whether or not to exit as if error has occurred
     */
    public StateExit(boolean isError){
        super("Exit State");

        this.isError = isError;
    }

    @Override
    public void onLoad() {
        //Perform any necessary clean-up
        //Exit program
        if(isError){
            System.exit(1);
        }else {
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void tick() {

    }
}
