package ca.pokeyone.tictactoe.states;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * A manager class of handling all states of a program. Handle the redirection of all system functions to the correct
 * state.
 */
public class StateManager {

    /**
     * A hash table containing all states that are managed by this manager. Key is a long representing a unique id, and
     * the value is the state. The unique id should be unique to the program, not the API.
     */
    private HashMap<Long, State> states;

    /**
     * Holds the ID of the current state
     */
    private long currentState = 0L;

    /**
     * Create a state manager with no states
     */
    public StateManager(){
        //initialize the hash map
        states = new HashMap<>();
    }

    /**
     * Add a state to be managed by the state manager
     * @param state the state to be managed.
     * @param uid the unique id to register the state under. The UID only needs to be unique to the state manager.
     */
    public void addState(State state, long uid){
        //Set the current state to the one added if no states exist
        boolean newStateManager = false;
        if(states.isEmpty()){
            newStateManager = true;
        }

        //Make sure we do not over write another state
        if(!states.containsKey(uid)){
            //Add the state
            states.put(uid, state);

            if(newStateManager){
                currentState = uid;
                states.get(currentState).onLoad();
            }
        }else{
            //Output the error
            System.err.println("Could not add state to state manager! Bad UID!");
        }
    }

    /**
     * Calls the render function of the correct state
     * @param g The Graphics object to render output to
     */
    public void render(Graphics g){
        //Check current state availability
        if(states.containsKey(currentState)){
            //Render current state
            states.get(currentState).render(g);
        }
    }

    /**
     * Calls the tick function in the current state
     */
    public void tick(){
        if(states.containsKey(currentState)){
            states.get(currentState).tick();

            long changeID = states.get(currentState).changeID;
            if(changeID >= 0L){
                states.get(currentState).onUnload();
                currentState = changeID;
                states.get(currentState).onLoad();
            }
        }
    }

    /**
     * A handler for when a key is pressed. Redirects input to the current state.
     * @param keyEvent key event to get key code from
     */
    public void keyPressed(KeyEvent keyEvent){
        states.get(currentState).keyPressed(keyEvent.getKeyCode());
    }

    /**
     * A handler for when a key is released. Redirects input to the current state.
     * @param keyEvent key event to get key code from
     */
    public void keyReleased(KeyEvent keyEvent){
        states.get(currentState).keyReleased(keyEvent.getKeyCode());
    }

    /**
     * A handler for when a key is typed. Redirects input to the current state.
     * @param keyEvent key event to get key code from
     */
    public void keyTyped(KeyEvent keyEvent){
        states.get(currentState).keyTyped(keyEvent.getKeyCode());
    }

    /**
     * A handler for when the mouse is clicked. Redirects input to the current state.
     * @param mouseEvent The MouseEvent of click
     */
    public void mouseClicked(MouseEvent mouseEvent) {
        states.get(currentState).mouseClicked(mouseEvent.getPoint());
    }

    /**
     * A handler for when the mouse is pressed. Redirects input to the current state.
     * @param mouseEvent The MouseEvent of press
     */
    public void mousePressed(MouseEvent mouseEvent) {
        states.get(currentState).mousePressed(mouseEvent.getPoint());
    }

    /**
     * A handler for when the mouse is released. Redirects input to the current state.
     * @param mouseEvent The MouseEvent of release
     */
    public void mouseReleased(MouseEvent mouseEvent) {
        states.get(currentState).mouseReleased(mouseEvent.getPoint());
    }

    /**
     * A handler for when the mouse enters screen above frame. Redirects input to the current state.
     * @param mouseEvent The MouseEvent of enter
     */
    public void mouseEntered(MouseEvent mouseEvent) {
        states.get(currentState).mouseEntered(mouseEvent.getPoint());
    }

    /**
     * A handler for when the mouse exits screen above frame. Redirects input to the current state.
     * @param mouseEvent The MouseEvent of exit
     */
    public void mouseExited(MouseEvent mouseEvent) {
        states.get(currentState).mouseExited(mouseEvent.getPoint());
    }
}
