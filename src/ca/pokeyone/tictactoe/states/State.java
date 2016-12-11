package ca.pokeyone.tictactoe.states;

import java.awt.*;

/**
 * A state of the program. Used to process user input and display out put.
 */
public abstract class State {
    public String displayName;

    /**
     * Initialize the state with default information.
     * @param displayName the name of the state the user could see and read.
     */
    public State(String displayName){
        this.displayName = displayName;
        System.out.println("[State] Entered the " + displayName);
    }

    /**
     * Renders all content to the graphics object.
     * @param g graphics object to render to
     */
    public abstract void render(Graphics g);

    /**
     * Runs all calculations <b>before</b> rendering. Speed determined by app core.
     */
    public abstract void tick();

    /**
     * A handler for when a key is pressed. Should be called by the state manager only.
     * @param keyCode key code of the KeyEvent
     */
    protected void keyPressed(int keyCode){

    }

    /**
     * A handler for when a key is released. Should be called by the state manager only.
     * @param keyCode key code of the KeyEvent
     */
    protected void keyReleased(int keyCode){

    }

    /**
     * A handler for when a key is typed. Should be called by the state manager only.
     * @param keyCode key code of the KeyEvent
     */
    protected void keyTyped(int keyCode){

    }
}
