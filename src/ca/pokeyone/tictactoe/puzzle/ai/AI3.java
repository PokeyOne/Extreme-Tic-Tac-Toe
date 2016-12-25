package ca.pokeyone.tictactoe.puzzle.ai;

import ca.pokeyone.tictactoe.puzzle.Move;
import ca.pokeyone.tictactoe.puzzle.Puzzle;
import ca.pokeyone.tictactoe.puzzle.Puzzle3;
import ca.pokeyone.tictactoe.puzzle.XOValue;

import java.awt.*;
import java.util.Random;

/*
   The AI goes through each row, column, or diagonal, and fills the empty spot in lines of 2. Then follows strategic
   pattern of two opposite corners and one other corner.
 */
/**
 * Artificial Intelligence player for a 3x3 board
 */
public class AI3 extends AI{

    public AI3(AIDifficulty difficulty){
        super(difficulty);
    }

    public Move getMove(Puzzle puzzle){
        if(puzzle.getClass() == Puzzle3.class){
            return getMove((Puzzle3)puzzle);
        }else{
            return null;
        }
    }

    public Move getMove(Puzzle3 puzzle){
        //Initialize a random
        Random random = new Random();
        //Calculated mess-up
        if(random.nextInt(100) < aiDifficulty.getMessUpChance()){
            return randomMove(puzzle);
        }else{ //Real move
            //check rows for almost full
            for (int row = 0; row < 3; row++) {
                int count = 0;
                Move lastEmpty = new Move(-1, -1);

                for (int i = 0; i < 3; i++) {
                    switch (puzzle.getValues()[row][i]){
                        case X:
                            count++;
                            break;
                        case O:
                            count--;
                            break;
                        case NONE:
                            lastEmpty = new Move(row, i);
                            break;
                    }
                }

                if(count == 2 && lastEmpty.x != -1 && lastEmpty.y != -1){
                    return lastEmpty;
                }
            }
        }


        //If all else fails
        return randomMove(puzzle);
    }

    private Move randomMove(Puzzle3 puzzle){
        Random random = new Random();

        //The move to be returned later
        Move move;

        //Random unique move
        do {
            move = new Move(random.nextInt(3), random.nextInt(3));
        }while(puzzle.getValues()[move.x][move.y] != XOValue.NONE);

        //Return the move generated
        return move;
    }
}
