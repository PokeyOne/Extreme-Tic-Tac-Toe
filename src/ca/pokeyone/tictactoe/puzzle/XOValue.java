package ca.pokeyone.tictactoe.puzzle;

/**
 * The possible values of a box of the game board
 */
public enum XOValue {
    X("X"), O("O"), NONE("NONE");

    private String string;
    private XOValue(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}
