package ca.pokeyone.tictactoe.puzzle.ai;

import ca.pokeyone.tictactoe.puzzle.Puzzle;
import ca.pokeyone.tictactoe.puzzle.Move;

/**
 * Created by pokeyone on 2016-12-16.
 */
public abstract class AI {

    public AIDifficulty aiDifficulty;

    public AI(AIDifficulty difficulty){
        aiDifficulty = difficulty;
    }

    public abstract Move getMove(Puzzle puzzle);
}
