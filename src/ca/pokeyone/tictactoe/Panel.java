package ca.pokeyone.tictactoe;

import ca.pokeyone.tictactoe.states.State;
import ca.pokeyone.tictactoe.states.StateLoading;
import ca.pokeyone.tictactoe.states.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * The main controller of the game
 */
public class Panel extends JPanel implements Runnable, KeyListener, MouseListener{

    //Runnable thread
    private Thread thread = new Thread(this);

    //State manager
    private StateManager stateManager;

    //TODO: add resource handler

    /**
     * Construct a Panel
     */
    public Panel(){
        //initialize the stateManager
        stateManager = new StateManager();
        stateManager.addState(new StateLoading(), Constants.STATE_UID_LOADING);

        //make sure the panel gets the input
        setFocusable(true);

        //add self as key listener and mouse listener
        addKeyListener(this);
        addMouseListener(this);

        //get the loop started
        thread.start();
    }

    /**
     * Main computation that run every tick
     */
    public void tick(){

    }

    @Override
    public void paint(Graphics g){
        //clear backdrop
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        //TODO: redirect to current state
    }

    public void run(){
        //main loop
        while(true){
            //compute things
            tick();
            //render things
            repaint();
            //Pause
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //TODO: input redirect to state manager

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
