package ca.pokeyone.tictactoe.puzzle;

import java.util.Arrays;

/**
 * A slightly larger game of 9x9 tic tac toe
 */
public class Puzzle9 extends Puzzle{

    public Puzzle9(){
        values = new XOValue[9][9];
        Arrays.fill(values, XOValue.NONE);
    }

    @Override
    public boolean play(int x, int y, XOValue v) {
        //TODO: write play method
        return false;
    }

    //TODO: write 9x9 puzzle class
}
