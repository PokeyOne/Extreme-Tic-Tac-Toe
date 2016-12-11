package ca.pokeyone.tictactoe.states;

import ca.pokeyone.tictactoe.Constants;

import java.awt.*;

/**
 * Simply displays logo and loads all needed assets into memory
 */
public class StateLoading extends State{

    public StateLoading(){
        super("Loading State");
        //TODO: add all needed assets to resource handler
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        //TODO: render image from resource handler, once loaded
    }

    @Override
    public void tick() {

    }
}
