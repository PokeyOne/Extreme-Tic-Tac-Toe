package ca.pokeyone.tictactoe;

import ca.pokeyone.tictactoe.states.*;

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

    /**
     * Construct a Panel
     */
    public Panel(){
        //initialize the stateManager
        stateManager = new StateManager();
        stateManager.addState(new StateExit(), Constants.STATE_UID_EXIT);
        stateManager.addState(new StateExit(true), Constants.STATE_UID_EXIT_ERROR);
        stateManager.addState(new StateLoading(), Constants.STATE_UID_LOADING);
        stateManager.addState(new StateMenu("Main Menu",
                new StateMenu.MenuOption("Play", Constants.STATE_UID_MENU_PLAY),
                new StateMenu.MenuOption("Exit", Constants.STATE_UID_EXIT)
        ), Constants.STATE_UID_MENU);

        //TODO: add play menu
        //TODO: add play state

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
        //Redirect to current state
        stateManager.tick();
    }

    @Override
    public void paint(Graphics g){
        //clear backdrop
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        //redirect to current state
        stateManager.render(g);
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

    //TODO: mouse input redirect to state manager

    @Override
    public void keyTyped(KeyEvent e) {
        stateManager.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        stateManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        stateManager.keyReleased(e);
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
