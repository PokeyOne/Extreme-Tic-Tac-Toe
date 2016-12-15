package ca.pokeyone.tictactoe.puzzle.ai;

/**
 * Created by Mateo on 12/14/2016.
 */
public enum AIDifficulty {
    EASY(50),
    MEDIUM(20),
    HARD(5);

    /**
     * Percentage chance that AI doesn't make the best move
     */
    private final int MESS_UP_CHANCE;

    /**
     * Initializes AIDifficult with specified messUpChance
     * @param messUpChance The chance in percentage that AI will make the wrong move
     */
    AIDifficulty(int messUpChance){
        MESS_UP_CHANCE = messUpChance;
    }

    /**
     * Return the chance, in integer percentage, of the AI making the wrong move
     * @return integer of chance of AI making wrong move
     */
    public int getMessUpChance(){
        return MESS_UP_CHANCE;
    }
}
