package ca.pokeyone.tictactoe.states;

import ca.pokeyone.graphics.GraphicsHelper;
import ca.pokeyone.tictactoe.*;
import ca.pokeyone.tictactoe.puzzle.*;

import java.awt.*;

/**
 * The main state of the game
 */
public class StatePlay extends State{

    //Puzzle holders
    private final Puzzle puzzle;

    //Size
    private final PuzzleSize puzzleSize;
    private final OpponentType opponentType;

    public StatePlay(PuzzleSize size, OpponentType type){
        super("state.play.name");

        puzzleSize = size;
        opponentType = type;

        switch(size){
            default:
            case THREE:
                puzzle = new Puzzle3();
                break;
            case NINE:
                puzzle = new Puzzle9();
                break;
            case TWENTY_SEVEN:
                puzzle = new Puzzle9(); //TODO: change to puzzle 27
                break;
        }
    }

    @Override
    public void render(Graphics g) {
        //Clear backdrop
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        //Board
        switch (puzzleSize){
            default:
            case THREE:
                //Draw Board
                drawBox3(Constants.WIDTH/2-(Constants.HEIGHT-50)/2, 10, Constants.HEIGHT-50, ((Puzzle3)puzzle).getValues(), g);
                break;
        }
    }

    @Override
    public void tick() {

    }

    /**
     * Draws a three by three grid for Tic Tac Toe
     * @param x x coordinate of box to draw.
     * @param y y coordinate of box to draw.
     * @param size The width and height of the box
     * @param values The array of XOValues for the board
     * @param g The Graphics object to render to
     */
    private void drawBox3(int x, int y, int size, XOValue[][] values, Graphics g){
        //TODO: make work for all sizes

        if(values == null) {
            System.err.println("Null values for box render");
            return;
        }

        //Colour
        g.setColor(Color.BLACK);

        //Main box
        GraphicsHelper.thickBox(g, x, y, size, size, 5);

        //Vertical & Horizontal lines
        g.drawLine(x + size/3, y, x + size/3, y + size);
        g.drawLine(x + size*2/3, y, x + size*2/3, y + size);
        g.drawLine(x, y + size/3, x + size, y + size/3);
        g.drawLine(x, y + size*2/3, x + size, y + size*2/3);

        //Values
        for(int ix = 0; ix < values.length; ix++){
            for(int iy = 0; iy < values[0].length; iy++){
                if(values[ix][iy] != null && values[ix][iy] != XOValue.NONE){
                    int xoffset = 0;

                    g.setFont(new Font("Arial", Font.BOLD, (int)(size*0.4)));
                    if(values[ix][iy] == XOValue.O){
                        xoffset = -10;
                    }
                    g.drawString(values[ix][iy].getString(), x + (size/3) * ix + size/30 + xoffset, y + (size/3) * (iy + 1) - size/35);
                }
            }
        }
    }
}
