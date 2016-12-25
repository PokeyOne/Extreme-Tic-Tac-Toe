package ca.pokeyone.tictactoe.puzzle.ai;

import java.awt.*;
import java.util.Random;

/**
 * Artificial Intelligence player for a 3x3 board
 */
public class AI3 {

    public AIDifficulty aiDifficulty;

    public AI3(AIDifficulty difficulty){
        aiDifficulty = difficulty;
    }

    public Point getMove(){
        //Initialize a random
        Random random = new Random();
        //Calculated mess-up
        if(random.nextInt(100) < aiDifficulty.getMessUpChance()){
            //Random move
            return new Point(random.nextInt(3), random.nextInt(3));
        }else{
            //Real move
        }
    }
}
