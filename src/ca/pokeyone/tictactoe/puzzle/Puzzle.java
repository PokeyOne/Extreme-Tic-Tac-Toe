package ca.pokeyone.tictactoe.puzzle;

/**
 * Base class for puzzles
 */
public abstract class Puzzle {

    /**
     * Holds the values for the board. Should not be set directly other than <b>play()</b> function
     */
    protected XOValue[][] values;

    /**
     * Weather or not the puzzle is complete
     */
    public Winner isComplete = Winner.UNCOMPLETE;

    /**
     * Change the box at a location to a value.
     * @param x The x coordinate (column) of the box to change
     * @param y The y coordinate (row) of the box to change
     * @param v The value to set of the the box
     * @return True if board is complete
     */
    public abstract boolean play(int x, int y, XOValue v);

    //TODO: migrate as much over as possible
}
