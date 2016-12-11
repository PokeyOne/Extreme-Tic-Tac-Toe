package ca.pokeyone.tictactoe.states;

import java.awt.*;
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
        if(states.isEmpty()){
            currentState = uid;
        }

        //Make sure we do not over write another state
        if(!states.containsKey(uid)){
            //Add the state
            states.put(uid, state);
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
        }
    }
}
