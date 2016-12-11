package ca.pokeyone.tictactoe.puzzle;

/**
 * A simple 3x3 tic tac toe puzzle
 */
public class Puzzle3 {

    /**
     * Holds the values for the board
     *
     * [x][y]
     * [column][row]
     */
    public XOValue[][] values = new XOValue[3][3];

    public Winner isComplete = Winner.UNCOMPLETE;

    public Puzzle3() {
        for(XOValue[] col : values){
            for(XOValue v : col){
                v = XOValue.NONE;
            }
        }
    }

    /**
     * Change the box at a location to a value
     * @param x The x coordinate (column) of the box to change
     * @param y The y coordinate (row) of the box to change
     * @param v The value to set of the the box
     */
    public void play(int x, int y, XOValue v){
        values[x][y] = v;
        checkBoard();
    }

    /**
     * Checks the board to see if it is finished
     * @return
     */
    public Winner checkBoard(){
        //TODO: add verification algorithm
        return Winner.UNCOMPLETE;
    }
}
