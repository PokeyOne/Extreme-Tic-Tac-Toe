package ca.pokeyone.tictactoe.states;

import ca.pokeyone.tictactoe.resources.ResourceHandler;

import java.awt.*;

/**
 * A state of the program. Used to process user input and display out put.
 */
public abstract class State {
    private String displayName;

    //The state manage will the change to the state with this ID. If value is -1L no change will take affect
    protected long changeID = -1L;

    /**
     * Initialize the state with default information.
     * @param displayName the name of the state the user could see and read.
     */
    public State(String displayName){
        this.displayName = displayName;
        System.out.println("[State] Entered the " + getDisplayName());
    }

    public String getDisplayName(){
        return ResourceHandler.localizer.localize(displayName);
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
     * Runs when the state comes into view to the user
     */
    public void onLoad(){

    }

    /**
     * Runs when the state goes out of view from the user
     */
    public void onUnload(){

    }

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

    /**
     * Flag the state manager to change the state.
     * @param uid The unique id of the state to change to.
     */
    protected void changeState(long uid){
        changeID = uid;
    }
}
