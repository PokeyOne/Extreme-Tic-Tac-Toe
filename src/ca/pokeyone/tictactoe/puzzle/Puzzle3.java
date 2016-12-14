package ca.pokeyone.tictactoe.puzzle;

import java.util.Arrays;

/**
 * A simple 3x3 tic tac toe puzzle
 */
public class Puzzle3 extends Puzzle{

    /**
     * Initialize a blank 3x3 puzzle
     */
    public Puzzle3() {
        //Initialize array
        values = new XOValue[3][3];
        Arrays.fill(values, XOValue.NONE);
    }

    /**
     * Change the box at a location to a value.
     * @param x The x coordinate (column) of the box to change
     * @param y The y coordinate (row) of the box to change
     * @param v The value to set of the the box
     * @return True if board is complete
     */
    public boolean play(int x, int y, XOValue v){
        if(values[x][y] == XOValue.NONE) values[x][y] = v;
        return (checkBoard(x, y) != Winner.UNCOMPLETE);
    }

    /**
     * Gets a copy of values
     * @return 3 by 3 array of XOValue objects
     */
    public XOValue[][] getValues(){
        return values.clone();
    }

    /**
     * Checks the board to see if it is finished based on one piece being changed.
     * @param x The x coordinate of the changed box
     * @param y The y coordinate of the changed box
     * @return the value of the check
     */
    public Winner checkBoard(int x, int y){
        //check column
        {
            //number of correct in col. 3 = X, -3 = O
            int count = 0;

            for(int row = 0; row < 3; row++){
                switch(values[x][row]){
                    case NONE:
                        break;
                    case X:
                        count++;
                        break;
                    case O:
                        count--;
                        break;
                }
            }

            if(count == 3){
                return Winner.X;
            }else if(count == -3){
                return Winner.O;
            }
        }

        //check row
        {
            //number of correct in col. 3 = X, -3 = O
            int count = 0;

            for(int col = 0; col < 3; col++){
                switch(values[col][y]){
                    case NONE:
                        break;
                    case X:
                        count++;
                        break;
                    case O:
                        count--;
                        break;
                }
            }

            if(count == 3){
                return Winner.X;
            }else if(count == -3){
                return Winner.O;
            }
        }

        //check board filled
        boolean filled = true;
        search: for(XOValue[] a : values){
            for(XOValue b : a){
                if(b == XOValue.NONE) {
                    filled = false;
                    break search;
                }
            }
        }
        if(filled) return Winner.NONE;

        return Winner.UNCOMPLETE;
    }
}
