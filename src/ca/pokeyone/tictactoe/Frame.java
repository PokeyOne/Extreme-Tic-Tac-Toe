package ca.pokeyone.tictactoe;

import javax.swing.JFrame;

/**
 * A simple container for displaying the game
 */
public class Frame extends JFrame{

    //The main game to display later
    private Panel panel = new Panel();

    /**
     * Construct the frame and display Panel
     */
    public Frame(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Extreme Tic Tac Toe: " + Constants.VERSION + " (Build " + String.format("%H", Constants.BUILD) + ")");
        setLocationRelativeTo(null);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args){
        new Frame();
    }
}
