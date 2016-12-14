package ca.pokeyone.tictactoe;

import ca.pokeyone.tictactoe.puzzle.OpponentType;
import ca.pokeyone.tictactoe.puzzle.PuzzleSize;
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

        //Add loading state
        stateManager.addState(new StateLoading(), Constants.STATE_UID_LOADING);

        //Add regular exit state
        stateManager.addState(new StateExit(), Constants.STATE_UID_EXIT);

        //Add irregular exit state
        stateManager.addState(new StateExit(true), Constants.STATE_UID_EXIT_ERROR);

        //Add the main menu
        stateManager.addState(new StateMenu("state.menu.main.name",
                new StateMenu.MenuOption("gui.play.name", Constants.STATE_UID_MENU_MODE, Constants.SOUND_PLAY),
                new StateMenu.MenuOption("gui.exit.name", Constants.STATE_UID_EXIT, Constants.SOUND_EXIT)
        ), Constants.STATE_UID_MENU);

        //Add menu for game board state
        stateManager.addState(new StateMenu("state.menu.mode.name",
                new StateMenu.MenuOption("gui.3x3.name", Constants.STATE_UID_3X3_MENU, Constants.SOUND_GAME_3),
                new StateMenu.MenuOption("gui.9x9.name", Constants.STATE_UID_9X9_MENU, Constants.SOUND_GAME_9)
        ), Constants.STATE_UID_MENU_MODE);

        //Add opponent menu for 3x3
        stateManager.addState(new StateMenu("state.menu.opponent.3x3.name",
                new StateMenu.MenuOption("gui.ai.name", Constants.STATE_UID_PLAY_AI_3X3)
        ), Constants.STATE_UID_3X3_MENU);

        //Add opponent menu for 9x9
        stateManager.addState(new StateMenu("state.menu.opponent.9x9.name",
                new StateMenu.MenuOption("gui.ai.name", Constants.STATE_UID_PLAY_AI_9X9)
        ), Constants.STATE_UID_9X9_MENU);

        //Add 3x3 AI Play State
        stateManager.addState(new StatePlay(PuzzleSize.THREE, OpponentType.AI), Constants.STATE_UID_PLAY_AI_3X3);

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
        //Set render hints
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Turn on antialiasing

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
