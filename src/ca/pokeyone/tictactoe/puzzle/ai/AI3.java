package ca.pokeyone.tictactoe.puzzle.ai;

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

    public Point getMove(Puzzle puzzle){
        if(puzzle.getClass() == Puzzle3.class){
            return getMove((Puzzle3)puzzle);
        }else{
            return null;
        }
    }

    public Point getMove(Puzzle3 puzzle){
        //Initialize a random
        Random random = new Random();
        //Calculated mess-up
        if(random.nextInt(100) < aiDifficulty.getMessUpChance()){
            //Random move
            Point point = new Point(random.nextInt(3), random.nextInt(3));

            //check point isn't already set

            return point;
        }else{ //Real move
            //check rows for almost full
            for (int row = 0; row < 3; row++) {
                int count = 0;
                Point lastEmpty = new Point(-1, -1);

                for (int i = 0; i < 3; i++) {
                    switch (puzzle.getValues()[row][i]){
                        case X:
                            count++;
                            break;
                        case O:
                            count--;
                            break;
                        case NONE:
                            lastEmpty = new Point(row, i);
                            break;
                    }
                }

                if(count == 2 && lastEmpty.x != -1 && lastEmpty.y != -1){
                    return lastEmpty;
                }
            }
        }



        return null;
    }
}
